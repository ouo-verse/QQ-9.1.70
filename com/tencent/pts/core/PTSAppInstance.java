package com.tencent.pts.core;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.pts.bridge.PTSJSBridge;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.jni.PTSJsJniHandler;
import com.tencent.pts.core.jni.PTSLiteJniHandler;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.core.lite.PTSLiteBridge;
import com.tencent.pts.core.lite.PTSLiteItemViewManager;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes22.dex */
public abstract class PTSAppInstance {
    static IPatchRedirector $redirector_ = null;
    private static final AtomicInteger NEXT_ID;
    private static final String TAG = "PTSAppInstance";
    private float containerWidth;
    private Context context;
    private String frameTreeJson;
    protected PTSItemData itemData;
    private String pageJs;
    private String pageName;
    private PTSComposer ptsComposer;
    private PTSRootNode rootNode;
    private int rootNodeType;
    private ViewGroup rootView;
    private int uniqueId;

    /* loaded from: classes22.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private float containerWidth;
        private Context context;
        private String frameTreeJson;
        private PTSItemData itemData;
        private IPTSLiteEventListener liteEventListener;
        private PTSLiteItemViewManager liteItemViewManager;
        private String pageJs;
        private String pageName;
        private PTSJSBridge ptsJSBridge;
        private int rootNodeType;
        private ViewGroup rootView;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private void check() {
            if (TextUtils.isEmpty(this.pageName)) {
                if (!PTSLog.isDebug()) {
                    this.pageName = "null";
                    PTSLog.e(PTSAppInstance.TAG, "[check] PTSAppInstance pageName is empty.");
                } else {
                    throw new IllegalStateException("PTSAppInstance pageName is empty.");
                }
            }
            if (TextUtils.isEmpty(this.frameTreeJson)) {
                if (!PTSLog.isDebug()) {
                    this.frameTreeJson = "{}";
                    PTSLog.e(PTSAppInstance.TAG, "[check] PTSAppInstance frameTreeJson is empty.");
                    return;
                }
                throw new IllegalStateException("PTSAppInstance frameTreeJson is empty.");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PTSAppInstance build() {
            PTSLiteAppInstance pTSLiteAppInstance;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (PTSAppInstance) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            AnonymousClass1 anonymousClass1 = null;
            if (this.ptsJSBridge != null) {
                PTSJsAppInstance pTSJsAppInstance = new PTSJsAppInstance(anonymousClass1);
                pTSJsAppInstance.setJsBridge(this.ptsJSBridge);
                pTSLiteAppInstance = pTSJsAppInstance;
            } else {
                PTSLiteAppInstance pTSLiteAppInstance2 = new PTSLiteAppInstance(anonymousClass1);
                pTSLiteAppInstance2.setLiteItemViewManager(this.liteItemViewManager);
                pTSLiteAppInstance2.setLiteEventListener(this.liteEventListener);
                pTSLiteAppInstance = pTSLiteAppInstance2;
            }
            ((PTSAppInstance) pTSLiteAppInstance).context = this.context;
            ((PTSAppInstance) pTSLiteAppInstance).rootView = this.rootView;
            ((PTSAppInstance) pTSLiteAppInstance).rootNodeType = this.rootNodeType;
            ((PTSAppInstance) pTSLiteAppInstance).pageName = this.pageName;
            pTSLiteAppInstance.itemData = this.itemData;
            ((PTSAppInstance) pTSLiteAppInstance).frameTreeJson = this.frameTreeJson;
            ((PTSAppInstance) pTSLiteAppInstance).pageJs = this.pageJs;
            ((PTSAppInstance) pTSLiteAppInstance).containerWidth = this.containerWidth;
            check();
            pTSLiteAppInstance.init(this.rootNodeType);
            return pTSLiteAppInstance;
        }

        public Builder withContainerWidth(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
            }
            this.containerWidth = f16;
            return this;
        }

        public Builder withContext(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            this.context = context;
            return this;
        }

        public Builder withFrameTreeJson(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            }
            this.frameTreeJson = str;
            return this;
        }

        public Builder withItemData(PTSItemData pTSItemData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) pTSItemData);
            }
            this.itemData = pTSItemData;
            if (pTSItemData != null) {
                this.pageName = pTSItemData.getPageName();
                this.frameTreeJson = pTSItemData.getFrameTreeJson();
                this.pageJs = pTSItemData.getPageJs();
            }
            return this;
        }

        public Builder withLiteEventListener(IPTSLiteEventListener iPTSLiteEventListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) iPTSLiteEventListener);
            }
            this.liteEventListener = iPTSLiteEventListener;
            return this;
        }

        public Builder withLiteItemViewManager(PTSLiteItemViewManager pTSLiteItemViewManager) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) pTSLiteItemViewManager);
            }
            this.liteItemViewManager = pTSLiteItemViewManager;
            return this;
        }

        public Builder withPTSJSBridge(PTSJSBridge pTSJSBridge) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) pTSJSBridge);
            }
            this.ptsJSBridge = pTSJSBridge;
            return this;
        }

        public Builder withPageJs(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            }
            this.pageJs = str;
            return this;
        }

        public Builder withPageName(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            this.pageName = str;
            return this;
        }

        public Builder withRootNodeType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.rootNodeType = i3;
            return this;
        }

        public Builder withRootView(ViewGroup viewGroup) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup);
            }
            this.rootView = viewGroup;
            return this;
        }
    }

    /* loaded from: classes22.dex */
    public static class PTSJsAppInstance extends PTSAppInstance {
        static IPatchRedirector $redirector_;
        private PTSJSBridge ptsJsBridge;

