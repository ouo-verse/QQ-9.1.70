package er2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: h, reason: collision with root package name */
    public static long f397058h = 57671680;

    /* renamed from: i, reason: collision with root package name */
    static a f397059i;

    /* renamed from: j, reason: collision with root package name */
    static final Object f397060j = new Object();

    /* renamed from: a, reason: collision with root package name */
    HashMap<String, String> f397061a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public String f397062b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f397063c = "";

    /* renamed from: d, reason: collision with root package name */
    long f397064d = 0;

    /* renamed from: e, reason: collision with root package name */
    boolean f397065e;

    /* renamed from: f, reason: collision with root package name */
    b f397066f;

    /* renamed from: g, reason: collision with root package name */
    final BroadcastReceiver f397067g;

    /* compiled from: P */
    /* renamed from: er2.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class C10262a extends BroadcastReceiver {
        C10262a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() == null) {
                return;
            }
            a aVar = a.this;
            String str = aVar.f397062b;
            aVar.a();
            a aVar2 = a.this;
            if (aVar2.f397066f != null && !str.equals(aVar2.f397062b)) {
                if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
                    a.this.g();
                    a aVar3 = a.this;
                    aVar3.f397066f.c(0, aVar3.f397062b);
                } else if (intent.getAction().equals("android.intent.action.MEDIA_MOUNTED")) {
                    a aVar4 = a.this;
                    aVar4.f397066f.c(1, aVar4.f397062b);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        void c(int i3, String str);
    }

    a() {
        C10262a c10262a = new C10262a();
        this.f397067g = c10262a;
        a();
        g();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        VideoEnvironment.getContext().registerReceiver(c10262a, intentFilter);
        this.f397065e = true;
    }

    public static long b(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("StorageManager", 2, "getFreeSpace throw an Exception!", e16);
                return 0L;
            }
            return 0L;
        }
    }

    public static a c() {
        if (f397059i == null) {
            synchronized (f397060j) {
                if (f397059i == null) {
                    f397059i = new a();
                }
            }
        }
        return f397059i;
    }

    static boolean d(String str) {
        File file = new File(str + "/qz" + Thread.currentThread().getId());
        boolean z16 = false;
        try {
            if (file.exists()) {
                if (file.delete()) {
                    z16 = file.createNewFile();
                }
            } else {
                z16 = file.createNewFile();
            }
        } finally {
            try {
                return z16;
            } finally {
            }
        }
        return z16;
    }

    void a() {
        synchronized (this.f397061a) {
            this.f397061a.clear();
            this.f397062b = "";
            this.f397064d = 0L;
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            if (!this.f397061a.containsValue(absolutePath)) {
                this.f397061a.put("external_card", absolutePath);
            }
            for (String str : this.f397061a.values()) {
                try {
                    File file = new File(str);
                    if (file.exists() && file.canWrite() && d(str)) {
                        StatFs statFs = new StatFs(str);
                        long availableBlocks = statFs.getAvailableBlocks() * statFs.getBlockSize();
                        if (availableBlocks > 0 && this.f397064d < availableBlocks) {
                            this.f397064d = availableBlocks;
                            this.f397062b = str;
                        }
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
    }

    public void e() {
        if (this.f397065e) {
            VideoEnvironment.getContext().unregisterReceiver(this.f397067g);
            this.f397065e = false;
        }
    }

    public void f(b bVar) {
        this.f397066f = bVar;
    }

    void g() {
        String absolutePath;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            absolutePath = BaseApplicationImpl.getApplication().getExternalCacheDir().getAbsolutePath();
        } else {
            absolutePath = BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath();
        }
        this.f397063c = absolutePath + "/qqvideo";
        if (QLog.isColorLevel()) {
            QLog.e("TAG", 2, "updateStorePath:storeVideoPath=" + this.f397063c);
        }
        try {
            File file = new File(this.f397063c);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception unused) {
            this.f397062b = null;
        }
    }
}
