package com.tencent.mobileqq.aio.animation.data;

import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgElement;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgNamePlate;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/data/c;", "Lcom/tencent/mobileqq/aio/animation/data/b;", "", "getMsgId", "getMsgSeq", "", "getSenderUid", "getSenderUin", "getPeerUin", "getPeerUid", "e", "", "d", "", "c", "b", "f", "a", "getChatType", "getVipType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgRecord msgRecord;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/data/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.data.c$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29739);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
        } else {
            this.msgRecord = msgRecord;
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.data.b
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.aio.animation.data.b
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return MsgExtKt.S(this.msgRecord);
    }

    @Override // com.tencent.mobileqq.aio.animation.data.b
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.aio.animation.data.b
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        MsgRecord msgRecord = this.msgRecord;
        if (msgRecord.msgType != 2) {
            return false;
        }
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            int i3 = ((MsgElement) it.next()).elementType;
            if (i3 != 1 && i3 != 6) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.animation.data.b
    @NotNull
    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        ArrayList<MsgElement> arrayList = this.msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        for (MsgElement msgElement : arrayList) {
            int i3 = msgElement.elementType;
            if (i3 != 1) {
                if (i3 == 6) {
                    sb5.append(QQSysFaceUtil.getFaceString(QQSysFaceUtil.convertToLocal(msgElement.faceElement.faceIndex)));
                }
            } else {
                sb5.append(msgElement.textElement.content);
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "content.toString()");
        return sb6;
    }

    @Override // com.tencent.mobileqq.aio.animation.data.b
    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        boolean z16 = !com.tencent.qqnt.aio.msg.d.N(this.msgRecord);
        if (!z16 && QLog.isDevelopLevel()) {
            QLog.d("AIOMsgImpl", 4, "msg not support: " + this.msgRecord.msgId);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.aio.animation.data.b
    public int getChatType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.msgRecord.chatType;
    }

    @Override // com.tencent.mobileqq.aio.animation.data.b
    public long getMsgId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.msgRecord.msgId;
    }

    @Override // com.tencent.mobileqq.aio.animation.data.b
    public long getMsgSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        MsgRecord msgRecord = this.msgRecord;
        long j3 = msgRecord.msgSeq;
        if (j3 == 0) {
            return msgRecord.msgId;
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.aio.animation.data.b
    @NotNull
    public String getPeerUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        String str = this.msgRecord.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.peerUid");
        return str;
    }

    @Override // com.tencent.mobileqq.aio.animation.data.b
    public long getPeerUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.msgRecord.peerUin;
    }

    @Override // com.tencent.mobileqq.aio.animation.data.b
    @NotNull
    public String getSenderUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String str = this.msgRecord.senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.senderUid");
        return str;
    }

    @Override // com.tencent.mobileqq.aio.animation.data.b
    public long getSenderUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.msgRecord.senderUin;
    }

    @Override // com.tencent.mobileqq.aio.animation.data.b
    public int getVipType() {
        Integer num;
        MsgAttributeInfo msgAttributeInfo;
        VASMsgElement vASMsgElement;
        VASMsgNamePlate vASMsgNamePlate;
        MsgAttributeInfo msgAttributeInfo2;
        VASMsgElement vASMsgElement2;
        VASMsgNamePlate vASMsgNamePlate2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        HashMap<Integer, MsgAttributeInfo> hashMap = this.msgRecord.msgAttrs;
        if (hashMap == null || (msgAttributeInfo2 = hashMap.get(0)) == null || (vASMsgElement2 = msgAttributeInfo2.vasMsgInfo) == null || (vASMsgNamePlate2 = vASMsgElement2.msgNamePlateInfo) == null || (num = vASMsgNamePlate2.namePlateType) == null) {
            HashMap<Integer, MsgAttributeInfo> hashMap2 = this.msgRecord.msgAttrs;
            if (hashMap2 != null && (msgAttributeInfo = hashMap2.get(0)) != null && (vASMsgElement = msgAttributeInfo.vasMsgInfo) != null && (vASMsgNamePlate = vASMsgElement.msgNamePlateInfo) != null) {
                num = vASMsgNamePlate.msgVipType;
            } else {
                num = null;
            }
            if (num == null) {
                return 0;
            }
        }
        return num.intValue();
    }
}
