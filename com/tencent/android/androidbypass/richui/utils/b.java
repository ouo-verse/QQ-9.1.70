package com.tencent.android.androidbypass.richui.utils;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import com.tencent.android.androidbypass.richui.d;
import com.tencent.android.androidbypass.richui.f;
import com.tencent.android.androidbypass.richui.viewdata.e;
import com.tencent.android.androidbypass.richui.viewdata.g;
import com.tencent.android.androidbypass.richui.viewdata.h;
import com.tencent.android.androidbypass.richui.viewdata.i;
import com.tencent.android.androidbypass.richui.viewdata.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000eJ(\u0010\u0019\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016J\u0016\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0002\u00a8\u0006\""}, d2 = {"Lcom/tencent/android/androidbypass/richui/utils/b;", "", "Lorg/json/JSONObject;", "layoutData", "attrData", "", "direction", "Lcom/tencent/android/androidbypass/richui/b;", "processInterface", "Lcom/tencent/android/androidbypass/richui/viewdata/k;", "a", "(Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/Integer;Lcom/tencent/android/androidbypass/richui/b;)Lcom/tencent/android/androidbypass/richui/viewdata/k;", "Landroid/content/Context;", "context", "", "colorStr", "tokenType", "Landroid/content/res/ColorStateList;", "b", "borderColorStateList", "solidColorStateList", NodeProps.BORDER_WIDTH, "", "radius", "Landroid/graphics/drawable/GradientDrawable;", "d", "selectColor", "normalColor", "e", "colorJson", "Lcom/tencent/android/androidbypass/richui/viewdata/h;", "f", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    public static final b f72344a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18643);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f72344a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public static /* synthetic */ ColorStateList c(b bVar, Context context, String str, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "_common_";
        }
        return bVar.b(context, str, str2);
    }

    @NotNull
    public final k a(@NotNull JSONObject layoutData, @NotNull JSONObject attrData, @Nullable Integer direction, @Nullable com.tencent.android.androidbypass.richui.b processInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (k) iPatchRedirector.redirect((short) 1, this, layoutData, attrData, direction, processInterface);
        }
        Intrinsics.checkNotNullParameter(layoutData, "layoutData");
        Intrinsics.checkNotNullParameter(attrData, "attrData");
        String optString = layoutData.optString("viewType");
        f fVar = new f(layoutData, attrData, direction, false, new d(null, 0, null, null, attrData.optInt("version"), 15, null), processInterface, 8, null);
        if (optString != null) {
            switch (optString.hashCode()) {
                case -1694556692:
                    if (optString.equals("circularProgress")) {
                        return new com.tencent.android.androidbypass.richui.viewdata.d(fVar);
                    }
                    break;
                case -1405959847:
                    if (optString.equals("avatar")) {
                        return new com.tencent.android.androidbypass.richui.viewdata.a(fVar);
                    }
                    break;
                case -773983246:
                    if (optString.equals("multiAvatar")) {
                        return new g(fVar);
                    }
                    break;
                case 97884:
                    if (optString.equals("btn")) {
                        return new com.tencent.android.androidbypass.richui.viewdata.c(fVar);
                    }
                    break;
                case 3556653:
                    if (optString.equals("text")) {
                        return new i(fVar);
                    }
                    break;
                case 100313435:
                    if (optString.equals("image")) {
                        return new com.tencent.android.androidbypass.richui.viewdata.f(fVar);
                    }
                    break;
            }
        }
        com.tencent.android.androidbypass.config.a.f72049a.e("RichUIUtils", "[generateViewData]: not support, get default view");
        return new e(fVar);
    }

    @NotNull
    public final ColorStateList b(@NotNull Context context, @NotNull String colorStr, @NotNull String tokenType) {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 2, this, context, colorStr, tokenType);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colorStr, "colorStr");
        Intrinsics.checkNotNullParameter(tokenType, "tokenType");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(colorStr, "#", false, 2, null);
        if (startsWith$default) {
            ColorStateList valueOf = ColorStateList.valueOf(Color.parseColor(colorStr));
            Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(Color.parseColor(colorStr))");
            return valueOf;
        }
        ColorStateList colorStateList = context.getResources().getColorStateList(context.getResources().getIdentifier("qui" + tokenType + colorStr, "color", "com.tencent.mobileqq"));
        Intrinsics.checkNotNullExpressionValue(colorStateList, "context.resources.getCol\u2026 \"com.tencent.mobileqq\"))");
        return colorStateList;
    }

    @NotNull
    public final GradientDrawable d(@Nullable ColorStateList borderColorStateList, @NotNull ColorStateList solidColorStateList, int r75, float radius) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (GradientDrawable) iPatchRedirector.redirect((short) 3, this, borderColorStateList, solidColorStateList, Integer.valueOf(r75), Float.valueOf(radius));
        }
        Intrinsics.checkNotNullParameter(solidColorStateList, "solidColorStateList");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(radius);
        if (borderColorStateList != null) {
            gradientDrawable.setStroke(r75, borderColorStateList);
        }
        gradientDrawable.setColor(solidColorStateList);
        return gradientDrawable;
    }

    @NotNull
    public final ColorStateList e(int selectColor, int normalColor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(selectColor), Integer.valueOf(normalColor));
        }
        return new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[]{R.attr.state_enabled}}, new int[]{selectColor, normalColor});
    }

    @NotNull
    public final h f(@NotNull JSONObject colorJson) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (h) iPatchRedirector.redirect((short) 5, (Object) this, (Object) colorJson);
        }
        Intrinsics.checkNotNullParameter(colorJson, "colorJson");
        String selectColor = colorJson.optString("selectColor", "");
        String normalColor = colorJson.optString("normalColor", "");
        Intrinsics.checkNotNullExpressionValue(selectColor, "selectColor");
        Intrinsics.checkNotNullExpressionValue(normalColor, "normalColor");
        return new h(selectColor, normalColor);
    }
}
