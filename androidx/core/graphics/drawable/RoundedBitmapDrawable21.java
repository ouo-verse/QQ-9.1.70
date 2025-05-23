package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: P */
@RequiresApi(21)
/* loaded from: classes.dex */
class RoundedBitmapDrawable21 extends RoundedBitmapDrawable {
    /* JADX INFO: Access modifiers changed from: protected */
    public RoundedBitmapDrawable21(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@NonNull Outline outline) {
        updateDstRect();
        outline.setRoundRect(this.mDstRect, getCornerRadius());
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    void gravityCompatApply(int i3, int i16, int i17, Rect rect, Rect rect2) {
        Gravity.apply(i3, i16, i17, rect, rect2, 0);
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public boolean hasMipMap() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && bitmap.hasMipMap()) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public void setMipMap(boolean z16) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.setHasMipMap(z16);
            invalidateSelf();
        }
    }
}
