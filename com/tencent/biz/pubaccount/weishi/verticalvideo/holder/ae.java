package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.sTadLowItem;
import UserGrowth.stAcquisitionInfo;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.WSDownloadStatus;
import com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.WSFiveFactorPopupWindow;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.ProgressButton;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0002H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\u0002H\u0014J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0014R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/ae;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/c;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "g", tl.h.F, "f", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "position", "u", "currentPosition", "v", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;", "getHolder", "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;", "holder", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "D", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "getFragment", "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "fragment", "Lcom/tencent/mobileqq/widget/ProgressButton;", "E", "Lcom/tencent/mobileqq/widget/ProgressButton;", "tvDownBtn", "Landroid/widget/FrameLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/FrameLayout;", "tvDownBtnContainer", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "tvFiveFactor", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/m;", "H", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/m;", "downloadViewHelper", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ae extends c {

    /* renamed from: C, reason: from kotlin metadata */
    private final au holder;

    /* renamed from: D, reason: from kotlin metadata */
    private final WSVerticalPageFragment fragment;

    /* renamed from: E, reason: from kotlin metadata */
    private ProgressButton tvDownBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private FrameLayout tvDownBtnContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView tvFiveFactor;

    /* renamed from: H, reason: from kotlin metadata */
    private com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.m downloadViewHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(Context context, au holder, WSVerticalPageFragment wSVerticalPageFragment) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.holder = holder;
        this.fragment = wSVerticalPageFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void x(ae this$0, View view) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WSVerticalPageFragment wSVerticalPageFragment = this$0.fragment;
        if (wSVerticalPageFragment == null || (activity = wSVerticalPageFragment.getActivity()) == null) {
            return;
        }
        String from = this$0.fragment.getFrom();
        Intrinsics.checkNotNullExpressionValue(from, "fragment.from");
        String playScene = this$0.fragment.getPlayScene();
        Intrinsics.checkNotNullExpressionValue(playScene, "fragment.playScene");
        T mData = this$0.f80413i;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.p.f(from, playScene, (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) mData);
        WSFiveFactorPopupWindow a16 = WSFiveFactorPopupWindow.INSTANCE.a(this$0.fragment);
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        T mData2 = this$0.f80413i;
        Intrinsics.checkNotNullExpressionValue(mData2, "mData");
        a16.A(decorView, (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) mData2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y() {
        WSVerticalPageFragment wSVerticalPageFragment;
        stAcquisitionInfo stacquisitioninfo;
        stSimpleMetaFeed e16 = ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this.f80413i).e();
        ArrayList<sTadLowItem> arrayList = (e16 == null || (stacquisitioninfo = e16.acquisitionInfo) == null) ? null : stacquisitioninfo.items;
        if ((arrayList == null || arrayList.isEmpty()) || (wSVerticalPageFragment = this.fragment) == null) {
            return;
        }
        String from = wSVerticalPageFragment.getFrom();
        Intrinsics.checkNotNullExpressionValue(from, "from");
        String playScene = wSVerticalPageFragment.getPlayScene();
        Intrinsics.checkNotNullExpressionValue(playScene, "playScene");
        T mData = this.f80413i;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.p.g(from, playScene, (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) mData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z() {
        ArrayList<sTadLowItem> arrayList = ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this.f80413i).e().acquisitionInfo.items;
        Intrinsics.checkNotNullExpressionValue(arrayList, "mData.itemInfo.acquisitionInfo.items");
        String str = "";
        int i3 = 0;
        int i16 = 0;
        for (Object obj : arrayList) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            sTadLowItem stadlowitem = (sTadLowItem) obj;
            if (i16 == 0) {
                str = stadlowitem.text;
                Intrinsics.checkNotNullExpressionValue(str, "{\n                sTadLowItem.text\n            }");
            } else {
                str = ((Object) str) + APLogFileUtil.SEPARATOR_LOG + stadlowitem.text;
            }
            i16 = i17;
        }
        TextView textView = this.tvFiveFactor;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvFiveFactor");
            textView = null;
        }
        if (str.length() == 0) {
            i3 = 8;
        } else {
            TextView textView3 = this.tvFiveFactor;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvFiveFactor");
            } else {
                textView2 = textView3;
            }
            textView2.setText(str);
        }
        textView.setVisibility(i3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.m mVar = this.downloadViewHelper;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadViewHelper");
            mVar = null;
        }
        mVar.s();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        z();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.d1z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void u(int position) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.m mVar = this.downloadViewHelper;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadViewHelper");
            mVar = null;
        }
        mVar.r((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this.f80413i);
        y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void v(int currentPosition) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.m mVar = this.downloadViewHelper;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadViewHelper");
            mVar = null;
        }
        mVar.s();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        FrameLayout frameLayout;
        ProgressButton progressButton;
        View p16 = p(R.id.p6k);
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.mobileqq.widget.ProgressButton");
        this.tvDownBtn = (ProgressButton) p16;
        View p17 = p(R.id.p6l);
        Intrinsics.checkNotNull(p17, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.tvDownBtnContainer = (FrameLayout) p17;
        View p18 = p(R.id.p6m);
        Intrinsics.checkNotNull(p18, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) p18;
        this.tvFiveFactor = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvFiveFactor");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.ad
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ae.x(ae.this, view);
            }
        });
        WSVerticalPageFragment wSVerticalPageFragment = this.fragment;
        FrameLayout frameLayout2 = this.tvDownBtnContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDownBtnContainer");
            frameLayout = null;
        } else {
            frameLayout = frameLayout2;
        }
        ProgressButton progressButton2 = this.tvDownBtn;
        if (progressButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDownBtn");
            progressButton = null;
        } else {
            progressButton = progressButton2;
        }
        this.downloadViewHelper = new com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.m(wSVerticalPageFragment, frameLayout, progressButton, WSDownloadStatus.Init, "videotag_rich", false, null, 96, null);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
    }
}
