package com.tencent.tgpa.vendorpd.a;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.tgpa.vendorpd.BuildConfig;
import com.tencent.tgpa.vendorpd.CombinationInfo;
import com.tencent.tgpa.vendorpd.GameCallback;
import com.tencent.tgpa.vendorpd.GamePredownloader;
import com.tencent.tgpa.vendorpd.b.e;
import com.tencent.tgpa.vendorpd.b.f;
import com.tencent.tgpa.vendorpd.gradish.GradishWrapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f375999a;

    /* renamed from: b, reason: collision with root package name */
    private String f376000b;

    /* renamed from: c, reason: collision with root package name */
    private String f376001c;

    /* renamed from: d, reason: collision with root package name */
    private String f376002d;

    /* renamed from: e, reason: collision with root package name */
    private String f376003e;

    /* renamed from: f, reason: collision with root package name */
    private String f376004f;

    /* renamed from: g, reason: collision with root package name */
    private GameCallback f376005g;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class a extends AsyncTask<String, Void, Void> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final String f376010a;

        /* renamed from: b, reason: collision with root package name */
        private final HashMap<String, String> f376011b;

        /* renamed from: c, reason: collision with root package name */
        private final c f376012c;

        public a(String str, c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) cVar);
                return;
            }
            this.f376010a = str;
            this.f376011b = new HashMap<>();
            this.f376012c = cVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Void) iPatchRedirector.redirect((short) 3, (Object) this, (Object) strArr);
            }
            try {
                HashMap<String, String> a16 = this.f376012c.a();
                HashMap<String, String> b16 = this.f376012c.b();
                HashMap<String, String> hashMap = this.f376011b;
                if (hashMap != null) {
                    b16.putAll(hashMap);
                }
                for (Map.Entry<String, String> entry : b16.entrySet()) {
                    if (entry.getValue() == null) {
                        b16.put(entry.getKey(), "");
                    }
                }
                f.a("start to request server, url: %s, header: %s , form data: %s", this.f376010a, a16.toString(), b16.toString());
                this.f376012c.a(e.a(this.f376010a, b16, a16));
                return null;
            } catch (IOException e16) {
                e16.printStackTrace();
                f.b("http request exception, ple check! url: %s", this.f376010a);
                return null;
            } catch (Exception e17) {
                e17.printStackTrace();
                f.d("request data code run exception, ple check!");
                return null;
            }
        }

        public a(String str, HashMap<String, String> hashMap, c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, hashMap, cVar);
                return;
            }
            this.f376010a = str;
            this.f376011b = hashMap;
            this.f376012c = cVar;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.tgpa.vendorpd.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C9915b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f376013a;

        /* renamed from: b, reason: collision with root package name */
        private String f376014b;

        /* renamed from: c, reason: collision with root package name */
        private String f376015c;

        /* renamed from: d, reason: collision with root package name */
        private String f376016d;

        /* renamed from: e, reason: collision with root package name */
        private String f376017e;

        /* renamed from: f, reason: collision with root package name */
        private String f376018f;

        /* renamed from: g, reason: collision with root package name */
        private GameCallback f376019g;

        public C9915b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f376014b = "default";
            this.f376019g = null;
            this.f376015c = "https://version.tgpa.qq.com";
            this.f376016d = null;
            this.f376017e = null;
        }

        public C9915b a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (C9915b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f376013a = str;
            return this;
        }

        public C9915b b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (C9915b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f376014b = str;
            return this;
        }

        public C9915b c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (C9915b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.f376016d = str;
            return this;
        }

        public C9915b d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (C9915b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.f376017e = str;
            return this;
        }

        public C9915b e(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (C9915b) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            this.f376018f = str;
            return this;
        }

        public C9915b a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (C9915b) iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
            this.f376015c = z16 ? "https://testversion.tgpa.qq.com" : "https://version.tgpa.qq.com";
            return this;
        }

        public b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? new b(this) : (b) iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface c {
        HashMap<String, String> a();

        void a(String str);

        HashMap<String, String> b();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final d f376020a;

        /* renamed from: b, reason: collision with root package name */
        public static final d f376021b;

        /* renamed from: c, reason: collision with root package name */
        public static final d f376022c;

        /* renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d[] f376023e;

        /* renamed from: d, reason: collision with root package name */
        private final String f376024d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12570);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            d dVar = new d("GetPredownloadInfo", 0, "pd_pkg_ver");
            f376020a = dVar;
            d dVar2 = new d("ReportChannelDownloadStatus", 1, "pd_data_report");
            f376021b = dVar2;
            d dVar3 = new d("GetCombineConfig", 2, "pd_combine_pkg");
            f376022c = dVar3;
            f376023e = new d[]{dVar, dVar2, dVar3};
        }

        d(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
            } else {
                this.f376024d = str2;
            }
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) f376023e.clone();
        }

        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f376024d;
        }
    }

    public b(C9915b c9915b) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) c9915b);
            return;
        }
        this.f375999a = c9915b.f376013a;
        this.f376000b = c9915b.f376014b;
        this.f376001c = c9915b.f376015c;
        this.f376002d = c9915b.f376016d;
        this.f376003e = c9915b.f376017e;
        this.f376004f = c9915b.f376018f;
        this.f376005g = c9915b.f376019g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(Context context, ArrayList<String> arrayList) {
        JSONObject jSONObject = new JSONObject();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str = arrayList.get(i3);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("vc", String.valueOf(com.tencent.tgpa.vendorpd.b.b.b(context, str))).put("vn", com.tencent.tgpa.vendorpd.b.b.a(context, str));
                jSONObject.put(str, jSONObject2);
            } catch (JSONException unused) {
                f.a("get game local version info exception! pkg: %s", str);
            }
        }
        return jSONObject.toString();
    }

    public b a(GameCallback gameCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (b) iPatchRedirector.redirect((short) 1, (Object) this, (Object) gameCallback);
        }
        this.f376005g = gameCallback;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        GamePredownloader.RetMsg retMsg;
        if (str == null) {
            f.b("onResponse: request predownload info failed!");
            retMsg = GamePredownloader.RetMsg.NetworkException;
        } else {
            try {
                f.a("onResponse: request version response data: %s", str);
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("ret") || !jSONObject.has("data")) {
                    f.b("OnResponse: request failed, json format is not correct! please check the data: %s", str);
                    return GamePredownloader.RetMsg.ResponseDataJsonFormatException.getJsonData();
                }
                if (jSONObject.getInt("ret") != 0) {
                    f.b("OnResponse: request failed, ret is not 0! please check response: %s", str);
                    return jSONObject.toString();
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    try {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject(str2);
                        String string = jSONObject3.getString("path");
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(Environment.getExternalStorageDirectory());
                        String str3 = File.separator;
                        sb5.append(str3);
                        sb5.append(string);
                        sb5.append(str3);
                        jSONObject3.put("path", sb5.toString());
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        f.d("onResponse: check game predownload info exception. game: " + str2);
                    }
                }
                return jSONObject.toString();
            } catch (Exception e17) {
                e17.printStackTrace();
                f.d("OnResponse: network response content parse to json exception.");
                retMsg = GamePredownloader.RetMsg.ResponseDataIsNotJson;
            }
        }
        return retMsg.getJsonData();
    }

    public String a(String str, CombinationInfo combinationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            String str2 = this.f376001c + "/" + d.f376022c.a();
            HashMap<String, String> a16 = a();
            a16.put("app_name", str);
            String valueOf = String.valueOf(System.currentTimeMillis());
            String c16 = com.tencent.tgpa.vendorpd.b.d.c(combinationInfo.predownFilePath);
            String str3 = combinationInfo.cdnMD5;
            if (str3 == null) {
                str3 = "";
            }
            String format = String.format("time_stamp=%s&api_key=%s&api_secret=%s&cdn_url=%s&cdn_md5=%s&game_package=%s&predownload_file=%s", valueOf, this.f376002d, this.f376003e, combinationInfo.cdnUrl, str3, combinationInfo.gamePackageName, c16);
            HashMap hashMap = new HashMap();
            hashMap.put("time_stamp", valueOf);
            hashMap.put("api_key", this.f376002d);
            hashMap.put("api_sign", String.valueOf(com.tencent.tgpa.vendorpd.b.c.a(format)));
            hashMap.put("model", DeviceInfoMonitor.getModel());
            hashMap.put("manufacturer", Build.MANUFACTURER);
            hashMap.put(WadlProxyConsts.CHANNEL, this.f376000b);
            hashMap.put("sdk_code", String.valueOf(17));
            hashMap.put("sdk_version", BuildConfig.VERSION_NAME);
            hashMap.put("cdn_url", combinationInfo.cdnUrl);
            String str4 = combinationInfo.cdnMD5;
            if (str4 == null) {
                str4 = "";
            }
            hashMap.put("cdn_md5", str4);
            hashMap.put("game_package", combinationInfo.gamePackageName);
            hashMap.put("predownload_file", c16);
            hashMap.put("predownfile_md5", combinationInfo.predownFileMD5);
            hashMap.put("app_name", str);
            hashMap.put("xid", GradishWrapper.getXID());
            String str5 = this.f376004f;
            hashMap.put("oaid", str5 != null ? str5 : "");
            try {
                f.a("request combine config, data: %s , header: %s", hashMap.toString(), a16.toString());
                return e.a(str2, hashMap, a16);
            } catch (IOException e16) {
                e16.printStackTrace();
                f.d("request predownload combine config exception.");
                return null;
            }
        }
        return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) combinationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        hashMap.put("X-Requested-With", "XMLHttpRequest");
        hashMap.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.116");
        return hashMap;
    }

    public void a(Context context, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) arrayList);
            return;
        }
        new a(this.f376001c + "/" + d.f376020a.a(), new c(context, arrayList) { // from class: com.tencent.tgpa.vendorpd.a.b.1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f376006a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ArrayList f376007b;

            {
                this.f376006a = context;
                this.f376007b = arrayList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, b.this, context, arrayList);
                }
            }

            @Override // com.tencent.tgpa.vendorpd.a.b.c
            public HashMap<String, String> a() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? b.this.a() : (HashMap) iPatchRedirector2.redirect((short) 2, (Object) this);
            }

            @Override // com.tencent.tgpa.vendorpd.a.b.c
            public HashMap<String, String> b() {
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                    String b16 = b.this.b(this.f376006a, this.f376007b);
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    String format = String.format("app_data=%s&time_stamp=%s&api_key=%s&api_secret=%s", b16, valueOf, b.this.f376002d, b.this.f376003e);
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("time_stamp", valueOf);
                    hashMap.put("app_data", b16);
                    hashMap.put("api_sign", String.valueOf(com.tencent.tgpa.vendorpd.b.c.a(format)));
                    hashMap.put("api_key", b.this.f376002d);
                    hashMap.put("model", DeviceInfoMonitor.getModel());
                    hashMap.put("manufacturer", Build.MANUFACTURER);
                    hashMap.put(WadlProxyConsts.CHANNEL, b.this.f376000b);
                    hashMap.put("app_name", b.this.f375999a);
                    hashMap.put("sdk_code", String.valueOf(17));
                    hashMap.put("sdk_version", BuildConfig.VERSION_NAME);
                    hashMap.put("xid", GradishWrapper.getXID());
                    if (b.this.f376004f != null) {
                        str = b.this.f376004f;
                    } else {
                        str = "";
                    }
                    hashMap.put("oaid", str);
                    return hashMap;
                }
                return (HashMap) iPatchRedirector2.redirect((short) 3, (Object) this);
            }

            @Override // com.tencent.tgpa.vendorpd.a.b.c
            public void a(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) str);
                    return;
                }
                String a16 = b.this.a(str);
                f.a("onResponse: callback data has been prepared, data: %s", a16);
                if (b.this.f376005g != null) {
                    b.this.f376005g.getPreDownloadVersionInfo(a16);
                } else {
                    f.d("onResponse: no callback is found!");
                }
            }
        }).execute(new String[0]);
    }

    public void a(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) hashMap);
            return;
        }
        new a(this.f376001c + "/" + d.f376021b.a(), hashMap, new c() { // from class: com.tencent.tgpa.vendorpd.a.b.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // com.tencent.tgpa.vendorpd.a.b.c
            public HashMap<String, String> a() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? b.this.a() : (HashMap) iPatchRedirector2.redirect((short) 2, (Object) this);
            }

            @Override // com.tencent.tgpa.vendorpd.a.b.c
            public HashMap<String, String> b() {
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return (HashMap) iPatchRedirector2.redirect((short) 3, (Object) this);
                }
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("api_key", b.this.f376002d);
                hashMap2.put("model", DeviceInfoMonitor.getModel());
                hashMap2.put("manufacturer", Build.MANUFACTURER);
                hashMap2.put(WadlProxyConsts.CHANNEL, b.this.f376000b);
                hashMap2.put("app_name", b.this.f375999a);
                hashMap2.put("sdk_code", String.valueOf(17));
                hashMap2.put("sdk_version", BuildConfig.VERSION_NAME);
                hashMap2.put("xid", GradishWrapper.getXID());
                if (b.this.f376004f != null) {
                    str = b.this.f376004f;
                } else {
                    str = "";
                }
                hashMap2.put("oaid", str);
                return hashMap2;
            }

            @Override // com.tencent.tgpa.vendorpd.a.b.c
            public void a(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) str);
                } else if (str != null) {
                    f.a("Channel download result report success. data: %s", str);
                } else {
                    f.b("Channel download result report failed. ");
                }
            }
        }).execute(new String[0]);
    }
}
