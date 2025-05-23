package com.tencent.mobileqq.vas.avatar;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.CacheDrawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.vas.VasManager;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.ao;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.avatar.api.IVasAvatarManager;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.zplan.meme.action.MODE;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasAvatarLoader implements VasManager.CompleteListener<String> {
    private static IdleGetDynamic F = new IdleGetDynamic();
    private static final Drawable G = new ColorDrawable(16777215);
    public boolean C;
    public Drawable D = G;
    public WeakReference<VasAvatar> E;

    /* renamed from: d, reason: collision with root package name */
    public int f308766d;

    /* renamed from: e, reason: collision with root package name */
    public String f308767e;

    /* renamed from: f, reason: collision with root package name */
    public long f308768f;

    /* renamed from: h, reason: collision with root package name */
    public String f308769h;

    /* renamed from: i, reason: collision with root package name */
    public int f308770i;

    /* renamed from: m, reason: collision with root package name */
    public int f308771m;

    public VasAvatarLoader(String str, int i3, int i16, String str2, long j3) {
        this.f308767e = str;
        this.f308768f = j3;
        this.f308769h = str2;
        this.f308770i = i3;
        this.f308771m = i16;
    }

    private Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putInt("key_loop", 3);
        bundle.putBoolean("key_double_bitmap", true);
        bundle.putBoolean("key_draw_round", true);
        bundle.putBoolean("key_get_reset_loop", false);
        bundle.putBoolean("key_stop_on_first", true);
        bundle.putString("key_name", "-face-");
        return bundle;
    }

    private void e(final QQAppInterface qQAppInterface) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.o
            @Override // java.lang.Runnable
            public final void run() {
                VasAvatarLoader.this.j(qQAppInterface);
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.excute(runnable, 16, null, true);
        } else {
            runnable.run();
        }
    }

    private void g(String str, MODE mode) {
        VasAvatar vasAvatar;
        if (TextUtils.isEmpty(str)) {
            QLog.e("Q.qqhead.VasFaceManager", 1, "VasAvatar get null path");
            return;
        }
        if ((this.f308770i != -1 || !DeviceInfoUtils.isLowPerfDevice()) && (vasAvatar = this.E.get()) != null && vasAvatar.f308762f == this) {
            try {
                final URLDrawable h16 = h(str, mode);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.VasAvatarLoader.4
                    @Override // java.lang.Runnable
                    public void run() {
                        VasAvatar vasAvatar2 = VasAvatarLoader.this.E.get();
                        if (vasAvatar2 != null && vasAvatar2.f308762f == VasAvatarLoader.this) {
                            vasAvatar2.setImageDrawable(h16);
                            vasAvatar2.h();
                        }
                    }
                });
            } catch (Exception e16) {
                QLog.e("Q.qqhead.VasFaceManager", 1, "getDrawable Image err, path:" + str, e16);
            }
        }
    }

    private URLDrawable h(String str, MODE mode) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (mode == MODE.GIF) {
            obtain.mPlayGifImage = true;
            obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            if (this.E.get() != null) {
                obtain.mGifRoundCorner = r5.getMeasuredWidth();
            }
            return URLDrawable.getFileDrawable(str, obtain);
        }
        if (mode == MODE.APNG) {
            ApngOptions apngOptions = new ApngOptions();
            apngOptions.setLoadingDrawable(URLDrawableHelper.getTransparent());
            apngOptions.setUseCache(true);
            apngOptions.setExtraInfo(d());
            return ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", apngOptions, str);
        }
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        drawable.addHeader("Referer", "https://h5.cmshow.qq.com/");
        drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable i(Drawable drawable) {
        boolean z16 = false;
        while (drawable instanceof AbsAsyncDrawable) {
            drawable = ((AbsAsyncDrawable) drawable).getCurrentDrawable();
            z16 = true;
        }
        while (drawable instanceof AbsAsyncDrawable) {
            drawable = ((AbsAsyncDrawable) drawable).getCurrentDrawable();
            z16 = true;
        }
        while (drawable instanceof com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable) {
            drawable = ((com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable) drawable).o();
            z16 = true;
        }
        if (z16) {
            return i(drawable);
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(QQAppInterface qQAppInterface) {
        IWinkEditorResourceAPI iWinkEditorResourceAPI = (IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class);
        if (!iWinkEditorResourceAPI.isShowDynamicAvatar()) {
            return;
        }
        boolean z16 = false;
        String customFaceFilePath = ((IQQAvatarDataService) qQAppInterface.getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(1, this.f308767e, 0);
        File file = new File(customFaceFilePath);
        if (file.exists()) {
            z16 = iWinkEditorResourceAPI.isApngFile(file);
        }
        if (z16) {
            l(customFaceFilePath, new Object(), file.lastModified());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(final Drawable drawable) {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.VasAvatarLoader.3
            @Override // java.lang.Runnable
            public void run() {
                VasAvatar vasAvatar = VasAvatarLoader.this.E.get();
                if (vasAvatar != null && vasAvatar.f308762f == VasAvatarLoader.this) {
                    vasAvatar.setImageDrawable(drawable);
                    vasAvatar.g(VasAvatarLoader.this.f308767e, r1.f308766d);
                    VasAvatarLoader vasAvatarLoader = VasAvatarLoader.this;
                    if (!vasAvatarLoader.C) {
                        Drawable i3 = vasAvatarLoader.i(drawable);
                        if (i3 instanceof URLDrawable) {
                            URLDrawable uRLDrawable = (URLDrawable) i3;
                            Drawable currDrawable = uRLDrawable.getCurrDrawable();
                            if (currDrawable instanceof ColorDrawable) {
                                uRLDrawable.setURLDrawableListener(new a(vasAvatar));
                                return;
                            }
                            i3 = currDrawable;
                        }
                        if (i3 instanceof ApngDrawable) {
                            if (VasAvatarLoader.this.f308770i != -1) {
                                VasFaceManager.o((ApngDrawable) i3);
                            }
                            VasFaceManager.n(VasAvatarLoader.this.f308767e, (ApngDrawable) i3);
                            vasAvatar.h();
                            return;
                        }
                        if (i3 instanceof CacheDrawable) {
                            if (VasAvatarLoader.this.f308770i != -1) {
                                ((CacheDrawable) i3).restart();
                            }
                            vasAvatar.h();
                        }
                    }
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.vas.avatar.VasAvatarLoader$3$a */
            /* loaded from: classes20.dex */
            class a implements URLDrawable.URLDrawableListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ VasAvatar f308773d;

                a(VasAvatar vasAvatar) {
                    this.f308773d = vasAvatar;
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadSuccessed(URLDrawable uRLDrawable) {
                    Drawable currDrawable = uRLDrawable.getCurrDrawable();
                    if (currDrawable instanceof ApngDrawable) {
                        if (VasAvatarLoader.this.f308770i != -1) {
                            VasFaceManager.o((ApngDrawable) currDrawable);
                        }
                        VasFaceManager.n(VasAvatarLoader.this.f308767e, (ApngDrawable) currDrawable);
                        this.f308773d.h();
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadCanceled(URLDrawable uRLDrawable) {
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
                }
            }
        }, 100L);
    }

    public void f(boolean z16) {
        VasAvatar vasAvatar = this.E.get();
        if (vasAvatar != null && vasAvatar.f308762f == this) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            int specialAvatarId = ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(this.f308767e).getSpecialAvatarId();
            if (runtime instanceof QQAppInterface) {
                QQAppInterface qQAppInterface = (QQAppInterface) runtime;
                VasFaceManager vasFaceManager = ((ao) qQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308429f;
                if (this.f308766d > 0) {
                    ((IVasAvatarManager) QRoute.api(IVasAvatarManager.class)).getVasAvatarDrawable(this.f308767e, this.f308766d, h.c(this.f308769h), this.f308771m, this.f308770i, new a(), specialAvatarId);
                    return;
                }
                ExtensionInfo extensionInfo = qQAppInterface.getExtensionInfo(this.f308767e, z16);
                if (extensionInfo != null && extensionInfo.faceIdUpdateTime != 0) {
                    int i3 = extensionInfo.faceId;
                    if (i3 > 0) {
                        this.f308766d = i3;
                        ((IVasAvatarManager) QRoute.api(IVasAvatarManager.class)).getVasAvatarDrawable(this.f308767e, this.f308766d, h.c(this.f308769h), this.f308771m, this.f308770i, new b(), specialAvatarId);
                        return;
                    } else {
                        if (VasToggle.BUG_82840110.isEnable(true)) {
                            vasAvatar.g(this.f308767e, 0L);
                        }
                        e(qQAppInterface);
                        return;
                    }
                }
                vasFaceManager.p(this.f308767e, this, G);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.VasManager.CompleteListener
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void onComplete(String str, Object obj) {
        l(str, obj, this.f308768f);
    }

    public void l(String str, Object obj, long j3) {
        VasAvatar vasAvatar;
        if (obj == G) {
            f(true);
            return;
        }
        if (str == null) {
            QLog.e("Q.qqhead.VasFaceManager", 1, "VasAvatar get null path");
            return;
        }
        if ((this.f308770i != -1 || !DeviceInfoUtils.isLowPerfDevice()) && (vasAvatar = this.E.get()) != null && vasAvatar.f308762f == this) {
            try {
                if (this.f308766d == 0) {
                    this.f308766d = ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getExtensionInfo(this.f308767e, false).faceId;
                }
                URL url = new URL("vasapngdownloader", str, "-vas-face-");
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mUseApngImage = true;
                obtain.mUseMemoryCache = true;
                obtain.mMemoryCacheKeySuffix = Long.toString(j3);
                Drawable drawable = vasAvatar.f308761e;
                obtain.mFailedDrawable = drawable;
                obtain.mLoadingDrawable = drawable;
                obtain.mExtraInfo = VasFaceManager.d(this.C);
                VasFaceManager.f((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).b(url, obtain);
                m(URLDrawable.getDrawable(url, obtain));
            } catch (Exception e16) {
                QLog.e("Q.qqhead.VasFaceManager", 1, "getApngDrawable ApngImage err, path:" + str, e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(VasAvatar vasAvatar) {
        this.E = new WeakReference<>(vasAvatar);
        f(false);
    }

    public void o(VasAvatar vasAvatar, String str, MODE mode) {
        this.E = new WeakReference<>(vasAvatar);
        if (this.f308770i == -1) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.qqhead.VasFaceManager", 2, "delay getAvatar uin: " + this.f308767e);
            }
            F.g(this);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            g(str, mode);
        }
    }

    public VasAvatarLoader(String str, int i3, int i16, int i17, String str2, long j3) {
        this.f308767e = str;
        this.f308766d = i3;
        this.f308768f = j3;
        this.f308769h = str2;
        this.f308770i = i16;
        this.f308771m = i17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements IVasAvatarManager.DrawableCreateCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.vas.avatar.api.IVasAvatarManager.DrawableCreateCallback
        public void createCallback(@Nullable Drawable drawable) {
            VasAvatarLoader.this.m(drawable);
        }

        @Override // com.tencent.mobileqq.vas.avatar.api.IVasAvatarManager.DrawableCreateCallback
        public void createFail(int i3, @Nullable String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements IVasAvatarManager.DrawableCreateCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.vas.avatar.api.IVasAvatarManager.DrawableCreateCallback
        public void createCallback(@Nullable Drawable drawable) {
            VasAvatarLoader.this.m(drawable);
        }

        @Override // com.tencent.mobileqq.vas.avatar.api.IVasAvatarManager.DrawableCreateCallback
        public void createFail(int i3, @Nullable String str) {
        }
    }
}
