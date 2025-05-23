package com.tencent.sqshow.zootopia.nativeui.dialog.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.BaseDragPanelDialogView;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishApiImpl;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.sqshow.zootopia.publish.a;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.state.report.SquareReportConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.r;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB/\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/dialog/views/DressShareDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/BaseDragPanelDialogView;", "", "dressKey", "", "setDressKey", "Landroid/view/View;", "N", "show", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "J", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "getChannel", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "Ln74/r;", "K", "Ln74/r;", "mViewBinding", "L", "Ljava/lang/String;", "mDressKey", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "M", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DressShareDialogView extends BaseDragPanelDialogView {

    /* renamed from: J, reason: from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j channel;

    /* renamed from: K, reason: from kotlin metadata */
    private final r mViewBinding;

    /* renamed from: L, reason: from kotlin metadata */
    private String mDressKey;

    public /* synthetic */ DressShareDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j jVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(DressShareDialogView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
        ZplanViewReportHelper mReporter = this$0.getMChannel().getReporter().getMReporter();
        Button button = this$0.mViewBinding.f419401c;
        Intrinsics.checkNotNullExpressionValue(button, "mViewBinding.btnShare");
        ZplanViewReportHelper.f(mReporter, button, "em_zplan_cancel_btn", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(DressShareDialogView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZPlanPublishApiImpl zPlanPublishApiImpl = ZPlanPublishApiImpl.f372397a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        a.C9834a.a(zPlanPublishApiImpl, context, ZootopiaSource.INSTANCE.g(), ZPlanPublishSource.FROM_DRESS_SAVE_SHARE, null, 8, null);
        this$0.o();
        ZplanViewReportHelper mReporter = this$0.getMChannel().getReporter().getMReporter();
        Button button = this$0.mViewBinding.f419401c;
        Intrinsics.checkNotNullExpressionValue(button, "mViewBinding.btnShare");
        ZplanViewReportHelper.f(mReporter, button, SquareReportConst.ElementId.ELEMENT_ID_POSTER_SHARE, null, 4, null);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BaseDragPanelDialogView
    public View N() {
        this.mViewBinding.f419400b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DressShareDialogView.U(DressShareDialogView.this, view);
            }
        });
        this.mViewBinding.f419401c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DressShareDialogView.V(DressShareDialogView.this, view);
            }
        });
        ZplanViewReportHelper mReporter = getMChannel().getReporter().getMReporter();
        Button button = this.mViewBinding.f419401c;
        Intrinsics.checkNotNullExpressionValue(button, "mViewBinding.btnShare");
        mReporter.g(button, SquareReportConst.ElementId.ELEMENT_ID_POSTER_SHARE, (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        ZplanViewReportHelper mReporter2 = getMChannel().getReporter().getMReporter();
        Button button2 = this.mViewBinding.f419401c;
        Intrinsics.checkNotNullExpressionValue(button2, "mViewBinding.btnShare");
        mReporter2.g(button2, "em_zplan_cancel_btn", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        LinearLayout root = this.mViewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mViewBinding.root");
        return root;
    }

    public final void setDressKey(String dressKey) {
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        this.mDressKey = dressKey;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView, ga4.g
    public void show() {
        super.show();
        b94.e O = getMChannel().O();
        boolean z16 = false;
        if (O != null && !O.getMMainPanelIsShow()) {
            z16 = true;
        }
        if (z16) {
            LinearLayout root = this.mViewBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "mViewBinding.root");
            aa.h(root, new Function1<LinearLayout.LayoutParams, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.DressShareDialogView$show$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LinearLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LinearLayout.LayoutParams updateLayoutParams) {
                    int i3;
                    r rVar;
                    Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                    if (com.tencent.sqshow.zootopia.recommend.main.tab.b.f372639a.d().size() > 1) {
                        rVar = DressShareDialogView.this.mViewBinding;
                        i3 = (int) rVar.getRoot().getContext().getResources().getDimension(R.dimen.f122670);
                    } else {
                        i3 = 0;
                    }
                    updateLayoutParams.bottomMargin = i3;
                    QLog.i("DressShareDialogView", 1, "adjustLoadingBottomMargin bottomMargin:" + i3);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DressShareDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        super(context, attributeSet, i3, channel);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        r g16 = r.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.mViewBinding = g16;
    }
}
