package com.tencent.mobileqq.zplan.card.impl.view.smallhome.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonBinder;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonVideoStyle;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.view.ZootopiaSmallHomeCardBottomView;
import com.tencent.mobileqq.zplan.widget.impl.button.ZplanCommonButton;
import com.tencent.sqshow.zootopia.card.report.a;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.data.ZootopiaDownloadBarType;
import com.tencent.sqshow.zootopia.utils.aa;
import fi3.ad;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pv4.o;
import pv4.s;
import pv4.x;
import wf3.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b \u0010!J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J.\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0006R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/view/ZootopiaSmallHomeCardBottomView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View;", "view", "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "position", "", "elementId", "", "C0", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "Loa4/a;", "mapResViewModel", "cardPosition", "A0", "Lfi3/ad;", "d", "Lfi3/ad;", "viewBinding", "Lcom/tencent/sqshow/zootopia/card/report/a;", "e", "Lcom/tencent/sqshow/zootopia/card/report/a;", "reportHelper", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaSmallHomeCardBottomView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ad viewBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final a reportHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaSmallHomeCardBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.reportHelper = new a();
        ad f16 = ad.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.viewBinding = f16;
    }

    private final void C0(View view, ZootopiaCardData dataInfo, int position, String elementId) {
        this.reportHelper.c(view, position, 0, "", dataInfo, new s(), (r24 & 64) != 0 ? new HashMap() : null, (r24 & 128) != 0 ? "em_zplan_element" : elementId, (r24 & 256) != 0 ? null : null, (r24 & 512) != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(ZootopiaSmallHomeCardBottomView this$0, int i3, ZootopiaCardData dataInfo, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataInfo, "$dataInfo");
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        new i(context).n();
        a aVar = this$0.reportHelper;
        TextView textView = this$0.viewBinding.f398800j;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.tvVisitorCnt");
        aVar.a(textView, i3, 0, "", dataInfo, new s(), (r20 & 64) != 0 ? new HashMap() : null, (r20 & 128) != 0 ? "em_zplan_element" : "em_zplan_xw_view_visitor");
    }

    public final void A0(final ZootopiaCardData dataInfo, LifecycleOwner lifecycleOwner, ZootopiaSource sourceCurrent, oa4.a mapResViewModel, final int cardPosition) {
        Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        x smallHomeData = dataInfo.getSmallHomeData();
        if (smallHomeData != null) {
            this.viewBinding.f398799i.setText(smallHomeData.f427726j.f427702a);
            this.viewBinding.f398798h.setText(smallHomeData.f427719c);
            this.viewBinding.f398800j.setText(smallHomeData.f427717a);
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.f159848id2);
            drawable.setBounds(new Rect(0, 0, com.tencent.sqshow.zootopia.utils.i.b(11), com.tencent.sqshow.zootopia.utils.i.a(8.5f)));
            this.viewBinding.f398800j.setCompoundDrawables(drawable, null, null, null);
            TextView textView = this.viewBinding.f398800j;
            Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.tvVisitorCnt");
            textView.setCompoundDrawablePadding(LayoutAttrsKt.getDp(com.tencent.sqshow.zootopia.utils.i.b(2)));
            TextView textView2 = this.viewBinding.f398800j;
            Intrinsics.checkNotNullExpressionValue(textView2, "viewBinding.tvVisitorCnt");
            aa.b(textView2, com.tencent.sqshow.zootopia.utils.i.b(5));
            this.viewBinding.f398800j.setOnClickListener(new View.OnClickListener() { // from class: xf3.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZootopiaSmallHomeCardBottomView.B0(ZootopiaSmallHomeCardBottomView.this, cardPosition, dataInfo, view);
                }
            });
            this.viewBinding.f398797g.setText(smallHomeData.f427718b);
            this.viewBinding.f398796f.setText(smallHomeData.f427720d);
            o oVar = smallHomeData.f427725i;
            String str = smallHomeData.f427721e;
            ZootopiaDownloadBarType zootopiaDownloadBarType = ZootopiaDownloadBarType.VIDEO_DOWNLOAD_BAR;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.viewBinding.f398792b.t(new fl3.a(oVar, str, null, ZootopiaDownloadButtonVideoStyle.class, zootopiaDownloadBarType, 0, sourceCurrent, new ZootopiaDownloadButtonBinder(context, lifecycleOwner, mapResViewModel), false, null, PlayerResources.ViewId.VIDEO_SURFACE, null), lifecycleOwner);
            TextView textView3 = this.viewBinding.f398800j;
            Intrinsics.checkNotNullExpressionValue(textView3, "viewBinding.tvVisitorCnt");
            C0(textView3, dataInfo, cardPosition, "em_zplan_xw_view_visitor");
            ZplanCommonButton zplanCommonButton = this.viewBinding.f398792b;
            Intrinsics.checkNotNullExpressionValue(zplanCommonButton, "viewBinding.btnEnter");
            C0(zplanCommonButton, dataInfo, cardPosition, "em_zplan_xw_entrance");
        }
    }
}
