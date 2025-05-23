package com.tencent.mobileqq.pskey;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\u0013B\u0013\b\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\f\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/pskey/e;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "Landroid/os/Bundle;", "data", "", "callbackId", "", "d", "", "", "domainToPskeyMap", "keyType", "e", "action", "Leipc/EIPCResult;", "onCall", "name", "<init>", "(Ljava/lang/String;)V", "a", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final e f261164e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/pskey/e$a;", "", "Lcom/tencent/mobileqq/pskey/e;", "a", "", "ACTION_GET_PSKEY_FROM_REQUEST", "Ljava/lang/String;", "INSTANCE", "Lcom/tencent/mobileqq/pskey/e;", "KEY_DOMAINS", "KEY_ERR_MSG", "KEY_ERR_MSG_OK", "KEY_REQUEST_TYPE", "KEY_RESULT_MAP_DOMAINS", "KEY_RESULT_MAP_KEYS", "TAG", "<init>", "()V", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.pskey.e$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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
        public final e a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return e.f261164e;
            }
            return (e) iPatchRedirector.redirect((short) 2, (Object) this);
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
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/pskey/e$b", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements sd2.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f261166b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f261167c;

        b(int i3, int i16) {
            this.f261166b = i3;
            this.f261167c = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, e.this, Integer.valueOf(i3), Integer.valueOf(i16));
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
            QLog.e("PskeyIPCModule", 1, "callbackResult onFail");
            Bundle bundle = new Bundle();
            bundle.putString("errMsg", errMsg);
            e.this.callbackResult(this.f261167c, EIPCResult.createSuccessResult(bundle));
        }

        @Override // sd2.a
        public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) domainToKeyMap);
                return;
            }
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            if (QLog.isDevelopLevel()) {
                QLog.i("PskeyIPCModule", 4, "callbackResult onSuccess");
            }
            e.this.callbackResult(this.f261167c, EIPCResult.createSuccessResult(e.this.e(domainToKeyMap, this.f261166b)));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34993);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
            f261164e = new e("PskeyIPCModule");
        }
    }

    e(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    private final void d(Bundle data, int callbackId) {
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            AppInterface appInterface = (AppInterface) peekAppRuntime;
            String[] stringArray = data.getStringArray("domains");
            int i3 = data.getInt("key_request_type");
            if (QLog.isDevelopLevel()) {
                QLog.i("PskeyIPCModule", 4, "callbackResult domains = " + Arrays.toString(stringArray));
            }
            IPskeyManager iPskeyManager = (IPskeyManager) appInterface.getRuntimeService(IPskeyManager.class, "");
            Intrinsics.checkNotNull(stringArray);
            iPskeyManager.getPskeyFromRequest(stringArray, i3, new b(i3, callbackId));
        } catch (Throwable th5) {
            QLog.e("PskeyIPCModule", 1, "handleGetPskey Error", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle e(Map<String, String> domainToPskeyMap, int keyType) {
        Bundle bundle = new Bundle();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (Map.Entry<String, String> entry : domainToPskeyMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            arrayList.add(key);
            arrayList2.add(value);
        }
        bundle.putStringArrayList("result_map_domains", arrayList);
        bundle.putStringArrayList("result_map_keys", arrayList2);
        bundle.putString("errMsg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
        return bundle;
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@NotNull String action, @NotNull Bundle data, int callbackId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, action, data, Integer.valueOf(callbackId));
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual("action_get_pskey_ignore_local_cache", action)) {
            d(data, callbackId);
        }
        return null;
    }
}
