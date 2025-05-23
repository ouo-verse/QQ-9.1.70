package com.tencent.luggage.wxa.il;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends Resources {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f130646a;

    public a(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f130646a = resources;
    }

    public final int a(int i3) {
        return super.getDimensionPixelOffset(i3);
    }

    public final int b(int i3) {
        return super.getDimensionPixelSize(i3);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i3) {
        return this.f130646a.getAnimation(i3);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i3) {
        return this.f130646a.getBoolean(i3);
    }

    @Override // android.content.res.Resources
    public int getColor(int i3, Resources.Theme theme) {
        return this.f130646a.getColor(i3, theme);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i3, Resources.Theme theme) {
        return this.f130646a.getColorStateList(i3, theme);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.f130646a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i3) {
        return this.f130646a.getDimension(i3);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i3) {
        return this.f130646a.getDimensionPixelOffset(i3);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i3) {
        return this.f130646a.getDimensionPixelSize(i3);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.f130646a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i3) {
        return this.f130646a.getDrawable(i3);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i3, int i16) {
        return this.f130646a.getDrawableForDensity(i3, i16);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i3, int i16, int i17) {
        return this.f130646a.getFraction(i3, i16, i17);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.f130646a.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i3) {
        return this.f130646a.getIntArray(i3);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i3) {
        return this.f130646a.getInteger(i3);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i3) {
        return this.f130646a.getLayout(i3);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i3) {
        return this.f130646a.getMovie(i3);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i3, int i16, Object... objArr) {
        return this.f130646a.getQuantityString(i3, i16, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i3, int i16) {
        return this.f130646a.getQuantityText(i3, i16);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i3) {
        return this.f130646a.getResourceEntryName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i3) {
        return this.f130646a.getResourceName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i3) {
        return this.f130646a.getResourcePackageName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i3) {
        return this.f130646a.getResourceTypeName(i3);
    }

    @Override // android.content.res.Resources
    public String getString(int i3) {
        return this.f130646a.getString(i3);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i3) {
        return this.f130646a.getStringArray(i3);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i3) {
        return this.f130646a.getText(i3);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i3) {
        return this.f130646a.getTextArray(i3);
    }

    @Override // android.content.res.Resources
    public void getValue(int i3, TypedValue typedValue, boolean z16) {
        this.f130646a.getValue(i3, typedValue, z16);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i3, int i16, TypedValue typedValue, boolean z16) {
        this.f130646a.getValueForDensity(i3, i16, typedValue, z16);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i3) {
        return this.f130646a.getXml(i3);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f130646a.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i3) {
        return this.f130646a.obtainTypedArray(i3);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i3) {
        return this.f130646a.openRawResource(i3);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i3) {
        return this.f130646a.openRawResourceFd(i3);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        this.f130646a.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        this.f130646a.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f130646a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i3) {
        return this.f130646a.getColor(i3);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i3) {
        return this.f130646a.getColorStateList(i3);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i3, Resources.Theme theme) {
        return this.f130646a.getDrawable(i3, theme);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i3, int i16, Resources.Theme theme) {
        return this.f130646a.getDrawableForDensity(i3, i16, theme);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i3, int i16) {
        return this.f130646a.getQuantityString(i3, i16);
    }

    @Override // android.content.res.Resources
    public String getString(int i3, Object... objArr) {
        return this.f130646a.getString(i3, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i3, CharSequence charSequence) {
        return this.f130646a.getText(i3, charSequence);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z16) {
        this.f130646a.getValue(str, typedValue, z16);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i3, TypedValue typedValue) {
        return this.f130646a.openRawResource(i3, typedValue);
    }
}
