package com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AskAnonymouslyUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016JM\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\r\"\u0004\u0018\u00010\u0004H\u0014\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/jsp/AskAnonymouslyApiPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "()V", "getNameSpace", "", "handleJsRequest", "", "listener", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "url", PushClientConstants.TAG_PKG_NAME, "method", "args", "", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "Companion", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class AskAnonymouslyApiPlugin extends WebViewPlugin {
    static IPatchRedirector $redirector_ = null;
    public static final int CALL_SHARE_ACTIVITY = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int DO_NOT_CALL_SHARE_ACTIVITY = 1;
    public static final int INVITE_FOR_FRIEND_AND_GROUP = 0;
    public static final int INVITE_FOR_QZONE = 1;

    @NotNull
    public static final String KEY_IMAGE_URL = "image_url";

    @NotNull
    public static final String KEY_INVITE_TYPE = "invite_type";

    @NotNull
    public static final String KEY_JUMP_URL = "jump_url";

    @NotNull
    public static final String KEY_SHARE_TYPE = "share_type";

    @NotNull
    public static final String METHOD_INVITE = "invite";

    @NotNull
    public static final String METHOD_SHARE_DETAIL_TO_QZONE = "shareDetailToQZone";

    @NotNull
    public static final String NAME_SPACE = "askanonymously";

    @NotNull
    public static final String TAG = "AskAnonymouslyApiPlugin";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/jsp/AskAnonymouslyApiPlugin$Companion;", "", "()V", "CALL_SHARE_ACTIVITY", "", "DO_NOT_CALL_SHARE_ACTIVITY", "INVITE_FOR_FRIEND_AND_GROUP", "INVITE_FOR_QZONE", "KEY_IMAGE_URL", "", "KEY_INVITE_TYPE", "KEY_JUMP_URL", "KEY_SHARE_TYPE", "METHOD_INVITE", "METHOD_SHARE_DETAIL_TO_QZONE", "NAME_SPACE", "TAG", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18404);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AskAnonymouslyApiPlugin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NotNull
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return NAME_SPACE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(@Nullable JsBridgeListener listener, @Nullable String url, @Nullable String pkgName, @Nullable String method, @NotNull String... args) {
        boolean equals;
        boolean equals2;
        boolean equals3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, listener, url, pkgName, method, args)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(args, "args");
        if (!TextUtils.isEmpty(url)) {
            equals = StringsKt__StringsJVMKt.equals(pkgName, NAME_SPACE, true);
            if (equals) {
                equals2 = StringsKt__StringsJVMKt.equals("invite", method, true);
                Activity activity = null;
                if (!equals2) {
                    equals3 = StringsKt__StringsJVMKt.equals(METHOD_SHARE_DETAIL_TO_QZONE, method, true);
                    if (equals3) {
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "Call method invite");
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(args[0]);
                            String optString = jSONObject.optString("jump_url");
                            String optString2 = jSONObject.optString("image_url");
                            int optInt = jSONObject.optInt(KEY_SHARE_TYPE, 0);
                            if (optInt != 0) {
                                if (optInt != 1) {
                                    QLog.e(TAG, 2, "shareDetailToQZone shareType invalid: " + optInt);
                                } else {
                                    AskAnonymouslyUtil.Companion companion = AskAnonymouslyUtil.INSTANCE;
                                    WebViewPlugin.b bVar = this.mRuntime;
                                    if (bVar != null) {
                                        activity = bVar.a();
                                    }
                                    companion.syncDetailToQZone(activity, optString2, optString);
                                }
                            } else {
                                AskAnonymouslyUtil.Companion companion2 = AskAnonymouslyUtil.INSTANCE;
                                WebViewPlugin.b bVar2 = this.mRuntime;
                                if (bVar2 != null) {
                                    activity = bVar2.a();
                                }
                                companion2.shareDetailToQZone(activity, optString2, optString);
                            }
                        } catch (JSONException e16) {
                            QLog.e(TAG, 2, e16.getMessage(), e16);
                        }
                    }
                    QLog.e(TAG, 1, "Call askanonymously jsapi error, method not match");
                    return false;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "Call method invite");
                }
                try {
                    int optInt2 = new JSONObject(args[0]).optInt(KEY_INVITE_TYPE, 0);
                    if (optInt2 != 0) {
                        if (optInt2 != 1) {
                            QLog.e(TAG, 2, "invite inviteType invalid: " + optInt2);
                        } else {
                            AskAnonymouslyUtil.Companion companion3 = AskAnonymouslyUtil.INSTANCE;
                            WebViewPlugin.b bVar3 = this.mRuntime;
                            if (bVar3 != null) {
                                activity = bVar3.a();
                            }
                            companion3.shareInviteToQZone(activity);
                        }
                    } else {
                        AskAnonymouslyUtil.Companion companion4 = AskAnonymouslyUtil.INSTANCE;
                        WebViewPlugin.b bVar4 = this.mRuntime;
                        if (bVar4 != null) {
                            activity = bVar4.a();
                        }
                        companion4.inviteAskAnonymously(activity, false);
                    }
                } catch (JSONException e17) {
                    QLog.e(TAG, 2, e17.getMessage(), e17);
                }
                return true;
            }
            QLog.e(TAG, 1, "Call askanonymously jsapi error, package not match");
            return false;
        }
        QLog.e(TAG, 1, "Call askanonymously jsapi error, url is empty");
        return false;
    }
}
