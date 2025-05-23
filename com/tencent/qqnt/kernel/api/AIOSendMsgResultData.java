package com.tencent.qqnt.kernel.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u000289B7\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c\u00a2\u0006\u0004\b3\u00104B\u0019\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u00106\u001a\u000205\u00a2\u0006\u0004\b3\u00107J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010!R\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b\t\u0010$R$\u0010)\u001a\u00020 2\u0006\u0010&\u001a\u00020 8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b'\u0010!\u001a\u0004\b\u000f\u0010(R\u0017\u0010*\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b\u001d\u0010$R*\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010#\u001a\u0004\b\u0015\u0010$\"\u0004\b,\u0010-R\u0017\u00102\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b'\u00101\u00a8\u0006:"}, d2 = {"Lcom/tencent/qqnt/kernel/api/AIOSendMsgResultData;", "", "", "errorCode", "", tl.h.F, "", "toString", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "a", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "getContact", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "Lcom/tencent/qqnt/kernel/api/AIOSendMsgResultData$SendType;", "b", "Lcom/tencent/qqnt/kernel/api/AIOSendMsgResultData$SendType;", "f", "()Lcom/tencent/qqnt/kernel/api/AIOSendMsgResultData$SendType;", "sendType", "Lcom/tencent/qqnt/kernel/api/AIOSendMsgResultData$SendPhase;", "c", "Lcom/tencent/qqnt/kernel/api/AIOSendMsgResultData$SendPhase;", "e", "()Lcom/tencent/qqnt/kernel/api/AIOSendMsgResultData$SendPhase;", "sendPhase", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "msgElements", "", "J", "beginTime", "I", "()I", "chatType", "<set-?>", "g", "()J", "costTime", "msgElementType", "value", "i", "(I)V", "", "j", "Z", "()Z", "success", "<init>", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;Lcom/tencent/qqnt/kernel/api/AIOSendMsgResultData$SendType;Lcom/tencent/qqnt/kernel/api/AIOSendMsgResultData$SendPhase;Ljava/util/ArrayList;)V", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "(Lcom/tencent/qqnt/kernel/api/AIOSendMsgResultData$SendPhase;Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "SendPhase", "SendType", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class AIOSendMsgResultData {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Contact contact;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SendType sendType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SendPhase sendPhase;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<MsgElement> msgElements;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long beginTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int chatType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long costTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int msgElementType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int errorCode;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final boolean success;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/kernel/api/AIOSendMsgResultData$SendPhase;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/String;", "Add", "Send", "kernel_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class SendPhase {
        private static final /* synthetic */ SendPhase[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final SendPhase Add;
        public static final SendPhase Send;

        @NotNull
        private final String value;

        private static final /* synthetic */ SendPhase[] $values() {
            return new SendPhase[]{Add, Send};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39942);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            Add = new SendPhase("Add", 0, "add");
            Send = new SendPhase("Send", 1, "send");
            $VALUES = $values();
        }

        SendPhase(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
            } else {
                this.value = str2;
            }
        }

        public static SendPhase valueOf(String str) {
            return (SendPhase) Enum.valueOf(SendPhase.class, str);
        }

        public static SendPhase[] values() {
            return (SendPhase[]) $VALUES.clone();
        }

        @NotNull
        public final String getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/kernel/api/AIOSendMsgResultData$SendType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/String;", "Send", "Forward", "kernel_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class SendType {
        private static final /* synthetic */ SendType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final SendType Forward;
        public static final SendType Send;

        @NotNull
        private final String value;

        private static final /* synthetic */ SendType[] $values() {
            return new SendType[]{Send, Forward};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39952);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            Send = new SendType("Send", 0, "send");
            Forward = new SendType("Forward", 1, "forward");
            $VALUES = $values();
        }

        SendType(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
            } else {
                this.value = str2;
            }
        }

        public static SendType valueOf(String str) {
            return (SendType) Enum.valueOf(SendType.class, str);
        }

        public static SendType[] values() {
            return (SendType[]) $VALUES.clone();
        }

        @NotNull
        public final String getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.value;
        }
    }

    public AIOSendMsgResultData(@NotNull Contact contact, @NotNull SendType sendType, @NotNull SendPhase sendPhase, @NotNull ArrayList<MsgElement> msgElements) {
        Object first;
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(sendType, "sendType");
        Intrinsics.checkNotNullParameter(sendPhase, "sendPhase");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, contact, sendType, sendPhase, msgElements);
            return;
        }
        this.contact = contact;
        this.sendType = sendType;
        this.sendPhase = sendPhase;
        this.msgElements = msgElements;
        this.beginTime = System.currentTimeMillis();
        this.chatType = contact.chatType;
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) msgElements);
        this.msgElementType = ((MsgElement) first).elementType;
        this.success = this.errorCode == 0;
    }

    private final void i(int i3) {
        this.errorCode = i3;
        this.costTime = System.currentTimeMillis() - this.beginTime;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.chatType;
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.costTime;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.errorCode;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.msgElementType;
    }

    @NotNull
    public final SendPhase e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SendPhase) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.sendPhase;
    }

    @NotNull
    public final SendType f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SendType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.sendType;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.success;
    }

    public final void h(int errorCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, errorCode);
        } else {
            i(errorCode);
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "{AIOSendMsgResultData:chatType=" + this.chatType + ",sendType=" + this.sendType + ",sendPhase=" + this.sendPhase + "},elementType=" + this.msgElementType + ",errorCode=" + this.errorCode + ",costTime=" + this.costTime;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AIOSendMsgResultData(@NotNull SendPhase sendPhase, @NotNull MsgRecord msgRecord) {
        this(r0, r1, sendPhase, r2);
        Intrinsics.checkNotNullParameter(sendPhase, "sendPhase");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Contact contact = new Contact(msgRecord.chatType, msgRecord.peerUid, "");
        SendType sendType = SendType.Send;
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) sendPhase, (Object) msgRecord);
    }
}
