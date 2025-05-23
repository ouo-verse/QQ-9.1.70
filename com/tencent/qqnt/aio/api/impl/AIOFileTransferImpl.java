package com.tencent.qqnt.aio.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.adapter.api.IAIOFileErrHandler;
import com.tencent.qqnt.aio.api.IAIOFileTransfer;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOFileTransferImpl;", "Lcom/tencent/qqnt/aio/api/IAIOFileTransfer;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "", "path", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "listener", "", "sendLocalFile", "<init>", "()V", "Companion", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOFileTransferImpl implements IAIOFileTransfer {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "AIOFileTransferImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOFileTransferImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.api.impl.AIOFileTransferImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65454);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOFileTransferImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendLocalFile$lambda$1(String path, Contact contact, final IOperateCallback iOperateCallback) {
        long j3;
        ArrayList<MsgElement> arrayListOf;
        Long j06;
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(contact, "$contact");
        MsgElement c16 = c81.a.c(path, c81.a.k(path));
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null && (j06 = e16.j0(contact.chatType)) != null) {
            j3 = j06.longValue();
        } else {
            j3 = 0;
        }
        long j16 = j3;
        ((IAIOFileErrHandler) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFileErrHandler.class)).registerFileIdListen(j16, contact);
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(c16);
        iMsgService.sendMsgWithMsgId(contact, j16, arrayListOf, new IOperateCallback() { // from class: com.tencent.qqnt.aio.api.impl.p
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                AIOFileTransferImpl.sendLocalFile$lambda$1$lambda$0(IOperateCallback.this, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendLocalFile$lambda$1$lambda$0(IOperateCallback iOperateCallback, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        com.tencent.qqnt.aio.utils.q.a(TAG, "send MessageForFile result=" + i3 + " errMsg=" + errMsg);
        if (iOperateCallback != null) {
            iOperateCallback.onResult(i3, errMsg);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IAIOFileTransfer
    public void sendLocalFile(@NotNull final Contact contact, @NotNull final String path, @Nullable final IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, contact, path, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(path, "path");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.api.impl.o
            @Override // java.lang.Runnable
            public final void run() {
                AIOFileTransferImpl.sendLocalFile$lambda$1(path, contact, listener);
            }
        }, 16, null, false);
    }
}
