package com.tencent.qqnt.graytips.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.JsonGrayElement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/graytips/api/impl/NtGrayTipApiImpl;", "Lcom/tencent/qqnt/graytips/api/INtGrayTipApi;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/graytips/local/LocalGrayTip;", "localGrayTip", "Lcom/tencent/qqnt/kernel/nativeinterface/IAddJsonGrayTipMsgCallback;", "cb", "", "addLocalGrayTip", "<init>", "()V", "Companion", "a", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class NtGrayTipApiImpl implements INtGrayTipApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "NtGrayTipApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/graytips/api/impl/NtGrayTipApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.graytips.api.impl.NtGrayTipApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30262);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NtGrayTipApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addLocalGrayTip$lambda$0(IAddJsonGrayTipMsgCallback iAddJsonGrayTipMsgCallback, int i3, long j3) {
        QLog.d(TAG, 1, "addLocalGrayTip result=" + i3 + ",msgId=" + j3);
        if (iAddJsonGrayTipMsgCallback != null) {
            iAddJsonGrayTipMsgCallback.onResult(i3, j3);
        }
    }

    @Override // com.tencent.qqnt.graytips.api.INtGrayTipApi
    public void addLocalGrayTip(@NotNull AppRuntime app, @NotNull LocalGrayTip localGrayTip, @Nullable final IAddJsonGrayTipMsgCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, app, localGrayTip, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(localGrayTip, "localGrayTip");
        w msgService = ((IKernelService) app.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            return;
        }
        msgService.y0(new Contact(localGrayTip.a(), localGrayTip.g(), ""), new JsonGrayElement(localGrayTip.b(), localGrayTip.d().toString(), localGrayTip.h(), false, null), localGrayTip.c(), localGrayTip.f(), localGrayTip.e(), new IAddJsonGrayTipMsgCallback() { // from class: com.tencent.qqnt.graytips.api.impl.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback
            public final void onResult(int i3, long j3) {
                NtGrayTipApiImpl.addLocalGrayTip$lambda$0(IAddJsonGrayTipMsgCallback.this, i3, j3);
            }
        });
    }
}
