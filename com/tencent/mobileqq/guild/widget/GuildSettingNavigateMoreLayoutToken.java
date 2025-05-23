package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ,2\u00020\u0001:\u0004-./0B\u0011\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$B\u001b\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u00a2\u0006\u0004\b#\u0010'B#\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\u0006\u0010(\u001a\u00020\t\u00a2\u0006\u0004\b#\u0010)B+\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\u0006\u0010(\u001a\u00020\t\u0012\u0006\u0010*\u001a\u00020\t\u00a2\u0006\u0004\b#\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0017\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R+\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00188F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildSettingNavigateMoreLayoutToken;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/mobileqq/guild/widget/GuildSettingNavigateMoreLayoutToken$a;", "attribute", "", "z0", "", "rightText", "setRightText", "", "iconSrc", "setLeadingIcon", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "leadingIcon", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "textTitle", "f", "redDotView", tl.h.F, "rightTextContent", "Lcom/tencent/mobileqq/guild/widget/GuildSettingNavigateMoreLayoutToken$RoundType;", "<set-?>", "i", "Lcom/tencent/mobileqq/guild/widget/GuildSettingNavigateMoreLayoutToken$c;", "getRoundType", "()Lcom/tencent/mobileqq/guild/widget/GuildSettingNavigateMoreLayoutToken$RoundType;", "setRoundType", "(Lcom/tencent/mobileqq/guild/widget/GuildSettingNavigateMoreLayoutToken$RoundType;)V", "roundType", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "RoundType", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSettingNavigateMoreLayoutToken extends ConstraintLayout {
    static final /* synthetic */ KProperty<Object>[] C = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(GuildSettingNavigateMoreLayoutToken.class, "roundType", "getRoundType()Lcom/tencent/mobileqq/guild/widget/GuildSettingNavigateMoreLayoutToken$RoundType;", 0))};

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView leadingIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView textTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView redDotView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView rightTextContent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c roundType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildSettingNavigateMoreLayoutToken$RoundType;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "BOTH", "NONE", "TOP", "BOTTOM", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum RoundType {
        BOTH(0),
        NONE(1),
        TOP(2),
        BOTTOM(3);

        private final int value;

        RoundType(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0001\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\r\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildSettingNavigateMoreLayoutToken$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "iconSrc", "", "b", "Ljava/lang/CharSequence;", "d", "()Ljava/lang/CharSequence;", "title", "Lcom/tencent/mobileqq/guild/widget/GuildSettingNavigateMoreLayoutToken$RoundType;", "c", "Lcom/tencent/mobileqq/guild/widget/GuildSettingNavigateMoreLayoutToken$RoundType;", "()Lcom/tencent/mobileqq/guild/widget/GuildSettingNavigateMoreLayoutToken$RoundType;", "roundType", "rightText", "<init>", "(ILjava/lang/CharSequence;Lcom/tencent/mobileqq/guild/widget/GuildSettingNavigateMoreLayoutToken$RoundType;Ljava/lang/CharSequence;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.widget.GuildSettingNavigateMoreLayoutToken$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class Attribute {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int iconSrc;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final CharSequence title;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RoundType roundType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final CharSequence rightText;

        public Attribute(@DrawableRes int i3, @NotNull CharSequence title, @NotNull RoundType roundType, @NotNull CharSequence rightText) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(roundType, "roundType");
            Intrinsics.checkNotNullParameter(rightText, "rightText");
            this.iconSrc = i3;
            this.title = title;
            this.roundType = roundType;
            this.rightText = rightText;
        }

        /* renamed from: a, reason: from getter */
        public final int getIconSrc() {
            return this.iconSrc;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final CharSequence getRightText() {
            return this.rightText;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final RoundType getRoundType() {
            return this.roundType;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final CharSequence getTitle() {
            return this.title;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Attribute)) {
                return false;
            }
            Attribute attribute = (Attribute) other;
            if (this.iconSrc == attribute.iconSrc && Intrinsics.areEqual(this.title, attribute.title) && this.roundType == attribute.roundType && Intrinsics.areEqual(this.rightText, attribute.rightText)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.iconSrc * 31) + this.title.hashCode()) * 31) + this.roundType.hashCode()) * 31) + this.rightText.hashCode();
        }

        @NotNull
        public String toString() {
            int i3 = this.iconSrc;
            CharSequence charSequence = this.title;
            return "Attribute(iconSrc=" + i3 + ", title=" + ((Object) charSequence) + ", roundType=" + this.roundType + ", rightText=" + ((Object) this.rightText) + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u00020\u0005*\u00020\u0002H\u0002J\f\u0010\t\u001a\u00020\b*\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\u0002R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildSettingNavigateMoreLayoutToken$b;", "", "Landroid/content/res/TypedArray;", "", "g", "", "j", tl.h.F, "Lcom/tencent/mobileqq/guild/widget/GuildSettingNavigateMoreLayoutToken$RoundType;", "i", "roundType", "f", "", "DEFAULT_TITLE", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.widget.GuildSettingNavigateMoreLayoutToken$b, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.guild.widget.GuildSettingNavigateMoreLayoutToken$b$a */
        /* loaded from: classes14.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f235968a;

            static {
                int[] iArr = new int[RoundType.values().length];
                try {
                    iArr[RoundType.BOTH.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RoundType.NONE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RoundType.TOP.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[RoundType.BOTTOM.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f235968a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int f(RoundType roundType) {
            int i3 = a.f235968a[roundType.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            return R.drawable.guild_qui_common_fill_light_secondary_bg_bottom_round_8_selector;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return R.drawable.guild_qui_common_fill_light_secondary_bg_top_round_8_selector;
                }
                return R.drawable.qui_common_fill_light_secondary_bg_selector;
            }
            return R.drawable.qui_common_fill_light_secondary_round_8_bg_selector;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int g(TypedArray typedArray) {
            return typedArray.getResourceId(up1.a.f439448c5, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final CharSequence h(TypedArray typedArray) {
            CharSequence text = typedArray.getText(up1.a.f439462d5);
            if (text == null) {
                return "";
            }
            return text;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final RoundType i(TypedArray typedArray) {
            RoundType roundType;
            boolean z16;
            int i3 = typedArray.getInt(up1.a.f439476e5, RoundType.BOTH.getValue());
            RoundType[] values = RoundType.values();
            int length = values.length;
            int i16 = 0;
            while (true) {
                if (i16 < length) {
                    roundType = values[i16];
                    if (roundType.getValue() == i3) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i16++;
                } else {
                    roundType = null;
                    break;
                }
            }
            if (roundType == null) {
                return RoundType.BOTH;
            }
            return roundType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final CharSequence j(TypedArray typedArray) {
            CharSequence text = typedArray.getText(up1.a.f439490f5);
            if (text == null) {
                return "\u8df3\u8f6c\u8bf4\u660e";
            }
            return text;
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J'\u0010\b\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\u0002R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildSettingNavigateMoreLayoutToken$c;", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "Lcom/tencent/mobileqq/guild/widget/GuildSettingNavigateMoreLayoutToken$RoundType;", "value", "", "a", "Lkotlin/Lazy;", "Landroid/view/View;", "Lkotlin/Lazy;", "getView", "()Lkotlin/Lazy;", "view", "<init>", "(Lkotlin/Lazy;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy<View> view;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull Lazy<? extends View> view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
        }

        public final void a(@Nullable Object thisRef, @NotNull KProperty<?> property, @NotNull RoundType value) {
            Intrinsics.checkNotNullParameter(property, "property");
            Intrinsics.checkNotNullParameter(value, "value");
            this.view.getValue().setTag(R.id.wxg, value);
            this.view.getValue().setBackgroundResource(GuildSettingNavigateMoreLayoutToken.INSTANCE.f(value));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildSettingNavigateMoreLayoutToken(@NotNull Context context) {
        this(context, null, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void z0(Attribute attribute) {
        View findViewById = findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.icon)");
        this.leadingIcon = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.title)");
        this.textTitle = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.wph);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.guild_manage_red_dot)");
        this.redDotView = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.wvy);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.guild_right_text)");
        this.rightTextContent = (TextView) findViewById4;
        TextView textView = this.textTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textTitle");
            textView = null;
        }
        textView.setText(attribute.getTitle());
        setRoundType(attribute.getRoundType());
        setRightText(attribute.getRightText().toString());
        setLeadingIcon(attribute.getIconSrc());
    }

    public final void setLeadingIcon(int iconSrc) {
        ImageView imageView = null;
        if (iconSrc == 0) {
            ImageView imageView2 = this.leadingIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leadingIcon");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView3 = this.leadingIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leadingIcon");
            imageView3 = null;
        }
        imageView3.setVisibility(0);
        ImageView imageView4 = this.leadingIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leadingIcon");
        } else {
            imageView = imageView4;
        }
        imageView.setImageResource(iconSrc);
    }

    public final void setRightText(@NotNull String rightText) {
        boolean z16;
        Intrinsics.checkNotNullParameter(rightText, "rightText");
        TextView textView = this.rightTextContent;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightTextContent");
            textView = null;
        }
        textView.setText(rightText);
        TextView textView3 = this.rightTextContent;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightTextContent");
        } else {
            textView2 = textView3;
        }
        int i3 = 0;
        if (rightText.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = 8;
        }
        textView2.setVisibility(i3);
    }

    public final void setRoundType(@NotNull RoundType roundType) {
        Intrinsics.checkNotNullParameter(roundType, "<set-?>");
        this.roundType.a(this, C[0], roundType);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildSettingNavigateMoreLayoutToken(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildSettingNavigateMoreLayoutToken(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSettingNavigateMoreLayoutToken(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildSettingNavigateMoreLayoutToken>() { // from class: com.tencent.mobileqq.guild.widget.GuildSettingNavigateMoreLayoutToken$roundType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildSettingNavigateMoreLayoutToken invoke() {
                return GuildSettingNavigateMoreLayoutToken.this;
            }
        });
        this.roundType = new c(lazy);
        if (isInEditMode()) {
            return;
        }
        View.inflate(context, R.layout.f_1, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.f439434b5);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026ettingNavigateMoreLayout)");
        Companion companion = INSTANCE;
        Attribute attribute = new Attribute(companion.g(obtainStyledAttributes), companion.j(obtainStyledAttributes), companion.i(obtainStyledAttributes), companion.h(obtainStyledAttributes));
        obtainStyledAttributes.recycle();
        z0(attribute);
    }
}
