package com.tencent.robot.adelie.kuikly.view.record;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.kuikly.module.AdelieTtsRecordParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J&\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u001c\u0010\u0012\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u0013\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\bH\u0016J>\u0010\u001b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u001c"}, d2 = {"com/tencent/robot/adelie/kuikly/view/record/AdelieVoiceRecorder$audioRecordListener$1", "Lcom/tencent/mobileqq/ptt/d$a;", "", "path", "Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "param", "", "onRecorderPrepare", "", "onRecorderStart", "p", "onBeginReceiveData", "", "totalTime", "onRecorderEnd", "throwable", "onRecorderError", "onInitSuccess", "onInitFailed", "onRecorderAbnormal", "state", "onRecorderVolumeStateChanged", "", "sliceData", "size", "maxAmplitude", "time", "onRecorderSilceEnd", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieVoiceRecorder$audioRecordListener$1 implements d.a {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdelieVoiceRecorder f366800d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdelieVoiceRecorder$audioRecordListener$1(AdelieVoiceRecorder adelieVoiceRecorder) {
        this.f366800d = adelieVoiceRecorder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdelieVoiceRecorder this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p(i3);
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onBeginReceiveData(@Nullable String path, @Nullable RecordParams.RecorderParam p16) {
        return 120000;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitFailed(@Nullable String path, @Nullable RecordParams.RecorderParam p16) {
        QLog.i("AdelieVoiceRecorder", 1, "onInitFailed");
        e callback = this.f366800d.getCallback();
        if (callback != null) {
            callback.a(-1, "\u5f55\u5236\u5f02\u5e38, \u8bf7\u7a0d\u540e\u91cd\u8bd5");
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitSuccess() {
        QLog.i("AdelieVoiceRecorder", 1, "onInitSuccess");
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderAbnormal(@Nullable String path, @Nullable RecordParams.RecorderParam p16) {
        QLog.i("AdelieVoiceRecorder", 1, "onRecorderAbnormal");
        e callback = this.f366800d.getCallback();
        if (callback != null) {
            callback.a(-1, "\u5f55\u5236\u5f02\u5e38, \u8bf7\u7a0d\u540e\u91cd\u8bd5");
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderEnd(@Nullable String path, @Nullable RecordParams.RecorderParam p16, double totalTime) {
        String str;
        AdelieTtsRecordParam adelieTtsRecordParam;
        this.f366800d.curRecordTime = totalTime;
        AdelieWavFile adelieWavFile = new AdelieWavFile();
        str = this.f366800d.pcmForVadPath;
        adelieTtsRecordParam = this.f366800d.recordParam;
        adelieWavFile.g(str, adelieTtsRecordParam, new AdelieVoiceRecorder$audioRecordListener$1$onRecorderEnd$1(this.f366800d));
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderError(@Nullable String path, @Nullable RecordParams.RecorderParam p16, @Nullable String throwable) {
        QLog.i("AdelieVoiceRecorder", 1, "onRecorderError = " + throwable + " path = " + path);
        if (throwable == null) {
            throwable = "\u5f55\u5236\u5f02\u5e38, \u8bf7\u7a0d\u540e\u91cd\u8bd5";
        }
        e callback = this.f366800d.getCallback();
        if (callback != null) {
            callback.a(-1, throwable);
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderPrepare(@Nullable String path, @Nullable RecordParams.RecorderParam param) {
        QLog.i("AdelieVoiceRecorder", 1, "onRecorderPrepare = " + path + ", param=" + param);
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderSilceEnd(@Nullable String path, @Nullable byte[] sliceData, int size, final int maxAmplitude, double time, @Nullable RecordParams.RecorderParam p16) {
        this.f366800d.curRecordTime = time;
        QLog.i("AdelieVoiceRecorder", 1, "onRecorderSilceEnd value = " + maxAmplitude);
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final AdelieVoiceRecorder adelieVoiceRecorder = this.f366800d;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.robot.adelie.kuikly.view.record.b
            @Override // java.lang.Runnable
            public final void run() {
                AdelieVoiceRecorder$audioRecordListener$1.b(AdelieVoiceRecorder.this, maxAmplitude);
            }
        });
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onRecorderStart() {
        this.f366800d.curRecordTime = 0.0d;
        return -1;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderVolumeStateChanged(int state) {
        QLog.i("AdelieVoiceRecorder", 1, "onRecorderVolumeStateChanged");
    }
}
