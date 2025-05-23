package com.tencent.open.appcommon;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.base.f;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.e;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.tmassistantbase.common.DownloadSDKConfigManager;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AppClient extends a {
    protected static String a(int i3, int i16, int i17, String str) {
        f.a("AppClient", "getFeedsChannelId >>> qzoneAppid = " + i3 + "| " + i16 + APLogFileUtil.SEPARATOR_LOG + i17);
        if (i3 == 352) {
            if (i16 != 1 && i16 != 3) {
                if (i16 == 7 || i16 == 8) {
                    if (i17 != 0 && i17 != 2) {
                        if (i17 != 1) {
                            return "";
                        }
                        return "200_2";
                    }
                    return "200_1";
                }
            } else {
                return "100_1";
            }
        }
        return "";
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("\\.");
        StringBuilder sb5 = new StringBuilder();
        if (split == null) {
            return "";
        }
        if (split.length <= 2) {
            return "";
        }
        for (int i3 = 2; i3 < split.length; i3++) {
            if (i3 == split.length - 1) {
                sb5.append(split[i3]);
            } else {
                sb5.append(split[i3] + ".");
            }
        }
        return sb5.toString();
    }

    public static Class c(String str) {
        try {
            Class.forName("com.tencent.open.appcenter.QZoneAppWebViewActivity");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (str.equals("detail") || str.equals("index")) {
            return QZoneAppListActivity.class;
        }
        str.equals(TPReportKeys.Common.COMMON_ONLINE);
        return QZoneAppListActivity.class;
    }

    public static void d(Activity activity, String str, String str2, String str3) {
        f(activity, str, str2, str3, "2460");
    }

    public static void e(Activity activity, String str, String str2, String str3) {
        f(activity, str, str2, str3, "2457");
    }

    protected static void f(Activity activity, String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        String str7;
        Activity activity2;
        String str8;
        f.e("AppClient", "shcemaUrlAnd:" + str);
        if (str == null || str.length() == 0) {
            return;
        }
        HashMap<String, String> z16 = Common.z(str);
        String str9 = z16.get("appid");
        String str10 = z16.get("sendtime");
        String str11 = z16.get("packname");
        String str12 = z16.get("packetversion");
        String str13 = z16.get(AppConstants.Key.COLUMN_MSG_TYPE);
        String str14 = z16.get("type");
        String str15 = z16.get("downurl");
        String str16 = z16.get("via");
        String b16 = b(str16);
        String str17 = z16.get("appCustom");
        String str18 = z16.get("nativepage");
        if (TextUtils.isEmpty(str18)) {
            str18 = z16.get("np");
        }
        String str19 = z16.get("htmlpage");
        if (TextUtils.isEmpty(str19)) {
            str19 = z16.get("hp");
        }
        String str20 = z16.get("subpagetype");
        if (TextUtils.isEmpty(str20)) {
            str20 = z16.get("sp");
        }
        String str21 = z16.get("pagetitles");
        if (TextUtils.isEmpty(str21)) {
            str21 = z16.get("pt");
        }
        String str22 = z16.get(e.f341494c);
        if (TextUtils.isEmpty(str22)) {
            str22 = z16.get("ta");
        }
        String str23 = str22;
        String str24 = z16.get(e.f341495d);
        if (TextUtils.isEmpty(str24)) {
            str24 = z16.get("tk");
        }
        String str25 = str24;
        String str26 = z16.get("minvercode");
        String str27 = z16.get("backurl");
        f.e("AppClient", "appid=" + str9 + " ,sendtime=" + str10 + " ,packname=" + str11 + " ,packetversion=" + str12 + " ,msgtype=" + str13 + " ,type=" + str14 + " ,downUrl=" + str15 + " ,nativePage=" + str18 + " ,htmlPage=" + str19 + " ,subPageType=" + str20 + " ,pageTitles=" + str21 + " ,minvercode=" + str26 + " ,backUrl=" + str27);
        int g16 = com.tencent.open.business.base.a.g(str11);
        int h16 = com.tencent.open.business.base.a.h(DownloadManager.C().v(str9));
        Bundle bundle = new Bundle();
        bundle.putString("installedVersion", String.valueOf(g16));
        bundle.putString("localVersion", String.valueOf(h16));
        bundle.putString("serverApkVersion", str12);
        bundle.putString("typeid", str14);
        bundle.putString(QQBrowserActivity.KEY_MSG_TYPE, str13);
        bundle.putString(RemoteMessageConst.SEND_TIME, str10);
        bundle.putString("subPageType", str20);
        bundle.putString("pageTitles", str21);
        bundle.putString("appCustom", str17);
        bundle.putString("schemaUrl", str);
        if (TextUtils.isEmpty(str16)) {
            str5 = str16;
        } else {
            str5 = str16;
            bundle.putString("via", str5);
            bundle.putString("splitvia", b16);
        }
        bundle.putString("uin", str2);
        bundle.putString("vkey", str3);
        bundle.putString(e.f341493b, str9);
        bundle.putString(e.f341494c, str23);
        bundle.putString(e.f341495d, str25);
        if (!TextUtils.isEmpty(str11)) {
            bundle.putString(e.f341497f, str11);
        }
        bundle.putString(e.f341496e, str12);
        try {
            str6 = str19;
            str7 = str26;
            try {
                com.tencent.open.adapter.a.f().s(Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
            }
        } catch (NumberFormatException unused2) {
            str6 = str19;
            str7 = str26;
        }
        com.tencent.open.adapter.a.f().r(str3);
        n(str4, str13, str9, str5);
        if ("2460".equals(str4)) {
            o(str2, str3, str9, str10);
            if (g16 > 0) {
                try {
                    str8 = URLDecoder.decode(str17, "UTF-8");
                    activity2 = activity;
                } catch (Exception unused3) {
                    activity2 = activity;
                    str8 = str17;
                }
                com.tencent.open.business.base.a.y(activity2, str9, str11, str8);
                return;
            }
        }
        if (TextUtils.isEmpty(str18)) {
            m(activity, str9, str4, bundle, "detail", "qapp_center_detail.htm");
            return;
        }
        if (str18.equals(JefsClass.SCHEME_YYB_PREFIX)) {
            if (TextUtils.isEmpty(str6)) {
                return;
            }
            int g17 = com.tencent.open.business.base.a.g(SDKConst.SELF_PACKAGENAME);
            if (!TextUtils.isEmpty(str7) && g17 > 0 && g17 >= Integer.valueOf(str7).intValue()) {
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str6));
                intent.setFlags(268435456);
                activity.startActivity(intent);
                return;
            } else {
                if (TextUtils.isEmpty(str27)) {
                    return;
                }
                m(activity, str9, str4, bundle, TPReportKeys.Common.COMMON_ONLINE, str27);
                return;
            }
        }
        if (str18.equals("detail")) {
            m(activity, str9, str4, bundle, "detail", "qapp_center_detail.htm");
        } else {
            m(activity, str9, str4, bundle, str18, str6);
        }
    }

    public static void g(Activity activity, final Bundle bundle) {
        int i3;
        int i16;
        int i17;
        boolean z16;
        String str;
        String str2;
        final String str3;
        String str4;
        final Bundle bundle2;
        String str5;
        String str6;
        final String str7;
        String str8;
        boolean z17;
        String[] split;
        Common.x();
        int i18 = bundle.getInt("qzoneAppid");
        int i19 = bundle.getInt("qzoneSubId");
        int i26 = bundle.getInt("op_type");
        int i27 = bundle.getInt("from");
        boolean z18 = bundle.getBoolean("is_can_open_yyb_native", true);
        String string = bundle.getString("schemaUrl");
        if (!TextUtils.isEmpty(string) && string.contains(ContainerUtils.FIELD_DELIMITER)) {
            Bundle bundle3 = new Bundle();
            if (string.startsWith("http://")) {
                try {
                    string = new URL(string).getQuery();
                } catch (MalformedURLException e16) {
                    e16.printStackTrace();
                }
            }
            HashMap<String, String> z19 = Common.z(string);
            str4 = z19.get("appid");
            if (TextUtils.isEmpty(str4)) {
                str4 = z19.get(e.f341493b);
            }
            String str9 = z19.get(e.f341494c);
            if (TextUtils.isEmpty(str9)) {
                str9 = z19.get("ta");
            }
            String str10 = z19.get(e.f341495d);
            if (TextUtils.isEmpty(str10)) {
                str10 = z19.get("tk");
            }
            str6 = z19.get(e.f341496e);
            str = ContainerUtils.FIELD_DELIMITER;
            str2 = z19.get("via");
            z16 = z18;
            str5 = z19.get("packName");
            if (TextUtils.isEmpty(str5)) {
                str5 = z19.get(e.f341497f);
            }
            i3 = i18;
            String str11 = z19.get(e.D);
            i16 = i19;
            StringBuilder sb5 = new StringBuilder();
            i17 = i27;
            sb5.append(" feedChannel:");
            sb5.append(str11);
            sb5.append("   schemaUrl:");
            sb5.append(string);
            f.i("AppClient", sb5.toString());
            String str12 = "";
            if (!TextUtils.isEmpty(str11) && !str11.startsWith("0;") && (split = str11.split(";")) != null && split.length > 0) {
                String str13 = split[0];
                if (!TextUtils.isEmpty(str13) && !str13.equals("0")) {
                    str12 = str13;
                }
            }
            f.i("AppClient", " finalFeedChannel:" + str12);
            if (!TextUtils.isEmpty(str5) && com.tencent.open.business.base.a.a(str5)) {
                String str14 = z19.get("appCustom");
                try {
                    str14 = URLDecoder.decode(str14, "UTF-8");
                } catch (Exception unused) {
                }
                com.tencent.open.business.base.a.y(com.tencent.open.adapter.a.f().e(), str4, str5, str14);
                return;
            }
            bundle3.putString(e.f341493b, str4);
            bundle3.putString(e.f341494c, str9);
            bundle3.putString(e.f341495d, str10);
            bundle3.putString(e.f341496e, str6);
            bundle3.putString(e.f341497f, str5);
            bundle3.putString(e.f341500i, str2);
            bundle3.putString(e.D, str12);
            bundle3.putString("schemaUrl", string);
            str3 = string;
            bundle2 = bundle3;
        } else {
            i3 = i18;
            i16 = i19;
            i17 = i27;
            z16 = z18;
            str = ContainerUtils.FIELD_DELIMITER;
            str2 = null;
            str3 = string;
            str4 = str3;
            bundle2 = null;
            str5 = null;
            str6 = "0";
        }
        if (i26 == 7) {
            int i28 = i3;
            int i29 = i16;
            int i36 = i17;
            String a16 = a(i28, i29, i36, str4);
            if (TextUtils.isEmpty(str2)) {
                str2 = com.tencent.open.business.base.e.b(i28, i29, i36);
            }
            com.tencent.open.business.viareport.c.a().e(String.valueOf(com.tencent.open.adapter.a.f().l()), str4, str2, "200", false);
            str7 = a16;
        } else {
            str7 = "2410";
        }
        if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str5) && !"0".equals(str6) && bundle2 != null && MyAppApi.z().n() && z16) {
            final String str15 = str4;
            final String str16 = str2;
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appcommon.AppClient.2
                @Override // java.lang.Runnable
                public void run() {
                    boolean z26;
                    String str17;
                    if (Common.z(bundle.getString("schemaUrl")).get(WadlProxyConsts.VIA_AUTO_DOWNLOAD) != null) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    if (!MyAppApi.z().n0(com.tencent.open.adapter.a.f().e(), bundle2, z26, false)) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(Common.s());
                        String str18 = File.separator;
                        sb6.append(str18);
                        sb6.append("qapp_center_detail.htm");
                        String sb7 = sb6.toString();
                        File file = new File(sb7);
                        if (!file.exists()) {
                            f.i("AppClient", "file" + sb7 + " not exist copyassets.");
                            com.tencent.open.base.c.d("Page/system", Common.t());
                        }
                        Intent intent = new Intent();
                        Bundle bundle4 = new Bundle();
                        if (file.exists()) {
                            str17 = "file:///" + sb7;
                        } else {
                            str17 = Common.e() + str18 + "qapp_center_detail.htm";
                        }
                        String str19 = "&from=-10&id=" + str15;
                        if (TextUtils.isEmpty(str3) || !str3.contains("channelId")) {
                            str19 = str19 + "&channelId=" + str7;
                        }
                        if (z26) {
                            str19 = str19 + "&auto_download=1";
                        }
                        if (!TextUtils.isEmpty(str3) && !str3.equals(str15)) {
                            str19 = str19 + ContainerUtils.FIELD_DELIMITER + str3;
                        }
                        intent.setClass(com.tencent.open.adapter.a.f().e(), QZoneAppListActivity.class);
                        if (DownloadSDKConfigManager.canGotoNewDetailPage(str16)) {
                            bundle4.putInt("goto_type", 7);
                        } else {
                            bundle4.putInt("goto_type", 3);
                        }
                        bundle4.putString("APP_URL", str17);
                        bundle4.putBoolean("FROM_FEED", true);
                        bundle4.putString("APP_PARAMS", str19);
                        if (bundle.getInt(CrashHianalyticsData.PROCESS_ID) == 2) {
                            bundle4.putInt(CrashHianalyticsData.PROCESS_ID, 2);
                        }
                        f.e("Jie", "APP_URL:" + str17 + " |  PARAMS >>> " + bundle4.getString("APP_PARAMS"));
                        intent.putExtras(bundle4);
                        intent.putExtra("adapter_action", "action_app_detail");
                        intent.addFlags(872415232);
                        com.tencent.open.adapter.a.f().e().startActivity(intent);
                    }
                }
            });
            return;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append(Common.s());
        String str17 = File.separator;
        sb6.append(str17);
        sb6.append("qapp_center_detail.htm");
        String sb7 = sb6.toString();
        File file = new File(sb7);
        if (!file.exists()) {
            f.i("AppClient", "file" + sb7 + " not exist copyassets.");
            com.tencent.open.base.c.d("Page/system", Common.t());
        }
        Intent intent = new Intent();
        Bundle bundle4 = new Bundle();
        if (file.exists()) {
            str8 = "file:///" + sb7;
        } else {
            str8 = Common.e() + str17 + "qapp_center_detail.htm";
        }
        String str18 = "&from=-10&id=" + str4 + "&channelId=" + str7;
        if (!TextUtils.isEmpty(str3) && !str3.equals(str4)) {
            str18 = str18 + str + str3;
        }
        if (Common.z(bundle.getString("schemaUrl")).get(WadlProxyConsts.VIA_AUTO_DOWNLOAD) != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && !str18.contains(WadlProxyConsts.VIA_AUTO_DOWNLOAD)) {
            str18 = str18 + "&auto_download=1";
        }
        intent.setClass(com.tencent.open.adapter.a.f().e(), QZoneAppListActivity.class);
        bundle4.putString("APP_URL", str8);
        bundle4.putBoolean("FROM_FEED", true);
        bundle4.putString("APP_PARAMS", str18);
        if (DownloadSDKConfigManager.canGotoNewDetailPage(str2)) {
            bundle4.putInt("goto_type", 7);
        } else {
            bundle4.putInt("goto_type", 2);
        }
        if (bundle.getInt(CrashHianalyticsData.PROCESS_ID) == 2) {
            bundle4.putInt(CrashHianalyticsData.PROCESS_ID, 2);
        }
        f.e("Jie", "APP_URL:" + str8 + " |  PARAMS >>> " + bundle4.getString("APP_PARAMS"));
        intent.putExtras(bundle4);
        intent.putExtra("adapter_action", "action_app_detail");
        intent.addFlags(872415232);
        com.tencent.open.adapter.a.f().e().startActivity(intent);
    }

    public static void h(Activity activity, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("schemaUrl", str);
        g(activity, bundle);
    }

    public static void i(Activity activity, String str, int i3, int i16, int i17) {
        Bundle bundle = new Bundle();
        bundle.putString("schemaUrl", str);
        bundle.putInt("qzoneAppid", i3);
        bundle.putInt("qzoneSubId", i16);
        bundle.putInt("from", i17);
        g(activity, bundle);
    }

    public static void j(Activity activity, String str, int i3, Bundle bundle) {
        String str2;
        String str3;
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(Common.s());
        String str4 = File.separator;
        sb5.append(str4);
        sb5.append("qapp_center_detail.htm");
        String sb6 = sb5.toString();
        Common.x();
        File file = new File(sb6);
        if (!file.exists()) {
            f.i("AppClient", "file" + sb6 + " not exist copyassets.");
            com.tencent.open.base.c.d("Page/system", Common.t());
        }
        Intent intent = new Intent();
        Bundle bundle2 = new Bundle();
        if (file.exists()) {
            str2 = "file:///" + sb6;
        } else {
            str2 = Common.e() + str4 + "qapp_center_detail.htm";
        }
        intent.setClass(com.tencent.open.adapter.a.f().e(), QZoneAppListActivity.class);
        String str5 = "&from=-10&id=" + str + "&channelId=" + i3;
        if (bundle != null) {
            str3 = bundle.getString("via");
        } else {
            str3 = null;
        }
        if (DownloadSDKConfigManager.canGotoNewDetailPage(str3)) {
            bundle2.putInt("goto_type", 7);
        } else {
            bundle2.putInt("goto_type", 3);
        }
        if (!TextUtils.isEmpty(str3)) {
            str5 = str5 + "&via=" + str3;
        }
        if (bundle != null) {
            z16 = bundle.getBoolean(VirtualAppProxy.KEY_AUTO_DOWNLOAD);
            String string = bundle.getString("packageName");
            if (!TextUtils.isEmpty(string)) {
                str5 = str5 + "&packageName=" + string;
            }
            String string2 = bundle.getString("subpagetype");
            if (!TextUtils.isEmpty(string2)) {
                str5 = str5 + "&subpagetype=" + string2;
            }
        } else {
            z16 = false;
        }
        if (z16) {
            str5 = str5 + "&msgType=56";
        }
        bundle2.putString("APP_PARAMS", str5);
        if (bundle != null) {
            bundle2.putString("uin", bundle.getString("uin"));
            bundle2.putString("sid", bundle.getString("vkey"));
        }
        bundle2.putString("APP_URL", str2);
        bundle2.putBoolean("FROM_FEED", true);
        f.e("Jie", "APP_URL:" + str2 + " |  PARAMS >>> " + bundle2.getString("APP_PARAMS"));
        intent.putExtras(bundle2);
        intent.putExtra("adapter_action", "action_app_detail");
        intent.addFlags(603979776);
        activity.startActivityForResult(intent, 200);
    }

    public static void k(Context context, String str, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putInt(CrashHianalyticsData.PROCESS_ID, 2);
        bundle.putString("schemaUrl", str);
        bundle.putBoolean("is_can_open_yyb_native", z16);
        if (context instanceof Activity) {
            g((Activity) context, bundle);
        } else {
            g(null, bundle);
        }
    }

    public static void l(final Activity activity, Bundle bundle) {
        final String string = bundle.getString("packageName");
        final String string2 = bundle.getString("appId");
        final boolean z16 = bundle.getBoolean(VirtualAppProxy.KEY_AUTO_DOWNLOAD);
        final String string3 = bundle.getString("big_brother_source_key");
        com.tencent.open.business.base.e.d("200", "ANDROIDQQ.SHARESOURCE", string2);
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.appcommon.AppClient.3
            @Override // java.lang.Runnable
            public void run() {
                MyAppApi.z();
                if (MyAppApi.G()) {
                    final Bundle bundle2 = new Bundle();
                    String str = e.f341493b;
                    String str2 = string2;
                    if (str2 == null) {
                        str2 = "";
                    }
                    bundle2.putString(str, str2);
                    bundle2.putString(e.f341494c, "");
                    bundle2.putString(e.f341495d, "");
                    bundle2.putString(e.f341497f, string);
                    bundle2.putInt(e.f341496e, 0);
                    bundle2.putString(e.f341500i, "ANDROIDQQ.SHARESOURCE");
                    bundle2.putString("big_brother_source_key", string3);
                    ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appcommon.AppClient.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MyAppApi.z().n0(activity.getApplicationContext(), bundle2, z16, false);
                        }
                    });
                    return;
                }
                Bundle bundle3 = new Bundle();
                bundle3.putString("uin", "");
                bundle3.putString("sid", "");
                bundle3.putString("via", "ANDROIDQQ.SHARESOURCE");
                bundle3.putBoolean(VirtualAppProxy.KEY_AUTO_DOWNLOAD, false);
                bundle3.putString("packageName", string);
                bundle3.putString("subpagetype", "SHARESOURCE");
                AppClient.j(activity, string2, 2462, bundle3);
            }
        });
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:1|(5:3|(1:5)|6|(1:8)(1:81)|9)(1:82)|10|(1:12)|13|(1:15)|16|(1:18)|19|(1:21)|22|(1:24)|25|(1:27)|28|(1:30)(2:78|(1:80))|31|(3:34|35|(11:37|(1:39)(1:74)|40|41|42|43|44|45|46|47|(2:65|66)(2:51|(2:53|(2:61|62)(2:58|59))(2:63|64))))|77|44|45|46|47|(1:49)|65|66|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x02ed, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x02ee, code lost:
    
        r0.printStackTrace();
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static void m(final Activity activity, final String str, String str2, final Bundle bundle, String str3, String str4) {
        String str5;
        boolean z16;
        String str6;
        Class<?> cls;
        String string;
        boolean z17;
        String str7;
        String str8 = str2;
        Common.x();
        if (!str3.equals(TPReportKeys.Common.COMMON_ONLINE)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(Common.s());
            String str9 = File.separator;
            sb5.append(str9);
            sb5.append(str4);
            String sb6 = sb5.toString();
            File file = new File(sb6);
            if (!file.exists()) {
                f.i("AppClient", "file" + sb6 + " not exist copyassets.");
                com.tencent.open.base.c.d("Page/system", Common.t());
            }
            if (file.exists()) {
                str7 = "file:///" + sb6;
                z16 = true;
            } else {
                str7 = Common.e() + str9 + "qapp_center_detail.htm";
                z16 = false;
            }
            str5 = str7;
        } else {
            str5 = str4;
            z16 = true;
        }
        final Intent intent = new Intent();
        final Bundle bundle2 = new Bundle();
        Class<?> c16 = c(str3);
        intent.setClass(activity, c16);
        String string2 = bundle.getString("installedVersion");
        String string3 = bundle.getString("localVersion");
        String string4 = bundle.getString("typeid");
        String string5 = bundle.getString("serverApkVersion");
        String string6 = bundle.getString(QQBrowserActivity.KEY_MSG_TYPE);
        String string7 = bundle.getString(RemoteMessageConst.SEND_TIME);
        final String string8 = bundle.getString("via");
        String string9 = bundle.getString("splitvia");
        String string10 = bundle.getString("subPageType");
        boolean z18 = z16;
        String string11 = bundle.getString("appCustom");
        if (str8 == "2460") {
            str8 = str8 + "_" + string6;
        }
        String str10 = str8;
        StringBuilder sb7 = new StringBuilder();
        String str11 = str5;
        sb7.append("&from=-10&id=");
        sb7.append(str);
        sb7.append("&channelId=");
        sb7.append(str10);
        sb7.append("&installedVersion=");
        sb7.append(string2);
        sb7.append("&localVersion=");
        sb7.append(string3);
        sb7.append("&serverApkVersion=");
        sb7.append(string5);
        sb7.append("&typeId=");
        sb7.append(string4);
        sb7.append("&msgType=");
        sb7.append(string6);
        sb7.append("&sendTime=");
        sb7.append(string7);
        String sb8 = sb7.toString();
        String string12 = bundle.getString("schemaUrl");
        if (!TextUtils.isEmpty(string10)) {
            sb8 = sb8 + "&subPageType=" + string10;
        }
        if (!TextUtils.isEmpty(string8)) {
            sb8 = sb8 + "&via=" + string8;
        }
        if (!TextUtils.isEmpty(string9)) {
            sb8 = sb8 + "&splitVia=" + string9;
        }
        if (!TextUtils.isEmpty(string11)) {
            sb8 = sb8 + "&appCustom=" + string11;
        }
        if (!TextUtils.isEmpty(string12)) {
            sb8 = sb8 + ContainerUtils.FIELD_DELIMITER + string12;
        }
        bundle2.putString("APP_PARAMS", sb8);
        bundle2.putString("uin", bundle.getString("uin"));
        bundle2.putString("sid", bundle.getString("vkey"));
        bundle2.putString("APP_URL", str11);
        bundle2.putBoolean("FROM_FEED", true);
        bundle2.putString(e.f341500i, string8);
        if ("detail".equals(str3)) {
            bundle2.putInt("goto_type", 2);
        } else if ("index".equals(str3)) {
            bundle2.putInt("goto_type", 1);
        }
        if (str3.equals("custom") && z18) {
            try {
                string = bundle.getString("pageTitles");
            } catch (Exception e16) {
                e = e16;
                str6 = "AppClient";
            }
            if (!TextUtils.isEmpty(string)) {
                ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(string.split(ContainerUtils.FIELD_DELIMITER)));
                bundle2.putStringArrayList("titleName", arrayList);
                if (arrayList.size() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                bundle2.putBoolean("showTitle", z17);
                str6 = "AppClient";
                try {
                    f.e(str6, "titles = " + arrayList);
                } catch (Exception e17) {
                    e = e17;
                    f.d(str6, "get push title error>>>", e);
                    f.e("TAG", "APP_URL:" + str11 + " |  PARAMS >>> " + bundle2.getString("APP_PARAMS"));
                    intent.putExtras(bundle2);
                    intent.putExtra("adapter_action", "action_app_detail");
                    intent.addFlags(603979776);
                    cls = Class.forName("com.tencent.open.appcenter.QZoneAppWebViewActivity");
                    if (cls == null) {
                    }
                    activity.startActivityForResult(intent, 200);
                }
                f.e("TAG", "APP_URL:" + str11 + " |  PARAMS >>> " + bundle2.getString("APP_PARAMS"));
                intent.putExtras(bundle2);
                intent.putExtra("adapter_action", "action_app_detail");
                intent.addFlags(603979776);
                cls = Class.forName("com.tencent.open.appcenter.QZoneAppWebViewActivity");
                if (cls == null && c16.getName().equals(cls.getName())) {
                    if (str10.equals("2457")) {
                        DownloadInfo w3 = DownloadManager.C().w(str);
                        if (MyAppApi.z().n() && w3 != null && w3.J == 1) {
                            f.i(str6, ">>>appid=" + w3.f341184e + " myAppid=" + w3.G);
                            bundle2.putString(e.f341493b, w3.f341184e);
                            bundle2.putString(e.f341494c, w3.G);
                            bundle2.putString(e.f341495d, w3.H);
                            bundle2.putString(e.f341500i, string8);
                            bundle2.putString(e.f341497f, w3.f341189h);
                            bundle2.putInt(e.f341496e, w3.I);
                            MyAppApi.z().n0(activity, bundle2, str10.equals("2457"), true);
                            return;
                        }
                        activity.startActivityForResult(intent, 200);
                        return;
                    }
                    ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appcommon.AppClient.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MyAppApi.z().n()) {
                                DownloadInfo w16 = DownloadManager.C().w(str);
                                if (w16 != null) {
                                    if (w16.J == 1) {
                                        bundle2.putString(e.f341493b, w16.f341184e);
                                        bundle2.putString(e.f341494c, w16.G);
                                        bundle2.putString(e.f341495d, w16.H);
                                        bundle2.putString(e.f341500i, string8);
                                        bundle2.putString(e.f341497f, w16.f341189h);
                                        bundle2.putInt(e.f341496e, w16.I);
                                        MyAppApi.z().n0(activity, bundle2, false, false);
                                        return;
                                    }
                                    activity.startActivityForResult(intent, 200);
                                    return;
                                }
                                Bundle bundle3 = bundle;
                                if (bundle3 != null && bundle3.containsKey(e.f341497f)) {
                                    bundle2.putAll(bundle);
                                    MyAppApi.z().n0(activity, bundle2, false, false);
                                    return;
                                } else {
                                    activity.startActivityForResult(intent, 200);
                                    return;
                                }
                            }
                            activity.startActivityForResult(intent, 200);
                        }
                    });
                    return;
                }
                activity.startActivityForResult(intent, 200);
            }
        }
        str6 = "AppClient";
        f.e("TAG", "APP_URL:" + str11 + " |  PARAMS >>> " + bundle2.getString("APP_PARAMS"));
        intent.putExtras(bundle2);
        intent.putExtra("adapter_action", "action_app_detail");
        intent.addFlags(603979776);
        cls = Class.forName("com.tencent.open.appcenter.QZoneAppWebViewActivity");
        if (cls == null) {
        }
        activity.startActivityForResult(intent, 200);
    }

    protected static void n(String str, String str2, String str3, String str4) {
        String str5;
        if ("2457".equals(str)) {
            if (TextUtils.isEmpty(str4)) {
                str5 = "ANDROIDQQ.PCPUSH.AIOMSG";
            } else {
                str5 = str4;
            }
            com.tencent.open.business.base.e.d("200", str5, str3);
        }
        if ("2460".equals(str)) {
            try {
                String a16 = com.tencent.open.business.base.e.a(Integer.parseInt(str2));
                if (TextUtils.isEmpty(str4)) {
                    str4 = a16;
                }
                com.tencent.open.business.base.e.d("200", str4, str3);
            } catch (NumberFormatException unused) {
            }
        }
    }

    protected static void o(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("huin", str);
        bundle.putString("keytype", "256");
        bundle.putString("keystr", str2);
        bundle.putString("appid", str3);
        bundle.putString("platform", com.tencent.open.adapter.a.f().h());
        bundle.putString("requestkeys", str4);
        bundle.putString("mode", "1");
        bundle.putString("v", com.tencent.open.adapter.a.f().b());
        new HttpCgiAsyncTask("https://appic.qq.com/cgi-bin/appstage/mapp_setrequest.cgi", "GET", null).execute(bundle);
    }
}
