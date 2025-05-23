package com.tencent.mobileqq.loginregister.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gateway.localphone.ecdh.g;
import com.tencent.mobileqq.loginregister.ILocalPhoneHttpModuleApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.login.GetLocalPhone$MaskPhoneData;
import tencent.im.login.GetLocalPhone$OIDBGetPhoneRsp;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/loginregister/impl/LocalPhoneHttpModuleApiImpl;", "Lcom/tencent/mobileqq/loginregister/ILocalPhoneHttpModuleApi;", "", "serviceType", "Lcom/tencent/mobileqq/loginregister/ILocalPhoneHttpModuleApi$a;", "maskPhoneCallback", "", "getMaskPhoneNum", "Landroid/os/Bundle;", "extra", "Lcom/tencent/mobileqq/loginregister/ILocalPhoneHttpModuleApi$b;", "phoneNumCallback", "getPhoneToken", "<init>", "()V", "Companion", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LocalPhoneHttpModuleApiImpl implements ILocalPhoneHttpModuleApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "LocalPhoneHttpModuleApiImpl";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/loginregister/impl/LocalPhoneHttpModuleApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.loginregister.impl.LocalPhoneHttpModuleApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/loginregister/impl/LocalPhoneHttpModuleApiImpl$b", "Lne1/a;", "Ltencent/im/login/GetLocalPhone$OIDBGetPhoneRsp;", "data", "", "a", "", "errorCode", "", "errorMsg", "onFail", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements ne1.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ILocalPhoneHttpModuleApi.a f242848a;

        b(ILocalPhoneHttpModuleApi.a aVar) {
            this.f242848a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // ne1.a
        public void a(@NotNull GetLocalPhone$OIDBGetPhoneRsp data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            GetLocalPhone$MaskPhoneData getLocalPhone$MaskPhoneData = data.msg_mask_phone_data.get();
            QLog.d(LocalPhoneHttpModuleApiImpl.TAG, 2, "LocalPhoneComponent onSuccess maskPhone: " + getLocalPhone$MaskPhoneData.str_mask_phone.get());
            this.f242848a.b(getLocalPhone$MaskPhoneData);
        }

        @Override // ne1.a
        public void onFail(int errorCode, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
                return;
            }
            QLog.e(LocalPhoneHttpModuleApiImpl.TAG, 1, "getMaskPhoneNum onException code: " + errorCode + " ", errorMsg);
            this.f242848a.a(errorCode, new Exception(errorMsg));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/loginregister/impl/LocalPhoneHttpModuleApiImpl$c", "Lne1/a;", "Ltencent/im/login/GetLocalPhone$OIDBGetPhoneRsp;", "data", "", "a", "", "errorCode", "", "errorMsg", "onFail", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements ne1.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ILocalPhoneHttpModuleApi.b f242849a;

        c(ILocalPhoneHttpModuleApi.b bVar) {
            this.f242849a = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            }
        }

        @Override // ne1.a
        public void a(@NotNull GetLocalPhone$OIDBGetPhoneRsp data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            this.f242849a.b(data.msg_encrypt_phone_data.get());
        }

        @Override // ne1.a
        public void onFail(int errorCode, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
                return;
            }
            QLog.e(LocalPhoneHttpModuleApiImpl.TAG, 1, "getMaskPhoneNum onException code: " + errorCode + " ", errorMsg);
            this.f242849a.a(errorCode, new Exception(errorMsg));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24315);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LocalPhoneHttpModuleApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMaskPhoneNum$lambda$0(int i3, ILocalPhoneHttpModuleApi.a aVar) {
        g.n(1, i3, new b(aVar), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPhoneToken$lambda$1(int i3, Bundle bundle, ILocalPhoneHttpModuleApi.b bVar) {
        g.m(3, i3, new c(bVar), bundle);
    }

    @Override // com.tencent.mobileqq.loginregister.ILocalPhoneHttpModuleApi
    public void getMaskPhoneNum(final int serviceType, @Nullable final ILocalPhoneHttpModuleApi.a maskPhoneCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, serviceType, (Object) maskPhoneCallback);
        } else if (maskPhoneCallback == null) {
            QLog.e(TAG, 1, "getMaskPhoneNum callback is null");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.loginregister.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    LocalPhoneHttpModuleApiImpl.getMaskPhoneNum$lambda$0(serviceType, maskPhoneCallback);
                }
            }, 128, null, false);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILocalPhoneHttpModuleApi
    public void getPhoneToken(final int serviceType, @Nullable final Bundle extra, @Nullable final ILocalPhoneHttpModuleApi.b phoneNumCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(serviceType), extra, phoneNumCallback);
        } else if (phoneNumCallback == null) {
            QLog.e(TAG, 1, "getPhoneToken callback is null");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.loginregister.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    LocalPhoneHttpModuleApiImpl.getPhoneToken$lambda$1(serviceType, extra, phoneNumCallback);
                }
            }, 128, null, false);
        }
    }
}
