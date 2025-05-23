package com.tencent.shadow.core.runtime;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ResourcesWrapper extends Resources {
    private Resources mBase;

    public ResourcesWrapper(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.mBase = resources;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i3) throws Resources.NotFoundException {
        return this.mBase.getAnimation(i3);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i3) throws Resources.NotFoundException {
        return this.mBase.getBoolean(i3);
    }

    @Override // android.content.res.Resources
    public int getColor(int i3) throws Resources.NotFoundException {
        return this.mBase.getColor(i3);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i3) throws Resources.NotFoundException {
        return this.mBase.getColorStateList(i3);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.mBase.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i3) throws Resources.NotFoundException {
        return this.mBase.getDimension(i3);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i3) throws Resources.NotFoundException {
        return this.mBase.getDimensionPixelOffset(i3);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i3) throws Resources.NotFoundException {
        return this.mBase.getDimensionPixelSize(i3);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.mBase.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i3) throws Resources.NotFoundException {
        return this.mBase.getDrawable(i3);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i3, int i16) throws Resources.NotFoundException {
        return this.mBase.getDrawableForDensity(i3, i16);
    }

    @Override // android.content.res.Resources
    @TargetApi(26)
    public Typeface getFont(int i3) throws Resources.NotFoundException {
        Typeface font;
        font = this.mBase.getFont(i3);
        return font;
    }

    @Override // android.content.res.Resources
    public float getFraction(int i3, int i16, int i17) {
        return this.mBase.getFraction(i3, i16, i17);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.mBase.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i3) throws Resources.NotFoundException {
        return this.mBase.getIntArray(i3);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i3) throws Resources.NotFoundException {
        return this.mBase.getInteger(i3);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i3) throws Resources.NotFoundException {
        return this.mBase.getLayout(i3);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i3) throws Resources.NotFoundException {
        return this.mBase.getMovie(i3);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i3, int i16, Object... objArr) throws Resources.NotFoundException {
        return this.mBase.getQuantityString(i3, i16, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i3, int i16) throws Resources.NotFoundException {
        return this.mBase.getQuantityText(i3, i16);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i3) throws Resources.NotFoundException {
        return this.mBase.getResourceEntryName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i3) throws Resources.NotFoundException {
        return this.mBase.getResourceName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i3) throws Resources.NotFoundException {
        return this.mBase.getResourcePackageName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i3) throws Resources.NotFoundException {
        return this.mBase.getResourceTypeName(i3);
    }

    @Override // android.content.res.Resources
    public String getString(int i3) throws Resources.NotFoundException {
        return this.mBase.getString(i3);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i3) throws Resources.NotFoundException {
        return this.mBase.getStringArray(i3);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i3) throws Resources.NotFoundException {
        return this.mBase.getText(i3);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i3) throws Resources.NotFoundException {
        return this.mBase.getTextArray(i3);
    }

    @Override // android.content.res.Resources
    public void getValue(int i3, TypedValue typedValue, boolean z16) throws Resources.NotFoundException {
        this.mBase.getValue(i3, typedValue, z16);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i3, int i16, TypedValue typedValue, boolean z16) throws Resources.NotFoundException {
        this.mBase.getValueForDensity(i3, i16, typedValue, z16);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i3) throws Resources.NotFoundException {
        return this.mBase.getXml(i3);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.mBase.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i3) throws Resources.NotFoundException {
        return this.mBase.obtainTypedArray(i3);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i3) throws Resources.NotFoundException {
        return this.mBase.openRawResource(i3);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i3) throws Resources.NotFoundException {
        return this.mBase.openRawResourceFd(i3);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.mBase.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.mBase.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    @TargetApi(23)
    public int getColor(int i3, Resources.Theme theme) throws Resources.NotFoundException {
        return this.mBase.getColor(i3, theme);
    }

    @Override // android.content.res.Resources
    @TargetApi(23)
    public ColorStateList getColorStateList(int i3, Resources.Theme theme) throws Resources.NotFoundException {
        return this.mBase.getColorStateList(i3, theme);
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i3, Resources.Theme theme) throws Resources.NotFoundException {
        return this.mBase.getDrawable(i3, theme);
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawableForDensity(int i3, int i16, Resources.Theme theme) {
        return this.mBase.getDrawableForDensity(i3, i16, theme);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i3, int i16) throws Resources.NotFoundException {
        return this.mBase.getQuantityString(i3, i16);
    }

    @Override // android.content.res.Resources
    public String getString(int i3, Object... objArr) throws Resources.NotFoundException {
        return this.mBase.getString(i3, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i3, CharSequence charSequence) {
        return this.mBase.getText(i3, charSequence);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z16) throws Resources.NotFoundException {
        this.mBase.getValue(str, typedValue, z16);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i3, TypedValue typedValue) throws Resources.NotFoundException {
        return this.mBase.openRawResource(i3, typedValue);
    }
}
