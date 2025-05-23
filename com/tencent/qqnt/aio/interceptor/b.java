package com.tencent.qqnt.aio.interceptor;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.qqnt.kernel.nativeinterface.TempChatPrepareInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J2\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/interceptor/b;", "Lcom/tencent/qqnt/aio/interceptor/BaseTempAIOStartInterceptor;", "", "chatType", "", "a", "Landroid/content/Context;", "context", "", "uid", "nick", "Landroid/os/Bundle;", "extra", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatPrepareInfo;", "c", "<init>", "()V", "b", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b extends BaseTempAIOStartInterceptor {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f351162b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/interceptor/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33358);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f351162b = new a(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.interceptor.g
    public boolean a(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, chatType)).booleanValue();
        }
        if (chatType == 102) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.interceptor.BaseTempAIOStartInterceptor
    @NotNull
    public TempChatPrepareInfo c(@NotNull Context context, int chatType, @NotNull String uid, @NotNull String nick, @Nullable Bundle extra) {
        long j3;
        int checkRadix;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TempChatPrepareInfo) iPatchRedirector.redirect((short) 3, this, context, Integer.valueOf(chatType), uid, nick, extra);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentUid = peekAppRuntime.getCurrentUid();
        long j16 = 0;
        if (extra != null) {
            j3 = extra.getLong("key_peerUin", 0L);
        } else {
            j3 = 0;
        }
        if (extra != null) {
            j16 = extra.getLong("key_groupUin", 0L);
        }
        byte[] k06 = ((com.tencent.mobileqq.service.message.e) peekAppRuntime.getMsgCache()).k0(String.valueOf(j3));
        if (k06 == null) {
            k06 = new byte[0];
        }
        byte[] bArr = k06;
        if (QLog.isColorLevel()) {
            QLog.d("CRMTempAIOInterceptor", 2, "CRMTempAIOInterceptor chatType: " + chatType + ", uid:" + uid + ", groupUin: " + j16 + " uin " + j3 + " sig " + bArr);
        }
        checkRadix = CharsKt__CharJVMKt.checkRadix(10);
        String l3 = Long.toString(j16, checkRadix);
        Intrinsics.checkNotNullExpressionValue(l3, "toString(this, checkRadix(radix))");
        return new TempChatPrepareInfo(chatType, uid, nick, l3, bArr, currentUid, "", new TempChatGameSession());
    }
}
