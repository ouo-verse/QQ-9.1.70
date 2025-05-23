package com.tencent.biz.qqstory.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.aelight.camera.qqstory.api.IGategoryItemManager;
import com.tencent.aelight.camera.qqstory.api.IQIMBeautyManager;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.hippy.qq.module.QQBridgeModule;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.util.pm.PackageUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static String f94471a = "{\"appName\":\"\u5fae\u89c6\",\"appid\":\"1101083114 \",\"isAutoDownload\":\"1\",\"isAutoInstall\":\"1\",\"isAutoInstallBySDK\":1,\"isShowNotification\":\"1\",\"packageName\":\"com.tencent.weishi\",\"url\":\"https://qzs.qzone.qq.com/qzone/qzact/act/external/weishi/weishi-download/index.html?pkg=3006\",\"via\":\"ANDROIDQQ.FEED\"}";

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f94472a;

        /* renamed from: b, reason: collision with root package name */
        String f94473b;

        /* renamed from: c, reason: collision with root package name */
        String f94474c;

        /* renamed from: d, reason: collision with root package name */
        int f94475d;

        /* renamed from: e, reason: collision with root package name */
        public String f94476e;

        /* renamed from: f, reason: collision with root package name */
        String f94477f;

        /* renamed from: g, reason: collision with root package name */
        int f94478g;

        /* renamed from: h, reason: collision with root package name */
        public String f94479h;

        /* renamed from: i, reason: collision with root package name */
        public String f94480i;
    }

    private static DownloadInfo a(String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        DownloadInfo downloadInfo = new DownloadInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            downloadInfo.f341184e = jSONObject.getString("appid");
            downloadInfo.f341186f = jSONObject.getString("url");
            downloadInfo.f341189h = jSONObject.getString("packageName");
            downloadInfo.C = jSONObject.getString("via");
            downloadInfo.T = true;
            downloadInfo.f341183d0 = true;
            downloadInfo.Z = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;
            String string = jSONObject.getString("isAutoInstall");
            if (string != null) {
                downloadInfo.T = string.equals("1");
            }
            String string2 = jSONObject.getString(WadlResult.WEB_KEY_IS_AUTO_INSTALL_BY_SDK);
            if (string2 != null) {
                downloadInfo.f341183d0 = string2.equals("1");
            }
            String string3 = jSONObject.getString("isShowNotification");
            if (string3 != null) {
                if (string3.equals("1")) {
                    i3 = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;
                } else {
                    i3 = TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE;
                }
                downloadInfo.Z = i3;
            }
            downloadInfo.X = true;
            downloadInfo.M = "biz_src_jc_qzone";
            downloadInfo.f341191i = jSONObject.getString("appName");
            return downloadInfo;
        } catch (JSONException unused) {
            QLog.e("WeishiGuideUtils", 4, "json err:" + str);
            return null;
        }
    }

    public static void b(Context context, String str) {
        if (!e.b(context)) {
            QQToast.makeText(context, HardCodeUtil.qqStr(R.string.vkc), 0).show();
            return;
        }
        ((IQIMBeautyManager) QRoute.api(IQIMBeautyManager.class)).parseConfig();
        DownloadInfo a16 = a(f94471a);
        if (a16 == null) {
            hd0.c.t("WeishiGuideUtils", "get null info");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("gotoWeishiDownload", 2, " gotoWeishiDownload = " + a16.f341186f);
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", a16.f341186f);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("big_brother_source_key", str);
        }
        context.startActivity(intent);
    }

    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PackageUtil.getPackageInfo(context, QQBridgeModule.WEISHI_PAKG_NAME);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void d(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        if (TextUtils.isEmpty(str2) || str2.equals("no") || str2.equals("default")) {
            str2 = "weishi://main?goto=recommend&logsour=3006";
        }
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setData(Uri.parse(str2));
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("big_brother_source_key", str);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a e(Object obj) {
        String str;
        String str2;
        int i3;
        String str3;
        String str4;
        String str5 = "1";
        String str6 = "";
        String str7 = "5";
        String str8 = null;
        if (obj != null) {
            if (obj.getClass().getName().contains("QIMFilterCategoryItem")) {
                if (((IGategoryItemManager) QRoute.api(IGategoryItemManager.class)).isCombo(obj)) {
                    str4 = ((IGategoryItemManager) QRoute.api(IGategoryItemManager.class)).getItemName(obj);
                    String jumApp = ((IGategoryItemManager) QRoute.api(IGategoryItemManager.class)).getJumApp(obj);
                    str3 = "7";
                    str = "clk_combo";
                    str2 = jumApp;
                    i3 = 1;
                    str6 = "1";
                    str5 = "2";
                } else {
                    str4 = ((IGategoryItemManager) QRoute.api(IGategoryItemManager.class)).getItemName(obj);
                    str2 = ((IGategoryItemManager) QRoute.api(IGategoryItemManager.class)).getJumApp(obj);
                    str5 = "11";
                    i3 = 0;
                    str3 = str5;
                    str = "clk_filter";
                    str6 = str3;
                }
            } else if (obj instanceof MusicItemInfo) {
                MusicItemInfo musicItemInfo = (MusicItemInfo) obj;
                String str9 = musicItemInfo.mMusicName;
                String str10 = musicItemInfo.jumpWs;
                str5 = "4";
                str = "clk_music";
                str2 = str10;
                i3 = 2;
                str3 = "9";
                str4 = str9;
                str6 = "2";
            } else if (obj instanceof qs.f) {
                qs.f fVar = (qs.f) obj;
                String str11 = fVar.f429437e;
                String str12 = fVar.f429451s;
                str5 = "3";
                str = "clk_poster";
                str2 = str12;
                i3 = 3;
                str3 = "8";
                str4 = str11;
                str6 = "3";
            } else if (obj instanceof PressDarkImageButton) {
                str = "";
                str5 = "5";
                str2 = null;
                i3 = 0;
                str4 = str;
                str3 = str5;
            } else if (obj instanceof String) {
                str8 = (String) obj;
                str7 = "6";
            }
            if (StringUtil.isEmpty(str2)) {
                str2 = "weishi://camera?logsour=3006";
            }
            a aVar = new a();
            aVar.f94472a = str5;
            aVar.f94473b = str4;
            aVar.f94474c = str3;
            aVar.f94475d = 1;
            aVar.f94477f = str6;
            aVar.f94479h = str2;
            aVar.f94480i = str;
            aVar.f94478g = i3;
            aVar.f94476e = HardCodeUtil.qqStr(R.string.vka);
            return aVar;
        }
        str = "";
        str2 = str8;
        i3 = 0;
        str3 = str7;
        str4 = str;
        if (StringUtil.isEmpty(str2)) {
        }
        a aVar2 = new a();
        aVar2.f94472a = str5;
        aVar2.f94473b = str4;
        aVar2.f94474c = str3;
        aVar2.f94475d = 1;
        aVar2.f94477f = str6;
        aVar2.f94479h = str2;
        aVar2.f94480i = str;
        aVar2.f94478g = i3;
        aVar2.f94476e = HardCodeUtil.qqStr(R.string.vka);
        return aVar2;
    }

    public static void f(Object obj) {
        a e16 = e(obj);
        if (e16 == null) {
            return;
        }
        int i3 = e16.f94475d;
        int i16 = e16.f94478g;
        if (i3 == 1) {
            ReportController.o(null, "dc00898", "", "", "weishi_share_shoot", "story_entry_exp", i16, 0, "", "", "", "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.tencent.biz.qqstory.view.a g(Context context, Object obj, int i3) {
        int i16;
        String str;
        String str2;
        String str3;
        a e16 = e(obj);
        if (e16 == null) {
            return null;
        }
        String str4 = e16.f94472a;
        String str5 = e16.f94473b;
        String str6 = e16.f94479h;
        String str7 = e16.f94477f;
        int i17 = e16.f94478g;
        if (i3 == 2) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        if (!(context instanceof Activity)) {
            str = "";
        } else {
            Intent intent = ((Activity) context).getIntent();
            if (intent != null) {
                int intExtra = intent.getIntExtra("entrance_type", 0);
                if (intExtra == 1) {
                    str3 = "biz_src_jc_hyws";
                } else if (intExtra == 120 || intExtra == 121) {
                    str3 = "biz_src_jc_story";
                }
                if (i3 != 1) {
                    str3 = "biz_src_jc_camera";
                } else if (i3 == 2) {
                    str3 = "biz_src_jc_editor";
                }
                str = str3;
            }
            str3 = "";
            if (i3 != 1) {
            }
            str = str3;
        }
        if ("biz_src_jc_hyws".equals(str)) {
            if (c(context)) {
                str2 = "story_clk_ws";
            } else {
                str2 = "story_dl_ws";
            }
            ReportController.o(null, "dc00898", "", "", "weishi_share_shoot", str2, i17, 0, "", "", "", "");
        }
        ReportController.o(null, "dc00899", "grp_story", "", "weishi_share", e16.f94480i, 0, 0, str4, str5, "", "");
        if (c(context)) {
            ReportController.o(null, "dc00899", "grp_story", "", "app_share", "clk_entry", i16, 1, str7, "weishi", "", "");
            ReportController.o(null, "dc00899", "grp_story", "", "weishi_share", "clk_ws", 0, 1, str4, str5, "", "");
            if (context != null) {
                Intent intent2 = new Intent();
                intent2.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
                intent2.setData(Uri.parse(str6));
                if (!TextUtils.isEmpty(str)) {
                    intent2.putExtra("big_brother_source_key", str);
                }
                context.startActivity(intent2);
            }
            return null;
        }
        ReportController.o(null, "dc00899", "grp_story", "", "app_share", "clk_entry", i16, 0, str7, "weishi", "", "");
        String str8 = e16.f94474c;
        ReportController.o(null, "dc00899", "grp_story", "", "weishi_share", "clk_ws", 0, 2, str4, str5, "", "");
        com.tencent.biz.qqstory.view.a aVar = new com.tencent.biz.qqstory.view.a(context, R.style.f174380xf, str);
        aVar.O("https://pub.idqqimg.com/pc/misc/files/20180423/4c3ece054ae044eb85797d31fa487ce7.jpg");
        aVar.P("", str8, "");
        aVar.show();
        return aVar;
    }
}
