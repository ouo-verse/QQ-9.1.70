package com.tencent.mobileqq.zootopia.lua;

import android.app.Activity;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\"\u0010\u000b\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/g;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "openRechargePanel", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "kotlin.jvm.PlatformType", "d", "Lmqq/util/WeakReference;", "activityRef", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g extends LuaBasePlugin {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<Activity> activityRef;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/g$a;", "", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "activityRef", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.lua.g$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/lua/g$a$a", "Lcom/tencent/mobileqq/vas/pay/api/IVasNativePayManager$PayObserver;", "", "onOpenPayViewFail", "onOpenPayViewSuccess", "onPaySuccess", "", "code", "onPayError", "onPayViewClose", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zootopia.lua.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes35.dex */
        public static final class C9113a implements IVasNativePayManager.PayObserver {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ LuaArgument f328552a;

            C9113a(LuaArgument luaArgument) {
                this.f328552a = luaArgument;
            }

            @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
            public void onOpenPayViewFail() {
                QLog.i("NativePayViewLuaPlugin", 1, "openRechargePanel, onOpenPayViewFail params:" + this.f328552a.getParams());
                this.f328552a.fail("openFail");
            }

            @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
            public void onOpenPayViewSuccess() {
                QLog.i("NativePayViewLuaPlugin", 1, "openRechargePanel, onOpenPayViewSuccess params:" + this.f328552a.getParams());
            }

            @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
            public void onPayError(int code) {
                QLog.i("NativePayViewLuaPlugin", 1, "openRechargePanel, onPayError params:" + this.f328552a.getParams());
            }

            @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
            public void onPaySuccess() {
                QLog.i("NativePayViewLuaPlugin", 1, "openRechargePanel, onPaySuccess params:" + this.f328552a.getParams());
                ar.f328509a.a("N2L_RechargeSucc", new JSONObject().toString());
            }

            @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
            public void onPayViewClose() {
                QLog.i("NativePayViewLuaPlugin", 1, "openRechargePanel, onPayViewClose params:" + this.f328552a.getParams());
                ar.f328509a.a("N2L_CloseRechargePanel", new JSONObject().toString());
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(LuaArgument argument, WeakReference<Activity> activityRef) {
            Intrinsics.checkNotNullParameter(argument, "argument");
            Intrinsics.checkNotNullParameter(activityRef, "activityRef");
            QLog.i("NativePayViewLuaPlugin", 1, "openRechargePanel, params:" + argument.getParams());
            Activity activity = activityRef.get();
            if (activity == null) {
                QLog.i("NativePayViewLuaPlugin", 1, "openRechargePanel, activity is null");
                return null;
            }
            JSONObject jSONObject = new JSONObject(argument.getParams());
            String optString = jSONObject.optString("title", "");
            String optString2 = jSONObject.optString("appName", "");
            int optInt = jSONObject.optInt("appId", 0);
            int optInt2 = jSONObject.optInt(WadlProxyConsts.SCENE_ID, 0);
            int optInt3 = jSONObject.optInt("sourceId", 0);
            String optString3 = jSONObject.optString("reportExt", "0_0_0_0");
            Object opt = jSONObject.opt("reportDic");
            Map<String, String> map = opt instanceof Map ? (Map) opt : null;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(optInt);
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(optInt2);
            String sb8 = sb7.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(optInt3);
            IVasNativePayManager.ReportData reportData = new IVasNativePayManager.ReportData(sb6, sb8, sb9.toString(), optString3);
            if (map != null) {
                reportData.mDtData = map;
            }
            ((IVasNativePayManager) QRoute.api(IVasNativePayManager.class)).initAndShowPayPanel(activity, optString, optString2, reportData, new C9113a(argument));
            return null;
        }

        Companion() {
        }
    }

    public g(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityRef = new WeakReference<>(activity);
    }

    @LuaEvent("L2N_OpenRechargePanel")
    public final String openRechargePanel(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        return INSTANCE.a(argument, this.activityRef);
    }
}
