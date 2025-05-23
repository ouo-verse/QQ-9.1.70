package b1;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class a {
    @NonNull
    public static AttributeSet a(@NonNull Context context, @XmlRes int i3, @NonNull CharSequence charSequence) {
        int next;
        try {
            XmlResourceParser xml = context.getResources().getXml(i3);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                if (TextUtils.equals(xml.getName(), charSequence)) {
                    return Xml.asAttributeSet(xml);
                }
                throw new XmlPullParserException("Must have a <" + ((Object) charSequence) + "> start tag");
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException e16) {
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i3));
            notFoundException.initCause(e16);
            throw notFoundException;
        }
    }

    @TargetApi(21)
    public static void b(@Nullable RippleDrawable rippleDrawable, int i3) {
        rippleDrawable.setRadius(i3);
    }

    @Nullable
    public static PorterDuffColorFilter c(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
        }
        return null;
    }
}
