package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\"\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\"\u0010\u0016\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J=\u0010\u0019\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J?\u0010\u001b\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n2\b\b\u0002\u0010\u001a\u001a\u00020\u0002H\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002JI\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016J \u0010 \u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/i;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "o", "u", "lbsBizId", "businessId", "businessScene", "t", "Landroid/content/Context;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "", "retCode", "l", "errMsg", "j", "Lcom/tencent/mobileqq/app/QBaseActivity;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "method", "call", "r", "<init>", "()V", "d", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class i extends i01.e {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/i$b", "Lcom/tencent/mobileqq/soso/location/LbsManagerServiceOnLocationChangeListener;", "", "errCode", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "info", "", "onLocationFinish", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f263000a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f263001b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, i iVar, Function1<Object, Unit> function1) {
            super(str, false);
            this.f263000a = iVar;
            this.f263001b = function1;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int errCode, SosoLbsInfo info) {
            SosoLocation sosoLocation;
            JSONObject jSONObject = new JSONObject();
            if (errCode == 0 && info != null && (sosoLocation = info.mLocation) != null) {
                try {
                    jSONObject.put("adcode", sosoLocation.cityCode);
                    jSONObject.put(QCircleSchemeAttr.Polymerize.LAT, String.valueOf(sosoLocation.mLat02));
                    jSONObject.put("lon", String.valueOf(sosoLocation.mLon02));
                    jSONObject.put("province", sosoLocation.province);
                    jSONObject.put("city", sosoLocation.city);
                    jSONObject.put("district", sosoLocation.district);
                    jSONObject.put("isSuccess", true);
                } catch (Throwable th5) {
                    QLog.e("QQKuiklyLocationModule", 2, th5, new Object[0]);
                    this.f263000a.j(this.f263001b, th5.toString());
                }
            }
            try {
                if (jSONObject.length() == 0 && this.f263000a.getActivity() != null) {
                    QQToast.makeText(this.f263000a.getActivity(), "\u83b7\u53d6\u4f4d\u7f6e\u4fe1\u606f\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
                }
                Function1<Object, Unit> function1 = this.f263001b;
                if (function1 != null) {
                    function1.invoke(jSONObject);
                }
            } catch (Throwable th6) {
                QLog.i("QQKuiklyLocationModule", 1, "ark.arkNotify", th6);
                this.f263000a.j(this.f263001b, th6.toString());
            }
            QLog.i("QQKuiklyLocationModule", 1, "errCode \uff1a" + errCode + ", jsonObject: " + jSONObject);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/i$c", "Lcom/tencent/mobileqq/soso/location/LbsManagerServiceOnLocationChangeListener;", "", "errCode", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "info", "", "onLocationFinish", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f263002a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f263003b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f263004c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, i iVar, String str2, String str3) {
            super(str, false);
            this.f263002a = iVar;
            this.f263003b = str2;
            this.f263004c = str3;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int errCode, SosoLbsInfo info) {
            String str;
            SosoLocation sosoLocation;
            SosoLocation sosoLocation2;
            SosoLocation sosoLocation3;
            JSONObject jSONObject = new JSONObject();
            if (errCode == 0 && info != null && (sosoLocation3 = info.mLocation) != null && (str = sosoLocation3.cityCode) != null) {
                Intrinsics.checkNotNullExpressionValue(str, "info.mLocation.cityCode");
                if (Math.abs(info.mLocation.mLat02) > 1.0E-6d && Math.abs(info.mLocation.mLon02) > 1.0E-6d) {
                    SosoLocation sosoLocation4 = info.mLocation;
                    double[] a16 = com.tencent.mobileqq.ark.util.g.a(sosoLocation4.mLon02, sosoLocation4.mLat02);
                    SosoLocation sosoLocation5 = info.mLocation;
                    sosoLocation5.mLat84 = a16[1];
                    sosoLocation5.mLon84 = a16[0];
                }
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                if (this.f263002a.getActivity() != null) {
                    QQToast.makeText(this.f263002a.getActivity(), "\u83b7\u53d6\u4f4d\u7f6e\u4fe1\u606f\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
                }
                jSONObject.put("adcode", str);
                jSONObject.put(QCircleSchemeAttr.Polymerize.LAT, "0");
                jSONObject.put("lon", "0");
                Context context = this.f263002a.getContext();
                if (context != null) {
                    com.tencent.kuikly.core.render.android.expand.module.l.e(context, "KuiklyLocationUpdateAdCode", jSONObject);
                    return;
                }
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                i iVar = this.f263002a;
                if (iVar.r(iVar.getActivity(), this.f263003b, this.f263004c)) {
                    try {
                        jSONObject.put("adcode", str);
                        Double d16 = null;
                        jSONObject.put(QCircleSchemeAttr.Polymerize.LAT, String.valueOf((info == null || (sosoLocation2 = info.mLocation) == null) ? null : Double.valueOf(sosoLocation2.mLat84)));
                        if (info != null && (sosoLocation = info.mLocation) != null) {
                            d16 = Double.valueOf(sosoLocation.mLon84);
                        }
                        jSONObject.put("lon", String.valueOf(d16));
                        Context context2 = this.f263002a.getContext();
                        if (context2 != null) {
                            com.tencent.kuikly.core.render.android.expand.module.l.e(context2, "KuiklyLocationUpdateAdCode", jSONObject);
                        }
                    } catch (Throwable th5) {
                        QLog.e("QQKuiklyLocationModule", 1, "send adcode to kuikly failed, errCode \uff1a" + errCode + ", exception : " + th5);
                    }
                }
            }
            QLog.i("QQKuiklyLocationModule", 1, "errCode \uff1a" + errCode + ", curAdCode: " + str);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016J\u001a\u0010\r\u001a\u00020\f2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/i$d", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "", "deniedPermissions", "", "isShowGuide", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f263006b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f263007c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f263008d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f263009e;

        d(Function1<Object, Unit> function1, String str, String str2, String str3) {
            this.f263006b = function1;
            this.f263007c = str;
            this.f263008d = str2;
            this.f263009e = str3;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public boolean isShowGuide(List<String> deniedPermissions) {
            return false;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            i.this.l(this.f263006b, 0);
            i iVar = i.this;
            String lbsBizId = this.f263007c;
            Intrinsics.checkNotNullExpressionValue(lbsBizId, "lbsBizId");
            String businessId = this.f263008d;
            Intrinsics.checkNotNullExpressionValue(businessId, "businessId");
            String businessScene = this.f263009e;
            Intrinsics.checkNotNullExpressionValue(businessScene, "businessScene");
            iVar.t(lbsBizId, businessId, businessScene);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            super.onDenied(permissions, results);
            i iVar = i.this;
            QBaseActivity m3 = iVar.m();
            String businessId = this.f263008d;
            Intrinsics.checkNotNullExpressionValue(businessId, "businessId");
            String businessScene = this.f263009e;
            Intrinsics.checkNotNullExpressionValue(businessScene, "businessScene");
            if (iVar.p(m3, businessId, businessScene)) {
                i.this.l(this.f263006b, 0);
            } else {
                i.this.l(this.f263006b, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(Function1<Object, Unit> callback, String errMsg) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isSuccess", false);
        jSONObject.put("errorMessage", errMsg);
        if (callback != null) {
            callback.invoke(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Function1<Object, Unit> callback, int retCode) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isSuccess", true);
        jSONObject.put("retCode", retCode);
        if (callback != null) {
            callback.invoke(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QBaseActivity m() {
        if (getActivity() != null && (getActivity() instanceof QBaseActivity)) {
            return (QBaseActivity) getActivity();
        }
        return null;
    }

    private final void o(String params, Function1<Object, Unit> callback) {
        QLog.d("QQKuiklyLocationModule", 1, "kuikly call getLatestAdCode");
        if (TextUtils.isEmpty(params)) {
            QLog.e("QQKuiklyLocationModule", 1, "kuikly call getLatestAdCode param empty");
        } else {
            ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new b(new JSONObject(params).optString("lbsBizId"), this, callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p(Context context, String businessId, String businessScene) {
        Activity activity = QBaseActivity.sTopActivity;
        if (context != null && (context instanceof Activity)) {
            activity = (Activity) context;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(businessId, businessScene));
        return qQPermission != null && qQPermission.hasPermission(businessId, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    private final boolean q(Context context, String businessId, String businessScene) {
        Activity activity = QBaseActivity.sTopActivity;
        if (context != null && (context instanceof Activity)) {
            activity = (Activity) context;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(businessId, businessScene));
        return qQPermission != null && qQPermission.hasPermission(businessId, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private final void u(String params, Function1<Object, Unit> callback) {
        QLog.d("QQKuiklyLocationModule", 1, "kuikly call requestLocationPermission");
        if (TextUtils.isEmpty(params)) {
            QLog.e("QQKuiklyLocationModule", 1, "kuikly call requestLocationPermission param empty");
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString("lbsBizId");
        String optString2 = jSONObject.optString("businessId");
        String optString3 = jSONObject.optString("businessScene");
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(optString2, optString3));
        if (qQPermission != null) {
            qQPermission.requestPermissions(QQPermissionConstants.Permission.GROUP_LOCATION, 2, new d(callback, optString, optString2, optString3));
        }
    }

    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "getLatestAdCode")) {
            o(params, callback);
        } else if (Intrinsics.areEqual(method, "requestLocationPermission")) {
            u(params, callback);
        }
        return Unit.INSTANCE;
    }

    public final boolean r(Context context, String businessId, String businessScene) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(businessScene, "businessScene");
        return q(context, businessId, businessScene) || p(context, businessId, businessScene);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(String lbsBizId, String businessId, String businessScene) {
        QLog.d("QQKuiklyLocationModule", 1, "call requestAdCode");
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new c(lbsBizId, this, businessId, businessScene));
    }
}
