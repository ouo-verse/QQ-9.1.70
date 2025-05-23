package com.tencent.mobileqq.kandian.base.report;

import android.app.ActivityManager;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.d;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.b;
import com.tencent.mobileqq.kandian.base.utils.c;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ReadInJoyMMapKvStorage {
    public static final String NAME_DEFAULT = "global";
    private static final String TAG = "kandianreport.ReadInJoyMMapKvStorage";
    private static Map<String, ReadInJoyMMapKvStorage> mMapHelperMap = new ConcurrentHashMap();
    private static String mmkvRootPath;
    private MappedByteBuffer mMMapDataBuffer;
    private String mMMapFilepath;
    private String mMMapName;
    private int mMMapFileSize = 0;
    private int mMMapCurrentSize = 0;
    private int mNumberOfKeysWithDuplicated = 0;
    private RandomAccessFile mMMapMemoryMappedFile = null;
    private Map<String, String> dataMap = new HashMap();
    private int expiredTime = 0;
    private int mMMapMinSize = 4096;
    private int mMMapMaxSize = 16777216;

    ReadInJoyMMapKvStorage(String str) {
        this.mMMapName = "";
        this.mMMapFilepath = mmkvRootPath + "/" + str;
        this.mMMapName = str;
        init();
    }

    private boolean ensureMemorySize(int i3) {
        int sizeAfterRemoveDuplicatedKeys = sizeAfterRemoveDuplicatedKeys();
        this.mMMapCurrentSize = sizeAfterRemoveDuplicatedKeys;
        return sizeAfterRemoveDuplicatedKeys + i3 <= this.mMMapFileSize;
    }

    private synchronized boolean expandMMapFile() {
        Throwable th5;
        MappedByteBuffer mappedByteBuffer;
        RandomAccessFile randomAccessFile = null;
        MappedByteBuffer mappedByteBuffer2 = null;
        try {
            int i3 = this.mMMapFileSize;
            if (i3 * 2 > this.mMMapMaxSize) {
                QLog.e(TAG, 1, String.format("memory not enough, mMMapFileSize: %d mMMapMaxSize: %d", Integer.valueOf(i3), Integer.valueOf(this.mMMapMaxSize)));
                return false;
            }
            this.mMMapFileSize = i3 * 2;
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.mMMapFilepath, "rw");
            try {
                mappedByteBuffer2 = this.mMMapMemoryMappedFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, this.mMMapFileSize);
                RandomAccessFile randomAccessFile3 = this.mMMapMemoryMappedFile;
                MappedByteBuffer mappedByteBuffer3 = this.mMMapDataBuffer;
                this.mMMapMemoryMappedFile = randomAccessFile2;
                this.mMMapDataBuffer = mappedByteBuffer2;
                mappedByteBuffer2.position(this.mMMapCurrentSize);
                releaseMMapFile(randomAccessFile3);
                releaseMMapMemory(mappedByteBuffer3);
                return true;
            } catch (Throwable th6) {
                th5 = th6;
                mappedByteBuffer = mappedByteBuffer2;
                randomAccessFile = randomAccessFile2;
                QLog.e(TAG, 1, th5.getStackTrace() + "");
                releaseMMapFile(randomAccessFile);
                releaseMMapMemory(mappedByteBuffer);
                this.mMMapFileSize = this.mMMapFileSize / 2;
                try {
                    RandomAccessFile randomAccessFile4 = new RandomAccessFile(this.mMMapFilepath, "rw");
                    this.mMMapMemoryMappedFile = randomAccessFile4;
                    MappedByteBuffer map = randomAccessFile4.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, this.mMMapFileSize);
                    this.mMMapDataBuffer = map;
                    map.position(this.mMMapCurrentSize);
                    return false;
                } catch (Throwable th7) {
                    QLog.e(TAG, 1, th7.getStackTrace() + "");
                    return false;
                }
            }
        } catch (Throwable th8) {
            th5 = th8;
            mappedByteBuffer = null;
        }
    }

    public static ReadInJoyMMapKvStorage getInstance() {
        return getInstance(NAME_DEFAULT);
    }

    private int readMMapSize() {
        return (int) new File(this.mMMapFilepath).length();
    }

    public static void resetRootPath() {
        String str;
        String str2 = "default";
        AppRuntime c16 = b.c();
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(Environment.getExternalStorageDirectory().getAbsolutePath());
            sb5.append("/tencent/MobileQQ/rijmmkv/");
            if (c16 == null) {
                str = "default";
            } else {
                str = c16.getAccount();
            }
            sb5.append(str);
            mmkvRootPath = VFSAssistantUtils.getSDKPrivatePath(sb5.toString());
        } catch (Throwable th5) {
            QLog.d(TAG, 1, th5.getMessage());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(BaseApplicationImpl.getApplication().getFilesDir().getParent());
            sb6.append("/tencent/MobileQQ/rijmmkv/");
            if (c16 != null) {
                str2 = c16.getAccount();
            }
            sb6.append(str2);
            mmkvRootPath = sb6.toString();
        }
    }

    private int sizeAfterRemoveDuplicatedKeys() {
        MappedByteBuffer mappedByteBuffer = this.mMMapDataBuffer;
        if (mappedByteBuffer == null) {
            return 0;
        }
        mappedByteBuffer.clear();
        this.mMMapDataBuffer.rewind();
        this.mMMapDataBuffer.putInt(this.dataMap.size());
        int i3 = 4;
        for (Map.Entry<String, String> entry : this.dataMap.entrySet()) {
            this.mMMapDataBuffer.putInt(entry.getKey().getBytes().length);
            this.mMMapDataBuffer.put(entry.getKey().getBytes());
            if (entry.getValue() != null) {
                this.mMMapDataBuffer.putInt(entry.getValue().getBytes().length);
                this.mMMapDataBuffer.put(entry.getValue().getBytes());
            } else {
                this.mMMapDataBuffer.putInt(0);
            }
            i3 += entry.getKey().getBytes().length + 8 + (entry.getValue() != null ? entry.getValue().getBytes().length : 0);
        }
        this.mNumberOfKeysWithDuplicated = this.dataMap.size();
        return i3;
    }

    public int getExpiredTime() {
        int intValue = ((Integer) c.c("kandianreport_mmkv_expired_" + this.mMMapName, 0)).intValue();
        this.expiredTime = intValue;
        return intValue;
    }

    public synchronized String getValeForKey(String str) {
        if (!this.dataMap.containsKey(str)) {
            return null;
        }
        return this.dataMap.get(str);
    }

    public synchronized void invalidate() {
        MappedByteBuffer mappedByteBuffer = this.mMMapDataBuffer;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.clear();
        }
        this.dataMap.clear();
        releaseMMapFile(this.mMMapMemoryMappedFile);
        this.mNumberOfKeysWithDuplicated = 0;
        this.mMMapCurrentSize = 0;
        if (!TextUtils.isEmpty(this.mMMapFilepath) && d.j(this.mMMapFilepath)) {
            new File(this.mMMapFilepath).delete();
        }
        mMapHelperMap.remove(this.mMMapName);
    }

    public synchronized void setExpiredTime(int i3) {
        this.expiredTime = i3;
        c.e("kandianreport_mmkv_expired_" + this.mMMapName, Integer.valueOf(i3));
    }

    public synchronized boolean update(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "key is empty");
            return false;
        }
        int length = str.getBytes().length + 8 + (str2 != null ? str2.getBytes().length : 0);
        if (this.mMMapCurrentSize + length > this.mMMapFileSize && !ensureMemorySize(length) && !expandMMapFile()) {
            QLog.e(TAG, 2, "expand map file error key " + str + " value " + str2);
            return false;
        }
        try {
            this.mMMapDataBuffer.putInt(str.getBytes().length);
            this.mMMapCurrentSize += 4;
            this.mMMapDataBuffer.put(str.getBytes());
            this.mMMapCurrentSize += str.getBytes().length;
            if (str2 != null) {
                this.mMMapDataBuffer.putInt(str2.getBytes().length);
                this.mMMapCurrentSize += 4;
                this.mMMapDataBuffer.put(str2.getBytes());
                this.mMMapCurrentSize += str2.getBytes().length;
            } else {
                this.mMMapDataBuffer.putInt(0);
                this.mMMapCurrentSize += 4;
            }
            int i3 = this.mNumberOfKeysWithDuplicated + 1;
            this.mNumberOfKeysWithDuplicated = i3;
            this.mMMapDataBuffer.putInt(0, i3);
            this.dataMap.put(str, str2);
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5.getStackTrace() + "");
            return false;
        }
    }

    public static ReadInJoyMMapKvStorage getInstance(String str) {
        if (mMapHelperMap.containsKey(str)) {
            return mMapHelperMap.get(str);
        }
        if (mmkvRootPath == null) {
            resetRootPath();
        }
        synchronized (ReadInJoyMMapKvStorage.class) {
            if (mMapHelperMap.containsKey(str)) {
                return mMapHelperMap.get(str);
            }
            ReadInJoyMMapKvStorage readInJoyMMapKvStorage = new ReadInJoyMMapKvStorage(str);
            mMapHelperMap.put(str, readInJoyMMapKvStorage);
            return readInJoyMMapKvStorage;
        }
    }

    private void init() {
        String str;
        try {
            ActivityManager activityManager = (ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager != null && ((activityManager.getMemoryClass() * 1024) * 1024) / 10 > this.mMMapMaxSize) {
                this.mMMapMaxSize = ((activityManager.getMemoryClass() * 1024) * 1024) / 10;
            }
            int readMMapSize = readMMapSize();
            this.mMMapFileSize = readMMapSize;
            if (readMMapSize == 0) {
                this.mMMapFileSize = this.mMMapMinSize;
            }
            if (!d.j(this.mMMapFilepath)) {
                d.g(this.mMMapFilepath);
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.mMMapFilepath, "rw");
            this.mMMapMemoryMappedFile = randomAccessFile;
            MappedByteBuffer map = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, this.mMMapFileSize);
            this.mMMapDataBuffer = map;
            map.rewind();
            int i3 = this.mMMapDataBuffer.getInt();
            this.mNumberOfKeysWithDuplicated = i3;
            this.mMMapCurrentSize += 4;
            for (int i16 = 0; i16 < i3; i16++) {
                int i17 = this.mMMapDataBuffer.getInt();
                this.mMMapCurrentSize += 4;
                byte[] bArr = new byte[i17];
                this.mMMapDataBuffer.get(bArr);
                this.mMMapCurrentSize += i17;
                String str2 = new String(bArr);
                int i18 = this.mMMapDataBuffer.getInt();
                this.mMMapCurrentSize += 4;
                if (i18 != 0) {
                    byte[] bArr2 = new byte[i18];
                    this.mMMapDataBuffer.get(bArr2);
                    str = new String(bArr2);
                    this.mMMapCurrentSize += i18;
                } else {
                    str = null;
                }
                this.dataMap.put(str2, str);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5.getStackTrace() + "");
            if (ensureMemorySize(0)) {
                return;
            }
            expandMMapFile();
        }
    }

    private void releaseMMapFile(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
                randomAccessFile.getChannel().close();
            } catch (IOException e16) {
                QLog.e(TAG, 1, e16.getStackTrace() + "");
            }
        }
    }

    private void releaseMMapMemory(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer != null) {
            mappedByteBuffer.clear();
        }
    }
}
