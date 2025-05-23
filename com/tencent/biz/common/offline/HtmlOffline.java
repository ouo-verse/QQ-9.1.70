package com.tencent.biz.common.offline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.h;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.injector.m;
import com.tencent.mobileqq.webview.swift.injector.v;
import com.tencent.mobileqq.webview.util.n;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.pts.utils.PTSFileUtil;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import px.e;
import tencent.im.sso.offlinpkg.OfflinePkg$BidPkg;
import tencent.im.sso.offlinpkg.OfflinePkg$ReqBody;
import tencent.im.sso.offlinpkg.OfflinePkg$RspBody;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HtmlOffline {

    /* renamed from: a, reason: collision with root package name */
    protected static final String[] f78398a;

    /* renamed from: b, reason: collision with root package name */
    protected static final String[] f78399b;

    /* renamed from: c, reason: collision with root package name */
    public static int f78400c;

    /* renamed from: d, reason: collision with root package name */
    private static Context f78401d;

    /* renamed from: e, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/Webview/Inject_OfflineDownloader.yml", version = 1)
    public static px.c f78402e;

    /* renamed from: f, reason: collision with root package name */
    public static px.b f78403f;

    /* renamed from: g, reason: collision with root package name */
    public static ConcurrentHashMap<String, String> f78404g;

    /* renamed from: h, reason: collision with root package name */
    public static com.tencent.biz.common.offline.a f78405h;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f78406i;

    /* renamed from: j, reason: collision with root package name */
    private static ArrayList f78407j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<com.tencent.biz.common.offline.a> f78427d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<AppRuntime> f78428e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f78429f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f78430h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f78431i;

        /* renamed from: m, reason: collision with root package name */
        private NewIntent f78432m;

        public b(@NonNull com.tencent.biz.common.offline.a aVar, @NonNull AppRuntime appRuntime, boolean z16, boolean z17, boolean z18, @NonNull NewIntent newIntent) {
            this.f78427d = new WeakReference<>(aVar);
            this.f78428e = new WeakReference<>(appRuntime);
            this.f78429f = z16;
            this.f78430h = z18;
            this.f78431i = z17;
            this.f78432m = newIntent;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            this.f78432m.setObserver(null);
            if (QLog.isColorLevel()) {
                QLog.d("HtmlCheckUpdate", 2, "-->offline:checkUpdate,onReceive:isSuccess=" + z16);
            }
            com.tencent.biz.common.offline.a aVar = this.f78427d.get();
            AppRuntime appRuntime = this.f78428e.get();
            boolean z17 = false;
            if (aVar != null && appRuntime != null) {
                if (z16) {
                    try {
                        byte[] byteArray = bundle.getByteArray("data");
                        if (byteArray != null) {
                            OfflinePkg$RspBody offlinePkg$RspBody = new OfflinePkg$RspBody();
                            offlinePkg$RspBody.mergeFrom(byteArray);
                            String str = new String(offlinePkg$RspBody.str_offline_pkg.get().toByteArray(), "UTF-8");
                            aVar.loaded(str, 0);
                            if (this.f78429f) {
                                if (this.f78430h) {
                                    HtmlOffline.G(str, appRuntime, this.f78431i, aVar);
                                } else {
                                    HtmlOffline.G(str, appRuntime, this.f78431i, null);
                                }
                            }
                        }
                        return;
                    } catch (Exception unused) {
                        aVar.loaded("{\"r\":-1}", 2);
                        return;
                    }
                }
                aVar.loaded("{\"r\":-1}", 2);
                return;
            }
            Object[] objArr = new Object[2];
            objArr[0] = "-->offline:checkUpdate,app is null:";
            if (appRuntime == null) {
                z17 = true;
            }
            objArr[1] = Boolean.valueOf(z17);
            QLog.d("HtmlCheckUpdate", 2, objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f78433a;

        /* renamed from: b, reason: collision with root package name */
        public InputStream f78434b;

        public c(String str, InputStream inputStream) {
            this.f78433a = str;
            this.f78434b = inputStream;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private Context f78435a;

        /* renamed from: b, reason: collision with root package name */
        private String f78436b;

        /* renamed from: c, reason: collision with root package name */
        private com.tencent.biz.common.offline.b f78437c;

        /* renamed from: d, reason: collision with root package name */
        private String f78438d;

        public d(Context context, String str, com.tencent.biz.common.offline.b bVar) {
            if (!TextUtils.isEmpty(str) && bVar != null) {
                this.f78435a = context;
                this.f78436b = str;
                this.f78437c = bVar;
                this.f78438d = Uri.parse(str).getQueryParameter("_bid");
                return;
            }
            if (HtmlOffline.f78403f.isColorLevel()) {
                HtmlOffline.f78403f.i("HtmlCheckUpdate", 2, "new TransUrl error");
            }
        }

        private void a(String str, int i3) {
            if (HtmlOffline.f78403f.isColorLevel()) {
                HtmlOffline.f78403f.i("HtmlCheckUpdate", 2, "transThread callback mode:" + i3);
            }
            com.tencent.biz.common.offline.b bVar = this.f78437c;
            if (bVar != null) {
                bVar.loaded(i3, str);
            }
        }

        private JSONObject b(long j3, String str, JSONObject jSONObject) {
            if ((HtmlOffline.q(this.f78438d) || jSONObject == null) && (jSONObject = HtmlOffline.t(this.f78438d)) != null) {
                long optLong = jSONObject.optLong("expired", 0L);
                if (optLong > 0 && j3 > optLong) {
                    if (HtmlOffline.f78400c == 0) {
                        HtmlOffline.f78400c = 1;
                    }
                    com.tencent.mobileqq.webview.util.d.a(str);
                    HtmlOffline.F("-->offline:doTransUrl,zip expire =1");
                }
            }
            return jSONObject;
        }

        private void c(long j3, String str, JSONObject jSONObject) {
            if (jSONObject != null) {
                int u16 = HtmlOffline.u(this.f78435a, this.f78438d);
                if (u16 != 1) {
                    long optLong = jSONObject.optLong("expired", 0L);
                    if (optLong > 0 && j3 > optLong) {
                        u16 = 1;
                    }
                }
                if (u16 == 1) {
                    HtmlOffline.f78400c = 1;
                    com.tencent.mobileqq.webview.util.d.a(str);
                    HtmlOffline.P(this.f78435a, this.f78438d, 0);
                    if (HtmlOffline.f78403f.isColorLevel()) {
                        HtmlOffline.f78403f.i("HtmlCheckUpdate", 2, "-->offline:doTransUrl,expire =1");
                    }
                }
            }
        }

        private boolean e() {
            String d16 = com.tencent.biz.common.offline.c.d(this.f78438d);
            if (TextUtils.isEmpty(d16)) {
                return false;
            }
            return HtmlOffline.n(this.f78435a, "html5/" + this.f78438d + "/" + this.f78438d + ".zip", d16 + this.f78438d + ".zip");
        }

        private String f(String str, int i3, int i16, String str2, String str3) {
            String str4;
            if (i16 == 2) {
                if (!str2.contains("_lv=")) {
                    return HtmlOffline.b(str2, "_lv=" + i3);
                }
                return str2;
            }
            String str5 = "file://" + str + "/" + this.f78436b.substring(this.f78436b.indexOf(":") + 3);
            if (!str5.contains("_lv=")) {
                str4 = HtmlOffline.b(str5, "_lv=" + i3 + "&_t=" + System.currentTimeMillis());
            } else {
                str4 = str5;
            }
            if (!new File(str + "/" + str3).exists()) {
                return this.f78436b;
            }
            return str4;
        }

        private void g(long j3, int i3, long j16, long j17) {
            if (i3 > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                long j18 = currentTimeMillis - j3;
                sb5.append(j18);
                HtmlOffline.J(this.f78438d, 0, i3, -1, "lixian_cover", sb5.toString());
                BidDownloader.m(0, this.f78438d, 0, i3, "lixian_cover", 0);
                if (HtmlOffline.f78403f.isColorLevel()) {
                    HtmlOffline.f78403f.i("HtmlCheckUpdate", 2, "trans time:" + j18);
                }
                if (j16 > 0) {
                    HtmlOffline.J(this.f78438d, Long.valueOf(j16).intValue(), 1L, -1, "lixian_cover_sec", "");
                    BidDownloader.m(0, this.f78438d, 0, 0, "lixian_cover_sec", 1);
                    return;
                } else {
                    if (j17 > 0) {
                        HtmlOffline.J(this.f78438d, Long.valueOf(j17).intValue(), 2L, -1, "lixian_cover_sec", "");
                        BidDownloader.m(0, this.f78438d, 0, 0, "lixian_cover_sec", 2);
                        return;
                    }
                    return;
                }
            }
            HtmlOffline.J(this.f78438d, 7, i3, NetworkUtil.getNetWorkType(), "lixian_cover", "0");
            BidDownloader.m(0, this.f78438d, 7, i3, "lixian_cover", 0);
        }

        public void d() {
            boolean z16;
            int i3;
            int i16;
            int i17;
            int i18;
            int i19;
            long j3;
            long j16;
            boolean k3;
            long currentTimeMillis;
            long j17;
            String str;
            int i26;
            String str2;
            int i27;
            HtmlOffline.F("-->offline:doTransUrl start:" + this.f78438d);
            int i28 = 0;
            HtmlOffline.f78400c = 0;
            long currentTimeMillis2 = System.currentTimeMillis();
            String c16 = com.tencent.biz.common.offline.c.c(this.f78438d);
            if (TextUtils.isEmpty(c16)) {
                HtmlOffline.F("-->offline:doTransUrl,html root dir is null!");
                a(this.f78436b, 0);
                HtmlOffline.J(this.f78438d, 2, 0L, -1, "lixian_cover", "0");
                BidDownloader.m(0, this.f78438d, 2, 0, "lixian_cover", 0);
                return;
            }
            String str3 = c16 + this.f78438d;
            JSONObject s16 = HtmlOffline.s(this.f78435a, this.f78438d);
            JSONObject t16 = HtmlOffline.t(this.f78438d);
            c(currentTimeMillis2, str3, t16);
            JSONObject b16 = b(currentTimeMillis2, str3, t16);
            if (s16 != null) {
                i3 = s16.optInt("version", 0);
                long optLong = s16.optLong("expired", 0L);
                if (optLong > 0 && currentTimeMillis2 > optLong) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            } else {
                z16 = false;
                i3 = 0;
            }
            if (b16 != null) {
                i16 = b16.optInt("version", 0);
            } else {
                i16 = 0;
            }
            int i29 = 3;
            if (i3 == 0 && i16 == 0) {
                HtmlOffline.F("-->offline:doTransUrl:no package in both asset and data dir!");
                if (HtmlOffline.f78400c == 0) {
                    HtmlOffline.f78400c = 3;
                }
                HtmlOffline.o(str3, this.f78438d);
                a(this.f78436b, 0);
                String str4 = this.f78438d;
                int netWorkType = NetworkUtil.getNetWorkType();
                if (b16 == null) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                HtmlOffline.J(str4, 5, 0L, netWorkType, "lixian_cover", str2);
                String str5 = this.f78438d;
                if (b16 == null) {
                    i27 = 0;
                } else {
                    i27 = 1;
                }
                BidDownloader.m(0, str5, 5, 0, "lixian_cover", i27);
                return;
            }
            HtmlOffline.F("-->offline:getVersion :" + String.valueOf(i3) + "," + String.valueOf(i16));
            int i36 = 6;
            if (i16 < i3 && !z16) {
                if (e()) {
                    if (HtmlOffline.q(this.f78438d)) {
                        b16 = HtmlOffline.t(this.f78438d);
                        if (b16 != null) {
                            i16 = b16.optInt("version", 0);
                        } else {
                            i36 = 10;
                        }
                    } else {
                        i36 = 9;
                    }
                } else {
                    i36 = 8;
                }
            }
            int i37 = i16;
            int i38 = i36;
            JSONObject jSONObject = b16;
            if (i37 < i3) {
                HtmlOffline.F("-->offline,doTransUrl:SD card update fail.");
                if (HtmlOffline.f78400c == 0) {
                    HtmlOffline.f78400c = 4;
                }
                HtmlOffline.o(str3, this.f78438d);
                a(this.f78436b, 0);
                String str6 = this.f78438d;
                long j18 = i37;
                int netWorkType2 = NetworkUtil.getNetWorkType();
                if (jSONObject == null) {
                    str = "0";
                } else {
                    str = "1";
                }
                HtmlOffline.J(str6, i38, j18, netWorkType2, "lixian_cover", str);
                String str7 = this.f78438d;
                if (jSONObject == null) {
                    i26 = 0;
                } else {
                    i26 = 1;
                }
                BidDownloader.m(0, str7, i38, i37, "lixian_cover", i26);
                return;
            }
            if (jSONObject != null) {
                i17 = jSONObject.optInt("loadmode", 1);
            } else {
                i17 = 1;
            }
            String str8 = this.f78436b;
            String v3 = HtmlOffline.v(str8);
            String f16 = f(str3, i37, i17, str8, v3);
            if (jSONObject != null) {
                i18 = jSONObject.optInt("verifyType", 0);
            } else {
                i18 = 0;
            }
            if (new File(str3).exists()) {
                ConcurrentHashMap<String, String> concurrentHashMap = HtmlOffline.f78404g;
                if (concurrentHashMap != null) {
                    concurrentHashMap.clear();
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                if (i17 == 2 && i18 == 1) {
                    if (!TextUtils.isEmpty(v3)) {
                        k3 = h.n(v3, str3, this.f78438d);
                    } else {
                        k3 = false;
                        i29 = i17;
                    }
                    j17 = System.currentTimeMillis() - currentTimeMillis3;
                    i17 = i29;
                    currentTimeMillis = 0;
                } else {
                    k3 = h.k(str3, this.f78438d);
                    currentTimeMillis = System.currentTimeMillis() - currentTimeMillis3;
                    j17 = 0;
                }
                if (!k3) {
                    if (HtmlOffline.f78400c == 0) {
                        HtmlOffline.f78400c = 5;
                    }
                    HtmlOffline.o(str3, this.f78438d);
                    f16 = this.f78436b;
                    HtmlOffline.F("-->offline:trans VerifyFile fail :" + this.f78438d);
                    i19 = 0;
                } else {
                    i19 = i37;
                    i28 = i17;
                }
                long j19 = currentTimeMillis;
                j3 = j17;
                j16 = j19;
            } else {
                i19 = i37;
                i28 = i17;
                j3 = 0;
                j16 = 0;
            }
            a(f16, i28);
            g(currentTimeMillis2, i19, j3, j16);
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f78407j = arrayList;
        arrayList.add(e.class);
        f78398a = new String[]{"config.json", "verify.json", "verify.signature"};
        f78399b = new String[]{"0", "1"};
        f78400c = 0;
        f78403f = new px.d();
        f78404g = new ConcurrentHashMap<>();
        f78405h = new a();
        f78406i = false;
    }

    protected static String A(String str) {
        File[] listFiles;
        JSONObject t16;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (int i3 = 0; i3 < listFiles.length && i3 < 100; i3++) {
                File file2 = listFiles[i3];
                if (file2.isDirectory() && TextUtils.isDigitsOnly(file2.getName()) && (t16 = t(file2.getName())) != null) {
                    try {
                        stringBuffer.append(file2.getName() + "|" + t16.getString("version") + ",");
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
            }
        }
        return stringBuffer.toString();
    }

    @SuppressLint({"NewApi"})
    public static c B(String str, String str2) {
        String str3;
        if (str != null && !TextUtils.isEmpty(str2) && str2.startsWith("http")) {
            String c16 = com.tencent.biz.common.offline.c.c(str);
            if (TextUtils.isEmpty(c16)) {
                return null;
            }
            String v3 = v(str2);
            String str4 = (c16 + str) + "/" + v3;
            if (!new File(str4).exists()) {
                if (f78403f.isDevelopLevel()) {
                    f78403f.i("HtmlCheckUpdate", 4, "getResponse local file not exists :" + v3);
                }
                return null;
            }
            if (v3.contains(".css")) {
                str3 = "text/css";
            } else if (v3.contains(PTSFileUtil.JS_FORMAT)) {
                str3 = "application/x-javascript";
            } else if (!v3.contains(".jpg") && !v3.contains(QzoneEmotionUtils.SIGN_ICON_URL_END) && !v3.contains(".png") && !v3.contains(".jpeg")) {
                str3 = "text/html";
            } else {
                str3 = "image/*";
            }
            if (f78403f.isDevelopLevel()) {
                f78403f.i("HtmlCheckUpdate", 4, "getResponse ****************** :" + v3);
            }
            try {
                return new c(str3, new BufferedInputStream(new FileInputStream(str4)));
            } catch (FileNotFoundException e16) {
                e16.printStackTrace();
                if (f78403f.isDevelopLevel()) {
                    f78403f.i("HtmlCheckUpdate", 4, "getResponse get local file fail:" + v3);
                }
                return null;
            }
        }
        if (f78403f.isColorLevel()) {
            f78403f.i("HtmlCheckUpdate", 2, "shouldInterceptRequest: businessId null ");
        }
        return null;
    }

    public static void C(ArrayList<String> arrayList, AppRuntime appRuntime, com.tencent.biz.common.offline.a aVar, boolean z16, boolean z17) {
        if (aVar == null) {
            return;
        }
        if (appRuntime != null && arrayList.size() != 0) {
            p(arrayList, appRuntime, aVar, z16, z17);
        } else {
            aVar.loaded("{\"r\":-1}", -1);
        }
    }

    public static void D() {
        if (f78401d == null) {
            if (f78402e == null) {
                E();
            }
            M(new px.d());
            K(BaseApplication.getContext());
        }
    }

    @QAutoInitMethod
    static void E() {
        f78402e = (px.c) com.tencent.mobileqq.qroute.utils.b.a(f78407j);
        if (QLog.isColorLevel()) {
            n.a("HtmlCheckUpdate", f78402e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(String str) {
        if (f78403f.isColorLevel()) {
            f78403f.i("HtmlCheckUpdate", 2, str);
        }
    }

    protected static void G(String str, AppRuntime appRuntime, boolean z16, com.tencent.biz.common.offline.a aVar) {
        int optInt;
        boolean z17;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("HtmlCheckUpdate", 2, "parseExpire:" + str);
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("data");
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null && (optInt = optJSONObject.optInt("code")) > 0 && optInt < 10) {
                    int optInt2 = optJSONObject.optInt("bid");
                    arrayList.add(optInt2 + "");
                    BidDownloader bidDownloader = new BidDownloader(optInt2 + "", appRuntime, aVar, true, optInt);
                    bidDownloader.L = optJSONObject.optInt("id");
                    if (optJSONObject.optInt("isWifi", 0) > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    bidDownloader.E = z17;
                    bidDownloader.f78391h = z16;
                    bidDownloader.I = optJSONObject.optString("url");
                    bidDownloader.J = optJSONObject.optInt(MediaDBValues.FILESIZE);
                    bidDownloader.e();
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.i("HtmlCheckUpdate", 2, "parseExpire: " + QLog.getStackTraceString(e16));
            }
        }
    }

    static boolean H(String str, String str2, String str3) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str2);
        if (!file2.exists()) {
            QLog.d("HtmlCheckUpdate", 1, str2, "not exist");
            return false;
        }
        boolean renameTo = file2.renameTo(new File(str3));
        if (QLog.isColorLevel()) {
            QLog.d("HtmlCheckUpdate", 2, "origin:", str2, " dest:", str3, " result: ", Boolean.valueOf(renameTo));
        }
        return renameTo;
    }

    protected static void I(String str, int i3, long j3, int i16) {
        J(str, i3, j3, i16, "lixian_update", "");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void J(String str, int i3, long j3, int i16, String str2, String str3) {
        int i17;
        String str4;
        String str5;
        int i18;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            i17 = Integer.valueOf(str).intValue();
        } catch (NumberFormatException unused) {
            i17 = -1;
        }
        int i19 = i17;
        if (str3 == null) {
            str4 = "";
        } else {
            str4 = str3;
        }
        try {
            if (f78401d == null) {
                f78401d = BaseApplication.getContext();
            }
            str5 = InstalledAppListMonitor.getPackageInfo(f78401d.getPackageManager(), f78401d.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            str5 = "";
            if (i16 > 0) {
            }
            i18 = i16;
            if (f78406i) {
            }
        } catch (Exception e17) {
            e17.printStackTrace();
            str5 = "";
            if (i16 > 0) {
            }
            i18 = i16;
            if (f78406i) {
            }
        }
        if (i16 > 0 && f78401d != null) {
            i18 = NetworkUtil.getNetWorkType();
        } else {
            i18 = i16;
        }
        if (f78406i) {
            ((m) aa.k(m.class)).b(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, str5, "mp_msg_sys_14", str2, i19, i3, "" + j3, "3", "" + i18, str4);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("HtmlCheckUpdate", 2, "reportDownTime qver=" + str5 + ", mainAction=" + str2 + ", bid=" + i19 + ", code=" + i3 + ", time=" + j3 + ", netType=" + i18 + ", ex5=" + str4);
        }
    }

    public static void K(Context context) {
        f78401d = context;
    }

    public static void L(px.c cVar) {
        f78402e = cVar;
    }

    public static void M(px.b bVar) {
        f78403f = bVar;
    }

    public static boolean N(final Context context, final String str, final com.tencent.biz.common.offline.b bVar) {
        if (f78403f.isColorLevel()) {
            f78403f.i("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,url:" + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String queryParameter = Uri.parse(str).getQueryParameter("_bid");
        if (TextUtils.isEmpty(queryParameter)) {
            if (f78403f.isColorLevel()) {
                f78403f.i("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,business id is null!");
            }
            return false;
        }
        if (context == null) {
            J(queryParameter, 3, 0L, 4, "lixian_cover", "0");
            BidDownloader.m(0, queryParameter, 3, 0, "lixian_cover", 0);
            return false;
        }
        if (com.tencent.biz.common.offline.c.c(queryParameter) == null) {
            if (f78403f.isColorLevel()) {
                f78403f.i("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,initEnv fail!");
            }
            J(queryParameter, 2, 0L, NetworkUtil.getNetWorkType(), "lixian_cover", "0");
            BidDownloader.m(0, queryParameter, 2, 0, "lixian_cover", 0);
            return false;
        }
        if (Arrays.asList(f78399b).contains(queryParameter)) {
            J(queryParameter, 4, 0L, NetworkUtil.getNetWorkType(), "lixian_cover", "0");
            BidDownloader.m(0, queryParameter, 4, 0, "lixian_cover", 0);
            return false;
        }
        com.tencent.biz.common.offline.d.a().b(new Runnable() { // from class: com.tencent.biz.common.offline.HtmlOffline.1
            @Override // java.lang.Runnable
            public void run() {
                d dVar = new d(context, str, bVar);
                if (HtmlOffline.f78403f.isColorLevel()) {
                    HtmlOffline.f78403f.i("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,Begin transThread:");
                }
                dVar.d();
            }
        });
        return true;
    }

    public static boolean O(String str, Context context, String str2, com.tencent.biz.common.offline.b bVar) {
        return N(context, "https://" + str + "?_bid=" + str2, bVar);
    }

    public static void P(Context context, String str, int i3) {
        t.m("busi_html_offline_").d("expire_" + str, Integer.valueOf(i3)).a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void Q(Context context, String str) {
        t.m("busi_html_offline_").d("last_up_" + str, Long.valueOf(System.currentTimeMillis())).a();
    }

    public static boolean R(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f78403f.isColorLevel()) {
                f78403f.i("HtmlCheckUpdate", 2, "verfySign: businessId null ");
            }
            return false;
        }
        String c16 = com.tencent.biz.common.offline.c.c(str);
        if (TextUtils.isEmpty(c16)) {
            return true;
        }
        String str2 = c16 + str;
        if (!new File(str2).exists() || h.q(str2, str)) {
            return true;
        }
        o(str2, str);
        if (f78403f.isColorLevel()) {
            f78403f.i("HtmlCheckUpdate", 2, "verfySign fail :" + str);
        }
        return false;
    }

    public static boolean S(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            if (f78403f.isColorLevel()) {
                f78403f.i("HtmlCheckUpdate", 2, "verfyFile: businessId null ");
            }
            return false;
        }
        String c16 = com.tencent.biz.common.offline.c.c(str);
        if (TextUtils.isEmpty(c16)) {
            return true;
        }
        String str3 = c16 + str;
        if (!new File(str3).exists()) {
            return true;
        }
        String v3 = v(str2);
        long currentTimeMillis = System.currentTimeMillis();
        if (!h.m(v3, str3, str)) {
            o(str3, str);
            if (f78403f.isColorLevel()) {
                f78403f.i("HtmlCheckUpdate", 2, "verfySingleFile fail :" + v3);
            }
            return false;
        }
        if (f78403f.isDevelopLevel()) {
            f78403f.d("HtmlCheckUpdate", 4, "verifyFile:time=" + (System.currentTimeMillis() - currentTimeMillis) + ", file:" + v3);
        }
        return true;
    }

    public static String b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.contains("#")) {
                String[] split = str.split("\\#");
                String str3 = split[0];
                int length = split.length;
                String str4 = "";
                for (int i3 = 1; i3 < length; i3++) {
                    str4 = str4 + "#" + split[i3];
                }
                if (str3.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    return str3.replace(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2 + ContainerUtils.FIELD_DELIMITER) + str4;
                }
                return str3 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2 + str4;
            }
            if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                return str.replace(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2 + ContainerUtils.FIELD_DELIMITER);
            }
            return str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2;
        }
        return str;
    }

    private static boolean c(String str, AppRuntime appRuntime, com.tencent.biz.common.offline.a aVar, int i3) {
        if (aVar == null) {
            if (f78403f.isColorLevel()) {
                f78403f.i("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId, callback is null!");
            }
            return true;
        }
        if (com.tencent.biz.common.offline.c.c(str) == null) {
            if (f78403f.isColorLevel()) {
                f78403f.i("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId,no sd card!");
            }
            aVar.loaded(null, 3);
            return true;
        }
        if (Arrays.asList(f78399b).contains(str)) {
            if (f78403f.isColorLevel()) {
                f78403f.i("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId,do not update");
            }
            return true;
        }
        if (i3 <= 60 && i3 >= 0) {
            if (appRuntime != null && appRuntime.isLogin()) {
                return false;
            }
            QLog.w("HtmlCheckUpdate", 1, "app == null or user not login.");
            return true;
        }
        if (f78403f.isColorLevel()) {
            f78403f.i("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId,delayed too long.");
        }
        return true;
    }

    public static void d(String str, AppRuntime appRuntime) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        g(str, appRuntime, true, f78405h);
    }

    public static void e(final String str, final AppRuntime appRuntime, final com.tencent.biz.common.offline.a aVar) {
        if (aVar == null) {
            return;
        }
        com.tencent.biz.common.offline.d.a().b(new Runnable() { // from class: com.tencent.biz.common.offline.HtmlOffline.2
            @Override // java.lang.Runnable
            public void run() {
                HtmlOffline.g(str, appRuntime, false, aVar);
            }
        });
    }

    public static void f(String str, AppRuntime appRuntime, com.tencent.biz.common.offline.a aVar, boolean z16) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        HashMap hashMap = new HashMap(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            JSONObject t16 = t(str2);
            if (t16 != null) {
                String optString = t16.optString("version");
                if (!TextUtils.isEmpty(optString)) {
                    hashMap.put(str2, optString);
                }
            } else {
                hashMap.put(str2, "0");
            }
        }
        l(appRuntime, hashMap, aVar, z16, false, false);
    }

    protected static void g(String str, AppRuntime appRuntime, boolean z16, com.tencent.biz.common.offline.a aVar) {
        if (f78403f.isDevelopLevel()) {
            f78403f.i("HtmlCheckUpdate", 2, "-->offline:checkUp,url=" + str + ",callback=" + aVar);
        }
        if (aVar == null) {
            return;
        }
        String queryParameter = Uri.parse(str).getQueryParameter("_bid");
        int s16 = AuthorizeConfig.z(true).s(str);
        if (s16 == 0) {
            s16 = 5;
        }
        h(queryParameter, appRuntime, aVar, z16, s16);
    }

    public static void h(String str, AppRuntime appRuntime, com.tencent.biz.common.offline.a aVar, boolean z16, int i3) {
        i(str, appRuntime, aVar, z16, 5, false);
    }

    @Deprecated
    public static void i(String str, AppRuntime appRuntime, com.tencent.biz.common.offline.a aVar, boolean z16, int i3, boolean z17) {
        k(str, appRuntime, aVar, true, i3, z17);
    }

    public static void j(String str, AppRuntime appRuntime, boolean z16, com.tencent.biz.common.offline.a aVar) {
        h(str, appRuntime, aVar, z16, 5);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void k(final String str, final AppRuntime appRuntime, final com.tencent.biz.common.offline.a aVar, final boolean z16, int i3, final boolean z17) {
        long j3;
        if (f78403f.isDevelopLevel()) {
            f78403f.i("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId " + str);
        }
        if (c(str, appRuntime, aVar, i3)) {
            return;
        }
        JSONObject t16 = t(str);
        if (t16 != null) {
            try {
                j3 = t16.getLong("frequency");
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            long currentTimeMillis = (System.currentTimeMillis() - w(appRuntime.getApplication(), str)) / 60000;
            if (f78403f.isColorLevel()) {
                f78403f.i("HtmlCheckUpdate", 2, "-->offline:checkUpdate check freq:" + j3 + ", time:" + currentTimeMillis);
            }
            if (!z17) {
                if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                    if (((Boolean) t.j().b("debug_webview_rate", Boolean.TRUE)).booleanValue() && currentTimeMillis < j3) {
                        if (QLog.isColorLevel()) {
                            QLog.i("HtmlCheckUpdate", 2, "-->offline:checkUpdate check too short! " + currentTimeMillis);
                        }
                        aVar.loaded(null, 5);
                        return;
                    }
                } else if (currentTimeMillis < j3) {
                    aVar.loaded(null, 5);
                    return;
                }
            }
            if (!BidDownloader.j(str)) {
                if (f78403f.isColorLevel()) {
                    f78403f.i("HtmlCheckUpdate", 2, "-->offline:" + str + " is downloading");
                }
                aVar.loaded(null, 7);
                return;
            }
            Q(appRuntime.getApplication().getApplicationContext(), str);
            final HashMap hashMap = new HashMap(1);
            int i16 = 0;
            if (t16 != null) {
                i16 = t16.optInt("version", 0);
            }
            hashMap.put(str, i16 + "");
            if (f78403f.isColorLevel()) {
                f78403f.i("HtmlCheckUpdate", 2, "start checkUpThread. delay:" + i3 + ", businessId:" + str);
            }
            com.tencent.biz.common.offline.d.a().c(new Runnable() { // from class: com.tencent.biz.common.offline.HtmlOffline.4
                @Override // java.lang.Runnable
                public void run() {
                    if (HtmlOffline.f78403f.isColorLevel()) {
                        HtmlOffline.f78403f.i("HtmlCheckUpdate", 2, "checkUpThread businessId:" + str);
                    }
                    HtmlOffline.l(appRuntime, hashMap, aVar, true, z16, z17);
                }
            }, i3 * 1000);
            return;
        }
        j3 = 30;
        long currentTimeMillis2 = (System.currentTimeMillis() - w(appRuntime.getApplication(), str)) / 60000;
        if (f78403f.isColorLevel()) {
        }
        if (!z17) {
        }
        if (!BidDownloader.j(str)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void l(AppRuntime appRuntime, HashMap<String, String> hashMap, com.tencent.biz.common.offline.a aVar, boolean z16, boolean z17, boolean z18) {
        int i3;
        int i16;
        if (QLog.isColorLevel()) {
            QLog.d("HtmlCheckUpdate", 2, "-->offline:checkUpdate");
        }
        NewIntent newIntent = new NewIntent(appRuntime.getApplication().getApplicationContext(), ((com.tencent.mobileqq.webview.swift.injector.n) aa.k(com.tencent.mobileqq.webview.swift.injector.n.class)).c());
        newIntent.putExtra("cmd", "offlinepkg.check");
        OfflinePkg$ReqBody offlinePkg$ReqBody = new OfflinePkg$ReqBody();
        offlinePkg$ReqBody.uint32_cmd.set(3);
        offlinePkg$ReqBody.uint32_platform.set(3);
        String str = ((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).getSubVersion() + "." + ((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).f();
        if (hashMap == null) {
            QLog.e("HtmlCheckUpdate", 1, String.format("bidAndVers is null", new Object[0]));
            return;
        }
        if (hashMap.size() > 0) {
            QLog.d("HtmlCheckUpdate", 1, String.format("check update, QQ Version: %s", str));
            if (QLog.isColorLevel()) {
                QLog.d("OfflineCheck", 2, "send check" + hashMap.toString());
            }
        }
        offlinePkg$ReqBody.str_qver.set(ByteStringMicro.copyFrom(str.getBytes()));
        offlinePkg$ReqBody.str_osrelease.set(ByteStringMicro.copyFrom(Build.VERSION.RELEASE.getBytes()));
        offlinePkg$ReqBody.int32_network.set(NetworkUtil.getNetWorkType());
        offlinePkg$ReqBody.str_from.set(ByteStringMicro.copyFrom("predown".getBytes()));
        for (String str2 : hashMap.keySet()) {
            String str3 = hashMap.get(str2);
            try {
                i3 = Integer.valueOf(str2).intValue();
            } catch (NumberFormatException e16) {
                e = e16;
                i3 = 0;
            } catch (Exception unused) {
                i3 = 0;
            }
            try {
                i16 = Integer.valueOf(str3).intValue();
            } catch (NumberFormatException e17) {
                e = e17;
                e.printStackTrace();
                i16 = 0;
                if (i3 != 0) {
                }
            } catch (Exception unused2) {
                i16 = 0;
                if (i3 != 0) {
                }
            }
            if (i3 != 0) {
                OfflinePkg$BidPkg offlinePkg$BidPkg = new OfflinePkg$BidPkg();
                offlinePkg$BidPkg.uint32_bid.set(i3);
                offlinePkg$BidPkg.uint32_pkg_id.add(Integer.valueOf(i16));
                offlinePkg$ReqBody.st_bid_pkg.add(offlinePkg$BidPkg);
            }
        }
        try {
            newIntent.putExtra("data", offlinePkg$ReqBody.toByteArray());
            newIntent.setObserver(new b(aVar, appRuntime, z16, z17, z18, newIntent));
            appRuntime.startServlet(newIntent);
        } catch (Exception e18) {
            if (QLog.isColorLevel()) {
                QLog.e("HtmlCheckUpdate", 2, "offline check update exception!", e18);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean m(String str) {
        String d16 = com.tencent.biz.common.offline.c.d(str);
        String str2 = d16 + str + ".zip";
        String str3 = d16 + "tmp_c_" + System.currentTimeMillis() + File.separator;
        String str4 = str3 + str + ".zip";
        boolean z16 = false;
        if (!H(str3, str2, str4)) {
            QLog.w("HtmlCheckUpdate", 1, "combine renameToDest businessId.zip failed");
            return false;
        }
        String str5 = com.tencent.biz.common.offline.c.c(str) + str;
        String str6 = str5 + "/b.zip";
        String str7 = str3 + "/b.zip";
        if (!H(str3, str6, str7)) {
            QLog.w("HtmlCheckUpdate", 1, "combine renameToDest b.zip failed");
            return false;
        }
        File file = new File(str7);
        if (f78403f.isColorLevel()) {
            f78403f.i("HtmlCheckUpdate", 2, "combine zip" + str);
        }
        File file2 = new File(str4);
        if (file.exists() && file2.exists()) {
            try {
                if (file2.isDirectory()) {
                    QLog.e("HtmlCheckUpdate", 1, "FXXX! This is a wrong patch file! " + str4);
                    file2.delete();
                    return false;
                }
                z16 = ((v) aa.k(v.class)).patch(str3 + "/b.zip", str4, str4);
            } catch (Throwable unused) {
            }
        }
        H(str5 + "/", str7, str6);
        H(d16, str4, str2);
        com.tencent.mobileqq.webview.util.d.a(str3);
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static boolean n(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(new File(str2));
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    try {
                        open.close();
                    } catch (IOException unused) {
                    }
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (IOException unused2) {
                        return true;
                    }
                } catch (IOException e16) {
                    e = e16;
                    inputStream = open;
                    try {
                        e.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        if (fileOutputStream == null) {
                            try {
                                fileOutputStream.close();
                                throw th;
                            } catch (IOException unused6) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = open;
                    if (inputStream != null) {
                    }
                    if (fileOutputStream == null) {
                    }
                }
            } catch (IOException e17) {
                e = e17;
                fileOutputStream = null;
            } catch (Throwable th7) {
                th = th7;
                fileOutputStream = null;
            }
        } catch (IOException e18) {
            e = e18;
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream = null;
        }
    }

    public static void o(String str, String str2) {
        OfflinePlugin.Q(str2);
        com.tencent.mobileqq.webview.util.d.a(str);
        if (QLog.isColorLevel()) {
            QLog.d("HtmlCheckUpdate", 2, "dealVerifyErroFile fileDir:", str, " mBussinessId:", str2);
        }
    }

    private static void p(ArrayList<String> arrayList, AppRuntime appRuntime, com.tencent.biz.common.offline.a aVar, boolean z16, boolean z17) {
        if (arrayList.size() == 0) {
            return;
        }
        HashMap hashMap = new HashMap(arrayList.size());
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            JSONObject t16 = t(next);
            if (t16 != null) {
                String optString = t16.optString("version");
                if (!TextUtils.isEmpty(optString)) {
                    hashMap.put(next, optString);
                }
            } else {
                hashMap.put(next, "0");
            }
        }
        l(appRuntime, hashMap, aVar, z16, z17, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized boolean q(String str) {
        synchronized (HtmlOffline.class) {
            f78403f.i("HtmlCheckUpdate", 1, "-->offline:doUpdateZip start:" + str);
            boolean z16 = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String d16 = com.tencent.biz.common.offline.c.d(str);
            if (TextUtils.isEmpty(d16)) {
                if (f78403f.isColorLevel()) {
                    f78403f.i("HtmlCheckUpdate", 2, "-->offline:doUpdateZip,zip root dir is null:");
                }
                return false;
            }
            String str2 = d16 + str + ".zip";
            if (!new File(str2).exists()) {
                if (f78403f.isColorLevel()) {
                    f78403f.i("HtmlCheckUpdate", 2, "-->offline:doUpdateZip:no zip ! : businessId:" + str);
                }
                return false;
            }
            String c16 = com.tencent.biz.common.offline.c.c(str);
            String str3 = d16 + "tmp_u_" + System.currentTimeMillis() + File.separator;
            String str4 = str3 + str + ".zip";
            if (!H(str3, str2, str4)) {
                QLog.w("HtmlCheckUpdate", 1, "doUpdateZip renameToDest businessId.zip failed");
                return false;
            }
            File file = new File(str4);
            String str5 = c16 + str;
            String str6 = c16 + str + "_new";
            com.tencent.mobileqq.webview.util.d.a(str6);
            File file2 = new File(str6);
            if (!file2.mkdirs()) {
                if (f78403f.isColorLevel()) {
                    f78403f.d("HtmlCheckUpdate", 2, "-->offline:doUpdateZip,mkdirs: error:" + str6);
                }
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int d17 = ((com.tencent.mobileqq.webview.swift.injector.b) aa.k(com.tencent.mobileqq.webview.swift.injector.b.class)).d(str4, str6);
            if (d17 > 0) {
                if (f78400c == 0) {
                    f78400c = 2;
                }
                com.tencent.mobileqq.webview.util.d.b(str4);
                J(str, 13, 0L, d17, "lixian_update", "0");
                BidDownloader.m(0, str, 13, 0, "lixian_update", d17);
                if (f78403f.isColorLevel()) {
                    f78403f.i("HtmlCheckUpdate", 2, "-->offline:doUpdateZip,unZipFolder fail!");
                }
            } else {
                file.renameTo(new File(str6 + "/b.zip"));
                com.tencent.mobileqq.webview.util.d.a(str5);
                z16 = file2.renameTo(new File(str5));
                J(str, 13, 0L, d17, "lixian_time", "0");
                BidDownloader.m(0, str, 13, 0, "lixian_time", d17);
            }
            if (f78403f.isColorLevel()) {
                f78403f.i("HtmlCheckUpdate", 2, "-->offline:time of unzip\uff1a" + (System.currentTimeMillis() - currentTimeMillis) + ", isSuccess: " + z16);
            }
            com.tencent.mobileqq.webview.util.d.a(str3);
            return z16;
        }
    }

    public static void r(final Context context, final String str, final String str2, int i3, final com.tencent.biz.common.offline.a aVar) {
        long j3;
        if (aVar == null) {
            return;
        }
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String d16 = com.tencent.biz.common.offline.c.d(str);
            if (TextUtils.isEmpty(d16)) {
                aVar.loaded(null, 3);
                return;
            }
            JSONObject t16 = t(str);
            if (t16 != null) {
                try {
                    j3 = t16.getLong("frequency");
                } catch (Exception e16) {
                    e16.printStackTrace();
                    j3 = 30;
                }
                long currentTimeMillis = (System.currentTimeMillis() - w(context, str)) / 60000;
                if (f78403f.isColorLevel()) {
                    f78403f.i("HtmlCheckUpdate", 2, "checkUpdate check freq:" + j3 + ", time:" + currentTimeMillis);
                }
                if (currentTimeMillis < j3) {
                    aVar.loaded(null, 5);
                    return;
                }
            }
            if (BidDownloader.j(str)) {
                aVar.loaded(null, 7);
                return;
            }
            BidDownloader.b(str);
            final String str3 = d16 + str + ".zip";
            final long currentTimeMillis2 = System.currentTimeMillis();
            final HashMap hashMap = new HashMap();
            hashMap.put("Accept-Encoding", "gzip");
            com.tencent.biz.common.offline.d.a().b(new Runnable() { // from class: com.tencent.biz.common.offline.HtmlOffline.5

                /* compiled from: P */
                /* renamed from: com.tencent.biz.common.offline.HtmlOffline$5$a */
                /* loaded from: classes2.dex */
                class a implements com.tencent.biz.common.offline.a {
                    a() {
                    }

                    @Override // com.tencent.biz.common.offline.a
                    public void loaded(String str, int i3) {
                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                        if (HtmlOffline.f78403f.isColorLevel()) {
                            HtmlOffline.f78403f.i("HtmlCheckUpdate", 2, "js call downloadUpdate callback:" + i3 + ", time:" + currentTimeMillis);
                        }
                        if (i3 == 0) {
                            if (HtmlOffline.q(str)) {
                                aVar.loaded(null, 0);
                            } else {
                                aVar.loaded(null, 6);
                            }
                        } else {
                            aVar.loaded(null, 2);
                        }
                        BidDownloader.l(str);
                        HtmlOffline.I(str, i3, currentTimeMillis, NetworkUtil.getNetWorkType());
                    }

                    @Override // com.tencent.biz.common.offline.a
                    public void progress(int i3) {
                        aVar.progress(i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (HtmlOffline.f78402e == null) {
                        HtmlOffline.E();
                    }
                    px.c cVar = HtmlOffline.f78402e;
                    if (cVar == null) {
                        return;
                    }
                    cVar.a(context, str2, str, str3, new a(), hashMap);
                }
            });
            return;
        }
        aVar.loaded(null, 1);
    }

    public static JSONObject s(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                InputStream open = context.getAssets().open("html5/" + (str + "/config.json"));
                String c16 = com.tencent.mobileqq.webview.util.d.c(open);
                try {
                    open.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                try {
                    return new JSONObject(c16);
                } catch (JSONException e17) {
                    e17.printStackTrace();
                    if (f78403f.isColorLevel()) {
                        f78403f.i("HtmlCheckUpdate", 2, "error:getAssetConfig");
                    }
                }
            } catch (IOException unused) {
            }
        }
        return null;
    }

    public static JSONObject t(String str) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String c16 = com.tencent.biz.common.offline.c.c(str);
        if (TextUtils.isEmpty(c16)) {
            return null;
        }
        File file = new File(c16 + str + "/config.json");
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e16) {
                e16.printStackTrace();
                fileInputStream = null;
            }
            if (fileInputStream == null) {
                return null;
            }
            String c17 = com.tencent.mobileqq.webview.util.d.c(fileInputStream);
            try {
                fileInputStream.close();
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            try {
                return new JSONObject(c17);
            } catch (JSONException e18) {
                e18.printStackTrace();
            } catch (Exception e19) {
                e19.printStackTrace();
                return null;
            }
        }
        return null;
    }

    protected static int u(Context context, String str) {
        return ((Integer) t.m("busi_html_offline_").b("expire_" + str, 0)).intValue();
    }

    public static String v(String str) {
        int indexOf;
        int i3;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf(":")) < 0 || (i3 = indexOf + 3) >= str.length()) {
            return null;
        }
        String[] split = str.substring(i3).split("\\?");
        if (split[0].contains("#")) {
            split = split[0].split("\\#");
        }
        return split[0];
    }

    protected static long w(Context context, String str) {
        return ((Long) t.m("busi_html_offline_").b("last_up_" + str, 0L)).longValue();
    }

    public static String x() {
        StringBuffer stringBuffer = new StringBuffer();
        if (Environment.getExternalStorageState().equals("mounted")) {
            String A = A(com.tencent.biz.common.offline.c.e());
            if (!TextUtils.isEmpty(A)) {
                stringBuffer.append(A);
            }
        }
        if (f78401d == null) {
            f78401d = BaseApplication.getContext().getApplicationContext();
        }
        String A2 = A(com.tencent.biz.common.offline.c.a());
        if (!TextUtils.isEmpty(A2)) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(A2);
        }
        if (f78403f.isColorLevel()) {
            f78403f.d("HtmlCheckUpdate", 2, "getLocalOfflineVersions:" + stringBuffer.toString());
        }
        return stringBuffer.toString();
    }

    public static String y(String str) {
        String substring;
        int indexOf;
        String str2 = "file://" + com.tencent.biz.common.offline.c.e();
        if (str == null || !str.startsWith(str2) || (indexOf = (substring = str.substring(str2.length())).indexOf(47)) <= 0) {
            return "";
        }
        try {
            Integer.parseInt(substring.substring(0, indexOf), 10);
            String substring2 = substring.substring(indexOf + 1);
            if (substring2.length() > 0) {
                return "https://" + substring2;
            }
        } catch (NumberFormatException unused) {
        }
        return "";
    }

    public static String z(String str) {
        JSONObject t16;
        if (TextUtils.isEmpty(str) || (t16 = t(str)) == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long optLong = t16.optLong("expired", 0L);
        if (optLong > 0 && currentTimeMillis > optLong) {
            return null;
        }
        try {
            return t16.getString("version");
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements com.tencent.biz.common.offline.a {
        a() {
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            if (i3 == 0 && HtmlOffline.f78403f.isColorLevel()) {
                HtmlOffline.f78403f.i("HtmlCheckUpdate", 2, "CODE_SUCCESS");
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
        }
    }
}
