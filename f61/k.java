package f61;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.oidb_0x1250.oidb_0x1250$PartnerLightInteraction;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \f2\u00020\u0001:\u0001\u0004B\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lf61/k;", "", "", "toString", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "defaultInto", "clickIntro", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class k {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String defaultInto;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String clickIntro;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lf61/k$a;", "", "Ltencent/im/oidb/oidb_0x1250/oidb_0x1250$PartnerLightInteraction;", "partnerLightInteraction", "Lf61/k;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: f61.k$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final k a(@NotNull oidb_0x1250$PartnerLightInteraction partnerLightInteraction) {
            String str;
            Intrinsics.checkNotNullParameter(partnerLightInteraction, "partnerLightInteraction");
            String str2 = "";
            if (!partnerLightInteraction.default_intro.has()) {
                str = "";
            } else {
                str = partnerLightInteraction.default_intro.get();
            }
            Intrinsics.checkNotNullExpressionValue(str, "if (partnerLightInteract\u2026fault_intro.get() else \"\"");
            if (partnerLightInteraction.clcik_intro.has()) {
                str2 = partnerLightInteraction.clcik_intro.get();
            }
            Intrinsics.checkNotNullExpressionValue(str2, "if (partnerLightInteract\u2026clcik_intro.get() else \"\"");
            return new k(str, str2);
        }

        Companion() {
        }
    }

    public k(@NotNull String defaultInto, @NotNull String clickIntro) {
        Intrinsics.checkNotNullParameter(defaultInto, "defaultInto");
        Intrinsics.checkNotNullParameter(clickIntro, "clickIntro");
        this.defaultInto = defaultInto;
        this.clickIntro = clickIntro;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getClickIntro() {
        return this.clickIntro;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDefaultInto() {
        return this.defaultInto;
    }

    @NotNull
    public String toString() {
        return "defaultInto=" + this.defaultInto + ", clickIntro=" + this.clickIntro;
    }

    public /* synthetic */ k(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
    }
}
