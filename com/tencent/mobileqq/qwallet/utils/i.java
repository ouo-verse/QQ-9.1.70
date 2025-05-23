package com.tencent.mobileqq.qwallet.utils;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007R\"\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/utils/i;", "", "Landroid/widget/ImageView;", "imageView", "", "url", "Landroid/graphics/drawable/Drawable;", "default", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "", "b", "", "", "Ljava/util/Map;", "viewUrlCache", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class i {

    /* renamed from: a */
    @NotNull
    public static final i f279264a = new i();

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static final Map<Integer, String> viewUrlCache = new LinkedHashMap();

    i() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void a(@NotNull ImageView imageView, @Nullable String str) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        c(imageView, str, null, null, 12, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void b(@NotNull ImageView imageView, @Nullable String url, @Nullable Drawable r56, @Nullable IPicLoadStateListener listener) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_PIC_LOADER_ENABLE_CACHE, true)) {
            String str = viewUrlCache.get(Integer.valueOf(imageView.hashCode()));
            if (Intrinsics.areEqual(str, url) && imageView.getDrawable() != null && !Intrinsics.areEqual(imageView.getDrawable(), r56)) {
                QLog.i("QWalletPicLoader", 1, "ignored loadImage:" + imageView.hashCode() + ", same url: " + str);
                if (listener != null) {
                    listener.onStateChange(LoadState.STATE_SUCCESS, null);
                    return;
                }
                return;
            }
        }
        Option option = Option.obtain().setTargetView(imageView).setUrl(url).setLoadingDrawable(r56).setFailDrawable(r56).setLifecycleOwner(ViewTreeLifecycleOwner.get(imageView)).setPreferDecoder(com.tencent.qqnt.emotion.pic.libra.d.class);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, listener);
        viewUrlCache.put(Integer.valueOf(imageView.hashCode()), url);
    }

    public static /* synthetic */ void c(ImageView imageView, String str, Drawable drawable, IPicLoadStateListener iPicLoadStateListener, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            drawable = new ColorDrawable(0);
        }
        if ((i3 & 8) != 0) {
            iPicLoadStateListener = null;
        }
        b(imageView, str, drawable, iPicLoadStateListener);
    }
}
