package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.c;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.bt;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecentItemConfessMsg extends RecentBaseData {
    static IPatchRedirector $redirector_;
    public final ConfessInfo mConfessInfo;
    public MessageRecord mMsg;
    public int mType;
    public String mUin;

    /* renamed from: msg, reason: collision with root package name */
    public Message f185393msg;

    public RecentItemConfessMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mConfessInfo = new ConfessInfo();
        this.mUin = "";
        this.mType = 0;
        this.mMsg = null;
        this.f185393msg = null;
    }

    public void a(QQAppInterface qQAppInterface, Context context) {
        String currentNickname;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) qQAppInterface, (Object) context);
            return;
        }
        if (qQAppInterface != null && context != null) {
            if (this.mType == 1032 && TextUtils.equals(this.mUin, AppConstants.CONFESS_FRD_REC_UIN)) {
                MsgSummary msgSummaryTemp = getMsgSummaryTemp();
                String g16 = ac.g(qQAppInterface, this.mMsg.senderuin, true);
                if (TextUtils.equals(g16, this.mMsg.senderuin) && !TextUtils.isEmpty(this.mMsg.msg2)) {
                    g16 = this.mMsg.msg2;
                }
                msgSummaryTemp.strContent = String.format(HardCodeUtil.qqStr(R.string.sub), g16, this.mMsg.f203106msg);
                this.mTitleName = HardCodeUtil.qqStr(R.string.su6);
                this.mDisplayTime = this.mMsg.time;
                this.mUnreadNum = this.mMsg.longMsgCount;
                this.mUnreadFlag = 3;
                extraUpdate(qQAppInterface, context, msgSummaryTemp);
                makeContentDesc();
                return;
            }
            if (this.f185393msg == null) {
                return;
            }
            MsgSummary msgSummaryTemp2 = getMsgSummaryTemp();
            int i3 = this.mType;
            if (i3 == 1033) {
                String g17 = ac.g(qQAppInterface, this.mUin, true);
                if (TextUtils.isEmpty(this.mConfessInfo.topic)) {
                    this.mTitleName = g17;
                } else {
                    if (g17 != null && g17.length() > 7) {
                        g17 = c.b(g17, 7.0f);
                    }
                    this.mTitleName = String.format(Locale.getDefault(), "%s\u2014%s", g17, this.mConfessInfo.topic);
                }
            } else if (i3 == 1034) {
                this.mTitleName = this.mConfessInfo.confessorNick;
                if (this.f185393msg.msgtype == -2066) {
                    currentNickname = qQAppInterface.getCurrentNickname();
                    if (currentNickname.length() > 7) {
                        currentNickname = c.b(currentNickname, 7.0f);
                    }
                    this.mUnreadNum = qQAppInterface.getConversationFacade().S(this.mUin, this.mType, this.mConfessInfo.topicId);
                    this.mUnreadFlag = 1;
                    this.mDisplayTime = this.f185393msg.time;
                    this.mMenuFlag = 1;
                    this.mStatus = 0;
                    Message message = this.f185393msg;
                    bt.b(context, qQAppInterface, message, message.istroop, msgSummaryTemp2, currentNickname, false, false);
                    msgSummaryTemp2.bShowDraft = false;
                    extraUpdate(qQAppInterface, context, msgSummaryTemp2);
                    makeContentDesc();
                }
            } else {
                this.mTitleName = ac.g(qQAppInterface, this.mUin, true);
            }
            currentNickname = "";
            this.mUnreadNum = qQAppInterface.getConversationFacade().S(this.mUin, this.mType, this.mConfessInfo.topicId);
            this.mUnreadFlag = 1;
            this.mDisplayTime = this.f185393msg.time;
            this.mMenuFlag = 1;
            this.mStatus = 0;
            Message message2 = this.f185393msg;
            bt.b(context, qQAppInterface, message2, message2.istroop, msgSummaryTemp2, currentNickname, false, false);
            msgSummaryTemp2.bShowDraft = false;
            extraUpdate(qQAppInterface, context, msgSummaryTemp2);
            makeContentDesc();
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public long getLastDraftTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public long getLastMsgTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        MessageRecord messageRecord = this.mMsg;
        if (messageRecord == null) {
            return 0L;
        }
        return messageRecord.time;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public int getRecentUserType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mType;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public String getRecentUserUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mUin;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public void update(BaseQQAppInterface baseQQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) baseQQAppInterface, (Object) context);
        } else if (baseQQAppInterface instanceof QQAppInterface) {
            a((QQAppInterface) baseQQAppInterface, context);
        }
    }
}
