package com.tencent.mobileqq.reminder.db;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0000\u001a&\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0000\u001a&\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0000*\u00020\u0000H\u0002\u001a\f\u0010\u000b\u001a\u00020\n*\u00020\tH\u0000\u001a\f\u0010\r\u001a\u00020\n*\u00020\fH\u0000\u00a8\u0006\u000e"}, d2 = {"", "tag", "msg", "", "e", "", h.F, "c", "a", "Lcom/tencent/mobileqq/reminder/db/b;", "Lcom/tencent/mobileqq/reminder/db/entity/b;", "g", "Lcom/tencent/imcore/message/Message;", "f", "qqreminder-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u000f8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0018\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\u0017R(\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u000f8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R$\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\r\u00a8\u0006\u001f"}, d2 = {"com/tencent/mobileqq/reminder/db/a$a", "Lcom/tencent/mobileqq/reminder/db/entity/b;", "", "a", "", "getMsgType", "()I", QQBrowserActivity.KEY_MSG_TYPE, "", "value", "getUniseq", "()J", "setUniseq", "(J)V", "uniseq", "", "getFrienduin", "()Ljava/lang/String;", "setFrienduin", "(Ljava/lang/String;)V", "frienduin", "getIstroop", "setIstroop", "(I)V", AppConstants.Key.COLUMN_IS_TROOP, "getMsg", "setMsg", "msg", "getTime", "setTime", "time", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.db.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C8508a implements com.tencent.mobileqq.reminder.db.entity.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.reminder.db.b f281035a;

        C8508a(com.tencent.mobileqq.reminder.db.b bVar) {
            this.f281035a = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            }
        }

        @Override // com.tencent.mobileqq.reminder.db.entity.b
        @NotNull
        public Object a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return this.f281035a;
        }

        @Override // com.tencent.mobileqq.reminder.db.entity.b
        @Nullable
        public String getFrienduin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.f281035a.getFrienduin();
        }

        @Override // com.tencent.mobileqq.reminder.db.entity.b
        public int getIstroop() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.f281035a.getIstroop();
        }

        @Override // com.tencent.mobileqq.reminder.db.entity.b
        @Nullable
        public String getMsg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.f281035a.getMsg();
        }

        @Override // com.tencent.mobileqq.reminder.db.entity.b
        public int getMsgType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f281035a.getMsgtype();
        }

        @Override // com.tencent.mobileqq.reminder.db.entity.b
        public long getTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
            }
            return this.f281035a.getTime();
        }

        @Override // com.tencent.mobileqq.reminder.db.entity.b
        public long getUniseq() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.f281035a.getUniseq();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u000f8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0018\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\u0017R(\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u000f8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R$\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\r\u00a8\u0006\u001f"}, d2 = {"com/tencent/mobileqq/reminder/db/a$b", "Lcom/tencent/mobileqq/reminder/db/entity/b;", "", "a", "", "getMsgType", "()I", QQBrowserActivity.KEY_MSG_TYPE, "", "value", "getUniseq", "()J", "setUniseq", "(J)V", "uniseq", "", "getFrienduin", "()Ljava/lang/String;", "setFrienduin", "(Ljava/lang/String;)V", "frienduin", "getIstroop", "setIstroop", "(I)V", AppConstants.Key.COLUMN_IS_TROOP, "getMsg", "setMsg", "msg", "getTime", "setTime", "time", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.mobileqq.reminder.db.entity.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Message f281036a;

        b(Message message) {
            this.f281036a = message;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) message);
            }
        }

        @Override // com.tencent.mobileqq.reminder.db.entity.b
        @NotNull
        public Object a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return this.f281036a;
        }

        @Override // com.tencent.mobileqq.reminder.db.entity.b
        @Nullable
        public String getFrienduin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.f281036a.frienduin;
        }

        @Override // com.tencent.mobileqq.reminder.db.entity.b
        public int getIstroop() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.f281036a.istroop;
        }

        @Override // com.tencent.mobileqq.reminder.db.entity.b
        @Nullable
        public String getMsg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.f281036a.f203106msg;
        }

        @Override // com.tencent.mobileqq.reminder.db.entity.b
        public int getMsgType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f281036a.msgtype;
        }

        @Override // com.tencent.mobileqq.reminder.db.entity.b
        public long getTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
            }
            return this.f281036a.time;
        }

        @Override // com.tencent.mobileqq.reminder.db.entity.b
        public long getUniseq() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.f281036a.uniseq;
        }
    }

    public static final void a(@NotNull String tag, @NotNull String msg2, @Nullable Throwable th5) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (!QLog.isColorLevel()) {
            return;
        }
        h(tag, msg2, th5);
    }

    public static /* synthetic */ void b(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        a(str, str2, th5);
    }

    public static final void c(@NotNull String tag, @NotNull String msg2, @Nullable Throwable th5) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (QLog.isDevelopLevel()) {
            if (th5 != null) {
                QLog.d(e(tag), 4, msg2, th5);
            } else {
                QLog.d(e(tag), 4, msg2);
            }
        }
    }

    public static /* synthetic */ void d(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        c(str, str2, th5);
    }

    private static final String e(String str) {
        return "RemindEngine:" + str;
    }

    @NotNull
    public static final com.tencent.mobileqq.reminder.db.entity.b f(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "<this>");
        return new b(message);
    }

    @NotNull
    public static final com.tencent.mobileqq.reminder.db.entity.b g(@NotNull com.tencent.mobileqq.reminder.db.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        return new C8508a(bVar);
    }

    public static final void h(@NotNull String tag, @NotNull String msg2, @Nullable Throwable th5) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.i(e(tag), 1, msg2);
    }

    public static /* synthetic */ void i(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        h(str, str2, th5);
    }
}
