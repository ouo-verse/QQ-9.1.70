package com.tencent.hippy.qq.module;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.IHippyAdapter;
import com.tencent.hippy.qq.api.IHippyDomNodeManager;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = QQRenderViewModule.TAG)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u001c\u0010\u0014\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/hippy/qq/module/QQRenderViewModule;", "Lcom/tencent/hippy/qq/module/QQBaseModule;", "context", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "deleteRenderViewCache", "", "params", "Lcom/tencent/mtt/hippy/common/HippyMap;", "promise", "Lcom/tencent/mtt/hippy/modules/Promise;", "doPromiseCallback", "obj", "", "removeRenderView", "saveRenderView", "sendEvent", AdMetricTag.EVENT_NAME, "", "hippyMap", "startPreRender", "Companion", "hippy-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class QQRenderViewModule extends QQBaseModule {
    public static final long REMOVE_DELAY_MINI = 100;

    @NotNull
    public static final String TAG = "QQRenderViewModule";

    public QQRenderViewModule(@Nullable HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    private final void doPromiseCallback(Promise promise, Object obj) {
        if (promise != null && promise.isCallback() && obj != null) {
            promise.resolve(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeRenderView$lambda$0(QQRenderViewModule this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HippyQQEngine hippyQQEngine = this$0.getHippyQQEngine();
        if (hippyQQEngine != null) {
            hippyQQEngine.removeSnapshotRootViewIfNeed();
        }
    }

    private final void sendEvent(String eventName, HippyMap hippyMap) {
        ((EventDispatcher) this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(eventName, hippyMap);
    }

    @HippyMethod(name = "deleteRenderViewCache")
    public final void deleteRenderViewCache(@Nullable HippyMap params, @Nullable Promise promise) {
        QLog.d(TAG, 1, "[deleteRenderViewCache] params:" + params);
        if (params == null) {
            return;
        }
        JSONObject jSONObject = params.toJSONObject();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "params.toJSONObject()");
        ((IHippyDomNodeManager) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IHippyDomNodeManager.class, ProcessConstant.MULTI)).deleteDomNodeCache(jSONObject.optString("bundleName", getHippyQQEngine().getModuleName()), jSONObject.optInt(HippyQQConstants.KEY_BUNDLE_VERSION, getHippyQQEngine().getModuleVersion()), jSONObject.optString(HippyQQConstants.KEY_RENDER_TAG));
    }

    @HippyMethod(name = "removeRenderView")
    public final void removeRenderView(@Nullable Promise promise) {
        QLog.d(TAG, 1, "[removeRenderView]");
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.hippy.qq.module.l
            @Override // java.lang.Runnable
            public final void run() {
                QQRenderViewModule.removeRenderView$lambda$0(QQRenderViewModule.this);
            }
        }, 100L);
    }

    @HippyMethod(name = "saveRenderView")
    public final void saveRenderView(@Nullable HippyMap params, @Nullable Promise promise) {
        QLog.d(TAG, 1, "[saveRenderView] params:" + params);
        if (params != null && getHippyQQEngine() != null && getHippyQQEngine().getHippyEngine() != null) {
            JSONObject jSONObject = params.toJSONObject();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "params.toJSONObject()");
            jSONObject.put("bundleName", getHippyQQEngine().getModuleName());
            jSONObject.put(HippyQQConstants.KEY_BUNDLE_VERSION, getHippyQQEngine().getModuleVersion());
            ((IHippyAdapter) QRoute.api(IHippyAdapter.class)).saveNodeSnapShotData(getHippyQQEngine().getThirdPartyAdapter(), jSONObject);
            getHippyQQEngine().getHippyEngine().saveInstanceState();
            getHippyQQEngine().destroyEngineImmediately("saveRenderView");
        }
    }

    @HippyMethod(name = "startPreRender")
    public final void startPreRender(@Nullable HippyMap params, @Nullable Promise promise) {
        int i3;
        String str;
        QLog.d(TAG, 1, "[startPreRender] params:" + params);
        if (params == null) {
            return;
        }
        boolean preNodeSnapShot = ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).preNodeSnapShot(new OpenHippyInfo(params));
        JSONObject jSONObject = new JSONObject();
        if (preNodeSnapShot) {
            i3 = 0;
        } else {
            i3 = -1;
        }
        jSONObject.put("code", i3);
        if (preNodeSnapShot) {
            str = "success";
        } else {
            str = "fail";
        }
        jSONObject.put("message", str);
        doPromiseCallback(promise, jSONObject);
    }
}
