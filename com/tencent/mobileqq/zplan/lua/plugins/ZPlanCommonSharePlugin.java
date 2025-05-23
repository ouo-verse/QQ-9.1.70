package com.tencent.mobileqq.zplan.lua.plugins;

import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanShareApi;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.mobileqq.zplan.share.s;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.v;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J.\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\tH\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\tH\u0007J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0005\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/lua/plugins/ZPlanCommonSharePlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lorg/json/JSONObject;", "jsonObject", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "g", "Lcom/tencent/zplan/luabridge/LuaArgument;", "arg", "handleUrlShare", "argument", "handleQQShare", HippyControllerProps.STRING, "", "d", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanCommonSharePlugin extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy<ZPlanCommonSharePlugin> f333814e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/lua/plugins/ZPlanCommonSharePlugin$a;", "", "Lcom/tencent/mobileqq/zplan/lua/plugins/ZPlanCommonSharePlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zplan/lua/plugins/ZPlanCommonSharePlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "PARAM_CONTENT_TYPE", "Ljava/lang/String;", "PARAM_FILE_PATH", "PARAM_FILE_PATHS", "PARAM_SHARE_TARGET", "PARAM_SHARE_TYPE", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.lua.plugins.ZPlanCommonSharePlugin$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanCommonSharePlugin a() {
            return (ZPlanCommonSharePlugin) ZPlanCommonSharePlugin.f333814e.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<ZPlanCommonSharePlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanCommonSharePlugin>() { // from class: com.tencent.mobileqq.zplan.lua.plugins.ZPlanCommonSharePlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanCommonSharePlugin invoke() {
                return new ZPlanCommonSharePlugin();
            }
        });
        f333814e = lazy;
    }

    public ZPlanCommonSharePlugin() {
        QLog.w("ZPlanCommonSharePlugin", 1, "ZPlanCommonSharePlugin init.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String contentPath, String str, String str2, String str3, String str4) {
        s sVar = s.f335583a;
        Intrinsics.checkNotNullExpressionValue(contentPath, "contentPath");
        sVar.b(contentPath, str, str2, str3, str4);
    }

    @LuaEvent("L2N_QQShare")
    public final String handleQQShare(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        if (d(argument.getF440574c())) {
            return argument.ok();
        }
        return argument.fail();
    }

    @LuaEvent("L2N_UrlShare")
    public final String handleUrlShare(LuaArgument arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        QLog.i("ZPlanCommonSharePlugin", 1, "handleUrlShare called." + arg.getF440574c());
        try {
            JSONObject jSONObject = new JSONObject(arg.getF440574c());
            final String optString = jSONObject.optString("url", "");
            final String optString2 = jSONObject.optString("thumb", "");
            final String optString3 = jSONObject.optString("title", "");
            final String optString4 = jSONObject.optString("desc", "");
            final String optString5 = jSONObject.optString("directMessage", "");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.lua.plugins.b
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanCommonSharePlugin.f(optString, optString3, optString4, optString2, optString5);
                }
            });
        } catch (JSONException e16) {
            v.f373305a.c(R.string.xdv, "Json");
            QLog.d("ZPlanCommonSharePlugin", 1, "handleMediaShare err.", e16);
        }
        return arg.ok();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ArrayList platformList, int i3, int i16, String filePath, HashMap extraParmas) {
        Intrinsics.checkNotNullParameter(platformList, "$platformList");
        Intrinsics.checkNotNullParameter(extraParmas, "$extraParmas");
        IZPlanShareApi iZPlanShareApi = (IZPlanShareApi) QRoute.api(IZPlanShareApi.class);
        Context topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            topActivity = BaseApplication.context;
        }
        Context context = topActivity;
        Intrinsics.checkNotNullExpressionValue(context, "Foreground.getTopActivit\u2026seApplicationImpl.context");
        Object[] array = platformList.toArray(new Integer[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
        iZPlanShareApi.launchForShareMedia(context, new ZPlanShareLaunchParam(i3, null, i16, filePath, null, extraParmas, null, (Integer[]) array, null, null, false, null, 3922, null));
    }

    private final HashMap<String, Object> g(JSONObject jsonObject) {
        if (jsonObject == null) {
            return new HashMap<>();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            Iterator keys = jsonObject.keys();
            while (keys.hasNext()) {
                String str = ((String) keys.next()).toString();
                hashMap.put(str, jsonObject.get(str).toString());
            }
        } catch (Exception e16) {
            QLog.e("ZPlanCommonSharePlugin", 1, "parse json error => " + e16);
        }
        return hashMap;
    }

    public final boolean d(String string) {
        String str;
        Intrinsics.checkNotNullParameter(string, "string");
        QLog.i("ZPlanCommonSharePlugin", 1, "L2N_QQShare - handleQQShare, " + string);
        try {
            JSONObject jSONObject = new JSONObject(string);
            final int optInt = jSONObject.optInt("ContentType", -1);
            final String filePath = jSONObject.optString("FilePath", "");
            JSONObject optJSONObject = jSONObject.optJSONObject("FilePaths");
            JSONArray optJSONArray = jSONObject.optJSONArray("ShareTarget");
            try {
                final int optInt2 = jSONObject.optInt("ShareType", -1);
                try {
                    if (optInt != -1) {
                        Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
                        if ((!(filePath.length() == 0) || optJSONObject != null) && optJSONArray != null && optJSONArray.length() != 0) {
                            final ArrayList arrayList = new ArrayList();
                            int length = optJSONArray.length();
                            int i3 = 0;
                            while (i3 < length) {
                                Object obj = optJSONArray.get(i3);
                                int i16 = length;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                                arrayList.add((Integer) obj);
                                i3++;
                                length = i16;
                            }
                            final HashMap<String, Object> g16 = g(optJSONObject);
                            String optString = jSONObject.optString("OpenId");
                            Intrinsics.checkNotNullExpressionValue(optString, "params.optString(SmallHo\u2026ion.PARAMS_SHARE_OPEN_ID)");
                            g16.put("OpenId", optString);
                            String optString2 = jSONObject.optString("SceneId");
                            Intrinsics.checkNotNullExpressionValue(optString2, "params.optString(SmallHo\u2026on.PARAMS_SHARE_SCENE_ID)");
                            g16.put("SceneId", optString2);
                            String optString3 = jSONObject.optString("RoomId");
                            Intrinsics.checkNotNullExpressionValue(optString3, "params.optString(SmallHo\u2026ion.PARAMS_SHARE_ROOM_ID)");
                            g16.put("RoomId", optString3);
                            String optString4 = jSONObject.optString("RoomName");
                            Intrinsics.checkNotNullExpressionValue(optString4, "params.optString(SmallHo\u2026n.PARAMS_SHARE_ROOM_NAME)");
                            g16.put("RoomName", optString4);
                            String optString5 = jSONObject.optString("ExtContent");
                            Intrinsics.checkNotNullExpressionValue(optString5, "params.optString(SmallHo\u2026PARAMS_SHARE_EXT_CONTENT)");
                            g16.put("ExtContent", optString5);
                            g16.put("LikesNums", Integer.valueOf(jSONObject.optInt("LikesNums")));
                            g16.put("SceneType", Integer.valueOf(jSONObject.optInt("SceneType")));
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.lua.plugins.c
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ZPlanCommonSharePlugin.e(arrayList, optInt2, optInt, filePath, g16);
                                }
                            });
                            return true;
                        }
                    }
                    str = "ZPlanCommonSharePlugin";
                } catch (JSONException e16) {
                    e = e16;
                    str = "ZPlanCommonSharePlugin";
                    v.f373305a.c(R.string.xdv, "JSONException:" + e.getMessage());
                    QLog.d(str, 1, "handleQQShare err.", e);
                    return false;
                }
                try {
                    QLog.d(str, 1, "params is invalid, contentType:" + optInt + ", filePath" + filePath + ", shareTarget" + optJSONArray);
                    v.f373305a.c(R.string.xdv, "contentType:" + optInt + ", filePath" + filePath + ", shareTarget" + optJSONArray);
                    return false;
                } catch (JSONException e17) {
                    e = e17;
                    v.f373305a.c(R.string.xdv, "JSONException:" + e.getMessage());
                    QLog.d(str, 1, "handleQQShare err.", e);
                    return false;
                }
            } catch (JSONException e18) {
                e = e18;
            }
        } catch (JSONException e19) {
            e = e19;
            str = "ZPlanCommonSharePlugin";
        }
    }
}
