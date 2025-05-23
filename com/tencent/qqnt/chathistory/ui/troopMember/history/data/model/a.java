package com.tencent.qqnt.chathistory.ui.troopMember.history.data.model;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.chathistory.ui.base.i;
import com.tencent.qqnt.chathistory.util.l;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.QueriedMsgInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\"\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u00a2\u0006\u0004\b8\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\t\u0010\b\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001e\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u0017\u0010#\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010(\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010$\u001a\u0004\b\u001c\u0010%\"\u0004\b&\u0010'R\u001f\u0010-\u001a\n )*\u0004\u0018\u00010\u00040\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\b+\u0010,R\u0017\u00100\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010.\u001a\u0004\b\u001f\u0010/R\u0017\u00102\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b+\u0010.\u001a\u0004\b1\u0010/R\u0017\u00104\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b3\u0010*\u001a\u0004\b3\u0010,R\u0017\u00106\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b5\u0010\u0018\u001a\u0004\b5\u0010\u001aR\u0014\u00107\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u001a\u00a8\u00069"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/model/a;", "Lcom/tencent/qqnt/chathistory/ui/base/i;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "k", "", "b", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/QueriedMsgInfo;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/QueriedMsgInfo;", "e", "()Lcom/tencent/qqnt/kernel/nativeinterface/QueriedMsgInfo;", "setInfo", "(Lcom/tencent/qqnt/kernel/nativeinterface/QueriedMsgInfo;)V", "info", "", "J", "f", "()J", "msgId", "c", "g", "msgSeq", "d", "I", "getChatType", "()I", "chatType", "Z", "()Z", "l", "(Z)V", "combine", "kotlin.jvm.PlatformType", "Ljava/lang/String;", h.F, "()Ljava/lang/String;", "peerName", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "displaySummary", "getDisplayNick", "displayNick", "i", "sendUId", "j", "sendUIn", "msgTime", "<init>", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class a implements i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QueriedMsgInfo info;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long msgId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long msgSeq;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int chatType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean combine;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String peerName;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence displaySummary;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence displayNick;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String sendUId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final long sendUIn;

    public a(@NotNull QueriedMsgInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) info);
            return;
        }
        this.info = info;
        MsgRecord msgRecord = info.msgRecord;
        this.msgId = msgRecord.msgId;
        this.msgSeq = msgRecord.msgSeq;
        this.chatType = msgRecord.chatType;
        this.combine = true;
        this.peerName = msgRecord.peerName;
        l lVar = l.f354063a;
        ArrayList<MsgAbstractElement> arrayList = info.msgAbstract.elements;
        String str = msgRecord.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "info.msgRecord.peerUid");
        String str2 = this.info.msgRecord.senderUid;
        Intrinsics.checkNotNullExpressionValue(str2, "info.msgRecord.senderUid");
        MsgRecord msgRecord2 = this.info.msgRecord;
        Intrinsics.checkNotNullExpressionValue(msgRecord2, "info.msgRecord");
        String k3 = k(msgRecord2);
        int i3 = this.info.msgRecord.chatType;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        this.displaySummary = l.b(lVar, arrayList, str, str2, k3, i3, context, null, this.info.msgRecord.anonymousExtInfo, 64, null);
        String str3 = this.info.msgRecord.sendNickName;
        Intrinsics.checkNotNullExpressionValue(str3, "info.msgRecord.sendNickName");
        this.displayNick = str3;
        String str4 = this.info.msgRecord.senderUid;
        Intrinsics.checkNotNullExpressionValue(str4, "info.msgRecord.senderUid");
        this.sendUId = str4;
        this.sendUIn = this.info.msgRecord.senderUin;
    }

    private final String k(MsgRecord msgRecord) {
        if (!TextUtils.isEmpty(msgRecord.sendMemberName)) {
            String str = msgRecord.sendMemberName;
            Intrinsics.checkNotNullExpressionValue(str, "msgRecord.sendMemberName");
            return str;
        }
        if (!TextUtils.isEmpty(msgRecord.sendRemarkName)) {
            String str2 = msgRecord.sendRemarkName;
            Intrinsics.checkNotNullExpressionValue(str2, "msgRecord.sendRemarkName");
            return str2;
        }
        if (!TextUtils.isEmpty(msgRecord.sendNickName)) {
            String str3 = msgRecord.sendNickName;
            Intrinsics.checkNotNullExpressionValue(str3, "msgRecord.sendNickName");
            return str3;
        }
        return String.valueOf(msgRecord.senderUin);
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.i
    /* renamed from: a */
    public long getMsgTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.info.msgRecord.msgTime;
    }

    @NotNull
    public final CharSequence b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (CharSequence) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        CharSequence f16 = en.f(BaseApplication.getContext(), 3, getMsgTime() * 1000, true, true);
        Intrinsics.checkNotNullExpressionValue(f16, "formatDateTime(\n        \u2026           true\n        )");
        return f16;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.combine;
    }

    @NotNull
    public final CharSequence d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (CharSequence) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.displaySummary;
    }

    @NotNull
    public final QueriedMsgInfo e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QueriedMsgInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.info;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if ((other instanceof a) && Intrinsics.areEqual(this.info, ((a) other).info)) {
            return true;
        }
        return false;
    }

    public final long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.msgId;
    }

    public final long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.msgSeq;
    }

    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.peerName;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.info.hashCode();
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.sendUId;
    }

    public final long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.sendUIn;
    }

    public final void l(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.combine = z16;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return "TroopMemberHistoryModel(info=" + this.info + ")";
    }
}
