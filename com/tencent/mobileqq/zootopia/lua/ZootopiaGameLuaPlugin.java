package com.tencent.mobileqq.zootopia.lua;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.data.ZootopiaTConnAddress;
import com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadManagerFragment;
import com.tencent.mobileqq.zootopia.qav.ZplanAVControllerForQAV;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.utils.StackPrinter;
import defpackage.UEBuglyInfoRecorder;
import java.net.URLDecoder;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;
import zb3.ZootopiaEnterRoomData;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00032\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0019\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#R\u001b\u0010&\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b%\u0010#\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZootopiaGameLuaPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "", tl.h.F, "", "roomId", "i", "(Ljava/lang/Long;)V", "", "errorCode", "", "message", "d", "Lzb3/f;", "result", "Lorg/json/JSONObject;", "g", "orientation", "j", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "handleScreenOrientation", "handleSwitchScreen", "handleClipboardCopy", "handleBackToZootopia", "handleEnterRoom", "", "isPortal", "k", "Landroid/app/Activity;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/util/SparseIntArray;", "e", "Lkotlin/Lazy;", "()Landroid/util/SparseIntArray;", "sensorDisabledOrientationMap", "f", "sensorEnabledOrientationMap", "<init>", "(Landroid/app/Activity;)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaGameLuaPlugin extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy sensorDisabledOrientationMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy sensorEnabledOrientationMap;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ZootopiaGameLuaPlugin$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzb3/f;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<ZootopiaEnterRoomData> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LuaArgument f328430e;

        b(LuaArgument luaArgument) {
            this.f328430e = luaArgument;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaEnterRoomData result) {
            Intrinsics.checkNotNullParameter(result, "result");
            String jSONObject = ZootopiaGameLuaPlugin.this.g(result).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "getSuccessRespond(result).toString()");
            QLog.i("ZootopiaGameLuaPlugin", 1, "enter room success : " + jSONObject);
            ZootopiaGameLuaPlugin.this.i(Long.valueOf(result.getRoomId()));
            this.f328430e.callback(jSONObject);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            String d16 = ZootopiaGameLuaPlugin.this.d(error, message);
            QLog.i("ZootopiaGameLuaPlugin", 1, "enter room failed : " + d16);
            this.f328430e.callback(d16);
        }
    }

    public ZootopiaGameLuaPlugin(Activity activity) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SparseIntArray>() { // from class: com.tencent.mobileqq.zootopia.lua.ZootopiaGameLuaPlugin$sensorDisabledOrientationMap$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SparseIntArray invoke() {
                return new SparseIntArray();
            }
        });
        this.sensorDisabledOrientationMap = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<SparseIntArray>() { // from class: com.tencent.mobileqq.zootopia.lua.ZootopiaGameLuaPlugin$sensorEnabledOrientationMap$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SparseIntArray invoke() {
                return new SparseIntArray();
            }
        });
        this.sensorEnabledOrientationMap = lazy2;
        e().put(1, 1);
        e().put(2, 9);
        e().put(3, 0);
        e().put(4, 8);
        f().put(0, 4);
        f().put(1, 7);
        f().put(2, 7);
        f().put(3, 6);
        f().put(4, 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d(int errorCode, String message) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("RetCode", errorCode);
        jSONObject.put("Msg", message);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026age)\n        }.toString()");
        return jSONObject2;
    }

    private final SparseIntArray e() {
        return (SparseIntArray) this.sensorDisabledOrientationMap.getValue();
    }

    private final SparseIntArray f() {
        return (SparseIntArray) this.sensorEnabledOrientationMap.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject g(ZootopiaEnterRoomData result) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (ZootopiaTConnAddress zootopiaTConnAddress : result.a()) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ip", zootopiaTConnAddress.getIp());
            jSONObject2.put("port", zootopiaTConnAddress.getPort());
            jSONObject2.put("addr_type", zootopiaTConnAddress.getType());
            jSONArray.mo162put(jSONObject2);
        }
        jSONObject.put("Addr", jSONArray);
        jSONObject.put(ZootopiaEnterParams.KEY_TOKEN, result.getToken());
        jSONObject.put("RoomId", result.getRoomId());
        jSONObject.put("RetCode", 0);
        jSONObject.put("Msg", "");
        return jSONObject;
    }

    private final void h() {
        QLog.i("ZootopiaGameLuaPlugin", 1, "realHandleExitMap - " + this.activity.isFinishing());
        if (!this.activity.isFinishing()) {
            Activity activity = this.activity;
            ZootopiaUEActivity zootopiaUEActivity = activity instanceof ZootopiaUEActivity ? (ZootopiaUEActivity) activity : null;
            if (zootopiaUEActivity != null ? zootopiaUEActivity.getIsFirstFrameReady() : true) {
                ZplanAVControllerForQAV.INSTANCE.p();
                this.activity.finish();
            }
        }
        if (t74.h.e()) {
            UEBuglyInfoRecorder.f25109a.onSmallHomeExit();
        } else {
            ((defpackage.c) k74.i.INSTANCE.a(defpackage.c.class)).onSmallHomeExit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(Long roomId) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("roomId", roomId);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        QLog.i("ZootopiaGameLuaPlugin", 1, "request room success " + jSONObject2);
        ComponentCallbacks2 componentCallbacks2 = this.activity;
        if (componentCallbacks2 instanceof com.tencent.mobileqq.zootopia.lua.b) {
            ((com.tencent.mobileqq.zootopia.lua.b) componentCallbacks2).c1(jSONObject2);
        }
    }

    private final void j(int orientation) {
        QLog.i("ZootopiaGameLuaPlugin", 1, "setOrientation : " + orientation + " , stack: " + new StackPrinter(""));
        this.activity.setRequestedOrientation(orientation);
    }

    @LuaEvent("L2N_ExitMap")
    public final String handleBackToZootopia(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaGameLuaPlugin", 1, "L2N_ExitMap handleBackToZootopia, params:" + argument.getF440574c());
        h();
        if (!TextUtils.isEmpty(argument.getF440574c())) {
            try {
                String optString = new JSONObject(argument.getF440574c()).optString("ModParams");
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject = new JSONObject(optString);
                    String optString2 = jSONObject.optString("modId");
                    int optInt = jSONObject.optInt("actionType", 0);
                    String actionParam = URLDecoder.decode(jSONObject.optString("actionParam", ""), "utf-8");
                    QLog.i("ZootopiaGameLuaPlugin", 1, "actionType:" + optInt + ", actionParam:" + actionParam);
                    if (optInt != 1) {
                        if (optInt == 2) {
                            Intrinsics.checkNotNullExpressionValue(actionParam, "actionParam");
                            if (actionParam.length() > 0) {
                                Context context = BaseApplication.context;
                                if (context == null) {
                                    context = this.activity;
                                }
                                QLog.i("ZootopiaGameLuaPlugin", 1, "ctx:" + context);
                                ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(context, actionParam);
                            }
                        }
                    } else if (!TextUtils.isEmpty(optString2)) {
                        ZootopiaDownloadManagerFragment.INSTANCE.b(this.activity, ZootopiaSource.INSTANCE.g(), 1, optString2);
                    }
                }
            } catch (Exception e16) {
                QLog.e("ZootopiaGameLuaPlugin", 1, "parse json error", e16);
            }
        }
        return argument.ok();
    }

    @LuaEvent("L2N_ClipboardCopy")
    public final String handleClipboardCopy(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaGameLuaPlugin", 1, "ClipboardCopy, params:" + argument.getF440574c());
        String optString = new JSONObject(argument.getF440574c()).optString("text");
        if (!TextUtils.isEmpty(optString)) {
            com.tencent.biz.common.util.b.a(BaseApplication.context, optString);
        }
        return argument.ok();
    }

    @LuaEvent("L2N_EnterRoom")
    public final void handleEnterRoom(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaGameLuaPlugin", 1, "called L2N_enterRoom ");
        if (this.activity.isFinishing()) {
            argument.callback(argument.fail(d(-1, "activity is invalid")));
            return;
        }
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        int optInt = jSONObject.optInt("MapId");
        long optLong = jSONObject.optLong("RoomId");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            argument.callback(argument.fail(d(-1, "app is null")));
            return;
        }
        QLog.i("ZootopiaGameLuaPlugin", 1, "enter room start , mapId: " + optInt + " , roomId " + optLong);
        new com.tencent.mobileqq.zootopia.service.b().a(appInterface, optInt, optLong, 1, new b(argument));
    }

    @LuaEvent("L2N_SetScreenOrientation")
    public final String handleScreenOrientation(LuaArgument argument) {
        SparseIntArray e16;
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaGameLuaPlugin", 1, "handleScreenOrientation, params:" + argument.getF440574c());
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        boolean optBoolean = jSONObject.optBoolean("EnableSensor");
        int optInt = jSONObject.optInt("OrientationType");
        if (optBoolean) {
            e16 = f();
        } else {
            e16 = e();
        }
        int i3 = e16.get(optInt, -1);
        if (i3 == -1) {
            return argument.ok();
        }
        j(i3);
        return argument.ok();
    }

    @LuaEvent("L2N_SwitchScreen")
    public final String handleSwitchScreen(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaGameLuaPlugin", 1, "handleSwitchScreen, params:" + argument.getF440574c());
        k(new JSONObject(argument.getF440574c()).optBoolean("IsPortal"));
        return argument.ok();
    }

    public final void k(boolean isPortal) {
        j(isPortal ? 1 : 0);
    }
}
