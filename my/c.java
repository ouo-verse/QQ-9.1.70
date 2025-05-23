package my;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.api.IPublicAccountReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.report.DTChatsReportManager;
import com.tencent.qqnt.chats.core.ui.listener.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0016R\"\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lmy/c;", "Lcom/tencent/qqnt/chats/core/ui/listener/a;", "", "e", "a", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "b", "newState", "d", "Lmqq/util/WeakReference;", "Lcom/tencent/qqnt/chats/core/report/DTChatsReportManager$b;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "listProviderRef", "listProvider", "<init>", "(Lcom/tencent/qqnt/chats/core/report/DTChatsReportManager$b;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
final class c implements com.tencent.qqnt.chats.core.ui.listener.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<DTChatsReportManager.b> listProviderRef;

    public c(@NotNull DTChatsReportManager.b listProvider) {
        Intrinsics.checkNotNullParameter(listProvider, "listProvider");
        this.listProviderRef = new WeakReference<>(listProvider);
    }

    private final void e() {
        Pair<Integer, Integer> c16;
        List<com.tencent.qqnt.chats.core.adapter.itemdata.b> b16;
        DTChatsReportManager.b bVar = this.listProviderRef.get();
        if (bVar == null || (c16 = bVar.c()) == null || (b16 = bVar.b(c16.getFirst().intValue(), c16.getSecond().intValue())) == null) {
            return;
        }
        for (com.tencent.qqnt.chats.core.adapter.itemdata.b bVar2 : b16) {
            if (bVar2 instanceof g) {
                g gVar = (g) bVar2;
                if (gVar.n() == 103) {
                    ((IPublicAccountReport) QRoute.api(IPublicAccountReport.class)).reportItemShowOnServiceFolder(gVar.s());
                }
            }
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.listener.a
    public void a() {
        e();
    }

    @Override // com.tencent.qqnt.chats.core.ui.listener.a
    public void b(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
    }

    @Override // com.tencent.qqnt.chats.core.ui.listener.a
    public void c() {
        a.C9588a.a(this);
    }

    @Override // com.tencent.qqnt.chats.core.ui.listener.a
    public void d(@NotNull RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (newState != 0) {
            return;
        }
        e();
    }
}
