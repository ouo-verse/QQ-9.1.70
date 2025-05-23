package com.tencent.mobileqq.guild.message.api.impl;

import android.content.ContentValues;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import bu1.a;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.api.IGuildSubscribeChannelGrayCreateApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.jump.model.extras.GuildManageNoticePushMsg;
import com.tencent.mobileqq.guild.message.GuildMsgNotifySettingGray;
import com.tencent.mobileqq.guild.message.GuildRobotDirectMsgLimitGray;
import com.tencent.mobileqq.guild.message.GuildSubscribeChannelGray;
import com.tencent.mobileqq.guild.message.MessageRecordForAppChannel;
import com.tencent.mobileqq.guild.message.MessageRecordForBlackRobotGray;
import com.tencent.mobileqq.guild.message.MessageRecordForDirectMessageWelcome;
import com.tencent.mobileqq.guild.message.MessageRecordForGuildWelcome;
import com.tencent.mobileqq.guild.message.MessageRecordForLiveGift;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildNicknameApi;
import com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi;
import com.tencent.mobileqq.guild.message.msgsend.SubQrCodePicInterceptProcessor;
import com.tencent.mobileqq.guild.message.msgtype.MessageForGuildRevokeGrayTip;
import com.tencent.mobileqq.guild.message.msgtype.MessageRecordForMarkdown;
import com.tencent.mobileqq.guild.message.p;
import com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotConfigApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.api.IMessageRecordFactoryService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm$Msg;
import org.json.JSONArray;
import org.json.JSONException;
import st1.l;
import tencent.im.group_pro_proto.common.common$Msg;
import tencent.im.group_pro_proto.msgpush.servtype$EventBody;
import xt1.k;
import xt1.m;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMessageUtilsApiImpl implements IGuildMessageUtilsApi {
    private static final String TAG = "GuildMessageUtilsApiImpl";
    private static final Object createWelcomeMsgLock = new Object();
    private static com.tencent.mobileqq.guild.message.base.e msgUtilsCB;

    static {
        try {
            ArrayList<Class<? extends com.tencent.mobileqq.guild.message.base.d>> arrayList = vt1.a.f443340b;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<Class<? extends com.tencent.mobileqq.guild.message.base.e>> it = vt1.a.f443341c.iterator();
                while (it.hasNext()) {
                    msgUtilsCB = it.next().newInstance();
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[static] ", e16);
        }
    }

    private void addSubscribeGrayTip(AppInterface appInterface, String str, String str2) {
        ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).addMessageForSubscribeChannelGray((BaseQQAppInterface) appInterface, str, str2);
        ((IGuildSubscribeChannelGrayCreateApi) QRoute.api(IGuildSubscribeChannelGrayCreateApi.class)).setChannelSubscribeGrayShowTime(str);
    }

    private ChatMessage createWelcomeMsg(AppRuntime appRuntime, IGProChannelInfo iGProChannelInfo) {
        String str;
        int i3;
        String str2;
        if (iGProChannelInfo == null) {
            return null;
        }
        String str3 = "";
        IGProGuildInfo guildInfo = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getGuildInfo(iGProChannelInfo.getGuildId());
        IGProChannelInfo Q = ch.Q(iGProChannelInfo.getGuildId(), appRuntime);
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        String guildId = iGProChannelInfo.getGuildId();
        String selfTinyId = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        if (guildInfo == null) {
            str = "";
        } else {
            str = guildInfo.getCreatorId();
        }
        String creatorId = iGProChannelInfo.getCreatorId();
        if (Q != null) {
            str3 = Q.getChannelUin();
        }
        MessageRecordForGuildWelcome messageRecordForGuildWelcome = new MessageRecordForGuildWelcome();
        if (TextUtils.equals(str3, iGProChannelInfo.getChannelUin())) {
            if (TextUtils.equals(str, selfTinyId)) {
                i3 = 1;
            } else {
                i3 = 3;
            }
        } else if (TextUtils.equals(creatorId, selfTinyId)) {
            i3 = 2;
        } else {
            i3 = 4;
        }
        messageRecordForGuildWelcome.init(i3, iGProChannelInfo.getType(), iGProChannelInfo.getTextChannelSubtypeId(), iGProChannelInfo.getChannelUin(), guildId);
        messageRecordForGuildWelcome.shmsgseq = 0L;
        messageRecordForGuildWelcome.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_LOCAL_ONLY, "1");
        ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).saveGuildIdToMR(messageRecordForGuildWelcome, guildId);
        long K0 = com.tencent.mobileqq.service.message.e.K0();
        String channelUin = iGProChannelInfo.getChannelUin();
        if (TextUtils.isEmpty(selfTinyId)) {
            str2 = currentAccountUin;
        } else {
            str2 = selfTinyId;
        }
        messageRecordForGuildWelcome.init(currentAccountUin, channelUin, str2, "", K0, MessageRecord.MSG_TYPE_GUILD_WELCOME_TIPS, 10014, 0L);
        return messageRecordForGuildWelcome;
    }

    private boolean isLocalGuildMsg(MessageRecord messageRecord) {
        for (int i3 : p.f230724b) {
            if (i3 == messageRecord.msgtype) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addDirectMsgLimitGray$3(BaseQQAppInterface baseQQAppInterface, String str, String str2, String str3, String str4, String str5) {
        BaseQQMessageFacade messageFacade = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade(baseQQAppInterface);
        synchronized (createWelcomeMsgLock) {
            deleteGrayTipsByType(baseQQAppInterface, str, MessageRecord.MSG_TYPE_GUILD_ROBOT_DIRECT_MSG_LIMIT_TIPS);
            for (MessageRecord messageRecord : messageFacade.D(str, 10014, null)) {
                if (needShowMsgSettingGray(messageRecord)) {
                    messageFacade.d(makeRobotDirectMsgLimitGrayTip(baseQQAppInterface, str2, str3, str4, str, str5, messageRecord.time, messageRecord.shmsgseq), baseQQAppInterface.getAccount(), true, true, false, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addMessageForBlackRobotGray$2(BaseQQAppInterface baseQQAppInterface, String str, int i3, String str2, String str3, String str4) {
        BaseQQMessageFacade messageFacade = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade(baseQQAppInterface);
        synchronized (createWelcomeMsgLock) {
            deleteGrayTipsByType(baseQQAppInterface, str, MessageRecord.MSG_TYPE_GUILD_ROBOT_BLACK_GRAY);
            List<MessageRecord> D = messageFacade.D(str, 10014, null);
            int size = D.size();
            if (size < i3) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "msgSize = " + size + "  limit = " + i3);
                }
                return;
            }
            ArrayList arrayList = new ArrayList(i3);
            for (int size2 = D.size() - 1; size2 >= 0; size2--) {
                MessageRecord messageRecord = D.get(size2);
                int i16 = messageRecord.msgtype;
                if (i16 != -2006 && i16 != -4009) {
                    arrayList.add(messageRecord);
                }
                if (arrayList.size() >= i3) {
                    break;
                }
            }
            if (arrayList.size() < i3) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "\u8fc7\u6ee4\u540e\u7684\u6d88\u606f\u7684\u6570\u91cf\u4e0d\u8db3 msgSize = " + arrayList.size() + "  limit = " + i3);
                }
                return;
            }
            for (int size3 = arrayList.size() - 1; size3 >= arrayList.size() - i3; size3--) {
                MessageRecord messageRecord2 = (MessageRecord) arrayList.get(size3);
                if (!TextUtils.equals(messageRecord2.getExtInfoFromExtStr(IGuildMessageUtilsApi.MSG_FROM_APPID), ((IGuildRobotConfigApi) QRoute.api(IGuildRobotConfigApi.class)).getMsgFromRobotFlag())) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "msg is not robot msg chatMessage = " + messageRecord2);
                    }
                    return;
                }
                if (!TextUtils.equals(messageRecord2.getExtInfoFromExtStr(IGuildMessageUtilsApi.ROBOT_MSG_TYPE), ((IGuildRobotConfigApi) QRoute.api(IGuildRobotConfigApi.class)).getRobotActiveMsgFlag())) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "msg is not active robot msg chatMessage = " + messageRecord2);
                    }
                    return;
                }
                if (TextUtils.equals(messageRecord2.getExtInfoFromExtStr(IGuildMessageUtilsApi.ROBOT_IS_SHOW_MSG_SETTING), "true")) {
                    QLog.i(TAG, 2, "need show msg limit setting");
                    return;
                }
            }
            messageFacade.d(makeBlackRobotGrayTip(baseQQAppInterface, str2, str3, str4, NetConnInfoCenter.getServerTime(), D.get(D.size() - 1).shmsgseq), baseQQAppInterface.getAccount(), true, true, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addMessageForGuildRobotWelcome$1(BaseQQAppInterface baseQQAppInterface, String str, String str2, String str3, ArrayList arrayList, int i3) {
        boolean z16;
        BaseQQMessageFacade messageFacade = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade(baseQQAppInterface);
        synchronized (createWelcomeMsgLock) {
            Iterator<MessageRecord> it = messageFacade.F(10014).y(10014).c0(str, 10014, 0L, 0L).iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next() instanceof st1.i) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "direct message welcome is exist");
                        }
                        z16 = true;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "need to insert welcome message");
                }
                messageFacade.d(makeDirectMessageWelcome(baseQQAppInterface, str2, str, str3, arrayList, i3), baseQQAppInterface.getAccount(), true, true, false, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addMessageForGuildWelcome$0(BaseQQAppInterface baseQQAppInterface, String str) {
        boolean z16;
        ChatMessage createWelcomeMsg;
        BaseQQMessageFacade messageFacade = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade(baseQQAppInterface);
        synchronized (createWelcomeMsgLock) {
            Iterator<MessageRecord> it = messageFacade.F(10014).y(10014).c0(str, 10014, 0L, 0L).iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next() instanceof st1.j) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16 && (createWelcomeMsg = createWelcomeMsg(baseQQAppInterface, ((IGPSService) baseQQAppInterface.getRuntimeService(IGPSService.class)).getChannelInfo(str))) != null) {
                messageFacade.d(createWelcomeMsg, baseQQAppInterface.getAccount(), true, true, false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addMessageForMsgNotifySettingGrayTips$5(BaseQQAppInterface baseQQAppInterface, String str, String str2) {
        BaseQQMessageFacade messageFacade = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade(baseQQAppInterface);
        List<MessageRecord> D = messageFacade.D(str, 10014, null);
        if (D.size() < 1) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "msgSize = " + D.size());
                return;
            }
            return;
        }
        messageFacade.d(makeMsgNotifySettingGrayTip(baseQQAppInterface, str2, str, NetConnInfoCenter.getServerTime(), D.get(D.size() - 1).shmsgseq), baseQQAppInterface.getAccount(), true, true, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addMessageForSubscribeChannelGray$4(BaseQQAppInterface baseQQAppInterface, String str, String str2) {
        BaseQQMessageFacade messageFacade = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade(baseQQAppInterface);
        List<MessageRecord> D = messageFacade.D(str, 10014, null);
        if (D.size() < 1) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "msgSize = " + D.size());
                return;
            }
            return;
        }
        messageFacade.d(makeSubscribeChannelGrayTip(baseQQAppInterface, str2, str, NetConnInfoCenter.getServerTime(), D.get(D.size() - 1).shmsgseq), baseQQAppInterface.getAccount(), true, true, false, true);
    }

    private MessageRecordForBlackRobotGray makeBlackRobotGrayTip(AppRuntime appRuntime, String str, String str2, String str3, long j3, long j16) {
        String str4;
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        String selfTinyId = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        MessageRecordForBlackRobotGray messageRecordForBlackRobotGray = new MessageRecordForBlackRobotGray();
        messageRecordForBlackRobotGray.initBlackRobotGray(selfTinyId, str3, str2, str);
        messageRecordForBlackRobotGray.shmsgseq = j16;
        ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).saveGuildIdToMR(messageRecordForBlackRobotGray, str);
        messageRecordForBlackRobotGray.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_LOCAL_ONLY, "1");
        String qqStr = HardCodeUtil.qqStr(R.string.f140790ex);
        if (TextUtils.isEmpty(selfTinyId)) {
            str4 = currentAccountUin;
        } else {
            str4 = selfTinyId;
        }
        messageRecordForBlackRobotGray.init(currentAccountUin, str2, str4, qqStr, j3, MessageRecord.MSG_TYPE_GUILD_ROBOT_BLACK_GRAY, 10014, j16);
        return messageRecordForBlackRobotGray;
    }

    private MessageRecordForDirectMessageWelcome makeDirectMessageWelcome(AppRuntime appRuntime, String str, String str2, String str3, ArrayList<String> arrayList, int i3) {
        String str4;
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        String selfTinyId = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        MessageRecordForDirectMessageWelcome messageRecordForDirectMessageWelcome = new MessageRecordForDirectMessageWelcome();
        messageRecordForDirectMessageWelcome.initWelcome(selfTinyId, str3, str2, str, arrayList, i3);
        messageRecordForDirectMessageWelcome.shmsgseq = 0L;
        ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).saveGuildIdToMR(messageRecordForDirectMessageWelcome, str);
        messageRecordForDirectMessageWelcome.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_LOCAL_ONLY, "1");
        long K0 = com.tencent.mobileqq.service.message.e.K0() - 60;
        String format = String.format(appRuntime.getApplicationContext().getString(R.string.f153651co), ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getGuildUserDisplayName(str, str3));
        if (TextUtils.isEmpty(selfTinyId)) {
            str4 = currentAccountUin;
        } else {
            str4 = selfTinyId;
        }
        messageRecordForDirectMessageWelcome.init(currentAccountUin, str2, str4, format, K0, MessageRecord.MSG_TYPE_GUILD_ROBOT_WELCOME_TIPS, 10014, 0L);
        return messageRecordForDirectMessageWelcome;
    }

    private GuildMsgNotifySettingGray makeMsgNotifySettingGrayTip(BaseQQAppInterface baseQQAppInterface, String str, String str2, long j3, long j16) {
        String str3;
        String currentAccountUin = baseQQAppInterface.getCurrentAccountUin();
        String selfTinyId = ((IGPSService) baseQQAppInterface.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        GuildMsgNotifySettingGray guildMsgNotifySettingGray = new GuildMsgNotifySettingGray();
        guildMsgNotifySettingGray.init(selfTinyId, str2, str);
        guildMsgNotifySettingGray.shmsgseq = j16;
        ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).saveGuildIdToMR(guildMsgNotifySettingGray, str);
        guildMsgNotifySettingGray.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_LOCAL_ONLY, "1");
        String str4 = HardCodeUtil.qqStr(R.string.f15048154) + HardCodeUtil.qqStr(R.string.f15049155);
        if (TextUtils.isEmpty(selfTinyId)) {
            str3 = currentAccountUin;
        } else {
            str3 = selfTinyId;
        }
        guildMsgNotifySettingGray.init(currentAccountUin, str2, str3, str4, j3, MessageRecord.MSG_TYPE_GUILD_MSG_NOTIFY_SETTING_TIPS, 10014, j16);
        return guildMsgNotifySettingGray;
    }

    private GuildRobotDirectMsgLimitGray makeRobotDirectMsgLimitGrayTip(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5, long j3, long j16) {
        String str6;
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        String selfTinyId = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        GuildRobotDirectMsgLimitGray guildRobotDirectMsgLimitGray = new GuildRobotDirectMsgLimitGray();
        guildRobotDirectMsgLimitGray.init(str, str3, str4, str5);
        guildRobotDirectMsgLimitGray.shmsgseq = j16;
        ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).saveGuildIdToMR(guildRobotDirectMsgLimitGray, str);
        guildRobotDirectMsgLimitGray.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_LOCAL_ONLY, "1");
        String qqStr = HardCodeUtil.qqStr(R.string.f153751cy);
        if (TextUtils.isEmpty(selfTinyId)) {
            str6 = currentAccountUin;
        } else {
            str6 = selfTinyId;
        }
        guildRobotDirectMsgLimitGray.init(currentAccountUin, str2, str6, qqStr, j3, MessageRecord.MSG_TYPE_GUILD_ROBOT_DIRECT_MSG_LIMIT_TIPS, 10014, j16);
        return guildRobotDirectMsgLimitGray;
    }

    private GuildSubscribeChannelGray makeSubscribeChannelGrayTip(BaseQQAppInterface baseQQAppInterface, String str, String str2, long j3, long j16) {
        String str3;
        String currentAccountUin = baseQQAppInterface.getCurrentAccountUin();
        String selfTinyId = ((IGPSService) baseQQAppInterface.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        GuildSubscribeChannelGray guildSubscribeChannelGray = new GuildSubscribeChannelGray();
        guildSubscribeChannelGray.initSubscribeChannelGray(selfTinyId, str2, str);
        guildSubscribeChannelGray.shmsgseq = j16;
        ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).saveGuildIdToMR(guildSubscribeChannelGray, str);
        guildSubscribeChannelGray.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_LOCAL_ONLY, "1");
        String str4 = HardCodeUtil.qqStr(R.string.f17895382) + HardCodeUtil.qqStr(R.string.f17894381);
        if (TextUtils.isEmpty(selfTinyId)) {
            str3 = currentAccountUin;
        } else {
            str3 = selfTinyId;
        }
        guildSubscribeChannelGray.init(currentAccountUin, str2, str3, str4, j3, MessageRecord.MSG_TYPE_GUILD_SUBSCRIBE_CHANNEL_TIPS, 10014, j16);
        return guildSubscribeChannelGray;
    }

    private boolean needShowMsgSettingGray(MessageRecord messageRecord) {
        int i3 = messageRecord.msgtype;
        if (i3 == -2006 || i3 == -4009) {
            return false;
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(IGuildMessageUtilsApi.MSG_FROM_APPID);
        String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr(IGuildMessageUtilsApi.ROBOT_MSG_TYPE);
        String extInfoFromExtStr3 = messageRecord.getExtInfoFromExtStr(IGuildMessageUtilsApi.ROBOT_IS_SHOW_MSG_SETTING);
        if (!TextUtils.equals(extInfoFromExtStr, "3161") || !TextUtils.equals(extInfoFromExtStr2, "1") || !TextUtils.equals(extInfoFromExtStr3, "true")) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void addDirectMsgLimitGray(final BaseQQAppInterface baseQQAppInterface, final String str, final String str2, final String str3, final String str4, final String str5) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.h
            @Override // java.lang.Runnable
            public final void run() {
                GuildMessageUtilsApiImpl.this.lambda$addDirectMsgLimitGray$3(baseQQAppInterface, str4, str, str2, str3, str5);
            }
        }, 32, null, true);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void addMessageForBlackRobotGray(final BaseQQAppInterface baseQQAppInterface, final String str, final String str2, final String str3, final String str4, final int i3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                GuildMessageUtilsApiImpl.this.lambda$addMessageForBlackRobotGray$2(baseQQAppInterface, str3, i3, str, str2, str4);
            }
        }, 32, null, true);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void addMessageForGuildRobotWelcome(final BaseQQAppInterface baseQQAppInterface, final String str, final String str2, final String str3, final ArrayList<String> arrayList, final int i3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildMessageUtilsApiImpl.this.lambda$addMessageForGuildRobotWelcome$1(baseQQAppInterface, str2, str, str3, arrayList, i3);
            }
        }, 32, null, true);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void addMessageForGuildWelcome(final BaseQQAppInterface baseQQAppInterface, final String str) {
        if (baseQQAppInterface != null && !TextUtils.isEmpty(str)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.f
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMessageUtilsApiImpl.this.lambda$addMessageForGuildWelcome$0(baseQQAppInterface, str);
                }
            }, 32, null, true);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void addMessageForMsgNotifySettingGrayTips(final BaseQQAppInterface baseQQAppInterface, final String str, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.g
            @Override // java.lang.Runnable
            public final void run() {
                GuildMessageUtilsApiImpl.this.lambda$addMessageForMsgNotifySettingGrayTips$5(baseQQAppInterface, str2, str);
            }
        }, 32, null, true);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void addMessageForSubscribeChannelGray(final BaseQQAppInterface baseQQAppInterface, final String str, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildMessageUtilsApiImpl.this.lambda$addMessageForSubscribeChannelGray$4(baseQQAppInterface, str2, str);
            }
        }, 32, null, true);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public MessageRecord createEmptyMR() {
        MessageRecord createMsgRecordByMsgType = ((IMessageRecordFactoryService) QRoute.api(IMessageRecordFactoryService.class)).createMsgRecordByMsgType(-1000);
        createMsgRecordByMsgType.msgtype = -2006;
        createMsgRecordByMsgType.f203106msg = "";
        createMsgRecordByMsgType.msg2 = "";
        createMsgRecordByMsgType.msgData = "".getBytes();
        return createMsgRecordByMsgType;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public MessageRecord createMessageRecordForAppChannel(String str, String str2, long j3, int i3, String str3, boolean z16) {
        return su1.a.b(str, str2, j3, i3, str3, z16);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public MessageRecord createMessageRecordForLiveGift(String str, String str2, String str3, long j3, long j16) {
        MessageRecordForLiveGift messageRecordForLiveGift = new MessageRecordForLiveGift();
        messageRecordForLiveGift.setSenderTinyId(str);
        messageRecordForLiveGift.setGiftName(str3);
        messageRecordForLiveGift.setReceiverUid(str2);
        messageRecordForLiveGift.setGiftId(j3);
        messageRecordForLiveGift.setGiftComboCount(j16);
        messageRecordForLiveGift.saveData();
        return messageRecordForLiveGift;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public boolean decodeAppChannelMsg(servtype$EventBody servtype_eventbody, List<MessageRecord> list, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.service.message.a aVar) {
        return su1.a.d(servtype_eventbody, list, msg_comm_msg, aVar);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void deleteGrayTipsByType(BaseQQAppInterface baseQQAppInterface, String str, int i3) {
        List<MessageRecord> D = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade(baseQQAppInterface).D(str, 10014, new int[]{i3});
        if (D.size() != 0) {
            ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageProxy(baseQQAppInterface, 10014).v(D, true);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "delete guild gray tips with %s" + D);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void deleteGuildFileManagerEntity(AppRuntime appRuntime, MessageRecord messageRecord) {
        FileManagerEntity queryFileEntityByUniseq;
        if (appRuntime != null && (messageRecord instanceof MessageForFile) && !TextUtils.isEmpty(messageRecord.frienduin) && (queryFileEntityByUniseq = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).queryFileEntityByUniseq((BaseQQAppInterface) appRuntime, messageRecord.uniseq, messageRecord.frienduin, 10014)) != null) {
            ((IQQFileDataCenter) appRuntime.getRuntimeService(IQQFileDataCenter.class, "")).setAioDelete(queryFileEntityByUniseq);
            ((IQQFileEngine) appRuntime.getRuntimeService(IQQFileEngine.class, "")).delete(queryFileEntityByUniseq.nSessionId);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public String getAdminRevokeWord(AppRuntime appRuntime, MessageForGuildRevokeGrayTip messageForGuildRevokeGrayTip, String str) {
        boolean z16;
        IGuildNicknameApi iGuildNicknameApi = (IGuildNicknameApi) QRoute.api(IGuildNicknameApi.class);
        String displayName = iGuildNicknameApi.getDisplayName(appRuntime, str, messageForGuildRevokeGrayTip.getRevokeSenderUin(), null);
        String selfTinyId = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        if (!TextUtils.isEmpty(selfTinyId) && selfTinyId.equals(messageForGuildRevokeGrayTip.getOperatorTid())) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = 8;
        if (z16) {
            if (!FontSettingManager.isFontSizeLarge()) {
                i3 = 15;
            }
            if (displayName.length() > i3) {
                displayName = iGuildNicknameApi.removeIncompleteEmoji(displayName, i3 - 1) + "\u2026";
            }
            return String.format(HardCodeUtil.qqStr(R.string.f153241bk), displayName);
        }
        if (FontSettingManager.isFontSizeLarge()) {
            i3 = 4;
        }
        String displayName2 = iGuildNicknameApi.getDisplayName(appRuntime, str, messageForGuildRevokeGrayTip.getOperatorTid(), null);
        if (displayName.length() > i3) {
            displayName = iGuildNicknameApi.removeIncompleteEmoji(displayName, i3 - 1) + "\u2026";
        }
        if (displayName2.length() > i3) {
            displayName2 = iGuildNicknameApi.removeIncompleteEmoji(displayName2, i3 - 1) + "\u2026";
        }
        return displayName2 + " " + String.format(HardCodeUtil.qqStr(R.string.f153261bm), displayName);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public Class<? extends com.tencent.imcore.message.core.codec.a> getAppChannelInnerKeyboardDecoder() {
        return xt1.i.class;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public Class<? extends com.tencent.imcore.message.core.codec.a> getAppChannelMarkdownDecoder() {
        return m.class;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public Class<? extends com.tencent.imcore.message.core.codec.a> getAppChannelNormalMsgDecoder() {
        return xt1.c.class;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public long getCntSeqFromMR(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return 0L;
        }
        try {
            return Long.parseLong(messageRecord.getExtInfoFromExtStr(IGuildMessageUtilsApi.MSG_CNT_NAME));
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public bu1.a getEventFlow(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return null;
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(IGuildMessageUtilsApi.MSG_EVENT_INFO);
        if (TextUtils.isEmpty(extInfoFromExtStr)) {
            return null;
        }
        return bu1.a.c(extInfoFromExtStr);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public long getGuildIdFromMR(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return 0L;
        }
        try {
            return Long.parseLong(su1.c.b(messageRecord));
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public GuildManageNoticePushMsg getGuildManageNoticePushMsgFromMr(MessageRecord messageRecord) {
        Object obj = messageRecord.extObj;
        if (obj instanceof Bundle) {
            return (GuildManageNoticePushMsg) ((Bundle) obj).getParcelable("GUILD_MANAGE_NOTICE_PUSH");
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public st1.d getGuildMessageCache(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return null;
        }
        return ((IGuildMsgFactory) appRuntime.getRuntimeService(IGuildMsgFactory.class, "")).getMsgCache();
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public st1.m getHongbaoInterceptProcessor(l lVar, com.tencent.aio.api.runtime.a aVar) {
        return new com.tencent.mobileqq.guild.message.msgsend.a(lVar, aVar);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public long getLiveGiftMessageGiftComboCount(ChatMessage chatMessage) {
        if (chatMessage instanceof MessageRecordForLiveGift) {
            return ((MessageRecordForLiveGift) chatMessage).getGiftComboCount();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public long getLiveGiftMessageGiftId(ChatMessage chatMessage) {
        if (chatMessage instanceof MessageRecordForLiveGift) {
            return ((MessageRecordForLiveGift) chatMessage).getGiftId();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public String getLiveGiftMessageGiftName(ChatMessage chatMessage) {
        if (chatMessage instanceof MessageRecordForLiveGift) {
            return ((MessageRecordForLiveGift) chatMessage).getGiftName();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public String getLiveGiftMessageReceiverUid(ChatMessage chatMessage) {
        if (chatMessage instanceof MessageRecordForLiveGift) {
            return ((MessageRecordForLiveGift) chatMessage).getReceiverUid();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public String getLocalOnlyFromMR(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return "";
        }
        return messageRecord.getExtInfoFromExtStr(IGuildMessageUtilsApi.MSG_LOCAL_ONLY);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public Class<? extends com.tencent.imcore.message.core.codec.a> getMessageForLiveGiftDecoder() {
        return k.class;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public Class<? extends MessageRecord> getMessageMarkdownClazz() {
        return MessageRecordForMarkdown.class;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public MessageRecord getMessageRecordForAppChannel() {
        return new MessageRecordForAppChannel();
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public Class<? extends MessageRecord> getMessageRecordForBlackRobotGrayTipClazz() {
        return MessageRecordForBlackRobotGray.class;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public Class<? extends MessageRecord> getMessageRecordForDirectMessageWelcomeClazz() {
        return MessageRecordForDirectMessageWelcome.class;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public Class<? extends MessageRecord> getMessageRecordForGuildWelcomeClazz() {
        return MessageRecordForGuildWelcome.class;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public MessageRecord getMessageRecordForLiveGift() {
        return new MessageRecordForLiveGift();
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public Class<? extends MessageRecord> getMessageRecordForLiveGiftClazz() {
        return MessageRecordForLiveGift.class;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public Class<? extends MessageRecord> getMessageRecordForMsgNotifySettingGrayTipsClazz() {
        return GuildMsgNotifySettingGray.class;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public Class<? extends MessageRecord> getMessageRecordForRobotDirectMsgLimitTipClazz() {
        return GuildRobotDirectMsgLimitGray.class;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public Class<? extends MessageRecord> getMessageRecordForSubscribeChannelGrayTipClazz() {
        return GuildSubscribeChannelGray.class;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public Class<? extends com.tencent.imcore.message.core.codec.a> getMsgEventDecoder() {
        return com.tencent.mobileqq.guild.message.pbdecoder.a.class;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public String getMsgGuildMemberNameFromMR(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return "";
        }
        return messageRecord.getExtInfoFromExtStr(IGuildMessageUtilsApi.MSG_GUILD_MEMBER_NAME);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public byte[] getMsgMetaFromMr(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return new byte[0];
        }
        return Base64.decode(messageRecord.getExtInfoFromExtStr(IGuildMessageUtilsApi.MSG_META_STR), 0);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public int getMsgRandomByMsgUid_Hummer(long j3) {
        return (int) (j3 & (-1));
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public String getMsgTypeFromMR(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return "";
        }
        return messageRecord.getExtInfoFromExtStr(IGuildMessageUtilsApi.MSG_TYPE);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public MessageRecord getNewMessageRecordForBlackRobotGrayTip() {
        return new MessageRecordForBlackRobotGray();
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public MessageRecord getNewMessageRecordForDirectMessageWelcome() {
        return new MessageRecordForDirectMessageWelcome();
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public MessageRecord getNewMessageRecordForGuildWelcome() {
        return new MessageRecordForGuildWelcome();
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public MessageRecord getNewMessageRecordForMarkdown() {
        return new MessageRecordForMarkdown();
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public MessageRecord getNewMessageRecordForMsgNotifySettingGrayTips() {
        return new GuildMsgNotifySettingGray();
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public MessageRecord getNewMessageRecordForRobotDirectMsgLimitGrayTip() {
        return new GuildRobotDirectMsgLimitGray();
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public MessageRecord getNewMessageRecordForSubscribeChannelGrayTip() {
        return new GuildSubscribeChannelGray();
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public String getNickNameFromMR(MessageRecord messageRecord) {
        if (messageRecord != null && !TextUtils.isEmpty(messageRecord.extStr) && messageRecord.extStr.contains(IGuildMessageUtilsApi.MSG_FROM_NICK)) {
            return messageRecord.getExtInfoFromExtStr(IGuildMessageUtilsApi.MSG_FROM_NICK);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public int getRevokeMsgType(MessageRecord messageRecord) {
        bu1.a eventFlow;
        ArrayList<a.b> arrayList;
        a.b d16;
        if (messageRecord != null && messageRecord.msgtype == -2006 && (eventFlow = ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getEventFlow(messageRecord)) != null && (arrayList = eventFlow.f29142a) != null && arrayList.size() != 0 && (d16 = eventFlow.d()) != null) {
            long j3 = d16.f29146a;
            if (j3 == 1) {
                return 2;
            }
            if (j3 == 2) {
                return 1;
            }
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public String getRoleInfoFromMR(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return "";
        }
        return messageRecord.getExtInfoFromExtStr(IGuildMessageUtilsApi.MSG_FROM_ROLE_INFO);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public st1.m getSubKeywordInterceptProcessor(l lVar, com.tencent.aio.api.runtime.a aVar) {
        return new com.tencent.mobileqq.guild.message.msgsend.e(lVar, aVar);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public st1.m getSubQrCodePicInterceptProcessor(l lVar, com.tencent.aio.api.runtime.a aVar, Boolean bool) {
        return new SubQrCodePicInterceptProcessor(lVar, aVar, bool.booleanValue());
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public st1.m getSubTextAtInterceptProcessor(l lVar, com.tencent.aio.api.runtime.a aVar) {
        return new com.tencent.mobileqq.guild.message.msgsend.d(lVar, aVar);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public st1.m getSubTextLinkInterceptProcessor(l lVar, com.tencent.aio.api.runtime.a aVar) {
        return new com.tencent.mobileqq.guild.message.msgsend.h(lVar, aVar);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void handleNeedAddSubscribeGrayTip(AppInterface appInterface, String str, String str2) {
        if (needAddSubscribeGrayAfterSpeaking(appInterface, str, str2)) {
            addSubscribeGrayTip(appInterface, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void handleSelfSendMsg(AppInterface appInterface, MessageRecord messageRecord, MessageRecord messageRecord2, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleSelfSendMsg : findMr: " + messageRecord2.toString() + ", extstr: " + messageRecord2.extStr + ", newMr: " + messageRecord.toString() + ", extstr: " + messageRecord.extStr + ", fromeType: " + i3);
        }
        messageRecord2.extStr = messageRecord.extStr;
        messageRecord2.mExJsonObject = messageRecord.mExJsonObject;
        messageRecord2.extLong = messageRecord.extLong;
        messageRecord2.senderuin = messageRecord.senderuin;
        com.tencent.imcore.message.f y16 = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) appInterface).F(10014).y(10014);
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppConstants.Key.COLUMN_EXT_STR, messageRecord2.extStr);
        contentValues.put(AppConstants.Key.COLUMN_EXT_LONG, Integer.valueOf(messageRecord2.extLong));
        contentValues.put("senderuin", messageRecord2.senderuin);
        y16.F0(messageRecord2.frienduin, 10014, messageRecord2.uniseq, contentValues);
        vt1.b.a().e(y16, messageRecord2, messageRecord);
        updateMsgSeqAndTime(appInterface, messageRecord2.uniseq, messageRecord);
        vt1.b.a().d(messageRecord, messageRecord2);
        if (((com.tencent.mobileqq.service.message.e) appInterface.getMsgCache()).t1(messageRecord2) && i3 != 3) {
            ((st1.h) appInterface.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildSendMsgHandlerName())).q(messageRecord.frienduin, messageRecord2.uniseq, messageRecord2.msgseq);
        }
        ArrayList<MessageRecord> arrayList = new ArrayList<>();
        arrayList.add(messageRecord2);
        ((IGuildMsgSeqTimeService) appInterface.getRuntimeService(IGuildMsgSeqTimeService.class, "")).updateLastSeqAndTime(arrayList);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "after handleSelfSendMsg. findMr: " + messageRecord2.toString() + ", extstr: " + messageRecord2.extStr);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public boolean isAtAllMsg(MessageRecord messageRecord) {
        com.tencent.mobileqq.guild.message.base.e eVar = msgUtilsCB;
        if (eVar != null) {
            return eVar.a(messageRecord);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public boolean isCanNotifyAppChannelMsg(MessageRecord messageRecord) {
        if (messageRecord.msgtype != -4051 || !isSysMsg(messageRecord) || !"1".equals(messageRecord.getExtInfoFromExtStr(MessageRecordForAppChannel.KEY_GUILD_APP_CHANNEL_NOTIFY))) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "AppChannelMsg canNotify");
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public boolean isDirectMsg(com.tencent.mobileqq.activity.aio.p pVar) {
        return su1.b.d(pVar);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public boolean isGuest(String str) {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public boolean isLocalOnlyMsg(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return false;
        }
        if (isLocalGuildMsg(messageRecord)) {
            QLog.i(TAG, 1, "isLocalOnlyMsg. isLocalGuildMsg = true. mr.shmsgseq: " + messageRecord.shmsgseq + ", mrtype: " + messageRecord.msgtype);
            return true;
        }
        return "1".equals(getLocalOnlyFromMR(messageRecord));
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public boolean isMsgVisible(MessageRecord messageRecord) {
        if (messageRecord != null && su1.c.d(messageRecord)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public boolean isNotSuccess(ChatMessage chatMessage) {
        int i3 = chatMessage.extraflag;
        if (i3 != 32768 && i3 != 32772) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public boolean isRevokeMsg(MessageRecord messageRecord) {
        int revokeMsgType = getRevokeMsgType(messageRecord);
        if (revokeMsgType == 2 || revokeMsgType == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public boolean isSysMsg(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return false;
        }
        return getMsgTypeFromMR(messageRecord).equals(String.valueOf(3841));
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public boolean isTopMsgGray(MessageRecord messageRecord) {
        if (messageRecord == null || !(messageRecord instanceof MessageForUniteGrayTip)) {
            return false;
        }
        return TextUtils.equals(IGuildUniteGrayTipUtilApi.GUILD_TOP_MESSAGE, messageRecord.getExtInfoFromExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_BUSI_ID));
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public boolean needAddSubscribeGrayAfterSpeaking(AppInterface appInterface, String str, String str2) {
        IGProChannelInfo channelInfo = ((IGPSService) appInterface.getRuntimeService(IGPSService.class, "")).getChannelInfo(str2);
        if (channelInfo == null) {
            QLog.e(TAG, 1, "get channelInfo is null, return.");
            return false;
        }
        if (channelInfo.getType() == 1 && !((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isSelfGuest(str2, str) && ((IGuildSubscribeChannelGrayCreateApi) QRoute.api(IGuildSubscribeChannelGrayCreateApi.class)).isOverSpeakingThreshold(str, str2) && !((uh2.e) appInterface.getRuntimeService(IGPSService.class, "")).isQQMsgListChannel(str, str2) && !((IGuildSubscribeChannelGrayCreateApi) QRoute.api(IGuildSubscribeChannelGrayCreateApi.class)).isOverAlreadyAddedThreshold(appInterface) && ((IGuildSubscribeChannelGrayCreateApi) QRoute.api(IGuildSubscribeChannelGrayCreateApi.class)).isOverGrayShowCycle(str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public ArrayList<AtTroopMemberInfo> parseAtInfoFromExtStr(String str) {
        com.tencent.mobileqq.guild.message.base.e eVar = msgUtilsCB;
        if (eVar != null) {
            return eVar.b(str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void saveAtInfoList(MessageRecord messageRecord, ArrayList<AtTroopMemberInfo> arrayList) {
        if (messageRecord == null) {
            return;
        }
        if (arrayList.size() > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<AtTroopMemberInfo> it = arrayList.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    jSONArray.put(i3, it.next().toJsonObject());
                    i3++;
                }
                messageRecord.saveExtInfoToExtStr(IGuildMessageUtilsApi.GUILD_AT_INFO_LIST, jSONArray.toString());
                return;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
        messageRecord.removeExtInfoToExtStr(IGuildMessageUtilsApi.GUILD_AT_INFO_LIST);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public boolean saveEventFlowToMsg(MessageRecord messageRecord, bu1.a aVar) {
        if (messageRecord == null) {
            return false;
        }
        bu1.a eventFlow = getEventFlow(messageRecord);
        String str = "";
        if (eventFlow != null) {
            if (eventFlow.i() != null) {
                str = eventFlow.i();
            }
            long j3 = eventFlow.f29143b;
            if (j3 > aVar.f29143b) {
                aVar.f29143b = j3;
            }
            Iterator<a.b> it = eventFlow.f29142a.iterator();
            while (it.hasNext()) {
                a.b next = it.next();
                a.b f16 = aVar.f(next.f29146a);
                if (f16 != null) {
                    long j16 = next.f29147b;
                    if (j16 > f16.f29147b) {
                        f16.f29147b = j16;
                    }
                    long j17 = next.f29148c;
                    if (j17 > f16.f29148c) {
                        f16.f29148c = j17;
                    }
                } else {
                    aVar.f29142a.add(next);
                }
            }
        }
        if (str.equals(aVar.i())) {
            return false;
        }
        messageRecord.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_EVENT_INFO, aVar.i());
        return true;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void saveEventToMsg(MessageRecord messageRecord, a.b bVar) {
        if (messageRecord == null) {
            return;
        }
        bu1.a eventFlow = getEventFlow(messageRecord);
        if (eventFlow != null) {
            a.b f16 = eventFlow.f(bVar.f29146a);
            if (f16 != null) {
                long j3 = f16.f29148c;
                long j16 = bVar.f29148c;
                if (j3 < j16) {
                    f16.f29148c = j16;
                }
            } else {
                eventFlow.f29142a.add(bVar);
            }
            messageRecord.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_EVENT_INFO, eventFlow.i());
            return;
        }
        bu1.a aVar = new bu1.a();
        aVar.f29142a.add(bVar);
        messageRecord.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_EVENT_INFO, aVar.i());
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void saveGuildIdToMR(MessageRecord messageRecord, String str) {
        if (messageRecord != null && !TextUtils.isEmpty(str)) {
            su1.c.f(messageRecord, str);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void saveMsgMetaToMr(MessageRecord messageRecord, byte[] bArr) {
        if (bArr != null && messageRecord != null) {
            messageRecord.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_META_STR, Base64.encodeToString(bArr, 0));
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void saveSyncTimeToMsg(MessageRecord messageRecord, long j3) {
        bu1.a eventFlow;
        if (messageRecord == null || (eventFlow = getEventFlow(messageRecord)) == null) {
            return;
        }
        eventFlow.f29143b = j3;
        saveEventFlowToMsg(messageRecord, eventFlow);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void setMsgReaded(AppInterface appInterface, MessageRecord messageRecord) {
        try {
            IGuildMsgSeqTimeService.a aVar = new IGuildMsgSeqTimeService.a(messageRecord.shmsgseq, getCntSeqFromMR(messageRecord), messageRecord.time, getMsgMetaFromMr(messageRecord));
            ((IGuildMsgReadedService) appInterface.getRuntimeService(IGuildMsgReadedService.class, "")).setMsgReadedAndReport(String.valueOf(getGuildIdFromMR(messageRecord)), messageRecord.frienduin, aVar, su1.c.c(messageRecord));
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void syncGuildMsg(AppInterface appInterface, boolean z16) {
        if (appInterface == null) {
            return;
        }
        ((st1.g) appInterface.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildPushMsgHandlerName())).j();
        ((bu1.c) appInterface.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildMessageEventHandlerName())).p(z16);
        ((st1.h) appInterface.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildSendMsgHandlerName())).C2();
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void updateMsgSendStatus(AppInterface appInterface, String str, long j3, int i3, int i16) {
        if (appInterface != null && !TextUtils.isEmpty(str)) {
            BaseQQMessageFacade messageFacade = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) appInterface);
            ((com.tencent.mobileqq.guild.message.m) messageFacade.F(10014)).f1(messageFacade.F(10014).y(10014).C0(str, 10014, j3, i3, i16), null);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public void updateMsgSeqAndTime(AppInterface appInterface, long j3, MessageRecord messageRecord) {
        BaseQQMessageFacade messageFacade = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) appInterface);
        MessageRecord y06 = messageFacade.F(10014).y(10014).y0(messageRecord.frienduin, 10014, j3, messageRecord.shmsgseq, messageRecord.time);
        if (y06 == null) {
            QLog.i(TAG, 1, "updateMsgSeqAndTime, updatedMr == null");
            return;
        }
        ((com.tencent.mobileqq.guild.message.m) messageFacade.F(10014)).f1(y06, null);
        setMsgReaded(appInterface, y06);
        ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).setChangeAndNotify(y06);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public boolean updateReplyMsgCommentForSourceMsg(MessageRecord messageRecord, MessageRecord messageRecord2, boolean z16, boolean z17) {
        boolean z18 = false;
        if (messageRecord == null || messageRecord2 == null) {
            return false;
        }
        if (z17) {
            if (((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setSourceRevokeForReplyMsg(messageRecord, ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getRevokeMsgType(messageRecord2))) {
                z18 = true;
            }
        }
        if (z16 && ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).updateReferCommonInfo(messageRecord, messageRecord2)) {
            return true;
        }
        return z18;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
    public boolean isSysMsg(common$Msg common_msg) {
        return common_msg.head.content_head.get().msg_type.get() == 3841;
    }
}
