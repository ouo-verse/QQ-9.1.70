package com.tencent.sqshow.zootopia.nativeui.adapter.holder;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.entry.IEntryApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.bk;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\"B\u001f\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J2\u0010\u000f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\b0\fj\b\u0012\u0004\u0012\u00020\b`\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/m;", "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/BaseAvatarPanelItemViewHolder;", "", "Q0", "reportClick", "R0", "Lcom/tencent/sqshow/zootopia/nativeui/view/loading/NativePanelLoadingIgv;", "O", "Luv4/bk;", "data", "", "posInList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "totalData", "e0", "", "J0", "", "Y", "Ln74/aa;", "W", "Ln74/aa;", "getBinding", "()Ln74/aa;", "binding", "Lg94/g;", "X", "Lg94/g;", "sizeHelper", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "<init>", "(Ln74/aa;Lg94/g;Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class m extends BaseAvatarPanelItemViewHolder {

    /* renamed from: W, reason: from kotlin metadata */
    private final n74.aa binding;

    /* renamed from: X, reason: from kotlin metadata */
    private final g94.g sizeHelper;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public m(n74.aa binding, g94.g sizeHelper, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        super(r0, channel);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(sizeHelper, "sizeHelper");
        Intrinsics.checkNotNullParameter(channel, "channel");
        LinearLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        this.binding = binding;
        this.sizeHelper = sizeHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(m this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(m this$0, Bundle entryBundle, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(entryBundle, "$entryBundle");
        IEntryApi iEntryApi = (IEntryApi) QRoute.api(IEntryApi.class);
        Context context = this$0.binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        iEntryApi.startAIGCCreationPage(context, ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.None, ZootopiaSource.SUB_SOURCE_AIGC_CREATION_ENTRANCE, null, 4, null), entryBundle);
        this$0.reportClick();
    }

    private final void Q0() {
        try {
            int mItemHeight = (int) this.sizeHelper.getMItemHeight();
            int mItemWidth = (int) this.sizeHelper.getMItemWidth();
            ViewGroup.LayoutParams layoutParams = this.binding.f418583b.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.width = mItemWidth - com.tencent.sqshow.zootopia.utils.i.b(8);
            layoutParams2.height = mItemHeight - com.tencent.sqshow.zootopia.utils.i.b(8);
            layoutParams2.leftMargin = com.tencent.sqshow.zootopia.utils.i.b(4);
            layoutParams2.rightMargin = com.tencent.sqshow.zootopia.utils.i.b(4);
            layoutParams2.topMargin = com.tencent.sqshow.zootopia.utils.i.b(4);
            layoutParams2.bottomMargin = com.tencent.sqshow.zootopia.utils.i.b(4);
            this.binding.f418583b.setLayoutParams(layoutParams2);
        } catch (Exception e16) {
            QLog.i("CreationEntranceViewHolder", 1, "lp is not LinearLayout.LayoutParam: " + e16);
        }
    }

    private final void R0() {
        ZplanViewReportHelper mReporter = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter();
        LinearLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        mReporter.g(root, "em_zplan_create_btn", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    private final void reportClick() {
        ZplanViewReportHelper mReporter = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter();
        LinearLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        mReporter.e(root, "em_zplan_create_btn", null);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public String J0() {
        return "CreationEntranceViewHolder";
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public NativePanelLoadingIgv O() {
        Context context = this.binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        return new NativePanelLoadingIgv(context, null, 0, 6, null);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public boolean Y() {
        return false;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public void e0(bk data, int posInList, ArrayList<bk> totalData) {
        Intrinsics.checkNotNullParameter(totalData, "totalData");
        if (data == null) {
            return;
        }
        D0(data);
        Q0();
        this.itemView.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.k
            @Override // java.lang.Runnable
            public final void run() {
                m.O0(m.this);
            }
        });
        final Bundle bundle = new Bundle();
        bundle.putInt("from", 2);
        LinearLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        com.tencent.sqshow.zootopia.utils.aa.e(root, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.P0(m.this, bundle, view);
            }
        }, 10L);
    }
}
