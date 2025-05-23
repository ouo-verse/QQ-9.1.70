package com.tencent.ams.dsdk.core.wormhole;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEngine;
import com.tencent.ams.dsdk.event.DKEventCenter;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.common.wormhole.views.HippyWormholeView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKWormholeEngine extends DKHippyEngine {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKWormholeEngine";
    private boolean isInitialized;
    private final Map<String, InnerMethodHandler> mInnerMethodHandlerMap;
    private int mRootTag;
    private final Map<WormholeModuleKey, DKMethodHandler> mWormholeMethodHandlerMap;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class InnerCreateEngineListener implements DKEngine.OnCreateEngineListener {
        static IPatchRedirector $redirector_;
        private Map<String, String> adParams;
        private DKEngine.OnCreateEngineListener onCreateEngineListener;

        public InnerCreateEngineListener(Map<String, String> map, DKEngine.OnCreateEngineListener onCreateEngineListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DKWormholeEngine.this, map, onCreateEngineListener);
            } else {
                this.adParams = map;
                this.onCreateEngineListener = onCreateEngineListener;
            }
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
        public void onEngineInitializeError(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            DLog.d(DKWormholeEngine.TAG, "onEngineInitializeError, errorCode: " + i3);
            DKEngine.OnCreateEngineListener onCreateEngineListener = this.onCreateEngineListener;
            if (onCreateEngineListener != null) {
                onCreateEngineListener.onEngineInitializeError(i3);
                this.onCreateEngineListener = null;
            }
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
        public void onEngineInitialized() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                DLog.d(DKWormholeEngine.TAG, "onEngineInitialized");
                DKWormholeEngine.this.createHippyView(DKEngine.getApplicationContext(), this.adParams, new InnerOnViewCreateListener(this.onCreateEngineListener));
            }
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
        public void onWillCreateEngine() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            DKEngine.OnCreateEngineListener onCreateEngineListener = this.onCreateEngineListener;
            if (onCreateEngineListener != null) {
                onCreateEngineListener.onWillCreateEngine();
            }
            HippyEngine.EngineInitParams initParams = DKWormholeEngine.this.getInitParams();
            initParams.engineMonitor = new DKWormholeEngineReportMonitor();
            List<HippyAPIProvider> list = initParams.providers;
            if (list == null) {
                list = new ArrayList<>();
            }
            list.addAll(DKWormholeHelper.getWormholeManager().getWormholeProviders());
            initParams.providers = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class InnerMethodHandler implements DKMethodHandler {
        static IPatchRedirector $redirector_;
        private String moduleId;

        public InnerMethodHandler(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKWormholeEngine.this, (Object) str);
            } else {
                this.moduleId = str;
            }
        }

        @Override // com.tencent.ams.dsdk.event.DKMethodHandler
        public String getModuleId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.moduleId;
        }

        @Override // com.tencent.ams.dsdk.event.DKMethodHandler
        public boolean invoke(DKEngine dKEngine, String str, JSONObject jSONObject, DKMethodHandler.Callback callback) throws Exception {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, dKEngine, str, jSONObject, callback)).booleanValue();
            }
            DLog.d(DKWormholeEngine.TAG, "InnerMethodHandler invoke event, methodName:" + str + ", params:" + jSONObject);
            String optString = jSONObject.optString(DKWormholeHelper.WORMHOLE_ID);
            if (!TextUtils.isEmpty(optString)) {
                DKMethodHandler dKMethodHandler = (DKMethodHandler) DKWormholeEngine.this.mWormholeMethodHandlerMap.get(new WormholeModuleKey(optString, this.moduleId));
                if (dKMethodHandler != null) {
                    return dKMethodHandler.invoke(dKEngine, str, jSONObject, callback);
                }
            } else {
                DLog.d(DKWormholeEngine.TAG, "InnerMethodHandler invoke not wormhole event, methodName:" + str);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class InnerOnViewCreateListener implements DKEngine.OnViewCreateListener {
        static IPatchRedirector $redirector_ = null;
        private static final String TAG = "InnerOnViewCreateListener";
        private DKEngine.OnCreateEngineListener onCreateEngineListener;

        public InnerOnViewCreateListener(DKEngine.OnCreateEngineListener onCreateEngineListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKWormholeEngine.this, (Object) onCreateEngineListener);
            } else {
                this.onCreateEngineListener = onCreateEngineListener;
            }
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnViewCreateListener
        public boolean onInterceptViewCreate(View view, int i3, Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(i3), runnable)).booleanValue();
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnViewCreateListener
        public void onViewCreate(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, i3);
                return;
            }
            DLog.d(TAG, "onViewCreate, errorCode: " + i3);
            if ((view instanceof HippyRootView) && i3 == 9000) {
                DKWormholeEngine.this.mRootTag = view.getId();
                return;
            }
            DKEngine.OnCreateEngineListener onCreateEngineListener = this.onCreateEngineListener;
            if (onCreateEngineListener != null) {
                onCreateEngineListener.onEngineInitializeError(i3);
                this.onCreateEngineListener = null;
            }
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnViewCreateListener
        public void onViewCreateStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                DLog.d(TAG, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATE_START);
            }
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnViewCreateListener
        public void onViewInitializeError(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
                return;
            }
            DLog.d(TAG, "onViewInitializeError, errorCode: " + i3);
            DKEngine.OnCreateEngineListener onCreateEngineListener = this.onCreateEngineListener;
            if (onCreateEngineListener != null) {
                onCreateEngineListener.onEngineInitializeError(i3);
                this.onCreateEngineListener = null;
            }
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnViewCreateListener
        public void onViewInitialized() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            DLog.d(TAG, "onViewInitialized");
            DKWormholeEngine.this.handleInitialized(this.onCreateEngineListener);
            this.onCreateEngineListener = null;
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnViewCreateListener
        public void onViewLoadComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                DLog.d(TAG, "onViewLoadComplete");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class WormholeModuleKey {
        static IPatchRedirector $redirector_;
        private String moduleId;
        private String wormholeId;

        public WormholeModuleKey(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DKWormholeEngine.this, str, str2);
            } else {
                this.wormholeId = str;
                this.moduleId = str2;
            }
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
            }
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WormholeModuleKey wormholeModuleKey = (WormholeModuleKey) obj;
            if (Objects.equals(this.wormholeId, wormholeModuleKey.wormholeId) && Objects.equals(this.moduleId, wormholeModuleKey.moduleId)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return Objects.hash(this.wormholeId, this.moduleId);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DKWormholeEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isInitialized = false;
        this.mWormholeMethodHandlerMap = new HashMap();
        this.mInnerMethodHandlerMap = new HashMap();
    }

    private void bindWormholeView(View view, Map<String, String> map, DKEngine.OnViewCreateListener onViewCreateListener) {
        if (!(view instanceof DKWormholeView)) {
            if (onViewCreateListener != null) {
                onViewCreateListener.onViewInitializeError(9009);
                return;
            }
            return;
        }
        DKWormholeView dKWormholeView = (DKWormholeView) view;
        if (onViewCreateListener != null) {
            onViewCreateListener.onViewCreate(dKWormholeView, 9000);
        }
        if (dKWormholeView.getRootId() != 0 && !TextUtils.isEmpty(dKWormholeView.getWormholeId())) {
            String wormholeId = dKWormholeView.getWormholeId();
            int rootId = dKWormholeView.getRootId();
            HippyMap transferData = transferData(wormholeId, map);
            if (dKWormholeView.getChildAt(0) instanceof HippyWormholeView) {
                DLog.d(TAG, "update, wormholeId: " + wormholeId + ", rootId: " + rootId + ", data: " + transferData.toString());
                DKWormholeHelper.getWormholeManager().sendDataUpdatedMessageToServer(transferData, rootId);
                if (onViewCreateListener != null) {
                    onViewCreateListener.onViewInitialized();
                    onViewCreateListener.onViewLoadComplete();
                    return;
                }
                return;
            }
            DLog.d(TAG, "create, wormholeId: " + wormholeId + ", rootId: " + rootId + ", data: " + transferData.toString());
            DKWormholeHelper.onNativeBindItemView(wormholeId, dKWormholeView, transferData, rootId, new HippyWormholeView.OnWormholeViewListener(wormholeId, transferData, onViewCreateListener) { // from class: com.tencent.ams.dsdk.core.wormhole.DKWormholeEngine.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ HippyMap val$data;
                final /* synthetic */ DKEngine.OnViewCreateListener val$onViewCreateListener;
                final /* synthetic */ String val$wormholeId;

                {
                    this.val$wormholeId = wormholeId;
                    this.val$data = transferData;
                    this.val$onViewCreateListener = onViewCreateListener;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, DKWormholeEngine.this, wormholeId, transferData, onViewCreateListener);
                    }
                }

                public void onViewAdd(HippyWormholeView hippyWormholeView, String str) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) hippyWormholeView, (Object) str);
                        return;
                    }
                    DLog.d(DKWormholeEngine.TAG, "onViewLoadComplete, wormholeId: " + this.val$wormholeId + ", data: " + this.val$data.toString());
                    DKEngine.OnViewCreateListener onViewCreateListener2 = this.val$onViewCreateListener;
                    if (onViewCreateListener2 != null) {
                        onViewCreateListener2.onViewInitialized();
                        this.val$onViewCreateListener.onViewLoadComplete();
                    }
                }
            });
            return;
        }
        if (onViewCreateListener != null) {
            onViewCreateListener.onViewInitializeError(9004);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createHippyView(Context context, Map<String, String> map, DKEngine.OnViewCreateListener onViewCreateListener) {
        DKEngine.CreateViewInfo createViewInfo = new DKEngine.CreateViewInfo();
        createViewInfo.context = context;
        createViewInfo.onViewCreateListener = onViewCreateListener;
        createViewInfo.params = map;
        if (!this.mIsDebugMode && !checkParams(createViewInfo)) {
            DLog.w(TAG, "check params fail.");
        } else {
            handleViewCreate(createViewInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInitialized(DKEngine.OnCreateEngineListener onCreateEngineListener) {
        this.isInitialized = true;
        try {
            DKWormholeHelper.getWormholeManager().setServerEngine(getHippyEngine());
            DKWormholeHelper.getWormholeManager().registerClientEngine(getHippyEngine());
            if (onCreateEngineListener != null) {
                onCreateEngineListener.onEngineInitialized();
            }
        } catch (Throwable th5) {
            DLog.e(TAG, "handleInitialized error.", th5);
            this.isInitialized = false;
            DKWormholeHelper.getWormholeManager().setServerEngine((HippyEngine) null);
            if (onCreateEngineListener != null) {
                onCreateEngineListener.onEngineInitializeError(3);
            }
        }
    }

    private HippyMap transferData(String str, Map<String, String> map) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString(DKWormholeHelper.WORMHOLE_ID, str);
        if (map != null && !map.isEmpty()) {
            HippyMap hippyMap2 = new HippyMap();
            hippyMap2.pushJSONObject(new JSONObject(map));
            hippyMap.pushMap("data", hippyMap2);
        }
        return hippyMap;
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void createEngine(Context context, Map<String, String> map, DKEngine.OnCreateEngineListener onCreateEngineListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, map, onCreateEngineListener);
            return;
        }
        DLog.d(TAG, "createEngine");
        if (!DKWormholeHelper.checkWormholeEnvironment()) {
            DLog.w(TAG, "engine initialize error: env not support.");
            if (onCreateEngineListener != null) {
                onCreateEngineListener.onEngineInitializeError(4);
                return;
            }
            return;
        }
        if (!this.isInitialized) {
            DLog.d(TAG, "engine not initialized.");
            super.createEngine(context, map, new InnerCreateEngineListener(map, onCreateEngineListener));
        } else {
            DLog.d(TAG, "engine initialized.");
            if (onCreateEngineListener != null) {
                onCreateEngineListener.onEngineInitialized();
            }
        }
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void createView(DKEngine.CreateViewInfo createViewInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) createViewInfo);
            return;
        }
        DLog.d(TAG, "createView: " + createViewInfo);
        if (createViewInfo == null) {
            DLog.w(TAG, "createView failed: createViewInfo should be not null");
            return;
        }
        if (!DKWormholeHelper.checkWormholeEnvironment()) {
            DLog.w(TAG, "createView error: env not support.");
            DKEngine.OnViewCreateListener onViewCreateListener = createViewInfo.onViewCreateListener;
            if (onViewCreateListener != null) {
                onViewCreateListener.onViewInitializeError(9008);
                return;
            }
            return;
        }
        if (!this.isInitialized) {
            DKEngine.OnViewCreateListener onViewCreateListener2 = createViewInfo.onViewCreateListener;
            if (onViewCreateListener2 != null) {
                onViewCreateListener2.onViewInitializeError(9002);
                return;
            }
            return;
        }
        bindWormholeView(createViewInfo.container, createViewInfo.params, createViewInfo.onViewCreateListener);
    }

    public void destroyWormhole(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
            return;
        }
        DLog.d(TAG, "onDestroy, wormholeId: " + str + ", rootId: " + i3);
        DKWormholeHelper.getWormholeManager().onNativeWormholeDestroy(str, i3);
    }

    public int generateRootId(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context)).intValue();
        }
        if (context != null) {
            return context.getClass().hashCode();
        }
        return 0;
    }

    public String generateWormholeId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return DKWormholeHelper.getWormholeManager().generateWormholeId();
    }

    @Override // com.tencent.ams.dsdk.core.hippy.DKHippyEngine, com.tencent.ams.dsdk.core.DKEngine
    public DKEventCenter.EngineType getEngineType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DKEventCenter.EngineType) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return DKEventCenter.EngineType.WORMHOLE;
    }

    @Override // com.tencent.ams.dsdk.core.hippy.DKHippyEngine, com.tencent.ams.dsdk.core.DKEngine
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.onDestroy();
            this.isInitialized = false;
        }
    }

    public boolean registerMethodHandler(String str, DKMethodHandler dKMethodHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) dKMethodHandler)).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && dKMethodHandler != null && !TextUtils.isEmpty(dKMethodHandler.getModuleId())) {
            this.mWormholeMethodHandlerMap.put(new WormholeModuleKey(str, dKMethodHandler.getModuleId()), dKMethodHandler);
            if (this.mInnerMethodHandlerMap.get(dKMethodHandler.getModuleId()) != null) {
                return false;
            }
            InnerMethodHandler innerMethodHandler = new InnerMethodHandler(dKMethodHandler.getModuleId());
            this.mInnerMethodHandlerMap.put(dKMethodHandler.getModuleId(), innerMethodHandler);
            return super.registerMethodHandler(innerMethodHandler);
        }
        DLog.w(TAG, "registerMethodHandler failed: invalid params");
        return false;
    }

    @Override // com.tencent.ams.dsdk.core.hippy.DKHippyEngine, com.tencent.ams.dsdk.core.DKEngine
    public void sendEvent(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, obj);
            return;
        }
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("event", str);
        hippyMap.pushInt("rootTag", this.mRootTag);
        try {
            hippyMap.pushObject("data", obj);
        } catch (Throwable th5) {
            DLog.e(TAG, "wrapper event data error.", th5);
        }
        if (DKWormholeHelper.getWormholeManager().isWormholeEngine(getHippyEngineContext())) {
            DKWormholeHelper.getWormholeManager().sendMessageToWormhole(hippyMap);
        } else {
            DKWormholeHelper.sendMessageToAllClient(hippyMap);
        }
    }

    public boolean unregisterMethodHandler(String str, DKMethodHandler dKMethodHandler) {
        boolean z16;
        InnerMethodHandler remove;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) dKMethodHandler)).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && dKMethodHandler != null && dKMethodHandler.getModuleId() != null) {
            DKMethodHandler remove2 = this.mWormholeMethodHandlerMap.remove(new WormholeModuleKey(str, dKMethodHandler.getModuleId()));
            if (remove2 != null && remove2.getModuleId() != null) {
                DLog.i(TAG, "unregisterMethodHandler success, wormholeId: " + str + ", moduleId: " + remove2.getModuleId());
                Iterator<DKMethodHandler> it = this.mWormholeMethodHandlerMap.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        DKMethodHandler next = it.next();
                        if (next != null && dKMethodHandler.getModuleId().equals(next.getModuleId())) {
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (z16 || (remove = this.mInnerMethodHandlerMap.remove(dKMethodHandler.getModuleId())) == null) {
                    return false;
                }
                DLog.i(TAG, "unregister module handler success, module:" + dKMethodHandler.getModuleId() + ", wormholeId: " + str);
                return super.unregisterMethodHandler(remove);
            }
            DLog.w(TAG, "unregisterMethodHandler failed: handler has been unregistered, wormholeId: " + str);
            return false;
        }
        DLog.w(TAG, "unregisterMethodHandler failed: invalid params, wormholeId: " + str);
        return false;
    }
}
