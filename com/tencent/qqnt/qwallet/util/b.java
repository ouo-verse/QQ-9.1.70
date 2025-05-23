package com.tencent.qqnt.qwallet.util;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.util.UiThreadUtil;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJf\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0002J^\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rR\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/qwallet/util/b;", "", "", "tag", "", "urlStr", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "loadingDrawable", "failDrawable", "preloadPath", "Landroid/os/Bundle;", "args", "Lkotlin/Function1;", "", "", "callBack", "Lcom/tencent/image/URLDrawable;", "b", "bundle", "d", "[I", "aioTag", "c", "walletTag", "shopTag", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {

    /* renamed from: a */
    @NotNull
    public static final b f361906a = new b();

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static final int[] aioTag = {0};

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private static final int[] walletTag = {26};

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private static final int[] shopTag = {40};

    b() {
    }

    private final URLDrawable b(final int[] tag, String urlStr, Drawable defaultDrawable, Drawable loadingDrawable, Drawable failDrawable, String preloadPath, Bundle args, Function1<? super Boolean, Unit> callBack) {
        boolean z16;
        boolean z17;
        args.putIntArray("key_tagId_arr", tag);
        args.putString("key_name", urlStr);
        if (!args.containsKey("key_double_bitmap")) {
            args.putBoolean("key_double_bitmap", true);
        }
        boolean z18 = args.getBoolean(VasApngUtil.KEY_PLAY_APNG, true);
        boolean z19 = args.getBoolean("key_use_cache", true);
        int i3 = args.getInt("key_loop");
        String string = args.getString(QWalletPicHelper.KEY_EXTRA_CACHE_SUFFIX, "");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseApngImage = z18;
        boolean z26 = false;
        if (i3 <= 0 && z19) {
            z16 = true;
        } else {
            z16 = false;
        }
        obtain.mUseMemoryCache = z16;
        obtain.mMemoryCacheKeySuffix = z18 + ',' + i3 + ',' + string;
        if (loadingDrawable == null) {
            loadingDrawable = defaultDrawable;
        }
        obtain.mLoadingDrawable = loadingDrawable;
        if (failDrawable != null) {
            defaultDrawable = failDrawable;
        }
        obtain.mFailedDrawable = defaultDrawable;
        obtain.mExtraInfo = args;
        if (preloadPath.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            preloadPath = QWalletPathUtils.f361901a.f(urlStr);
        }
        URLDrawable drawable = URLDrawable.getDrawable(new URL(QWalletPicHelper.PROTOCOL_QWALLET_DOWNLOAD, preloadPath, urlStr), obtain);
        if (tag.length == 0) {
            z26 = true;
        }
        if (!z26) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.qwallet.util.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.c(tag);
                }
            });
        }
        if (callBack != null) {
            drawable.setURLDrawableListener(new a(callBack));
        }
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
        return drawable;
    }

    public static final void c(int[] tag) {
        Intrinsics.checkNotNullParameter(tag, "$tag");
        ApngImage.playByTag(tag[0]);
    }

    public static /* synthetic */ URLDrawable e(b bVar, String str, Drawable drawable, Drawable drawable2, Drawable drawable3, String str2, Bundle bundle, Function1 function1, int i3, Object obj) {
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        String str3;
        Bundle bundle2;
        Function1 function12 = null;
        if ((i3 & 2) != 0) {
            drawable4 = null;
        } else {
            drawable4 = drawable;
        }
        if ((i3 & 4) != 0) {
            drawable5 = null;
        } else {
            drawable5 = drawable2;
        }
        if ((i3 & 8) != 0) {
            drawable6 = null;
        } else {
            drawable6 = drawable3;
        }
        if ((i3 & 16) != 0) {
            str3 = "";
        } else {
            str3 = str2;
        }
        if ((i3 & 32) != 0) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundle;
        }
        if ((i3 & 64) == 0) {
            function12 = function1;
        }
        return bVar.d(str, drawable4, drawable5, drawable6, str3, bundle2, function12);
    }

    @NotNull
    public final URLDrawable d(@NotNull String urlStr, @Nullable Drawable defaultDrawable, @Nullable Drawable loadingDrawable, @Nullable Drawable failDrawable, @NotNull String preloadPath, @NotNull Bundle bundle, @Nullable Function1<? super Boolean, Unit> callBack) {
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        Intrinsics.checkNotNullParameter(preloadPath, "preloadPath");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        return b(aioTag, urlStr, defaultDrawable, loadingDrawable, failDrawable, preloadPath, bundle, callBack);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/qqnt/qwallet/util/b$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d */
        final /* synthetic */ Function1<Boolean, Unit> f361910d;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Boolean, Unit> function1) {
            this.f361910d = function1;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable drawable) {
            this.f361910d.invoke(Boolean.FALSE);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable r26) {
            this.f361910d.invoke(Boolean.FALSE);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable drawable) {
            this.f361910d.invoke(Boolean.TRUE);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
        }
    }
}
