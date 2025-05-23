package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.ptt.v;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOPttApi;
import com.tencent.qqnt.kernel.nativeinterface.AIVoiceChatType;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.OtherBusinessInfo;
import com.tencent.qqnt.kernel.nativeinterface.PttElement;
import com.tencent.qqnt.kernel.nativeinterface.PttVoiceType;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 J2\u00020\u0001:\u0001KB\u000f\u0012\u0006\u0010G\u001a\u00020\u000b\u00a2\u0006\u0004\bH\u0010IJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0002J\f\u0010\n\u001a\u00020\u0007*\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0012J\u0006\u0010\u001d\u001a\u00020\u0012J\u001c\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0014J\u0012\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\u0012H\u0016J\u0012\u0010(\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0001H\u0016J\u0006\u0010+\u001a\u00020\u0012J\b\u0010,\u001a\u00020\u0004H\u0016J\u0006\u0010-\u001a\u00020\u0004J\b\u0010.\u001a\u00020\u0002H\u0016R\u001d\u00104\u001a\u0004\u0018\u00010/8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001d\u00107\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u00101\u001a\u0004\b5\u00106R\u001b\u0010;\u001a\u0002088FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u00101\u001a\u0004\b9\u0010:R\"\u0010B\u001a\u00020\u00048F@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010F\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010=\u001a\u0004\bD\u0010?\"\u0004\bE\u0010A\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/PttMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "translateStatus", "", "F2", "(Ljava/lang/Integer;)Z", "", "m2", "Lcom/tencent/qqnt/kernel/nativeinterface/PttElement;", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "q2", "r2", "t2", Constants.BASE_IN_PLUGIN_VERSION, "", "K2", Constants.MMCCID, "v2", "w2", "z2", "y2", "x2", "u2", NowProxyConstants.AccountInfoKey.A2, "l2", "H2", "Lcom/tencent/aio/data/msglist/a;", "target", "Lkotlin/Pair;", "o", "", "getChangePayload", "f1", "X0", "Landroid/content/Context;", "context", "Y0", "newMsgItem", "l", "k2", "g2", "B2", "getViewType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "W0", "Lkotlin/Lazy;", "o2", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", ICustomDataEditor.STRING_PARAM_2, "()Lcom/tencent/qqnt/kernel/nativeinterface/PttElement;", "pttElement", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/v;", "p2", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/v;", "msgExtInfo", "Z0", "Z", "C2", "()Z", "J2", "(Z)V", "isFakeMsg", ICustomDataEditor.STRING_ARRAY_PARAM_1, "E2", "setPttFileExists", "isPttFileExists", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "b1", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class PttMsgItem extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: b1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: W0, reason: from kotlin metadata */
    @NotNull
    private final Lazy msgElement;

    /* renamed from: X0, reason: from kotlin metadata */
    @NotNull
    private final Lazy pttElement;

    /* renamed from: Y0, reason: from kotlin metadata */
    @NotNull
    private final Lazy msgExtInfo;

    /* renamed from: Z0, reason: from kotlin metadata */
    private boolean isFakeMsg;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    private boolean isPttFileExists;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/PttMsgItem$a;", "", "", "MAX_VALID_DURATION", "I", "MIN_VALID_DURATION", "SHORTEST_DISPLAY_DURATION", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.PttMsgItem$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57295);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PttMsgItem(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<MsgElement>() { // from class: com.tencent.mobileqq.aio.msg.PttMsgItem$msgElement$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PttMsgItem.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final MsgElement invoke() {
                    String m26;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (MsgElement) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    MsgElement firstTypeElement = PttMsgItem.this.getFirstTypeElement(4);
                    if (firstTypeElement == null) {
                        m26 = PttMsgItem.this.m2();
                        QLog.e("PttMsgItem", 1, "ptt msgElement is null, " + m26);
                    }
                    return firstTypeElement;
                }
            });
            this.msgElement = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<PttElement>() { // from class: com.tencent.mobileqq.aio.msg.PttMsgItem$pttElement$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PttMsgItem.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final PttElement invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (PttElement) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    MsgElement o26 = PttMsgItem.this.o2();
                    if (o26 != null) {
                        return o26.pttElement;
                    }
                    return null;
                }
            });
            this.pttElement = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.aio.msglist.holder.component.ptt.v>() { // from class: com.tencent.mobileqq.aio.msg.PttMsgItem$msgExtInfo$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PttMsgItem.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.mobileqq.aio.msglist.holder.component.ptt.v invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.mobileqq.aio.msglist.holder.component.ptt.v) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    v.Companion companion = com.tencent.mobileqq.aio.msglist.holder.component.ptt.v.INSTANCE;
                    MsgElement o26 = PttMsgItem.this.o2();
                    return companion.a(o26 != null ? o26.extBufForUI : null);
                }
            });
            this.msgExtInfo = lazy3;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
    }

    private final boolean F2(Integer translateStatus) {
        if ((translateStatus == null || translateStatus.intValue() != 2) && (translateStatus == null || translateStatus.intValue() != 3)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I2(int i3, String str) {
        if (i3 != 0) {
            QLog.w("PttMsgItem", 1, "[serializeExtInfo] fail, err=" + i3 + ", " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String m2() {
        String str;
        String str2 = "MsgRecord{msgId=" + getMsgRecord().msgId + ",msgSeq=" + getMsgRecord().msgSeq + ",chatType=" + getMsgRecord().chatType + ",msgType=" + getMsgRecord().msgType + ",sendType=" + getMsgRecord().sendType + ",senderUid=" + getMsgRecord().senderUid + ",senderUin=" + getMsgRecord().senderUin;
        Iterator<MsgElement> it = getMsgRecord().elements.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            long j3 = next.elementId;
            int i3 = next.elementType;
            PttElement pttElement = next.pttElement;
            if (pttElement != null) {
                str = n2(pttElement);
            } else {
                str = null;
            }
            str2 = str2 + ",MsgElement={elementId=" + j3 + ",elementType=" + i3 + ",pttElement=" + str + "}";
        }
        return str2;
    }

    private final String n2(PttElement pttElement) {
        return "PttElement{fileName=" + pttElement.fileName + ",filePath=" + pttElement.filePath + ",md5HexStr=" + pttElement.md5HexStr + ",fileSize=" + pttElement.fileSize + ",duration=" + pttElement.duration + "}";
    }

    public final boolean A2() {
        OtherBusinessInfo otherBusinessInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        PttElement s26 = s2();
        if (s26 == null || (otherBusinessInfo = s26.otherBusinessInfo) == null || otherBusinessInfo.aiVoiceType != AIVoiceChatType.KAIVOICECHATTYPESOUND.ordinal()) {
            return false;
        }
        return true;
    }

    public final boolean B2() {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        PttElement s26 = s2();
        if (s26 == null || (num = s26.invalidState) == null || num.intValue() != 1) {
            return false;
        }
        return true;
    }

    public final boolean C2() {
        ArrayList<Byte> arrayList;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.isFakeMsg) {
            return true;
        }
        PttElement s26 = s2();
        if (s26 != null) {
            arrayList = s26.waveAmplitudes;
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        return false;
    }

    public final boolean D2() {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        PttElement s26 = s2();
        if (s26 == null || (num = s26.playState) == null || num.intValue() != 1) {
            return false;
        }
        return true;
    }

    public final boolean E2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isPttFileExists;
    }

    public final boolean G2() {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        PttElement s26 = s2();
        if (s26 != null && s26.voiceType == PttVoiceType.KVOICECHANGE.ordinal()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        PttElement s27 = s2();
        if (s27 != null) {
            i3 = s27.voiceChangeType;
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            return true;
        }
        return false;
    }

    public final void H2() {
        MsgElement o26;
        com.tencent.qqnt.kernel.api.w e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.ptt.v p26 = p2();
        if (p26 != null && (o26 = o2()) != null && (e16 = com.tencent.qqnt.msg.f.e()) != null) {
            e16.updateElementExtBufForUI(new Contact(p0(), r0(), ""), q0(), o26.elementId, p26.e(), new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msg.s
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    PttMsgItem.I2(i3, str);
                }
            });
        }
    }

    public final void J2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.isFakeMsg = z16;
        }
    }

    public final void K2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        PttElement s26 = s2();
        if (s26 != null) {
            s26.playState = 1;
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void X0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else {
            super.X0();
            Y1(a.a(this));
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) context);
            return;
        }
        super.Y0(context);
        if (context != null) {
            Y1(com.tencent.mobileqq.aio.utils.n.f194168a.e(context, this, isSelf(), false));
        }
        this.isPttFileExists = FileUtils.fileExists(t2());
        k2();
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 9, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new PttMsgItem(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        if (isSelf()) {
            return HardCodeUtil.qqStr(R.string.ypb) + HardCodeUtil.qqStr(R.string.ypd) + HardCodeUtil.qqStr(R.string.yp8) + q2() + HardCodeUtil.qqStr(R.string.yp9);
        }
        if (com.tencent.mobileqq.aio.utils.d.s(this)) {
            return getMsgRecord().anonymousExtInfo.anonymousNick + HardCodeUtil.qqStr(R.string.ypc) + HardCodeUtil.qqStr(R.string.yp8) + q2() + HardCodeUtil.qqStr(R.string.yp9);
        }
        CharSequence x16 = x();
        return ((Object) x16) + HardCodeUtil.qqStr(R.string.ypc) + HardCodeUtil.qqStr(R.string.yp8) + q2() + HardCodeUtil.qqStr(R.string.yp9);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    @Nullable
    public Object getChangePayload(@NotNull com.tencent.aio.data.msglist.a target) {
        Integer num;
        Integer num2;
        Integer num3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return iPatchRedirector.redirect((short) 26, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        HashMap hashMap = new HashMap();
        Object changePayload = super.getChangePayload(target);
        try {
            if (changePayload instanceof Map) {
                hashMap.putAll((Map) changePayload);
            }
        } catch (Exception e16) {
            QLog.e("PttMsgItem", 1, e16, new Object[0]);
            if (!com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
                throw e16;
            }
        }
        if (!(target instanceof PttMsgItem)) {
            QLog.i("PttMsgItem", 1, "getChangePayload  target is not PttMsgItem, " + target);
            return hashMap;
        }
        PttMsgItem pttMsgItem = (PttMsgItem) target;
        PttElement s26 = pttMsgItem.s2();
        String str = null;
        if (s26 != null) {
            num = s26.translateStatus;
        } else {
            num = null;
        }
        PttElement s27 = s2();
        if (s27 != null) {
            num2 = s27.translateStatus;
        } else {
            num2 = null;
        }
        if (!Intrinsics.areEqual(num, num2)) {
            PttElement s28 = pttMsgItem.s2();
            if (s28 != null) {
                num3 = s28.translateStatus;
            } else {
                num3 = null;
            }
            if (F2(num3)) {
                AIOMsgItemPayloadType aIOMsgItemPayloadType = AIOMsgItemPayloadType.PTT_TRANSLATE_PAYLOAD;
                PttElement s29 = pttMsgItem.s2();
                if (s29 != null) {
                    str = s29.text;
                }
                if (str == null) {
                    str = "";
                }
                hashMap.put(aIOMsgItemPayloadType, new a.ao(str));
            }
        }
        if (C2() != pttMsgItem.C2()) {
            if (QLog.isDevelopLevel()) {
                QLog.i("PttMsgItem", 4, "getChangePayload fakeState is changed, old isFake: " + C2() + ", new isFake: " + pttMsgItem.C2() + ", ptt duration: " + pttMsgItem.q2() + ", ptt file path:" + pttMsgItem.t2());
            }
            PttElement s210 = pttMsgItem.s2();
            if (s210 != null) {
                hashMap.put(AIOMsgItemPayloadType.PTT_FAKE_PAYLOAD, new a.al(pttMsgItem.q2(), s210));
            }
        }
        if (!Intrinsics.areEqual(t2(), pttMsgItem.t2())) {
            if (QLog.isDebugVersion()) {
                QLog.i("PttMsgItem", 4, "getChangePayload ptt file path is changed, old path: " + t2() + ", new path: " + pttMsgItem.t2());
            }
            hashMap.put(AIOMsgItemPayloadType.PTT_PATH_PAYLOAD, new a.am(pttMsgItem.t2()));
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }
        if (isSelf()) {
            return 13;
        }
        return 12;
    }

    public final void k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        PttElement s26 = s2();
        if (s26 == null) {
            return;
        }
        int i3 = s26.duration;
        if ((i3 < 1 || i3 > 300) && p2().a() < 0) {
            String t26 = t2();
            boolean fileExists = FileUtils.fileExists(t26);
            QLog.i("PttMsgItem", 1, "get duration from file, id:" + getMsgId() + ", duration:" + s26.duration + ", fileExists::" + fileExists);
            if (fileExists) {
                p2().c(((IAIOPttApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOPttApi.class)).getPttFileDuration(t26));
                H2();
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        PttMsgItem pttMsgItem = (PttMsgItem) newMsgItem;
        pttMsgItem.Y1(x0());
        pttMsgItem.isPttFileExists = this.isPttFileExists;
    }

    public final void l2() {
        boolean z16;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        String t26 = t2();
        if (!new File(t26).exists() && !B2()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            t26 = null;
        }
        if (t26 != null) {
            RichMediaElementGetReq richMediaElementGetReq = new RichMediaElementGetReq();
            richMediaElementGetReq.msgId = getMsgRecord().msgId;
            richMediaElementGetReq.peerUid = getMsgRecord().peerUid;
            richMediaElementGetReq.chatType = getMsgRecord().chatType;
            MsgElement o26 = o2();
            if (o26 != null) {
                j3 = o26.elementId;
            } else {
                j3 = 0;
            }
            richMediaElementGetReq.elementId = j3;
            richMediaElementGetReq.downloadType = 1;
            richMediaElementGetReq.downSourceType = 1;
            richMediaElementGetReq.triggerType = 1;
            com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                e16.getRichMediaElement(richMediaElementGetReq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public Pair<Boolean, String> o(@NotNull com.tencent.aio.data.msglist.a target) {
        Integer num;
        Integer num2;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (Pair) iPatchRedirector.redirect((short) 25, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (!(target instanceof PttMsgItem)) {
            QLog.i("PttMsgItem", 1, "isSameContent  target is not PttMsgItem, " + target);
            return new Pair<>(Boolean.FALSE, "not PttMsgItem");
        }
        PttMsgItem pttMsgItem = (PttMsgItem) target;
        if (C2() != pttMsgItem.C2()) {
            if (QLog.isDevelopLevel()) {
                QLog.i("PttMsgItem", 4, "compareMsgContent fakeState is changed, old isFake: " + C2() + ", new isFake: " + pttMsgItem.C2());
            }
            return new Pair<>(Boolean.FALSE, "isFakeMsg");
        }
        PttElement s26 = s2();
        String str2 = null;
        if (s26 != null) {
            num = s26.translateStatus;
        } else {
            num = null;
        }
        PttElement s27 = pttMsgItem.s2();
        if (s27 != null) {
            num2 = s27.translateStatus;
        } else {
            num2 = null;
        }
        if (!Intrinsics.areEqual(num, num2)) {
            return new Pair<>(Boolean.FALSE, "translateStatus");
        }
        PttElement s28 = s2();
        if (s28 != null) {
            str = s28.text;
        } else {
            str = null;
        }
        PttElement s29 = pttMsgItem.s2();
        if (s29 != null) {
            str2 = s29.text;
        }
        if (!Intrinsics.areEqual(str, str2)) {
            return new Pair<>(Boolean.FALSE, "pttElement.text");
        }
        if (!Intrinsics.areEqual(t2(), t2())) {
            return new Pair<>(Boolean.FALSE, "ptt file path change");
        }
        return super.o(target);
    }

    @Nullable
    public final MsgElement o2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MsgElement) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (MsgElement) this.msgElement.getValue();
    }

    @NotNull
    public final com.tencent.mobileqq.aio.msglist.holder.component.ptt.v p2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.ptt.v) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (com.tencent.mobileqq.aio.msglist.holder.component.ptt.v) this.msgExtInfo.getValue();
    }

    public final int q2() {
        Integer num;
        int coerceAtLeast;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        boolean z16 = true;
        IntRange intRange = new IntRange(1, 300);
        PttElement s26 = s2();
        if (s26 != null) {
            num = Integer.valueOf(s26.duration);
        } else {
            num = null;
        }
        if (num == null || !intRange.contains(num.intValue())) {
            z16 = false;
        }
        if (!z16) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(p2().a(), 0);
            return coerceAtLeast;
        }
        PttElement s27 = s2();
        if (s27 == null) {
            return 0;
        }
        return s27.duration;
    }

    public final int r2() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        PttElement s26 = s2();
        if (s26 != null) {
            i3 = s26.duration;
        } else {
            i3 = 0;
        }
        return i3 * 1000;
    }

    @Nullable
    public final PttElement s2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (PttElement) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (PttElement) this.pttElement.getValue();
    }

    @NotNull
    public final String t2() {
        String str;
        PttElement s26;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        PttElement s27 = s2();
        String str3 = null;
        if (s27 != null) {
            str = s27.filePath;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str) && (s26 = s2()) != null) {
            PttElement s28 = s2();
            if (s28 != null) {
                str2 = com.tencent.mobileqq.aio.utils.aj.d(s28);
            } else {
                str2 = null;
            }
            s26.filePath = str2;
        }
        PttElement s29 = s2();
        if (s29 != null) {
            str3 = s29.filePath;
        }
        if (str3 == null) {
            return "";
        }
        return str3;
    }

    @NotNull
    public final String u2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        if (A2()) {
            return "AI\u58f0\u804a";
        }
        return "";
    }

    public final boolean v2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return A2();
    }

    public final boolean w2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (v2() && isSelf()) {
            return true;
        }
        return false;
    }

    public final boolean x2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        if (v2() && R() == 0) {
            return true;
        }
        return false;
    }

    public final boolean y2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if (v2() && R() == 2) {
            return true;
        }
        return false;
    }

    public final boolean z2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        if (v2() && R() == 1) {
            return true;
        }
        return false;
    }
}
