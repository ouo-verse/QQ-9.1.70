package com.qq.e.comm.plugin.e;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.tg.splash.image.TGSplashFileUtil;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f39337a = new a();

    /* renamed from: b, reason: collision with root package name */
    private volatile int f39338b = 0;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f39339c = false;

    /* renamed from: d, reason: collision with root package name */
    private ReentrantReadWriteLock f39340d;

    /* renamed from: e, reason: collision with root package name */
    private String f39341e;

    /* renamed from: f, reason: collision with root package name */
    private String f39342f;

    private JSONObject c() {
        String c16;
        JSONObject jSONObject = new JSONObject();
        if (!this.f39339c) {
            return jSONObject;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            GDTLogger.e("DeviceIdentifier readCachedFile on main thread");
            return jSONObject;
        }
        GDTLogger.d("DeviceIdentifier readCachedFile");
        if (this.f39340d == null) {
            GDTLogger.e("DeviceIdentifier readCachedFile failed. lock is null");
            return jSONObject;
        }
        if (!StringUtil.isEmpty(this.f39341e) && !StringUtil.isEmpty(this.f39342f)) {
            try {
                this.f39340d.readLock().lock();
                c16 = at.c(a(this.f39341e, this.f39342f));
            } finally {
                try {
                    return jSONObject;
                } finally {
                }
            }
            if (!StringUtil.isEmpty(c16)) {
                return new JSONObject(c16);
            }
            return jSONObject;
        }
        GDTLogger.e("DeviceIdentifier readCachedFile failed. cache file path is null");
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject b() {
        JSONObject c16 = c();
        if (!y.a(c16)) {
            return new JSONObject();
        }
        if (c16.optInt("revise") == 1) {
            return c16;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator keys = c16.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                String optString = c16.optString(str);
                String d16 = b.d(str);
                String d17 = b.d(optString);
                if (!TextUtils.isEmpty(d16) && !TextUtils.isEmpty(d17)) {
                    jSONObject.put(d16, d17);
                }
            }
            jSONObject.put("revise", 1);
            a(jSONObject);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return jSONObject;
    }

    public void a(Context context, boolean z16) {
        if (this.f39338b != 0) {
            return;
        }
        synchronized (this) {
            if (this.f39338b != 0) {
                return;
            }
            a(1);
            this.f39339c = z16;
            this.f39340d = new ReentrantReadWriteLock();
            this.f39341e = GDTADManager.getInstance().getAppContext().getDir(TGSplashFileUtil.ADNET, 0).getAbsolutePath();
            this.f39342f = "device.dat";
            GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b();
                    a.this.a(2);
                }
            });
        }
    }

    public void a() {
        GDTLogger.d("DeviceIdentifier detele file cache");
        a(0);
        this.f39341e = GDTADManager.getInstance().getAppContext().getDir(TGSplashFileUtil.ADNET, 0).getAbsolutePath();
        this.f39342f = "device.dat";
        File file = new File(this.f39341e, this.f39342f);
        if (file.exists()) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3) {
        synchronized (this) {
            this.f39338b = i3;
        }
    }

    private void a(JSONObject jSONObject) {
        if (this.f39339c) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                GDTLogger.e("DeviceIdentifier writeCachedFile on main thread");
                return;
            }
            if (jSONObject == null) {
                GDTLogger.e("DeviceIdentifier writeCachedFile failed. cache is null");
                return;
            }
            GDTLogger.i("DeviceIdentifier writeCachedFile");
            if (this.f39340d == null) {
                GDTLogger.e("DeviceIdentifier writeCachedFile failed. lock is null");
                return;
            }
            if (!StringUtil.isEmpty(this.f39341e) && !StringUtil.isEmpty(this.f39342f)) {
                try {
                    this.f39340d.writeLock().lock();
                    at.a(a(this.f39341e, this.f39342f), jSONObject.toString());
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                return;
            }
            GDTLogger.e("DeviceIdentifier writeCachedFile failed. cache file path is null");
        }
    }

    private File a(String str, String str2) {
        File file = null;
        try {
            File file2 = new File(str);
            File file3 = new File(str, str2);
            try {
                if (!file2.exists() && !file2.mkdir()) {
                    GDTLogger.d("DeviceIdentifier cacheFile mkdir failed: ");
                    return null;
                }
                if (file3.exists()) {
                    return file3;
                }
                GDTLogger.d("DeviceIdentifier cacheFile createNewFile result: " + file3.createNewFile());
                return file3;
            } catch (IOException e16) {
                e = e16;
                file = file3;
                GDTLogger.e("DeviceIdentifier getCacheFile exception.", e);
                return file;
            }
        } catch (IOException e17) {
            e = e17;
        }
    }
}
