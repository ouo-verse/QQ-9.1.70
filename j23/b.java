package j23;

import com.tencent.mobileqq.vas.pay.page.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\u0006H\u0016R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lj23/b;", "", "", "d", "b", "c", "", "e", "a", "toString", "Ldu4/c;", "Ldu4/c;", "monthInfo", "<init>", "(Ldu4/c;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final du4.c monthInfo;

    public b(@NotNull du4.c monthInfo) {
        Intrinsics.checkNotNullParameter(monthInfo, "monthInfo");
        this.monthInfo = monthInfo;
    }

    @NotNull
    public final String a() {
        if (this.monthInfo.f394938e == 1) {
            return j.INSTANCE.a();
        }
        return "";
    }

    public final int b() {
        return this.monthInfo.f394945l;
    }

    public final int c() {
        return this.monthInfo.f394942i;
    }

    public final int d() {
        du4.c cVar = this.monthInfo;
        return cVar.f394945l - cVar.f394942i;
    }

    @NotNull
    public final String e() {
        return j.INSTANCE.l();
    }

    @NotNull
    public String toString() {
        du4.c cVar = this.monthInfo;
        return "monthInfo: " + cVar.f394953t + " " + cVar.f394940g + " " + cVar.f394939f;
    }
}
