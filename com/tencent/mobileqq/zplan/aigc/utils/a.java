package com.tencent.mobileqq.zplan.aigc.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/utils/a;", "", "Landroid/content/Context;", "context", "", "c", "Landroid/view/View;", "view", "", h.F, "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "e", "d", "b", "", "urlString", "", "g", WidgetCacheConstellationData.NUM, "", "a", "Landroid/widget/ImageView;", "imageView", "Landroid/graphics/Bitmap;", "f", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f330690a = new a();

    a() {
    }

    public final List<String> a(int num) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        while (linkedHashSet.size() < num) {
            linkedHashSet.add("https://downv6.qq.com/shadow_qqcamera/zshow/QQChannel_avatar_" + Random.INSTANCE.nextInt(31) + ".png");
        }
        arrayList.addAll(linkedHashSet);
        return arrayList;
    }

    public final URLDrawable.URLDrawableOptions b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        new ColorDrawable(0);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = ContextCompat.getDrawable(context, R.drawable.i7s);
        obtain.mFailedDrawable = ContextCompat.getDrawable(context, R.drawable.i7s);
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026th_placeholder)\n        }");
        return obtain;
    }

    public final int c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ImmersiveUtils.dpToPx(4.0f) + ImmersiveUtils.getStatusBarHeight(context);
    }

    public final URLDrawable.URLDrawableOptions d() {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026sparentDrawable\n        }");
        return obtain;
    }

    public final URLDrawable.URLDrawableOptions e() {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026sparentDrawable\n        }");
        return obtain;
    }

    public final Bitmap f(ImageView imageView) {
        Drawable.ConstantState constantState;
        Drawable newDrawable;
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Drawable drawable = imageView.getDrawable();
        if (drawable == null || (constantState = drawable.mutate().getConstantState()) == null || (newDrawable = constantState.newDrawable()) == null || newDrawable.getIntrinsicWidth() <= 0 || newDrawable.getIntrinsicHeight() <= 0) {
            return null;
        }
        if (newDrawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) newDrawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(newDrawable.getIntrinsicWidth(), newDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        newDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        newDrawable.draw(canvas);
        return createBitmap;
    }

    public final boolean g(String urlString) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        try {
            new URL(urlString).toURI();
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    public final void h(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getLayoutParams().width <= ViewUtils.getScreenWidth()) {
            view.getLayoutParams().width = (int) (ViewUtils.getScreenWidth() * 1.5d);
            view.getLayoutParams().height = (int) (ViewUtils.getScreenHeight() * 1.5d);
        }
    }
}
