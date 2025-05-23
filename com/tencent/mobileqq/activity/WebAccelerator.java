package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.jakewharton.disklrucache.DiskLruCache;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.k;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.util.URLUtil;
import common.config.service.QzoneConfig;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WebAccelerator {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    static final Pattern f177624j;

    /* renamed from: k, reason: collision with root package name */
    private static WebAccelerator f177625k;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f177626l;

    /* renamed from: m, reason: collision with root package name */
    public static int f177627m;

    /* renamed from: n, reason: collision with root package name */
    public static boolean f177628n;

    /* renamed from: a, reason: collision with root package name */
    private int f177629a;

    /* renamed from: b, reason: collision with root package name */
    private int f177630b;

    /* renamed from: c, reason: collision with root package name */
    private Set<String> f177631c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f177632d;

    /* renamed from: e, reason: collision with root package name */
    private long f177633e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f177634f;

    /* renamed from: g, reason: collision with root package name */
    private DiskLruCache f177635g;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, Long> f177636h;

    /* renamed from: i, reason: collision with root package name */
    private int f177637i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67625);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        f177624j = Pattern.compile(com.tencent.mobileqq.utils.cg.f307525d.pattern());
        f177625k = null;
        f177626l = true;
        f177627m = -1;
        f177628n = false;
    }

    public WebAccelerator() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f177629a = 15;
        this.f177630b = 10;
        this.f177631c = null;
        this.f177632d = new byte[0];
        this.f177633e = 86400000L;
        this.f177634f = true;
        this.f177635g = null;
        this.f177636h = null;
        this.f177637i = 0;
        if (!f177626l) {
            return;
        }
        com.tencent.mobileqq.troop.soso.b.c().g();
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_gifplay.name());
        if (QLog.isColorLevel()) {
            QLog.d("WebAccelerator", 2, "DPC:" + featureValue);
        }
        try {
            if (!TextUtils.isEmpty(featureValue)) {
                String[] split = featureValue.split("\\|");
                if (split.length > 5) {
                    try {
                        this.f177637i = Integer.parseInt(split[4]);
                        this.f177633e = Integer.parseInt(split[5]) * 1000 * 60 * 60;
                        if (split.length > 6) {
                            this.f177630b = Integer.parseInt(split[6]);
                        }
                        if (this.f177630b > 30) {
                            this.f177630b = 10;
                        }
                        z16 = true;
                    } catch (Exception unused) {
                        this.f177634f = false;
                        if (QLog.isColorLevel()) {
                            QLog.d("WebAccelerator", 2, "WebAccelerator init fail");
                        }
                    }
                    if (!z16 && QLog.isColorLevel()) {
                        StringBuilder P = com.tencent.mobileqq.activity.aio.l.P();
                        P.append("DPC not catch success[");
                        P.append(featureValue);
                        P.append("]");
                        QLog.d("WebAccelerator", 2, P.toString());
                    }
                    this.f177631c = new HashSet();
                    this.f177636h = new HashMap();
                    this.f177635g = DiskLruCache.open(((QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getApp().getCacheDir(), 1, 1, 1048576L);
                    return;
                }
            }
            this.f177635g = DiskLruCache.open(((QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getApp().getCacheDir(), 1, 1, 1048576L);
            return;
        } catch (Exception unused2) {
            this.f177634f = false;
            if (QLog.isColorLevel()) {
                QLog.d("WebAccelerator", 2, "WebAccelerator init fail");
                return;
            }
            return;
        }
        z16 = false;
        if (!z16) {
            StringBuilder P2 = com.tencent.mobileqq.activity.aio.l.P();
            P2.append("DPC not catch success[");
            P2.append(featureValue);
            P2.append("]");
            QLog.d("WebAccelerator", 2, P2.toString());
        }
        this.f177631c = new HashSet();
        this.f177636h = new HashMap();
    }

    private final String e(String str) {
        String str2 = "";
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.connect();
            str2 = httpURLConnection.getHeaderField("Location");
            QLog.d("WebAccelerator", 2, "code:" + httpURLConnection.getResponseCode());
            return str2;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("WebAccelerator", 2, "doRedirect", e16);
                return str2;
            }
            return str2;
        }
    }

    public static String h(@NonNull String str) {
        if (!str.contains("http")) {
            return null;
        }
        Matcher matcher = f177624j.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        return str.substring(matcher.start(), matcher.end());
    }

    public static synchronized WebAccelerator j() {
        WebAccelerator webAccelerator;
        synchronized (WebAccelerator.class) {
            if (f177625k == null) {
                f177625k = new WebAccelerator();
            }
            webAccelerator = f177625k;
        }
        return webAccelerator;
    }

    public static boolean l(Context context, String str, Intent intent) {
        String config = QzoneConfig.getInstance().getConfig("QZVideo", QzoneConfig.SECONDARY_KEY_EC_LIVE_HOST, QzoneConfig.DefaultValue.DEFAULT_EC_LIVE_URL);
        Intent intent2 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent2.addCategory("android.intent.category.DEFAULT");
        intent2.setPackage("com.tencent.mobileqq");
        StringBuilder sb5 = new StringBuilder();
        if (str != null && str.contains(config)) {
            try {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("hostuin");
                String queryParameter2 = parse.getQueryParameter("roomid");
                String queryParameter3 = parse.getQueryParameter("feedid");
                String queryParameter4 = parse.getQueryParameter("roomstatus");
                if (!o(queryParameter2)) {
                    QLog.d("WebAccelerator", 2, "room_id not number!");
                    return false;
                }
                sb5.append(QzoneConfig.DefaultValue.DEFAULT_ECLIVE_LIVE_SCHEMA);
                sb5.append("?ec_room_id=" + queryParameter2);
                sb5.append("&ec_room_owner_id=" + queryParameter);
                sb5.append("&ec_room_from_type2");
                sb5.append("&ec_room_init_type=3");
                intent2.setData(Uri.parse(sb5.toString()));
                context.startActivity(intent2);
                k.a aVar = new k.a();
                aVar.f290022d = "kuolie_party";
                aVar.f290023e = "party_clk";
                aVar.f290026h = queryParameter3;
                aVar.f290027i = queryParameter2;
                aVar.f290028j = intent.getStringExtra("title");
                aVar.f290030l = queryParameter4;
                aVar.f290031m = queryParameter;
                aVar.f290032n = intent.getStringExtra("friendUin");
                aVar.f290033o = "4";
                com.tencent.mobileqq.statistics.k.d(null, aVar);
                return true;
            } catch (Exception unused) {
                QLog.d("WebAccelerator", 1, "getQzoneVideoIntent parse url error!");
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m(Context context, String str, Intent intent) {
        String config = QzoneConfig.getInstance().getConfig("QZVideo", QzoneConfig.SECONDARY_KEY_EC_LIVE_HOST, QzoneConfig.DefaultValue.DEFAULT_EC_LIVE_URL);
        if (!TextUtils.isEmpty(str) && str.startsWith(config)) {
            return l(context, str, intent);
        }
        String config2 = QzoneConfig.getInstance().getConfig("QZVideo", QzoneConfig.SECONDARY_KEY_QZONEVIDEO_HOST, QzoneConfig.DefaultValue.DEFAULT_QZONEVIDEO_URL);
        int config3 = QzoneConfig.getInstance().getConfig("QZVideo", QzoneConfig.SECONDARY_KEY_MODULE_JUMP_NATIVE, 1);
        String config4 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PLATO, QzoneConfig.SECONDARY_KEY_QZONEPLATO_SHAREHOST, QzoneConfig.DefaultValue.DEFAULT_PLATO_SHARE_URL);
        int config5 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PLATO, QzoneConfig.SECONDARY_KEY_QZONEPLATO_JUMP_NATIVE, 1);
        Intent intent2 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent2.addCategory("android.intent.category.DEFAULT");
        intent2.setPackage("com.tencent.mobileqq");
        StringBuilder sb5 = new StringBuilder();
        if (str != null && str.contains(config2)) {
            try {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("stayin");
                if (config3 == 1) {
                    String str2 = "1";
                    if (queryParameter == null || !TextUtils.equals(queryParameter, "1")) {
                        String stringExtra = intent.getStringExtra("self_uin");
                        String str3 = str.substring(str.lastIndexOf(config2) + config2.length(), str.length()).split("/")[0];
                        if (stringExtra != null && str3 != null && !TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(str3)) {
                            if (!o(str3)) {
                                QLog.d("WebAccelerator", 2, "room_id not number!");
                                return false;
                            }
                            sb5.append(QzoneConfig.DefaultValue.DEFAULT_QZONEVIDEO_SCHEMA);
                            sb5.append("?room=" + str3);
                            sb5.append("&uin=" + stringExtra);
                            sb5.append("&video_play_source=12");
                            sb5.append("&backup=" + URLEncoder.encode(str));
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("&isEcLive=");
                            if (!intent.getBooleanExtra("isEcLive", false)) {
                                str2 = "0";
                            }
                            sb6.append(str2);
                            sb5.append(sb6.toString());
                            intent2.setData(Uri.parse(sb5.toString()));
                            context.startActivity(intent2);
                            return true;
                        }
                        return false;
                    }
                }
                QLog.d("WebAccelerator", 1, "is_native not available, jump to H5, " + str);
                Intent intent3 = new Intent(context, (Class<?>) QQBrowserActivity.class);
                intent3.putExtra("url", parse.toString());
                intent3.setData(parse);
                context.startActivity(intent3);
                return true;
            } catch (Exception unused) {
                QLog.d("WebAccelerator", 1, "getQzoneVideoIntent parse url error!");
                return false;
            }
        }
        if (TextUtils.isEmpty(str) || !str.contains(config4) || config5 != 1) {
            return false;
        }
        try {
            Map<String, String> arguments = URLUtil.getArguments(str.substring(str.lastIndexOf(config4) + config4.length() + 1));
            sb5.append(QzoneConfig.DefaultValue.DEFAULT_PLATO_SCHEMA);
            sb5.append("?id=" + URLEncoder.encode(arguments.get("id")));
            if (!TextUtils.isEmpty(arguments.get("data"))) {
                sb5.append("&data=" + URLEncoder.encode(arguments.get("data")));
            }
            sb5.append("&url=" + URLEncoder.encode(str));
            intent2.setData(Uri.parse(sb5.toString()));
            context.startActivity(intent2);
            return true;
        } catch (Exception unused2) {
            QLog.d("WebAccelerator", 1, "arouse plato  parse url error!");
            return false;
        }
    }

    private final boolean n(int i3) {
        if ((this.f177637i & i3) == i3) {
            return true;
        }
        return false;
    }

    public static boolean o(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean p(Context context) {
        return false;
    }

    public static final boolean r(AbsStructMsg absStructMsg) {
        if (absStructMsg != null && "web".equals(absStructMsg.mMsgAction) && (absStructMsg instanceof StructMsgForGeneralShare) && !com.tencent.mobileqq.structmsg.d.a((AbsShareMsg) absStructMsg)) {
            return true;
        }
        return false;
    }

    public static void s(Context context, Intent intent, String str) {
        if (f177626l) {
            ThreadManagerV2.post(new Runnable(str, intent, context) { // from class: com.tencent.mobileqq.activity.WebAccelerator.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f177638d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Intent f177639e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Context f177640f;

                {
                    this.f177638d = str;
                    this.f177639e = intent;
                    this.f177640f = context;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, str, intent, context);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:27:0x00dd  */
                /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:36:0x00b6  */
                /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    boolean z16;
                    boolean z17;
                    Long l3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    String str2 = this.f177638d;
                    WebAccelerator j3 = WebAccelerator.j();
                    if (com.tencent.mobileqq.webview.swift.utils.c.j(this.f177638d)) {
                        str2 = j3.k(this.f177638d);
                        if (!TextUtils.isEmpty(str2)) {
                            this.f177639e.putExtra("url", str2);
                            z16 = true;
                            if (WebAccelerator.p(this.f177640f) && j3.q(str2)) {
                                this.f177639e.putExtra("key_isReadModeEnabled", false);
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            l3 = (Long) j3.f177636h.remove(this.f177638d);
                            if (l3 != null && SystemClock.uptimeMillis() - l3.longValue() < 180000) {
                                j3.t("bank_download_key");
                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put("count", "1");
                                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "AIOWebPreDownloadHit", false, 0L, 0L, hashMap, "", false);
                            }
                            if (!z17 || z16) {
                                j3.t("bankSize");
                                SharedPreferences i3 = WebAccelerator.j().i();
                                SharedPreferences.Editor edit = i3.edit();
                                if (z16) {
                                    edit.putInt("hit_shortLink", i3.getInt("hit_shortLink", 0) + 1);
                                }
                                if (z17) {
                                    edit.putInt("hit_safeCheck", i3.getInt("hit_safeCheck", 0) + 1);
                                }
                                edit.commit();
                            }
                            if (WebAccelerator.m(this.f177640f, this.f177638d, this.f177639e)) {
                                if (this.f177639e.getBooleanExtra(IPublicAccountBrowser.KEY_IS_PUBLIC_ACCOUNT, false)) {
                                    ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.f177640f, IPublicAccountBrowser.ROUTE_NAME);
                                    activityURIRequest.extra().putAll(this.f177639e.getExtras());
                                    QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
                                    return;
                                }
                                this.f177640f.startActivity(this.f177639e);
                                return;
                            }
                            return;
                        }
                        str2 = this.f177638d;
                    }
                    z16 = false;
                    if (WebAccelerator.p(this.f177640f)) {
                    }
                    z17 = false;
                    l3 = (Long) j3.f177636h.remove(this.f177638d);
                    if (l3 != null) {
                        j3.t("bank_download_key");
                        HashMap<String, String> hashMap2 = new HashMap<>();
                        hashMap2.put("count", "1");
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "AIOWebPreDownloadHit", false, 0L, 0L, hashMap2, "", false);
                    }
                    if (!z17) {
                    }
                    j3.t("bankSize");
                    SharedPreferences i36 = WebAccelerator.j().i();
                    SharedPreferences.Editor edit2 = i36.edit();
                    if (z16) {
                    }
                    if (z17) {
                    }
                    edit2.commit();
                    if (WebAccelerator.m(this.f177640f, this.f177638d, this.f177639e)) {
                    }
                }
            }, 8, null, false);
        } else {
            if (intent.getBooleanExtra(IPublicAccountBrowser.KEY_IS_PUBLIC_ACCOUNT, false)) {
                ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, IPublicAccountBrowser.ROUTE_NAME);
                activityURIRequest.extra().putAll(intent.getExtras());
                QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
                return;
            }
            context.startActivity(intent);
        }
    }

    private final synchronized boolean u() {
        boolean z16;
        SharedPreferences i3 = i();
        z16 = false;
        int i16 = i3.getInt("bankSize", 0);
        if (i16 < this.f177629a) {
            SharedPreferences.Editor edit = i3.edit();
            i16++;
            edit.putInt("bankSize", i16);
            edit.commit();
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            StringBuilder P = com.tencent.mobileqq.activity.aio.l.P();
            P.append("shouldUseAccelerator:");
            P.append(z16);
            P.append("   ");
            P.append(i16);
            QLog.d("WebAccelerator", 2, P.toString());
        }
        return z16;
    }

    public final void c(String str, int i3, String str2, String str3) {
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), str2, str3);
            return;
        }
        if (!TextUtils.isEmpty(str) && f177626l) {
            String trim = str.trim();
            synchronized (this.f177632d) {
                if (this.f177631c.contains(trim)) {
                    return;
                }
                this.f177631c.add(trim);
                int netWorkType = HttpUtil.getNetWorkType();
                if (netWorkType != 1) {
                    if (netWorkType != 2) {
                        if (netWorkType != 3) {
                            if (netWorkType != 4) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("WebAccelerator", 2, "unknown network type , not use accelerator");
                                    return;
                                }
                                return;
                            }
                            i16 = 8;
                        }
                    } else {
                        i16 = 2;
                    }
                } else {
                    i16 = 1;
                }
                if (n(i16) && u()) {
                    if (n(16)) {
                        str4 = g(trim);
                    } else {
                        str4 = trim;
                    }
                    if (n(32)) {
                        f(str4, i3, str2, str3);
                    }
                    if (n(64)) {
                        d(str4);
                    }
                }
                synchronized (this.f177632d) {
                    this.f177631c.remove(trim);
                }
            }
        }
    }

    public final boolean d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        boolean z16 = false;
        if (str != null && !str.equals("")) {
            if (!f177626l) {
                return false;
            }
            try {
                InetAddress.getByName(com.tencent.mobileqq.structmsg.d.b(str));
                z16 = true;
            } catch (SecurityException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("WebAccelerator", 2, "doDNS", e16);
                }
            } catch (UnknownHostException e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("WebAccelerator", 2, "doDNS", e17);
                }
            }
            if (QLog.isColorLevel()) {
                StringBuilder P = com.tencent.mobileqq.activity.aio.l.P();
                P.append("doDNS:");
                P.append(str);
                P.append("   ");
                P.append(z16);
                QLog.d("WebAccelerator", 2, P.toString());
            }
        }
        return z16;
    }

    public final boolean f(String str, int i3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2, str3)).booleanValue();
        }
        if (str != null && !str.equals("")) {
            if (this.f177634f && f177626l && !str.contains(URLEncoder.encode("/cgi-bin/httpconn?htcmd=0x6ff0080")) && !str.contains("/cgi-bin/httpconn?htcmd=0x6ff0080") && !q(str)) {
                try {
                    int uptimeMillis = ((int) SystemClock.uptimeMillis()) % 2;
                    String[] strArr = com.tencent.mobileqq.webview.util.x.f314887b;
                    if (uptimeMillis <= -1) {
                        uptimeMillis = 0;
                    }
                    String str4 = strArr[uptimeMillis];
                    String d16 = com.tencent.mobileqq.troop.soso.b.c().d(0, false, false);
                    if (d16 != null && d16.length() > 0) {
                        str4 = str4.replaceFirst("http://[^/\\s]*/", d16);
                    }
                    StringBuilder P = com.tencent.mobileqq.activity.aio.l.P();
                    P.append(str4);
                    P.append("&u=");
                    P.append(URLEncoder.encode(str, "UTF-8"));
                    P.append("&wap=3");
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 3000) {
                                P.append("&qq-pf-to=mqq.temporaryc2c");
                            } else {
                                P.append("&qq-pf-to=mqq.discussion");
                            }
                        } else {
                            P.append("&qq-pf-to=mqq.group");
                        }
                    } else {
                        P.append("&qq-pf-to=mqq.c2c");
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        P.append("&uin=");
                        P.append(str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        P.append("&originuin=");
                        P.append(str3);
                    }
                    String sb5 = P.toString();
                    String e16 = e(sb5);
                    SharedPreferences i16 = i();
                    i16.edit().putInt("load_safeCheck", i16.getInt("load_safeCheck", 0) + 1).commit();
                    if (!TextUtils.isEmpty(e16) && e16.equals(str)) {
                        DiskLruCache.Editor editor = null;
                        try {
                            DiskLruCache.Editor edit = this.f177635g.edit(Md5Utils.getMD5(str));
                            if (edit != null) {
                                edit.set(0, SystemClock.uptimeMillis() + "");
                                edit.commit();
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.e("WebAccelerator", 2, "fail to open cache.editor");
                                }
                                z16 = false;
                            }
                            z17 = z16;
                        } catch (IOException e17) {
                            if (QLog.isColorLevel()) {
                                QLog.d("WebAccelerator", 2, "doSafeCheck", e17);
                            }
                            if (0 != 0) {
                                try {
                                    editor.abort();
                                } catch (IOException e18) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("WebAccelerator", 2, "doSafeCheck", e18);
                                    }
                                }
                            }
                        } catch (Exception unused) {
                            if (0 != 0) {
                                try {
                                    editor.abort();
                                } catch (IOException e19) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("WebAccelerator", 2, "doSafeCheck", e19);
                                    }
                                }
                            }
                            return false;
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("WebAccelerator", 2, "doRedirect get fail url");
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder P2 = com.tencent.mobileqq.activity.aio.l.P();
                        P2.append("doSafeCheck:");
                        P2.append(sb5);
                        P2.append("   ");
                        P2.append(z17);
                        QLog.d("WebAccelerator", 2, P2.toString());
                    }
                    return z17;
                } catch (UnsupportedEncodingException e26) {
                    if (QLog.isColorLevel()) {
                        QLog.e("WebAccelerator", 2, "buildUrl fail", e26);
                    }
                    return false;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("WebAccelerator", 2, "no need doSafeCheck");
            }
        }
        return false;
    }

    public final String g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (str != null && !str.equals("") && this.f177634f && f177626l && com.tencent.mobileqq.webview.swift.utils.c.j(str)) {
            String k3 = k(str);
            if (k3 == null) {
                k3 = e(str);
                if (k3 != null && !k3.equals("")) {
                    SharedPreferences i3 = i();
                    i3.edit().putInt("load_shortLink", i3.getInt("load_shortLink", 0) + 1).commit();
                    DiskLruCache.Editor editor = null;
                    try {
                        editor = this.f177635g.edit(Md5Utils.getMD5(str));
                        if (editor != null) {
                            editor.set(0, k3);
                            editor.commit();
                        } else if (QLog.isColorLevel()) {
                            QLog.d("WebAccelerator", 2, "fail to open cache.Editor");
                        }
                        if (QLog.isColorLevel()) {
                            StringBuilder P = com.tencent.mobileqq.activity.aio.l.P();
                            P.append("doShortLink:");
                            P.append(str);
                            P.append("   ");
                            P.append(k3);
                            QLog.d("WebAccelerator", 2, P.toString());
                        }
                    } catch (IOException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("WebAccelerator", 2, "doShortLink", e16);
                        }
                        if (editor != null) {
                            try {
                                editor.abort();
                            } catch (IOException e17) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("WebAccelerator", 2, "doShortLink.editor.abort", e17);
                                }
                            }
                        }
                    } catch (Exception unused) {
                        if (editor != null) {
                            try {
                                editor.abort();
                            } catch (IOException e18) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("WebAccelerator", 2, "doShortLink.editor.abort", e18);
                                }
                            }
                        }
                        return str;
                    }
                } else {
                    return str;
                }
            }
            return k3;
        }
        return str;
    }

    public final synchronized SharedPreferences i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("WebAccelerator", 0);
        long j3 = sharedPreferences.getLong("updateTime", 0L);
        if (j3 == 0) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong("updateTime", System.currentTimeMillis());
            edit.commit();
        } else if (System.currentTimeMillis() - j3 > 86400000) {
            if (QLog.isColorLevel()) {
                QLog.d("WebAccelerator", 2, "get circle,clean data and report");
            }
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            edit2.putLong("updateTime", System.currentTimeMillis());
            edit2.putInt("bankSize", 0);
            edit2.putInt("bank_download_key", 0);
            this.f177636h.clear();
            int i3 = sharedPreferences.getInt("load_shortLink", 0);
            edit2.putInt("load_shortLink", 0);
            int i16 = sharedPreferences.getInt("hit_shortLink", 0);
            edit2.putInt("hit_shortLink", 0);
            if (i3 > 0 || i16 > 0) {
                HashMap<String, String> hashMap = new HashMap<>(4);
                hashMap.put("load_time", i3 + "");
                hashMap.put("hit_time", i16 + "");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "AIOWebShortLink", false, 0L, 0L, hashMap, "", false);
            }
            int i17 = sharedPreferences.getInt("load_safeCheck", 0);
            edit2.putInt("load_safeCheck", 0);
            int i18 = sharedPreferences.getInt("hit_safeCheck", 0);
            edit2.putInt("hit_safeCheck", 0);
            if (i17 > 0 || i18 > 0) {
                HashMap<String, String> hashMap2 = new HashMap<>(4);
                hashMap2.put("load_time", i17 + "");
                hashMap2.put("hit_time", i18 + "");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "AIOWebSafeCheck", false, 0L, 0L, hashMap2, "", false);
            }
            edit2.commit();
        }
        return sharedPreferences;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
    
        if (r1 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007a, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0061, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005f, code lost:
    
        if (r1 != null) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String k(String str) {
        DiskLruCache.Snapshot snapshot;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (str != null && !str.equals("")) {
            DiskLruCache.Snapshot snapshot2 = null;
            r3 = null;
            r3 = null;
            String str2 = null;
            if (!this.f177634f || !f177626l) {
                return null;
            }
            try {
                snapshot = this.f177635g.get(Md5Utils.getMD5(str));
                if (snapshot != null) {
                    try {
                        try {
                            str2 = snapshot.getString(0);
                        } catch (Throwable th5) {
                            th = th5;
                            snapshot2 = snapshot;
                            if (snapshot2 != null) {
                                snapshot2.close();
                            }
                            throw th;
                        }
                    } catch (IOException e16) {
                        e = e16;
                        if (QLog.isColorLevel()) {
                            QLog.e("WebAccelerator", 2, "getLinkFromShortLink fail", e);
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    StringBuilder P = com.tencent.mobileqq.activity.aio.l.P();
                    P.append("getLinkFromShortLink:");
                    P.append(str);
                    P.append("   ");
                    P.append(str2);
                    QLog.d("WebAccelerator", 2, P.toString());
                }
            } catch (IOException e17) {
                e = e17;
                snapshot = null;
            } catch (Throwable th6) {
                th = th6;
                if (snapshot2 != null) {
                }
                throw th;
            }
        } else {
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0096, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0093, code lost:
    
        if (0 != 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean q(String str) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        boolean z16 = false;
        if (str == null || str.equals("") || !this.f177634f || !f177626l) {
            return false;
        }
        String md5 = Md5Utils.getMD5(str);
        DiskLruCache.Snapshot snapshot = null;
        try {
            try {
                snapshot = this.f177635g.get(md5);
                if (snapshot != null) {
                    try {
                        j3 = Long.parseLong(snapshot.getString(0));
                    } catch (NumberFormatException unused) {
                        j3 = 0;
                    }
                    if (SystemClock.uptimeMillis() - j3 < this.f177633e) {
                        z16 = true;
                    } else {
                        this.f177635g.remove(md5);
                    }
                }
                if (QLog.isColorLevel()) {
                    StringBuilder P = com.tencent.mobileqq.activity.aio.l.P();
                    P.append("isSafeCheck:");
                    P.append(str);
                    P.append("   ");
                    P.append(z16);
                    QLog.d("WebAccelerator", 2, P.toString());
                }
            } catch (IOException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("WebAccelerator", 2, "isSafeCheck fail", e16);
                }
            }
        } finally {
            if (0 != 0) {
                snapshot.close();
            }
        }
    }

    public final synchronized void t(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("WebAccelerator", 0);
        int i3 = sharedPreferences.getInt(str, 0);
        if (i3 > 0) {
            sharedPreferences.edit().putInt(str, i3 - 1).commit();
        }
    }
}
