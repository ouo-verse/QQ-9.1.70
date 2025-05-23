package com.tencent.mobileqq.zootopia.service.api.impl;

import android.os.Bundle;
import com.google.protobuf.nano.MessageNano;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import ov4.g;
import ov4.h;
import ov4.i;
import ov4.j;
import ov4.k;
import ov4.p;
import qd3.ZootopiaSendArkResult;
import rd3.ShareTarget;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'Jc\u0010\u0011\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u00042\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J?\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u0015H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J6\u0010\u001d\u001a\u00020\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0016J4\u0010!\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0016J6\u0010\"\u001a\u00020\n2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0016J6\u0010#\u001a\u00020\n2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0016J6\u0010%\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u0015H\u0016\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/zootopia/service/api/impl/ZootopiaShareArkServiceImpl;", "Lcom/tencent/mobileqq/zootopia/service/api/IZootopiaShareArkService;", "Lcom/tencent/common/app/AppInterface;", "app", "", IZootopiaShareArkService.ARK_MAP_ID, "", IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS, "Lkotlin/Function1;", "Lqd3/a;", "", "callback", "source", "", "Lov4/p;", "shareTargets", "extInfo", "sendZootopiaShareRequest", "(Lcom/tencent/common/app/AppInterface;ILjava/lang/String;Lkotlin/jvm/functions/Function1;I[Lov4/p;Ljava/lang/String;)V", "id", "users", "Lkotlin/Function2;", "sendDressArkInfo", "(Ljava/lang/String;[Lov4/p;Lkotlin/jvm/functions/Function2;)V", "", "Lrd3/a;", "toUsers", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "sendZplanArkMessage", "Lorg/json/JSONObject;", "info", "targets", "sendGameArkMessage", "sendDressArkMessage", "sendShotArkMessage", "text", "sendZplanArkMessageToGuild", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaShareArkServiceImpl implements IZootopiaShareArkService {
    private static final String METHOD_SHARE_ARK = "SendGameShareArk";
    private static final int NO_ERROR_CODE = -999;
    private static final String SCENE_MANAGE_SERVICE = "trpc.metaverse.scene_ark_svr.SceneArkSvr";
    private static final String TAG = "ZootopiaShareArkService";
    private static final int UIN_TYPE_FRIEND = 1;
    private static final int UIN_TYPE_GROUP = 2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/service/api/impl/ZootopiaShareArkServiceImpl$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lov4/i;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<i> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, String, Unit> f329175d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f329176e;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Integer, ? super String, Unit> function2, String str) {
            this.f329175d = function2;
            this.f329176e = str;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(i result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.f329175d.invoke(0, "");
            QLog.i(ZootopiaShareArkServiceImpl.TAG, 1, "sendDressArkInfo request success");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            this.f329175d.invoke(Integer.valueOf(error), message == null ? "" : message);
            QLog.e(ZootopiaShareArkServiceImpl.TAG, 1, "sendDressArkInfo request failed " + error + " " + message);
            kb4.a.f411993a.c(this.f329176e, error);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/service/api/impl/ZootopiaShareArkServiceImpl$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lov4/k;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<k> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<ZootopiaSendArkResult, Unit> f329177d;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super ZootopiaSendArkResult, Unit> function1) {
            this.f329177d = function1;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(k result) {
            Intrinsics.checkNotNullParameter(result, "result");
            Function1<ZootopiaSendArkResult, Unit> function1 = this.f329177d;
            if (function1 != null) {
                function1.invoke(new ZootopiaSendArkResult(0, ""));
            }
            QLog.i(ZootopiaShareArkServiceImpl.TAG, 1, "sendModShareArkInfo request success");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            Function1<ZootopiaSendArkResult, Unit> function1 = this.f329177d;
            if (function1 != null) {
                function1.invoke(new ZootopiaSendArkResult(error, message == null ? "" : message));
            }
            QLog.e(ZootopiaShareArkServiceImpl.TAG, 1, "sendModShareArkInfo request failed " + error + " " + message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/api/impl/ZootopiaShareArkServiceImpl$d", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<ZootopiaSendArkResult, Unit> f329178a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super ZootopiaSendArkResult, Unit> function1) {
            this.f329178a = function1;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e(ZootopiaShareArkServiceImpl.TAG, 1, "sendZootopiaShareRequest onError " + errCode + ", " + errMsg);
            int intValue = errCode != null ? errCode.intValue() : -999;
            if (errMsg == null) {
                errMsg = "";
            }
            ZootopiaSendArkResult zootopiaSendArkResult = new ZootopiaSendArkResult(intValue, errMsg);
            Function1<ZootopiaSendArkResult, Unit> function1 = this.f329178a;
            if (function1 != null) {
                function1.invoke(zootopiaSendArkResult);
            }
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            QLog.i(ZootopiaShareArkServiceImpl.TAG, 1, "sendZootopiaShareRequest success");
            Function1<ZootopiaSendArkResult, Unit> function1 = this.f329178a;
            if (function1 != null) {
                function1.invoke(new ZootopiaSendArkResult(0, ""));
            }
        }
    }

    @Override // com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService
    public void sendDressArkMessage(List<ShareTarget> targets, Bundle extraData, final Function1<? super ZootopiaSendArkResult, Unit> callback) {
        String joinToString$default;
        String string;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(targets, "targets");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(targets, ContainerUtils.FIELD_DELIMITER, null, null, 0, null, null, 62, null);
        QLog.i(TAG, 2, "sendDressArkMessage " + joinToString$default);
        String str = "";
        if (extraData != null) {
            try {
                string = extraData.getString("forward_ark_app_meta", "");
            } catch (Throwable unused) {
                QLog.e(TAG, 1, "share dress ark error");
                return;
            }
        } else {
            string = null;
        }
        if (string != null) {
            str = string;
        }
        JSONObject optJSONObject = new JSONObject(str).optJSONObject("info");
        if (optJSONObject == null) {
            return;
        }
        String id5 = optJSONObject.optString("id");
        QLog.d(TAG, 1, "share dress ark to user " + id5);
        Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.zootopia.service.api.impl.ZootopiaShareArkServiceImpl$sendDressArkMessage$tempCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2) {
                invoke(num.intValue(), str2);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                Function1<ZootopiaSendArkResult, Unit> function1 = callback;
                if (function1 != null) {
                    function1.invoke(new ZootopiaSendArkResult(i3, message));
                }
            }
        };
        List<ShareTarget> list = targets;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (ShareTarget shareTarget : list) {
            p pVar = new p();
            pVar.f424195b = shareTarget.getId();
            pVar.f424194a = shareTarget.getType();
            arrayList.add(pVar);
        }
        Object[] array = arrayList.toArray(new p[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        sendDressArkInfo(id5, (p[]) array, function2);
    }

    @Override // com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService
    public void sendShotArkMessage(List<ShareTarget> targets, Bundle extraData, Function1<? super ZootopiaSendArkResult, Unit> callback) {
        String joinToString$default;
        String string;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(targets, "targets");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(targets, ContainerUtils.FIELD_DELIMITER, null, null, 0, null, null, 62, null);
        QLog.i(TAG, 2, "sendShotArkMessage " + joinToString$default);
        String str = "";
        if (extraData != null) {
            try {
                string = extraData.getString("forward_ark_app_meta", "");
            } catch (Throwable unused) {
                QLog.e(TAG, 1, "share mod shot ark error");
                return;
            }
        } else {
            string = null;
        }
        if (string != null) {
            str = string;
        }
        JSONObject optJSONObject = new JSONObject(str).optJSONObject("invite");
        if (optJSONObject == null) {
            return;
        }
        String optString = optJSONObject.optString("id");
        QLog.d(TAG, 1, "share mod shot ark to user " + optString);
        List<ShareTarget> list = targets;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (ShareTarget shareTarget : list) {
            p pVar = new p();
            pVar.f424195b = shareTarget.getId();
            pVar.f424194a = shareTarget.getType();
            arrayList.add(pVar);
        }
        Object[] array = arrayList.toArray(new p[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        j jVar = new j();
        jVar.f424168b = (p[]) array;
        jVar.f424167a = optString;
        mj3.a.d(mj3.a.f416866a, jVar, new c(callback), 0, 4, null);
    }

    @Override // com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService
    public void sendZplanArkMessage(List<ShareTarget> toUsers, Bundle extraData, Function1<? super ZootopiaSendArkResult, Unit> callback) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(toUsers, "toUsers");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(toUsers, ContainerUtils.FIELD_DELIMITER, null, null, 0, null, null, 62, null);
        QLog.i(TAG, 2, "sendZplanArkMessage " + joinToString$default);
        if (extraData == null) {
            QLog.e(TAG, 1, "sendZplanArkMessage extraData is null");
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(extraData.getString("forward_ark_app_meta", "")).optJSONObject("info");
            if (optJSONObject == null) {
                return;
            }
            sendGameArkMessage(optJSONObject, toUsers, callback);
        } catch (Throwable unused) {
            QLog.e(TAG, 1, "share zootopia ark error");
        }
    }

    private final void sendDressArkInfo(String id5, p[] users, Function2<? super Integer, ? super String, Unit> callback) {
        QLog.i(TAG, 1, "sendDressArkInfo");
        h hVar = new h();
        hVar.f424165a = users;
        hVar.f424166b = id5;
        a.b(a.f329180a, hVar, new b(callback, id5), 0, 4, null);
    }

    private final void sendZootopiaShareRequest(AppInterface app, int mapID, String gameTeamParams, Function1<? super ZootopiaSendArkResult, Unit> callback, int source, p[] shareTargets, String extInfo) {
        Map emptyMap;
        QLog.i(TAG, 1, "sendZootopiaShareRequest");
        g gVar = new g();
        gVar.f424159a = mapID;
        gVar.f424161c = gameTeamParams;
        gVar.f424162d = shareTargets;
        gVar.f424164f = extInfo == null ? "" : extInfo;
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(gVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(this)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, app, SCENE_MANAGE_SERVICE, METHOD_SHARE_ARK, byteArray, emptyMap, new d(callback), source, 0, 128, null);
    }

    @Override // com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService
    public void sendGameArkMessage(JSONObject info, List<ShareTarget> targets, Function1<? super ZootopiaSendArkResult, Unit> callback) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(targets, "targets");
        QLog.i(TAG, 1, "sendGameArkMessage");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            QLog.e(TAG, 1, "sendZplanArkMessage app is not AppInterface");
            return;
        }
        String gameTeamParams = info.optString(IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS);
        int optInt = info.optInt(IZootopiaShareArkService.ARK_MAP_ID);
        List<ShareTarget> list = targets;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (ShareTarget shareTarget : list) {
            p pVar = new p();
            pVar.f424195b = shareTarget.getId();
            pVar.f424194a = shareTarget.getType();
            arrayList.add(pVar);
        }
        Object[] array = arrayList.toArray(new p[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Intrinsics.checkNotNullExpressionValue(gameTeamParams, "gameTeamParams");
        sendZootopiaShareRequest$default(this, (AppInterface) peekAppRuntime, optInt, gameTeamParams, callback, 5, (p[]) array, null, 64, null);
        QLog.i(TAG, 1, "share zootopia ark");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0082, code lost:
    
        r8 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toBigIntegerOrNull(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r3);
     */
    @Override // com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void sendZplanArkMessageToGuild(String text, Bundle extraData, Function2<? super Integer, ? super String, Unit> callback) {
        Bundle bundle;
        Long longOrNull;
        BigInteger bigIntegerOrNull;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (extraData != null && (bundle = extraData.getBundle("zootopia_guild_biz_params")) != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            if (appInterface == null) {
                callback.invoke(-1, "app is null");
                return;
            }
            try {
                JSONObject optJSONObject = new JSONObject(extraData.getString("forward_ark_app_meta", "")).optJSONObject("info");
                if (optJSONObject == null) {
                    callback.invoke(-1, "meta miss info");
                    return;
                }
                if (Intrinsics.areEqual(optJSONObject.optString(IZootopiaShareArkService.ARK_TYPE), IZootopiaShareArkService.ARK_TYPE_DRESS)) {
                    return;
                }
                z23.c cVar = new z23.c();
                int optInt = optJSONObject.optInt(IZootopiaShareArkService.ARK_MAP_ID);
                int i3 = bundle.getInt("g_guildIdType", 1);
                String string = bundle.getString("g_guildId", null);
                long longValue = (string == null || bigIntegerOrNull == null) ? 0L : bigIntegerOrNull.longValue();
                String string2 = bundle.getString("g_channelId", null);
                long longValue2 = (string2 == null || longOrNull == null) ? 0L : longOrNull.longValue();
                int optInt2 = optJSONObject.optInt("sceneType");
                String str = text == null ? "" : text;
                String optString = optJSONObject.optString(IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS);
                Intrinsics.checkNotNullExpressionValue(optString, "info.optString(IZootopia\u2026vice.ARK_MAP_TEAM_PARAMS)");
                String optString2 = optJSONObject.optString("extInfo");
                Intrinsics.checkNotNullExpressionValue(optString2, "info.optString(IZootopia\u2026ce.ARK_EXTRA_INFO_PARAMS)");
                cVar.c(appInterface, optInt, i3, longValue, longValue2, optInt2, str, optString, (r30 & 256) != 0 ? "" : optString2, (r30 & 512) != 0 ? 0 : 0, callback);
                return;
            } catch (Throwable unused) {
                QLog.e(TAG, 1, "share zootopia ark error");
                return;
            }
        }
        callback.invoke(-1, "miss guildBizParams");
    }

    static /* synthetic */ void sendZootopiaShareRequest$default(ZootopiaShareArkServiceImpl zootopiaShareArkServiceImpl, AppInterface appInterface, int i3, String str, Function1 function1, int i16, p[] pVarArr, String str2, int i17, Object obj) {
        zootopiaShareArkServiceImpl.sendZootopiaShareRequest(appInterface, i3, str, function1, i16, pVarArr, (i17 & 64) != 0 ? null : str2);
    }
}
