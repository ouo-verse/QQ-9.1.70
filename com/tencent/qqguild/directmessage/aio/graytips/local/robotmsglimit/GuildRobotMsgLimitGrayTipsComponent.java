package com.tencent.qqguild.directmessage.aio.graytips.local.robotmsglimit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.qroute.QRoute;
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
import tl.h;
import vp1.di;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 !2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001f\u0010 J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0016\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010H\u0016R\u0017\u0010\u0018\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/graytips/local/robotmsglimit/GuildRobotMsgLimitGrayTipsComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Lvp1/di;", h.F, "Lkotlin/Lazy;", "k1", "()Lvp1/di;", "mBinding", "<init>", "(Landroid/view/View;)V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class GuildRobotMsgLimitGrayTipsComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBinding;

    public GuildRobotMsgLimitGrayTipsComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<di>() { // from class: com.tencent.qqguild.directmessage.aio.graytips.local.robotmsglimit.GuildRobotMsgLimitGrayTipsComponent$mBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final di invoke() {
                di g16 = di.g(LayoutInflater.from(GuildRobotMsgLimitGrayTipsComponent.this.getRoot().getContext()), null, false);
                ImageView imageView = g16.f442912d;
                GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
                Context context = g16.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "root.context");
                imageView.setImageDrawable(guildUIUtils.A(context, R.drawable.qui_notify, R.color.qui_common_icon_secondary));
                Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            inf\u2026\n            ))\n        }");
                return g16;
            }
        });
        this.mBinding = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(com.tencent.aio.data.msglist.a msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        GuildRobotMsgLimitGrayTipsMsgItem guildRobotMsgLimitGrayTipsMsgItem = (GuildRobotMsgLimitGrayTipsMsgItem) msgItem;
        ((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).openRobotActiveMsgControlDialogFragment(guildRobotMsgLimitGrayTipsMsgItem.getAioContext().c().getActivity(), guildRobotMsgLimitGrayTipsMsgItem.getGuildId(), guildRobotMsgLimitGrayTipsMsgItem.getRobotTid(), "", guildRobotMsgLimitGrayTipsMsgItem.getRobotName());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final di k1() {
        return (di) this.mBinding.getValue();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (msgItem instanceof GuildRobotMsgLimitGrayTipsMsgItem) {
            k1().f442911c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqguild.directmessage.aio.graytips.local.robotmsglimit.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildRobotMsgLimitGrayTipsComponent.j1(com.tencent.aio.data.msglist.a.this, view);
                }
            });
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        LinearLayout root = k1().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new c();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
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
