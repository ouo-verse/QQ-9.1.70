package com.tencent.hippy.qq.app;

import com.tencent.comic.api.IQQComicHippyUtil;
import com.tencent.gdtad.hippy.GdtTangramModule;
import com.tencent.hippy.qq.api.IHippyInnerApi;
import com.tencent.hippy.qq.api.IHippyModules;
import com.tencent.hippy.qq.module.QQAppModule;
import com.tencent.hippy.qq.module.QQJsbModule;
import com.tencent.hippy.qq.module.QQTroopNoticeModule;
import com.tencent.hippy.qq.module.QQUiModule;
import com.tencent.hippy.qq.utils.HippyDebugUtil;
import com.tencent.hippy.qq.view.alphavideo.HippyAlphaVideoViewController;
import com.tencent.hippy.qq.view.boodo.CommonVideoViewController;
import com.tencent.hippy.qq.view.gridview.HippyQQDragGridViewController;
import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import com.tencent.hippy.qq.view.recycleview.HippyQQRecycleViewController;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.hippy.qq.view.scroll.HippyHeaderScrollViewController;
import com.tencent.hippy.qq.view.text.HippyQQJustifyTextViewController;
import com.tencent.hippy.qq.view.video.HippyQQVideoViewController;
import com.tencent.hippy.qq.view.viola.list.TkdListItemViewController;
import com.tencent.hippy.qq.view.viola.list.TkdListViewController;
import com.tencent.hippy.qq.view.viola.scroll.TkdScrollViewController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.hippy.view.HippyDTReportController;
import com.tencent.mobileqq.vas.hippy.view.HippyLottieViewController;
import com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallItemViewController;
import com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallViewController;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class HippyQQAPIProvider implements HippyAPIProvider {
    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyViewController>> getControllers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(HippyQQVideoViewController.class);
        arrayList.add(CommonVideoViewController.class);
        arrayList.add(TkdListItemViewController.class);
        arrayList.add(TkdListViewController.class);
        arrayList.add(TkdScrollViewController.class);
        arrayList.add(HippyLottieViewController.class);
        arrayList.add(HippyDTReportController.class);
        arrayList.add(HippyWaterfallViewController.class);
        arrayList.add(HippyWaterfallItemViewController.class);
        arrayList.add(((IHippyInnerApi) QRoute.api(IHippyInnerApi.class)).getHippyQQImageViewController());
        arrayList.add(HippyQQPagViewController.class);
        arrayList.add(HippyAlphaVideoViewController.class);
        arrayList.add(HippyHeaderScrollViewController.class);
        arrayList.add(HippyHeaderListViewController.class);
        arrayList.add(HippyQQRecycleViewController.class);
        arrayList.add(HippyQQDragGridViewController.class);
        arrayList.add(HippyQQJustifyTextViewController.class);
        return arrayList;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules() {
        return null;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(final HippyEngineContext hippyEngineContext) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(((IHippyModules) QRoute.api(IHippyModules.class)).getReleaseModules(hippyEngineContext));
        final IQQComicHippyUtil iQQComicHippyUtil = (IQQComicHippyUtil) QRoute.api(IQQComicHippyUtil.class);
        hashMap.put(iQQComicHippyUtil.getHippyQQComicModuleClass(), new Provider<HippyNativeModuleBase>() { // from class: com.tencent.hippy.qq.app.HippyQQAPIProvider.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.mtt.hippy.common.Provider
            public HippyNativeModuleBase get() {
                return iQQComicHippyUtil.getHippyQQComicModule(hippyEngineContext);
            }
        });
        hashMap.put(QQAppModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.hippy.qq.app.HippyQQAPIProvider.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.mtt.hippy.common.Provider
            public HippyNativeModuleBase get() {
                return new QQAppModule(hippyEngineContext);
            }
        });
        hashMap.put(QQTroopNoticeModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.hippy.qq.app.HippyQQAPIProvider.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.mtt.hippy.common.Provider
            public HippyNativeModuleBase get() {
                return new QQTroopNoticeModule(hippyEngineContext);
            }
        });
        hashMap.put(QQUiModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.hippy.qq.app.HippyQQAPIProvider.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.mtt.hippy.common.Provider
            public HippyNativeModuleBase get() {
                return new QQUiModule(hippyEngineContext);
            }
        });
        hashMap.put(GdtTangramModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.hippy.qq.app.HippyQQAPIProvider.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.mtt.hippy.common.Provider
            public HippyNativeModuleBase get() {
                return new GdtTangramModule(hippyEngineContext);
            }
        });
        hashMap.put(QQJsbModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.hippy.qq.app.HippyQQAPIProvider.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.mtt.hippy.common.Provider
            public HippyNativeModuleBase get() {
                return new QQJsbModule(hippyEngineContext);
            }
        });
        if (HippyDebugUtil.isDebugEnable()) {
            hashMap.putAll(((IHippyModules) QRoute.api(IHippyModules.class)).getDebugModules(hippyEngineContext));
        }
        return hashMap;
    }
}
