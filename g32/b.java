package g32;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000b\"\u0004\b\t\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lg32/b;", "", "", "a", "J", "getCreateTime", "()J", WadlProxyConsts.CREATE_TIME, "Lg32/l;", "b", "Lg32/l;", "()Lg32/l;", "(Lg32/l;)V", "tag", "<init>", "()V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long createTime = System.currentTimeMillis();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private l tag;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final l getTag() {
        return this.tag;
    }

    public final void b(@Nullable l lVar) {
        this.tag = lVar;
    }
}
