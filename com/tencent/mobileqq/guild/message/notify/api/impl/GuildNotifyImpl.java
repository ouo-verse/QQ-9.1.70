package com.tencent.mobileqq.guild.message.notify.api.impl;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.google.gson.JsonObject;
import com.tencent.aio.data.AIOContact;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.config.QQGuildMCParser;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.extras.GuildManageNoticePushMsg;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.mainframe.manager.GuildOpenRecordManager;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.guild.message.notify.api.IGuildNotify;
import com.tencent.mobileqq.guild.message.notify.api.impl.GuildNotifyImpl;
import com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.ca;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.az;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgAbstractsCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.util.BadgeUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildNotifyImpl implements IGuildNotify {
    private static final String MSG_GUILD_REVOKE_NOTIFY = "GUILD_REVOKE_NOTIFY";
    private static final int MSG_NOTIFY_NOTIFICATION = 1;
    private static final int NOTIFY_DELAY_TIMER = 800;
    private static final String TAG = "GuildNotifyImpl";
    BaseQQAppInterface mApp;
    private HashMap<String, Integer> mChannelHasNotNotifyCount;
    private Message mLastMsg;
    private long mLastNotifyTime;
    private Message mNotifyingMsg;
    private IMessageFacade messageFacade;
    private LruCache<String, Bitmap> cacheDrawable = new LruCache<>(3);
    Handler mHandler = new a(ThreadManagerV2.getSubThreadLooper());
    private WeakHandleMsgRevoke handleMsgRevoke = new WeakHandleMsgRevoke(this);

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull android.os.Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                GuildNotifyImpl.this.notifyNotification();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f230693e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Message f230694f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z16, String str, Message message) {
            super(z16);
            this.f230693e = str;
            this.f230694f = message;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(Option option, String str, Message message) {
            Bitmap resultBitMap = option.getResultBitMap();
            if (resultBitMap != null) {
                GuildNotifyImpl.this.cacheDrawable.put(str, BaseImageUtil.getRoundFaceBitmap(resultBitMap, resultBitMap.getWidth(), resultBitMap.getHeight()));
            }
            GuildNotifyImpl.this.messageFacade.setIncomingMsg(message);
            az.d(false);
            ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).handleReceivedMessage(message.counter, true, true, message, GuildNotifyImpl.this.mApp);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState loadState, final Option option) {
            if (loadState == LoadState.STATE_SUCCESS || loadState == LoadState.STATE_DECODE_FAILED || loadState == LoadState.STATE_DOWNLOAD_FAILED) {
                Handler handler = GuildNotifyImpl.this.mHandler;
                final String str = this.f230693e;
                final Message message = this.f230694f;
                handler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.notify.api.impl.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildNotifyImpl.b.this.e(option, str, message);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f230696e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Message f230697f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(boolean z16, String str, Message message) {
            super(z16);
            this.f230696e = str;
            this.f230697f = message;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(Option option, String str, Message message) {
            Bitmap resultBitMap = option.getResultBitMap();
            if (resultBitMap != null) {
                GuildNotifyImpl.this.cacheDrawable.put(str, BaseImageUtil.getRoundFaceBitmap(resultBitMap, resultBitMap.getWidth(), resultBitMap.getHeight()));
            }
            GuildNotifyImpl.this.messageFacade.setIncomingMsg(message);
            az.d(false);
            ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).handleReceivedMessage(message.counter, true, true, message, GuildNotifyImpl.this.mApp);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState loadState, final Option option) {
            if (loadState == LoadState.STATE_SUCCESS || loadState == LoadState.STATE_DECODE_FAILED || loadState == LoadState.STATE_DOWNLOAD_FAILED) {
                Handler handler = GuildNotifyImpl.this.mHandler;
                final String str = this.f230696e;
                final Message message = this.f230697f;
                handler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.notify.api.impl.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildNotifyImpl.c.this.e(option, str, message);
                    }
                });
            }
        }
    }

    private boolean canNotifyBefore(MsgRecord msgRecord) {
        if (msgRecord.getMsgType() == 5) {
            log("canNotifyBefore grayMsg");
            return false;
        }
        if (MsgExtKt.e(msgRecord, g.b())) {
            log("canNotifyBefore summonMsg");
            return true;
        }
        if (MsgExtKt.q(msgRecord)) {
            log("canNotifyBefore appChannel");
            return true;
        }
        boolean A = MsgExtKt.A(msgRecord);
        if (!A) {
            log("canNotifyBefore is not MsgVisible");
        }
        return A;
    }

    private Message convert2NotifyMessage(Message message, MsgAbstract msgAbstract) {
        Message message2 = new Message();
        MessageRecord.copyMessageRecordBaseField(message2, message);
        message2.f203106msg = getContent(msgAbstract, (MsgRecord) message.extObj).toString();
        message2.extObj = message.extObj;
        message2.nickName = getSenderName(msgAbstract, (MsgRecord) message.extObj);
        return message2;
    }

    private String getAtNotificationPrefix(int i3) {
        if (i3 == 2) {
            return this.mApp.getApplicationContext().getString(R.string.f1515017v);
        }
        if (i3 == 8) {
            return this.mApp.getApplicationContext().getString(R.string.f1515217x);
        }
        if (i3 == 64) {
            return this.mApp.getApplicationContext().getString(R.string.f1515117w);
        }
        if (i3 == 1) {
            return this.mApp.getApplicationContext().getString(R.string.f1514917u);
        }
        return "";
    }

    private static com.tencent.mobileqq.guild.message.notify.a getConfig() {
        return new com.tencent.mobileqq.guild.message.notify.a();
    }

    private CharSequence getContent(MsgAbstract msgAbstract, MsgRecord msgRecord) {
        if (MsgExtKt.V(msgRecord)) {
            return g.a(msgRecord);
        }
        return iu1.b.f408754a.b(msgAbstract, ((IGPSService) this.mApp.getRuntimeService(IGPSService.class, "")).getSelfTinyId());
    }

    private long getMessageDelayTime(MsgRecord msgRecord) {
        if (needDelayMessage(msgRecord)) {
            return getConfig().a();
        }
        return 0L;
    }

    private void getMsgAbstract(MessageRecord messageRecord, IGetMsgAbstractsCallback iGetMsgAbstractsCallback) {
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgAbstract(new Contact(4, messageRecord.frienduin, String.valueOf(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(messageRecord))), messageRecord.uniseq, iGetMsgAbstractsCallback);
    }

    private String getSenderName(MsgAbstract msgAbstract, MsgRecord msgRecord) {
        String str;
        if (!TextUtils.isEmpty(msgAbstract.getSendMemberName())) {
            str = msgAbstract.getSendMemberName();
        } else if (!TextUtils.isEmpty(msgAbstract.getSendNickName())) {
            str = msgAbstract.getSendNickName();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            String guildId = msgAbstract.getPeer().getGuildId();
            String peerUid = msgAbstract.getPeer().getPeerUid();
            boolean z16 = true;
            if (msgRecord.getDirectMsgFlag() != 1) {
                z16 = false;
            }
            if (z16) {
                guildId = String.valueOf(((IGuildDirectMsgUtilApi) QRoute.api(IGuildDirectMsgUtilApi.class)).getSourceGuildId(peerUid));
            }
            if (!TextUtils.isEmpty(msgAbstract.getSenderUid()) && !TextUtils.isEmpty(guildId)) {
                return ((IGPSService) ch.R0(IGPSService.class)).getGuildUserDisplayName(guildId, msgAbstract.getSenderUid());
            }
            return str;
        }
        return str;
    }

    private String getSummonStr(MsgRecord msgRecord) {
        int channelType = ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).getChannelType(MobileQQ.sMobileQQ.peekAppRuntime(), msgRecord.getGuildId(), msgRecord.getChannelId());
        String string = this.mApp.getApplicationContext().getString(R.string.f157471n0);
        if (channelType == 2) {
            return QQGuildMCParser.INSTANCE.f("100960", "voiceChannelPerfix", string);
        }
        if (channelType == 5) {
            return QQGuildMCParser.INSTANCE.f("100960", "livingChannelPerfix", string);
        }
        return string;
    }

    private void handleNotifyDirectMessage(MsgRecord msgRecord) {
        String channelId = msgRecord.getChannelId();
        DirectMessageNode C = DirectMessageNodeRepository.C(channelId);
        if (C == null) {
            QLog.w(TAG, 1, "[afterOnlinePushProcessed] handleNotifyDirectMessage not find channelId: " + channelId);
            return;
        }
        if (!canNotifyByLogic(msgRecord)) {
            QLog.w(TAG, 1, "[afterOnlinePushProcessed] handleNotifyDirectMessage can not logic ");
            return;
        }
        saveLastMsg(msgRecord);
        long messageDelayTime = getMessageDelayTime(msgRecord);
        if (messageDelayTime > 0) {
            postNotifyDelay(messageDelayTime);
        } else {
            notifyImmediately();
        }
        QLog.i(TAG, 1, "[afterOnlinePushProcessed] handleNotifyDirectMessage, from: " + C.getSource().getTinyId() + " shouldNotify() = " + C.y() + " delayTime:" + messageDelayTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleNotifyGuildMessageInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$handleNotifyGuildMessage$1(MsgRecord msgRecord) {
        log("handleNotifyGuildMessage before channelId:" + msgRecord.getChannelId() + "seq:" + msgRecord.getMsgSeq());
        if (!canNotifyBefore(msgRecord)) {
            return;
        }
        if (msgRecord.getDirectMsgFlag() == 1) {
            handleNotifyDirectMessage(msgRecord);
            return;
        }
        try {
            IGProChannelInfo channelInfo = ((IGPSService) this.mApp.getRuntimeService(IGPSService.class)).getChannelInfo(msgRecord.getChannelId());
            if (channelInfo == null) {
                log("handleNotifyGuildMessage channelInfo ERR! " + msgRecord.getChannelId());
                return;
            }
            if (!canNotifyByLogic(msgRecord)) {
                return;
            }
            saveLastMsg(msgRecord);
            if (channelInfo.getType() == 7 && !TextUtils.isEmpty(msgRecord.feedId)) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(IGuildMessageUtilsApi.MSG_FROM_PUSH_CHANNEL, (Number) 3);
                this.mLastMsg.extStr = jsonObject.toString();
            }
            long messageDelayTime = getMessageDelayTime(msgRecord);
            if (messageDelayTime > 0) {
                postNotifyDelay(messageDelayTime);
            } else {
                notifyImmediately();
            }
            log("handleNotifyGuildMessageInternal success shmsgseq:" + msgRecord.getMsgSeq() + " channelId" + channelInfo.getChannelUin() + " FinalMsgNotify:" + channelInfo.getFinalMsgNotify() + " delayTime:" + messageDelayTime);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getChannelInfo error! e = " + e16);
        }
    }

    private boolean isAllowChannelIdEmpty(Object obj) {
        boolean z16;
        if (!(obj instanceof Bundle)) {
            return false;
        }
        Bundle bundle = (Bundle) obj;
        boolean z17 = bundle.getBoolean("is_guest_notice", false);
        if (((GuildManageNoticePushMsg) bundle.getParcelable("GUILD_MANAGE_NOTICE_PUSH")) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z17 && !z16) {
            return false;
        }
        return true;
    }

    private boolean isAtMeOrSummonMsg(MsgRecord msgRecord) {
        if (msgRecord == null) {
            return false;
        }
        String selfTinyId = ((IGPSService) this.mApp.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        if (!qr0.e.e(msgRecord, g.b()) && !qr0.e.b(msgRecord, selfTinyId) && !MsgExtKt.V(msgRecord)) {
            return false;
        }
        return true;
    }

    private boolean isDirectMessageNodeInited(MsgRecord msgRecord) {
        if (DirectMessageNodeRepository.C(msgRecord.getChannelId()) != null) {
            return true;
        }
        wp1.c.o();
        QLog.i(TAG, 1, "isDirectMessageNodeInited: false. delay handleNotification.");
        return false;
    }

    private boolean isGuildCloseMessageNotify(String str) {
        IGProGuildInfo guildInfo = ((IGPSService) this.mApp.getRuntimeService(IGPSService.class)).getGuildInfo(str);
        if (guildInfo != null && guildInfo.getGuildUnNotifyFlag() == 0) {
            return false;
        }
        return true;
    }

    private boolean isRevokeMsg(MsgRecord msgRecord) {
        if (msgRecord.getMsgType() == 1) {
            return true;
        }
        if (msgRecord.getMsgType() == 5 && msgRecord.getElements() != null) {
            Iterator<MsgElement> it = msgRecord.getElements().iterator();
            while (it.hasNext()) {
                MsgElement next = it.next();
                if (next.getGrayTipElement() != null && next.getGrayTipElement().getSubElementType() == 1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleMsgRevokeEvent$0(Message message) {
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).handleReceivedMessage(message.counter, true, true, message, this.mApp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyNotification$2(Message message) {
        this.messageFacade.setIncomingMsg(message);
        az.d(false);
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).handleReceivedMessage(message.counter, true, true, message, this.mApp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyNotification$3(Message message, int i3, String str, ArrayList arrayList) {
        MsgAbstract msgAbstract;
        synchronized (this) {
            if (message != this.mLastMsg) {
                QLog.e(TAG, 1, "getMsgAbstract mLastMsg different");
                return;
            }
            if (arrayList.size() > 0) {
                msgAbstract = (MsgAbstract) arrayList.get(0);
            } else {
                msgAbstract = new MsgAbstract();
            }
            final Message convert2NotifyMessage = convert2NotifyMessage(this.mLastMsg, msgAbstract);
            if (this.mChannelHasNotNotifyCount.containsKey(this.mLastMsg.frienduin)) {
                Integer num = this.mChannelHasNotNotifyCount.get(this.mLastMsg.frienduin);
                if (num == null) {
                    QLog.e(TAG, 1, "mChannelHasNotNotifyCount.get(mLastMsg.frienduin) == null");
                    return;
                } else {
                    convert2NotifyMessage.counter = num.intValue();
                    this.mNotifyingMsg = convert2NotifyMessage;
                    this.mChannelHasNotNotifyCount.clear();
                }
            }
            Object obj = this.mLastMsg.extObj;
            if ((obj instanceof MsgRecord) && ((MsgRecord) obj).getDirectMsgFlag() == 1) {
                this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.notify.api.impl.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildNotifyImpl.this.lambda$notifyNotification$2(convert2NotifyMessage);
                    }
                });
            } else {
                IGProGuildInfo guildInfo = ((IGPSService) this.mApp.getRuntimeService(IGPSService.class)).getGuildInfo(su1.c.b(this.mLastMsg));
                if (guildInfo != null) {
                    String avatarUrl = guildInfo.getAvatarUrl(100);
                    com.tencent.mobileqq.guild.picload.e.a().f(new Option().setUrl(avatarUrl).setPredecode(true).setLoadingDrawable(com.tencent.mobileqq.urldrawable.b.f306350a), new b(true, avatarUrl, convert2NotifyMessage));
                }
            }
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "notifyNotification" + convert2NotifyMessage);
            }
        }
    }

    private void log(String str) {
        QLog.i(TAG, 1, str);
    }

    private boolean needDelayMessage(MsgRecord msgRecord) {
        if (System.currentTimeMillis() - this.mLastNotifyTime > getConfig().a()) {
            return false;
        }
        if (qr0.e.c(msgRecord, ((IGPSService) this.mApp.getRuntimeService(IGPSService.class, "")).getSelfTinyId())) {
            return getConfig().b();
        }
        if (qr0.e.f(msgRecord)) {
            return getConfig().c();
        }
        return !isAtMeOrSummonMsg(msgRecord);
    }

    private synchronized void saveLastMsg(MsgRecord msgRecord) {
        ChatMessage convertToChatMessage = ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).convertToChatMessage(this.mApp, msgRecord);
        Message message = new Message();
        this.mLastMsg = message;
        MessageRecord.copyMessageRecordBaseField(message, convertToChatMessage);
        this.mLastMsg.extObj = msgRecord;
        if (!this.mChannelHasNotNotifyCount.containsKey(msgRecord.getChannelId())) {
            this.mChannelHasNotNotifyCount.put(msgRecord.getChannelId(), 0);
        }
        this.mChannelHasNotNotifyCount.put(msgRecord.getChannelId(), Integer.valueOf(this.mChannelHasNotNotifyCount.get(msgRecord.getChannelId()).intValue() + 1));
    }

    @Override // com.tencent.mobileqq.guild.message.notify.api.IGuildNotify
    public boolean canNotify(String str, Object obj) {
        boolean isAllowChannelIdEmpty = isAllowChannelIdEmpty(obj);
        if (TextUtils.isEmpty(str) && !isAllowChannelIdEmpty) {
            log("canNotify channelId null");
            return false;
        }
        IGPSService d16 = at.d();
        if (d16 == null) {
            log("canNotify service null");
            return false;
        }
        if (((IGuildTempApi) QRoute.api(IGuildTempApi.class)).otherDevLoginMute(this.mApp)) {
            log("canNotify otherDevLoginMute");
            return false;
        }
        if (!isAllowChannelIdEmpty) {
            IGProChannelInfo channelInfo = d16.getChannelInfo(str);
            if (channelInfo == null) {
                log("canNotify channelInfo null");
                return false;
            }
            boolean isShowGuildTabCached = ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTabCached();
            boolean isQQMsgListChannel = d16.isQQMsgListChannel(channelInfo.getGuildId(), channelInfo.getChannelUin());
            boolean f16 = GuildJumpUtil.f(channelInfo.getGuildId(), "canNotify");
            if (!isShowGuildTabCached && !isQQMsgListChannel && !f16) {
                log("canNotify isQQMsgListChannel or isQQMsgListGuild or isGuildFeedHome");
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.message.notify.api.IGuildNotify
    public boolean canNotifyByLogic(MsgRecord msgRecord) {
        if (msgRecord == null) {
            log("canNotifyByLogic msgRecord null");
            return false;
        }
        if (((IGuildTempApi) QRoute.api(IGuildTempApi.class)).otherDevLoginMute(this.mApp)) {
            log("canNotifyByLogic otherDevLoginMute");
            return false;
        }
        IGPSService d16 = at.d();
        if (d16 == null) {
            log("canNotifyByLogic service null");
            return false;
        }
        if (TextUtils.equals(d16.getSelfTinyId(), msgRecord.getSenderUid())) {
            log("canNotifyByLogic selfMsg");
            return false;
        }
        String channelId = msgRecord.getChannelId();
        if (msgRecord.getDirectMsgFlag() == 1) {
            log("canNotifyByLogic directMsg");
            if (!ca.a()) {
                QLog.i(TAG, 1, "canNotify DirectMsg false: !isTabShow channelId:" + msgRecord.getChannelId());
                return false;
            }
            if (wp1.c.o() != 1) {
                QLog.i(TAG, 1, "canNotify DirectMsg false: notifyStatus" + wp1.c.o() + " channelId:" + msgRecord.getChannelId());
                return false;
            }
            DirectMessageNode C = DirectMessageNodeRepository.C(channelId);
            if (C != null && C.y()) {
                return true;
            }
            QLog.i(TAG, 1, "canNotify DirectMsg false:  channelId:" + msgRecord.getChannelId());
            return false;
        }
        IGProChannelInfo channelInfo = d16.getChannelInfo(channelId);
        if (channelInfo == null) {
            log("canNotifyByLogic channelInfo null");
            return false;
        }
        if (channelInfo.getType() != 1 && channelInfo.getType() != 6) {
            boolean isShowGuildTabCached = ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTabCached();
            boolean isQQMsgListChannel = d16.isQQMsgListChannel(channelInfo.getGuildId(), channelInfo.getChannelUin());
            boolean f16 = GuildJumpUtil.f(channelInfo.getGuildId(), "canNotifyByLogic");
            if (!isShowGuildTabCached && !isQQMsgListChannel && !f16) {
                log("canNotifyByLogic isQQMsgListChannel or isQQMsgListGuild");
                return false;
            }
            if (isGuildCloseMessageNotify(channelInfo.getGuildId())) {
                log("canNotifyByLogic guildClose");
                return false;
            }
            if (channelInfo.getFinalMsgNotify() == 3) {
                log("canNotifyByLogic channelClose");
                return false;
            }
            boolean b16 = g.b();
            if (channelInfo.getType() != 5 && channelInfo.getType() != 8 && channelInfo.getType() != 2) {
                if (MsgExtKt.q(msgRecord)) {
                    log("canNotifyByLogic appChannel");
                    return true;
                }
                if (qr0.e.b(msgRecord, ((IGPSService) this.mApp.getRuntimeService(IGPSService.class, "")).getSelfTinyId())) {
                    log("canNotifyByLogic AtMsg");
                    return true;
                }
                if (!MsgExtKt.c(msgRecord) && !MsgExtKt.b(msgRecord, b16) && !MsgExtKt.D(msgRecord) && channelInfo.getFinalMsgNotify() != 1) {
                    return false;
                }
                return true;
            }
            boolean e16 = MsgExtKt.e(msgRecord, b16);
            log("canNotifyByLogic summon " + e16);
            return e16;
        }
        QLog.i(TAG, 1, "canNotify text or application channel false:  channelId:" + msgRecord.getChannelId() + ", type: " + channelInfo.getType());
        return false;
    }

    @Override // com.tencent.mobileqq.guild.message.notify.api.IGuildNotify
    public Bitmap getAvatarBitmap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cacheDrawable.get(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.guild.message.notify.api.IGuildNotify
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getNotificationPrefix(Message message) {
        boolean z16;
        boolean z17;
        int i3;
        Object obj = message.extObj;
        String str = "";
        boolean z18 = false;
        if (!(obj instanceof MsgRecord)) {
            if (!(obj instanceof Bundle) || (i3 = ((Bundle) obj).getInt(AppConstants.Key.GUILD_PUSH_AT_TYPE, 0)) == 0) {
                return "";
            }
            return getAtNotificationPrefix(i3);
        }
        MsgRecord msgRecord = (MsgRecord) obj;
        String selfTinyId = ((IGPSService) this.mApp.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        if (qr0.e.f(msgRecord)) {
            if (qr0.e.c(msgRecord, selfTinyId)) {
                str = this.mApp.getApplicationContext().getString(R.string.f15155180);
            } else {
                str = this.mApp.getApplicationContext().getString(R.string.f15156181);
            }
        } else {
            if (MsgExtKt.C(msgRecord, selfTinyId)) {
                str = this.mApp.getApplicationContext().getString(R.string.f1515317y);
                z16 = false;
                z17 = true;
                if (TextUtils.isEmpty(str) && message.counter > 1) {
                    str = this.mApp.getApplicationContext().getString(R.string.f1515417z, Integer.valueOf(message.counter));
                }
                if (!MsgExtKt.p(msgRecord)) {
                    z18 = z16;
                }
                if (z18) {
                    str = str + message.nickName;
                }
                if (z17) {
                    return str + ":";
                }
                return str;
            }
            if (MsgExtKt.E(msgRecord, selfTinyId)) {
                str = this.mApp.getApplicationContext().getString(R.string.f1515017v);
            } else if (MsgExtKt.c(msgRecord)) {
                str = this.mApp.getApplicationContext().getString(R.string.f1515217x);
            } else if (MsgExtKt.b(msgRecord, g.b())) {
                str = this.mApp.getApplicationContext().getString(R.string.f1515117w);
            } else if (MsgExtKt.D(msgRecord)) {
                str = this.mApp.getApplicationContext().getString(R.string.f1514917u);
            } else if (MsgExtKt.V(msgRecord)) {
                str = getSummonStr(msgRecord);
                z16 = false;
                z17 = z16;
                if (TextUtils.isEmpty(str)) {
                    str = this.mApp.getApplicationContext().getString(R.string.f1515417z, Integer.valueOf(message.counter));
                }
                if (!MsgExtKt.p(msgRecord)) {
                }
                if (z18) {
                }
                if (z17) {
                }
            }
        }
        z16 = true;
        z17 = z16;
        if (TextUtils.isEmpty(str)) {
        }
        if (!MsgExtKt.p(msgRecord)) {
        }
        if (z18) {
        }
        if (z17) {
        }
    }

    public void handleMsgRevokeEvent(ArrayList<com.tencent.qqnt.msg.d> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<com.tencent.qqnt.msg.d> it = arrayList.iterator();
            while (it.hasNext()) {
                MsgRecord a16 = it.next().a();
                if (this.mNotifyingMsg != null && a16 != null && TextUtils.equals(a16.getChannelId(), this.mNotifyingMsg.frienduin) && a16.getMsgId() == this.mNotifyingMsg.uniseq && isRevokeMsg(a16)) {
                    saveRevokeNotifyToMR(this.mNotifyingMsg);
                    final Message message = this.mNotifyingMsg;
                    message.counter = 1;
                    this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.notify.api.impl.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildNotifyImpl.this.lambda$handleMsgRevokeEvent$0(message);
                        }
                    });
                } else if (this.mLastMsg != null && a16 != null && TextUtils.equals(a16.getChannelId(), this.mLastMsg.frienduin) && a16.getMsgId() == this.mLastMsg.uniseq && isRevokeMsg(a16)) {
                    saveRevokeNotifyToMR(this.mLastMsg);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.notify.api.IGuildNotify
    public void handleNotifyGuildMessage(final MsgRecord msgRecord) {
        boolean z16 = msgRecord.getDirectMsgFlag() == 1;
        if (!BadgeUtils.i() && (!z16 || isDirectMessageNodeInited(msgRecord))) {
            lambda$handleNotifyGuildMessage$1(msgRecord);
        } else {
            this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.message.notify.api.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildNotifyImpl.this.lambda$handleNotifyGuildMessage$1(msgRecord);
                }
            }, 800L);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.notify.api.IGuildNotify
    public boolean isRevokeNotify(Message message) {
        if (message != null && !TextUtils.isEmpty(message.extStr) && message.extStr.contains(MSG_GUILD_REVOKE_NOTIFY)) {
            try {
                return TextUtils.equals(message.getExtInfoFromExtStr(MSG_GUILD_REVOKE_NOTIFY), MSG_GUILD_REVOKE_NOTIFY);
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    protected void notifyImmediately() {
        if (this.mHandler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
        this.mHandler.sendEmptyMessage(1);
    }

    protected synchronized void notifyNotification() {
        this.mLastNotifyTime = System.currentTimeMillis();
        final Message message = this.mLastMsg;
        getMsgAbstract(message, new IGetMsgAbstractsCallback() { // from class: com.tencent.mobileqq.guild.message.notify.api.impl.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetMsgAbstractsCallback
            public final void onGetMsgAbstracts(int i3, String str, ArrayList arrayList) {
                GuildNotifyImpl.this.lambda$notifyNotification$3(message, i3, str, arrayList);
            }
        });
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mLastNotifyTime = 0L;
        this.mApp = (BaseQQAppInterface) appRuntime;
        this.mChannelHasNotNotifyCount = new HashMap<>();
        this.messageFacade = (IMessageFacade) this.mApp.getRuntimeService(IMessageFacade.class, "");
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.handleMsgRevoke.b();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    protected void postNotifyDelay(long j3) {
        if (this.mHandler.hasMessages(1)) {
            return;
        }
        this.mHandler.sendEmptyMessageDelayed(1, j3);
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 2, "postNotifyDelay");
        }
    }

    protected void saveRevokeNotifyToMR(MessageRecord messageRecord) {
        if (messageRecord != null) {
            messageRecord.saveExtInfoToExtStr(MSG_GUILD_REVOKE_NOTIFY, MSG_GUILD_REVOKE_NOTIFY);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.notify.api.IGuildNotify
    public boolean shieldNotifyMainBackground(Message message, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19 = false;
        if (message.istroop == 10014 && ((IGuildUserService) this.mApp.getRuntimeService(IGuildUserService.class)).isGuildUserCached()) {
            String str = message.frienduin;
            if (!GuildMainFrameUtils.q(str) && TextUtils.equals(GLiveChannelCore.f226698a.s().getChannelId(), str)) {
                z17 = true;
            } else {
                z17 = false;
            }
            boolean K = j.a().K(str);
            Object obj = message.extObj;
            if ((obj instanceof MsgRecord) && MsgExtKt.G((MsgRecord) obj) && !g.b()) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z17 || K || z16 || z18) {
                z19 = true;
            }
            QLog.i(TAG, 1, "shieldByBackground: ret:" + z19 + " channelId:" + str + " live\uff1a" + z17 + " media:" + K + " subProcessBackgroundStop:" + z16 + "isAtOnline:" + z18);
        }
        return z19;
    }

    @Override // com.tencent.mobileqq.guild.message.notify.api.IGuildNotify
    public boolean shieldNotifyMainForeground(Message message) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        boolean z37;
        boolean z38;
        boolean z39;
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        String str = message.frienduin;
        if (qBaseActivity == null) {
            QLog.i(TAG, 1, "shieldByBackground: sTopActivity is null, return.");
            return false;
        }
        if (((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getGuildManageNoticePushMsgFromMr(message) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isInConversationTab = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isInConversationTab();
        if (z16) {
            QLog.i(TAG, 1, "shieldByForeground: isGuildManageNotice ret: isInConversationTab");
            return isInConversationTab;
        }
        boolean isGuildTabSelected = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected();
        boolean equals = TextUtils.equals(GLiveChannelCore.f226698a.s().getChannelId(), str);
        boolean K = j.a().K(str);
        Object obj = message.extObj;
        if (obj instanceof MsgRecord) {
            z18 = isAtMeOrSummonMsg((MsgRecord) obj);
            if (((MsgRecord) message.extObj).getDirectMsgFlag() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
        } else {
            z17 = false;
            z18 = true;
        }
        if (isGuildTabSelected && !z18 && !z17) {
            z19 = true;
        } else {
            z19 = false;
        }
        AIOContact activeAIOContact = ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getActiveAIOContact();
        if (activeAIOContact != null && TextUtils.equals(str, activeAIOContact.j())) {
            z26 = true;
        } else {
            z26 = false;
        }
        IGPSService iGPSService = (IGPSService) this.mApp.getRuntimeService(IGPSService.class);
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(str);
        if (channelInfo != null) {
            z27 = iGPSService.isQQMsgListChannel(channelInfo.getGuildId(), channelInfo.getChannelUin());
            z28 = GuildJumpUtil.f(channelInfo.getGuildId(), "shieldNotifyMainForeground");
        } else {
            z27 = false;
            z28 = false;
        }
        boolean d16 = GuildOpenRecordManager.d();
        if (isInConversationTab && !d16 && (isAllowChannelIdEmpty(message.extObj) || z27 || z28)) {
            z29 = true;
        } else {
            z29 = false;
        }
        if (isInConversationTab && d16 && ((z27 || z28) && !z18)) {
            z36 = true;
        } else {
            z36 = false;
        }
        if (((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getCurrentActiveTab() == 2) {
            z37 = true;
        } else {
            z37 = false;
        }
        if ((isInConversationTab || z37) && z17) {
            z38 = true;
        } else {
            z38 = false;
        }
        if (!equals && !K && !z26 && !z38 && !z19 && !z29 && !z36) {
            z39 = false;
        } else {
            z39 = true;
        }
        QLog.i(TAG, 1, "shieldByForeground: ret:" + z39 + " channelId:" + str + " live\uff1a" + equals + " media:" + K + "  guildAIO:" + z26 + " isConvTabAndDirectMsg:" + z38 + " inGuildTabNotAt:" + z19 + " isGuildPageResume:" + d16 + " isInMsgListAndInConversationTabAndNotDisplay:" + z29 + " isInMsgListAtMsgAndInConversationTabAndDisplay:" + z36);
        return z39;
    }

    @Override // com.tencent.mobileqq.guild.message.notify.api.IGuildNotify
    public void handleNotifyGuildMessage(Message message) {
        IGProGuildInfo guildInfo = ((IGPSService) this.mApp.getRuntimeService(IGPSService.class)).getGuildInfo(su1.c.b(message));
        if (guildInfo != null) {
            String avatarUrl = guildInfo.getAvatarUrl(100);
            com.tencent.mobileqq.guild.picload.e.a().f(new Option().setUrl(avatarUrl).setPredecode(true).setLoadingDrawable(com.tencent.mobileqq.urldrawable.b.f306350a), new c(true, avatarUrl, message));
        }
    }
}
