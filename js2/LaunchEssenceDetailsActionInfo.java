package js2;

import com.tencent.qqnt.graytips.action.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ljs2/b;", "Lcom/tencent/qqnt/graytips/action/f;", "", "getActionType", "", "toString", "", "a", "J", "()J", "troopUin", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "url", "<init>", "(JLjava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: js2.b, reason: from toString */
/* loaded from: classes38.dex */
public final class LaunchEssenceDetailsActionInfo implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String url;

    public LaunchEssenceDetailsActionInfo(long j3, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.troopUin = j3;
        this.url = url;
    }

    /* renamed from: a, reason: from getter */
    public final long getTroopUin() {
        return this.troopUin;
    }

    /* renamed from: b, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Override // com.tencent.qqnt.graytips.action.f
    public int getActionType() {
        return 95;
    }

    public String toString() {
        return "LaunchEssenceDetailsActionInfo(troopUin: " + this.troopUin + ", url: " + this.url + ", )";
    }
}
