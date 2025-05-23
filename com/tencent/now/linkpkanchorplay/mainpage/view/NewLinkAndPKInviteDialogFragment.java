package com.tencent.now.linkpkanchorplay.mainpage.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.now.linkpkanchorplay.event.b;
import com.tencent.now.linkpkanchorplay.event.d;
import com.tencent.now.linkpkanchorplay.invite.model.AnchorTabPageContext;
import com.tencent.now.linkpkanchorplay.invite.view.BottomDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import om3.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/mainpage/view/NewLinkAndPKInviteDialogFragment;", "Lcom/tencent/now/linkpkanchorplay/invite/view/BottomDialog;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "H", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "pageContext", "Lcom/tencent/component/core/event/Eventor;", "I", "Lcom/tencent/component/core/event/Eventor;", "eventor", "<init>", "(Lcom/tencent/now/linkpkanchorplay/invite/model/a;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class NewLinkAndPKInviteDialogFragment extends BottomDialog {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final AnchorTabPageContext pageContext;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Eventor eventor;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkpkanchorplay/mainpage/view/NewLinkAndPKInviteDialogFragment$a", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/now/linkpkanchorplay/event/d$h;", "event", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements OnEvent<d.StateChangeEvent> {
        a() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull d.StateChangeEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getCurState() instanceof d.InvitationSent) {
                NewLinkAndPKInviteDialogFragment.this.dismissAllowingStateLoss();
            }
        }
    }

    public NewLinkAndPKInviteDialogFragment(@NotNull AnchorTabPageContext pageContext) {
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        this.pageContext = pageContext;
        this.eventor = new Eventor();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        NewLinkAndPKInviteTabView newLinkAndPKInviteTabView = new NewLinkAndPKInviteTabView(requireActivity);
        b eventTrigger = qh();
        Intrinsics.checkNotNullExpressionValue(eventTrigger, "eventTrigger");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        newLinkAndPKInviteTabView.J0(eventTrigger, new ViewModelProvider(this, new hm3.b(requireContext)), this, this.pageContext);
        com.tencent.report.a.f364907a.f(newLinkAndPKInviteTabView, IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID, zm3.a.f452778a.b());
        this.eventor.addOnEvent(new a());
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, newLinkAndPKInviteTabView);
        return newLinkAndPKInviteTabView;
    }

    @Override // com.tencent.now.linkpkanchorplay.invite.view.BottomDialog, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eventor.removeAll();
    }
}
