package k92;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lk92/a;", "Lcom/tencent/qqnt/graytips/action/f;", "", "getActionType", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "friendUin", "<init>", "(Ljava/lang/String;)V", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements com.tencent.qqnt.graytips.action.f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String friendUin;

    public a(String friendUin) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        this.friendUin = friendUin;
    }

    /* renamed from: a, reason: from getter */
    public final String getFriendUin() {
        return this.friendUin;
    }

    @Override // com.tencent.qqnt.graytips.action.f
    public int getActionType() {
        return 92;
    }
}
