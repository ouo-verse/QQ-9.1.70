package ht;

import android.content.Context;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.event.DKEventCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a extends DKEngine<DKEngine.OnCreateEngineListener> {

    /* compiled from: P */
    /* renamed from: ht.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C10472a extends DKEngine.CreateViewInfo {

        /* renamed from: a, reason: collision with root package name */
        public h f406221a;

        /* renamed from: b, reason: collision with root package name */
        public g f406222b;
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void createEngine(Context context, Map<String, String> map, DKEngine.OnCreateEngineListener onCreateEngineListener) {
        QLog.i("DynamicKuiklyEngine", 1, "[createEngine] params:" + map);
        handleCreateEngine(context, map, onCreateEngineListener);
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void createView(DKEngine.CreateViewInfo createViewInfo) {
        handleViewCreate(createViewInfo);
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public int getEngineGroupId() {
        QLog.e("DynamicKuiklyEngine", 1, "[getEngineGroupId]");
        return -1;
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public DKEventCenter.EngineType getEngineType() {
        QLog.e("DynamicKuiklyEngine", 1, "[getEngineType]");
        return DKEventCenter.EngineType.WORMHOLE;
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    protected void handleCreateEngine(Context context, Map<String, String> map, DKEngine.OnCreateEngineListener onCreateEngineListener) {
        QLog.i("DynamicKuiklyEngine", 1, "[handleCreateEngine] map:" + map);
        if (onCreateEngineListener != null) {
            onCreateEngineListener.onWillCreateEngine();
        }
        if (onCreateEngineListener != null) {
            onCreateEngineListener.onEngineInitialized();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ams.dsdk.core.DKEngine
    protected void handleViewCreate(DKEngine.CreateViewInfo createViewInfo) {
        if (!(createViewInfo instanceof C10472a)) {
            QLog.e("DynamicKuiklyEngine", 1, "[handleViewCreate] error, createViewInfo not instanceof DynamicKuiklyCreateViewInfo");
            return;
        }
        C10472a c10472a = (C10472a) createViewInfo;
        if (c10472a.onViewCreateListener != null) {
            createViewInfo.onViewCreateListener.onViewCreateStart();
        }
        if (c10472a.context == null) {
            QLog.e("DynamicKuiklyEngine", 1, "[handleViewCreate] error, createViewInfo.context is null");
            DKEngine.OnViewCreateListener onViewCreateListener = c10472a.onViewCreateListener;
            if (onViewCreateListener != null) {
                onViewCreateListener.onViewCreate(null, 9004);
                return;
            }
            return;
        }
        if (c10472a.f406221a == null) {
            QLog.e("DynamicKuiklyEngine", 1, "[handleViewCreate] error, createViewInfo.delegate is null");
            DKEngine.OnViewCreateListener onViewCreateListener2 = c10472a.onViewCreateListener;
            if (onViewCreateListener2 != null) {
                onViewCreateListener2.onViewCreate(null, 9004);
                return;
            }
            return;
        }
        QLog.i("DynamicKuiklyEngine", 1, "[handleViewCreate]");
        try {
            g createKuiklyRenderView = ((IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class)).createKuiklyRenderView(c10472a.context, c10472a.f406221a);
            if (!(createKuiklyRenderView instanceof View)) {
                QLog.e("DynamicKuiklyEngine", 1, "[handleViewCreate] error, kuiklyRenderView not instanceof View");
                DKEngine.OnViewCreateListener onViewCreateListener3 = c10472a.onViewCreateListener;
                if (onViewCreateListener3 != null) {
                    onViewCreateListener3.onViewCreate(null, 9001);
                    return;
                }
                return;
            }
            c10472a.f406222b = createKuiklyRenderView;
            DKEngine.OnViewCreateListener onViewCreateListener4 = c10472a.onViewCreateListener;
            if (onViewCreateListener4 != null) {
                onViewCreateListener4.onViewCreate((View) createKuiklyRenderView, 9000);
            }
        } catch (Throwable th5) {
            QLog.e("DynamicKuiklyEngine", 1, "[handleViewCreate]", th5);
            DKEngine.OnViewCreateListener onViewCreateListener5 = c10472a.onViewCreateListener;
            if (onViewCreateListener5 != null) {
                onViewCreateListener5.onViewCreate(null, 9007);
            }
        }
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public boolean isEnginePreWarmed() {
        QLog.e("DynamicKuiklyEngine", 1, "[isEnginePreWarmed]");
        return false;
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public boolean onBackPressed(DKEngine.BackPressHandler backPressHandler) {
        return false;
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void onDestroy() {
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void onResume() {
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void onStop() {
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void sendEvent(String str, Object obj) {
    }
}
