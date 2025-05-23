package com.tencent.mobileqq.troop.qrcode;

import android.os.Bundle;
import com.tencent.biz.qrcode.util.QRCodeLoadingComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRDataApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u0000 \r2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJP\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000426\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\t0\u0006H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J@\u0010\u000e\u001a\u00020\t26\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\t0\u0006H\u0016R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/ad;", "Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent$b;", "", "isSuccess", "", "chain", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "cb", "g", "d", "c", "b", "a", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "troopUin", "Z", "isSourceChainReady", "()Z", "setSourceChainReady", "(Z)V", "<init>", "(Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class ad extends QRCodeLoadingComponent.b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isSourceChainReady;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/ad$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.qrcode.ad$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/qrcode/ad$b", "Lcom/tencent/mobileqq/qrscan/o;", "", "i", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "", "onReceive", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends com.tencent.mobileqq.qrscan.o {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, String, Unit> f298174e;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Boolean, ? super String, Unit> function2) {
            this.f298174e = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ad.this, (Object) function2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00a8  */
        @Override // com.tencent.mobileqq.qrscan.o, mqq.observer.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(int i3, boolean isSuccess, @Nullable Bundle bundle) {
            String str;
            boolean z16;
            JSONObject jSONObject;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(isSuccess), bundle);
                return;
            }
            if (isSuccess && bundle != null && bundle.containsKey("result")) {
                try {
                    String string = bundle.getString("result");
                    if (string == null) {
                        string = "";
                    }
                    jSONObject = new JSONObject(string);
                    i16 = jSONObject.getInt("r");
                } catch (Throwable th5) {
                    QLog.e("ShortChainForTroopCardProcess", 2, "parse json error, e=" + th5.getMessage() + "}", th5);
                }
                if (i16 == 0) {
                    str = jSONObject.getString("url");
                    if (str == null && str.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        ad.this.g(true, str, this.f298174e);
                        return;
                    } else {
                        QLog.e("ShortChainForTroopCardProcess", 2, "parse json error, url is null or empty");
                        ad.this.g(false, "", this.f298174e);
                        return;
                    }
                }
                QLog.e("ShortChainForTroopCardProcess", 2, "parse json r !=" + i16);
                str = "";
                if (str == null) {
                }
                z16 = true;
                if (z16) {
                }
            } else {
                QLog.e("ShortChainForTroopCardProcess", 2, "onReceive error");
                ad.this.g(false, "", this.f298174e);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62239);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ad(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopUin);
        } else {
            this.troopUin = troopUin;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(boolean isSuccess, String chain, Function2<? super Boolean, ? super String, Unit> cb5) {
        QLog.i("ShortChainForTroopCardProcess", 1, "[doCallback] isSuccess = " + isSuccess + ", chain = " + chain + ", isSourceChainReady = " + this.isSourceChainReady);
        if (!this.isSourceChainReady) {
            cb5.invoke(Boolean.valueOf(isSuccess), chain);
        }
    }

    @Override // com.tencent.biz.qrcode.util.QRCodeLoadingComponent.b
    public void b(@NotNull Function2<? super Boolean, ? super String, Unit> cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(cb5, "cb");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("ShortChainForTroopCardProcess", 1, "app is null");
            g(false, "", cb5);
            return;
        }
        com.tencent.mobileqq.qrscan.m a16 = com.tencent.mobileqq.qrscan.m.a(2, this.troopUin);
        if (a16 == null) {
            QLog.e("ShortChainForTroopCardProcess", 2, "entity is null in getCardQRCode");
            g(false, "", cb5);
        } else {
            ((IQRDataApi) QRoute.api(IQRDataApi.class)).requestUrlEncode(peekAppRuntime, a16.e(), new Bundle(), new b(cb5));
        }
    }

    @Override // com.tencent.biz.qrcode.util.QRCodeLoadingComponent.b
    @NotNull
    /* renamed from: c */
    public String getF94861a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.troopUin;
    }

    @Override // com.tencent.biz.qrcode.util.QRCodeLoadingComponent.b
    @NotNull
    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "ShortChainForTroopCardProcess";
    }
}
