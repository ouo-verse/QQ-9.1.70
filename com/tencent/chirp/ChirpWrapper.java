package com.tencent.chirp;

import android.util.Pair;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ChirpWrapper {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f99149b;

    /* renamed from: a, reason: collision with root package name */
    private int f99150a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23030);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f99149b = false;
        }
    }

    public ChirpWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static native int createChirp() throws Exception;

    public static boolean d() {
        if (f99149b) {
            return true;
        }
        synchronized (ChirpWrapper.class) {
            if (f99149b) {
                return true;
            }
            try {
                String str = BaseApplication.getContext().getFilesDir().getParent() + "/chirp/libQChirp.so";
                if (new File(str).exists()) {
                    System.load(str);
                    f99149b = true;
                } else if (QLog.isColorLevel()) {
                    QLog.d("ChirpWrapper", 2, "so not exist");
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ChirpWrapper", 2, "loadLibrary error", e16);
                }
                f99149b = false;
            }
            return f99149b;
        }
    }

    private static native int decodeChirp(int i3, short[] sArr, int i16);

    private static native int encodeChirp(int i3, String str, int i16);

    public static boolean f(String str) {
        synchronized (ChirpWrapper.class) {
            String str2 = null;
            try {
                try {
                    str2 = BaseApplication.getContext().getFilesDir().getParent() + "/chirp";
                    FileUtils.uncompressZip(str, str2, false);
                } catch (IOException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ChirpWrapper", 2, "unzipSo error", e16);
                    }
                    try {
                        new File(str2 + "/libQChirp.so").delete();
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ChirpWrapper", 2, "delete error", e17);
                        }
                    }
                    return false;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
        return true;
    }

    private static native int getAudioLength(int i3);

    private static native int getAudioSample(int i3, short[] sArr, int i16);

    private static native String getDecodeString(int i3);

    private static native int getDecodeStringLen(int i3);

    private static native int releaseChirp(int i3);

    public String a(short[] sArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) sArr, i3);
        }
        if (!f99149b || decodeChirp(this.f99150a, sArr, sArr.length) != 0 || getDecodeStringLen(this.f99150a) != i3) {
            return null;
        }
        return getDecodeString(this.f99150a);
    }

    public Pair<Integer, short[]> b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (!f99149b) {
            return new Pair<>(-2, null);
        }
        int encodeChirp = encodeChirp(this.f99150a, str, str.length());
        if (encodeChirp != 0) {
            return new Pair<>(Integer.valueOf(encodeChirp), null);
        }
        int audioLength = getAudioLength(this.f99150a);
        short[] sArr = new short[audioLength];
        return new Pair<>(Integer.valueOf(getAudioSample(this.f99150a, sArr, audioLength)), sArr);
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (!f99149b) {
            return -2;
        }
        try {
            this.f99150a = createChirp();
            return 0;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ChirpWrapper", 2, "", e16);
                return -1;
            }
            return -1;
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            try {
                releaseChirp(this.f99150a);
            } catch (Throwable unused) {
            }
        }
    }
}
