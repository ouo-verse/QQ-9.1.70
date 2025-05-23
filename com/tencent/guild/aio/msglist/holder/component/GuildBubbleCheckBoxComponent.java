package com.tencent.guild.aio.msglist.holder.component;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.msglist.holder.component.i;
import com.tencent.guild.aio.msglist.holder.component.s;
import com.tencent.guild.aio.util.ex.FromScene;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 '2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u00a2\u0006\u0004\b%\u0010&J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0016\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0017\u0010\u001a\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/GuildBubbleCheckBoxComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "", "getTag", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/widget/FrameLayout;", tl.h.F, "Landroid/widget/FrameLayout;", "contentViewWrapper", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "i", "Lkotlin/Lazy;", "l1", "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "contentView", "<init>", "(Landroid/view/View;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildBubbleCheckBoxComponent extends a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout contentViewWrapper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    public GuildBubbleCheckBoxComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        this.contentViewWrapper = new FrameLayout(root.getContext());
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QUICheckBox>() { // from class: com.tencent.guild.aio.msglist.holder.component.GuildBubbleCheckBoxComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QUICheckBox invoke() {
                FrameLayout frameLayout;
                QUICheckBox qUICheckBox = new QUICheckBox(GuildBubbleCheckBoxComponent.this.getRoot().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(qUICheckBox.getContext().getResources().getDimensionPixelSize(R.dimen.chh), qUICheckBox.getContext().getResources().getDimensionPixelSize(R.dimen.che));
                layoutParams.setMargins(qUICheckBox.getContext().getResources().getDimensionPixelSize(R.dimen.chb), qUICheckBox.getContext().getResources().getDimensionPixelSize(R.dimen.chg), 0, 0);
                qUICheckBox.setLayoutParams(layoutParams);
                frameLayout = GuildBubbleCheckBoxComponent.this.contentViewWrapper;
                frameLayout.addView(qUICheckBox);
                return qUICheckBox;
            }
        });
        this.contentView = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(GuildBubbleCheckBoxComponent this$0, GuildMultiMsgManager selectManager, GuildMultiMsgManager.d session, com.tencent.aio.data.msglist.a msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(selectManager, "$selectManager");
        Intrinsics.checkNotNullParameter(session, "$session");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        if (this$0.l1().isChecked()) {
            selectManager.b(session, (GuildMsgItem) msgItem);
        } else {
            selectManager.k(session, (GuildMsgItem) msgItem);
        }
        this$0.sendIntent(i.a.f111543d);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final QUICheckBox l1() {
        return (QUICheckBox) this.contentView.getValue();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        int ordinal;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        final GuildMultiMsgManager a16 = GuildMultiMsgManager.INSTANCE.a();
        s.AioContextWrapper aioContextWrapper = new s.AioContextWrapper(null, 1, null);
        sendIntent(new s.GetAioContext(aioContextWrapper));
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        String str = guildMsgItem.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.channelId");
        com.tencent.aio.api.runtime.a context = aioContextWrapper.getContext();
        if (context != null) {
            ordinal = com.tencent.guild.aio.util.ex.a.d(context);
        } else {
            ordinal = FromScene.DEFAULT.ordinal();
        }
        final GuildMultiMsgManager.d dVar = new GuildMultiMsgManager.d(str, ordinal);
        if (a16.i(dVar) && !guildMsgItem.isReviewingMsg()) {
            l1().setVisibility(0);
            l1().setChecked(a16.h(dVar, guildMsgItem));
            l1().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.holder.component.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildBubbleCheckBoxComponent.k1(GuildBubbleCheckBoxComponent.this, a16, dVar, msgItem, view);
                }
            });
            this.contentViewWrapper.setVisibility(0);
            return;
        }
        this.contentViewWrapper.setVisibility(8);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return this.contentViewWrapper;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new j();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public String getTag() {
        return "GuildBubbleCheckBoxComponent";
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }
}
