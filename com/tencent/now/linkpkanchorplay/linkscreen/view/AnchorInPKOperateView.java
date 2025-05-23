package com.tencent.now.linkpkanchorplay.linkscreen.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.tencent.component.callback.ITimedCallback;
import com.tencent.component.core.event.EventCenter;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.now.app.misc.ui.UIUtil;
import com.tencent.now.linkpkanchorplay.base.LinkPKHeadImageView;
import com.tencent.now.linkpkanchorplay.event.d;
import com.tencent.now.linkpkanchorplay.linkscreen.view.AnchorOperateLinkDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import om3.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u00105\u001a\u000204\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0014R\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010'\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010\"R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\u00a8\u00068"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorInPKOperateView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "initView", "H0", "J0", "Lom3/d;", "oldState", "curState", "", "G0", "O0", NodeProps.ON_DETACHED_FROM_WINDOW, "d", "Z", "isInviting", "", "e", "J", "curRoomId", "Le55/a;", "f", "Le55/a;", "anchorInfo", "Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog$a;", h.F, "Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog$a;", "dialogCallBack", "Lcom/tencent/now/linkpkanchorplay/base/LinkPKHeadImageView;", "i", "Lcom/tencent/now/linkpkanchorplay/base/LinkPKHeadImageView;", "avatarView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "endPK", BdhLogUtil.LogTag.Tag_Conn, "restartPK", "D", "nickName", "Lcom/tencent/component/core/event/Eventor;", "E", "Lcom/tencent/component/core/event/Eventor;", "eventor", "Lpm3/b;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "I0", "()Lpm3/b;", "anchorInPKCtrlViewModel", "Landroid/content/Context;", "context", "Landroidx/lifecycle/ViewModelProvider;", "viewModelProvider", "<init>", "(Landroid/content/Context;ZJLe55/a;Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog$a;Landroidx/lifecycle/ViewModelProvider;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AnchorInPKOperateView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView restartPK;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView nickName;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Eventor eventor;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy anchorInPKCtrlViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isInviting;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long curRoomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e55.a anchorInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnchorOperateLinkDialog.a dialogCallBack;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinkPKHeadImageView avatarView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView endPK;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkpkanchorplay/linkscreen/view/AnchorInPKOperateView$b", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/now/linkpkanchorplay/event/d$h;", "event", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements OnEvent<d.StateChangeEvent> {
        b() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull d.StateChangeEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (AnchorInPKOperateView.this.G0(event.getOldState(), event.getCurState())) {
                AnchorInPKOperateView.this.dialogCallBack.onClose();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkpkanchorplay/linkscreen/view/AnchorInPKOperateView$c", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/now/linkpkanchorplay/event/d$b;", "event", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements OnEvent<d.InviteReceiveReplyEvent> {
        c() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull d.InviteReceiveReplyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            AnchorInPKOperateView.this.dialogCallBack.onClose();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkpkanchorplay/linkscreen/view/AnchorInPKOperateView$d", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/now/linkpkanchorplay/event/d$f;", "event", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class d implements OnEvent<d.f> {
        d() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull d.f event) {
            Intrinsics.checkNotNullParameter(event, "event");
            AnchorInPKOperateView.this.O0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorInPKOperateView(@NotNull Context context, boolean z16, long j3, @NotNull e55.a anchorInfo, @NotNull AnchorOperateLinkDialog.a dialogCallBack, @NotNull final ViewModelProvider viewModelProvider) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(anchorInfo, "anchorInfo");
        Intrinsics.checkNotNullParameter(dialogCallBack, "dialogCallBack");
        Intrinsics.checkNotNullParameter(viewModelProvider, "viewModelProvider");
        this.isInviting = z16;
        this.curRoomId = j3;
        this.anchorInfo = anchorInfo;
        this.dialogCallBack = dialogCallBack;
        this.eventor = new Eventor();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<pm3.b>() { // from class: com.tencent.now.linkpkanchorplay.linkscreen.view.AnchorInPKOperateView$anchorInPKCtrlViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final pm3.b invoke() {
                return (pm3.b) ViewModelProvider.this.get(pm3.b.class);
            }
        });
        this.anchorInPKCtrlViewModel = lazy;
        View.inflate(context, R.layout.fdr, this);
        initView();
        J0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean G0(om3.d oldState, om3.d curState) {
        if ((oldState instanceof d.InLinkScreen) && ((d.InLinkScreen) oldState).getIsInPK()) {
            boolean z16 = curState instanceof d.InLinkScreen;
            if (z16) {
                if (z16 && !((d.InLinkScreen) curState).getIsInPK()) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    private final void H0() {
        I0().L1(this.curRoomId, new a());
    }

    private final pm3.b I0() {
        return (pm3.b) this.anchorInPKCtrlViewModel.getValue();
    }

    private final void J0() {
        this.eventor.addOnEvent(new b());
        this.eventor.addOnEvent(new c()).addOnEvent(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(final AnchorInPKOperateView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.qui.a.a(this$0.getContext(), 0, this$0.getContext().getString(R.string.zva), this$0.getContext().getString(R.string.zv_), "\u53d6\u6d88", "\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: com.tencent.now.linkpkanchorplay.linkscreen.view.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AnchorInPKOperateView.L0(dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.now.linkpkanchorplay.linkscreen.view.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AnchorInPKOperateView.M0(AnchorInPKOperateView.this, dialogInterface, i3);
            }
        }).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(AnchorInPKOperateView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(AnchorInPKOperateView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EventCenter.post(new ym3.a(4, this$0.anchorInfo, 8));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0() {
        TextView textView = this.endPK;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endPK");
            textView = null;
        }
        textView.setVisibility(0);
        TextView textView3 = this.restartPK;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restartPK");
        } else {
            textView2 = textView3;
        }
        textView2.setVisibility(0);
    }

    private final void initView() {
        View findViewById = findViewById(R.id.a2o);
        LinkPKHeadImageView linkPKHeadImageView = (LinkPKHeadImageView) findViewById;
        ImageLoader.getInstance().displayImage(this.anchorInfo.f395729a.f395738d, linkPKHeadImageView, new ImageSize(UIUtil.b(linkPKHeadImageView.getContext(), 48.0f), UIUtil.b(linkPKHeadImageView.getContext(), 48.0f)));
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<LinkPKHeadI\u2026go, this, size)\n        }");
        this.avatarView = linkPKHeadImageView;
        View findViewById2 = findViewById(R.id.f9d);
        TextView textView = (TextView) findViewById2;
        textView.setText(this.anchorInfo.f395729a.f395737c);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<TextView>(R\u2026Info.basic.nick\n        }");
        this.nickName = textView;
        View findViewById3 = getRootView().findViewById(R.id.uvj);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById<TextView>(R.id.end_pk)");
        this.endPK = (TextView) findViewById3;
        View findViewById4 = getRootView().findViewById(R.id.f73653u5);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById<TextView>(R.id.restart_pk)");
        this.restartPK = (TextView) findViewById4;
        TextView textView2 = this.endPK;
        TextView textView3 = null;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endPK");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.now.linkpkanchorplay.linkscreen.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorInPKOperateView.K0(AnchorInPKOperateView.this, view);
            }
        });
        TextView textView4 = this.restartPK;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restartPK");
        } else {
            textView3 = textView4;
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.now.linkpkanchorplay.linkscreen.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorInPKOperateView.N0(AnchorInPKOperateView.this, view);
            }
        });
        O0();
        AnchorOperateLinkDialog.a aVar = this.dialogCallBack;
        String string = getContext().getString(R.string.zrg);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026.dialog_linking_pk_title)");
        aVar.setTitle(string);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eventor.removeAll();
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/now/linkpkanchorplay/linkscreen/view/AnchorInPKOperateView$a", "Lcom/tencent/component/callback/ITimedCallback;", "Lg55/d;", "data", "", "a", "", "code", "", "msg", "fail", WadlProxyConsts.PARAM_TIME_OUT, "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements ITimedCallback<g55.d> {
        a() {
        }

        @Override // com.tencent.component.callback.ITimedCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(@Nullable g55.d data) {
            AnchorInPKOperateView.this.dialogCallBack.onClose();
        }

        @Override // com.tencent.component.callback.ITimedCallback
        public void timeOut() {
        }

        @Override // com.tencent.component.callback.ITimedCallback
        public void fail(int code, @Nullable String msg2) {
        }
    }
}
