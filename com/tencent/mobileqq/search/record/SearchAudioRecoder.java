package com.tencent.mobileqq.search.record;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.mmkv.api.IMMKVPerfApi;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.api.IVoiceToTextSttApi;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.data.Constants;
import com.tencent.util.QQToastUtil;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u001e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\rJ\u0006\u0010\u0013\u001a\u00020\rR\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\"\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/search/record/SearchAudioRecoder;", "", "", "recorderSessionId", "Ltd2/a;", "k", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/search/record/b;", "recordParam", "", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "l", "sessionId", "p", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "a", "Ljava/lang/String;", Constants.AUDIO_FILE_PATH, "Lcom/tencent/mobileqq/ptt/d;", "b", "Lcom/tencent/mobileqq/ptt/d;", "audioRecorder", "c", "pcmForVadPath", "", "d", "D", "curRecordTime", "Lcom/tencent/mobileqq/search/record/a;", "e", "Lcom/tencent/mobileqq/search/record/a;", "j", "()Lcom/tencent/mobileqq/search/record/a;", "o", "(Lcom/tencent/mobileqq/search/record/a;)V", "callback", "f", "Lcom/tencent/mobileqq/search/record/b;", "Ljava/util/concurrent/ConcurrentHashMap;", "g", "Ljava/util/concurrent/ConcurrentHashMap;", "audioPttListenerMap", "currentSessionId", "Lcom/tencent/mobileqq/ptt/d$a;", "Lcom/tencent/mobileqq/ptt/d$a;", "audioRecordListener", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchAudioRecoder {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d audioRecorder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private double curRecordTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a callback;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String audioFilePath = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pcmForVadPath = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RecordParam recordParam = new RecordParam(0.0f, 0.0f, 0, 0, 0, 31, null);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ConcurrentHashMap<String, td2.a> audioPttListenerMap = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String currentSessionId = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d.a audioRecordListener = new d.a() { // from class: com.tencent.mobileqq.search.record.SearchAudioRecoder$audioRecordListener$1
        @Override // com.tencent.mobileqq.ptt.d.a
        public int onBeginReceiveData(@Nullable String path, @Nullable RecordParams.RecorderParam p16) {
            return 120000;
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onInitFailed(@Nullable String path, @Nullable RecordParams.RecorderParam p16) {
            QLog.i("QQSearch.NetDetail.AI.SearchAudioRecoder", 1, "onInitFailed");
            final SearchAudioRecoder searchAudioRecoder = SearchAudioRecoder.this;
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.record.SearchAudioRecoder$audioRecordListener$1$onInitFailed$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    a callback = SearchAudioRecoder.this.getCallback();
                    if (callback != null) {
                        callback.a(-1, "\u5f55\u5236\u5f02\u5e38, \u8bf7\u7a0d\u540e\u91cd\u8bd5");
                    }
                }
            });
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onInitSuccess() {
            QLog.i("QQSearch.NetDetail.AI.SearchAudioRecoder", 1, "onInitSuccess");
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderAbnormal(@Nullable String path, @Nullable RecordParams.RecorderParam p16) {
            QLog.i("QQSearch.NetDetail.AI.SearchAudioRecoder", 1, "onRecorderAbnormal");
            final SearchAudioRecoder searchAudioRecoder = SearchAudioRecoder.this;
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.record.SearchAudioRecoder$audioRecordListener$1$onRecorderAbnormal$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    a callback = SearchAudioRecoder.this.getCallback();
                    if (callback != null) {
                        callback.a(-1, "\u5f55\u5236\u5f02\u5e38, \u8bf7\u7a0d\u540e\u91cd\u8bd5");
                    }
                }
            });
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderEnd(@Nullable String path, @Nullable RecordParams.RecorderParam p16, double totalTime) {
            SearchAudioRecoder.this.curRecordTime = totalTime;
            final SearchAudioRecoder searchAudioRecoder = SearchAudioRecoder.this;
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.record.SearchAudioRecoder$audioRecordListener$1$onRecorderEnd$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    a callback = SearchAudioRecoder.this.getCallback();
                    if (callback != null) {
                        callback.onRecorderEnd();
                    }
                }
            });
            ((IVoiceToTextSttApi) QRoute.api(IVoiceToTextSttApi.class)).onRecorderEnd();
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderError(@Nullable String path, @Nullable RecordParams.RecorderParam p16, @Nullable final String throwable) {
            QLog.i("QQSearch.NetDetail.AI.SearchAudioRecoder", 1, "onRecorderError = " + throwable + " path = " + path);
            final SearchAudioRecoder searchAudioRecoder = SearchAudioRecoder.this;
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.record.SearchAudioRecoder$audioRecordListener$1$onRecorderError$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String str = throwable;
                    if (str == null) {
                        str = "\u5f55\u5236\u5f02\u5e38, \u8bf7\u7a0d\u540e\u91cd\u8bd5";
                    }
                    a callback = searchAudioRecoder.getCallback();
                    if (callback != null) {
                        callback.a(-1, str);
                    }
                }
            });
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderPrepare(@Nullable String path, @Nullable RecordParams.RecorderParam param) {
            QLog.i("QQSearch.NetDetail.AI.SearchAudioRecoder", 1, "onRecorderPrepare = " + path + ", param=" + param);
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderSilceEnd(@Nullable String path, @Nullable final byte[] sliceData, final int size, final int maxAmplitude, final double time, @Nullable RecordParams.RecorderParam p16) {
            SearchAudioRecoder.this.curRecordTime = time;
            final SearchAudioRecoder searchAudioRecoder = SearchAudioRecoder.this;
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.record.SearchAudioRecoder$audioRecordListener$1$onRecorderSilceEnd$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    a callback = SearchAudioRecoder.this.getCallback();
                    if (callback != null) {
                        callback.d(maxAmplitude, sliceData, size, time);
                    }
                }
            });
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public int onRecorderStart() {
            String str;
            String str2;
            String str3;
            td2.a k3;
            SearchAudioRecoder.this.curRecordTime = 0.0d;
            IVoiceToTextSttApi iVoiceToTextSttApi = (IVoiceToTextSttApi) QRoute.api(IVoiceToTextSttApi.class);
            str = SearchAudioRecoder.this.pcmForVadPath;
            str2 = SearchAudioRecoder.this.audioFilePath;
            SearchAudioRecoder searchAudioRecoder = SearchAudioRecoder.this;
            str3 = searchAudioRecoder.currentSessionId;
            k3 = searchAudioRecoder.k(str3);
            iVoiceToTextSttApi.onRecorderStart(str, str2, k3);
            final SearchAudioRecoder searchAudioRecoder2 = SearchAudioRecoder.this;
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.record.SearchAudioRecoder$audioRecordListener$1$onRecorderStart$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    a callback = SearchAudioRecoder.this.getCallback();
                    if (callback != null) {
                        callback.onRecorderStart();
                    }
                }
            });
            return -1;
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderVolumeStateChanged(int state) {
            QLog.i("QQSearch.NetDetail.AI.SearchAudioRecoder", 1, "onRecorderVolumeStateChanged");
        }
    };

    private final boolean h(Context context, RecordParam recordParam) {
        if (!NetworkUtil.isNetworkAvailable(context)) {
            QQToastUtil.showQQToast(-1, "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u65e0\u6cd5\u8bed\u97f3\u8f93\u5165");
            Logger.f235387a.d().w("QQSearch.NetDetail.AI.SearchAudioRecoder", 1, "can't start record no net!");
            a aVar = this.callback;
            if (aVar != null) {
                aVar.a(-1, "no net");
            }
            return false;
        }
        if (!((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).checkIntenalStorageForRecord(recordParam.getAudioType())) {
            QQToastUtil.showQQToast(R.string.by8);
            Logger.f235387a.d().w("QQSearch.NetDetail.AI.SearchAudioRecoder", 1, "can't start record storage full!");
            a aVar2 = this.callback;
            if (aVar2 != null) {
                aVar2.a(-1, "can't start record storage full!");
            }
            return false;
        }
        Boolean isAVChatting = ((IMMKVPerfApi) QRoute.api(IMMKVPerfApi.class)).isAVChatting();
        Intrinsics.checkNotNullExpressionValue(isAVChatting, "api(IMMKVPerfApi::class.java).isAVChatting");
        if (isAVChatting.booleanValue()) {
            QQToastUtil.showQQToast(R.string.f171206d52);
            Logger.f235387a.d().w("QQSearch.NetDetail.AI.SearchAudioRecoder", 1, "can't start record because is chatting or can't has audio focus!");
            a aVar3 = this.callback;
            if (aVar3 != null) {
                aVar3.a(-1, "can't start record because is chatting ");
            }
            return false;
        }
        if (!AudioUtil.h(1)) {
            return true;
        }
        ((IPttUtils) QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission(context);
        Logger.f235387a.d().w("QQSearch.NetDetail.AI.SearchAudioRecoder", 1, "can't start record for meizu!");
        a aVar4 = this.callback;
        if (aVar4 != null) {
            aVar4.a(-1, "can't start record for meizu!");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final td2.a k(String recorderSessionId) {
        SearchAudioRecoder$initNewPttListener$newListener$1 searchAudioRecoder$initNewPttListener$newListener$1 = new SearchAudioRecoder$initNewPttListener$newListener$1(recorderSessionId, this);
        this.audioPttListenerMap.put(recorderSessionId, searchAudioRecoder$initNewPttListener$newListener$1);
        return searchAudioRecoder$initNewPttListener$newListener$1;
    }

    private final boolean m() {
        d dVar = this.audioRecorder;
        if (dVar == null || !dVar.isRecording()) {
            return false;
        }
        return true;
    }

    public final void i(@NotNull String recorderSessionId) {
        Intrinsics.checkNotNullParameter(recorderSessionId, "recorderSessionId");
        q();
        ((IVoiceToTextSttApi) QRoute.api(IVoiceToTextSttApi.class)).cancelAllRequest();
        this.audioPttListenerMap.remove(recorderSessionId);
        QLog.d("QQSearch.NetDetail.AI.SearchAudioRecoder", 1, "QQRecorder cancel sessionId=" + recorderSessionId);
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final a getCallback() {
        return this.callback;
    }

    public final void l() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        String currentUin = peekAppRuntime.getCurrentUin();
        if (currentUin == null) {
            currentUin = "";
        }
        String transferFilePath = TransFileUtil.getTransferFilePath(currentUin, null, 2, null, false);
        Intrinsics.checkNotNullExpressionValue(transferFilePath, "getTransferFilePath(\n   \u2026          false\n        )");
        this.audioFilePath = transferFilePath;
        String vFSPath = RmVFSUtils.getVFSPath(AppConstants.SDCARD_PATH + "ppt/", true);
        File file = new File(vFSPath);
        if (!file.exists()) {
            file.mkdir();
        }
        this.pcmForVadPath = vFSPath + "search_audio.pcm";
    }

    public final void n() {
        q();
        this.audioPttListenerMap.clear();
        this.currentSessionId = "";
        d dVar = this.audioRecorder;
        if (dVar != null) {
            dVar.b(null);
            dVar.release();
        }
    }

    public final void o(@Nullable a aVar) {
        this.callback = aVar;
    }

    public final void p(@NotNull Context context, @NotNull RecordParam recordParam, @NotNull String sessionId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(recordParam, "recordParam");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        if (!h(context, recordParam)) {
            return;
        }
        if (this.audioRecorder == null) {
            this.audioRecorder = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).createQQRecorder(context);
        }
        d dVar = this.audioRecorder;
        if (dVar != null && dVar.isRecording()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QQToastUtil.showQQToast(R.string.z6q);
            Logger.f235387a.d().w("QQSearch.NetDetail.AI.SearchAudioRecoder", 1, "can't start record because now is recording!");
            a aVar = this.callback;
            if (aVar != null) {
                aVar.a(-1, "is already recording!");
                return;
            }
            return;
        }
        File file = new File(this.pcmForVadPath);
        if (file.exists()) {
            file.delete();
        }
        this.currentSessionId = sessionId;
        this.audioPttListenerMap.clear();
        RecordParams.RecorderParam c16 = RecordParams.c(peekAppRuntime, false);
        c16.f307255d = (int) recordParam.getSampleRate();
        c16.f307256e = (int) recordParam.getBitRate();
        c16.f307257f = recordParam.getAudioType();
        d dVar2 = this.audioRecorder;
        if (dVar2 != null) {
            dVar2.e(c16);
        }
        d dVar3 = this.audioRecorder;
        if (dVar3 != null) {
            dVar3.d(this.pcmForVadPath);
        }
        d dVar4 = this.audioRecorder;
        if (dVar4 != null) {
            dVar4.b(this.audioRecordListener);
        }
        QLog.d("QQSearch.NetDetail.AI.SearchAudioRecoder", 1, "QQRecorder start sessionId=" + sessionId);
        this.recordParam = recordParam;
        ((IVoiceToTextSttApi) QRoute.api(IVoiceToTextSttApi.class)).setRecorderSessionId(this.currentSessionId);
        d dVar5 = this.audioRecorder;
        if (dVar5 != null) {
            dVar5.start(this.audioFilePath);
        }
    }

    public final void q() {
        d dVar;
        if (m() && (dVar = this.audioRecorder) != null) {
            dVar.stop();
        }
    }
}
