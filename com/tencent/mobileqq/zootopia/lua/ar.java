package com.tencent.mobileqq.zootopia.lua;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.c;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\n\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ar;", "", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "plugin", "", "b", "c", "", AdMetricTag.EVENT_NAME, "params", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ar {

    /* renamed from: a, reason: collision with root package name */
    public static final ar f328509a = new ar();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\"\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ar$b;", "Lcom/tencent/zplan/c$a;", "", AdMetricTag.EVENT_NAME, "params", "", "callbackId", "t0", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "d", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "plugin", "<init>", "(Lcom/tencent/zplan/luabridge/LuaBasePlugin;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends c.a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final LuaBasePlugin plugin;

        public b(LuaBasePlugin plugin) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            this.plugin = plugin;
        }

        @Override // com.tencent.zplan.c
        public String t0(String eventName, String params, int callbackId) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(params, "params");
            this.plugin.handleEvent(eventName, new a(0, eventName, params));
            return null;
        }
    }

    ar() {
    }

    public final void a(String eventName, String params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        boolean b16 = t74.h.b();
        if (QLog.isColorLevel()) {
            QLog.d("ZootopiaLuaManager", 2, "callLua in MainProcess:" + b16 + ", " + eventName + ", " + params);
        }
        if (b16) {
            ux4.b bVar = ux4.b.f440566e;
            if (bVar.j(eventName)) {
                if (params == null) {
                    params = "";
                }
                bVar.a(eventName, new JSONObject(params), null, true);
                return;
            }
            ZPlanServiceHelper.I.G(eventName, params);
            return;
        }
        ZPlanLuaBridge.INSTANCE.callLua(eventName, params);
    }

    public final void b(LuaBasePlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        if (t74.h.b()) {
            Iterator<T> it = plugin.getEvents().iterator();
            while (it.hasNext()) {
                ZPlanServiceHelper.I.p0((String) it.next(), new b(plugin));
            }
            return;
        }
        ZPlanLuaBridge.INSTANCE.registerPlugin(plugin);
    }

    public final void c(LuaBasePlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        if (t74.h.b()) {
            Iterator<T> it = plugin.getEvents().iterator();
            while (it.hasNext()) {
                ZPlanServiceHelper.I.p0((String) it.next(), null);
            }
            return;
        }
        ZPlanLuaBridge.INSTANCE.removePlugin(plugin);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0010\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ar$a;", "Lp0/a;", "", "result", "", "callback", "", "a", "I", "getCallbackId", "()I", "callbackId", "b", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", AdMetricTag.EVENT_NAME, "c", "getParams", "params", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements p0.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int callbackId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final String eventName;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final String params;

        public a(int i3, String eventName, String params) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(params, "params");
            this.callbackId = i3;
            this.eventName = eventName;
            this.params = params;
        }

        @Override // p0.a
        public int getCallbackId() {
            return this.callbackId;
        }

        @Override // p0.a
        public String getEventName() {
            return this.eventName;
        }

        @Override // p0.a
        public String getParams() {
            return this.params;
        }

        @Override // p0.a
        public boolean isASync() {
            return a.C10971a.a(this);
        }

        @Override // p0.a
        public void callback(String result) {
        }
    }
}
