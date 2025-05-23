package com.tencent.state.utils;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u001e\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J$\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u001a\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/utils/BackgroundUtils;", "", "()V", "TAG", "", "getDefaultGradient", "", "setBackgroundGradientColor", "", "backgroundView", "Landroid/view/View;", "gradientArr", "setBkgImage", "url", "forceNoResample", "", "updateTopBarBkg", "topBar", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class BackgroundUtils {
    public static final BackgroundUtils INSTANCE = new BackgroundUtils();
    private static final String TAG = "BackgroundUtils";

    BackgroundUtils() {
    }

    public final List<String> getDefaultGradient() {
        ArrayList arrayListOf;
        ArrayList arrayListOf2;
        ArrayList arrayListOf3;
        ArrayList arrayListOf4;
        ArrayList arrayListOf5;
        int i3 = Calendar.getInstance().get(11);
        if (6 <= i3 && 11 >= i3) {
            arrayListOf5 = CollectionsKt__CollectionsKt.arrayListOf("F5C9B6", "F9E5D1");
            return arrayListOf5;
        }
        if (12 <= i3 && 17 >= i3) {
            arrayListOf4 = CollectionsKt__CollectionsKt.arrayListOf("9EE5F3", "E5F2E5");
            return arrayListOf4;
        }
        if (18 <= i3 && 21 >= i3) {
            arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf("A2CBF3", "D6F0F8");
            return arrayListOf3;
        }
        if (22 <= i3 && 5 >= i3) {
            arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf("B0BBF8", "D8E3FA");
            return arrayListOf2;
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("91BBF2", "A0CAF2", "E5FAF9", "F5FAF9");
        return arrayListOf;
    }

    public final void setBackgroundGradientColor(View backgroundView, List<String> gradientArr) {
        int collectionSizeOrDefault;
        int[] intArray;
        String replaceFirst$default;
        Intrinsics.checkNotNullParameter(gradientArr, "gradientArr");
        if (gradientArr.isEmpty()) {
            return;
        }
        try {
            List<String> list = gradientArr;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default((String) it.next(), "", "#", false, 4, (Object) null);
                arrayList.add(Integer.valueOf(Color.parseColor(replaceFirst$default)));
            }
            if (backgroundView != null) {
                GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TL_BR;
                intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
                backgroundView.setBackground(new GradientDrawable(orientation, intArray));
            }
        } catch (Exception e16) {
            SquareBaseKt.getSquareLog().e(TAG, "setBackgroundGradientColor set background color failed with:", e16);
        }
    }

    public final void setBkgImage(View backgroundView, final String url, boolean forceNoResample) {
        if (url != null) {
            if (!RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, url, false, 2, null)) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "setBkgImage " + url + " is null", null, 4, null);
                return;
            }
            URLDrawable.URLDrawableOptions urlDrawableOptions$default = SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null);
            if (forceNoResample) {
                urlDrawableOptions$default.mRequestWidth = -1;
                urlDrawableOptions$default.mRequestHeight = -1;
            }
            if (!(backgroundView instanceof ImageView)) {
                backgroundView = null;
            }
            final WeakReference weakReference = new WeakReference((ImageView) backgroundView);
            URLDrawable drawable = URLDrawable.getDrawable(url, urlDrawableOptions$default);
            drawable.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.state.utils.BackgroundUtils$setBkgImage$$inlined$apply$lambda$1
                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadFialed(URLDrawable p06, Throwable p16) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "BackgroundUtils", "onLoadFailed " + url, null, 4, null);
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadSuccessed(URLDrawable drawable2) {
                    ImageView imageView = (ImageView) weakReference.get();
                    if (imageView != null) {
                        imageView.setImageDrawable(drawable2);
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadCanceled(URLDrawable p06) {
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadProgressed(URLDrawable p06, int p16) {
                }
            });
            drawable.startDownload();
            ImageView imageView = (ImageView) weakReference.get();
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
        }
    }

    public final void updateTopBarBkg(final View topBar, final String url) {
        if (url == null || topBar == null || !RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, url, false, 2, null)) {
            return;
        }
        final WeakReference weakReference = new WeakReference(topBar);
        URLDrawable drawable = URLDrawable.getDrawable(url, SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null));
        drawable.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.state.utils.BackgroundUtils$updateTopBarBkg$$inlined$let$lambda$1
            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(URLDrawable p06, Throwable p16) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "BackgroundUtils", "onLoadFailed " + url, null, 4, null);
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(URLDrawable drawable2) {
                View view = (View) weakReference.get();
                if (view != null) {
                    view.setBackground(drawable2);
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(URLDrawable p06) {
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(URLDrawable p06, int p16) {
            }
        });
        drawable.startDownload();
        topBar.setBackground(drawable);
    }

    public static /* synthetic */ void setBkgImage$default(BackgroundUtils backgroundUtils, View view, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        backgroundUtils.setBkgImage(view, str, z16);
    }
}
