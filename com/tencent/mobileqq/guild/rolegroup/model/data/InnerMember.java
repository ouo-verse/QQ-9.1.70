package com.tencent.mobileqq.guild.rolegroup.model.data;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u0000 \u00132\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/data/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getTinyId", "()Ljava/lang/String;", "tinyId", "b", "getName", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.rolegroup.model.data.e, reason: from toString */
/* loaded from: classes14.dex */
final /* data */ class InnerMember {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tinyId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/data/e$a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/mobileqq/guild/rolegroup/model/data/e;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.model.data.e$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final InnerMember a(@NotNull IGProUserInfo user) {
            Intrinsics.checkNotNullParameter(user, "user");
            String tinyId = user.getTinyId();
            Intrinsics.checkNotNullExpressionValue(tinyId, "user.tinyId");
            String displayName = user.getDisplayName();
            Intrinsics.checkNotNullExpressionValue(displayName, "user.displayName");
            return new InnerMember(tinyId, displayName);
        }

        Companion() {
        }
    }

    public InnerMember(@NotNull String tinyId, @NotNull String name) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(name, "name");
        this.tinyId = tinyId;
        this.name = name;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InnerMember)) {
            return false;
        }
        InnerMember innerMember = (InnerMember) other;
        if (Intrinsics.areEqual(this.tinyId, innerMember.tinyId) && Intrinsics.areEqual(this.name, innerMember.name)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.tinyId.hashCode() * 31) + this.name.hashCode();
    }

    @NotNull
    public String toString() {
        return "InnerMember(tinyId=" + this.tinyId + ", name=" + this.name + ")";
    }
}
