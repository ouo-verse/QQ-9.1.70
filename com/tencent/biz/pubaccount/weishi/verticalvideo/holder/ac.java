package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0014J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0014R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/ac;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/c;", "", "g", tl.h.F, "f", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "position", "u", "currentPosition", "v", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;", "getHolder", "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;", "holder", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "D", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "getFragment", "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "fragment", "Landroid/view/View;", "E", "Landroid/view/View;", "hotView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ac extends c {

    /* renamed from: C, reason: from kotlin metadata */
    private final au holder;

    /* renamed from: D, reason: from kotlin metadata */
    private final WSVerticalPageFragment fragment;

    /* renamed from: E, reason: from kotlin metadata */
    private View hotView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(Context context, au holder, WSVerticalPageFragment wSVerticalPageFragment) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.holder = holder;
        this.fragment = wSVerticalPageFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void x(ac this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.i.d(this$0.fragment, (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this$0.f80413i, QAdVrReport.ElementID.AD_FLOAT, 2, (r13 & 16) != 0 ? 0 : 0, (r13 & 32) != 0 ? false : false);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.d1x;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void u(int position) {
        View view = this.hotView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hotView");
            view = null;
        }
        view.setClickable(((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this.f80413i).e().acquisitionInfo.hotRegion == 1);
        WSVerticalPageFragment wSVerticalPageFragment = this.fragment;
        if (wSVerticalPageFragment != null) {
            String from = wSVerticalPageFragment.getFrom();
            Intrinsics.checkNotNullExpressionValue(from, "from");
            String playScene = wSVerticalPageFragment.getPlayScene();
            Intrinsics.checkNotNullExpressionValue(playScene, "playScene");
            com.tencent.biz.pubaccount.weishi.verticalvideo.data.j data = c();
            Intrinsics.checkNotNullExpressionValue(data, "data");
            com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.p.d(from, playScene, data);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        View p16 = p(R.id.f163253p43);
        Intrinsics.checkNotNullExpressionValue(p16, "findViewById(R.id.hot_view)");
        this.hotView = p16;
        if (p16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hotView");
            p16 = null;
        }
        p16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ac.x(ac.this, view);
            }
        });
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void v(int currentPosition) {
    }
}
