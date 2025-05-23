package com.tencent.now.linkpkanchorplay.guide;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.now.linkpkanchorplay.guide.LinkMicVideoCutGuideView;
import com.tencent.now.linkpkanchorplay.invite.view.BottomDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/guide/LinkMicVideoCutGuideDialog;", "Lcom/tencent/now/linkpkanchorplay/invite/view/BottomDialog;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Lcom/tencent/now/linkpkanchorplay/guide/LinkMicVideoCutGuideView;", "H", "Lcom/tencent/now/linkpkanchorplay/guide/LinkMicVideoCutGuideView;", "linkMicVideoCutGuideView", "", "I", "Z", "uh", "()Z", "vh", "(Z)V", "dismissFromClickButton", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class LinkMicVideoCutGuideDialog extends BottomDialog {

    /* renamed from: H, reason: from kotlin metadata */
    private LinkMicVideoCutGuideView linkMicVideoCutGuideView;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean dismissFromClickButton;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/now/linkpkanchorplay/guide/LinkMicVideoCutGuideDialog$a", "Lcom/tencent/now/linkpkanchorplay/guide/LinkMicVideoCutGuideView$a;", "", NodeProps.ON_CLICK, "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements LinkMicVideoCutGuideView.a {
        a() {
        }

        @Override // com.tencent.now.linkpkanchorplay.guide.LinkMicVideoCutGuideView.a
        public void onClick() {
            LinkMicVideoCutGuideDialog.this.vh(true);
            LinkMicVideoCutGuideDialog.this.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this.linkMicVideoCutGuideView = new LinkMicVideoCutGuideView(requireContext, new a());
        rh(true);
        LinkMicVideoCutGuideView linkMicVideoCutGuideView = this.linkMicVideoCutGuideView;
        if (linkMicVideoCutGuideView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linkMicVideoCutGuideView");
            linkMicVideoCutGuideView = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, linkMicVideoCutGuideView);
        return linkMicVideoCutGuideView;
    }

    /* renamed from: uh, reason: from getter */
    public final boolean getDismissFromClickButton() {
        return this.dismissFromClickButton;
    }

    public final void vh(boolean z16) {
        this.dismissFromClickButton = z16;
    }
}
