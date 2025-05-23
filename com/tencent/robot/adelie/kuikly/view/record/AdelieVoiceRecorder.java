package com.tencent.robot.adelie.kuikly.view.record;

import android.os.SystemClock;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.kuikly.module.AdelieTtsRecordParam;
import com.tencent.ttpic.videoshelf.data.Constants;
import common.config.service.QzoneConfig;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\"R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010+R\u0016\u0010-\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\"R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010.R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/view/record/AdelieVoiceRecorder;", "", "", "l", "", "level", "", "p", "k", "Lcom/tencent/robot/adelie/kuikly/module/n;", "recordParam", "j", DomainData.DOMAIN_NAME, "o", "", "i", "", h.F, "", "a", "[I", "VOLUME_ARRAY", "Lcom/tencent/robot/adelie/kuikly/view/record/e;", "b", "Lcom/tencent/robot/adelie/kuikly/view/record/e;", "g", "()Lcom/tencent/robot/adelie/kuikly/view/record/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/robot/adelie/kuikly/view/record/e;)V", "callback", "c", "D", "curRecordTime", "d", "Ljava/lang/String;", Constants.AUDIO_FILE_PATH, "Lcom/tencent/mobileqq/ptt/d;", "e", "Lcom/tencent/mobileqq/ptt/d;", "audioRecorder", "f", "pcmForVadPath", "", "J", "lastSliceTime", "wavFilePath", "Lcom/tencent/robot/adelie/kuikly/module/n;", "Lcom/tencent/mobileqq/ptt/d$a;", "Lcom/tencent/mobileqq/ptt/d$a;", "audioRecordListener", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieVoiceRecorder {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e callback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private double curRecordTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.ptt.d audioRecorder;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long lastSliceTime;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] VOLUME_ARRAY = {0, 500, 1000, 1500, 2300, QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES, 5000, 7000, 10000, 15000, 20000};

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String audioFilePath = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pcmForVadPath = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String wavFilePath = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AdelieTtsRecordParam recordParam = new AdelieTtsRecordParam(0.0f, 0, 0, null, 15, null);

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d.a audioRecordListener = new AdelieVoiceRecorder$audioRecordListener$1(this);

    private final boolean k() {
        com.tencent.mobileqq.ptt.d dVar = this.audioRecorder;
        if (dVar == null || !dVar.isRecording()) {
            return false;
        }
        return true;
    }

    private final boolean l() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.lastSliceTime < 75) {
            return false;
        }
        this.lastSliceTime = uptimeMillis;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(int level) {
        if (!l()) {
            return;
        }
        int length = this.VOLUME_ARRAY.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (level > this.VOLUME_ARRAY[length]) {
                    break;
                } else if (i3 < 0) {
                    break;
                } else {
                    length = i3;
                }
            }
        }
        length = 0;
        e eVar = this.callback;
        if (eVar != null) {
            eVar.b(length);
        }
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final e getCallback() {
        return this.callback;
    }

    /* renamed from: h, reason: from getter */
    public final double getCurRecordTime() {
        return this.curRecordTime;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getWavFilePath() {
        return this.wavFilePath;
    }

    public final void j(@NotNull AdelieTtsRecordParam recordParam) {
        Intrinsics.checkNotNullParameter(recordParam, "recordParam");
        if (this.audioRecorder == null) {
            this.audioRecorder = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).createQQRecorder(QBaseActivity.sTopActivity);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        String currentUin = peekAppRuntime.getCurrentUin();
        if (currentUin == null) {
            currentUin = "";
        }
        String transferFilePath = TransFileUtil.getTransferFilePath(currentUin, null, 2, null, false);
        Intrinsics.checkNotNullExpressionValue(transferFilePath, "getTransferFilePath(\n   \u2026          false\n        )");
        this.audioFilePath = transferFilePath;
        RecordParams.RecorderParam c16 = RecordParams.c(peekAppRuntime, false);
        c16.f307255d = (int) recordParam.getSampleRate();
        c16.f307256e = (int) recordParam.getSampleRate();
        c16.f307257f = 2;
        com.tencent.mobileqq.ptt.d dVar = this.audioRecorder;
        if (dVar != null) {
            dVar.e(c16);
        }
        String vFSPath = RmVFSUtils.getVFSPath(AppConstants.SDCARD_PATH + "ppt/", true);
        File file = new File(vFSPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String str = vFSPath + "create_customize_voice.pcm";
        this.pcmForVadPath = str;
        com.tencent.mobileqq.ptt.d dVar2 = this.audioRecorder;
        if (dVar2 != null) {
            dVar2.d(str);
        }
        com.tencent.mobileqq.ptt.d dVar3 = this.audioRecorder;
        if (dVar3 != null) {
            dVar3.b(this.audioRecordListener);
        }
        QLog.d("AdelieVoiceRecorder", 1, "QQRecorder start time is:" + System.currentTimeMillis());
    }

    public final void m(@Nullable e eVar) {
        this.callback = eVar;
    }

    public final void n(@NotNull AdelieTtsRecordParam recordParam) {
        Intrinsics.checkNotNullParameter(recordParam, "recordParam");
        this.recordParam = recordParam;
        com.tencent.mobileqq.ptt.d dVar = this.audioRecorder;
        if (dVar != null) {
            dVar.start(this.audioFilePath);
        }
    }

    public final void o() {
        com.tencent.mobileqq.ptt.d dVar;
        if (k() && (dVar = this.audioRecorder) != null) {
            dVar.stop();
        }
        com.tencent.qqnt.audio.record.util.b bVar = com.tencent.qqnt.audio.record.util.b.f352553a;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        bVar.c(context, false);
    }
}
