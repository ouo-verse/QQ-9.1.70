package ce0;

import android.content.res.ColorStateList;
import android.text.TextUtils;
import com.tencent.theme.SkinData;
import com.tencent.theme.SkinnableColorStateList;
import java.util.Arrays;
import td0.g;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final ae0.a f30732a;

    /* renamed from: b, reason: collision with root package name */
    private final g f30733b = (g) ud0.c.a(g.class);

    public a(ae0.a aVar) {
        this.f30732a = aVar;
    }

    private String a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return "";
        }
        try {
            return "{defaultColor:" + Integer.toHexString(colorStateList.getDefaultColor()) + "}";
        } catch (Exception e16) {
            ud0.d.b("QUIProfileSkin_ColorStateListTint", ud0.d.f438811e, "getColorDescription error:", e16);
            return "null";
        }
    }

    private void c(String str, String str2) {
        if (str != null && str.startsWith("qui_") && !TextUtils.isEmpty(str2)) {
            ud0.d.b("QUIProfileSkin_ColorStateListTint", ud0.d.f438811e, "[" + str + "], " + str2);
        }
    }

    public String b(SkinnableColorStateList skinnableColorStateList) {
        String str;
        SkinData skinData = skinnableColorStateList.skinData;
        if (skinData != null && (str = skinData.mFileName) != null) {
            return str;
        }
        return null;
    }

    public ColorStateList d(ColorStateList colorStateList) {
        int[] iArr;
        ColorStateList colorStateList2;
        g gVar;
        if (this.f30732a == null) {
            return colorStateList;
        }
        if (!(colorStateList instanceof SkinnableColorStateList)) {
            return colorStateList;
        }
        String b16 = b((SkinnableColorStateList) colorStateList);
        if (TextUtils.isEmpty(b16)) {
            return colorStateList;
        }
        try {
            int[][] stateSpecs = ((SkinnableColorStateList) colorStateList).getStateSpecs();
            if (stateSpecs != null && stateSpecs.length != 0) {
                int[] color = this.f30732a.getColor(b16);
                if (color != null && color.length != 0) {
                    if (color.length < stateSpecs.length) {
                        iArr = new int[stateSpecs.length];
                        System.arraycopy(color, 0, iArr, 0, color.length);
                        Arrays.fill(iArr, color.length, stateSpecs.length, color[0]);
                    } else {
                        if (color.length > stateSpecs.length) {
                            iArr = new int[stateSpecs.length];
                            System.arraycopy(color, 0, iArr, 0, stateSpecs.length);
                        }
                        colorStateList2 = new ColorStateList(stateSpecs, color);
                        gVar = this.f30733b;
                        if (gVar != null && gVar.b(b16)) {
                            ud0.d.g("QUIProfileSkin_ColorStateListTint", ud0.d.f438811e, "[ColorTint] token=" + b16 + ", srcColor=" + a(colorStateList) + ", tintColor= " + a(colorStateList2));
                        }
                        return colorStateList2;
                    }
                    color = iArr;
                    colorStateList2 = new ColorStateList(stateSpecs, color);
                    gVar = this.f30733b;
                    if (gVar != null) {
                        ud0.d.g("QUIProfileSkin_ColorStateListTint", ud0.d.f438811e, "[ColorTint] token=" + b16 + ", srcColor=" + a(colorStateList) + ", tintColor= " + a(colorStateList2));
                    }
                    return colorStateList2;
                }
                if (ud0.d.i() && b16 != null && b16.startsWith("qui_")) {
                    ud0.d.k("QUIProfileSkin_ColorStateListTint", ud0.d.f438811e, "[" + b16 + "], tintColors is null");
                }
                return colorStateList;
            }
            c(b16, "states is empty");
            return colorStateList;
        } catch (Exception e16) {
            ud0.d.b("QUIProfileSkin_ColorStateListTint", ud0.d.f438811e, "tint exception " + b16, e16);
            return colorStateList;
        }
    }
}
