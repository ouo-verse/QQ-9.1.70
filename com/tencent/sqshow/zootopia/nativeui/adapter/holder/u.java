package com.tencent.sqshow.zootopia.nativeui.adapter.holder;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.bk;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J2\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/u;", "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/BaseAvatarPanelItemViewHolder;", "Lcom/tencent/sqshow/zootopia/nativeui/view/loading/NativePanelLoadingIgv;", "O", "Luv4/bk;", "data", "", "posInList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "totalData", "", "e0", "", "J0", "", "Y", "Ln74/ab;", "W", "Ln74/ab;", "getBinding", "()Ln74/ab;", "binding", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "X", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "getQuiEmptyState", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "quiEmptyState", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "<init>", "(Ln74/ab;Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class u extends BaseAvatarPanelItemViewHolder {

    /* renamed from: W, reason: from kotlin metadata */
    private final n74.ab binding;

    /* renamed from: X, reason: from kotlin metadata */
    private final QUIEmptyState quiEmptyState;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public u(n74.ab binding, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        super(r0, channel);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(channel, "channel");
        FrameLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        this.binding = binding;
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(binding.getRoot().getContext()).setImageType(11);
        String qqStr = HardCodeUtil.qqStr(R.string.xrc);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.zplan_nat\u2026shop_empty_default_title)");
        QUIEmptyState.Builder title = imageType.setTitle(qqStr);
        String qqStr2 = HardCodeUtil.qqStr(R.string.xrb);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.zplan_nat\u2026_shop_empty_default_desc)");
        QUIEmptyState build = title.setDesc(qqStr2).setHalfScreenState(true).setBackgroundColorType(0).build();
        this.quiEmptyState = build;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        binding.f418586c.addView(build, layoutParams);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public String J0() {
        return "EmptyViewHolder";
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public NativePanelLoadingIgv O() {
        return null;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public boolean Y() {
        return false;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public void e0(bk data, int posInList, ArrayList<bk> totalData) {
        Intrinsics.checkNotNullParameter(totalData, "totalData");
    }
}
