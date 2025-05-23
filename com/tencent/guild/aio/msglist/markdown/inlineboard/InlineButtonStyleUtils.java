package com.tencent.guild.aio.msglist.markdown.inlineboard;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet;
import com.tencent.guild.aio.msglist.markdown.inlineboard.InlineButtonStyleUtils;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002)*B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J0\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001a\u0010\u0018\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J;\u0010\u001e\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ \u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0007\u001a\u00020\u0006R!\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/inlineboard/InlineButtonStyleUtils;", "", "Landroid/content/Context;", "context", "", "style", "", "supportVas", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/InlineButtonStyleUtils$a;", "o", SkinConstants.TintConstant.KEY_DEFAULT_COLOR, "selectedColor", "pressedColor", "disableColor", "Landroid/content/res/ColorStateList;", "g", "styleDescription", "Landroid/graphics/drawable/Drawable;", "j", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "i", "borderColorStateList", "solidColorStateList", h.F, "drawableRes", "tintColor", "", "", "stateArray", DomainData.DOMAIN_NAME, "(Landroid/content/Context;ILandroid/content/res/ColorStateList;[[I)Landroid/graphics/drawable/Drawable;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnStyleSheet;", "k", "b", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()[[I", "mInlineBtnStateArray", "<init>", "()V", "InlineBtnStyleSheetImpl", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class InlineButtonStyleUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final InlineButtonStyleUtils f111753a = new InlineButtonStyleUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mInlineBtnStateArray;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/inlineboard/InlineButtonStyleUtils$InlineBtnStyleSheetImpl;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnStyleSheet;", "Landroid/content/res/ColorStateList;", "e", "Landroid/graphics/drawable/Drawable;", "f", "c", "b", "g", "", "d", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnStyleSheet$BtnType;", "getType", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/InlineButtonStyleUtils$a;", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/InlineButtonStyleUtils$a;", "mStyleDescription", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/graphics/drawable/Drawable;", "mIconDrawable", "l", "mBackgroundDrawable", "", "supportVas", "<init>", "(Landroid/content/Context;Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class InlineBtnStyleSheetImpl implements InlineBtnStyleSheet {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final StyleDescription mStyleDescription;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy mIconDrawable;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy mBackgroundDrawable;

        public InlineBtnStyleSheetImpl(@NotNull Context context, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, boolean z16) {
            Lazy lazy;
            Lazy lazy2;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(btnModel, "btnModel");
            this.context = context;
            this.btnModel = btnModel;
            this.mStyleDescription = InlineButtonStyleUtils.f111753a.o(context, btnModel.f().c(), z16);
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
            lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Drawable>() { // from class: com.tencent.guild.aio.msglist.markdown.inlineboard.InlineButtonStyleUtils$InlineBtnStyleSheetImpl$mIconDrawable$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Drawable invoke() {
                    Context context2;
                    com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar;
                    InlineButtonStyleUtils.StyleDescription styleDescription;
                    int[][] m3;
                    Drawable n3;
                    InlineButtonStyleUtils inlineButtonStyleUtils = InlineButtonStyleUtils.f111753a;
                    context2 = InlineButtonStyleUtils.InlineBtnStyleSheetImpl.this.context;
                    aVar = InlineButtonStyleUtils.InlineBtnStyleSheetImpl.this.btnModel;
                    int i3 = inlineButtonStyleUtils.i(aVar);
                    styleDescription = InlineButtonStyleUtils.InlineBtnStyleSheetImpl.this.mStyleDescription;
                    ColorStateList iconTintColor = styleDescription.getIconTintColor();
                    m3 = inlineButtonStyleUtils.m();
                    n3 = inlineButtonStyleUtils.n(context2, i3, iconTintColor, m3);
                    return n3;
                }
            });
            this.mIconDrawable = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Drawable>() { // from class: com.tencent.guild.aio.msglist.markdown.inlineboard.InlineButtonStyleUtils$InlineBtnStyleSheetImpl$mBackgroundDrawable$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Drawable invoke() {
                    InlineButtonStyleUtils.StyleDescription styleDescription;
                    InlineButtonStyleUtils.StyleDescription styleDescription2;
                    Drawable h16;
                    InlineButtonStyleUtils inlineButtonStyleUtils = InlineButtonStyleUtils.f111753a;
                    styleDescription = InlineButtonStyleUtils.InlineBtnStyleSheetImpl.this.mStyleDescription;
                    ColorStateList borderColor = styleDescription.getBorderColor();
                    styleDescription2 = InlineButtonStyleUtils.InlineBtnStyleSheetImpl.this.mStyleDescription;
                    h16 = inlineButtonStyleUtils.h(borderColor, styleDescription2.getSolidColor());
                    return h16;
                }
            });
            this.mBackgroundDrawable = lazy2;
        }

        private final Drawable l() {
            return (Drawable) this.mBackgroundDrawable.getValue();
        }

        private final Drawable m() {
            return (Drawable) this.mIconDrawable.getValue();
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        public /* synthetic */ int a() {
            return com.tencent.android.androidbypass.enhance.inlinekeyboard.view.b.h(this);
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        @NotNull
        public Drawable b() {
            return l();
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        @Nullable
        public Drawable c() {
            return com.tencent.mobileqq.guild.util.qqui.d.d(this.context, this.mStyleDescription.getLoadingType());
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        public int d() {
            return 8;
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        @NotNull
        public ColorStateList e() {
            return this.mStyleDescription.getTextColor();
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        @Nullable
        public Drawable f() {
            return m();
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        @NotNull
        public Drawable g() {
            return InlineButtonStyleUtils.f111753a.j(this.mStyleDescription);
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        public /* synthetic */ int getIconRes() {
            return com.tencent.android.androidbypass.enhance.inlinekeyboard.view.b.e(this);
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        @NotNull
        public InlineBtnStyleSheet.BtnType getType() {
            if (InlineButtonStyleUtils.f111753a.i(this.btnModel) != 0) {
                return InlineBtnStyleSheet.BtnType.ENTER;
            }
            return InlineBtnStyleSheet.BtnType.NORMAL;
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        public /* synthetic */ int h() {
            return com.tencent.android.androidbypass.enhance.inlinekeyboard.view.b.b(this);
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<int[][]>() { // from class: com.tencent.guild.aio.msglist.markdown.inlineboard.InlineButtonStyleUtils$mInlineBtnStateArray$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final int[][] invoke() {
                return new int[][]{new int[]{R.attr.state_selected}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_enabled}, new int[]{-16842910}};
            }
        });
        mInlineBtnStateArray = lazy;
    }

    InlineButtonStyleUtils() {
    }

    private final ColorStateList g(@ColorInt int defaultColor, @ColorInt int selectedColor, @ColorInt int pressedColor, @ColorInt int disableColor) {
        return new ColorStateList(m(), new int[]{selectedColor, pressedColor, defaultColor, disableColor});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable h(ColorStateList borderColorStateList, ColorStateList solidColorStateList) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(4.0f));
        if (borderColorStateList != null) {
            gradientDrawable.setStroke(ViewUtils.dpToPx(1.0f), borderColorStateList);
        }
        gradientDrawable.setColor(solidColorStateList);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int i(com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel) {
        int c16 = btnModel.a().c();
        if (c16 != 0) {
            if (c16 != 4) {
                return 0;
            }
            return com.tencent.mobileqq.R.drawable.qui_remind;
        }
        return com.tencent.mobileqq.R.drawable.qui_link;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable j(StyleDescription styleDescription) {
        Integer num;
        int[] iArr = {R.attr.state_pressed};
        int colorForState = styleDescription.getSolidColor().getColorForState(iArr, styleDescription.getSolidColor().getDefaultColor());
        ColorStateList borderColor = styleDescription.getBorderColor();
        ColorStateList colorStateList = null;
        if (borderColor != null) {
            num = Integer.valueOf(borderColor.getColorForState(iArr, styleDescription.getBorderColor().getDefaultColor()));
        } else {
            num = null;
        }
        if (num != null) {
            colorStateList = ColorStateList.valueOf(num.intValue());
        }
        ColorStateList valueOf = ColorStateList.valueOf(colorForState);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(solidColor)");
        return h(colorStateList, valueOf);
    }

    public static /* synthetic */ InlineBtnStyleSheet l(InlineButtonStyleUtils inlineButtonStyleUtils, Context context, com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        return inlineButtonStyleUtils.k(context, aVar, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int[][] m() {
        return (int[][]) mInlineBtnStateArray.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable n(Context context, @DrawableRes int drawableRes, ColorStateList tintColor, int[][] stateArray) {
        if (drawableRes == 0) {
            return null;
        }
        if (tintColor == null) {
            return ContextCompat.getDrawable(context, drawableRes);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        for (int[] iArr : stateArray) {
            stateListDrawable.addState(iArr, GuildUIUtils.y(context, drawableRes, tintColor.getColorForState(iArr, tintColor.getDefaultColor())));
        }
        return stateListDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StyleDescription o(Context context, int style, boolean supportVas) {
        int i3;
        StyleDescription styleDescription;
        if (supportVas && UIUtil.f112434a.A()) {
            i3 = 16;
        } else {
            i3 = 0;
        }
        int i16 = i3 | (style & 15);
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 3) {
                    if (i16 != 4) {
                        if (i16 != 16) {
                            if (i16 != 17) {
                                if (i16 != 19) {
                                    if (i16 != 20) {
                                        styleDescription = null;
                                    } else {
                                        ColorStateList colorStateList = context.getColorStateList(com.tencent.mobileqq.R.color.blk);
                                        Intrinsics.checkNotNullExpressionValue(colorStateList, "getColorStateList(R.colo\u2026_inlinebtn_solid_blue_bg)");
                                        ColorStateList colorStateList2 = context.getColorStateList(com.tencent.mobileqq.R.color.qui_button_text_primary);
                                        Intrinsics.checkNotNullExpressionValue(colorStateList2, "getColorStateList(com.te\u2026.qui_button_text_primary)");
                                        styleDescription = new StyleDescription(colorStateList, colorStateList2, null, null, 1, 12, null);
                                        styleDescription.f(styleDescription.getTextColor());
                                    }
                                } else {
                                    ColorStateList colorStateList3 = context.getColorStateList(com.tencent.mobileqq.R.color.bll);
                                    ColorStateList colorStateList4 = context.getColorStateList(com.tencent.mobileqq.R.color.blj);
                                    ColorStateList colorStateList5 = context.getColorStateList(com.tencent.mobileqq.R.color.bln);
                                    Intrinsics.checkNotNullExpressionValue(colorStateList3, "getColorStateList(R.colo\u2026aio_inlinebtn_solid_gray)");
                                    Intrinsics.checkNotNullExpressionValue(colorStateList5, "getColorStateList(R.colo\u2026d_aio_inlinebtn_text_red)");
                                    styleDescription = new StyleDescription(colorStateList3, colorStateList5, colorStateList4, null, 0, 24, null);
                                    styleDescription.f(styleDescription.getBorderColor());
                                }
                            } else {
                                int color = context.getColor(com.tencent.mobileqq.R.color.qui_button_bg_primary_default);
                                InlineButtonStyleUtils inlineButtonStyleUtils = f111753a;
                                GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
                                ColorStateList g16 = inlineButtonStyleUtils.g(0, guildUIUtils.E(color, 0.1f), guildUIUtils.E(color, 0.1f), 0);
                                ColorStateList colorStateList6 = context.getColorStateList(com.tencent.mobileqq.R.color.blh);
                                ColorStateList colorStateList7 = context.getColorStateList(com.tencent.mobileqq.R.color.blh);
                                Intrinsics.checkNotNullExpressionValue(colorStateList7, "getColorStateList(R.colo\u2026nlinebtn_border_blue_vas)");
                                styleDescription = new StyleDescription(g16, colorStateList7, colorStateList6, null, 0, 24, null);
                                styleDescription.f(styleDescription.getBorderColor());
                            }
                        } else {
                            ColorStateList colorStateList8 = context.getColorStateList(com.tencent.mobileqq.R.color.bll);
                            ColorStateList colorStateList9 = context.getColorStateList(com.tencent.mobileqq.R.color.blj);
                            ColorStateList colorStateList10 = context.getColorStateList(com.tencent.mobileqq.R.color.blj);
                            Intrinsics.checkNotNullExpressionValue(colorStateList8, "getColorStateList(R.colo\u2026aio_inlinebtn_solid_gray)");
                            Intrinsics.checkNotNullExpressionValue(colorStateList10, "getColorStateList(R.colo\u2026nlinebtn_border_gray_vas)");
                            styleDescription = new StyleDescription(colorStateList8, colorStateList10, colorStateList9, null, 0, 24, null);
                            styleDescription.f(styleDescription.getBorderColor());
                        }
                    } else {
                        ColorStateList g17 = f111753a.g(context.getColor(com.tencent.mobileqq.R.color.qui_button_bg_primary_default), context.getColor(com.tencent.mobileqq.R.color.qui_button_bg_primary_pressed), context.getColor(com.tencent.mobileqq.R.color.qui_button_bg_primary_pressed), context.getColor(com.tencent.mobileqq.R.color.qui_button_bg_primary_disable));
                        ColorStateList colorStateList11 = context.getColorStateList(com.tencent.mobileqq.R.color.qui_button_text_primary);
                        Intrinsics.checkNotNullExpressionValue(colorStateList11, "getColorStateList(com.te\u2026.qui_button_text_primary)");
                        styleDescription = new StyleDescription(g17, colorStateList11, null, null, 1, 12, null);
                        styleDescription.f(styleDescription.getTextColor());
                    }
                } else {
                    InlineButtonStyleUtils inlineButtonStyleUtils2 = f111753a;
                    ColorStateList g18 = inlineButtonStyleUtils2.g(0, context.getColor(com.tencent.mobileqq.R.color.qui_button_bg_secondary_pressed), context.getColor(com.tencent.mobileqq.R.color.qui_button_bg_secondary_pressed), 0);
                    ColorStateList g19 = inlineButtonStyleUtils2.g(context.getColor(com.tencent.mobileqq.R.color.qui_button_border_secondary_default), context.getColor(com.tencent.mobileqq.R.color.qui_button_border_secondary_pressed), context.getColor(com.tencent.mobileqq.R.color.qui_button_border_secondary_pressed), context.getColor(com.tencent.mobileqq.R.color.qui_button_border_secondary_disable));
                    ColorStateList colorStateList12 = context.getColorStateList(com.tencent.mobileqq.R.color.bln);
                    Intrinsics.checkNotNullExpressionValue(colorStateList12, "getColorStateList(R.colo\u2026d_aio_inlinebtn_text_red)");
                    StyleDescription styleDescription2 = new StyleDescription(g18, colorStateList12, g19, null, 0, 24, null);
                    styleDescription2.f(styleDescription2.getBorderColor());
                    styleDescription = styleDescription2;
                }
            } else {
                int color2 = context.getColor(com.tencent.mobileqq.R.color.qui_button_bg_primary_default);
                InlineButtonStyleUtils inlineButtonStyleUtils3 = f111753a;
                GuildUIUtils guildUIUtils2 = GuildUIUtils.f235378a;
                styleDescription = new StyleDescription(inlineButtonStyleUtils3.g(0, guildUIUtils2.E(color2, 0.1f), guildUIUtils2.E(color2, 0.1f), 0), inlineButtonStyleUtils3.g(context.getColor(com.tencent.mobileqq.R.color.qui_button_bg_primary_default), context.getColor(com.tencent.mobileqq.R.color.qui_button_bg_primary_default), context.getColor(com.tencent.mobileqq.R.color.qui_button_bg_primary_default), context.getColor(com.tencent.mobileqq.R.color.qui_button_text_secondary_disable)), inlineButtonStyleUtils3.g(context.getColor(com.tencent.mobileqq.R.color.qui_button_bg_primary_default), context.getColor(com.tencent.mobileqq.R.color.qui_button_bg_primary_default), context.getColor(com.tencent.mobileqq.R.color.qui_button_bg_primary_default), context.getColor(com.tencent.mobileqq.R.color.qui_button_border_secondary_disable)), null, 0, 24, null);
                styleDescription.f(styleDescription.getBorderColor());
            }
        } else {
            InlineButtonStyleUtils inlineButtonStyleUtils4 = f111753a;
            ColorStateList g26 = inlineButtonStyleUtils4.g(0, context.getColor(com.tencent.mobileqq.R.color.qui_button_bg_secondary_pressed), context.getColor(com.tencent.mobileqq.R.color.qui_button_bg_secondary_pressed), 0);
            ColorStateList g27 = inlineButtonStyleUtils4.g(context.getColor(com.tencent.mobileqq.R.color.qui_button_border_secondary_default), context.getColor(com.tencent.mobileqq.R.color.qui_button_border_secondary_pressed), context.getColor(com.tencent.mobileqq.R.color.qui_button_border_secondary_pressed), context.getColor(com.tencent.mobileqq.R.color.qui_button_border_secondary_disable));
            ColorStateList colorStateList13 = context.getColorStateList(com.tencent.mobileqq.R.color.qui_button_text_secondary);
            Intrinsics.checkNotNullExpressionValue(colorStateList13, "getColorStateList(com.te\u2026ui_button_text_secondary)");
            styleDescription = new StyleDescription(g26, colorStateList13, g27, null, 0, 24, null);
            styleDescription.f(styleDescription.getBorderColor());
        }
        if (styleDescription == null) {
            return o(context, 0, supportVas);
        }
        return styleDescription;
    }

    @NotNull
    public final InlineBtnStyleSheet k(@NotNull Context context, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, boolean supportVas) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
        return new InlineBtnStyleSheetImpl(context, btnModel, supportVas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\n\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u0012\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/inlineboard/InlineButtonStyleUtils$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/content/res/ColorStateList;", "a", "Landroid/content/res/ColorStateList;", "d", "()Landroid/content/res/ColorStateList;", "solidColor", "b", "e", "textColor", "c", NodeProps.BORDER_COLOR, "f", "(Landroid/content/res/ColorStateList;)V", "iconTintColor", "I", "()I", "loadingType", "<init>", "(Landroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.markdown.inlineboard.InlineButtonStyleUtils$a, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class StyleDescription {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ColorStateList solidColor;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ColorStateList textColor;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final ColorStateList borderColor;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private ColorStateList iconTintColor;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int loadingType;

        public StyleDescription(@NotNull ColorStateList solidColor, @NotNull ColorStateList textColor, @Nullable ColorStateList colorStateList, @Nullable ColorStateList colorStateList2, int i3) {
            Intrinsics.checkNotNullParameter(solidColor, "solidColor");
            Intrinsics.checkNotNullParameter(textColor, "textColor");
            this.solidColor = solidColor;
            this.textColor = textColor;
            this.borderColor = colorStateList;
            this.iconTintColor = colorStateList2;
            this.loadingType = i3;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final ColorStateList getBorderColor() {
            return this.borderColor;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final ColorStateList getIconTintColor() {
            return this.iconTintColor;
        }

        /* renamed from: c, reason: from getter */
        public final int getLoadingType() {
            return this.loadingType;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final ColorStateList getSolidColor() {
            return this.solidColor;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final ColorStateList getTextColor() {
            return this.textColor;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StyleDescription)) {
                return false;
            }
            StyleDescription styleDescription = (StyleDescription) other;
            if (Intrinsics.areEqual(this.solidColor, styleDescription.solidColor) && Intrinsics.areEqual(this.textColor, styleDescription.textColor) && Intrinsics.areEqual(this.borderColor, styleDescription.borderColor) && Intrinsics.areEqual(this.iconTintColor, styleDescription.iconTintColor) && this.loadingType == styleDescription.loadingType) {
                return true;
            }
            return false;
        }

        public final void f(@Nullable ColorStateList colorStateList) {
            this.iconTintColor = colorStateList;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.solidColor.hashCode() * 31) + this.textColor.hashCode()) * 31;
            ColorStateList colorStateList = this.borderColor;
            int i3 = 0;
            if (colorStateList == null) {
                hashCode = 0;
            } else {
                hashCode = colorStateList.hashCode();
            }
            int i16 = (hashCode2 + hashCode) * 31;
            ColorStateList colorStateList2 = this.iconTintColor;
            if (colorStateList2 != null) {
                i3 = colorStateList2.hashCode();
            }
            return ((i16 + i3) * 31) + this.loadingType;
        }

        @NotNull
        public String toString() {
            return "StyleDescription(solidColor=" + this.solidColor + ", textColor=" + this.textColor + ", borderColor=" + this.borderColor + ", iconTintColor=" + this.iconTintColor + ", loadingType=" + this.loadingType + ")";
        }

        public /* synthetic */ StyleDescription(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, ColorStateList colorStateList4, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(colorStateList, colorStateList2, (i16 & 4) != 0 ? null : colorStateList3, (i16 & 8) != 0 ? null : colorStateList4, (i16 & 16) != 0 ? 2 : i3);
        }
    }
}
