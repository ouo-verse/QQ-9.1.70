package com.tencent.mobileqq.reminder.db.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi;
import com.tencent.mobileqq.reminder.db.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76$MsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/reminder/db/entity/ActivateFriendsRecord;", "Lcom/tencent/mobileqq/reminder/db/entity/RemindWithBodyRecord;", "Ltencent/im/s2c/msgtype0x210/submsgtype0x76/SubMsgType0x76$MsgBody;", "()V", "createMsgBody", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class ActivateFriendsRecord extends RemindWithBodyRecord<SubMsgType0x76$MsgBody> {
    static IPatchRedirector $redirector_;

    public ActivateFriendsRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
    
        if (r1 != null) goto L15;
     */
    @Override // com.tencent.mobileqq.reminder.db.entity.RemindWithBodyRecord, com.tencent.mobileqq.reminder.db.c
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SubMsgType0x76$MsgBody createMsgBody() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SubMsgType0x76$MsgBody) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        SubMsgType0x76$MsgBody subMsgType0x76$MsgBody = new SubMsgType0x76$MsgBody();
        subMsgType0x76$MsgBody.mergeFrom(this.msgData);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "peekAppRuntime()");
            IQQReminderRecordFacadeApi a16 = d.a(peekAppRuntime);
            if (a16 != null) {
                str = a16.getMessageDescrpition(subMsgType0x76$MsgBody);
            }
        }
        str = "";
        this.f281037msg = str;
        return subMsgType0x76$MsgBody;
    }
}
