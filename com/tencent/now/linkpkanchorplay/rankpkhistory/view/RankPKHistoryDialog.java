package com.tencent.now.linkpkanchorplay.rankpkhistory.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.now.linkpkanchorplay.invite.model.AnchorTabPageContext;
import com.tencent.now.linkpkanchorplay.invite.view.BottomDialog;
import com.tencent.now.linkpkanchorplay.rankpkhistory.view.RankPKHistoryTabView;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryDialog;", "Lcom/tencent/now/linkpkanchorplay/invite/view/BottomDialog;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "H", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "pageContext", "<init>", "(Lcom/tencent/now/linkpkanchorplay/invite/model/a;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class RankPKHistoryDialog extends BottomDialog {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final AnchorTabPageContext pageContext;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryDialog$a", "Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryTabView$a;", "", "onBack", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements RankPKHistoryTabView.a {
        a() {
        }

        @Override // com.tencent.now.linkpkanchorplay.rankpkhistory.view.RankPKHistoryTabView.a
        public void onBack() {
            Dialog dialog = RankPKHistoryDialog.this.getDialog();
            if (dialog != null) {
                dialog.cancel();
            }
        }
    }

    public RankPKHistoryDialog(@NotNull AnchorTabPageContext pageContext) {
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        this.pageContext = pageContext;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        RankPKHistoryTabView rankPKHistoryTabView = new RankPKHistoryTabView(requireActivity, this, this, null, 8, null);
        com.tencent.now.linkpkanchorplay.event.b eventTrigger = qh();
        Intrinsics.checkNotNullExpressionValue(eventTrigger, "eventTrigger");
        rankPKHistoryTabView.C0(eventTrigger, this.pageContext);
        rankPKHistoryTabView.setBackCallback(new a());
        com.tencent.report.a.f364907a.f(rankPKHistoryTabView, IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID, zm3.a.f452778a.b());
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rankPKHistoryTabView);
        return rankPKHistoryTabView;
    }

    @Override // com.tencent.now.linkpkanchorplay.invite.view.BottomDialog, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
