package com.tencent.mobileqq.zplan.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.ZPlanAppInterface;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.ttpic.openapi.filter.LightConstants;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.panorama.util.PanoramaConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0012\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0002J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0016\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u001a\u0010 \u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u001f\u0018\u00010\u001eJ\u0006\u0010!\u001a\u00020\u0017J\f\u0010\"\u001a\u00020\u0017*\u0004\u0018\u00010\u0002J\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\fR\u0013\u0010(\u001a\u0004\u0018\u00010%8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u0013\u0010,\u001a\u0004\u0018\u00010)8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010+R\u0013\u0010/\u001a\u0004\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b-\u0010.R\u0013\u00102\u001a\u0004\u0018\u00010\u00028F\u00a2\u0006\u0006\u001a\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/bb;", "", "", "gender", "theme", tl.h.F, "Lcom/tencent/mobileqq/app/QQAppInterface;", "j", "Landroid/content/Context;", "context", "Landroid/app/Activity;", "b", "", "designerPx", "screenWidth", "a", "uin", "k", "o", "", "g", "status", "i", "", "r", "enterResult", "", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "", "Lkotlin/Pair;", "f", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "businessId", ReportConstant.COSTREPORT_PREFIX, "Lmqq/app/AppRuntime;", "d", "()Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/common/app/AppInterface;", "c", "()Lcom/tencent/common/app/AppInterface;", "appInterface", "l", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "qqApp", "e", "()Ljava/lang/String;", PanoramaConfig.KEY_CURRENT_UIN, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class bb {

    /* renamed from: a, reason: collision with root package name */
    public static final bb f335811a = new bb();

    bb() {
    }

    private final String h(String gender, String theme) {
        if (Intrinsics.areEqual(gender, LightConstants.MALE)) {
            if (Intrinsics.areEqual(theme, MiniAppConst.MENU_STYLE_LIGHT)) {
                return "https://zplan.gtimg.cn/avatar/static/day-mode-male2.png";
            }
            return "https://zplan.gtimg.cn/avatar/static/night-mode-male2.png";
        }
        if (Intrinsics.areEqual(theme, MiniAppConst.MENU_STYLE_LIGHT)) {
            return "https://zplan.gtimg.cn/avatar/static/day-mode-female2.png";
        }
        return "https://zplan.gtimg.cn/avatar/static/night-mode-female2.png";
    }

    public final int a(Context context, int designerPx, int screenWidth) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (designerPx * context.getResources().getDisplayMetrics().widthPixels) / screenWidth;
    }

    public final Activity b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof Activity) {
            return (Activity) context;
        }
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                QLog.d("ZPlanUtil", 1, "get activity ==>" + context + " ");
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(context, "ctx.baseContext");
        }
        return null;
    }

    public final AppInterface c() {
        AppRuntime d16 = d();
        if (d16 != null && (d16 instanceof AppInterface)) {
            return (AppInterface) d16;
        }
        return null;
    }

    public final AppRuntime d() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface ? true : peekAppRuntime instanceof ZPlanAppInterface) {
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            return (AppInterface) peekAppRuntime;
        }
        if (peekAppRuntime instanceof ToolAppRuntime) {
            return peekAppRuntime.getAppRuntime("modular_web");
        }
        if (peekAppRuntime instanceof ToolRuntimePeak) {
            return peekAppRuntime.getAppRuntime("peak");
        }
        return peekAppRuntime instanceof VideoAppInterface ? peekAppRuntime.getAppRuntime("module_video") : peekAppRuntime;
    }

    public final String e() {
        AppRuntime d16 = d();
        if (d16 != null) {
            return d16.getCurrentUin();
        }
        return null;
    }

    public final List<Pair<String, Long>> f() {
        String j16 = ZPlanFeatureSwitch.f369852a.j1();
        QLog.i("ZPlanUtil", 1, "getEasterEggPortraitWrongAppearanceInfo, config: " + j16);
        if (j16 == null || j16.length() == 0) {
            QLog.w("ZPlanUtil", 1, "getEasterEggPortraitWrongAppearanceInfo failed, toggle config null.");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new JSONObject(j16).optJSONArray("info");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj = optJSONArray.get(i3);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject jSONObject = (JSONObject) obj;
                    arrayList.add(new Pair(jSONObject.optString("appearanceKey"), Long.valueOf(jSONObject.optLong("errorTimeStamp"))));
                }
            }
            return arrayList;
        } catch (Exception e16) {
            QLog.e("ZPlanUtil", 1, "getEasterEggPortraitWrongAppearanceInfo failed.", e16);
            return null;
        }
    }

    public final long g(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (r(uin)) {
            AppRuntime d16 = d();
            IOnlineStatusService iOnlineStatusService = d16 != null ? (IOnlineStatusService) d16.getRuntimeService(IOnlineStatusService.class, "") : null;
            if (iOnlineStatusService != null) {
                return iOnlineStatusService.getExtOnlineStatus();
            }
            return ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getSelfExtOnlineStatus(d());
        }
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        if (uid == null || uid.length() == 0) {
            return -1L;
        }
        IOnlineStatusInfoService iOnlineStatusInfoService = (IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = iOnlineStatusInfoService.getOnlineStatusSimpleInfoWithUid(uid, "ZPlanUtil");
        if (onlineStatusSimpleInfoWithUid != null) {
            return onlineStatusSimpleInfoWithUid.e0();
        }
        return -1L;
    }

    public final QQAppInterface j() {
        AppRuntime runtime;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application == null || (runtime = application.getRuntime()) == null || !(runtime instanceof QQAppInterface)) {
            return null;
        }
        return (QQAppInterface) runtime;
    }

    public final int k(String uin) {
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = iFriendsInfoService.getFriendsSimpleInfoWithUid(uid, "ZPlanUtil");
        Integer valueOf = friendsSimpleInfoWithUid != null ? Integer.valueOf(friendsSimpleInfoWithUid.v()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            return 0;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            return 1;
        }
        return (valueOf != null && valueOf.intValue() == 2) ? 2 : 0;
    }

    public final QQAppInterface l() {
        AppRuntime d16 = d();
        if (d16 != null && (d16 instanceof QQAppInterface)) {
            return (QQAppInterface) d16;
        }
        return null;
    }

    public final String m(String gender, String theme) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(theme, "theme");
        String n3 = n(gender, theme);
        if (!(n3 == null || n3.length() == 0)) {
            return n3;
        }
        QLog.e("ZPlanUtil", 1, "getStaticDefaultAvatarUrl for gender: " + gender + " theme:" + theme + " failed, try origin url.");
        return h(gender, theme);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String n(String gender, String theme) {
        String str;
        JSONObject optJSONObject;
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(theme, "theme");
        String H2 = ZPlanFeatureSwitch.f369852a.H2();
        boolean z16 = true;
        QLog.i("ZPlanUtil", 1, "getStaticDefaultConfigUrl for QZone, config: " + H2);
        if (H2.length() == 0) {
            QLog.w("ZPlanUtil", 1, "getStaticDefaultConfigUrl failed, toggle config invalid.");
            return null;
        }
        try {
            optJSONObject = new JSONObject(H2).optJSONObject(gender);
        } catch (Exception e16) {
            QLog.e("ZPlanUtil", 1, e16, new Object[0]);
        }
        if (optJSONObject != null) {
            str = optJSONObject.optString(theme);
            QLog.i("ZPlanUtil", 1, "getStaticDefaultConfigUrl done, gender: " + gender + ", theme:" + theme + ", defaultUrl:" + str);
            if (str != null && str.length() != 0) {
                z16 = false;
            }
            if (z16) {
                return str;
            }
            return null;
        }
        str = null;
        QLog.i("ZPlanUtil", 1, "getStaticDefaultConfigUrl done, gender: " + gender + ", theme:" + theme + ", defaultUrl:" + str);
        if (str != null) {
            z16 = false;
        }
        if (z16) {
        }
    }

    public final boolean p() {
        return ImmersiveUtils.getScreenWidth() >= 1092;
    }

    public final boolean r(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime d16 = d();
        return Intrinsics.areEqual(d16 != null ? d16.getCurrentUin() : null, uin);
    }

    public final void s(int businessId) {
        HashMap hashMap = new HashMap();
        hashMap.put("businessId", String.valueOf(businessId));
        t74.r.e(null, "zplan_create_dynamic_avatar_manager", hashMap, 1, null);
    }

    public final void t(boolean enterResult, Context context) {
        if (QLog.isColorLevel()) {
            QLog.i("ZPlanUtil", 2, "sendEnterResultBroadcast result: " + enterResult);
        }
        Intent intent = new Intent("tencent.video.q2v.ACTION_ENTER_SMALL_HOME");
        intent.putExtra("enter_result", enterResult);
        if (context != null) {
            context.sendBroadcast(intent);
        }
    }

    public final int o(String uin) {
        if (uin == null || uin.length() == 0) {
            return 0;
        }
        return ZplanDataRepository.f334898a.j(uin, true ^ t74.h.b()).gender;
    }

    public final boolean q(String str) {
        boolean startsWith$default;
        boolean startsWith$default2;
        if (!(str == null || str.length() == 0)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "http", false, 2, null);
            if (startsWith$default) {
                return true;
            }
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str, "https", false, 2, null);
            if (startsWith$default2) {
                return true;
            }
        }
        return false;
    }

    public final int i(long status) {
        if (status <= 0) {
            QZLog.i("ZPlanUtil", 2, "get portrait id by status failed, not extStatus.");
            return -1;
        }
        String D2 = ZPlanFeatureSwitch.f369852a.D2();
        QZLog.i("ZPlanUtil", 1, "getPortraiIdByOnlineStatus config:" + D2);
        if (TextUtils.isEmpty(D2)) {
            return -1;
        }
        try {
            JSONObject jSONObject = new JSONObject(D2);
            int optInt = jSONObject.optInt(String.valueOf(status), -1);
            return optInt != -1 ? optInt : jSONObject.optInt("default", -1);
        } catch (JSONException e16) {
            QZLog.w("ZPlanUtil", 1, "parse config error", e16);
            return -1;
        }
    }
}
