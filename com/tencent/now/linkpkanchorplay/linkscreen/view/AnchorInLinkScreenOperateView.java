package com.tencent.now.linkpkanchorplay.linkscreen.view;

import android.content.Context;
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
import nm3.k;
import nm3.n;
import om3.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u00101\u001a\u000200\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0014R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010#\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\u00a8\u00064"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorInLinkScreenOperateView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "initView", "G0", "E0", "I0", NodeProps.ON_DETACHED_FROM_WINDOW, "", "d", "J", "roomId", "Le55/a;", "e", "Le55/a;", "anchorInfo", "", "f", "Z", "allowStartPK", "Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog$a;", h.F, "Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog$a;", "dialogCallBack", "Lcom/tencent/now/linkpkanchorplay/base/LinkPKHeadImageView;", "i", "Lcom/tencent/now/linkpkanchorplay/base/LinkPKHeadImageView;", "avatarView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "nickName", BdhLogUtil.LogTag.Tag_Conn, "endLinkScreen", "D", "invitePK", "Lcom/tencent/component/core/event/Eventor;", "E", "Lcom/tencent/component/core/event/Eventor;", "eventor", "Lpm3/a;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "F0", "()Lpm3/a;", "anchorInLinkScreenViewModel", "Landroid/content/Context;", "context", "Landroidx/lifecycle/ViewModelProvider;", "viewModelProvider", "<init>", "(Landroid/content/Context;JLe55/a;ZLcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog$a;Landroidx/lifecycle/ViewModelProvider;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AnchorInLinkScreenOperateView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView endLinkScreen;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView invitePK;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Eventor eventor;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy anchorInLinkScreenViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e55.a anchorInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean allowStartPK;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnchorOperateLinkDialog.a dialogCallBack;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinkPKHeadImageView avatarView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView nickName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkpkanchorplay/linkscreen/view/AnchorInLinkScreenOperateView$b", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/now/linkpkanchorplay/event/d$h;", "event", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements OnEvent<d.StateChangeEvent> {
        b() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull d.StateChangeEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if ((event.getCurState() instanceof d.c) && (event.getOldState() instanceof d.InLinkScreen)) {
                AnchorInLinkScreenOperateView.this.dialogCallBack.onClose();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkpkanchorplay/linkscreen/view/AnchorInLinkScreenOperateView$c", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/now/linkpkanchorplay/event/d$b;", "event", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements OnEvent<d.InviteReceiveReplyEvent> {
        c() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull d.InviteReceiveReplyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            AnchorInLinkScreenOperateView.this.dialogCallBack.onClose();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkpkanchorplay/linkscreen/view/AnchorInLinkScreenOperateView$d", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/now/linkpkanchorplay/event/d$f;", "event", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class d implements OnEvent<d.f> {
        d() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull d.f event) {
            Intrinsics.checkNotNullParameter(event, "event");
            AnchorInLinkScreenOperateView.this.I0();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/now/linkpkanchorplay/linkscreen/view/AnchorInLinkScreenOperateView$e", "Lnm3/k;", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class e implements k {
        e() {
        }

        @Override // nm3.k
        public void a() {
            AnchorInLinkScreenOperateView.this.E0();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkpkanchorplay/linkscreen/view/AnchorInLinkScreenOperateView$f", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@Nullable View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            EventCenter.post(new ym3.a(2, AnchorInLinkScreenOperateView.this.anchorInfo, 5));
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorInLinkScreenOperateView(@NotNull Context context, long j3, @NotNull e55.a anchorInfo, boolean z16, @NotNull AnchorOperateLinkDialog.a dialogCallBack, @NotNull final ViewModelProvider viewModelProvider) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(anchorInfo, "anchorInfo");
        Intrinsics.checkNotNullParameter(dialogCallBack, "dialogCallBack");
        Intrinsics.checkNotNullParameter(viewModelProvider, "viewModelProvider");
        this.roomId = j3;
        this.anchorInfo = anchorInfo;
        this.allowStartPK = z16;
        this.dialogCallBack = dialogCallBack;
        this.eventor = new Eventor();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<pm3.a>() { // from class: com.tencent.now.linkpkanchorplay.linkscreen.view.AnchorInLinkScreenOperateView$anchorInLinkScreenViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final pm3.a invoke() {
                return (pm3.a) ViewModelProvider.this.get(pm3.a.class);
            }
        });
        this.anchorInLinkScreenViewModel = lazy;
        View.inflate(context, R.layout.fdq, this);
        initView();
        G0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0() {
        F0().L1(this.roomId, new a());
        mm3.a aVar = mm3.a.f417004a;
        TextView textView = this.endLinkScreen;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endLinkScreen");
            textView = null;
        }
        aVar.a(textView, this.anchorInfo.f395729a.f395735a);
    }

    private final pm3.a F0() {
        return (pm3.a) this.anchorInLinkScreenViewModel.getValue();
    }

    private final void G0() {
        this.eventor.addOnEvent(new b());
        this.eventor.addOnEvent(new c()).addOnEvent(new d());
        AnchorOperateLinkDialog.a aVar = this.dialogCallBack;
        String string = getContext().getString(R.string.zrh);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.dialog_linking_title)");
        aVar.setTitle(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(AnchorInLinkScreenOperateView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.endLinkScreen;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endLinkScreen");
            textView = null;
        }
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "endLinkScreen.context");
        n.c(context, new e());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0() {
        TextView textView = this.endLinkScreen;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endLinkScreen");
            textView = null;
        }
        int i3 = 0;
        textView.setVisibility(0);
        TextView textView3 = this.invitePK;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("invitePK");
        } else {
            textView2 = textView3;
        }
        if (!this.allowStartPK) {
            i3 = 8;
        }
        textView2.setVisibility(i3);
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
        View findViewById3 = getRootView().findViewById(R.id.uve);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById<Te\u2026iew>(R.id.end_linkscreen)");
        this.endLinkScreen = (TextView) findViewById3;
        View findViewById4 = getRootView().findViewById(R.id.xrs);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById<TextView>(R.id.invite_pk)");
        this.invitePK = (TextView) findViewById4;
        TextView textView2 = this.endLinkScreen;
        TextView textView3 = null;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endLinkScreen");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.now.linkpkanchorplay.linkscreen.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorInLinkScreenOperateView.H0(AnchorInLinkScreenOperateView.this, view);
            }
        });
        TextView textView4 = this.invitePK;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("invitePK");
        } else {
            textView3 = textView4;
        }
        textView3.setOnClickListener(new f());
        I0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eventor.removeAll();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/now/linkpkanchorplay/linkscreen/view/AnchorInLinkScreenOperateView$a", "Lcom/tencent/component/callback/ITimedCallback;", "Lg55/b;", "data", "", "a", "", "code", "", "msg", "fail", WadlProxyConsts.PARAM_TIME_OUT, "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements ITimedCallback<g55.b> {
        a() {
        }

        @Override // com.tencent.component.callback.ITimedCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(@Nullable g55.b data) {
            EventCenter.post(d.g.f338188a);
            AnchorInLinkScreenOperateView.this.dialogCallBack.onClose();
        }

        @Override // com.tencent.component.callback.ITimedCallback
        public void timeOut() {
        }

        @Override // com.tencent.component.callback.ITimedCallback
        public void fail(int code, @Nullable String msg2) {
        }
    }
}
