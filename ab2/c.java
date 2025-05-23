package ab2;

import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rp4.g;
import xp4.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\t\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\f\u001a\u00020\b*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0012\u0010\u000f\u001a\u00020\b*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\n\u0010\u0010\u001a\u00020\b*\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\bJ\f\u0010\u0012\u001a\u0004\u0018\u00010\u0003*\u00020\u0002R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lab2/c;", "", "Lcom/tencent/mobileqq/nearbypro/api/map/SelfUserInfo;", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "latLng", "", "locationAddress", "locationName", "", "d", "Lsp4/c;", QCircleAlphaUserReporter.KEY_USER, "e", "Lxp4/h;", "person", "f", "c", "b", "a", "Lab2/c$a;", "Lab2/c$a;", "offsetRandom", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f25771a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final OffsetRandom offsetRandom = new OffsetRandom(0.0d, 0.0d, 3, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lab2/c$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "D", "()D", "c", "(D)V", "offsetLat", "b", "d", "offsetLng", "<init>", "(DD)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ab2.c$a, reason: from toString */
    /* loaded from: classes15.dex */
    public static final /* data */ class OffsetRandom {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private double offsetLat;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private double offsetLng;

        public OffsetRandom() {
            this(0.0d, 0.0d, 3, null);
        }

        /* renamed from: a, reason: from getter */
        public final double getOffsetLat() {
            return this.offsetLat;
        }

        /* renamed from: b, reason: from getter */
        public final double getOffsetLng() {
            return this.offsetLng;
        }

        public final void c(double d16) {
            this.offsetLat = d16;
        }

        public final void d(double d16) {
            this.offsetLng = d16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OffsetRandom)) {
                return false;
            }
            OffsetRandom offsetRandom = (OffsetRandom) other;
            if (Double.compare(this.offsetLat, offsetRandom.offsetLat) == 0 && Double.compare(this.offsetLng, offsetRandom.offsetLng) == 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (com.tencent.biz.qqcircle.comment.recpic.a.a(this.offsetLat) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.offsetLng);
        }

        @NotNull
        public String toString() {
            return "OffsetRandom(offsetLat=" + this.offsetLat + ", offsetLng=" + this.offsetLng + ")";
        }

        public OffsetRandom(double d16, double d17) {
            this.offsetLat = d16;
            this.offsetLng = d17;
        }

        public /* synthetic */ OffsetRandom(double d16, double d17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0.0d : d16, (i3 & 2) != 0 ? 0.0d : d17);
        }
    }

    c() {
    }

    @Nullable
    public final LatLng a(@NotNull SelfUserInfo selfUserInfo) {
        Intrinsics.checkNotNullParameter(selfUserInfo, "<this>");
        LatLng latLng = selfUserInfo.getLatLng();
        if (latLng != null) {
            OffsetRandom offsetRandom2 = offsetRandom;
            return new LatLng(offsetRandom2.getOffsetLat() + latLng.latitude, offsetRandom2.getOffsetLng() + latLng.longitude);
        }
        return null;
    }

    public final void b() {
        LatLng y16 = a.f25767a.y(new Pair<>(1000, 1500), 0.0d, 0.0d);
        OffsetRandom offsetRandom2 = offsetRandom;
        offsetRandom2.c(y16.latitude);
        offsetRandom2.d(y16.longitude);
    }

    public final void c(@NotNull SelfUserInfo selfUserInfo) {
        Intrinsics.checkNotNullParameter(selfUserInfo, "<this>");
        b.f25770a.b(selfUserInfo);
    }

    public final void d(@NotNull SelfUserInfo selfUserInfo, @NotNull LatLng latLng, @NotNull String locationAddress, @NotNull String locationName) {
        Intrinsics.checkNotNullParameter(selfUserInfo, "<this>");
        Intrinsics.checkNotNullParameter(latLng, "latLng");
        Intrinsics.checkNotNullParameter(locationAddress, "locationAddress");
        Intrinsics.checkNotNullParameter(locationName, "locationName");
        boolean u16 = selfUserInfo.u(latLng);
        boolean v3 = selfUserInfo.v(locationAddress);
        selfUserInfo.w(locationName);
        if (u16 || v3) {
            c(selfUserInfo);
        }
    }

    public final void e(@NotNull SelfUserInfo selfUserInfo, @NotNull sp4.c user) {
        String str;
        sp4.a aVar;
        sp4.b bVar;
        boolean z16;
        Intrinsics.checkNotNullParameter(selfUserInfo, "<this>");
        Intrinsics.checkNotNullParameter(user, "user");
        boolean z17 = selfUserInfo.z(user.f434140a);
        String str2 = user.f434145f;
        Intrinsics.checkNotNullExpressionValue(str2, "user.avatar");
        boolean r16 = selfUserInfo.r(str2);
        boolean t16 = selfUserInfo.t(user.f434144e);
        String str3 = user.f434143d;
        Intrinsics.checkNotNullExpressionValue(str3, "user.nick");
        boolean x16 = selfUserInfo.x(str3);
        sp4.a[] aVarArr = user.f434142c;
        Intrinsics.checkNotNullExpressionValue(aVarArr, "user.dresses");
        int length = aVarArr.length;
        int i3 = 0;
        while (true) {
            str = null;
            if (i3 < length) {
                aVar = aVarArr[i3];
                if (aVar.f434131a == 1001) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                } else {
                    i3++;
                }
            } else {
                aVar = null;
                break;
            }
        }
        if (aVar != null && (bVar = aVar.f434133c) != null) {
            str = bVar.f434137d;
        }
        if (str == null) {
            str = "";
        }
        boolean s16 = selfUserInfo.s(str);
        if (z17 || r16 || t16 || x16 || s16) {
            c(selfUserInfo);
        }
    }

    public final void f(@NotNull SelfUserInfo selfUserInfo, @NotNull h person) {
        Intrinsics.checkNotNullParameter(selfUserInfo, "<this>");
        Intrinsics.checkNotNullParameter(person, "person");
        g gVar = person.f448329e;
        if (gVar != null) {
            Intrinsics.checkNotNullExpressionValue(gVar, "person.statusInfo");
            selfUserInfo.y(gVar);
        }
    }
}
