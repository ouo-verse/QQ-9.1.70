package com.tencent.qqnt.aio.assistedchat.servlet;

import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u0000 \u00152\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J9\u0010\u0011\u001a\u00020\u0006\"\f\b\u0000\u0010\f*\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/servlet/a;", "Lmqq/observer/BusinessObserver;", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "", "a", "", "type", "onReceive", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "code", "", "msg", "rsp", "b", "(ILjava/lang/String;Lcom/tencent/mobileqq/pb/MessageMicro;)V", "<init>", "()V", "d", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class a implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/servlet/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.servlet.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60083);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(boolean isSuccess, Bundle bundle) {
        int i3;
        String str;
        String str2;
        byte[] bArr;
        boolean z16;
        if (bundle != null) {
            i3 = bundle.getInt("code");
        } else {
            i3 = 0;
        }
        if (bundle != null) {
            str = bundle.getString("msg");
        } else {
            str = null;
        }
        if (!isSuccess) {
            b(i3, str, null);
            return;
        }
        if (bundle == null || (str2 = bundle.getString("cmd")) == null) {
            str2 = "";
        }
        Class<? extends MessageMicro<?>> cls = b.f349435a.a().get(str2);
        if (cls == null) {
            QLog.e("AssistedChatObserver", 1, "handleRsp " + str2 + " rspClass is null");
            b(-1, null, null);
            return;
        }
        if (bundle != null) {
            bArr = bundle.getByteArray("rspBody");
        } else {
            bArr = null;
        }
        if (bArr != null) {
            if (bArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                try {
                    MessageMicro<?> newInstance = cls.newInstance();
                    newInstance.mergeFrom(bArr);
                    b(0, "", newInstance);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("AssistedChatObserver", 1, "handleRsp " + str2 + " error: " + e16);
                    b(-1, null, null);
                    return;
                } catch (IllegalAccessException e17) {
                    QLog.e("AssistedChatObserver", 1, "handleRsp " + str2 + " error: " + e17);
                    b(-1, null, null);
                    return;
                } catch (InstantiationException e18) {
                    QLog.e("AssistedChatObserver", 1, "handleRsp " + str2 + " error: " + e18);
                    b(-1, null, null);
                    return;
                }
            }
        }
        QLog.e("AssistedChatObserver", 1, "handleRsp " + str2 + " rspBody is null or empty");
        b(-1, null, null);
    }

    public abstract <T extends MessageMicro<?>> void b(int code, @Nullable String msg2, @Nullable T rsp);

    @Override // mqq.observer.BusinessObserver
    public final void onReceive(int type, boolean isSuccess, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), bundle);
        } else {
            a(isSuccess, bundle);
        }
    }
}
