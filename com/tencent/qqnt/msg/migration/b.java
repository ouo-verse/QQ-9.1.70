package com.tencent.qqnt.msg.migration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006JO\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0003H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/msg/migration/b;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "", "", "args", "p", "([Ljava/lang/String;)Ljava/lang/String;", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "handleJsRequest", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "getNameSpace", "<init>", "()V", "d", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/msg/migration/b$a;", "", "", "KEY_BACK_UPGRADE_SWITCH", "Ljava/lang/String;", "KEY_RESULT", "METHOD_GET_BACK_UPGRADE_SWITCH", "METHOD_SET_BACK_UPGRADE_SWITCH", "NAMESPACE", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.msg.migration.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64047);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String p(String... args) {
        Object firstOrNull;
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(args);
        String str = (String) firstOrNull;
        if (str != null) {
            try {
                return new JSONObject(str).optString("callback");
            } catch (JSONException unused) {
                return null;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NotNull
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "NtMigration";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(@Nullable JsBridgeListener listener, @Nullable String url, @Nullable String pkgName, @Nullable String method, @NotNull String... args) {
        Object firstOrNull;
        boolean z16;
        String str;
        Activity a16;
        Intent intent;
        Bundle extras;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, listener, url, pkgName, method, args)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(args, "args");
        if (method == null) {
            return false;
        }
        QLog.d("NTMigrationPlugin", 1, "handleJsRequest " + method);
        String str2 = null;
        if (Intrinsics.areEqual(method, "getBackUpgradeSwitch")) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str2 = peekAppRuntime.getCurrentAccountUin();
            }
            if (str2 == null) {
                return false;
            }
            String p16 = p((String[]) Arrays.copyOf(args, args.length));
            if (p16 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("retCode", 0);
                jSONObject.put("backUpgradeSwitch", NTMsgMigrationManager.INSTANCE.a().U(str2) ? 1 : 0);
                callJs(p16, jSONObject.toString());
            }
        } else if (Intrinsics.areEqual(method, "setBackUpgradeSwitch")) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(args);
            String str3 = (String) firstOrNull;
            if (str3 != null) {
                try {
                    AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime2 != null) {
                        str2 = peekAppRuntime2.getCurrentAccountUin();
                    }
                    if (str2 == null) {
                        return false;
                    }
                    Intrinsics.checkNotNullExpressionValue(str2, "MobileQQ.sMobileQQ.peekA\u2026ccountUin ?: return false");
                    int optInt = new JSONObject(str3).optInt("backUpgradeSwitch", -1);
                    if (optInt != -1) {
                        NTMsgMigrationManager a17 = NTMsgMigrationManager.INSTANCE.a();
                        if (optInt == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        a17.e1(str2, z16);
                        WebViewPlugin.b bVar = this.mRuntime;
                        if (bVar != null && (a16 = bVar.a()) != null && (intent = a16.getIntent()) != null && (extras = intent.getExtras()) != null) {
                            i3 = extras.getInt("migration_user_type");
                        }
                        int i16 = i3;
                        AppRuntime peekAppRuntime3 = MobileQQ.sMobileQQ.peekAppRuntime();
                        if (optInt == 1) {
                            str = "1";
                        } else {
                            str = "2";
                        }
                        ReportController.o(peekAppRuntime3, "dc00898", "", "", "0X800C513", "0X800C513", i16, 0, str, "", "", "");
                    }
                } catch (JSONException unused) {
                }
            }
        }
        return super.handleJsRequest(listener, url, pkgName, method, (String[]) Arrays.copyOf(args, args.length));
    }
}
