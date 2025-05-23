package com.tencent.mobileqq.qqlive.push;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qqlive.common.api.AegisLogger;
import java.io.UnsupportedEncodingException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rq3.h;
import rq3.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqlive/push/c;", "", "", "Lfp4/c;", "infoArray", "", "a", "([Lfp4/c;)V", "", BaseConstants.ATTRIBUTE_KEY_PB_DATA, "b", "Lrq3/a;", "broadCastMsg", "c", "Ljp4/c;", "rsp", "d", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuffer;", "stringBuffer", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final List<Integer> f271421c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private StringBuffer stringBuffer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0011\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqlive/push/c$a;", "", "", "", "DEFAULT_CMD_LIST", "Ljava/util/List;", "DEFAULT_MAX_MSG_COUNT", "I", "HIGH_PRIORITY_MESSAGE_CMD_NOW_QQLIVE", "HIGH_PRIORITY_MESSAGE_CMD_QQLIVE", "LOW_PRIORITY_MESSAGE_CMD_NOW_QQLIVE", "LOW_PRIORITY_MESSAGE_CMD_QQLIVE", "NORMAL_CHAT_MESSAGE_CMD", "", "TAG", "Ljava/lang/String;", "USER_ENTER_ROOM_CMD", "USER_LEVEL_CHANGED", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.push.c$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        List<Integer> mutableListOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43127);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(33, 200, 167, 235, 55, 234, 263);
        f271421c = mutableListOf;
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.stringBuffer = new StringBuffer();
        }
    }

    private final void a(fp4.c[] infoArray) {
        if (infoArray.length > 20) {
            return;
        }
        for (fp4.c cVar : infoArray) {
            if (f271421c.contains(Integer.valueOf(cVar.f400284b))) {
                StringBuffer stringBuffer = this.stringBuffer;
                stringBuffer.append(cVar.f400288f + "-" + cVar.f400284b + "-" + cVar.f400283a + "-" + cVar.f400289g);
                stringBuffer.append(" ");
                if (cVar.f400284b == 33) {
                    byte[] bArr = cVar.f400285c;
                    Intrinsics.checkNotNullExpressionValue(bArr, "it.msgData");
                    b(bArr);
                }
            }
        }
        if (TextUtils.isEmpty(this.stringBuffer)) {
            return;
        }
        AegisLogger.INSTANCE.i("Push|LiveRoomPushMsgPrinter", String.valueOf(this.stringBuffer));
        StringBuffer stringBuffer2 = this.stringBuffer;
        stringBuffer2.delete(0, stringBuffer2.length());
    }

    private final void b(byte[] pbData) {
        try {
            c(rq3.a.c(pbData));
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Push|LiveRoomPushMsgPrinter", "parseAndPrintChatMsg error", "e:" + e16.getMessage());
        }
    }

    private final void c(rq3.a broadCastMsg) {
        String str;
        i iVar = broadCastMsg.f431934a;
        rq3.e[] eVarArr = null;
        if (iVar != null) {
            str = iVar.f431959b;
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        rq3.d dVar = broadCastMsg.f431935b;
        if (dVar != null) {
            eVarArr = dVar.f431942a;
        }
        if (eVarArr == null) {
            return;
        }
        for (rq3.e eVar : eVarArr) {
            h hVar = eVar.f431946b;
            if (hVar != null) {
                byte[] bArr = hVar.f431957a;
                if (bArr == null) {
                    bArr = new byte[0];
                }
                try {
                    AegisLogger.INSTANCE.i("Push|LiveRoomPushMsgPrinter", "printChatMsg", "nick:" + str + ", text:" + new String(bArr, Charsets.UTF_16LE));
                } catch (UnsupportedEncodingException e16) {
                    AegisLogger.INSTANCE.e("Push|LiveRoomPushMsgPrinter", "printChatMsg error", "e:" + e16);
                }
            }
        }
    }

    public final void d(@Nullable jp4.c rsp) {
        fp4.c[] cVarArr;
        fp4.c[] cVarArr2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
            return;
        }
        if (!ht3.a.e("qqlive_push_message_log_enable", true)) {
            return;
        }
        if (rsp != null && (cVarArr2 = rsp.f410802c) != null) {
            a(cVarArr2);
        }
        if (rsp != null && (cVarArr = rsp.f410801b) != null) {
            a(cVarArr);
        }
    }
}
