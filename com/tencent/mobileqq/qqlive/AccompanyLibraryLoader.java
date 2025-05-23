package com.tencent.mobileqq.qqlive;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.karaoke.decodesdk.M4aDecoder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.io.File;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AccompanyLibraryLoader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f270355a;

    /* renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f270356b;

    /* renamed from: c, reason: collision with root package name */
    private static IAegisLogApi f270357c;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class AccompanyLibraryReadyEvent extends SimpleBaseEvent {
        static IPatchRedirector $redirector_;

        public AccompanyLibraryReadyEvent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20280);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f270355a = "AccompanyLibraryLoader";
        f270356b = new AtomicBoolean(false);
        f270357c = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
    }

    public static boolean b() {
        return f270356b.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(int i3, LoadExtResult loadExtResult) {
        String relatedFilesFolder = loadExtResult.getRelatedFilesFolder(SoLoadConstants.SONAME_KARAOKE_GUILD);
        String soLoadPath = loadExtResult.getSoLoadPath(SoLoadConstants.SONAME_KARAOKE_GUILD);
        String a16 = Utils.a(relatedFilesFolder);
        f270357c.i(f270355a, "onLoadResult() resCode:" + i3 + " relatedSoPath:" + a16 + " soLoadPath:" + soLoadPath);
        if (i3 == 0) {
            try {
                File file = new File(a16);
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles.length > 0) {
                        int i16 = -1;
                        for (File file2 : listFiles) {
                            i16++;
                            if (file2 != null && file2.isFile() && file2.exists()) {
                                String name = file2.getName();
                                f270357c.i(f270355a, "currentSoIndex:" + i16 + ", soFileName:" + name);
                                if ("libm4adec.so".equals(name)) {
                                    boolean e16 = e(file2);
                                    f270356b.set(true);
                                    f270357c.i(f270355a, "do load:" + name + ", soLoadResult:" + e16);
                                    SimpleEventBus.getInstance().dispatchEvent(new AccompanyLibraryReadyEvent());
                                    return;
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th5) {
                f270357c.e(f270355a, "loadASync error:" + th5);
            }
        }
    }

    public static void d() {
        String soVer = SoLoadManager.getInstance().getSoVer(SoLoadConstants.SONAME_KARAOKE_GUILD);
        boolean b16 = b();
        f270357c.i(f270355a, "soVersion:" + soVer + ", isLibraryReady:" + b16);
        if (b16) {
            return;
        }
        SoLoadManager.getInstance().load(SoLoadConstants.SONAME_KARAOKE_GUILD, new OnLoadListener() { // from class: com.tencent.mobileqq.qqlive.b
            @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
            public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                AccompanyLibraryLoader.c(i3, loadExtResult);
            }
        });
    }

    private static boolean e(File file) {
        if (file != null && file.length() > 0) {
            String name = file.getName();
            try {
                System.load(file.getAbsolutePath());
                return f(M4aDecoder.class, "IS_LOAD");
            } catch (Throwable th5) {
                f270357c.e(f270355a, "loadM4adecSo() Load so:" + name + " ,exception:" + th5);
                return false;
            }
        }
        f270357c.e(f270355a, "loadSingleSo() so not exist!");
        return false;
    }

    private static final boolean f(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(null, Boolean.TRUE);
            return true;
        } catch (Exception e16) {
            f270357c.e(f270355a, "reflectSetField() exception:" + e16);
            return false;
        }
    }
}
