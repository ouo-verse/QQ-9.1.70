package com.tencent.hotpatch;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.mobileqq.msf.core.net.patch.RFixExtraConfig;
import com.tencent.mobileqq.msf.core.net.utils.MsfHandlePatchUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import com.tencent.rfix.lib.RFix;
import com.tencent.rfix.lib.RFixListener;
import com.tencent.rfix.lib.event.ConfigEvent;
import com.tencent.rfix.lib.event.DownloadEvent;
import com.tencent.rfix.lib.event.InstallEvent;
import com.tencent.rfix.lib.reporter.RFixQualitySampler;
import com.tencent.rfix.loader.entity.RFixLoadResult;
import com.tencent.rfix.loader.lite.RFixLoader;
import com.tencent.rfix.loader.log.IRFixLog;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.safemode.RFixSafeModeKeeper;
import com.tencent.rfix.loader.storage.IRFixStorage;
import com.tencent.rfix.loader.storage.IRFixStorageFactory;
import com.tencent.rfix.loader.storage.RFixStorageFactory;
import com.tencent.rfix.loader.thread.IRFixThreadPool;
import com.tencent.rfix.loader.thread.RFixThreadPool;
import java.io.File;
import mqq.app.MobileQQ;
import org.json.JSONException;

/* loaded from: classes7.dex */
public class DexPatchInstaller implements RFixListener {
    static IPatchRedirector $redirector_;

    /* loaded from: classes7.dex */
    class a implements IRFixLog {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.rfix.loader.log.IRFixLog
        public void d(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            } else {
                QLog.d(str, 1, str2);
            }
        }

