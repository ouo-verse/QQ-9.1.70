package com.tencent.mobileqq.app;

import QQService.RespTmpChatPicDownload;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForDanceMachine;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.service.message.k;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import msf.msgsvc.msg_svc$TransSvrInfo;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bs extends BaseMessageObserver {
    static IPatchRedirector $redirector_;
    private static HashMap<Integer, com.tencent.mobileqq.app.messageobserver.d> sMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69821);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 140)) {
            redirector.redirect((short) 140);
            return;
        }
        sMap = new HashMap<>();
        com.tencent.mobileqq.app.messageobserver.i iVar = new com.tencent.mobileqq.app.messageobserver.i();
        sMap.put(999, iVar);
        sMap.put(1000, iVar);
        sMap.put(1003, iVar);
        sMap.put(1004, iVar);
        sMap.put(1005, iVar);
        sMap.put(2000, iVar);
        sMap.put(1002, iVar);
        sMap.put(2001, iVar);
        sMap.put(2002, iVar);
        sMap.put(3012, iVar);
        sMap.put(3011, iVar);
        com.tencent.mobileqq.app.messageobserver.b bVar = new com.tencent.mobileqq.app.messageobserver.b();
        sMap.put(4003, bVar);
        sMap.put(4005, bVar);
        sMap.put(4006, bVar);
        sMap.put(4011, bVar);
        sMap.put(4012, bVar);
        sMap.put(4001, bVar);
        sMap.put(4004, bVar);
        sMap.put(4002, bVar);
        sMap.put(4013, bVar);
        sMap.put(3021, bVar);
        com.tencent.mobileqq.app.messageobserver.f fVar = new com.tencent.mobileqq.app.messageobserver.f();
        sMap.put(3001, fVar);
        sMap.put(3002, fVar);
        sMap.put(3013, fVar);
        sMap.put(3008, fVar);
        sMap.put(6000, fVar);
        sMap.put(6009, fVar);
        sMap.put(8002, fVar);
        sMap.put(7000, fVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_SAME_STATE_MSG_SEND_ERROR_RSP), fVar);
        sMap.put(8005, fVar);
        sMap.put(6010, fVar);
        sMap.put(6012, fVar);
        sMap.put(6013, fVar);
        sMap.put(8010, fVar);
        sMap.put(8012, fVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_NEARBY_ASSISTANT_SEND_ERROR_RSP), fVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_TRIBE_TMP), fVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_MOVIE_TICKET_SEND_ERROR_RSP), fVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_QQGAME_MSG_RSP), fVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_QQ_CIRCLE_RESP), fVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_GAME_BUDDY), fVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_QQ_AUDIO_ROOM_RESP), fVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_LIMIT_CHAT_ERROR_RSP), fVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_MATCH_CHAT_ERROR_RSP), fVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_MATCH_CAMPUS_CHAT_ERROR_RSP), fVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_MATCH_FRIEND_CHAT_ERROR_RSP), fVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_SQUARE_CHAT_ERROR_RSP), fVar);
        com.tencent.mobileqq.app.messageobserver.c cVar = new com.tencent.mobileqq.app.messageobserver.c();
        sMap.put(4016, cVar);
        sMap.put(4017, cVar);
        sMap.put(4018, cVar);
        sMap.put(5002, cVar);
        sMap.put(5003, cVar);
        sMap.put(5004, cVar);
        sMap.put(5005, cVar);
        sMap.put(4014, cVar);
        sMap.put(4015, cVar);
        com.tencent.mobileqq.app.messageobserver.a aVar = new com.tencent.mobileqq.app.messageobserver.a();
        sMap.put(6005, aVar);
        sMap.put(6004, aVar);
        sMap.put(6006, aVar);
        sMap.put(6017, aVar);
        sMap.put(6003, aVar);
        sMap.put(6001, aVar);
        sMap.put(6002, aVar);
        sMap.put(6007, aVar);
        sMap.put(5006, aVar);
        sMap.put(5012, aVar);
        sMap.put(5010, aVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_UPDATE_SELF_MSG_SEQ_AND_TIME), aVar);
        sMap.put(6018, aVar);
        com.tencent.mobileqq.app.messageobserver.h hVar = new com.tencent.mobileqq.app.messageobserver.h();
        sMap.put(6008, hVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_ROAM_MESSAGE_SEARCH_IN_CLOUD), hVar);
        sMap.put(6014, hVar);
        sMap.put(6016, hVar);
        sMap.put(8003, hVar);
        sMap.put(8011, hVar);
        sMap.put(8004, hVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_PC_ACTIVE_NOTIFY), hVar);
        sMap.put(6015, hVar);
        com.tencent.mobileqq.app.messageobserver.e eVar = new com.tencent.mobileqq.app.messageobserver.e();
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_REQ_INSERT_BLACKLIST_PB), eVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_SUBACCOUNT_THIRD_QQ_UNREAD_MSG_NUM), eVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_MSG_REVOKE_RSP), eVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_REQ_BLESS_DIRTY_TEXT_CHECK), eVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_REQ_BLESS_MSG), eVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_NEW_MESSAGE_ADDED), eVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_MSG_START_SENDING_UI), eVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_BOX_UNREAD_NUM_REFRESH), eVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_MSGFORWARD_WX), eVar);
        com.tencent.mobileqq.app.messageobserver.g gVar = new com.tencent.mobileqq.app.messageobserver.g();
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_MAC_ONLINES_STATUS), gVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_WATCH_ONLINE_STATUS), gVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_DANCE_MACHINE), gVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_CONFESS_TMP), gVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_HIBOOM_AUTH), gVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_DELETE_ALL_SYSTEMMSG), gVar);
        sMap.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_SEND_RESULT_WITH_TRANSINFO), gVar);
    }

    public bs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void c2cOnlineFile(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 110)) {
            iPatchRedirector.redirect((short) 110, this, Boolean.valueOf(z16), objArr);
        } else if (objArr != null && objArr.length >= 2) {
            onOnlineFileSessionNotify(z16, (String) objArr[1], ((Integer) objArr[0]).intValue(), (String) objArr[2]);
        }
    }

    public void comenMsgReceived() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this);
        } else {
            onUpdateReceivedMsg();
        }
    }

    public void commenMsgContentChanged(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, this, Boolean.valueOf(z16), obj);
        } else if (obj instanceof String) {
            onUpdateMsgContent(z16, (String) obj);
        } else {
            onUpdateMsgContent(z16, "");
        }
    }

    public void danceMachine(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 128)) {
            iPatchRedirector.redirect((short) 128, (Object) this, obj);
        } else if (obj instanceof MessageForDanceMachine) {
            onDanceMachineUploaded((MessageForDanceMachine) obj);
        }
    }

    public void delRoamChatFriend(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this, z16);
        } else {
            onUpdateDelRoamChat(z16);
        }
    }

    public void deleteAllSystemMsg(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 129)) {
            iPatchRedirector.redirect((short) 129, this, Boolean.valueOf(z16), objArr);
        } else if (objArr != null && objArr.length >= 1) {
            onDeleteAllSysMsg(z16, ((Integer) objArr[0]).intValue());
        }
    }

    public void friendsListRefresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this);
        } else {
            onUpdateFriendsList();
        }
    }

    public void getAllProxyTroopMsg(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            iPatchRedirector.redirect((short) 101, this, Boolean.valueOf(z16), objArr);
        } else if (objArr != null && objArr.length >= 2) {
            onGetAllProxyTroopMsgFin(z16, ((Long) objArr[0]).longValue(), ((Long) objArr[1]).longValue());
        } else {
            onGetAllProxyTroopMsgFin(z16, 0L, 0L);
        }
    }

    public void getDelSystemMsgError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 118)) {
            iPatchRedirector.redirect((short) 118, (Object) this);
        } else {
            onGetDelSystemMsgError();
        }
    }

    public void getDelSystemMsgFin(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 117)) {
            iPatchRedirector.redirect((short) 117, (Object) this, z16);
        } else {
            onGetDelSystemMsgFin(z16, false);
        }
    }

    public void getDiscussionMsgFin(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            iPatchRedirector.redirect((short) 100, (Object) this, z16);
        } else {
            onGetDiscussionMsgFin(z16);
        }
    }

    public void getGroupFirstMsgFin(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            iPatchRedirector.redirect((short) 92, (Object) this, z16);
        } else {
            onGetGroupFirstMsgFin(z16);
        }
    }

    public void getMsgFin(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            iPatchRedirector.redirect((short) 89, (Object) this, z16);
        } else {
            onGetMsgFin(z16);
        }
    }

    public void getOfflineFinish(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, z16);
        } else {
            onGetOfflineMsgFinished(z16);
        }
    }

    public void getOfflineStart(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, (Object) this, z16);
        } else {
            onGretOfflineMsgStart(z16);
        }
    }

    public void getPAFin(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            iPatchRedirector.redirect((short) 91, (Object) this, z16);
        } else {
            onGetPAMsgFin(z16);
        }
    }

    public void getRoamChat(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, this, Boolean.valueOf(z16), obj);
        } else {
            onUpdateGetRoamChat(z16, obj);
        }
    }

    public void getSuspiciousSystemMsgFin(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, this, Boolean.valueOf(z16), obj);
        } else {
            onGetSuspiciousSystemMsgFin(z16, false, (List) obj);
        }
    }

    public void getSystemMsgFin(boolean z16, boolean z17, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, this, Boolean.valueOf(z16), Boolean.valueOf(z17), list);
        } else {
            onGetSystemMsgFin(z16, z17, list);
        }
    }

    public void getTroopMsgFin(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, this, Boolean.valueOf(z16), objArr);
            return;
        }
        if (objArr != null && objArr.length > 0) {
            int length = objArr.length;
            String[] strArr = new String[length];
            for (int i3 = 0; i3 < length; i3++) {
                strArr[i3] = (String) objArr[i3];
            }
            onGetTroopMsgFin(z16, strArr);
            return;
        }
        onGetTroopMsgFin(z16, null);
    }

    public void handle_NOTIFY_TYPE_CONFESS_TMP(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 139)) {
            iPatchRedirector.redirect((short) 139, this, Boolean.valueOf(z16), objArr);
            return;
        }
        if (z16) {
            if (objArr != null && objArr.length >= 8) {
                onUpdateSendMsgError_confess((String) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), (SendMessageHandler) objArr[3], ((Long) objArr[4]).longValue(), ((Long) objArr[5]).longValue(), (String) objArr[6], ((Integer) objArr[7]).intValue());
                return;
            } else {
                if (objArr != null && objArr.length >= 4) {
                    onSendResult_confess(true, (String) objArr[0], ((Integer) objArr[1]).intValue(), ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                    return;
                }
                return;
            }
        }
        if (objArr != null && objArr.length >= 8) {
            onUpdateSendMsgError_confess((String) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), (SendMessageHandler) objArr[3], ((Long) objArr[4]).longValue(), ((Long) objArr[5]).longValue(), (String) objArr[6], ((Integer) objArr[7]).intValue());
        }
    }

    public void iPadOnlinesStatus(Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            iPatchRedirector.redirect((short) 107, (Object) this, (Object) objArr);
        } else if (objArr != null && objArr.length > 1) {
            onSelfIpadOnlineStatusUpdateNotify(((Byte) objArr[0]).byteValue(), ((Byte) objArr[1]).byteValue());
        }
    }

    public void macOnlinesStatus(Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 126)) {
            iPatchRedirector.redirect((short) 126, (Object) this, (Object) objArr);
        } else if (objArr != null && objArr.length > 1) {
            onSelfMacOnlineStatusUpdateNotify(((Byte) objArr[0]).byteValue(), ((Byte) objArr[1]).byteValue());
        }
    }

    public void msgDelFriend(Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, (Object) objArr);
        } else if (objArr != null && objArr.length > 2) {
            onUpdateMsgDelFriend((String) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
        }
    }

    public void msgRevokeRsp(boolean z16, Object[] objArr) {
        List<MessageRecord> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 119)) {
            iPatchRedirector.redirect((short) 119, this, Boolean.valueOf(z16), objArr);
            return;
        }
        if (objArr != null && objArr.length == 3) {
            list = (List) objArr[0];
            z18 = ((Boolean) objArr[1]).booleanValue();
            z17 = ((Boolean) objArr[2]).booleanValue();
        } else {
            list = null;
        }
        if (z17) {
            onLocalMsgRevokeNotice(z16, list, z18);
        } else {
            onMsgRevokeNotice(z16, list, z18);
        }
    }

    public void msgStartSendingUI(Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 123)) {
            iPatchRedirector.redirect((short) 123, (Object) this, (Object) objArr);
        } else if (objArr != null && objArr.length == 1) {
            onMsgStartSendingUI((String) objArr[0]);
        }
    }

    public void newMessageAdded(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 122)) {
            iPatchRedirector.redirect((short) 122, (Object) this, obj);
        } else if (obj != null && (obj instanceof List)) {
            onMessageRecordAdded((List) obj);
        }
    }

    public void newRegisterProxyFin(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            iPatchRedirector.redirect((short) 93, (Object) this, z16);
        } else {
            onNewRegisterProxyFin(z16);
        }
    }

    public void onBlessDirtyTextCheck(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    public void onBoxMsgUnreadNumRefresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this);
        }
    }

    public void onDanceMachineUploaded(MessageForDanceMachine messageForDanceMachine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) messageForDanceMachine);
        }
    }

    protected void onDeleteAllSysMsg(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 137)) {
            iPatchRedirector.redirect((short) 137, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    protected void onGetAllProxyTroopMsgFin(boolean z16, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    protected void onGetDelSystemMsgError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    protected void onGetDelSystemMsgFin(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onGetDiscussionMsgFin(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        }
    }

    protected void onGetGroupFirstMsgFin(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        }
    }

    protected void onGetMsgFin(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        }
    }

    protected void onGetOfflineMsgFinished(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, z16);
        }
    }

    protected void onGetPAMsgFin(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        }
    }

    public void onGetSubAccountMsg(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, Boolean.valueOf(z16), str, aVar);
        }
    }

    protected void onGetSuspiciousSystemMsgFin(boolean z16, boolean z17, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Boolean.valueOf(z17), list);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetSystemMsgFin(boolean z16, boolean z17, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Boolean.valueOf(z17), list);
        }
    }

    protected void onGetTempChatPic(boolean z16, RespTmpChatPicDownload respTmpChatPicDownload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), respTmpChatPicDownload);
        }
    }

    protected void onGetTroopMsgFin(boolean z16, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), strArr);
        }
    }

    protected void onGretOfflineMsgStart(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, z16);
        }
    }

    protected void onHiBoomAuthResult(int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 136)) {
            iPatchRedirector.redirect((short) 136, (Object) this, i3, (Object) bArr);
        }
    }

    protected void onInsertIntoBlackList(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 34)) {
            return;
        }
        iPatchRedirector.redirect((short) 34, this, Boolean.valueOf(z16), str);
    }

    public void onLocalMsgRevokeNotice(boolean z16, List<MessageRecord> list, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, this, Boolean.valueOf(z16), list, Boolean.valueOf(z17));
        }
    }

    public void onMessageRecordAdded(List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) list);
        }
    }

    public void onMsgForwardWXResult(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, i3);
        }
    }

    public void onMsgRevokeNotice(boolean z16, List<MessageRecord> list, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, this, Boolean.valueOf(z16), list, Boolean.valueOf(z17));
        }
    }

    public void onMsgStartSendingUI(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, (Object) str);
        }
    }

    protected void onNewRegisterProxyFin(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        }
    }

    public void onNotifyResultAfterSendRich(boolean z16, long j3, StatictisInfo statictisInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 133)) {
            iPatchRedirector.redirect((short) 133, this, Boolean.valueOf(z16), Long.valueOf(j3), statictisInfo);
        }
    }

    protected void onNotifyUpdateSelfMsgSeqAndTime(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) messageRecord);
        }
    }

    protected void onOnlineFileSessionNotify(boolean z16, String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2);
        }
    }

    public void onPushPCActiveNotice(boolean z16, String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, Boolean.valueOf(z16), str, str2, str3, str4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPushReadedNotify(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Boolean.valueOf(z16), obj);
        }
    }

    public void onPushSubAccountMsg(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, Boolean.valueOf(z16), str, aVar);
        }
    }

    protected void onPushUpdateLoginDevStatusNotify(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, i3);
        }
    }

    public void onReceiptMessageFetchReadStatusResult(long j3, int i3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, this, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16));
        }
    }

    public void onReceiptMessageReadReportResult(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, this, Long.valueOf(j3), Integer.valueOf(i3));
        }
    }

    protected void onRecvEmoticonRandomResult(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, str, Long.valueOf(j3));
        }
    }

    protected void onRefleshRecentListFinished(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, z16);
        }
    }

    protected void onRegisterProxyFin(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), obj);
        }
    }

    public void onRegisterProxyReceiving() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, (Object) this);
        }
    }

    protected void onRemoveFromBlackList(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) {
            return;
        }
        iPatchRedirector.redirect((short) 36, this, Boolean.valueOf(z16), str);
    }

    protected void onSelfIpadOnlineStatusUpdateNotify(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    protected void onSelfMacOnlineStatusUpdateNotify(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    protected void onSelfPcOnlineStatusUpdateNotify(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    protected void onSelfWatchOnlineStatusUpdateNotify(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    public void onSendBlessMsgResp(boolean z16, int i3, long j3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z17));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSendResult(boolean z16, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 131)) {
            return;
        }
        iPatchRedirector.redirect((short) 131, this, Boolean.valueOf(z16), str, Long.valueOf(j3));
    }

    protected void onSendResultWithTransInfo(boolean z16, msg_svc$TransSvrInfo msg_svc_transsvrinfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 138)) {
            iPatchRedirector.redirect((short) 138, this, Boolean.valueOf(z16), msg_svc_transsvrinfo);
        }
    }

    protected void onSendResult_confess(boolean z16, String str, int i3, long j3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 135)) {
            iPatchRedirector.redirect((short) 135, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSendSystemMsgActionError(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSendSystemMsgActionFin(boolean z16, String str, int i3, String str2, int i16, int i17, String str3, String str4, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2, Integer.valueOf(i16), Integer.valueOf(i17), str3, str4, Integer.valueOf(i18));
        }
    }

    public void onSubAccountMsgNumConfirm(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, Boolean.valueOf(z16), str, str2);
        }
    }

    public void onSubAccountThirdQQUnreadMsgNum(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, Boolean.valueOf(z16), str, bVar);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        Object[] objArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (obj instanceof Object[]) {
            objArr = (Object[]) obj;
        } else {
            objArr = null;
        }
        Object[] objArr2 = objArr;
        com.tencent.mobileqq.app.messageobserver.d dVar = sMap.get(Integer.valueOf(i3));
        if (dVar != null) {
            dVar.a(this, i3, z16, obj, objArr2, null);
        }
    }

    protected void onUpdateDelRoamChat(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        }
    }

    protected void onUpdateFriendsList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    protected void onUpdateGetRoamChat(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void onUpdateMsgContent(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str);
        }
    }

    protected void onUpdateMsgDelFriend(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    protected void onUpdateReceivedMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    protected void onUpdateRecentList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    protected void onUpdateRoamMsgSearchResult(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void onUpdateSecretfileStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 134)) {
            iPatchRedirector.redirect((short) 134, (Object) this);
        }
    }

    protected void onUpdateSendGetFriendSig(boolean z16, byte[] bArr, StatictisInfo statictisInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Boolean.valueOf(z16), bArr, statictisInfo);
        }
    }

    protected void onUpdateSendGetSig(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        }
    }

    protected void onUpdateSendMsgError(String str, int i3, int i16, SendMessageHandler sendMessageHandler, long j3, long j16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, str, Integer.valueOf(i3), Integer.valueOf(i16), sendMessageHandler, Long.valueOf(j3), Long.valueOf(j16), str2);
        }
    }

    protected void onUpdateSendMsgError_confess(String str, int i3, int i16, SendMessageHandler sendMessageHandler, long j3, long j16, String str2, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, Integer.valueOf(i3), Integer.valueOf(i16), sendMessageHandler, Long.valueOf(j3), Long.valueOf(j16), str2, Integer.valueOf(i17));
        }
    }

    protected void onUpdateSendOfflineFile(boolean z16, k.b bVar, StatictisInfo statictisInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Boolean.valueOf(z16), bVar, statictisInfo);
        }
    }

    protected void onUpdateSetOfflineFileState(boolean z16, k.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Boolean.valueOf(z16), bVar);
        }
    }

    protected void onUpdateSetRoamChat(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
        }
    }

    protected void onUpdateTroopList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    protected void onUpdateUploadStreamFinished(boolean z16, k.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), dVar);
        }
    }

    public void pcActiveNotify(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 116)) {
            iPatchRedirector.redirect((short) 116, this, Boolean.valueOf(z16), objArr);
        } else if (objArr != null && objArr.length == 4) {
            onPushPCActiveNotice(z16, (String) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3]);
        }
    }

    public void pcOnlinesStatus(Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            iPatchRedirector.redirect((short) 106, (Object) this, (Object) objArr);
        } else if (objArr != null && objArr.length > 1) {
            onSelfPcOnlineStatusUpdateNotify(((Byte) objArr[0]).byteValue(), ((Byte) objArr[1]).byteValue());
        }
    }

    public void pushReadedNotify(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, this, Boolean.valueOf(z16), obj);
        } else {
            onPushReadedNotify(z16, obj);
        }
    }

    public void pushUpdateLoginDevStatus(Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            iPatchRedirector.redirect((short) 108, (Object) this, (Object) objArr);
        } else if (objArr != null && objArr.length >= 1) {
            onPushUpdateLoginDevStatusNotify(((Byte) objArr[0]).byteValue());
        }
    }

    public void receiptErrorRsp(Long[] lArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 125)) {
            iPatchRedirector.redirect((short) 125, (Object) this, (Object) lArr);
        } else if (lArr[0].longValue() == 1) {
            onReceiptMessageReadReportResult(lArr[1].longValue(), lArr[2].intValue());
        } else {
            onReceiptMessageFetchReadStatusResult(lArr[1].longValue(), lArr[2].intValue(), 0L);
        }
    }

    public void receiptRead(Long[] lArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 124)) {
            iPatchRedirector.redirect((short) 124, (Object) this, (Object) lArr);
        } else if (lArr[0].longValue() == 1) {
            onReceiptMessageReadReportResult(lArr[1].longValue(), 0);
        } else {
            onReceiptMessageFetchReadStatusResult(lArr[1].longValue(), 0, lArr[2].longValue());
        }
    }

    public void recentListRefresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, (Object) this);
        } else {
            onUpdateRecentList();
        }
    }

    public void recvEmoticonRandomResult(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            iPatchRedirector.redirect((short) 95, this, Boolean.valueOf(z16), obj);
            return;
        }
        if (z16 && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                onRecvEmoticonRandomResult((String) objArr[0], ((MessageForAniSticker) objArr[1]).uniseq);
            }
        }
    }

    public void refreshRecentListFinish(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, z16);
        } else {
            onRefleshRecentListFinished(z16);
        }
    }

    public void registerProxyFin(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, this, Boolean.valueOf(z16), obj);
        } else {
            onRegisterProxyFin(z16, obj);
        }
    }

    public void reqBlessDirtyTextCheck(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 120)) {
            iPatchRedirector.redirect((short) 120, this, Boolean.valueOf(z16), objArr);
            return;
        }
        if (objArr != null && objArr.length == 1) {
            i3 = ((Integer) objArr[0]).intValue();
        }
        onBlessDirtyTextCheck(z16, i3);
    }

    public void reqBlessMsg(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 121)) {
            iPatchRedirector.redirect((short) 121, this, Boolean.valueOf(z16), objArr);
        } else if (objArr != null && objArr.length == 3) {
            onSendBlessMsgResp(z16, ((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue(), ((Boolean) objArr[2]).booleanValue());
        }
    }

    public void reqDeleteBlacklist(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            iPatchRedirector.redirect((short) 105, this, Boolean.valueOf(z16), objArr);
        } else if (objArr != null && objArr.length == 2) {
            onRemoveFromBlackList(z16, (String) objArr[0]);
            onRemoveFromBlackList(z16, (String) objArr[0], ((Integer) objArr[1]).intValue());
        }
    }

    public void reqInsertBlacklist(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            iPatchRedirector.redirect((short) 103, this, Boolean.valueOf(z16), obj);
        } else if (obj instanceof String) {
            onInsertIntoBlackList(z16, (String) obj);
        }
    }

    public void reqInsertBlacklistPB(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
            iPatchRedirector.redirect((short) 104, this, Boolean.valueOf(z16), obj);
        } else if (obj instanceof Object[]) {
            onInsertIntoBlackList(z16, (Object[]) obj);
        }
    }

    public void richSendNotifyMsg(boolean z16, Object[] objArr, StatictisInfo statictisInfo) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 109)) {
            iPatchRedirector.redirect((short) 109, this, Boolean.valueOf(z16), objArr, statictisInfo);
            return;
        }
        if (objArr != null && objArr.length >= 2) {
            j3 = ((Long) objArr[0]).longValue();
            statictisInfo = (StatictisInfo) objArr[1];
        } else {
            j3 = 0;
        }
        onNotifyResultAfterSendRich(z16, j3, statictisInfo);
    }

    public void roamMessageSearchInCloud(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, this, Boolean.valueOf(z16), obj);
        } else {
            onUpdateRoamMsgSearchResult(z16, obj);
        }
    }

    public void sendGetC2CSig(boolean z16, Object[] objArr, StatictisInfo statictisInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            iPatchRedirector.redirect((short) 97, this, Boolean.valueOf(z16), objArr, statictisInfo);
            return;
        }
        byte[] bArr = null;
        if (z16) {
            if (objArr != null && objArr.length >= 1) {
                bArr = (byte[]) objArr[0];
            }
            if (objArr != null && objArr.length >= 2) {
                statictisInfo = (StatictisInfo) objArr[1];
            }
            onUpdateSendGetFriendSig(z16, bArr, statictisInfo);
            return;
        }
        if (objArr != null && objArr.length >= 2) {
            statictisInfo = (StatictisInfo) objArr[1];
        }
        onUpdateSendGetFriendSig(z16, null, statictisInfo);
    }

    public void sendGetSig(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            iPatchRedirector.redirect((short) 96, (Object) this, z16);
        } else {
            onUpdateSendGetSig(z16);
        }
    }

    public void sendMsgError(Object[] objArr) {
        SendMessageHandler sendMessageHandler;
        long j3;
        long j16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, (Object) objArr);
            return;
        }
        if (objArr != null && objArr.length > 2) {
            String str2 = (String) objArr[0];
            int intValue = ((Integer) objArr[1]).intValue();
            int intValue2 = ((Integer) objArr[2]).intValue();
            if (objArr.length >= 6) {
                sendMessageHandler = (SendMessageHandler) objArr[3];
                j3 = ((Long) objArr[4]).longValue();
                j16 = ((Long) objArr[5]).longValue();
            } else {
                sendMessageHandler = null;
                j3 = 96000;
                j16 = 0;
            }
            long j17 = j16;
            long j18 = j3;
            SendMessageHandler sendMessageHandler2 = sendMessageHandler;
            if (objArr.length >= 7) {
                str = (String) objArr[6];
            } else {
                str = "";
            }
            onUpdateSendMsgError(str2, intValue, intValue2, sendMessageHandler2, j18, j17, str);
        }
    }

    public void sendOfflineFile(boolean z16, Object[] objArr, StatictisInfo statictisInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            iPatchRedirector.redirect((short) 98, this, Boolean.valueOf(z16), objArr, statictisInfo);
            return;
        }
        k.b bVar = null;
        if (z16) {
            if (objArr != null && objArr.length >= 1) {
                bVar = (k.b) objArr[0];
            }
            if (objArr != null && objArr.length >= 2) {
                statictisInfo = (StatictisInfo) objArr[1];
            }
            onUpdateSendOfflineFile(z16, bVar, statictisInfo);
            return;
        }
        if (objArr != null && objArr.length >= 2) {
            statictisInfo = (StatictisInfo) objArr[1];
        }
        onUpdateSendOfflineFile(z16, null, statictisInfo);
    }

    public void sendResult(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            iPatchRedirector.redirect((short) 94, this, Boolean.valueOf(z16), objArr);
        } else if (objArr != null) {
            if (objArr.length >= 3) {
                onSendResult(z16, (String) objArr[0], Long.parseLong((String) objArr[1]), (MessageHandlerConstants.MsgSendCostParams) objArr[2]);
            }
            onSendResult(z16, (String) objArr[0], Long.parseLong((String) objArr[1]));
        }
    }

    public void sendResultWithTransinfo(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 130)) {
            iPatchRedirector.redirect((short) 130, this, Boolean.valueOf(z16), obj);
        } else if (obj instanceof msg_svc$TransSvrInfo) {
            onSendResultWithTransInfo(z16, (msg_svc$TransSvrInfo) obj);
        }
    }

    public void sendSystemMsgActionError(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, (Object) this, (Object) toServiceMsg);
        } else {
            onSendSystemMsgActionError((String) toServiceMsg.getAttribute(BaseConstants.Attribute_TAG_LOGSTR));
        }
    }

    public void sendSystemMsgActionFin(boolean z16, ToServiceMsg toServiceMsg) {
        String str;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, this, Boolean.valueOf(z16), toServiceMsg);
            return;
        }
        String str4 = (String) toServiceMsg.getAttribute(BaseConstants.Attribute_TAG_LOGSTR);
        int i3 = toServiceMsg.extraData.getInt("system_msg_action_type");
        String string = toServiceMsg.extraData.getString("system_msg_action_resp_key");
        String string2 = toServiceMsg.extraData.getString("system_msg_action_resp_error_key");
        int i16 = toServiceMsg.extraData.getInt("system_msg_action_resp_result_code_key");
        int i17 = toServiceMsg.extraData.getInt("system_msg_action_resp_type_key");
        String string3 = toServiceMsg.extraData.getString("system_msg_action_resp_invalid_decided_key");
        int i18 = toServiceMsg.extraData.getInt("system_msg_action_resp_remark_result_key");
        if (string == null) {
            str = "";
        } else {
            str = string;
        }
        if (string2 == null) {
            str2 = "";
        } else {
            str2 = string2;
        }
        if (string3 == null) {
            str3 = "";
        } else {
            str3 = string3;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessageObserver", 2, "sendSystemMsgActionResult logStr=" + str4 + ";actionType=" + i3 + ";msgDetail=" + str + ";resultCode=" + i16 + ";respType=" + i17 + ";msgFail=" + str2 + ";msgInvalidDecided=" + str3 + ";remarkRet=" + i18);
        }
        onSendSystemMsgActionFin(z16, str4, i3, str, i16, i17, str2, str3, i18);
    }

    public void setOfflineFileState(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            iPatchRedirector.redirect((short) 99, this, Boolean.valueOf(z16), objArr);
            return;
        }
        k.b bVar = null;
        if (z16) {
            if (objArr != null && objArr.length >= 1) {
                bVar = (k.b) objArr[0];
            }
            onUpdateSetOfflineFileState(z16, bVar);
            return;
        }
        onUpdateSetOfflineFileState(z16, null);
    }

    public void setRoamChat(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, z16);
        } else {
            onUpdateSetRoamChat(z16);
        }
    }

    public void subaccountGetMsg(boolean z16, Object obj) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 113)) {
            iPatchRedirector.redirect((short) 113, this, Boolean.valueOf(z16), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessageObserver", 2, "onUpdate NOTIFY_TYPE_SUBACCOUNT_GET_MSG");
        }
        if (obj != null) {
            str = ((com.tencent.mobileqq.subaccount.logic.a) obj).f291124d;
        } else {
            str = null;
        }
        onGetSubAccountMsg(z16, str, (com.tencent.mobileqq.subaccount.logic.a) obj);
    }

    public void subaccountMsgNumReadedConfirm(boolean z16, Object obj) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 114)) {
            iPatchRedirector.redirect((short) 114, this, Boolean.valueOf(z16), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessageObserver", 2, "onUpdate NOTIFY_TYPE_SUBACCOUNT_MSG_NUM_READED_CONFIRM isSucc=" + z16 + " data=" + String.valueOf(obj));
        }
        if (obj instanceof String[]) {
            String[] strArr = (String[]) obj;
            if (strArr.length == 2) {
                str = strArr[0];
                str2 = strArr[1];
                onSubAccountMsgNumConfirm(z16, str, str2);
            }
        }
        str = null;
        str2 = null;
        onSubAccountMsgNumConfirm(z16, str, str2);
    }

    public void subaccountPushMsg(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 115)) {
            iPatchRedirector.redirect((short) 115, this, Boolean.valueOf(z16), obj);
        } else if (obj != null) {
            com.tencent.mobileqq.subaccount.logic.a aVar = (com.tencent.mobileqq.subaccount.logic.a) obj;
            onPushSubAccountMsg(z16, aVar.f291124d, aVar);
        }
    }

    public void transserviceC2CUploadStreamPtt(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            iPatchRedirector.redirect((short) 102, this, Boolean.valueOf(z16), objArr);
            return;
        }
        if (objArr != null && objArr.length >= 1) {
            onUpdateUploadStreamFinished(z16, (k.d) objArr[0]);
        } else if (QLog.isColorLevel()) {
            QLog.d(BuddyTransfileProcessor.STREAM_TAG_S, 2, "Stream ptt:UploadStreamStruct : arrayLength:" + Arrays.toString(objArr));
        }
    }

    public void transserviceTempChatDownloadPic(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, this, Boolean.valueOf(z16), objArr);
            return;
        }
        RespTmpChatPicDownload respTmpChatPicDownload = null;
        if (z16) {
            if (objArr != null && objArr.length > 0) {
                respTmpChatPicDownload = (RespTmpChatPicDownload) objArr[0];
            }
            onGetTempChatPic(z16, respTmpChatPicDownload);
            return;
        }
        onGetTempChatPic(z16, null);
    }

    public void troopListRefresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this);
        } else {
            onUpdateTroopList();
            onUpdateRecentList();
        }
    }

    public void updateSecretfileStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 111)) {
            iPatchRedirector.redirect((short) 111, (Object) this);
        } else {
            onUpdateSecretfileStatus();
        }
    }

    public void updateSelfMsgSeqAndTime(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 112)) {
            iPatchRedirector.redirect((short) 112, (Object) this, obj);
        } else if (obj instanceof MessageRecord) {
            onNotifyUpdateSelfMsgSeqAndTime((MessageRecord) obj);
        }
    }

    public void watchOnlineStatus(Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 127)) {
            iPatchRedirector.redirect((short) 127, (Object) this, (Object) objArr);
        } else if (objArr != null && objArr.length > 2) {
            onSelfWatchOnlineStatusUpdateNotify(((Byte) objArr[0]).byteValue(), ((Byte) objArr[1]).byteValue(), ((Integer) objArr[2]).intValue());
        }
    }

    protected void onInsertIntoBlackList(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 35)) {
            return;
        }
        iPatchRedirector.redirect((short) 35, this, Boolean.valueOf(z16), objArr);
    }

    protected void onRemoveFromBlackList(boolean z16, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 37)) {
            return;
        }
        iPatchRedirector.redirect((short) 37, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
    }

    protected void onSendResult(boolean z16, String str, long j3, MessageHandlerConstants.MsgSendCostParams msgSendCostParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 132)) {
            return;
        }
        iPatchRedirector.redirect((short) 132, this, Boolean.valueOf(z16), str, Long.valueOf(j3), msgSendCostParams);
    }
}
