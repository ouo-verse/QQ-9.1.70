package com.tencent.mobileqq.service.message;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.app.activateFriends.MessageForReminder;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForAIOStoryVideo;
import com.tencent.mobileqq.data.MessageForActivity;
import com.tencent.mobileqq.data.MessageForAioGift;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForAutoReply;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForColorRing;
import com.tencent.mobileqq.data.MessageForCommonHobbyForAIOShow;
import com.tencent.mobileqq.data.MessageForConfessCard;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForDarenAssistant;
import com.tencent.mobileqq.data.MessageForDateFeed;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageForLimitChatTopic;
import com.tencent.mobileqq.data.MessageForLocationShare;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMedalNews;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForMyEnterTroop;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForNearbyRecommenderTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForSplitLineTips;
import com.tencent.mobileqq.data.MessageForStarLeague;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopNotification;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageForVideoEmoticon;
import com.tencent.mobileqq.data.MessageForVideoVip;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.data.MessageForYanZhi;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.msgtype.MessageForGuildRevokeGrayTip;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.poke.IPokeSendHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.zplan.utils.ag;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static com.tencent.imcore.message.core.b f286328a;

    public static MessageForStructing A(QQAppInterface qQAppInterface, String str, String str2, String str3, int i3, long j3, AbsStructMsg absStructMsg) {
        MessageForStructing messageForStructing = (MessageForStructing) d(MessageRecord.MSG_TYPE_STRUCT_MSG);
        messageForStructing.msgtype = MessageRecord.MSG_TYPE_STRUCT_MSG;
        messageForStructing.structingMsg = absStructMsg;
        messageForStructing.mIsParsed = true;
        I(qQAppInterface, messageForStructing, str2, str3, i3);
        try {
            messageForStructing.msgData = absStructMsg.getBytes();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("structMsg", 2, e16.getMessage(), e16);
            }
        }
        if (absStructMsg.sourceAccoutType != 0) {
            messageForStructing.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
        }
        return messageForStructing;
    }

    public static MessageForText B(AppInterface appInterface, String str, String str2, String str3, int i3, byte b16, byte b17, short s16, String str4) {
        MessageForText messageForText = (MessageForText) d(-1000);
        messageForText.msgtype = -1000;
        messageForText.longMsgCount = b16;
        messageForText.longMsgIndex = b17;
        messageForText.longMsgId = s16;
        messageForText.f203106msg = str4;
        try {
            messageForText.msgData = str4.getBytes("utf-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
        I(appInterface, messageForText, str2, str3, i3);
        messageForText.parse();
        return messageForText;
    }

    public static MessageForTribeShortVideo C(QQAppInterface qQAppInterface, String str, String str2, String str3, int i3, long j3, AbsStructMsg absStructMsg) {
        MessageForTribeShortVideo messageForTribeShortVideo = (MessageForTribeShortVideo) d(MessageRecord.MSG_TYPE_TRIBE_SHORT_VIDEO);
        messageForTribeShortVideo.msgtype = MessageRecord.MSG_TYPE_TRIBE_SHORT_VIDEO;
        messageForTribeShortVideo.structingMsg = absStructMsg;
        messageForTribeShortVideo.mIsParsed = false;
        I(qQAppInterface, messageForTribeShortVideo, str2, str3, i3);
        try {
            messageForTribeShortVideo.msgData = absStructMsg.getBytes();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("structMsg", 2, e16.getMessage(), e16);
            }
        }
        if (absStructMsg.sourceAccoutType != 0) {
            messageForTribeShortVideo.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
        }
        return messageForTribeShortVideo;
    }

    public static com.tencent.imcore.message.core.b D() {
        com.tencent.imcore.message.core.b bVar = f286328a;
        if (bVar != null) {
            return bVar;
        }
        synchronized (com.tencent.imcore.message.core.b.class) {
            com.tencent.imcore.message.core.b bVar2 = f286328a;
            if (bVar2 != null) {
                return bVar2;
            }
            com.tencent.imcore.message.core.c cVar = new com.tencent.imcore.message.core.c();
            f286328a = cVar;
            cVar.a(-7009, com.tencent.mobileqq.service.message.mrcallback.e.class);
            f286328a.a(-7010, com.tencent.mobileqq.service.message.mrcallback.d.class);
            f286328a.a(-7011, com.tencent.mobileqq.service.message.mrcallback.f.class);
            f286328a.a(-7012, com.tencent.mobileqq.service.message.mrcallback.a.class);
            f286328a.a(-7013, com.tencent.mobileqq.service.message.mrcallback.g.class);
            f286328a.a(-7014, com.tencent.mobileqq.service.message.mrcallback.h.class);
            f286328a.a(-7015, com.tencent.mobileqq.service.message.mrcallback.b.class);
            f286328a.a(-7016, com.tencent.mobileqq.service.message.mrcallback.c.class);
            return f286328a;
        }
    }

    private static MessageRecord E(int i3, int i16, String str, int i17, MessageRecord messageRecord) {
        if ((i3 == -1000 || i3 == -2006) && i17 == 1 && (i16 & 1) == 1) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("redbag_fold_msg") && jSONObject.getString("redbag_fold_msg").equals("true")) {
                        return new MessageForFoldMsg();
                    }
                    return messageRecord;
                }
                return messageRecord;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("msgFold", 2, e16.getMessage(), e16);
                    return messageRecord;
                }
                return messageRecord;
            }
        }
        return messageRecord;
    }

    private static MessageRecord F(int i3, String str, MessageRecord messageRecord) {
        int optInt;
        if (i3 == -2058) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("Emoji_Sticker_Info") && (optInt = new JSONObject(jSONObject.getString("Emoji_Sticker_Info")).optInt(QQBrowserActivity.KEY_MSG_TYPE, 0)) != 0) {
                    return e(optInt);
                }
                return messageRecord;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("MessageRecordFactory", 2, "", e16);
                    return messageRecord;
                }
                return messageRecord;
            }
        }
        return messageRecord;
    }

    private static void G(String str, MessageRecord messageRecord) {
        if (messageRecord != null && messageRecord.msgtype == -2056) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(MessageForWantGiftMsg.GIFT_SENDER_UIN)) {
                    if (QLog.isColorLevel()) {
                        QLog.e("MessageForWantGiftMsg.GIFT_SENDER_UIN", 2, " MessageForWantGiftMsg.GIFT_SENDER_UIN  " + MessageForWantGiftMsg.GIFT_SENDER_UIN);
                    }
                    try {
                        ((MessageForWantGiftMsg) messageRecord).wantGiftSenderUin = Long.valueOf(jSONObject.getString(MessageForWantGiftMsg.GIFT_SENDER_UIN)).longValue();
                    } catch (Exception unused) {
                    }
                    String str2 = MessageForWantGiftMsg.GIFT_SENDER_UIN;
                    messageRecord.saveExtInfoToExtStr(str2, jSONObject.getString(str2));
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("MessageForWantGiftMsg.GIFT_SENDER_UIN", 2, e16.getMessage(), e16);
                }
            }
        }
    }

    private static void H(MessageRecord messageRecord, MessageRecord messageRecord2) {
        messageRecord.selfuin = messageRecord2.selfuin;
        messageRecord.frienduin = messageRecord2.frienduin;
        messageRecord.senderuin = messageRecord2.senderuin;
        messageRecord.istroop = messageRecord2.istroop;
        messageRecord.longMsgCount = messageRecord2.longMsgCount;
        messageRecord.longMsgId = messageRecord2.longMsgId;
        messageRecord.longMsgIndex = messageRecord2.longMsgIndex;
        messageRecord.isread = true;
        messageRecord.issend = 1;
        messageRecord.msgseq = messageRecord2.msgseq;
        messageRecord.shmsgseq = messageRecord2.shmsgseq;
        messageRecord.msgUid = messageRecord2.msgUid;
        messageRecord.extStr = messageRecord2.extStr;
        messageRecord.extLong = messageRecord2.extLong;
        if (com.tencent.biz.anonymous.a.m(messageRecord2)) {
            messageRecord.vipBubbleID = messageRecord2.vipBubbleID;
        }
        messageRecord.time = (int) e.K0();
    }

    public static void I(AppInterface appInterface, MessageRecord messageRecord, String str, String str2, int i3) {
        RespondQueryQQBindingStat selfBindInfo;
        int a16 = s.a();
        int K0 = (int) e.K0();
        int i16 = MobileQQServiceBase.seq;
        MobileQQServiceBase.seq = i16 + 1;
        long j3 = i16;
        String currentAccountUin = appInterface.getCurrentAccountUin();
        if (i3 != 1000 && i3 != 1020 && i3 != 1004) {
            if (i3 == 1006 && (selfBindInfo = ((IPhoneContactService) appInterface.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo()) != null) {
                str2 = selfBindInfo.nationCode + selfBindInfo.mobileNo;
                if (str2 == null || str2.length() <= 0) {
                    if (QLog.isColorLevel()) {
                        QLog.e("MessageRecordFactory", 2, "createPicMessageToShow : error selfPhoneNum:" + str2);
                    }
                }
            }
            str2 = currentAccountUin;
        } else if ((str2 == null || str2.length() == 0) && QLog.isColorLevel()) {
            QLog.e("MessageRecordFactory", 2, "createPicMessageToShow : error groupUin:" + str2);
        }
        if (i3 == 10014) {
            IGPSService iGPSService = (IGPSService) appInterface.getRuntimeService(IGPSService.class, "");
            ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).saveGuildIdToMR(messageRecord, iGPSService.getGuildIdOf(str));
            String selfTinyId = iGPSService.getSelfTinyId();
            if (!TextUtils.isEmpty(selfTinyId) && !TextUtils.equals(selfTinyId, "0")) {
                str2 = selfTinyId;
            }
        }
        if (!(messageRecord instanceof MessageForPoke) && i3 == 0) {
            ((IPokeSendHelper) QRoute.api(IPokeSendHelper.class)).getStrengthStatus(appInterface, str, -1, -1);
            if (QLog.isColorLevel()) {
                QLog.d("PokeMsg", 2, "send unPokeMsg strength:-1");
            }
        }
        messageRecord.frienduin = str;
        messageRecord.istroop = i3;
        messageRecord.selfuin = currentAccountUin;
        messageRecord.senderuin = str2;
        messageRecord.isread = true;
        messageRecord.time = K0;
        messageRecord.msgseq = j3;
        messageRecord.msgUid = s.f(a16);
        messageRecord.shmsgseq = s.b(j3, i3);
        messageRecord.issend = 1;
    }

    private static MessageRecord a(int i3, MessageRecord messageRecord) {
        if (messageRecord == null && s.j(i3)) {
            if (i3 == -1002) {
                return new MessageForSafeGrayTips();
            }
            if (i3 != -5000 && i3 != -5001 && i3 != -2037) {
                if (i3 == -5002) {
                    return new MessageForIncompatibleGrayTips();
                }
                if (i3 == -2027) {
                    return new MessageForNearbyMarketGrayTips();
                }
                if (i3 == -4011) {
                    return new MessageForNearbyRecommenderTips();
                }
                if (i3 == -4050) {
                    return new MessageForGuildRevokeGrayTip();
                }
                if (i3 == -4089) {
                    return ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getNewMessageRecordForBlackRobotGrayTip();
                }
                if (i3 == -4091) {
                    return ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getNewMessageRecordForSubscribeChannelGrayTip();
                }
                if (i3 == -4092) {
                    return ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getNewMessageRecordForMsgNotifySettingGrayTips();
                }
                if (i3 == -4093) {
                    return ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getNewMessageRecordForRobotDirectMsgLimitGrayTip();
                }
                return new MessageForGrayTips();
            }
            return new MessageForNewGrayTips();
        }
        return messageRecord;
    }

    public static MessageForStructing b(QQAppInterface qQAppInterface, String str, int i3, String str2, String str3) {
        StructMsgForGeneralShare b16 = com.tencent.mobileqq.structmsg.i.b();
        b16.mMsgActionData = str3;
        b16.mMsgBrief = str2;
        return A(qQAppInterface, "", str, "", i3, 0L, b16);
    }

    private static MessageRecord c(int i3) {
        com.tencent.imcore.message.core.a aVar = D().get(Integer.valueOf(i3));
        if (aVar != null) {
            return aVar.a(i3);
        }
        return null;
    }

    public static MessageRecord d(int i3) {
        MessageRecord e16 = e(i3);
        if (e16 == null) {
            MessageForText messageForText = new MessageForText();
            messageForText.msgtype = i3;
            return messageForText;
        }
        return e16;
    }

    private static MessageRecord e(int i3) {
        MessageRecord a16 = a(i3, f(i3));
        if (a16 != null) {
            a16.msgtype = i3;
        }
        return a16;
    }

    private static MessageRecord f(int i3) {
        switch (i3) {
            case -20000:
            case MessageRecord.MSG_TYPE_GAME_SHARE /* -3005 */:
            case MessageRecord.MSG_TYPE_GAME_INVITE /* -3004 */:
            case -3001:
            case -3000:
            case -2000:
            case -1032:
                return new MessageForPic();
            case -8018:
                return new MessageForAniSticker();
            case MessageRecord.MSG_TYPE_LIFEONLINEACCOUNT /* -5004 */:
            case MessageRecord.MSG_TYPE_PUBLIC_ACCOUNT /* -3006 */:
                return new MessageForPubAccount();
            case MessageRecord.MSG_TYPE_TROOP_WANT_GIFT_MSG /* -2056 */:
                return new MessageForWantGiftMsg();
            case MessageRecord.MSG_TYPE_STRUCT_TROOP_NOTIFICATION /* -2021 */:
                return new MessageForTroopNotification();
            case MessageRecord.MSG_TYPE_GROUPDISC_FILE /* -2014 */:
            case -2005:
                return new MessageForFile();
            case MessageRecord.MSG_TYPE_STRUCT_MSG /* -2011 */:
                return new MessageForStructing();
            case -2008:
            case -1003:
            case -1000:
                return new MessageForText();
            case -2007:
                return new MessageForMarketFace();
            case -2002:
            case -1031:
                return new MessageForPtt();
            default:
                return g(i3);
        }
    }

    private static MessageRecord g(int i3) {
        switch (i3) {
            case -10000:
                return new MessageForAutoReply();
            case -4073:
            case MessageRecord.MSG_TYPE_PSTN_CALL /* -2046 */:
            case MessageRecord.MSG_TYPE_LIGHTALK_MSG /* -2026 */:
            case MessageRecord.MSG_TYPE_MULTI_VIDEO /* -2016 */:
            case -2009:
                return new MessageForVideo();
            case MessageRecord.MSG_TYPE_SPLIT_LINE_GRAY_TIPS /* -4012 */:
                return new MessageForSplitLineTips();
            case MessageRecord.MSG_TYPE_TROOP_UNREAD_TIPS /* -4009 */:
                return new MessageForTroopUnreadTips();
            case -4004:
                return new MessageForMyEnterTroop();
            case -4003:
                return new MessageForEnterTroop();
            case -4002:
                return new MessageForActivity();
            case MessageRecord.MSG_TYPE_AIO_FOR_LOCATION_SHARE /* -2076 */:
                return new MessageForLocationShare();
            case MessageRecord.MSG_TYPE_FRIEND_SYSTEM_STRUCT_MSG /* -2050 */:
            case MessageRecord.MSG_TYPE_SYSTEM_STRUCT_MSG /* -2018 */:
                return new MessageForSystemMsg();
            case MessageRecord.MSG_TYPE_MEDIA_SHORTVIDEO /* -2022 */:
                return new MessageForShortVideo();
            case MessageRecord.MSG_TYPE_SHAKE_WINDOW /* -2020 */:
                MessageForShakeWindow messageForShakeWindow = new MessageForShakeWindow();
                messageForShakeWindow.msgtype = MessageRecord.MSG_TYPE_SHAKE_WINDOW;
                return messageForShakeWindow;
            case MessageRecord.MSG_TYPE_TROOP_OBJ_MSG /* -2017 */:
                return new MessageForTroopFile();
            case MessageRecord.MSG_TYPE_QZONE_NEWEST_FEED /* -2015 */:
                return new MessageForQzoneFeed();
            case MessageRecord.MSG_TYPE_DATE_FEED /* -1042 */:
                return new MessageForDateFeed();
            case MessageRecord.MSG_TYPE_MIX /* -1035 */:
                return new MessageForMixedMsg();
            case MessageRecord.MSG_TYPE_TEXT_FRIEND_FEED /* -1034 */:
                return new MessageForRichState();
            default:
                return h(i3);
        }
    }

    private static MessageRecord h(int i3) {
        if (i3 != -7090) {
            if (i3 != -5003) {
                if (i3 != -3012) {
                    if (i3 != -2049 && i3 != -2043 && i3 != -2041) {
                        if (i3 != -2038) {
                            if (i3 != -2029) {
                                if (i3 != -2025) {
                                    if (i3 != -2036) {
                                        if (i3 != -2035) {
                                            return i(i3);
                                        }
                                        return new MessageForDeliverGiftTips();
                                    }
                                    return new MessageForTroopFee();
                                }
                                return new MessageForQQWalletMsg();
                            }
                            return new MessageForQQWalletTips();
                        }
                        return new MessageForTroopGift();
                    }
                    return new MessageForGrayTips();
                }
                return new MessageForColorRing();
            }
            return new MessageForActivateFriends();
        }
        return new MessageForReminder();
    }

    private static MessageRecord i(int i3) {
        if (i3 != -5018) {
            if (i3 != -5017) {
                if (i3 != -5009) {
                    if (i3 != -5008 && i3 != -4072 && i3 != -4071) {
                        if (i3 != -2048) {
                            if (i3 != -2047) {
                                if (i3 != -2045) {
                                    if (i3 != -1051) {
                                        if (i3 != -1049) {
                                            if (i3 != -2040) {
                                                if (i3 != -2039) {
                                                    switch (i3) {
                                                        case MessageRecord.MSG_TYPE_FLASH_CHAT /* -5013 */:
                                                            return new MessageForArkFlashChat();
                                                        case MessageRecord.MSG_TYPE_POKE_MSG /* -5012 */:
                                                            return new MessageForPoke();
                                                        case MessageRecord.MSG_TYPE_FOLD_MSG_GRAY_TIPS /* -5011 */:
                                                            return new MessageForFoldMsgGrayTips();
                                                        default:
                                                            switch (i3) {
                                                                case -4027:
                                                                case -4026:
                                                                case -4025:
                                                                    break;
                                                                default:
                                                                    return j(i3);
                                                            }
                                                    }
                                                } else {
                                                    return new MessageForText();
                                                }
                                            } else {
                                                return new MessageForApproval();
                                            }
                                        } else {
                                            return new MessageForReplyText();
                                        }
                                    } else {
                                        return new MessageForLongTextMsg();
                                    }
                                } else {
                                    return new MessageForVideoVip();
                                }
                            } else {
                                return new MessageForVIPDonate();
                            }
                        } else {
                            return new MessageForTroopReward();
                        }
                    }
                } else {
                    return new MessageForAioGift();
                }
            }
            return new MessageForArkApp();
        }
        return new MessageForPokeEmo();
    }

    private static MessageRecord j(int i3) {
        if (i3 != -7001) {
            if (i3 != -5040) {
                if (i3 != -5015) {
                    if (i3 != -4100) {
                        if (i3 != -2062) {
                            if (i3 != -2057) {
                                if (i3 != -2051) {
                                    if (i3 != -2023) {
                                        if (i3 != -2060) {
                                            if (i3 != -2059) {
                                                switch (i3) {
                                                    case MessageRecord.MSG_TYPE_UNITE_TAB_HISTORI_INVI /* -5023 */:
                                                    case MessageRecord.MSG_TYPE_UNITE_TAB_DB_INVI /* -5022 */:
                                                    case MessageRecord.MSG_TYPE_UNITE_GRAY_HISTORY_INVI /* -5021 */:
                                                    case MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI /* -5020 */:
                                                        break;
                                                    default:
                                                        switch (i3) {
                                                            case MessageRecord.MSG_TYPE_TROOP_CONFESS /* -2067 */:
                                                                return new MessageForTroopConfess();
                                                            case MessageRecord.MSG_TYPE_CONFESS_CARD /* -2066 */:
                                                                return new MessageForConfessCard();
                                                            case MessageRecord.MSG_TYPE_CONFESS_NEWS /* -2065 */:
                                                                return new MessageForConfessNews();
                                                            default:
                                                                switch (i3) {
                                                                    case MessageRecord.MSG_TYPE_INTERACT_AND_FOLLOW /* -2055 */:
                                                                        return new MessageForInteractAndFollow();
                                                                    case MessageRecord.MSG_TYPE_TROOP_SIGN /* -2054 */:
                                                                        return new MessageForTroopSign();
                                                                    case MessageRecord.MSG_TYPE_NEARBY_LIVE_TIP /* -2053 */:
                                                                        return new MessageForNearbyLiveTip();
                                                                    default:
                                                                        return k(i3);
                                                                }
                                                        }
                                                }
                                            } else {
                                                return new MessageForTroopPobing();
                                            }
                                        } else {
                                            return new MessageForPLNews();
                                        }
                                    } else {
                                        return new MessageForCommonHobbyForAIOShow();
                                    }
                                } else {
                                    return new MessageForQQStory();
                                }
                            } else {
                                return new MessageForTroopStory();
                            }
                        } else {
                            return new MessageForMedalNews();
                        }
                    }
                } else {
                    return new MessageForTroopEffectPic();
                }
            }
            return new MessageForUniteGrayTip();
        }
        return new MessageForScribble();
    }

    private static MessageRecord k(int i3) {
        switch (i3) {
            case -8018:
                return new MessageForAniSticker();
            case MessageRecord.MSG_TYPE_BIRTHDAY_NOTICE /* -7007 */:
                return new MessageForBirthdayNotice();
            case MessageRecord.MSG_TYPE_LIMIT_CHAT_CONFIRM /* -7005 */:
                return new MessageForLimitChatConfirm();
            case MessageRecord.MSG_TYPE_TRIBE_SHORT_VIDEO /* -7002 */:
                return new MessageForTribeShortVideo();
            case MessageRecord.MSG_TYPE_ARK_BABYQ_REPLY /* -5016 */:
                return new MessageForArkBabyqReply();
            case MessageRecord.MSG_TYPE_GUILD_ROBOT_WELCOME_TIPS /* -4090 */:
                return ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getNewMessageRecordForDirectMessageWelcome();
            case MessageRecord.MSG_TYPE_GUILD_LIVE_GIFT /* -4070 */:
                return ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getMessageRecordForLiveGift();
            case MessageRecord.MSG_TYPE_GUILD_MARK_DOWN /* -4052 */:
                return ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getNewMessageRecordForMarkdown();
            case MessageRecord.MSG_TYPE_GUILD_APP_CHANNEL /* -4051 */:
                return ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getMessageRecordForAppChannel();
            case MessageRecord.MSG_TYPE_GUILD_WELCOME_TIPS /* -4028 */:
                return ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getNewMessageRecordForGuildWelcome();
            case MessageRecord.MSG_TYPE_LIMIT_CHAT_TOPIC_RECEIVER /* -4024 */:
            case MessageRecord.MSG_TYPE_LIMIT_CHAT_TOPIC /* -4023 */:
                return new MessageForLimitChatTopic();
            case -3017:
                return new MessageForDLFile();
            case MessageRecord.MSG_TYPE_VIDEO_EMOTICON /* -2079 */:
                return new MessageForVideoEmoticon();
            case MessageRecord.MSG_TYPE_ZPLAN /* -2078 */:
                return ag.f335760a.a();
            case MessageRecord.MSG_TYPE_QCIRCLE_NEWEST_FEED /* -2077 */:
                return new MessageForQCircleFeed();
            case MessageRecord.MSG_TYPE_AIO_FOR_STORY_VIDEO /* -2074 */:
                return new MessageForAIOStoryVideo();
            case MessageRecord.MSG_TYPE_FU_DAI /* -2072 */:
                return new MessageForFuDai();
            case MessageRecord.MSG_TYPE_YANZHI /* -2070 */:
                return new MessageForYanZhi();
            case MessageRecord.MSG_TYPE_TROOP_STAR_LEAGUE /* -2069 */:
                return new MessageForStarLeague();
            case MessageRecord.MSG_TYPE_DAREN_ASSISTANT /* -2068 */:
                return new MessageForDarenAssistant();
            default:
                return c(i3);
        }
    }

    public static MessageRecord l(int i3, byte[] bArr, int i16, String str, int i17) {
        MessageRecord e16 = e(i3);
        if (e16 != null) {
            e16.msgtype = i3;
        } else if (bArr != null) {
            e16 = m(bArr, e16);
        }
        G(str, e16);
        MessageRecord F = F(i3, str, E(i3, i16, str, i17, e16));
        if (F == null) {
            try {
                new j().c(i3, bArr, i16, str, i17);
            } catch (Exception e17) {
                QLog.i("MessageRecordFactory", 1, "createMsgRecordFromDB", e17);
            }
            MessageForText messageForText = new MessageForText();
            messageForText.msgtype = i3;
            return messageForText;
        }
        return F;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.tencent.mobileqq.data.MessageRecord] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    private static MessageRecord m(byte[] bArr, MessageRecord messageRecord) {
        Exception e16;
        MessageRecord messageRecord2;
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (Exception e17) {
            Object obj = messageRecord;
            e16 = e17;
            messageRecord2 = obj;
        }
        if (str.length() > 0 && str.charAt(0) == 22) {
            String[] split = str.split("\\|");
            if (split.length > 2) {
                messageRecord2 = Integer.parseInt(split[2]);
                try {
                    if (messageRecord2 == 3) {
                        MessageForGrayTips messageForGrayTips = new MessageForGrayTips();
                        messageRecord = -1001;
                        messageForGrayTips.msgtype = -1001;
                        messageRecord2 = messageForGrayTips;
                    } else if (messageRecord2 == 2 || messageRecord2 == 8) {
                        MessageForPtt messageForPtt = new MessageForPtt();
                        messageRecord = -2002;
                        messageForPtt.msgtype = -2002;
                        messageRecord2 = messageForPtt;
                    } else {
                        return messageRecord;
                    }
                } catch (Exception e18) {
                    e16 = e18;
                    e16.printStackTrace();
                    return messageRecord2;
                }
                return messageRecord2;
            }
            return messageRecord;
        }
        return messageRecord;
    }

    public static MessageRecord n(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return null;
        }
        MessageRecord d16 = d(messageRecord.msgtype);
        d16.msgtype = messageRecord.msgtype;
        H(d16, messageRecord);
        byte[] bArr = messageRecord.msgData;
        if (bArr != null) {
            d16.msgData = bArr;
        }
        String str = messageRecord.f203106msg;
        if (str != null) {
            d16.f203106msg = str;
        }
        if (d16 instanceof ChatMessage) {
            ((ChatMessage) d16).parse();
        }
        return d16;
    }

    public static MessageForShortVideo o(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        MessageForBlessPTV messageForBlessPTV = new MessageForBlessPTV();
        messageForBlessPTV.msgtype = MessageRecord.MSG_TYPE_MEDIA_SHORTVIDEO;
        I(qQAppInterface, messageForBlessPTV, str, str2, i3);
        messageForBlessPTV.longMsgCount = 1;
        messageForBlessPTV.longMsgIndex = 0;
        messageForBlessPTV.longMsgId = (short) messageForBlessPTV.shmsgseq;
        return messageForBlessPTV;
    }

    public static MessageForMixedMsg p(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        MessageForMixedMsg messageForMixedMsg = new MessageForMixedMsg();
        messageForMixedMsg.msgtype = MessageRecord.MSG_TYPE_MIX;
        I(qQAppInterface, messageForMixedMsg, str, str2, i3);
        messageForMixedMsg.longMsgCount = 1;
        messageForMixedMsg.longMsgIndex = 0;
        messageForMixedMsg.longMsgId = (short) messageForMixedMsg.shmsgseq;
        return messageForMixedMsg;
    }

    public static MessageForPic q(AppInterface appInterface, String str, String str2, int i3) {
        MessageForPic messageForPic = new MessageForPic();
        messageForPic.msgtype = -2000;
        I(appInterface, messageForPic, str, str2, i3);
        messageForPic.longMsgCount = 1;
        messageForPic.longMsgIndex = 0;
        messageForPic.longMsgId = (short) messageForPic.shmsgseq;
        return messageForPic;
    }

    public static MessageForPtt r(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        MessageForPtt messageForPtt = new MessageForPtt();
        messageForPtt.msgtype = -2002;
        I(qQAppInterface, messageForPtt, str, str2, i3);
        messageForPtt.longMsgCount = 1;
        messageForPtt.longMsgIndex = 0;
        messageForPtt.longMsgId = (short) messageForPtt.shmsgseq;
        return messageForPtt;
    }

    public static MessageForShortVideo s(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        MessageForShortVideo messageForShortVideo = new MessageForShortVideo();
        messageForShortVideo.msgtype = MessageRecord.MSG_TYPE_MEDIA_SHORTVIDEO;
        I(qQAppInterface, messageForShortVideo, str, str2, i3);
        messageForShortVideo.longMsgCount = 1;
        messageForShortVideo.longMsgIndex = 0;
        messageForShortVideo.longMsgId = (short) messageForShortVideo.shmsgseq;
        return messageForShortVideo;
    }

    public static MessageForShortVideo t(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        MessageForVideoEmoticon messageForVideoEmoticon = new MessageForVideoEmoticon();
        messageForVideoEmoticon.msgtype = MessageRecord.MSG_TYPE_VIDEO_EMOTICON;
        I(qQAppInterface, messageForVideoEmoticon, str, str2, i3);
        messageForVideoEmoticon.longMsgCount = 1;
        messageForVideoEmoticon.longMsgIndex = 0;
        messageForVideoEmoticon.longMsgId = (short) messageForVideoEmoticon.shmsgseq;
        return messageForVideoEmoticon;
    }

    public static MessageForArkApp u(QQAppInterface qQAppInterface, String str, String str2, int i3, ArkAppMessage arkAppMessage) {
        if (arkAppMessage == null) {
            return null;
        }
        MessageForArkApp messageForArkApp = (MessageForArkApp) e(MessageRecord.MSG_TYPE_ARK_APP);
        messageForArkApp.msgtype = MessageRecord.MSG_TYPE_ARK_APP;
        messageForArkApp.ark_app_message = arkAppMessage;
        arkAppMessage.updateMultiInfo("", messageForArkApp.uniseq);
        messageForArkApp.f203106msg = arkAppMessage.getSummery();
        messageForArkApp.msgData = messageForArkApp.ark_app_message.toBytes();
        I(qQAppInterface, messageForArkApp, str, str2, i3);
        messageForArkApp.longMsgCount = 1;
        messageForArkApp.longMsgIndex = 0;
        messageForArkApp.longMsgId = (short) messageForArkApp.shmsgseq;
        return messageForArkApp;
    }

    public static MessageForArkApp v(QQAppInterface qQAppInterface, String str, String str2, int i3, ArkAppMessage arkAppMessage) {
        if (arkAppMessage == null) {
            return null;
        }
        MessageForArkApp messageForArkApp = new MessageForArkApp();
        messageForArkApp.ark_app_message = arkAppMessage;
        arkAppMessage.fromAppXml(arkAppMessage.toAppXml());
        messageForArkApp.msgtype = MessageRecord.MSG_TYPE_ARK_SDK_SHARE;
        messageForArkApp.f203106msg = arkAppMessage.getSummery();
        messageForArkApp.msgData = arkAppMessage.toBytes();
        I(qQAppInterface, messageForArkApp, str, str2, i3);
        messageForArkApp.longMsgCount = 1;
        messageForArkApp.longMsgIndex = 0;
        messageForArkApp.longMsgId = (short) messageForArkApp.shmsgseq;
        return messageForArkApp;
    }

    public static MessageForArkFlashChat w(QQAppInterface qQAppInterface, String str, String str2, int i3, ArkFlashChatMessage arkFlashChatMessage) {
        if (arkFlashChatMessage == null) {
            return null;
        }
        MessageForArkFlashChat messageForArkFlashChat = new MessageForArkFlashChat();
        messageForArkFlashChat.msgtype = MessageRecord.MSG_TYPE_FLASH_CHAT;
        messageForArkFlashChat.ark_app_message = arkFlashChatMessage;
        messageForArkFlashChat.f203106msg = arkFlashChatMessage.getSummery();
        messageForArkFlashChat.msgData = messageForArkFlashChat.ark_app_message.toBytes();
        I(qQAppInterface, messageForArkFlashChat, str, str2, i3);
        messageForArkFlashChat.longMsgCount = 1;
        messageForArkFlashChat.longMsgIndex = 0;
        messageForArkFlashChat.longMsgId = (short) messageForArkFlashChat.shmsgseq;
        return messageForArkFlashChat;
    }

    public static MessageForMarketFace x(QQAppInterface qQAppInterface, String str, String str2, int i3, MarkFaceMessage markFaceMessage) {
        MessageForMarketFace messageForMarketFace = (MessageForMarketFace) d(-2007);
        messageForMarketFace.msgtype = -2007;
        messageForMarketFace.mMarkFaceMessage = markFaceMessage;
        messageForMarketFace.mIsParsed = true;
        I(qQAppInterface, messageForMarketFace, str, str2, i3);
        try {
            messageForMarketFace.msgData = MessagePkgUtils.getBytesFromObject(markFaceMessage);
        } catch (Exception e16) {
            QLog.e(MessageForMarketFace.TAG, 1, "createSendMsg_MarketFace: ", e16);
        }
        return messageForMarketFace;
    }

    public static MessageForQQStory y(QQAppInterface qQAppInterface, String str, String str2, String str3, int i3, long j3, AbsStructMsg absStructMsg) {
        MessageForQQStory messageForQQStory = (MessageForQQStory) d(MessageRecord.MSG_TYPE_QQSTORY);
        messageForQQStory.msgtype = MessageRecord.MSG_TYPE_QQSTORY;
        messageForQQStory.structingMsg = absStructMsg;
        messageForQQStory.mIsParsed = false;
        I(qQAppInterface, messageForQQStory, str2, str3, i3);
        try {
            messageForQQStory.msgData = absStructMsg.getBytes();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("structMsg", 2, e16.getMessage(), e16);
            }
        }
        if (absStructMsg.sourceAccoutType != 0) {
            messageForQQStory.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
        }
        return messageForQQStory;
    }

    public static MessageForReplyText z(QQAppInterface qQAppInterface, String str, int i3, MessageForReplyText.SourceMsgInfo sourceMsgInfo, String str2) {
        if (sourceMsgInfo == null) {
            return null;
        }
        MessageForReplyText messageForReplyText = (MessageForReplyText) d(MessageRecord.MSG_TYPE_REPLY_TEXT);
        messageForReplyText.selfuin = qQAppInterface.getCurrentAccountUin();
        messageForReplyText.frienduin = str;
        messageForReplyText.senderuin = qQAppInterface.getCurrentAccountUin();
        messageForReplyText.f203106msg = str2;
        messageForReplyText.msgtype = MessageRecord.MSG_TYPE_REPLY_TEXT;
        messageForReplyText.isread = true;
        messageForReplyText.issend = 1;
        messageForReplyText.istroop = i3;
        messageForReplyText.msgUid = s.f(s.a());
        List<ChatMessage> l16 = qQAppInterface.getMessageFacade().l1(messageForReplyText.senderuin, i3);
        if (l16 != null && !l16.isEmpty()) {
            messageForReplyText.shmsgseq = l16.get(l16.size() - 1).shmsgseq;
        } else {
            messageForReplyText.shmsgseq = Math.abs(new Random().nextInt());
        }
        messageForReplyText.time = e.K0();
        MessageForReplyText.SourceMsgInfo sourceMsgInfo2 = new MessageForReplyText.SourceMsgInfo(sourceMsgInfo);
        messageForReplyText.mSourceMsgInfo = sourceMsgInfo2;
        messageForReplyText.charStr = str2;
        try {
            messageForReplyText.saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.bytes2HexStr(MessagePkgUtils.getBytesFromObject(sourceMsgInfo2)));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("MessageRecordFactory", 2, QLog.getStackTraceString(e16));
            }
        }
        if (messageForReplyText.isSend()) {
            ((ISVIPHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).addSendingBubbleId(messageForReplyText);
        }
        return messageForReplyText;
    }
}