        @Override // com.tencent.rfix.loader.log.IRFixLog
        public void e(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                QLog.e(str, 1, str2);
            } else {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
            }
        }

        @Override // com.tencent.rfix.loader.log.IRFixLog
        public void i(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            } else {
                QLog.i(str, 1, str2);
            }
        }

        @Override // com.tencent.rfix.loader.log.IRFixLog
        public void v(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            } else {
                Log.v(str, str2);
            }
        }

        @Override // com.tencent.rfix.loader.log.IRFixLog
        public void w(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                QLog.w(str, 1, str2);
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            }
        }

        @Override // com.tencent.rfix.loader.log.IRFixLog
        public void e(String str, String str2, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                QLog.e(str, 1, str2, th5);
            } else {
                iPatchRedirector.redirect((short) 8, this, str, str2, th5);
            }
        }

        @Override // com.tencent.rfix.loader.log.IRFixLog
        public void w(String str, String str2, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                QLog.w(str, 1, str2, th5);
            } else {
                iPatchRedirector.redirect((short) 6, this, str, str2, th5);
            }
        }
    }

    /* loaded from: classes7.dex */
    class b implements IRFixThreadPool {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.rfix.loader.thread.IRFixThreadPool
        public void execute(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ThreadManagerV2.excute(runnable, 16, null, false);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            }
        }

        @Override // com.tencent.rfix.loader.thread.IRFixThreadPool
        public void execute(Runnable runnable, IRFixThreadPool.ThreadType threadType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable, (Object) threadType);
            } else {
                int i3 = c.f114705a[threadType.ordinal()];
                ThreadManagerV2.excute(runnable, i3 != 1 ? i3 != 2 ? 16 : 128 : 64, null, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    static /* synthetic */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f114705a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66070);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[IRFixThreadPool.ThreadType.values().length];
            f114705a = iArr;
            try {
                iArr[IRFixThreadPool.ThreadType.THREAD_IO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f114705a[IRFixThreadPool.ThreadType.THREAD_NETWORK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class d implements IRFixStorage {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final String f114706a;

        /* renamed from: b, reason: collision with root package name */
        private final MMKVOptionEntity f114707b;

        public d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            } else {
                this.f114706a = str;
                this.f114707b = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            }
        }

        private String a(String str) {
            return this.f114706a + "#" + str;
        }

        @Override // com.tencent.rfix.loader.storage.IRFixStorage
        public boolean contains(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str)).booleanValue();
            }
            return this.f114707b.containsKey(a(str));
        }

        @Override // com.tencent.rfix.loader.storage.IRFixStorage
        public boolean delete(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, z16)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.rfix.loader.storage.IRFixStorage
        public boolean getBoolean(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16))).booleanValue();
            }
            return this.f114707b.decodeBool(a(str), z16);
        }

        @Override // com.tencent.rfix.loader.storage.IRFixStorage
        public int getInt(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3)).intValue();
            }
            return this.f114707b.decodeInt(a(str), i3);
        }

        @Override // com.tencent.rfix.loader.storage.IRFixStorage
        public long getLong(String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Long) iPatchRedirector.redirect((short) 7, this, str, Long.valueOf(j3))).longValue();
            }
            return this.f114707b.decodeLong(a(str), j3);
        }

        @Override // com.tencent.rfix.loader.storage.IRFixStorage
        public String getString(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            }
            return this.f114707b.decodeString(a(str), str2);
        }

        @Override // com.tencent.rfix.loader.storage.IRFixStorage
        public void load(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
        }

        @Override // com.tencent.rfix.loader.storage.IRFixStorage
        public void putBoolean(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, this, str, Boolean.valueOf(z16));
            } else {
                this.f114707b.encodeBool(a(str), z16);
            }
        }

        @Override // com.tencent.rfix.loader.storage.IRFixStorage
        public void putInt(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3);
            } else {
                this.f114707b.encodeInt(a(str), i3);
            }
        }

        @Override // com.tencent.rfix.loader.storage.IRFixStorage
        public void putLong(String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, this, str, Long.valueOf(j3));
            } else {
                this.f114707b.encodeLong(a(str), j3);
            }
        }

        @Override // com.tencent.rfix.loader.storage.IRFixStorage
        public void putString(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
            } else {
                this.f114707b.encodeString(a(str), str2);
            }
        }

        @Override // com.tencent.rfix.loader.storage.IRFixStorage
        public void remove(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            } else {
                this.f114707b.removeKey(a(str));
            }
        }

        @Override // com.tencent.rfix.loader.storage.IRFixStorage
        public void save(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            }
        }
    }

    public DexPatchInstaller() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(Context context) throws JSONException {
        if (MobileQQ.sProcessId != 1) {
            com.tencent.mobileqq.rfix.a.f281292a.g(false);
        }
        String decodeString = QMMKV.from(context, "common_mmkv_configurations").decodeString(MsfHandlePatchUtils.KEY_PATCH_CONFIG, null);
        if (!TextUtils.isEmpty(decodeString)) {
            RFixExtraConfig rFixExtraConfig = new RFixExtraConfig(decodeString);
            if (!AppSetting.l().equals(rFixExtraConfig.getCommitId())) {
                QLog.w("PatchLogTag", 1, "skip patch, commit id not match: " + AppSetting.l() + " <-> " + rFixExtraConfig.getCommitId());
                return;
            }
            if (!rFixExtraConfig.isEnable()) {
                QLog.w("PatchLogTag", 1, "patch not enabled");
                return;
            }
            String patchPath = PatchCommonUtil.getPatchPath(rFixExtraConfig.getPatchName());
            if (!new File(patchPath).exists()) {
                QLog.w("PatchLogTag", 1, "patch file not ready yet");
                return;
            }
            QLog.d("PatchLogTag", 1, "install from msf, config id: " + rFixExtraConfig.getConfigId());
            if (MobileQQ.sProcessId == 1) {
                com.tencent.mobileqq.rfix.a.f281292a.g(true);
            }
            RFix.getInstance().getConfigManager().b(new com.tencent.rfix.lib.config.c(rFixExtraConfig.getConfigId(), decodeString), patchPath);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IRFixStorage c(Context context, String str) {
        return new d(str);
    }

    public static void installDexPatch(Context context, boolean z16) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            RFixLog.setLogImpl(new a());
            RFixStorageFactory.setStorageFactoryImpl(new IRFixStorageFactory() { // from class: com.tencent.hotpatch.a
                @Override // com.tencent.rfix.loader.storage.IRFixStorageFactory
                public final IRFixStorage createRFixStorage(Context context2, String str) {
                    IRFixStorage c16;
                    c16 = DexPatchInstaller.c(context2, str);
                    return c16;
                }
            });
            RFixSafeModeKeeper.setStrategy(RFixSafeModeKeeper.Strategy.MULTI_PROCESS);
            RFixThreadPool.setThreadPoolImpl(new b());
            RFixQualitySampler.e();
            RFixLoadResult tryLoad = RFixLoader.tryLoad((Application) context.getApplicationContext());
            com.tencent.mobileqq.rfix.a.j(tryLoad, MobileQQ.processName);
            com.tencent.rfix.lib.bugly.a.c(context, tryLoad);
            b(context);
            QLog.d("PatchLogTag", 1, "DexPatchInstaller installDexPatch total cost time=" + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
        } catch (Throwable th5) {
            QLog.e("PatchLogTag", 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.rfix.lib.RFixListener
    public void onConfig(boolean z16, int i3, ConfigEvent configEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), configEvent);
            return;
        }
        QLog.d("PatchLogTag", 1, "onConfig success=" + z16 + ", resultCode=" + i3);
        if (!z16) {
            com.tencent.qqperf.crashdefend.d.e().g(1, false);
            SafeModeUtil.c();
        }
    }

    @Override // com.tencent.rfix.lib.RFixListener
    public void onDownload(boolean z16, int i3, DownloadEvent downloadEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3), downloadEvent);
            return;
        }
        QLog.d("PatchLogTag", 1, "onDownload success=" + z16 + ", resultCode=" + i3);
        if (!z16) {
            com.tencent.qqperf.crashdefend.d.e().g(1, false);
            SafeModeUtil.c();
        }
    }

    @Override // com.tencent.rfix.lib.RFixListener
    public void onInstall(boolean z16, int i3, InstallEvent installEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), installEvent);
            return;
        }
        QLog.d("PatchLogTag", 1, "onInstall success=" + z16 + ", resultCode=" + i3);
        if (z16) {
            SafeModeUtil.c();
            SafeModeUtil.f(HardCodeUtil.qqStr(R.string.f172275p01));
        }
        com.tencent.qqperf.crashdefend.d.e().g(1000, z16);
    }
}
