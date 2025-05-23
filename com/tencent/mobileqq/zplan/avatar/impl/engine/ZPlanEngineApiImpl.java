package com.tencent.mobileqq.zplan.avatar.impl.engine;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.scene.IAvatarSceneApi;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.engine.c;
import com.tencent.zplan.luabridge.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import si3.b;
import t74.s;
import we3.a;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/impl/engine/ZPlanEngineApiImpl;", "Lwe3/a;", "", "isEngineReady", "", "getEngineStatus", "", AdMetricTag.EVENT_NAME, "params", "", "callLua", "getFirstFrameViewType", "isEngineHotReady", "targetViewType", "needLoading", "from", "startEngine", "Lwe3/b;", "callBack", "getCurrentViewType", "notifyRoleCompleted", "appForeground", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanEngineApiImpl implements a {
    private static final String TAG = "ZPlanEngineApiImpl_";

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/avatar/impl/engine/ZPlanEngineApiImpl$b", "Lcom/tencent/zplan/engine/c;", "", "success", "", "startEngineState", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ we3.b f331876a;

        b(we3.b bVar) {
            this.f331876a = bVar;
        }

        @Override // com.tencent.zplan.engine.c
        public void a(boolean success, int startEngineState) {
            this.f331876a.a(success, startEngineState);
        }
    }

    @Override // we3.a
    public boolean appForeground() {
        return s.f435588a.a();
    }

    public void callLua(String eventName, String params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        com.tencent.zplan.luabridge.a S = ZPlanServiceHelper.I.S();
        if (S != null) {
            if (params == null) {
                params = "";
            }
            a.C10063a.b(S, eventName, params, null, 4, null);
        }
    }

    public int getCurrentViewType() {
        return ((IAvatarSceneApi) QRoute.api(IAvatarSceneApi.class)).getCurViewType();
    }

    public int getEngineStatus() {
        return ZPlanServiceHelper.I.O();
    }

    public int getFirstFrameViewType() {
        return ZPlanServiceHelper.I.P();
    }

    public boolean isEngineHotReady() {
        return ((IZPlanApi) QRoute.api(IZPlanApi.class)).isEngineHotReady();
    }

    public boolean isEngineReady() {
        return ((IZPlanApi) QRoute.api(IZPlanApi.class)).isEngineReady();
    }

    @Override // we3.a
    public boolean needLoading(int targetViewType) {
        if (!isEngineReady()) {
            QLog.i(TAG, 1, "needLoading engineReady:false");
            return true;
        }
        if (!isEngineHotReady()) {
            QLog.i(TAG, 1, "needLoading engineHotReady:false");
            return true;
        }
        if (((IAvatarSceneApi) QRoute.api(IAvatarSceneApi.class)).isSameViewType(targetViewType)) {
            return false;
        }
        QLog.i(TAG, 1, "needLoading viewTypeSame:false");
        return true;
    }

    @Override // we3.a
    public void startEngine(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).startEngineWhenNotReady(null, from);
    }

    @Override // we3.a
    public void notifyRoleCompleted(String params) {
        QLog.i(TAG, 1, "notifyRoleCompleted--");
        b.a.a((si3.b) vb3.a.f441346a.a(si3.b.class), true, false, 0, 4, null);
    }

    @Override // we3.a
    public void startEngine(String from, we3.b callBack) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).startEngineWhenNotReady(new WeakReference<>(new b(callBack)), from);
    }
}
