package com.tencent.mobileqq.text;

import android.os.SystemClock;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.commonsdk.zip.QZipInputStream;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQSysFaceSwitcher;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqemoticon.api.IAppleEmojiManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AppleEmojiManager {
    static IPatchRedirector $redirector_ = null;
    public static final String DEFAULT_APPLE_EMOJI_SRC_FILE;
    public static final String EMOJI_FILE;
    public static final String INDEX_FILE;
    public static final String SP_KEY_APPLE_EMOJI_FILE = "apple_emoji_file";
    public static final String SP_KEY_BUILD_EMOJI_FILE = "build_emoji_file";
    public static final String TAG = "AppleEmojiManager";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42739);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        DEFAULT_APPLE_EMOJI_SRC_FILE = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "pddata/prd/early/qq.android.appleemoji");
        StringBuilder sb5 = new StringBuilder();
        String str = AppConstants.SDCARD_PATH_EMOJIS;
        sb5.append(str);
        sb5.append("emojiindex");
        INDEX_FILE = VFSAssistantUtils.getSDKPrivatePath(sb5.toString());
        EMOJI_FILE = VFSAssistantUtils.getSDKPrivatePath(str + "emojis");
    }

    public AppleEmojiManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void buildEmojiFiles(final File file, final File file2) {
        final String emojiResFilePath = getEmojiResFilePath();
        if (emojiResFilePath == null) {
            return;
        }
        logColor("extract from zip path=" + emojiResFilePath);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.text.b
            @Override // java.lang.Runnable
            public final void run() {
                AppleEmojiManager.lambda$buildEmojiFiles$1(file, file2, emojiResFilePath);
            }
        }, 64, null, false);
    }

    public static final int bytesToInt(byte[] bArr) {
        int i3 = 0;
        for (int i16 = 0; i16 < 4; i16++) {
            int i17 = bArr[i16];
            if (i17 < 0) {
                i17 += 256;
            }
            i3 |= i17 << (i16 * 8);
        }
        return i3;
    }

    private static String getEmojiResFilePath() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        String decodeString = from.decodeString(SP_KEY_APPLE_EMOJI_FILE, DEFAULT_APPLE_EMOJI_SRC_FILE);
        if (!FileUtils.fileExists(decodeString)) {
            from.removeKey(SP_KEY_APPLE_EMOJI_FILE);
            EmotcationConstants.DOUBLE_EMOJI_MAP.clear();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "apple_emoji_file file not exist, path=" + decodeString);
                return null;
            }
            return null;
        }
        return decodeString;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isEmojiFileAvailable(File file, File file2) {
        if (!QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(SP_KEY_BUILD_EMOJI_FILE, false) || !file.exists() || !file2.exists()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$buildEmojiFiles$1(File file, File file2, String str) {
        if (file.exists()) {
            file.delete();
        }
        if (file2.exists()) {
            file2.delete();
        }
        unzip(new File(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reDownloadAppleEmoji$0() {
        try {
            ((IAppleEmojiManager) QRoute.api(IAppleEmojiManager.class)).reDownloadAppleEmoji();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[reDownloadAppleEmoji] error: ", th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void loadEmojiMapFromDisk() {
        if (!QQSysFaceSwitcher.f204652a.h()) {
            logColor("loadEmojiMapFromDisk, disable apple emoji res.");
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            File file = new File(INDEX_FILE);
            File file2 = new File(EMOJI_FILE);
            if (isEmojiFileAvailable(file, file2)) {
                logColor("emoji index file exist, start loading");
                EmotcationConstants.setEmojiMap(file, file2);
            } else {
                logColor("emoji index file not exist,load fail");
                buildEmojiFiles(file, file2);
            }
        } finally {
            logColor("init full emoji index cost:" + (SystemClock.uptimeMillis() - uptimeMillis));
        }
    }

    private static void logColor(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, str);
        }
    }

    public static void reDownloadAppleEmoji() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "reDownloadAppleEmoji");
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.text.a
            @Override // java.lang.Runnable
            public final void run() {
                AppleEmojiManager.lambda$reDownloadAppleEmoji$0();
            }
        }, 128, null, false);
    }

    public static final int readIntFromStream(InputStream inputStream) throws IOException {
        int i3 = 0;
        for (int i16 = 0; i16 < 4; i16++) {
            i3 |= inputStream.read() << (i16 * 8);
        }
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02bb A[Catch: IOException -> 0x02b7, TryCatch #2 {IOException -> 0x02b7, blocks: (B:127:0x02b3, B:116:0x02bb, B:118:0x02c0), top: B:126:0x02b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02c0 A[Catch: IOException -> 0x02b7, TRY_LEAVE, TryCatch #2 {IOException -> 0x02b7, blocks: (B:127:0x02b3, B:116:0x02bb, B:118:0x02c0), top: B:126:0x02b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x028c A[Catch: all -> 0x02af, TRY_LEAVE, TryCatch #11 {all -> 0x02af, blocks: (B:151:0x0259, B:153:0x025f, B:131:0x0286, B:133:0x028c), top: B:12:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x029d A[Catch: IOException -> 0x0299, TryCatch #0 {IOException -> 0x0299, blocks: (B:147:0x0295, B:136:0x029d, B:138:0x02a2), top: B:146:0x0295 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02a2 A[Catch: IOException -> 0x0299, TRY_LEAVE, TryCatch #0 {IOException -> 0x0299, blocks: (B:147:0x0295, B:136:0x029d, B:138:0x02a2), top: B:146:0x0295 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0295 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x025f A[Catch: all -> 0x02af, TRY_LEAVE, TryCatch #11 {all -> 0x02af, blocks: (B:151:0x0259, B:153:0x025f, B:131:0x0286, B:133:0x028c), top: B:12:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0270 A[Catch: IOException -> 0x026c, TryCatch #10 {IOException -> 0x026c, blocks: (B:167:0x0268, B:156:0x0270, B:158:0x0275), top: B:166:0x0268 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0275 A[Catch: IOException -> 0x026c, TRY_LEAVE, TryCatch #10 {IOException -> 0x026c, blocks: (B:167:0x0268, B:156:0x0270, B:158:0x0275), top: B:166:0x0268 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0268 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean unzip(File file) {
        Throwable th5;
        boolean z16;
        QZipInputStream qZipInputStream;
        byte[] bArr;
        QZipInputStream qZipInputStream2;
        byte[] bArr2;
        QZipInputStream qZipInputStream3;
        BufferedOutputStream bufferedOutputStream;
        byte[] bArr3;
        QZipInputStream qZipInputStream4;
        HashMap hashMap;
        int i3;
        String str = " ";
        int i16 = 0;
        int i17 = 2;
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "unzip zip is not exist");
            }
            return false;
        }
        File file2 = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH_EMOJIS));
        if (!file2.exists()) {
            file2.mkdirs();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            try {
                qZipInputStream4 = new QZipInputStream(new BufferedInputStream(new FileInputStream(file)));
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(EMOJI_FILE));
                    try {
                        hashMap = new HashMap(((int) file.length()) / 1024);
                        byte[] buf = ByteArrayPool.getGenericInstance().getBuf(512);
                        int i18 = 0;
                        while (true) {
                            try {
                                ZipEntry nextEntry = qZipInputStream4.getNextEntry();
                                i3 = 1;
                                if (nextEntry == null) {
                                    break;
                                }
                                String name = nextEntry.getName();
                                if (name != null) {
                                    if (name.contains("/")) {
                                        name = name.substring(name.lastIndexOf(47) + 1).trim();
                                    }
                                    if (!name.equals("")) {
                                        hashMap.put(name, Integer.valueOf(i18));
                                        int size = (int) nextEntry.getSize();
                                        if (size >= 1) {
                                            writeIntToBytes(bufferedOutputStream2, size);
                                            i18 += 4;
                                            while (true) {
                                                int read = qZipInputStream4.read(buf);
                                                if (read == -1) {
                                                    break;
                                                }
                                                bufferedOutputStream2.write(buf, 0, read);
                                                i18 += read;
                                            }
                                            bufferedOutputStream2.flush();
                                        }
                                    }
                                }
                            } catch (FileNotFoundException e16) {
                                e = e16;
                                qZipInputStream3 = qZipInputStream4;
                                bArr2 = buf;
                                bufferedOutputStream = bufferedOutputStream2;
                                if (QLog.isColorLevel()) {
                                }
                                if (qZipInputStream3 != null) {
                                }
                                if (bufferedOutputStream != null) {
                                }
                                if (bArr2 != null) {
                                }
                            } catch (IOException e17) {
                                e = e17;
                                qZipInputStream2 = qZipInputStream4;
                                bArr = buf;
                                bufferedOutputStream = bufferedOutputStream2;
                                if (QLog.isColorLevel()) {
                                }
                                if (qZipInputStream2 != null) {
                                }
                                if (bufferedOutputStream != null) {
                                }
                                if (bArr != null) {
                                }
                            } catch (Throwable th6) {
                                th5 = th6;
                                qZipInputStream = qZipInputStream4;
                                bArr3 = buf;
                                bufferedOutputStream = bufferedOutputStream2;
                                if (qZipInputStream != null) {
                                }
                                if (bufferedOutputStream != null) {
                                }
                                if (bArr3 != 0) {
                                }
                            }
                        }
                        ByteArrayPool.getGenericInstance().returnBuf(buf);
                        bufferedOutputStream2.close();
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "build emoji file success");
                        }
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(INDEX_FILE));
                    } catch (FileNotFoundException e18) {
                        e = e18;
                        qZipInputStream3 = qZipInputStream4;
                        bufferedOutputStream = bufferedOutputStream2;
                    } catch (IOException e19) {
                        e = e19;
                        qZipInputStream2 = qZipInputStream4;
                        bufferedOutputStream = bufferedOutputStream2;
                    } catch (Throwable th7) {
                        th5 = th7;
                        qZipInputStream = qZipInputStream4;
                        bufferedOutputStream = bufferedOutputStream2;
                    }
                } catch (FileNotFoundException e26) {
                    e = e26;
                    qZipInputStream3 = qZipInputStream4;
                    bArr2 = null;
                    bufferedOutputStream = null;
                    if (QLog.isColorLevel()) {
                    }
                    if (qZipInputStream3 != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    if (bArr2 != null) {
                    }
                } catch (IOException e27) {
                    e = e27;
                    qZipInputStream2 = qZipInputStream4;
                    bArr = null;
                    bufferedOutputStream = null;
                    if (QLog.isColorLevel()) {
                    }
                    if (qZipInputStream2 != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    if (bArr != null) {
                    }
                } catch (Throwable th8) {
                    th5 = th8;
                    qZipInputStream = qZipInputStream4;
                    z16 = false;
                    bufferedOutputStream = null;
                    bArr3 = z16;
                    if (qZipInputStream != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    if (bArr3 != 0) {
                    }
                }
            } catch (FileNotFoundException e28) {
                e = e28;
                bArr2 = null;
                qZipInputStream3 = null;
            } catch (IOException e29) {
                e = e29;
                bArr = null;
                qZipInputStream2 = null;
            } catch (Throwable th9) {
                th5 = th9;
                z16 = false;
                qZipInputStream = null;
            }
            try {
                try {
                    for (String str2 : hashMap.keySet()) {
                        try {
                            if (!str2.contains(" ")) {
                                String substring = str2.substring(i17, str2.length() - 4);
                                int intValue = ((Integer) hashMap.get(str2)).intValue();
                                int parseInt = Integer.parseInt(substring, 16);
                                bufferedOutputStream.write(i3);
                                writeIntToBytes(bufferedOutputStream, parseInt);
                                writeIntToBytes(bufferedOutputStream, intValue);
                            } else {
                                String[] split = str2.substring(i16, str2.length() - 4).split(" ");
                                int intValue2 = ((Integer) hashMap.get(str2)).intValue();
                                if (split != null) {
                                    int length = split.length;
                                    int[] iArr = new int[length];
                                    while (i16 < split.length) {
                                        iArr[i16] = Integer.parseInt(split[i16].substring(i17), 16);
                                        i16++;
                                        i17 = 2;
                                    }
                                    bufferedOutputStream.write(split.length);
                                    for (int i19 = 0; i19 < length; i19++) {
                                        writeIntToBytes(bufferedOutputStream, iArr[i19]);
                                    }
                                    writeIntToBytes(bufferedOutputStream, intValue2);
                                }
                            }
                        } catch (Exception e36) {
                            QLog.e(TAG, 1, "fail to handle unicode:", str2, e36);
                        }
                        i16 = 0;
                        i17 = 2;
                        i3 = 1;
                    }
                    bufferedOutputStream.flush();
                    QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(SP_KEY_BUILD_EMOJI_FILE, true);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "build emoji index success");
                    }
                    File file3 = new File(INDEX_FILE);
                    File file4 = new File(EMOJI_FILE);
                    if (file3.exists() && file4.exists()) {
                        EmotcationConstants.setEmojiMap(file3, file4);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "unzip EMOJI_MAP size=" + EmotcationConstants.EMOJI_MAP.size() + "DOUBLE_EMOJI_MAP size" + EmotcationConstants.DOUBLE_EMOJI_MAP.size());
                    }
                    try {
                        qZipInputStream4.close();
                        bufferedOutputStream.close();
                    } catch (IOException e37) {
                        e37.printStackTrace();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "cost:" + (SystemClock.uptimeMillis() - uptimeMillis));
                        return true;
                    }
                    return true;
                } catch (FileNotFoundException e38) {
                    e = e38;
                    qZipInputStream3 = qZipInputStream4;
                    bArr2 = null;
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "file not found", e);
                    }
                    if (qZipInputStream3 != null) {
                        try {
                            qZipInputStream3.close();
                        } catch (IOException e39) {
                            e39.printStackTrace();
                            return false;
                        }
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (bArr2 != null) {
                        ByteArrayPool.getGenericInstance().returnBuf(bArr2);
                        return false;
                    }
                    return false;
                } catch (IOException e46) {
                    e = e46;
                    qZipInputStream2 = qZipInputStream4;
                    bArr = null;
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "IOE ", e);
                    }
                    if (qZipInputStream2 != null) {
                        try {
                            qZipInputStream2.close();
                        } catch (IOException e47) {
                            e47.printStackTrace();
                            return false;
                        }
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (bArr != null) {
                        ByteArrayPool.getGenericInstance().returnBuf(bArr);
                        return false;
                    }
                    return false;
                }
            } catch (Throwable th10) {
                th5 = th10;
                qZipInputStream = qZipInputStream4;
                bArr3 = 0;
                if (qZipInputStream != null) {
                    try {
                        qZipInputStream.close();
                    } catch (IOException e48) {
                        e48.printStackTrace();
                        throw th5;
                    }
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bArr3 != 0) {
                    ByteArrayPool.getGenericInstance().returnBuf(bArr3);
                    throw th5;
                }
                throw th5;
            }
        } catch (Throwable th11) {
            th5 = th11;
            bArr3 = str;
        }
    }

    public static final void writeIntToBytes(OutputStream outputStream, int i3) throws IOException {
        for (int i16 = 0; i16 < 4; i16++) {
            outputStream.write((i3 >> (i16 * 8)) & 255);
        }
    }
}
