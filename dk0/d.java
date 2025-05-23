package dk0;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface d {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(String str, Drawable drawable, boolean z16, Bundle bundle);
    }

    void a(String str, int i3, int i16, boolean z16, com.tencent.ecommerce.richtext.ui.component.image.a aVar, boolean z17, ImageView.ScaleType scaleType);

    boolean b(TextPaint textPaint, String str, int i3);

    void c(Runnable runnable);

    CharSequence d(CharSequence charSequence, int i3, int i16);

    Bitmap e(Drawable drawable);

    DisplayMetrics f();

    void g(String str, int i3, int i16, a aVar);

    void runOnUiThread(Runnable runnable);
}
