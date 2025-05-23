package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QQProfileItem;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.api.IRelationBlacklistApi;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilecommon.api.IProfileCommonService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stt.ISttManagerApi;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.wink.storage.kv.MaskType;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tenpay.sdk.download.HttpOp;
import friendlist.AddGroupResp;
import friendlist.DelGroupResp;
import friendlist.RenameGroupResp;
import gxh_message.Dialogue;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.observer.AccountObserver;
import org.jf.dexlib2.analysis.RegisterType;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$AddGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$DaRenNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$DelGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$FrdCustomOnlineStatusChange;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$FriendRemark;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$GroupSort;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$MQQCampusNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$ModCustomFace;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$ModGroupName;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$ModLongNick;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$ModProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$ModSnsGeneralInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$PraiseRankNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$ProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$SnsUpateBuffer;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$SnsUpdateFlag;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$SnsUpdateItem;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$SnsUpdateOneFlag;

/* compiled from: P */
/* loaded from: classes7.dex */
public class am implements com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FriendsManager f116595a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SubMsgType0x27$ModLongNick f116596b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ byte[] f116597c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f116598d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f116599e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f116600f;

        a(FriendsManager friendsManager, SubMsgType0x27$ModLongNick subMsgType0x27$ModLongNick, byte[] bArr, long j3, QQAppInterface qQAppInterface, String str) {
            this.f116595a = friendsManager;
            this.f116596b = subMsgType0x27$ModLongNick;
            this.f116597c = bArr;
            this.f116598d = j3;
            this.f116599e = qQAppInterface;
            this.f116600f = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, am.this, friendsManager, subMsgType0x27$ModLongNick, bArr, Long.valueOf(j3), qQAppInterface, str);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            Card r16 = this.f116595a.r(this.f116596b.uint64_uin.get() + "");
            if (r16 != null) {
                r16.vRichSign = this.f116597c;
                r16.lSignModifyTime = this.f116598d;
                this.f116595a.p0(r16);
            }
            QQAppInterface qQAppInterface = this.f116599e;
            String str = BusinessHandlerFactory.FRIENDLIST_HANDLER;
            qQAppInterface.getBusinessHandler(str).notifyUI(3, true, this.f116600f);
            this.f116599e.getBusinessHandler(str).notifyUI(2, true, new String[]{this.f116600f});
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class b implements hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f116602a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap f116603b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f116604c;

        /* compiled from: P */
        /* loaded from: classes7.dex */
        class a implements hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // hx3.c
            public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.c> eVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                } else if (b.this.f116603b.size() > 0) {
                    b.this.f116604c.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(95, true, new Object[]{Boolean.TRUE, new ArrayList(b.this.f116603b.values()), new ArrayList(b.this.f116602a.values())});
                }
            }
        }

        b(HashMap hashMap, HashMap hashMap2, QQAppInterface qQAppInterface) {
            this.f116602a = hashMap;
            this.f116603b = hashMap2;
            this.f116604c = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, am.this, hashMap, hashMap2, qQAppInterface);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            } else {
                ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).accurateUpdateNTOtherSimpleInfo(new ArrayList<>(this.f116602a.values()), "MsgType0x210SubMsgType0x27", new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class c implements hx3.c<NTVasSimpleInfo> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f116607a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f116608b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.imcore.message.af f116609c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FriendsManager f116610d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f116611e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f116612f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f116613g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f116614h;

        c(long j3, int i3, com.tencent.imcore.message.af afVar, FriendsManager friendsManager, int i16, int i17, String str, int i18) {
            this.f116607a = j3;
            this.f116608b = i3;
            this.f116609c = afVar;
            this.f116610d = friendsManager;
            this.f116611e = i16;
            this.f116612f = i17;
            this.f116613g = str;
            this.f116614h = i18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, am.this, Long.valueOf(j3), Integer.valueOf(i3), afVar, friendsManager, Integer.valueOf(i16), Integer.valueOf(i17), str, Integer.valueOf(i18));
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<NTVasSimpleInfo> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            String valueOf = String.valueOf(this.f116607a);
            if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(valueOf), "MsgType0x210SubMsgType0x27") != null) {
                com.tencent.mobileqq.vip.api.b.a().updateFlagData(valueOf, this.f116608b);
                com.tencent.mobileqq.vip.api.b.a().getVipData(valueOf, this.f116608b);
            }
            this.f116609c.d().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(this.f116607a));
            Card r16 = this.f116610d.r(this.f116607a + "");
            if (r16 != null) {
                int i3 = r16.gameCardId;
                int i16 = this.f116611e;
                if (i3 != i16) {
                    r16.gameCardId = i16;
                    r16.vipStarFlag = this.f116612f;
                    String str = this.f116613g;
                    if (str != null) {
                        r16.vipIcons = str;
                    }
                    this.f116610d.p0(r16);
                    this.f116609c.d().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, r16);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "vip_card_extension id by push=" + this.f116614h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class d implements hx3.c<NTVasSimpleInfo> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.imcore.message.af f116616a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f116617b;

        d(com.tencent.imcore.message.af afVar, long j3) {
            this.f116616a = afVar;
            this.f116617b = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, am.this, afVar, Long.valueOf(j3));
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<NTVasSimpleInfo> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            } else {
                this.f116616a.d().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(this.f116617b));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class e implements hx3.c<NTVasSimpleInfo> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f116619a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.imcore.message.af f116620b;

        e(long j3, com.tencent.imcore.message.af afVar) {
            this.f116619a = j3;
            this.f116620b = afVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, am.this, Long.valueOf(j3), afVar);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<NTVasSimpleInfo> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            HashSet hashSet = new HashSet(1);
            hashSet.add(String.valueOf(this.f116619a));
            this.f116620b.d().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(62, true, hashSet);
        }
    }

    public am() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void A(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        long j16 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
        Card r16 = friendsManager.r(j3 + "");
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(Long.toString(j3));
        IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, Long.toString(j3));
        nTVasSimpleInfo.c();
        if (r16 != null) {
            r16.namePlateOfKingLoginTime = j16;
            friendsManager.p0(r16);
            afVar.d().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, r16);
        }
        nTVasSimpleInfo.namePlateOfKingGameId = j16;
        iVasInfoService.accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "MsgType0x210SubMsgType0x27", (hx3.c<NTVasSimpleInfo>) null);
        afVar.d().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(j3));
        QLog.i("namePlateOfKing", 1, "handle push gameLoginTime = " + j16 + ", uin = " + j3);
    }

    private void B(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        long j16 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
        Card r16 = friendsManager.r(j3 + "");
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(Long.toString(j3));
        IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, Long.toString(j3));
        nTVasSimpleInfo.c();
        if (r16 != null) {
            r16.namePlateOfKingGameId = j16;
            friendsManager.p0(r16);
            afVar.d().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, r16);
        }
        nTVasSimpleInfo.namePlateOfKingGameId = j16;
        iVasInfoService.accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "MsgType0x210SubMsgType0x27", (hx3.c<NTVasSimpleInfo>) null);
        afVar.d().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(j3));
        QLog.i("namePlateOfKing", 1, "handle push gameId = " + j16 + ", uin = " + j3);
    }

    private void C(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        int i3 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
        long currentTimeMillis = System.currentTimeMillis();
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3));
        IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, String.valueOf(j3));
        nTVasSimpleInfo.pendantDiyId = i3;
        nTVasSimpleInfo.timestamp = currentTimeMillis;
        iVasInfoService.accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "MsgType0x210SubMsgType0x27", (hx3.c<NTVasSimpleInfo>) null);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get PendantDiyId, uin=" + j3 + ", id=" + nTVasSimpleInfo.pendantDiyId);
        }
    }

    private void D(com.tencent.imcore.message.af afVar, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        int i3 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
        ((com.tencent.mobileqq.vas.ao) afVar.d().getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308429f.i(Long.toString(j3), i3);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get faceId, uin=" + j3 + ", id=" + i3);
        }
    }

    private void E(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        short s16 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3));
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, String.valueOf(j3));
        nTVasSimpleInfo.c();
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(uidFromUin, "MsgType0x210SubMsgType0x27");
        if (vasSimpleInfoWithUid == null || vasSimpleInfoWithUid.fontEffect != s16) {
            nTVasSimpleInfo.fontEffect = s16;
            ((IFontManagerService) afVar.d().getRuntimeService(IFontManagerService.class, "")).resetLastSendReportTime();
            ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "MsgType0x210SubMsgType0x27", (hx3.c<NTVasSimpleInfo>) null);
        }
    }

    private void F(com.tencent.imcore.message.af afVar, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        int i3 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
        boolean isNowThemeIsSimple = ThemeUtil.isNowThemeIsSimple(afVar.d(), false, null);
        if (!isNowThemeIsSimple && DarkModeManager.l(String.valueOf(i3))) {
            if (!ThemeSwitcher.isSwitching(String.valueOf(i3))) {
                ThemeSwitcher.startSwitch(String.valueOf(i3), ThemeReporter.FROM_PUSH, null);
            }
        } else {
            ThemeSwitchUtil.setPreviousThemeIdVersion(afVar.d(), String.valueOf(i3), "20000000");
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "theme online push " + subMsgType0x27$ProfileInfo.uint32_field.get() + " themeId:" + i3 + " isSimpleMode\uff1a" + isNowThemeIsSimple);
        }
    }

    private void G(com.tencent.imcore.message.af afVar, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        if (com.tencent.mobileqq.vas.ar.b("kenaiyu", "2024-11-18", "vas_bug_bg_id_push").isEnable(true)) {
            VasLogReporter.getChatBackground().reportLow("receive push and update data");
            new ChatBackgroundAuth().h(Boolean.TRUE);
            return;
        }
        if (com.tencent.mobileqq.vas.ar.b("kenaiyu", "2024-11-18", "vas_bug_bg_id_push").isEnable(true)) {
            return;
        }
        int i3 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
        ChatBackgroundManager chatBackgroundManager = (ChatBackgroundManager) afVar.d().getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
        if (chatBackgroundManager != null) {
            chatBackgroundManager.y(i3, 0, null, "onlinePush", -1);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, " bg online push " + subMsgType0x27$ProfileInfo.uint32_field.get() + " bgId:" + i3);
        }
    }

    private void H(com.tencent.imcore.message.af afVar, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        int i3 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "handleModProfileBranch: invoked. c2c online push, field id: 27370, changed global ring id", " ringId: ", Integer.valueOf(i3));
        }
        MessageNotificationSettingManager.l((QQAppInterface) afVar.d()).R(i3);
    }

    private void I(com.tencent.imcore.message.af afVar, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        short s16;
        byte[] byteArray = subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray();
        long j3 = 0;
        if (byteArray.length == 4) {
            s16 = ByteBuffer.wrap(new byte[]{byteArray[3]}).get();
            if (s16 == 1) {
                j3 = ByteBuffer.wrap(new byte[]{byteArray[2], byteArray[1]}).asShortBuffer().get() & 65535;
            }
        } else {
            s16 = ByteBuffer.wrap(byteArray).asShortBuffer().get();
        }
        AppRuntime.Status statusFromProfile = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getStatusFromProfile(s16);
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) afVar.d().getRuntimeService(IOnlineStatusService.class, "");
        AppRuntime.Status onlineStatus = iOnlineStatusService.getOnlineStatus();
        long selfExtOnlineStatus = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getSelfExtOnlineStatus(afVar.d());
        if (statusFromProfile != onlineStatus || selfExtOnlineStatus != j3) {
            iOnlineStatusService.setOnlineStatus(statusFromProfile, "handleModProfile_27372");
            iOnlineStatusService.setExtOnlineStatus(j3);
            Bundle bundle = new Bundle();
            bundle.putSerializable("onlineStatus", statusFromProfile);
            bundle.putLong("extOnlineStatus", j3);
            afVar.d().notifyObservers(AccountObserver.class, Constants.Action.ACTION_ONLINE_STATUS_PUSH, true, bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, String.format("online new status push code: %s, newStatus: %s, curStatus: %s, ext:%s", Integer.valueOf(s16), statusFromProfile, onlineStatus, Long.valueOf(j3)));
        }
        if (statusFromProfile == AppRuntime.Status.online && j3 == 1000) {
            if (onlineStatus != statusFromProfile || j3 != selfExtOnlineStatus) {
                iOnlineStatusService.checkBatteryStatus();
                iOnlineStatusService.updateOnlineStatus(statusFromProfile, j3);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageProcessor", 2, "udc reset battery status");
                }
            }
        }
    }

    private void J(SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        int i3 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
        ThemeFontAdapter.B(i3);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, " theme font online push " + subMsgType0x27$ProfileInfo.uint32_field.get() + " id:" + i3);
        }
    }

    private void K(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        ByteStringMicro byteStringMicro = subMsgType0x27$ProfileInfo.bytes_value.get();
        Dialogue dialogue = new Dialogue();
        try {
            dialogue.mergeFrom(byteStringMicro.toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        int i3 = dialogue.nameplate_pendant_itemid.get();
        int i16 = dialogue.diyfontid.get();
        int i17 = dialogue.vipstar_flag.get();
        String vipIconsString = com.tencent.mobileqq.vip.api.d.a().getVipIconsString(dialogue.diy_nameplate_ids.get());
        int i18 = dialogue.qqvadata_changerand.get();
        int i19 = dialogue.game_nameplate.get();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && TextUtils.equals(Long.toString(j3), peekAppRuntime.getCurrentUin())) {
            int i26 = dialogue.aio_badge_show_switch.get();
            if (QLog.isDebugVersion()) {
                VasLogNtReporter.getVipIcon().reportDebug("0x27 27375 aioBadgeShowSwitch=" + i26);
            }
            VipNtMMKV.getCommon(Long.toString(j3)).encodeInt("aioBadgeShowSwitch", i26);
        }
        if (QLog.isColorLevel()) {
            VasLogNtReporter.getVipIcon().reportDebug("0x27 27375 nameplate_pendant=" + i3 + "vipStartFlag=" + i17 + "vipIcons=" + vipIconsString + "vipDataFlag=" + i18 + "gameNameplateId" + i19);
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(Long.toString(j3));
        IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, Long.toString(j3));
        nTVasSimpleInfo.c();
        nTVasSimpleInfo.bigClubExtTemplateId = i3;
        nTVasSimpleInfo.diyFontId = i16;
        nTVasSimpleInfo.vipStartFlag = i17;
        if (vipIconsString != null) {
            nTVasSimpleInfo.vipIcons = vipIconsString;
        }
        nTVasSimpleInfo.vipDataFlag = i18;
        nTVasSimpleInfo.gameCardId = i19;
        iVasInfoService.accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "MsgType0x210SubMsgType0x27", new c(j3, i18, afVar, friendsManager, i19, i17, vipIconsString, i3));
    }

    private void L(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        short s16 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3)), String.valueOf(j3));
        nTVasSimpleInfo.c();
        nTVasSimpleInfo.magicFont = s16;
        nTVasSimpleInfo.timestamp = System.currentTimeMillis();
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "MsgType0x210SubMsgType0x27", (hx3.c<NTVasSimpleInfo>) null);
        VasUtils.c(afVar.d());
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "push Get MagicFont uin = " + j3 + ", magicFont = " + ((int) s16));
        }
    }

    private void M(com.tencent.imcore.message.af afVar) {
        try {
            QLog.d("vip", 1, "receive 40551 push");
            afVar.d().getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER).notifyUI(116, true, null);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("vip", 1, "handleModProfile_40551 error", e16);
            }
        }
    }

    private void N(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        short s16;
        byte[] byteArray = subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray();
        if (byteArray.length == 1) {
            s16 = byteArray[0];
        } else {
            s16 = ByteBuffer.wrap(byteArray).asShortBuffer().get();
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(Long.toString(j3));
        IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, Long.toString(j3));
        nTVasSimpleInfo.c();
        nTVasSimpleInfo.cNewLoverDiamondFlag = s16;
        iVasInfoService.accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "MsgType0x210SubMsgType0x27", (hx3.c<NTVasSimpleInfo>) null);
    }

    private void O(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        boolean z16;
        short s16 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
        Card r16 = friendsManager.r(j3 + "");
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(Long.toString(j3));
        IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, Long.toString(j3));
        nTVasSimpleInfo.c();
        boolean z17 = false;
        if (r16 != null) {
            if (s16 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            r16.namePlateOfKingDanDisplatSwitch = z16;
            friendsManager.p0(r16);
            afVar.d().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, r16);
        }
        if (s16 == 1) {
            z17 = true;
        }
        nTVasSimpleInfo.namePlateOfKingDanDisplatSwitch = Boolean.valueOf(z17);
        iVasInfoService.accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "MsgType0x210SubMsgType0x27", new d(afVar, j3));
        QLog.i("namePlateOfKing", 1, "handle push namePlateOfKingDanDisplatSwitch = " + ((int) s16) + ", uin = " + j3);
    }

    private void P(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        short s16 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
        Card r16 = friendsManager.r(j3 + "");
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(Long.toString(j3));
        IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, Long.toString(j3));
        nTVasSimpleInfo.c();
        if (r16 != null) {
            r16.namePlateOfKingDan = s16;
            friendsManager.p0(r16);
            afVar.d().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, r16);
        }
        nTVasSimpleInfo.namePlateOfKingDan = s16;
        iVasInfoService.accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "MsgType0x210SubMsgType0x27", (hx3.c<NTVasSimpleInfo>) null);
        afVar.d().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(j3));
        QLog.i("namePlateOfKing", 1, "handle push namePlateOfKingDan = " + ((int) s16) + ", uin = " + j3);
    }

    private void Q(com.tencent.imcore.message.af afVar, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        byte[] byteArray = subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray();
        boolean z16 = true;
        if (byteArray.length != 1 ? ByteBuffer.wrap(byteArray).asShortBuffer().get() != 1 : byteArray[0] != 1) {
            z16 = false;
        }
        ((TempMsgManager) afVar.d().getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).R((short) subMsgType0x27$ProfileInfo.uint32_field.get(), false, "", !z16);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "push temp msg block,uin=" + j3 + ", id=" + z16 + " field=" + subMsgType0x27$ProfileInfo.uint32_field.get());
        }
    }

    private void R(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        short s16;
        byte[] byteArray = subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray();
        if (byteArray.length == 1) {
            s16 = byteArray[0];
        } else {
            s16 = ByteBuffer.wrap(byteArray).asShortBuffer().get();
        }
        Card r16 = friendsManager.r(j3 + "");
        if (r16 != null) {
            long j16 = s16;
            r16.lBigClubTemplateId = j16;
            r16.lSuperVipTemplateId = j16;
            friendsManager.p0(r16);
            afVar.d().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, r16);
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(Long.toString(j3));
        IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, Long.toString(j3));
        nTVasSimpleInfo.c();
        nTVasSimpleInfo.superVipTemplateId = s16;
        nTVasSimpleInfo.bigClubTemplateId = s16;
        iVasInfoService.accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "MsgType0x210SubMsgType0x27", (hx3.c<NTVasSimpleInfo>) null);
        afVar.d().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(j3));
    }

    private void S(com.tencent.imcore.message.af afVar, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        boolean z16;
        byte[] byteArray = subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray();
        if (byteArray.length > 1) {
            if (byteArray[1] == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "it have receive push value:" + z16);
            SharedPreferences sharedPreferences = afVar.d().getApp().getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0);
            String str = "businessinfo_ptt_auto_change_text_" + afVar.d().getCurrentAccountUin();
            String str2 = "businessinfo_ptt_auto_change_time_" + afVar.d().getCurrentAccountUin();
            String str3 = "businessinfo_ptt_auto_change_guide_has_show_" + afVar.d().getCurrentAccountUin();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, z16);
            long serverTime = NetConnInfoCenter.getServerTime();
            if (z16) {
                edit.putLong(str2, serverTime);
                edit.putBoolean(str3, true);
            } else {
                edit.putLong(str2, Long.MAX_VALUE);
            }
            edit.apply();
            com.tencent.mobileqq.activity.aio.item.m.f179515e = z16;
            com.tencent.mobileqq.activity.aio.item.m.f179516f = serverTime;
            return;
        }
        QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "it have receive push value is null");
        ArrayList arrayList = new ArrayList();
        arrayList.add(Short.valueOf(ProfileContants.FIELD_AUTO_TO_TEXT_OFFLINE_FLAG));
        TempGetProfileDetailProcessor tempGetProfileDetailProcessor = (TempGetProfileDetailProcessor) ProfileServiceUtils.getBusinessProcessor(afVar.d(), TempGetProfileDetailProcessor.class);
        if (tempGetProfileDetailProcessor != null) {
            tempGetProfileDetailProcessor.getDetailCardInfo(arrayList, null);
        }
    }

    private void T(com.tencent.imcore.message.af afVar, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        byte[] byteArray = subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray();
        boolean z16 = false;
        if (byteArray.length != 1 ? ByteBuffer.wrap(byteArray).asShortBuffer().get() == 0 : byteArray[0] == 0) {
            z16 = true;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) afVar.d();
        ((IStickerRecManager) qQAppInterface.getRuntimeService(IStickerRecManager.class)).updateEmotionRecSetting(z16);
        qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(102, true, Boolean.valueOf(z16));
        if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "handleModProfileBranch emotionRec flag:" + z16);
        }
    }

    private void U(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        byte[] byteArray = subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray();
        int i3 = 0;
        if (byteArray.length == 1) {
            i3 = byteArray[0];
        } else if (byteArray.length == 2) {
            i3 = ByteBuffer.wrap(byteArray).asShortBuffer().get();
        } else if (byteArray.length == 4) {
            i3 = ByteBuffer.wrap(byteArray).asIntBuffer().get();
        } else {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "rsp VASPROFILEGATE_SERVICE oidb FIELD_QQ_LEVEL_ICON_TYPE flag content error, len:" + byteArray.length);
        }
        Card r16 = friendsManager.r(j3 + "");
        if (r16 != null && r16.mQQLevelType != i3) {
            r16.mQQLevelType = i3;
            friendsManager.p0(r16);
            afVar.d().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, r16);
        }
    }

    private void V(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        if (subMsgType0x27$ProfileInfo.uint32_field.has() && subMsgType0x27$ProfileInfo.bytes_value.has()) {
            short s16 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
            VasLogNtReporter.getVipIcon().reportDebug("0x27 42344 nameplateVipType=" + ((int) s16));
            Card r16 = friendsManager.r(j3 + "");
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(Long.toString(j3));
            IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
            NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, Long.toString(j3));
            nTVasSimpleInfo.c();
            if (r16 != null) {
                r16.nameplateVipType = s16;
                friendsManager.p0(r16);
            }
            nTVasSimpleInfo.nameplateVipType = s16;
            iVasInfoService.accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "MsgType0x210SubMsgType0x27", (hx3.c<NTVasSimpleInfo>) null);
        }
    }

    private void W(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        if (subMsgType0x27$ProfileInfo.uint32_field.has() && subMsgType0x27$ProfileInfo.bytes_value.has()) {
            short s16 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
            if (QLog.isColorLevel()) {
                QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push 42354 = " + ((int) s16));
            }
            Card r16 = friendsManager.r(j3 + "");
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(Long.toString(j3));
            IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
            NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, Long.toString(j3));
            nTVasSimpleInfo.c();
            if (r16 != null) {
                r16.grayNameplateFlag = s16;
                friendsManager.p0(r16);
            }
            nTVasSimpleInfo.grayNameplateFlag = s16;
            iVasInfoService.accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "MsgType0x210SubMsgType0x27", (hx3.c<NTVasSimpleInfo>) null);
        }
    }

    private void X(com.tencent.imcore.message.af afVar, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        ((com.tencent.mobileqq.graytip.a) afVar.d().getManager(QQManagerFactory.CUSTOMIZE_GRAY_TIPS)).f(ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get());
    }

    private void Y(com.tencent.imcore.message.af afVar, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        boolean z16;
        int i3 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
        BubbleManager bubbleManager = (BubbleManager) afVar.d().getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
        if (bubbleManager != null) {
            com.tencent.mobileqq.bubble.e eVar = bubbleManager.H;
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            eVar.b(z16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, String.format("bubble unread feature push %s", "" + i3));
        }
    }

    private void Z(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, SubMsgType0x27$ForwardBody subMsgType0x27$ForwardBody) {
        if (subMsgType0x27$ForwardBody.msg_mod_rich_long_nick_ex.has()) {
            SubMsgType0x27$ModLongNick subMsgType0x27$ModLongNick = subMsgType0x27$ForwardBody.msg_mod_rich_long_nick_ex.get();
            String l3 = Long.toString(subMsgType0x27$ModLongNick.uint64_uin.get());
            ByteBuffer wrap = ByteBuffer.wrap(subMsgType0x27$ModLongNick.bytes_value.get().toByteArray());
            long j3 = wrap.getLong();
            byte[] bArr = new byte[wrap.remaining()];
            wrap.get(bArr);
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(l3);
            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uidFromUin, l3);
            dVar.M();
            com.tencent.mobileqq.richstatus.c.m(dVar, bArr, j3);
            QQAppInterface qQAppInterface = (QQAppInterface) afVar.d();
            dVar.N(Boolean.valueOf(SignatureManager.m(qQAppInterface, l3, com.tencent.mobileqq.richstatus.c.h(dVar))));
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "insertSignMsgIfNeeded from OnLinePush uin = " + l3 + " result =  " + dVar.y());
            }
            iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, "MsgType0x210SubMsgType0x27", new a(friendsManager, subMsgType0x27$ModLongNick, bArr, j3, qQAppInterface, l3));
        }
    }

    private void a0(com.tencent.imcore.message.af afVar, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        try {
            SubMsgType0x27$MsgBody mergeFrom = new SubMsgType0x27$MsgBody().mergeFrom(bArr);
            FriendsManager friendsManager = (FriendsManager) afVar.d().getManager(QQManagerFactory.FRIENDS_MANAGER);
            TroopManager troopManager = (TroopManager) afVar.d().getManager(QQManagerFactory.TROOP_MANAGER);
            IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) afVar.d().getRuntimeService(IPublicAccountDataManager.class, "all");
            List<SubMsgType0x27$ForwardBody> list = mergeFrom.rpt_msg_mod_infos.get();
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d[] dVarArr = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d[list.size()];
            int i3 = 0;
            for (SubMsgType0x27$ForwardBody subMsgType0x27$ForwardBody : list) {
                if (!subMsgType0x27$ForwardBody.uint32_notify_type.has() || subMsgType0x27$ForwardBody.uint32_notify_type.get() != 1) {
                    if (subMsgType0x27$ForwardBody.uint32_op_type.has()) {
                        int i16 = subMsgType0x27$ForwardBody.uint32_op_type.get();
                        if (i16 != 0) {
                            if (i16 != 1) {
                                if (i16 != 2) {
                                    if (i16 != 3) {
                                        if (i16 != 5) {
                                            if (i16 != 40) {
                                                if (i16 != 203) {
                                                    if (i16 != 205) {
                                                        if (i16 != 214) {
                                                            if (i16 != 7) {
                                                                if (i16 != 8) {
                                                                    switch (i16) {
                                                                        case 20:
                                                                            if (subMsgType0x27$ForwardBody.msg_mod_profile.has()) {
                                                                                i3 = q(afVar, subMsgType0x27$ForwardBody, friendsManager, dVarArr, i3);
                                                                                break;
                                                                            } else {
                                                                                continue;
                                                                            }
                                                                        case 21:
                                                                            k(afVar, troopManager, subMsgType0x27$ForwardBody);
                                                                            continue;
                                                                        case 22:
                                                                            g(afVar, friendsManager, subMsgType0x27$ForwardBody);
                                                                            continue;
                                                                        default:
                                                                            switch (i16) {
                                                                                case 210:
                                                                                    e(afVar, subMsgType0x27$ForwardBody);
                                                                                    continue;
                                                                                case 211:
                                                                                    Z(afVar, friendsManager, subMsgType0x27$ForwardBody);
                                                                                    continue;
                                                                                case 212:
                                                                                    f(subMsgType0x27$ForwardBody);
                                                                                    break;
                                                                            }
                                                                    }
                                                                } else {
                                                                    l(afVar, friendsManager, subMsgType0x27$ForwardBody);
                                                                }
                                                            } else {
                                                                n(afVar, friendsManager, troopManager, subMsgType0x27$ForwardBody);
                                                            }
                                                        }
                                                        j(subMsgType0x27$ForwardBody);
                                                    } else {
                                                        b0(afVar, subMsgType0x27$ForwardBody);
                                                    }
                                                } else {
                                                    c0(afVar, subMsgType0x27$ForwardBody);
                                                }
                                            } else {
                                                m(afVar, friendsManager, subMsgType0x27$ForwardBody);
                                            }
                                        } else {
                                            h(afVar, friendsManager, iPublicAccountDataManager, subMsgType0x27$ForwardBody);
                                        }
                                    } else {
                                        p(afVar, friendsManager, subMsgType0x27$ForwardBody);
                                    }
                                } else {
                                    o(afVar, friendsManager, subMsgType0x27$ForwardBody);
                                }
                            } else {
                                i(afVar, friendsManager, subMsgType0x27$ForwardBody);
                            }
                        } else {
                            d(afVar, friendsManager, subMsgType0x27$ForwardBody);
                        }
                    }
                }
            }
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(new ArrayList<>(Arrays.asList(dVarArr)), "MsgType0x210SubMsgType0x27", (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
        } catch (Exception e16) {
            QLog.e("MsgType0x210SubMsgType0x27", 1, "handleMsgType0x210SubMsgType0x27 decode fail.", e16);
        }
    }

    private static void b(QQAppInterface qQAppInterface, String str) {
        com.tencent.qqnt.kernel.api.w msgService = ((IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.e("MsgType0x210SubMsgType0x27", 1, "cancelTopContactOnDelFriend fail, service is null");
        } else {
            msgService.setContactLocalTop(new Contact(1, ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), ""), false, new IOperateCallback() { // from class: com.tencent.imcore.message.ext.codec.decoder.msgType0x210.al
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    am.d0(i3, str2);
                }
            });
        }
    }

    private void b0(com.tencent.imcore.message.af afVar, SubMsgType0x27$ForwardBody subMsgType0x27$ForwardBody) {
        String str;
        SubMsgType0x27$PraiseRankNotify subMsgType0x27$PraiseRankNotify = subMsgType0x27$ForwardBody.msg_praise_rank_notify.get();
        if (subMsgType0x27$PraiseRankNotify.str_msg.has()) {
            str = subMsgType0x27$PraiseRankNotify.str_msg.get();
        } else {
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "praise rank notify: " + str);
        }
        if (!TextUtils.isEmpty(str)) {
            String[] strArr = {"QQ", "QQ", str};
            Bitmap g16 = com.tencent.mobileqq.util.j.g(afVar.d().getApp().getResources(), R.drawable.icon);
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", afVar.d().getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
            Intent intent = new Intent(afVar.d().getApp(), (Class<?>) LikeRankingListActivity.class);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 1);
            intent.addFlags(67108864);
            toServiceMsg.extraData.putStringArray("cmds", strArr);
            toServiceMsg.extraData.putParcelable("intent", intent);
            toServiceMsg.extraData.putParcelable(MimeHelper.IMAGE_SUBTYPE_BITMAP, g16);
            afVar.d().sendToService(toServiceMsg);
            ReportController.o(afVar.d(), "dc00898", "", "", "0X8007618", "0X8007618", 0, 0, "", "", "", "");
        }
    }

    private void c0(com.tencent.imcore.message.af afVar, SubMsgType0x27$ForwardBody subMsgType0x27$ForwardBody) {
        if (subMsgType0x27$ForwardBody.bytes_redpoint_info.has()) {
            ((LocalRedTouchManager) afVar.d().getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).r(subMsgType0x27$ForwardBody.bytes_redpoint_info.get().toByteArray());
        }
    }

    private void d(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, SubMsgType0x27$ForwardBody subMsgType0x27$ForwardBody) {
        if (subMsgType0x27$ForwardBody.msg_add_group.has()) {
            SubMsgType0x27$AddGroup subMsgType0x27$AddGroup = subMsgType0x27$ForwardBody.msg_add_group.get();
            Groups groups = new Groups();
            if (subMsgType0x27$AddGroup.uint32_groupid.has()) {
                groups.group_id = subMsgType0x27$AddGroup.uint32_groupid.get();
            }
            if (subMsgType0x27$AddGroup.bytes_groupname.has()) {
                groups.group_name = subMsgType0x27$AddGroup.bytes_groupname.get().toStringUtf8();
            }
            if (subMsgType0x27$AddGroup.uint32_sortid.has()) {
                groups.seqid = (byte) subMsgType0x27$AddGroup.uint32_sortid.get();
            }
            if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a AddGroup  = id:" + groups.group_id + " name : " + groups.group_name + " sortid: " + ((int) groups.seqid));
            }
            friendsManager.u0(groups);
            AddGroupResp addGroupResp = new AddGroupResp();
            addGroupResp.dwToUin = Long.valueOf(afVar.d().getAccount()).longValue();
            byte b16 = groups.seqid;
            addGroupResp.dwSequence = b16;
            addGroupResp.cGroupId = (byte) groups.group_id;
            addGroupResp.cSortId = b16;
            afVar.d().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(18, true, new GroupActionResp(0, "", addGroupResp));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d0(int i3, String str) {
        QLog.i("MsgType0x210SubMsgType0x27", 1, "cancelTopContactOnDelFriend, result=" + i3 + ", errMsg=" + str);
    }

    private void e(com.tencent.imcore.message.af afVar, SubMsgType0x27$ForwardBody subMsgType0x27$ForwardBody) {
        try {
            SubMsgType0x27$MQQCampusNotify subMsgType0x27$MQQCampusNotify = subMsgType0x27$ForwardBody.msg_campus_notify.get();
            if (subMsgType0x27$MQQCampusNotify != null) {
                ((com.tencent.mobileqq.campuscircle.d) afVar.d().getManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)).e(subMsgType0x27$MQQCampusNotify);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.MQQCampusNotify fail", e16);
            }
        }
    }

    private void e0(FriendsManager friendsManager, long j3, long j16, int i3) {
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3));
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uidFromUin, String.valueOf(j3));
        dVar.M();
        int i16 = (int) j16;
        boolean z16 = false;
        if (i16 != 4090) {
            if (i16 == 4092) {
                if (i3 == 1) {
                    z16 = true;
                }
                dVar.b0(Boolean.valueOf(z16));
            }
        } else {
            if (i3 == 1) {
                z16 = true;
            }
            dVar.a0(Boolean.valueOf(z16));
        }
        iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, "MsgType0x210SubMsgType0x27", (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
    }

    private void f(SubMsgType0x27$ForwardBody subMsgType0x27$ForwardBody) {
        try {
            if (subMsgType0x27$ForwardBody.msg_chat_match_info.get() != null) {
                QLog.d("Q.msg.BaseMessageProcessorExtendFriendLimitChat", 2, "SubMsgType0x27.ChatMatchInfo");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.ChatMatchInfo fail", e16);
            }
        }
    }

    private void f0(SubMsgType0x27$FriendRemark subMsgType0x27$FriendRemark, com.tencent.imcore.message.af afVar) {
        if (subMsgType0x27$FriendRemark.uint64_group_code.has()) {
            if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModFriendRemark  : 1 troop troopcode = " + subMsgType0x27$FriendRemark.uint64_group_code.get());
            }
            ((ITroopInfoService) afVar.d().getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(String.valueOf(subMsgType0x27$FriendRemark.uint64_group_code.get())).troopRemark = subMsgType0x27$FriendRemark.bytes_rmk_name.get().toStringUtf8();
            afVar.d().getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER).notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_NOTIFY_UPDATE_RECENT_LIST, true, null);
        }
    }

    private void g(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, SubMsgType0x27$ForwardBody subMsgType0x27$ForwardBody) {
        if (subMsgType0x27$ForwardBody.msg_daren_notify.has()) {
            SubMsgType0x27$DaRenNotify subMsgType0x27$DaRenNotify = subMsgType0x27$ForwardBody.msg_daren_notify.get();
            long j3 = subMsgType0x27$DaRenNotify.uint64_uin.get();
            int i3 = subMsgType0x27$DaRenNotify.uint32_login_days.get();
            int i16 = subMsgType0x27$DaRenNotify.uint32_days.get();
            if (afVar.d().getCurrentAccountUin().equals(String.valueOf(j3))) {
                Card q16 = friendsManager.q(afVar.d().getCurrentAccountUin());
                long j16 = i3;
                if (j16 != q16.lLoginDays || i16 != q16.lQQMasterLogindays) {
                    q16.lLoginDays = j16;
                    q16.lQQMasterLogindays = i16;
                    friendsManager.p0(q16);
                    afVar.d().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, q16);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "daren notify received local data logindays=" + q16.lLoginDays + ";days=" + q16.lQQMasterLogindays);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "daren notify received uin=" + j3 + ";logindays=" + i3 + ";days=" + i16);
            }
        }
    }

    private void h(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, IPublicAccountDataManager iPublicAccountDataManager, SubMsgType0x27$ForwardBody subMsgType0x27$ForwardBody) {
        if (subMsgType0x27$ForwardBody.msg_del_friend.has()) {
            List<Long> list = subMsgType0x27$ForwardBody.msg_del_friend.get().rpt_uint64_uins.get();
            QQAppInterface qQAppInterface = (QQAppInterface) afVar.d();
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                friendsManager.l(longValue + "");
                iPublicAccountDataManager.delPublicAccountInfo(longValue + "");
                if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a DelFriend  = id:" + longValue);
                }
                try {
                    QidianManager qidianManager = (QidianManager) qQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
                    if (qidianManager != null) {
                        if (qidianManager.L(longValue + "")) {
                            qQAppInterface.getProxyManager().m().delC2CRecentUser(String.valueOf(longValue), true);
                            SharedPreferences.Editor edit = qQAppInterface.getApplication().getBaseContext().getSharedPreferences(qQAppInterface.getCurrentAccountUin() + "_customer_transfer_sharepreference", 0).edit();
                            edit.putBoolean(qQAppInterface.getCurrentAccountUin() + "_" + longValue + "", false);
                            edit.apply();
                        }
                    }
                    if (((com.tencent.mobileqq.troop.utils.bd) qQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)) == null) {
                        QLog.e("MsgType0x210SubMsgType0x27", 1, "handleDelFriend robotManager is null!");
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("cardpush", 2, "push a DelFriend  = id:" + longValue + " error :" + e16.toString());
                    }
                }
                qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(15, true, Long.valueOf(longValue));
                String valueOf = String.valueOf(longValue);
                IceBreakingUtil.z(qQAppInterface, valueOf);
                com.tencent.mobileqq.tofumsg.m.c(qQAppInterface, valueOf);
                com.tencent.mobileqq.mutualmark.nt.f.f252196a.p(String.valueOf(longValue));
                b(qQAppInterface, valueOf);
            }
            IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
            if (iPhoneContactService != null) {
                iPhoneContactService.onFriendListChanged();
            }
        }
    }

    private void i(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, SubMsgType0x27$ForwardBody subMsgType0x27$ForwardBody) {
        if (subMsgType0x27$ForwardBody.msg_del_group.has()) {
            SubMsgType0x27$DelGroup subMsgType0x27$DelGroup = subMsgType0x27$ForwardBody.msg_del_group.get();
            if (subMsgType0x27$DelGroup.uint32_groupid.has()) {
                Groups w3 = friendsManager.w(subMsgType0x27$DelGroup.uint32_groupid.get() + "");
                if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a DelGroup  = id:" + subMsgType0x27$DelGroup.uint32_groupid.get());
                }
                DelGroupResp delGroupResp = new DelGroupResp();
                delGroupResp.dwToUin = Long.valueOf(afVar.d().getAccount()).longValue();
                delGroupResp.dwSequence = w3.seqid;
                delGroupResp.cGroupid = (byte) subMsgType0x27$DelGroup.uint32_groupid.get();
                ((FriendListHandler) afVar.d().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).handleDelGroupResp(delGroupResp, true, new GroupActionResp(0, "", delGroupResp));
            }
        }
    }

    private void j(SubMsgType0x27$ForwardBody subMsgType0x27$ForwardBody) {
        try {
            SubMsgType0x27$FrdCustomOnlineStatusChange subMsgType0x27$FrdCustomOnlineStatusChange = subMsgType0x27$ForwardBody.msg_frd_custom_online_status_change.get();
            if (subMsgType0x27$FrdCustomOnlineStatusChange != null) {
                CustomOnlineStatusManager.Utils.i(subMsgType0x27$FrdCustomOnlineStatusChange);
                QLog.d("Q.msg.BaseMessageProcessorCustomOnlineStatus", 2, "SubMsgType0x27.FrdCustomOnlineStatusChange");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.FrdCustomOnlineStatusChange fail", e16);
            }
        }
    }

    private void k(com.tencent.imcore.message.af afVar, TroopManager troopManager, SubMsgType0x27$ForwardBody subMsgType0x27$ForwardBody) {
        if (subMsgType0x27$ForwardBody.msg_mod_custom_face.has()) {
            SubMsgType0x27$ModCustomFace subMsgType0x27$ModCustomFace = subMsgType0x27$ForwardBody.msg_mod_custom_face.get();
            if (subMsgType0x27$ModCustomFace.uint32_type.has() && subMsgType0x27$ModCustomFace.uint64_uin.has()) {
                IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) afVar.d().getRuntimeService(IQQAvatarHandlerService.class, "");
                ITroopInfoService iTroopInfoService = (ITroopInfoService) afVar.d().getRuntimeService(ITroopInfoService.class, "");
                if (subMsgType0x27$ModCustomFace.uint32_type.get() == 0) {
                    long j3 = subMsgType0x27$ModCustomFace.uint64_uin.get();
                    String l3 = Long.toString(j3);
                    if (QLog.isColorLevel()) {
                        QLog.d("cardpush", 2, "push a ModCustomFace  :0  Normal user uin = " + j3);
                    }
                    iQQAvatarHandlerService.getCustomHead(l3);
                    iQQAvatarHandlerService.sendBroadCastHeadChanged(1, l3);
                    afVar.d().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, l3);
                    return;
                }
                if (subMsgType0x27$ModCustomFace.uint32_type.get() == 1) {
                    long j16 = subMsgType0x27$ModCustomFace.uint64_group_code.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("cardpush", 2, "push a ModCustomFace  :1 Troop uin = " + j16);
                    }
                    iTroopInfoService.findTroopInfo(String.valueOf(j16)).hasSetNewTroopHead = true;
                    iQQAvatarHandlerService.getTroopHead(Long.toString(j16));
                }
            }
        }
    }

    private void l(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, SubMsgType0x27$ForwardBody subMsgType0x27$ForwardBody) {
        boolean z16;
        if (subMsgType0x27$ForwardBody.msg_mod_friend_flag.has()) {
            SubMsgType0x27$SnsUpdateFlag subMsgType0x27$SnsUpdateFlag = subMsgType0x27$ForwardBody.msg_mod_friend_flag.get();
            if (subMsgType0x27$SnsUpdateFlag.rpt_msg_update_sns_flag.has()) {
                for (SubMsgType0x27$SnsUpdateOneFlag subMsgType0x27$SnsUpdateOneFlag : subMsgType0x27$SnsUpdateFlag.rpt_msg_update_sns_flag.get()) {
                    long j3 = subMsgType0x27$SnsUpdateOneFlag.uint64__uin.get();
                    int i3 = subMsgType0x27$SnsUpdateOneFlag.uint32_flag.get();
                    long j16 = subMsgType0x27$SnsUpdateOneFlag.uint64_id.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageProcessor", 2, "FriendShield : onLinePush : uin : " + j3 + " flag:" + i3 + " id:" + j16);
                    }
                    if (j16 == 4051) {
                        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3));
                        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d();
                        dVar.w0(String.valueOf(j3));
                        dVar.v0(uidFromUin);
                        dVar.M();
                        if (i3 == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        dVar.r0(z16);
                        iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, "MsgType0x210SubMsgType0x27", (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
                        if (!((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).isEnableBlackList()) {
                            BusinessHandler businessHandler = afVar.d().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                            Boolean bool = Boolean.TRUE;
                            businessHandler.notifyUI(54, true, new Object[]{Long.valueOf(j3), Boolean.valueOf(z16), bool, bool, ""});
                        }
                    }
                    e0(friendsManager, j3, j16, i3);
                }
            }
        }
    }

    private void m(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, SubMsgType0x27$ForwardBody subMsgType0x27$ForwardBody) {
        if (subMsgType0x27$ForwardBody.msg_mod_friend_remark.has()) {
            for (SubMsgType0x27$FriendRemark subMsgType0x27$FriendRemark : subMsgType0x27$ForwardBody.msg_mod_friend_remark.get().rpt_msg_frd_rmk.get()) {
                if (subMsgType0x27$FriendRemark.uint32_type.has()) {
                    if (subMsgType0x27$FriendRemark.uint32_type.get() == 0) {
                        long j3 = subMsgType0x27$FriendRemark.uint64_fuin.get();
                        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3));
                        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                        String remarkWithUid = iFriendsInfoService.getRemarkWithUid(uidFromUin, "MsgType0x210SubMsgType0x27");
                        if (QLog.isColorLevel()) {
                            QLog.d("cardpush", 2, "push a ModFriendRemark  : 0 Friend uin = " + subMsgType0x27$FriendRemark.uint64_fuin.get() + "\u5907\u6ce8 = " + subMsgType0x27$FriendRemark.bytes_rmk_name.get().toStringUtf8() + ",oldRemark = " + remarkWithUid);
                        }
                        friendsManager.r0(subMsgType0x27$FriendRemark.uint64_fuin.get() + "", subMsgType0x27$FriendRemark.bytes_rmk_name.get().toStringUtf8());
                        Card r16 = friendsManager.r(subMsgType0x27$FriendRemark.uint64_fuin.get() + "");
                        String stringUtf8 = subMsgType0x27$FriendRemark.bytes_rmk_name.get().toStringUtf8();
                        if (r16 != null && !stringUtf8.equals(r16.strReMark)) {
                            r16.strReMark = stringUtf8;
                            friendsManager.p0(r16);
                        }
                        if (iFriendsInfoService.isFriend(uidFromUin, "MsgType0x210SubMsgType0x27") && QQProfileItem.b(stringUtf8, remarkWithUid)) {
                            QQProfileItem.C(j3, stringUtf8, (com.tencent.mobileqq.app.n) afVar.d().getManager(QQManagerFactory.DISCUSSION_MANAGER));
                        }
                        AppInterface d16 = afVar.d();
                        String str = BusinessHandlerFactory.FRIENDLIST_HANDLER;
                        d16.getBusinessHandler(str).notifyUI(3, true, Long.toString(subMsgType0x27$FriendRemark.uint64_fuin.get()));
                        afVar.d().getBusinessHandler(str).notifyUI(27, true, new Object[]{subMsgType0x27$FriendRemark.uint64_fuin.get() + "", subMsgType0x27$FriendRemark.bytes_rmk_name.get().toStringUtf8(), (byte) 1});
                    } else if (subMsgType0x27$FriendRemark.uint32_type.get() == 1) {
                        f0(subMsgType0x27$FriendRemark, afVar);
                    }
                }
            }
        }
    }

    private void n(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, TroopManager troopManager, SubMsgType0x27$ForwardBody subMsgType0x27$ForwardBody) {
        SubMsgType0x27$ModSnsGeneralInfo subMsgType0x27$ModSnsGeneralInfo;
        QQAppInterface qQAppInterface = (QQAppInterface) afVar.d();
        if (subMsgType0x27$ForwardBody.msg_mod_friend_rings.has()) {
            for (SubMsgType0x27$SnsUpateBuffer subMsgType0x27$SnsUpateBuffer : subMsgType0x27$ForwardBody.msg_mod_friend_rings.get().rpt_msg_sns_general_infos.get()) {
                Iterator<SubMsgType0x27$SnsUpdateItem> it = subMsgType0x27$SnsUpateBuffer.rpt_msg_sns_update_item.get().iterator();
                while (it.hasNext()) {
                    int i3 = it.next().uint32_update_sns_type.get();
                    if (i3 != 13569 || subMsgType0x27$SnsUpateBuffer.uint32_result.get() != 0) {
                        if (i3 == 13571) {
                            QLog.d("Q.msg.BaseMessageProcessor", 1, "onlinePush, oprerate external show troop troopUin=" + String.valueOf(Long.valueOf(subMsgType0x27$SnsUpateBuffer.uint64_code.get())));
                        }
                    }
                }
            }
        }
        if (subMsgType0x27$ForwardBody.msg_mod_friend_rings.has() && (subMsgType0x27$ModSnsGeneralInfo = subMsgType0x27$ForwardBody.msg_mod_friend_rings.get()) != null && subMsgType0x27$ModSnsGeneralInfo.rpt_msg_sns_general_infos.has()) {
            List<SubMsgType0x27$SnsUpateBuffer> list = subMsgType0x27$ModSnsGeneralInfo.rpt_msg_sns_general_infos.get();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (SubMsgType0x27$SnsUpateBuffer subMsgType0x27$SnsUpateBuffer2 : list) {
                if (subMsgType0x27$SnsUpateBuffer2 != null && subMsgType0x27$SnsUpateBuffer2.uint64_uin.has() && subMsgType0x27$SnsUpateBuffer2.rpt_msg_sns_update_item.has()) {
                    String valueOf = String.valueOf(subMsgType0x27$SnsUpateBuffer2.uint64_uin.get());
                    for (SubMsgType0x27$SnsUpdateItem subMsgType0x27$SnsUpdateItem : subMsgType0x27$SnsUpateBuffer2.rpt_msg_sns_update_item.get()) {
                        if (subMsgType0x27$SnsUpdateItem != null && subMsgType0x27$SnsUpdateItem.uint32_update_sns_type.has() && subMsgType0x27$SnsUpdateItem.bytes_value.has()) {
                            if (!FriendsStatusUtil.e(subMsgType0x27$SnsUpdateItem, qQAppInterface, valueOf)) {
                                if (subMsgType0x27$SnsUpdateItem.uint32_update_sns_type.get() == 13568) {
                                    com.tencent.mobileqq.activity.specialcare.e.a(valueOf, subMsgType0x27$SnsUpdateItem.bytes_value.get().toStringUtf8(), qQAppInterface);
                                }
                                String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(valueOf);
                                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) hashMap.get(uidFromUin);
                                com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar = (com.tencent.qqnt.ntrelation.otherinfo.bean.c) hashMap2.get(uidFromUin);
                                if (dVar == null || cVar == null) {
                                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "MsgType0x210SubMsgType0x27");
                                    com.tencent.qqnt.ntrelation.otherinfo.bean.c otherSimpleInfoWithUid = ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).getOtherSimpleInfoWithUid(uidFromUin, "MsgType0x210SubMsgType0x27");
                                    if (friendsSimpleInfoWithUid == null) {
                                        dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d();
                                        dVar.v0(uidFromUin);
                                        dVar.w0(valueOf);
                                        dVar.M();
                                    }
                                    if (otherSimpleInfoWithUid == null) {
                                        cVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.c();
                                        cVar.t(uidFromUin);
                                        cVar.u(valueOf);
                                        cVar.m();
                                    }
                                    if (cVar != null) {
                                        hashMap.put(cVar.getUid(), dVar);
                                        hashMap2.put(cVar.getUid(), cVar);
                                    }
                                }
                                int i16 = subMsgType0x27$SnsUpdateItem.uint32_update_sns_type.get();
                                String stringUtf8 = subMsgType0x27$SnsUpdateItem.bytes_value.get().toStringUtf8();
                                FriendListHandler.initSpecialCareInfo(dVar, i16, stringUtf8, cVar);
                                if (QLog.isColorLevel()) {
                                    QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x27 uin=" + valueOf + ", itemtype=" + i16 + ",itemVal=" + stringUtf8);
                                }
                            }
                        }
                    }
                }
            }
            Iterator it5 = hashMap.entrySet().iterator();
            ArrayList arrayList = new ArrayList();
            while (it5.hasNext()) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar2 = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) ((Map.Entry) it5.next()).getValue();
                if (dVar2 != null && !dVar2.F().booleanValue()) {
                    arrayList.add(dVar2);
                }
            }
            int size = hashMap.size();
            if (size == 0) {
                return;
            }
            for (int i17 = size - 1; i17 >= 0; i17--) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar3 = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) hashMap.get(Integer.valueOf(i17));
                if (dVar3 != null && !dVar3.F().booleanValue()) {
                    arrayList.remove(i17);
                    if (i17 < hashMap2.size()) {
                        hashMap2.remove(Integer.valueOf(i17));
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x27 bulkSaveOrUpdateSpecialCareInfos=" + hashMap.size());
            }
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(new ArrayList<>(hashMap.values()), "MsgType0x210SubMsgType0x27", new b(hashMap2, hashMap, qQAppInterface));
        }
    }

    private void o(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, SubMsgType0x27$ForwardBody subMsgType0x27$ForwardBody) {
        if (subMsgType0x27$ForwardBody.msg_mod_group_name.has()) {
            SubMsgType0x27$ModGroupName subMsgType0x27$ModGroupName = subMsgType0x27$ForwardBody.msg_mod_group_name.get();
            if (subMsgType0x27$ModGroupName.uint32_groupid.has() && subMsgType0x27$ModGroupName.bytes_groupname.has()) {
                int i3 = subMsgType0x27$ModGroupName.uint32_groupid.get();
                String stringUtf8 = subMsgType0x27$ModGroupName.bytes_groupname.get().toStringUtf8();
                Groups w3 = friendsManager.w(String.valueOf(i3));
                if (w3 != null) {
                    w3.group_name = stringUtf8;
                } else {
                    w3 = new Groups();
                    w3.group_id = i3;
                    w3.group_name = stringUtf8;
                }
                friendsManager.u0(w3);
                if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a ModGroupName  = id:" + subMsgType0x27$ModGroupName.uint32_groupid.get() + " name:" + subMsgType0x27$ModGroupName.bytes_groupname.get().toStringUtf8());
                }
                RenameGroupResp renameGroupResp = new RenameGroupResp();
                renameGroupResp.dwToUin = subMsgType0x27$ModGroupName.uint32_groupid.get();
                renameGroupResp.sGroupName = subMsgType0x27$ModGroupName.bytes_groupname.get().toStringUtf8();
                afVar.d().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(19, true, new GroupActionResp(0, "", renameGroupResp));
            }
        }
    }

    private void p(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, SubMsgType0x27$ForwardBody subMsgType0x27$ForwardBody) {
        List<SubMsgType0x27$GroupSort> list;
        if (subMsgType0x27$ForwardBody.msg_mod_group_sort.has() && (list = subMsgType0x27$ForwardBody.msg_mod_group_sort.get().rpt_msg_groupsort.get()) != null) {
            byte[] bArr = new byte[list.size()];
            byte[] bArr2 = new byte[list.size()];
            int i3 = 0;
            for (SubMsgType0x27$GroupSort subMsgType0x27$GroupSort : list) {
                if (subMsgType0x27$GroupSort.uint32_groupid.has() && subMsgType0x27$GroupSort.uint32_sortid.has()) {
                    bArr[i3] = (byte) subMsgType0x27$GroupSort.uint32_groupid.get();
                    bArr2[i3] = (byte) subMsgType0x27$GroupSort.uint32_sortid.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("cardpush", 2, "push a ModGroupSort  = id:" + subMsgType0x27$GroupSort.uint32_groupid.get() + " sortid:" + subMsgType0x27$GroupSort.uint32_sortid.get());
                    }
                    i3++;
                }
            }
            afVar.d().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(22, true, null);
            ((IFriendDataService) ((QQAppInterface) afVar.d()).getRuntimeService(IFriendDataService.class, "")).updateGroupSortIds(bArr, bArr2);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x006f. Please report as an issue. */
    private int q(com.tencent.imcore.message.af afVar, SubMsgType0x27$ForwardBody subMsgType0x27$ForwardBody, FriendsManager friendsManager, com.tencent.qqnt.ntrelation.friendsinfo.bean.d[] dVarArr, int i3) {
        int i16;
        int i17;
        am amVar = this;
        com.tencent.imcore.message.af afVar2 = afVar;
        SubMsgType0x27$ModProfile subMsgType0x27$ModProfile = subMsgType0x27$ForwardBody.msg_mod_profile.get();
        if (!subMsgType0x27$ModProfile.uint64_uin.has()) {
            return i3;
        }
        long j3 = subMsgType0x27$ModProfile.uint64_uin.get();
        QQAppInterface qQAppInterface = (QQAppInterface) afVar.d();
        IProfileCommonService iProfileCommonService = (IProfileCommonService) qQAppInterface.getRuntimeService(IProfileCommonService.class, "all");
        iProfileCommonService.notifyProfileModifyPushBegin(j3);
        int i18 = i3;
        int i19 = 0;
        int i26 = 0;
        boolean z16 = false;
        for (SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo : subMsgType0x27$ModProfile.rpt_msg_profile_infos.get()) {
            if (subMsgType0x27$ProfileInfo.uint32_field.has() && subMsgType0x27$ProfileInfo.bytes_value.has()) {
                int i27 = subMsgType0x27$ProfileInfo.uint32_field.get();
                ByteStringMicro byteStringMicro = subMsgType0x27$ProfileInfo.bytes_value.get();
                switch (i27) {
                    case 20002:
                        i16 = i19;
                        i17 = i26;
                        i18 = r(afVar, friendsManager, dVarArr, i18, j3, subMsgType0x27$ProfileInfo);
                        i19 = i16;
                        i26 = i17;
                        break;
                    case 20009:
                        s(afVar, friendsManager, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case 20015:
                        t(afVar, friendsManager, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case 20059:
                        amVar.u(afVar2, subMsgType0x27$ProfileInfo);
                        break;
                    case 23104:
                        amVar.v(afVar2, subMsgType0x27$ProfileInfo);
                        break;
                    case 23109:
                        amVar.w(afVar2, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case 27025:
                        x(afVar, friendsManager, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case 27041:
                        y(afVar, friendsManager, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case ProfileContants.FIELD_VIP_FONT_ID_TYPE /* 27201 */:
                        i26 = z(afVar, friendsManager, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case ProfileContants.FIELD_KING_GMAE_LAST_LOGIN_TIME /* 27224 */:
                        A(afVar, friendsManager, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case ProfileContants.FIELD_KING_GAME_ID /* 27225 */:
                        B(afVar, friendsManager, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case 27235:
                        C(afVar, friendsManager, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case 27238:
                        amVar.D(afVar2, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case ProfileContants.FIELD_VIP_DIY_FONT_TIMESTAMP /* 27241 */:
                        int i28 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
                        if (i28 != 0) {
                            i19 = i28;
                            z16 = true;
                            break;
                        } else {
                            i19 = i28;
                            break;
                        }
                    case ProfileContants.FIELD_VIP_FONT_EFFECT /* 27254 */:
                        E(afVar, friendsManager, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case ProfileContants.FIELD_THEME_TYPE /* 27262 */:
                        amVar.F(afVar2, subMsgType0x27$ProfileInfo);
                        break;
                    case ProfileContants.FIELD_BG_TYPE /* 27263 */:
                        amVar.G(afVar2, subMsgType0x27$ProfileInfo);
                        break;
                    case 27370:
                        amVar.H(afVar2, subMsgType0x27$ProfileInfo);
                        break;
                    case ProfileContants.FIELD_NEW_ONLINE_STATUS /* 27372 */:
                        amVar.I(afVar2, subMsgType0x27$ProfileInfo);
                        break;
                    case ProfileContants.FIELD_THEME_FONT_TYPE /* 27373 */:
                        amVar.J(subMsgType0x27$ProfileInfo);
                        break;
                    case 27375:
                        K(afVar, friendsManager, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case ProfileContants.FIELD_VIP_MAGIC_FONT_FLAG /* 40530 */:
                        L(afVar, friendsManager, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case 40551:
                        M(afVar);
                        break;
                    case 41812:
                        N(afVar, friendsManager, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case 42116:
                        VasLogNtReporter.getVipIcon().reportDebug("0x27 42116 and request vipInfo");
                        TicketManager ticketManager = (TicketManager) qQAppInterface.getManager(2);
                        ((VipInfoHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).sendGetBaseVipInfoReq(VasSkey.getSkey(ticketManager, String.valueOf(j3)), j3 + "");
                        break;
                    case ProfileContants.FIELD_KING_GAME_DAN_DISPLAY_SWITCH /* 42121 */:
                        O(afVar, friendsManager, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case ProfileContants.FIELD_KING_GAME_DAN /* 42122 */:
                        P(afVar, friendsManager, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case 42224:
                    case 42226:
                    case 42227:
                    case 42228:
                    case 42368:
                    case 42370:
                    case 42375:
                    case 42378:
                        amVar.Q(afVar2, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case ProfileContants.FIELD_VIP_CUSTOM_ICON_ID_FIELD /* 42249 */:
                        R(afVar, friendsManager, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case 42287:
                        amVar.S(afVar2, subMsgType0x27$ProfileInfo);
                        break;
                    case ProfileContants.FIELD_EMOTION_RECOMMEND_FLAG /* 42315 */:
                        amVar.T(afVar2, subMsgType0x27$ProfileInfo);
                        break;
                    case ProfileContants.FIELD_QQ_LEVEL_ICON_TYPE /* 42334 */:
                        U(afVar, friendsManager, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case ProfileContants.FIELD_NAMEPLATEVIPTYPE /* 42344 */:
                        V(afVar, friendsManager, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case ProfileContants.FIELD_GRAYNAMEPLATE /* 42354 */:
                        W(afVar, friendsManager, j3, subMsgType0x27$ProfileInfo);
                        break;
                    case ProfileContants.FILED_CUSTOMIZE_GRAY_TIPS_WORDING_ID /* 42393 */:
                        amVar.X(afVar2, subMsgType0x27$ProfileInfo);
                        break;
                    case HttpOp.HTTP_READTIMEOUT /* 45000 */:
                        amVar.Y(afVar2, subMsgType0x27$ProfileInfo);
                        break;
                    default:
                        i16 = i19;
                        i17 = i26;
                        iProfileCommonService.notifyProcessProfileModifyPush(i27, byteStringMicro);
                        i19 = i16;
                        i26 = i17;
                        break;
                }
                amVar = this;
                afVar2 = afVar;
            }
            i16 = i19;
            i17 = i26;
            i19 = i16;
            i26 = i17;
            amVar = this;
            afVar2 = afVar;
        }
        int i29 = i19;
        int i36 = i26;
        iProfileCommonService.notifyProfileModifyPushEnd();
        if (!z16) {
            return i18;
        }
        if (QLog.isColorLevel()) {
            QLog.d(FontManagerConstants.TAG, 2, "Onlinepush hasDiyFontTimestamp: uin = " + j3 + " fontid = " + i36 + " timestamp = " + i29);
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3));
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(uidFromUin, "MsgType0x210SubMsgType0x27");
        if (vasSimpleInfoWithUid == null) {
            vasSimpleInfoWithUid = new NTVasSimpleInfo();
            vasSimpleInfoWithUid.f(String.valueOf(j3));
            vasSimpleInfoWithUid.e(uidFromUin);
        }
        NTVasSimpleInfo nTVasSimpleInfo = vasSimpleInfoWithUid;
        ((IFontManagerService) afVar.d().getRuntimeService(IFontManagerService.class, "")).checkUpdateDIYConfig(afVar.d(), String.valueOf(j3), nTVasSimpleInfo, i36 == 0 ? (int) nTVasSimpleInfo.uVipFont : i36, i29);
        return i18;
    }

    private int r(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, com.tencent.qqnt.ntrelation.friendsinfo.bean.d[] dVarArr, int i3, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        String str;
        String stringUtf8 = subMsgType0x27$ProfileInfo.bytes_value.get().toStringUtf8();
        if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModProfile Nick = " + stringUtf8);
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(Long.toString(j3));
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "MsgType0x210SubMsgType0x27");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uidFromUin, Long.toString(j3));
        dVar.M();
        if (friendsSimpleInfoWithUid != null) {
            str = friendsSimpleInfoWithUid.p();
        } else {
            str = null;
        }
        dVar.k0(stringUtf8);
        dVar.g0(System.currentTimeMillis());
        int i16 = i3 + 1;
        dVarArr[i3] = dVar;
        if (friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.B() && QQProfileItem.a(stringUtf8, str)) {
            QQProfileItem.B(j3, stringUtf8, (com.tencent.mobileqq.app.n) afVar.d().getManager(QQManagerFactory.DISCUSSION_MANAGER));
        }
        Card r16 = friendsManager.r(j3 + "");
        if (r16 != null) {
            r16.strNick = stringUtf8;
            friendsManager.p0(r16);
            afVar.d().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, r16);
        }
        afVar.d().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(j3));
        return i16;
    }

    private void s(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        byte b16 = 0;
        byte byteAt = subMsgType0x27$ProfileInfo.bytes_value.get().byteAt(0);
        if (byteAt != 1) {
            if (byteAt == 2) {
                b16 = 1;
            } else if (byteAt == 0) {
                b16 = 2;
            } else {
                b16 = byteAt;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModProfile Sex = " + ((int) b16));
        }
        Card r16 = friendsManager.r(j3 + "");
        if (r16 != null) {
            r16.shGender = b16;
            friendsManager.p0(r16);
            afVar.d().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, r16);
        }
    }

    private void t(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        ByteStringMicro byteStringMicro = subMsgType0x27$ProfileInfo.bytes_value.get();
        if (byteStringMicro != null && byteStringMicro.size() == 2) {
            short byteAt = (short) (byteStringMicro.byteAt(1) | (byteStringMicro.byteAt(0) << 8));
            if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModProfile Head = " + ((int) byteAt));
            }
            ((IQQAvatarHandlerService) afVar.d().getRuntimeService(IQQAvatarHandlerService.class, "")).getCustomHead(Long.toString(j3));
            Card r16 = friendsManager.r(j3 + "");
            if (r16 != null) {
                r16.nFaceID = byteAt;
                friendsManager.p0(r16);
                afVar.d().getBusinessHandler(BusinessHandlerFactory.AVATAR_HANDLER).notifyUI(1, true, new Object[]{j3 + "", r16, null});
                afVar.d().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, r16);
            }
        }
    }

    private void u(com.tencent.imcore.message.af afVar, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        int i3 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get(0);
        afVar.o0(i3);
        ((ISVIPHandler) afVar.d().getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).notifyUI(101, true, Integer.valueOf(i3));
        if (QLog.isColorLevel()) {
            QLog.d("vip", 2, "bubble id = " + i3);
        }
    }

    private void v(com.tencent.imcore.message.af afVar, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        ByteStringMicro byteStringMicro = subMsgType0x27$ProfileInfo.bytes_value.get();
        int i3 = 2;
        if ((byteStringMicro.byteAt(5) & 2) != 0) {
            SharedPreferences sharedPreferences = afVar.d().getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
            if ((byteStringMicro.byteAt(1) & 2) == 0) {
                if (sharedPreferences.getInt("message_roam_flag" + afVar.d().getCurrentAccountUin(), -1) == 2) {
                    i3 = 1;
                } else {
                    i3 = -1;
                }
            }
            if (i3 != -1) {
                sharedPreferences.edit().putInt("message_roam_flag" + afVar.d().getCurrentAccountUin(), i3).apply();
                afVar.d().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(97, true, Integer.valueOf(i3));
            }
        }
    }

    private void w(com.tencent.imcore.message.af afVar, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        boolean z16;
        boolean z17;
        ByteStringMicro byteStringMicro = subMsgType0x27$ProfileInfo.bytes_value.get();
        QQAppInterface qQAppInterface = (QQAppInterface) afVar.d();
        if ((byteStringMicro.byteAt(31) & 32) != 0 || (byteStringMicro.byteAt(34) & RegisterType.UNINIT_REF) != 0 || (byteStringMicro.byteAt(29) & RegisterType.UNINIT_REF) != 0) {
            SharedPreferences sharedPreferences = qQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
            int i3 = 4;
            if ((byteStringMicro.byteAt(11) & 32) == 0 && (byteStringMicro.byteAt(14) & RegisterType.UNINIT_REF) == 0) {
                if ((byteStringMicro.byteAt(9) & RegisterType.UNINIT_REF) != 0) {
                    i3 = 3;
                } else {
                    int i16 = sharedPreferences.getInt("message_roam_flag" + qQAppInterface.getCurrentAccountUin(), -1);
                    i3 = (i16 == 4 || i16 == 3) ? 1 : -1;
                }
            }
            if (i3 != -1) {
                sharedPreferences.edit().putInt("message_roam_flag" + qQAppInterface.getCurrentAccountUin(), i3).apply();
                qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(97, true, Integer.valueOf(i3));
            }
        }
        if ((byteStringMicro.byteAt(12) & 8) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        ((ISttManagerApi) QRoute.api(ISttManagerApi.class)).setSttAbility(qQAppInterface, z16);
        if ((byteStringMicro.byteAt(13) & MaskType.MASK_TYPE_EXTERNAL) != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (SettingCloneUtil.readValue((Context) qQAppInterface.getApplication(), Long.toString(j3), (String) null, AppConstants.QQSETTING_PCACTIVE_KEY, false) != z17) {
            SettingCloneUtil.writeValue(qQAppInterface.getApplication(), Long.valueOf(j3).toString(), (String) null, AppConstants.QQSETTING_PCACTIVE_KEY, z17);
            Intent intent = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
            intent.putExtra("pcActive", z17);
            intent.putExtra("uin", Long.valueOf(j3).toString());
            qQAppInterface.getApp().sendBroadcast(intent);
            if (z17) {
                SettingCloneUtil.writeValue((Context) qQAppInterface.getApplication(), Long.toString(j3), (String) null, AppConstants.PCACTIVE_CONFIG, true);
                qQAppInterface.openMsfPCActive(Long.toString(j3), DownloadInfo.spKey_Config, true);
                QLog.d("OnlinePush", 1, "PCActive opened: true by switch push");
            }
        }
    }

    private void x(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        long j16 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asLongBuffer().get();
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3));
        IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, String.valueOf(j3));
        nTVasSimpleInfo.c();
        nTVasSimpleInfo.pendantId = j16;
        nTVasSimpleInfo.timestamp = System.currentTimeMillis();
        iVasInfoService.accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "MsgType0x210SubMsgType0x27", new e(j3, afVar));
    }

    private void y(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        int i3 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3));
        IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
        com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.a(uidFromUin, String.valueOf(j3));
        aVar.o(i3);
        aVar.v0(System.currentTimeMillis());
        iOtherInfoService.accurateUpdateNTOtherDetailInfo(new ArrayList<>(Collections.singletonList(aVar)), "MsgType0x210SubMsgType0x27", null);
    }

    private int z(com.tencent.imcore.message.af afVar, FriendsManager friendsManager, long j3, SubMsgType0x27$ProfileInfo subMsgType0x27$ProfileInfo) {
        long j16 = ByteBuffer.wrap(subMsgType0x27$ProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
        long parseFontId = FontManagerConstants.parseFontId(j16);
        int parseFontType = FontManagerConstants.parseFontType(j16);
        long currentTimeMillis = System.currentTimeMillis();
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3)), String.valueOf(j3));
        nTVasSimpleInfo.c();
        nTVasSimpleInfo.uVipFont = parseFontId;
        nTVasSimpleInfo.vipFontType = parseFontType;
        nTVasSimpleInfo.timestamp = currentTimeMillis;
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "MsgType0x210SubMsgType0x27", (hx3.c<NTVasSimpleInfo>) null);
        VasUtils.c(afVar.d());
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Font, uin=" + j3 + ", id=" + nTVasSimpleInfo.uVipFont + ", type = " + nTVasSimpleInfo.vipFontType);
        }
        return (int) FontManagerConstants.parseFontId(j16);
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        a0(afVar, msgType0x210.vProtobuf);
        return null;
    }
}
