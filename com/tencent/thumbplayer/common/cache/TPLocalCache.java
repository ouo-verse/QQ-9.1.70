package com.tencent.thumbplayer.common.cache;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class TPLocalCache {
    private static final int DEFAULT_CACHED_FILE_NUMBER_LIMIT = Integer.MAX_VALUE;
    private static final int DEFAULT_CACHE_CAPACITY_LIMIT_BYTE = 52428800;
    private static final String DEFAULT_CACHE_NAME = "TPLocalCache";
    private static final String TAG = "TPLocalCache";
    private static final Map<String, TPLocalCache> sLocalCacheInstanceMap = new ConcurrentHashMap();
    private final FileManager mFileManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class FileManager {
        private final long mCacheCapacityLimitByte;
        private final File mCacheDir;
        private final int mCachedFileNumberLimit;
        private final Map<File, Long> mCachedFileRecord = Collections.synchronizedMap(new HashMap());
        private final AtomicLong mOccupiedMemoryByte = new AtomicLong(0);

        public FileManager(File file, long j3, int i3) {
            this.mCacheDir = file;
            this.mCacheCapacityLimitByte = j3;
            this.mCachedFileNumberLimit = i3;
            recordExistingCachedFiles();
        }

        private long calculateSizeByte(File file) {
            if (file == null) {
                return 0L;
            }
            return file.length();
        }

        private void recordExistingCachedFiles() {
            File[] listFiles = this.mCacheDir.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file : listFiles) {
                this.mOccupiedMemoryByte.addAndGet(calculateSizeByte(file));
                this.mCachedFileRecord.put(file, Long.valueOf(file.lastModified()));
            }
        }

        private boolean removeOldestFile() {
            File file;
            if (this.mCachedFileRecord.isEmpty()) {
                return false;
            }
            synchronized (this.mCachedFileRecord) {
                file = null;
                long j3 = Long.MAX_VALUE;
                for (Map.Entry<File, Long> entry : this.mCachedFileRecord.entrySet()) {
                    long longValue = entry.getValue().longValue();
                    if (longValue < j3) {
                        file = entry.getKey();
                        j3 = longValue;
                    }
                }
            }
            long calculateSizeByte = calculateSizeByte(file);
            if (file != null && file.delete()) {
                this.mCachedFileRecord.remove(file);
                this.mOccupiedMemoryByte.addAndGet(-calculateSizeByte);
                return true;
            }
            TPLogUtil.e("TPLocalCache", "[removeOldestFile] Failed to delete file: " + file);
            return false;
        }

        private void updateLastModifiedTimestamp(File file) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!file.setLastModified(currentTimeMillis)) {
                TPLogUtil.w("TPLocalCache", "[updateLastModifiedTimestamp] Failed to invoke setLastModified: " + file);
            }
            this.mCachedFileRecord.put(file, Long.valueOf(currentTimeMillis));
        }

        public void clear() {
            File[] listFiles = this.mCacheDir.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file : listFiles) {
                long calculateSizeByte = calculateSizeByte(file);
                if (!file.delete()) {
                    TPLogUtil.e("TPLocalCache", "[clear] Failed to delete file: " + file);
                } else {
                    this.mOccupiedMemoryByte.addAndGet(-calculateSizeByte);
                    this.mCachedFileRecord.remove(file);
                }
            }
        }

        public File getFile(String str) {
            File newFile = newFile(str);
            if (!newFile.exists()) {
                return null;
            }
            updateLastModifiedTimestamp(newFile);
            return newFile;
        }

        public File newFile(String str) {
            return new File(this.mCacheDir, String.valueOf(str.hashCode()));
        }

        public void recordFile(File file) {
            this.mOccupiedMemoryByte.addAndGet(calculateSizeByte(file));
            updateLastModifiedTimestamp(file);
            while (true) {
                if (this.mCachedFileRecord.size() <= this.mCachedFileNumberLimit) {
                    break;
                } else if (!removeOldestFile()) {
                    TPLogUtil.e("TPLocalCache", "[recordFile] Failed to remove oldest file");
                    break;
                }
            }
            while (this.mOccupiedMemoryByte.get() > this.mCacheCapacityLimitByte) {
                if (!removeOldestFile()) {
                    TPLogUtil.e("TPLocalCache", "[recordFile] Failed to remove oldest file");
                    return;
                }
            }
        }

        public boolean removeFile(String str) {
            File newFile = newFile(str);
            long calculateSizeByte = calculateSizeByte(newFile);
            if (!newFile.delete()) {
                TPLogUtil.e("TPLocalCache", "[removeFile] Failed to delete file: " + newFile);
                return false;
            }
            this.mOccupiedMemoryByte.addAndGet(-calculateSizeByte);
            this.mCachedFileRecord.remove(newFile);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class Utils {
        private static final String LOCAL_CACHE_TIME_MARK_PREFIX = "***LOCAL_CACHE_TIME_MARK_PREFIX***";
        private static final char TIMESTAMP_TO_VALID_TIME_SEPARATOR = '-';
        private static final char VALID_TIME_TO_CONTENT_SEPARATOR = ' ';

        Utils() {
        }

        public static String clearDateInfo(String str) {
            return (str == null || !hasDateInfo(str.getBytes())) ? str : str.substring(str.indexOf(32) + 1);
        }

        private static byte[] copyOfRange(byte[] bArr, int i3, int i16) {
            int i17 = i16 - i3;
            if (i17 >= 0) {
                byte[] bArr2 = new byte[i17];
                System.arraycopy(bArr, i3, bArr2, 0, Math.min(bArr.length - i3, i17));
                return bArr2;
            }
            throw new IllegalArgumentException("From (" + i3 + ") > to (" + i16 + ")");
        }

        private static String createDateInfo(int i3) {
            return LOCAL_CACHE_TIME_MARK_PREFIX + System.currentTimeMillis() + TIMESTAMP_TO_VALID_TIME_SEPARATOR + i3 + ' ';
        }

        private static String[] getDateInfo(byte[] bArr) {
            if (!hasDateInfo(bArr)) {
                return null;
            }
            int indexOf = indexOf(bArr, TIMESTAMP_TO_VALID_TIME_SEPARATOR);
            return new String[]{new String(copyOfRange(bArr, 34, indexOf)), new String(copyOfRange(bArr, indexOf + 1, indexOf(bArr, ' ')))};
        }

        private static boolean hasDateInfo(byte[] bArr) {
            if (bArr == null || bArr.length <= 34 || !Arrays.equals(LOCAL_CACHE_TIME_MARK_PREFIX.getBytes(), copyOfRange(bArr, 0, 34)) || indexOf(bArr, TIMESTAMP_TO_VALID_TIME_SEPARATOR) == -1 || indexOf(bArr, ' ') == -1) {
                return false;
            }
            return true;
        }

        private static int indexOf(byte[] bArr, char c16) {
            for (int i3 = 0; i3 < bArr.length; i3++) {
                if (bArr[i3] == c16) {
                    return i3;
                }
            }
            return -1;
        }

        public static boolean isDue(String str) {
            return isDue(str.getBytes());
        }

        public static byte[] newByteArrayWithDateInfo(int i3, byte[] bArr) {
            byte[] bytes = createDateInfo(i3).getBytes();
            byte[] bArr2 = new byte[bytes.length + bArr.length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            return bArr2;
        }

        public static String newStringWithDateInfo(int i3, String str) {
            return createDateInfo(i3) + str;
        }

        public static boolean isDue(byte[] bArr) {
            String[] dateInfo = getDateInfo(bArr);
            if (dateInfo != null && dateInfo.length == 2) {
                try {
                    if (System.currentTimeMillis() > Long.parseLong(dateInfo[0]) + (Long.parseLong(dateInfo[1]) * 1000)) {
                        return true;
                    }
                } catch (NumberFormatException unused) {
                    TPLogUtil.e("TPLocalCache", "[isDue] Invalid date info. File probably has been broken");
                }
            }
            return false;
        }

        public static byte[] clearDateInfo(byte[] bArr) {
            return !hasDateInfo(bArr) ? bArr : copyOfRange(bArr, indexOf(bArr, ' ') + 1, bArr.length);
        }
    }

    TPLocalCache(File file, long j3, int i3) throws IOException {
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("Cache directory inaccessible");
        }
        this.mFileManager = new FileManager(file, j3, i3);
    }

    @Nullable
    public static TPLocalCache getInstance(@NonNull Context context) {
        return getInstance(context, "TPLocalCache");
    }

    public void clear() {
        this.mFileManager.clear();
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x005f: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:96), block:B:54:0x005f */
    @Nullable
    public byte[] getAsByteArray(@NonNull String str) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        File file = this.mFileManager.getFile(str);
        RandomAccessFile randomAccessFile3 = null;
        try {
            if (file == null) {
                return null;
            }
            try {
                randomAccessFile2 = new RandomAccessFile(file, "r");
            } catch (Exception e16) {
                e = e16;
                randomAccessFile2 = null;
            } catch (Throwable th5) {
                th = th5;
                if (randomAccessFile3 != null) {
                    try {
                        randomAccessFile3.close();
                    } catch (IOException e17) {
                        TPLogUtil.e("TPLocalCache", e17);
                    }
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[(int) randomAccessFile2.length()];
                if (randomAccessFile2.read(bArr) <= 0) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e18) {
                        TPLogUtil.e("TPLocalCache", e18);
                    }
                    return null;
                }
                if (!Utils.isDue(bArr)) {
                    byte[] clearDateInfo = Utils.clearDateInfo(bArr);
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e19) {
                        TPLogUtil.e("TPLocalCache", e19);
                    }
                    return clearDateInfo;
                }
                remove(str);
                try {
                    randomAccessFile2.close();
                } catch (IOException e26) {
                    TPLogUtil.e("TPLocalCache", e26);
                }
                return null;
            } catch (Exception e27) {
                e = e27;
                TPLogUtil.e("TPLocalCache", e);
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e28) {
                        TPLogUtil.e("TPLocalCache", e28);
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            randomAccessFile3 = randomAccessFile;
        }
    }

    @Nullable
    public JSONArray getAsJSONArray(@NonNull String str) {
        String asString = getAsString(str);
        if (asString == null) {
            return null;
        }
        try {
            return new JSONArray(asString);
        } catch (JSONException e16) {
            TPLogUtil.e("TPLocalCache", e16);
            return null;
        }
    }

    @Nullable
    public JSONObject getAsJSONObject(@NonNull String str) {
        String asString = getAsString(str);
        if (asString == null) {
            return null;
        }
        try {
            return new JSONObject(asString);
        } catch (JSONException e16) {
            TPLogUtil.e("TPLocalCache", e16);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getAsObject(@NonNull String str) {
        Throwable th5;
        ObjectInputStream objectInputStream;
        byte[] asByteArray = getAsByteArray(str);
        if (asByteArray == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(asByteArray);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
        } catch (Exception e16) {
            e = e16;
            objectInputStream = null;
        } catch (Throwable th6) {
            th5 = th6;
            objectInputStream = null;
            try {
                byteArrayInputStream.close();
            } catch (IOException e17) {
                TPLogUtil.e("TPLocalCache", e17);
            }
            if (objectInputStream == null) {
            }
        }
        try {
            try {
                Object readObject = objectInputStream.readObject();
                try {
                    byteArrayInputStream.close();
                } catch (IOException e18) {
                    TPLogUtil.e("TPLocalCache", e18);
                }
                try {
                    objectInputStream.close();
                } catch (IOException e19) {
                    TPLogUtil.e("TPLocalCache", e19);
                }
                return readObject;
            } catch (Throwable th7) {
                th5 = th7;
                byteArrayInputStream.close();
                if (objectInputStream == null) {
                    try {
                        objectInputStream.close();
                        throw th5;
                    } catch (IOException e26) {
                        TPLogUtil.e("TPLocalCache", e26);
                        throw th5;
                    }
                }
                throw th5;
            }
        } catch (Exception e27) {
            e = e27;
            TPLogUtil.e("TPLocalCache", e);
            try {
                byteArrayInputStream.close();
            } catch (IOException e28) {
                TPLogUtil.e("TPLocalCache", e28);
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e29) {
                    TPLogUtil.e("TPLocalCache", e29);
                }
            }
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x005e: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:95), block:B:51:0x005e */
    @Nullable
    public String getAsString(@NonNull String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        File file = this.mFileManager.getFile(str);
        BufferedReader bufferedReader3 = null;
        try {
            if (file == null) {
                return null;
            }
            try {
                bufferedReader2 = new BufferedReader(new FileReader(file));
            } catch (IOException e16) {
                e = e16;
                bufferedReader2 = null;
            } catch (Throwable th5) {
                th = th5;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e17) {
                        TPLogUtil.e("TPLocalCache", e17);
                    }
                }
                throw th;
            }
            try {
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine);
                }
                String sb6 = sb5.toString();
                if (!Utils.isDue(sb6)) {
                    String clearDateInfo = Utils.clearDateInfo(sb6);
                    try {
                        bufferedReader2.close();
                    } catch (IOException e18) {
                        TPLogUtil.e("TPLocalCache", e18);
                    }
                    return clearDateInfo;
                }
                remove(str);
                try {
                    bufferedReader2.close();
                } catch (IOException e19) {
                    TPLogUtil.e("TPLocalCache", e19);
                }
                return null;
            } catch (IOException e26) {
                e = e26;
                TPLogUtil.e("TPLocalCache", e);
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e27) {
                        TPLogUtil.e("TPLocalCache", e27);
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedReader3 = bufferedReader;
        }
    }

    @Nullable
    public File getFile(@NonNull String str) {
        return this.mFileManager.getFile(str);
    }

    public void put(@NonNull String str, @NonNull String str2) {
        File newFile = this.mFileManager.newFile(str);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(newFile), 1024);
                    try {
                        bufferedWriter2.write(str2);
                        bufferedWriter2.flush();
                        bufferedWriter2.close();
                    } catch (IOException e16) {
                        e = e16;
                        bufferedWriter = bufferedWriter2;
                        TPLogUtil.e("TPLocalCache", e);
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                        this.mFileManager.recordFile(newFile);
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e17) {
                                TPLogUtil.e("TPLocalCache", e17);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e18) {
                e = e18;
            }
        } catch (IOException e19) {
            TPLogUtil.e("TPLocalCache", e19);
        }
        this.mFileManager.recordFile(newFile);
    }

    public boolean remove(@NonNull String str) {
        return this.mFileManager.removeFile(str);
    }

    @Nullable
    public static TPLocalCache getInstance(@NonNull Context context, @NonNull String str) {
        return getInstance(context, str, IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE, Integer.MAX_VALUE);
    }

    @Nullable
    public static TPLocalCache getInstance(@NonNull Context context, @NonNull String str, long j3, int i3) {
        return getInstance(new File(context.getCacheDir(), str), j3, i3);
    }

    @Nullable
    public static TPLocalCache getInstance(@NonNull File file) {
        return getInstance(file, IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE, Integer.MAX_VALUE);
    }

    @Nullable
    public static TPLocalCache getInstance(@NonNull File file, long j3, int i3) {
        String absolutePath = file.getAbsolutePath();
        TPLocalCache tPLocalCache = null;
        try {
            synchronized (absolutePath.intern()) {
                try {
                    Map<String, TPLocalCache> map = sLocalCacheInstanceMap;
                    TPLocalCache tPLocalCache2 = map.get(absolutePath);
                    if (tPLocalCache2 == null) {
                        try {
                            TPLocalCache tPLocalCache3 = new TPLocalCache(file, j3, i3);
                            map.put(absolutePath, tPLocalCache3);
                            tPLocalCache2 = tPLocalCache3;
                        } catch (Throwable th5) {
                            th = th5;
                            tPLocalCache = tPLocalCache2;
                        }
                    }
                    return tPLocalCache2;
                } catch (Throwable th6) {
                    th = th6;
                }
            }
            throw th;
        } catch (Exception e16) {
            TPLogUtil.e("TPLocalCache", e16);
            return tPLocalCache;
        }
    }

    public void put(@NonNull String str, @NonNull String str2, int i3) {
        put(str, Utils.newStringWithDateInfo(i3, str2));
    }

    public void put(@NonNull String str, @NonNull JSONObject jSONObject) {
        put(str, jSONObject.toString());
    }

    public void put(@NonNull String str, @NonNull JSONObject jSONObject, int i3) {
        put(str, jSONObject.toString(), i3);
    }

    public void put(@NonNull String str, @NonNull JSONArray jSONArray) {
        put(str, jSONArray.toString());
    }

    public void put(@NonNull String str, @NonNull JSONArray jSONArray, int i3) {
        put(str, jSONArray.toString(), i3);
    }

    public void put(@NonNull String str, @NonNull byte[] bArr) {
        File newFile = this.mFileManager.newFile(str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(newFile);
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (Exception e16) {
                        e = e16;
                        fileOutputStream = fileOutputStream2;
                        TPLogUtil.e("TPLocalCache", e);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        this.mFileManager.recordFile(newFile);
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e17) {
                                TPLogUtil.e("TPLocalCache", e17);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e18) {
                e = e18;
            }
        } catch (IOException e19) {
            TPLogUtil.e("TPLocalCache", e19);
        }
        this.mFileManager.recordFile(newFile);
    }

    public void put(@NonNull String str, @NonNull byte[] bArr, int i3) {
        put(str, Utils.newByteArrayWithDateInfo(i3, bArr));
    }

    public void put(@NonNull String str, @NonNull Serializable serializable) {
        put(str, serializable, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0046 -> B:13:0x0049). Please report as a decompilation issue!!! */
    public void put(@NonNull String str, @NonNull Serializable serializable, int i3) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ?? r26 = 0;
        r26 = 0;
        r26 = 0;
        try {
        } catch (IOException e16) {
            TPLogUtil.e("TPLocalCache", e16);
        }
        try {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(serializable);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    r26 = -1;
                    if (i3 != -1) {
                        put(str, byteArray, i3);
                    } else {
                        put(str, byteArray);
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e17) {
                        TPLogUtil.e("TPLocalCache", e17);
                    }
                    objectOutputStream.close();
                } catch (Exception e18) {
                    e = e18;
                    r26 = objectOutputStream;
                    TPLogUtil.e("TPLocalCache", e);
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e19) {
                        TPLogUtil.e("TPLocalCache", e19);
                    }
                    if (r26 != 0) {
                        r26.close();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    r26 = objectOutputStream;
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e26) {
                        TPLogUtil.e("TPLocalCache", e26);
                    }
                    if (r26 != 0) {
                        try {
                            r26.close();
                            throw th;
                        } catch (IOException e27) {
                            TPLogUtil.e("TPLocalCache", e27);
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Exception e28) {
                e = e28;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
