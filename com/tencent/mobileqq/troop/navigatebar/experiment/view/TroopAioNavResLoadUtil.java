package com.tencent.mobileqq.troop.navigatebar.experiment.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.an;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rlottie.AXrLottieDrawable;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAioNavResLoadUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f297983a;

    /* renamed from: b, reason: collision with root package name */
    private static b f297984b;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public AXrLottieDrawable f297988a;

        /* renamed from: b, reason: collision with root package name */
        public AXrLottieDrawable f297989b;

        /* renamed from: c, reason: collision with root package name */
        public ApngDrawable f297990c;

        /* renamed from: d, reason: collision with root package name */
        public ApngDrawable f297991d;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface b {
        void a(@Nullable a aVar);
    }

    static /* bridge */ /* synthetic */ boolean c() {
        return g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(a aVar) {
        b bVar = f297984b;
        l(null);
        if (bVar != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(aVar) { // from class: com.tencent.mobileqq.troop.navigatebar.experiment.view.TroopAioNavResLoadUtil.2
                static IPatchRedirector $redirector_;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ a f297987e;

                {
                    this.f297987e = aVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) aVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        b.this.a(this.f297987e);
                    }
                }
            });
        }
    }

    private static String f(Context context, String str) {
        String str2 = context.getFilesDir() + "/guild-asset/" + str;
        if (FileUtils.fileExists(str2)) {
            return str2;
        }
        new File(str2).getParentFile().mkdirs();
        if (FileUtils.copyAssetToFile(context, str, str2)) {
            return str2;
        }
        return "";
    }

    private static boolean g() {
        return an.h().isLoaded();
    }

    private static ApngDrawable h(Context context, String str) throws IOException {
        String f16 = f(context, str);
        Bundle bundle = new Bundle();
        bundle.putInt("key_density", 160);
        bundle.putBoolean(ApngImage.KEY_USE_FILE_LOOP, false);
        bundle.putBoolean("key_stop_on_first", true);
        bundle.putBoolean("key_once_clear", true);
        bundle.putInt("key_loop", 0);
        return new ApngDrawable(new ApngImage(new File(f16), true, bundle));
    }

    private static AXrLottieDrawable i(Context context, String str, String str2) {
        return AXrLottieDrawable.T(context, str, str2).f(true).h(false).e(true).c(true).b();
    }

    public static void j() {
        long j3;
        if (f297983a) {
            return;
        }
        f297983a = true;
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.troop.navigatebar.experiment.view.TroopAioNavResLoadUtil.1
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.troop.navigatebar.experiment.view.TroopAioNavResLoadUtil$1$a */
            /* loaded from: classes19.dex */
            class a extends URLDrawableHandler.Adapter {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                @Override // com.tencent.image.URLDrawableHandler.Adapter, com.tencent.image.URLDrawableHandler
                public void onFileDownloadFailed(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                        TroopAioNavResLoadUtil.f297983a = false;
                        TroopAioNavResLoadUtil.e(new a());
                    } else {
                        iPatchRedirector.redirect((short) 3, (Object) this, i3);
                    }
                }

                @Override // com.tencent.image.URLDrawableHandler.Adapter, com.tencent.image.URLDrawableHandler
                public void onFileDownloadSucceed(long j3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        TroopAioNavResLoadUtil.f297983a = false;
                        TroopAioNavResLoadUtil.k();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, j3);
                    }
                }
            }

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (TroopAioNavResLoadUtil.c()) {
                    TroopAioNavResLoadUtil.k();
                    TroopAioNavResLoadUtil.f297983a = false;
                } else {
                    an.h().load(new a());
                }
            }
        };
        if (g()) {
            j3 = 0;
        } else {
            j3 = 200;
        }
        ThreadManagerV2.executeDelay(runnable, 64, null, true, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k() {
        a aVar = new a();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            BaseApplication context = BaseApplication.getContext();
            com.tencent.rlottie.a.d(context);
            aVar.f297988a = i(context, "images/lottie/qq_loading_white.json", "white");
            if (QLog.isColorLevel()) {
                QLog.d("TroopAioNavResLoadUtil", 2, "white lottie loading: spend time: " + (System.currentTimeMillis() - currentTimeMillis));
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            aVar.f297989b = i(context, "images/lottie/qq_loading_black.json", "blue");
            if (QLog.isColorLevel()) {
                QLog.d("TroopAioNavResLoadUtil", 2, "blue lottie loading: spend time: " + (System.currentTimeMillis() - currentTimeMillis2));
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            aVar.f297990c = h(context, "guild/guild_aio_nav_arrow_white.png");
            if (QLog.isColorLevel()) {
                QLog.d("TroopAioNavResLoadUtil", 2, "white apng loading: spend time: " + (System.currentTimeMillis() - currentTimeMillis3));
            }
            long currentTimeMillis4 = System.currentTimeMillis();
            aVar.f297991d = h(context, "guild/guild_aio_nav_arrow_blue.png");
            if (QLog.isColorLevel()) {
                QLog.d("TroopAioNavResLoadUtil", 2, "blue apng loading: spend time: " + (System.currentTimeMillis() - currentTimeMillis4));
            }
        } catch (Throwable th5) {
            QLog.w("TroopAioNavResLoadUtil", 1, "loadResSync fail : ", th5);
            aVar = null;
        }
        e(aVar);
    }

    public static void l(b bVar) {
        f297984b = bVar;
    }
}
