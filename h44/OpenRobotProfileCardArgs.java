package h44;

import android.content.Context;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0016\u001a\u0004\b\u0013\u0010\u0018R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\n\u0010\u001d\u00a8\u0006!"}, d2 = {"Lh44/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/content/Context;", "a", "Landroid/content/Context;", "b", "()Landroid/content/Context;", "context", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "robotUin", "c", "f", "troopUin", "I", "e", "()I", "source", "exposureId", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;IILandroid/os/Bundle;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: h44.a, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class OpenRobotProfileCardArgs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String robotUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String troopUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int source;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int exposureId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Bundle bundle;

    public OpenRobotProfileCardArgs(@NotNull Context context, @NotNull String robotUin, @Nullable String str, int i3, int i16, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        this.context = context;
        this.robotUin = robotUin;
        this.troopUin = str;
        this.source = i3;
        this.exposureId = i16;
        this.bundle = bundle;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Bundle getBundle() {
        return this.bundle;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* renamed from: c, reason: from getter */
    public final int getExposureId() {
        return this.exposureId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getRobotUin() {
        return this.robotUin;
    }

    /* renamed from: e, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenRobotProfileCardArgs)) {
            return false;
        }
        OpenRobotProfileCardArgs openRobotProfileCardArgs = (OpenRobotProfileCardArgs) other;
        if (Intrinsics.areEqual(this.context, openRobotProfileCardArgs.context) && Intrinsics.areEqual(this.robotUin, openRobotProfileCardArgs.robotUin) && Intrinsics.areEqual(this.troopUin, openRobotProfileCardArgs.troopUin) && this.source == openRobotProfileCardArgs.source && this.exposureId == openRobotProfileCardArgs.exposureId && Intrinsics.areEqual(this.bundle, openRobotProfileCardArgs.bundle)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.context.hashCode() * 31) + this.robotUin.hashCode()) * 31;
        String str = this.troopUin;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (((((hashCode2 + hashCode) * 31) + this.source) * 31) + this.exposureId) * 31;
        Bundle bundle = this.bundle;
        if (bundle != null) {
            i3 = bundle.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "OpenRobotProfileCardArgs(context=" + this.context + ", robotUin=" + this.robotUin + ", troopUin=" + this.troopUin + ", source=" + this.source + ", exposureId=" + this.exposureId + ", bundle=" + this.bundle + ")";
    }

    public /* synthetic */ OpenRobotProfileCardArgs(Context context, String str, String str2, int i3, int i16, Bundle bundle, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i17 & 4) != 0 ? "" : str2, (i17 & 8) != 0 ? 0 : i3, (i17 & 16) != 0 ? 0 : i16, (i17 & 32) != 0 ? null : bundle);
    }
}
