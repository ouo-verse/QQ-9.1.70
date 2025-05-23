package dc4;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.sqshow.zootopia.data.s;
import com.tencent.sqshow.zootopia.data.t;
import com.tencent.sqshow.zootopia.data.y;
import kotlin.Metadata;
import xv4.r;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u0016\u0010\n\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H&J\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u0004H&J\u0016\u0010\u000f\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u0004H&J&\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u0004H&J\u0016\u0010\u0013\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004H&J\u001e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004H&J\u0016\u0010\u0017\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004H&\u00a8\u0006\u0018"}, d2 = {"Ldc4/a;", "", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/y;", "callback", "", "d", "Lcom/tencent/sqshow/zootopia/data/s;", tl.h.F, "", "index", "Lcom/tencent/sqshow/zootopia/data/t;", "f", "a", "questId", "c", "Lxv4/c;", "g", "Lxv4/r;", "i", "Lxv4/t;", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public interface a {
    void a(com.tencent.mobileqq.zootopia.api.e<t> callback);

    void b(com.tencent.mobileqq.zootopia.api.e<xv4.t> callback);

    void c(long taskId, long questId, com.tencent.mobileqq.zootopia.api.e<t> callback);

    void d(long taskId, com.tencent.mobileqq.zootopia.api.e<y> callback);

    void f(int index, com.tencent.mobileqq.zootopia.api.e<t> callback);

    void g(com.tencent.mobileqq.zootopia.api.e<xv4.c> callback);

    void h(com.tencent.mobileqq.zootopia.api.e<s> callback);

    void i(long taskId, com.tencent.mobileqq.zootopia.api.e<r> callback);
}
