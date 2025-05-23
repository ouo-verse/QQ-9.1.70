package androidx.core.content.res;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class GuildComplexColorCompat {
    private static final String LOG_TAG = "ComplexColorCompat";
    private int mColor;
    private final ColorStateList mColorStateList;
    private int mResId;
    private final Shader mShader;

    GuildComplexColorCompat(Shader shader, ColorStateList colorStateList, @ColorInt int i3) {
        this.mShader = shader;
        this.mColorStateList = colorStateList;
        this.mColor = i3;
    }

    @NonNull
    @SuppressLint({"RestrictedApi"})
    private static GuildComplexColorCompat createFromXml(@NonNull Resources resources, @ColorRes int i3, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
        int next;
        XmlResourceParser xml = resources.getXml(i3);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            name.hashCode();
            if (!name.equals("gradient")) {
                if (name.equals("selector")) {
                    return from(ColorStateListInflaterCompat.createFromXmlInner(resources, xml, asAttributeSet, theme), i3);
                }
                throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
            }
            return from(GradientColorInflaterCompat.createFromXmlInner(resources, xml, asAttributeSet, theme), i3);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static GuildComplexColorCompat from(@NonNull Shader shader) {
        return new GuildComplexColorCompat(shader, null, 0);
    }

    @Nullable
    public static GuildComplexColorCompat inflate(@NonNull Resources resources, @ColorRes int i3, @Nullable Resources.Theme theme) {
        try {
            return createFromXml(resources, i3, theme);
        } catch (Exception e16) {
            Log.e(LOG_TAG, "Failed to inflate ComplexColor.", e16);
            return null;
        }
    }

    @ColorInt
    public int getColor() {
        return this.mColor;
    }

    @ColorRes
    public int getColorResId() {
        return this.mResId;
    }

    @Nullable
    public Shader getShader() {
        return this.mShader;
    }

    public boolean isColorStateList() {
        if (this.mColorStateList != null) {
            return true;
        }
        return false;
    }

    public boolean isColorStateListFromResId() {
        if (this.mColorStateList != null && this.mResId != 0) {
            return true;
        }
        return false;
    }

    public boolean isGradient() {
        if (this.mShader != null) {
            return true;
        }
        return false;
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        if (this.mShader == null && (colorStateList = this.mColorStateList) != null && colorStateList.isStateful()) {
            return true;
        }
        return false;
    }

    public boolean onStateChanged(int[] iArr) {
        if (isStateful()) {
            ColorStateList colorStateList = this.mColorStateList;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.mColor) {
                this.mColor = colorForState;
                return true;
            }
        }
        return false;
    }

    public void setColor(@ColorInt int i3) {
        this.mColor = i3;
    }

    public boolean willDraw() {
        if (!isGradient() && this.mColor == 0) {
            return false;
        }
        return true;
    }

    public static GuildComplexColorCompat from(@NonNull ColorStateList colorStateList) {
        return new GuildComplexColorCompat(null, colorStateList, colorStateList.getDefaultColor());
    }

    public static GuildComplexColorCompat from(@NonNull Shader shader, @ColorRes int i3) {
        GuildComplexColorCompat guildComplexColorCompat = new GuildComplexColorCompat(shader, null, 0);
        guildComplexColorCompat.mResId = i3;
        return guildComplexColorCompat;
    }

    public static GuildComplexColorCompat from(@NonNull ColorStateList colorStateList, @ColorRes int i3) {
        GuildComplexColorCompat guildComplexColorCompat = new GuildComplexColorCompat(null, colorStateList, colorStateList.getDefaultColor());
        guildComplexColorCompat.mResId = i3;
        return guildComplexColorCompat;
    }

    public static GuildComplexColorCompat from(@ColorInt int i3) {
        return new GuildComplexColorCompat(null, null, i3);
    }
}
