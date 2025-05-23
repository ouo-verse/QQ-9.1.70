package com.tencent.libra.extension.gif;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    static final List<String> f118748a = Arrays.asList("raw", "drawable", "mipmap");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i3, Drawable drawable) {
        if (drawable instanceof GifDrawable) {
            ((GifDrawable) drawable).setLoopCount(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(@NonNull Resources resources, @DrawableRes @RawRes int i3) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i3, typedValue, true);
        int i16 = typedValue.density;
        if (i16 == 0) {
            i16 = 160;
        } else if (i16 == 65535) {
            i16 = 0;
        }
        int i17 = resources.getDisplayMetrics().densityDpi;
        if (i16 > 0 && i17 > 0) {
            return i17 / i16;
        }
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a c(ImageView imageView, AttributeSet attributeSet, int i3, int i16) {
        if (attributeSet != null && !imageView.isInEditMode()) {
            a aVar = new a(imageView, attributeSet, i3, i16);
            int i17 = aVar.f118752b;
            if (i17 >= 0) {
                a(i17, imageView.getDrawable());
                a(i17, imageView.getBackground());
            }
            return aVar;
        }
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(ImageView imageView, Uri uri) {
        if (uri != null) {
            try {
                imageView.setImageDrawable(new GifDrawable(imageView.getContext().getContentResolver(), uri));
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(ImageView imageView, boolean z16, int i3) {
        Resources resources = imageView.getResources();
        if (resources != null) {
            try {
                if (!f118748a.contains(resources.getResourceTypeName(i3))) {
                    return false;
                }
                GifDrawable gifDrawable = new GifDrawable(resources, i3);
                if (z16) {
                    imageView.setImageDrawable(gifDrawable);
                    return true;
                }
                imageView.setBackground(gifDrawable);
                return true;
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class a extends b {

        /* renamed from: c, reason: collision with root package name */
        final int f118749c;

        /* renamed from: d, reason: collision with root package name */
        final int f118750d;

        a(ImageView imageView, AttributeSet attributeSet, int i3, int i16) {
            super(imageView, attributeSet, i3, i16);
            this.f118749c = a(imageView, attributeSet, true);
            this.f118750d = a(imageView, attributeSet, false);
        }

        private static int a(ImageView imageView, AttributeSet attributeSet, boolean z16) {
            String str;
            if (z16) {
                str = "src";
            } else {
                str = "background";
            }
            int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", str, 0);
            if (attributeResourceValue > 0) {
                if (e.f118748a.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) && !e.e(imageView, z16, attributeResourceValue)) {
                    return attributeResourceValue;
                }
            }
            return 0;
        }

        a() {
            this.f118749c = 0;
            this.f118750d = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        boolean f118751a;

        /* renamed from: b, reason: collision with root package name */
        final int f118752b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(View view, AttributeSet attributeSet, int i3, int i16) {
            TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, l.f118783y, i3, i16);
            this.f118751a = obtainStyledAttributes.getBoolean(l.f118784z, false);
            this.f118752b = obtainStyledAttributes.getInt(l.A, -1);
            obtainStyledAttributes.recycle();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
            this.f118751a = false;
            this.f118752b = -1;
        }
    }
}
