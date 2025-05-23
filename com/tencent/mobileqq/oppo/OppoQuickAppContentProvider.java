package com.tencent.mobileqq.oppo;

import android.os.Bundle;
import com.tencent.common.config.pad.g;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.hapjs.storage.BaseSharedProvider;
import org.hapjs.storage.IStorage;
import org.hapjs.storage.InstantStorage;
import org.hapjs.storage.Request;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u000b*\u0001\u0014\u0018\u0000 \u001a2\u00020\u0001:\u0003\u001b\u001c\u001dB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0016\u0010\u0013\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/oppo/OppoQuickAppContentProvider;", "Lorg/hapjs/storage/BaseSharedProvider;", "Lcom/tencent/mobileqq/oppo/OppoQuickAppContentProvider$b;", "k", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "Lorg/json/JSONObject;", "data", DomainData.DOMAIN_NAME, "Landroid/os/Bundle;", "l", "", "onCreate", "Lorg/hapjs/storage/Request;", Const.BUNDLE_KEY_REQUEST, "doHandleRequestData", "d", "Z", "isFirstRefresh", "com/tencent/mobileqq/oppo/OppoQuickAppContentProvider$d", "e", "Lcom/tencent/mobileqq/oppo/OppoQuickAppContentProvider$d;", "accountCallback", "<init>", "()V", "f", "a", "b", "c", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OppoQuickAppContentProvider extends BaseSharedProvider {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private static Boolean f256980h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private static Boolean f256981i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstRefresh;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d accountCallback;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0011\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0014\u0010\u0013\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0007R\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0007R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/oppo/OppoQuickAppContentProvider$a;", "", "", "c", "d", "", "CONFIG_ID_OPPO_CARD_PSKEY", "Ljava/lang/String;", "", "ERROR_CODE_APP_NULL", "I", "ERROR_CODE_DATA_EMPTY", "ERROR_CODE_NOT_LOGIN", "", "EXPIRED_TIME_IN_MILLS", "J", "QCIRCLE_FRIEND_RECOMMEND_KEY", "QUICK_APP_DOMAIN", "QUICK_APP_PACKAGE_NAME", "SYNC_AWAIT_TIME_IN_SEC", "TAG", "VALUE_KEY_PSKEY", "VALUE_KEY_UIN", "sIsEnableGetPskey", "Ljava/lang/Boolean;", "sIsOnlyOppo", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.oppo.OppoQuickAppContentProvider$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean c() {
            if (OppoQuickAppContentProvider.f256980h == null) {
                OppoQuickAppContentProvider.f256980h = Boolean.valueOf(com.tencent.mobileqq.troop.config.b.f294691a.h("20727", true));
            }
            Boolean bool = OppoQuickAppContentProvider.f256980h;
            Intrinsics.checkNotNull(bool);
            return bool.booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d() {
            if (OppoQuickAppContentProvider.f256981i == null) {
                OppoQuickAppContentProvider.f256981i = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("oppo_quick_app_content_only_oppo", true));
            }
            Boolean bool = OppoQuickAppContentProvider.f256981i;
            Intrinsics.checkNotNull(bool);
            return bool.booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/oppo/OppoQuickAppContentProvider$b;", "", "<init>", "()V", "a", "b", "Lcom/tencent/mobileqq/oppo/OppoQuickAppContentProvider$b$a;", "Lcom/tencent/mobileqq/oppo/OppoQuickAppContentProvider$b$b;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static abstract class b {
        static IPatchRedirector $redirector_;

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/oppo/OppoQuickAppContentProvider$b$a;", "Lcom/tencent/mobileqq/oppo/OppoQuickAppContentProvider$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "getErrorCode", "()I", "errorCode", "b", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "errorMsg", "<init>", "(ILjava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes16.dex */
        public static final /* data */ class a extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final int errorCode;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final String errorMsg;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(int i3, @NotNull String errorMsg) {
                super(null);
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) errorMsg);
                } else {
                    this.errorCode = i3;
                    this.errorMsg = errorMsg;
                }
            }

            public boolean equals(@Nullable Object other) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
                }
                if (this == other) {
                    return true;
                }
                if (!(other instanceof a)) {
                    return false;
                }
                a aVar = (a) other;
                if (this.errorCode == aVar.errorCode && Intrinsics.areEqual(this.errorMsg, aVar.errorMsg)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
                }
                return (this.errorCode * 31) + this.errorMsg.hashCode();
            }

            @NotNull
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return (String) iPatchRedirector.redirect((short) 7, (Object) this);
                }
                return "Error(errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ")";
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/oppo/OppoQuickAppContentProvider$b$b;", "Lcom/tencent/mobileqq/oppo/OppoQuickAppContentProvider$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lorg/json/JSONObject;", "a", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "data", "<init>", "(Lorg/json/JSONObject;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.oppo.OppoQuickAppContentProvider$b$b, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        public static final /* data */ class C8193b extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final JSONObject data;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C8193b(@NotNull JSONObject data) {
                super(null);
                Intrinsics.checkNotNullParameter(data, "data");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) data);
                } else {
                    this.data = data;
                }
            }

            @NotNull
            public final JSONObject a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.data;
            }

            public boolean equals(@Nullable Object other) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
                }
                if (this == other) {
                    return true;
                }
                if ((other instanceof C8193b) && Intrinsics.areEqual(this.data, ((C8193b) other).data)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
                }
                return this.data.hashCode();
            }

            @NotNull
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (String) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                return "Succeed(data=" + this.data + ")";
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/oppo/OppoQuickAppContentProvider$c;", "", "", "domain", "a", "Lcom/tencent/mobileqq/pskey/api/IPskeyManager;", "Lcom/tencent/mobileqq/pskey/api/IPskeyManager;", "psKeyManager", "Lmqq/app/AppRuntime;", "app", "<init>", "(Lmqq/app/AppRuntime;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final IPskeyManager psKeyManager;

        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/oppo/OppoQuickAppContentProvider$c$a", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes16.dex */
        public static final class a implements sd2.a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicReference<Map<String, String>> f256988a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ CountDownLatch f256989b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ AtomicReference<String> f256990c;

            a(AtomicReference<Map<String, String>> atomicReference, CountDownLatch countDownLatch, AtomicReference<String> atomicReference2) {
                this.f256988a = atomicReference;
                this.f256989b = countDownLatch;
                this.f256990c = atomicReference2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, atomicReference, countDownLatch, atomicReference2);
                }
            }

            @Override // sd2.a
            public void onFail(@NotNull String errMsg) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) errMsg);
                    return;
                }
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.i("OppoQuickAppContentProvider", 1, "replace pskey failed= " + errMsg);
                this.f256990c.set(errMsg);
                this.f256989b.countDown();
            }

            @Override // sd2.a
            public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) domainToKeyMap);
                    return;
                }
                Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
                QLog.i("OppoQuickAppContentProvider", 1, "replace pskey = " + domainToKeyMap.size());
                this.f256988a.set(domainToKeyMap);
                this.f256989b.countDown();
            }
        }

        public c(@NotNull AppRuntime app) {
            Intrinsics.checkNotNullParameter(app, "app");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) app);
                return;
            }
            IRuntimeService runtimeService = app.getRuntimeService(IPskeyManager.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IP\u2026ava, ProcessConstant.ALL)");
            this.psKeyManager = (IPskeyManager) runtimeService;
        }

        @NotNull
        public final String a(@NotNull String domain) throws InterruptedException, ExecutionException, TimeoutException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) domain);
            }
            Intrinsics.checkNotNullParameter(domain, "domain");
            Object obj = "";
            if (!OppoQuickAppContentProvider.INSTANCE.c()) {
                return "";
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            AtomicReference atomicReference = new AtomicReference();
            AtomicReference atomicReference2 = new AtomicReference();
            this.psKeyManager.replacePskey(new String[]{domain}, new a(atomicReference, countDownLatch, atomicReference2));
            if (countDownLatch.await(5L, TimeUnit.SECONDS)) {
                if (atomicReference2.get() == null) {
                    Object obj2 = atomicReference.get();
                    Intrinsics.checkNotNullExpressionValue(obj2, "resultRef.get()");
                    Object obj3 = ((Map) obj2).get(domain);
                    if (obj3 != null) {
                        obj = obj3;
                    }
                    return (String) obj;
                }
                throw new ExecutionException((String) atomicReference2.get(), null);
            }
            throw new TimeoutException("Operation timed out after 5 seconds");
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/oppo/OppoQuickAppContentProvider$d", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements IAccountCallback {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OppoQuickAppContentProvider.this);
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) newRuntime);
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(@Nullable AppRuntime newRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) newRuntime);
            } else if (!OppoQuickAppContentProvider.this.isFirstRefresh) {
                OppoQuickAppContentProvider.this.m();
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(@Nullable Constants.LogoutReason reason) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                OppoQuickAppContentProvider.this.j();
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) reason);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/oppo/OppoQuickAppContentProvider$e", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class e implements sd2.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppRuntime f256993b;

        e(AppRuntime appRuntime) {
            this.f256993b = appRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OppoQuickAppContentProvider.this, (Object) appRuntime);
            }
        }

        @Override // sd2.a
        public void onFail(@NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.i("OppoQuickAppContentProvider", 1, "replace pskey failed= " + errMsg);
        }

        @Override // sd2.a
        public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) domainToKeyMap);
                return;
            }
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            boolean z16 = true;
            QLog.i("OppoQuickAppContentProvider", 1, "replace pskey = " + domainToKeyMap.size());
            String str = domainToKeyMap.get(FlockBaseRequest.QUN_DOMAIN);
            if (str != null && str.length() != 0) {
                z16 = false;
            }
            if (!z16) {
                JSONObject jSONObject = new JSONObject();
                AppRuntime appRuntime = this.f256993b;
                jSONObject.put("pskey", str);
                jSONObject.put("uin", appRuntime.getCurrentAccountUin());
                OppoQuickAppContentProvider.this.n(jSONObject);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23406);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public OppoQuickAppContentProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isFirstRefresh = true;
            this.accountCallback = new d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        QLog.i("OppoQuickAppContentProvider", 1, "clearData");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pskey", "");
        jSONObject.put("uin", "");
        n(jSONObject);
    }

    private final b k() {
        boolean z16;
        String str;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        boolean z17 = true;
        if (waitAppRuntime == null) {
            QLog.e("OppoQuickAppContentProvider", 1, "handleQCircleCardRequest failed, app is null");
            return new b.a(-2, "app is null");
        }
        if (waitAppRuntime.isLogin()) {
            String currentAccountUin = waitAppRuntime.getCurrentAccountUin();
            if (currentAccountUin != null && currentAccountUin.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                try {
                    str = new c(waitAppRuntime).a(FlockBaseRequest.QUN_DOMAIN);
                } catch (Throwable th5) {
                    QLog.e("OppoQuickAppContentProvider", 1, "syncGetPskey failed, e=" + th5.getMessage());
                    str = "";
                }
                if (str.length() != 0) {
                    z17 = false;
                }
                if (z17) {
                    return new b.a(-3, "pskey and data both null");
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pskey", str);
                jSONObject.put("uin", waitAppRuntime.getCurrentAccountUin());
                return new b.C8193b(jSONObject);
            }
        }
        return new b.a(-1, "app is not login");
    }

    private final Bundle l() {
        b k3 = k();
        if (k3 instanceof b.a) {
            QLog.i("OppoQuickAppContentProvider", 1, "handleQCircleCardRequest, result=" + k3 + " ");
            return null;
        }
        if (k3 instanceof b.C8193b) {
            Bundle bundle = new Bundle();
            bundle.putString(BaseSharedProvider.RESPONSE_REQUEST_DATA_DATA, ((b.C8193b) k3).a().toString());
            bundle.putLong(BaseSharedProvider.RESPONSE_REQUEST_DATA_EXPIRED, 43200000L);
            return bundle;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        AppRuntime appRuntime;
        if (!INSTANCE.c()) {
            return;
        }
        this.isFirstRefresh = false;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            return;
        }
        QLog.i("OppoQuickAppContentProvider", 1, "refreshData, uin->" + appRuntime.getCurrentAccountUin());
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IPskeyManager.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IP\u2026ava, ProcessConstant.ALL)");
        ((IPskeyManager) runtimeService).replacePskey(new String[]{FlockBaseRequest.QUN_DOMAIN}, new e(appRuntime));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(final JSONObject data) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.oppo.a
            @Override // java.lang.Runnable
            public final void run() {
                OppoQuickAppContentProvider.o(JSONObject.this);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(JSONObject data) {
        Integer num;
        Intrinsics.checkNotNullParameter(data, "$data");
        IStorage storage = InstantStorage.INSTANCE.getStorage("com.tencent.mobileqq.oppo.quickapp");
        if (storage != null) {
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String jSONObject = data.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "data.toString()");
            num = Integer.valueOf(storage.setSharedData(context, "qcircle.friend.recommend", jSONObject, 43200000L));
        } else {
            num = null;
        }
        QLog.i("OppoQuickAppContentProvider", 1, "updateDataToStorage " + num);
    }

    @Override // org.hapjs.storage.BaseSharedProvider
    @Nullable
    public Bundle doHandleRequestData(@NotNull Request request) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bundle) iPatchRedirector.redirect((short) 3, (Object) this, (Object) request);
        }
        Intrinsics.checkNotNullParameter(request, "request");
        String mCaller = request.getMCaller();
        String mKey = request.getMKey();
        QLog.i("OppoQuickAppContentProvider", 1, "doHandleRequestData, caller=" + mCaller + " key=" + mKey);
        if (!Intrinsics.areEqual(mCaller, "com.tencent.mobileqq.oppo.quickapp") || !Intrinsics.areEqual(mKey, "qcircle.friend.recommend")) {
            return null;
        }
        return l();
    }

    @Override // org.hapjs.storage.BaseSharedProvider, android.content.ContentProvider
    public boolean onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (g.d() || !INSTANCE.d()) {
            QLog.d("OppoQuickAppContentProvider", 1, "onCreate");
            com.tencent.mobileqq.oppo.b.f256995a.a(new Function0<Unit>() { // from class: com.tencent.mobileqq.oppo.OppoQuickAppContentProvider$onCreate$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OppoQuickAppContentProvider.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        OppoQuickAppContentProvider.this.m();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null) {
                mobileQQ.registerAccountCallback(this.accountCallback);
            }
        }
        return super.onCreate();
    }
}
