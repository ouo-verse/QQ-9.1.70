package com.tencent.state.data;

import android.graphics.Color;
import android.graphics.Point;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/data/Text;", "", "textSize", "", "textColor", "", "location", "Landroid/graphics/Point;", "(ILjava/lang/String;Landroid/graphics/Point;)V", "getLocation", "()Landroid/graphics/Point;", "getTextColor", "()Ljava/lang/String;", "getTextSize", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", SkinConstants.TintConstant.KEY_DEFAULT_COLOR, "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes4.dex */
public final /* data */ class Text {

    @NotNull
    private final Point location;

    @NotNull
    private final String textColor;
    private final int textSize;

    public Text(int i3, @NotNull String textColor, @NotNull Point location) {
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Intrinsics.checkNotNullParameter(location, "location");
        this.textSize = i3;
        this.textColor = textColor;
        this.location = location;
    }

    public static /* synthetic */ Text copy$default(Text text, int i3, String str, Point point, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = text.textSize;
        }
        if ((i16 & 2) != 0) {
            str = text.textColor;
        }
        if ((i16 & 4) != 0) {
            point = text.location;
        }
        return text.copy(i3, str, point);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTextSize() {
        return this.textSize;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getTextColor() {
        return this.textColor;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final Point getLocation() {
        return this.location;
    }

    @NotNull
    public final Text copy(int textSize, @NotNull String textColor, @NotNull Point location) {
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Intrinsics.checkNotNullParameter(location, "location");
        return new Text(textSize, textColor, location);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Text) {
                Text text = (Text) other;
                if (this.textSize != text.textSize || !Intrinsics.areEqual(this.textColor, text.textColor) || !Intrinsics.areEqual(this.location, text.location)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final Point getLocation() {
        return this.location;
    }

    @NotNull
    public final String getTextColor() {
        return this.textColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public int hashCode() {
        int i3;
        int i16 = this.textSize * 31;
        String str = this.textColor;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = (i16 + i3) * 31;
        Point point = this.location;
        if (point != null) {
            i17 = point.hashCode();
        }
        return i18 + i17;
    }

    public final int textColor(int defaultColor) {
        try {
            return Color.parseColor(this.textColor);
        } catch (Throwable unused) {
            return defaultColor;
        }
    }

    @NotNull
    public String toString() {
        return "Text(textSize=" + this.textSize + ", textColor=" + this.textColor + ", location=" + this.location + ")";
    }
}
