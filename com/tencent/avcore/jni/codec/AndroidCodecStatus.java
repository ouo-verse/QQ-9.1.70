package com.tencent.avcore.jni.codec;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class AndroidCodecStatus {
    private static final /* synthetic */ AndroidCodecStatus[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final AndroidCodecStatus ErrorConfigureCodecException;
    public static final AndroidCodecStatus ErrorConfigureCodecTimeOut;
    public static final AndroidCodecStatus ErrorCreateByCodecNameException;
    public static final AndroidCodecStatus ErrorCreateByCodecNameTimeOut;
    public static final AndroidCodecStatus ErrorCreateDecCodecException;
    public static final AndroidCodecStatus ErrorCreateEncCodecException;
    public static final AndroidCodecStatus ErrorDequeueInputBuffer;
    public static final AndroidCodecStatus ErrorDequeueInputBufferWithIndex;
    public static final AndroidCodecStatus ErrorDequeueOutputBuffer;
    public static final AndroidCodecStatus ErrorFlushCodecException;
    public static final AndroidCodecStatus ErrorFlushCodecTimeOut;
    public static final AndroidCodecStatus ErrorGetCapabilityesForType;
    public static final AndroidCodecStatus ErrorGetCodecInfoException;
    public static final AndroidCodecStatus ErrorGetCodecInfoTimeOut;
    public static final AndroidCodecStatus ErrorGetOutputBufferWithIndex;
    public static final AndroidCodecStatus ErrorGetOutputFormatWithIndex;
    public static final AndroidCodecStatus ErrorOnDoCodecFrame;
    public static final AndroidCodecStatus ErrorQueueInputBuffer;
    public static final AndroidCodecStatus ErrorReleaseCodecException;
    public static final AndroidCodecStatus ErrorReleaseCodecTimeOut;
    public static final AndroidCodecStatus ErrorResetCodecException;
    public static final AndroidCodecStatus ErrorSetParametersWithBundle;
    public static final AndroidCodecStatus ErrorStartCodecException;
    public static final AndroidCodecStatus ErrorStartCodecTimeOut;
    public static final AndroidCodecStatus ErrorStopCodecException;
    public static final AndroidCodecStatus ErrorStopCodecTimeOut;
    public static final AndroidCodecStatus OK;
    private int value;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14236);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        AndroidCodecStatus androidCodecStatus = new AndroidCodecStatus("OK", 0, 0);
        OK = androidCodecStatus;
        AndroidCodecStatus androidCodecStatus2 = new AndroidCodecStatus("ErrorCreateByCodecNameException", 1, 1);
        ErrorCreateByCodecNameException = androidCodecStatus2;
        AndroidCodecStatus androidCodecStatus3 = new AndroidCodecStatus("ErrorCreateByCodecNameTimeOut", 2, 2);
        ErrorCreateByCodecNameTimeOut = androidCodecStatus3;
        AndroidCodecStatus androidCodecStatus4 = new AndroidCodecStatus("ErrorConfigureCodecException", 3, 3);
        ErrorConfigureCodecException = androidCodecStatus4;
        AndroidCodecStatus androidCodecStatus5 = new AndroidCodecStatus("ErrorConfigureCodecTimeOut", 4, 4);
        ErrorConfigureCodecTimeOut = androidCodecStatus5;
        AndroidCodecStatus androidCodecStatus6 = new AndroidCodecStatus("ErrorStartCodecException", 5, 5);
        ErrorStartCodecException = androidCodecStatus6;
        AndroidCodecStatus androidCodecStatus7 = new AndroidCodecStatus("ErrorStartCodecTimeOut", 6, 6);
        ErrorStartCodecTimeOut = androidCodecStatus7;
        AndroidCodecStatus androidCodecStatus8 = new AndroidCodecStatus("ErrorFlushCodecException", 7, 7);
        ErrorFlushCodecException = androidCodecStatus8;
        AndroidCodecStatus androidCodecStatus9 = new AndroidCodecStatus("ErrorFlushCodecTimeOut", 8, 8);
        ErrorFlushCodecTimeOut = androidCodecStatus9;
        AndroidCodecStatus androidCodecStatus10 = new AndroidCodecStatus("ErrorStopCodecException", 9, 9);
        ErrorStopCodecException = androidCodecStatus10;
        AndroidCodecStatus androidCodecStatus11 = new AndroidCodecStatus("ErrorStopCodecTimeOut", 10, 10);
        ErrorStopCodecTimeOut = androidCodecStatus11;
        AndroidCodecStatus androidCodecStatus12 = new AndroidCodecStatus("ErrorReleaseCodecException", 11, 11);
        ErrorReleaseCodecException = androidCodecStatus12;
        AndroidCodecStatus androidCodecStatus13 = new AndroidCodecStatus("ErrorReleaseCodecTimeOut", 12, 12);
        ErrorReleaseCodecTimeOut = androidCodecStatus13;
        AndroidCodecStatus androidCodecStatus14 = new AndroidCodecStatus("ErrorDequeueInputBuffer", 13, 13);
        ErrorDequeueInputBuffer = androidCodecStatus14;
        AndroidCodecStatus androidCodecStatus15 = new AndroidCodecStatus("ErrorDequeueInputBufferWithIndex", 14, 14);
        ErrorDequeueInputBufferWithIndex = androidCodecStatus15;
        AndroidCodecStatus androidCodecStatus16 = new AndroidCodecStatus("ErrorQueueInputBuffer", 15, 15);
        ErrorQueueInputBuffer = androidCodecStatus16;
        AndroidCodecStatus androidCodecStatus17 = new AndroidCodecStatus("ErrorDequeueOutputBuffer", 16, 16);
        ErrorDequeueOutputBuffer = androidCodecStatus17;
        AndroidCodecStatus androidCodecStatus18 = new AndroidCodecStatus("ErrorGetOutputBufferWithIndex", 17, 17);
        ErrorGetOutputBufferWithIndex = androidCodecStatus18;
        AndroidCodecStatus androidCodecStatus19 = new AndroidCodecStatus("ErrorGetOutputFormatWithIndex", 18, 18);
        ErrorGetOutputFormatWithIndex = androidCodecStatus19;
        AndroidCodecStatus androidCodecStatus20 = new AndroidCodecStatus("ErrorSetParametersWithBundle", 19, 19);
        ErrorSetParametersWithBundle = androidCodecStatus20;
        AndroidCodecStatus androidCodecStatus21 = new AndroidCodecStatus("ErrorOnDoCodecFrame", 20, 20);
        ErrorOnDoCodecFrame = androidCodecStatus21;
        AndroidCodecStatus androidCodecStatus22 = new AndroidCodecStatus("ErrorGetCodecInfoException", 21, 21);
        ErrorGetCodecInfoException = androidCodecStatus22;
        AndroidCodecStatus androidCodecStatus23 = new AndroidCodecStatus("ErrorGetCodecInfoTimeOut", 22, 22);
        ErrorGetCodecInfoTimeOut = androidCodecStatus23;
        AndroidCodecStatus androidCodecStatus24 = new AndroidCodecStatus("ErrorGetCapabilityesForType", 23, 23);
        ErrorGetCapabilityesForType = androidCodecStatus24;
        AndroidCodecStatus androidCodecStatus25 = new AndroidCodecStatus("ErrorCreateEncCodecException", 24, 24);
        ErrorCreateEncCodecException = androidCodecStatus25;
        AndroidCodecStatus androidCodecStatus26 = new AndroidCodecStatus("ErrorCreateDecCodecException", 25, 25);
        ErrorCreateDecCodecException = androidCodecStatus26;
        AndroidCodecStatus androidCodecStatus27 = new AndroidCodecStatus("ErrorResetCodecException", 26, 26);
        ErrorResetCodecException = androidCodecStatus27;
        $VALUES = new AndroidCodecStatus[]{androidCodecStatus, androidCodecStatus2, androidCodecStatus3, androidCodecStatus4, androidCodecStatus5, androidCodecStatus6, androidCodecStatus7, androidCodecStatus8, androidCodecStatus9, androidCodecStatus10, androidCodecStatus11, androidCodecStatus12, androidCodecStatus13, androidCodecStatus14, androidCodecStatus15, androidCodecStatus16, androidCodecStatus17, androidCodecStatus18, androidCodecStatus19, androidCodecStatus20, androidCodecStatus21, androidCodecStatus22, androidCodecStatus23, androidCodecStatus24, androidCodecStatus25, androidCodecStatus26, androidCodecStatus27};
    }

    AndroidCodecStatus(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.value = i16;
        }
    }

    public static AndroidCodecStatus valueOf(String str) {
        return (AndroidCodecStatus) Enum.valueOf(AndroidCodecStatus.class, str);
    }

    public static AndroidCodecStatus[] values() {
        return (AndroidCodecStatus[]) $VALUES.clone();
    }

    public int getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.value;
    }
}
