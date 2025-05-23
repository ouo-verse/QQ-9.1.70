package nk;

import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.intimate.request.QZIntimateQueryMigrationJobRequest;
import com.qzone.reborn.intimate.request.QZIntimateQueryMigrationSettingRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.qzoneMigration$GetSettingRsp;
import qzone.qzoneMigration$QueryJobRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J2\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019\u00a8\u0006#"}, d2 = {"Lnk/h;", "Lcom/qzone/reborn/base/n;", "", "spaceId", "", "isSuccess", "", "retCode", "errMsg", "Lqzone/qzoneMigration$QueryJobRsp;", "rsp", "", "R1", "Lqzone/qzoneMigration$GetSettingRsp;", "Q1", "getLogTag", "U1", "S1", "Landroidx/lifecycle/MutableLiveData;", "Lij/c;", "i", "Landroidx/lifecycle/MutableLiveData;", "O1", "()Landroidx/lifecycle/MutableLiveData;", "setMigrationData", "(Landroidx/lifecycle/MutableLiveData;)V", "migrationData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "P1", "setShowSettingSyncEntrance", "showSettingSyncEntrance", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class h extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<ij.c> migrationData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<Boolean> showSettingSyncEntrance = new MutableLiveData<>(Boolean.FALSE);

    private final void R1(String spaceId, boolean isSuccess, long retCode, String errMsg, qzoneMigration$QueryJobRsp rsp) {
        if (isSuccess && rsp != null && retCode == 0) {
            QLog.i("QZIntimateLoverSpaceMigrationViewModel", 1, "space id is " + spaceId + ", job id is " + rsp.job_id.get() + ", job status is " + rsp.job_status.get() + ", auth status is " + rsp.auth_status.get() + ",need create job is " + rsp.show_tool_tips.get());
            ij.c cVar = new ij.c();
            cVar.h(spaceId);
            String str = rsp.job_id.get();
            Intrinsics.checkNotNullExpressionValue(str, "rsp.job_id.get()");
            cVar.d(str);
            cVar.e(rsp.job_status.get());
            cVar.c(rsp.auth_status.get());
            cVar.g(rsp.show_tool_tips.get());
            cVar.f(rsp.auth_status.get() == 2);
            com.qzone.reborn.util.i.b().l("HAS_QUERY_JOB_BEFORE", true);
            com.qzone.reborn.util.i.b().l("WHETHER_HAS_MIGRATION_JOB", cVar.b());
            this.migrationData.postValue(cVar);
            return;
        }
        QLog.e("QZIntimateLoverSpaceMigrationViewModel", 1, "handleQueryJobRsp rsp error  isSuccess = " + isSuccess + " retCode = " + retCode + " errMsg = " + errMsg + " rsp = " + rsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(h this$0, String spaceId, BaseRequest baseRequest, boolean z16, long j3, String errMsg, qzoneMigration$GetSettingRsp qzonemigration_getsettingrsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(spaceId, "$spaceId");
        Intrinsics.checkNotNullParameter(baseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this$0.Q1(spaceId, z16, j3, errMsg, qzonemigration_getsettingrsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(h this$0, String spaceId, BaseRequest baseRequest, boolean z16, long j3, String errMsg, qzoneMigration$QueryJobRsp qzonemigration_queryjobrsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(spaceId, "$spaceId");
        Intrinsics.checkNotNullParameter(baseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this$0.R1(spaceId, z16, j3, errMsg, qzonemigration_queryjobrsp);
    }

    public final MutableLiveData<ij.c> O1() {
        return this.migrationData;
    }

    public final MutableLiveData<Boolean> P1() {
        return this.showSettingSyncEntrance;
    }

    public final void S1(final String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        sendRequest(new QZIntimateQueryMigrationSettingRequest(spaceId), new VSDispatchObserver.OnVSRspCallBack() { // from class: nk.g
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                h.T1(h.this, spaceId, baseRequest, z16, j3, str, (qzoneMigration$GetSettingRsp) obj);
            }
        });
    }

    public final void U1(final String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        sendRequest(new QZIntimateQueryMigrationJobRequest(spaceId), new VSDispatchObserver.OnVSRspCallBack() { // from class: nk.f
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                h.W1(h.this, spaceId, baseRequest, z16, j3, str, (qzoneMigration$QueryJobRsp) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZIntimateLoverSpaceMigrationViewModel";
    }

    private final void Q1(String spaceId, boolean isSuccess, long retCode, String errMsg, qzoneMigration$GetSettingRsp rsp) {
        if (isSuccess && rsp != null && retCode == 0) {
            QLog.i("QZIntimateLoverSpaceMigrationViewModel", 1, "space id is " + spaceId + ", show setting is " + rsp.show_setting.get());
            this.showSettingSyncEntrance.postValue(Boolean.valueOf(rsp.show_setting.get()));
            return;
        }
        QLog.e("QZIntimateLoverSpaceMigrationViewModel", 1, "handleGetSettingRsp rsp error  isSuccess = " + isSuccess + " retCode = " + retCode + " errMsg = " + errMsg + " rsp = " + rsp);
    }
}
