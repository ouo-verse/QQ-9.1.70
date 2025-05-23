package com.tencent.guildlive.aio.msglist.holder.component;

import android.content.DialogInterface;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msglist.IGuildAIOLinkSpanApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 I2\u00020\u0001:\u0001JB\u0007\u00a2\u0006\u0004\bG\u0010HJ\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J \u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u001c\u0010\u0016\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\u0016\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001dH\u0016J&\u0010'\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\"2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(H\u0014J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(H\u0014J\b\u0010,\u001a\u00020\u0015H\u0014J\b\u0010-\u001a\u00020\u0015H\u0004J\u0010\u0010/\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u000bH\u0014J \u00100\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0004J\u0010\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u001fH\u0016R\u0016\u00105\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R$\u0010)\u001a\u0004\u0018\u00010(8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010>\u001a\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/holder/component/AbsGuildLiveComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "tips", "Lkotlin/Function0;", "", "nextFunction", "C1", "url", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "F1", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", ICustomDataEditor.NUMBER_PARAM_1, "", "type", "y1", "guildId", "tinyId", "", "v1", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "q1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "b1", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "currentMsgItem", "z1", "A1", "w1", "u1", "root", ICustomDataEditor.STRING_PARAM_1, "x1", "state", "handleUIState", "f", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gpsObserver", tl.h.F, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "o1", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "B1", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)V", "Lcom/tencent/mobileqq/guild/api/IQQGuildRouterApi;", "i", "Lkotlin/Lazy;", "r1", "()Lcom/tencent/mobileqq/guild/api/IQQGuildRouterApi;", "routerApi", "Lcom/tencent/mobileqq/guild/util/IGuildFastClickUtilApi;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p1", "()Lcom/tencent/mobileqq/guild/util/IGuildFastClickUtilApi;", "fastClickApi", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class AbsGuildLiveComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final GPServiceObserver gpsObserver = n1();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMsgItem currentMsgItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy routerApi;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy fastClickApi;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/guildlive/aio/msglist/holder/component/AbsGuildLiveComponent$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "tinyId", "", "onMemberTopRoleChanged", "onUserDisplayNameUpdate", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onMemberTopRoleChanged(@Nullable String guildId, @Nullable String tinyId) {
            if (AbsGuildLiveComponent.this.v1(guildId, tinyId)) {
                AbsGuildLiveComponent.this.y1(2);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(@Nullable String tinyId) {
            String str;
            MsgRecord msgRecord;
            GuildMsgItem currentMsgItem = AbsGuildLiveComponent.this.getCurrentMsgItem();
            if (currentMsgItem != null && (msgRecord = currentMsgItem.getMsgRecord()) != null) {
                str = msgRecord.senderUid;
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, tinyId)) {
                AbsGuildLiveComponent.this.y1(1);
            }
        }
    }

    public AbsGuildLiveComponent() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IQQGuildRouterApi>() { // from class: com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent$routerApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IQQGuildRouterApi invoke() {
                return (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
            }
        });
        this.routerApi = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IGuildFastClickUtilApi>() { // from class: com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent$fastClickApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGuildFastClickUtilApi invoke() {
                return (IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class);
            }
        });
        this.fastClickApi = lazy2;
    }

    private final void C1(String tips, final Function0<Unit> nextFunction) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getMContext(), 0, null, tips, null, null);
        createCustomDialog.setNegativeButton(getMContext().getString(R.string.cancel), 0, new DialogInterface.OnClickListener() { // from class: com.tencent.guildlive.aio.msglist.holder.component.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AbsGuildLiveComponent.D1(dialogInterface, i3);
            }
        });
        createCustomDialog.setPositiveButton(getMContext().getString(R.string.d_d), 0, new DialogInterface.OnClickListener() { // from class: com.tencent.guildlive.aio.msglist.holder.component.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AbsGuildLiveComponent.E1(Function0.this, dialogInterface, i3);
            }
        });
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(Function0 nextFunction, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(nextFunction, "$nextFunction");
        nextFunction.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F1(String url, MsgRecord msgRecord, View widget) {
        HashMap hashMap = new HashMap();
        String str = msgRecord.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.guildId");
        hashMap.put("sgrp_channel_id", str);
        String str2 = msgRecord.channelId;
        Intrinsics.checkNotNullExpressionValue(str2, "msgRecord.channelId");
        hashMap.put("sgrp_sub_channel_id", str2);
        VideoReport.reportEvent("ev_sgrp_click_link", hashMap);
        ((IGuildAIOLinkSpanApi) QRoute.api(IGuildAIOLinkSpanApi.class)).onClick(url, "biz_src_jc_aio", widget, msgRecord);
    }

    private final GPServiceObserver n1() {
        if (!w1()) {
            return null;
        }
        return new b();
    }

    private final IGuildFastClickUtilApi p1() {
        return (IGuildFastClickUtilApi) this.fastClickApi.getValue();
    }

    private final IGPSService q1() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        return (IGPSService) iRuntimeService;
    }

    private final IQQGuildRouterApi r1() {
        return (IQQGuildRouterApi) this.routerApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean v1(String guildId, String tinyId) {
        String str;
        MsgRecord msgRecord;
        MsgRecord msgRecord2;
        GuildMsgItem guildMsgItem = this.currentMsgItem;
        String str2 = null;
        if (guildMsgItem != null && (msgRecord2 = guildMsgItem.getMsgRecord()) != null) {
            str = msgRecord2.guildId;
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, guildId)) {
            GuildMsgItem guildMsgItem2 = this.currentMsgItem;
            if (guildMsgItem2 != null && (msgRecord = guildMsgItem2.getMsgRecord()) != null) {
                str2 = msgRecord.senderUid;
            }
            if (Intrinsics.areEqual(str2, tinyId)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y1(int type) {
        GuildMsgItem guildMsgItem = this.currentMsgItem;
        if (guildMsgItem == null) {
            return;
        }
        if (type != 1) {
            if (type == 2) {
                Intrinsics.checkNotNull(guildMsgItem);
                A1(guildMsgItem);
                return;
            }
            return;
        }
        Intrinsics.checkNotNull(guildMsgItem);
        z1(guildMsgItem);
    }

    protected void A1(@NotNull GuildMsgItem currentMsgItem) {
        Intrinsics.checkNotNullParameter(currentMsgItem, "currentMsgItem");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void B1(@Nullable GuildMsgItem guildMsgItem) {
        this.currentMsgItem = guildMsgItem;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (msgItem instanceof GuildMsgItem) {
            this.currentMsgItem = (GuildMsgItem) msgItem;
        } else {
            this.currentMsgItem = null;
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new GuildLiveItemBaseVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull final MviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        if (state instanceof TextUrlLinkJumpTips) {
            C1(((TextUrlLinkJumpTips) state).getTips(), new Function0<Unit>() { // from class: com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent$handleUIState$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((TextUrlLinkJumpTips) MviUIState.this).a().invoke();
                }
            });
            return;
        }
        if (state instanceof TextUrlLinkOriginJumpTips) {
            C1(((TextUrlLinkOriginJumpTips) state).getTips(), new Function0<Unit>() { // from class: com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent$handleUIState$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).isSelfLivingAndPushFlowType(Boolean.TRUE)) {
                        return;
                    }
                    AbsGuildLiveComponent.this.F1(((TextUrlLinkOriginJumpTips) state).getUrl(), ((TextUrlLinkOriginJumpTips) state).getMsgRecord(), ((TextUrlLinkOriginJumpTips) state).getWidget());
                }
            });
        } else if (state instanceof TextUrlLinkOriginJump) {
            TextUrlLinkOriginJump textUrlLinkOriginJump = (TextUrlLinkOriginJump) state;
            F1(textUrlLinkOriginJump.getUrl(), textUrlLinkOriginJump.getMsgRecord(), textUrlLinkOriginJump.getCom.tencent.aelight.camera.constants.AECameraConstants.HOT_ENTRY_TYPE_WIDGET java.lang.String());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: o1, reason: from getter */
    public final GuildMsgItem getCurrentMsgItem() {
        return this.currentMsgItem;
    }

    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        IGPSService q16 = q1();
        if (q16 != null) {
            q16.addObserver(this.gpsObserver);
        }
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        IGPSService q16 = q1();
        if (q16 != null) {
            q16.deleteObserver(this.gpsObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean s1(@NotNull View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        return !u1();
    }

    protected final boolean u1() {
        return ((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).guildLiveVideoIsLandScreenState();
    }

    protected boolean w1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean x1(@NotNull String url, @NotNull MsgRecord msgRecord, @NotNull View widget) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(widget, "widget");
        if (u1() || p1().isFastClick(widget)) {
            return true;
        }
        if (r1().isGuildShareUrl(url)) {
            sendIntent(new v(url, msgRecord, widget));
            return true;
        }
        return false;
    }

    protected void z1(@NotNull GuildMsgItem currentMsgItem) {
        Intrinsics.checkNotNullParameter(currentMsgItem, "currentMsgItem");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(DialogInterface dialogInterface, int i3) {
    }
}
