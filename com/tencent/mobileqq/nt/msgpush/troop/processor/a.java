package com.tencent.mobileqq.nt.msgpush.troop.processor;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$GroupBusinessData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.nt_im_msg_body$ExtraInfo;
import tencent.im.msg.nt_im_msg_body$GeneralFlags;
import tencent.im.msg.nt_im_msg_body$PubGroup;
import tencent.im.msg.nt_im_msg_general_flags_body$ResvAttr;
import tencent.im.msg.nt_msg_common$Group;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020!\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010:\u0012\b\b\u0002\u0010B\u001a\u00020\u0007\u00a2\u0006\u0004\bC\u0010DJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017R\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017R\u0017\u0010%\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010*\u001a\u0004\u0018\u00010&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b\u000f\u0010)R\u0019\u0010/\u001a\u0004\u0018\u00010+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b\u001e\u0010.R\u0019\u00104\u001a\u0004\u0018\u0001008\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b\n\u00103R\u0019\u00109\u001a\u0004\u0018\u0001058\u0006\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b\u001b\u00108R\u0019\u0010>\u001a\u0004\u0018\u00010:8\u0006\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b\u0012\u0010=R\u0017\u0010B\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b'\u0010A\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/troop/processor/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "getMsgId", "()J", "msgId", "b", "getMsgSeq", "msgSeq", "c", "d", "msgTime", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "peerUin", "getPeerUid", "peerUid", "f", h.F, AppConstants.Key.COLUMN_MSG_SENDER_UIN, "g", "getSenderUid", "senderUid", "Lcom/tencent/qqnt/kernel/frequencycontrol/pb/FrequencyControlField$GroupBusinessData;", "Lcom/tencent/qqnt/kernel/frequencycontrol/pb/FrequencyControlField$GroupBusinessData;", "getOriginData", "()Lcom/tencent/qqnt/kernel/frequencycontrol/pb/FrequencyControlField$GroupBusinessData;", "originData", "Ltencent/im/msg/nt_im_msg_body$GeneralFlags;", "i", "Ltencent/im/msg/nt_im_msg_body$GeneralFlags;", "()Ltencent/im/msg/nt_im_msg_body$GeneralFlags;", "generalFlags", "Ltencent/im/msg/nt_im_msg_general_flags_body$ResvAttr;", "j", "Ltencent/im/msg/nt_im_msg_general_flags_body$ResvAttr;", "()Ltencent/im/msg/nt_im_msg_general_flags_body$ResvAttr;", "resvAttr", "Ltencent/im/msg/nt_im_msg_body$ExtraInfo;", "k", "Ltencent/im/msg/nt_im_msg_body$ExtraInfo;", "()Ltencent/im/msg/nt_im_msg_body$ExtraInfo;", "extraInfo", "Ltencent/im/msg/nt_im_msg_body$PubGroup;", "l", "Ltencent/im/msg/nt_im_msg_body$PubGroup;", "()Ltencent/im/msg/nt_im_msg_body$PubGroup;", "pubGroup", "Ltencent/im/msg/nt_msg_common$Group;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ltencent/im/msg/nt_msg_common$Group;", "()Ltencent/im/msg/nt_msg_common$Group;", "headGroupInfo", DomainData.DOMAIN_NAME, "Z", "()Z", "isOnlineMsg", "<init>", "(JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qqnt/kernel/frequencycontrol/pb/FrequencyControlField$GroupBusinessData;Ltencent/im/msg/nt_im_msg_body$GeneralFlags;Ltencent/im/msg/nt_im_msg_general_flags_body$ResvAttr;Ltencent/im/msg/nt_im_msg_body$ExtraInfo;Ltencent/im/msg/nt_im_msg_body$PubGroup;Ltencent/im/msg/nt_msg_common$Group;Z)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long msgId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long msgSeq;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long msgTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUid;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String senderUin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String senderUid;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrequencyControlField$GroupBusinessData originData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final nt_im_msg_body$GeneralFlags generalFlags;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final nt_im_msg_general_flags_body$ResvAttr resvAttr;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final nt_im_msg_body$ExtraInfo extraInfo;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final nt_im_msg_body$PubGroup pubGroup;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final nt_msg_common$Group headGroupInfo;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final boolean isOnlineMsg;

    public a(long j3, long j16, long j17, @NotNull String peerUin, @NotNull String peerUid, @NotNull String senderUin, @NotNull String senderUid, @NotNull FrequencyControlField$GroupBusinessData originData, @Nullable nt_im_msg_body$GeneralFlags nt_im_msg_body_generalflags, @Nullable nt_im_msg_general_flags_body$ResvAttr nt_im_msg_general_flags_body_resvattr, @Nullable nt_im_msg_body$ExtraInfo nt_im_msg_body_extrainfo, @Nullable nt_im_msg_body$PubGroup nt_im_msg_body_pubgroup, @Nullable nt_msg_common$Group nt_msg_common_group, boolean z16) {
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(senderUin, "senderUin");
        Intrinsics.checkNotNullParameter(senderUid, "senderUid");
        Intrinsics.checkNotNullParameter(originData, "originData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), peerUin, peerUid, senderUin, senderUid, originData, nt_im_msg_body_generalflags, nt_im_msg_general_flags_body_resvattr, nt_im_msg_body_extrainfo, nt_im_msg_body_pubgroup, nt_msg_common_group, Boolean.valueOf(z16));
            return;
        }
        this.msgId = j3;
        this.msgSeq = j16;
        this.msgTime = j17;
        this.peerUin = peerUin;
        this.peerUid = peerUid;
        this.senderUin = senderUin;
        this.senderUid = senderUid;
        this.originData = originData;
        this.generalFlags = nt_im_msg_body_generalflags;
        this.resvAttr = nt_im_msg_general_flags_body_resvattr;
        this.extraInfo = nt_im_msg_body_extrainfo;
        this.pubGroup = nt_im_msg_body_pubgroup;
        this.headGroupInfo = nt_msg_common_group;
        this.isOnlineMsg = z16;
    }

    @Nullable
    public final nt_im_msg_body$ExtraInfo a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (nt_im_msg_body$ExtraInfo) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.extraInfo;
    }

    @Nullable
    public final nt_im_msg_body$GeneralFlags b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (nt_im_msg_body$GeneralFlags) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.generalFlags;
    }

    @Nullable
    public final nt_msg_common$Group c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (nt_msg_common$Group) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.headGroupInfo;
    }

    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.msgTime;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.peerUin;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.msgId == aVar.msgId && this.msgSeq == aVar.msgSeq && this.msgTime == aVar.msgTime && Intrinsics.areEqual(this.peerUin, aVar.peerUin) && Intrinsics.areEqual(this.peerUid, aVar.peerUid) && Intrinsics.areEqual(this.senderUin, aVar.senderUin) && Intrinsics.areEqual(this.senderUid, aVar.senderUid) && Intrinsics.areEqual(this.originData, aVar.originData) && Intrinsics.areEqual(this.generalFlags, aVar.generalFlags) && Intrinsics.areEqual(this.resvAttr, aVar.resvAttr) && Intrinsics.areEqual(this.extraInfo, aVar.extraInfo) && Intrinsics.areEqual(this.pubGroup, aVar.pubGroup) && Intrinsics.areEqual(this.headGroupInfo, aVar.headGroupInfo) && this.isOnlineMsg == aVar.isOnlineMsg) {
            return true;
        }
        return false;
    }

    @Nullable
    public final nt_im_msg_body$PubGroup f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (nt_im_msg_body$PubGroup) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.pubGroup;
    }

    @Nullable
    public final nt_im_msg_general_flags_body$ResvAttr g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (nt_im_msg_general_flags_body$ResvAttr) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.resvAttr;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.senderUin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        int a16 = ((((((((((((((androidx.fragment.app.a.a(this.msgId) * 31) + androidx.fragment.app.a.a(this.msgSeq)) * 31) + androidx.fragment.app.a.a(this.msgTime)) * 31) + this.peerUin.hashCode()) * 31) + this.peerUid.hashCode()) * 31) + this.senderUin.hashCode()) * 31) + this.senderUid.hashCode()) * 31) + this.originData.hashCode()) * 31;
        nt_im_msg_body$GeneralFlags nt_im_msg_body_generalflags = this.generalFlags;
        int i3 = 0;
        if (nt_im_msg_body_generalflags == null) {
            hashCode = 0;
        } else {
            hashCode = nt_im_msg_body_generalflags.hashCode();
        }
        int i16 = (a16 + hashCode) * 31;
        nt_im_msg_general_flags_body$ResvAttr nt_im_msg_general_flags_body_resvattr = this.resvAttr;
        if (nt_im_msg_general_flags_body_resvattr == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = nt_im_msg_general_flags_body_resvattr.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        nt_im_msg_body$ExtraInfo nt_im_msg_body_extrainfo = this.extraInfo;
        if (nt_im_msg_body_extrainfo == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = nt_im_msg_body_extrainfo.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        nt_im_msg_body$PubGroup nt_im_msg_body_pubgroup = this.pubGroup;
        if (nt_im_msg_body_pubgroup == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = nt_im_msg_body_pubgroup.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        nt_msg_common$Group nt_msg_common_group = this.headGroupInfo;
        if (nt_msg_common_group != null) {
            i3 = nt_msg_common_group.hashCode();
        }
        int i26 = (i19 + i3) * 31;
        boolean z16 = this.isOnlineMsg;
        int i27 = z16;
        if (z16 != 0) {
            i27 = 1;
        }
        return i26 + i27;
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.isOnlineMsg;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return "TroopBusinessData(msgId=" + this.msgId + ", msgSeq=" + this.msgSeq + ", msgTime=" + this.msgTime + ", peerUin=" + this.peerUin + ", peerUid=" + this.peerUid + ", senderUin=" + this.senderUin + ", senderUid=" + this.senderUid + ", originData=" + this.originData + ", generalFlags=" + this.generalFlags + ", resvAttr=" + this.resvAttr + ", extraInfo=" + this.extraInfo + ", pubGroup=" + this.pubGroup + ", headGroupInfo=" + this.headGroupInfo + ", isOnlineMsg=" + this.isOnlineMsg + ")";
    }
}
