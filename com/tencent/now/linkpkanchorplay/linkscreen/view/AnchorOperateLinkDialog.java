package com.tencent.now.linkpkanchorplay.linkscreen.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.component.core.log.LogUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.now.linkpkanchorplay.event.d;
import com.tencent.now.linkpkanchorplay.invite.view.AnchorInvitingView;
import com.tencent.now.linkpkanchorplay.invite.view.AnchorInvitingWhenLinkingView;
import com.tencent.now.linkpkanchorplay.invite.view.BottomDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import om3.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001=B'\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010 \u001a\u00020\u001e\u0012\u0006\u0010$\u001a\u00020!\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J&\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006>"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog;", "Lcom/tencent/now/linkpkanchorplay/invite/view/BottomDialog;", "", "initView", "wh", "Landroid/view/View;", "getContentView", "", "isPK", "", "pkType", "Le55/a;", "anchorInfo", "xh", "yh", OcrConfig.CHINESE, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "H", "J", "roomId", "I", "Le55/a;", "Lom3/e;", "Lom3/e;", "stateMgr", "Landroidx/lifecycle/ViewModelProvider;", "K", "Landroidx/lifecycle/ViewModelProvider;", "viewModelProvider", "", "L", "Ljava/lang/String;", "TAG", "M", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N", "Landroid/view/ViewGroup;", "operateView", "Landroid/widget/TextView;", "P", "Landroid/widget/TextView;", "titleView", "Lcom/tencent/component/core/event/Eventor;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/component/core/event/Eventor;", "eventor", "Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog$a;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog$a;", "dialogCallBack", "<init>", "(JLe55/a;Lom3/e;Landroidx/lifecycle/ViewModelProvider;)V", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AnchorOperateLinkDialog extends BottomDialog {

    /* renamed from: H, reason: from kotlin metadata */
    private final long roomId;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final e55.a anchorInfo;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final om3.e stateMgr;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final ViewModelProvider viewModelProvider;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: M, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: N, reason: from kotlin metadata */
    private ViewGroup operateView;

    /* renamed from: P, reason: from kotlin metadata */
    private TextView titleView;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Eventor eventor;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final a dialogCallBack;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog$a;", "", "", "onClose", "", "title", "setTitle", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface a {
        void onClose();

        void setTitle(@NotNull String title);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog$b", "Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog$a;", "", "onClose", "", "title", "setTitle", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements a {
        b() {
        }

        @Override // com.tencent.now.linkpkanchorplay.linkscreen.view.AnchorOperateLinkDialog.a
        public void onClose() {
            AnchorOperateLinkDialog.this.dismissAllowingStateLoss();
        }

        @Override // com.tencent.now.linkpkanchorplay.linkscreen.view.AnchorOperateLinkDialog.a
        public void setTitle(@NotNull String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            TextView textView = AnchorOperateLinkDialog.this.titleView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleView");
                textView = null;
            }
            textView.setText(title);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog$c", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/now/linkpkanchorplay/event/d$h;", "event", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements OnEvent<d.StateChangeEvent> {
        c() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull d.StateChangeEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            AnchorOperateLinkDialog.this.wh();
        }
    }

    public AnchorOperateLinkDialog(long j3, @NotNull e55.a anchorInfo, @NotNull om3.e stateMgr, @NotNull ViewModelProvider viewModelProvider) {
        Intrinsics.checkNotNullParameter(anchorInfo, "anchorInfo");
        Intrinsics.checkNotNullParameter(stateMgr, "stateMgr");
        Intrinsics.checkNotNullParameter(viewModelProvider, "viewModelProvider");
        this.roomId = j3;
        this.anchorInfo = anchorInfo;
        this.stateMgr = stateMgr;
        this.viewModelProvider = viewModelProvider;
        this.TAG = "AnchorOperateLinkDialog";
        this.eventor = new Eventor();
        this.dialogCallBack = new b();
    }

    private final View getContentView() {
        om3.d currentState = this.stateMgr.getCurrentState();
        boolean z16 = currentState instanceof d.InvitationSent;
        if (z16 && !fn3.a.a(this.stateMgr.getBizType())) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            return new AnchorInvitingView(requireContext, this.stateMgr.getBizType(), this.anchorInfo, this.dialogCallBack);
        }
        if (z16 && fn3.a.a(this.stateMgr.getBizType())) {
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
            return new AnchorInvitingWhenLinkingView(requireContext2, this.stateMgr.getBizType(), this.anchorInfo, this.dialogCallBack);
        }
        if (currentState instanceof d.InLinkScreen) {
            d.InLinkScreen inLinkScreen = (d.InLinkScreen) currentState;
            return xh(inLinkScreen.getIsInPK(), inLinkScreen.getPkType(), inLinkScreen.getAnchorInfo());
        }
        Context requireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
        return new AnchorInvitingView(requireContext3, this.stateMgr.getBizType(), this.anchorInfo, this.dialogCallBack);
    }

    private final void initView() {
        View view = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fdp, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026operate_panel_view, null)");
        this.rootView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.zzl);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Vi\u2026d.operate_view_container)");
        this.operateView = (ViewGroup) findViewById;
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view = view2;
        }
        View findViewById2 = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<TextView>(R.id.title)");
        this.titleView = (TextView) findViewById2;
        wh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wh() {
        if (getContext() != null) {
            ViewGroup viewGroup = this.operateView;
            ViewGroup viewGroup2 = null;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateView");
                viewGroup = null;
            }
            viewGroup.removeAllViews();
            ViewGroup viewGroup3 = this.operateView;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateView");
            } else {
                viewGroup2 = viewGroup3;
            }
            viewGroup2.addView(getContentView());
        }
    }

    private final View xh(boolean isPK, int pkType, e55.a anchorInfo) {
        LogUtil.i(this.TAG, "getInGameContentView, isPK:" + isPK + ", pkType:" + pkType, new Object[0]);
        if (!isPK) {
            return yh();
        }
        if (pkType != 1 && pkType != 2) {
            if (pkType == 3) {
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return new AnchorInPKOperateView(requireContext, false, this.roomId, anchorInfo, this.dialogCallBack, this.viewModelProvider);
            }
            return yh();
        }
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        return new AnchorInRankPKOperateView(requireContext2, pkType, anchorInfo, this.dialogCallBack);
    }

    private final View yh() {
        boolean z16;
        if (this.stateMgr.getCurrentState() instanceof d.InLinkScreen) {
            om3.d currentState = this.stateMgr.getCurrentState();
            Intrinsics.checkNotNull(currentState, "null cannot be cast to non-null type com.tencent.now.linkpkanchorplay.linkscreen.state.AnchorPlayOperationState.InLinkScreen");
            z16 = ((d.InLinkScreen) currentState).getAllowStartPK();
        } else {
            z16 = true;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new AnchorInLinkScreenOperateView(requireContext, this.roomId, this.anchorInfo, z16, this.dialogCallBack, this.viewModelProvider);
    }

    private final void zh() {
        this.eventor.addOnEvent(new c());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        initView();
        zh();
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.now.linkpkanchorplay.invite.view.BottomDialog, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.eventor.removeAll();
        if (getContext() != null) {
            ViewGroup viewGroup = this.operateView;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateView");
                viewGroup = null;
            }
            viewGroup.removeAllViews();
        }
        super.onDestroy();
    }
}
