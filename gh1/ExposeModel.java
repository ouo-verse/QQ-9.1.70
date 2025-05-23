package gh1;

import com.tencent.mobileqq.qqguildsdk.data.genc.ak;
import com.tencent.mobileqq.qqguildsdk.data.genc.cx;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u000bB\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0006\u0010\b\u001a\u00020\u0007J\t\u0010\n\u001a\u00020\tH\u00d6\u0001R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lgh1/c;", "", "other", "", "equals", "", "hashCode", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/ak;", "b", "", "toString", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "id", "getStateData", "stateData", "", "c", "[B", "getCbExtData", "()[B", "cbExtData", "<init>", "(Ljava/lang/String;Ljava/lang/String;[B)V", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: gh1.c, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class ExposeModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String stateData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final byte[] cbExtData;

    public ExposeModel(@NotNull String id5, @NotNull String stateData, @NotNull byte[] cbExtData) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(stateData, "stateData");
        Intrinsics.checkNotNullParameter(cbExtData, "cbExtData");
        this.id = id5;
        this.stateData = stateData;
        this.cbExtData = cbExtData;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final ak b() {
        ak akVar = new ak();
        akVar.d(this.id);
        akVar.c(new cx());
        akVar.a().d(this.stateData);
        akVar.a().c(this.cbExtData);
        return akVar;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(ExposeModel.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.guild.discovery.expose.ExposeModel");
        ExposeModel exposeModel = (ExposeModel) other;
        if (Intrinsics.areEqual(this.id, exposeModel.id) && Intrinsics.areEqual(this.stateData, exposeModel.stateData) && Arrays.equals(this.cbExtData, exposeModel.cbExtData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.stateData.hashCode()) * 31) + Arrays.hashCode(this.cbExtData);
    }

    @NotNull
    public String toString() {
        return "ExposeModel(id=" + this.id + ", stateData=" + this.stateData + ", cbExtData=" + Arrays.toString(this.cbExtData) + ")";
    }
}
