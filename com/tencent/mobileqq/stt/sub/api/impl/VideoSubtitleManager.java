package com.tencent.mobileqq.stt.sub.api.impl;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.stt.ISttManagerService;
import com.tencent.mobileqq.stt.sub.api.IVideoSubtitleManager;
import com.tencent.mobileqq.stt.sub.api.impl.VideoSubtitleManager;
import com.tencent.mobileqq.stt.util.AudioExtractorUtil;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes18.dex */
public class VideoSubtitleManager implements IVideoSubtitleManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "VideoSubtitleManager";
    private AppRuntime appRuntime;
    private boolean disableLocalCache;
    private final Handler mainHandler;
    private final com.tencent.mobileqq.qdispatchqueue.i queue;
    private boolean skipQueryServerCache;
    private final ArrayList<d> tasks;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements com.tencent.mobileqq.stt.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f290766a;

        a(d dVar) {
            this.f290766a = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoSubtitleManager.this, (Object) dVar);
            }
        }

        @Override // com.tencent.mobileqq.stt.a
        public void a(MessageForPtt messageForPtt, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                VideoSubtitleManager.this.onTranslateSuccess(this.f290766a, messageForPtt.sttText, 3);
            } else {
                iPatchRedirector.redirect((short) 3, this, messageForPtt, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.stt.a
        public void b(MessageForPtt messageForPtt) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageForPtt);
                return;
            }
            QLog.i(VideoSubtitleManager.TAG, 1, "server cache missed, task=" + this.f290766a);
            VideoSubtitleManager.this.onServerCacheMissed(this.f290766a);
        }

        @Override // com.tencent.mobileqq.stt.a
        public void c(MessageForPtt messageForPtt) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageForPtt);
            } else {
                QLog.i(VideoSubtitleManager.TAG, 1, "onSttRepush, IGNORE");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        void a(int i3, MediaFormat mediaFormat, boolean z16, long j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements com.tencent.mobileqq.stt.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final d f290768a;

        c(d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoSubtitleManager.this, (Object) dVar);
            } else {
                this.f290768a = dVar;
            }
        }

        @Override // com.tencent.mobileqq.stt.a
        public void a(MessageForPtt messageForPtt, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, messageForPtt, Boolean.valueOf(z16));
                return;
            }
            QLog.i(VideoSubtitleManager.TAG, 1, "onSttCompete, first=" + z16 + ", task=" + this.f290768a);
            d(messageForPtt);
            VideoSubtitleManager.this.onTranslateSuccess(this.f290768a, messageForPtt.sttText, 1);
        }

        @Override // com.tencent.mobileqq.stt.a
        public void b(MessageForPtt messageForPtt) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageForPtt);
                return;
            }
            QLog.i(VideoSubtitleManager.TAG, 1, "onSttError, task=" + this.f290768a);
            d(messageForPtt);
            VideoSubtitleManager.this.onTranslateError(this.f290768a);
        }

        @Override // com.tencent.mobileqq.stt.a
        public void c(MessageForPtt messageForPtt) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageForPtt);
                return;
            }
            QLog.i(VideoSubtitleManager.TAG, 1, "onSttRepush, task=" + this.f290768a);
        }

        void d(MessageForPtt messageForPtt) {
            MessageForPtt messageForPtt2 = this.f290768a.f290777g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: l, reason: collision with root package name */
        private static final AtomicLong f290770l;

        /* renamed from: a, reason: collision with root package name */
        public final long f290771a;

        /* renamed from: b, reason: collision with root package name */
        public final MessageRecord f290772b;

        /* renamed from: c, reason: collision with root package name */
        public final String f290773c;

        /* renamed from: d, reason: collision with root package name */
        public final String f290774d;

        /* renamed from: e, reason: collision with root package name */
        public final int f290775e;

        /* renamed from: f, reason: collision with root package name */
        public String f290776f;

        /* renamed from: g, reason: collision with root package name */
        public final MessageForPtt f290777g;

        /* renamed from: h, reason: collision with root package name */
        TransferRequest f290778h;

        /* renamed from: i, reason: collision with root package name */
        public final ArrayList<com.tencent.mobileqq.stt.sub.api.a> f290779i;

        /* renamed from: j, reason: collision with root package name */
        public final b f290780j;

        /* renamed from: k, reason: collision with root package name */
        public final a f290781k;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public static class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            int f290782a;

            /* renamed from: b, reason: collision with root package name */
            int f290783b;

            /* renamed from: c, reason: collision with root package name */
            String f290784c;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                this.f290782a = 0;
                this.f290783b = 0;
                this.f290784c = "";
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public static class b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            long f290785a;

            /* renamed from: b, reason: collision with root package name */
            long f290786b;

            /* renamed from: c, reason: collision with root package name */
            long f290787c;

            /* renamed from: d, reason: collision with root package name */
            long f290788d;

            /* renamed from: e, reason: collision with root package name */
            long f290789e;

            /* renamed from: f, reason: collision with root package name */
            long f290790f;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                this.f290785a = 0L;
                this.f290786b = 0L;
                this.f290787c = 0L;
                this.f290788d = 0L;
                this.f290789e = 0L;
                this.f290790f = 0L;
            }

            int a() {
                return e(this.f290787c, this.f290788d);
            }

            int b() {
                return e(this.f290785a, this.f290790f);
            }

            int c() {
                return e(this.f290789e, this.f290790f);
            }

            int d() {
                return e(this.f290788d, this.f290789e);
            }

            int e(long j3, long j16) {
                if (j3 != 0 && j16 != 0) {
                    return (int) (j16 - j3);
                }
                return 0;
            }

            @NonNull
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "query:" + e(this.f290786b, this.f290787c) + ",extract:" + a() + ",upload:" + d() + ",translate:" + c() + ",total:" + b();
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22262);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                f290770l = new AtomicLong(1L);
            }
        }

        public d(MessageRecord messageRecord, String str, String str2, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, messageRecord, str, str2, Integer.valueOf(i3));
                return;
            }
            this.f290771a = f290770l.getAndIncrement();
            this.f290777g = new MessageForPtt();
            this.f290779i = new ArrayList<>();
            b bVar = new b();
            this.f290780j = bVar;
            this.f290781k = new a();
            this.f290772b = messageRecord;
            this.f290773c = str;
            this.f290774d = str2;
            this.f290775e = i3;
            bVar.f290785a = System.currentTimeMillis();
            a(messageRecord);
        }

        void a(MessageRecord messageRecord) {
            MessageForPtt messageForPtt = this.f290777g;
            messageForPtt.istroop = messageRecord.istroop;
            messageForPtt.selfuin = messageRecord.selfuin;
            messageForPtt.frienduin = messageRecord.frienduin;
            messageForPtt.senderuin = messageRecord.senderuin;
            messageForPtt.voiceType = 3;
        }

        void b(String str, int i3) {
            k kVar = k.f290825a;
            String str2 = this.f290774d;
            int b16 = this.f290780j.b();
            int i16 = this.f290781k.f290782a;
            int a16 = this.f290780j.a();
            a aVar = this.f290781k;
            kVar.a(str, str2, i3, b16, i16, a16, aVar.f290784c, aVar.f290783b, this.f290780j.c(), this.f290780j.d());
        }

        public void c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                this.f290777g.voiceType = i3;
            }
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "{" + getClass().getSimpleName() + ":session=" + this.f290771a + ",videoMd5=" + this.f290774d + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e implements ad {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final d f290791d;

        e(d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoSubtitleManager.this, (Object) dVar);
            } else {
                this.f290791d = dVar;
            }
        }

        void a(d dVar) {
            ((ITransFileController) VideoSubtitleManager.this.appRuntime.getRuntimeService(ITransFileController.class, "")).removeProcessor(dVar.f290778h.getKeyForTransfer());
        }

        @Override // com.tencent.mobileqq.pic.ad
        public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MessageRecord) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_richtext);
            }
            a(this.f290791d);
            this.f290791d.f290777g.richText = im_msg_body_richtext;
            QLog.i(VideoSubtitleManager.TAG, 1, "on upload audio success, task=" + this.f290791d + ", urlAtServer=" + this.f290791d.f290777g.urlAtServer + ", groupFileId=" + this.f290791d.f290777g.groupFileID + ", groupFileKey=" + this.f290791d.f290777g.groupFileKeyStr);
            VideoSubtitleManager.this.onUploadAudio(this.f290791d);
            return this.f290791d.f290777g;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void q(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
                return;
            }
            QLog.i(VideoSubtitleManager.TAG, 1, "FAILED to upload audio, FAIL, task=" + this.f290791d);
            a(this.f290791d);
            VideoSubtitleManager.this.notifyFail(this.f290791d, 5);
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            } else {
                QLog.i(VideoSubtitleManager.TAG, 1, "updateMsg, IGNORED");
            }
        }
    }

    public VideoSubtitleManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.disableLocalCache = false;
        this.skipQueryServerCache = false;
        this.queue = com.tencent.mobileqq.qdispatchqueue.d.a(TAG);
        this.tasks = new ArrayList<>();
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    private static boolean checkUploadAudioParams(@NonNull d dVar) {
        MessageRecord messageRecord = dVar.f290772b;
        if (!TextUtils.isEmpty(messageRecord.selfuin) && !TextUtils.isEmpty(messageRecord.frienduin)) {
            return true;
        }
        return false;
    }

    private d createTask(MessageRecord messageRecord, String str, String str2, int i3, com.tencent.mobileqq.stt.sub.api.a aVar) {
        synchronized (this.tasks) {
            Iterator<d> it = this.tasks.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.f290773c.equals(str)) {
                    next.f290779i.add(aVar);
                    return null;
                }
            }
            d dVar = new d(messageRecord, str, str2, i3);
            dVar.f290779i.add(aVar);
            this.tasks.add(dVar);
            return dVar;
        }
    }

    static void doExtractAudio(final Context context, final String str, final String str2, final b bVar) {
        AudioExtractorUtil.a(context, str, str2, new AudioExtractorUtil.a() { // from class: com.tencent.mobileqq.stt.sub.api.impl.g
            @Override // com.tencent.mobileqq.stt.util.AudioExtractorUtil.a
            public final void a(int i3, MediaFormat mediaFormat, long j3) {
                VideoSubtitleManager.lambda$doExtractAudio$8(context, str, str2, bVar, i3, mediaFormat, j3);
            }
        });
    }

    private void extractAudioFromVideo(Context context, final d dVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        dVar.f290780j.f290787c = currentTimeMillis;
        String str = dVar.f290773c;
        if (!new File(str).exists()) {
            QLog.i(TAG, 1, "extractAudioFromVideo, file not exist, path=" + str);
            notifyFail(dVar, 1);
            return;
        }
        long b16 = com.tencent.mobileqq.stt.sub.b.b(str);
        if (b16 >= com.tencent.mobileqq.stt.sub.a.b().e()) {
            QLog.i(TAG, 1, "extractAudioFromVideo, file too large, path=" + str + ", size=" + b16);
            notifyFail(dVar, 11);
            return;
        }
        final String str2 = str + ".audio";
        doExtractAudio(context, str, str2, new b() { // from class: com.tencent.mobileqq.stt.sub.api.impl.h
            @Override // com.tencent.mobileqq.stt.sub.api.impl.VideoSubtitleManager.b
            public final void a(int i3, MediaFormat mediaFormat, boolean z16, long j3) {
                VideoSubtitleManager.this.lambda$extractAudioFromVideo$6(dVar, str2, currentTimeMillis, i3, mediaFormat, z16, j3);
            }
        });
    }

    static int getNonZeroVoiceLength(long j3) {
        if (j3 == 0) {
            return 1;
        }
        return (int) j3;
    }

    private String getSubtitleFromMessageRecord(MessageRecord messageRecord, String str) {
        if (isCacheDisabled()) {
            return null;
        }
        String d16 = com.tencent.mobileqq.stt.sub.b.d(str);
        if (com.tencent.mobileqq.stt.sub.b.f(d16)) {
            return d16;
        }
        return com.tencent.mobileqq.stt.sub.b.c(messageRecord);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doExtractAudio$8(Context context, String str, String str2, final b bVar, int i3, final MediaFormat mediaFormat, long j3) {
        if (i3 == 5) {
            QLog.i(TAG, 1, "audio format not support, try to decode to silk");
            AudioExtractorUtil.b(context, str, str2, new AudioExtractorUtil.a() { // from class: com.tencent.mobileqq.stt.sub.api.impl.i
                @Override // com.tencent.mobileqq.stt.util.AudioExtractorUtil.a
                public final void a(int i16, MediaFormat mediaFormat2, long j16) {
                    VideoSubtitleManager.b.this.a(i16, mediaFormat, true, j16);
                }
            });
        } else {
            bVar.a(i3, mediaFormat, false, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$extractAudioFromVideo$6(d dVar, String str, long j3, int i3, MediaFormat mediaFormat, boolean z16, long j16) {
        if (mediaFormat != null) {
            dVar.f290781k.f290784c = mediaFormat.getString("mime");
        }
        dVar.f290781k.f290783b = i3;
        if (i3 != 0) {
            QLog.i(TAG, 1, "FAILED to extract audio, error=" + i3 + ", task=" + dVar + ", format=" + mediaFormat);
            notifyFail(dVar, 2);
            return;
        }
        long b16 = com.tencent.mobileqq.stt.sub.b.b(str);
        if (b16 >= com.tencent.mobileqq.stt.sub.a.b().a()) {
            QLog.i(TAG, 1, "extractAudioFromVideo, audio too large, , task=" + dVar + ", size=" + b16);
            com.tencent.mobileqq.stt.sub.b.a(str);
            notifyFail(dVar, 12);
            return;
        }
        int mediaFormatToAudioType = mediaFormatToAudioType(mediaFormat, z16);
        if (mediaFormatToAudioType < 0) {
            QLog.i(TAG, 1, "extractAudioFromVideo, format not support, , task=" + dVar + ", format=" + mediaFormat);
            com.tencent.mobileqq.stt.sub.b.a(str);
            notifyFail(dVar, 13);
            return;
        }
        QLog.i(TAG, 1, "extract audio success, task=" + dVar + ", format=" + mediaFormat + ", file-length=" + com.tencent.mobileqq.stt.sub.b.b(str) + ", audio-length=" + j16 + ", audio-type=" + mediaFormatToAudioType + ", cost-time=" + (System.currentTimeMillis() - j3));
        dVar.f290776f = str;
        dVar.f290777g.voiceLength = getNonZeroVoiceLength(j16 / 1000);
        dVar.c(mediaFormatToAudioType);
        uploadAudio(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getVideoSubtitle$0(String str, int i3, long j3, String str2, com.tencent.mobileqq.stt.sub.api.a aVar, String str3, int i16) {
        MessageRecord queryMsgItemByUniseq = ((IMessageFacade) this.appRuntime.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(str, i3, j3);
        if (queryMsgItemByUniseq == null) {
            QLog.i(TAG, 1, "getVideoSubtitle, msg not found, uin=" + str + ", uinType=" + i3 + ", uniSeq=" + j3 + "video=" + str2);
            aVar.a(9, null);
            return;
        }
        QLog.i(TAG, 1, "getVideoSubtitle, uin=" + str + ", uinType=" + i3 + ", uniSeq=" + j3 + "video=" + str2);
        getVideoSubtitle(queryMsgItemByUniseq, str2, str3, i16, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getVideoSubtitle$1(MessageRecord messageRecord, String str, d dVar) {
        String subtitleFromMessageRecord = getSubtitleFromMessageRecord(messageRecord, str);
        if (subtitleFromMessageRecord != null) {
            if (com.tencent.mobileqq.stt.sub.b.e(subtitleFromMessageRecord)) {
                QLog.i(TAG, 1, "getVideoSubtitle, get from cache, no subtitle");
                notifyFail(dVar, 8);
                return;
            } else if (com.tencent.mobileqq.stt.sub.b.f(subtitleFromMessageRecord)) {
                QLog.i(TAG, 1, "getVideoSubtitle, get from cache, path=" + subtitleFromMessageRecord);
                notifySuccess(dVar, subtitleFromMessageRecord, 2);
                return;
            }
        }
        if (TextUtils.isEmpty(dVar.f290774d)) {
            QLog.i(TAG, 1, "video md5 not exist");
            onServerCacheMissed(dVar);
            return;
        }
        if (isSkipQueryServerCache()) {
            onServerCacheMissed(dVar);
            return;
        }
        dVar.f290780j.f290786b = System.currentTimeMillis();
        QLog.i(TAG, 1, "try querying cache at server by video md5\uff0ctask=" + dVar);
        ISttManagerService iSttManagerService = (ISttManagerService) this.appRuntime.getRuntimeService(ISttManagerService.class, "");
        MessageRecord messageRecord2 = dVar.f290772b;
        iSttManagerService.queryVideoSubtitle(messageRecord2.senderuin, messageRecord2.frienduin, messageRecord2.istroop, dVar.f290774d, new a(dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyFail$3(d dVar, int i3) {
        removeTask(dVar);
        Iterator<com.tencent.mobileqq.stt.sub.api.a> it = dVar.f290779i.iterator();
        while (it.hasNext()) {
            it.next().a(i3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifySuccess$5(d dVar, String str) {
        Iterator<com.tencent.mobileqq.stt.sub.api.a> it = dVar.f290779i.iterator();
        while (it.hasNext()) {
            it.next().a(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onServerCacheMissed$2(d dVar) {
        extractAudioFromVideo(this.appRuntime.getApplicationContext(), dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTranslateSuccess$4(d dVar, String str, int i3) {
        String str2 = dVar.f290773c + ".srt";
        String srtFromSttText = getSrtFromSttText(str);
        if (TextUtils.isEmpty(srtFromSttText)) {
            com.tencent.mobileqq.stt.sub.b.g(dVar.f290772b);
            QLog.i(TAG, 1, "onTranslateSuccess, stt text empty");
            notifyFail(dVar, 8);
        } else {
            if (!saveSubtitle(srtFromSttText, str2)) {
                notifyFail(dVar, 6);
                return;
            }
            com.tencent.mobileqq.stt.sub.b.h(dVar.f290772b, str2);
            QLog.i(TAG, 1, "onTranslateSuccess, task=" + dVar + ", ptt-text=" + str.length() + ", subtitlePath=" + str2);
            notifySuccess(dVar, str2, i3);
        }
    }

    static int mediaFormatToAudioType(MediaFormat mediaFormat, boolean z16) {
        if (mediaFormat != null && !z16) {
            String string = mediaFormat.getString("mime");
            if (string == null) {
                return -1;
            }
            if ("audio/mp4a-latm".equals(string)) {
                return 3;
            }
            if (!"audio/mpeg".equals(string)) {
                return -1;
            }
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFail(final d dVar, final int i3) {
        QLog.i(TAG, 1, "notifyFail, error=" + i3 + ", task=" + dVar + ", time=" + dVar.f290780j);
        dVar.f290780j.f290790f = System.currentTimeMillis();
        dVar.b(this.appRuntime.getCurrentUin(), i3);
        this.mainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.stt.sub.api.impl.j
            @Override // java.lang.Runnable
            public final void run() {
                VideoSubtitleManager.this.lambda$notifyFail$3(dVar, i3);
            }
        });
    }

    private void notifySuccess(final d dVar, final String str, int i3) {
        removeTask(dVar);
        dVar.f290781k.f290782a = i3;
        dVar.f290780j.f290790f = System.currentTimeMillis();
        dVar.b(this.appRuntime.getCurrentUin(), 0);
        QLog.i(TAG, 1, "notifySuccess, task=" + dVar + ", time=" + dVar.f290780j);
        this.mainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.stt.sub.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                VideoSubtitleManager.lambda$notifySuccess$5(VideoSubtitleManager.d.this, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onServerCacheMissed(final d dVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.stt.sub.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                VideoSubtitleManager.this.lambda$onServerCacheMissed$2(dVar);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTranslateError(d dVar) {
        QLog.i(TAG, 1, "onTranslateError, task=" + dVar);
        notifyFail(dVar, 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTranslateSuccess(final d dVar, final String str, final int i3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.stt.sub.api.impl.f
            @Override // java.lang.Runnable
            public final void run() {
                VideoSubtitleManager.this.lambda$onTranslateSuccess$4(dVar, str, i3);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUploadAudio(d dVar) {
        MessageForPtt messageForPtt = dVar.f290777g;
        if (messageForPtt.richText == null) {
            QLog.i(TAG, 1, "onUploadAudio, FAIL to upload");
            notifyFail(dVar, 5);
        } else if (com.tencent.mobileqq.stt.b.d(messageForPtt)) {
            QLog.i(TAG, 1, "onUploadAudio, FAIL, no uuid");
            notifyFail(dVar, 5);
        } else {
            translate(dVar);
        }
    }

    private void removeTask(d dVar) {
        synchronized (this.tasks) {
            this.tasks.remove(dVar);
        }
    }

    static boolean saveSubtitle(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            QLog.i(TAG, 1, "saveSubtitle, stt text is empty");
            return false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            try {
                fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
                fileOutputStream.close();
                return true;
            } finally {
            }
        } catch (IOException e16) {
            QLog.i(TAG, 1, "saveSubtitle, FAIL, EXCEPTION=" + e16);
            return false;
        }
    }

    private void translate(d dVar) {
        dVar.f290780j.f290789e = System.currentTimeMillis();
        Long translateVideoSubtitle = ((ISttManagerService) this.appRuntime.getRuntimeService(ISttManagerService.class, "all")).translateVideoSubtitle(dVar.f290777g, dVar.f290774d, new c(dVar));
        if (translateVideoSubtitle != null && translateVideoSubtitle.longValue() >= 0) {
            QLog.i(TAG, 1, "request translation, task=" + dVar + ",session-id=" + translateVideoSubtitle);
            return;
        }
        QLog.i(TAG, 1, "request translation, FAIL, task=" + dVar + ", session-id=" + translateVideoSubtitle);
        notifyFail(dVar, 6);
    }

    private void uploadAudio(@NonNull d dVar) {
        if (!checkUploadAudioParams(dVar)) {
            QLog.i(TAG, 1, "uploadAudio, check FAIL, task=" + dVar);
            notifyFail(dVar, 5);
            return;
        }
        dVar.f290780j.f290788d = System.currentTimeMillis();
        TransferRequest transferRequest = new TransferRequest();
        MessageRecord messageRecord = dVar.f290772b;
        transferRequest.mSelfUin = messageRecord.selfuin;
        transferRequest.mPeerUin = messageRecord.frienduin;
        transferRequest.mUinType = messageRecord.istroop;
        transferRequest.mFileType = 2;
        transferRequest.mUniseq = messageRecord.uniseq;
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = dVar.f290776f;
        transferRequest.mBusiType = 1002;
        transferRequest.mPttCompressFinish = true;
        transferRequest.mCanSendMsg = false;
        transferRequest.needSendMsg = false;
        transferRequest.mReqVideoSubtitle = true;
        transferRequest.mUpCallBack = new e(dVar);
        transferRequest.mRec = dVar.f290777g;
        dVar.f290778h = transferRequest;
        ((ITransFileController) this.appRuntime.getRuntimeService(ITransFileController.class, "")).transferAsync(transferRequest);
        QLog.i(TAG, 1, "upload audio, task=" + dVar);
    }

    String getSrtFromSttText(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(PluginBaseInfoHelper.Base64Helper.decode(new JSONObject(str).getJSONArray("sentences").getJSONObject(0).getString("srt"), 0), StandardCharsets.UTF_8);
        } catch (Exception e16) {
            QLog.i(TAG, 1, "getSrtFromSttText, FAIL, " + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.stt.sub.api.IVideoSubtitleManager
    public void getVideoSubtitle(final String str, final int i3, final long j3, final String str2, final String str3, final int i16, final com.tencent.mobileqq.stt.sub.api.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.stt.sub.api.impl.e
                @Override // java.lang.Runnable
                public final void run() {
                    VideoSubtitleManager.this.lambda$getVideoSubtitle$0(str, i3, j3, str2, aVar, str3, i16);
                }
            }, 32, null, true);
        } else {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2, str3, Integer.valueOf(i16), aVar);
        }
    }

    @Override // com.tencent.mobileqq.stt.sub.api.IVideoSubtitleManager
    public boolean isCacheDisabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.disableLocalCache;
    }

    @Override // com.tencent.mobileqq.stt.sub.api.IVideoSubtitleManager
    public boolean isSkipQueryServerCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.skipQueryServerCache;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.appRuntime = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.appRuntime = null;
        }
    }

    @Override // com.tencent.mobileqq.stt.sub.api.IVideoSubtitleManager
    public void setCacheDisabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.disableLocalCache = z16;
        }
    }

    @Override // com.tencent.mobileqq.stt.sub.api.IVideoSubtitleManager
    public void setSkipQueryServerCache(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.skipQueryServerCache = z16;
        }
    }

    @Override // com.tencent.mobileqq.stt.sub.api.IVideoSubtitleManager
    public void getVideoSubtitle(final MessageRecord messageRecord, final String str, String str2, int i3, com.tencent.mobileqq.stt.sub.api.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, messageRecord, str, str2, Integer.valueOf(i3), aVar);
            return;
        }
        if (messageRecord != null && str != null) {
            if (TextUtils.isEmpty(str2) && (messageRecord instanceof MessageForShortVideo)) {
                str2 = ((MessageForShortVideo) messageRecord).md5;
            }
            final d createTask = createTask(messageRecord, str, str2, i3, aVar);
            if (createTask == null) {
                QLog.i(TAG, 1, "getVideoSubtitle, request merged, path=" + str);
                return;
            }
            this.queue.post(new Runnable() { // from class: com.tencent.mobileqq.stt.sub.api.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    VideoSubtitleManager.this.lambda$getVideoSubtitle$1(messageRecord, str, createTask);
                }
            });
            return;
        }
        QLog.i(TAG, 1, "getVideoSubtitle, invalid arguments");
        aVar.a(1, null);
    }
}
