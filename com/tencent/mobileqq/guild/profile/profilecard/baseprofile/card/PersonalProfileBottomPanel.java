package com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.event.GuildSpeakThresholdAuthEvent;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.guild.temp.api.IGuildMakeQQFriendApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.bs;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildListSortInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.QQToastUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r12.a;
import wh2.eh;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u00012\u00020\u0002:\u0001AB'\b\u0007\u0012\u0006\u0010;\u001a\u00020:\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<\u0012\b\b\u0002\u0010>\u001a\u00020\u0010\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0002J\b\u0010\u0019\u001a\u00020\u0003H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u0003H\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u000e\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#J\u0016\u0010*\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(J\u000e\u0010+\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0005J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020#H\u0016R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00104\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010/R\u0016\u00107\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u00108\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/card/PersonalProfileBottomPanel;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "", HippyTKDListViewAdapter.X, "", ReportConstant.COSTREPORT_PREFIX, "p", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqguildsdk/data/IGuildSpeakableThresholdPermission;", QCircleDaTongConstant.ElementParamValue.PERMISSION, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "guildId", "dialogTip", "", "source", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "param", "v", "isQQFriend", "y", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isDirectMsg", "w", "t", "u", "g", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "service", "Lcom/tencent/mobileqq/qqguildsdk/data/i;", "i", "Landroid/view/View;", "parentView", "setLogicParent", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;", "guildProfileData", "Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/card/l;", "cardViewModel", "setParams", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, NodeProps.ON_CLICK, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "d", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mAddFriendBtn", "e", "mBtnDirectMessage", "f", "mSendGiftBtn", tl.h.F, "Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;", "mGuildProfileData", "Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/card/l;", "mCardViewModel", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class PersonalProfileBottomPanel extends LinearLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUIButton mAddFriendBtn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUIButton mBtnDirectMessage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUIButton mSendGiftBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GuildProfileData mGuildProfileData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private l mCardViewModel;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PersonalProfileBottomPanel(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        if (r4 != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void A() {
        boolean z16;
        int i3;
        boolean z17;
        GuildProfileData guildProfileData = this.mGuildProfileData;
        if (guildProfileData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
            guildProfileData = null;
        }
        int i16 = 0;
        if (w(guildProfileData.isDirectMessage())) {
            this.mBtnDirectMessage.setVisibility(0);
        } else {
            this.mBtnDirectMessage.setVisibility(8);
        }
        QUIButton qUIButton = this.mBtnDirectMessage;
        boolean z18 = true;
        if (this.mAddFriendBtn.getVisibility() == 8) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 2;
        }
        qUIButton.setType(i3);
        QUIButton qUIButton2 = this.mSendGiftBtn;
        if (this.mAddFriendBtn.getVisibility() == 8) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            if (this.mBtnDirectMessage.getVisibility() != 8) {
                z18 = false;
            }
        }
        i16 = 2;
        qUIButton2.setType(i16);
    }

    private final void B() {
        GuildProfileData guildProfileData = this.mGuildProfileData;
        GuildProfileData guildProfileData2 = null;
        if (guildProfileData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
            guildProfileData = null;
        }
        String e16 = guildProfileData.getGuildBaseProfileData().e();
        Intrinsics.checkNotNullExpressionValue(e16, "mGuildProfileData.guildBaseProfileData.guildId");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            GuildProfileData guildProfileData3 = this.mGuildProfileData;
            if (guildProfileData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
                guildProfileData3 = null;
            }
            String b16 = guildProfileData3.getGuildBaseProfileData().b();
            GuildProfileData guildProfileData4 = this.mGuildProfileData;
            if (guildProfileData4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
            } else {
                guildProfileData2 = guildProfileData4;
            }
            d16.d("Guild.profile.PersonalProfileBottomPanel", 1, "updateEnterEditProfileBtn gId:" + e16 + " dstTinyId:" + b16 + " selfTinyId:" + guildProfileData2.getGuildBaseProfileData().j());
        }
    }

    private final void g() {
        IGPSService service = (IGPSService) ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(service, "service");
        service.createDirectMsgSession(i(service), new vh2.h() { // from class: com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.q
            @Override // vh2.h
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, boolean z16, com.tencent.mobileqq.qqguildsdk.data.k kVar) {
                PersonalProfileBottomPanel.h(PersonalProfileBottomPanel.this, i3, str, iGProSecurityResult, z16, kVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(PersonalProfileBottomPanel this$0, int i3, String errMsg, IGProSecurityResult iGProSecurityResult, boolean z16, com.tencent.mobileqq.qqguildsdk.data.k session) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(session, "session");
        if (i3 == 66000) {
            QQToastUtil.showQQToast(0, BaseApplication.getContext().getString(R.string.f142360j6));
            return;
        }
        if (i3 != 0 && i3 != 66014) {
            QLog.e("Guild.profile.PersonalProfileBottomPanel", 1, "createDirectMsgSession network error code:" + i3 + " message: " + errMsg);
            return;
        }
        if (!ch.p(iGProSecurityResult)) {
            Intrinsics.checkNotNull(iGProSecurityResult);
            QLog.e("Guild.profile.PersonalProfileBottomPanel", 1, "createDirectMsgSession network error securityCode:" + iGProSecurityResult.get$actionCode() + " strPrompt: " + iGProSecurityResult.getStrPrompt() + "strDetail: " + iGProSecurityResult.getStrDetail());
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Guild.profile.PersonalProfileBottomPanel", 2, session.toString());
        }
        QLog.d("Guild.profile.PersonalProfileBottomPanel", 4, "createDirectMsgSession guildId = ", session.b(), " channelId = ", session.a());
        DirectMessageNodeRepository.P(session, z16);
        l lVar = this$0.mCardViewModel;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardViewModel");
            lVar = null;
        }
        lVar.j2(session);
    }

    private final com.tencent.mobileqq.qqguildsdk.data.i i(IGPSService service) {
        GuildProfileData guildProfileData = this.mGuildProfileData;
        GuildProfileData guildProfileData2 = null;
        if (guildProfileData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
            guildProfileData = null;
        }
        String e16 = guildProfileData.getGuildBaseProfileData().e();
        Intrinsics.checkNotNullExpressionValue(e16, "mGuildProfileData.guildBaseProfileData.guildId");
        GuildProfileData guildProfileData3 = this.mGuildProfileData;
        if (guildProfileData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
        } else {
            guildProfileData2 = guildProfileData3;
        }
        String b16 = guildProfileData2.getGuildBaseProfileData().b();
        Intrinsics.checkNotNullExpressionValue(b16, "mGuildProfileData.guildBaseProfileData.dstTinyId");
        com.tencent.mobileqq.qqguildsdk.data.i iVar = new com.tencent.mobileqq.qqguildsdk.data.i();
        iVar.f266704b = e16;
        iVar.f266703a = b16;
        iVar.f266707e = service.getGuildUserDisplayName(e16, b16);
        iVar.f266706d = service.getGuildUserDisplayName(e16, b16);
        IGProGuildInfo guildInfo = service.getGuildInfo(e16);
        if (guildInfo != null) {
            iVar.f266705c = guildInfo.getGuildName();
        }
        if (QLog.isColorLevel()) {
            QLog.i("Guild.profile.PersonalProfileBottomPanel", 2, iVar.toString());
        }
        return iVar;
    }

    private final void j() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        GuildProfileData guildProfileData = this.mGuildProfileData;
        if (guildProfileData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
            guildProfileData = null;
        }
        final String e16 = guildProfileData.getGuildBaseProfileData().e();
        Intrinsics.checkNotNullExpressionValue(e16, "mGuildProfileData.guildBaseProfileData.guildId");
        if (ch.j0(e16)) {
            String qqStr = HardCodeUtil.qqStr(R.string.f147270wf);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_join_unlock_add_friend_tips)");
            n(e16, qqStr, 1);
            return;
        }
        GuildProfileData guildProfileData2 = this.mGuildProfileData;
        if (guildProfileData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
            guildProfileData2 = null;
        }
        if (!guildProfileData2.getGuildBaseProfileData().p()) {
            QQToast.makeText(getContext(), 0, BaseApplication.getContext().getString(R.string.f142360j6), 1).show();
            QLog.i("Guild.profile.PersonalProfileBottomPanel", 1, "he is visitor. guildId=" + e16);
            return;
        }
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        final String guildName = iGPSService.getGuildName(e16);
        GuildProfileData guildProfileData3 = this.mGuildProfileData;
        if (guildProfileData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
            guildProfileData3 = null;
        }
        final String nickName = guildProfileData3.getUserProfileInfo().getNickName();
        Intrinsics.checkNotNullExpressionValue(nickName, "mGuildProfileData.userProfileInfo.nickName");
        GuildProfileData guildProfileData4 = this.mGuildProfileData;
        if (guildProfileData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
            guildProfileData4 = null;
        }
        final String guildUserDisplayName = iGPSService.getGuildUserDisplayName(e16, guildProfileData4.getGuildBaseProfileData().j());
        Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "service.getGuildUserDisp\u2026seProfileData.selfTinyId)");
        GuildProfileData guildProfileData5 = this.mGuildProfileData;
        if (guildProfileData5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
            guildProfileData5 = null;
        }
        final String openId = guildProfileData5.getUserProfileInfo().getOpenId();
        Intrinsics.checkNotNullExpressionValue(openId, "mGuildProfileData.userProfileInfo.openId");
        QLog.i("Guild.profile.PersonalProfileBottomPanel", 1, "AddFriend guildId:" + e16 + " openid:" + openId + " friendDefaultNickName:" + nickName);
        iGPSService.fetchAddGuildInfo(1, az.d(e16, 0L), new wh2.a() { // from class: com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.m
            @Override // wh2.a
            public final void onResult(int i3, String str, String str2, String str3, String str4) {
                PersonalProfileBottomPanel.k(e16, guildName, this, openId, guildUserDisplayName, nickName, i3, str, str2, str3, str4);
            }
        });
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
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
        IGPSService iGPSService2 = (IGPSService) iRuntimeService;
        if (iGPSService2 != null) {
            iGPSService2.setGuildListTop(e16, 1, 2, new eh() { // from class: com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.n
                @Override // wh2.eh
                public final void a(int i3, String str, IGProGuildListSortInfo iGProGuildListSortInfo) {
                    PersonalProfileBottomPanel.l(e16, i3, str, iGProGuildListSortInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(String guildId, String str, PersonalProfileBottomPanel this$0, String openId, String selfName, String friendDefaultNickName, int i3, String errMsg, String str2, String str3, String joinGuildSig) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(openId, "$openId");
        Intrinsics.checkNotNullParameter(selfName, "$selfName");
        Intrinsics.checkNotNullParameter(friendDefaultNickName, "$friendDefaultNickName");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(joinGuildSig, "joinGuildSig");
        if (i3 == 0) {
            IGuildMakeQQFriendApi.a aVar = new IGuildMakeQQFriendApi.a();
            aVar.f235218a = joinGuildSig;
            aVar.f235219b = "1";
            aVar.f235220c = "1";
            aVar.f235221d = "1";
            aVar.f235222e = 1;
            aVar.f235223f = guildId;
            aVar.f235224g = str;
            GuildProfileData guildProfileData = this$0.mGuildProfileData;
            if (guildProfileData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
                guildProfileData = null;
            }
            aVar.f235225h = guildProfileData.getGuildBaseProfileData().g();
            aVar.f235226i = openId;
            aVar.f235227j = selfName;
            aVar.f235228k = friendDefaultNickName;
            aVar.f235229l = 2;
            ((IGuildMakeQQFriendApi) QRoute.api(IGuildMakeQQFriendApi.class)).makeQQFriend(QBaseActivity.sTopActivity, aVar);
            return;
        }
        QLog.w("Guild.profile.PersonalProfileBottomPanel", 1, "fetchAddGuildInfo error, guildId:" + guildId + " errMsg:" + errMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(String guildId, int i3, String str, IGProGuildListSortInfo iGProGuildListSortInfo) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Logger.f235387a.d().i("Guild.profile.PersonalProfileBottomPanel", 1, "setGuildListTop end. with guildId=" + guildId + " code=" + i3 + " errMsg=" + str);
    }

    private final void m() {
        GuildProfileData guildProfileData = this.mGuildProfileData;
        GuildProfileData guildProfileData2 = null;
        if (guildProfileData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
            guildProfileData = null;
        }
        String e16 = guildProfileData.getGuildBaseProfileData().e();
        Intrinsics.checkNotNullExpressionValue(e16, "mGuildProfileData.guildBaseProfileData.guildId");
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (TextUtils.isEmpty(e16) || qBaseActivity == null) {
            QLog.w("Guild.profile.PersonalProfileBottomPanel", 1, "handleDirectMsgBtnClick guildId:" + e16 + " activity:" + qBaseActivity);
        }
        if (ch.j0(e16)) {
            String qqStr = HardCodeUtil.qqStr(R.string.f147290wh);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_join_unlock_message_tips)");
            n(e16, qqStr, 2);
            QLog.i("Guild.profile.PersonalProfileBottomPanel", 1, "createDirectMsgSession you are visitor. guildId=" + e16);
            return;
        }
        GuildProfileData guildProfileData3 = this.mGuildProfileData;
        if (guildProfileData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
        } else {
            guildProfileData2 = guildProfileData3;
        }
        if (guildProfileData2.getUserProfileInfo().n()) {
            QQToastUtil.showQQToast(1, R.string.f146630up);
            return;
        }
        if (sz1.d.l(e16)) {
            IGuildSpeakableThresholdPermission f16 = sz1.d.f(e16);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            SpannableStringBuilder c16 = sz1.c.c(context, e16);
            QLog.d("Guild.profile.PersonalProfileBottomPanel", 2, "handleDirectMsgBtnClick permission:" + f16 + " thresholdTips:" + ((Object) c16));
            int directMsgLimitType = f16.getDirectMsgLimitType();
            if (directMsgLimitType != 2) {
                if (directMsgLimitType != 4) {
                    QLog.e("Guild.profile.PersonalProfileBottomPanel", 1, "handleDirectMsgBtnClick Illegal limitType:" + f16.getDirectMsgLimitType());
                    return;
                }
                ch.f1(c16.toString());
                return;
            }
            q(f16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.profile.PersonalProfileBottomPanel", 2, "handleDirectMsgBtnClick not LimitInDirectMsg");
        }
        g();
    }

    private final void n(final String guildId, final String dialogTip, final int source) {
        QLog.i("Guild.profile.PersonalProfileBottomPanel", 1, "AddFriend you are visitor. guildId=" + guildId);
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        ((IGPSService) runtimeService).fetchAddGuildInfo(2, az.d(guildId, 0L), new wh2.a() { // from class: com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.p
            @Override // wh2.a
            public final void onResult(int i3, String str, String str2, String str3, String str4) {
                PersonalProfileBottomPanel.o(guildId, source, this, dialogTip, i3, str, str2, str3, str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0064, code lost:
    
        if (r8.getGuildBaseProfileData().o() != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void o(String guildId, int i3, PersonalProfileBottomPanel this$0, String dialogTip, int i16, String errMsg, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialogTip, "$dialogTip");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (i16 == 0) {
            JumpGuildParam jumpGuildParam = new JumpGuildParam(guildId, null, str3, str, str2);
            jumpGuildParam.setExtraJoinGuildSource(i3);
            GuildProfileData guildProfileData = this$0.mGuildProfileData;
            GuildProfileData guildProfileData2 = null;
            if (guildProfileData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
                guildProfileData = null;
            }
            jumpGuildParam.setExtraJoinGuildTinyId(guildProfileData.getGuildBaseProfileData().b());
            GuildProfileData guildProfileData3 = this$0.mGuildProfileData;
            if (guildProfileData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
                guildProfileData3 = null;
            }
            if (guildProfileData3.getGuildBaseProfileData().g() != 15) {
                GuildProfileData guildProfileData4 = this$0.mGuildProfileData;
                if (guildProfileData4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
                } else {
                    guildProfileData2 = guildProfileData4;
                }
            }
            jumpGuildParam.extras.putInt(JumpGuildParam.EXTRA_PERSON_CARD_SCENE_TYPE, 15);
            this$0.v(jumpGuildParam, dialogTip);
            return;
        }
        QLog.w("Guild.profile.PersonalProfileBottomPanel", 1, "fetchAddGuildInfo error, guildId:" + guildId + " errMsg:" + errMsg);
        QQToastUtil.showQQToast(0, errMsg);
    }

    private final void p() {
        l lVar = this.mCardViewModel;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardViewModel");
            lVar = null;
        }
        lVar.k2();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void q(final IGuildSpeakableThresholdPermission permission) {
        l lVar;
        GuildProfileData guildProfileData = this.mGuildProfileData;
        l lVar2 = null;
        if (guildProfileData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
            guildProfileData = null;
        }
        if (guildProfileData.getGuildBaseProfileData().g() == 8) {
            GuildProfileData guildProfileData2 = this.mGuildProfileData;
            if (guildProfileData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
                guildProfileData2 = null;
            }
            if (guildProfileData2.getExtras().getBoolean(GuildProfileData.KEY_IS_FROM_STANDALONE, false)) {
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                String qqStr = HardCodeUtil.qqStr(R.string.f157221mb);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026reshold_c2c_aio_auth_tip)");
                String qqStr2 = HardCodeUtil.qqStr(R.string.f157191m9);
                Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(com.tencent.mobile\u2026_threshold_aio_auth_jump)");
                String verifyUrl = permission.getVerifyUrl();
                Intrinsics.checkNotNullExpressionValue(verifyUrl, "permission.verifyUrl");
                simpleEventBus.dispatchEvent(new GuildSpeakThresholdAuthEvent(qqStr, qqStr2, verifyUrl), true);
                lVar = this.mCardViewModel;
                if (lVar != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCardViewModel");
                } else {
                    lVar2 = lVar;
                }
                lVar2.R1();
            }
        }
        r12.a.a(getContext(), new a.C11105a(getResources().getString(R.string.f157221mb), getResources().getString(R.string.f157191m9), 0, 1, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PersonalProfileBottomPanel.r(IGuildSpeakableThresholdPermission.this, view);
            }
        })).b();
        lVar = this.mCardViewModel;
        if (lVar != null) {
        }
        lVar2.R1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(IGuildSpeakableThresholdPermission permission, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(permission, "$permission");
        ch.i1(QBaseActivity.sTopActivity, permission.getVerifyUrl());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean s() {
        GuildProfileData guildProfileData = this.mGuildProfileData;
        if (guildProfileData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
            guildProfileData = null;
        }
        String a16 = guildProfileData.getGuildBaseProfileData().a();
        Intrinsics.checkNotNullExpressionValue(a16, "mGuildProfileData.guildBaseProfileData.channelId");
        IGProChannelInfo B = ch.B(a16);
        if (B == null) {
            QLog.e("Guild.profile.PersonalProfileBottomPanel", 1, "channel(" + a16 + ") info is null!");
            return false;
        }
        QLog.i("Guild.profile.PersonalProfileBottomPanel", 1, "channel(" + a16 + ") roomId:" + B.getLiveRoomId());
        if (B.getType() != 5) {
            return false;
        }
        return true;
    }

    private final boolean t() {
        GuildProfileData guildProfileData = this.mGuildProfileData;
        GuildProfileData guildProfileData2 = null;
        if (guildProfileData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
            guildProfileData = null;
        }
        String j3 = guildProfileData.getGuildBaseProfileData().j();
        Intrinsics.checkNotNullExpressionValue(j3, "mGuildProfileData.guildBaseProfileData.selfTinyId");
        GuildProfileData guildProfileData3 = this.mGuildProfileData;
        if (guildProfileData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
        } else {
            guildProfileData2 = guildProfileData3;
        }
        String b16 = guildProfileData2.getGuildBaseProfileData().b();
        Intrinsics.checkNotNullExpressionValue(b16, "mGuildProfileData.guildBaseProfileData.dstTinyId");
        if (!TextUtils.equals(j3, b16)) {
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            if (!TextUtils.equals(b16, ((IGPSService) S0).getSelfTinyId())) {
                return false;
            }
        }
        return true;
    }

    private final boolean u() {
        GuildProfileData guildProfileData = this.mGuildProfileData;
        GuildProfileData guildProfileData2 = null;
        if (guildProfileData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
            guildProfileData = null;
        }
        QLog.i("Guild.profile.PersonalProfileBottomPanel", 1, "needShieldDirectMsg: " + guildProfileData.getGuildBaseProfileData().g());
        GuildProfileData guildProfileData3 = this.mGuildProfileData;
        if (guildProfileData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
        } else {
            guildProfileData2 = guildProfileData3;
        }
        if (guildProfileData2.getGuildBaseProfileData().g() == 12) {
            return true;
        }
        return false;
    }

    private final void v(final JumpGuildParam param, final String dialogTip) {
        String str = param.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "param.guildId");
        GuildMainFrameUtils.i(str, null, 0, null, false, new Function1<GuildMainFrameUtils.GuildAndChannelInfoRsp, Unit>() { // from class: com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.PersonalProfileBottomPanel$openInviteDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
                invoke2(guildAndChannelInfoRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildMainFrameUtils.GuildAndChannelInfoRsp it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!it.l()) {
                    SecurityTipHelperKt.F(ch.i(), it.k(), it.e(), null, null, null, 56, null);
                } else {
                    ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).openJoinInvitationDialog(PersonalProfileBottomPanel.this.getContext(), param, dialogTip, false, true);
                }
            }
        }, 30, null);
    }

    private final boolean w(boolean isDirectMsg) {
        if (ch.i0() && !isDirectMsg && !t() && !u()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
    
        if (r5.r().a() == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void x() {
        GuildProfileData guildProfileData = this.mGuildProfileData;
        GuildProfileData guildProfileData2 = null;
        if (guildProfileData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
            guildProfileData = null;
        }
        int f16 = guildProfileData.getGuildBaseProfileData().f();
        boolean z16 = true;
        int i3 = 0;
        if (f16 != 1) {
            if (f16 != 2) {
                if (f16 != 5) {
                    this.mSendGiftBtn.setVisibility(8);
                    return;
                }
                QUIButton qUIButton = this.mSendGiftBtn;
                if (s()) {
                    GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
                    String anchorTinyId = gLiveChannelCore.s().getAnchorTinyId();
                    GuildProfileData guildProfileData3 = this.mGuildProfileData;
                    if (guildProfileData3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
                    } else {
                        guildProfileData2 = guildProfileData3;
                    }
                    if (Intrinsics.areEqual(anchorTinyId, guildProfileData2.getGuildBaseProfileData().b())) {
                    }
                }
                if (s()) {
                    z16 = false;
                }
                if (!z16) {
                    i3 = 8;
                }
                qUIButton.setVisibility(i3);
                return;
            }
            GuildProfileData guildProfileData4 = this.mGuildProfileData;
            if (guildProfileData4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
            } else {
                guildProfileData2 = guildProfileData4;
            }
            String b16 = guildProfileData2.getGuildBaseProfileData().b();
            GLiveChannelCore gLiveChannelCore2 = GLiveChannelCore.f226698a;
            if (Intrinsics.areEqual(b16, gLiveChannelCore2.s().getAnchorTinyId()) && !gLiveChannelCore2.r().a()) {
                this.mSendGiftBtn.setVisibility(0);
                return;
            } else {
                this.mSendGiftBtn.setVisibility(8);
                return;
            }
        }
        this.mSendGiftBtn.setVisibility(0);
    }

    private final void y(boolean isQQFriend) {
        boolean z16;
        GuildProfileData guildProfileData = null;
        if (QLog.isColorLevel()) {
            boolean t16 = t();
            boolean a16 = bs.a();
            GuildProfileData guildProfileData2 = this.mGuildProfileData;
            if (guildProfileData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
                guildProfileData2 = null;
            }
            String openId = guildProfileData2.getUserProfileInfo().getOpenId();
            GuildProfileData guildProfileData3 = this.mGuildProfileData;
            if (guildProfileData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
                guildProfileData3 = null;
            }
            QLog.d("Guild.profile.PersonalProfileBottomPanel", 2, "updateAddFriendBtn isFriend:" + isQQFriend + " isSelf:" + t16 + " manager:" + a16 + " openId: " + openId + " uin: " + guildProfileData3.getUserProfileInfo().getUin());
        }
        if (!isQQFriend && !t() && bs.a()) {
            GuildProfileData guildProfileData4 = this.mGuildProfileData;
            if (guildProfileData4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
                guildProfileData4 = null;
            }
            String openId2 = guildProfileData4.getUserProfileInfo().getOpenId();
            if (openId2 != null && openId2.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                GuildProfileData guildProfileData5 = this.mGuildProfileData;
                if (guildProfileData5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
                    guildProfileData5 = null;
                }
                if (!Intrinsics.areEqual("0", guildProfileData5.getUserProfileInfo().getOpenId())) {
                    GuildProfileData guildProfileData6 = this.mGuildProfileData;
                    if (guildProfileData6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mGuildProfileData");
                    } else {
                        guildProfileData = guildProfileData6;
                    }
                    String uin = guildProfileData.getUserProfileInfo().getUin();
                    Intrinsics.checkNotNullExpressionValue(uin, "mGuildProfileData.userProfileInfo.uin");
                    if (!lv1.a.f(uin)) {
                        this.mAddFriendBtn.setVisibility(0);
                        return;
                    }
                }
            }
        }
        this.mAddFriendBtn.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (FastClickUtils.isFastDoubleClick("Guild.profile.PersonalProfileBottomPanel")) {
            Logger.f235387a.d().w("Guild.profile.PersonalProfileBottomPanel", 1, "onClick isFastDoubleClick, ignore!");
        } else if (Intrinsics.areEqual(v3, this.mBtnDirectMessage)) {
            m();
        } else if (Intrinsics.areEqual(v3, this.mAddFriendBtn)) {
            j();
        } else if (Intrinsics.areEqual(v3, this.mSendGiftBtn)) {
            p();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void setLogicParent(@NotNull View parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        VideoReport.setLogicParent(this.mBtnDirectMessage, parentView);
        VideoReport.setLogicParent(this.mAddFriendBtn, parentView);
        VideoReport.setLogicParent(this.mSendGiftBtn, parentView);
        QUIButton qUIButton = this.mBtnDirectMessage;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        ch.Y0(qUIButton, "em_sgrp_profile_private_letters", clickPolicy, exposurePolicy);
        ch.Y0(this.mAddFriendBtn, "em_party_add_friend", clickPolicy, exposurePolicy);
        ch.Y0(this.mSendGiftBtn, "em_sgrp_aio_gifts", clickPolicy, exposurePolicy);
    }

    public final void setParams(@NotNull GuildProfileData guildProfileData, @NotNull l cardViewModel) {
        Intrinsics.checkNotNullParameter(guildProfileData, "guildProfileData");
        Intrinsics.checkNotNullParameter(cardViewModel, "cardViewModel");
        this.mGuildProfileData = guildProfileData;
        this.mCardViewModel = cardViewModel;
    }

    public final void z(boolean isQQFriend) {
        y(isQQFriend);
        x();
        A();
        B();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PersonalProfileBottomPanel(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PersonalProfileBottomPanel(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PersonalProfileBottomPanel(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.f1x, this);
        View findViewById = findViewById(R.id.f165590wu0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_profile_add_friend)");
        QUIButton qUIButton = (QUIButton) findViewById;
        this.mAddFriendBtn = qUIButton;
        View findViewById2 = findViewById(R.id.f165445w14);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.guild_btn_direct_message)");
        QUIButton qUIButton2 = (QUIButton) findViewById2;
        this.mBtnDirectMessage = qUIButton2;
        View findViewById3 = findViewById(R.id.w16);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.guild_btn_send_gift)");
        QUIButton qUIButton3 = (QUIButton) findViewById3;
        this.mSendGiftBtn = qUIButton3;
        qUIButton2.setOnClickListener(this);
        qUIButton.setOnClickListener(this);
        qUIButton3.setOnClickListener(this);
    }
}
