package com.tencent.qq.minibox.proxy;

import android.app.Activity;
import android.content.Context;
import com.tencent.minibox.proxy.CallHostCallback;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.minigame.api.CreateColorNoteCallback;
import com.tencent.mobileqq.minigame.api.IMetaFarmWidgetApi;
import com.tencent.mobileqq.minigame.api.IMiniGameVAColorNote;
import com.tencent.mobileqq.minigame.api.IMiniGameVAShareApi;
import com.tencent.mobileqq.minigame.jsplugin.QQWidgetJsPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifiphoto.fragment.RequestApplyFragment;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000eB\u001f\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0006\u0010\f\u001a\u00020\u0006R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qq/minibox/proxy/MiniBoxHostAction;", "", "", "optType", "", "isSuccess", "", "e", "", "errCode", "errMsg", "d", "f", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "b", "Ljava/lang/String;", "params", "Lcom/tencent/minibox/proxy/CallHostCallback;", "c", "Lcom/tencent/minibox/proxy/CallHostCallback;", "callback", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/minibox/proxy/CallHostCallback;)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MiniBoxHostAction {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String params;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CallHostCallback callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0007R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0007R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0007R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0007R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0007R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0007\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qq/minibox/proxy/MiniBoxHostAction$a;", "", "", "params", "", "a", RequestApplyFragment.ERROR_CODE, "Ljava/lang/String;", "", "ERROR_FAIL", "I", "ERROR_MSG", "ERROR_SUCCESS", "EVENT_DATA", "EVENT_NAME", "EVENT_OPT", "MINI_APP_ID", "MINI_APP_NAME", "NEED_TRANSPARENT_FRAGMENT", "OPT_TYPE", "TAG", "TYPE_ADD_COLOR_SIGN", "TYPE_ADD_DESKTOP", "TYPE_ADD_WIDGET", "TYPE_IS_COLOR_SIGN_EXIST", "TYPE_IS_DESKTOP_EXIST", "TYPE_IS_WIDGET_EXIST", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qq.minibox.proxy.MiniBoxHostAction$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull String params) {
            Intrinsics.checkNotNullParameter(params, "params");
            try {
                JSONObject jSONObject = new JSONObject(params);
                String optString = jSONObject.optString("OptType");
                if (jSONObject.optBoolean("need_transparent_fragment", false) || Intrinsics.areEqual("addDesktop", optString) || Intrinsics.areEqual("isDesktopExist", optString)) {
                    return true;
                }
                if (Intrinsics.areEqual("addColorSign", optString)) {
                    return true;
                }
                return false;
            } catch (JSONException e16) {
                QLog.e("[MiniBox-callHost]MiniBoxHostAction", 1, e16, new Object[0]);
                return false;
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qq/minibox/proxy/MiniBoxHostAction$b", "Lcom/tencent/mobileqq/minigame/api/CreateColorNoteCallback;", "Lcom/tencent/mobileqq/minigame/api/IMiniGameVAColorNote;", "colorNode", "", "onCreate", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements CreateColorNoteCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f344583b;

        b(String str) {
            this.f344583b = str;
        }

        @Override // com.tencent.mobileqq.minigame.api.CreateColorNoteCallback
        public void onCreate(@Nullable IMiniGameVAColorNote colorNode) {
            if (colorNode == null) {
                MiniBoxHostAction miniBoxHostAction = MiniBoxHostAction.this;
                String optType = this.f344583b;
                Intrinsics.checkNotNullExpressionValue(optType, "optType");
                miniBoxHostAction.e(optType, false);
                return;
            }
            boolean isExistColorNote = colorNode.isExistColorNote();
            colorNode.onDestroy();
            MiniBoxHostAction miniBoxHostAction2 = MiniBoxHostAction.this;
            String optType2 = this.f344583b;
            Intrinsics.checkNotNullExpressionValue(optType2, "optType");
            miniBoxHostAction2.e(optType2, isExistColorNote);
        }
    }

    public MiniBoxHostAction(@NotNull Context context, @NotNull String params, @NotNull CallHostCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.context = context;
        this.params = params;
        this.callback = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(String optType, int errCode, String errMsg) {
        CallHostCallback callHostCallback = this.callback;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("EventName", "notify-opt");
        jSONObject.put("OptType", optType);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("errCode", errCode);
        jSONObject2.put("errMsg", errMsg);
        Unit unit = Unit.INSTANCE;
        jSONObject.put("Data", jSONObject2);
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "JSONObject().apply {\n   \u2026  })\n        }.toString()");
        callHostCallback.response(jSONObject3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(String optType, boolean isSuccess) {
        int i3;
        if (isSuccess) {
            i3 = 0;
        } else {
            i3 = -1;
        }
        d(optType, i3, "");
    }

    public final void f() {
        try {
            QLog.i("[MiniBox-callHost]MiniBoxHostAction", 1, "perform params:" + this.params);
            JSONObject jSONObject = new JSONObject(this.params);
            final String optType = jSONObject.optString("OptType");
            if (optType != null) {
                switch (optType.hashCode()) {
                    case -1225342239:
                        if (!optType.equals("isColorSignExist")) {
                            break;
                        } else {
                            if (!(this.context instanceof Activity)) {
                                QLog.e("[MiniBox-callHost]MiniBoxHostAction", 1, "context error");
                                e(optType, false);
                                return;
                            }
                            IMiniGameVAShareApi iMiniGameVAShareApi = (IMiniGameVAShareApi) QRoute.api(IMiniGameVAShareApi.class);
                            Activity activity = (Activity) this.context;
                            String optString = jSONObject.optString("miniAppId");
                            Intrinsics.checkNotNullExpressionValue(optString, "paramsObj.optString(MINI_APP_ID)");
                            iMiniGameVAShareApi.createMiniGameVAColorNote(activity, optString, new b(optType));
                            return;
                        }
                    case -829626309:
                        if (!optType.equals("addDesktop")) {
                            break;
                        } else {
                            if (!(this.context instanceof Activity)) {
                                QLog.e("[MiniBox-callHost]MiniBoxHostAction", 1, "context error");
                                e(optType, false);
                                return;
                            }
                            IMiniGameVAShareApi iMiniGameVAShareApi2 = (IMiniGameVAShareApi) QRoute.api(IMiniGameVAShareApi.class);
                            Activity activity2 = (Activity) this.context;
                            String optString2 = jSONObject.optString("miniAppId");
                            Intrinsics.checkNotNullExpressionValue(optString2, "paramsObj.optString(MINI_APP_ID)");
                            iMiniGameVAShareApi2.addShortcut(activity2, optString2, new Function1<Boolean, Unit>() { // from class: com.tencent.qq.minibox.proxy.MiniBoxHostAction$perform$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                    invoke(bool.booleanValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z16) {
                                    MiniBoxHostAction miniBoxHostAction = MiniBoxHostAction.this;
                                    String optType2 = optType;
                                    Intrinsics.checkNotNullExpressionValue(optType2, "optType");
                                    miniBoxHostAction.e(optType2, z16);
                                }
                            });
                            return;
                        }
                    case 104792645:
                        if (!optType.equals(QQWidgetJsPlugin.EVENT_ADD_WIDGET)) {
                            break;
                        } else {
                            ((IMetaFarmWidgetApi) QRoute.api(IMetaFarmWidgetApi.class)).addWidget(new Function2<Integer, String, Unit>() { // from class: com.tencent.qq.minibox.proxy.MiniBoxHostAction$perform$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                                    invoke(num.intValue(), str);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int i3, @NotNull String errMsg) {
                                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                                    MiniBoxHostAction miniBoxHostAction = MiniBoxHostAction.this;
                                    String optType2 = optType;
                                    Intrinsics.checkNotNullExpressionValue(optType2, "optType");
                                    miniBoxHostAction.d(optType2, i3, errMsg);
                                }
                            });
                            return;
                        }
                    case 215322245:
                        if (!optType.equals("isDesktopExist")) {
                            break;
                        } else {
                            if (!(this.context instanceof Activity)) {
                                QLog.e("[MiniBox-callHost]MiniBoxHostAction", 1, "context error");
                                e(optType, false);
                                return;
                            }
                            IMiniGameVAShareApi iMiniGameVAShareApi3 = (IMiniGameVAShareApi) QRoute.api(IMiniGameVAShareApi.class);
                            Activity activity3 = (Activity) this.context;
                            String optString3 = jSONObject.optString("miniAppId");
                            Intrinsics.checkNotNullExpressionValue(optString3, "paramsObj.optString(MINI_APP_ID)");
                            String optString4 = jSONObject.optString(MiniChatConstants.MINI_APP_NAME);
                            Intrinsics.checkNotNullExpressionValue(optString4, "paramsObj.optString(MINI_APP_NAME)");
                            e(optType, iMiniGameVAShareApi3.isMiniGameShortcutExist(activity3, optString3, optString4));
                            return;
                        }
                    case 1842996255:
                        if (!optType.equals("addColorSign")) {
                            break;
                        } else {
                            if (!(this.context instanceof Activity)) {
                                QLog.e("[MiniBox-callHost]MiniBoxHostAction", 1, "context error");
                                e(optType, false);
                                return;
                            }
                            IMiniGameVAShareApi iMiniGameVAShareApi4 = (IMiniGameVAShareApi) QRoute.api(IMiniGameVAShareApi.class);
                            Activity activity4 = (Activity) this.context;
                            String optString5 = jSONObject.optString("miniAppId");
                            Intrinsics.checkNotNullExpressionValue(optString5, "paramsObj.optString(MINI_APP_ID)");
                            iMiniGameVAShareApi4.createMiniGameVAColorNote(activity4, optString5, new CreateColorNoteCallback() { // from class: com.tencent.qq.minibox.proxy.MiniBoxHostAction$perform$3
                                @Override // com.tencent.mobileqq.minigame.api.CreateColorNoteCallback
                                public void onCreate(@Nullable final IMiniGameVAColorNote colorNode) {
                                    if (colorNode == null) {
                                        MiniBoxHostAction miniBoxHostAction = MiniBoxHostAction.this;
                                        String optType2 = optType;
                                        Intrinsics.checkNotNullExpressionValue(optType2, "optType");
                                        miniBoxHostAction.e(optType2, false);
                                        return;
                                    }
                                    final MiniBoxHostAction miniBoxHostAction2 = MiniBoxHostAction.this;
                                    final String str = optType;
                                    colorNode.addToColorNote(new Function1<Boolean, Unit>() { // from class: com.tencent.qq.minibox.proxy.MiniBoxHostAction$perform$3$onCreate$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                            invoke(bool.booleanValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(boolean z16) {
                                            Context context;
                                            Context context2;
                                            if (z16) {
                                                context2 = MiniBoxHostAction.this.context;
                                                QQToast.makeText(context2, 2, "\u5f69\u7b7e\u5df2\u6dfb\u52a0", 1).show();
                                            } else {
                                                context = MiniBoxHostAction.this.context;
                                                QQToast.makeText(context, 1, "\u5f69\u7b7e\u6dfb\u52a0\u5931\u8d25", 1).show();
                                            }
                                            colorNode.onDestroy();
                                            MiniBoxHostAction miniBoxHostAction3 = MiniBoxHostAction.this;
                                            String optType3 = str;
                                            Intrinsics.checkNotNullExpressionValue(optType3, "optType");
                                            miniBoxHostAction3.e(optType3, z16);
                                        }
                                    });
                                }
                            });
                            return;
                        }
                    case 1937999753:
                        if (!optType.equals("isWidgetExist")) {
                            break;
                        } else {
                            e(optType, ((IMetaFarmWidgetApi) QRoute.api(IMetaFarmWidgetApi.class)).hasWidget());
                            return;
                        }
                }
            }
            Intrinsics.checkNotNullExpressionValue(optType, "optType");
            d(optType, -1, "not support optType");
        } catch (Exception e16) {
            QLog.e("[MiniBox-callHost]MiniBoxHostAction", 1, e16, new Object[0]);
        }
    }
}
