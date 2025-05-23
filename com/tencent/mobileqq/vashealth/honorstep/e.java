package com.tencent.mobileqq.vashealth.honorstep;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.hihonor.mcs.fitness.health.datastore.QueryRequest;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.mobileqq.vashealth.StepCounterPermissionUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vashealth/honorstep/e;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "", "f", "allowShowAuth", "i", "l", "Lcom/tencent/mobileqq/vashealth/huawei/b;", "huaweiCancelAuthorizationListener", "g", "", "b", "Ljava/lang/String;", "TAG", "c", "Landroid/content/Context;", "mContext", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f312286a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "HonorStepAuthManager";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final Context mContext = null;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vashealth/honorstep/e$a", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.vashealth.huawei.b f312289a;

        a(com.tencent.mobileqq.vashealth.huawei.b bVar) {
            this.f312289a = bVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException e16) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e16, "e");
            QLog.i(e.TAG, 1, "call failed", e16);
            this.f312289a.b();
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            try {
                QLog.i(e.TAG, 1, "cancelHonorPermission success " + response);
                if (response.code() == 200) {
                    this.f312289a.a();
                    StepCounterPermissionUtils.n(false);
                    g.f312292a.s();
                } else {
                    this.f312289a.b();
                }
            } catch (JSONException e16) {
                QLog.i(e.TAG, 1, "cancelHonorPermission failed " + e16);
            }
        }
    }

    e() {
    }

    private final boolean f(Context context) {
        boolean z16;
        MMKVOptionEntity from = QMMKV.from(context, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(context, HuaweiStepConstant.FILE_COMMON)");
        float decodeLong = (float) from.decodeLong("recent_request_qq_health_honor_permission_time", 0L);
        String str = TAG;
        QLog.d(str, 1, "allowHonorRequestAuthPopUp time " + decodeLong + "  " + System.currentTimeMillis());
        if (((float) System.currentTimeMillis()) - decodeLong > 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d(str, 1, "allowHonorRequestAuthPopUp: " + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(com.tencent.mobileqq.vashealth.huawei.b huaweiCancelAuthorizationListener) {
        Intrinsics.checkNotNullParameter(huaweiCancelAuthorizationListener, "$huaweiCancelAuthorizationListener");
        HttpRequest.f312280a.c().newCall(new Request.Builder().url("https://hnoauth-login.cloud.honor.com/oauth2/v3/revoke").post(new FormBody.Builder(null, 1, 0 == true ? 1 : 0).add("token", g.f312292a.e()).build()).build()).enqueue(new a(huaweiCancelAuthorizationListener));
    }

    private final void i(final boolean allowShowAuth) {
        n2.a.a(MobileQQ.sMobileQQ).a(g.f312292a.j(), new QueryRequest(204, SSOHttpUtils.d(), SSOHttpUtils.c())).b(new y2.b() { // from class: com.tencent.mobileqq.vashealth.honorstep.b
            @Override // y2.b
            public final void onSuccess(Object obj) {
                e.j((p2.b) obj);
            }
        }).a(new y2.a() { // from class: com.tencent.mobileqq.vashealth.honorstep.c
            @Override // y2.a
            public final void onFailure(Exception exc) {
                e.k(allowShowAuth, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(p2.b sampleDataQueryResponse) {
        Integer num;
        Intrinsics.checkNotNullParameter(sampleDataQueryResponse, "sampleDataQueryResponse");
        List a16 = sampleDataQueryResponse.a();
        if (a16 != null && (!a16.isEmpty())) {
            int i3 = 0;
            o2.d dVar = (o2.d) a16.get(0);
            if (dVar != null) {
                num = dVar.i("steps");
            } else {
                num = null;
            }
            if (num != null) {
                Integer i16 = dVar.i("steps");
                Intrinsics.checkNotNullExpressionValue(i16, "sampleData.getInteger(St\u2026ticField.FIELD_STEP_NAME)");
                i3 = i16.intValue();
            }
            QLog.d(TAG, 1, "getStepDailyData step " + i3);
            g gVar = g.f312292a;
            if (gVar.d()) {
                StepCounterPermissionUtils.n(true);
            }
            gVar.t(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(boolean z16, Exception e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        String str = TAG;
        QLog.e(str, 1, "getHealthAppAuthorization failed: " + e16);
        StepCounterPermissionUtils.n(false);
        if (z16) {
            e eVar = f312286a;
            if (eVar.f(mContext)) {
                QLog.d(str, 1, "getHealthAppAuth failed and requestAuth");
                eVar.m();
                return;
            }
        }
        g gVar = g.f312292a;
        if (gVar.c()) {
            gVar.f(gVar.l(), true);
        }
    }

    private final void m() {
        MMKVOptionEntity from = QMMKV.from(mContext, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(mContext, HuaweiStepConstant.FILE_COMMON)");
        from.encodeLong("recent_request_huawei_health_permission_time", System.currentTimeMillis());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vashealth.honorstep.d
            @Override // java.lang.Runnable
            public final void run() {
                e.n();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("action", "com.tencent.huawei.step.auth_action");
        intent.putExtra("paramsBundle", bundle);
        intent.addFlags(268435456);
        QLog.d(TAG, 1, "start requestAuth fragment");
        QPublicFragmentActivity.start(BaseApplication.getContext(), intent, HonorStepAuthFragment.class);
    }

    public final void g(@NotNull final com.tencent.mobileqq.vashealth.huawei.b huaweiCancelAuthorizationListener) {
        Intrinsics.checkNotNullParameter(huaweiCancelAuthorizationListener, "huaweiCancelAuthorizationListener");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vashealth.honorstep.a
            @Override // java.lang.Runnable
            public final void run() {
                e.h(com.tencent.mobileqq.vashealth.huawei.b.this);
            }
        }, 16, null, false);
    }

    public final void l(boolean allowShowAuth) {
        QLog.d(TAG, 1, "queryHonorSdkTodaySteps allowShowAuth: " + allowShowAuth);
        i(allowShowAuth);
    }
}
