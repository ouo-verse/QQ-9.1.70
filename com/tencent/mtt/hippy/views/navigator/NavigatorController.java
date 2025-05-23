package com.tencent.mtt.hippy.views.navigator;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyGroupController;

/* compiled from: P */
@HippyController(name = NavigatorController.CLASS)
/* loaded from: classes20.dex */
public class NavigatorController extends HippyGroupController<Navigator> {
    public static final String CLASS = "Navigator";
    private static final String POP = "pop";
    private static final String PUSH = "push";

    public static void destroyInstance(View view) {
        if (view instanceof HippyRootView) {
            ((HippyInstanceContext) view.getContext()).getEngineManager().destroyModule((HippyRootView) view);
        }
    }

    private HippyRootView loadNavPage(Navigator navigator, String str, HippyMap hippyMap) {
        HippyInstanceContext hippyInstanceContext = (HippyInstanceContext) navigator.getContext();
        HippyEngine.ModuleLoadParams moduleLoadParams = new HippyEngine.ModuleLoadParams(hippyInstanceContext.getModuleParams());
        moduleLoadParams.componentName = str;
        moduleLoadParams.jsParams = hippyMap;
        return hippyInstanceContext.getEngineManager().loadModule(moduleLoadParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void addView(ViewGroup viewGroup, View view, int i3) {
        Log.d(CLASS, "addView");
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new Navigator(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void deleteChild(ViewGroup viewGroup, View view) {
        destroyInstance(view);
        Log.d(CLASS, "deleteChild");
    }

    @HippyControllerProps(defaultType = "map", name = "initialRoute")
    public void initPage(Navigator navigator, HippyMap hippyMap) {
        navigator.init(loadNavPage(navigator, hippyMap.getString("routeName"), hippyMap.getMap("initProps")));
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(Navigator navigator, String str, HippyArray hippyArray) {
        String str2;
        HippyMap map;
        HippyMap map2;
        super.dispatchFunction((NavigatorController) navigator, str, hippyArray);
        str.hashCode();
        boolean z16 = false;
        if (str.equals(POP)) {
            if (hippyArray == null || (map = hippyArray.getMap(0)) == null) {
                str2 = null;
            } else {
                z16 = map.getBoolean("animated");
                str2 = map.getString("toDirection");
            }
            navigator.pop(z16, str2);
            return;
        }
        if (!str.equals("push") || hippyArray == null || (map2 = hippyArray.getMap(0)) == null) {
            return;
        }
        navigator.push(loadNavPage(navigator, map2.getString("routeName"), map2.getMap("initProps")), map2.getBoolean("animated"), map2.getString("fromDirection"));
    }
}
