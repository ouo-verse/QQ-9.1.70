package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FaceBubbleElement;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.SmallYellowFaceInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 )2\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010&\u001a\u00020\u0012\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\f\u0010\t\u001a\u00020\u0006*\u00020\bH\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0001H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0006\u0010\u0011\u001a\u00020\u0004J\u0010\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00188FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010!\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\"R\u0011\u0010%\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b#\u0010$\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/FaceBubbleMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msg/f;", "msgExtInfo", "", "p2", "", "k2", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceBubbleElement;", "l2", "Landroid/content/Context;", "context", "Y0", "newMsgItem", "l", "", "getViewType", "r2", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "f1", "", "e2", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "W0", "Lkotlin/Lazy;", ICustomDataEditor.NUMBER_PARAM_2, "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "X0", "m2", "()Lcom/tencent/qqnt/kernel/nativeinterface/FaceBubbleElement;", "faceBubbleElement", "Lcom/tencent/mobileqq/aio/msg/f;", "o2", "()Z", "isPlayed", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "Z0", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class FaceBubbleMsgItem extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: Z0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: W0, reason: from kotlin metadata */
    @NotNull
    private final Lazy msgElement;

    /* renamed from: X0, reason: from kotlin metadata */
    @NotNull
    private final Lazy faceBubbleElement;

    /* renamed from: Y0, reason: from kotlin metadata */
    @Nullable
    private f msgExtInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/FaceBubbleMsgItem$a;", "", "", "POP_EMO_BUSINESS_TYPE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.FaceBubbleMsgItem$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46616);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceBubbleMsgItem(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<MsgElement>() { // from class: com.tencent.mobileqq.aio.msg.FaceBubbleMsgItem$msgElement$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FaceBubbleMsgItem.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final MsgElement invoke() {
                    String k26;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (MsgElement) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    MsgElement firstTypeElement = FaceBubbleMsgItem.this.getFirstTypeElement(27);
                    if (firstTypeElement == null) {
                        k26 = FaceBubbleMsgItem.this.k2();
                        QLog.e("FaceBubbleMsgItem", 1, "face bubble msgElement is null, " + k26);
                    }
                    return firstTypeElement;
                }
            });
            this.msgElement = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FaceBubbleElement>() { // from class: com.tencent.mobileqq.aio.msg.FaceBubbleMsgItem$faceBubbleElement$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FaceBubbleMsgItem.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final FaceBubbleElement invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (FaceBubbleElement) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    MsgElement n26 = FaceBubbleMsgItem.this.n2();
                    if (n26 != null) {
                        return n26.faceBubbleElement;
                    }
                    return null;
                }
            });
            this.faceBubbleElement = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String k2() {
        String str;
        String str2 = "MsgRecord{msgId=" + getMsgRecord().msgId + ",msgSeq=" + getMsgRecord().msgSeq + ",chatType=" + getMsgRecord().chatType + ",msgType=" + getMsgRecord().msgType + ",sendType=" + getMsgRecord().sendType + ",senderUid=" + getMsgRecord().senderUid + ",senderUin=" + getMsgRecord().senderUin;
        Iterator<MsgElement> it = getMsgRecord().elements.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            long j3 = next.elementId;
            int i3 = next.elementType;
            FaceBubbleElement faceBubbleElement = next.faceBubbleElement;
            if (faceBubbleElement != null) {
                str = l2(faceBubbleElement);
            } else {
                str = null;
            }
            str2 = str2 + ",MsgElement={elementId=" + j3 + ",elementType=" + i3 + ",faceBubbleElement=" + str + "}";
        }
        return str2;
    }

    private final String l2(FaceBubbleElement faceBubbleElement) {
        return "FaceBubbleElement{faceType=" + faceBubbleElement.faceType + ",faceCount=" + faceBubbleElement.faceCount + ",faceSummary=" + faceBubbleElement.faceSummary + "}";
    }

    private final void p2(f msgExtInfo) {
        com.tencent.qqnt.kernel.api.w e16;
        MsgElement n26 = n2();
        if (n26 != null && (e16 = com.tencent.qqnt.msg.f.e()) != null) {
            e16.updateElementExtBufForUI(new Contact(p0(), r0(), ""), q0(), n26.elementId, msgExtInfo.c(), new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msg.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    FaceBubbleMsgItem.q2(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q2(int i3, String str) {
        if (i3 != 0) {
            QLog.w("FaceBubbleMsgItem", 1, "[serializeExtInfo] fail, err=" + i3 + ", " + str);
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        super.Y0(context);
        MsgElement n26 = n2();
        if (n26 != null) {
            this.msgExtInfo = f.INSTANCE.a(n26.extBufForUI);
        }
        if (QLog.isColorLevel()) {
            QLog.d("FaceBubbleMsgItem", 2, "msgRecord: id=" + getMsgRecord().msgId + ", seq=" + getMsgRecord().msgSeq + ", msgExtInfo=" + this.msgExtInfo);
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 9, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new FaceBubbleMsgItem(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String f1() {
        SmallYellowFaceInfo smallYellowFaceInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        FaceBubbleElement m26 = m2();
        if (m26 == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        String str = "\u8868\u60c5";
        if (m26.faceType == 13 && (smallYellowFaceInfo = m26.yellowFaceInfo) != null) {
            if (smallYellowFaceInfo.index >= 0) {
                str = "\u8868\u60c5" + smallYellowFaceInfo.compatibleText;
            }
        } else {
            str = "\u8868\u60c5" + m26.faceSummary;
        }
        CharSequence x16 = x();
        if (isSelf()) {
            sb5.append("\u6211\u53d1\u51fa" + str + m26.faceCount);
        } else {
            sb5.append(((Object) x16) + "\u53d1\u6765" + str + m26.faceCount);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sbContentDescription.toString()");
        return sb6;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (isSelf()) {
            return 75;
        }
        return 76;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        FaceBubbleMsgItem faceBubbleMsgItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        Unit unit = Unit.INSTANCE;
        if (newMsgItem instanceof FaceBubbleMsgItem) {
            faceBubbleMsgItem = (FaceBubbleMsgItem) newMsgItem;
        } else {
            faceBubbleMsgItem = null;
        }
        if (faceBubbleMsgItem != null) {
            faceBubbleMsgItem.msgExtInfo = this.msgExtInfo;
        }
    }

    @Nullable
    public final FaceBubbleElement m2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (FaceBubbleElement) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (FaceBubbleElement) this.faceBubbleElement.getValue();
    }

    @Nullable
    public final MsgElement n2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MsgElement) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (MsgElement) this.msgElement.getValue();
    }

    public final boolean o2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        f fVar = this.msgExtInfo;
        if (fVar != null) {
            return fVar.a();
        }
        return true;
    }

    public final void r2() {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else if (!o2() && (fVar = this.msgExtInfo) != null) {
            fVar.b(true);
            p2(fVar);
        }
    }
}
