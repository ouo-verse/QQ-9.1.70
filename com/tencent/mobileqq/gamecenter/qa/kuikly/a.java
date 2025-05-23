package com.tencent.mobileqq.gamecenter.qa.kuikly;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import i01.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0002\r\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J5\u0010\u000e\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0016JI\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/kuikly/a;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "c", "a", "d", "g", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "method", "call", "Lcom/tencent/mobileqq/gamecenter/qa/kuikly/a$b;", "Lcom/tencent/mobileqq/gamecenter/qa/kuikly/a$b;", "receiver", "<init>", "()V", "e", "b", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends e {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b receiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J.\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007R\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000fR\u0014\u0010\u001b\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000fR\u0014\u0010\u001c\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000fR\u0014\u0010\u001d\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u000f\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/kuikly/a$a;", "", "Landroid/content/Context;", "context", "", "code", "appId", "", "questionId", "", "b", "answerId", "a", "", "ACTION_RECEIVE_STRATEGY_ANSWER", "Ljava/lang/String;", "ACTION_RECEIVE_STRATEGY_QUESTION", "MODULE_NAME", "OPEN_STRATEGY_ANSWER", "OPEN_STRATEGY_QUESTION", "PARAM_ANSWER_ID", "PARAM_APP_ID", "PARAM_CODE", "PARAM_DATA", "PARAM_JUMP_URL", "PARAM_MINI_GAME_APP_ID", "PARAM_QUESTION_CONTENT", "PARAM_QUESTION_ID", "PARAM_SCENE", "TAG", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.qa.kuikly.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, int code, int appId, long questionId, long answerId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent("receiveStrategyAnswer");
            intent.putExtra("code", code);
            intent.putExtra("appId", appId);
            intent.putExtra("questionId", questionId);
            intent.putExtra("answerId", answerId);
            context.sendBroadcast(intent);
        }

        public final void b(@NotNull Context context, int code, int appId, long questionId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent("receiveStrategyQuestion");
            intent.putExtra("code", code);
            intent.putExtra("appId", appId);
            intent.putExtra("questionId", questionId);
            context.sendBroadcast(intent);
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J3\u0010\n\u001a\u00020\u00072+\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\bJ\u001c\u0010\u000f\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R;\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/kuikly/a$b;", "Landroid/content/BroadcastReceiver;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "a", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "Lkotlin/jvm/functions/Function1;", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Function1<Object, Unit> callback;

        public final void a(@Nullable Function1<Object, Unit> callback) {
            this.callback = callback;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            String str;
            Bundle bundle;
            Function1<Object, Unit> function1;
            Map mapOf;
            Function1<Object, Unit> function12;
            Map mapOf2;
            String str2 = null;
            if (intent != null) {
                str = intent.getAction();
            } else {
                str = null;
            }
            if (intent != null) {
                bundle = intent.getExtras();
            } else {
                bundle = null;
            }
            QLog.i("GameQAKuiklyModule", 1, "onReceive action:" + str + ", data:" + bundle);
            if (intent != null) {
                str2 = intent.getAction();
            }
            if (str2 != null) {
                int hashCode = str2.hashCode();
                if (hashCode != 802038484) {
                    if (hashCode == 1293529468 && str2.equals("receiveStrategyQuestion") && (function12 = this.callback) != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("appId", intent.getIntExtra("appId", 0));
                        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("code", Integer.valueOf(intent.getIntExtra("code", 0))), TuplesKt.to("data", jSONObject.put("questionId", intent.getLongExtra("questionId", 0L)).toString()));
                        function12.invoke(mapOf2);
                        return;
                    }
                    return;
                }
                if (str2.equals("receiveStrategyAnswer") && (function1 = this.callback) != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("appId", intent.getIntExtra("appId", 0));
                    jSONObject2.put("questionId", intent.getLongExtra("questionId", 0L));
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("code", 0), TuplesKt.to("data", jSONObject2.put("answerId", intent.getLongExtra("answerId", 0L)).toString()));
                    function1.invoke(mapOf);
                }
            }
        }
    }

    private final void a(String params, Function1<Object, Unit> callback) {
        boolean z16;
        Map mapOf;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (callback != null) {
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("code", -1), TuplesKt.to("msg", "error params"));
                callback.invoke(mapOf);
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).openGameStrategyAnswer(getContext(), jSONObject.optInt("appId"), jSONObject.optLong("questionId"), jSONObject.optString("questionTitle"), jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL), jSONObject.optString("data"), jSONObject.optInt("scene"), jSONObject.optInt("miniGameAppId"));
        d(callback);
    }

    private final void c(String params, Function1<Object, Unit> callback) {
        boolean z16;
        Map mapOf;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (callback != null) {
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("code", -1), TuplesKt.to("msg", "error params"));
                callback.invoke(mapOf);
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).openGameStrategyQuestion(getContext(), jSONObject.optInt("appId"), jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL), jSONObject.optString("data"), jSONObject.optInt("scene"), jSONObject.optInt("miniGameAppId"));
        d(callback);
    }

    private final void d(Function1<Object, Unit> callback) {
        Context applicationContext;
        if (this.receiver == null) {
            this.receiver = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("receiveStrategyQuestion");
            intentFilter.addAction("receiveStrategyAnswer");
            Context context = getContext();
            if (context != null && (applicationContext = context.getApplicationContext()) != null) {
                applicationContext.registerReceiver(this.receiver, intentFilter);
            }
        }
        b bVar = this.receiver;
        Intrinsics.checkNotNull(bVar);
        bVar.a(callback);
    }

    private final void g() {
        Context applicationContext;
        if (this.receiver != null) {
            try {
                Context context = getContext();
                if (context != null && (applicationContext = context.getApplicationContext()) != null) {
                    applicationContext.unregisterReceiver(this.receiver);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception e16) {
                QLog.e("GameQAKuiklyModule", 1, e16, new Object[0]);
                Unit unit2 = Unit.INSTANCE;
            }
        }
        b bVar = this.receiver;
        if (bVar != null) {
            bVar.a(null);
        }
        this.receiver = null;
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "openStrategyQuestion")) {
            c(params, callback);
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(method, "openStrategyAnswer")) {
            a(params, callback);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        g();
    }
}
