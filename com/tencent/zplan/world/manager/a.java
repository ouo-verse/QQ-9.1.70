package com.tencent.zplan.world.manager;

import com.tencent.zplan.engine.service.ZPlanEngineService;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.luabridge.plugins.FirstFramePlugin;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.model.FirstFrameResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import yx4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/zplan/world/manager/a;", "", "", "sceneType", "", "sceneParams", "Lorg/json/JSONObject;", "d", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "listener", "", "c", "Ljava/util/concurrent/locks/ReentrantLock;", "a", "Ljava/util/concurrent/locks/ReentrantLock;", "registerListenerListLock", "", "Lcom/tencent/zplan/luabridge/plugins/FirstFramePlugin$a;", "b", "Ljava/util/List;", "registerListenerList", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f386318c = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ReentrantLock registerListenerListLock = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final List<FirstFramePlugin.a> registerListenerList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/zplan/world/manager/a$a", "Lcom/tencent/zplan/luabridge/a$b;", "", "onExecuteLua", "", "success", "", "result", "onLuaResult", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.world.manager.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static final class C10074a implements a.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f386319d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IZPlanWorldStatusListener f386320e;

        C10074a(JSONObject jSONObject, IZPlanWorldStatusListener iZPlanWorldStatusListener) {
            this.f386319d = jSONObject;
            this.f386320e = iZPlanWorldStatusListener;
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            ZLog.f386189b.k("ZPlanNormalManager", "enterAvatarScene onExecuteLua");
            c cVar = (c) mx4.a.f417748a.a(c.class);
            if (cVar != null) {
                cVar.notifyEnterAvatarScene(this.f386319d.toString());
            }
            this.f386320e.onEnterSceneResult(true);
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, @Nullable String result) {
            ZLog.f386189b.k("ZPlanNormalManager", "enterAvatarScene onLuaResult, success: " + success + ", result: " + result);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/zplan/world/manager/a$b", "Lcom/tencent/zplan/luabridge/plugins/FirstFramePlugin$b;", "", "event", "Lorg/json/JSONObject;", "params", "", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b implements FirstFramePlugin.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IZPlanWorldStatusListener f386321a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f386322b;

        b(IZPlanWorldStatusListener iZPlanWorldStatusListener, Ref.ObjectRef objectRef) {
            this.f386321a = iZPlanWorldStatusListener;
            this.f386322b = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.zplan.luabridge.plugins.FirstFramePlugin.b
        public void a(@NotNull String event, @NotNull JSONObject params) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(params, "params");
            this.f386321a.onFirstFrame(new FirstFrameResult(params.optInt("ViewType", -1), params.optString("OriginalParams")));
            FirstFramePlugin.a aVar = (FirstFramePlugin.a) this.f386322b.element;
            if (aVar != null) {
                FirstFramePlugin.f385718f.d(aVar);
                a aVar2 = a.f386318c;
                ReentrantLock b16 = a.b(aVar2);
                b16.lock();
                try {
                    a.a(aVar2).remove(aVar);
                } finally {
                    b16.unlock();
                }
            }
        }
    }

    a() {
    }

    public static final /* synthetic */ List a(a aVar) {
        return registerListenerList;
    }

    public static final /* synthetic */ ReentrantLock b(a aVar) {
        return registerListenerListLock;
    }

    private final JSONObject d(int sceneType, String sceneParams) {
        JSONObject jSONObject;
        int andIncrement = ZPlanEngineService.INSTANCE.i().getAndIncrement();
        if (sceneParams != null) {
            jSONObject = new JSONObject(sceneParams);
        } else {
            jSONObject = new JSONObject();
        }
        jSONObject.put("ViewType", sceneType);
        jSONObject.put("_EnterAvaterIndex_", andIncrement);
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v4, types: [T, com.tencent.zplan.luabridge.plugins.FirstFramePlugin$a] */
    public final void c(int sceneType, @Nullable String sceneParams, @NotNull IZPlanWorldStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ZLog zLog = ZLog.f386189b;
        zLog.k("ZPlanNormalManager", "enterAvatarScene, sceneType : " + sceneType + ", sceneParams : " + sceneParams + ", listener: " + listener);
        if (sceneType < 0) {
            listener.onEnterSceneResult(false);
            zLog.f("ZPlanNormalManager", "enterAvatarScene sceneType < 0, return");
            return;
        }
        JSONObject d16 = d(sceneType, sceneParams);
        a.C10063a.d(ZPlanLuaBridge.INSTANCE, "N2L_EnterAvatarScene", d16, new C10074a(d16, listener), false, 8, null);
        int optInt = d16.optInt("_EnterAvaterIndex_", -1);
        zLog.k("ZPlanNormalManager", "enterAvatarScene, callLuaIndex: " + optInt);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        objectRef.element = new FirstFramePlugin.a(optInt, new b(listener, objectRef), false, 4, null);
        ReentrantLock reentrantLock = registerListenerListLock;
        reentrantLock.lock();
        try {
            registerListenerList.add((FirstFramePlugin.a) objectRef.element);
            reentrantLock.unlock();
            FirstFramePlugin.f385718f.b((FirstFramePlugin.a) objectRef.element);
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }
}
