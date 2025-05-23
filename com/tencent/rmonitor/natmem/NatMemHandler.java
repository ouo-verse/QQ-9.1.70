package com.tencent.rmonitor.natmem;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.bugly.matrix.backtrace.WeChatBacktrace;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.NatMemPluginConfig;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.common.bhook.BHookManager;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.FileUtil;
import cooperation.photoplus.sticker.Sticker;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import l14.f;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class NatMemHandler extends Handler implements l14.b, l14.c, com.tencent.rmonitor.common.lifecycle.c {
    private SharedPreferences.Editor C;

    /* renamed from: d, reason: collision with root package name */
    private long f365780d;

    /* renamed from: e, reason: collision with root package name */
    private long f365781e;

    /* renamed from: f, reason: collision with root package name */
    private String f365782f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f365783h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f365784i;

    /* renamed from: m, reason: collision with root package name */
    private SharedPreferences f365785m;

    public NatMemHandler(Looper looper) {
        super(looper);
        this.f365780d = 1099511627776L;
        this.f365781e = 1073741824L;
        this.f365783h = true;
        this.C = null;
    }

    private boolean b() {
        File file = new File(this.f365782f);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.exists();
    }

    private void d(int i3) {
        float f16 = ConfigProxy.INSTANCE.getConfig().k(BuglyMonitorName.NATIVE_MEMORY_ANALYZE).eventSampleRatio;
        if ((this.f365784i && Math.random() > f16) || !PluginController.f365404b.b(BuglyMonitorName.NATIVE_MEMORY_ANALYZE) || !b()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str = this.f365782f + "usage_" + currentTimeMillis + Sticker.JSON_SUFFIX;
        String str2 = this.f365782f + "mem_history_" + currentTimeMillis + Sticker.JSON_SUFFIX;
        String str3 = this.f365782f + "smaps_" + currentTimeMillis + ".txt";
        k(str);
        e(str2);
        h(str3);
        if (1 == i3) {
            c.b(str, str2, str3, 1, null);
            d.a(str, 4);
        } else if (2 == i3) {
            c.b(str, str2, str3, 2, null);
            d.a(str, 5);
        }
        if (str != null) {
            FileUtil.i(new File(str));
        }
        if (str2 != null) {
            FileUtil.i(new File(str2));
        }
        if (str3 != null) {
            FileUtil.i(new File(str3));
        }
        this.f365784i = true;
    }

    private void e(String str) {
        BufferedOutputStream bufferedOutputStream;
        if (NatMemMonitor.f365787i) {
            JSONObject jSONObject = new JSONObject();
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    jSONObject.put("pss", f.f().d());
                    jSONObject.put("vss", f.f().e());
                    jSONObject.put("java_heap", f.f().c());
                    File file = new File(str);
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    String jSONObject2 = jSONObject.toString();
                    bufferedOutputStream.write(jSONObject2.getBytes(), 0, jSONObject2.getBytes().length);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                } catch (Throwable th6) {
                    bufferedOutputStream2 = bufferedOutputStream;
                    th = th6;
                    try {
                        Logger.f365497g.c("RMonitor_NatMem_Handler", th);
                        if (bufferedOutputStream2 != null) {
                            bufferedOutputStream2.close();
                        }
                    } catch (Throwable th7) {
                        if (bufferedOutputStream2 != null) {
                            try {
                                bufferedOutputStream2.close();
                            } catch (Throwable th8) {
                                Logger.f365497g.c("RMonitor_NatMem_Handler", th8);
                            }
                        }
                        throw th7;
                    }
                }
            } catch (Throwable th9) {
                Logger.f365497g.c("RMonitor_NatMem_Handler", th9);
            }
        }
    }

    private void f() {
        NatMemPluginConfig f16 = NatMemMonitor.getInstance().f();
        NatMemMonitor.getInstance().nativeInit();
        NatMemMonitor.getInstance().nativeInitSysHookParameter(f16.l(), f16.m(), f16.k());
        NatMemMonitor.getInstance().nativeInitAppHookParameter(f16.b());
        SharedPreferences sharedPreferences = BaseInfo.sharePreference;
        this.f365785m = sharedPreferences;
        if (sharedPreferences != null) {
            this.C = sharedPreferences.edit();
        }
        g();
        boolean nativeIs64Bit = nativeIs64Bit();
        this.f365783h = nativeIs64Bit;
        if (nativeIs64Bit) {
            this.f365780d = f16.h();
        } else {
            this.f365780d = 4294967296L;
        }
        this.f365781e = f16.f();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(ContextUtil.getGlobalContext().getExternalFilesDir("/Tencent/RMonitor").getPath());
        String str = File.separator;
        sb5.append(str);
        sb5.append("NatMem");
        sb5.append(str);
        this.f365782f = sb5.toString();
        WeChatBacktrace.initQuickBacktrace();
        this.f365784i = false;
    }

    private void g() {
        SharedPreferences sharedPreferences = this.f365785m;
        if (sharedPreferences != null && this.C != null) {
            int i3 = sharedPreferences.getInt("sig_jmp_info_key", 0);
            if (i3 != 0) {
                b.b(i3);
            }
            this.C.putInt("sig_jmp_info_key", 0).commit();
        }
    }

    private void h(String str) {
        if (NatMemMonitor.f365787i) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                FileUtil.g(new File("/proc/self/smaps"), file);
            } catch (Throwable th5) {
                Logger.f365497g.c("RMonitor_NatMem_Handler", th5);
            }
        }
    }

    private void i() {
        Iterator<String> it = NatMemMonitor.getInstance().f().i().iterator();
        while (it.hasNext()) {
            NatMemMonitor.getInstance().nativeRegisterAppLib(it.next());
        }
        if (!NatMemMonitor.getInstance().f().c()) {
            NatMemMonitor.getInstance().f().e().add(".*/libc.so$");
        }
        Iterator<String> it5 = NatMemMonitor.getInstance().f().e().iterator();
        while (it5.hasNext()) {
            NatMemMonitor.getInstance().nativeIgnoreLib(it5.next());
        }
        if (NatMemMonitor.getInstance().f().d()) {
            Iterator<String> it6 = NatMemMonitor.getInstance().f().j().iterator();
            while (it6.hasNext()) {
                NatMemMonitor.getInstance().nativeRegisterSysLib(it6.next());
            }
        }
        NatMemMonitor.getInstance().nativeStartHook(f.f().i(false));
        d.c();
        b.d();
        f.f().p(this);
        f.f().q(this);
        com.tencent.rmonitor.common.lifecycle.a.i().m(this);
        NatMemMonitor.getInstance().g(com.tencent.rmonitor.common.lifecycle.a.f());
    }

    private void j() {
        SharedPreferences.Editor editor;
        int a16 = BHookManager.a();
        if (this.f365785m != null && (editor = this.C) != null && a16 != 0) {
            editor.putInt("sig_jmp_info_key", a16).commit();
        }
    }

    private void k(String str) {
        if (NatMemMonitor.f365787i) {
            NatMemMonitor.getInstance().nativeDumpNatMemUsageInfo(str, f.f().i(false));
        }
    }

    private native boolean nativeIs64Bit();

    @Override // com.tencent.rmonitor.common.lifecycle.c
    public void a(String str) {
        NatMemMonitor.getInstance().g(com.tencent.rmonitor.common.lifecycle.a.f());
    }

    @Override // com.tencent.rmonitor.common.lifecycle.c
    public void c(String str) {
        NatMemMonitor.getInstance().g(com.tencent.rmonitor.common.lifecycle.a.f());
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 == 2) {
                i();
                return;
            }
            return;
        }
        f();
    }

    @Override // l14.b
    public void onPssUpdate(long j3) {
        j();
        if (((float) j3) > ((float) this.f365781e) * 0.85f) {
            d(2);
        }
    }

    @Override // l14.c
    public void onVssUpdate(long j3) {
        j();
        if (((float) j3) > ((float) this.f365780d) * 0.85f) {
            d(1);
        }
    }
}
