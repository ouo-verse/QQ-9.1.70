package com.tencent.mobileqq.widget.listitem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/QUIListItemBackgroundType;", "", "Landroid/content/Context;", "context", "", "themeId", "Landroid/graphics/drawable/Drawable;", "getBackground", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "None", "NoneRound", "AllRound", "TopRound", "BottomRound", "FullWidth", "FullWidthWithTransparent", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public enum QUIListItemBackgroundType {
    None,
    NoneRound,
    AllRound,
    TopRound,
    BottomRound,
    FullWidth,
    FullWidthWithTransparent;


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/QUIListItemBackgroundType$a;", "", "Landroid/content/Context;", "context", "", "themeId", "colorResId", "", "topRadius", "bottomRadius", "Landroid/graphics/drawable/Drawable;", "a", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Drawable a(@NotNull Context context, int themeId, int colorResId, float topRadius, float bottomRadius) {
            Intrinsics.checkNotNullParameter(context, "context");
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

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f316983a;

        static {
            int[] iArr = new int[QUIListItemBackgroundType.values().length];
            try {
                iArr[QUIListItemBackgroundType.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[QUIListItemBackgroundType.NoneRound.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[QUIListItemBackgroundType.AllRound.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[QUIListItemBackgroundType.TopRound.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[QUIListItemBackgroundType.BottomRound.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[QUIListItemBackgroundType.FullWidth.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[QUIListItemBackgroundType.FullWidthWithTransparent.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f316983a = iArr;
        }
    }

    @Nullable
    public final Drawable getBackground(@NotNull Context context, int themeId) {
        Intrinsics.checkNotNullParameter(context, "context");
        float dimension = context.getResources().getDimension(R.dimen.d_y);
        switch (b.f316983a[ordinal()]) {
            case 1:
                return null;
            case 2:
                return INSTANCE.a(context, themeId, R.color.qui_common_fill_light_secondary, 0.0f, 0.0f);
            case 3:
                return INSTANCE.a(context, themeId, R.color.qui_common_fill_light_secondary, dimension, dimension);
            case 4:
                return INSTANCE.a(context, themeId, R.color.qui_common_fill_light_secondary, dimension, 0.0f);
            case 5:
                return INSTANCE.a(context, themeId, R.color.qui_common_fill_light_secondary, 0.0f, dimension);
            case 6:
                return INSTANCE.a(context, themeId, R.color.qui_common_fill_light_primary, 0.0f, 0.0f);
            case 7:
                return INSTANCE.a(context, themeId, R.color.ajr, 0.0f, 0.0f);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
