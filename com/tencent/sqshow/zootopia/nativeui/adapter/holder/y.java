package com.tencent.sqshow.zootopia.nativeui.adapter.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.adapter.holder.StoreItemViewHolder;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.az;
import uv4.bk;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001 B'\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0014J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0002H\u0014J\b\u0010\u0014\u001a\u00020\u0002H\u0014\u00a8\u0006!"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/y;", "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/StoreItemViewHolder;", "", "P1", "A1", "Luv4/az;", "storeItemData", "b1", "Z0", ICustomDataEditor.STRING_ARRAY_PARAM_1, "data", "u1", "W0", "", "id", "c1", "", "itemDressingOrDressed", "g1", "B1", "reportClick", "Ln74/ad;", "binding", "Lg94/g;", "sizeHelper", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/StoreItemViewHolder$a$a;", "category", "<init>", "(Ln74/ad;Lg94/g;Lcom/tencent/sqshow/zootopia/nativeui/data/j;Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/StoreItemViewHolder$a$a;)V", "h0", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class y extends StoreItemViewHolder {

    /* renamed from: i0, reason: collision with root package name */
    private static final int f370917i0 = ViewUtils.dpToPx(5.0f);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(n74.ad binding, g94.g sizeHelper, com.tencent.sqshow.zootopia.nativeui.data.j channel, StoreItemViewHolder.Companion.CategoryData category) {
        super(binding, sizeHelper, channel, category);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(sizeHelper, "sizeHelper");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(category, "category");
        P1();
    }

    private final void P1() {
        getBinding().getRoot().setBackground(getBinding().getRoot().getContext().getDrawable(R.drawable.f159873h52));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.StoreItemViewHolder
    public void A1() {
        super.A1();
        ViewGroup.LayoutParams layoutParams = getBinding().f418598i.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        int mItemWidth = (int) getSizeHelper().getMItemWidth();
        int i3 = f370917i0;
        layoutParams2.width = mItemWidth - (i3 * 2);
        layoutParams2.height = ((int) getSizeHelper().getMItemHeight()) - (i3 * 2);
        layoutParams2.gravity = 17;
        layoutParams2.setMargins(i3, i3, i3, i3);
        getBinding().f418598i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        getBinding().f418598i.setLayoutParams(layoutParams2);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.StoreItemViewHolder
    protected void B1() {
        az azVar;
        ZplanViewReportHelper mReporter = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter();
        FrameLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        HashMap<String, Object> d16 = d1();
        bk bindingData = getBindingData();
        mReporter.g(root, "em_zplan_recom_item", (r16 & 4) != 0 ? null : d16, (r16 & 8) != 0, (r16 & 16) != 0 ? null : (bindingData == null || (azVar = bindingData.f440366b) == null) ? null : azVar.B, (r16 & 32) != 0 ? false : true);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.StoreItemViewHolder
    protected void W0(az storeItemData) {
        Intrinsics.checkNotNullParameter(storeItemData, "storeItemData");
        View view = k1().get(Integer.valueOf(R.id.pep));
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = k1().get(Integer.valueOf(R.id.peu));
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = k1().get(Integer.valueOf(R.id.p_8));
        if (view3 == null) {
            return;
        }
        view3.setVisibility(8);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.StoreItemViewHolder
    public void Z0(az storeItemData) {
        Intrinsics.checkNotNullParameter(storeItemData, "storeItemData");
        getBinding().f418597h.f418869e.setVisibility(8);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.StoreItemViewHolder
    protected void a1(az storeItemData) {
        Intrinsics.checkNotNullParameter(storeItemData, "storeItemData");
        View view = k1().get(Integer.valueOf(R.id.qns));
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.StoreItemViewHolder
    protected void b1(az storeItemData) {
        Intrinsics.checkNotNullParameter(storeItemData, "storeItemData");
        View view = k1().get(Integer.valueOf(R.id.q4p));
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = k1().get(Integer.valueOf(R.id.qhs));
        if (view2 == null) {
            return;
        }
        view2.setVisibility(8);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.StoreItemViewHolder
    public void c1(int id5) {
        View view = k1().get(Integer.valueOf(R.id.qgv));
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.StoreItemViewHolder
    protected void reportClick() {
        ZplanViewReportHelper mReporter = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter();
        FrameLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        mReporter.e(root, "em_zplan_recom_item", d1());
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.StoreItemViewHolder
    protected void u1(az data) {
        View view = k1().get(Integer.valueOf(R.id.pkp));
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.StoreItemViewHolder
    protected void g1(boolean itemDressingOrDressed) {
    }
}
