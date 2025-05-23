package com.tencent.qqguild.directmessage.aio.graytips.local.robotblack;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.model.data.MessageSource;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.guild.robot.api.IRobotDaTongApi;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vh2.cd;
import vp1.dg;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 12\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0010\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0016\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015H\u0016R\u0017\u0010\u001c\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010&R\u0018\u0010\u0007\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/graytips/local/robotblack/GuildBlackRobotGrayTipsComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "b1", ICustomDataEditor.NUMBER_PARAM_1, "Lcom/tencent/mvi/base/mvi/MviUIState;", "state", "handleUIState", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "e1", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Lvp1/dg;", h.F, "Lkotlin/Lazy;", "m1", "()Lvp1/dg;", "mBinding", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "i", "l1", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gpsService", "Lcom/tencent/qqguild/directmessage/aio/graytips/local/robotblack/GuildBlackRobotGrayTipsMsgItem;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqguild/directmessage/aio/graytips/local/robotblack/GuildBlackRobotGrayTipsMsgItem;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "observer", "<init>", "(Landroid/view/View;)V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class GuildBlackRobotGrayTipsComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver observer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBinding;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy gpsService;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildBlackRobotGrayTipsMsgItem msgItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/qqguild/directmessage/aio/graytips/local/robotblack/GuildBlackRobotGrayTipsComponent$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "tinyId", "", "isBlack", "", "onDirectMsgBlackChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDirectMsgBlackChanged(@Nullable String tinyId, boolean isBlack) {
            super.onDirectMsgBlackChanged(tinyId, isBlack);
            if (GuildBlackRobotGrayTipsComponent.this.msgItem != null) {
                GuildBlackRobotGrayTipsComponent guildBlackRobotGrayTipsComponent = GuildBlackRobotGrayTipsComponent.this;
                GuildBlackRobotGrayTipsMsgItem guildBlackRobotGrayTipsMsgItem = guildBlackRobotGrayTipsComponent.msgItem;
                Intrinsics.checkNotNull(guildBlackRobotGrayTipsMsgItem);
                if (Intrinsics.areEqual(guildBlackRobotGrayTipsMsgItem.getRobotTid(), tinyId)) {
                    GuildBlackRobotGrayTipsMsgItem guildBlackRobotGrayTipsMsgItem2 = guildBlackRobotGrayTipsComponent.msgItem;
                    Intrinsics.checkNotNull(guildBlackRobotGrayTipsMsgItem2);
                    guildBlackRobotGrayTipsMsgItem2.setBlack(isBlack);
                    GuildBlackRobotGrayTipsMsgItem guildBlackRobotGrayTipsMsgItem3 = guildBlackRobotGrayTipsComponent.msgItem;
                    Intrinsics.checkNotNull(guildBlackRobotGrayTipsMsgItem3);
                    guildBlackRobotGrayTipsComponent.n1(guildBlackRobotGrayTipsMsgItem3);
                }
            }
        }
    }

    public GuildBlackRobotGrayTipsComponent(@NotNull View root) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<dg>() { // from class: com.tencent.qqguild.directmessage.aio.graytips.local.robotblack.GuildBlackRobotGrayTipsComponent$mBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final dg invoke() {
                dg g16 = dg.g(LayoutInflater.from(GuildBlackRobotGrayTipsComponent.this.getRoot().getContext()), null, false);
                ImageView imageView = g16.f442895d;
                GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
                Context context = g16.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "root.context");
                imageView.setImageDrawable(guildUIUtils.A(context, R.drawable.qui_mail, R.color.qui_common_icon_secondary));
                Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, null, \u2026\n            ))\n        }");
                return g16;
            }
        });
        this.mBinding = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IGPSService>() { // from class: com.tencent.qqguild.directmessage.aio.graytips.local.robotblack.GuildBlackRobotGrayTipsComponent$gpsService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IGPSService invoke() {
                return (IGPSService) ch.S0(IGPSService.class, "");
            }
        });
        this.gpsService = lazy2;
        this.observer = new b();
    }

    private final IGPSService l1() {
        Object value = this.gpsService.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-gpsService>(...)");
        return (IGPSService) value;
    }

    private final dg m1() {
        return (dg) this.mBinding.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(final com.tencent.aio.data.msglist.a msgItem, final GuildBlackRobotGrayTipsComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildBlackRobotGrayTipsMsgItem guildBlackRobotGrayTipsMsgItem = (GuildBlackRobotGrayTipsMsgItem) msgItem;
        if (!guildBlackRobotGrayTipsMsgItem.getIsBlack()) {
            this$0.l1().setDirectMsgBlack(guildBlackRobotGrayTipsMsgItem.getRobotTid(), !guildBlackRobotGrayTipsMsgItem.getIsBlack(), new cd() { // from class: com.tencent.qqguild.directmessage.aio.graytips.local.robotblack.b
                @Override // vh2.cd
                public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                    GuildBlackRobotGrayTipsComponent.p1(GuildBlackRobotGrayTipsComponent.this, msgItem, i3, str, iGProSecurityResult);
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(GuildBlackRobotGrayTipsComponent this$0, com.tencent.aio.data.msglist.a msgItem, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        if (!TextUtils.isEmpty(str)) {
            QQToast.makeText(this$0.getMContext(), str, 1).show();
            return;
        }
        QQToast.makeText(this$0.getMContext(), 5, HardCodeUtil.qqStr(R.string.f153611ck), 1).show();
        this$0.m1().f442894c.setText(HardCodeUtil.qqStr(R.string.f153611ck));
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        TextView textView = this$0.m1().f442894c;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.guildRobotBlackTips");
        guildUIUtils.b(textView, R.color.qui_common_text_secondary);
        ((GuildBlackRobotGrayTipsMsgItem) msgItem).setBlack(true);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        n1(msgItem);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        LinearLayout root = m1().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new GuildBlackRobotGrayTipsVM();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
    }

    public final void n1(@NotNull final com.tencent.aio.data.msglist.a msgItem) {
        MessageSource messageSource;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof GuildBlackRobotGrayTipsMsgItem) {
            GuildBlackRobotGrayTipsMsgItem guildBlackRobotGrayTipsMsgItem = (GuildBlackRobotGrayTipsMsgItem) msgItem;
            this.msgItem = guildBlackRobotGrayTipsMsgItem;
            if (guildBlackRobotGrayTipsMsgItem.getIsBlack()) {
                m1().f442894c.setText(HardCodeUtil.qqStr(R.string.f153611ck));
                GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
                TextView textView = m1().f442894c;
                Intrinsics.checkNotNullExpressionValue(textView, "mBinding.guildRobotBlackTips");
                guildUIUtils.b(textView, R.color.qui_button_text_secondary);
            } else {
                m1().f442894c.setText(HardCodeUtil.qqStr(R.string.f153701ct));
                GuildUIUtils guildUIUtils2 = GuildUIUtils.f235378a;
                TextView textView2 = m1().f442894c;
                Intrinsics.checkNotNullExpressionValue(textView2, "mBinding.guildRobotBlackTips");
                guildUIUtils2.b(textView2, R.color.qui_common_text_link);
            }
            DirectMessageNode C = DirectMessageNodeRepository.C(guildBlackRobotGrayTipsMsgItem.getAioContext().g().r().c().j());
            if (C != null) {
                messageSource = C.getSource();
            } else {
                messageSource = null;
            }
            if (messageSource != null) {
                ((IRobotDaTongApi) QRoute.api(IRobotDaTongApi.class)).reportBlackRobotGray(m1().f442893b, guildBlackRobotGrayTipsMsgItem.getRobotTid(), messageSource.getNickName());
            }
            m1().f442894c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqguild.directmessage.aio.graytips.local.robotblack.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildBlackRobotGrayTipsComponent.o1(com.tencent.aio.data.msglist.a.this, this, view);
                }
            });
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        l1().addObserver(this.observer);
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        l1().deleteObserver(this.observer);
    }
}
