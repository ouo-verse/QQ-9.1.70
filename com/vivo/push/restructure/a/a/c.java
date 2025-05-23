package com.vivo.push.restructure.a.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.aa;
import com.vivo.push.util.ab;
import com.vivo.push.util.ag;
import com.vivo.push.util.u;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class c extends a<com.vivo.push.restructure.a.a> {

    /* renamed from: b, reason: collision with root package name */
    private static final List<Integer> f387780b = Arrays.asList(3);

    public c(com.vivo.push.restructure.a.a aVar, i iVar) {
        super("CheckNode", aVar, iVar);
    }

    private static boolean b(Intent intent) {
        try {
            Context b16 = com.vivo.push.restructure.a.a().b();
            String b17 = ag.b(b16, "com.vivo.pushservice");
            u.d("CheckNode", " \u914d\u7f6e\u7684\u9a8c\u7b7e\u53c2\u6570 = ".concat(String.valueOf(b17)));
            if (!TextUtils.equals(b17, "1")) {
                return true;
            }
            String stringExtra = intent.getStringExtra("security_avoid_pull_rsa");
            String stringExtra2 = intent.getStringExtra("security_avoid_rsa_public_key");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                if (!TextUtils.equals(stringExtra, "com.vivo.pushservice") && !TextUtils.equals(stringExtra2, "com.vivo.pushservice")) {
                    if (com.vivo.push.e.b.a().a(b16).a("com.vivo.pushservice".getBytes("UTF-8"), ab.a(stringExtra2), Base64.decode(stringExtra, 2))) {
                        u.d("CheckNode", " RSA\u9a8c\u7b7e\u901a\u8fc7  ");
                        return true;
                    }
                    u.d("CheckNode", " RSA\u9a8c\u7b7e \u4e0d\u901a\u8fc7  ");
                    return false;
                }
                u.a("CheckNode", " \u9a8c\u7b7e\u53c2\u6570\u4f20\u5165\u9519\u8bef securityContent = " + stringExtra + " publickKey= " + stringExtra2);
                return true;
            }
            u.a("CheckNode", "!decrypt.equals, so securityContent == " + stringExtra + " or publickKey isempty ");
            return false;
        } catch (Exception e16) {
            u.a("CheckNode", "checkIntentIsSecurity Exception: " + e16.getMessage());
            return true;
        }
    }

    @Override // com.vivo.push.restructure.a.a.a
    protected final /* bridge */ /* synthetic */ int a(com.vivo.push.restructure.a.a aVar) {
        return a2(aVar);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static int a2(com.vivo.push.restructure.a.a aVar) {
        try {
        } catch (Exception e16) {
            u.a("CheckNode", e16);
        }
        if (!com.vivo.push.restructure.a.a().e().l().isAgreePrivacyStatement()) {
            u.d("CheckNode", " checkNeedReportByPrivacyStatement is false  ");
            return 2809;
        }
        Intent b16 = aVar.b();
        String b17 = com.vivo.push.sdk.a.a().b();
        if (!TextUtils.isEmpty(b17) && b17.contains("CommandService")) {
            if (!(b16 != null && a(b16) && b(b16))) {
                u.a("CheckNode", " !checkIntentIsSecurity(intent)");
                return 2801;
            }
        }
        Context b18 = com.vivo.push.restructure.a.a().b();
        String packageName = b18.getPackageName();
        String stringExtra = b16.getStringExtra("command_type");
        if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver")) {
            int intExtra = b16.getIntExtra("command", -1);
            if (intExtra < 0) {
                intExtra = b16.getIntExtra("method", -1);
            }
            if (f387780b.contains(Integer.valueOf(intExtra)) && aa.c(b18, packageName) && !aa.b(b18)) {
                u.a("CheckNode", "METHOD_ON_MESSAGE is not support");
                return 2803;
            }
            String action = b16.getAction();
            if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().e().a(b18, action))) {
                u.d("CheckNode", " reflectReceiver error: receiver for: " + action + " not found, package: " + packageName);
                b16.setPackage(packageName);
                b18.sendBroadcast(b16);
                return 2802;
            }
            return 0;
        }
        u.a("CheckNode", "commandTypeStr is not satisfy == ".concat(String.valueOf(stringExtra)));
        return 2801;
    }

    private static boolean a(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("security_avoid_pull");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    String b16 = com.vivo.push.util.a.a(com.vivo.push.restructure.a.a().b()).b(stringExtra);
                    if ("com.vivo.pushservice".equals(b16)) {
                        return true;
                    }
                    u.a("CheckNode", "!decrypt.equals, so decrypt == ".concat(String.valueOf(b16)));
                    return false;
                } catch (Exception e16) {
                    u.a("CheckNode", "checkIntentIsSecurity Exception: " + e16.getMessage());
                    return false;
                }
            }
            u.a("CheckNode", "checkIntentIsSecurityTextUtils.isEmpty");
            return true;
        } catch (Exception unused) {
            u.a("CheckNode", "getStringExtra error");
            return true;
        }
    }
}
