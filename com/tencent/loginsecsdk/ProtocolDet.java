package com.tencent.loginsecsdk;

import android.content.Context;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class ProtocolDet {
    static IPatchRedirector $redirector_ = null;
    private static final String DET_CACHE_FILE_NAME = "pd2.dat";
    private static final int EXTRA_IPV4_DATA_ITEM_SIZE = 21;
    private static final int EXTRA_IPV6_DATA_ITEM_SIZE = 33;
    private static final int IPV4_LEN = 4;
    private static final int IPV6_LEN = 16;
    private static final int MAX_CACHED_FILE_SIZE = 4096;
    private static final int MAX_CACHED_ITEM_COUNT = 3;
    private static byte cNum;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class LoginExtraData {
        static IPatchRedirector $redirector_;
        byte[] mIp;
        int mTime;
        long mUin;
        int mVersion;
        byte mlen;

        LoginExtraData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* synthetic */ LoginExtraData(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) anonymousClass1);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7125);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            cNum = (byte) 0;
        }
    }

    public ProtocolDet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] convertExtraDataListToBuffer(List<LoginExtraData> list) {
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                } catch (Exception e16) {
                    e = e16;
                    dataOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    outputStream = null;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                    }
                    if (outputStream == null) {
                    }
                }
            } catch (Exception e17) {
                e = e17;
                byteArrayOutputStream = null;
                dataOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception e18) {
                        e18.printStackTrace();
                    }
                }
                if (outputStream == null) {
                    try {
                        outputStream.close();
                        throw th;
                    } catch (Exception e19) {
                        e19.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
            try {
                int size = list.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    long j3 = list.get(i3).mUin;
                    byte b16 = list.get(i3).mlen;
                    if (list.get(i3).mlen != 4 && list.get(i3).mlen != 16) {
                        Log.d("Det", "error: IP Length fault ");
                        break;
                    }
                    dataOutputStream.writeLong(j3);
                    dataOutputStream.writeByte(b16);
                    dataOutputStream.write(list.get(i3).mIp);
                    dataOutputStream.writeInt(list.get(i3).mTime);
                    dataOutputStream.writeInt(list.get(i3).mVersion);
                    i3++;
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e26) {
                    e26.printStackTrace();
                }
                try {
                    dataOutputStream.close();
                } catch (Exception e27) {
                    e27.printStackTrace();
                }
                return byteArray;
            } catch (Exception e28) {
                e = e28;
                e.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e29) {
                        e29.printStackTrace();
                    }
                }
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (Exception e36) {
                        e36.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private static String getCachedDetFileFullPath(Context context) {
        return context.getFilesDir() + File.separator + DET_CACHE_FILE_NAME;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0067: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:104), block:B:36:0x0067 */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static LoginExtraData getExtraDataFromBuffer(byte[] bArr) {
        DataInputStream dataInputStream;
        InputStream inputStream;
        LoginExtraData loginExtraData;
        InputStream inputStream2 = null;
        try {
            try {
                loginExtraData = new LoginExtraData(0 == true ? 1 : 0);
                dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
            } catch (Exception e16) {
                e = e16;
                dataInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (inputStream2 != null) {
                }
                throw th;
            }
            try {
                loginExtraData.mUin = dataInputStream.readLong();
                int readByte = dataInputStream.readByte();
                loginExtraData.mlen = readByte;
                if (readByte != 4 && readByte != 16) {
                    Log.d("Det", "error: IP Length fault ");
                    try {
                        dataInputStream.close();
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                    return null;
                }
                byte[] bArr2 = new byte[readByte];
                loginExtraData.mIp = bArr2;
                dataInputStream.read(bArr2);
                loginExtraData.mTime = dataInputStream.readInt();
                loginExtraData.mVersion = dataInputStream.readInt();
                try {
                    dataInputStream.close();
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
                return loginExtraData;
            } catch (Exception e19) {
                e = e19;
                e.printStackTrace();
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (Exception e26) {
                        e26.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception e27) {
                    e27.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static byte[] getLoginExtraData(Context context) {
        if (context == null) {
            return null;
        }
        List<LoginExtraData> loadExtraDataFromFile = loadExtraDataFromFile(context, 3);
        if (loadExtraDataFromFile == null) {
            return packExtraData(null);
        }
        cNum = (byte) loadExtraDataFromFile.size();
        return packExtraData(convertExtraDataListToBuffer(loadExtraDataFromFile));
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0043, code lost:
    
        android.util.Log.d("Det", "error: IP Length fault ");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.loginsecsdk.ProtocolDet$1] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int, byte] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x007b -> B:26:0x007e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<LoginExtraData> loadExtraDataFromFile(Context context, int i3) {
        byte[] loadFileContent;
        ArrayList arrayList = new ArrayList();
        ?? r16 = 0;
        r16 = 0;
        try {
            try {
                try {
                    loadFileContent = loadFileContent(getCachedDetFileFullPath(context));
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Exception e16) {
                e = e16;
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        if (loadFileContent == null) {
            return null;
        }
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(loadFileContent));
        while (true) {
            try {
                if (dataInputStream.available() == 0 || (arrayList.size() >= i3 && i3 > 0)) {
                    break;
                }
                LoginExtraData loginExtraData = new LoginExtraData(r16);
                loginExtraData.mUin = dataInputStream.readLong();
                int readByte = dataInputStream.readByte();
                loginExtraData.mlen = readByte;
                if (readByte != 4 && readByte != 16) {
                    break;
                }
                byte[] bArr = new byte[readByte];
                loginExtraData.mIp = bArr;
                dataInputStream.read(bArr);
                loginExtraData.mTime = dataInputStream.readInt();
                loginExtraData.mVersion = dataInputStream.readInt();
                arrayList.add(loginExtraData);
            } catch (Exception e18) {
                e = e18;
                r16 = dataInputStream;
                e.printStackTrace();
                if (r16 != 0) {
                    r16.close();
                }
                return arrayList;
            } catch (Throwable th6) {
                th = th6;
                r16 = dataInputStream;
                if (r16 != 0) {
                    try {
                        r16.close();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                    }
                }
                throw th;
            }
        }
        dataInputStream.close();
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.lang.Throwable, java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] loadFileContent(String str) {
        Throwable th5;
        FileInputStream fileInputStream;
        File file;
        FileInputStream fileInputStream2;
        byte[] bArr = null;
        try {
            try {
                file = new File((String) str);
            } catch (Exception e16) {
                e = e16;
                fileInputStream = null;
            } catch (Throwable th6) {
                th5 = th6;
                str = 0;
                if (str != 0) {
                }
                throw th5;
            }
            if (!file.exists()) {
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                int available = fileInputStream.available();
                if (available > 4096) {
                    available = 4096;
                }
                byte[] bArr2 = new byte[available];
                fileInputStream.read(bArr2);
                try {
                    fileInputStream.close();
                    fileInputStream2 = fileInputStream;
                } catch (Exception e17) {
                    e17.printStackTrace();
                    fileInputStream2 = e17;
                }
                bArr = bArr2;
                str = fileInputStream2;
            } catch (Exception e18) {
                e = e18;
                e.printStackTrace();
                str = fileInputStream;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        str = fileInputStream;
                    } catch (Exception e19) {
                        e19.printStackTrace();
                        str = e19;
                    }
                }
                return bArr;
            }
            return bArr;
        } catch (Throwable th7) {
            th5 = th7;
            if (str != 0) {
                try {
                    str.close();
                } catch (Exception e26) {
                    e26.printStackTrace();
                }
            }
            throw th5;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:8|9|(10:11|(1:13)|15|(1:17)|18|19|20|22|23|24)(1:32)|14|15|(0)|18|19|20|22|23|24) */
    /* JADX WARN: Can't wrap try/catch for region: R(19:1|2|3|5|6|7|8|9|(10:11|(1:13)|15|(1:17)|18|19|20|22|23|24)(1:32)|14|15|(0)|18|19|20|22|23|24|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0034, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0035, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x002c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x002d, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0021 A[Catch: Exception -> 0x0039, all -> 0x005f, TryCatch #5 {Exception -> 0x0039, blocks: (B:9:0x000c, B:11:0x0012, B:15:0x001a, B:17:0x0021, B:18:0x0024, B:32:0x0017), top: B:8:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] packExtraData(byte[] bArr) {
        DataOutputStream dataOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte b16;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            } catch (Exception e16) {
                e = e16;
                dataOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                dataOutputStream = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                }
                if (dataOutputStream != null) {
                }
            }
        } catch (Exception e17) {
            e = e17;
            byteArrayOutputStream = null;
            dataOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            dataOutputStream = null;
            if (byteArrayOutputStream2 != null) {
            }
            if (dataOutputStream != null) {
            }
        }
        try {
            try {
                dataOutputStream.writeByte(1);
                if (bArr != null) {
                    b16 = (byte) bArr.length;
                    if (b16 < 0) {
                    }
                    dataOutputStream.writeByte(cNum);
                    if (b16 > 0) {
                        dataOutputStream.write(bArr, 0, b16);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    dataOutputStream.close();
                    return byteArray;
                }
                cNum = (byte) 0;
                b16 = 0;
                dataOutputStream.writeByte(cNum);
                if (b16 > 0) {
                }
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                dataOutputStream.close();
                return byteArray2;
            } catch (Throwable th7) {
                th = th7;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception e18) {
                        e18.printStackTrace();
                    }
                }
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                        throw th;
                    } catch (Exception e19) {
                        e19.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Exception e26) {
            e = e26;
            e.printStackTrace();
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e27) {
                    e27.printStackTrace();
                }
            }
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (Exception e28) {
                    e28.printStackTrace();
                }
            }
            return null;
        }
    }

    public static int setLoginExtraData(Context context, byte[] bArr) {
        LoginExtraData extraDataFromBuffer;
        if (context == null || bArr == null || ((bArr.length != 21 && bArr.length != 33) || (extraDataFromBuffer = getExtraDataFromBuffer(bArr)) == null)) {
            return -1;
        }
        return updateCachedExtraDataFile(context, extraDataFromBuffer);
    }

    private static int updateCachedExtraDataFile(Context context, LoginExtraData loginExtraData) {
        int i3 = 0;
        List loadExtraDataFromFile = loadExtraDataFromFile(context, 0);
        if (loadExtraDataFromFile == null) {
            loadExtraDataFromFile = new ArrayList();
        }
        try {
            if (loadExtraDataFromFile.size() < 3) {
                loadExtraDataFromFile.add(loginExtraData);
            } else {
                int i16 = ((LoginExtraData) loadExtraDataFromFile.get(0)).mTime;
                int size = loadExtraDataFromFile.size();
                for (int i17 = 1; i17 < size; i17++) {
                    if (i16 > ((LoginExtraData) loadExtraDataFromFile.get(i17)).mTime) {
                        i16 = ((LoginExtraData) loadExtraDataFromFile.get(i17)).mTime;
                        i3 = i17;
                    }
                }
                loadExtraDataFromFile.set(i3, loginExtraData);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return updateFile(context, loadExtraDataFromFile);
    }

    private static int updateFile(Context context, List<LoginExtraData> list) {
        String cachedDetFileFullPath;
        byte[] convertExtraDataListToBuffer;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    cachedDetFileFullPath = getCachedDetFileFullPath(context);
                    convertExtraDataListToBuffer = convertExtraDataListToBuffer(list);
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Exception e16) {
                e = e16;
            }
            if (convertExtraDataListToBuffer == null) {
                return -1;
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(cachedDetFileFullPath);
            try {
                fileOutputStream2.write(convertExtraDataListToBuffer);
                fileOutputStream2.close();
            } catch (Exception e17) {
                e = e17;
                fileOutputStream = fileOutputStream2;
                e.printStackTrace();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    return 0;
                }
                return 0;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e18) {
                        e18.printStackTrace();
                    }
                }
                throw th;
            }
            return 0;
        } catch (Exception e19) {
            e19.printStackTrace();
            return 0;
        }
    }
}
