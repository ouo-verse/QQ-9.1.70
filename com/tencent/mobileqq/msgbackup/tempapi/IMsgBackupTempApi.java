package com.tencent.mobileqq.msgbackup.tempapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.service.message.ac;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm$MsgHead;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7$MsgBody;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMsgBackupTempApi extends QRouteApi {
    ChatMessage changeRealChatMessage(ChatMessage chatMessage);

    MessageRecord changeRichTextToTextMsg(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord, String str, boolean z16);

    msg_svc$PbSendMsgReq createPbSendMsgReq(BaseQQAppInterface baseQQAppInterface, int i3, String str, ac acVar, long j3, int i16);

    void destoryFaceDecord();

    void fillMsgHeader(BaseQQAppInterface baseQQAppInterface, SubMsgType0x7$MsgBody.MsgHeader msgHeader, Long l3);

    MqqHandler getConversationHandler(BaseQQAppInterface baseQQAppInterface);

    String getCreateFileName(BaseQQAppInterface baseQQAppInterface, long j3, MessageForTroopFile messageForTroopFile);

    Drawable getFaceDrawable(BaseQQAppInterface baseQQAppInterface, DecodeTaskCompletionListener decodeTaskCompletionListener, int i3, String str);

    Drawable getFaceDrawable(BaseQQAppInterface baseQQAppInterface, DecodeTaskCompletionListener decodeTaskCompletionListener, RecentBaseData recentBaseData);

    byte[] getFileIdByte(BaseQQAppInterface baseQQAppInterface, long j3, MessageForTroopFile messageForTroopFile);

    int getFileImageHeight(BaseQQAppInterface baseQQAppInterface, MessageForTroopFile messageForTroopFile);

    int getFileImageWidth(BaseQQAppInterface baseQQAppInterface, MessageForTroopFile messageForTroopFile);

    int getFileType(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord);

    Pair<Integer, Integer> getHeadIcon(BaseQQAppInterface baseQQAppInterface, int i3, String str);

    int getInActionLoginB(BaseQQAppInterface baseQQAppInterface);

    String getLargeThumbPath(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord);

    String getLargeThumbPath2(BaseQQAppInterface baseQQAppInterface, String str, MessageForTroopFile messageForTroopFile);

    String getLocalFilePath(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord);

    String getLocalFilePath2(BaseQQAppInterface baseQQAppInterface, String str, MessageForTroopFile messageForTroopFile);

    MessageRecord getMessageRecord(BaseQQAppInterface baseQQAppInterface, String str, int i3, long j3, int i16);

    im_msg_body$MsgBody getMultiMsgBody(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord);

    msg_comm$MsgHead getMultiMsgHead(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord, long j3);

    String getTroopFileItemFileName(BaseQQAppInterface baseQQAppInterface, MessageForTroopFile messageForTroopFile);

    String getTroopFileItemId(BaseQQAppInterface baseQQAppInterface, MessageForTroopFile messageForTroopFile);

    String getTroopThumbnailFile(long j3, String str);

    String getTroopThumbnailFilePath(long j3, int i3, String str);

    String getUnsupportMsgStr(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord);

    void gotoChatHistoryFragment(Context context, Intent intent);

    void gotoConversation(Activity activity);

    void gotoQQSettingMsgClearFragment(Context context, Intent intent);

    void gotoWebViewBrowser(Context context, String str, boolean z16, boolean z17, boolean z18, boolean z19, Object obj, String str2);

    String handleMultiMsg(MessageRecord messageRecord);

    void insertToFMList(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity);

    void insertToMemMap(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity);

    boolean isAnonymousMsg(MessageRecord messageRecord);

    boolean isBeancurdMsg(ChatMessage chatMessage);

    boolean isMultiMsg(ChatMessage chatMessage);

    boolean isNeedHandle(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord);

    boolean isNeedHandleCreateTroopFileInfo(BaseQQAppInterface baseQQAppInterface, long j3, MessageForTroopFile messageForTroopFile);

    boolean isNeedHandleTroopFileRecord(BaseQQAppInterface baseQQAppInterface, MessageForTroopFile messageForTroopFile);

    boolean isSupportMsgType(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord);

    void openStorageScanView(Context context, AppRuntime appRuntime);

    FileManagerEntity queryEntityForDbByFileId(BaseQQAppInterface baseQQAppInterface, String str);

    FileManagerEntity queryFileEntityByUniseq(BaseQQAppInterface baseQQAppInterface, long j3, String str, int i3);

    FileManagerEntity queryFileManagerEntityByFileUuidForMemory(BaseQQAppInterface baseQQAppInterface, String str);

    void saveItemLargeThrumbPath(BaseQQAppInterface baseQQAppInterface, MessageForTroopFile messageForTroopFile, String str);

    void saveItemRawPath(BaseQQAppInterface baseQQAppInterface, MessageForTroopFile messageForTroopFile, String str);

    void saveTroopFileInfo(BaseQQAppInterface baseQQAppInterface, long j3, MessageForTroopFile messageForTroopFile, String str, String str2);

    MessageRecord transToMessageRecord(BaseQQAppInterface baseQQAppInterface, byte[] bArr);

    void updateFileEntity(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity);
}
