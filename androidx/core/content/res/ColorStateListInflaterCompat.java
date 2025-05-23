package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.core.R;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class ColorStateListInflaterCompat {
    private static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal<>();

    ColorStateListInflaterCompat() {
    }

    @NonNull
    public static ColorStateList createFromXml(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
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

    @NonNull
    public static ColorStateList createFromXmlInner(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return inflate(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    @NonNull
    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> threadLocal = sTempTypedValue;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    @Nullable
    public static ColorStateList inflate(@NonNull Resources resources, @XmlRes int i3, @Nullable Resources.Theme theme) {
        try {
            return createFromXml(resources, resources.getXml(i3), theme);
        } catch (Exception e16) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e16);
            return null;
        }
    }

    private static boolean isColorInt(@NonNull Resources resources, @ColorRes int i3) {
        TypedValue typedValue = getTypedValue();
        resources.getValue(i3, typedValue, true);
        int i16 = typedValue.type;
        if (i16 >= 28 && i16 <= 31) {
            return true;
        }
        return false;
    }

    @ColorInt
    private static int modulateColorAlpha(@ColorInt int i3, @FloatRange(from = 0.0d, to = 1.0d) float f16) {
        return (i3 & 16777215) | (Math.round(Color.alpha(i3) * f16) << 24);
    }

    private static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private static ColorStateList inflate(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int color;
        int i3 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20];
        int[] iArr2 = new int[20];
        int i16 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i3 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME)) {
                TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, R.styleable.ColorStateListItem);
                int i17 = R.styleable.ColorStateListItem_android_color;
                int resourceId = obtainAttributes.getResourceId(i17, -1);
                if (resourceId != -1 && !isColorInt(resources, resourceId)) {
                    try {
                        color = createFromXml(resources, resources.getXml(resourceId), theme).getDefaultColor();
                    } catch (Exception unused) {
                        color = obtainAttributes.getColor(R.styleable.ColorStateListItem_android_color, -65281);
                    }
                } else {
                    color = obtainAttributes.getColor(i17, -65281);
                }
                int i18 = R.styleable.ColorStateListItem_android_alpha;
                float f16 = 1.0f;
                if (obtainAttributes.hasValue(i18)) {
                    f16 = obtainAttributes.getFloat(i18, 1.0f);
                } else {
                    int i19 = R.styleable.ColorStateListItem_alpha;
                    if (obtainAttributes.hasValue(i19)) {
                        f16 = obtainAttributes.getFloat(i19, 1.0f);
                    }
                }
                obtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr3 = new int[attributeCount];
                int i26 = 0;
                for (int i27 = 0; i27 < attributeCount; i27++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i27);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != com.tencent.mobileqq.R.attr.f155315a3) {
                        int i28 = i26 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i27, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr3[i26] = attributeNameResource;
                        i26 = i28;
                    }
                }
                int[] trimStateSet = StateSet.trimStateSet(iArr3, i26);
                iArr2 = GrowingArrayUtils.append(iArr2, i16, modulateColorAlpha(color, f16));
                iArr = (int[][]) GrowingArrayUtils.append(iArr, i16, trimStateSet);
                i16++;
            }
            i3 = 1;
        }
        int[] iArr4 = new int[i16];
        int[][] iArr5 = new int[i16];
        System.arraycopy(iArr2, 0, iArr4, 0, i16);
        System.arraycopy(iArr, 0, iArr5, 0, i16);
        return new ColorStateList(iArr5, iArr4);
    }
}
