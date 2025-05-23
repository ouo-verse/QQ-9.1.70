package h20;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.util.AppSetting;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f404075a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f404076b;

    /* compiled from: P */
    /* renamed from: h20.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C10409a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f404077a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f404078b;

        C10409a(Context context, b bVar) {
            this.f404077a = context;
            this.f404078b = bVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            QLog.d("QCircleEvilReport", 1, "repose is failed jump to h5");
            a.e(this.f404077a, this.f404078b, "Jbq0Dm55FudiaTa26UjP071XduhCyIKRYaK6MCcYzZA");
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            try {
                String optString = new JSONObject(response.body().string()).optString("key");
                QLog.d("QCircleEvilReport", 1, "response is success jump to h5");
                a.e(this.f404077a, this.f404078b, optString);
            } catch (Throwable th5) {
                QLog.d("QCircleEvilReport", 1, "response is failed" + th5);
                th5.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f404079a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f404080b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f404081c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f404082d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f404083e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f404084f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f404085g = "";

        /* renamed from: h, reason: collision with root package name */
        public String f404086h = "";

        /* renamed from: i, reason: collision with root package name */
        public String f404087i = "";

        /* renamed from: j, reason: collision with root package name */
        public String f404088j = "";

        /* renamed from: k, reason: collision with root package name */
        public String f404089k = "0";

        /* renamed from: l, reason: collision with root package name */
        public String f404090l = "";

        /* renamed from: m, reason: collision with root package name */
        public String f404091m = "";

        /* renamed from: n, reason: collision with root package name */
        public String f404092n = "chatmsg:";

        /* renamed from: o, reason: collision with root package name */
        public String f404093o = "";

        /* renamed from: p, reason: collision with root package name */
        public String f404094p = "";

        /* renamed from: q, reason: collision with root package name */
        public String f404095q = "";

        /* renamed from: r, reason: collision with root package name */
        public String f404096r = "";

        /* renamed from: s, reason: collision with root package name */
        public String f404097s = "";

        /* renamed from: t, reason: collision with root package name */
        public String f404098t = "";

        /* renamed from: u, reason: collision with root package name */
        public String f404099u = "";

        /* renamed from: v, reason: collision with root package name */
        public String f404100v = "";

        /* renamed from: w, reason: collision with root package name */
        public String f404101w = "";

        /* renamed from: x, reason: collision with root package name */
        public String f404102x = "";

        /* renamed from: y, reason: collision with root package name */
        public String f404103y = "";

        /* renamed from: z, reason: collision with root package name */
        public String f404104z = "";
        public String A = "";
        public String B = "";
    }

    static {
        String str;
        String str2;
        if (AppSetting.isDebugVersion()) {
            str = "https://jubaobest.qq.com/uniform_impeach/impeach_entry";
        } else {
            str = "https://jubao.qq.com/uniform_impeach/impeach_entry";
        }
        f404075a = str;
        if (AppSetting.isDebugVersion()) {
            str2 = "https://jubaobest.qq.com/uniform_impeach/impeach_cryptokey";
        } else {
            str2 = "https://jubao.qq.com/uniform_impeach/impeach_cryptokey";
        }
        f404076b = str2;
    }

    private static String b(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec("d41d8cd98f00b204e9800998ecf8427e".getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(decode), "utf-8");
        } catch (Throwable th5) {
            QLog.e("NewEvilReportUtils", 1, "decrypt key error:", th5);
            return "";
        }
    }

    public static void c(Context context, b bVar) {
        if (context != null && bVar != null) {
            new OkHttpClient().newCall(new Request.Builder().url(f404076b).build()).enqueue(new C10409a(context, bVar));
        } else {
            QLog.d("QCircleEvilReport", 1, "context or reportParam is empty");
        }
    }

    private static String d(b bVar, String str) {
        return MD5.toMD5((bVar.f404085g + "_" + bVar.f404084f + "_" + bVar.f404098t + "_" + bVar.f404089k + "_" + bVar.f404091m + "_" + bVar.f404099u + "_" + bVar.f404082d + "_" + bVar.f404083e + "_" + bVar.f404097s + "_" + bVar.f404090l + "_" + bVar.f404094p + "_" + bVar.f404088j + "_" + bVar.f404087i + "_" + bVar.f404092n + "_" + bVar.f404086h + "_" + bVar.f404079a + "_" + bVar.f404093o + "_" + bVar.f404081c + "_" + bVar.f404095q + "_" + bVar.f404080b + "_" + bVar.f404096r + "_" + MD5.toMD5(bVar.f404079a + "_" + bVar.f404080b + "_" + bVar.f404087i + "_" + b(str))).getBytes(StandardCharsets.UTF_8)).toLowerCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Context context, b bVar, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserDelegationActivity");
        intent.putExtra("url", f404075a + "?system=" + bVar.f404079a + "&version=" + bVar.f404080b + "&uintype=" + bVar.f404081c + "&eviluin=" + bVar.f404082d + "&eviluin_type=" + bVar.f404083e + "&appname=" + bVar.f404084f + "&appid=" + bVar.f404085g + "&subapp=" + bVar.f404086h + "&scene=" + bVar.f404087i + "&is_anonymous=" + bVar.f404088j + "&buddyflag=" + bVar.f404089k + "&groupid=" + bVar.f404090l + "&contentid=" + bVar.f404091m + "&srv_para=" + bVar.f404092n + "&text_evidence=" + URLEncoder.encode(bVar.f404093o) + "&img_evidence=" + URLEncoder.encode(bVar.f404094p) + "&url_evidence=" + bVar.f404095q + "&video_evidence=" + URLEncoder.encode(bVar.f404096r) + "&file_evidence=" + bVar.f404097s + "&audio_evidence=" + bVar.f404098t + "&crypto_version=" + bVar.f404099u + "&cryptograph=" + d(bVar, str) + "&user_input_param=" + bVar.f404101w + "&chatuin=" + bVar.f404102x + "&groupcode=" + bVar.f404103y + "&chattype=" + bVar.f404104z + "&topicid=" + bVar.A + "&uinname=" + bVar.B);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }
}
