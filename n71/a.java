package n71;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import java.io.File;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements SDCardMountMonitorReceiver.SDCardMountStateListener {

    /* renamed from: b, reason: collision with root package name */
    private static a f418548b;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f418549c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private String f418550a = "";

    a() {
        c();
        SDCardMountMonitorReceiver.getInstance().addListener(this);
    }

    public static a a() {
        if (f418548b == null) {
            synchronized (f418549c) {
                if (f418548b == null) {
                    f418548b = new a();
                }
            }
        }
        return f418548b;
    }

    private void c() {
        this.f418550a = CacheManager.getVideoFileCacheDir();
        if (QLog.isColorLevel()) {
            QLog.d("StorageManager", 2, "updateStorePath, storeVideoPath=" + this.f418550a);
        }
        try {
            File file = new File(this.f418550a);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e16) {
            QLog.e("StorageManager", 2, "create root path directory error", e16);
        }
    }

    public String b() {
        return this.f418550a;
    }

    @Override // cooperation.qzone.cache.SDCardMountMonitorReceiver.SDCardMountStateListener
    public void onSDCardMountStateChange(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("StorageManager", 2, "sdcard mount receiver, isMount=" + z16);
        }
        CacheManager.getVideoFileCacheDir();
    }
}
