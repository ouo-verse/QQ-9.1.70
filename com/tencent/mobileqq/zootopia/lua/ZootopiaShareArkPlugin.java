package com.tencent.mobileqq.zootopia.lua;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import qd3.ZootopiaSendArkResult;
import rd3.ShareTarget;
import zb3.ZootopiaShareArkInfo;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZootopiaShareArkPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "", "mapId", "", IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS, "toOpenId", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "b", "c", "handleShareArk", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaShareArkPlugin extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ZootopiaShareArkPlugin$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lov4/m;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<ov4.m> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f328447d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZootopiaShareArkPlugin f328448e;

        b(String str, ZootopiaShareArkPlugin zootopiaShareArkPlugin) {
            this.f328447d = str;
            this.f328448e = zootopiaShareArkPlugin;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ov4.m result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ZootopiaShareArkInfo d16 = new ZootopiaShareArkInfo(0, 1, null).d(result);
            String str = this.f328447d;
            ZootopiaShareArkPlugin zootopiaShareArkPlugin = this.f328448e;
            d16.j(str);
            sd3.f.f433689a.j(zootopiaShareArkPlugin.activity, d16);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("ZootopiaShareArkPlugin", 1, "doRealShareAction onResultFailure error = " + error + " message = " + message);
        }
    }

    public ZootopiaShareArkPlugin(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    private final void b(int mapId, String gameTeamParams, String toOpenId, final LuaArgument argument) {
        QLog.i("ZootopiaShareArkPlugin", 1, "directShareToOpenId, toOpenId:" + toOpenId);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ShareTarget(3, toOpenId));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS, gameTeamParams);
        jSONObject.put(IZootopiaShareArkService.ARK_MAP_ID, mapId);
        ((IZootopiaShareArkService) QRoute.api(IZootopiaShareArkService.class)).sendGameArkMessage(jSONObject, arrayList, new Function1<ZootopiaSendArkResult, Unit>() { // from class: com.tencent.mobileqq.zootopia.lua.ZootopiaShareArkPlugin$directShareToOpenId$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaSendArkResult zootopiaSendArkResult) {
                invoke2(zootopiaSendArkResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaSendArkResult sendResult) {
                Intrinsics.checkNotNullParameter(sendResult, "sendResult");
                QLog.i("ZootopiaShareArkPlugin", 1, "sendGameArkMessage Result " + sendResult.getResult());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(QzoneIPCModule.RESULT_CODE, sendResult.getResult());
                LuaArgument.this.callback(jSONObject2.toString());
            }
        });
    }

    private final void c(int mapId, String gameTeamParams) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        new com.tencent.mobileqq.zootopia.service.c().a(appInterface, mapId, 5, new b(gameTeamParams, this));
    }

    @LuaEvent("L2N_ShareArk")
    public final String handleShareArk(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        if (QLog.isColorLevel()) {
            QLog.i("ZootopiaShareArkPlugin", 2, "handleShareArk, params:" + argument.getParams());
        }
        JSONObject jSONObject = new JSONObject(argument.getParams());
        int optInt = jSONObject.optInt(IZootopiaShareArkService.ARK_MAP_ID);
        String gameTeamParams = jSONObject.optString(IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS);
        String toOpenId = jSONObject.optString("toOpenId");
        if (TextUtils.isEmpty(toOpenId)) {
            Intrinsics.checkNotNullExpressionValue(gameTeamParams, "gameTeamParams");
            c(optInt, gameTeamParams);
            return argument.ok();
        }
        Intrinsics.checkNotNullExpressionValue(gameTeamParams, "gameTeamParams");
        Intrinsics.checkNotNullExpressionValue(toOpenId, "toOpenId");
        b(optInt, gameTeamParams, toOpenId, argument);
        return null;
    }
}
