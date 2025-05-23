package com.tencent.mobileqq.reminder.db.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0005\u001a\u00020\u0004H\u0004J\b\u0010\u0006\u001a\u00020\u0004H\u0004J\b\u0010\u0007\u001a\u00020\u0004H\u0004J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00028\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/reminder/db/entity/RemindWithBodyRecord;", "T", "Lcom/tencent/mobileqq/reminder/db/entity/ReminderRecord;", "Lcom/tencent/mobileqq/reminder/db/c;", "", "prewrite", "postRead", "postwrite", "body", "setMsgBody", "(Ljava/lang/Object;)V", "getMsgBody", "()Ljava/lang/Object;", "mMsgBody", "Ljava/lang/Object;", "getMMsgBody", "setMMsgBody", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class RemindWithBodyRecord<T> extends ReminderRecord implements com.tencent.mobileqq.reminder.db.c<T> {
    static IPatchRedirector $redirector_;

    @Nullable
    private T mMsgBody;

    public RemindWithBodyRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract /* synthetic */ T createMsgBody() throws Exception;

    @Nullable
    public final T getMMsgBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mMsgBody;
    }

    @Override // com.tencent.mobileqq.reminder.db.c
    @Nullable
    public final T getMsgBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (T) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (this.mMsgBody == null) {
            try {
                this.mMsgBody = createMsgBody();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("RemindWithBodyRecord", 2, "Message parse error.", e16);
                }
            }
        }
        return this.mMsgBody;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.reminder.db.entity.ReminderRecord, com.tencent.mobileqq.persistence.Entity
    public final void postRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            createMsgBody();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public final void postwrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.reminder.db.entity.ReminderRecord, com.tencent.mobileqq.persistence.Entity
    public final void prewrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public final void setMMsgBody(@Nullable T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) t16);
        } else {
            this.mMsgBody = t16;
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.c
    public final void setMsgBody(T body) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) body);
        } else {
            this.mMsgBody = body;
        }
    }
}
