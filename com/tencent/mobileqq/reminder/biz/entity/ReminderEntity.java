package com.tencent.mobileqq.reminder.biz.entity;

import Wallet.AcsMsg;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.reminder.util.QQReminderUtil;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ReminderEntity extends Entity implements a {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "ReminderEntity.class";
    private boolean hasReminded;

    @notColumn
    private AcsMsg mAcsMsg;

    @unique
    public String mKey;
    public byte[] mMsgDate;
    public String mMsgId;
    public long mReminderTime;

    public ReminderEntity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void acsMsgExtract() {
        AcsMsg acsMsg = this.mAcsMsg;
        this.mMsgId = acsMsg.msg_id;
        this.mReminderTime = acsMsg.notice_time;
        this.mKey = QQReminderUtil.p(acsMsg);
    }

    private void acsMsgPack() {
        AcsMsg acsMsg = this.mAcsMsg;
        acsMsg.msg_id = this.mMsgId;
        acsMsg.notice_time = this.mReminderTime;
    }

    @Override // com.tencent.mobileqq.reminder.biz.entity.a
    public AcsMsg getAcsMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AcsMsg) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mAcsMsg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.postRead();
        JceInputStream jceInputStream = new JceInputStream(this.mMsgDate);
        jceInputStream.setServerEncoding("utf-8");
        AcsMsg acsMsg = new AcsMsg();
        this.mAcsMsg = acsMsg;
        acsMsg.readFrom(jceInputStream);
        acsMsgPack();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.prewrite();
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding("utf-8");
        acsMsgExtract();
        this.mAcsMsg.writeTo(jceOutputStream);
        this.mMsgDate = jceOutputStream.toByteArray();
    }

    public void setAcsMsg(AcsMsg acsMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) acsMsg);
        } else {
            this.mAcsMsg = acsMsg;
            acsMsgExtract();
        }
    }
}
