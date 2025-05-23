package com.tencent.mobileqq.aio.msg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \"2\u00020\u0001:\u0002#$B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001e\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ad;", "Lcom/tencent/mobileqq/aio/msg/ae;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "b0", "", "getViewType", "", "J2", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE, "P2", "", "q1", "Z", "L2", "()Z", "O2", "(Z)V", "enableScaleAnim", "Lcom/tencent/mobileqq/aio/msg/ad$b;", "r1", "Lcom/tencent/mobileqq/aio/msg/ad$b;", "stateInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "M2", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "N2", "()I", "msgPlayState", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", ICustomDataEditor.STRING_PARAM_1, "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ad extends ae {
    static IPatchRedirector $redirector_;

    /* renamed from: s1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: q1, reason: collision with root package name and from kotlin metadata */
    private boolean enableScaleAnim;

    /* renamed from: r1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b stateInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ad$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.ad$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ad$b;", "", "", "e", "", "verifyMsgId", "buf", "", "a", "J", "getMsgId", "()J", "c", "(J)V", "msgId", "", "b", "I", "()I", "d", "(I)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE, "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: d, reason: collision with root package name */
        private static final Charset f190110d;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long msgId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int playState;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ad$b$a;", "", "Ljava/nio/charset/Charset;", "kotlin.jvm.PlatformType", "CHARSET_UTF8", "Ljava/nio/charset/Charset;", "", "KEY_MSG_ID", "Ljava/lang/String;", "KEY_PLAY_STATE", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.aio.msg.ad$b$a, reason: from kotlin metadata */
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57488);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 8)) {
                redirector.redirect((short) 8);
            } else {
                INSTANCE = new Companion(null);
                f190110d = Charset.forName("UTF-8");
            }
        }

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final boolean a(long verifyMsgId, @NotNull byte[] buf) {
            boolean z16;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, this, Long.valueOf(verifyMsgId), buf)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(buf, "buf");
            if (buf.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
            try {
                Charset CHARSET_UTF8 = f190110d;
                Intrinsics.checkNotNullExpressionValue(CHARSET_UTF8, "CHARSET_UTF8");
                JSONObject jSONObject = new JSONObject(new String(buf, CHARSET_UTF8));
                long optLong = jSONObject.optLong("KEY_MSG_ID");
                this.msgId = optLong;
                if (verifyMsgId == optLong) {
                    i3 = jSONObject.optInt("KEY_PLAY_STATE");
                } else {
                    i3 = 0;
                }
                this.playState = i3;
                return true;
            } catch (JSONException e16) {
                com.tencent.qqnt.aio.utils.q.e("MsgExtendInfo", "[fromByteArray] failed, exc=" + e16);
                return false;
            }
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.playState;
        }

        public final void c(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
            } else {
                this.msgId = j3;
            }
        }

        public final void d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.playState = i3;
            }
        }

        @NotNull
        public final byte[] e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("KEY_MSG_ID", this.msgId);
                jSONObject.put("KEY_PLAY_STATE", this.playState);
                String jSONObject2 = jSONObject.toString(0);
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "root.toString(0)");
                Charset CHARSET_UTF8 = f190110d;
                Intrinsics.checkNotNullExpressionValue(CHARSET_UTF8, "CHARSET_UTF8");
                byte[] bytes = jSONObject2.getBytes(CHARSET_UTF8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                return bytes;
            } catch (JSONException e16) {
                com.tencent.qqnt.aio.utils.q.e("MsgExtendInfo", "[toByteArray] failed, exc=" + e16);
                return new byte[0];
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57490);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
            return;
        }
        b bVar = new b();
        this.stateInfo = bVar;
        long q06 = q0();
        byte[] bArr = M2().extBufForUI;
        Intrinsics.checkNotNullExpressionValue(bArr, "msgElement.extBufForUI");
        bVar.a(q06, bArr);
    }

    private final MsgElement M2() {
        MsgElement firstTypeElement = getFirstTypeElement(6);
        Intrinsics.checkNotNull(firstTypeElement);
        return firstTypeElement;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q2(int i3, String str) {
        QLog.e("SingleSysFaceMsgItem", 1, "update state info, result=" + i3 + ", msg=" + str);
    }

    @Override // com.tencent.mobileqq.aio.msg.ae
    public void J2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    public final boolean L2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.enableScaleAnim;
    }

    public final int N2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.stateInfo.b();
    }

    public final void O2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.enableScaleAnim = z16;
        }
    }

    public final void P2(int playState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, playState);
            return;
        }
        boolean z16 = false;
        if (playState == 2) {
            this.enableScaleAnim = false;
        }
        if (this.stateInfo.b() != playState) {
            this.stateInfo.d(playState);
            z16 = true;
        }
        if (z16) {
            this.stateInfo.c(q0());
            M2().extBufForUI = this.stateInfo.e();
            com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                Contact contact = new Contact(getMsgRecord().chatType, getMsgRecord().peerUid, "");
                long q06 = q0();
                long j3 = M2().elementId;
                byte[] bArr = M2().extBufForUI;
                Intrinsics.checkNotNullExpressionValue(bArr, "msgElement.extBufForUI");
                e16.updateElementExtBufForUI(contact, q06, j3, bArr, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msg.ac
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        ad.Q2(i3, str);
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.ae, com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 4, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new ad(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.ae, com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (C2()) {
            if (isSelf()) {
                return 79;
            }
            return 80;
        }
        if (isSelf()) {
            return 90;
        }
        return 91;
    }
}
