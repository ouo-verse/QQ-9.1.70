package i23;

import android.text.TextUtils;
import com.tencent.mobileqq.vas.pay.page.j;
import com.tencent.mobileqq.vas.pay.page.o;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$MonthInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016R\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Li23/b;", "Lh23/c;", "", "v", "def", "f", "", h.F, "", "selected", "", "setSelected", "isSelected", "b", "a", "d", "getOriginalPrice", "e", "c", "toString", "I", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/trpcprotocol/qqva/experience_svip_server/experience_svip_server/ExperienceSvipServerPB$MonthInfo;", "Lcom/tencent/trpcprotocol/qqva/experience_svip_server/experience_svip_server/ExperienceSvipServerPB$MonthInfo;", "g", "()Lcom/tencent/trpcprotocol/qqva/experience_svip_server/experience_svip_server/ExperienceSvipServerPB$MonthInfo;", "monthInfo", "Z", "<init>", "(ILcom/tencent/trpcprotocol/qqva/experience_svip_server/experience_svip_server/ExperienceSvipServerPB$MonthInfo;Z)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b implements h23.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int pos;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ExperienceSvipServerPB$MonthInfo monthInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isSelected;

    public b(int i3, @NotNull ExperienceSvipServerPB$MonthInfo monthInfo, boolean z16) {
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
        String str = this.monthInfo.title.get();
        Intrinsics.checkNotNullExpressionValue(str, "monthInfo.title.get()");
        return str;
    }

    @Override // h23.c
    @NotNull
    public String b() {
        String str = this.monthInfo.tip_text.get();
        Intrinsics.checkNotNullExpressionValue(str, "monthInfo.tip_text.get()");
        return str;
    }

    @Override // h23.c
    public int c() {
        return this.monthInfo.month.get();
    }

    @Override // h23.c
    @NotNull
    public String d() {
        int i3 = this.monthInfo.price.get();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        return sb5.toString();
    }

    @Override // h23.c
    @NotNull
    public String e() {
        if (this.isSelected) {
            String str = this.monthInfo.active_img.get();
            Intrinsics.checkNotNullExpressionValue(str, "monthInfo.active_img.get()");
            return f(str, j.INSTANCE.d());
        }
        if (o.n()) {
            String str2 = this.monthInfo.black_inactive_img.get();
            Intrinsics.checkNotNullExpressionValue(str2, "monthInfo.black_inactive_img.get()");
            return f(str2, j.INSTANCE.c());
        }
        String str3 = this.monthInfo.inactive_img.get();
        Intrinsics.checkNotNullExpressionValue(str3, "monthInfo.inactive_img.get()");
        return f(str3, j.INSTANCE.b());
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final ExperienceSvipServerPB$MonthInfo getMonthInfo() {
        return this.monthInfo;
    }

    @Override // h23.c
    @NotNull
    public String getOriginalPrice() {
        return "\u539f\u4ef7\uffe5" + this.monthInfo.ori_price.get();
    }

    /* renamed from: h, reason: from getter */
    public int getPos() {
        return this.pos;
    }

    @Override // h23.c
    /* renamed from: isSelected, reason: from getter */
    public boolean getIsSelected() {
        return this.isSelected;
    }

    @Override // h23.c
    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    @NotNull
    public String toString() {
        return "pos:" + this.pos + " index:" + this.monthInfo.index.get() + " title:" + this.monthInfo.title.get() + " payAid:" + this.monthInfo.pay_aid.get();
    }

    public /* synthetic */ b(int i3, ExperienceSvipServerPB$MonthInfo experienceSvipServerPB$MonthInfo, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1 : i3, experienceSvipServerPB$MonthInfo, (i16 & 4) != 0 ? false : z16);
    }
}
