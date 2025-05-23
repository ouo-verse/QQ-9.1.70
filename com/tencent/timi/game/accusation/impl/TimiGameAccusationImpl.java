package com.tencent.timi.game.accusation.impl;

import android.content.Intent;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.timi.game.ui.widget.i;
import com.tencent.timi.game.utils.l;
import java.io.IOException;
import java.net.URLEncoder;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import mqq.util.WeakReference;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import pl4.d;
import trpc.yes.common.SafeOuterClass$QQGetUserSafeSercetRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiGameAccusationImpl {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<i> f376197a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f376198b = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements d<SafeOuterClass$QQGetUserSafeSercetRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.accusation.impl.a f376200a;

        a(com.tencent.timi.game.accusation.impl.a aVar) {
            this.f376200a = aVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable SafeOuterClass$QQGetUserSafeSercetRsp safeOuterClass$QQGetUserSafeSercetRsp, @Nullable FromServiceMsg fromServiceMsg) {
            TimiGameAccusationImpl.m(false);
            if (eh4.a.e()) {
                l.b("TimiGameAccusationImpl", "\u4e3e\u62a5\u5bc6\u94a5&\u52a0\u5bc6Uin\u5931\u8d25");
            }
            gn4.b.a("TimiGameAccusationImpl", i16, i17, str, str2);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(SafeOuterClass$QQGetUserSafeSercetRsp safeOuterClass$QQGetUserSafeSercetRsp, FromServiceMsg fromServiceMsg) {
            TimiGameAccusationImpl.f376198b = safeOuterClass$QQGetUserSafeSercetRsp.aes_decrypt_key.get();
            this.f376200a.f376205d = safeOuterClass$QQGetUserSafeSercetRsp.uin_key.get();
            if (eh4.a.e()) {
                l.b("TimiGameAccusationImpl", "\u4e3e\u62a5\u5bc6\u94a5&\u52a0\u5bc6Uin\u83b7\u53d6\u6210\u529f eviluin:" + safeOuterClass$QQGetUserSafeSercetRsp.uin_key.get() + "decypt key:" + TimiGameAccusationImpl.f376198b);
            }
            TimiGameAccusationImpl.l(this.f376200a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.accusation.impl.a f376201a;

        b(com.tencent.timi.game.accusation.impl.a aVar) {
            this.f376201a = aVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (eh4.a.e()) {
                QLog.d("TimiGameAccusationImpl", 4, "repose is failed jump to h5");
            }
            TimiGameAccusationImpl.m(false);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            try {
                TimiGameAccusationImpl.m(false);
                String string = response.body().string();
                if (eh4.a.e()) {
                    QLog.d("TimiGameAccusationImpl", 4, "response is " + string);
                }
                String optString = new JSONObject(string).optString("key");
                if (eh4.a.e()) {
                    QLog.d("TimiGameAccusationImpl", 4, "response is success jump to h5");
                }
                TimiGameAccusationImpl.k(this.f376201a, optString);
            } catch (Throwable th5) {
                if (eh4.a.e()) {
                    QLog.d("TimiGameAccusationImpl", 4, "response is failed" + th5);
                    th5.printStackTrace();
                }
            }
        }
    }

    private static String h(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(f376198b.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(decode), "utf-8");
        } catch (Throwable th5) {
            if (eh4.a.e()) {
                QLog.e("TimiGameAccusationImpl", 4, "decrypt key error! " + th5);
            }
            return "";
        }
    }

    public static void i(com.tencent.timi.game.accusation.impl.a aVar) {
        if (aVar == null) {
            if (eh4.a.e()) {
                QLog.d("TimiGameAccusationImpl", 4, "reportParam is empty");
            }
        } else {
            n(aVar);
            if (eh4.a.e()) {
                QLog.d("TimiGameAccusationImpl", 4, "startReport");
            }
        }
    }

    private static String j(com.tencent.timi.game.accusation.impl.a aVar, String str) {
        String md5 = MD5.toMD5(aVar.f376202a + "_" + aVar.f376203b + "_" + aVar.f376210i + "_" + h(str));
        StringBuilder sb5 = new StringBuilder();
        sb5.append(aVar.f376208g);
        sb5.append("_");
        sb5.append(aVar.f376207f);
        sb5.append("_");
        sb5.append(aVar.f376219r);
        sb5.append("_");
        sb5.append(aVar.f376211j);
        sb5.append("_");
        sb5.append(aVar.f376212k);
        sb5.append("_");
        sb5.append(aVar.f376205d);
        sb5.append("_");
        sb5.append(aVar.f376218q);
        sb5.append("_");
        sb5.append(aVar.f376221t);
        sb5.append("_");
        sb5.append(aVar.f376215n);
        sb5.append("_");
        sb5.append(aVar.f376210i);
        sb5.append("_");
        sb5.append(aVar.f376213l);
        sb5.append("_");
        sb5.append(aVar.f376209h);
        sb5.append("_");
        sb5.append(aVar.f376202a);
        sb5.append("_");
        sb5.append(aVar.f376214m);
        sb5.append("_");
        sb5.append(aVar.f376204c);
        sb5.append("_");
        sb5.append(aVar.f376216o);
        sb5.append("_");
        sb5.append(aVar.f376203b);
        sb5.append("_");
        sb5.append(aVar.f376217p);
        sb5.append("_");
        sb5.append(md5);
        if (eh4.a.e()) {
            QLog.d("TimiGameAccusationImpl", 2, "good string: " + sb5.toString());
        }
        return MD5.toMD5(sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(com.tencent.timi.game.accusation.impl.a aVar, String str) {
        QLog.d("TimiGameAccusationImpl", 4, "navigateToEvilReportPage");
        StringBuilder sb5 = new StringBuilder("https://jubao.qq.com/uniform_impeach/impeach_entry");
        sb5.append("?system=");
        sb5.append(aVar.f376202a);
        sb5.append("&version=");
        sb5.append(aVar.f376203b);
        sb5.append("&uintype=");
        sb5.append(aVar.f376204c);
        sb5.append("&eviluin=");
        sb5.append(aVar.f376205d);
        sb5.append("&appname=");
        sb5.append(aVar.f376207f);
        sb5.append("&appid=");
        sb5.append(aVar.f376208g);
        sb5.append("&subapp=");
        sb5.append(aVar.f376209h);
        sb5.append("&scene=");
        sb5.append(aVar.f376210i);
        sb5.append("&buddyflag=");
        sb5.append(aVar.f376211j);
        sb5.append("&contentid=");
        sb5.append(aVar.f376212k);
        sb5.append("&srv_para=");
        sb5.append(aVar.f376213l);
        sb5.append("&text_evidence=");
        sb5.append(aVar.f376214m);
        sb5.append("&img_evidence=");
        sb5.append(URLEncoder.encode(aVar.f376215n));
        sb5.append("&url_evidence=");
        sb5.append(aVar.f376216o);
        sb5.append("&video_evidence=");
        sb5.append(URLEncoder.encode(aVar.f376217p));
        sb5.append("&file_evidence=");
        sb5.append(aVar.f376218q);
        sb5.append("&audio_evidence=");
        sb5.append(aVar.f376219r);
        sb5.append("&user_input_param=");
        sb5.append(aVar.f376220s);
        sb5.append("&groupid=");
        sb5.append(aVar.f376221t);
        sb5.append("&cryptograph=");
        sb5.append(j(aVar, str));
        QLog.d("TimiGameAccusationImpl", 4, sb5.toString());
        try {
            QBaseActivity b16 = vf4.a.b();
            Intent intent = new Intent(b16, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("hide_more_button", true);
            intent.putExtra("ishiderefresh", true);
            intent.putExtra("ishidebackforward", true);
            b16.startActivity(intent.putExtra("url", sb5.toString()));
        } catch (Exception e16) {
            if (eh4.a.e()) {
                QLog.d("TimiGameAccusationImpl", 2, "doJumpReport exception: " + e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(com.tencent.timi.game.accusation.impl.a aVar) {
        new OkHttpClient().newCall(new Request.Builder().url("https://jubao.qq.com/uniform_impeach/impeach_cryptokey").build()).enqueue(new b(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(boolean z16) {
        final QBaseActivity b16 = vf4.a.b();
        if (b16 == null) {
            QLog.e("TimiGameAccusationImpl", 4, "Context is null ");
        } else if (z16) {
            QLog.d("TimiGameAccusationImpl", 4, "Post to show Dialog ");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.accusation.impl.TimiGameAccusationImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    i iVar = new i(QBaseActivity.this);
                    TimiGameAccusationImpl.f376197a = new WeakReference(iVar);
                    QLog.d("TimiGameAccusationImpl", 4, "start to show Dialog ");
                    iVar.show();
                    wf4.a.f445618a.e(iVar);
                }
            });
        } else {
            QLog.d("TimiGameAccusationImpl", 4, "Post to hide Dialog ");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.accusation.impl.TimiGameAccusationImpl.4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    i iVar;
                    if (TimiGameAccusationImpl.f376197a != null && (iVar = (i) TimiGameAccusationImpl.f376197a.get()) != null) {
                        wf4.a.f445618a.b(iVar);
                        iVar.dismiss();
                    }
                }
            });
        }
    }

    private static void n(com.tencent.timi.game.accusation.impl.a aVar) {
        m(true);
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(com.tencent.timi.game.accusation.impl.b.d(aVar.f376206e), SafeOuterClass$QQGetUserSafeSercetRsp.class, new a(aVar));
    }
}
