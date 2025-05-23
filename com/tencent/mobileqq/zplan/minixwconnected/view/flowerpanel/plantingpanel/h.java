package com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplan.scene.xwconnect.data.CoinType;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerStatus;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController;
import com.tencent.mobileqq.zplan.minixwconnected.report.ZPlanMiniHomeConnectReporter;
import com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanelViewModel;
import com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.h;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import fi3.bg;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.json.JSONObject;
import t74.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001f B+\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0015\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\n\u001a\u00020\tJ\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0006H\u0016R\u001f\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/h;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$b;", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/h$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "", "m0", "holder", "position", "j0", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lmqq/util/WeakReference;", "getController", "()Lmqq/util/WeakReference;", "controller", "Lkotlin/Function1;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "onSelect", "D", "Ljava/lang/Integer;", "currentSelect", "<init>", "(Lmqq/util/WeakReference;Lkotlin/jvm/functions/Function1;)V", "E", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h extends ListAdapter<MiniHomeFlowerPlantingPanelViewModel.FlowerData, b> {

    /* renamed from: C, reason: from kotlin metadata */
    private final Function1<MiniHomeFlowerPlantingPanelViewModel.FlowerData, Unit> onSelect;

    /* renamed from: D, reason: from kotlin metadata */
    private Integer currentSelect;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<MiniHomeConnectedController> controller;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h(WeakReference<MiniHomeConnectedController> weakReference, Function1<? super MiniHomeFlowerPlantingPanelViewModel.FlowerData, Unit> onSelect) {
        super(new j());
        Intrinsics.checkNotNullParameter(onSelect, "onSelect");
        this.controller = weakReference;
        this.onSelect = onSelect;
        this.currentSelect = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(b this_apply, h this$0, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int adapterPosition = this_apply.getAdapterPosition();
        boolean z16 = false;
        if (adapterPosition >= 0 && adapterPosition < this$0.getNUM_BACKGOURND_ICON()) {
            z16 = true;
        }
        MiniHomeFlowerPlantingPanelViewModel.FlowerData item = z16 ? this$0.getItem(adapterPosition) : null;
        if (item != null) {
            this$0.onSelect.invoke(item);
            this$0.notifyDataSetChanged();
            this$0.currentSelect = Integer.valueOf(adapterPosition);
            this_apply.n("dt_clck", item);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MiniHomeFlowerPlantingPanelViewModel.FlowerData item = getItem(position);
        if (item == null) {
            return;
        }
        holder.l(item);
        View view = holder.getBinding().f399087e;
        Integer num = this.currentSelect;
        view.setSelected(num != null && position == num.intValue());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        bg g16 = bg.g(LayoutInflater.from(parent.getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(parent.context))");
        final b bVar = new b(g16, this.controller);
        bVar.getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.l0(h.b.this, this, view);
            }
        });
        return bVar;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/h$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "textView", "", "resId", "", "o", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$b;", "data", "l", "", "eventType", DomainData.DOMAIN_NAME, "Lfi3/bg;", "E", "Lfi3/bg;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lfi3/bg;", "binding", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", UserInfo.SEX_FEMALE, "Lmqq/util/WeakReference;", "getController", "()Lmqq/util/WeakReference;", "controller", "<init>", "(Lfi3/bg;Lmqq/util/WeakReference;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final bg binding;

        /* renamed from: F, reason: from kotlin metadata */
        private final WeakReference<MiniHomeConnectedController> controller;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(bg binding, WeakReference<MiniHomeConnectedController> weakReference) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
            this.controller = weakReference;
            o(binding.f399085c, R.color.qui_common_text_primary);
            o(binding.f399090h, R.color.qui_common_text_primary);
        }

        public final void l(MiniHomeFlowerPlantingPanelViewModel.FlowerData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.binding.f399085c.setText(data.getFlowerName());
            this.binding.f399086d.setText(data.getFlowerSummary());
            this.binding.f399086d.setVisibility(0);
            this.binding.f399088f.setVisibility(8);
            if (i.a(data)) {
                this.binding.f399088f.setVisibility(0);
                this.binding.f399086d.setVisibility(8);
                this.binding.f399089g.setImageResource(data.getFlowerCoinType() == CoinType.GOLD ? R.drawable.ilx : R.drawable.f159901im2);
                this.binding.f399090h.setText(String.valueOf(data.getFlowerCost()));
            }
            if (data.getFlowerStatus() == FlowerStatus.Growing) {
                o(this.binding.f399086d, R.color.qui_common_brand_standard);
            } else {
                o(this.binding.f399086d, R.color.qui_common_text_secondary_light);
            }
            URLImageView uRLImageView = this.binding.f399084b;
            Intrinsics.checkNotNullExpressionValue(uRLImageView, "binding.flowerIcon");
            n.e(uRLImageView, data.getFlowerIcon(), R.drawable.gym, null, 4, null);
            n("dt_imp", data);
        }

        /* renamed from: m, reason: from getter */
        public final bg getBinding() {
            return this.binding;
        }

        public final void n(String eventType, MiniHomeFlowerPlantingPanelViewModel.FlowerData data) {
            MiniHomeConnectedController miniHomeConnectedController;
            ZPlanMiniHomeConnectReporter U;
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(data, "data");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", data.getFlowerName());
            jSONObject.put("item_id", data.getId());
            jSONObject.put("item_type", data.getFlowerOwnStatus());
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026\n            }.toString()");
            WeakReference<MiniHomeConnectedController> weakReference = this.controller;
            if (weakReference == null || (miniHomeConnectedController = weakReference.get()) == null || (U = miniHomeConnectedController.U()) == null) {
                return;
            }
            LinearLayout root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_crop_data", jSONObject2);
            Unit unit = Unit.INSTANCE;
            ZPlanMiniHomeConnectReporter.f(U, root, "em_zplan_crop", eventType, linkedHashMap, false, false, 32, null);
        }

        private final void o(TextView textView, int resId) {
            if (textView != null) {
                textView.setTextColor(ie0.a.f().g(this.binding.getRoot().getContext(), resId, 1001));
            }
        }
    }

    public final void m0() {
        this.currentSelect = -1;
        notifyDataSetChanged();
    }
}
