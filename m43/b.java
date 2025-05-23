package m43;

import android.app.Activity;
import com.heytap.databaseengine.HeytapHealthApi;
import com.heytap.databaseengine.apiv2.HResponse;
import com.heytap.databaseengine.apiv2.auth.AuthResult;
import com.heytap.databaseengine.apiv3.DataReadRequest;
import com.heytap.databaseengine.apiv3.data.DataPoint;
import com.heytap.databaseengine.apiv3.data.DataSet;
import com.heytap.databaseengine.apiv3.data.DataType;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0011"}, d2 = {"Lm43/b;", "", "", "allowShowAuth", "", "f", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "j", "i", h.F, "Lcom/tencent/mobileqq/vashealth/huawei/b;", "huaweiCancelAuthorizationListener", "e", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f416141a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"m43/b$a", "Lcom/heytap/databaseengine/apiv2/HResponse;", "", "", "objectList", "", "a", "", "errorCode", "onFailure", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements HResponse<List<? extends Object>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.vashealth.huawei.b f416142a;

        a(com.tencent.mobileqq.vashealth.huawei.b bVar) {
            this.f416142a = bVar;
        }

        @Override // com.heytap.databaseengine.apiv2.HResponse
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable List<? extends Object> objectList) {
            QLog.d("OppoStepAuthManager", 1, "revoke access successfully");
            this.f416142a.a();
            m43.c.f416147a.f(false);
        }

        @Override // com.heytap.databaseengine.apiv2.HResponse
        public void onFailure(int errorCode) {
            QLog.d("OppoStepAuthManager", 1, "revoke access failed! Error code: " + errorCode);
            this.f416142a.b();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"m43/b$b", "Lcom/heytap/databaseengine/apiv2/HResponse;", "", "Lcom/heytap/databaseengine/apiv3/data/DataSet;", "dataSets", "", "a", "", "i", "onFailure", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: m43.b$b, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static final class C10763b implements HResponse<List<? extends DataSet>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f416143a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f416144b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f416145c;

        C10763b(long j3, long j16, boolean z16) {
            this.f416143a = j3;
            this.f416144b = j16;
            this.f416145c = z16;
        }

        @Override // com.heytap.databaseengine.apiv2.HResponse
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull List<? extends DataSet> dataSets) {
            Intrinsics.checkNotNullParameter(dataSets, "dataSets");
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            for (DataSet dataSet : dataSets) {
                QLog.e("OppoStepAuthManager", 1, "data " + dataSet);
                Intrinsics.checkNotNullExpressionValue(dataSet.getDataPoints(), "dataSet.dataPoints");
                if (!r6.isEmpty()) {
                    for (DataPoint dataPoint : dataSet.getDataPoints()) {
                        if (dataPoint.getStartTimeStamp() >= this.f416143a && dataPoint.getTimeStamp() <= this.f416144b) {
                            i3 += dataPoint.getValues()[0].asInt();
                            i16 += dataPoint.getValues()[1].asInt();
                            i17 += dataPoint.getValues()[2].asInt();
                        }
                    }
                    QLog.e("OppoStepAuthManager", 1, "step " + i3 + " dis " + i16 + "col " + i17);
                    m43.c.f416147a.g(i3);
                }
            }
            m43.c.f416147a.f(true);
        }

        @Override // com.heytap.databaseengine.apiv2.HResponse
        public void onFailure(int i3) {
            if (this.f416145c) {
                b bVar = b.f416141a;
                if (bVar.d()) {
                    QLog.d("OppoStepAuthManager", 1, "getHealthAppAuth failed and requestAuth");
                    bVar.i();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"m43/b$c", "Lcom/heytap/databaseengine/apiv2/HResponse;", "", "", "scopeList", "", "a", "", "errorCode", "onFailure", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements HResponse<List<? extends String>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f416146a;

        c(QBaseActivity qBaseActivity) {
            this.f416146a = qBaseActivity;
        }

        @Override // com.heytap.databaseengine.apiv2.HResponse
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull List<String> scopeList) {
            Intrinsics.checkNotNullParameter(scopeList, "scopeList");
            QLog.i("OppoStepAuthManager", 1, "Auth scope is " + scopeList);
            if (scopeList.isEmpty()) {
                m43.c.f416147a.f(false);
                b bVar = b.f416141a;
                QBaseActivity activity = this.f416146a;
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                bVar.j(activity);
                return;
            }
            m43.c.f416147a.f(true);
        }

        @Override // com.heytap.databaseengine.apiv2.HResponse
        public void onFailure(int errorCode) {
            QLog.e("OppoStepAuthManager", 1, "Auth valid failed! Error code: " + errorCode);
            m43.c.f416147a.f(false);
            b bVar = b.f416141a;
            QBaseActivity activity = this.f416146a;
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            bVar.j(activity);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"m43/b$d", "Lcom/heytap/databaseengine/apiv2/HResponse;", "Lcom/heytap/databaseengine/apiv2/auth/AuthResult;", "authResult", "", "a", "", "i", "onFailure", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements HResponse<AuthResult> {
        d() {
        }

        @Override // com.heytap.databaseengine.apiv2.HResponse
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull AuthResult authResult) {
            Intrinsics.checkNotNullParameter(authResult, "authResult");
            QLog.e("OppoStepAuthManager", 1, "request onSuccess " + authResult);
            m43.c.f416147a.f(true);
        }

        @Override // com.heytap.databaseengine.apiv2.HResponse
        public void onFailure(int i3) {
            QLog.e("OppoStepAuthManager", 1, "request fail " + i3);
            m43.c.f416147a.f(false);
        }
    }

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d() {
        boolean z16;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        float decodeLong = (float) from.decodeLong("recent_request_qq_health_honor_permission_time", 0L);
        QLog.d("OppoStepAuthManager", 1, "allowOppoRequestAuthPopUp time " + decodeLong + "  " + System.currentTimeMillis());
        if (((float) System.currentTimeMillis()) - decodeLong > 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("OppoStepAuthManager", 1, "allowOppoRequestAuthPopUp: " + z16);
        return z16;
    }

    private final void f(final boolean allowShowAuth) {
        ThreadManagerV2.excute(new Runnable() { // from class: m43.a
            @Override // java.lang.Runnable
            public final void run() {
                b.g(allowShowAuth);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(boolean z16) {
        long d16 = SSOHttpUtils.d();
        long currentTimeMillis = System.currentTimeMillis();
        DataReadRequest build = new DataReadRequest.Builder().read(DataType.TYPE_DAILY_ACTIVITY_COUNT).setTimeRange(currentTimeMillis - 1, currentTimeMillis).build();
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            QLog.e("OppoStepAuthManager", 1, "getHealthAppAuthorization null");
        } else {
            HeytapHealthApi.init(qBaseActivity);
            HeytapHealthApi.getInstance().dataApi().read(build, new C10763b(d16, currentTimeMillis, z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(Activity activity) {
        HeytapHealthApi.init(activity);
        HeytapHealthApi.getInstance().authorityApi().request(activity, new d());
    }

    public final void e(@NotNull com.tencent.mobileqq.vashealth.huawei.b huaweiCancelAuthorizationListener) {
        Intrinsics.checkNotNullParameter(huaweiCancelAuthorizationListener, "huaweiCancelAuthorizationListener");
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            QLog.e("OppoStepAuthManager", 1, "checkOppoPermission null");
        } else {
            HeytapHealthApi.init(topActivity);
            HeytapHealthApi.getInstance().authorityApi().revoke(new a(huaweiCancelAuthorizationListener));
        }
    }

    public final void h(boolean allowShowAuth) {
        QLog.d("OppoStepAuthManager", 1, "queryOppoSdkTodaySteps allowShowAuth: " + allowShowAuth);
        f(allowShowAuth);
    }

    public final void i() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            QLog.e("OppoStepAuthManager", 1, "requestOppoHealthPermission null");
        } else {
            HeytapHealthApi.init(qBaseActivity);
            HeytapHealthApi.getInstance().authorityApi().valid(new c(qBaseActivity));
        }
    }
}
