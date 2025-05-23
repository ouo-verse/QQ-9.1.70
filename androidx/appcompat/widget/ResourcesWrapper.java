package androidx.appcompat.widget;

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
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes.dex */
class ResourcesWrapper extends Resources {
    private final Resources mResources;

    public ResourcesWrapper(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.mResources = resources;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i3) throws Resources.NotFoundException {
        return this.mResources.getAnimation(i3);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i3) throws Resources.NotFoundException {
        return this.mResources.getBoolean(i3);
    }

    @Override // android.content.res.Resources
    public int getColor(int i3) throws Resources.NotFoundException {
        return this.mResources.getColor(i3);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i3) throws Resources.NotFoundException {
        return this.mResources.getColorStateList(i3);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.mResources.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i3) throws Resources.NotFoundException {
        return this.mResources.getDimension(i3);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i3) throws Resources.NotFoundException {
        return this.mResources.getDimensionPixelOffset(i3);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i3) throws Resources.NotFoundException {
        return this.mResources.getDimensionPixelSize(i3);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.mResources.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i3) throws Resources.NotFoundException {
        return this.mResources.getDrawable(i3);
    }

    @Override // android.content.res.Resources
    @RequiresApi(15)
    public Drawable getDrawableForDensity(int i3, int i16) throws Resources.NotFoundException {
        return this.mResources.getDrawableForDensity(i3, i16);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i3, int i16, int i17) {
        return this.mResources.getFraction(i3, i16, i17);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.mResources.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i3) throws Resources.NotFoundException {
        return this.mResources.getIntArray(i3);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i3) throws Resources.NotFoundException {
        return this.mResources.getInteger(i3);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i3) throws Resources.NotFoundException {
        return this.mResources.getLayout(i3);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i3) throws Resources.NotFoundException {
        return this.mResources.getMovie(i3);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i3, int i16, Object... objArr) throws Resources.NotFoundException {
        return this.mResources.getQuantityString(i3, i16, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i3, int i16) throws Resources.NotFoundException {
        return this.mResources.getQuantityText(i3, i16);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i3) throws Resources.NotFoundException {
        return this.mResources.getResourceEntryName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i3) throws Resources.NotFoundException {
        return this.mResources.getResourceName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i3) throws Resources.NotFoundException {
        return this.mResources.getResourcePackageName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i3) throws Resources.NotFoundException {
        return this.mResources.getResourceTypeName(i3);
    }

    @Override // android.content.res.Resources
    public String getString(int i3) throws Resources.NotFoundException {
        return this.mResources.getString(i3);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i3) throws Resources.NotFoundException {
        return this.mResources.getStringArray(i3);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i3) throws Resources.NotFoundException {
        return this.mResources.getText(i3);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i3) throws Resources.NotFoundException {
        return this.mResources.getTextArray(i3);
    }

    @Override // android.content.res.Resources
    public void getValue(int i3, TypedValue typedValue, boolean z16) throws Resources.NotFoundException {
        this.mResources.getValue(i3, typedValue, z16);
    }

    @Override // android.content.res.Resources
    @RequiresApi(15)
    public void getValueForDensity(int i3, int i16, TypedValue typedValue, boolean z16) throws Resources.NotFoundException {
        this.mResources.getValueForDensity(i3, i16, typedValue, z16);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i3) throws Resources.NotFoundException {
        return this.mResources.getXml(i3);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.mResources.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i3) throws Resources.NotFoundException {
        return this.mResources.obtainTypedArray(i3);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i3) throws Resources.NotFoundException {
        return this.mResources.openRawResource(i3);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i3) throws Resources.NotFoundException {
        return this.mResources.openRawResourceFd(i3);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.mResources.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.mResources.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.mResources;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    @RequiresApi(21)
    public Drawable getDrawable(int i3, Resources.Theme theme) throws Resources.NotFoundException {
        return this.mResources.getDrawable(i3, theme);
    }

    @Override // android.content.res.Resources
    @RequiresApi(21)
    public Drawable getDrawableForDensity(int i3, int i16, Resources.Theme theme) {
        return this.mResources.getDrawableForDensity(i3, i16, theme);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i3, int i16) throws Resources.NotFoundException {
        return this.mResources.getQuantityString(i3, i16);
    }

    @Override // android.content.res.Resources
    public String getString(int i3, Object... objArr) throws Resources.NotFoundException {
        return this.mResources.getString(i3, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i3, CharSequence charSequence) {
        return this.mResources.getText(i3, charSequence);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z16) throws Resources.NotFoundException {
        this.mResources.getValue(str, typedValue, z16);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i3, TypedValue typedValue) throws Resources.NotFoundException {
        return this.mResources.openRawResource(i3, typedValue);
    }
}
