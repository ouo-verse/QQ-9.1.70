package com.tencent.now.linkpkanchorplay.linkscreen.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.now.app.misc.ui.UIUtil;
import com.tencent.now.linkpkanchorplay.base.LinkPKHeadImageView;
import com.tencent.now.linkpkanchorplay.event.d;
import com.tencent.now.linkpkanchorplay.linkscreen.view.AnchorOperateLinkDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import om3.d;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0014R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorInRankPKOperateView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "initView", "C0", "Lom3/d;", "oldState", "curState", "", "B0", NodeProps.ON_DETACHED_FROM_WINDOW, "", "d", "I", "pkType", "Le55/a;", "e", "Le55/a;", "anchorInfo", "Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog$a;", "f", "Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog$a;", "dialogCallBack", "Lcom/tencent/now/linkpkanchorplay/base/LinkPKHeadImageView;", h.F, "Lcom/tencent/now/linkpkanchorplay/base/LinkPKHeadImageView;", "avatarView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "nickName", "Lcom/tencent/component/core/event/Eventor;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/component/core/event/Eventor;", "eventor", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;ILe55/a;Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog$a;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AnchorInRankPKOperateView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int pkType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e55.a anchorInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnchorOperateLinkDialog.a dialogCallBack;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LinkPKHeadImageView avatarView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView nickName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Eventor eventor;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkpkanchorplay/linkscreen/view/AnchorInRankPKOperateView$a", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/now/linkpkanchorplay/event/d$h;", "event", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements OnEvent<d.StateChangeEvent> {
        a() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull d.StateChangeEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (AnchorInRankPKOperateView.this.B0(event.getOldState(), event.getCurState())) {
                AnchorInRankPKOperateView.this.dialogCallBack.onClose();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorInRankPKOperateView(@NotNull Context context, int i3, @NotNull e55.a anchorInfo, @NotNull AnchorOperateLinkDialog.a dialogCallBack) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(anchorInfo, "anchorInfo");
        Intrinsics.checkNotNullParameter(dialogCallBack, "dialogCallBack");
        this.pkType = i3;
        this.anchorInfo = anchorInfo;
        this.dialogCallBack = dialogCallBack;
        this.eventor = new Eventor();
        View.inflate(context, R.layout.fds, this);
        initView();
        C0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean B0(om3.d oldState, om3.d curState) {
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

    private final void C0() {
        this.eventor.addOnEvent(new a());
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
        AnchorOperateLinkDialog.a aVar = this.dialogCallBack;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        aVar.setTitle(fn3.c.b(context, this.pkType));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eventor.removeAll();
    }
}
