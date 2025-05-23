package com.tencent.mobileqq.msgbackup.tempapi.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.q;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.impl.a;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.i;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.IMultiMsgRecordOp;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.fragment.QQSettingMsgClearFragment;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.ac;
import com.tencent.mobileqq.service.message.p;
import com.tencent.mobileqq.settings.message.ChatHistorySettingFragment;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.ae;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm$MsgHead;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7$MsgBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsgBackupTempApiImpl implements IMsgBackupTempApi {
    static IPatchRedirector $redirector_;
    protected i mFaceDecoder;

    public MsgBackupTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private n getTroopFileInfo(BaseQQAppInterface baseQQAppInterface, long j3, MessageForTroopFile messageForTroopFile) {
        return TroopFileManager.F((QQAppInterface) baseQQAppInterface, j3).r(messageForTroopFile.url, messageForTroopFile.fileName, messageForTroopFile.fileSize, messageForTroopFile.bisID);
    }

    private TroopFileTransferManager.Item getTroopFileTransferManagerItem(BaseQQAppInterface baseQQAppInterface, String str, MessageForTroopFile messageForTroopFile) {
        UUID uuid;
        QQAppInterface qQAppInterface = (QQAppInterface) baseQQAppInterface;
        TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, Long.parseLong(str));
        t m3 = TroopFileUtils.m(qQAppInterface, messageForTroopFile);
        if (O != null && m3 != null && (uuid = m3.f294967a) != null) {
            return O.J(uuid);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public ChatMessage changeRealChatMessage(ChatMessage chatMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ChatMessage) iPatchRedirector.redirect((short) 23, (Object) this, (Object) chatMessage);
        }
        return FileManagerUtil.changeRealChatMessage(chatMessage);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public MessageRecord changeRichTextToTextMsg(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 4, this, baseQQAppInterface, messageRecord, str, Boolean.valueOf(z16));
        }
        return ((QQAppInterface) baseQQAppInterface).getMultiMessageProxy().c(messageRecord, str, false);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public msg_svc$PbSendMsgReq createPbSendMsgReq(BaseQQAppInterface baseQQAppInterface, int i3, String str, ac acVar, long j3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (msg_svc$PbSendMsgReq) iPatchRedirector.redirect((short) 19, this, baseQQAppInterface, Integer.valueOf(i3), str, acVar, Long.valueOf(j3), Integer.valueOf(i16));
        }
        return p.a(baseQQAppInterface, i3, str, acVar, j3, i16);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public void destoryFaceDecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        i iVar = this.mFaceDecoder;
        if (iVar != null) {
            iVar.r();
            this.mFaceDecoder = null;
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public void fillMsgHeader(BaseQQAppInterface baseQQAppInterface, SubMsgType0x7$MsgBody.MsgHeader msgHeader, Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, baseQQAppInterface, msgHeader, l3);
        } else {
            new ProtocolHelper(baseQQAppInterface, 0).fillMsgHeader(msgHeader, l3.longValue());
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public MqqHandler getConversationHandler(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (MqqHandler) iPatchRedirector.redirect((short) 10, (Object) this, (Object) baseQQAppInterface);
        }
        return baseQQAppInterface.getHandler(Conversation.class);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public String getCreateFileName(BaseQQAppInterface baseQQAppInterface, long j3, MessageForTroopFile messageForTroopFile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (String) iPatchRedirector.redirect((short) 41, this, baseQQAppInterface, Long.valueOf(j3), messageForTroopFile);
        }
        n troopFileInfo = getTroopFileInfo(baseQQAppInterface, j3, messageForTroopFile);
        if (troopFileInfo != null) {
            return troopFileInfo.f294917c;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public Drawable getFaceDrawable(BaseQQAppInterface baseQQAppInterface, DecodeTaskCompletionListener decodeTaskCompletionListener, RecentBaseData recentBaseData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Drawable) iPatchRedirector.redirect((short) 15, this, baseQQAppInterface, decodeTaskCompletionListener, recentBaseData);
        }
        if (this.mFaceDecoder == null) {
            this.mFaceDecoder = new i((QQAppInterface) baseQQAppInterface, decodeTaskCompletionListener, false);
        }
        return this.mFaceDecoder.g(recentBaseData);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public byte[] getFileIdByte(BaseQQAppInterface baseQQAppInterface, long j3, MessageForTroopFile messageForTroopFile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (byte[]) iPatchRedirector.redirect((short) 40, this, baseQQAppInterface, Long.valueOf(j3), messageForTroopFile);
        }
        n troopFileInfo = getTroopFileInfo(baseQQAppInterface, j3, messageForTroopFile);
        if (troopFileInfo != null) {
            return troopFileInfo.f294916b.getBytes();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public int getFileImageHeight(BaseQQAppInterface baseQQAppInterface, MessageForTroopFile messageForTroopFile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this, (Object) baseQQAppInterface, (Object) messageForTroopFile)).intValue();
        }
        t troopFileStatusInfo = getTroopFileStatusInfo(baseQQAppInterface, messageForTroopFile);
        if (troopFileStatusInfo != null) {
            return troopFileStatusInfo.f294983q;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public int getFileImageWidth(BaseQQAppInterface baseQQAppInterface, MessageForTroopFile messageForTroopFile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this, (Object) baseQQAppInterface, (Object) messageForTroopFile)).intValue();
        }
        t troopFileStatusInfo = getTroopFileStatusInfo(baseQQAppInterface, messageForTroopFile);
        if (troopFileStatusInfo != null) {
            return troopFileStatusInfo.f294982p;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public int getFileType(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this, (Object) baseQQAppInterface, (Object) messageRecord)).intValue();
        }
        t troopFileStatusInfo = getTroopFileStatusInfo(baseQQAppInterface, messageRecord);
        if (troopFileStatusInfo != null) {
            return FileManagerUtil.getFileType(troopFileStatusInfo.f294987u);
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public Pair<Integer, Integer> getHeadIcon(BaseQQAppInterface baseQQAppInterface, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Pair) iPatchRedirector.redirect((short) 13, this, baseQQAppInterface, Integer.valueOf(i3), str);
        }
        return i.n((QQAppInterface) baseQQAppInterface, i3, str);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public int getInActionLoginB(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) baseQQAppInterface)).intValue();
        }
        return ((QQAppInterface) baseQQAppInterface).mAutomator.getInActionLoginB();
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public String getLargeThumbPath(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this, (Object) baseQQAppInterface, (Object) messageRecord);
        }
        t troopFileStatusInfo = getTroopFileStatusInfo(baseQQAppInterface, messageRecord);
        if (troopFileStatusInfo != null) {
            return troopFileStatusInfo.f294980n;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public String getLargeThumbPath2(BaseQQAppInterface baseQQAppInterface, String str, MessageForTroopFile messageForTroopFile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, this, baseQQAppInterface, str, messageForTroopFile);
        }
        TroopFileTransferManager.Item troopFileTransferManagerItem = getTroopFileTransferManagerItem(baseQQAppInterface, str, messageForTroopFile);
        if (troopFileTransferManagerItem != null) {
            return troopFileTransferManagerItem.largeThumbnailFile;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public String getLocalFilePath(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this, (Object) baseQQAppInterface, (Object) messageRecord);
        }
        t troopFileStatusInfo = getTroopFileStatusInfo(baseQQAppInterface, messageRecord);
        if (troopFileStatusInfo != null) {
            return troopFileStatusInfo.f294978l;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public String getLocalFilePath2(BaseQQAppInterface baseQQAppInterface, String str, MessageForTroopFile messageForTroopFile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, this, baseQQAppInterface, str, messageForTroopFile);
        }
        TroopFileTransferManager.Item troopFileTransferManagerItem = getTroopFileTransferManagerItem(baseQQAppInterface, str, messageForTroopFile);
        if (troopFileTransferManagerItem != null) {
            return troopFileTransferManagerItem.LocalFile;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public MessageRecord getMessageRecord(BaseQQAppInterface baseQQAppInterface, String str, int i3, long j3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 47, this, baseQQAppInterface, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16));
        }
        return ((QQAppInterface) baseQQAppInterface).getMessageFacade().M(str, i3, j3, i16);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public im_msg_body$MsgBody getMultiMsgBody(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (im_msg_body$MsgBody) iPatchRedirector.redirect((short) 22, (Object) this, (Object) baseQQAppInterface, (Object) messageRecord);
        }
        return ((QQAppInterface) baseQQAppInterface).getMultiMessageProxy().i(messageRecord, false);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public msg_comm$MsgHead getMultiMsgHead(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (msg_comm$MsgHead) iPatchRedirector.redirect((short) 21, this, baseQQAppInterface, messageRecord, Long.valueOf(j3));
        }
        return ((QQAppInterface) baseQQAppInterface).getMultiMessageProxy().o(messageRecord, null, false, 0, false);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public String getTroopFileItemFileName(BaseQQAppInterface baseQQAppInterface, MessageForTroopFile messageForTroopFile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this, (Object) baseQQAppInterface, (Object) messageForTroopFile);
        }
        TroopFileTransferManager.Item troopFileTransferManagerItem = getTroopFileTransferManagerItem(baseQQAppInterface, messageForTroopFile.frienduin, messageForTroopFile);
        if (troopFileTransferManagerItem != null) {
            return troopFileTransferManagerItem.FileName;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public String getTroopFileItemId(BaseQQAppInterface baseQQAppInterface, MessageForTroopFile messageForTroopFile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this, (Object) baseQQAppInterface, (Object) messageForTroopFile);
        }
        TroopFileTransferManager.Item troopFileTransferManagerItem = getTroopFileTransferManagerItem(baseQQAppInterface, messageForTroopFile.frienduin, messageForTroopFile);
        if (troopFileTransferManagerItem != null) {
            return troopFileTransferManagerItem.Id.toString();
        }
        return null;
    }

    public t getTroopFileStatusInfo(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (t) iPatchRedirector.redirect((short) 25, (Object) this, (Object) baseQQAppInterface, (Object) messageRecord);
        }
        if (messageRecord.isMultiMsg) {
            return TroopFileUtils.m((QQAppInterface) baseQQAppInterface, (MessageForTroopFile) FileManagerUtil.changeRealChatMessage((ChatMessage) messageRecord));
        }
        return TroopFileUtils.m((QQAppInterface) baseQQAppInterface, (MessageForTroopFile) messageRecord);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public String getTroopThumbnailFile(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, this, Long.valueOf(j3), str);
        }
        return QFileUtils.a0(j3, 640, str);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public String getTroopThumbnailFilePath(long j3, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, this, Long.valueOf(j3), Integer.valueOf(i3), str);
        }
        return QFileUtils.a0(j3, i3, str);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public String getUnsupportMsgStr(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseQQAppInterface, (Object) messageRecord);
        }
        return com.tencent.mobileqq.multimsg.i.h((QQAppInterface) baseQQAppInterface, (ChatMessage) messageRecord);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public void gotoChatHistoryFragment(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) context, (Object) intent);
        } else {
            PublicFragmentActivity.start(context, intent, ChatHistorySettingFragment.class);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public void gotoConversation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
            return;
        }
        Intent aliasIntent = SplashActivity.getAliasIntent(activity);
        aliasIntent.putExtra("tab_index", a.f183038a);
        aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        aliasIntent.setFlags(67108864);
        activity.startActivity(aliasIntent);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public void gotoQQSettingMsgClearFragment(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) context, (Object) intent);
        } else {
            PublicFragmentActivity.start(context, intent, QQSettingMsgClearFragment.class);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public void gotoWebViewBrowser(Context context, String str, boolean z16, boolean z17, boolean z18, boolean z19, Object obj, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, context, str, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), obj, str2);
        } else {
            com.tencent.mobileqq.mtt.a.a(context, str, true, true, true, false, null, "biz_src_msg_backup");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public String handleMultiMsg(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) messageRecord);
        }
        if (messageRecord instanceof IMultiMsgRecordOp) {
            return ((IMultiMsgRecordOp) messageRecord).getFilename();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public void insertToFMList(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) baseQQAppInterface, (Object) fileManagerEntity);
        } else {
            ((QQAppInterface) baseQQAppInterface).getFileManagerDataCenter().f0(fileManagerEntity);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public void insertToMemMap(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) baseQQAppInterface, (Object) fileManagerEntity);
        } else {
            ((QQAppInterface) baseQQAppInterface).getFileManagerDataCenter().t(fileManagerEntity);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public boolean isAnonymousMsg(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return com.tencent.biz.anonymous.a.m(messageRecord);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public boolean isBeancurdMsg(ChatMessage chatMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) chatMessage)).booleanValue();
        }
        return q.h(chatMessage);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public boolean isMultiMsg(ChatMessage chatMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) chatMessage)).booleanValue();
        }
        return com.tencent.mobileqq.multimsg.i.m(chatMessage);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public boolean isNeedHandle(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) baseQQAppInterface, (Object) messageRecord)).booleanValue();
        }
        if (getTroopFileStatusInfo(baseQQAppInterface, messageRecord) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public boolean isNeedHandleCreateTroopFileInfo(BaseQQAppInterface baseQQAppInterface, long j3, MessageForTroopFile messageForTroopFile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, this, baseQQAppInterface, Long.valueOf(j3), messageForTroopFile)).booleanValue();
        }
        if (ae.b(j3) == null || getTroopFileInfo(baseQQAppInterface, j3, messageForTroopFile) == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public boolean isNeedHandleTroopFileRecord(BaseQQAppInterface baseQQAppInterface, MessageForTroopFile messageForTroopFile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) baseQQAppInterface, (Object) messageForTroopFile)).booleanValue();
        }
        if (getTroopFileTransferManagerItem(baseQQAppInterface, messageForTroopFile.frienduin, messageForTroopFile) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public boolean isSupportMsgType(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface, (Object) messageRecord)).booleanValue();
        }
        return com.tencent.mobileqq.multimsg.i.o((QQAppInterface) baseQQAppInterface, (ChatMessage) messageRecord);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public void openStorageScanView(Context context, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) context, (Object) appRuntime);
        } else {
            GeneralSettingActivity.x3(context, appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public FileManagerEntity queryEntityForDbByFileId(BaseQQAppInterface baseQQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (FileManagerEntity) iPatchRedirector.redirect((short) 44, (Object) this, (Object) baseQQAppInterface, (Object) str);
        }
        return ((QQAppInterface) baseQQAppInterface).getFileManagerProxy().E(str);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public FileManagerEntity queryFileEntityByUniseq(BaseQQAppInterface baseQQAppInterface, long j3, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (FileManagerEntity) iPatchRedirector.redirect((short) 45, this, baseQQAppInterface, Long.valueOf(j3), str, Integer.valueOf(i3));
        }
        return ((QQAppInterface) baseQQAppInterface).getFileManagerDataCenter().E(j3, str, i3);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public FileManagerEntity queryFileManagerEntityByFileUuidForMemory(BaseQQAppInterface baseQQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (FileManagerEntity) iPatchRedirector.redirect((short) 46, (Object) this, (Object) baseQQAppInterface, (Object) str);
        }
        return ((QQAppInterface) baseQQAppInterface).getFileManagerProxy().K(str);
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public void saveItemLargeThrumbPath(BaseQQAppInterface baseQQAppInterface, MessageForTroopFile messageForTroopFile, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, baseQQAppInterface, messageForTroopFile, str);
            return;
        }
        TroopFileTransferManager O = TroopFileTransferManager.O((QQAppInterface) baseQQAppInterface, Long.parseLong(messageForTroopFile.frienduin));
        TroopFileTransferManager.Item troopFileTransferManagerItem = getTroopFileTransferManagerItem(baseQQAppInterface, messageForTroopFile.frienduin, messageForTroopFile);
        if (troopFileTransferManagerItem != null) {
            troopFileTransferManagerItem.largeThumbnailFile = str;
            troopFileTransferManagerItem.HasThumbnailFile_Large = true;
            O.i0(troopFileTransferManagerItem);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public void saveItemRawPath(BaseQQAppInterface baseQQAppInterface, MessageForTroopFile messageForTroopFile, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, baseQQAppInterface, messageForTroopFile, str);
            return;
        }
        TroopFileTransferManager O = TroopFileTransferManager.O((QQAppInterface) baseQQAppInterface, Long.parseLong(messageForTroopFile.frienduin));
        TroopFileTransferManager.Item troopFileTransferManagerItem = getTroopFileTransferManagerItem(baseQQAppInterface, messageForTroopFile.frienduin, messageForTroopFile);
        if (troopFileTransferManagerItem != null) {
            troopFileTransferManagerItem.LocalFile = str;
            troopFileTransferManagerItem.Status = 11;
            O.i0(troopFileTransferManagerItem);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public void saveTroopFileInfo(BaseQQAppInterface baseQQAppInterface, long j3, MessageForTroopFile messageForTroopFile, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, baseQQAppInterface, Long.valueOf(j3), messageForTroopFile, str, str2);
            return;
        }
        n troopFileInfo = getTroopFileInfo(baseQQAppInterface, j3, messageForTroopFile);
        if (troopFileInfo != null) {
            if (FileUtils.fileExistsAndNotEmpty(str)) {
                troopFileInfo.f294934t = str;
                troopFileInfo.f294930p = 11;
            }
            if (FileUtils.fileExistsAndNotEmpty(str2)) {
                troopFileInfo.f294938x = str2;
            }
            TroopFileTransferManager.O((QQAppInterface) baseQQAppInterface, j3).u(troopFileInfo);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public MessageRecord transToMessageRecord(BaseQQAppInterface baseQQAppInterface, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 20, (Object) this, (Object) baseQQAppInterface, (Object) bArr);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public void updateFileEntity(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) baseQQAppInterface, (Object) fileManagerEntity);
        } else {
            ((QQAppInterface) baseQQAppInterface).getFileManagerProxy().x(fileManagerEntity);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
    public Drawable getFaceDrawable(BaseQQAppInterface baseQQAppInterface, DecodeTaskCompletionListener decodeTaskCompletionListener, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Drawable) iPatchRedirector.redirect((short) 17, this, baseQQAppInterface, decodeTaskCompletionListener, Integer.valueOf(i3), str);
        }
        if (this.mFaceDecoder == null) {
            this.mFaceDecoder = new i((QQAppInterface) baseQQAppInterface, decodeTaskCompletionListener, false);
        }
        return this.mFaceDecoder.e(i3, str);
    }
}
