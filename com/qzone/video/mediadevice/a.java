package com.qzone.video.mediadevice;

import android.os.StatFs;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.QZoneFilePath;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import cooperation.qzone.util.QZLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a implements SDCardMountMonitorReceiver.SDCardMountStateListener {

    /* renamed from: b, reason: collision with root package name */
    private static a f60091b;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f60092c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private String f60093a = "";

    a() {
        e();
        SDCardMountMonitorReceiver.getInstance().addListener(this);
    }

    public static String a() {
        return QZoneFilePath.DCIM_CAMERA_PATH;
    }

    public static long b(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception e16) {
            QZLog.w("StorageManager", "getFreeSpace error", e16);
            return 0L;
        }
    }

    public static a c() {
        if (f60091b == null) {
            synchronized (f60092c) {
                if (f60091b == null) {
                    f60091b = new a();
                }
            }
        }
        return f60091b;
    }

    private void e() {
        this.f60093a = CacheManager.getVideoFileCacheDir();
        if (QZLog.isColorLevel()) {
            QZLog.d("StorageManager", 2, "updateStorePath, storeVideoPath=" + this.f60093a);
        }
        try {
            File file = new File(this.f60093a);
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        } catch (Exception e16) {
            QZLog.e("StorageManager", "create root path directory error", e16);
        }
    }

    public String d() {
        return this.f60093a;
    }

    @Override // cooperation.qzone.cache.SDCardMountMonitorReceiver.SDCardMountStateListener
    public void onSDCardMountStateChange(boolean z16) {
        if (QZLog.isColorLevel()) {
            QZLog.d("StorageManager", 2, "sdcard mount receiver, isMount=" + z16);
        }
        CacheManager.getVideoFileCacheDir();
    }
}
