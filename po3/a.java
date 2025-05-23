package po3;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0016\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR(\u0010\u0015\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014R(\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0011\u0010\u001b\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0014R\u0011\u0010\u001c\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lpo3/a;", "", "", "a", h.F, "Le55/c;", "Le55/c;", "leftAnchor", "b", "rightAnchor", "", "c", "J", "leftScore", "d", "rightScore", "", "<set-?>", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "leftScoreText", "f", "g", "rightScoreText", "leftAnchorHeadUrl", "rightAnchorHeadUrl", "leftAnchorNick", "rightAnchorNick", "<init>", "()V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public e55.c leftAnchor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public e55.c rightAnchor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long leftScore;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long rightScore;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String leftScoreText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String rightScoreText;

    public final void a() {
        this.leftScoreText = String.valueOf(this.leftScore);
        this.rightScoreText = String.valueOf(this.rightScore);
    }

    @NotNull
    public final String b() {
        e55.c cVar = this.leftAnchor;
        if (cVar != null) {
            Intrinsics.checkNotNull(cVar);
            if (cVar.f395738d != null) {
                e55.c cVar2 = this.leftAnchor;
                Intrinsics.checkNotNull(cVar2);
                String str = cVar2.f395738d;
                Intrinsics.checkNotNullExpressionValue(str, "leftAnchor!!.logo");
                return str;
            }
        }
        return "";
    }

    @NotNull
    public final String c() {
        e55.c cVar = this.leftAnchor;
        if (cVar != null) {
            Intrinsics.checkNotNull(cVar);
            if (cVar.f395737c != null) {
                e55.c cVar2 = this.leftAnchor;
                Intrinsics.checkNotNull(cVar2);
                String str = cVar2.f395737c;
                Intrinsics.checkNotNullExpressionValue(str, "leftAnchor!!.nick");
                return str;
            }
        }
        return "";
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getLeftScoreText() {
        return this.leftScoreText;
    }

    @NotNull
    public final String e() {
        e55.c cVar = this.rightAnchor;
        if (cVar != null) {
            Intrinsics.checkNotNull(cVar);
            if (cVar.f395738d != null) {
                e55.c cVar2 = this.rightAnchor;
                Intrinsics.checkNotNull(cVar2);
                String str = cVar2.f395738d;
                Intrinsics.checkNotNullExpressionValue(str, "rightAnchor!!.logo");
                return str;
            }
        }
        return "";
    }

    @NotNull
    public final String f() {
        e55.c cVar = this.rightAnchor;
        if (cVar != null) {
            Intrinsics.checkNotNull(cVar);
            if (cVar.f395737c != null) {
                e55.c cVar2 = this.rightAnchor;
                Intrinsics.checkNotNull(cVar2);
                String str = cVar2.f395737c;
                Intrinsics.checkNotNullExpressionValue(str, "rightAnchor!!.nick");
                return str;
            }
        }
        return "";
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getRightScoreText() {
        return this.rightScoreText;
    }

    public final void h() {
        this.leftScore = 0L;
        this.rightScore = 0L;
        a();
    }
}
