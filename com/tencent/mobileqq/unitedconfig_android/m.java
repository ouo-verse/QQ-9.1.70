package com.tencent.mobileqq.unitedconfig_android;

import android.os.Bundle;
import com.tencent.freesia.GetConfigRsp;
import com.tencent.freesia.MSFObserverCenter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00102\u00020\u0001:\u0002\u0011\u0012B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/unitedconfig_android/m;", "Lmqq/observer/BusinessObserver;", "", "type", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "", "onReceive", "Lcom/tencent/freesia/MSFObserverCenter;", "d", "Lcom/tencent/freesia/MSFObserverCenter;", "msfObserverCenter", "<init>", "()V", "e", "a", "b", "UnitedConfig-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class m implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MSFObserverCenter msfObserverCenter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/unitedconfig_android/m$a;", "", "Lcom/tencent/mobileqq/unitedconfig_android/m;", "a", "<init>", "()V", "UnitedConfig-sdk_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.unitedconfig_android.m$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final m a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (m) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return b.f306053a.a();
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/unitedconfig_android/m$b;", "", "Lcom/tencent/mobileqq/unitedconfig_android/m;", "b", "Lcom/tencent/mobileqq/unitedconfig_android/m;", "a", "()Lcom/tencent/mobileqq/unitedconfig_android/m;", "INSTANCE", "<init>", "()V", "UnitedConfig-sdk_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f306053a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final m INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35129);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f306053a = new b();
                INSTANCE = new m();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final m a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (m) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return INSTANCE;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35132);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MSFObserverCenter a16 = com.tencent.freesia.b.a();
        Intrinsics.checkNotNull(a16);
        this.msfObserverCenter = a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Bundle bundle, m this$0, boolean z16, int i3) {
        GetConfigRsp getConfigRsp;
        String string;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string2 = bundle.getString(CheckForwardServlet.KEY_CMD);
        if (string2 != null && (getConfigRsp = (GetConfigRsp) bundle.getParcelable("result")) != null && (string = bundle.getString("uin")) != null) {
            this$0.msfObserverCenter.onReceive(z16, bundle.getInt("result_code", 0), string, string2, i3, getConfigRsp);
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int type, final boolean isSuccess, @Nullable final Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), bundle);
        } else {
            if (bundle == null) {
                return;
            }
            final int i3 = bundle.getInt("request_seq");
            new h().d(i3, isSuccess);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.unitedconfig_android.l
                @Override // java.lang.Runnable
                public final void run() {
                    m.b(bundle, this, isSuccess, i3);
                }
            }, 64, null, true);
        }
    }
}
