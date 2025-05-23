package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class GradientColorInflaterCompat {
    private static final int TILE_MODE_CLAMP = 0;
    private static final int TILE_MODE_MIRROR = 2;
    private static final int TILE_MODE_REPEAT = 1;

    GradientColorInflaterCompat() {
    }

    private static ColorStops checkColors(@Nullable ColorStops colorStops, @ColorInt int i3, @ColorInt int i16, boolean z16, @ColorInt int i17) {
        if (colorStops != null) {
            return colorStops;
        }
        if (z16) {
            return new ColorStops(i3, i17, i16);
        }
        return new ColorStops(i3, i16);
    }

    static Shader createFromXml(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return createFromXmlInner(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Shader createFromXmlInner(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.GradientColor);
            float namedFloat = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "startX", R.styleable.GradientColor_android_startX, 0.0f);
            float namedFloat2 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "startY", R.styleable.GradientColor_android_startY, 0.0f);
            float namedFloat3 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "endX", R.styleable.GradientColor_android_endX, 0.0f);
            float namedFloat4 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "endY", R.styleable.GradientColor_android_endY, 0.0f);
            float namedFloat5 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "centerX", R.styleable.GradientColor_android_centerX, 0.0f);
            float namedFloat6 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "centerY", R.styleable.GradientColor_android_centerY, 0.0f);
            int namedInt = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "type", R.styleable.GradientColor_android_type, 0);
            int namedColor = TypedArrayUtils.getNamedColor(obtainAttributes, xmlPullParser, "startColor", R.styleable.GradientColor_android_startColor, 0);
            boolean hasAttribute = TypedArrayUtils.hasAttribute(xmlPullParser, "centerColor");
            int namedColor2 = TypedArrayUtils.getNamedColor(obtainAttributes, xmlPullParser, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
            int namedColor3 = TypedArrayUtils.getNamedColor(obtainAttributes, xmlPullParser, "endColor", R.styleable.GradientColor_android_endColor, 0);
            int namedInt2 = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
            float namedFloat7 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, 0.0f);
            obtainAttributes.recycle();
            ColorStops checkColors = checkColors(inflateChildElements(resources, xmlPullParser, attributeSet, theme), namedColor, namedColor3, hasAttribute, namedColor2);
            if (namedInt != 1) {
                if (namedInt != 2) {
                    return new LinearGradient(namedFloat, namedFloat2, namedFloat3, namedFloat4, checkColors.mColors, checkColors.mOffsets, parseTileMode(namedInt2));
                }
                return new SweepGradient(namedFloat5, namedFloat6, checkColors.mColors, checkColors.mOffsets);
            }
            if (namedFloat7 > 0.0f) {
                return new RadialGradient(namedFloat5, namedFloat6, namedFloat7, checkColors.mColors, checkColors.mOffsets, parseTileMode(namedInt2));
            }
            throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0082, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ColorStops inflateChildElements(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME)) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.GradientColorItem);
                int i3 = R.styleable.GradientColorItem_android_color;
                boolean hasValue = obtainAttributes.hasValue(i3);
                int i16 = R.styleable.GradientColorItem_android_offset;
                boolean hasValue2 = obtainAttributes.hasValue(i16);
                if (!hasValue || !hasValue2) {
                    break;
                }
                int color = obtainAttributes.getColor(i3, 0);
                float f16 = obtainAttributes.getFloat(i16, 0.0f);
                obtainAttributes.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f16));
            }
        }
        if (arrayList2.size() > 0) {
            return new ColorStops(arrayList2, arrayList);
        }
        return null;
    }

    private static Shader.TileMode parseTileMode(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return Shader.TileMode.CLAMP;
            }
            return Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class ColorStops {
        final int[] mColors;
        final float[] mOffsets;

        ColorStops(@NonNull List<Integer> list, @NonNull List<Float> list2) {
            int size = list.size();
            this.mColors = new int[size];
            this.mOffsets = new float[size];
            for (int i3 = 0; i3 < size; i3++) {
                this.mColors[i3] = list.get(i3).intValue();
                this.mOffsets[i3] = list2.get(i3).floatValue();
            }
        }

        ColorStops(@ColorInt int i3, @ColorInt int i16) {
            this.mColors = new int[]{i3, i16};
            this.mOffsets = new float[]{0.0f, 1.0f};
        }

        ColorStops(@ColorInt int i3, @ColorInt int i16, @ColorInt int i17) {
            this.mColors = new int[]{i3, i16, i17};
            this.mOffsets = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
