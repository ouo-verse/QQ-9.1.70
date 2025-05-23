package com.tencent.zplan.record.recorder;

import androidx.annotation.RequiresApi;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.meme.action.ERROR_ENGINE_DISCONNECT;
import com.tencent.zplan.meme.action.ERROR_ENGINE_INIT_FAIL;
import com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder;
import com.tencent.zplan.utils.ZLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lx4.f;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0017\u00a8\u0006\t"}, d2 = {"com/tencent/zplan/record/recorder/MemeZPlanBaseRecorder$BaseRecordContext$engineStatusListener$1", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "engineInitFinish", "", "success", "", "engineSuspended", "serviceConnected", UploadQualityReportBuilder.STATE_CONNECT, "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class MemeZPlanBaseRecorder$BaseRecordContext$engineStatusListener$1 implements ZPlanEngineStatusUpdateListener {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MemeZPlanBaseRecorder.BaseRecordContext f386172d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MemeZPlanBaseRecorder$BaseRecordContext$engineStatusListener$1(MemeZPlanBaseRecorder.BaseRecordContext baseRecordContext) {
        this.f386172d = baseRecordContext;
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineDestroy() {
        ZPlanEngineStatusUpdateListener.a.a(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
    public void engineFirstFrame() {
        ZPlanEngineStatusUpdateListener.a.b(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInitFinish(boolean success) {
        boolean z16;
        ZPlanEngineStatusUpdateListener.a.c(this, success);
        ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
        boolean l06 = zPlanServiceHelper.l0();
        boolean forceStopped = this.f386172d.getForceStopped();
        ZLog zLog = ZLog.f386189b;
        zLog.k("[zplan][MemePlayer-SDK][MemeZPlanBaseRecorder]", "EngineStatusUpdate engineInitFinish:" + success + ", engineReady:" + l06 + ',' + TokenParser.SP + this.f386172d.getAction().getDesc() + ", forceStopped:" + forceStopped + ", " + this);
        if (forceStopped) {
            return;
        }
        if (success && l06) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            this.f386172d.k(ERROR_ENGINE_INIT_FAIL.INSTANCE);
            return;
        }
        if (!this.f386172d.getRecorder().getHasSetUsing()) {
            this.f386172d.getRecorder().setHasSetUsing(zPlanServiceHelper.Q0(true));
            zLog.k("[zplan][MemePlayer-SDK][MemeZPlanBaseRecorder]", "[initFinish] setZPlanSceneStatus to " + this.f386172d.getRecorder().getHasSetUsing());
        }
        f.a.a(this.f386172d.getThreadPool(), new Runnable() { // from class: com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder$BaseRecordContext$engineStatusListener$1$engineInitFinish$1
            @Override // java.lang.Runnable
            public final void run() {
                MemeZPlanBaseRecorder$BaseRecordContext$engineStatusListener$1.this.f386172d.y();
            }
        }, 0L, 2, null);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInversePurged() {
        ZPlanEngineStatusUpdateListener.a.d(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurged() {
        ZPlanEngineStatusUpdateListener.a.e(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurging() {
        ZPlanEngineStatusUpdateListener.a.f(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineSuspended() {
        if (this.f386172d.getForceStopped()) {
            return;
        }
        boolean hasSetUsing = this.f386172d.getRecorder().getHasSetUsing();
        ZLog zLog = ZLog.f386189b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("EngineStatusUpdate engineSuspended, hasSetUsing:");
        sb5.append(hasSetUsing);
        sb5.append(", ");
        sb5.append("enableResumeEngineOnSuspended:");
        MemeZPlanBaseRecorder.Companion companion = MemeZPlanBaseRecorder.INSTANCE;
        sb5.append(companion.a());
        sb5.append(", ");
        sb5.append(this.f386172d.getAction().getDesc());
        sb5.append(", ");
        sb5.append(this);
        zLog.k("[zplan][MemePlayer-SDK][MemeZPlanBaseRecorder]", sb5.toString());
        if (hasSetUsing && companion.a()) {
            this.f386172d.getThreadPool().c(new Runnable() { // from class: com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder$BaseRecordContext$engineStatusListener$1$engineSuspended$1
                @Override // java.lang.Runnable
                public final void run() {
                    if (MemeZPlanBaseRecorder$BaseRecordContext$engineStatusListener$1.this.f386172d.getRecorder().getHasSetUsing()) {
                        MemeZPlanBaseRecorder$BaseRecordContext$engineStatusListener$1.this.f386172d.w();
                    }
                }
            }, 200L);
        }
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void hotPatchDownloadFailed(int i3, @NotNull String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        ZPlanEngineStatusUpdateListener.a.h(this, i3, errorMessage);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    @RequiresApi(16)
    public void serviceConnected(boolean connect) {
        boolean forceStopped = this.f386172d.getForceStopped();
        ZLog zLog = ZLog.f386189b;
        zLog.k("[zplan][MemePlayer-SDK][MemeZPlanBaseRecorder]", "EngineStatusUpdate serviceConnected:" + connect + ", " + this.f386172d.getAction().getDesc() + ", forceStopped:" + forceStopped + ", " + this);
        if (!forceStopped && !connect) {
            zLog.f("[zplan][MemePlayer-SDK][MemeZPlanBaseRecorder]", "EngineStatusUpdate service disConnected, record fail");
            this.f386172d.k(ERROR_ENGINE_DISCONNECT.INSTANCE);
            this.f386172d.getRecorder().setHasSetUsing(false);
        }
    }
}
