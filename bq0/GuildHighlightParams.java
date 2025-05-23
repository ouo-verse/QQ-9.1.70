package bq0;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000bBk\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010!\u001a\u00020\u001a\u0012\u0006\u0010'\u001a\u00020\u0004\u0012\u0006\u0010*\u001a\u00020\u0004\u0012\b\b\u0002\u0010-\u001a\u00020\u0004\u0012\b\b\u0002\u00103\u001a\u00020.\u0012\b\b\u0002\u00108\u001a\u00020\u0007\u0012\b\b\u0002\u0010?\u001a\u000209\u0012\b\b\u0002\u0010A\u001a\u00020\u0004\u00a2\u0006\u0004\bB\u0010CJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R*\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\"\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\"\u001a\u0004\b\u0013\u0010$\"\u0004\b,\u0010&R\"\u00103\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010/\u001a\u0004\b+\u00100\"\u0004\b1\u00102R\"\u00108\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u00104\u001a\u0004\b\u001b\u00105\"\u0004\b6\u00107R\"\u0010?\u001a\u0002098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b:\u0010<\"\u0004\b=\u0010>R\"\u0010A\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\"\u001a\u0004\b\u000b\u0010$\"\u0004\b@\u0010&\u00a8\u0006D"}, d2 = {"Lbq0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "a", "Ljava/lang/ref/WeakReference;", "d", "()Ljava/lang/ref/WeakReference;", "setContext", "(Ljava/lang/ref/WeakReference;)V", "context", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "j", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "textView", "Landroid/text/SpannableStringBuilder;", "c", "Landroid/text/SpannableStringBuilder;", "g", "()Landroid/text/SpannableStringBuilder;", "setShowText", "(Landroid/text/SpannableStringBuilder;)V", "showText", "I", tl.h.F, "()I", "setStart", "(I)V", "start", "e", "setEnd", "end", "f", "setAtType", "atType", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "setExtData", "(Landroid/os/Bundle;)V", "extData", "Z", "()Z", "setCheckSourceChannelIsValid", "(Z)V", "checkSourceChannelIsValid", "Lbq0/a$a;", "i", "Lbq0/a$a;", "()Lbq0/a$a;", "l", "(Lbq0/a$a;)V", "style", "k", "atTextColor", "<init>", "(Ljava/lang/ref/WeakReference;Landroid/widget/TextView;Landroid/text/SpannableStringBuilder;IIILandroid/os/Bundle;ZLbq0/a$a;I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bq0.a, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class GuildHighlightParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private WeakReference<Context> context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private TextView textView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private SpannableStringBuilder showText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int start;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int end;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int atType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private Bundle extData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean checkSourceChannelIsValid;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private GuildHighlightStyle style;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private int atTextColor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\tBW\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020 \u0012\b\b\u0002\u0010'\u001a\u00020 \u00a2\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\rR\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\rR\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\rR\"\u0010%\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010!\u001a\u0004\b\u0016\u0010\"\"\u0004\b#\u0010$R\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b\u000f\u0010\"\"\u0004\b&\u0010$\u00a8\u0006*"}, d2 = {"Lbq0/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "g", "(I)V", "atBgColorId", "b", "c", "i", "atTextColorId", "getAtTextColorIdWhite", "setAtTextColorIdWhite", "atTextColorIdWhite", "d", "getHashTagTextColorId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "hashTagTextColorId", "e", "k", "hashTagBgColorId", "f", "l", "hashTagPressedColorId", "", UserInfo.SEX_FEMALE, "()F", "j", "(F)V", "atTextSize", tl.h.F, "atIconSize", "<init>", "(IIIIIIFF)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bq0.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class GuildHighlightStyle {

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private int atBgColorId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int atTextColorId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int atTextColorIdWhite;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int hashTagTextColorId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private int hashTagBgColorId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private int hashTagPressedColorId;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private float atTextSize;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private float atIconSize;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\r"}, d2 = {"Lbq0/a$a$a;", "", "", "a", "b", "c", "g", "e", "f", "", "d", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: bq0.a$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return R.color.f157122bl3;
            }

            public final int b() {
                return R.color.f157123bl4;
            }

            public final int c() {
                return R.color.bl5;
            }

            public final float d() {
                return 17.0f;
            }

            public final int e() {
                return R.color.bos;
            }

            public final int f() {
                return R.color.bov;
            }

            public final int g() {
                return R.color.bou;
            }

            Companion() {
            }
        }

        public GuildHighlightStyle() {
            this(0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 255, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getAtBgColorId() {
            return this.atBgColorId;
        }

        /* renamed from: b, reason: from getter */
        public final float getAtIconSize() {
            return this.atIconSize;
        }

        /* renamed from: c, reason: from getter */
        public final int getAtTextColorId() {
            return this.atTextColorId;
        }

        /* renamed from: d, reason: from getter */
        public final float getAtTextSize() {
            return this.atTextSize;
        }

        /* renamed from: e, reason: from getter */
        public final int getHashTagBgColorId() {
            return this.hashTagBgColorId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildHighlightStyle)) {
                return false;
            }
            GuildHighlightStyle guildHighlightStyle = (GuildHighlightStyle) other;
            if (this.atBgColorId == guildHighlightStyle.atBgColorId && this.atTextColorId == guildHighlightStyle.atTextColorId && this.atTextColorIdWhite == guildHighlightStyle.atTextColorIdWhite && this.hashTagTextColorId == guildHighlightStyle.hashTagTextColorId && this.hashTagBgColorId == guildHighlightStyle.hashTagBgColorId && this.hashTagPressedColorId == guildHighlightStyle.hashTagPressedColorId && Float.compare(this.atTextSize, guildHighlightStyle.atTextSize) == 0 && Float.compare(this.atIconSize, guildHighlightStyle.atIconSize) == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final int getHashTagPressedColorId() {
            return this.hashTagPressedColorId;
        }

        public final void g(int i3) {
            this.atBgColorId = i3;
        }

        public final void h(float f16) {
            this.atIconSize = f16;
        }

        public int hashCode() {
            return (((((((((((((this.atBgColorId * 31) + this.atTextColorId) * 31) + this.atTextColorIdWhite) * 31) + this.hashTagTextColorId) * 31) + this.hashTagBgColorId) * 31) + this.hashTagPressedColorId) * 31) + Float.floatToIntBits(this.atTextSize)) * 31) + Float.floatToIntBits(this.atIconSize);
        }

        public final void i(int i3) {
            this.atTextColorId = i3;
        }

        public final void j(float f16) {
            this.atTextSize = f16;
        }

        public final void k(int i3) {
            this.hashTagBgColorId = i3;
        }

        public final void l(int i3) {
            this.hashTagPressedColorId = i3;
        }

        public final void m(int i3) {
            this.hashTagTextColorId = i3;
        }

        @NotNull
        public String toString() {
            return "GuildHighlightStyle(atBgColorId=" + this.atBgColorId + ", atTextColorId=" + this.atTextColorId + ", atTextColorIdWhite=" + this.atTextColorIdWhite + ", hashTagTextColorId=" + this.hashTagTextColorId + ", hashTagBgColorId=" + this.hashTagBgColorId + ", hashTagPressedColorId=" + this.hashTagPressedColorId + ", atTextSize=" + this.atTextSize + ", atIconSize=" + this.atIconSize + ")";
        }

        public GuildHighlightStyle(int i3, int i16, int i17, int i18, int i19, int i26, float f16, float f17) {
            this.atBgColorId = i3;
            this.atTextColorId = i16;
            this.atTextColorIdWhite = i17;
            this.hashTagTextColorId = i18;
            this.hashTagBgColorId = i19;
            this.hashTagPressedColorId = i26;
            this.atTextSize = f16;
            this.atIconSize = f17;
        }

        public /* synthetic */ GuildHighlightStyle(int i3, int i16, int i17, int i18, int i19, int i26, float f16, float f17, int i27, DefaultConstructorMarker defaultConstructorMarker) {
            this((i27 & 1) != 0 ? INSTANCE.a() : i3, (i27 & 2) != 0 ? INSTANCE.b() : i16, (i27 & 4) != 0 ? INSTANCE.c() : i17, (i27 & 8) != 0 ? INSTANCE.g() : i18, (i27 & 16) != 0 ? INSTANCE.e() : i19, (i27 & 32) != 0 ? INSTANCE.f() : i26, (i27 & 64) != 0 ? INSTANCE.d() : f16, (i27 & 128) != 0 ? INSTANCE.d() : f17);
        }
    }

    public GuildHighlightParams(@NotNull WeakReference<Context> context, @Nullable TextView textView, @NotNull SpannableStringBuilder showText, int i3, int i16, int i17, @NotNull Bundle extData, boolean z16, @NotNull GuildHighlightStyle style, int i18) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(showText, "showText");
        Intrinsics.checkNotNullParameter(extData, "extData");
        Intrinsics.checkNotNullParameter(style, "style");
        this.context = context;
        this.textView = textView;
        this.showText = showText;
        this.start = i3;
        this.end = i16;
        this.atType = i17;
        this.extData = extData;
        this.checkSourceChannelIsValid = z16;
        this.style = style;
        this.atTextColor = i18;
    }

    /* renamed from: a, reason: from getter */
    public final int getAtTextColor() {
        return this.atTextColor;
    }

    /* renamed from: b, reason: from getter */
    public final int getAtType() {
        return this.atType;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getCheckSourceChannelIsValid() {
        return this.checkSourceChannelIsValid;
    }

    @NotNull
    public final WeakReference<Context> d() {
        return this.context;
    }

    /* renamed from: e, reason: from getter */
    public final int getEnd() {
        return this.end;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildHighlightParams)) {
            return false;
        }
        GuildHighlightParams guildHighlightParams = (GuildHighlightParams) other;
        if (Intrinsics.areEqual(this.context, guildHighlightParams.context) && Intrinsics.areEqual(this.textView, guildHighlightParams.textView) && Intrinsics.areEqual(this.showText, guildHighlightParams.showText) && this.start == guildHighlightParams.start && this.end == guildHighlightParams.end && this.atType == guildHighlightParams.atType && Intrinsics.areEqual(this.extData, guildHighlightParams.extData) && this.checkSourceChannelIsValid == guildHighlightParams.checkSourceChannelIsValid && Intrinsics.areEqual(this.style, guildHighlightParams.style) && this.atTextColor == guildHighlightParams.atTextColor) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final Bundle getExtData() {
        return this.extData;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final SpannableStringBuilder getShowText() {
        return this.showText;
    }

    /* renamed from: h, reason: from getter */
    public final int getStart() {
        return this.start;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = this.context.hashCode() * 31;
        TextView textView = this.textView;
        if (textView == null) {
            hashCode = 0;
        } else {
            hashCode = textView.hashCode();
        }
        int hashCode3 = (((((((((((hashCode2 + hashCode) * 31) + this.showText.hashCode()) * 31) + this.start) * 31) + this.end) * 31) + this.atType) * 31) + this.extData.hashCode()) * 31;
        boolean z16 = this.checkSourceChannelIsValid;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((hashCode3 + i3) * 31) + this.style.hashCode()) * 31) + this.atTextColor;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final GuildHighlightStyle getStyle() {
        return this.style;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final TextView getTextView() {
        return this.textView;
    }

    public final void k(int i3) {
        this.atTextColor = i3;
    }

    public final void l(@NotNull GuildHighlightStyle guildHighlightStyle) {
        Intrinsics.checkNotNullParameter(guildHighlightStyle, "<set-?>");
        this.style = guildHighlightStyle;
    }

    @NotNull
    public String toString() {
        WeakReference<Context> weakReference = this.context;
        TextView textView = this.textView;
        SpannableStringBuilder spannableStringBuilder = this.showText;
        return "GuildHighlightParams(context=" + weakReference + ", textView=" + textView + ", showText=" + ((Object) spannableStringBuilder) + ", start=" + this.start + ", end=" + this.end + ", atType=" + this.atType + ", extData=" + this.extData + ", checkSourceChannelIsValid=" + this.checkSourceChannelIsValid + ", style=" + this.style + ", atTextColor=" + this.atTextColor + ")";
    }

    public /* synthetic */ GuildHighlightParams(WeakReference weakReference, TextView textView, SpannableStringBuilder spannableStringBuilder, int i3, int i16, int i17, Bundle bundle, boolean z16, GuildHighlightStyle guildHighlightStyle, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference, textView, spannableStringBuilder, i3, i16, (i19 & 32) != 0 ? 0 : i17, (i19 & 64) != 0 ? new Bundle() : bundle, (i19 & 128) != 0 ? true : z16, (i19 & 256) != 0 ? new GuildHighlightStyle(0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 255, null) : guildHighlightStyle, (i19 & 512) != 0 ? 0 : i18);
    }
}
