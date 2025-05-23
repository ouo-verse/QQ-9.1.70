package dc4;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskBlindBoxData;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskCommonRewardData;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskSystemMainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xv4.r;
import xv4.t;
import yb4.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\u0004\b!\u0010\"J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0016\u0010\u000b\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u0016J\u001e\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005H\u0016J\u0016\u0010\u0010\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005H\u0016J&\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005H\u0016J\u0016\u0010\u0014\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005H\u0016J\u001e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005H\u0016J\u0016\u0010\u0018\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005H\u0016R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001f\u00a8\u0006#"}, d2 = {"Ldc4/b;", "Lcom/tencent/mobileqq/mvvm/a;", "Ldc4/a;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/y;", "callback", "", "d", "Lcom/tencent/sqshow/zootopia/data/s;", tl.h.F, "", "index", "Lcom/tencent/sqshow/zootopia/data/t;", "f", "a", "questId", "c", "Lxv4/c;", "g", "Lxv4/r;", "i", "Lxv4/t;", "b", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lyb4/l;", "Lyb4/l;", "service", "<init>", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends com.tencent.mobileqq.mvvm.a implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final l service;

    public b(ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.service = new l(ZootopiaSource.INSTANCE.j(source));
    }

    @Override // dc4.a
    public void a(com.tencent.mobileqq.zootopia.api.e<ZootopiaTaskCommonRewardData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.g(callback);
    }

    @Override // dc4.a
    public void b(com.tencent.mobileqq.zootopia.api.e<t> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.l(callback);
    }

    @Override // dc4.a
    public void c(long taskId, long questId, com.tencent.mobileqq.zootopia.api.e<ZootopiaTaskCommonRewardData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.i(taskId, questId, callback);
    }

    @Override // dc4.a
    public void d(long taskId, com.tencent.mobileqq.zootopia.api.e<ZootopiaTaskSystemMainData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.m(taskId, callback);
    }

    @Override // dc4.a
    public void f(int index, com.tencent.mobileqq.zootopia.api.e<ZootopiaTaskCommonRewardData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.h(index, callback);
    }

    @Override // dc4.a
    public void g(com.tencent.mobileqq.zootopia.api.e<xv4.c> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.e(callback);
    }

    @Override // dc4.a
    public void h(com.tencent.mobileqq.zootopia.api.e<ZootopiaTaskBlindBoxData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.j(callback);
    }

    @Override // dc4.a
    public void i(long taskId, com.tencent.mobileqq.zootopia.api.e<r> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.k(taskId, callback);
    }
}
