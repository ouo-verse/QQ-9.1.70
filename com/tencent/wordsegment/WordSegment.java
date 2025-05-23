package com.tencent.wordsegment;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WordSegment {
    static IPatchRedirector $redirector_ = null;
    public static final int ContextMatchType_HotWordWholeWord = 2;
    public static final int ContextMatchType_None = 0;
    public static final int ContextMatchType_Pattern = 1;
    public static final int ContextMatchType_Precontext = 3;
    private static ILogCallback _logCallback;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ILogCallback {
        void OnLog(String str, String str2);
    }

    public WordSegment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final native String bussinesReport(String str);

    public static long getARM64LibCRC32() {
        return WordSegmentVersion.WORDSEGMENT_SO_CRC32_ARM64;
    }

    public static int getARM64LibSize() {
        return WordSegmentVersion.WORDSEGMENT_SO_SIZE_ARM64;
    }

    public static long getARMv7LibCRC32() {
        return WordSegmentVersion.WORDSEGMENT_SO_CRC32_ARMV7;
    }

    public static int getARMv7LibSize() {
        return WordSegmentVersion.WORDSEGMENT_SO_SIZE_ARMV7;
    }

    public static final int getPlatformBuildNumber() {
        return WordSegmentVersion.WORDSEGMENT_BUILD_NO;
    }

    public static final native int init(String str);

    public static final native boolean recognize(String str, ArrayList<Integer> arrayList, ArrayList<ContextItem> arrayList2);

    public static final native String[] segment(String str);

    public static void setLogCallback(ILogCallback iLogCallback) {
        _logCallback = iLogCallback;
    }

    public static final native void uninit();

    public static final native int updateDict(int i3, String str);

    public static void writeLog(String str, String str2) {
        ILogCallback iLogCallback = _logCallback;
        if (iLogCallback != null) {
            iLogCallback.OnLog(str, str2);
        }
    }
}