        /* synthetic */ PTSJsAppInstance(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setJsBridge(PTSJSBridge pTSJSBridge) {
            this.ptsJsBridge = pTSJSBridge;
        }

        @Override // com.tencent.pts.core.PTSAppInstance
        public PTSJSBridge getJsBridge() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (PTSJSBridge) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.ptsJsBridge;
        }

        @Override // com.tencent.pts.core.PTSAppInstance
        void initPTSAppInstance(String str, String str2) {
            this.ptsJsBridge.initAppJSBundle(str, str2, this);
        }

        @Override // com.tencent.pts.core.PTSAppInstance
        public void onDestroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onDestroy();
            PTSJsJniHandler.destroy(this, this.ptsJsBridge.getJsEnvID());
            this.ptsJsBridge = null;
        }

        @Override // com.tencent.pts.core.PTSAppInstance
        public void setItemData(PTSItemData pTSItemData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) pTSItemData);
            } else {
                super.setItemData(pTSItemData);
                this.ptsJsBridge.callOnLoadJsFunction(this);
            }
        }

        PTSJsAppInstance() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* loaded from: classes22.dex */
    public static class PTSLiteAppInstance extends PTSAppInstance {
        static IPatchRedirector $redirector_;
        private IPTSLiteEventListener liteEventListener;
        private PTSLiteItemViewManager liteItemViewManager;
        private PTSLiteBridge ptsLiteBridge;

        /* synthetic */ PTSLiteAppInstance(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                return;
            }
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) anonymousClass1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLiteEventListener(IPTSLiteEventListener iPTSLiteEventListener) {
            this.liteEventListener = iPTSLiteEventListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLiteItemViewManager(PTSLiteItemViewManager pTSLiteItemViewManager) {
            this.liteItemViewManager = pTSLiteItemViewManager;
        }

        @Override // com.tencent.pts.core.PTSAppInstance
        public PTSLiteBridge getLiteBridge() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (PTSLiteBridge) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.ptsLiteBridge;
        }

        public IPTSLiteEventListener getLiteEventListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (IPTSLiteEventListener) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.liteEventListener;
        }

        public PTSLiteItemViewManager getLiteItemViewManager() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (PTSLiteItemViewManager) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.liteItemViewManager;
        }

        @Override // com.tencent.pts.core.PTSAppInstance
        void initPTSAppInstance(String str, String str2) {
            this.ptsLiteBridge.initAppLiteBundle(str, this);
            this.ptsLiteBridge.setData(getItemData(), this);
        }

        @Override // com.tencent.pts.core.PTSAppInstance
        public void onDestroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onDestroy();
            PTSLiteJniHandler.destroy(this);
            this.liteItemViewManager = null;
            this.liteEventListener = null;
        }

        @Override // com.tencent.pts.core.PTSAppInstance
        public void setItemData(PTSItemData pTSItemData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) pTSItemData);
            } else {
                super.setItemData(pTSItemData);
                this.ptsLiteBridge.setData(getItemData(), this);
            }
        }

        public void triggerLiteEvent(int i3, String str, HashMap<String, String> hashMap, View view, PTSComposer pTSComposer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), str, hashMap, view, pTSComposer);
                return;
            }
            if (this.liteEventListener == null) {
                PTSLog.i(PTSAppInstance.TAG, "[triggerLiteEvent], liteEventListener is null.");
                return;
            }
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            hashMap.put("pts:pageName", getPageName());
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                PTSLog.i(PTSAppInstance.TAG, "[triggerLiteEvent] unknown, eventType = " + i3);
                                return;
                            }
                            this.liteEventListener.onScrollViewItemExposureTriggered(str, hashMap, view, pTSComposer);
                            return;
                        }
                        this.liteEventListener.onSwiperDragTriggered(str, hashMap, view, pTSComposer);
                        return;
                    }
                    this.liteEventListener.onSwiperItemExposureTriggered(str, hashMap, view, pTSComposer);
                    return;
                }
                this.liteEventListener.onExposureTriggered(str, hashMap, view, pTSComposer);
                return;
            }
            this.liteEventListener.onTapEventTriggered(str, hashMap, view, pTSComposer);
        }

        @Override // com.tencent.pts.core.PTSAppInstance
        public String updateData(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            String updateData = this.ptsLiteBridge.updateData(str, this);
            if (getItemData() != null) {
                this.itemData = new PTSItemData.Builder().withPageName(getItemData().getPageName()).withFrameTreeJson(getItemData().getFrameTreeJson()).withJsonData(updateData).build();
            }
            return updateData;
        }

        PTSLiteAppInstance() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.ptsLiteBridge = new PTSLiteBridge();
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37141);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            NEXT_ID = new AtomicInteger(1);
        }
    }

    /* synthetic */ PTSAppInstance(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
            return;
        }
        iPatchRedirector.redirect((short) 25, (Object) this, (Object) anonymousClass1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init(int i3) {
        this.rootNode = new PTSRootNode(this, this.rootView, i3);
        initPTSAppInstance(this.frameTreeJson, this.pageJs);
    }

    private void release() {
        this.context = null;
        this.rootView = null;
        this.rootNode = null;
    }

    public void addOnRecyclerViewScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) onScrollListener);
            return;
        }
        PTSRootNode pTSRootNode = this.rootNode;
        if (pTSRootNode != null) {
            pTSRootNode.addOnRecyclerViewScrollListener(onScrollListener);
        }
    }

    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Context) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.context;
    }

    public PTSItemData getItemData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (PTSItemData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.itemData;
    }

    public PTSJSBridge getJsBridge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (PTSJSBridge) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return null;
    }

    public PTSLiteBridge getLiteBridge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (PTSLiteBridge) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return null;
    }

    public String getPageName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.pageName;
    }

    public PTSComposer getPtsComposer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (PTSComposer) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.ptsComposer;
    }

    public PTSRootNode getRootNode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (PTSRootNode) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.rootNode;
    }

    public int getRootNodeType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.rootNodeType;
    }

    public float getRootViewWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Float) iPatchRedirector.redirect((short) 14, (Object) this)).floatValue();
        }
        float f16 = this.containerWidth;
        if (f16 > 0.0f) {
            return f16;
        }
        return PTSDeviceUtil.getScreenWidthDp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float[] getTextMeasuredSize(float[] fArr, String str, String str2, String str3, String str4) {
        return PTSNodeFactory.getTextMeasuredSize(fArr, str, str2, str3, str4);
    }

    public int getUniqueID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.uniqueId;
    }

    abstract void initPTSAppInstance(String str, String str2);

    public boolean isJsAppInstance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return this instanceof PTSJsAppInstance;
    }

    public boolean isLiteAppInstance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this instanceof PTSLiteAppInstance;
    }

    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            PTSLog.i(TAG, "[onDestroy], destroy PTSJNIHandler.");
            release();
        }
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public void setContext(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) context);
        } else {
            this.context = context;
        }
    }

    public void setItemData(PTSItemData pTSItemData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) pTSItemData);
        } else {
            this.itemData = pTSItemData;
        }
    }

    public void setPtsComposer(PTSComposer pTSComposer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) pTSComposer);
        } else {
            this.ptsComposer = pTSComposer;
        }
    }

    public void setPtsLiteEventListener(IPTSLiteEventListener iPTSLiteEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) iPTSLiteEventListener);
        } else if (this instanceof PTSLiteAppInstance) {
            ((PTSLiteAppInstance) this).setLiteEventListener(iPTSLiteEventListener);
        } else {
            PTSLog.i(TAG, "[setLiteEventListener] failed, this is not PTSLiteAppInstance.");
        }
    }

    public void triggerExposureEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        PTSRootNode rootNode = getRootNode();
        if (rootNode != null && rootNode.getRootNodeInfo() != null) {
            PTSNodeInfo rootNodeInfo = rootNode.getRootNodeInfo();
            HashMap<String, String> eventInfo = rootNodeInfo.getEventInfo();
            String eventPtsOnExposure = rootNodeInfo.getAttributes().getEventPtsOnExposure();
            if (isLiteAppInstance()) {
                ((PTSLiteAppInstance) this).triggerLiteEvent(2, eventPtsOnExposure, eventInfo, rootNode.getRootView(), getPtsComposer());
                return;
            } else {
                PTSLog.e(TAG, "[triggerExposureEvent] failed, is not PTSLiteAppInstance.");
                return;
            }
        }
        PTSLog.e(TAG, "[triggerExposureEvent], ptsRootNode or rootNodeInfo is null.");
    }

    public String updateData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        }
        return "";
    }

    PTSAppInstance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.uniqueId = NEXT_ID.getAndIncrement();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
