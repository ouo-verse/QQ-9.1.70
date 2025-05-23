package com.tencent.mobileqq.vashealth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.databaseengine.HeytapHealthApi;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.INsrApi;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.mobileqq.vashealth.hippy.HealthMainHippyFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class x {
    private static g43.c b() {
        g43.c cVar = (g43.c) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100502");
        if (cVar == null) {
            return new g43.c();
        }
        return cVar;
    }

    private static String c() {
        g43.e eVar = (g43.e) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("105893");
        if (eVar == null) {
            return "mqqapi://kuikly/open?page_name=QQSport&bundle_name=QQSportsKuikly&version=1&src_type=web";
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_QQ_sport_new_versio");
        if (expEntity.isExperiment("exp_QQ_sport_new_versio_A")) {
            return "mqqapi://kuikly/open?page_name=QQSport&bundle_name=QQSportsKuikly&version=1&src_type=web";
        }
        if (expEntity.isExperiment("exp_QQ_sport_new_versio_B")) {
            return eVar.getQqSportMainPageCompose();
        }
        if (!expEntity.isExperiment("exp_QQ_sport_new_versio_C")) {
            return "mqqapi://kuikly/open?page_name=QQSport&bundle_name=QQSportsKuikly&version=1&src_type=web";
        }
        return eVar.getQqSportMsgListPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(int i3, boolean z16, BaseQQAppInterface baseQQAppInterface, Context context, int i16, String str, ArrayList arrayList) {
        MsgRecord msgRecord;
        String str2;
        if (!arrayList.isEmpty()) {
            msgRecord = (MsgRecord) arrayList.get(0);
        } else {
            msgRecord = null;
        }
        f fVar = f.f312270a;
        String f16 = fVar.f(i3, fVar.g(msgRecord), z16);
        if (i3 == 161) {
            str2 = fVar.g(msgRecord);
        } else {
            str2 = "";
        }
        if (TextUtils.isEmpty(f16)) {
            QLog.e("VSHealthUtil", 1, "[redirectAIOToMainPage] error! targetJumpUrl is null!");
            return;
        }
        String d16 = fVar.d(msgRecord);
        fVar.k(baseQQAppInterface, String.valueOf(i3));
        i(context, f16, str2, d16);
    }

    public static void e(Context context, String str, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putString("bundleName", HippyQQConstants.ModuleName.QQ_SPORT);
        bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_ANIMATED, true);
        bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_CUSTOM_NIGHT_MODE, true);
        bundle.putString("domain", "yundong.qq.com");
        bundle.putInt(OpenHippyInfo.EXTRA_KEY_UPDATE_JS_BUNDLE_TYPE, 1);
        bundle.putString("srcUrl", str);
        bundle.putString("loadStartTime", String.valueOf(System.currentTimeMillis()));
        Intent intent = new Intent();
        intent.putExtra("params", bundle);
        intent.setFlags(268435456);
        intent.putExtra("public_fragment_window_feature", 1);
        g(context, intent, z16);
    }

    public static boolean f(final Context context, final BaseQQAppInterface baseQQAppInterface, final int i3, final boolean z16) {
        boolean z17;
        boolean z18;
        if (context != null && baseQQAppInterface != null) {
            ((IMsgService) QRoute.api(IMsgService.class)).getLatestDbMsgs(new Contact(1, "u_m9X3fOJ4pgkey0OEgpnXHQ", ""), 1, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.vashealth.w
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i16, String str, ArrayList arrayList) {
                    x.d(i3, z16, baseQQAppInterface, context, i16, str, arrayList);
                }
            });
            ((INsrApi) QRoute.api(INsrApi.class)).downloadImgRes("https://cdn-win.qq.com/public/test/2F36ABE6CBB6043B26739AC7402336BB.jpg");
            f.f312270a.b();
            return true;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[redirectAIOToMainPage] error! context: ");
        if (context == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        sb5.append(", app: ");
        if (baseQQAppInterface == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        sb5.append(z18);
        QLog.e("VSHealthUtil", 1, sb5.toString());
        return false;
    }

    private static void g(Context context, Intent intent, boolean z16) {
        if (z16) {
            QPublicFragmentActivity.start(context, intent, HealthMainHippyFragment.class);
        } else if (AppSetting.t(context)) {
            com.tencent.mobileqq.pad.i.e(context, intent.getExtras(), HealthMainHippyFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(true).h(LaunchMode.standard).a());
        } else {
            QPublicFragmentActivity.start(context, intent, HealthMainHippyFragment.class);
        }
    }

    public static void h(Context context, String str) {
        j(context, str, "", false, "");
    }

    public static void i(Context context, String str, String str2, String str3) {
        j(context, str, str2, false, str3);
    }

    public static void j(Context context, String str, String str2, boolean z16, String str3) {
        if (f.f312270a.j()) {
            n(context, str, str2, str3);
        } else {
            HeytapHealthApi.getInstance().dataApi();
            e(context, str, z16);
        }
    }

    public static void k(Context context, String str, boolean z16) {
        j(context, str, "", z16, "");
    }

    public static void l(Context context, HashMap<String, String> hashMap) {
        Bundle bundle = new Bundle();
        bundle.putString("bundleName", HippyQQConstants.ModuleName.QQ_SPORT);
        bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_ANIMATED, true);
        bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_CUSTOM_NIGHT_MODE, true);
        bundle.putString("domain", "yundong.qq.com");
        bundle.putInt(OpenHippyInfo.EXTRA_KEY_UPDATE_JS_BUNDLE_TYPE, 1);
        SerializableMap serializableMap = new SerializableMap();
        serializableMap.wrapMap(hashMap);
        bundle.putSerializable("qqHealthParams", serializableMap);
        bundle.putString("loadStartTime", String.valueOf(System.currentTimeMillis()));
        Intent intent = new Intent();
        intent.putExtra("params", bundle);
        intent.setFlags(268435456);
        intent.putExtra("public_fragment_window_feature", 1);
        g(context, intent, false);
    }

    public static void m(Context context, String str) {
        n(context, str, "", "");
    }

    public static void n(Context context, String str, String str2, String str3) {
        ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).startAsyncCardAdRequest(Arrays.asList("1082214467882419", "5015318293089789"), ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).isShowMaskAdForHealth(), "");
        StringBuilder sb5 = new StringBuilder(c());
        if (!TextUtils.isEmpty(str)) {
            try {
                String encode = URLEncoder.encode(str, "utf-8");
                sb5.append("&srcUrl=");
                sb5.append(encode);
                if (!TextUtils.isEmpty(str2)) {
                    String encode2 = URLEncoder.encode(str2, "utf-8");
                    sb5.append("&msg_src_url=");
                    sb5.append(encode2);
                }
                String encode3 = URLEncoder.encode(b().getMainPageUrl(), "utf-8");
                sb5.append("&error_url=");
                sb5.append(encode3);
                if (!TextUtils.isEmpty(str3)) {
                    String encode4 = URLEncoder.encode(str3, "utf-8");
                    sb5.append("&redpoint_ad_id=");
                    sb5.append(encode4);
                }
            } catch (UnsupportedEncodingException e16) {
                QLog.e("VSHealthUtil", 1, "startSportToKuikly encode url error:", e16);
            }
        }
        String sb6 = sb5.toString();
        QLog.d("VSHealthUtil", 1, "openKuiklySchema:", sb6);
        ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).jump(context, sb6);
        HeytapHealthApi.init(context);
    }
}
