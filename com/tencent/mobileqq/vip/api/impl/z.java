package com.tencent.mobileqq.vip.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import cooperation.qzone.zipanimate.ZipDrawableLoader;
import cooperation.qzone.zipanimate.ZipLoadedListener;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J$\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\n\u001a\u00020\u0005J\u0010\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001aR\u0011\u0010\u001c\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/z;", "", "", "zipUrl", "d", "", "e", "business", QzoneZipCacheHelper.DIR, "f", tl.h.F, "Lcooperation/qzone/zipanimate/ZipLoadedListener;", "listener", "g", "a", "Ljava/lang/String;", "getBusiness", "()Ljava/lang/String;", "b", "Lcooperation/qzone/zipanimate/ZipLoadedListener;", "mListener", "c", "mZipUrl", "mDir", "mBusiness", "Lcooperation/qzone/webviewplugin/QzoneZipCacheHelperCallBack;", "Lcooperation/qzone/webviewplugin/QzoneZipCacheHelperCallBack;", "mCallback", "fileDir", "<init>", "(Ljava/lang/String;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class z {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String business;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ZipLoadedListener mListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mZipUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mDir;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mBusiness;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QzoneZipCacheHelperCallBack mCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/z$a;", "", "", "DEFAULT_BUSINESS", "Ljava/lang/String;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vip.api.impl.z$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/vip/api/impl/z$b", "Lcooperation/qzone/webviewplugin/QzoneZipCacheHelperCallBack;", "", "result", "", "onResult", "", "path", "url", "onResultOfNativeRequest", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements QzoneZipCacheHelperCallBack {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) z.this);
            }
        }

        @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
        public void onResult(boolean result) {
            ZipLoadedListener zipLoadedListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, result);
            } else if (result && (zipLoadedListener = z.this.mListener) != null) {
                zipLoadedListener.onZipLoaded(true);
            }
        }

        @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
        public void onResultOfNativeRequest(boolean result, @NotNull String path, @NotNull String url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(result), path, url);
            } else {
                Intrinsics.checkNotNullParameter(path, "path");
                Intrinsics.checkNotNullParameter(url, "url");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50238);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public z(@NotNull String business) {
        Intrinsics.checkNotNullParameter(business, "business");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) business);
        } else {
            this.business = business;
            this.mCallback = new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(z this$0) {
        ZipLoadedListener zipLoadedListener;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).checkAndDownLoadFileIfNeeded(null, this$0.mZipUrl, this$0.mBusiness, this$0.mDir, -1, this$0.mCallback) && (zipLoadedListener = this$0.mListener) != null) {
            zipLoadedListener.onZipLoaded(true);
        }
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        String basePath = ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getBasePath(this.mBusiness, this.mDir);
        Intrinsics.checkNotNullExpressionValue(basePath, "api(IQzoneZipCacheHelper\u2026BasePath(mBusiness, mDir)");
        return basePath;
    }

    @NotNull
    public final String d(@NotNull String zipUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) zipUrl);
        }
        Intrinsics.checkNotNullParameter(zipUrl, "zipUrl");
        if (TextUtils.isEmpty(zipUrl)) {
            return "";
        }
        return String.valueOf(zipUrl.hashCode());
    }

    public final synchronized void e(@NotNull String zipUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) zipUrl);
        } else {
            Intrinsics.checkNotNullParameter(zipUrl, "zipUrl");
            f(zipUrl, this.business, d(zipUrl));
        }
    }

    public final synchronized void f(@Nullable String zipUrl, @Nullable String business, @Nullable String dir) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, zipUrl, business, dir);
        } else {
            if (zipUrl == null) {
                return;
            }
            this.mZipUrl = zipUrl;
            this.mDir = dir;
            this.mBusiness = business;
        }
    }

    public final void g(@Nullable ZipLoadedListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) listener);
        } else {
            this.mListener = listener;
        }
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (new File(c()).exists()) {
            ZipLoadedListener zipLoadedListener = this.mListener;
            if (zipLoadedListener != null) {
                zipLoadedListener.onZipLoaded(true);
                return;
            }
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.tencent.mobileqq.vip.api.impl.y
            @Override // java.lang.Runnable
            public final void run() {
                z.i(z.this);
            }
        });
    }

    public /* synthetic */ z(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ZipDrawableLoader.DEFAULT_BUSINESS : str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
