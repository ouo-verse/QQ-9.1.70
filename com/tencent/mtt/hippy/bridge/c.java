package com.tencent.mtt.hippy.bridge;

import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.Dimensions;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.modules.nativemodules.animation.AnimationFrameModule;
import com.tencent.mtt.hippy.modules.nativemodules.animation.AnimationModule;
import com.tencent.mtt.hippy.modules.nativemodules.audio.AudioPlayerModule;
import com.tencent.mtt.hippy.modules.nativemodules.clipboard.ClipboardModule;
import com.tencent.mtt.hippy.modules.nativemodules.console.ConsoleModule;
import com.tencent.mtt.hippy.modules.nativemodules.debug.DevMenu;
import com.tencent.mtt.hippy.modules.nativemodules.deviceevent.DeviceEventModule;
import com.tencent.mtt.hippy.modules.nativemodules.exception.ExceptionModule;
import com.tencent.mtt.hippy.modules.nativemodules.image.ImageLoaderModule;
import com.tencent.mtt.hippy.modules.nativemodules.netinfo.NetInfoModule;
import com.tencent.mtt.hippy.modules.nativemodules.network.NetworkModule;
import com.tencent.mtt.hippy.modules.nativemodules.network.WebSocketModule;
import com.tencent.mtt.hippy.modules.nativemodules.storage.StorageModule;
import com.tencent.mtt.hippy.modules.nativemodules.timer.TimerModule;
import com.tencent.mtt.hippy.modules.nativemodules.uimanager.UIManagerModule;
import com.tencent.mtt.hippy.modules.nativemodules.utils.UtilsModule;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.views.custom.HippyCustomPropsController;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewController;
import com.tencent.mtt.hippy.views.hippylistpager.HippyRecyclerPagerViewController;
import com.tencent.mtt.hippy.views.image.HippyImageViewController;
import com.tencent.mtt.hippy.views.list.HippyListItemViewController;
import com.tencent.mtt.hippy.views.modal.HippyModalHostManager;
import com.tencent.mtt.hippy.views.navigator.NavigatorController;
import com.tencent.mtt.hippy.views.refresh.HippyPullFooterViewController;
import com.tencent.mtt.hippy.views.refresh.HippyPullHeaderViewController;
import com.tencent.mtt.hippy.views.refresh.RefreshWrapperController;
import com.tencent.mtt.hippy.views.refresh.RefreshWrapperItemController;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewController;
import com.tencent.mtt.hippy.views.text.HippyTextViewController;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.mtt.hippy.views.view.HippyViewGroupController;
import com.tencent.mtt.hippy.views.viewpager.HippyViewPagerController;
import com.tencent.mtt.hippy.views.viewpager.HippyViewPagerItemController;
import com.tencent.mtt.hippy.views.waterfalllist.HippyWaterfallItemViewController;
import com.tencent.mtt.hippy.views.waterfalllist.HippyWaterfallViewController;
import com.tencent.mtt.hippy.views.webview.HippyWebViewController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c implements HippyAPIProvider {
    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyViewController>> getControllers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(HippyTextViewController.class);
        arrayList.add(HippyViewGroupController.class);
        arrayList.add(HippyImageViewController.class);
        arrayList.add(HippyRecyclerViewController.class);
        arrayList.add(HippyListItemViewController.class);
        arrayList.add(HippyTextInputController.class);
        arrayList.add(HippyScrollViewController.class);
        arrayList.add(HippyViewPagerController.class);
        arrayList.add(HippyViewPagerItemController.class);
        arrayList.add(HippyModalHostManager.class);
        arrayList.add(RefreshWrapperController.class);
        arrayList.add(RefreshWrapperItemController.class);
        arrayList.add(HippyPullHeaderViewController.class);
        arrayList.add(HippyPullFooterViewController.class);
        arrayList.add(NavigatorController.class);
        arrayList.add(HippyWebViewController.class);
        arrayList.add(HippyCustomPropsController.class);
        arrayList.add(HippyWaterfallViewController.class);
        arrayList.add(HippyWaterfallItemViewController.class);
        arrayList.add(HippyRecyclerPagerViewController.class);
        return arrayList;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(EventDispatcher.class);
        arrayList.add(Dimensions.class);
        return arrayList;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(final HippyEngineContext hippyEngineContext) {
        HashMap hashMap = new HashMap();
        hashMap.put(TimerModule.class, new Provider<TimerModule>() { // from class: com.tencent.mtt.hippy.bridge.c.1
            @Override // com.tencent.mtt.hippy.common.Provider
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TimerModule get() {
                return new TimerModule(hippyEngineContext);
            }
        });
        hashMap.put(ConsoleModule.class, new Provider<ConsoleModule>() { // from class: com.tencent.mtt.hippy.bridge.c.9
            @Override // com.tencent.mtt.hippy.common.Provider
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ConsoleModule get() {
                return new ConsoleModule(hippyEngineContext);
            }
        });
        hashMap.put(ExceptionModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.mtt.hippy.bridge.c.10
            @Override // com.tencent.mtt.hippy.common.Provider
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HippyNativeModuleBase get() {
                return new ExceptionModule(hippyEngineContext);
            }
        });
        hashMap.put(UIManagerModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.mtt.hippy.bridge.c.11
            @Override // com.tencent.mtt.hippy.common.Provider
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HippyNativeModuleBase get() {
                return new UIManagerModule(hippyEngineContext);
            }
        });
        hashMap.put(AnimationModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.mtt.hippy.bridge.c.12
            @Override // com.tencent.mtt.hippy.common.Provider
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HippyNativeModuleBase get() {
                return new AnimationModule(hippyEngineContext);
            }
        });
        hashMap.put(StorageModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.mtt.hippy.bridge.c.13
            @Override // com.tencent.mtt.hippy.common.Provider
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HippyNativeModuleBase get() {
                return new StorageModule(hippyEngineContext);
            }
        });
        hashMap.put(NetInfoModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.mtt.hippy.bridge.c.14
            @Override // com.tencent.mtt.hippy.common.Provider
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HippyNativeModuleBase get() {
                return new NetInfoModule(hippyEngineContext);
            }
        });
        hashMap.put(AnimationFrameModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.mtt.hippy.bridge.c.15
            @Override // com.tencent.mtt.hippy.common.Provider
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HippyNativeModuleBase get() {
                return new AnimationFrameModule(hippyEngineContext);
            }
        });
        hashMap.put(ImageLoaderModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.mtt.hippy.bridge.c.16
            @Override // com.tencent.mtt.hippy.common.Provider
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HippyNativeModuleBase get() {
                return new ImageLoaderModule(hippyEngineContext);
            }
        });
        hashMap.put(NetworkModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.mtt.hippy.bridge.c.2
            @Override // com.tencent.mtt.hippy.common.Provider
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HippyNativeModuleBase get() {
                return new NetworkModule(hippyEngineContext);
            }
        });
        hashMap.put(DeviceEventModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.mtt.hippy.bridge.c.3
            @Override // com.tencent.mtt.hippy.common.Provider
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HippyNativeModuleBase get() {
                return new DeviceEventModule(hippyEngineContext);
            }
        });
        hashMap.put(WebSocketModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.mtt.hippy.bridge.c.4
            @Override // com.tencent.mtt.hippy.common.Provider
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HippyNativeModuleBase get() {
                return new WebSocketModule(hippyEngineContext);
            }
        });
        hashMap.put(UtilsModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.mtt.hippy.bridge.c.5
            @Override // com.tencent.mtt.hippy.common.Provider
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HippyNativeModuleBase get() {
                return new UtilsModule(hippyEngineContext);
            }
        });
        hashMap.put(ClipboardModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.mtt.hippy.bridge.c.6
            @Override // com.tencent.mtt.hippy.common.Provider
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HippyNativeModuleBase get() {
                return new ClipboardModule(hippyEngineContext);
            }
        });
        hashMap.put(DevMenu.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.mtt.hippy.bridge.c.7
            @Override // com.tencent.mtt.hippy.common.Provider
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HippyNativeModuleBase get() {
                return new DevMenu(hippyEngineContext);
            }
        });
        hashMap.put(AudioPlayerModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.mtt.hippy.bridge.c.8
            @Override // com.tencent.mtt.hippy.common.Provider
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HippyNativeModuleBase get() {
                return new AudioPlayerModule(hippyEngineContext);
            }
        });
        return hashMap;
    }
}
