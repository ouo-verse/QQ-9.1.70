package com.tencent.mobileqq.dt.web;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.protobuf.nano.MessageNano;
import com.tencent.ark.ark;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.dt.data.g;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.api.IO3AssistantRobotApi;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u000489:\"B\u0007\u00a2\u0006\u0004\b6\u00107J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0016JO\u0010 \u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u001e\"\u0004\u0018\u00010\u0004H\u0014\u00a2\u0006\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/dt/web/O3WebViewPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "", "callbackId", "", "B", "u", "r", "y", "params", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ReportConstant.COSTREPORT_PREFIX, BdhLogUtil.LogTag.Tag_Conn, "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "cur", HippyTKDListViewAdapter.X, "", "t", "v", "getNameSpace", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "args", "handleJsRequest", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "d", "J", "timeSecond", "", "e", "I", "callCount", "f", "Ljava/lang/String;", "safePostDataId", h.F, "safePostData", "Lkotlinx/coroutines/CoroutineScope;", "i", "Lkotlinx/coroutines/CoroutineScope;", "mainScope", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[B", "smsToken", "<init>", "()V", "a", "b", "c", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class O3WebViewPlugin extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long timeSecond;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int callCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String safePostDataId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String safePostData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope mainScope;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private byte[] smsToken;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0004\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/dt/web/O3WebViewPlugin$a;", "", "", "BUSINESS_NAME", "Ljava/lang/String;", "JS_PARAMS_CMD", "JS_PARAMS_DATA", "JS_PARAMS_RET_CODE", "", "MAX_COUNT_SECOND", "I", "METHOD_ACCOUNT_ASSISTANT_CHECK_FACE", "METHOD_GET_FACE_VERIFY_USER_DATA", "METHOD_GET_REPORT_DATA", "METHOD_OPEN_ACCOUNT_ASSISTANT_PAGE", "METHOD_OPEN_REPORT_PAGE", "METHOD_PUZZLE_VERIFY_RESULT", "METHOD_SEND_REPORT_REQUEST", "METHOD_SEND_REQUEST", "METHOD_SEND_SMS", "METHOD_VERIFY_LOCK", "SSO_CMD_VERIFY_LOCK", "TAG", "<init>", "()V", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.dt.web.O3WebViewPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/dt/web/O3WebViewPlugin$b;", "Lcom/tencent/qqprotect/qsec/api/IO3AssistantRobotApi$a;", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFailed", "a", "Ljava/lang/String;", "callbackId", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/dt/web/O3WebViewPlugin;", "b", "Lmqq/util/WeakReference;", "plugin", "<init>", "(Ljava/lang/String;Lmqq/util/WeakReference;)V", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b implements IO3AssistantRobotApi.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String callbackId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<O3WebViewPlugin> plugin;

        public b(@NotNull String callbackId, @NotNull WeakReference<O3WebViewPlugin> plugin) {
            Intrinsics.checkNotNullParameter(callbackId, "callbackId");
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) callbackId, (Object) plugin);
            } else {
                this.callbackId = callbackId;
                this.plugin = plugin;
            }
        }

        @Override // com.tencent.qqprotect.qsec.api.IO3AssistantRobotApi.a
        public void onFailed(int errorCode, @NotNull String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            QLog.e("O3WebViewPlugin", 1, "OpenAssistant onFailed() called with: errorCode = " + errorCode + ", errorMsg = " + errorMsg);
            O3WebViewPlugin o3WebViewPlugin = this.plugin.get();
            if (o3WebViewPlugin != null) {
                String str = this.callbackId;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("retcode", errorCode);
                jSONObject.put(HippyReporter.EXTRA_KEY_REPORT_ERRMSG, errorMsg);
                Unit unit = Unit.INSTANCE;
                o3WebViewPlugin.callJs(str, jSONObject.toString());
            }
        }

        @Override // com.tencent.qqprotect.qsec.api.IO3AssistantRobotApi.a
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.i("O3WebViewPlugin", 1, "OpenAssistant onSuccess: ");
            O3WebViewPlugin o3WebViewPlugin = this.plugin.get();
            if (o3WebViewPlugin != null) {
                String str = this.callbackId;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("retcode", 0);
                Unit unit = Unit.INSTANCE;
                o3WebViewPlugin.callJs(str, jSONObject.toString());
            }
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/dt/web/O3WebViewPlugin$c;", "Lcom/tencent/mobileqq/dt/web/a;", "", "code", "", "data", "", "b", "", "f", "Ljava/lang/String;", "callbackId", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/dt/web/O3WebViewPlugin;", "kotlin.jvm.PlatformType", h.F, "Lmqq/util/WeakReference;", "ref", "plugin", "<init>", "(Lcom/tencent/mobileqq/dt/web/O3WebViewPlugin;Ljava/lang/String;)V", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class c extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String callbackId;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<O3WebViewPlugin> ref;

        public c(@NotNull O3WebViewPlugin plugin, @NotNull String callbackId) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(callbackId, "callbackId");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) plugin, (Object) callbackId);
            } else {
                this.callbackId = callbackId;
                this.ref = new WeakReference<>(plugin);
            }
        }

        @Override // com.tencent.mobileqq.dt.web.a
        public void b(int code, @NotNull byte[] data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, code, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            O3WebViewPlugin o3WebViewPlugin = this.ref.get();
            if (o3WebViewPlugin == null) {
                QLog.e("O3WebViewPlugin", 1, "onResult but ref.get() == null");
                return;
            }
            QLog.i("O3WebViewPlugin", 1, "sendRequest onResult " + code + " dataLen:" + data.length);
            String str = new String(data, Charsets.UTF_8);
            if (QLog.isColorLevel()) {
                QLog.i("O3WebViewPlugin", 2, "sendRequest onResult data is " + str);
            }
            String str2 = this.callbackId;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retcode", code);
            jSONObject.put("data", str);
            Unit unit = Unit.INSTANCE;
            o3WebViewPlugin.callJs(str2, jSONObject.toString());
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/dt/web/O3WebViewPlugin$d;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "", "d", "Ljava/lang/String;", "callbackId", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/dt/web/O3WebViewPlugin;", "kotlin.jvm.PlatformType", "e", "Lmqq/util/WeakReference;", "ref", "plugin", "<init>", "(Lcom/tencent/mobileqq/dt/web/O3WebViewPlugin;Ljava/lang/String;)V", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class d implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String callbackId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<O3WebViewPlugin> ref;

        public d(@NotNull O3WebViewPlugin plugin, @NotNull String callbackId) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(callbackId, "callbackId");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) plugin, (Object) callbackId);
            } else {
                this.callbackId = callbackId;
                this.ref = new WeakReference<>(plugin);
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
            FromServiceMsg fromServiceMsg;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), data);
                return;
            }
            QLog.i("O3WebViewPlugin", 1, "SsoVerifyAndUnLock isSuccess " + isSuccess);
            O3WebViewPlugin o3WebViewPlugin = this.ref.get();
            if (o3WebViewPlugin == null) {
                QLog.e("O3WebViewPlugin", 1, "SafeVerifyLockObserver onResult but ref.get() == null");
                return;
            }
            if (!isSuccess) {
                String str = this.callbackId;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", -1);
                Unit unit = Unit.INSTANCE;
                o3WebViewPlugin.callJs(str, jSONObject.toString());
                return;
            }
            if (data instanceof FromServiceMsg) {
                fromServiceMsg = (FromServiceMsg) data;
            } else {
                fromServiceMsg = null;
            }
            if (fromServiceMsg != null) {
                if (!fromServiceMsg.isSuccess()) {
                    QLog.i("O3WebViewPlugin", 1, "SsoVerifyAndUnLock error code is " + fromServiceMsg.getResultCode());
                    String str2 = this.callbackId;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", fromServiceMsg.getResultCode());
                    Unit unit2 = Unit.INSTANCE;
                    o3WebViewPlugin.callJs(str2, jSONObject2.toString());
                    return;
                }
                com.tencent.mobileqq.dt.data.h hVar = new com.tencent.mobileqq.dt.data.h();
                MessageNano.mergeFrom(hVar, ((FromServiceMsg) data).getWupBuffer());
                QLog.i("O3WebViewPlugin", 1, "SsoVerifyAndUnLock resp is " + hVar.f203779a);
                String str3 = this.callbackId;
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 0);
                jSONObject3.put("lockStatus", hVar.f203779a);
                Unit unit3 = Unit.INSTANCE;
                o3WebViewPlugin.callJs(str3, jSONObject3.toString());
                return;
            }
            String str4 = this.callbackId;
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("code", -1);
            Unit unit4 = Unit.INSTANCE;
            o3WebViewPlugin.callJs(str4, jSONObject4.toString());
            QLog.e("O3WebViewPlugin", 1, "SsoVerifyAndUnLock resp is null");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25435);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public O3WebViewPlugin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.safePostDataId = "";
        this.safePostData = "";
        this.mainScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate());
        this.smsToken = new byte[0];
    }

    private final void A(JSONObject params, String callbackId) {
        AppRuntime appRuntime;
        AppInterface appInterface;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (!t(currentTimeMillis)) {
            QLog.e("O3WebViewPlugin", 1, "checkFrequency error");
            return;
        }
        x(currentTimeMillis);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        O3BusinessHandler o3BusinessHandler = null;
        if (peekAppRuntime != null) {
            appRuntime = peekAppRuntime.getAppRuntime("modular_web");
        } else {
            appRuntime = null;
        }
        if (appRuntime instanceof AppInterface) {
            appInterface = (AppInterface) appRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            QLog.e("O3WebViewPlugin", 1, "sendRequest but app is null");
            return;
        }
        BusinessHandler businessHandler = appInterface.getBusinessHandler(O3BusinessHandler.class.getName());
        if (businessHandler instanceof O3BusinessHandler) {
            o3BusinessHandler = (O3BusinessHandler) businessHandler;
        }
        if (o3BusinessHandler == null) {
            QLog.e("O3WebViewPlugin", 1, "sendRequest but handler is null");
            return;
        }
        String optString = params.optString("cmd", "");
        String optString2 = params.optString("data", "");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", optString);
        jSONObject.put("data", optString2);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ams)\n        }.toString()");
        QLog.i("O3WebViewPlugin", 1, "sendRequest cmd is " + optString);
        if (QLog.isColorLevel()) {
            QLog.i("O3WebViewPlugin", 2, "sendRequest data is " + optString2);
        }
        o3BusinessHandler.D2("sendRequest", jSONObject2, new c(this, callbackId));
    }

    private final void B(JSONObject json, final String callbackId) {
        String conversationId = json.optString("conversation_id", "");
        boolean optBoolean = json.optBoolean("is_resend");
        IO3AssistantRobotApi iO3AssistantRobotApi = (IO3AssistantRobotApi) QRoute.api(IO3AssistantRobotApi.class);
        Intrinsics.checkNotNullExpressionValue(conversationId, "conversationId");
        iO3AssistantRobotApi.sendSmsCode(conversationId, optBoolean, new Function2<Integer, String, Unit>(callbackId) { // from class: com.tencent.mobileqq.dt.web.O3WebViewPlugin$sendSms$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $callbackId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$callbackId = callbackId;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) O3WebViewPlugin.this, (Object) callbackId);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String msg2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) msg2);
                    return;
                }
                Intrinsics.checkNotNullParameter(msg2, "msg");
                O3WebViewPlugin o3WebViewPlugin = O3WebViewPlugin.this;
                String str = this.$callbackId;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", i3);
                jSONObject.put(HippyReporter.EXTRA_KEY_REPORT_ERRMSG, msg2);
                Unit unit = Unit.INSTANCE;
                o3WebViewPlugin.callJs(str, jSONObject.toString());
            }
        });
    }

    private final void C(JSONObject params, String callbackId) {
        JSONObject optJSONObject = params.optJSONObject("data");
        String optString = params.optString("nativeDataKey", "");
        String optString2 = params.optString("id", "");
        v();
        if (optJSONObject != null && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            if (!optString2.equals(this.safePostDataId)) {
                QLog.e("O3WebViewPlugin", 1, "submitReport id error expect " + this.safePostDataId + " get " + optString2);
                return;
            }
            optJSONObject.put(optString, this.safePostData);
            params.put("data", optJSONObject);
            A(params, callbackId);
            return;
        }
        QLog.e("O3WebViewPlugin", 1, "submitReport params error " + params);
    }

    private final void D(JSONObject params, String callbackId) {
        AppRuntime appRuntime;
        AppInterface appInterface;
        int optInt = params.optInt("eventType");
        String optString = params.optString("resultKey", "");
        long optLong = params.optLong("nonce", 0L);
        g gVar = new g();
        gVar.f203777a = optInt;
        com.tencent.mobileqq.dt.data.b bVar = new com.tencent.mobileqq.dt.data.b();
        bVar.f203765a = optString;
        bVar.f203766b = optLong;
        gVar.f203778b = bVar;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        O3BusinessHandler o3BusinessHandler = null;
        if (peekAppRuntime != null) {
            appRuntime = peekAppRuntime.getAppRuntime("modular_web");
        } else {
            appRuntime = null;
        }
        if (appRuntime instanceof AppInterface) {
            appInterface = (AppInterface) appRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            QLog.e("O3WebViewPlugin", 1, "sendRequest but app is null");
            return;
        }
        BusinessHandler businessHandler = appInterface.getBusinessHandler(O3BusinessHandler.class.getName());
        if (businessHandler instanceof O3BusinessHandler) {
            o3BusinessHandler = (O3BusinessHandler) businessHandler;
        }
        if (o3BusinessHandler == null) {
            QLog.e("O3WebViewPlugin", 1, "sendRequest but handler is null");
            return;
        }
        byte[] byteArray = MessageNano.toByteArray(gVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        o3BusinessHandler.G2("trpc.o3.full_social_lock_punish.FullSocialLockPunish.SsoVerifyAndUnLock", byteArray, new d(this, callbackId));
    }

    private final void r(JSONObject json, String callbackId) {
        CoroutineScope coroutineScope;
        ComponentCallbacks2 a16 = this.mRuntime.a();
        if (a16 instanceof FragmentActivity) {
            coroutineScope = LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) a16);
        } else {
            QLog.e("O3WebViewPlugin", 1, "getFaceVerifyUserData activity is not FragmentActivity");
            coroutineScope = this.mainScope;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new O3WebViewPlugin$accountAssistantCheckFace$1(json, this, callbackId, null), 3, null);
    }

    private final void s(JSONObject params) {
        Activity a16;
        Activity a17;
        Intent intent = new Intent();
        intent.putExtra("data", params.toString());
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (a17 = bVar.a()) != null) {
            a17.setResult(-1, intent);
        }
        WebViewPlugin.b bVar2 = this.mRuntime;
        if (bVar2 != null && (a16 = bVar2.a()) != null) {
            a16.finish();
        }
    }

    private final boolean t(long cur) {
        if (cur == this.timeSecond && this.callCount >= 5) {
            return false;
        }
        return true;
    }

    private final void u(JSONObject json, String callbackId) {
        CoroutineScope coroutineScope;
        ComponentCallbacks2 a16 = this.mRuntime.a();
        if (a16 instanceof FragmentActivity) {
            coroutineScope = LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) a16);
        } else {
            QLog.e("O3WebViewPlugin", 1, "getFaceVerifyUserData activity is not FragmentActivity");
            coroutineScope = this.mainScope;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new O3WebViewPlugin$getFaceVerifyUserData$1(json, this, callbackId, null), 3, null);
    }

    private final void v() {
        if (TextUtils.isEmpty(this.safePostData) || TextUtils.isEmpty(this.safePostDataId)) {
            String stringExtra = this.mRuntime.a().getIntent().getStringExtra("SafeReportDataId");
            String str = "";
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.safePostDataId = stringExtra;
            String stringExtra2 = this.mRuntime.a().getIntent().getStringExtra("NewSafeReportData");
            if (stringExtra2 != null) {
                str = stringExtra2;
            }
            this.safePostData = str;
        }
    }

    private final void w(JSONObject params, String callbackId) {
        v();
        String optString = params.optString("id", "");
        JSONArray optJSONArray = params.optJSONArray("keys");
        if (!TextUtils.isEmpty(optString) && optJSONArray != null) {
            if (!optString.equals(this.safePostDataId)) {
                QLog.e("O3WebViewPlugin", 1, "getReportData id error expect " + this.safePostDataId + " get " + optString);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject(this.safePostData);
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                jSONObject.put(optJSONArray.optString(i3), jSONObject2.optString(optJSONArray.optString(i3)));
            }
            callJs(callbackId, jSONObject.toString());
            return;
        }
        QLog.e("O3WebViewPlugin", 1, "getReportData params error " + params);
    }

    private final void x(long cur) {
        if (cur != this.timeSecond) {
            this.timeSecond = cur;
            this.callCount = 1;
        } else {
            this.callCount++;
        }
    }

    private final void y(JSONObject json, String callbackId) {
        Activity a16 = this.mRuntime.a();
        if (a16 == null) {
            QLog.e("O3WebViewPlugin", 1, "activity is null");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retcode", -1);
            Unit unit = Unit.INSTANCE;
            callJs(callbackId, jSONObject.toString());
            return;
        }
        String uin = json.optString("uin");
        String uinToken = json.optString("uinToken");
        String email = json.optString("email");
        String src = json.optString("src");
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        Intrinsics.checkNotNullExpressionValue(uinToken, "uinToken");
        Intrinsics.checkNotNullExpressionValue(email, "email");
        Intrinsics.checkNotNullExpressionValue(src, "src");
        ((IO3AssistantRobotApi) QRoute.api(IO3AssistantRobotApi.class)).openO3AssistantRobotChatFrame(a16, new com.tencent.qqprotect.qsec.api.a(uin, uinToken, email, src), new b(callbackId, new WeakReference(this)));
    }

    private final void z(JSONObject params, String callbackId) {
        String optString = params.optString("appid");
        String optString2 = params.optString("token");
        IDTAPI idtapi = (IDTAPI) QRoute.api(IDTAPI.class);
        Activity a16 = this.mRuntime.a();
        com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
        bVar.i(optString);
        Bundle bundle = new Bundle();
        bundle.putString("qrt_token", optString2);
        bVar.p(bundle);
        Unit unit = Unit.INSTANCE;
        idtapi.jumpReport(a16, bVar);
        callJs(callbackId, "");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NotNull
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "o3";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(@Nullable JsBridgeListener listener, @Nullable String url, @Nullable String pkgName, @Nullable String method, @NotNull String... args) {
        boolean z16;
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, listener, url, pkgName, method, args)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(args, "args");
        if (!TextUtils.isEmpty(url) && Intrinsics.areEqual("o3", pkgName) && !TextUtils.isEmpty(method)) {
            if (args.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                jSONObject = new JSONObject(args[0]);
            } else {
                jSONObject = new JSONObject();
            }
            String optString = jSONObject.optString("callback", "");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"callback\", \"\")");
            QLog.i("O3WebViewPlugin", 1, "handlerO3JsRequest, method= " + method);
            if (method != null) {
                switch (method.hashCode()) {
                    case -954252348:
                        if (method.equals("openNativeReportPage")) {
                            z(jSONObject, optString);
                            break;
                        }
                        break;
                    case 224692813:
                        if (method.equals("accountAssistantSendSMSCode")) {
                            B(jSONObject, optString);
                            break;
                        }
                        break;
                    case 245393236:
                        if (method.equals("accountAssistantCheckFace")) {
                            r(jSONObject, optString);
                            break;
                        }
                        break;
                    case 763908810:
                        if (method.equals("openAccountAssistantPage")) {
                            y(jSONObject, optString);
                            break;
                        }
                        break;
                    case 832221671:
                        if (method.equals("sendRequest")) {
                            A(jSONObject, optString);
                            break;
                        }
                        break;
                    case 956156834:
                        if (method.equals("verifyAndUnLock")) {
                            D(jSONObject, optString);
                            break;
                        }
                        break;
                    case 1274220396:
                        if (method.equals("submitReport")) {
                            C(jSONObject, optString);
                            break;
                        }
                        break;
                    case 1633138420:
                        if (method.equals("getReportData")) {
                            w(jSONObject, optString);
                            break;
                        }
                        break;
                    case 1917972832:
                        if (method.equals("captchaResultNotify")) {
                            s(jSONObject);
                            break;
                        }
                        break;
                    case 2071720801:
                        if (method.equals("getFaceVerifyUserData")) {
                            u(jSONObject, optString);
                            break;
                        }
                        break;
                }
            }
            return true;
        }
        QLog.e("O3WebViewPlugin", 1, "url:" + url + " method:" + method + " pkgName:" + pkgName);
        return false;
    }
}
