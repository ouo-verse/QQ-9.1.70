package com.tencent.qui.quilistitem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qui/quilistitem/QUIListItemBackgroundType;", "", "(Ljava/lang/String;I)V", "createBackground", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "themeId", "", "colorResId", "topRadius", "", "bottomRadius", "getBackground", "None", "NoneRound", "AllRound", "TopRound", "BottomRound", "FullWidth", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final class QUIListItemBackgroundType {
    private static final /* synthetic */ QUIListItemBackgroundType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final QUIListItemBackgroundType AllRound;
    public static final QUIListItemBackgroundType BottomRound;
    public static final QUIListItemBackgroundType FullWidth;
    public static final QUIListItemBackgroundType None;
    public static final QUIListItemBackgroundType NoneRound;
    public static final QUIListItemBackgroundType TopRound;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14575);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        QUIListItemBackgroundType qUIListItemBackgroundType = new QUIListItemBackgroundType("None", 0);
        None = qUIListItemBackgroundType;
        QUIListItemBackgroundType qUIListItemBackgroundType2 = new QUIListItemBackgroundType("NoneRound", 1);
        NoneRound = qUIListItemBackgroundType2;
        QUIListItemBackgroundType qUIListItemBackgroundType3 = new QUIListItemBackgroundType("AllRound", 2);
        AllRound = qUIListItemBackgroundType3;
        QUIListItemBackgroundType qUIListItemBackgroundType4 = new QUIListItemBackgroundType("TopRound", 3);
        TopRound = qUIListItemBackgroundType4;
        QUIListItemBackgroundType qUIListItemBackgroundType5 = new QUIListItemBackgroundType("BottomRound", 4);
        BottomRound = qUIListItemBackgroundType5;
        QUIListItemBackgroundType qUIListItemBackgroundType6 = new QUIListItemBackgroundType("FullWidth", 5);
        FullWidth = qUIListItemBackgroundType6;
        $VALUES = new QUIListItemBackgroundType[]{qUIListItemBackgroundType, qUIListItemBackgroundType2, qUIListItemBackgroundType3, qUIListItemBackgroundType4, qUIListItemBackgroundType5, qUIListItemBackgroundType6};
    }

    QUIListItemBackgroundType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
        }
    }

    private final Drawable createBackground(Context context, int themeId, int colorResId, float topRadius, float bottomRadius) {
        float[] fArr = {topRadius, topRadius, topRadius, topRadius, bottomRadius, bottomRadius, bottomRadius, bottomRadius};
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ie0.a.f().h(context, colorResId, themeId));
        gradientDrawable.setCornerRadii(fArr);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(ie0.a.f().h(context, R.color.qui_common_overlay_standard_primary, themeId));
        gradientDrawable2.setCornerRadii(fArr);
        LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable, gradientDrawable2});
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, layerDrawable);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    public static QUIListItemBackgroundType valueOf(String str) {
        return (QUIListItemBackgroundType) Enum.valueOf(QUIListItemBackgroundType.class, str);
    }

    public static QUIListItemBackgroundType[] values() {
        return (QUIListItemBackgroundType[]) $VALUES.clone();
    }

    @Nullable
    public final Drawable getBackground(@NotNull Context context, int themeId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, themeId);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        float dimension = context.getResources().getDimension(R.dimen.d_y);
        switch (k.f363805a[ordinal()]) {
            case 1:
                return null;
            case 2:
                return createBackground(context, themeId, R.color.qui_common_fill_light_secondary, 0.0f, 0.0f);
            case 3:
                return createBackground(context, themeId, R.color.qui_common_fill_light_secondary, dimension, dimension);
            case 4:
                return createBackground(context, themeId, R.color.qui_common_fill_light_secondary, dimension, 0.0f);
            case 5:
                return createBackground(context, themeId, R.color.qui_common_fill_light_secondary, 0.0f, dimension);
            case 6:
                return createBackground(context, themeId, R.color.qui_common_fill_light_primary, 0.0f, 0.0f);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
