package com.tencent.zplan.luabridge.plugins;

import com.tencent.autotemplate.model.TAVBaseAutomaticEffect;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.luabridge.plugins.data.CommonLoadingData;
import com.tencent.zplan.luabridge.plugins.data.LoadingExtData;
import com.tencent.zplan.utils.ZLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/a;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Ltx4/a;", "listener", "", "a", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleCommonLoadingProgress", "Ljava/util/concurrent/CopyOnWriteArrayList;", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class a extends LuaBasePlugin {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f385727e = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<tx4.a> listeners = new CopyOnWriteArrayList<>();

    a() {
    }

    public final void a(@NotNull tx4.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.addIfAbsent(listener);
    }

    @LuaEvent("L2N_StoreLoadingProgress")
    @NotNull
    public final String handleCommonLoadingProgress(@NotNull LuaArgument argument) {
        LoadingExtData loadingExtData;
        Intrinsics.checkNotNullParameter(argument, "argument");
        ZLog.f386189b.k("CommonLoadingPlugin", "handleCommonLoadingProgress\uff1a" + argument.getParams());
        JSONObject jSONObject = new JSONObject(argument.getParams());
        double optDouble = jSONObject.optDouble("Progress", 0.0d);
        int optInt = jSONObject.optInt("TotalMode", 0);
        int optInt2 = jSONObject.optInt("CurrentMode", 0);
        int optInt3 = jSONObject.optInt("CurrentType", 0);
        int optInt4 = jSONObject.optInt("ViewType", 0);
        int optInt5 = jSONObject.optInt("SceneID", 0);
        JSONObject optJSONObject = jSONObject.optJSONObject("Ext");
        if (optJSONObject != null) {
            LoadingExtData loadingExtData2 = new LoadingExtData(0.0d, 0.0d, 0.0d, null, null, 31, null);
            loadingExtData2.setTotalSize(optJSONObject.optDouble("Total", 0.0d));
            loadingExtData2.setCurrentDownload(optJSONObject.optDouble("Current", 0.0d));
            loadingExtData2.setSpeed(optJSONObject.optDouble(TAVBaseAutomaticEffect.TYPE_SPEED, 0.0d));
            String optString = optJSONObject.optString("Tip1");
            String str = "";
            if (optString == null) {
                optString = "";
            }
            loadingExtData2.setTips1(optString);
            String optString2 = optJSONObject.optString("Tip2");
            if (optString2 != null) {
                str = optString2;
            }
            loadingExtData2.setTips2(str);
            loadingExtData = loadingExtData2;
        } else {
            loadingExtData = null;
        }
        CommonLoadingData commonLoadingData = new CommonLoadingData((int) optDouble, optInt, optInt2, optInt3, optInt4, optInt5, loadingExtData);
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((tx4.a) it.next()).Q0(commonLoadingData);
        }
        return argument.ok();
    }
}
