package com.tencent.mobileqq.reminder.db.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import tencent.im.s2c.msgtype0x210.submsgtype0x13a.submsgtype0x13a$MsgBody;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/reminder/db/entity/PushReminderRecord;", "Lcom/tencent/mobileqq/reminder/db/entity/RemindWithBodyRecord;", "Ltencent/im/s2c/msgtype0x210/submsgtype0x13a/submsgtype0x13a$MsgBody;", "createMsgBody", "<init>", "()V", "Companion", "a", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class PushReminderRecord extends RemindWithBodyRecord<submsgtype0x13a$MsgBody> {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final a Companion;

    @Deprecated
    @NotNull
    public static final String TAG = "PushReminderRecord";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/reminder/db/entity/PushReminderRecord$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23905);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            Companion = new a(null);
        }
    }

    public PushReminderRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.entity.RemindWithBodyRecord, com.tencent.mobileqq.reminder.db.c
    @NotNull
    public submsgtype0x13a$MsgBody createMsgBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (submsgtype0x13a$MsgBody) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        submsgtype0x13a$MsgBody submsgtype0x13a_msgbody = new submsgtype0x13a$MsgBody();
        submsgtype0x13a_msgbody.mergeFrom(this.msgData);
        String stringUtf8 = submsgtype0x13a_msgbody.msg_system_notify.bytes_msg_summary.get().toStringUtf8();
        com.tencent.mobileqq.reminder.db.a.d(TAG, "parseMsg: " + stringUtf8, null, 4, null);
        this.f281037msg = stringUtf8;
        return submsgtype0x13a_msgbody;
    }
}
