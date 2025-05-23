package com.tencent.mobileqq.identification;

import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import face.qqlogin.FaceCommon$EncryptContext;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public class EncryptContext implements Serializable {
    static IPatchRedirector $redirector_;
    public byte[] encryptKey;

    /* renamed from: iv, reason: collision with root package name */
    public byte[] f237889iv;
    public int method;

    public EncryptContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.method = 0;
        this.encryptKey = null;
        this.f237889iv = null;
    }

    public static EncryptContext mergeFromBase64String(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("EncryptContext", 1, "EncryptContext encContext is null");
            return null;
        }
        EncryptContext encryptContext = new EncryptContext();
        try {
            byte[] decode = PluginBaseInfoHelper.Base64Helper.decode(str, 11);
            FaceCommon$EncryptContext faceCommon$EncryptContext = new FaceCommon$EncryptContext();
            faceCommon$EncryptContext.mergeFrom(decode);
            if (faceCommon$EncryptContext.Method.has() && faceCommon$EncryptContext.EncryptKey.has() && faceCommon$EncryptContext.IV.has()) {
                encryptContext.method = faceCommon$EncryptContext.Method.get();
                encryptContext.encryptKey = faceCommon$EncryptContext.EncryptKey.get().toByteArray();
                encryptContext.f237889iv = faceCommon$EncryptContext.IV.get().toByteArray();
                QLog.i("EncryptContext", 2, "result=" + encryptContext);
                return encryptContext;
            }
            QLog.e("EncryptContext", 1, "EncryptContext failed! parse error");
            return null;
        } catch (Throwable th5) {
            QLog.e("EncryptContext", 1, "EncryptContext failed! ", th5);
            return null;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "EncryptContext{method=" + this.method + ", encryptKey=" + Arrays.toString(this.encryptKey) + ", iv=" + Arrays.toString(this.f237889iv) + '}';
    }

    public EncryptContext(int i3, byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bArr2);
            return;
        }
        this.method = i3;
        this.encryptKey = bArr;
        this.f237889iv = bArr2;
    }
}
