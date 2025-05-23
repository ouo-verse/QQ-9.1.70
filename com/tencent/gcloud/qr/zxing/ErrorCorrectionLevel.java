package com.tencent.gcloud.qr.zxing;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class ErrorCorrectionLevel {
    private static final /* synthetic */ ErrorCorrectionLevel[] $VALUES;
    static IPatchRedirector $redirector_;
    private static final ErrorCorrectionLevel[] FOR_BITS;
    public static final ErrorCorrectionLevel H;
    public static final ErrorCorrectionLevel L;
    public static final ErrorCorrectionLevel M;
    public static final ErrorCorrectionLevel Q;
    private final int bits;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19985);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ErrorCorrectionLevel errorCorrectionLevel = new ErrorCorrectionLevel("L", 0, 1);
        L = errorCorrectionLevel;
        ErrorCorrectionLevel errorCorrectionLevel2 = new ErrorCorrectionLevel("M", 1, 0);
        M = errorCorrectionLevel2;
        ErrorCorrectionLevel errorCorrectionLevel3 = new ErrorCorrectionLevel(AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, 2, 3);
        Q = errorCorrectionLevel3;
        ErrorCorrectionLevel errorCorrectionLevel4 = new ErrorCorrectionLevel("H", 3, 2);
        H = errorCorrectionLevel4;
        $VALUES = new ErrorCorrectionLevel[]{errorCorrectionLevel, errorCorrectionLevel2, errorCorrectionLevel3, errorCorrectionLevel4};
        FOR_BITS = new ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel, errorCorrectionLevel4, errorCorrectionLevel3};
    }

    ErrorCorrectionLevel(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.bits = i16;
        }
    }

    public static ErrorCorrectionLevel forBits(int i3) {
        if (i3 >= 0) {
            ErrorCorrectionLevel[] errorCorrectionLevelArr = FOR_BITS;
            if (i3 < errorCorrectionLevelArr.length) {
                return errorCorrectionLevelArr[i3];
            }
        }
        throw new IllegalArgumentException();
    }

    public static ErrorCorrectionLevel valueOf(String str) {
        return (ErrorCorrectionLevel) Enum.valueOf(ErrorCorrectionLevel.class, str);
    }

    public static ErrorCorrectionLevel[] values() {
        return (ErrorCorrectionLevel[]) $VALUES.clone();
    }

    public int getBits() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.bits;
    }
}
