package com.tencent.guild.api.gift.impl;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.gift.IGuildGiftApi;
import com.tencent.guild.api.gift.impl.GuildGiftApiImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.vas.IGuildGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.b;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.ISlowModeInfo;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.TextGiftElement;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import nh2.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J2\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/guild/api/gift/impl/GuildGiftApiImpl;", "Lcom/tencent/guild/api/gift/IGuildGiftApi;", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", "initGiftAnimationEngine", "", "getQQLiveSecretKey", "", "appInfoUinType", "", "isGuild", "channelId", "Lcom/tencent/mobileqq/qqguildsdk/data/ISlowModeInfo;", "getSlowModeInfo", "isTextPanel", ReportConstant.COSTREPORT_PREFIX, "preLoadGiftData", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "guildMsgItem", "isClick", "isNewGiftMessage", "guildId", "startGiftAnimation", "releaseAnimationEngine", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "handleGiftBtnClick", "exitRoom", "enterRoom", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/b;", "animationEngine", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/b;", "GIFT_LEVEL_PRIMARY", "I", "<init>", "()V", "a", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildGiftApiImpl implements IGuildGiftApi {
    private final int GIFT_LEVEL_PRIMARY = 1;

    @Nullable
    private b animationEngine;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/api/gift/impl/GuildGiftApiImpl$a;", "Landroidx/activity/result/ActivityResultCallback;", "Landroidx/activity/result/ActivityResult;", "result", "", "a", "", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "<init>", "(Ljava/lang/String;)V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements ActivityResultCallback<ActivityResult> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String guildId;

        public a(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            this.guildId = guildId;
        }

        @Override // androidx.activity.result.ActivityResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(@Nullable ActivityResult result) {
            boolean z16;
            String str;
            if (result != null && result.getResultCode() == -1 && result.getData() != null) {
                Intent data = result.getData();
                Intrinsics.checkNotNull(data);
                String[] stringArrayExtra = data.getStringArrayExtra(IQQGuildRouterApi.SELECT_MEMBER_LIST);
                Intent data2 = result.getData();
                Intrinsics.checkNotNull(data2);
                String[] stringArrayExtra2 = data2.getStringArrayExtra(IQQGuildRouterApi.SELECT_MEMBER_NAME_LIST);
                if (stringArrayExtra != null) {
                    if (stringArrayExtra.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        if (stringArrayExtra2 == null || stringArrayExtra2.length != 1 || (str = stringArrayExtra2[0]) == null) {
                            str = "";
                        }
                        String str2 = stringArrayExtra[0];
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        Drawable avatarDrawable = ((IQQGuildAvatarApi) peekAppRuntime.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(peekAppRuntime, this.guildId, str2);
                        Intrinsics.checkNotNullExpressionValue(avatarDrawable, "app.getRuntimeService<IQ\u2026ble(app, guildId, tinyId)");
                        ((IGuildGiftManager) QRoute.api(IGuildGiftManager.class)).setReceiverInfo(str2, str, avatarDrawable);
                    }
                }
            }
        }
    }

    private final String getQQLiveSecretKey() {
        if (QQLiveSDKConfigHelper.getSceneId() == 10001) {
            return "2ba343368f5483089089ae290adf298f";
        }
        return "571ab62646abd99881be652d3e250a39";
    }

    private final ISlowModeInfo getSlowModeInfo(String channelId) {
        IGProChannelInfo channelInfo = ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).getChannelInfo(channelId);
        Intrinsics.checkNotNullExpressionValue(channelInfo, "app.getRuntimeService<IG\u2026getChannelInfo(channelId)");
        Iterator<ISlowModeInfo> it = channelInfo.getGProSlowModeInfoList().iterator();
        while (it.hasNext()) {
            ISlowModeInfo next = it.next();
            if (next.getSlowModeKey() == channelInfo.getSlowModeKey()) {
                return next;
            }
        }
        return null;
    }

    private final void initGiftAnimationEngine(final com.tencent.aio.main.businesshelper.b param) {
        View view;
        Window window;
        Window window2;
        c sDKImpl = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getSceneId());
        if (sDKImpl == null) {
            QLog.e("GuildGiftHelper", 1, "giftSDK == null.");
            return;
        }
        if (this.animationEngine == null) {
            if (!sDKImpl.isInited()) {
                sDKImpl.c(MobileQQ.sMobileQQ.peekAppRuntime(), com.tencent.mobileqq.qqgift.sdk.config.a.a().d(QQLiveSDKConfigHelper.getSceneId()).a(getQQLiveSecretKey()).b());
            }
            b A = sDKImpl.d().A(param.a().c().getContext(), 0);
            this.animationEngine = A;
            if (A == null) {
                return;
            }
            Intrinsics.checkNotNull(A);
            A.prepare();
            b bVar = this.animationEngine;
            Intrinsics.checkNotNull(bVar);
            View k3 = bVar.k();
            Intrinsics.checkNotNullExpressionValue(k3, "animationEngine!!.giftAnimationView");
            k3.setOnClickListener(new View.OnClickListener() { // from class: ir0.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GuildGiftApiImpl.initGiftAnimationEngine$lambda$0(GuildGiftApiImpl.this, param, view2);
                }
            });
            FragmentActivity activity = param.a().c().getActivity();
            View view2 = null;
            if (activity != null && (window2 = activity.getWindow()) != null) {
                view = window2.getDecorView();
            } else {
                view = null;
            }
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) view).addView(k3, new RelativeLayout.LayoutParams(-1, -1));
            b bVar2 = this.animationEngine;
            Intrinsics.checkNotNull(bVar2);
            View b16 = bVar2.b();
            Intrinsics.checkNotNullExpressionValue(b16, "animationEngine!!.giftBannerView");
            FragmentActivity activity2 = param.a().c().getActivity();
            if (activity2 != null && (window = activity2.getWindow()) != null) {
                view2 = window.getDecorView();
            }
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) view2).addView(b16, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initGiftAnimationEngine$lambda$0(GuildGiftApiImpl this$0, com.tencent.aio.main.businesshelper.b param, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(param, "$param");
        b bVar = this$0.animationEngine;
        Intrinsics.checkNotNull(bVar);
        bVar.reset();
        param.a().e().h(new GuildMsgListIntent.StopGiftAnimationByUserEvent());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean isGuild(int appInfoUinType) {
        if (appInfoUinType == 10014) {
            return true;
        }
        return false;
    }

    private final boolean isTextPanel(com.tencent.aio.main.businesshelper.b param) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProChannelInfo iGProChannelInfo = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGProChannelInfo = iGPSService.getChannelInfo(param.a().g().r().c().j());
        }
        if (iGProChannelInfo == null || iGProChannelInfo.getType() != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.guild.api.gift.IGuildGiftApi
    public void enterRoom() {
        ((IGuildGiftManager) QRoute.api(IGuildGiftManager.class)).onFreeGiftCountDownStart();
    }

    @Override // com.tencent.guild.api.gift.IGuildGiftApi
    public void exitRoom() {
        ((IGuildGiftManager) QRoute.api(IGuildGiftManager.class)).onFreeGiftCountDownEnd();
    }

    @Override // com.tencent.guild.api.gift.IGuildGiftApi
    public void handleGiftBtnClick(@NotNull com.tencent.aio.part.root.panel.mvx.config.c panelParam, int appInfoUinType) {
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        IGuildGiftManager iGuildGiftManager = (IGuildGiftManager) QRoute.api(IGuildGiftManager.class);
        com.tencent.aio.api.runtime.a a16 = panelParam.a();
        AIOParam g16 = panelParam.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "panelParam.mAIOContext.aioParam");
        iGuildGiftManager.initGiftPanel(a16, new a(com.tencent.guild.aio.util.a.g(g16)));
        if (isGuild(appInfoUinType) && getSlowModeInfo(com.tencent.guild.aio.util.a.a(panelParam)) != null) {
            String string = mobileQQ.getString(R.string.f156871ld);
            Intrinsics.checkNotNullExpressionValue(string, "app.getString(com.tencen\u2026d_slow_mode_exceed_limit)");
            QQToast.makeText(BaseApplication.getContext(), 1, string, 0).show();
            return;
        }
        ((IGuildGiftManager) QRoute.api(IGuildGiftManager.class)).showGiftPanel(panelParam.a().c().getActivity());
    }

    @Override // com.tencent.guild.api.gift.IGuildGiftApi
    public void preLoadGiftData(@NotNull String s16) {
        Intrinsics.checkNotNullParameter(s16, "s");
        ((IGuildGiftManager) QRoute.api(IGuildGiftManager.class)).preLoadGiftData("");
    }

    @Override // com.tencent.guild.api.gift.IGuildGiftApi
    public void releaseAnimationEngine() {
        b bVar = this.animationEngine;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            bVar.release();
            this.animationEngine = null;
        }
    }

    @Override // com.tencent.guild.api.gift.IGuildGiftApi
    public void startGiftAnimation(@NotNull com.tencent.aio.main.businesshelper.b param, @NotNull GuildMsgItem guildMsgItem, boolean isClick, boolean isNewGiftMessage, @Nullable String guildId) {
        TextGiftElement textGiftElement;
        boolean z16;
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(guildMsgItem, "guildMsgItem");
        VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.INTENT_TO_PLAY, String.valueOf(QQLiveSDKConfigHelper.getSceneId()));
        if (this.animationEngine == null) {
            VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.PREPARE_ENGINE, String.valueOf(QQLiveSDKConfigHelper.getSceneId()));
            initGiftAnimationEngine(param);
        }
        if (this.animationEngine == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Iterator<MsgElement> it = guildMsgItem.getMsgRecord().elements.iterator();
        while (true) {
            if (it.hasNext()) {
                textGiftElement = it.next().textGiftElement;
                if (textGiftElement != null) {
                    break;
                }
            } else {
                textGiftElement = null;
                break;
            }
        }
        if (textGiftElement == null) {
            return;
        }
        String avatarUrl = ((IQQGuildAvatarApi) peekAppRuntime.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarUrl(peekAppRuntime, guildId, String.valueOf(textGiftElement.senderUin));
        String avatarUrl2 = ((IQQGuildAvatarApi) peekAppRuntime.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarUrl(peekAppRuntime, guildId, String.valueOf(textGiftElement.receiverUin));
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = new com.tencent.mobileqq.qqgift.mvvm.business.anim.a();
        aVar.f264914e = (int) textGiftElement.tianquanId;
        aVar.f264913d = textGiftElement.giftName;
        aVar.f264910a = (int) textGiftElement.giftId;
        aVar.f264915f = 1;
        aVar.f264918i = textGiftElement.senderUin;
        aVar.f264919j = textGiftElement.senderNick;
        aVar.f264920k = textGiftElement.receiverUin;
        aVar.f264921l = textGiftElement.receiverNick;
        aVar.f264922m = avatarUrl;
        aVar.f264923n = avatarUrl2;
        aVar.f264929t = true;
        if (textGiftElement.needPlayAnimation && isTextPanel(param)) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar.f264930u = z16;
        if (textGiftElement.level > this.GIFT_LEVEL_PRIMARY) {
            aVar.f264924o = 3;
        } else {
            aVar.f264924o = 1;
        }
        if (isClick) {
            aVar.f264916g = 100;
            b bVar = this.animationEngine;
            Intrinsics.checkNotNull(bVar);
            bVar.l(aVar, 0);
            return;
        }
        if (isNewGiftMessage) {
            aVar.f264916g = 100;
            b bVar2 = this.animationEngine;
            Intrinsics.checkNotNull(bVar2);
            bVar2.d(aVar);
            return;
        }
        b bVar3 = this.animationEngine;
        Intrinsics.checkNotNull(bVar3);
        bVar3.l(aVar, 0);
    }
}
