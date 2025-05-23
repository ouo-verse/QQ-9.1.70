package com.tencent.rmonitor.base.config.impl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.bugly.GlobalConfig;
import com.tencent.bugly.common.reporter.upload.QAPMUpload;
import com.tencent.bugly.common.utils.FileUtil;
import com.tencent.rmonitor.base.config.impl.IConfigApply;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public class d extends QAPMUpload implements IConfigApply {

    /* renamed from: d, reason: collision with root package name */
    private final b f365350d;

    /* renamed from: e, reason: collision with root package name */
    private final c f365351e;

    public d(@NotNull URL url) {
        super(url);
        this.f365350d = new b();
        this.f365351e = new c();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private IConfigApply.LoadConfigMode g() {
        int i3;
        int i16;
        int i17;
        if (GlobalConfig.isInStandaloneMode()) {
            Logger.f365497g.w("RMonitor_config_Apply", "load config fail for app in standalone mode.");
            return IConfigApply.LoadConfigMode.FROM_LOCAL;
        }
        JSONObject a16 = this.f365350d.a();
        long uptimeMillis = SystemClock.uptimeMillis();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Content-Type", "application/x-gzip");
        hashMap.put("Content-Encoding", "gzip");
        IConfigApply.LoadConfigMode loadConfigMode = IConfigApply.LoadConfigMode.FROM_LOCAL;
        HttpURLConnection connectionBuilder = connectionBuilder(hashMap, 30000, 30000);
        if (connectionBuilder != null) {
            try {
                if (Logger.verbos) {
                    Logger.f365497g.v("RMonitor_config_Apply", "apply param: " + a16);
                }
                i(connectionBuilder, a16);
                i16 = connectionBuilder.getResponseCode();
                if (i16 == 200) {
                    try {
                        String h16 = h(connectionBuilder);
                        if (Logger.verbos) {
                            Logger.f365497g.v("RMonitor_config_Apply", "config from server: " + h16);
                        }
                        if (!TextUtils.isEmpty(h16)) {
                            this.f365351e.d(new JSONObject(h16));
                            loadConfigMode = IConfigApply.LoadConfigMode.FROM_SERVICE;
                        }
                        i3 = 1;
                        i16 = 0;
                    } catch (Throwable th5) {
                        th = th5;
                        i3 = 1;
                        try {
                            Logger.f365497g.c("RMonitor_config_Apply", th);
                            connectionBuilder.disconnect();
                            i16 = 0;
                            i17 = i3;
                            com.tencent.rmonitor.sla.d.b().a("RMConfigEvent", i17, i16, SystemClock.uptimeMillis() - uptimeMillis);
                            if (Logger.verbos) {
                            }
                            return loadConfigMode;
                        } finally {
                            connectionBuilder.disconnect();
                        }
                    }
                } else {
                    i3 = 0;
                }
            } catch (Throwable th6) {
                th = th6;
                i3 = 0;
            }
            i17 = i3;
        } else {
            i16 = 0;
            i17 = 0;
        }
        com.tencent.rmonitor.sla.d.b().a("RMConfigEvent", i17, i16, SystemClock.uptimeMillis() - uptimeMillis);
        if (Logger.verbos) {
            Logger.f365497g.v("RMonitor_config_Apply", String.format(Locale.getDefault(), "load config from service, errorCode: %d, configMode: %s", Integer.valueOf(i16), loadConfigMode));
        }
        return loadConfigMode;
    }

    private String h(HttpURLConnection httpURLConnection) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            String readStream = FileUtil.readStream(bufferedInputStream, 8192);
            bufferedInputStream.close();
            return readStream;
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
    }

    private void i(HttpURLConnection httpURLConnection, JSONObject jSONObject) throws IOException {
        DataOutputStream dataOutputStream;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                gZIPOutputStream = new GZIPOutputStream(dataOutputStream);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                gZIPOutputStream.write(jSONObject.toString().getBytes(Charset.forName("utf-8")));
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                dataOutputStream.close();
            } catch (Throwable th6) {
                th = th6;
                gZIPOutputStream2 = gZIPOutputStream;
                if (gZIPOutputStream2 != null) {
                    gZIPOutputStream2.close();
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            dataOutputStream = null;
        }
    }

    @Override // com.tencent.rmonitor.base.config.impl.IConfigApply
    public c e() {
        return this.f365351e;
    }

    @Override // com.tencent.rmonitor.base.config.impl.IConfigApply
    public void f(b bVar) {
        this.f365350d.d(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    @Override // com.tencent.rmonitor.base.config.impl.IConfigApply
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int loadConfigs() {
        int i3 = 3;
        try {
            this.f365351e.b();
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_config_Apply", th5);
        }
        if (g() == IConfigApply.LoadConfigMode.FROM_SERVICE) {
            int i16 = this.f365351e.f365345b;
            if (i16 != 1200) {
                if (i16 == 1000) {
                    i3 = 1;
                }
                if (Logger.verbos) {
                    Logger.f365497g.v("RMonitor_config_Apply", "load config result: " + i3 + ", status: " + this.f365351e.f365345b);
                }
                return i3;
            }
        }
        i3 = 2;
        if (Logger.verbos) {
        }
        return i3;
    }

    @Override // com.tencent.bugly.common.reporter.upload.BaseUpload
    public void request() {
        loadConfigs();
    }
}
