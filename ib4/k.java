package ib4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u001d\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lib4/k;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lib4/l;", "", "position", "", "l0", "", "j0", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "o0", "holder", "m0", "getItemCount", "", "Lib4/i;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "getData", "()Ljava/util/List;", "data", "Lib4/a;", BdhLogUtil.LogTag.Tag_Conn, "Lib4/a;", "getListener", "()Lib4/a;", "listener", "<init>", "(Ljava/util/List;Lib4/a;)V", "D", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class k extends RecyclerView.Adapter<l> {

    /* renamed from: C, reason: from kotlin metadata */
    private final a listener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<ZplanPrivacyData> data;

    public k(List<ZplanPrivacyData> data, a listener) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.data = data;
        this.listener = listener;
    }

    private final void j0(int position) {
        int size = this.data.size();
        int i3 = 0;
        while (i3 < size) {
            this.data.get(i3).e(i3 == position);
            i3++;
        }
        notifyItemRangeChanged(0, this.data.size());
    }

    private final int k0() {
        for (ZplanPrivacyData zplanPrivacyData : this.data) {
            if (zplanPrivacyData.getIsChecked()) {
                return zplanPrivacyData.getShowType();
            }
        }
        return -1;
    }

    private final boolean l0(int position) {
        if (this.data.size() < position) {
            return false;
        }
        if (!this.data.get(position).getIsChecked()) {
            return true;
        }
        QLog.d("ZplanPrivacySettingAdapter", 1, "ignore click ");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(k this$0, int i3, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.l0(i3)) {
            this$0.j0(i3);
            a aVar = this$0.listener;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            aVar.a(it, this$0.k0());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(l holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (this.data.size() > position) {
            ZplanPrivacyData zplanPrivacyData = this.data.get(position);
            holder.getIconView().setImageResource(zplanPrivacyData.getIconResId());
            holder.getTextView().setText(zplanPrivacyData.getTextResId());
            holder.getOperateView().setVisibility(zplanPrivacyData.getIsChecked() ? 0 : 8);
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: ib4.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k.n0(k.this, position, view);
                }
            });
            return;
        }
        QLog.e("ZplanPrivacySettingAdapter", 1, "data is invalid");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public l onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dek, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new l(view);
    }
}
