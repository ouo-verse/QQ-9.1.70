package com.tencent.mobileqq.dalvik;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DalvikReplacer {
    static IPatchRedirector $redirector_ = null;
    public static final int ERR_ART = 15;
    private static final int ERR_FIND = 6;
    private static final int ERR_FIND_EXC = 7;
    private static final int ERR_GC_HEAP = 18;
    private static final int ERR_HEAP_0 = 20;
    private static final int ERR_HEAP_EXC = 16;
    private static final int ERR_HEAP_SOURCE = 19;
    private static final int ERR_ING = 2;
    private static final int ERR_MAP_EMPTY = 5;
    private static final int ERR_MAP_EXC = 4;
    private static final int ERR_MATCH_LA = 17;
    public static final int ERR_OK = 21;
    private static final int ERR_REP_ALLOC = 8;
    private static final int ERR_REP_EXP = 10;
    private static final int ERR_REP_MMAP = 9;
    private static final int ERR_SO_LOAD = 3;
    private static final int ERR_VER_EXC = 14;
    private static final int ERR_VER_HIT = 12;
    private static final int ERR_VER_MODE = 13;
    public static final int ERR_VIRGIN = 1;
    public static final int SIZE_LINEARALLOC_GINGERBREAD = 5242880;
    public static final int SIZE_LINEARALLOC_ICS = 8388608;
    public static final int SIZE_LINEARALLOC_JB = 16777216;
    private static final int SYSTEM_PAGE_SIZE = 4096;
    public static int sArtHackResult;
    public static int sHeapResult;
    public static int sLaResult;
    public static int sVerifyResult;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9499);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        sLaResult = 1;
        sVerifyResult = 1;
        sHeapResult = 1;
        sArtHackResult = 1;
    }

    public DalvikReplacer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public static void artHack(Context context, long j3, long j16) {
        boolean z16;
        long[] jArr;
        if (sArtHackResult == 1) {
            if (j16 > j3 && Build.VERSION.SDK_INT == 23) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                sArtHackResult = 2;
                if (DalvikInternals.loadLib(context)) {
                    try {
                        jArr = new MappingReader().getReadableMaps();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                        jArr = null;
                    }
                    if (jArr != null && jArr.length > 1) {
                        int modArtHeap = DalvikInternals.modArtHeap(jArr, (int) j3, ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getLargeMemoryClass() * 1024 * 1024, (int) j16);
                        if (modArtHeap == 0) {
                            sArtHackResult = 21;
                            return;
                        } else {
                            sArtHackResult = modArtHeap;
                            return;
                        }
                    }
                    sArtHackResult = 5;
                    return;
                }
                sArtHackResult = 3;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0085  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x006d -> B:23:0x0087). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void dvmHack(Context context, int i3, boolean z16, long j3) {
        boolean z17;
        MappingReader mappingReader;
        if (sLaResult == 1 && sVerifyResult == 1) {
            sLaResult = 2;
            sVerifyResult = 2;
            int i16 = (j3 > Runtime.getRuntime().maxMemory() ? 1 : (j3 == Runtime.getRuntime().maxMemory() ? 0 : -1));
            if (getLinearAllocLimit() < i3) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                sHeapResult = 21;
                sVerifyResult = 21;
                sLaResult = 21;
                return;
            }
            boolean loadLib = DalvikInternals.loadLib(context);
            long[] jArr = null;
            if (loadLib) {
                try {
                    mappingReader = new MappingReader();
                    try {
                        jArr = mappingReader.getReadableMaps();
                    } catch (Throwable th5) {
                        th = th5;
                        th.printStackTrace();
                        if (!z17) {
                        }
                        sHeapResult = 21;
                        sVerifyResult = 21;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    mappingReader = null;
                }
            } else {
                mappingReader = null;
            }
            if (!z17) {
                if (loadLib) {
                    if (jArr != null && jArr.length > 1) {
                        try {
                            long findLinearAllocHeader = findLinearAllocHeader(mappingReader, jArr);
                            if (findLinearAllocHeader <= 0) {
                                sLaResult = 6;
                            } else {
                                try {
                                    int replace = DalvikInternals.replace(findLinearAllocHeader, i3, 4096);
                                    if (replace == 0) {
                                        sLaResult = 21;
                                    } else {
                                        sLaResult = replace;
                                    }
                                } catch (Throwable th7) {
                                    th7.printStackTrace();
                                    sLaResult = 10;
                                }
                            }
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                            sLaResult = 7;
                        }
                    } else {
                        sLaResult = 5;
                    }
                } else {
                    sLaResult = 3;
                }
            } else {
                sLaResult = 21;
            }
            sHeapResult = 21;
            sVerifyResult = 21;
        }
    }

    private static long findLinearAllocHeader(MappingReader mappingReader, long[] jArr) {
        long j3;
        long j16;
        Mapping findMappingByName = mappingReader.findMappingByName("LinearAlloc");
        if (findMappingByName == null) {
            return 0L;
        }
        Mapping findMappingByName2 = mappingReader.findMappingByName("[heap]");
        if (findMappingByName2 != null && findMappingByName2.readable) {
            j3 = findMappingByName2.beginAddr;
            j16 = findMappingByName2.endAddr;
        } else {
            j3 = 0;
            j16 = 0;
        }
        return DalvikInternals.find(jArr, 704, 1480, 0, 3, 524288, 16777216, j3, j16, 5242880, 16777216, 4100, findMappingByName.beginAddr);
    }

    public static int getLinearAllocLimit() {
        return 16777216;
    }
}
