package com.tencent.mobileqq.reminder.db.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/reminder/db/entity/c;", "", "", "cMsgType", "Lcom/tencent/mobileqq/reminder/db/entity/ReminderRecord;", "default", "a", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f281040a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27091);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f281040a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ ReminderRecord b(c cVar, int i3, ReminderRecord reminderRecord, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            reminderRecord = null;
        }
        return cVar.a(i3, reminderRecord);
    }

    @NotNull
    public final ReminderRecord a(int cMsgType, @Nullable ReminderRecord r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ReminderRecord) iPatchRedirector.redirect((short) 2, (Object) this, cMsgType, (Object) r56);
        }
        if (cMsgType != -7090) {
            if (cMsgType != -5003) {
                if (r56 == null) {
                    r56 = new ReminderRecord();
                }
            } else {
                r56 = new ActivateFriendsRecord();
            }
        } else {
            r56 = new PushReminderRecord();
        }
        r56.msgtype = cMsgType;
        return r56;
    }
}
