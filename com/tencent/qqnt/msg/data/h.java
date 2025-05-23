package com.tencent.qqnt.msg.data;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.common.nt_msg_common$Msg;
import tencent.im.msg.nt_sys_msg_common$Msg;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\t\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/msg/data/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getBusinessType", "()I", "businessType", "", "b", "J", "d", "()J", QQBrowserActivity.KEY_MSG_TYPE, "c", "msgSubType", "Ltencent/im/common/nt_msg_common$Msg;", "Ltencent/im/common/nt_msg_common$Msg;", "()Ltencent/im/common/nt_msg_common$Msg;", "msg", "Ltencent/im/msg/nt_sys_msg_common$Msg;", "e", "Ltencent/im/msg/nt_sys_msg_common$Msg;", "()Ltencent/im/msg/nt_sys_msg_common$Msg;", "c2c_group_msg", "<init>", "(IJJLtencent/im/common/nt_msg_common$Msg;Ltencent/im/msg/nt_sys_msg_common$Msg;)V", "msg_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final /* data */ class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int businessType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long msgType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long msgSubType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final nt_msg_common$Msg msg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final nt_sys_msg_common$Msg c2c_group_msg;

    public h(int i3, long j3, long j16, @Nullable nt_msg_common$Msg nt_msg_common_msg, @Nullable nt_sys_msg_common$Msg nt_sys_msg_common_msg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), nt_msg_common_msg, nt_sys_msg_common_msg);
            return;
        }
        this.businessType = i3;
        this.msgType = j3;
        this.msgSubType = j16;
        this.msg = nt_msg_common_msg;
        this.c2c_group_msg = nt_sys_msg_common_msg;
    }

    @Nullable
    public final nt_sys_msg_common$Msg a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (nt_sys_msg_common$Msg) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.c2c_group_msg;
    }

    @Nullable
    public final nt_msg_common$Msg b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (nt_msg_common$Msg) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.msg;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.msgSubType;
    }

    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.msgType;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof h)) {
            return false;
        }
        h hVar = (h) other;
        if (this.businessType == hVar.businessType && this.msgType == hVar.msgType && this.msgSubType == hVar.msgSubType && Intrinsics.areEqual(this.msg, hVar.msg) && Intrinsics.areEqual(this.c2c_group_msg, hVar.c2c_group_msg)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        int a16 = ((((this.businessType * 31) + androidx.fragment.app.a.a(this.msgType)) * 31) + androidx.fragment.app.a.a(this.msgSubType)) * 31;
        nt_msg_common$Msg nt_msg_common_msg = this.msg;
        int i3 = 0;
        if (nt_msg_common_msg == null) {
            hashCode = 0;
        } else {
            hashCode = nt_msg_common_msg.hashCode();
        }
        int i16 = (a16 + hashCode) * 31;
        nt_sys_msg_common$Msg nt_sys_msg_common_msg = this.c2c_group_msg;
        if (nt_sys_msg_common_msg != null) {
            i3 = nt_sys_msg_common_msg.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "SysMsgNotificationData(businessType=" + this.businessType + ", msgType=" + this.msgType + ", msgSubType=" + this.msgSubType + ", msg=" + this.msg + ", c2c_group_msg=" + this.c2c_group_msg + ")";
    }
}
