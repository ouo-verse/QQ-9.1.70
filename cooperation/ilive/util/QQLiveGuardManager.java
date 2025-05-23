package cooperation.ilive.util;

import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.qqlive.base.coroutine.QQLiveCoroutineScopes;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0016\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcooperation/ilive/util/QQLiveGuardManager;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "c", "d", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "e", "Z", "isStarted", "Lkotlinx/coroutines/Job;", "f", "Lkotlinx/coroutines/Job;", "backgroundReportJob", "Lcom/tencent/mobileqq/qqlive/sail/model/AudienceRoomInfo;", h.F, "Lcom/tencent/mobileqq/qqlive/sail/model/AudienceRoomInfo;", "roomInfo", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class QQLiveGuardManager implements IGuardInterface {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final QQLiveGuardManager f390141d = new QQLiveGuardManager();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean isStarted;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Job backgroundReportJob;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile AudienceRoomInfo roomInfo;

    QQLiveGuardManager() {
    }

    private final void c() {
        Job launch$default;
        Job job = backgroundReportJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(QQLiveCoroutineScopes.f270996a.c().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), null, null, new QQLiveGuardManager$launchReportJob$1(null), 3, null);
        backgroundReportJob = launch$default;
    }

    public final void d() {
        Integer num;
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            num = Integer.valueOf(guardManager.hashCode());
        } else {
            num = null;
        }
        QLog.i("QQLiveGuardManager", 1, "[start] ins=" + num + ", isStarted=" + isStarted);
        if (!isStarted && guardManager != null) {
            guardManager.unregisterCallback(this);
            guardManager.registerCallBack(this);
            isStarted = true;
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        QLog.i("QQLiveGuardManager", 1, "[onApplicationBackground]");
        c();
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        QLog.i("QQLiveGuardManager", 1, "[onApplicationForeground]");
        Job job = backgroundReportJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        final AudienceRoomInfo audienceRoomInfo = roomInfo;
        if (audienceRoomInfo != null) {
            QLog.i("QQLiveGuardManager", 1, "[onApplicationForeground] windowModeSeq=" + audienceRoomInfo.w());
            com.tencent.mobileqq.qqlive.report.h.b(new Function0<QQLiveQualityReportData.Builder>() { // from class: cooperation.ilive.util.QQLiveGuardManager$onApplicationForeground$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final QQLiveQualityReportData.Builder invoke() {
                    QQLiveQualityReportData.Builder eventId = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null).eventId(QQLiveReportConstants.Event.E_AUDIENCE_ON_FOREGROUND);
                    QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
                    return eventId.traceId(c16 != null ? c16.n() : null).roomId(String.valueOf(AudienceRoomInfo.this.getRoomId())).roomType(String.valueOf(AudienceRoomInfo.this.getRoomType())).uid(String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G())).ext7(AudienceRoomInfo.this.w()).ext8(String.valueOf(System.currentTimeMillis()));
                }
            });
        }
        roomInfo = null;
        backgroundReportJob = null;
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long tick) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long tick) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long tick) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean isEnabled) {
    }
}
