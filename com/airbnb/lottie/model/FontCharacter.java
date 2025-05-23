package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;
import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.List;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class FontCharacter {
    private final char character;
    private final String fontFamily;
    private final List<ShapeGroup> shapes;
    private final double size;
    private final String style;
    private final double width;

    public FontCharacter(List<ShapeGroup> list, char c16, double d16, double d17, String str, String str2) {
        this.shapes = list;
        this.character = c16;
        this.size = d16;
        this.width = d17;
        this.style = str;
        this.fontFamily = str2;
    }

    public static int hashFor(char c16, String str, String str2) {
        return ((((0 + c16) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<ShapeGroup> getShapes() {
        return this.shapes;
    }

    public double getWidth() {
        return this.width;
    }

    public int hashCode() {
        return hashFor(this.character, this.fontFamily, this.style);
    }
}
