package com.tencent.shadow.core.runtime;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes25.dex */
public class MixResources extends ResourcesWrapper {
    private Resources mHostResources;

    public MixResources(Resources resources, Resources resources2) {
        super(resources2);
        this.mHostResources = resources;
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public XmlResourceParser getAnimation(int i3) throws Resources.NotFoundException {
        try {
            return super.getAnimation(i3);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getAnimation(i3);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public boolean getBoolean(int i3) throws Resources.NotFoundException {
        try {
            return super.getBoolean(i3);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getBoolean(i3);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public int getColor(int i3) throws Resources.NotFoundException {
        try {
            return super.getColor(i3);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getColor(i3);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public ColorStateList getColorStateList(int i3) throws Resources.NotFoundException {
        try {
            return super.getColorStateList(i3);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getColorStateList(i3);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public float getDimension(int i3) throws Resources.NotFoundException {
        try {
            return super.getDimension(i3);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getDimension(i3);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public int getDimensionPixelOffset(int i3) throws Resources.NotFoundException {
        try {
            return super.getDimensionPixelOffset(i3);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getDimensionPixelOffset(i3);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public int getDimensionPixelSize(int i3) throws Resources.NotFoundException {
        try {
            return super.getDimensionPixelSize(i3);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getDimensionPixelSize(i3);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int i3) throws Resources.NotFoundException {
        try {
            return super.getDrawable(i3);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getDrawable(i3);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public Drawable getDrawableForDensity(int i3, int i16) throws Resources.NotFoundException {
        try {
            return super.getDrawableForDensity(i3, i16);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getDrawableForDensity(i3, i16);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    @TargetApi(26)
    public Typeface getFont(int i3) throws Resources.NotFoundException {
        Typeface font;
        try {
            return super.getFont(i3);
        } catch (Resources.NotFoundException unused) {
            font = this.mHostResources.getFont(i3);
            return font;
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public int getInteger(int i3) throws Resources.NotFoundException {
        try {
            return super.getInteger(i3);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getInteger(i3);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public XmlResourceParser getLayout(int i3) throws Resources.NotFoundException {
        try {
            return super.getLayout(i3);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getLayout(i3);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public Movie getMovie(int i3) throws Resources.NotFoundException {
        try {
            return super.getMovie(i3);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getMovie(i3);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public String getResourceName(int i3) throws Resources.NotFoundException {
        try {
            return super.getResourceName(i3);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getResourceName(i3);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public String getString(int i3) throws Resources.NotFoundException {
        try {
            return super.getString(i3);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getString(i3);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public CharSequence getText(int i3) throws Resources.NotFoundException {
        try {
            return super.getText(i3);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getText(i3);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public XmlResourceParser getXml(int i3) throws Resources.NotFoundException {
        try {
            return super.getXml(i3);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getXml(i3);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public InputStream openRawResource(int i3) throws Resources.NotFoundException {
        try {
            return super.openRawResource(i3);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.openRawResource(i3);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i3) throws Resources.NotFoundException {
        try {
            return super.openRawResourceFd(i3);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.openRawResourceFd(i3);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    @TargetApi(23)
    public int getColor(int i3, Resources.Theme theme) throws Resources.NotFoundException {
        try {
            return super.getColor(i3, theme);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getColor(i3, theme);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    @TargetApi(23)
    public ColorStateList getColorStateList(int i3, Resources.Theme theme) throws Resources.NotFoundException {
        try {
            return super.getColorStateList(i3, theme);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getColorStateList(i3, theme);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i3, Resources.Theme theme) throws Resources.NotFoundException {
        try {
            return super.getDrawable(i3, theme);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getDrawable(i3, theme);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawableForDensity(int i3, int i16, Resources.Theme theme) {
        try {
            return super.getDrawableForDensity(i3, i16, theme);
        } catch (Exception unused) {
            return this.mHostResources.getDrawableForDensity(i3, i16, theme);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public String getString(int i3, Object... objArr) throws Resources.NotFoundException {
        try {
            return super.getString(i3, objArr);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getString(i3, objArr);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public CharSequence getText(int i3, CharSequence charSequence) {
        try {
            return super.getText(i3, charSequence);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.getText(i3, charSequence);
        }
    }

    @Override // com.tencent.shadow.core.runtime.ResourcesWrapper, android.content.res.Resources
    public InputStream openRawResource(int i3, TypedValue typedValue) throws Resources.NotFoundException {
        try {
            return super.openRawResource(i3, typedValue);
        } catch (Resources.NotFoundException unused) {
            return this.mHostResources.openRawResource(i3, typedValue);
        }
    }
}
