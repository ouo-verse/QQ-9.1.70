package com.tencent.mobileqq.qrscan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.eqq.api.ICrmApi;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.activity.QRCardActivity;
import com.tencent.mobileqq.qrscan.activity.QRJumpActivity;
import com.tencent.mobileqq.qrscan.activity.ScannerActivity;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class r {
    static IPatchRedirector $redirector_;

    public static void a(AppRuntime appRuntime, Activity activity, String str, int i3) {
        Intent intent = new Intent(activity, (Class<?>) QRCardActivity.class);
        intent.putExtra("CARDMODE", i3);
        intent.putExtra("QRCARDSTR", str);
        activity.startActivity(intent);
    }

    public static void b(AppRuntime appRuntime, Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        StringBuilder sb5 = new StringBuilder(1024);
        sb5.append("https://qm.qq.com/cgi-bin/result");
        sb5.append("?p=a&v=");
        sb5.append(ah.P());
        sb5.append("&r=");
        sb5.append(URLEncoder.encode(str).replaceAll("\\+", "%20"));
        sb5.append("&_wv=1027");
        String sb6 = sb5.toString();
        intent.putExtra("title", activity.getString(R.string.f21712606));
        intent.putExtra("url", sb6);
        intent.putExtra("key_isReadModeEnabled", true);
        if (activity.getIntent().getBooleanExtra("fromPicQRDecode", false)) {
            activity.startActivityForResult(intent, 2);
        } else {
            activity.startActivity(intent);
        }
    }

    public static int c(AppRuntime appRuntime, Activity activity, m mVar, String str, Bundle bundle) {
        String str2;
        String str3;
        String str4;
        Uri parse;
        if (mVar != null && mVar.d() != 0) {
            try {
                int i3 = mVar.f276675c;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 6) {
                                if (i3 != 10) {
                                    b(appRuntime, activity, str);
                                    return 0;
                                }
                                f(appRuntime, activity, ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).getUin(mVar.c().c()), bundle);
                                return 10;
                            }
                            d(activity, mVar);
                            return mVar.f276675c;
                        }
                        f(appRuntime, activity, mVar.c().b() + "", bundle);
                        return 3;
                    }
                    String string = bundle.getString("authKey");
                    if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || !parse.isHierarchical()) {
                        str2 = "";
                        str3 = str2;
                    } else {
                        str3 = parse.getQueryParameter("jump_from");
                        str2 = parse.getQueryParameter("source_id");
                    }
                    if (TextUtils.isEmpty(str3)) {
                        str4 = bundle.getString("jump_from", "");
                    } else {
                        str4 = str3;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = bundle.getString("sourceId", "");
                    }
                    String string2 = bundle.getString("market_channel_source");
                    e(appRuntime, activity, mVar.c().b() + "", str4, str2, string, bundle.getString("authSig"), string2);
                    return 2;
                }
                g(appRuntime, activity, mVar.c().b() + "", bundle.getBoolean("issupportwpa", false), bundle.getInt(ReportConstant.COSTREPORT_PREFIX));
                return 1;
            } catch (Exception unused) {
                b(appRuntime, activity, str);
                return 0;
            }
        }
        b(appRuntime, activity, str);
        return 0;
    }

    private static void d(Context context, m mVar) throws Exception {
        AppRuntime waitAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
        ((ICrmApi) waitAppRuntime.getRuntimeService(ICrmApi.class, "")).gotoCrmMainProfile(context, null, String.valueOf(mVar.c().b()), false, 1, true, -1);
    }

    private static void e(AppRuntime appRuntime, Activity activity, String str, String str2, String str3, String str4, String str5, String str6) {
        Bundle bundle = new Bundle();
        bundle.putString(ISchemeApi.KEY_IOS_SRC_TYPE, "internal");
        bundle.putString("version", "1");
        bundle.putString("callback_type", ZPlanPublishSource.FROM_SCHEME);
        bundle.putString("callback_name", "open_card");
        bundle.putString("uin", str);
        bundle.putString("card_type", VipFunCallConstants.KEY_GROUP);
        bundle.putString("authKey", str4);
        bundle.putString("authSig", str5);
        bundle.putString("from", "qrcode");
        bundle.putString("market_channel_source", str6);
        if (!TextUtils.isEmpty(ax.L)) {
            bundle.putString("appid", ax.L);
        }
        if (!TextUtils.isEmpty(ax.M)) {
            bundle.putString("openid", h(ax.M));
        }
        ax.L = null;
        ax.M = null;
        if (StringUtil.isEmpty(str2)) {
            if (!(activity instanceof ScannerActivity)) {
                if (activity instanceof QRJumpActivity) {
                    if (!activity.getIntent().getBooleanExtra("fromQrcode", false)) {
                        str2 = "QRJumpActivity";
                    }
                }
            }
            str2 = "ScannerActivity";
        }
        if (!StringUtil.isEmpty(str3)) {
            bundle.putString("source_id", str3);
        }
        bundle.putString("jump_from", str2);
        ax c16 = bi.c((BaseQQAppInterface) appRuntime, activity, Uri.parse("mqqapi://card/show_pslcard?" + HttpUtil.encodeUrl(bundle)).toString());
        if (c16 != null) {
            c16.b();
        }
    }

    private static final void f(AppRuntime appRuntime, Activity activity, String str, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            String string = bundle.getString("extvalue");
            String string2 = bundle.getString("exttype");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                intent.putExtra("extvalue", string);
                intent.putExtra("exttype", string2);
            }
        }
        intent.putExtra("source", 1);
        AppInterface appInterface = (AppInterface) appRuntime;
        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).gotoProfile(intent, appInterface, activity, str, -1);
        ((IPublicAccountHandler) QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(appInterface, str, IPublicAccountHandler.MAIN_ACTION, "mp_msg_sys_1", "scan");
    }

    private static void g(AppRuntime appRuntime, Activity activity, String str, boolean z16, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString(ISchemeApi.KEY_IOS_SRC_TYPE, "internal");
        String str2 = "1";
        bundle.putString("version", "1");
        bundle.putString("callback_type", ZPlanPublishSource.FROM_SCHEME);
        bundle.putString("callback_name", "open_card");
        bundle.putString("uin", str);
        if (!z16) {
            str2 = "0";
        }
        bundle.putString("wpa", str2);
        bundle.putString(ReportConstant.COSTREPORT_PREFIX, i3 + "");
        ax c16 = bi.c((BaseQQAppInterface) appRuntime, activity, Uri.parse("mqqapi://card/show_pslcard?" + HttpUtil.encodeUrl(bundle)).toString());
        if (c16 != null) {
            c16.w();
            c16.b();
        }
    }

    private static String h(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        if (str.length() != 0) {
            try {
            } catch (Exception unused) {
                return null;
            }
        }
        return new String(PluginBaseInfoHelper.Base64Helper.decode(str, 0));
    }
}
