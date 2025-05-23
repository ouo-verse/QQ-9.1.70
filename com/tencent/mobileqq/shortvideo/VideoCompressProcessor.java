package com.tencent.mobileqq.shortvideo;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.shortvideo.ac;
import com.tencent.mobileqq.shortvideo.api.IShortVideoDebugSetting;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.richmedia.videocompress.converter.AsyncHardwareConverter;
import com.tencent.richmedia.videocompress.converter.HardwareConverter;
import com.tencent.richmedia.videocompress.strategy.MediaCodecSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes18.dex */
public class VideoCompressProcessor {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<Long, WeakReference<CompressTask>> f287721a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static VideoCompressProcessor f287722b;

    /* loaded from: classes18.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class b implements VideoConverter.Processor {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<QQAppInterface> f287738a;

        /* renamed from: b, reason: collision with root package name */
        final String f287739b;

        /* renamed from: c, reason: collision with root package name */
        final String f287740c;

        /* renamed from: d, reason: collision with root package name */
        ac.a f287741d;

        /* renamed from: e, reason: collision with root package name */
        c f287742e;

        b(WeakReference<QQAppInterface> weakReference, String str, String str2, ac.a aVar, c cVar) {
            this.f287738a = weakReference;
            this.f287739b = str2;
            this.f287740c = str;
            this.f287742e = cVar;
            if (str2 != null) {
                this.f287741d = aVar;
                return;
            }
            throw new IllegalArgumentException("null == outputFilePath");
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public VideoConverterConfig getEncodeConfig(int i3, int i16) {
            VideoConverterConfig videoConverterConfig = new VideoConverterConfig();
            videoConverterConfig.output = this.f287739b;
            ac.a aVar = this.f287741d;
            videoConverterConfig.scaleRate = aVar.f287762e;
            videoConverterConfig.videoFrameRate = (int) aVar.f287761d;
            videoConverterConfig.videoBitRate = (int) aVar.f287760c;
            return videoConverterConfig;
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onCancel() {
            if (QLog.isColorLevel()) {
                QLog.d("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onCanceled!");
            }
            c cVar = this.f287742e;
            if (cVar != null) {
                cVar.b(3);
            }
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onFail(Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onFailed");
            }
            c cVar = this.f287742e;
            if (cVar != null) {
                cVar.b(2);
            }
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onProgress(int i3) {
            c cVar = this.f287742e;
            if (cVar != null && i3 >= 0 && i3 <= 10000) {
                cVar.a(i3 / 10000.0f);
            }
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onSuccess() {
            if (QLog.isColorLevel()) {
                QLog.d("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onSucceed");
            }
            c cVar = this.f287742e;
            if (cVar != null) {
                cVar.b(1);
            }
        }
    }

    /* loaded from: classes18.dex */
    public interface c {
        void a(float f16);

        void b(int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        boolean f287743a = false;

        /* renamed from: b, reason: collision with root package name */
        String f287744b = "";

        d() {
        }

        private static void a(HashMap<String, String> hashMap, ac.a aVar) {
            hashMap.put("param_des_bps", String.valueOf(aVar.f287760c));
            hashMap.put("param_des_fps", String.valueOf(aVar.f287761d));
            hashMap.put("param_des_width", String.valueOf(aVar.f287758a));
            hashMap.put("param_des_height", String.valueOf(aVar.f287759b));
            hashMap.put("param_des_res", String.valueOf(aVar.f287758a * aVar.f287759b));
        }

        private static void b(HashMap<String, String> hashMap, ac.c cVar) {
            hashMap.put("param_file_source_size", String.valueOf(cVar.f287776a));
            hashMap.put("param_video_duration", String.valueOf(cVar.f287780e));
            hashMap.put("param_src_bps", String.valueOf(cVar.f287782g));
            hashMap.put("param_src_fps", String.valueOf(cVar.f287781f));
            hashMap.put("param_src_width", String.valueOf(cVar.f287777b));
            hashMap.put("param_src_height", String.valueOf(cVar.f287778c));
            hashMap.put("param_src_res", String.valueOf(cVar.f287777b * cVar.f287778c));
        }

        public static void d(ac.c cVar) {
            if (cVar == null) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            b(hashMap, cVar);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actLongVideoInfo", true, 0L, 0L, hashMap, "", false);
        }

        public void c(boolean z16, long j3, ac.c cVar, ac.a aVar, long j16) {
            String str;
            int i3;
            if (cVar != null && aVar != null) {
                HashMap<String, String> hashMap = new HashMap<>();
                b(hashMap, cVar);
                a(hashMap, aVar);
                hashMap.put("param_compressSuccess", z16 + "");
                if (this.f287743a) {
                    str = "1";
                } else {
                    str = "0";
                }
                hashMap.put("param_software_first", str);
                hashMap.put("param_compress_type", this.f287744b);
                hashMap.put("param_compressTime", j3 + "");
                hashMap.put("param_file_target_sze", String.valueOf(j16));
                long j17 = cVar.f287776a;
                if (j17 > 0 && j16 > 0) {
                    hashMap.put("param_compress_rate", String.valueOf(((float) j16) / ((float) j17)));
                }
                if (j3 > 0 && (i3 = cVar.f287780e) > 0) {
                    hashMap.put("param_compressSpeed", String.valueOf(((float) j3) / i3));
                }
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actVideoCompressTime", z16, 0L, 0L, hashMap, "", false);
                QLog.i("VideoCompressProcessor", 1, "reportVideoCompressTime, success=" + z16 + ", compressTime=" + (((float) j3) / 1000.0f) + ", compressType=" + this.f287744b + ", softwareFirst=" + this.f287743a + ", size=" + (((float) cVar.f287776a) / 1000000.0f) + "->" + (((float) j16) / 1000000.0f));
            }
        }
    }

    static {
        URLDrawableHelper.initVideoAIOSizeByDpc();
    }

    VideoCompressProcessor() {
    }

    public static VideoCompressProcessor b() {
        if (f287722b == null) {
            f287722b = new VideoCompressProcessor();
        }
        return f287722b;
    }

    public CompressTask a(long j3) {
        WeakReference<CompressTask> weakReference;
        if (f287721a.containsKey(Long.valueOf(j3)) && (weakReference = f287721a.get(Long.valueOf(j3))) != null) {
            return weakReference.get();
        }
        return null;
    }

    public void c(long j3) {
        CompressTask a16 = a(j3);
        if (a16 != null) {
            a16.e();
        }
        f287721a.remove(Long.valueOf(j3));
    }

    public void d(long j3, CompressTask compressTask) {
        if (compressTask != null) {
            WeakReference<CompressTask> weakReference = new WeakReference<>(compressTask);
            f287721a.put(Long.valueOf(j3), weakReference);
            Utils.executeAsyncTaskOnSerialExcuter(weakReference.get(), new Void[0]);
        }
    }

    /* loaded from: classes18.dex */
    public static class CompressTask extends AsyncTask<Void, Void, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public MessageForShortVideo f287723a;

        /* renamed from: b, reason: collision with root package name */
        private long f287724b;

        /* renamed from: c, reason: collision with root package name */
        private VideoConverter f287725c;

        /* renamed from: d, reason: collision with root package name */
        private String f287726d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<QQAppInterface> f287727e;

        /* renamed from: f, reason: collision with root package name */
        private WeakReference<Context> f287728f;

        /* renamed from: g, reason: collision with root package name */
        private String f287729g;

        /* renamed from: h, reason: collision with root package name */
        private String f287730h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f287731i = false;

        /* renamed from: j, reason: collision with root package name */
        private boolean f287732j = false;

        /* renamed from: k, reason: collision with root package name */
        private boolean f287733k = false;

        /* renamed from: com.tencent.mobileqq.shortvideo.VideoCompressProcessor$CompressTask$2, reason: invalid class name */
        /* loaded from: classes18.dex */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ CompressTask this$0;

            @Override // java.lang.Runnable
            public void run() {
                CompressTask.a(this.this$0);
                MessageForShortVideo messageForShortVideo = this.this$0.f287723a;
                throw null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes18.dex */
        public class a implements c {
            a() {
            }

            @Override // com.tencent.mobileqq.shortvideo.VideoCompressProcessor.c
            public void a(float f16) {
                CompressTask.a(CompressTask.this);
            }

            @Override // com.tencent.mobileqq.shortvideo.VideoCompressProcessor.c
            public void b(int i3) {
                QLog.d("VideoCompressProcessor", 1, "hardware compress finish code: " + i3);
                CompressTask.a(CompressTask.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes18.dex */
        public class b extends ShortVideoTrimmer.ProcessCallBack {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ VideoConverterConfig f287735a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f287736b;

            b(VideoConverterConfig videoConverterConfig, String str) {
                this.f287735a = videoConverterConfig;
                this.f287736b = str;
            }

            @Override // com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.ProcessCallBack, com.tencent.richmedia.videocompress.VideoConverter.Processor
            public VideoConverterConfig getEncodeConfig(int i3, int i16) {
                VideoConverterConfig videoConverterConfig = this.f287735a;
                videoConverterConfig.output = this.f287736b;
                return videoConverterConfig;
            }
        }

        public CompressTask(QQAppInterface qQAppInterface, Context context, MessageForShortVideo messageForShortVideo, a aVar) {
            this.f287727e = new WeakReference<>(qQAppInterface);
            this.f287728f = new WeakReference<>(context);
            this.f287723a = messageForShortVideo;
            this.f287726d = messageForShortVideo.videoFileName;
            messageForShortVideo.videoFileStatus = 998;
            try {
                messageForShortVideo.serial();
                qQAppInterface.getMessageFacade().Y0(messageForShortVideo.frienduin, messageForShortVideo.istroop, messageForShortVideo.uniseq, messageForShortVideo.msgData);
            } catch (Exception e16) {
                QLog.e("VideoCompressProcessor", 1, "CompressTask Init", e16);
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoCompressProcessor", 2, "CompressTask, step: messageForShortVideo info uniseq=" + this.f287723a.uniseq + ", OriPath:" + this.f287726d);
            }
        }

        static /* bridge */ /* synthetic */ a a(CompressTask compressTask) {
            compressTask.getClass();
            return null;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(19:11|12|13|14|(3:155|156|(14:158|44|45|46|(9:83|84|85|(2:103|104)|(2:98|99)(2:88|89)|90|(1:92)|93|94)(11:50|51|(2:73|74)|(4:54|(1:56)|57|(1:59)(1:60))|61|(1:63)|(1:65)(1:72)|66|(1:68)(1:71)|69|70)|82|78|22|(1:24)|(1:26)(1:33)|27|(1:29)(1:32)|30|31))|16|(1:18)|34|35|36|(9:133|134|135|(1:137)|(1:139)(1:146)|140|(1:142)(1:145)|143|144)(2:38|(9:116|117|118|(1:120)|(1:122)(1:129)|123|(1:125)(1:128)|126|127)(17:40|41|42|43|44|45|46|(1:48)|83|84|85|(0)|(0)(0)|90|(0)|93|94))|78|22|(0)|(0)(0)|27|(0)(0)|30|31) */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x03b5, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:153:0x03bc, code lost:
        
            r4 = ", uniseq=";
            r3 = ", fileTargetSize=";
            r7 = "ms, fileSourceSize=";
         */
        /* JADX WARN: Removed duplicated region for block: B:103:0x030e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x03ca  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x03e9  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x040e  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0411  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x03eb  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0324 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x032f  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0319 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int b(String str, String str2) {
            ac.a aVar;
            String str3;
            String str4;
            String str5;
            int i3;
            String str6;
            boolean z16;
            boolean z17;
            String str7;
            boolean h16;
            int g16;
            String str8;
            boolean z18;
            String str9;
            boolean z19;
            String str10;
            boolean z26;
            long currentTimeMillis = System.currentTimeMillis();
            if (!m()) {
                HardwareConverter.setChangeOutputFrameRateDisabled(true);
                AsyncHardwareConverter.u(true);
            }
            ac.b b16 = ac.b(this.f287727e.get());
            ac.c c16 = ac.c(str);
            d.d(c16);
            boolean d16 = ac.d(c16, b16);
            this.f287732j = d16;
            if (QLog.isColorLevel()) {
                QLog.d("VideoCompressProcessor", 1, "CompressTask, isNeedCompress = " + d16);
            }
            k(d16);
            int i16 = -1;
            if (!d16) {
                return -1;
            }
            ac.a a16 = ac.a(c16, b16, this.f287723a.sendRawVideo);
            b bVar = new b(this.f287727e, str, str2, a16, new a());
            d dVar = new d();
            try {
            } catch (Throwable th5) {
                th = th5;
                aVar = a16;
            }
            if (!b16.f287770h.a()) {
                try {
                } catch (Throwable th6) {
                    th = th6;
                    i3 = -1;
                    aVar = a16;
                    str3 = ", uniseq=";
                    str4 = ", fileTargetSize=";
                    str5 = "ms, fileSourceSize=";
                }
                if (!i()) {
                    z17 = false;
                    aVar = a16;
                    str7 = ", uniseq=";
                    str4 = ", fileTargetSize=";
                    str5 = "ms, fileSourceSize=";
                    try {
                        h16 = h();
                        g16 = g(str, bVar, h16);
                        if (g16 == 0 && g16 != -1002) {
                            try {
                                if (QLog.isColorLevel()) {
                                    try {
                                        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: compress failed by MediaCodec");
                                    } catch (Throwable th7) {
                                        th = th7;
                                        i3 = i16;
                                        str3 = str7;
                                        if (QLog.isColorLevel()) {
                                        }
                                        if (i3 != 0) {
                                        }
                                        this.f287730h = str6;
                                        long length = new File(str).length();
                                        long length2 = new File(this.f287730h).length();
                                        Throwable th8 = th;
                                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                        if (i3 != 0) {
                                        }
                                        dVar.c(z16, currentTimeMillis2, c16, aVar, length2);
                                        QLog.i("VideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress, cost:" + currentTimeMillis2 + str5 + length + str4 + length2 + str3 + this.f287723a.uniseq);
                                        throw th8;
                                    }
                                }
                                if (!z17) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("VideoCompressProcessor", 2, "CompressTask, step, try software compress after hardware compress failed");
                                    }
                                    i16 = d(str, str2, c16, aVar);
                                    if (i16 == 0) {
                                        dVar.f287744b = "software";
                                    } else {
                                        this.f287730h = this.f287723a.videoFileName;
                                    }
                                }
                                int i17 = i16;
                                if (QLog.isColorLevel()) {
                                    QLog.d("VideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress retCode=" + i17 + ", uni=" + this.f287723a.uniseq);
                                }
                                if (i17 == 0) {
                                    str8 = str2;
                                } else {
                                    str8 = this.f287723a.videoFileName;
                                }
                                this.f287730h = str8;
                                long length3 = new File(str).length();
                                long length4 = new File(this.f287730h).length();
                                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                                if (i17 == 0) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                dVar.c(z18, currentTimeMillis3, c16, aVar, length4);
                                QLog.i("VideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress, cost:" + currentTimeMillis3 + str5 + length3 + str4 + length4 + str7 + this.f287723a.uniseq);
                                return i17;
                            } catch (Throwable th9) {
                                th = th9;
                                str3 = str7;
                            }
                        } else {
                            str3 = str7;
                            try {
                                if (QLog.isColorLevel()) {
                                    try {
                                        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: compress completed by MediaCodec");
                                    } catch (Throwable th10) {
                                        th = th10;
                                    }
                                }
                                if (!h16) {
                                    try {
                                        dVar.f287744b = "async_hardware";
                                    } catch (Throwable th11) {
                                        th = th11;
                                        i3 = 0;
                                    }
                                } else {
                                    try {
                                        dVar.f287744b = "hardware";
                                    } catch (Throwable th12) {
                                        th = th12;
                                        i3 = 0;
                                    }
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("VideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress retCode=0, uni=" + this.f287723a.uniseq);
                                }
                                this.f287730h = str2;
                                long length5 = new File(str).length();
                                long length6 = new File(this.f287730h).length();
                                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                dVar.c(true, currentTimeMillis4, c16, aVar, length6);
                                QLog.i("VideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress, cost:" + currentTimeMillis4 + str5 + length5 + str4 + length6 + str3 + this.f287723a.uniseq);
                                return 0;
                            } catch (Throwable th13) {
                                th = th13;
                                i3 = i16;
                                if (QLog.isColorLevel()) {
                                }
                                if (i3 != 0) {
                                }
                                this.f287730h = str6;
                                long length7 = new File(str).length();
                                long length22 = new File(this.f287730h).length();
                                Throwable th82 = th;
                                long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
                                if (i3 != 0) {
                                }
                                dVar.c(z16, currentTimeMillis22, c16, aVar, length22);
                                QLog.i("VideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress, cost:" + currentTimeMillis22 + str5 + length7 + str4 + length22 + str3 + this.f287723a.uniseq);
                                throw th82;
                            }
                        }
                        i3 = i16;
                    } catch (Throwable th14) {
                        th = th14;
                        str3 = str7;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress retCode=" + i3 + ", uni=" + this.f287723a.uniseq);
                    }
                    if (i3 != 0) {
                        str6 = str2;
                    } else {
                        str6 = this.f287723a.videoFileName;
                    }
                    this.f287730h = str6;
                    long length72 = new File(str).length();
                    long length222 = new File(this.f287730h).length();
                    Throwable th822 = th;
                    long currentTimeMillis222 = System.currentTimeMillis() - currentTimeMillis;
                    if (i3 != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    dVar.c(z16, currentTimeMillis222, c16, aVar, length222);
                    QLog.i("VideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress, cost:" + currentTimeMillis222 + str5 + length72 + str4 + length222 + str3 + this.f287723a.uniseq);
                    throw th822;
                }
            }
            dVar.f287743a = true;
            if (QLog.isColorLevel()) {
                QLog.i("VideoCompressProcessor", 2, "CompressTask, step, try software compress first");
            }
            aVar = a16;
            i3 = d(str, str2, c16, aVar);
            if (i3 != 0) {
                str5 = "ms, fileSourceSize=";
                if (i3 != -1002) {
                    str4 = ", fileTargetSize=";
                    str7 = ", uniseq=";
                    try {
                        QLog.i("VideoCompressProcessor", 1, "CompressTask, doSoftwareCompress failed, ret=" + i3);
                        z17 = true;
                        i16 = i3;
                        h16 = h();
                        g16 = g(str, bVar, h16);
                        if (g16 == 0) {
                        }
                        str3 = str7;
                        if (QLog.isColorLevel()) {
                        }
                        if (!h16) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        this.f287730h = str2;
                        long length52 = new File(str).length();
                        long length62 = new File(this.f287730h).length();
                        long currentTimeMillis42 = System.currentTimeMillis() - currentTimeMillis;
                        dVar.c(true, currentTimeMillis42, c16, aVar, length62);
                        QLog.i("VideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress, cost:" + currentTimeMillis42 + str5 + length52 + str4 + length62 + str3 + this.f287723a.uniseq);
                        return 0;
                    } catch (Throwable th15) {
                        th = th15;
                        str3 = str7;
                        if (QLog.isColorLevel()) {
                        }
                        if (i3 != 0) {
                        }
                        this.f287730h = str6;
                        long length722 = new File(str).length();
                        long length2222 = new File(this.f287730h).length();
                        Throwable th8222 = th;
                        long currentTimeMillis2222 = System.currentTimeMillis() - currentTimeMillis;
                        if (i3 != 0) {
                        }
                        dVar.c(z16, currentTimeMillis2222, c16, aVar, length2222);
                        QLog.i("VideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress, cost:" + currentTimeMillis2222 + str5 + length722 + str4 + length2222 + str3 + this.f287723a.uniseq);
                        throw th8222;
                    }
                }
                try {
                    QLog.i("VideoCompressProcessor", 1, "CompressTask, doSoftwareCompress cancelled");
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress retCode=" + i3 + ", uni=" + this.f287723a.uniseq);
                    }
                    if (i3 == 0) {
                        str10 = str2;
                    } else {
                        str10 = this.f287723a.videoFileName;
                    }
                    this.f287730h = str10;
                    long length8 = new File(str).length();
                    long length9 = new File(this.f287730h).length();
                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                    if (i3 == 0) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    dVar.c(z26, currentTimeMillis5, c16, aVar, length9);
                    QLog.i("VideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress, cost:" + currentTimeMillis5 + str5 + length8 + ", fileTargetSize=" + length9 + ", uniseq=" + this.f287723a.uniseq);
                    return -1002;
                } catch (Throwable th16) {
                    th = th16;
                    str4 = ", fileTargetSize=";
                    str3 = ", uniseq=";
                }
            } else {
                try {
                    dVar.f287744b = "software";
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress retCode=" + i3 + ", uni=" + this.f287723a.uniseq);
                    }
                    if (i3 == 0) {
                        str9 = str2;
                    } else {
                        str9 = this.f287723a.videoFileName;
                    }
                    this.f287730h = str9;
                    long length10 = new File(str).length();
                    long length11 = new File(this.f287730h).length();
                    long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                    if (i3 == 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    dVar.c(z19, currentTimeMillis6, c16, aVar, length11);
                    QLog.i("VideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress, cost:" + currentTimeMillis6 + "ms, fileSourceSize=" + length10 + ", fileTargetSize=" + length11 + ", uniseq=" + this.f287723a.uniseq);
                    return 0;
                } catch (Throwable th17) {
                    th = th17;
                    str5 = "ms, fileSourceSize=";
                    str3 = ", uniseq=";
                    str4 = ", fileTargetSize=";
                }
            }
            if (QLog.isColorLevel()) {
            }
            if (i3 != 0) {
            }
            this.f287730h = str6;
            long length7222 = new File(str).length();
            long length22222 = new File(this.f287730h).length();
            Throwable th82222 = th;
            long currentTimeMillis22222 = System.currentTimeMillis() - currentTimeMillis;
            if (i3 != 0) {
            }
            dVar.c(z16, currentTimeMillis22222, c16, aVar, length22222);
            QLog.i("VideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress, cost:" + currentTimeMillis22222 + str5 + length7222 + str4 + length22222 + str3 + this.f287723a.uniseq);
            throw th82222;
        }

        private int d(String str, String str2, ac.c cVar, ac.a aVar) {
            if (!ShortVideoTrimmer.initVideoTrim(this.f287728f.get())) {
                QLog.i("VideoCompressProcessor", 1, "CompressTask, ShortVideoTrimmer init failure");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "initVideoTrimError", true, 0L, 0L, (HashMap<String, String>) null, "", false);
                return -2;
            }
            VideoConverterConfig videoConverterConfig = new VideoConverterConfig();
            videoConverterConfig.isNeedCompress = true;
            videoConverterConfig.rotate = String.valueOf(cVar.f287779d);
            videoConverterConfig.srcWidth = cVar.f287777b;
            videoConverterConfig.srcHeight = cVar.f287778c;
            videoConverterConfig.destWidth = aVar.f287758a;
            videoConverterConfig.destHeight = aVar.f287759b;
            videoConverterConfig.destQmax = 25;
            videoConverterConfig.videoFrameRate = (int) aVar.f287761d;
            videoConverterConfig.videoBitRate = (int) (aVar.f287760c / 1024);
            this.f287725c = new VideoConverter();
            ShortVideoTrimmer.setSoftwareCompressMode(this.f287728f.get(), this.f287725c);
            return this.f287725c.startCompress(this.f287728f.get(), str, new b(videoConverterConfig, str2), true);
        }

        private String f() {
            String str;
            MessageForShortVideo messageForShortVideo = this.f287723a;
            if (messageForShortVideo != null) {
                str = String.valueOf(messageForShortVideo.uniseq);
            } else {
                str = "";
            }
            return "uniseq = " + str;
        }

        private int g(String str, b bVar, boolean z16) {
            int i3;
            boolean z17;
            VideoConverter videoConverter = new VideoConverter(new br2.a());
            this.f287725c = videoConverter;
            if (z16) {
                i3 = 5;
            } else {
                i3 = 1;
            }
            videoConverter.setCompressMode(i3);
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[2];
                objArr[0] = "CompressTask, step, hardwareCompress. isAsyncMode = ";
                if (i3 == 5) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                objArr[1] = Boolean.valueOf(z17);
                QLog.d("VideoCompressProcessor", 2, objArr);
            }
            if (j()) {
                this.f287725c.setOutPutVideoCodecMIMEType(MediaCodecSupport.HEVC_CODEC_MIME);
                int startCompress = this.f287725c.startCompress(this.f287728f.get(), str, bVar, true);
                if (startCompress != 0 && startCompress != -1002) {
                    QLog.d("VideoCompressProcessor", 1, "[H265_VIDEO]", "CompressTask, step: compress to H265 video failed by MediaCodec. compressRet = ", Integer.valueOf(startCompress));
                    this.f287733k = false;
                    this.f287725c.setOutPutVideoCodecMIMEType(MediaCodecSupport.AVC_CODEC_MIME);
                    return this.f287725c.startCompress(this.f287728f.get(), str, bVar, true);
                }
                return startCompress;
            }
            this.f287733k = false;
            return this.f287725c.startCompress(this.f287728f.get(), str, bVar, true);
        }

        public static boolean h() {
            if (!((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("aio_video_hardware_compress_async", false) && !((IShortVideoDebugSetting) QRoute.api(IShortVideoDebugSetting.class)).isAIOUseAsyncHardwareVideoCompress()) {
                return false;
            }
            return true;
        }

        public static boolean i() {
            return false;
        }

        private boolean j() {
            if (!this.f287733k) {
                QLog.d("VideoCompressProcessor", 1, "[H265_VIDEO]", "[needEncodeToH265Video] mIsH265Video = false");
                return false;
            }
            if (!h.k(this.f287727e.get())) {
                QLog.d("VideoCompressProcessor", 1, "[H265_VIDEO]", "[needEncodeToH265Video] isConfigEnableAIOH265VideoUpload = false");
                return false;
            }
            if (!ShortVideoUtils.isDeviceSupportEncodeH265Video()) {
                QLog.d("VideoCompressProcessor", 1, "[H265_VIDEO]", "[needEncodeToH265Video] isDeviceSupportEncodeH265Video = false");
                return false;
            }
            QLog.d("VideoCompressProcessor", 1, "[H265_VIDEO]", "[needEncodeToH265Video] needEncodeToH265Video = true");
            return true;
        }

        public static boolean m() {
            return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("video_compress_support_change_fps");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:49:0x01c2  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x01c9  */
        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Integer doInBackground(Void... voidArr) {
            MessageForShortVideo messageForShortVideo;
            String str;
            String str2;
            boolean z16;
            WeakReference<Context> weakReference = this.f287728f;
            if (weakReference != null && weakReference.get() != null && (messageForShortVideo = this.f287723a) != null) {
                if (!TextUtils.isEmpty(messageForShortVideo.md5)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: Md5 not null, Compressed has been done, uniseq=" + this.f287723a.uniseq);
                    }
                    return 5;
                }
                if (!TextUtils.isEmpty(this.f287723a.videoFileName) && FileUtils.fileExistsAndNotEmpty(this.f287723a.videoFileName)) {
                    String str3 = this.f287723a.videoFileName;
                    this.f287726d = str3;
                    String shortVideoCompressPath = ShortVideoUtils.getShortVideoCompressPath(str3, "mp4");
                    if (TextUtils.isEmpty(shortVideoCompressPath)) {
                        return 5;
                    }
                    boolean isH265FormatShortVideo = ShortVideoUtils.isH265FormatShortVideo(this.f287726d);
                    if (this.f287723a.sendRawVideo) {
                        shortVideoCompressPath = ShortVideoUtils.getShortVideoRawCompressPath(str3, "mp4");
                        long length = new File(str3).length();
                        if (length >= ShortVideoConstants.VIDEO_SIZE_LIMIT) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        this.f287731i = z16;
                        if (isH265FormatShortVideo) {
                            this.f287731i = true;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("VideoCompressProcessor", 2, "CompressTask, step: Compressed sendRawVideo, uniseq:" + this.f287723a.uniseq + ", mRawCompress:" + this.f287731i + ", output:" + shortVideoCompressPath + ", isH265:" + isH265FormatShortVideo + ", size:" + length);
                        }
                    }
                    this.f287733k = isH265FormatShortVideo;
                    if (TextUtils.isEmpty(shortVideoCompressPath)) {
                        return 5;
                    }
                    MessageForShortVideo messageForShortVideo2 = this.f287723a;
                    if (messageForShortVideo2.sendRawVideo && !this.f287731i) {
                        this.f287730h = messageForShortVideo2.videoFileName;
                        if (QLog.isColorLevel()) {
                            QLog.d("VideoCompressProcessor", 2, "CompressTask, step: Compressed sendRawVideo, uniseq:" + this.f287723a.uniseq);
                        }
                    } else if (FileUtils.fileExistsAndNotEmpty(shortVideoCompressPath)) {
                        this.f287730h = shortVideoCompressPath;
                        QLog.d("VideoCompressProcessor", 1, "CompressTask, step: Compressed file has exists, videoPath:" + shortVideoCompressPath + ", uniseq=" + this.f287723a.uniseq);
                    } else {
                        int b16 = b(str3, shortVideoCompressPath);
                        long length2 = new File(str3).length();
                        long length3 = new File(shortVideoCompressPath).length();
                        if (!QLog.isColorLevel()) {
                            str = ", uniseq=";
                        } else {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("CompressTask\uff0cstep: ShortVideoTrimmer Over fileSourceSize=");
                            sb5.append(length2);
                            sb5.append(", fileTargetSize=");
                            sb5.append(length3);
                            sb5.append(", uniseq=");
                            str = ", uniseq=";
                            sb5.append(this.f287723a.uniseq);
                            sb5.append(", videoInput=");
                            sb5.append(str3);
                            sb5.append(", mVideoPath=");
                            sb5.append(this.f287730h);
                            QLog.d("VideoCompressProcessor", 2, sb5.toString());
                        }
                        if (b16 == 0) {
                            if (length3 > length2) {
                                FileUtils.deleteFile(shortVideoCompressPath);
                                this.f287730h = this.f287723a.videoFileName;
                            } else {
                                this.f287730h = shortVideoCompressPath;
                            }
                        } else {
                            this.f287730h = this.f287723a.videoFileName;
                        }
                        if (!isCancelled()) {
                            return 11;
                        }
                        if (QLog.isColorLevel()) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("CompressTask, step: after compress, mVideoPath = ");
                            sb6.append(this.f287730h);
                            sb6.append(", videoInput = ");
                            sb6.append(str3);
                            str2 = str;
                            sb6.append(str2);
                            sb6.append(this.f287723a.uniseq);
                            QLog.d("VideoCompressProcessor", 2, sb6.toString());
                        } else {
                            str2 = str;
                        }
                        if (!TextUtils.isEmpty(this.f287730h) && FileUtils.fileExistsAndNotEmpty(this.f287730h)) {
                            File file = new File(this.f287730h);
                            if (ShortVideoUtils.isSupportProgressive(file)) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("VideoCompressProcessor", 2, "CompressTask, step: supportProgressive, uniseq=" + this.f287723a.uniseq);
                                }
                                this.f287723a.supportProgressive = true;
                            } else {
                                boolean z17 = com.tencent.mobileqq.activity.shortvideo.e.f186320a.get();
                                if (z17) {
                                    boolean moveMoovAtom = ShortVideoUtils.moveMoovAtom(this.f287730h, shortVideoCompressPath);
                                    if (moveMoovAtom) {
                                        this.f287730h = shortVideoCompressPath;
                                        file = new File(this.f287730h);
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: not supportProgressive => moveMoovAtom, result = " + moveMoovAtom + str2 + this.f287723a.uniseq + ", enableProgressive = " + z17);
                                    }
                                    this.f287723a.supportProgressive = moveMoovAtom;
                                }
                            }
                            this.f287724b = file.length();
                            try {
                                this.f287729g = HexUtil.bytes2HexStr(MD5.toMD5Byte(new FileInputStream(file), this.f287724b));
                            } catch (FileNotFoundException e16) {
                                e16.printStackTrace();
                            } catch (Exception e17) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("VideoCompressProcessor", 2, "", e17);
                                }
                            }
                            if (TextUtils.isEmpty(this.f287729g)) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("VideoCompressProcessor", 1, "CompressTask, step: after compress, mVideoMd5 is empty!!, uniseq=" + this.f287723a.uniseq);
                                }
                                return 5;
                            }
                            MessageForShortVideo messageForShortVideo3 = this.f287723a;
                            messageForShortVideo3.md5 = this.f287729g;
                            messageForShortVideo3.originVideoMd5 = MD5Utils.encodeFileHexStr(str3);
                            this.f287723a.videoFileSize = (int) this.f287724b;
                            File file2 = new File(this.f287730h);
                            String j3 = j.j(this.f287723a, "mp4");
                            FileUtils.copyFile(file2, new File(j3));
                            if (!TextUtils.isEmpty(this.f287726d) && !TextUtils.isEmpty(this.f287730h) && !this.f287726d.equals(this.f287730h)) {
                                FileUtils.deleteFile(file2);
                            }
                            MessageForShortVideo messageForShortVideo4 = this.f287723a;
                            messageForShortVideo4.videoFileName = j3;
                            messageForShortVideo4.sourceVideoCodecFormat = this.f287733k ? 1 : 0;
                            messageForShortVideo4.serial();
                            return 1;
                        }
                        QLog.e("VideoCompressProcessor", 2, "CompressTask, step: after compress, mVideoPath not exists!!, path = " + this.f287730h + str2 + this.f287723a.uniseq);
                        return 3;
                    }
                    str = ", uniseq=";
                    if (!isCancelled()) {
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.e("VideoCompressProcessor", 2, "CompressTask, step: before compress, msg.videoFileName file not exists!! videoFileName=" + this.f287723a.videoFileName);
                    }
                    return 3;
                }
            } else {
                return 7;
            }
        }

        public boolean e() {
            VideoConverter videoConverter = this.f287725c;
            if (videoConverter != null) {
                return videoConverter.cancelCompress();
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            QLog.d("VideoCompressProcessor", 1, "CompressTask onPostExecute(): result = " + num + ", " + f());
            if (QLog.isColorLevel()) {
                QLog.d("VideoCompressProcessor", 2, "onPostExecute, mListener is null ," + f());
            }
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            String shortVideoCompressPath;
            ChatFragment chatFragment;
            a61.c qh5;
            if (this.f287727e.get() != null) {
                MessageForShortVideo messageForShortVideo = this.f287723a;
                String str = messageForShortVideo.md5;
                messageForShortVideo.videoFileStatus = 1004;
                if (!TextUtils.isEmpty(str)) {
                    FileUtils.deleteFile(j.j(messageForShortVideo, "mp4"));
                }
                if (!TextUtils.isEmpty(this.f287726d)) {
                    messageForShortVideo.videoFileName = this.f287726d;
                }
                messageForShortVideo.md5 = null;
                messageForShortVideo.serial();
                this.f287727e.get().getMessageFacade().Y0(messageForShortVideo.frienduin, messageForShortVideo.istroop, messageForShortVideo.uniseq, messageForShortVideo.msgData);
                ((IOrderMediaMsgService) this.f287727e.get().getRuntimeService(IOrderMediaMsgService.class)).removeMediaMsgByUniseq(messageForShortVideo.frienduin, messageForShortVideo.uniseq);
                WeakReference<Context> weakReference = this.f287728f;
                if (weakReference != null && weakReference.get() != null && (this.f287728f.get() instanceof BaseActivity) && (chatFragment = ((BaseActivity) this.f287728f.get()).getChatFragment()) != null && (qh5 = chatFragment.qh()) != null) {
                    qh5.q(false, false);
                }
                if (messageForShortVideo.sendRawVideo) {
                    shortVideoCompressPath = ShortVideoUtils.getShortVideoRawCompressPath(this.f287726d, "mp4");
                } else {
                    shortVideoCompressPath = ShortVideoUtils.getShortVideoCompressPath(this.f287726d, "mp4");
                }
                if (!TextUtils.isEmpty(shortVideoCompressPath)) {
                    FileUtils.deleteFile(shortVideoCompressPath);
                }
                VideoCompressProcessor.b().c(this.f287723a.uniseq);
                if (QLog.isColorLevel()) {
                    QLog.i("VideoCompressProcessor", 2, "CompressTask onCancelled id:" + this.f287723a.uniseq + ", videoFileName:" + messageForShortVideo.videoFileName + ", md5:" + str);
                }
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
        }

        private void k(boolean z16) {
        }
    }
}
