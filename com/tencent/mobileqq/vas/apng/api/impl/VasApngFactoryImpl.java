package com.tencent.mobileqq.vas.apng.api.impl;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0017\u0010\f\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0082\u0004J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vas/apng/api/impl/VasApngFactoryImpl;", "Lcom/tencent/mobileqq/vas/apng/api/IVasApngFactory;", "", "filePath", "urlStr", "Lcom/tencent/mobileqq/vas/apng/api/ApngOptions;", "options", "Lcom/tencent/image/URLDrawable;", "getApngDrawableFromUrl", "Lkotlin/Function0;", "", "block", "doOnMainThread", "from", "Lcom/tencent/mobileqq/vas/ui/APNGDrawable;", "getApngDrawable", "Landroid/graphics/drawable/Drawable;", "getDynamicDrawable", "getApngURLDrawable", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasApngFactoryImpl implements IVasApngFactory {

    @NotNull
    public static final String TAG = "VasApngFactory";
    private static final boolean enableNewDynamicDrawable = ar.INSTANCE.b("anzaihuang", "2024-04-15", "vas_new_dynamic_drawable_switch").isEnable(true);

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnMainThread(final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            block.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.apng.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    VasApngFactoryImpl.doOnMainThread$lambda$6(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doOnMainThread$lambda$6(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final URLDrawable getApngDrawableFromUrl(String filePath, String urlStr, ApngOptions options) {
        boolean z16;
        if (filePath.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        String name = new File(urlStr).getName();
        try {
            Bundle extraInfo = options.getExtraInfo();
            extraInfo.putInt("key_loop", options.getLoop());
            extraInfo.putIntArray("key_tagId_arr", options.getTagId());
            extraInfo.putBoolean("key_double_bitmap", true);
            extraInfo.putString("key_name", name);
            URL url = new URL("vasapngdownloader", filePath, urlStr);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mExtraInfo = options.getExtraInfo();
            obtain.mUseApngImage = true;
            obtain.mPlayGifImage = true;
            obtain.mUseMemoryCache = options.getUseCache();
            obtain.mMemoryCacheKeySuffix = String.valueOf(options.getLoop());
            obtain.mUseUnFinishCache = options.getUseUnFinishedCache();
            obtain.mRequestWidth = options.getRequestWidth();
            obtain.mRequestHeight = options.getRequestHeight();
            obtain.mLoadingDrawable = options.getLoadingDrawable();
            obtain.mFailedDrawable = options.getLoadingDrawable();
            obtain.mUseAutoScaleParams = options.getAutoScale();
            return URLDrawable.getDrawable(url, obtain);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getApngDrawable ApngImage err:" + th5 + ", path:" + filePath + ", name=" + name);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDynamicDrawable$lambda$1$lambda$0(ApngOptions options, k it) {
        int loop;
        Intrinsics.checkNotNullParameter(options, "$options");
        Intrinsics.checkNotNullParameter(it, "it");
        if (options.getLoop() <= 0) {
            loop = -1;
        } else {
            loop = options.getLoop();
        }
        it.y(loop);
        it.C(options.getRequestWidth());
        it.B(options.getRequestHeight());
        it.I(options.getUseCache());
    }

    @Override // com.tencent.mobileqq.vas.apng.api.IVasApngFactory
    @NotNull
    public APNGDrawable getApngDrawable(@NotNull String from, @NotNull String urlStr) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        return new APNGDrawable(from, urlStr);
    }

    @Override // com.tencent.mobileqq.vas.apng.api.IVasApngFactory
    @Nullable
    public URLDrawable getApngURLDrawable(@NotNull String from, @NotNull String urlStr) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        return getApngURLDrawable(from, urlStr, new ApngOptions());
    }

    @Override // com.tencent.mobileqq.vas.apng.api.IVasApngFactory
    @NotNull
    public Drawable getDynamicDrawable(@NotNull String urlStr, @NotNull ApngOptions options) {
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        Intrinsics.checkNotNullParameter(options, "options");
        return getDynamicDrawable(urlStr, options, "");
    }

    @Override // com.tencent.mobileqq.vas.apng.api.IVasApngFactory
    @NotNull
    public APNGDrawable getApngDrawable(@NotNull String from, @NotNull String urlStr, @NotNull ApngOptions options) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        Intrinsics.checkNotNullParameter(options, "options");
        return new APNGDrawable(from, urlStr, options);
    }

    @Override // com.tencent.mobileqq.vas.apng.api.IVasApngFactory
    @Nullable
    public URLDrawable getApngURLDrawable(@NotNull String from, @NotNull String urlStr, @NotNull ApngOptions options) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        Intrinsics.checkNotNullParameter(options, "options");
        String newCacheFilePath = VasApngUtil.getNewCacheFilePath(urlStr, from);
        Intrinsics.checkNotNullExpressionValue(newCacheFilePath, "getNewCacheFilePath(urlStr, from)");
        return getApngURLDrawable(urlStr, options, newCacheFilePath);
    }

    @Override // com.tencent.mobileqq.vas.apng.api.IVasApngFactory
    @NotNull
    public Drawable getDynamicDrawable(@NotNull String urlStr) {
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        return getDynamicDrawable(urlStr, new ApngOptions(), "");
    }

    @Override // com.tencent.mobileqq.vas.apng.api.IVasApngFactory
    @NotNull
    public APNGDrawable getApngDrawable(@NotNull String from, @NotNull String urlStr, @NotNull ApngOptions options, @NotNull String filePath) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return new APNGDrawable(from, urlStr, options, filePath);
    }

    @Override // com.tencent.mobileqq.vas.apng.api.IVasApngFactory
    @Nullable
    public URLDrawable getApngURLDrawable(@NotNull final String urlStr, @NotNull final ApngOptions options, @NotNull String filePath) {
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        URLDrawable.URLDrawableListener uRLDrawableListener = new URLDrawable.URLDrawableListener() { // from class: com.tencent.mobileqq.vas.apng.api.impl.VasApngFactoryImpl$getApngURLDrawable$listenerProxy$1
            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(@NotNull final URLDrawable d16) {
                Intrinsics.checkNotNullParameter(d16, "d");
                VasApngFactoryImpl vasApngFactoryImpl = VasApngFactoryImpl.this;
                final ApngOptions apngOptions = options;
                final String str = urlStr;
                vasApngFactoryImpl.doOnMainThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.apng.api.impl.VasApngFactoryImpl$getApngURLDrawable$listenerProxy$1$onLoadCanceled$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ApngOptions.this.getLoadListener().onLoadCanceled(d16);
                        if (QLog.isColorLevel()) {
                            QLog.d(VasApngFactoryImpl.TAG, 2, "onLoadCanceled: " + str);
                        }
                    }
                });
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(@NotNull final URLDrawable d16, @Nullable final Throwable t16) {
                Intrinsics.checkNotNullParameter(d16, "d");
                VasApngFactoryImpl vasApngFactoryImpl = VasApngFactoryImpl.this;
                final ApngOptions apngOptions = options;
                final String str = urlStr;
                vasApngFactoryImpl.doOnMainThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.apng.api.impl.VasApngFactoryImpl$getApngURLDrawable$listenerProxy$1$onLoadFialed$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ApngOptions.this.getLoadListener().onLoadFialed(d16, t16);
                        if (QLog.isColorLevel()) {
                            QLog.d(VasApngFactoryImpl.TAG, 2, "onLoadFialed: " + str);
                        }
                    }
                });
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(@NotNull final URLDrawable d16, final int progress) {
                Intrinsics.checkNotNullParameter(d16, "d");
                VasApngFactoryImpl vasApngFactoryImpl = VasApngFactoryImpl.this;
                final ApngOptions apngOptions = options;
                final String str = urlStr;
                vasApngFactoryImpl.doOnMainThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.apng.api.impl.VasApngFactoryImpl$getApngURLDrawable$listenerProxy$1$onLoadProgressed$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ApngOptions.this.getLoadListener().onLoadProgressed(d16, progress);
                        if (QLog.isDebugVersion()) {
                            QLog.d(VasApngFactoryImpl.TAG, 4, "onLoadProgressed: " + str);
                        }
                    }
                });
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(@NotNull final URLDrawable d16) {
                Intrinsics.checkNotNullParameter(d16, "d");
                VasApngFactoryImpl vasApngFactoryImpl = VasApngFactoryImpl.this;
                final ApngOptions apngOptions = options;
                final String str = urlStr;
                vasApngFactoryImpl.doOnMainThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.apng.api.impl.VasApngFactoryImpl$getApngURLDrawable$listenerProxy$1$onLoadSuccessed$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Drawable currDrawable = URLDrawable.this.getCurrDrawable();
                        if (currDrawable != null) {
                            ApngOptions apngOptions2 = apngOptions;
                            if (currDrawable instanceof ApngDrawable) {
                                if (!(apngOptions2.getTagId().length == 0)) {
                                    ApngImage.playByTag(apngOptions2.getTagId()[0]);
                                } else {
                                    ((ApngDrawable) currDrawable).getImage().setSupportGlobalPasued(false);
                                }
                            }
                        }
                        apngOptions.getLoadListener().onLoadSuccessed(URLDrawable.this);
                        if (QLog.isDebugVersion()) {
                            QLog.d(VasApngFactoryImpl.TAG, 2, "onLoadSuccessed: " + str);
                        }
                    }
                });
            }
        };
        URLDrawable apngDrawableFromUrl = getApngDrawableFromUrl(filePath, urlStr, options);
        if (apngDrawableFromUrl == null) {
            return null;
        }
        int status = apngDrawableFromUrl.getStatus();
        if (status != 1) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "UrlDrawable is not  SUCCESSED :" + status);
            }
            apngDrawableFromUrl.setURLDrawableListener(uRLDrawableListener);
            if (status == 2) {
                apngDrawableFromUrl.restartDownload();
            } else if (status != 0) {
                apngDrawableFromUrl.startDownload();
            } else if (VasToggle.BUG_109812534.isEnable(true) && new File(filePath).exists()) {
                apngDrawableFromUrl.startDownload();
            }
        } else {
            uRLDrawableListener.onLoadSuccessed(apngDrawableFromUrl);
        }
        return apngDrawableFromUrl;
    }

    @Override // com.tencent.mobileqq.vas.apng.api.IVasApngFactory
    @NotNull
    public Drawable getDynamicDrawable(@NotNull String urlStr, @NotNull final ApngOptions options, @NotNull String filePath) {
        boolean contains$default;
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (enableNewDynamicDrawable) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) urlStr, (CharSequence) QzoneEmotionUtils.SIGN_ICON_URL_END, false, 2, (Object) null);
            if (!contains$default) {
                a.C1005a a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a();
                if ((filePath.length() > 0) && new File(filePath).exists()) {
                    a16.d(filePath);
                } else {
                    if (urlStr.length() > 0) {
                        String lowerCase = urlStr.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(lowerCase, "http", false, 2, null);
                        if (startsWith$default) {
                            a16.k(urlStr);
                            a16.l(VasDynamicDrawableCache.INSTANCE);
                        }
                    }
                    if (filePath.length() == 0) {
                        return new APNGDrawable("urlStr", urlStr, options);
                    }
                    return new APNGDrawable("error", urlStr, options, filePath);
                }
                a16.g(new a.c() { // from class: com.tencent.mobileqq.vas.apng.api.impl.b
                    @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
                    public final void a(k kVar) {
                        VasApngFactoryImpl.getDynamicDrawable$lambda$1$lambda$0(ApngOptions.this, kVar);
                    }
                });
                return a16.a();
            }
        }
        if (filePath.length() == 0) {
            return new APNGDrawable("gif", urlStr, options);
        }
        return new APNGDrawable("gif", urlStr, options, filePath);
    }
}
