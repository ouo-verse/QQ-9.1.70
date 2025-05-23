package f61;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.oidb_0x1250.oidb_0x1250$Guide;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 \u00072\u00020\u0001:\u0001\u0005B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lf61/d;", "", "", "toString", "", "a", "J", "d", "()J", "id", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "icon", "desc", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String icon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String desc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lf61/d$a;", "", "Ltencent/im/oidb/oidb_0x1250/oidb_0x1250$Guide;", "guide", "Lf61/d;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: f61.d$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final d a(@NotNull oidb_0x1250$Guide guide) {
            long j3;
            String str;
            Intrinsics.checkNotNullParameter(guide, "guide");
            if (guide.f436012id.has()) {
                j3 = guide.f436012id.get();
            } else {
                j3 = 0;
            }
            String str2 = "";
            if (!guide.icon_url.has()) {
                str = "";
            } else {
                str = guide.icon_url.get();
            }
            Intrinsics.checkNotNullExpressionValue(str, "if (guide.icon_url.has()\u2026de.icon_url.get() else \"\"");
            if (guide.content.has()) {
                str2 = guide.content.get();
            }
            Intrinsics.checkNotNullExpressionValue(str2, "if (guide.content.has())\u2026ide.content.get() else \"\"");
            return new d(j3, str, str2);
        }

        Companion() {
        }
    }

    public d() {
        this(0L, null, null, 7, null);
    }

    @JvmStatic
    @NotNull
    public static final d a(@NotNull oidb_0x1250$Guide oidb_0x1250_guide) {
        return INSTANCE.a(oidb_0x1250_guide);
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: d, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    public String toString() {
        return "{id=" + this.id + ", icon=" + this.icon + ", desc=" + this.desc + "}";
    }

    public d(long j3, @NotNull String icon, @NotNull String desc) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.id = j3;
        this.icon = icon;
        this.desc = desc;
    }

    public /* synthetic */ d(long j3, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2);
    }
}
