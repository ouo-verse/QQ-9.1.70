package d00;

import com.tencent.biz.pubaccount.weishi.main.WSVideoPageChangeObserver;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007\u00a8\u0006\f"}, d2 = {"Ld00/e;", "", "", "contextFeedId", "", "isContextFeedShowMusk", "Lcom/tencent/biz/pubaccount/weishi/main/WSVideoPageChangeObserver;", "observer", "Ld00/a;", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f392595a = new e();

    e() {
    }

    @JvmStatic
    public static final a a(String contextFeedId, boolean isContextFeedShowMusk, WSVideoPageChangeObserver observer) {
        a cVar;
        Intrinsics.checkNotNullParameter(contextFeedId, "contextFeedId");
        if (com.tencent.biz.pubaccount.weishi.home.c.j()) {
            return new b(observer);
        }
        if (com.tencent.biz.pubaccount.weishi.home.c.m()) {
            cVar = new d(contextFeedId, isContextFeedShowMusk);
        } else {
            cVar = new c(contextFeedId, isContextFeedShowMusk);
        }
        return cVar;
    }
}
