package com.tencent.biz.subscribe.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.IOException;
import java.net.URLEncoder;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* compiled from: P */
    /* renamed from: com.tencent.biz.subscribe.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0971a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f96247a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f96248b;

        C0971a(Context context, b bVar) {
            this.f96247a = context;
            this.f96248b = bVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            QLog.d("QCircleEvilReport", 1, "repose is failed jump to h5");
            a.e(this.f96247a, this.f96248b, "Jbq0Dm55FudiaTa26UjP071XduhCyIKRYaK6MCcYzZA");
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            try {
                String optString = new JSONObject(response.body().string()).optString("key");
                QLog.d("QCircleEvilReport", 1, "response is success jump to h5");
                a.e(this.f96247a, this.f96248b, optString);
            } catch (Throwable th5) {
                QLog.d("QCircleEvilReport", 1, "response is failed" + th5);
                th5.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f96249a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f96250b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f96251c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f96252d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f96253e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f96254f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f96255g = "";

        /* renamed from: h, reason: collision with root package name */
        public String f96256h = "";

        /* renamed from: i, reason: collision with root package name */
        public String f96257i = "";

        /* renamed from: j, reason: collision with root package name */
        public String f96258j = "";

        /* renamed from: k, reason: collision with root package name */
        public String f96259k = "";

        /* renamed from: l, reason: collision with root package name */
        public String f96260l = "";

        /* renamed from: m, reason: collision with root package name */
        public String f96261m = "";

        /* renamed from: n, reason: collision with root package name */
        public String f96262n = "";

        /* renamed from: o, reason: collision with root package name */
        public String f96263o = "";

        /* renamed from: p, reason: collision with root package name */
        public String f96264p = "";

        /* renamed from: q, reason: collision with root package name */
        public String f96265q = "";

        /* renamed from: r, reason: collision with root package name */
        public String f96266r = "";

        /* renamed from: s, reason: collision with root package name */
        public String f96267s = "";

        /* renamed from: t, reason: collision with root package name */
        public Bundle f96268t;
    }

    private static String b(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec("d41d8cd98f00b204e9800998ecf8427e".getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(decode), "utf-8");
        } catch (Throwable th5) {
            QLog.e("EvilReportUtil", 1, "decrypt key error! " + th5);
            return "";
        }
    }

    public static void c(Context context, b bVar) {
        if (context != null && bVar != null) {
            new OkHttpClient().newCall(new Request.Builder().url("https://jubao.qq.com/uniform_impeach/impeach_cryptokey").build()).enqueue(new C0971a(context, bVar));
        } else {
            QLog.d("QCircleEvilReport", 1, "context or reportParam is empty");
        }
    }

    private static String d(b bVar, String str) {
        return com.tencent.securitysdk.utils.c.b(bVar.f96252d + "_" + bVar.f96259k + "_" + bVar.f96260l + "_" + bVar.f96261m + "_" + bVar.f96262n + "_" + bVar.f96263o + "_" + bVar.f96264p + "_" + bVar.f96265q + "_" + com.tencent.securitysdk.utils.c.b(bVar.f96249a + "_" + bVar.f96250b + "_" + bVar.f96256h + "_" + b(str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Context context, b bVar, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserDelegationActivity");
        intent.putExtra("url", "https://jubao.qq.com/uniform_impeach/impeach_entry?system=" + bVar.f96249a + "&version=" + bVar.f96250b + "&uintype=" + bVar.f96251c + "&eviluin=" + bVar.f96252d + "&appname=" + bVar.f96253e + "&appid=" + bVar.f96254f + "&subapp=" + bVar.f96255g + "&scene=" + bVar.f96256h + "&buddyflag=" + bVar.f96257i + "&contentid=" + bVar.f96258j + "&srv_para=" + bVar.f96259k + "&text_evidence=" + bVar.f96260l + "&img_evidence=" + URLEncoder.encode(bVar.f96261m) + "&url_evidence=" + bVar.f96262n + "&video_evidence=" + URLEncoder.encode(bVar.f96263o) + "&file_evidence=" + bVar.f96264p + "&audio_evidence=" + bVar.f96265q + "&user_input_param=" + bVar.f96266r + "&groupid=" + bVar.f96267s + "&cryptograph=" + d(bVar, str));
        Bundle bundle = bVar.f96268t;
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }
}
