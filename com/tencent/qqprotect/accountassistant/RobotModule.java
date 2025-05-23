package com.tencent.qqprotect.accountassistant;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.c;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.accountassistant.chat.data.model.cache.d;
import cooperation.qzone.QzoneIPCModule;
import i01.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u000b2\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\"\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u0007H\u0002J?\u0010\u0019\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\u0018\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012j\u0004\u0018\u0001`\u0017H\u0002J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J?\u0010 \u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\u0018\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012j\u0004\u0018\u0001`\u0017H\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\b\u0010\"\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020#H\u0002JI\u0010&\u001a\u0004\u0018\u00010\u00132\u0006\u0010%\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\u0018\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012j\u0004\u0018\u0001`\u0017H\u0016R;\u0010)\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012j\u0004\u0018\u0001`\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/\u00a8\u00066"}, d2 = {"Lcom/tencent/qqprotect/accountassistant/RobotModule;", "Li01/e;", "", "B", "", "params", HippyTKDListViewAdapter.X, "", "code", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "onActivityResult", "intent", "v", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "y", "w", "l", BdhLogUtil.LogTag.Tag_Conn, "r", "t", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "", "u", "method", "call", "d", "Lkotlin/jvm/functions/Function1;", "puzzleVerifyCallback", "", "e", "Z", "isAddLifeCallback", "f", "Ljava/lang/String;", "uin", h.F, "pwd", "<init>", "()V", "a", "qqprotect-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotModule extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> puzzleVerifyCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isAddLifeCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pwd;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqprotect/accountassistant/RobotModule$a;", "", "", "METHOD_CLEAR_CACHE", "Ljava/lang/String;", "METHOD_DELETE_MSG", "METHOD_GET_APPID", "METHOD_GET_BEFORE_MSG", "METHOD_GET_GUID", "METHOD_GET_LAST_SUCCESS_MSG", "METHOD_GET_SERVER_TIME", "METHOD_INSERT_MSG", "METHOD_LOGIN", "METHOD_NOTIFY_OPEN_RESULT", "METHOD_PUZZLE_VERIFY", "METHOD_SEND_REQUEST", "METHOD_UPDATE_MSG", "", "REQUEST_PUZZLE_VERIFY_CODE", "I", "TAG", "<init>", "()V", "qqprotect-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqprotect.accountassistant.RobotModule$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqprotect/accountassistant/RobotModule$b", "Lcom/tencent/kuikly/core/render/android/c;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "qqprotect-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RobotModule.this);
            }
        }

        @Override // com.tencent.kuikly.core.render.android.c
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                RobotModule.this.onActivityResult(requestCode, resultCode, data);
            } else {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17555);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RobotModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.uin = "";
            this.pwd = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Function1 function1, int i3, byte[] bArr) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ret", i3);
        if (bArr != null) {
            jSONObject.put("data", PluginBaseInfoHelper.Base64Helper.encodeToString(bArr, 0));
        }
        if (function1 != null) {
            function1.invoke(jSONObject);
        }
    }

    private final void B() {
        Intent intent = new Intent();
        intent.putExtra("uin", this.uin);
        ClipboardManager clipboardManager = (ClipboardManager) MobileQQ.sMobileQQ.getSystemService("clipboard");
        if (clipboardManager != null) {
            ClipboardMonitor.setPrimaryClip(clipboardManager, ClipData.newPlainText("RobotModule", this.pwd));
        }
        intent.putExtra("loginFragmentType", 5);
        RouteUtils.startActivity(getContext(), intent, RouterConstants.UI_ROUTER_LOGIN);
    }

    private final void C(String params) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        d.f363456a.k(new JSONObject(new JSONObject(params).optString(QQPermissionConstants.Permission.AUIDO_GROUP)));
    }

    private final void i() {
        if (!this.isAddLifeCallback) {
            this.isAddLifeCallback = true;
            addKuiklyRenderLifecycleCallback(new b());
        }
    }

    private final String j() {
        if (d.f363456a.d()) {
            return "0";
        }
        return "-1";
    }

    private final void l(String params) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        d.f363456a.e(new JSONObject(new JSONObject(params).optString(QQPermissionConstants.Permission.AUIDO_GROUP)));
    }

    private final String m(int code, String data) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", code);
        jSONObject.put("data", data);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ata)\n        }.toString()");
        return jSONObject2;
    }

    static /* synthetic */ String o(RobotModule robotModule, int i3, String str, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = "";
        }
        return robotModule.m(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2) {
            v(data, resultCode);
        }
    }

    private final int p() {
        return AppSetting.f();
    }

    private final String q() {
        return zy3.a.b();
    }

    private final String r(String params) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "";
        }
        String id5 = new JSONObject(params).optString("conversationID");
        d dVar = d.f363456a;
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        com.tencent.qqprotect.accountassistant.chat.data.model.db.c g16 = dVar.g(id5);
        if (g16 == null) {
            return "";
        }
        String d16 = com.tencent.qqprotect.accountassistant.chat.data.model.db.c.d(g16);
        Intrinsics.checkNotNullExpressionValue(d16, "toJson(record)");
        return d16;
    }

    private final String t(String params) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "";
        }
        JSONObject jSONObject = new JSONObject(params);
        String conversionID = jSONObject.optString("conversationID");
        long optLong = jSONObject.optLong("rowID");
        int optInt = jSONObject.optInt("count");
        d dVar = d.f363456a;
        Intrinsics.checkNotNullExpressionValue(conversionID, "conversionID");
        List<com.tencent.qqprotect.accountassistant.chat.data.model.db.c> h16 = dVar.h(conversionID, optLong, optInt);
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = h16.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(com.tencent.qqprotect.accountassistant.chat.data.model.db.c.d((com.tencent.qqprotect.accountassistant.chat.data.model.db.c) it.next()));
        }
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "array.toString()");
        return jSONArray2;
    }

    private final long u() {
        return zy3.a.c();
    }

    private final void v(Intent intent, int resultCode) {
        String str;
        if (resultCode != -1) {
            Function1<Object, Unit> function1 = this.puzzleVerifyCallback;
            if (function1 != null) {
                function1.invoke(o(this, -1, null, 2, null));
                return;
            }
            return;
        }
        if (intent == null || (str = intent.getStringExtra("data")) == null) {
            str = "";
        }
        Function1<Object, Unit> function12 = this.puzzleVerifyCallback;
        if (function12 != null) {
            function12.invoke(m(0, str));
        }
    }

    private final void w(String params) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        d.f363456a.i(new JSONArray(params));
    }

    private final void x(String params) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        int optInt = jSONObject.optInt("retcode");
        String msg2 = jSONObject.optString("msg");
        if (optInt == 0) {
            com.tencent.qqprotect.accountassistant.chat.service.b bVar = com.tencent.qqprotect.accountassistant.chat.service.b.f363485a;
            bVar.k(new Function2<String, String, Unit>() { // from class: com.tencent.qqprotect.accountassistant.RobotModule$notifyOpenChatResult$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) RobotModule.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                    invoke2(str, str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String uin, @NotNull String pwd) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin, (Object) pwd);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(uin, "uin");
                    Intrinsics.checkNotNullParameter(pwd, "pwd");
                    RobotModule.this.uin = uin;
                    RobotModule.this.pwd = pwd;
                    Context context = RobotModule.this.getContext();
                    if (context != null) {
                        l.e(context, "findPwdSuccess", new JSONObject());
                    }
                }
            });
            bVar.j(new Function1<Boolean, Unit>() { // from class: com.tencent.qqprotect.accountassistant.RobotModule$notifyOpenChatResult$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) RobotModule.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, z17);
                        return;
                    }
                    Context context = RobotModule.this.getContext();
                    if (context != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("isSuccess", z17);
                        Unit unit = Unit.INSTANCE;
                        l.e(context, "checkFaceResult", jSONObject2);
                    }
                }
            });
            com.tencent.qqprotect.qsec.utils.a.f363534a.b();
            return;
        }
        com.tencent.qqprotect.qsec.utils.a aVar = com.tencent.qqprotect.qsec.utils.a.f363534a;
        Intrinsics.checkNotNullExpressionValue(msg2, "msg");
        aVar.a(optInt, msg2);
    }

    private final void y(String params, Function1<Object, Unit> callback) {
        boolean z16;
        boolean z17 = false;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("RobotModule", 1, "puzzleVerify params empty");
            if (callback != null) {
                callback.invoke(o(this, -1, null, 2, null));
                return;
            }
            return;
        }
        String url = new JSONObject(params).optString("url");
        Intrinsics.checkNotNullExpressionValue(url, "url");
        if (url.length() == 0) {
            z17 = true;
        }
        if (z17) {
            QLog.e("RobotModule", 1, "puzzleVerify url empty");
            if (callback != null) {
                callback.invoke(o(this, -1, null, 2, null));
                return;
            }
            return;
        }
        i();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserActivity"));
        intent.putExtra("url", url);
        this.puzzleVerifyCallback = callback;
        Activity activity = getActivity();
        if (activity != null) {
            activity.startActivityForResult(intent, 2);
        }
    }

    private final void z(String params, final Function1<Object, Unit> callback) {
        boolean z16;
        boolean z17;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString("cmd");
        String optString2 = jSONObject.optString("data");
        if (optString != null && optString.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            QLog.e("RobotModule", 1, "sendO3PbRequest cmd is empty");
            return;
        }
        AppRuntime a16 = zy3.a.a();
        if (!(a16 instanceof AppInterface)) {
            QLog.e("RobotModule", 1, "sendO3PbRequest appInterface error");
        } else {
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).sendRequest((AppInterface) a16, optString, PluginBaseInfoHelper.Base64Helper.decode(optString2, 0), new com.tencent.mobileqq.dt.api.a() { // from class: com.tencent.qqprotect.accountassistant.a
                @Override // com.tencent.mobileqq.dt.api.a
                public final void onResult(int i3, byte[] bArr) {
                    RobotModule.A(Function1.this, i3, bArr);
                }
            });
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, method, params, callback);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.i("RobotModule", 1, method + " params is empty");
        }
        switch (method.hashCode()) {
            case -1172322898:
                if (method.equals("toLogin")) {
                    B();
                    return null;
                }
                return null;
            case -936075689:
                if (method.equals("puzzleVerify")) {
                    y(params, callback);
                    return null;
                }
                return null;
            case -934458917:
                if (method.equals("getServerMsgTimeMS")) {
                    return Long.valueOf(u());
                }
                return null;
            case -759238347:
                if (method.equals(HippyReporter.RemoveEngineReason.CLEAR_CACHE)) {
                    j();
                    return null;
                }
                return null;
            case -541025538:
                if (method.equals("updateMessage")) {
                    C(params);
                    return null;
                }
                return null;
            case -75497729:
                if (method.equals("getGuid")) {
                    return q();
                }
                return null;
            case -29493710:
                if (method.equals("getSubAppId")) {
                    return Integer.valueOf(p());
                }
                return null;
            case 750152668:
                if (method.equals("deleteMessage")) {
                    l(params);
                    return null;
                }
                return null;
            case 1119192752:
                if (method.equals("getMessageBefore")) {
                    return t(params);
                }
                return null;
            case 1369685601:
                if (method.equals("getLatestSuccessMessage")) {
                    return r(params);
                }
                return null;
            case 1393870417:
                if (method.equals("sendO3PbRequest")) {
                    z(params, callback);
                    return null;
                }
                return null;
            case 1451295528:
                if (method.equals("notifyOpenChatResult")) {
                    x(params);
                    return null;
                }
                return null;
            case 1522567889:
                if (method.equals("insertOrUpdateMessages")) {
                    w(params);
                    return null;
                }
                return null;
            default:
                return null;
        }
    }
}
