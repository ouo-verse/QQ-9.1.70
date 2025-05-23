package com.tencent.turingcam;

import android.content.Context;
import android.hardware.Camera;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingcam.OTVRM;
import com.tencent.turingcam.tLlmS;
import com.tencent.turingcam.view.TuringPreviewDisplay;
import com.tencent.turingface.sdk.mfa.TNative$aa;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuringFaceDefender {
    static IPatchRedirector $redirector_;

    public TuringFaceDefender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static long activeSign(String str) {
        OTVRM otvrm;
        int i3 = OTVRM.f381989w;
        otvrm = OTVRM.Bi3eT.f381999a;
        return otvrm.a(str);
    }

    public static JSONObject getDeviceInfo(Context context) {
        return RYhXO.a().a(context);
    }

    public static String getSDKVersion() {
        return "2.3.0";
    }

    public static int init(TuringFaceBuilder turingFaceBuilder) {
        OTVRM otvrm;
        int i3 = OTVRM.f381989w;
        otvrm = OTVRM.Bi3eT.f381999a;
        return otvrm.a(turingFaceBuilder);
    }

    public static void processFrame(byte[] bArr) {
        OTVRM otvrm;
        int i3 = OTVRM.f381989w;
        otvrm = OTVRM.Bi3eT.f381999a;
        otvrm.a(bArr);
    }

    public static void setCallback(TuringCallback turingCallback) {
        OTVRM otvrm;
        OTVRM otvrm2;
        if (turingCallback == null) {
            int i3 = OTVRM.f381989w;
            otvrm2 = OTVRM.Bi3eT.f381999a;
            otvrm2.a((OTVRM.B9LVG) null);
        } else {
            int i16 = OTVRM.f381989w;
            otvrm = OTVRM.Bi3eT.f381999a;
            otvrm.a(new vqARY(turingCallback));
        }
    }

    public static void setPreviewDisplay(Camera camera2, TuringPreviewDisplay turingPreviewDisplay) {
        OTVRM otvrm;
        int i3 = OTVRM.f381989w;
        otvrm = OTVRM.Bi3eT.f381999a;
        otvrm.a(camera2, turingPreviewDisplay);
    }

    public static SignResult signData(String str) {
        OTVRM otvrm;
        BfUKf bfUKf;
        tLlmS.ShGzN a16;
        int i3 = OTVRM.f381989w;
        otvrm = OTVRM.Bi3eT.f381999a;
        otvrm.getClass();
        JD1Ej.a().getClass();
        HashMap<String, tLlmS.SkEpO> hashMap = tLlmS.f382377a;
        if (TextUtils.isEmpty(str)) {
            a16 = tLlmS.ShGzN.a(-81004);
        } else {
            AtomicReference<BfUKf> atomicReference = tLlmS.f382380d;
            synchronized (atomicReference) {
                bfUKf = atomicReference.get();
                if (bfUKf == null) {
                    atomicReference.set(XStYH.a());
                    bfUKf = atomicReference.get();
                }
            }
            if (bfUKf == null) {
                a16 = tLlmS.ShGzN.a(-81000);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                Random random = Ckq8l.f381753a;
                char[] cArr = new char[32];
                for (int i16 = 0; i16 < 32; i16++) {
                    cArr[i16] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(Ckq8l.f381753a.nextInt(62));
                }
                String str2 = new String(cArr);
                try {
                    SparseArray<Object> n91_FC6D5B0A7013DB60 = TNative$aa.n91_FC6D5B0A7013DB60(new SparseArray(), (str + str2 + currentTimeMillis).getBytes("UTF-8"), 2, bfUKf.f381726a, currentTimeMillis);
                    int b16 = SWw7W.b(n91_FC6D5B0A7013DB60);
                    if (b16 != 0) {
                        a16 = tLlmS.ShGzN.a(b16);
                    } else {
                        a16 = new tLlmS.ShGzN(0, Base64.encodeToString(SWw7W.a(n91_FC6D5B0A7013DB60), 2), str2, currentTimeMillis, bfUKf.f381728c, "TuringV2");
                    }
                } catch (UnsupportedEncodingException unused) {
                    a16 = tLlmS.ShGzN.a(-81003);
                } catch (UnsatisfiedLinkError e16) {
                    Log.e("TuringSign", "sign method invoke fail", e16);
                    a16 = tLlmS.ShGzN.a(-81005);
                }
            }
        }
        SignResult signResult = new SignResult(a16.f382381a, a16.f382382b);
        long j3 = signResult.code;
        if (j3 != 0) {
            signResult.code = j3 - 800000;
        }
        return signResult;
    }

    public static void start(Camera camera2, String str) {
        OTVRM otvrm;
        int i3 = OTVRM.f381989w;
        otvrm = OTVRM.Bi3eT.f381999a;
        otvrm.a(camera2, str);
    }

    public static void startFrameCheck(String str) {
        OTVRM otvrm;
        int i3 = OTVRM.f381989w;
        otvrm = OTVRM.Bi3eT.f381999a;
        otvrm.c(str);
    }
}
