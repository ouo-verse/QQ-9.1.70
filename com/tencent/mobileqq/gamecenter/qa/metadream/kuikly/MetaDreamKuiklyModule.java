package com.tencent.mobileqq.gamecenter.qa.metadream.kuikly;

import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gamecenter.metadream.fragment.GameMetaDreamMsgCenterFragment;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamService;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.minigame.api.IMetaFarmWidgetApi;
import com.tencent.mobileqq.minigame.jsplugin.QQWidgetJsPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import i01.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import vd1.MetaDreamUnreadMsgInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J5\u0010\u000e\u001a\u00020\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J5\u0010\u000f\u001a\u00020\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J5\u0010\u0010\u001a\u00020\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002JI\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/metadream/kuikly/MetaDreamKuiklyModule;", "Li01/e;", "", "params", "", "i", "g", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "c", "d", "a", "method", "call", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class MetaDreamKuiklyModule extends e {
    private final void a(final Function1<Object, Unit> callback) {
        QLog.d("MetaDreamKuiklyModule", 1, QQWidgetJsPlugin.EVENT_ADD_WIDGET);
        ((IMetaFarmWidgetApi) QRoute.api(IMetaFarmWidgetApi.class)).addWidget(new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.gamecenter.qa.metadream.kuikly.MetaDreamKuiklyModule$addWidget$1
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
                Map mapOf;
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Function1<Object, Unit> function1 = callback;
                if (function1 != null) {
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("retCode", Integer.valueOf(i3)), TuplesKt.to("retMsg", errMsg));
                    function1.invoke(mapOf);
                }
            }
        });
    }

    private final void c(Function1<Object, Unit> callback) {
        Map mapOf;
        QLog.d("MetaDreamKuiklyModule", 1, "getUnreadMsgInfo");
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMetaDreamService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026ssConstant.MAIN\n        )");
        MetaDreamUnreadMsgInfo metaDreamUnreadMsgInfo = ((IMetaDreamService) runtimeService).getMetaDreamUnreadMsgInfo();
        if (callback != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("msgCount", Integer.valueOf(metaDreamUnreadMsgInfo.getUnreadCount())), TuplesKt.to("latestMsgTime", Long.valueOf(metaDreamUnreadMsgInfo.getLastestMsgTime())));
            callback.invoke(mapOf);
        }
    }

    private final void d(Function1<Object, Unit> callback) {
        Map mapOf;
        QLog.d("MetaDreamKuiklyModule", 1, "hasWidget");
        if (callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("hasWidget", Boolean.valueOf(((IMetaFarmWidgetApi) QRoute.api(IMetaFarmWidgetApi.class)).hasWidget())));
            callback.invoke(mapOf);
        }
    }

    private final void g(String params) {
        QLog.d("MetaDreamKuiklyModule", 1, "openMsgList params:" + params);
        int optInt = new JSONObject(params).optInt("tabIndex");
        Object requestWithReturn = QRoute.createNavigator(getActivity(), "/metadream/msgcenter").requestWithReturn();
        Intrinsics.checkNotNull(requestWithReturn, "null cannot be cast to non-null type com.tencent.mobileqq.fragment.QPublicBaseFragment");
        Intent intent = new Intent();
        intent.putExtra(GameMetaDreamMsgCenterFragment.EXTRA_META_DREAM_MSG_TAB_INDEX, optInt);
        QPublicFragmentActivity.start(getActivity(), intent, ((QPublicBaseFragment) requestWithReturn).getClass());
    }

    private final void i(String params) {
        QLog.d("MetaDreamKuiklyModule", 1, "sayHello");
        JSONObject jSONObject = new JSONObject(params);
        String selfTinyId = jSONObject.optString("selfTinyId");
        String peerTinyId = jSONObject.optString("peerTinyId");
        String optString = jSONObject.optString("selfOpenId");
        String optString2 = jSONObject.optString("peerOpenId");
        String optString3 = jSONObject.optString("selfRoleId");
        String optString4 = jSONObject.optString("peerRoleId");
        String optString5 = jSONObject.optString(PreloadTRTCPlayerParams.KEY_SIG);
        IGameMsgNtApi iGameMsgNtApi = (IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class);
        Intrinsics.checkNotNullExpressionValue(selfTinyId, "selfTinyId");
        long parseLong = Long.parseLong(selfTinyId);
        Intrinsics.checkNotNullExpressionValue(peerTinyId, "peerTinyId");
        ((IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class)).enterGameMsgAio(getContext(), iGameMsgNtApi.createUidFromTinyId(parseLong, Long.parseLong(peerTinyId)), optString4, optString3, optString2, optString, peerTinyId, selfTinyId, "1112198072", optString5, "", 0, 8, false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -2012993625:
                if (method.equals("sayHello")) {
                    Intrinsics.checkNotNull(params);
                    i(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -168297090:
                if (method.equals("hasWidget")) {
                    d(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 104792645:
                if (method.equals(QQWidgetJsPlugin.EVENT_ADD_WIDGET)) {
                    a(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 831980906:
                if (method.equals("getUnreadMsgInfo")) {
                    c(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1146670613:
                if (method.equals("openMsgList")) {
                    Intrinsics.checkNotNull(params);
                    g(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }
}
