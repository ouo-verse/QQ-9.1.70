package e10;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0014J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014\u00a8\u0006\f"}, d2 = {"Le10/d;", "Le10/c;", "", "E1", "Q0", "P0", "O0", "", "F0", "subTabId", "<init>", "(Ljava/lang/String;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends c {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String subTabId) {
        super(subTabId);
        Intrinsics.checkNotNullParameter(subTabId, "subTabId");
    }

    private final boolean E1() {
        return Intrinsics.areEqual(uy.b.f440579a.a(), "monofeed_tab");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e10.a
    public String F0() {
        if (com.tencent.biz.pubaccount.weishi.home.e.m()) {
            return super.F0();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e10.c, e10.a
    public boolean O0() {
        if (E1()) {
            return true;
        }
        return super.O0();
    }

    @Override // e10.a
    protected boolean P0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e10.a
    public boolean Q0() {
        if (com.tencent.biz.pubaccount.weishi.home.e.m()) {
            return super.Q0();
        }
        return false;
    }
}
