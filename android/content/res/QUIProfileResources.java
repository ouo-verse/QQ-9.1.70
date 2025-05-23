package android.content.res;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import ud0.b;
import ud0.d;

/* loaded from: classes.dex */
public class QUIProfileResources extends QUIResourcesWrapper {
    private static final String TAG = "QUIProfileSkin_Resources";
    private final be0.a mSkinManager;

    public QUIProfileResources(Resources resources, Context context, String str) {
        super(resources);
        this.mSkinManager = be0.a.b(str);
    }

    @Override // android.content.res.QUIResourcesWrapper, android.content.res.Resources
    public int getColor(int i3) throws Resources.NotFoundException {
        return getColor(i3, null);
    }

    @Override // android.content.res.QUIResourcesWrapper, android.content.res.Resources
    @NonNull
    public ColorStateList getColorStateList(int i3, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        be0.a aVar;
        ColorStateList colorStateList = super.getColorStateList(i3, theme);
        return (colorStateList == null || (aVar = this.mSkinManager) == null) ? colorStateList : aVar.d(colorStateList);
    }

    @Override // android.content.res.QUIResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int i3) throws Resources.NotFoundException {
        return getDrawable(i3, null);
    }

    @Override // android.content.res.QUIResourcesWrapper, android.content.res.Resources
    public Drawable getDrawableForDensity(int i3, int i16) throws Resources.NotFoundException {
        return getDrawableForDensity(i3, i16, null);
    }

    @Override // android.content.res.QUIResourcesWrapper, android.content.res.Resources
    public int getColor(int i3, Resources.Theme theme) throws Resources.NotFoundException {
        try {
            return getColorStateList(i3, theme).getDefaultColor();
        } catch (Exception e16) {
            d.b(TAG, d.f438811e, "getColor error:", e16);
            return super.getColor(i3, theme);
        }
    }

    @Override // android.content.res.QUIResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int i3, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        be0.a aVar;
        Drawable drawable = super.getDrawable(i3, theme);
        return (drawable == null || (aVar = this.mSkinManager) == null) ? drawable : aVar.e(b.a(), drawable);
    }

    @Override // android.content.res.QUIResourcesWrapper, android.content.res.Resources
    @Nullable
    public Drawable getDrawableForDensity(int i3, int i16, @Nullable Resources.Theme theme) {
        be0.a aVar;
        Drawable drawableForDensity = super.getDrawableForDensity(i3, i16, theme);
        return (drawableForDensity == null || (aVar = this.mSkinManager) == null) ? drawableForDensity : aVar.e(b.a(), drawableForDensity);
    }

    @Override // android.content.res.QUIResourcesWrapper, android.content.res.Resources
    public ColorStateList getColorStateList(int i3) throws Resources.NotFoundException {
        return getColorStateList(i3, null);
    }
}
