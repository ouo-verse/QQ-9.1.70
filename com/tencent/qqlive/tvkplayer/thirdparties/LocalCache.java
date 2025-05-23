package com.tencent.qqlive.tvkplayer.thirdparties;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
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
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class LocalCache {
    private static final int MAX_COUNT = Integer.MAX_VALUE;
    private static final int MAX_SIZE = 50000000;
    private static final String TAG = "TVKPlayer[LocalCache]";
    private static final Map<String, LocalCache> mInstanceMap = new HashMap();
    private final ACacheManager mCache;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ACacheManager {
        private final AtomicInteger cacheCount;
        protected File cacheDir;
        private final AtomicLong cacheSize;
        private final int countLimit;
        private final Map<File, Long> lastUsageDates;
        private final long sizeLimit;

        private void calculateCacheSizeAndCacheCount() {
            File[] listFiles = this.cacheDir.listFiles();
            if (listFiles != null) {
                int i3 = 0;
                int i16 = 0;
                for (File file : listFiles) {
                    i3 = (int) (i3 + calculateSize(file));
                    i16++;
                    this.lastUsageDates.put(file, Long.valueOf(file.lastModified()));
                }
                this.cacheSize.set(i3);
                this.cacheCount.set(i16);
            }
        }

        private long calculateSize(File file) {
            if (file == null) {
                return 0L;
            }
            return file.length();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.lastUsageDates.clear();
            this.cacheSize.set(0L);
            File[] listFiles = this.cacheDir.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    file.delete();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File get(String str) {
            File newFile = newFile(str);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            newFile.setLastModified(valueOf.longValue());
            this.lastUsageDates.put(newFile, valueOf);
            return newFile;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File newFile(String str) {
            return new File(this.cacheDir, str.hashCode() + "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void put(File file) {
            int i3 = this.cacheCount.get();
            while (true) {
                if (i3 + 1 <= this.countLimit) {
                    break;
                }
                long removeNext = removeNext();
                if (removeNext <= 0) {
                    TVKLogUtil.e(LocalCache.TAG, "count limit! removeNext return illegal size, break");
                    break;
                } else {
                    this.cacheSize.addAndGet(-removeNext);
                    i3 = this.cacheCount.addAndGet(-1);
                }
            }
            this.cacheCount.addAndGet(1);
            long calculateSize = calculateSize(file);
            long j3 = this.cacheSize.get();
            while (true) {
                if (j3 + calculateSize <= this.sizeLimit) {
                    break;
                }
                long removeNext2 = removeNext();
                if (removeNext2 <= 0) {
                    TVKLogUtil.e(LocalCache.TAG, "size limit! removeNext return illegal size, break");
                    break;
                }
                j3 = this.cacheSize.addAndGet(-removeNext2);
            }
            this.cacheSize.addAndGet(calculateSize);
            long currentTimeMillis = System.currentTimeMillis();
            file.setLastModified(currentTimeMillis);
            this.lastUsageDates.put(file, Long.valueOf(currentTimeMillis));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean remove(String str) {
            return get(str).delete();
        }

        private long removeNext() {
            File file;
            if (this.lastUsageDates.isEmpty()) {
                TVKLogUtil.e(LocalCache.TAG, "lastUsageDates.isEmpty, remove no file");
                return 0L;
            }
            Set<Map.Entry<File, Long>> entrySet = this.lastUsageDates.entrySet();
            synchronized (this.lastUsageDates) {
                file = null;
                Long l3 = null;
                for (Map.Entry<File, Long> entry : entrySet) {
                    if (file == null) {
                        file = entry.getKey();
                        l3 = entry.getValue();
                    } else {
                        Long value = entry.getValue();
                        if (value.longValue() < l3.longValue()) {
                            file = entry.getKey();
                            l3 = value;
                        }
                    }
                }
            }
            if (file == null) {
                TVKLogUtil.e(LocalCache.TAG, "mostLongUsedFile == null, remove no file");
                return 0L;
            }
            long calculateSize = calculateSize(file);
            if (file.delete()) {
                this.lastUsageDates.remove(file);
            }
            return calculateSize;
        }

        ACacheManager(File file, long j3, int i3) {
            this.lastUsageDates = Collections.synchronizedMap(new HashMap());
            this.cacheDir = file;
            this.sizeLimit = j3;
            this.countLimit = i3;
            this.cacheSize = new AtomicLong();
            this.cacheCount = new AtomicInteger();
            calculateCacheSizeAndCacheCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Utils {
        private static final char mSeparator = ' ';

        Utils() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] Bitmap2Bytes(Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Bitmap Bytes2Bimap(byte[] bArr) {
            int length = bArr.length;
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Drawable bitmap2Drawable(Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            return new BitmapDrawable(bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String clearDateInfo(String str) {
            return (str == null || !hasDateInfo(str.getBytes())) ? str : str.substring(str.indexOf(32) + 1, str.length());
        }

        private static byte[] copyOfRange(byte[] bArr, int i3, int i16) {
            int i17 = i16 - i3;
            if (i17 >= 0) {
                byte[] bArr2 = new byte[i17];
                System.arraycopy(bArr, i3, bArr2, 0, Math.min(bArr.length - i3, i17));
                return bArr2;
            }
            throw new IllegalArgumentException(i3 + " > " + i16);
        }

        private static String createDateInfo(int i3) {
            String str = System.currentTimeMillis() + "";
            while (str.length() < 13) {
                str = "0" + str;
            }
            return str + "-" + i3 + ' ';
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Bitmap drawable2Bitmap(Drawable drawable) {
            Bitmap.Config config;
            if (drawable == null) {
                return null;
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (drawable.getOpacity() != -1) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.RGB_565;
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        }

        private static String[] getDateInfoFromDate(byte[] bArr) {
            if (hasDateInfo(bArr)) {
                return new String[]{new String(copyOfRange(bArr, 0, 13), Charset.forName("UTF-8")), new String(copyOfRange(bArr, 14, indexOf(bArr, ' ')))};
            }
            return null;
        }

        private static boolean hasDateInfo(byte[] bArr) {
            if (bArr != null && bArr.length > 15 && bArr[13] == 45 && indexOf(bArr, ' ') > 14) {
                return true;
            }
            return false;
        }

        private static int indexOf(byte[] bArr, char c16) {
            for (int i3 = 0; i3 < bArr.length; i3++) {
                if (bArr[i3] == c16) {
                    return i3;
                }
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isDue(String str) {
            return isDue(str.getBytes());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] newByteArrayWithDateInfo(int i3, byte[] bArr) {
            byte[] bytes = createDateInfo(i3).getBytes();
            byte[] bArr2 = new byte[bytes.length + bArr.length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            return bArr2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String newStringWithDateInfo(int i3, String str) {
            return createDateInfo(i3) + str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isDue(byte[] bArr) {
            String[] dateInfoFromDate = getDateInfoFromDate(bArr);
            if (dateInfoFromDate != null && dateInfoFromDate.length == 2) {
                String str = dateInfoFromDate[0];
                while (str.startsWith("0")) {
                    str = str.substring(1, str.length());
                }
                try {
                    if (System.currentTimeMillis() > Long.valueOf(str).longValue() + (Long.valueOf(dateInfoFromDate[1]).longValue() * 1000)) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] clearDateInfo(byte[] bArr) {
            return hasDateInfo(bArr) ? copyOfRange(bArr, indexOf(bArr, ' ') + 1, bArr.length) : bArr;
        }
    }

    LocalCache(File file, long j3, int i3) throws Exception {
        if (!file.exists() && !file.mkdirs()) {
            TVKLogUtil.e(TAG, "cacheDir=" + file.getAbsolutePath() + " not exits, and can not mkdirs");
            this.mCache = null;
            return;
        }
        this.mCache = new ACacheManager(file, j3, i3);
    }

    public static LocalCache get(Context context) {
        return get(context, "LocalCache");
    }

    private static String myPid() {
        return "_" + Process.myPid();
    }

    public void clear() {
        ACacheManager aCacheManager = this.mCache;
        if (aCacheManager != null) {
            aCacheManager.clear();
        }
    }

    public File file(String str) {
        ACacheManager aCacheManager = this.mCache;
        if (aCacheManager != null) {
            File newFile = aCacheManager.newFile(str);
            if (!newFile.exists()) {
                return null;
            }
            return newFile;
        }
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0066: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:103), block:B:58:0x0066 */
    public byte[] getAsBinary(String str) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        ACacheManager aCacheManager = this.mCache;
        RandomAccessFile randomAccessFile3 = null;
        try {
            if (aCacheManager != null) {
                try {
                    File file = aCacheManager.get(str);
                    if (!file.exists()) {
                        return null;
                    }
                    randomAccessFile2 = new RandomAccessFile(file, "r");
                    try {
                        byte[] bArr = new byte[(int) randomAccessFile2.length()];
                        if (randomAccessFile2.read(bArr) > 0) {
                            if (!Utils.isDue(bArr)) {
                                byte[] clearDateInfo = Utils.clearDateInfo(bArr);
                                try {
                                    randomAccessFile2.close();
                                } catch (IOException e16) {
                                    TVKLogUtil.e(TAG, e16);
                                }
                                return clearDateInfo;
                            }
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e17) {
                                TVKLogUtil.e(TAG, e17);
                            }
                            remove(str);
                            return null;
                        }
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e18) {
                            TVKLogUtil.e(TAG, e18);
                        }
                        return null;
                    } catch (Exception e19) {
                        e = e19;
                        TVKLogUtil.e(TAG, e);
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e26) {
                                TVKLogUtil.e(TAG, e26);
                            }
                        }
                        return null;
                    }
                } catch (Exception e27) {
                    e = e27;
                    randomAccessFile2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (randomAccessFile3 != null) {
                        try {
                            randomAccessFile3.close();
                        } catch (IOException e28) {
                            TVKLogUtil.e(TAG, e28);
                        }
                    }
                    throw th;
                }
            } else {
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            randomAccessFile3 = randomAccessFile;
        }
    }

    public Bitmap getAsBitmap(String str) {
        if (getAsBinary(str) != null) {
            return Utils.Bytes2Bimap(getAsBinary(str));
        }
        return null;
    }

    public Drawable getAsDrawable(String str) {
        if (getAsBinary(str) != null) {
            return Utils.bitmap2Drawable(Utils.Bytes2Bimap(getAsBinary(str)));
        }
        return null;
    }

    public JSONArray getAsJSONArray(String str) {
        try {
            return new JSONArray(getAsString(str));
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
            return null;
        }
    }

    public JSONObject getAsJSONObject(String str) {
        try {
            return new JSONObject(getAsString(str));
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getAsObject(String str) {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th5;
        ObjectInputStream objectInputStream;
        byte[] asBinary = getAsBinary(str);
        if (asBinary == null) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(asBinary);
        } catch (Exception e16) {
            e = e16;
            objectInputStream = null;
            byteArrayInputStream = null;
        } catch (Throwable th6) {
            byteArrayInputStream = null;
            th5 = th6;
            objectInputStream = null;
        }
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
        } catch (Exception e17) {
            e = e17;
            objectInputStream = null;
        } catch (Throwable th7) {
            th5 = th7;
            objectInputStream = null;
            if (byteArrayInputStream != null) {
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
                    TVKLogUtil.e(TAG, e18, "LocalCache.getAsObject.bais.close() has a exception");
                }
                try {
                    objectInputStream.close();
                } catch (IOException e19) {
                    TVKLogUtil.e(TAG, e19, "LocalCache.getAsObject.ois.close() has a exception");
                }
                return readObject;
            } catch (Throwable th8) {
                th5 = th8;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e26) {
                        TVKLogUtil.e(TAG, e26, "LocalCache.getAsObject.bais.close() has a exception");
                    }
                }
                if (objectInputStream == null) {
                    try {
                        objectInputStream.close();
                        throw th5;
                    } catch (IOException e27) {
                        TVKLogUtil.e(TAG, e27, "LocalCache.getAsObject.ois.close() has a exception");
                        throw th5;
                    }
                }
                throw th5;
            }
        } catch (Exception e28) {
            e = e28;
            TVKLogUtil.e(TAG, e, "LocalCache.getAsObject has a exception");
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e29) {
                    TVKLogUtil.e(TAG, e29, "LocalCache.getAsObject.bais.close() has a exception");
                }
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e36) {
                    TVKLogUtil.e(TAG, e36, "LocalCache.getAsObject.ois.close() has a exception");
                }
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getAsString(String str) {
        BufferedReader bufferedReader;
        ACacheManager aCacheManager = this.mCache;
        BufferedReader bufferedReader2 = null;
        if (aCacheManager != null) {
            File file = aCacheManager.get(str);
            if (!file.exists()) {
                return null;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                String str2 = "";
                while (true) {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            str2 = str2 + readLine;
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e16) {
                                    TVKLogUtil.e(TAG, e16);
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e17) {
                        e = e17;
                        TVKLogUtil.e(TAG, e);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e18) {
                                TVKLogUtil.e(TAG, e18);
                            }
                        }
                        return null;
                    }
                }
                if (!Utils.isDue(str2)) {
                    String clearDateInfo = Utils.clearDateInfo(str2);
                    try {
                        bufferedReader.close();
                    } catch (IOException e19) {
                        TVKLogUtil.e(TAG, e19);
                    }
                    return clearDateInfo;
                }
                try {
                    bufferedReader.close();
                } catch (IOException e26) {
                    TVKLogUtil.e(TAG, e26);
                }
                remove(str);
                return null;
            } catch (IOException e27) {
                e = e27;
                bufferedReader = null;
            } catch (Throwable th6) {
                th = th6;
                if (bufferedReader2 != null) {
                }
                throw th;
            }
        } else {
            return null;
        }
    }

    public void put(String str, String str2) {
        ACacheManager aCacheManager = this.mCache;
        if (aCacheManager == null) {
            return;
        }
        File newFile = aCacheManager.newFile(str);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(newFile), 1024);
                try {
                    bufferedWriter2.write(str2);
                    try {
                        bufferedWriter2.flush();
                    } catch (IOException e16) {
                        TVKLogUtil.e(TAG, e16, "put(String key, String value).out.flush");
                    }
                } catch (IOException e17) {
                    e = e17;
                    bufferedWriter = bufferedWriter2;
                    TVKLogUtil.e(TAG, e, "put(String key, String value).out.write");
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.flush();
                        } catch (IOException e18) {
                            TVKLogUtil.e(TAG, e18, "put(String key, String value).out.flush");
                        }
                        try {
                            bufferedWriter.close();
                        } catch (IOException e19) {
                            e = e19;
                            TVKLogUtil.e(TAG, e, "put(String key, String value).out.close");
                            this.mCache.put(newFile);
                        }
                    }
                    this.mCache.put(newFile);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.flush();
                        } catch (IOException e26) {
                            TVKLogUtil.e(TAG, e26, "put(String key, String value).out.flush");
                        }
                        try {
                            bufferedWriter.close();
                        } catch (IOException e27) {
                            TVKLogUtil.e(TAG, e27, "put(String key, String value).out.close");
                        }
                    }
                    this.mCache.put(newFile);
                    throw th;
                }
                try {
                    bufferedWriter2.close();
                } catch (IOException e28) {
                    e = e28;
                    TVKLogUtil.e(TAG, e, "put(String key, String value).out.close");
                    this.mCache.put(newFile);
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e29) {
            e = e29;
        }
        this.mCache.put(newFile);
    }

    public boolean remove(String str) {
        ACacheManager aCacheManager = this.mCache;
        if (aCacheManager != null) {
            return aCacheManager.remove(str);
        }
        return false;
    }

    public static LocalCache get(Context context, String str) {
        return get(new File(context.getCacheDir(), str), 50000000L, Integer.MAX_VALUE);
    }

    public static LocalCache get(File file) {
        return get(file, 50000000L, Integer.MAX_VALUE);
    }

    public static LocalCache get(Context context, long j3, int i3) {
        return get(new File(context.getCacheDir(), "LocalCache"), j3, i3);
    }

    public static LocalCache get(File file, long j3, int i3) {
        LocalCache localCache;
        try {
            localCache = mInstanceMap.get(file.getAbsoluteFile() + myPid());
        } catch (Exception unused) {
            localCache = null;
        }
        if (localCache != null) {
            return localCache;
        }
        try {
            LocalCache localCache2 = new LocalCache(file, j3, i3);
            try {
                mInstanceMap.put(file.getAbsolutePath() + myPid(), localCache2);
            } catch (Throwable unused2) {
            }
            return localCache2;
        } catch (Throwable unused3) {
            return localCache;
        }
    }

    public void put(String str, String str2, int i3) {
        put(str, Utils.newStringWithDateInfo(i3, str2));
    }

    public void put(String str, JSONObject jSONObject) {
        put(str, jSONObject.toString());
    }

    public void put(String str, JSONObject jSONObject, int i3) {
        put(str, jSONObject.toString(), i3);
    }

    public void put(String str, JSONArray jSONArray) {
        put(str, jSONArray.toString());
    }

    public void put(String str, JSONArray jSONArray, int i3) {
        put(str, jSONArray.toString(), i3);
    }

    public void put(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        ACacheManager aCacheManager = this.mCache;
        if (aCacheManager != null) {
            File newFile = aCacheManager.newFile(str);
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(newFile);
                    try {
                        fileOutputStream.write(bArr);
                    } catch (Exception e16) {
                        e = e16;
                        fileOutputStream2 = fileOutputStream;
                        TVKLogUtil.e(TAG, e, "put.write has a exception");
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.flush();
                                fileOutputStream2.close();
                            } catch (IOException e17) {
                                e = e17;
                                TVKLogUtil.e(TAG, e, "close output stream has a exception");
                                this.mCache.put(newFile);
                            }
                        }
                        this.mCache.put(newFile);
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.flush();
                                fileOutputStream2.close();
                            } catch (IOException e18) {
                                TVKLogUtil.e(TAG, e18, "close output stream has a exception");
                            }
                        }
                        this.mCache.put(newFile);
                        throw th;
                    }
                } catch (Exception e19) {
                    e = e19;
                }
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e26) {
                    e = e26;
                    TVKLogUtil.e(TAG, e, "close output stream has a exception");
                    this.mCache.put(newFile);
                }
                this.mCache.put(newFile);
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            TVKLogUtil.e(TAG, "mCache == null");
        }
    }

    public void put(String str, byte[] bArr, int i3) {
        put(str, Utils.newByteArrayWithDateInfo(i3, bArr));
    }

    public void put(String str, Serializable serializable) {
        put(str, serializable, -1);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x003c -> B:11:0x003f). Please report as a decompilation issue!!! */
    public void put(String str, Serializable serializable, int i3) {
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream2.writeObject(serializable);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (i3 != -1) {
                            put(str, byteArray, i3);
                        } else {
                            put(str, byteArray);
                        }
                        objectOutputStream2.close();
                    } catch (Exception e16) {
                        e = e16;
                        objectOutputStream = objectOutputStream2;
                        TVKLogUtil.e(TAG, e, "LocalCache.put, has a exception");
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Throwable th6) {
                                TVKLogUtil.e(TAG, th6, "LocalCache.put.finally.oos.close() has a exception");
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (Exception e17) {
                e = e17;
            }
        } catch (Throwable th8) {
            TVKLogUtil.e(TAG, th8, "LocalCache.put.finally.oos.close() has a exception");
        }
    }

    public void put(String str, Bitmap bitmap) {
        put(str, Utils.Bitmap2Bytes(bitmap));
    }

    public void put(String str, Bitmap bitmap, int i3) {
        put(str, Utils.Bitmap2Bytes(bitmap), i3);
    }

    public void put(String str, Drawable drawable) {
        put(str, Utils.drawable2Bitmap(drawable));
    }

    public void put(String str, Drawable drawable, int i3) {
        put(str, Utils.drawable2Bitmap(drawable), i3);
    }
}
