package com.tencent.mobileqq.vas.troopnick.shop.adapter;

import QC.UniBusinessCheckItem;
import QC.UniBusinessItem;
import QC.UniCheckReq;
import QC.UniCheckRsp;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J*\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/troopnick/shop/adapter/d;", "", "", "authType", "", "c", "appId", "itemId", VipFunCallConstants.KEY_FEET_TYPE, "Lcom/tencent/mobileqq/vas/troopnick/shop/adapter/a;", "listener", "", "e", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/troopnick/shop/adapter/d$a;", "", "", "itemId", "", "b", "Landroid/content/Context;", "context", "a", "AUTH_CMD", "Ljava/lang/String;", "AUTH_SERVANT_NAME", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.troopnick.shop.adapter.d$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mode", "common");
            jSONObject.put("businessType", "100");
            jSONObject.put("itemId", "403_b53acf98");
            jSONObject.put("buyNum", 1);
            jSONObject.put("sandbox", 0);
            jSONObject.put("aid", "mvip.g.a.qnc_20rx");
            jSONObject.put("baseUrl", "https://zb.vip.qq.com/v2");
            String jSONObject2 = jSONObject.toString();
            if (jSONObject2 == null) {
                jSONObject2 = "";
            }
            Intent intent = new Intent(context, (Class<?>) QQTranslucentBrowserActivity.class);
            intent.putExtra("url", "https://h5.vip.qq.com/p/pay/vippaylogic.html?vipPayLogicParams=" + jSONObject2);
            Bundle bundle = new Bundle();
            bundle.putBoolean(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
            bundle.putBoolean("hide_more_button", true);
            intent.putExtras(bundle);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }

        @JvmStatic
        public final void b(@NotNull String itemId) {
            String str;
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            try {
                String jSONObject = new JSONObject().put("aid", "mvip.g.a.qnc_20rx").put("payact_id", "").put("payrule_id", "403_b53acf98").toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject()\n           \u2026              .toString()");
                str = jSONObject;
            } catch (Exception e16) {
                QLog.e("TroopNickAuthRequest", 1, "buy. " + e16.getMessage());
                str = "";
            }
            MobileReportManager.getInstance().reportAction("DressVip", "3001146", "2", "", itemId, "", "4", 109, 0, 0, "", str, "");
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final void b(@NotNull Context context) {
        INSTANCE.a(context);
    }

    @JvmStatic
    public static final void d(@NotNull String str) {
        INSTANCE.b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(a aVar, int i3, boolean z16, Object obj) {
        boolean z17;
        if (aVar != null) {
            boolean z18 = false;
            if (obj instanceof UniCheckRsp) {
                UniCheckRsp uniCheckRsp = (UniCheckRsp) obj;
                ArrayList<UniBusinessCheckItem> arrayList = uniCheckRsp.uniBusinessItemList;
                if (arrayList != null && !arrayList.isEmpty()) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    if (uniCheckRsp.uniBusinessItemList.get(0).ret == 0) {
                        z18 = true;
                    }
                    aVar.a(z18, uniCheckRsp);
                    return;
                }
            }
            aVar.a(false, null);
        }
    }

    public boolean c(int authType) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        if (authType == 0 || authType == 1) {
            return true;
        }
        if (authType != 4) {
            if (authType != 5) {
                return false;
            }
            return VasUtil.getSignedService(qQAppInterface).getVipStatus().isSVip();
        }
        return VasUtil.getSignedService(qQAppInterface).getVipStatus().isVip();
    }

    public void e(int appId, int itemId, int feeType, @Nullable final a listener) {
        if (c(feeType) && listener != null) {
            listener.a(true, null);
            return;
        }
        IJce build = VasUtil.getService().getJceRequset().build("QC.UniBusinessLogicServer.UniBusinessLogicObj", "QCUniBusinessLogic.uniCheck", "stReq", "rsp");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UniBusinessItem(appId, itemId, ""));
        build.request("uniCheck", new UniCheckReq(IJce.Util.getLoginInfo(), arrayList), new UniCheckRsp(), new BusinessObserver() { // from class: com.tencent.mobileqq.vas.troopnick.shop.adapter.c
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                d.f(a.this, i3, z16, obj);
            }
        }, false);
    }
}
