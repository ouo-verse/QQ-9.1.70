package j23;

import android.text.TextUtils;
import com.tencent.mobileqq.vas.pay.page.j;
import com.tencent.mobileqq.vas.pay.page.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016R\u0014\u0010\u0017\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001d\u00a8\u0006 "}, d2 = {"Lj23/a;", "Lh23/c;", "", "v", "def", "f", h.F, "g", "", "j", "", "selected", "", "setSelected", "isSelected", "b", "a", "d", "getOriginalPrice", "e", "c", "toString", "I", com.tencent.luggage.wxa.c8.c.G, "Ldu4/c;", "Ldu4/c;", "i", "()Ldu4/c;", "monthInfo", "Z", "<init>", "(ILdu4/c;Z)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a implements h23.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int pos;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final du4.c monthInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isSelected;

    public a(int i3, @NotNull du4.c monthInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(monthInfo, "monthInfo");
        this.pos = i3;
        this.monthInfo = monthInfo;
        this.isSelected = z16;
    }

    private final String f(String v3, String def) {
        if (TextUtils.isEmpty(v3)) {
            return def;
        }
        return v3;
    }

    @Override // h23.c
    @NotNull
    public String a() {
        String str = this.monthInfo.f394940g;
        Intrinsics.checkNotNullExpressionValue(str, "monthInfo.title");
        return str;
    }

    @Override // h23.c
    @NotNull
    public String b() {
        String str = this.monthInfo.f394947n;
        Intrinsics.checkNotNullExpressionValue(str, "monthInfo.tipText");
        return str;
    }

    @Override // h23.c
    public int c() {
        return this.monthInfo.f394941h;
    }

    @Override // h23.c
    @NotNull
    public String d() {
        int i3 = this.monthInfo.f394942i;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        return sb5.toString();
    }

    @Override // h23.c
    @NotNull
    public String e() {
        if (this.isSelected) {
            String str = this.monthInfo.f394949p;
            Intrinsics.checkNotNullExpressionValue(str, "monthInfo.activeImg");
            return f(str, j.INSTANCE.d());
        }
        if (o.n()) {
            String str2 = this.monthInfo.f394951r;
            Intrinsics.checkNotNullExpressionValue(str2, "monthInfo.blackInactiveImg");
            return f(str2, j.INSTANCE.c());
        }
        String str3 = this.monthInfo.f394950q;
        Intrinsics.checkNotNullExpressionValue(str3, "monthInfo.inactiveImg");
        return f(str3, j.INSTANCE.b());
    }

    @NotNull
    public final String g() {
        String str;
        du4.b bVar = this.monthInfo.f394935b;
        if (bVar != null) {
            str = bVar.f394931c;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // h23.c
    @NotNull
    public String getOriginalPrice() {
        return "\u539f\u4ef7\uffe5" + this.monthInfo.f394945l;
    }

    @NotNull
    public final String h() {
        String str = this.monthInfo.f394943j;
        Intrinsics.checkNotNullExpressionValue(str, "monthInfo.text");
        return str;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final du4.c getMonthInfo() {
        return this.monthInfo;
    }

    @Override // h23.c
    /* renamed from: isSelected, reason: from getter */
    public boolean getIsSelected() {
        return this.isSelected;
    }

    /* renamed from: j, reason: from getter */
    public int getPos() {
        return this.pos;
    }

    @Override // h23.c
    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    @NotNull
    public String toString() {
        int i3 = this.pos;
        du4.c cVar = this.monthInfo;
        return "pos:" + i3 + " index:" + cVar.f394939f + " title:" + cVar.f394940g + " payAid:" + cVar.f394953t;
    }

    public /* synthetic */ a(int i3, du4.c cVar, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1 : i3, cVar, (i16 & 4) != 0 ? false : z16);
    }
}
