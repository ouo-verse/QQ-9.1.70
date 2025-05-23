package com.tencent.mobileqq.vas.apng.api.impl;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.apng.api.IVasSharpPFactory;
import com.tencent.mobileqq.vas.apng.api.SharpPOptions;
import com.tencent.mobileqq.vas.ui.SharpPDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0017\u0010\f\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0082\u0004J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/vas/apng/api/impl/VasSharpPFactoryImpl;", "Lcom/tencent/mobileqq/vas/apng/api/IVasSharpPFactory;", "", "urlStr", "Lcom/tencent/mobileqq/vas/apng/api/SharpPOptions;", "options", "filePath", "Lcom/tencent/image/URLDrawable;", "getApngDrawableFromUrl", "Lkotlin/Function0;", "", "block", "doOnMainThread", "Lcom/tencent/mobileqq/vas/ui/SharpPDrawable;", "getSharpPDrawable", "getSharpPURLDrawable", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasSharpPFactoryImpl implements IVasSharpPFactory {

    @NotNull
    public static final String TAG = "VasSharpPFactory";

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnMainThread(final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            block.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.apng.api.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    VasSharpPFactoryImpl.doOnMainThread$lambda$5(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doOnMainThread$lambda$5(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final URLDrawable getApngDrawableFromUrl(String urlStr, SharpPOptions options, String filePath) {
        URLDrawable fileDrawable;
        String name = new File(urlStr).getName();
        try {
            Bundle extraInfo = options.getExtraInfo();
            extraInfo.putInt("key_loop", options.getLoop());
            extraInfo.putIntArray("key_tagId_arr", options.getTagId());
            extraInfo.putBoolean("key_double_bitmap", true);
            extraInfo.putString("key_name", name);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mExtraInfo = options.getExtraInfo();
            obtain.mUseSharpPAnimImage = true;
            obtain.mUseMemoryCache = options.getUseCache();
            obtain.mMemoryCacheKeySuffix = options.getCacheKeySuffix();
            obtain.mUseUnFinishCache = options.getUseUnFinishedCache();
            obtain.mRequestWidth = options.getRequestWidth();
            obtain.mRequestHeight = options.getRequestHeight();
            obtain.mLoadingDrawable = options.getLoadingDrawable();
            obtain.mFailedDrawable = options.getLoadingDrawable();
            obtain.mUseAutoScaleParams = options.getAutoScale();
            if (TextUtils.isEmpty(filePath)) {
                fileDrawable = URLDrawable.getDrawable(urlStr, obtain);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getApngDrawable ApngImage ok urlStr:" + urlStr + ", name=" + name);
                }
            } else {
                fileDrawable = URLDrawable.getFileDrawable(filePath, obtain);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getApngDrawable ApngImage ok urlStr:" + urlStr + ", name=" + name);
                }
            }
            return fileDrawable;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getApngDrawable ApngImage err:" + th5 + ", urlStr:" + urlStr + ", name=" + name);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.vas.apng.api.IVasSharpPFactory
    @NotNull
    public SharpPDrawable getSharpPDrawable(@NotNull String urlStr) {
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        return new SharpPDrawable(urlStr);
    }

    @Override // com.tencent.mobileqq.vas.apng.api.IVasSharpPFactory
    @Nullable
    public URLDrawable getSharpPURLDrawable(@NotNull final String urlStr, @NotNull final SharpPOptions options, @NotNull String filePath) {
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        URLDrawable.URLDrawableListener uRLDrawableListener = new URLDrawable.URLDrawableListener() { // from class: com.tencent.mobileqq.vas.apng.api.impl.VasSharpPFactoryImpl$getSharpPURLDrawable$listenerProxy$1
            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(@NotNull final URLDrawable d16) {
                Intrinsics.checkNotNullParameter(d16, "d");
                VasSharpPFactoryImpl vasSharpPFactoryImpl = VasSharpPFactoryImpl.this;
                final SharpPOptions sharpPOptions = options;
                final String str = urlStr;
                vasSharpPFactoryImpl.doOnMainThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.apng.api.impl.VasSharpPFactoryImpl$getSharpPURLDrawable$listenerProxy$1$onLoadCanceled$1
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
                        SharpPOptions.this.getLoadListener().onLoadCanceled(d16);
                        if (QLog.isColorLevel()) {
                            QLog.d(VasSharpPFactoryImpl.TAG, 2, "onLoadCanceled: " + str);
                        }
                    }
                });
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(@NotNull final URLDrawable d16, @Nullable final Throwable t16) {
                Intrinsics.checkNotNullParameter(d16, "d");
                VasSharpPFactoryImpl vasSharpPFactoryImpl = VasSharpPFactoryImpl.this;
                final SharpPOptions sharpPOptions = options;
                final String str = urlStr;
                vasSharpPFactoryImpl.doOnMainThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.apng.api.impl.VasSharpPFactoryImpl$getSharpPURLDrawable$listenerProxy$1$onLoadFialed$1
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
                        SharpPOptions.this.getLoadListener().onLoadFialed(d16, t16);
                        if (QLog.isColorLevel()) {
                            QLog.d(VasSharpPFactoryImpl.TAG, 2, "onLoadFialed: " + str);
                        }
                    }
                });
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(@NotNull final URLDrawable d16, final int progress) {
                Intrinsics.checkNotNullParameter(d16, "d");
                VasSharpPFactoryImpl vasSharpPFactoryImpl = VasSharpPFactoryImpl.this;
                final SharpPOptions sharpPOptions = options;
                final String str = urlStr;
                vasSharpPFactoryImpl.doOnMainThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.apng.api.impl.VasSharpPFactoryImpl$getSharpPURLDrawable$listenerProxy$1$onLoadProgressed$1
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
                        SharpPOptions.this.getLoadListener().onLoadProgressed(d16, progress);
                        if (QLog.isColorLevel()) {
                            QLog.d(VasSharpPFactoryImpl.TAG, 2, "onLoadProgressed: " + str);
                        }
                    }
                });
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(@NotNull final URLDrawable d16) {
                Intrinsics.checkNotNullParameter(d16, "d");
                VasSharpPFactoryImpl vasSharpPFactoryImpl = VasSharpPFactoryImpl.this;
                final SharpPOptions sharpPOptions = options;
                final String str = urlStr;
                vasSharpPFactoryImpl.doOnMainThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.apng.api.impl.VasSharpPFactoryImpl$getSharpPURLDrawable$listenerProxy$1$onLoadSuccessed$1
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
                            SharpPOptions sharpPOptions2 = sharpPOptions;
                            if (currDrawable instanceof ApngDrawable) {
                                if (!(sharpPOptions2.getTagId().length == 0)) {
                                    ApngImage.playByTag(sharpPOptions2.getTagId()[0]);
                                } else {
                                    ((ApngDrawable) currDrawable).getImage().setSupportGlobalPasued(false);
                                }
                            }
                        }
                        sharpPOptions.getLoadListener().onLoadSuccessed(URLDrawable.this);
                        if (QLog.isColorLevel()) {
                            QLog.d(VasSharpPFactoryImpl.TAG, 2, "onLoadSuccessed: " + str);
                        }
                    }
                });
            }
        };
        URLDrawable apngDrawableFromUrl = getApngDrawableFromUrl(urlStr, options, filePath);
        if (apngDrawableFromUrl != null) {
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
                }
            } else {
                uRLDrawableListener.onLoadSuccessed(apngDrawableFromUrl);
            }
            return apngDrawableFromUrl;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.apng.api.IVasSharpPFactory
    @NotNull
    public SharpPDrawable getSharpPDrawable(@NotNull String urlStr, @NotNull SharpPOptions options) {
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        Intrinsics.checkNotNullParameter(options, "options");
        return new SharpPDrawable(urlStr, options);
    }
}
