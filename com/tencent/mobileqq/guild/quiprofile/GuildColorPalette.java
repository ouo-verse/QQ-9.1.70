package com.tencent.mobileqq.guild.quiprofile;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.quiprofile.GuildColorPalette;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.theme.SkinnableColorStateList;
import com.tencent.util.QUIProfileConstants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0002\t\u0019B\u0011\b\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001f\u0010\u0015\u001a\u00060\u0010R\u00020\u00008FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/quiprofile/GuildColorPalette;", "Lae0/a;", "", "colorToken", "", "getColor", "", "y", "", "a", "I", "paletteIndex", "", "b", "Ljava/util/Map;", "tokenMap", "Lcom/tencent/mobileqq/guild/quiprofile/GuildColorPalette$InspectorColorPalette;", "c", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/guild/quiprofile/GuildColorPalette$InspectorColorPalette;", "inspector", "<init>", "(I)V", "d", "InspectorColorPalette", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildColorPalette implements ae0.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildColorPalette> f231904e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildColorPalette> f231905f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildColorPalette> f231906g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildColorPalette> f231907h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildColorPalette> f231908i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildColorPalette> f231909j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildColorPalette> f231910k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildColorPalette> f231911l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final Lazy<ae0.a> f231912m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final Lazy<ae0.a> f231913n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private static final int[] f231914o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private static final Lazy<Map<String, List<String>>> f231915p;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int paletteIndex;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> tokenMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy inspector;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u001b\u0010\u0010\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/quiprofile/GuildColorPalette$InspectorColorPalette;", "Lae0/a;", "", "color", "", "redFactor", "gbReduction", "b", "", "colorToken", "", "getColor", "", "a", "Lkotlin/Lazy;", "()Z", "isCurrentTokenDark", "<init>", "(Lcom/tencent/mobileqq/guild/quiprofile/GuildColorPalette;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public final class InspectorColorPalette implements ae0.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy isCurrentTokenDark;

        public InspectorColorPalette() {
            Lazy lazy;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.quiprofile.GuildColorPalette$InspectorColorPalette$isCurrentTokenDark$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    return Boolean.valueOf(je0.a.a(MobileQQ.sMobileQQ));
                }
            });
            this.isCurrentTokenDark = lazy;
        }

        private final boolean a() {
            return ((Boolean) this.isCurrentTokenDark.getValue()).booleanValue();
        }

        private final int b(int color, float redFactor, float gbReduction) {
            int coerceIn;
            int coerceIn2;
            int coerceIn3;
            int alpha = Color.alpha(color);
            int red = Color.red(color);
            int green = Color.green(color);
            int blue = Color.blue(color);
            coerceIn = RangesKt___RangesKt.coerceIn((int) (red + ((255 - red) * redFactor)), 0, 255);
            float f16 = 1 - gbReduction;
            coerceIn2 = RangesKt___RangesKt.coerceIn((int) (green * f16), 0, 255);
            coerceIn3 = RangesKt___RangesKt.coerceIn((int) (blue * f16), 0, 255);
            return Color.argb(alpha, coerceIn, coerceIn2, coerceIn3);
        }

        static /* synthetic */ int c(InspectorColorPalette inspectorColorPalette, int i3, float f16, float f17, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                f16 = 0.3f;
            }
            if ((i16 & 4) != 0) {
                f17 = 0.2f;
            }
            return inspectorColorPalette.b(i3, f16, f17);
        }

        @Override // ae0.a
        @NotNull
        public int[] getColor(@Nullable String colorToken) {
            boolean z16;
            ae0.a aVar;
            int lastIndexOf$default;
            boolean z17;
            if (colorToken != null && colorToken.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return GuildColorPalette.f231914o;
            }
            if (GuildColorPalette.this.tokenMap.containsKey(colorToken)) {
                if (a()) {
                    return GuildColorPalette.INSTANCE.g().getColor(colorToken);
                }
                return GuildColorPalette.INSTANCE.h().getColor(colorToken);
            }
            if (a()) {
                aVar = QUIProfileConstants.DEFAULT_COLOR_PALETTE;
            } else {
                aVar = QUIProfileConstants.DEFAULT_NIGHT_COLOR_PALETTE;
            }
            int[] color = aVar.getColor(colorToken);
            if (color != null) {
                if (color.length == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    return color;
                }
            }
            Resources resources = MobileQQ.sMobileQQ.getResources();
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) colorToken, ".xml", 0, false, 6, (Object) null);
            String substring = colorToken.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            int identifier = resources.getIdentifier(substring, "color", MobileQQ.sMobileQQ.getPackageName());
            if (identifier != 0) {
                try {
                    ColorStateList colorStateList = resources.getColorStateList(identifier);
                    Intrinsics.checkNotNullExpressionValue(colorStateList, "res.getColorStateList(resId)");
                    if (colorStateList instanceof SkinnableColorStateList) {
                        int length = ((SkinnableColorStateList) colorStateList).getColors().length;
                        int[] iArr = new int[length];
                        for (int i3 = 0; i3 < length; i3++) {
                            iArr[i3] = c(this, ((SkinnableColorStateList) colorStateList).getColors()[i3], 0.0f, 0.0f, 6, null);
                        }
                        return iArr;
                    }
                } catch (Resources.NotFoundException unused) {
                }
            }
            return new int[]{Color.parseColor("#FF0001")};
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0015\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b?\u0010\u0015J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0007R-\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\n0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR!\u0010\u0016\u001a\u00020\u00108FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u001a\u001a\u00020\u00108FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\f\u0012\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u0018\u0010\u0013R!\u0010\u001e\u001a\u00020\u00108FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\f\u0012\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001c\u0010\u0013R!\u0010\"\u001a\u00020\u00108FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\f\u0012\u0004\b!\u0010\u0015\u001a\u0004\b \u0010\u0013R!\u0010&\u001a\u00020\u00108FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b#\u0010\f\u0012\u0004\b%\u0010\u0015\u001a\u0004\b$\u0010\u0013R!\u0010*\u001a\u00020\u00108FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b'\u0010\f\u0012\u0004\b)\u0010\u0015\u001a\u0004\b(\u0010\u0013R!\u0010.\u001a\u00020\u00108FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b+\u0010\f\u0012\u0004\b-\u0010\u0015\u001a\u0004\b,\u0010\u0013R!\u00102\u001a\u00020\u00108FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b/\u0010\f\u0012\u0004\b1\u0010\u0015\u001a\u0004\b0\u0010\u0013R!\u00107\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b3\u0010\f\u0012\u0004\b6\u0010\u0015\u001a\u0004\b4\u00105R!\u0010;\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b8\u0010\f\u0012\u0004\b:\u0010\u0015\u001a\u0004\b9\u00105R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/guild/quiprofile/GuildColorPalette$a;", "", "Lae0/a;", "palette1", "palette2", "p", "", "r", "", "", "", "tokenConfig$delegate", "Lkotlin/Lazy;", "o", "()Ljava/util/Map;", "tokenConfig", "Lcom/tencent/mobileqq/guild/quiprofile/GuildColorPalette;", "default$delegate", "g", "()Lcom/tencent/mobileqq/guild/quiprofile/GuildColorPalette;", "getDefault$annotations", "()V", "default", "night$delegate", h.F, "getNight$annotations", "night", "simpleYellow$delegate", DomainData.DOMAIN_NAME, "getSimpleYellow$annotations", "simpleYellow", "simpleGreen$delegate", "j", "getSimpleGreen$annotations", "simpleGreen", "simpleTRed$delegate", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getSimpleTRed$annotations", "simpleTRed", "simplePurple$delegate", "k", "getSimplePurple$annotations", "simplePurple", "simpleBlue$delegate", "i", "getSimpleBlue$annotations", "simpleBlue", "simpleRed$delegate", "l", "getSimpleRed$annotations", "simpleRed", "allDefault$delegate", "e", "()Lae0/a;", "getAllDefault$annotations", "allDefault", "allNight$delegate", "f", "getAllNight$annotations", "allNight", "", "emptyIntArray", "[I", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.quiprofile.GuildColorPalette$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, List<String>> o() {
            return (Map) GuildColorPalette.f231915p.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ae0.a p(final ae0.a palette1, final ae0.a palette2) {
            return new ae0.a() { // from class: com.tencent.mobileqq.guild.quiprofile.a
                @Override // ae0.a
                public final int[] getColor(String str) {
                    int[] q16;
                    q16 = GuildColorPalette.Companion.q(ae0.a.this, palette2, str);
                    return q16;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int[] q(ae0.a palette1, ae0.a palette2, String str) {
            boolean z16;
            Intrinsics.checkNotNullParameter(palette1, "$palette1");
            Intrinsics.checkNotNullParameter(palette2, "$palette2");
            int[] color = palette1.getColor(str);
            if (color != null) {
                if (color.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return color;
                }
            }
            return palette2.getColor(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s() {
            GuildColorPalette.INSTANCE.o();
        }

        @NotNull
        public final ae0.a e() {
            return (ae0.a) GuildColorPalette.f231912m.getValue();
        }

        @NotNull
        public final ae0.a f() {
            return (ae0.a) GuildColorPalette.f231913n.getValue();
        }

        @NotNull
        public final GuildColorPalette g() {
            return (GuildColorPalette) GuildColorPalette.f231904e.getValue();
        }

        @NotNull
        public final GuildColorPalette h() {
            return (GuildColorPalette) GuildColorPalette.f231905f.getValue();
        }

        @NotNull
        public final GuildColorPalette i() {
            return (GuildColorPalette) GuildColorPalette.f231910k.getValue();
        }

        @NotNull
        public final GuildColorPalette j() {
            return (GuildColorPalette) GuildColorPalette.f231907h.getValue();
        }

        @NotNull
        public final GuildColorPalette k() {
            return (GuildColorPalette) GuildColorPalette.f231909j.getValue();
        }

        @NotNull
        public final GuildColorPalette l() {
            return (GuildColorPalette) GuildColorPalette.f231911l.getValue();
        }

        @NotNull
        public final GuildColorPalette m() {
            return (GuildColorPalette) GuildColorPalette.f231908i.getValue();
        }

        @NotNull
        public final GuildColorPalette n() {
            return (GuildColorPalette) GuildColorPalette.f231906g.getValue();
        }

        @JvmStatic
        public final void r() {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.quiprofile.b
                @Override // java.lang.Runnable
                public final void run() {
                    GuildColorPalette.Companion.s();
                }
            }, 64, null, false);
        }

        Companion() {
        }
    }

    static {
        Lazy<GuildColorPalette> lazy;
        Lazy<GuildColorPalette> lazy2;
        Lazy<GuildColorPalette> lazy3;
        Lazy<GuildColorPalette> lazy4;
        Lazy<GuildColorPalette> lazy5;
        Lazy<GuildColorPalette> lazy6;
        Lazy<GuildColorPalette> lazy7;
        Lazy<GuildColorPalette> lazy8;
        Lazy<ae0.a> lazy9;
        Lazy<ae0.a> lazy10;
        Lazy<Map<String, List<String>>> lazy11;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildColorPalette>() { // from class: com.tencent.mobileqq.guild.quiprofile.GuildColorPalette$Companion$default$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildColorPalette invoke() {
                return new GuildColorPalette(0, null);
            }
        });
        f231904e = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GuildColorPalette>() { // from class: com.tencent.mobileqq.guild.quiprofile.GuildColorPalette$Companion$night$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildColorPalette invoke() {
                return new GuildColorPalette(1, null);
            }
        });
        f231905f = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<GuildColorPalette>() { // from class: com.tencent.mobileqq.guild.quiprofile.GuildColorPalette$Companion$simpleYellow$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildColorPalette invoke() {
                return new GuildColorPalette(2, null);
            }
        });
        f231906g = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<GuildColorPalette>() { // from class: com.tencent.mobileqq.guild.quiprofile.GuildColorPalette$Companion$simpleGreen$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildColorPalette invoke() {
                return new GuildColorPalette(3, null);
            }
        });
        f231907h = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<GuildColorPalette>() { // from class: com.tencent.mobileqq.guild.quiprofile.GuildColorPalette$Companion$simpleTRed$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildColorPalette invoke() {
                return new GuildColorPalette(4, null);
            }
        });
        f231908i = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<GuildColorPalette>() { // from class: com.tencent.mobileqq.guild.quiprofile.GuildColorPalette$Companion$simplePurple$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildColorPalette invoke() {
                return new GuildColorPalette(5, null);
            }
        });
        f231909j = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<GuildColorPalette>() { // from class: com.tencent.mobileqq.guild.quiprofile.GuildColorPalette$Companion$simpleBlue$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildColorPalette invoke() {
                return new GuildColorPalette(6, null);
            }
        });
        f231910k = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<GuildColorPalette>() { // from class: com.tencent.mobileqq.guild.quiprofile.GuildColorPalette$Companion$simpleRed$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildColorPalette invoke() {
                return new GuildColorPalette(7, null);
            }
        });
        f231911l = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<ae0.a>() { // from class: com.tencent.mobileqq.guild.quiprofile.GuildColorPalette$Companion$allDefault$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ae0.a invoke() {
                ae0.a p16;
                GuildColorPalette.Companion companion = GuildColorPalette.INSTANCE;
                GuildColorPalette g16 = companion.g();
                ae0.a DEFAULT_COLOR_PALETTE = QUIProfileConstants.DEFAULT_COLOR_PALETTE;
                Intrinsics.checkNotNullExpressionValue(DEFAULT_COLOR_PALETTE, "DEFAULT_COLOR_PALETTE");
                p16 = companion.p(g16, DEFAULT_COLOR_PALETTE);
                return p16;
            }
        });
        f231912m = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<ae0.a>() { // from class: com.tencent.mobileqq.guild.quiprofile.GuildColorPalette$Companion$allNight$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ae0.a invoke() {
                ae0.a p16;
                GuildColorPalette.Companion companion = GuildColorPalette.INSTANCE;
                GuildColorPalette h16 = companion.h();
                ae0.a DEFAULT_NIGHT_COLOR_PALETTE = QUIProfileConstants.DEFAULT_NIGHT_COLOR_PALETTE;
                Intrinsics.checkNotNullExpressionValue(DEFAULT_NIGHT_COLOR_PALETTE, "DEFAULT_NIGHT_COLOR_PALETTE");
                p16 = companion.p(h16, DEFAULT_NIGHT_COLOR_PALETTE);
                return p16;
            }
        });
        f231913n = lazy10;
        f231914o = new int[0];
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, ? extends List<? extends String>>>() { // from class: com.tencent.mobileqq.guild.quiprofile.GuildColorPalette$Companion$tokenConfig$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, ? extends List<? extends String>> invoke() {
                return e.f231945a.b();
            }
        });
        f231915p = lazy11;
    }

    public /* synthetic */ GuildColorPalette(int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3);
    }

    @NotNull
    public static final ae0.a n() {
        return INSTANCE.e();
    }

    @NotNull
    public static final ae0.a o() {
        return INSTANCE.f();
    }

    @NotNull
    public static final GuildColorPalette p() {
        return INSTANCE.g();
    }

    @NotNull
    public static final GuildColorPalette r() {
        return INSTANCE.h();
    }

    @NotNull
    public static final GuildColorPalette s() {
        return INSTANCE.i();
    }

    @NotNull
    public static final GuildColorPalette t() {
        return INSTANCE.j();
    }

    @NotNull
    public static final GuildColorPalette u() {
        return INSTANCE.k();
    }

    @NotNull
    public static final GuildColorPalette v() {
        return INSTANCE.l();
    }

    @NotNull
    public static final GuildColorPalette w() {
        return INSTANCE.m();
    }

    @NotNull
    public static final GuildColorPalette x() {
        return INSTANCE.n();
    }

    @JvmStatic
    public static final void z() {
        INSTANCE.r();
    }

    @Override // ae0.a
    @NotNull
    public int[] getColor(@Nullable String colorToken) {
        boolean z16;
        List list;
        boolean z17 = true;
        if (colorToken != null && colorToken.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return f231914o;
        }
        String str = this.tokenMap.get(colorToken);
        if (str != null) {
            list = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null);
        } else {
            list = null;
        }
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z17 = false;
        }
        if (z17) {
            return f231914o;
        }
        try {
            int size = list.size();
            int[] iArr = new int[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = Color.parseColor((String) list.get(i3));
            }
            return iArr;
        } catch (Exception unused) {
            return f231914o;
        }
    }

    @NotNull
    public final InspectorColorPalette q() {
        return (InspectorColorPalette) this.inspector.getValue();
    }

    public final boolean y(@Nullable String colorToken) {
        boolean z16;
        if (colorToken != null && colorToken.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        if (this.tokenMap.containsKey(colorToken + ".xml") || this.tokenMap.containsKey(colorToken)) {
            return true;
        }
        return false;
    }

    GuildColorPalette(int i3) {
        Lazy lazy;
        boolean contains$default;
        this.paletteIndex = i3;
        this.tokenMap = new LinkedHashMap();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<InspectorColorPalette>() { // from class: com.tencent.mobileqq.guild.quiprofile.GuildColorPalette$inspector$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildColorPalette.InspectorColorPalette invoke() {
                return new GuildColorPalette.InspectorColorPalette();
            }
        });
        this.inspector = lazy;
        for (Map.Entry entry : INSTANCE.o().entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "button", false, 2, (Object) null);
            String str2 = contains$default ? "qui_" + str + ".xml" : "qui_common_" + str + ".xml";
            String str3 = (String) list.get(this.paletteIndex);
            if (!(str3 == null || str3.length() == 0)) {
                this.tokenMap.put(str2, str3);
            }
        }
        com.tencent.mobileqq.qui.util.b.b(this.tokenMap);
        com.tencent.mobileqq.qui.util.b.a(this.tokenMap);
        com.tencent.mobileqq.qui.util.b.c(this.tokenMap);
    }
}
