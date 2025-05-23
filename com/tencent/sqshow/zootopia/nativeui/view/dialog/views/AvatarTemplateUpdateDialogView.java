package com.tencent.sqshow.zootopia.nativeui.view.dialog.views;

import android.content.Context;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;
import java.util.LinkedHashMap;
import java.util.Map;
import k94.AvatarTemplateNeedUpdateData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.ao;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB7\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/AvatarTemplateUpdateDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/BasePanelDialogView;", "Ln74/ao;", "binding", "", "P", "", HippyTKDListViewAdapter.X, "", "L", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lk94/a;", "D", "Lk94/a;", "mData", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;Lk94/a;)V", "E", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class AvatarTemplateUpdateDialogView extends BasePanelDialogView {

    /* renamed from: D, reason: from kotlin metadata */
    private final AvatarTemplateNeedUpdateData mData;

    public /* synthetic */ AvatarTemplateUpdateDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j jVar, AvatarTemplateNeedUpdateData avatarTemplateNeedUpdateData, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, jVar, avatarTemplateNeedUpdateData);
    }

    private final void P(ao binding) {
        int size = this.mData.c().size();
        for (int i3 = 0; i3 < size; i3++) {
            String str = this.mData.c().get(i3);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (i3 != 0) {
                layoutParams.topMargin = com.tencent.sqshow.zootopia.utils.i.b(12);
            }
            linearLayout.setLayoutParams(layoutParams);
            View view = new View(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.tencent.sqshow.zootopia.utils.i.b(9), com.tencent.sqshow.zootopia.utils.i.b(9));
            layoutParams2.topMargin = com.tencent.sqshow.zootopia.utils.i.b(2);
            view.setLayoutParams(layoutParams2);
            view.setBackgroundResource(R.drawable.h48);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = new ZplanExcludeFontPaddingTextView(context);
            zplanExcludeFontPaddingTextView.setText(Html.fromHtml(str));
            zplanExcludeFontPaddingTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
            zplanExcludeFontPaddingTextView.setTextSize(1, 14.0f);
            m84.b.g(zplanExcludeFontPaddingTextView, "#999999");
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.leftMargin = com.tencent.sqshow.zootopia.utils.i.b(8);
            zplanExcludeFontPaddingTextView.setLayoutParams(layoutParams3);
            linearLayout.addView(view);
            linearLayout.addView(zplanExcludeFontPaddingTextView);
            binding.f418680d.addView(linearLayout);
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_item_id", String.valueOf(this.mData.getOutfitCfgId()));
        ZplanViewReportHelper mReporter = getMChannel().getReporter().getMReporter();
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2 = binding.f418679c;
        Intrinsics.checkNotNullExpressionValue(zplanExcludeFontPaddingTextView2, "binding.updateDialogActionConfirm");
        mReporter.g(zplanExcludeFontPaddingTextView2, "em_zplan_abnormal_apparel_win_confirm", (r16 & 4) != 0 ? null : linkedHashMap, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        ZplanViewReportHelper mReporter2 = getMChannel().getReporter().getMReporter();
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView3 = binding.f418678b;
        Intrinsics.checkNotNullExpressionValue(zplanExcludeFontPaddingTextView3, "binding.updateDialogActionCancel");
        mReporter2.g(zplanExcludeFontPaddingTextView3, "em_zplan_abnormal_apparel_win_cancel", (r16 & 4) != 0 ? null : linkedHashMap, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView4 = binding.f418679c;
        Intrinsics.checkNotNullExpressionValue(zplanExcludeFontPaddingTextView4, "binding.updateDialogActionConfirm");
        aa.d(zplanExcludeFontPaddingTextView4, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AvatarTemplateUpdateDialogView.Q(AvatarTemplateUpdateDialogView.this, linkedHashMap, view2);
            }
        });
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView5 = binding.f418678b;
        Intrinsics.checkNotNullExpressionValue(zplanExcludeFontPaddingTextView5, "binding.updateDialogActionCancel");
        aa.d(zplanExcludeFontPaddingTextView5, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AvatarTemplateUpdateDialogView.R(AvatarTemplateUpdateDialogView.this, linkedHashMap, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(AvatarTemplateUpdateDialogView this$0, Map reportParams, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
        QLog.i("AvatarTemplateUpdateDialogView", 1, "click - Confirm");
        ZplanViewReportHelper mReporter = this$0.getMChannel().getReporter().getMReporter();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mReporter.e(it, "em_zplan_abnormal_apparel_win_confirm", reportParams);
        this$0.mData.getConfirmClickListener().onClick(it);
        this$0.getMChannel().getDialogController().g(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(AvatarTemplateUpdateDialogView this$0, Map reportParams, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
        QLog.i("AvatarTemplateUpdateDialogView", 1, "click - Cancel");
        ZplanViewReportHelper mReporter = this$0.getMChannel().getReporter().getMReporter();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mReporter.e(it, "em_zplan_abnormal_apparel_win_cancel", reportParams);
        View.OnClickListener cancelClickListener = this$0.mData.getCancelClickListener();
        if (cancelClickListener != null) {
            cancelClickListener.onClick(it);
        }
        this$0.getMChannel().getDialogController().g(this$0);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected boolean L() {
        return false;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected View m() {
        ao g16 = ao.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        P(g16);
        FrameLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    public int x() {
        return 2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarTemplateUpdateDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j channel, AvatarTemplateNeedUpdateData mData) {
        super(context, attributeSet, i3, channel);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(mData, "mData");
        this.mData = mData;
    }
}
