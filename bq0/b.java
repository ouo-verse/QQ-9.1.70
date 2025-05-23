package bq0;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J2\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lbq0/b;", "Lbq0/f;", "", "position", "highLightStyleType", "Landroid/view/View;", "itemView", "", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "parserId", "Landroid/os/Bundle;", "extra", "b", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "mUIHelper", "<init>", "(Lcom/tencent/aio/api/list/IListUIOperationApi;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IListUIOperationApi mUIHelper;

    public b(@NotNull IListUIOperationApi mUIHelper) {
        Intrinsics.checkNotNullParameter(mUIHelper, "mUIHelper");
        this.mUIHelper = mUIHelper;
    }

    @Override // bq0.f
    public void a(int position, int highLightStyleType, @Nullable View itemView) {
        View view;
        View view2;
        if (itemView == null) {
            RecyclerView.ViewHolder G = this.mUIHelper.G(position);
            itemView = null;
            if (G != null) {
                view = G.itemView;
            } else {
                view = null;
            }
            if (view == null) {
                if (G != null) {
                    view2 = G.itemView;
                } else {
                    view2 = null;
                }
                QLog.i("HighLightViewHolderApiImpl", 1, "[highLightViewHolder] viewHolder:" + G + ", itemView:" + view2);
            }
            if (G != null) {
                itemView = G.itemView;
            }
        }
        if (itemView != null) {
            dq0.e.f394583a.b(highLightStyleType).a(itemView);
        }
    }

    @Override // bq0.f
    public void b(int position, @NotNull MsgRecord msgRecord, int parserId, @NotNull Bundle extra, @Nullable View itemView) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(extra, "extra");
        a(position, cq0.c.f391633a.b(parserId).a(msgRecord, extra), itemView);
    }
}
