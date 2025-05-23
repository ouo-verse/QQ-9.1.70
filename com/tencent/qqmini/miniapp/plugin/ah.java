package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.container.core.MiniWebView;
import com.tencent.qqmini.container.core.ax;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ah extends BaseJsPlugin {
    private static final int EMBEDDED_ON_DESTROY_EVENT = 3;
    private static final int EMBEDDED_ON_PAUSE_EVENT = 2;
    private static final int EMBEDDED_ON_RESUME_EVENT = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ EmbeddedWidgetClientFactory lambda$getFactory$0(BaseRuntime baseRuntime) {
        IPage page = baseRuntime.getPage();
        if (!(page instanceof AppBrandPageContainer)) {
            QMLog.d(Action.TAG, "Page is invalid");
            return null;
        }
        return ((AppBrandPageContainer) page).getCurrentX5EmbeddedWidgetClientFactory();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public EmbeddedWidgetClientFactory getFactory(RequestEvent requestEvent) {
        if (this.mIsContainer && requestEvent != null) {
            IJsService iJsService = requestEvent.jsService;
            if (iJsService instanceof MiniWebView) {
                return ((MiniWebView) iJsService).K();
            }
            MiniWebView s16 = ((ax) this.mMiniAppContext).s(requestEvent.webViewId);
            if (s16 != null) {
                return s16.K();
            }
            return null;
        }
        return (EmbeddedWidgetClientFactory) this.mMiniAppContext.performAction(new Action() { // from class: com.tencent.qqmini.miniapp.plugin.ag
            @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
            public final Object perform(BaseRuntime baseRuntime) {
                EmbeddedWidgetClientFactory lambda$getFactory$0;
                lambda$getFactory$0 = ah.lambda$getFactory$0(baseRuntime);
                return lambda$getFactory$0;
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        onEmbeddedWidgetLifeCycleEvent(3);
    }

    protected void onEmbeddedWidgetLifeCycleEvent(int i3) {
        EmbeddedWidgetClientFactory factory = getFactory(null);
        if (factory != null && factory.getEmbeddedWidgetClientHolderMap() != null) {
            Iterator<Map.Entry<Long, EmbeddedWidgetClientHolder>> it = factory.getEmbeddedWidgetClientHolderMap().entrySet().iterator();
            while (it.hasNext()) {
                EmbeddedWidgetClientHolder value = it.next().getValue();
                if (value != null) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                value.nativeDestroy();
                                it.remove();
                            }
                        } else {
                            value.nativePause();
                        }
                    } else {
                        value.nativeResume();
                    }
                }
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onPause() {
        super.onPause();
        onEmbeddedWidgetLifeCycleEvent(2);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onResume() {
        super.onResume();
        onEmbeddedWidgetLifeCycleEvent(1);
    }
}
