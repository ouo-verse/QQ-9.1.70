package com.tencent.rlottie;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.network.NetQualityPluginConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.effect.engine.QEffectType;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static long f365188f;

    /* renamed from: a, reason: collision with root package name */
    private Context f365189a;

    /* renamed from: b, reason: collision with root package name */
    private File f365190b;

    /* renamed from: c, reason: collision with root package name */
    private File f365191c;

    /* renamed from: d, reason: collision with root package name */
    private Set<String> f365192d;

    /* renamed from: e, reason: collision with root package name */
    private a f365193e;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface a {
        void onClearCache(long j3, long j16, long j17);
    }

    public b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f365192d = new HashSet();
        this.f365189a = context.getApplicationContext();
        this.f365190b = new File(context.getCacheDir(), QEffectType.LOTTIE_TAG);
        File file = new File(this.f365190b, "aCache");
        this.f365191c = file;
        if (!file.exists()) {
            this.f365191c.mkdirs();
        }
    }

    private String g(String str) {
        return str.replaceAll("\\W+", "") + Sticker.JSON_SUFFIX;
    }

    private void l() {
        if (com.tencent.rlottie.a.f365185c) {
            AXrLottieNative.configureModelCacheSize(0);
            AXrLottieNative.configureModelCacheSize(10);
        }
    }

    public void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f365193e = aVar;
        }
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.f365192d.add(str);
        }
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        boolean a16 = com.tencent.rlottie.decoder.b.a(this.f365190b.getAbsolutePath());
        l();
        if (!this.f365191c.exists()) {
            this.f365191c.mkdirs();
        }
        return a16;
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        try {
            String absolutePath = this.f365191c.getAbsolutePath();
            long dirSize = AXrLottieNative.getDirSize(absolutePath, true);
            if (dirSize > 157286400) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                AXrLottieNative.clearDir(absolutePath, currentTimeMillis - 172800, true);
                l();
                SharedPreferences sharedPreferences = this.f365189a.getSharedPreferences("rlottie_cache", 0);
                long j3 = sharedPreferences.getLong("lastClearTime", 0L);
                if (j3 > 0 && this.f365193e != null) {
                    this.f365193e.onClearCache(currentTimeMillis - j3, dirSize, AXrLottieNative.getFileCount(absolutePath, true));
                }
                sharedPreferences.edit().putLong("lastClearTime", currentTimeMillis).apply();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public boolean e(String str) {
        File file;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            file = this.f365191c;
        } else {
            file = new File(this.f365191c, str);
        }
        boolean a16 = com.tencent.rlottie.decoder.b.a(file.getAbsolutePath());
        l();
        if (!this.f365191c.exists()) {
            this.f365191c.mkdirs();
        }
        return a16;
    }

    public File f(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (File) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        }
        File file = new File(i(), g(str2));
        if (file.exists()) {
            return file;
        }
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
            outputStreamWriter.write(str);
            outputStreamWriter.close();
            return file;
        } catch (IOException e16) {
            if (file.exists()) {
                file.delete();
            }
            e16.printStackTrace();
            return null;
        }
    }

    public File h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (File) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        return new File(i(), g(str));
    }

    public File i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (File) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        File file = this.f365190b;
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public boolean j() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (f365188f == 0) {
            f365188f = this.f365189a.getSharedPreferences("rlottie_cache", 0).getLong("lastCheckTime", 0L);
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (Math.abs(currentTimeMillis - f365188f) < NetQualityPluginConfig.MAX_CALL_END_DELAY_IN_SEC) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            f365188f = currentTimeMillis;
            this.f365189a.getSharedPreferences("rlottie_cache", 0).edit().putLong("lastCheckTime", f365188f).apply();
        }
        return z16;
    }

    public String k(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) file);
        }
        if (!this.f365191c.exists()) {
            Log.i("AXrLottieCacheManager", "produceLottieCacheName, result:" + this.f365191c.mkdirs());
        }
        String absolutePath = this.f365191c.getAbsolutePath();
        String absolutePath2 = file.getAbsolutePath();
        if (absolutePath2.startsWith(absolutePath)) {
            return absolutePath2;
        }
        if (!this.f365192d.isEmpty()) {
            for (String str : this.f365192d) {
                if (absolutePath2.contains(str)) {
                    int indexOf = absolutePath2.indexOf(str);
                    if (str.length() + indexOf + 1 < absolutePath2.length()) {
                        String replace = absolutePath2.substring(indexOf + str.length() + 1).replace('\\', '-').replace('/', '-');
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(absolutePath);
                        String str2 = File.separator;
                        sb5.append(str2);
                        sb5.append(str);
                        sb5.append(str2);
                        sb5.append(replace);
                        return sb5.toString();
                    }
                }
            }
        }
        String b16 = com.tencent.rlottie.decoder.b.b(file);
        if (!TextUtils.isEmpty(b16)) {
            return absolutePath + File.separator + file.getName() + "_" + b16;
        }
        return "";
    }

    public File m(String str, InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (File) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) inputStream);
        }
        File file = new File(i(), g(str));
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e16) {
                if (file.exists()) {
                    file.delete();
                }
                Log.e("AXrLottieCacheManager", "writeCacheFile: ", e16);
            }
            try {
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                } catch (Exception e17) {
                    if (file.exists()) {
                        file.delete();
                    }
                    Log.e("AXrLottieCacheManager", "writeCacheFile: ", e17);
                }
                return file;
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }
}
