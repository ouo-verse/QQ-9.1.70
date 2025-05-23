package com.tencent.guildlive.aio.msglist.holder.component;

import android.net.Uri;
import com.tencent.aio.data.AIOParam;
import com.tencent.avbiz.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.api.IGuildChannelInfoApi;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVerifyShareInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.fg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.ez;

/* compiled from: P */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0007*\u0001)\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002J.\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001cH\u0016R\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/holder/component/GuildLiveItemBaseVM;", "Lcom/tencent/guild/aio/msglist/holder/component/t;", "Lcom/tencent/guildlive/aio/msglist/holder/component/v;", "intent", "", "v", "", "guildID", "channelID", "", HippyTKDListViewAdapter.X, "inviteCode", "contentId", "shortUrl", "Lwh2/ez;", "cb", "r", "", "type", "p", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "", "y", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "u", "Lol3/b;", "handleIntent", "Lcom/tencent/mobileqq/guild/api/IQQGuildRouterApi;", "d", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/guild/api/IQQGuildRouterApi;", "routerApi", "Lcom/tencent/mobileqq/guild/api/IGuildChannelInfoApi;", "e", "o", "()Lcom/tencent/mobileqq/guild/api/IGuildChannelInfoApi;", "channelInfoApi", "com/tencent/guildlive/aio/msglist/holder/component/GuildLiveItemBaseVM$a", "f", "Lcom/tencent/guildlive/aio/msglist/holder/component/GuildLiveItemBaseVM$a;", "mAction", "<init>", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class GuildLiveItemBaseVM extends com.tencent.guild.aio.msglist.holder.component.t {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy routerApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy channelInfoApi;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guildlive/aio/msglist/holder/component/GuildLiveItemBaseVM$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        a() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildLiveItemBaseVM.this.u(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public GuildLiveItemBaseVM() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IQQGuildRouterApi>() { // from class: com.tencent.guildlive.aio.msglist.holder.component.GuildLiveItemBaseVM$routerApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IQQGuildRouterApi invoke() {
                return (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
            }
        });
        this.routerApi = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IGuildChannelInfoApi>() { // from class: com.tencent.guildlive.aio.msglist.holder.component.GuildLiveItemBaseVM$channelInfoApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGuildChannelInfoApi invoke() {
                return (IGuildChannelInfoApi) QRoute.api(IGuildChannelInfoApi.class);
            }
        });
        this.channelInfoApi = lazy2;
        this.mAction = new a();
    }

    private final IGuildChannelInfoApi o() {
        return (IGuildChannelInfoApi) this.channelInfoApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p(int type) {
        if (type != 2) {
            if (type != 5) {
                if (type != 8) {
                    return "";
                }
                return Constants.Business.QQ_META_ROOM;
            }
            return "\u76f4\u64ad\u5b50\u9891\u9053";
        }
        return "\u97f3\u89c6\u9891\u5b50\u9891\u9053";
    }

    private final IQQGuildRouterApi q() {
        return (IQQGuildRouterApi) this.routerApi.getValue();
    }

    private final void r(String inviteCode, String contentId, String shortUrl, final ez cb5) {
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
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        fg fgVar = new fg();
        fgVar.f(inviteCode);
        fgVar.e(contentId);
        fgVar.g(shortUrl);
        if (iGPSService != null) {
            iGPSService.getGuildVerifyShareInfo(fgVar, new ez() { // from class: com.tencent.guildlive.aio.msglist.holder.component.m
                @Override // wh2.ez
                public final void a(int i3, String str, IGProVerifyShareInfoRsp iGProVerifyShareInfoRsp) {
                    GuildLiveItemBaseVM.t(ez.this, i3, str, iGProVerifyShareInfoRsp);
                }
            });
        }
    }

    static /* synthetic */ void s(GuildLiveItemBaseVM guildLiveItemBaseVM, String str, String str2, String str3, ez ezVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                str = "";
            }
            if ((i3 & 2) != 0) {
                str2 = "";
            }
            if ((i3 & 4) != 0) {
                str3 = "";
            }
            guildLiveItemBaseVM.r(str, str2, str3, ezVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getShareInfo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ez cb5, int i3, String errMsg, IGProVerifyShareInfoRsp rsp) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        cb5.a(i3, errMsg, rsp);
    }

    private final void v(final v intent) {
        String str;
        ez ezVar = new ez() { // from class: com.tencent.guildlive.aio.msglist.holder.component.l
            @Override // wh2.ez
            public final void a(int i3, String str2, IGProVerifyShareInfoRsp iGProVerifyShareInfoRsp) {
                GuildLiveItemBaseVM.w(GuildLiveItemBaseVM.this, intent, i3, str2, iGProVerifyShareInfoRsp);
            }
        };
        if (q().isGuildShortUrl(intent.getUrl())) {
            s(this, null, null, intent.getUrl(), ezVar, 3, null);
            return;
        }
        Uri parse = Uri.parse(intent.getUrl());
        String queryParameter = parse.getQueryParameter("inviteCode");
        if (queryParameter == null) {
            str = "";
        } else {
            str = queryParameter;
        }
        String queryParameter2 = parse.getQueryParameter("contentID");
        if (queryParameter2 == null) {
            queryParameter2 = "";
        }
        s(this, str, queryParameter2, null, ezVar, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(final GuildLiveItemBaseVM this$0, final v intent, int i3, String str, final IGProVerifyShareInfoRsp iGProVerifyShareInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        if (i3 == 0 && iGProVerifyShareInfoRsp.getGuildInfo() != null) {
            GuildLiveLogUtil.INSTANCE.c(FrameworkVM.TAG, "inviteInfo.guildID[" + iGProVerifyShareInfoRsp.getGuildInfo().getGuildId() + "] [" + iGProVerifyShareInfoRsp.getGuildInfo().getChannel() + "]");
            if (this$0.x(String.valueOf(iGProVerifyShareInfoRsp.getGuildInfo().getGuildId()), String.valueOf(iGProVerifyShareInfoRsp.getGuildInfo().getChannel()))) {
                this$0.updateUI(new TextUrlLinkOriginJump(intent.getUrl(), intent.getMsgRecord(), intent.getCom.tencent.aelight.camera.constants.AECameraConstants.HOT_ENTRY_TYPE_WIDGET java.lang.String()));
                return;
            } else {
                this$0.o().fetchChannelInfoAnyway(String.valueOf(iGProVerifyShareInfoRsp.getGuildInfo().getGuildId()), String.valueOf(iGProVerifyShareInfoRsp.getGuildInfo().getChannel()), new Function1<IGProChannelInfo, Unit>() { // from class: com.tencent.guildlive.aio.msglist.holder.component.GuildLiveItemBaseVM$handleUrlLinkClick$cb$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IGProChannelInfo iGProChannelInfo) {
                        invoke2(iGProChannelInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable final IGProChannelInfo iGProChannelInfo) {
                        String p16;
                        if (iGProChannelInfo != null) {
                            p16 = GuildLiveItemBaseVM.this.p(iGProChannelInfo.getType());
                            if (p16.length() == 0) {
                                GuildLiveLogUtil.INSTANCE.e(FrameworkVM.TAG, "fetch channel, tips is empty.");
                                GuildLiveItemBaseVM.this.updateUI(new TextUrlLinkOriginJump(intent.getUrl(), intent.getMsgRecord(), intent.getCom.tencent.aelight.camera.constants.AECameraConstants.HOT_ENTRY_TYPE_WIDGET java.lang.String()));
                                return;
                            }
                            String str2 = "\u8fdb\u5165" + p16 + "\u5c06\u9000\u51fa\u5f53\u524d\u5b50\u9891\u9053\uff0c\u662f\u5426\u7ee7\u7eed\uff1f";
                            if (iGProChannelInfo.getType() == 5) {
                                GuildLiveItemBaseVM guildLiveItemBaseVM = GuildLiveItemBaseVM.this;
                                final IGProVerifyShareInfoRsp iGProVerifyShareInfoRsp2 = iGProVerifyShareInfoRsp;
                                guildLiveItemBaseVM.updateUI(new TextUrlLinkJumpTips(str2, new Function0<Unit>() { // from class: com.tencent.guildlive.aio.msglist.holder.component.GuildLiveItemBaseVM$handleUrlLinkClick$cb$1$1.1
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
                                        ((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).switchLiveChannel(IGProChannelInfo.this, iGProVerifyShareInfoRsp2.getGuildInfo().getJoinGuildSig());
                                    }
                                }));
                                return;
                            }
                            GuildLiveItemBaseVM.this.updateUI(new TextUrlLinkOriginJumpTips(str2, intent.getUrl(), intent.getMsgRecord(), intent.getCom.tencent.aelight.camera.constants.AECameraConstants.HOT_ENTRY_TYPE_WIDGET java.lang.String()));
                            return;
                        }
                        GuildLiveItemBaseVM.this.updateUI(new TextUrlLinkOriginJump(intent.getUrl(), intent.getMsgRecord(), intent.getCom.tencent.aelight.camera.constants.AECameraConstants.HOT_ENTRY_TYPE_WIDGET java.lang.String()));
                        GuildLiveLogUtil.INSTANCE.d(FrameworkVM.TAG, "fetch channel info is null.");
                    }
                });
                return;
            }
        }
        GuildLiveLogUtil.INSTANCE.d(FrameworkVM.TAG, "result[" + i3 + "] errMsg[" + str + "] inviteInfo[" + iGProVerifyShareInfoRsp.getGuildInfo() + "]");
        this$0.updateUI(new TextUrlLinkOriginJump(intent.getUrl(), intent.getMsgRecord(), intent.getCom.tencent.aelight.camera.constants.AECameraConstants.HOT_ENTRY_TYPE_WIDGET java.lang.String()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean x(String guildID, String channelID) {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        if (Intrinsics.areEqual(com.tencent.guild.aio.util.a.g(g16), guildID)) {
            AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
            if (Intrinsics.areEqual(com.tencent.guild.aio.util.a.b(g17), channelID)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.handleIntent(intent);
        if (intent instanceof v) {
            v((v) intent);
        }
    }

    public void u(@NotNull MsgIntent i3) {
        Intrinsics.checkNotNullParameter(i3, "i");
    }

    @Nullable
    public List<String> y() {
        return null;
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        List<String> y16 = y();
        if (y16 != null) {
            Iterator<T> it = y16.iterator();
            while (it.hasNext()) {
                context.e().d((String) it.next(), this.mAction);
            }
        }
    }
}
