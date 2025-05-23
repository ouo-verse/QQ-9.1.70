package com.tencent.open.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.f;
import com.tencent.open.business.base.e;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.common.NoticeParam;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenAppClient {

    /* renamed from: a, reason: collision with root package name */
    public static final String f339508a = "com.tencent.open.adapter.OpenAppClient";

    /* renamed from: b, reason: collision with root package name */
    protected static boolean f339509b = false;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    protected static class GetVkeyRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        protected Activity f339512d;

        /* renamed from: e, reason: collision with root package name */
        protected int f339513e;

        /* renamed from: f, reason: collision with root package name */
        protected String f339514f;

        /* renamed from: h, reason: collision with root package name */
        protected AppRuntime f339515h;

        public GetVkeyRunnable(AppRuntime appRuntime, int i3, String str) {
            this.f339515h = appRuntime;
            this.f339513e = i3;
            this.f339514f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppRuntime appRuntime;
            String str;
            if (!com.tencent.open.base.a.a(a.f().e()) || (appRuntime = this.f339515h) == null) {
                return;
            }
            String skey = ((TicketManager) appRuntime.getManager(2)).getSkey(this.f339515h.getAccount());
            AppRuntime appRuntime2 = this.f339515h;
            if (appRuntime2 instanceof QQAppInterface) {
                str = ((QQAppInterface) appRuntime2).getCurrentAccountUin();
            } else if (appRuntime2 instanceof BrowserAppInterface) {
                str = ((BrowserAppInterface) appRuntime2).getAccount();
            } else {
                str = null;
            }
            if (str != null && !str.equals(String.valueOf(a.f().l()))) {
                try {
                    a.f().s(Long.parseLong(str));
                } catch (Exception e16) {
                    f.d(OpenAppClient.f339508a, "GetVkeyRunnable setUin exception. uin=[" + str + "]", e16);
                }
            }
            if (!TextUtils.isEmpty(skey)) {
                f.e(OpenAppClient.f339508a, "Get skey success");
                a.f().r(skey);
            }
            OpenAppClient.f339509b = false;
            int i3 = this.f339513e;
            if (i3 != 1) {
                if (i3 == 2) {
                    AppClient.d(this.f339512d, this.f339514f, str, skey);
                    return;
                }
                return;
            }
            AppClient.e(this.f339512d, this.f339514f, str, skey);
        }
    }

    protected static boolean a(final Context context, final HashMap<String, String> hashMap) {
        int i3;
        if (hashMap != null && hashMap.size() != 0) {
            try {
                i3 = Integer.parseInt(hashMap.get("isauto"));
            } catch (NumberFormatException e16) {
                f.b(f339508a, "onPcPushMsgForground>>>", e16);
                i3 = -1;
            }
            if (i3 == 1) {
                try {
                    if (DownloadApi.j(hashMap.get("appid"))) {
                        return false;
                    }
                    ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.adapter.OpenAppClient.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                OpenAppClient.d(context, hashMap);
                            } catch (Exception e17) {
                                f.d(OpenAppClient.f339508a, "onPushMsg exception: " + hashMap, e17);
                            }
                        }
                    });
                    return true;
                } catch (Exception e17) {
                    f.d(f339508a, "onPushMsg exception: " + hashMap, e17);
                }
            }
        }
        return false;
    }

    public static void b(AppInterface appInterface, int i3) {
        String str;
        rp3.a.b(a.f().e());
        if (appInterface != null) {
            if (appInterface instanceof QQAppInterface) {
                str = ((QQAppInterface) appInterface).getAccount();
            } else if (!(appInterface instanceof BrowserAppInterface)) {
                str = "";
            } else {
                String account = ((BrowserAppInterface) appInterface).getAccount();
                HashMap hashMap = new HashMap();
                hashMap.put("method_name", "OpenAppClient#initUserData");
                hashMap.put("trace", String.valueOf(i3));
                QQBeaconReport.report(account, "OpenGetSkey", hashMap);
                ThreadManagerV2.executeOnNetWorkThread(new GetVkeyRunnable(appInterface, 0, ""));
                str = account;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    a.f().s(Long.valueOf(str).longValue());
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void c(Context context, String str) {
        f.e(f339508a, "onPcPushMsgForground " + str);
        if (com.tencent.open.base.a.k(context)) {
            a(context, Common.z(str));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static void d(Context context, HashMap<String, String> hashMap) throws Exception {
        String str;
        int i3;
        int i16;
        int i17;
        String[] split;
        String str2;
        boolean z16;
        String str3 = f339508a;
        f.e(str3, "onPushDownloadMsg " + hashMap);
        String str4 = hashMap.get("appid");
        String str5 = hashMap.get("packname");
        String str6 = hashMap.get("packetversion");
        String str7 = hashMap.get("downurl");
        String str8 = hashMap.get("via");
        String str9 = hashMap.get("appname");
        if (TextUtils.isEmpty(str9)) {
            str = "";
        } else {
            str = str9;
        }
        String str10 = "_" + str4;
        String v3 = DownloadManager.C().v(str4);
        int i18 = -1;
        if (com.tencent.open.business.base.a.g(str5) > 0) {
            i3 = com.tencent.open.business.base.a.g(str5);
        } else {
            i3 = -1;
        }
        if (com.tencent.open.business.base.a.h(v3) > 0) {
            i18 = com.tencent.open.business.base.a.h(v3);
        }
        f.h(str3, "installedApkVer = " + i3 + " downloadedApkVer = " + i18 + " serverApkVer = " + i18);
        try {
            i16 = Integer.valueOf(str6).intValue();
        } catch (NumberFormatException unused) {
            f.c(f339508a, "onPushMsg versionCode exception versionCode: " + str6);
            i16 = 0;
        }
        int i19 = 1;
        StringBuilder sb5 = null;
        if (!TextUtils.isEmpty(str8)) {
            try {
                split = str8.split("\\.");
            } catch (Exception e16) {
                e = e16;
                i17 = 1;
            }
            if (split != null && split.length >= 2) {
                StringBuilder sb6 = new StringBuilder();
                int i26 = 0;
                while (i26 < split.length) {
                    try {
                        if (i26 != i19) {
                            try {
                                sb6.append(split[i26]);
                            } catch (Exception e17) {
                                e = e17;
                                sb5 = sb6;
                                i17 = 1;
                                f.d(f339508a, "viaSB >>>", e);
                                if (sb5 != null) {
                                }
                                NoticeParam noticeParam = new NoticeParam();
                                noticeParam.f341445d = str4;
                                noticeParam.f341446e = str;
                                noticeParam.f341448h = str5;
                                noticeParam.D = str10;
                                Bundle bundle = new Bundle();
                                bundle.putString("id", str4);
                                bundle.putString("via", str2);
                                bundle.putString("downloadUrl", str7);
                                bundle.putString("packageName", str5);
                                bundle.putString("channelId", "2400");
                                if (i16 <= i3) {
                                }
                            }
                        } else {
                            try {
                                sb6.append(split[i26]);
                                sb6.append(".");
                                sb6.append("AUTO");
                            } catch (Exception e18) {
                                e = e18;
                                i17 = 1;
                                sb5 = sb6;
                                f.d(f339508a, "viaSB >>>", e);
                                if (sb5 != null) {
                                }
                                NoticeParam noticeParam2 = new NoticeParam();
                                noticeParam2.f341445d = str4;
                                noticeParam2.f341446e = str;
                                noticeParam2.f341448h = str5;
                                noticeParam2.D = str10;
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("id", str4);
                                bundle2.putString("via", str2);
                                bundle2.putString("downloadUrl", str7);
                                bundle2.putString("packageName", str5);
                                bundle2.putString("channelId", "2400");
                                if (i16 <= i3) {
                                }
                            }
                        }
                        i17 = 1;
                        if (i26 != split.length - 1) {
                            try {
                                sb6.append(".");
                            } catch (Exception e19) {
                                e = e19;
                                sb5 = sb6;
                                f.d(f339508a, "viaSB >>>", e);
                                if (sb5 != null) {
                                }
                                NoticeParam noticeParam22 = new NoticeParam();
                                noticeParam22.f341445d = str4;
                                noticeParam22.f341446e = str;
                                noticeParam22.f341448h = str5;
                                noticeParam22.D = str10;
                                Bundle bundle22 = new Bundle();
                                bundle22.putString("id", str4);
                                bundle22.putString("via", str2);
                                bundle22.putString("downloadUrl", str7);
                                bundle22.putString("packageName", str5);
                                bundle22.putString("channelId", "2400");
                                if (i16 <= i3) {
                                }
                            }
                        }
                        i26++;
                        i19 = 1;
                    } catch (Exception e26) {
                        e = e26;
                        i17 = i19;
                    }
                }
                i17 = i19;
                sb5 = sb6;
                if (sb5 != null) {
                    str2 = sb5.toString();
                } else {
                    str2 = str8;
                }
                NoticeParam noticeParam222 = new NoticeParam();
                noticeParam222.f341445d = str4;
                noticeParam222.f341446e = str;
                noticeParam222.f341448h = str5;
                noticeParam222.D = str10;
                Bundle bundle222 = new Bundle();
                bundle222.putString("id", str4);
                bundle222.putString("via", str2);
                bundle222.putString("downloadUrl", str7);
                bundle222.putString("packageName", str5);
                bundle222.putString("channelId", "2400");
                if (i16 <= i3) {
                    e.d("100", "ANDROIDQQ.PCPUSH.AUTO.NEWTIPS", str4);
                    noticeParam222.C = 2;
                    noticeParam222.f341449i = str7;
                    noticeParam222.F = com.tencent.open.downloadnew.common.c.a(bundle222);
                    com.tencent.open.downloadnew.common.a.e().k(noticeParam222);
                    return;
                }
                if (i16 <= i18) {
                    e.d("100", "ANDROIDQQ.PCPUSH.AUTO.DOWNLOADED", str4);
                    noticeParam222.C = 3;
                    noticeParam222.f341449i = str7;
                    noticeParam222.F = com.tencent.open.downloadnew.common.c.a(bundle222);
                    com.tencent.open.downloadnew.common.a.e().k(noticeParam222);
                    String v16 = DownloadManager.C().v(str4);
                    String z17 = DownloadManager.C().z(str4);
                    if (com.tencent.open.business.base.a.e(v16) == null || com.tencent.open.business.base.a.p(context, v16, z17)) {
                        f.c(f339508a, "AUTO push and AUTO install failed!!!");
                        return;
                    }
                    return;
                }
                if (DownloadManager.C().w(str4) != null) {
                    e.d("100", "ANDROIDQQ.PCPUSH.AUTO.DOWNLOADING", str4);
                }
                Intent a16 = com.tencent.open.downloadnew.common.c.a(bundle222);
                if (str5 != null && !str5.trim().equals("")) {
                    z16 = i17;
                } else {
                    z16 = 0;
                }
                DownloadManager.C().d0(new DownloadInfo(str4, str7.trim(), str5, str, str2, a16, "biz_src_yyb", z16));
                return;
            }
        }
        i17 = 1;
        if (sb5 != null) {
        }
        NoticeParam noticeParam2222 = new NoticeParam();
        noticeParam2222.f341445d = str4;
        noticeParam2222.f341446e = str;
        noticeParam2222.f341448h = str5;
        noticeParam2222.D = str10;
        Bundle bundle2222 = new Bundle();
        bundle2222.putString("id", str4);
        bundle2222.putString("via", str2);
        bundle2222.putString("downloadUrl", str7);
        bundle2222.putString("packageName", str5);
        bundle2222.putString("channelId", "2400");
        if (i16 <= i3) {
        }
    }
}
