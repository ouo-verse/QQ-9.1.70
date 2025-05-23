package com.tencent.mobileqq.profilecard.bussiness.anonymous.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xec9.oidb_0xec9$ReqBody;
import tencent.im.oidb.cmd0xec9.oidb_0xec9$RspBody;
import tencent.im.oidb.cmd0xecf.oidb_0xecf$Quest;
import tencent.im.oidb.cmd0xecf.oidb_0xecf$ReqBody;
import tencent.im.oidb.cmd0xecf.oidb_0xecf$RspBody;
import tencent.im.oidb.cmd0xee5.oidb_0xee5$QuestTimes;
import tencent.im.oidb.cmd0xee5.oidb_0xee5$ReqBody;
import tencent.im.oidb.cmd0xee5.oidb_0xee5$RspBody;
import tencent.im.oidb.oidb_0xf15.oidb_0xf15$AddReply;
import tencent.im.oidb.oidb_0xf15.oidb_0xf15$AddRequest;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AnonymousHandler extends BusinessHandler {
    static IPatchRedirector $redirector_ = null;
    private static final int ACTION_TYPE_CANCEL = 2;
    private static final int ACTION_TYPE_LIKE = 1;
    public static final String CMD_BROWSE_ASK_ANONYMOUSLY_REPORT = "OidbSvc.0xee5";
    public static final String CMD_GET_LATEST_ANONYMOUS_INFO = "OidbSvc.0xecf";
    public static final String CMD_LIKE_ANONYMOUS_ANSWER = "OidbSvc.0xec9";
    public static final String CMD_REPLY_TROOP_ASK_ANONYMOUSLY = "OidbSvc.0xf15";
    private static final String TAG = "AnonymousHandler";

    protected AnonymousHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleBrowseAskAnonymouslyReport(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        boolean z17;
        if (toServiceMsg != null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            try {
                oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "handleBrowseAskAnonymouslyReport fail.", e16);
            }
            if (z17) {
                new MessageMicro<oidb_0xee5$RspBody>() { // from class: tencent.im.oidb.cmd0xee5.oidb_0xee5$RspBody
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_quest"}, new Object[]{null}, oidb_0xee5$RspBody.class);
                    public final PBRepeatMessageField<oidb_0xee5$QuestTimes> rpt_quest = PBField.initRepeatMessage(oidb_0xee5$QuestTimes.class);
                }.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                z16 = true;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, String.format("handleBrowseAskAnonymouslyReport success=%s", Boolean.valueOf(z16)));
                }
                notifyUI(2, z16, null);
            }
        }
        z16 = false;
        if (QLog.isColorLevel()) {
        }
        notifyUI(2, z16, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleGetLatestAnonymousInfo(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        Exception exc;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        boolean z17;
        long j3;
        boolean z18;
        long j16;
        if (toServiceMsg != null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            try {
                oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            } catch (Exception e16) {
                exc = e16;
                z16 = false;
            }
            if (z17) {
                oidb_0xecf$RspBody oidb_0xecf_rspbody = new oidb_0xecf$RspBody();
                oidb_0xecf_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                try {
                    oidb_0xecf$Quest oidb_0xecf_quest = oidb_0xecf_rspbody.msg_quest.get();
                    String str = oidb_0xecf_quest.str_id.get();
                    long j17 = 0;
                    if (oidb_0xecf_quest.uint64_praise_num.has()) {
                        j3 = oidb_0xecf_quest.uint64_praise_num.get();
                    } else {
                        j3 = 0;
                    }
                    if (oidb_0xecf_quest.uint64_been_praised.has() && oidb_0xecf_quest.uint64_been_praised.get() == 1) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (oidb_0xecf_quest.uint64_comment_num.has()) {
                        j16 = oidb_0xecf_quest.uint64_comment_num.get();
                    } else {
                        j16 = 0;
                    }
                    if (oidb_0xecf_quest.uint64_show_times.has()) {
                        j17 = oidb_0xecf_quest.uint64_show_times.get();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, String.format("handleGetLatestAnonymousInfo result data:questId=%s, praiseNum=%s, praised=%s, commentNum=%s, showTimes=%s:", str, Long.valueOf(j3), Boolean.valueOf(z18), Long.valueOf(j16), Long.valueOf(j17)));
                    }
                    notifyUI(3, true, new Object[]{str, Long.valueOf(j3), Boolean.valueOf(z18), Long.valueOf(j16), Long.valueOf(j17)});
                    z16 = true;
                } catch (Exception e17) {
                    exc = e17;
                    z16 = true;
                    QLog.e(TAG, 1, "handleGetLatestAnonymousInfo fail.", exc);
                    if (QLog.isColorLevel()) {
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, String.format("handleGetLatestAnonymousInfo success=%s", Boolean.valueOf(z16)));
                    return;
                }
                return;
            }
            notifyUI(3, false, null);
        } else {
            notifyUI(3, false, null);
        }
        z16 = false;
        if (QLog.isColorLevel()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleLikeAnonymousAnswer(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        boolean z17;
        if (toServiceMsg != null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            try {
                oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "handleGetOneWayFriendFlag fail.", e16);
            }
            if (z17) {
                new MessageMicro<oidb_0xec9$RspBody>() { // from class: tencent.im.oidb.cmd0xec9.oidb_0xec9$RspBody
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xec9$RspBody.class);
                }.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                z16 = true;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, String.format("handleLikeAnonymousAnswer success=%s", Boolean.valueOf(z16)));
                }
                notifyUI(1, z16, null);
            }
        }
        z16 = false;
        if (QLog.isColorLevel()) {
        }
        notifyUI(1, z16, null);
    }

    public void browseAskAnonymouslyReport(AnonymousQuestion anonymousQuestion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) anonymousQuestion);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("browserAskAnonymouslyReport question=%s", anonymousQuestion));
        }
        if (anonymousQuestion != null) {
            ArrayList arrayList = new ArrayList();
            oidb_0xee5$QuestTimes oidb_0xee5_questtimes = new oidb_0xee5$QuestTimes();
            oidb_0xee5_questtimes.str_quest_id.set(anonymousQuestion.mId);
            oidb_0xee5_questtimes.uint64_quest_time.set(anonymousQuestion.mQuestTime);
            oidb_0xee5_questtimes.uint64_show_times.set(0L);
            oidb_0xee5_questtimes.uint64_uin.set(anonymousQuestion.mOwnerUin);
            arrayList.add(oidb_0xee5_questtimes);
            oidb_0xee5$ReqBody oidb_0xee5_reqbody = new oidb_0xee5$ReqBody();
            oidb_0xee5_reqbody.rpt_quest.set(arrayList);
            sendPbReq(makeOIDBPkg(CMD_BROWSE_ASK_ANONYMOUSLY_REPORT, 3813, 2, oidb_0xee5_reqbody.toByteArray()));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(CMD_LIKE_ANONYMOUS_ANSWER);
            this.allowCmdSet.add(CMD_BROWSE_ASK_ANONYMOUSLY_REPORT);
            this.allowCmdSet.add(CMD_GET_LATEST_ANONYMOUS_INFO);
            this.allowCmdSet.add(CMD_REPLY_TROOP_ASK_ANONYMOUSLY);
        }
        return this.allowCmdSet;
    }

    public void getLatestAnonymousInfo(AnonymousQuestion anonymousQuestion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) anonymousQuestion);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("getLatestAnonymousInfo question=%s", anonymousQuestion));
        }
        if (anonymousQuestion != null) {
            oidb_0xecf$ReqBody oidb_0xecf_reqbody = new oidb_0xecf$ReqBody();
            oidb_0xecf_reqbody.str_quest_id.set(anonymousQuestion.mId);
            oidb_0xecf_reqbody.uint64_comment_num.set(0L);
            oidb_0xecf_reqbody.uint64_no_cache.set(0L);
            oidb_0xecf_reqbody.uint64_quest_time.set(anonymousQuestion.mQuestTime);
            oidb_0xecf_reqbody.uint64_uin.set(anonymousQuestion.mOwnerUin);
            sendPbReq(makeOIDBPkg(CMD_GET_LATEST_ANONYMOUS_INFO, 3791, 3, oidb_0xecf_reqbody.toByteArray()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleReplyTroopAskAnonymously(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            try {
                oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
            } catch (Exception e16) {
                e = e16;
                z17 = false;
            }
            if (z18) {
                oidb_0xf15$AddReply oidb_0xf15_addreply = new oidb_0xf15$AddReply();
                oidb_0xf15_addreply.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                try {
                    long j3 = oidb_0xf15_addreply.answer_id.get();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "handleReplyTroopAskAnonymously result");
                    }
                    notifyUI(4, true, Long.valueOf(j3));
                    z16 = true;
                } catch (Exception e17) {
                    e = e17;
                    z17 = true;
                    QLog.e(TAG, 1, "handleReplyTroopAskAnonymously fail.", e);
                    z16 = z17;
                    if (QLog.isColorLevel()) {
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, String.format("handleReplyTroopAskAnonymously success=%s", Boolean.valueOf(z16)));
                    return;
                }
                return;
            }
            QLog.e(TAG, 1, "handleReplyTroopAskAnonymously result = pkg.uint32_result.get().");
            notifyUI(4, false, null);
        } else {
            notifyUI(4, false, null);
        }
        z16 = false;
        if (QLog.isColorLevel()) {
        }
    }

    public void likeAnonymousAnswer(AnonymousQuestion anonymousQuestion, boolean z16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, anonymousQuestion, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("likeAnonymousAnswer question=%s like=%s", anonymousQuestion, Boolean.valueOf(z16)));
        }
        if (anonymousQuestion != null) {
            oidb_0xec9$ReqBody oidb_0xec9_reqbody = new oidb_0xec9$ReqBody();
            oidb_0xec9_reqbody.uint64_uin.set(anonymousQuestion.mOwnerUin);
            oidb_0xec9_reqbody.str_quest_id.set(anonymousQuestion.mId);
            oidb_0xec9_reqbody.str_like_key.set(anonymousQuestion.mPraiseKey);
            PBUInt64Field pBUInt64Field = oidb_0xec9_reqbody.uint64_act_type;
            if (z16) {
                j3 = 1;
            } else {
                j3 = 2;
            }
            pBUInt64Field.set(j3);
            oidb_0xec9_reqbody.uint64_quest_time.set(anonymousQuestion.mQuestTime);
            sendPbReq(makeOIDBPkg(CMD_LIKE_ANONYMOUS_ANSWER, 3785, 1, oidb_0xec9_reqbody.toByteArray()));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return AnonymousObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        if (CMD_LIKE_ANONYMOUS_ANSWER.equals(serviceCmd)) {
            handleLikeAnonymousAnswer(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (CMD_BROWSE_ASK_ANONYMOUSLY_REPORT.equals(serviceCmd)) {
            handleBrowseAskAnonymouslyReport(toServiceMsg, fromServiceMsg, obj);
        } else if (CMD_GET_LATEST_ANONYMOUS_INFO.equals(serviceCmd)) {
            handleGetLatestAnonymousInfo(toServiceMsg, fromServiceMsg, obj);
        } else if (CMD_REPLY_TROOP_ASK_ANONYMOUSLY.equals(serviceCmd)) {
            handleReplyTroopAskAnonymously(toServiceMsg, fromServiceMsg, obj);
        }
    }

    public void replyTroopAskAnonymously(long j3, long j16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), Long.valueOf(j16), str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("replyTroopAskAnonymously groupCode=%s questId=%s reply=%s", Long.valueOf(j3), Long.valueOf(j16), str));
        }
        oidb_0xf15$AddRequest oidb_0xf15_addrequest = new oidb_0xf15$AddRequest();
        oidb_0xf15_addrequest.group_code.set(j3);
        oidb_0xf15_addrequest.question_id.set(j16);
        oidb_0xf15_addrequest.reply.set(str);
        sendPbReq(makeOIDBPkg(CMD_REPLY_TROOP_ASK_ANONYMOUSLY, 3861, 1, oidb_0xf15_addrequest.toByteArray()));
    }
}
