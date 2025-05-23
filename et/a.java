package et;

import android.view.ViewGroup;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\bH&J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H&J\u001a\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00110\u0010H&J\u001a\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00110\u0010H&\u00a8\u0006\u0014"}, d2 = {"Let/a;", "", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/holder/a;", "vh", "", "position", "Lcom/tencent/aio/data/msglist/a;", "data", "", "payloads", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "R0", "", "Lkotlin/Pair;", "e", h.F, "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface a {
    @NotNull
    com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a R0(@NotNull ViewGroup parent, int viewType);

    @NotNull
    List<Pair<Integer, Integer>> e();

    @NotNull
    List<Pair<Integer, Integer>> h();

    void o(@NotNull com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a vh5, int position, @NotNull com.tencent.aio.data.msglist.a data, @NotNull List<Object> payloads);
}
