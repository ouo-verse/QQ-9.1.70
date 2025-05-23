package com.tencent.zplan.luabridge.plugins;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.utils.ZLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/f;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "notifyChooseFriendFinish", "notifyUpdatePreloadResource", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "e", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class f extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    public f(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @LuaEvent("L2N_SameStyle_FriendChoosenFinished")
    @NotNull
    public final String notifyChooseFriendFinish(@NotNull LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        ZLog.f386189b.k("NotifyPlugin", "receive FriendChoosenFinished event");
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this.context);
        Intent intent = new Intent();
        intent.setAction("L2N_SameStyle_FriendChoosenFinished");
        Unit unit = Unit.INSTANCE;
        localBroadcastManager.sendBroadcast(intent);
        return argument.ok();
    }

    @LuaEvent("L2N_SameStyle_UpdatePreloadResource")
    @NotNull
    public final String notifyUpdatePreloadResource(@NotNull LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        JSONObject jSONObject = new JSONObject(argument.getParams());
        int optInt = jSONObject.optInt("progress");
        int optInt2 = jSONObject.optInt("state");
        ZLog.f386189b.k("NotifyPlugin", "receive UpdatePreloadResource event, progress = " + optInt + ", state = " + optInt2);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this.context);
        Intent intent = new Intent();
        intent.setAction("L2N_SameStyle_UpdatePreloadResource");
        intent.putExtra("progress", optInt);
        intent.putExtra("state", optInt2);
        Unit unit = Unit.INSTANCE;
        localBroadcastManager.sendBroadcast(intent);
        return argument.ok();
    }
}
