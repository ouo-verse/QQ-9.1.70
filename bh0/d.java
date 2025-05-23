package bh0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import com.tencent.ecommerce.base.ui.ECBasePtsView;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJu\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062S\u0010\u0011\u001aO\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bj\u0004\u0018\u0001`\u0010H\u0016J*\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&\u00a8\u0006\u001e"}, d2 = {"Lbh0/d;", "Landroidx/lifecycle/ViewModel;", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "position", "itemViewType", "", "Lcom/tencent/ecommerce/base/ui/component/ECRecyclerViewItemClick;", "onItemClickListener", "Lbh0/c;", "M1", "holder", "Lcom/tencent/ecommerce/base/ui/b;", "ptsViewData", "L1", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "N1", "<init>", "()V", "i", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes39.dex */
public abstract class d extends ViewModel {
    public void L1(Context context, c holder, ECBasePtsViewData ptsViewData, int viewType) {
        PTSComposer ptsComposer;
        View view = holder.itemView;
        if (!(view instanceof ECBasePtsView) || ptsViewData == null || (ptsComposer = ptsViewData.getPtsComposer()) == null) {
            return;
        }
        ((ECBasePtsView) view).b(ptsComposer, N1(ptsViewData));
    }

    public c M1(Context context, ViewGroup parent, int viewType, Function3<? super View, ? super Integer, ? super Integer, Unit> onItemClickListener) {
        return new c(new ECBasePtsView(context), viewType, onItemClickListener);
    }

    public abstract IPTSLiteEventListener N1(ECBasePtsViewData ptsViewData);
}
