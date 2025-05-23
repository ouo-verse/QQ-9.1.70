package com.tencent.now.linkpkanchorplay.invite.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.component.core.event.EventCenter;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.now.linkpkanchorplay.base.LinkPKHeadImageView;
import com.tencent.now.linkpkanchorplay.event.d;
import com.tencent.now.linkpkanchorplay.invite.view.AnchorInvitingWhenLinkingView;
import com.tencent.now.linkpkanchorplay.linkscreen.view.AnchorOperateLinkDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import fn3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0014R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/invite/view/AnchorInvitingWhenLinkingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "B0", "initView", NodeProps.ON_DETACHED_FROM_WINDOW, "", "d", "I", "bizType", "Le55/a;", "e", "Le55/a;", "anchorInfo", "Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog$a;", "f", "Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog$a;", "dialogCallBack", "Lcom/tencent/now/linkpkanchorplay/base/LinkPKHeadImageView;", h.F, "Lcom/tencent/now/linkpkanchorplay/base/LinkPKHeadImageView;", "linkPKHeadImageView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "nickView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "cancelInviteBtn", "Lcom/tencent/component/core/event/Eventor;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/component/core/event/Eventor;", "eventor", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;ILe55/a;Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog$a;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AnchorInvitingWhenLinkingView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Eventor eventor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int bizType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e55.a anchorInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnchorOperateLinkDialog.a dialogCallBack;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LinkPKHeadImageView linkPKHeadImageView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView nickView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView cancelInviteBtn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkpkanchorplay/invite/view/AnchorInvitingWhenLinkingView$a", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/now/linkpkanchorplay/event/d$b;", "event", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements OnEvent<d.InviteReceiveReplyEvent> {
        a() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull d.InviteReceiveReplyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            AnchorInvitingWhenLinkingView.this.dialogCallBack.onClose();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkpkanchorplay/invite/view/AnchorInvitingWhenLinkingView$b", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/now/linkpkanchorplay/event/d$f;", "event", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements OnEvent<d.f> {
        b() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull d.f event) {
            Intrinsics.checkNotNullParameter(event, "event");
            AnchorInvitingWhenLinkingView.this.dialogCallBack.onClose();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorInvitingWhenLinkingView(@NotNull Context context, int i3, @NotNull e55.a anchorInfo, @NotNull AnchorOperateLinkDialog.a dialogCallBack) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(anchorInfo, "anchorInfo");
        Intrinsics.checkNotNullParameter(dialogCallBack, "dialogCallBack");
        this.bizType = i3;
        this.anchorInfo = anchorInfo;
        this.dialogCallBack = dialogCallBack;
        this.eventor = new Eventor();
        initView();
        B0();
    }

    private final void B0() {
        this.eventor.addOnEvent(new a()).addOnEvent(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCenter.post(d.a.f338180a);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initView() {
        View.inflate(getContext(), R.layout.fe9, this);
        View findViewById = findViewById(R.id.a2o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.avatar)");
        this.linkPKHeadImageView = (LinkPKHeadImageView) findViewById;
        View findViewById2 = findViewById(R.id.f9d);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.nick_name)");
        this.nickView = (TextView) findViewById2;
        ImageLoader imageLoader = ImageLoader.getInstance();
        String str = this.anchorInfo.f395729a.f395738d;
        LinkPKHeadImageView linkPKHeadImageView = this.linkPKHeadImageView;
        TextView textView = null;
        if (linkPKHeadImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linkPKHeadImageView");
            linkPKHeadImageView = null;
        }
        imageLoader.displayImage(str, linkPKHeadImageView, hm3.a.a());
        TextView textView2 = this.nickView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickView");
        } else {
            textView = textView2;
        }
        textView.setText(this.anchorInfo.f395729a.f395737c);
        View findViewById3 = getRootView().findViewById(R.id.tln);
        TextView textView3 = (TextView) findViewById3;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: km3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorInvitingWhenLinkingView.C0(view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById<Te\u2026)\n            }\n        }");
        this.cancelInviteBtn = textView3;
        AnchorOperateLinkDialog.a aVar = this.dialogCallBack;
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        aVar.setTitle(c.c(context, this.bizType));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eventor.removeAll();
    }
}
