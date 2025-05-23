package com.tencent.luggage.wxa.dr;

import com.tenpay.utils.SMUtilsV2;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {
    public static void a(String str, String str2, String str3) {
        int TSMStorageInit = SMUtilsV2.TSMStorageInit(str, str2, str3);
        if (TSMStorageInit != 0) {
            throw new c(TSMStorageInit);
        }
    }

    public static void b(String str, byte[] bArr) {
        int TSMStorageUpdateSM4Key = SMUtilsV2.TSMStorageUpdateSM4Key(str, bArr);
        if (TSMStorageUpdateSM4Key != 0) {
            throw new c(TSMStorageUpdateSM4Key);
        }
    }

    public static boolean c(String str) {
        int TSMStorageCheckSM4Key = SMUtilsV2.TSMStorageCheckSM4Key(str);
        if (TSMStorageCheckSM4Key == 0) {
            return TSMStorageCheckSM4Key == 0;
        }
        if (TSMStorageCheckSM4Key == -60012) {
            return false;
        }
        throw new c(TSMStorageCheckSM4Key);
    }

    public static void d(String str, String str2, g gVar) {
        int TSMStorageUpdateSM2PubKey = SMUtilsV2.TSMStorageUpdateSM2PubKey(str, str2, gVar.ordinal());
        if (TSMStorageUpdateSM2PubKey != 0) {
            throw new c(TSMStorageUpdateSM2PubKey);
        }
    }

    public static void e(String str) {
        int TSMStorageDeleteSM2PubKey = SMUtilsV2.TSMStorageDeleteSM2PubKey(str);
        if (TSMStorageDeleteSM2PubKey == 0) {
        } else {
            throw new c(TSMStorageDeleteSM2PubKey);
        }
    }

    public static void f(String str) {
        int TSMStorageDeleteSM4Key = SMUtilsV2.TSMStorageDeleteSM4Key(str);
        if (TSMStorageDeleteSM4Key == 0) {
        } else {
            throw new c(TSMStorageDeleteSM4Key);
        }
    }

    public static byte[] g(String str) {
        byte[][] bArr = new byte[1];
        int TSMStorageExportSM4Key = SMUtilsV2.TSMStorageExportSM4Key(str, bArr);
        if (TSMStorageExportSM4Key != 0) {
            if (TSMStorageExportSM4Key == -60012) {
                return null;
            }
            throw new c(TSMStorageExportSM4Key);
        }
        return bArr[0];
    }

    public static boolean h(String str) {
        int TSMStorageGenerateSM2KeyPair = SMUtilsV2.TSMStorageGenerateSM2KeyPair(str);
        if (TSMStorageGenerateSM2KeyPair == 0) {
            return true;
        }
        throw new c(TSMStorageGenerateSM2KeyPair);
    }

    public static boolean i(String str) {
        int TSMStorageGenerateSM4Key = SMUtilsV2.TSMStorageGenerateSM4Key(str);
        if (TSMStorageGenerateSM4Key == 0) {
            return true;
        }
        throw new c(TSMStorageGenerateSM4Key);
    }

    public static void a(String str, byte[] bArr) {
        int TSMStorageImportSM4Key = SMUtilsV2.TSMStorageImportSM4Key(str, bArr);
        if (TSMStorageImportSM4Key != 0) {
            throw new c(TSMStorageImportSM4Key);
        }
    }

    public static void b(String str, String str2, g gVar) {
        int TSMStorageImportSM2PubKey = SMUtilsV2.TSMStorageImportSM2PubKey(str, str2, gVar.ordinal());
        if (TSMStorageImportSM2PubKey != 0) {
            throw new c(TSMStorageImportSM2PubKey);
        }
    }

    public static void c(String str, String str2, g gVar) {
        int TSMStorageUpdateSM2PriKey = SMUtilsV2.TSMStorageUpdateSM2PriKey(str, str2, gVar.ordinal());
        if (TSMStorageUpdateSM2PriKey != 0) {
            throw new c(TSMStorageUpdateSM2PriKey);
        }
    }

    public static void d(String str) {
        int TSMStorageDeleteSM2PriKey = SMUtilsV2.TSMStorageDeleteSM2PriKey(str);
        if (TSMStorageDeleteSM2PriKey != 0) {
            throw new c(TSMStorageDeleteSM2PriKey);
        }
    }

    public static void a(String str, String str2, g gVar) {
        int TSMStorageImportSM2PriKey = SMUtilsV2.TSMStorageImportSM2PriKey(str, str2, gVar.ordinal());
        if (TSMStorageImportSM2PriKey != 0) {
            throw new c(TSMStorageImportSM2PriKey);
        }
    }

    public static String b(String str, g gVar) {
        String[] strArr = new String[1];
        int TSMStorageExportSM2PubKey = SMUtilsV2.TSMStorageExportSM2PubKey(str, gVar.ordinal(), strArr);
        if (TSMStorageExportSM2PubKey == 0) {
            return strArr[0];
        }
        if (TSMStorageExportSM2PubKey == -60012) {
            return null;
        }
        throw new c(TSMStorageExportSM2PubKey);
    }

    public static String[] a(String str, g gVar) {
        String[] strArr = new String[1];
        String[] strArr2 = new String[1];
        int TSMStorageExportSM2PriKey = SMUtilsV2.TSMStorageExportSM2PriKey(str, gVar.ordinal(), strArr, strArr2);
        if (TSMStorageExportSM2PriKey == 0) {
            return new String[]{strArr[0], strArr2[0]};
        }
        if (TSMStorageExportSM2PriKey == -60012) {
            return null;
        }
        throw new c(TSMStorageExportSM2PriKey);
    }

    public static boolean b(String str) {
        int TSMStorageCheckSM2PubKey = SMUtilsV2.TSMStorageCheckSM2PubKey(str);
        if (TSMStorageCheckSM2PubKey == 0) {
            return TSMStorageCheckSM2PubKey == 0;
        }
        if (TSMStorageCheckSM2PubKey == -60012) {
            return false;
        }
        throw new c(TSMStorageCheckSM2PubKey);
    }

    public static boolean a(String str) {
        int TSMStorageCheckSM2PriKey = SMUtilsV2.TSMStorageCheckSM2PriKey(str);
        if (TSMStorageCheckSM2PriKey == 0) {
            return TSMStorageCheckSM2PriKey == 0;
        }
        if (TSMStorageCheckSM2PriKey == -60012) {
            return false;
        }
        throw new c(TSMStorageCheckSM2PriKey);
    }
}
