package gb2;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rp4.g;
import xp4.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lgb2/c;", "Lda2/b;", "", "b", "toString", "", "a", "", "other", "equals", "", "hashCode", "Lxp4/h;", "c", "Lxp4/h;", "d", "()Lxp4/h;", "setData", "(Lxp4/h;)V", "data", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", com.tencent.luggage.wxa.c8.c.G, "<init>", "(Lxp4/h;Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c extends da2.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private h data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull h data, @NotNull LatLng pos) {
        super(pos);
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(pos, "pos");
        this.data = data;
    }

    @Override // da2.b
    public boolean a() {
        if (ab2.a.f25767a.m() != this.data.f448325a) {
            return true;
        }
        return false;
    }

    @Override // da2.b
    @NotNull
    public String b() {
        return String.valueOf(this.data.f448325a);
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final h getData() {
        return this.data;
    }

    public boolean equals(@Nullable Object other) {
        Integer num;
        if (other != null && (other instanceof c)) {
            c cVar = (c) other;
            h hVar = cVar.data;
            long j3 = hVar.f448325a;
            h hVar2 = this.data;
            if (j3 == hVar2.f448325a && Intrinsics.areEqual(hVar.f448327c, hVar2.f448327c) && Intrinsics.areEqual(cVar.data.f448328d, this.data.f448328d)) {
                g gVar = cVar.data.f448329e;
                Integer num2 = null;
                if (gVar != null) {
                    num = Integer.valueOf(gVar.f431878a);
                } else {
                    num = null;
                }
                g gVar2 = this.data.f448329e;
                if (gVar2 != null) {
                    num2 = Integer.valueOf(gVar2.f431878a);
                }
                if (Intrinsics.areEqual(num, num2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (int) this.data.f448325a;
    }

    @Override // da2.b
    @NotNull
    public String toString() {
        return "uin:" + this.data.f448325a + " + super.toString()";
    }
}
