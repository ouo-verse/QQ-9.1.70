package com.tencent.mobileqq.zplan.lua.plugins;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanShareApi;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.v;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Foreground;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/lua/plugins/g;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "", "extContent", "b", "Lcom/tencent/zplan/luabridge/LuaArgument;", "arg", "handleMediaShare", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name */
    public static final g f333847d = new g();

    static {
        QLog.w("ZPlanMediaShareLuaPlugin", 1, "ZPlanMediaShareLuaPlugin init.");
    }

    g() {
    }

    private final String b(String extContent) {
        try {
            String optString = new JSONObject(extContent).optString("SceneId");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"SceneId\")");
            return optString;
        } catch (Throwable th5) {
            QLog.e("ZPlanMediaShareLuaPlugin", 1, "getSceneId err.", th5);
            return "0";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0085 A[Catch: JSONException -> 0x00b7, TryCatch #0 {JSONException -> 0x00b7, blocks: (B:3:0x0026, B:5:0x004e, B:9:0x0063, B:13:0x0079, B:18:0x0085, B:21:0x0097, B:24:0x00a4), top: B:2:0x0026 }] */
    @LuaEvent("L2N_Media_Share")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String handleMediaShare(LuaArgument arg) {
        final int optInt;
        final int optInt2;
        final String contentPath;
        final String optString;
        boolean z16;
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(arg, "arg");
        QLog.d("ZPlanMediaShareLuaPlugin", 1, "handleMediaShare called." + arg.getF440574c());
        try {
            JSONObject jSONObject = new JSONObject(arg.getF440574c());
            optInt = jSONObject.optInt("ShareType", -1);
            optInt2 = jSONObject.optInt("ContentType", -1);
            contentPath = jSONObject.optString("Url");
            optString = jSONObject.optString("ExtContent");
        } catch (JSONException e16) {
            v.f373305a.c(R.string.xdv, "Json");
            QLog.d("ZPlanMediaShareLuaPlugin", 1, "handleMediaShare err.", e16);
        }
        if (optInt == -1) {
            QLog.d("ZPlanMediaShareLuaPlugin", 1, "handleMediaShare shareType error.");
            v.f373305a.c(R.string.xdv, "shareType");
            return arg.ok();
        }
        if (optInt2 == -1) {
            QLog.d("ZPlanMediaShareLuaPlugin", 1, "handleMediaShare contentType error.");
            v.f373305a.c(R.string.xdv, "contentType");
            return arg.ok();
        }
        if (contentPath != null && contentPath.length() != 0) {
            z16 = false;
            if (!z16) {
                Intrinsics.checkNotNullExpressionValue(contentPath, "contentPath");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(contentPath, "/", false, 2, null);
                if (startsWith$default) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.lua.plugins.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            g.c(optInt, optInt2, contentPath, optString);
                        }
                    });
                    return arg.ok();
                }
            }
            QLog.d("ZPlanMediaShareLuaPlugin", 1, "handleMediaShare contentPath error.");
            v.f373305a.c(R.string.xdv, "path");
            return arg.ok();
        }
        z16 = true;
        if (!z16) {
        }
        QLog.d("ZPlanMediaShareLuaPlugin", 1, "handleMediaShare contentPath error.");
        v.f373305a.c(R.string.xdv, "path");
        return arg.ok();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(int i3, int i16, String contentPath, String extContent) {
        IZPlanShareApi iZPlanShareApi = (IZPlanShareApi) QRoute.api(IZPlanShareApi.class);
        Context topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            topActivity = BaseApplication.context;
        }
        Intrinsics.checkNotNullExpressionValue(topActivity, "Foreground.getTopActivit\u2026seApplicationImpl.context");
        Intrinsics.checkNotNullExpressionValue(contentPath, "contentPath");
        HashMap hashMap = new HashMap();
        if (i3 == 1) {
            hashMap.put(ZPlanShareLaunchParam.KEY_BIZ_SMALL_HOME_EXT, extContent);
            g gVar = f333847d;
            Intrinsics.checkNotNullExpressionValue(extContent, "extContent");
            hashMap.put(ZPlanShareLaunchParam.KEY_BIZ_SMALL_HOME_SCENE, gVar.b(extContent));
        }
        Unit unit = Unit.INSTANCE;
        iZPlanShareApi.launchForShareMedia(topActivity, new ZPlanShareLaunchParam(i3, null, i16, contentPath, hashMap, null, null, null, null, null, false, null, 4032, null));
    }
}
