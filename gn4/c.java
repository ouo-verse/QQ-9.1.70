package gn4;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.timi.game.utils.l;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {
    public static URLDrawable a(String str, float f16, float f17) {
        return b(str, null, f16, f17);
    }

    public static URLDrawable b(String str, Drawable drawable, float f16, float f17) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (drawable == null) {
            drawable = new a();
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = ViewUtils.dpToPx(f16);
        obtain.mRequestHeight = ViewUtils.dpToPx(f17);
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        try {
            return ((ei4.a) mm4.b.b(ei4.a.class)).m(str, obtain);
        } catch (Exception unused) {
            l.e("URLDrawableUtil", "URLDrawableUtil Loading fail" + str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a extends Drawable {
        a() {
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i3) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
        }
    }
}
