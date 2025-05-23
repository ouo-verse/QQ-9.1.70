package com.google.android.vending.licensing;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.vending.licensing.util.Base64DecoderException;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final h f34638a;

    /* renamed from: b, reason: collision with root package name */
    private final d f34639b;

    /* renamed from: c, reason: collision with root package name */
    private final int f34640c;

    /* renamed from: d, reason: collision with root package name */
    private final String f34641d;

    /* renamed from: e, reason: collision with root package name */
    private final String f34642e;

    /* renamed from: f, reason: collision with root package name */
    private final c f34643f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(h hVar, c cVar, d dVar, int i3, String str, String str2) {
        this.f34638a = hVar;
        this.f34643f = cVar;
        this.f34639b = dVar;
        this.f34640c = i3;
        this.f34641d = str;
        this.f34642e = str2;
    }

    private void d(int i3) {
        this.f34639b.applicationError(i3);
    }

    private void e() {
        this.f34639b.dontAllow(PlayerResources.ViewId.GET_MORE_TOGGLE_ARROW_BTN);
    }

    private void f(int i3, j jVar) {
        this.f34638a.a(i3, jVar);
        if (this.f34638a.b()) {
            this.f34639b.allow(i3);
        } else {
            this.f34639b.dontAllow(i3);
        }
    }

    public d a() {
        return this.f34639b;
    }

    public int b() {
        return this.f34640c;
    }

    public String c() {
        return this.f34641d;
    }

    public void g(PublicKey publicKey, int i3, String str, String str2) {
        j jVar;
        String str3;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            str3 = null;
            jVar = null;
        } else {
            try {
                if (TextUtils.isEmpty(str)) {
                    Log.e("LicenseValidator", "Signature verification failed: signedData is empty. (Device not signed-in to any Google accounts?)");
                    e();
                    return;
                }
                Signature signature = Signature.getInstance("SHA1withRSA");
                signature.initVerify(publicKey);
                signature.update(str.getBytes());
                if (!signature.verify(o1.a.a(str2))) {
                    Log.e("LicenseValidator", "Signature verification failed.");
                    e();
                    return;
                }
                try {
                    j a16 = j.a(str);
                    if (a16.f34647a != i3) {
                        Log.e("LicenseValidator", "Response codes don't match.");
                        e();
                        return;
                    }
                    if (a16.f34648b != this.f34640c) {
                        Log.e("LicenseValidator", "Nonce doesn't match.");
                        e();
                        return;
                    }
                    if (!a16.f34649c.equals(this.f34641d)) {
                        Log.e("LicenseValidator", "Package name doesn't match.");
                        e();
                        return;
                    } else {
                        if (!a16.f34650d.equals(this.f34642e)) {
                            Log.e("LicenseValidator", "Version codes don't match.");
                            e();
                            return;
                        }
                        String str4 = a16.f34651e;
                        if (TextUtils.isEmpty(str4)) {
                            Log.e("LicenseValidator", "User identifier is empty.");
                            e();
                            return;
                        } else {
                            jVar = a16;
                            str3 = str4;
                        }
                    }
                } catch (IllegalArgumentException unused) {
                    Log.e("LicenseValidator", "Could not parse response.");
                    e();
                    return;
                }
            } catch (Base64DecoderException unused2) {
                Log.e("LicenseValidator", "Could not Base64-decode signature.");
                e();
                return;
            } catch (InvalidKeyException unused3) {
                d(5);
                return;
            } catch (NoSuchAlgorithmException e16) {
                throw new RuntimeException(e16);
            } catch (SignatureException e17) {
                throw new RuntimeException(e17);
            }
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                switch (i3) {
                                    case 257:
                                        Log.w("LicenseValidator", "Error contacting licensing server.");
                                        f(291, jVar);
                                        return;
                                    case 258:
                                        d(1);
                                        return;
                                    case 259:
                                        d(2);
                                        return;
                                    default:
                                        Log.e("LicenseValidator", "Unknown response code for license check.");
                                        e();
                                        return;
                                }
                            }
                            Log.w("LicenseValidator", "Licensing server is refusing to talk to this device, over quota.");
                            f(291, jVar);
                            return;
                        }
                        Log.w("LicenseValidator", "An error has occurred on the licensing server.");
                        f(291, jVar);
                        return;
                    }
                    d(3);
                    return;
                }
            } else {
                f(PlayerResources.ViewId.GET_MORE_TOGGLE_ARROW_BTN, jVar);
                return;
            }
        }
        f(this.f34643f.a(str3), jVar);
    }
}
