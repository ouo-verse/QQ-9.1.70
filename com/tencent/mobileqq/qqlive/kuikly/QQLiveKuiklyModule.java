package com.tencent.mobileqq.qqlive.kuikly;

import android.os.Bundle;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.ipc.QQLiveIPCConstants;
import com.tencent.mobileqq.qqlive.api.room.IQQLiveHuYaRoomApi;
import com.tencent.mobileqq.qqlive.base.ipc.QQLiveClientQIPCModule;
import com.tencent.mobileqq.qqlive.huya.QQLiveHuYaUrlManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import i01.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0012\u001bB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u000e\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u000f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0010\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0011\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J5\u0010\u0012\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JE\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JI\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qqlive/kuikly/QQLiveKuiklyModule;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "d", "g", "i", "a", "", "code", "msg", "c", "method", "call", "<init>", "()V", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveKuiklyModule extends e {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B>\u0012+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006j\u0004\u0018\u0001`\f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018JE\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006j\u0004\u0018\u0001`\fH\u0002J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000fH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R=\u0010\u0016\u001a+\u0012%\u0012#\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\f\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqlive/kuikly/QQLiveKuiklyModule$b;", "Leipc/EIPCResultCallback;", "", "code", "", "msg", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "a", "Leipc/EIPCResult;", "onCallback", "d", "Ljava/lang/String;", "Lmqq/util/WeakReference;", "e", "Lmqq/util/WeakReference;", "callbackRef", "<init>", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String msg;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final WeakReference<Function1<Object, Unit>> callbackRef;

        public b(@Nullable Function1<Object, Unit> function1, @Nullable String str) {
            WeakReference<Function1<Object, Unit>> weakReference;
            this.msg = str;
            if (function1 != null) {
                weakReference = new WeakReference<>(function1);
            } else {
                weakReference = null;
            }
            this.callbackRef = weakReference;
        }

        private final void a(int code, String msg2, Function1<Object, Unit> callback) {
            Map mapOf;
            if (callback != null) {
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("code", Integer.valueOf(code)), TuplesKt.to("msg", msg2));
                callback.invoke(mapOf);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(@Nullable EIPCResult result) {
            Function1<Object, Unit> function1;
            String string;
            WeakReference<Function1<Object, Unit>> weakReference = this.callbackRef;
            if (weakReference != null) {
                function1 = weakReference.get();
            } else {
                function1 = null;
            }
            if (result == null) {
                a(-2, this.msg + " callback null", function1);
                return;
            }
            String str = "";
            if (result.isSuccess()) {
                a(0, "", function1);
                return;
            }
            int i3 = result.code;
            Bundle bundle = result.data;
            if (bundle != null && (string = bundle.getString(QQLiveIPCConstants.Param.PARAM_KUIKLY_CALLBACK_MSG)) != null) {
                str = string;
            }
            a(i3, str, function1);
        }
    }

    private final void a(Function1<Object, Unit> callback) {
        QQLiveHuYaUrlManager.f271340a.a();
        c(0, "success", callback);
    }

    private final void c(int code, String msg2, Function1<Object, Unit> callback) {
        Map mapOf;
        if (callback != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("code", Integer.valueOf(code)), TuplesKt.to("msg", msg2));
            callback.invoke(mapOf);
        }
    }

    private final void d(String params, Function1<Object, Unit> callback) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            c(-1, "error params", callback);
            return;
        }
        QQLiveClientQIPCModule.Companion companion = QQLiveClientQIPCModule.INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putString(QQLiveIPCConstants.Param.PARAM_KUIKLY_PARAMS, params);
        Unit unit = Unit.INSTANCE;
        companion.a(QQLiveIPCConstants.Action.ACTION_QQLIVE_ENTER_GAME_INVITE_ROOM, bundle, new b(callback, "enter game invite room"));
    }

    private final void g(String params, Function1<Object, Unit> callback) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            c(-1, "error params", callback);
            return;
        }
        QQLiveClientQIPCModule.Companion companion = QQLiveClientQIPCModule.INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putString(QQLiveIPCConstants.Param.PARAM_KUIKLY_PARAMS, params);
        Unit unit = Unit.INSTANCE;
        companion.a(QQLiveIPCConstants.Action.ACTION_QQLIVE_EXIT_ROOM, bundle, new b(callback, "exit room"));
    }

    private final void i(String params, final Function1<Object, Unit> callback) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            c(-1, "error params", callback);
            return;
        }
        try {
            String optString = new JSONObject(params).optString("roomID");
            Intrinsics.checkNotNullExpressionValue(optString, "data.optString(\"roomID\")");
            ((IQQLiveHuYaRoomApi) QRoute.api(IQQLiveHuYaRoomApi.class)).getHuYaRoomPreviewUrl(Long.parseLong(optString), new Function1<String, Void>() { // from class: com.tencent.mobileqq.qqlive.kuikly.QQLiveKuiklyModule$fetchHuyaUrl$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Void invoke(@Nullable String str) {
                    Map mapOf;
                    Function1<Object, Unit> function1 = callback;
                    if (function1 == null) {
                        return null;
                    }
                    Pair[] pairArr = new Pair[2];
                    pairArr[0] = TuplesKt.to("retCode", Integer.valueOf(str == null || str.length() == 0 ? -1 : 0));
                    pairArr[1] = TuplesKt.to("urlWithToken", str);
                    mapOf = MapsKt__MapsKt.mapOf(pairArr);
                    function1.invoke(mapOf);
                    return null;
                }
            });
        } catch (Exception e16) {
            QLog.e("QQLiveKuiklyModule", 2, "fetchHuyaUrl exception:", e16);
        }
    }

    private final void j(String params, Function1<Object, Unit> callback) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            c(-1, "error params", callback);
            return;
        }
        QQLiveClientQIPCModule.Companion companion = QQLiveClientQIPCModule.INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putString(QQLiveIPCConstants.Param.PARAM_KUIKLY_PARAMS, params);
        Unit unit = Unit.INSTANCE;
        companion.a(QQLiveIPCConstants.Action.ACTION_QQLIVE_FOLLOW_ANCHOR, bundle, new b(callback, "follow anchor"));
    }

    private final void l(String params, Function1<Object, Unit> callback) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            c(-1, "error params", callback);
            return;
        }
        QQLiveClientQIPCModule.Companion companion = QQLiveClientQIPCModule.INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putString(QQLiveIPCConstants.Param.PARAM_KUIKLY_PARAMS, params);
        Unit unit = Unit.INSTANCE;
        companion.a(QQLiveIPCConstants.Action.ACTION_QQLIVE_SEND_COMMENT, bundle, new b(callback, "send comment"));
    }

    private final void m(String params, Function1<Object, Unit> callback) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            c(-1, "error params", callback);
            return;
        }
        QQLiveClientQIPCModule.Companion companion = QQLiveClientQIPCModule.INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putString(QQLiveIPCConstants.Param.PARAM_KUIKLY_PARAMS, params);
        Unit unit = Unit.INSTANCE;
        companion.a(QQLiveIPCConstants.Action.ACTION_QQLIVE_SEND_FREE_LOVE, bundle, new b(callback, "send free love"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -2122780903:
                if (method.equals("exitRoom")) {
                    g(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1183252416:
                if (method.equals("fetchHuyaUrl")) {
                    i(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1116248154:
                if (method.equals("sendFreeLove")) {
                    m(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -245181938:
                if (method.equals("enterGameInviteRoom")) {
                    d(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 686927287:
                if (method.equals("sendComment")) {
                    l(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1251620173:
                if (method.equals("clearHuyaUrl")) {
                    a(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1385931206:
                if (method.equals("followAnchor")) {
                    j(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }
}
