package com.tencent.open.downloadnew.common;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.f;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f341481a = "com.tencent.open.download.start";

    /* renamed from: b, reason: collision with root package name */
    public static String f341482b = "com.tencent.open.download.pause";

    /* renamed from: c, reason: collision with root package name */
    public static String f341483c = "com.tencent.open.download.restart";

    /* renamed from: d, reason: collision with root package name */
    public static String f341484d = "com.tencent.open.download.complete";

    /* renamed from: e, reason: collision with root package name */
    public static String f341485e = "com.tencent.open.download.open";

    /* renamed from: f, reason: collision with root package name */
    public static String f341486f = "com.tencent.open.download.yyb";

    /* renamed from: g, reason: collision with root package name */
    public static ArrayList<String> f341487g;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f341487g = arrayList;
        arrayList.add(f341484d);
        f341487g.add(f341485e);
        f341487g.add(f341482b);
        f341487g.add(f341486f);
        f341487g.add(f341483c);
        f341487g.add(f341481a);
    }

    public static Intent a(Bundle bundle) {
        String str;
        Intent intent = new Intent();
        intent.putExtra("adapter_action", "action_push_app_detail");
        intent.setClassName("com.tencent.plugin.qappcenter", "com.tencent.open.appcenter.QZoneAppWebViewActivity");
        intent.putExtras(bundle);
        StringBuffer stringBuffer = new StringBuffer("sd://qapp_center_detail.htm?");
        for (String str2 : bundle.keySet()) {
            String string = bundle.getString(str2);
            stringBuffer.append(str2);
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(string);
            stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        }
        String[] h16 = Common.h(stringBuffer.toString());
        String str3 = h16[0];
        String str4 = "" + h16[1];
        String string2 = bundle.getString("from");
        intent.putExtra("uinRestore", com.tencent.open.adapter.a.f().l());
        intent.putExtra("APP_URL_NOTICE", str3);
        if (d(string2)) {
            str = c(bundle);
        } else {
            str = str4;
        }
        intent.putExtra("APP_PARAMS_NOTICE", str);
        f.e("IntentFactory", "params=" + str4 + "\n pushParams=" + c(bundle));
        if (bundle.containsKey("friendUin")) {
            intent.putExtra("friendUin", bundle.getString("friendUin"));
            intent.putExtra("isTroop", bundle.getInt("isTroop"));
        }
        intent.addFlags(603979776);
        return intent;
    }

    public static PendingIntent b(int i3, NoticeParam noticeParam) {
        Intent intent = new Intent();
        if (noticeParam != null) {
            intent.putExtra("noticeParam", noticeParam);
            intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, a.e().g(noticeParam.D, noticeParam.C, noticeParam.f341445d));
        }
        String m3 = Common.m();
        if (!TextUtils.isEmpty(m3)) {
            intent.putExtra("processName", m3);
        }
        String replace = m3.replace(":", ".");
        switch (i3) {
            case 1:
            case 3:
                intent.setAction(f341481a + "." + replace);
                break;
            case 2:
                intent.setAction(f341482b + "." + replace);
                break;
            case 4:
                intent.setAction(f341484d + "." + replace);
                break;
            case 5:
                intent.setAction(f341486f + "." + replace);
                break;
            case 6:
                intent.setAction(f341485e + "." + replace);
                break;
        }
        intent.setPackage(BaseApplication.getContext().getPackageName());
        return PendingIntent.getBroadcast(com.tencent.open.adapter.a.f().e(), (int) (System.currentTimeMillis() & 268435455), intent, 201326592);
    }

    protected static String c(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString("id");
        f.e("IntentFactory", "appId=" + string);
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        String string2 = bundle.getString("downloadUrl");
        String string3 = bundle.getString("packageName");
        String string4 = bundle.getString("serverApkVersion");
        if (string4 == null) {
            string4 = "0";
        }
        String string5 = bundle.getString("via");
        String string6 = bundle.getString("splitvia");
        String valueOf = String.valueOf(com.tencent.open.business.base.a.g(string3));
        int h16 = com.tencent.open.business.base.a.h(DownloadManager.C().v(string));
        boolean k3 = com.tencent.open.base.a.k(com.tencent.open.adapter.a.f().e());
        try {
            string2 = URLEncoder.encode(string2, "utf-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
        String str = "&from=-10&id=" + string + "&channelId=" + bundle.getString("from") + "&installedVersion=" + valueOf + "&localVersion=" + h16 + "&serverApkVersion=" + string4 + "&typeId=0&msgType=56&sendTime=" + string + "&downloadUrl=" + string2 + "&packageName=" + string3 + "&nt=" + (k3 ? 1 : 0);
        if (!TextUtils.isEmpty(string5)) {
            str = str + "&via=" + string5;
        }
        if (!TextUtils.isEmpty(string6)) {
            return str + "&splitvia=" + string6;
        }
        return str;
    }

    protected static boolean d(String str) {
        if (!"2457".equals(str) && !"2458".equals(str)) {
            return false;
        }
        return true;
    }
}
