package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.bp;
import com.tencent.mapsdk.internal.kp;
import com.tencent.mapsdk.internal.kq;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class gq {

    /* renamed from: a, reason: collision with root package name */
    static volatile boolean f148570a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends JsonComposer {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "name")
        String f148582a;

        /* renamed from: b, reason: collision with root package name */
        @Json(name = "token")
        b f148583b;

        /* renamed from: c, reason: collision with root package name */
        @Json(name = AlbumCacheData.CREATE_TIME)
        long f148584c;

        /* renamed from: d, reason: collision with root package name */
        @Json(ignore = true)
        bp f148585d;

        public a(bp bpVar) {
            this(bpVar, "");
        }

        private long c() {
            return this.f148584c;
        }

        private long d() {
            b bVar = this.f148583b;
            if (bVar != null) {
                return Long.parseLong(bVar.f148590b);
            }
            return 0L;
        }

        private String e() {
            return "https://" + this.f148583b.f148591c + "/" + b();
        }

        /* JADX WARN: Type inference failed for: r7v13, types: [com.tencent.tencentmap.mapsdk.maps.TencentMap] */
        private boolean f() throws Exception {
            byte[] c16;
            File[] listFiles;
            if (this.f148585d == null) {
                return false;
            }
            File file = new File(mz.a(this.f148585d.getContext(), (TencentMapOptions) null).a());
            File a16 = kt.a(file, a());
            LogUtil.c(ky.f149104j, "\u521b\u5efa\u4e0a\u4f20\u6587\u4ef6\u76ee\u5f55:".concat(String.valueOf(a16)));
            File b16 = kt.b(a16, "base-info.txt");
            StringBuilder sb5 = new StringBuilder();
            bp.b D = this.f148585d.D();
            sb5.append(ho.a(D.f147927c, D.f147928d));
            sb5.append("&engine_draw_version=");
            sb5.append(this.f148585d.E());
            sb5.append("&engine_data_version=");
            sb5.append(this.f148585d.F());
            sb5.append("&camera=");
            sb5.append(this.f148585d.f147916c.getMap().getCameraPosition());
            LogUtil.c(ky.f149104j, "\u65e5\u5fd7\u6570\u636e:".concat(String.valueOf(sb5)));
            kt.a(b16, sb5.toString().getBytes());
            LogUtil.c(ky.f149104j, "\u6536\u96c6\u65e5\u5fd7\u6570\u636e\u81f3\u6587\u4ef6:".concat(String.valueOf(b16)));
            kt.b(new File(mz.a(this.f148585d.getContext(), (TencentMapOptions) null).a(this.f148585d.D().f147927c)), new File(a16, DownloadInfo.spKey_Config));
            String a17 = this.f148585d.H().a();
            if (!TextUtils.isEmpty(a17)) {
                File b17 = kt.b(a16, "engine-crash-info.txt");
                LogUtil.c(ky.f149104j, "\u6536\u96c6\u5f15\u64ceCrash\u81f3\u6587\u4ef6:".concat(String.valueOf(b17)));
                kt.a(b17, a17.getBytes());
            }
            String b18 = this.f148585d.H().b();
            if (!TextUtils.isEmpty(b18)) {
                File b19 = kt.b(a16, "engine-log-info.txt");
                LogUtil.c(ky.f149104j, "\u6536\u96c6\u5f15\u64ce\u65e5\u5fd7\u81f3\u6587\u4ef6:".concat(String.valueOf(b19)));
                kt.a(b19, b18.getBytes());
            }
            File d16 = u.a().f151144a.d();
            if (d16 != null && d16.exists() && d16.isDirectory() && (listFiles = d16.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists() && file2.isFile()) {
                        kt.b(file2, new File(a16, "plugin"));
                    }
                }
            }
            String a18 = LogUtil.a();
            if (!TextUtils.isEmpty(a18)) {
                File file3 = new File(a18);
                if (file3.exists() && file3.isDirectory()) {
                    File[] e16 = kt.e(file3, ".*.log.*");
                    if (e16 != null) {
                        for (File file4 : e16) {
                            if (file4 != null && file4.exists() && file4.isFile()) {
                                kt.b(file4, new File(a16, "logs"));
                            }
                        }
                    }
                    File[] e17 = kt.e(file3, "archive-.*.zip");
                    if (e17 != null) {
                        for (File file5 : e17) {
                            if (file5 != null && file5.exists() && file5.isFile()) {
                                kt.b(file5, new File(a16, "archives"));
                            }
                        }
                    }
                }
            }
            File a19 = kw.a(a16, file.getAbsolutePath());
            LogUtil.c(ky.f149104j, "\u6253\u5305\u6210zip\u6587\u4ef6:".concat(String.valueOf(a19)));
            if (a19 == null || (c16 = kt.c(a19)) == null) {
                return false;
            }
            LogUtil.c(ky.f149104j, "zip\u6587\u4ef6\u5927\u5c0f:" + c16.length);
            if (c16.length > 0) {
                LogUtil.c(ky.f149104j, "\u5f00\u59cb\u4e0a\u4f20\u6587\u4ef6\u5230\uff1a" + e());
                String a26 = lj.a(a19);
                NetRequest postData = new NetRequest(NetMethod.PUT, e()).setPostData(c16);
                StringBuilder sb6 = new StringBuilder();
                sb6.append(c16.length);
                NetResponse doRequest = NetManager.getInstance().doRequest(postData.setMapHeaders("Content-Length", sb6.toString()).setMapHeaders("Authorization", this.f148583b.f148589a).setMapHeaders("x-cos-content-sha1", a26).setTimeout(120000));
                LogUtil.c(ky.f149104j, "\u7ed3\u675f\u4e0a\u4f20\u6587\u4ef6");
                kt.b(a19);
                kt.b(a16);
                int i3 = doRequest.statusCode;
                LogUtil.c(ky.f149104j, "\u4e0a\u4f20\u72b6\u6001:".concat(String.valueOf(i3)));
                if (i3 == 200) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Type inference failed for: r1v13, types: [com.tencent.tencentmap.mapsdk.maps.TencentMap] */
        private byte[] g() {
            StringBuilder sb5 = new StringBuilder();
            bp.b D = this.f148585d.D();
            sb5.append(ho.a(D.f147927c, D.f147928d));
            sb5.append("&engine_draw_version=");
            sb5.append(this.f148585d.E());
            sb5.append("&engine_data_version=");
            sb5.append(this.f148585d.F());
            sb5.append("&camera=");
            sb5.append(this.f148585d.f147916c.getMap().getCameraPosition());
            LogUtil.c(ky.f149104j, "\u65e5\u5fd7\u6570\u636e:".concat(String.valueOf(sb5)));
            return sb5.toString().getBytes();
        }

        public final String a() {
            return "android-" + this.f148582a + "-" + this.f148584c;
        }

        public final String b() {
            return a() + ".zip";
        }

        public a(bp bpVar, String str) {
            this.f148582a = str;
            this.f148585d = bpVar;
            this.f148584c = System.currentTimeMillis();
        }

        public final boolean a(Context context) {
            b bVar;
            return (!NetUtil.isWifi(context) || (bVar = this.f148583b) == null || bVar.a()) ? false : true;
        }

        public final void a(final Callback<Boolean> callback) {
            kp.a((kp.g) new kp.g<Boolean>() { // from class: com.tencent.mapsdk.internal.gq.a.2
                private Boolean a() throws Exception {
                    return Boolean.valueOf(a.a(a.this));
                }

                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() throws Exception {
                    return Boolean.valueOf(a.a(a.this));
                }
            }).a((kp.a) new kp.a<Boolean>() { // from class: com.tencent.mapsdk.internal.gq.a.1
                private void a(Boolean bool) {
                    Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.callback(bool);
                    }
                }

                @Override // com.tencent.mapsdk.internal.kp.a, com.tencent.map.tools.Callback
                public final /* bridge */ /* synthetic */ void callback(Object obj) {
                    Boolean bool = (Boolean) obj;
                    Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.callback(bool);
                    }
                }
            });
        }

        /* JADX WARN: Type inference failed for: r7v13, types: [com.tencent.tencentmap.mapsdk.maps.TencentMap] */
        static /* synthetic */ boolean a(a aVar) throws Exception {
            byte[] c16;
            File[] listFiles;
            if (aVar.f148585d != null) {
                File file = new File(mz.a(aVar.f148585d.getContext(), (TencentMapOptions) null).a());
                File a16 = kt.a(file, aVar.a());
                LogUtil.c(ky.f149104j, "\u521b\u5efa\u4e0a\u4f20\u6587\u4ef6\u76ee\u5f55:".concat(String.valueOf(a16)));
                File b16 = kt.b(a16, "base-info.txt");
                StringBuilder sb5 = new StringBuilder();
                bp.b D = aVar.f148585d.D();
                sb5.append(ho.a(D.f147927c, D.f147928d));
                sb5.append("&engine_draw_version=");
                sb5.append(aVar.f148585d.E());
                sb5.append("&engine_data_version=");
                sb5.append(aVar.f148585d.F());
                sb5.append("&camera=");
                sb5.append(aVar.f148585d.f147916c.getMap().getCameraPosition());
                LogUtil.c(ky.f149104j, "\u65e5\u5fd7\u6570\u636e:".concat(String.valueOf(sb5)));
                kt.a(b16, sb5.toString().getBytes());
                LogUtil.c(ky.f149104j, "\u6536\u96c6\u65e5\u5fd7\u6570\u636e\u81f3\u6587\u4ef6:".concat(String.valueOf(b16)));
                kt.b(new File(mz.a(aVar.f148585d.getContext(), (TencentMapOptions) null).a(aVar.f148585d.D().f147927c)), new File(a16, DownloadInfo.spKey_Config));
                String a17 = aVar.f148585d.H().a();
                if (!TextUtils.isEmpty(a17)) {
                    File b17 = kt.b(a16, "engine-crash-info.txt");
                    LogUtil.c(ky.f149104j, "\u6536\u96c6\u5f15\u64ceCrash\u81f3\u6587\u4ef6:".concat(String.valueOf(b17)));
                    kt.a(b17, a17.getBytes());
                }
                String b18 = aVar.f148585d.H().b();
                if (!TextUtils.isEmpty(b18)) {
                    File b19 = kt.b(a16, "engine-log-info.txt");
                    LogUtil.c(ky.f149104j, "\u6536\u96c6\u5f15\u64ce\u65e5\u5fd7\u81f3\u6587\u4ef6:".concat(String.valueOf(b19)));
                    kt.a(b19, b18.getBytes());
                }
                File d16 = u.a().f151144a.d();
                if (d16 != null && d16.exists() && d16.isDirectory() && (listFiles = d16.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        if (file2 != null && file2.exists() && file2.isFile()) {
                            kt.b(file2, new File(a16, "plugin"));
                        }
                    }
                }
                String a18 = LogUtil.a();
                if (!TextUtils.isEmpty(a18)) {
                    File file3 = new File(a18);
                    if (file3.exists() && file3.isDirectory()) {
                        File[] e16 = kt.e(file3, ".*.log.*");
                        if (e16 != null) {
                            for (File file4 : e16) {
                                if (file4 != null && file4.exists() && file4.isFile()) {
                                    kt.b(file4, new File(a16, "logs"));
                                }
                            }
                        }
                        File[] e17 = kt.e(file3, "archive-.*.zip");
                        if (e17 != null) {
                            for (File file5 : e17) {
                                if (file5 != null && file5.exists() && file5.isFile()) {
                                    kt.b(file5, new File(a16, "archives"));
                                }
                            }
                        }
                    }
                }
                File a19 = kw.a(a16, file.getAbsolutePath());
                LogUtil.c(ky.f149104j, "\u6253\u5305\u6210zip\u6587\u4ef6:".concat(String.valueOf(a19)));
                if (a19 != null && (c16 = kt.c(a19)) != null) {
                    LogUtil.c(ky.f149104j, "zip\u6587\u4ef6\u5927\u5c0f:" + c16.length);
                    if (c16.length > 0) {
                        LogUtil.c(ky.f149104j, "\u5f00\u59cb\u4e0a\u4f20\u6587\u4ef6\u5230\uff1a" + aVar.e());
                        String a26 = lj.a(a19);
                        NetRequest postData = new NetRequest(NetMethod.PUT, aVar.e()).setPostData(c16);
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(c16.length);
                        NetResponse doRequest = NetManager.getInstance().doRequest(postData.setMapHeaders("Content-Length", sb6.toString()).setMapHeaders("Authorization", aVar.f148583b.f148589a).setMapHeaders("x-cos-content-sha1", a26).setTimeout(120000));
                        LogUtil.c(ky.f149104j, "\u7ed3\u675f\u4e0a\u4f20\u6587\u4ef6");
                        kt.b(a19);
                        kt.b(a16);
                        int i3 = doRequest.statusCode;
                        LogUtil.c(ky.f149104j, "\u4e0a\u4f20\u72b6\u6001:".concat(String.valueOf(i3)));
                        if (i3 == 200) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b extends JsonComposer {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "token")
        String f148589a;

        /* renamed from: b, reason: collision with root package name */
        @Json(name = "expire")
        String f148590b;

        /* renamed from: c, reason: collision with root package name */
        @Json(name = "host")
        String f148591c;

        b() {
        }

        final boolean a() {
            try {
                if (Long.parseLong(this.f148590b) < SystemClock.uptimeMillis() / 1000) {
                    return true;
                }
                return false;
            } catch (Exception e16) {
                e16.printStackTrace();
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(final Context context, final SharedPreferences sharedPreferences, final a aVar) {
        if (aVar != null && context != null) {
            if (LogUtil.e(ky.f149104j) && Build.VERSION.SDK_INT < 30) {
                try {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("\u65e5\u5fd7\u540d\u79f0:\n");
                    sb5.append(aVar.a());
                    sb5.append("\n");
                    String format = DateFormat.getInstance().format(new Date(aVar.f148584c));
                    sb5.append("\u521b\u5efa\u65f6\u95f4:\n");
                    sb5.append(format);
                    sb5.append("\n");
                    DateFormat dateFormat = DateFormat.getInstance();
                    b bVar = aVar.f148583b;
                    String format2 = dateFormat.format(new Date((bVar != null ? Long.parseLong(bVar.f148590b) : 0L) * 1000));
                    sb5.append("\u8fc7\u671f\u65f6\u95f4:\n");
                    sb5.append(format2);
                    sb5.append("\n");
                    final kq.a a16 = kq.a(context, "\u8c03\u8bd5\u6a21\u5f0f", sb5.toString(), 1);
                    return a16.a().a("\u4e0a\u62a5(\u4ec5WIFI)", new View.OnClickListener() { // from class: com.tencent.mapsdk.internal.gq.3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            EventCollector.getInstance().onViewClickedBefore(view);
                            if (!gq.f148570a && a.this.a(context)) {
                                a16.a("\u4e0a\u62a5\u4e2d", (View.OnClickListener) null);
                                a.this.a(new Callback<Boolean>() { // from class: com.tencent.mapsdk.internal.gq.3.1
                                    private void a(Boolean bool) {
                                        if (!bool.booleanValue()) {
                                            LogUtil.c(ky.f149104j, "\u6e05\u7406\u672c\u5730\u7f13\u5b58");
                                            kv.a(sharedPreferences).a("reportFile", "");
                                        }
                                        Toast toast = a16.f149059a;
                                        if (toast != null) {
                                            toast.cancel();
                                        }
                                        gq.f148570a = false;
                                    }

                                    @Override // com.tencent.map.tools.Callback
                                    public final /* synthetic */ void callback(Boolean bool) {
                                        if (!bool.booleanValue()) {
                                            LogUtil.c(ky.f149104j, "\u6e05\u7406\u672c\u5730\u7f13\u5b58");
                                            kv.a(sharedPreferences).a("reportFile", "");
                                        }
                                        Toast toast = a16.f149059a;
                                        if (toast != null) {
                                            toast.cancel();
                                        }
                                        gq.f148570a = false;
                                    }
                                });
                                gq.f148570a = true;
                            } else {
                                LogUtil.c(ky.f149104j, "\u6b63\u5728\u4e0a\u4f20\u4e2d");
                            }
                            EventCollector.getInstance().onViewClicked(view);
                        }
                    }).b();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } else if (!f148570a && aVar.a(context)) {
                aVar.a(new Callback<Boolean>() { // from class: com.tencent.mapsdk.internal.gq.4
                    private void a(Boolean bool) {
                        if (!bool.booleanValue()) {
                            LogUtil.c(ky.f149104j, "\u6e05\u7406\u672c\u5730\u7f13\u5b58");
                            kv.a(sharedPreferences).a("reportFile", "");
                        }
                        gq.f148570a = false;
                    }

                    @Override // com.tencent.map.tools.Callback
                    public final /* synthetic */ void callback(Boolean bool) {
                        if (!bool.booleanValue()) {
                            LogUtil.c(ky.f149104j, "\u6e05\u7406\u672c\u5730\u7f13\u5b58");
                            kv.a(sharedPreferences).a("reportFile", "");
                        }
                        gq.f148570a = false;
                    }
                });
                f148570a = true;
            }
        }
        return false;
    }

    public static boolean a(bp bpVar) {
        if (bpVar == null || bpVar.f147920g || bpVar.u().a()) {
            return false;
        }
        final Context context = bpVar.getContext();
        final bp.b D = bpVar.D();
        String a16 = D.a();
        final SharedPreferences a17 = kv.a(context, "uploadConfig." + D.c());
        final a aVar = null;
        String string = a17.getString("reportFile", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                LogUtil.c(ky.f149104j, "\u83b7\u53d6\u672c\u5730\u4e0a\u62a5\u6587\u4ef6\uff1a".concat(String.valueOf(string)));
                aVar = (a) JsonUtils.parseToModel(new JSONObject(string), a.class, bpVar);
            } catch (Exception unused) {
            }
        }
        if (aVar == null || !a16.equals(aVar.f148582a)) {
            LogUtil.c(ky.f149104j, "\u91cd\u65b0\u521b\u5efa\u4e0a\u62a5\u6587\u4ef6");
            aVar = new a(bpVar, a16);
        }
        b bVar = aVar.f148583b;
        if (bVar != null && !bVar.a()) {
            LogUtil.c(ky.f149104j, "\u4f7f\u7528\u672c\u5730\u4e0a\u62a5\u6587\u4ef6");
            return a(context, a17, aVar);
        }
        LogUtil.c(ky.f149104j, "\u8bf7\u6c42token");
        kp.a((kp.g) new kp.g<JSONObject>() { // from class: com.tencent.mapsdk.internal.gq.2
            private JSONObject a() throws Exception {
                cz czVar = (cz) ((dm) cr.a(dm.class)).i();
                String b16 = a.this.b();
                bp.b bVar2 = D;
                NetResponse uploadToken = czVar.uploadToken(b16, bVar2.f147925a, bVar2.f147926b);
                LogUtil.c(ky.f149104j, "\u54cd\u5e94\u72b6\u6001\uff1a" + uploadToken.statusCode);
                if (uploadToken.available()) {
                    String a18 = hs.a(uploadToken.data, uploadToken.charset);
                    LogUtil.c(ky.f149104j, "\u83b7\u53d6\u7f51\u7edctoken\u6570\u636e\uff1a".concat(String.valueOf(a18)));
                    if (!TextUtils.isEmpty(a18)) {
                        return new JSONObject(a18).optJSONObject("detail");
                    }
                    return null;
                }
                return null;
            }

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() throws Exception {
                cz czVar = (cz) ((dm) cr.a(dm.class)).i();
                String b16 = a.this.b();
                bp.b bVar2 = D;
                NetResponse uploadToken = czVar.uploadToken(b16, bVar2.f147925a, bVar2.f147926b);
                LogUtil.c(ky.f149104j, "\u54cd\u5e94\u72b6\u6001\uff1a" + uploadToken.statusCode);
                if (uploadToken.available()) {
                    String a18 = hs.a(uploadToken.data, uploadToken.charset);
                    LogUtil.c(ky.f149104j, "\u83b7\u53d6\u7f51\u7edctoken\u6570\u636e\uff1a".concat(String.valueOf(a18)));
                    if (!TextUtils.isEmpty(a18)) {
                        return new JSONObject(a18).optJSONObject("detail");
                    }
                    return null;
                }
                return null;
            }
        }).a((kp.a) new kp.a<JSONObject>() { // from class: com.tencent.mapsdk.internal.gq.1
            private void a(JSONObject jSONObject) {
                if (jSONObject != null) {
                    a.this.f148583b = (b) JsonUtils.parseToModel(jSONObject, b.class, new Object[0]);
                    gq.a(context, a17, a.this);
                    JSONObject modelToJson = JsonUtils.modelToJson(a.this);
                    if (modelToJson != null) {
                        LogUtil.c(ky.f149104j, "\u4fdd\u5b58\u4e0a\u62a5\u6587\u4ef6\u81f3\u672c\u5730");
                        kv.a(a17).a("reportFile", modelToJson.toString());
                    }
                }
            }

            @Override // com.tencent.mapsdk.internal.kp.a, com.tencent.map.tools.Callback
            public final /* synthetic */ void callback(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject != null) {
                    a.this.f148583b = (b) JsonUtils.parseToModel(jSONObject, b.class, new Object[0]);
                    gq.a(context, a17, a.this);
                    JSONObject modelToJson = JsonUtils.modelToJson(a.this);
                    if (modelToJson != null) {
                        LogUtil.c(ky.f149104j, "\u4fdd\u5b58\u4e0a\u62a5\u6587\u4ef6\u81f3\u672c\u5730");
                        kv.a(a17).a("reportFile", modelToJson.toString());
                    }
                }
            }
        });
        return false;
    }
}
