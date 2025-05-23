package com.tencent.mtt.hippy.uimanager;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.common.HippyTag;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.DimensionsUtil;
import com.tencent.mtt.hippy.utils.ExceptionUtil;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.mtt.hippy.views.custom.HippyCustomPropsController;
import com.tencent.mtt.hippy.views.list.HippyRecycler;
import com.tencent.mtt.hippy.views.scroll.HippyHorizontalScrollView;
import com.tencent.mtt.hippy.views.text.HippyTextView;
import com.tencent.mtt.hippy.views.view.HippyViewGroupController;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ControllerManager implements HippyInstanceLifecycleEventListener {

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ boolean f337638e = true;

    /* renamed from: a, reason: collision with root package name */
    final HippyEngineContext f337639a;

    /* renamed from: b, reason: collision with root package name */
    final b f337640b;

    /* renamed from: c, reason: collision with root package name */
    final c<HippyViewController, View> f337641c;

    /* renamed from: d, reason: collision with root package name */
    final SparseArray<View> f337642d = new SparseArray<>();

    public ControllerManager(HippyEngineContext hippyEngineContext, List<HippyAPIProvider> list) {
        this.f337639a = hippyEngineContext;
        b bVar = new b(hippyEngineContext);
        this.f337640b = bVar;
        c<HippyViewController, View> cVar = new c<>();
        this.f337641c = cVar;
        hippyEngineContext.addInstanceLifecycleEventListener(this);
        b(list);
        cVar.a((c<HippyViewController, View>) bVar.b(HippyCustomPropsController.CLASS_NAME));
    }

    public StyleNode a(String str, boolean z16, int i3) {
        StyleNode createNode = this.f337640b.b(str).createNode(z16, i3);
        return createNode != null ? createNode : this.f337640b.b(str).createNode(z16);
    }

    public View b(HippyRootView hippyRootView, int i3, String str, HippyMap hippyMap) {
        View a16 = this.f337640b.a(i3);
        if (a16 == null) {
            a16 = this.f337642d.get(i3);
            this.f337642d.remove(i3);
            HippyViewController b16 = this.f337640b.b(str);
            if (a16 != null && !b16.canControlView(a16, "onAfterUpdateProps")) {
                ExceptionUtil.handleNativeException(this.f337639a, new Exception(("ControllerManager.createView can't control, id:" + i3) + " class:" + a16.getClass().getName()), "");
                a16 = null;
            }
            if (a16 == null) {
                a16 = b16.createView(hippyRootView, i3, this.f337639a, str, hippyMap);
            }
            if (a16 != null) {
                this.f337640b.a(a16);
                this.f337641c.a(b16, a16, hippyMap);
                b16.onAfterUpdateProps(a16);
            }
        }
        return a16;
    }

    public void c(int i3) {
        View c16 = this.f337640b.c(i3);
        if (c16 != null) {
            HippyRootView hippyRootView = (HippyRootView) c16;
            for (int childCount = hippyRootView.getChildCount() - 1; childCount >= 0; childCount--) {
                deleteChild(i3, hippyRootView.getChildAt(childCount).getId());
            }
        }
        this.f337640b.e(i3);
    }

    public void deleteChild(int i3, int i16) {
        b(i3, i16, -1);
    }

    public View findView(int i3) {
        return this.f337640b.a(i3);
    }

    @Override // com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener
    public void onInstanceLoad(int i3) {
        HippyEngineContext hippyEngineContext = this.f337639a;
        if (hippyEngineContext != null && hippyEngineContext.getInstance(i3) != null) {
            this.f337640b.a(this.f337639a.getInstance(i3));
        }
    }

    public RenderNode a(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, boolean z16) {
        return this.f337640b.b(str).createRenderNode(i3, hippyMap, str, hippyRootView, this, z16);
    }

    public void b(int i3) {
        View a16 = this.f337640b.a(i3);
        if (a16 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) a16;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt != null) {
                    b(childAt.getId());
                }
            }
        }
        if (a16 != null) {
            this.f337640b.d(a16.getId());
        }
    }

    public void c(int i3, int i16, int i17) {
        String str;
        String str2;
        String str3;
        View a16 = this.f337640b.a(i16);
        View a17 = this.f337640b.a(i3);
        if (a16 != null && (a17 instanceof ViewGroup)) {
            if (a16.getParent() == null) {
                LogUtils.d("ControllerManager", "addChild id: " + i16 + " pid: " + i3);
                this.f337640b.b(HippyTag.getClassName(a17)).addView((ViewGroup) a17, a16, i17);
                return;
            }
            return;
        }
        RenderNode renderNode = this.f337639a.getRenderManager().getRenderNode(i3);
        String className = renderNode != null ? renderNode.getClassName() : "null";
        if (a17 != null) {
            String className2 = HippyTag.getClassName(a17);
            str2 = className2 != null ? className2.toString() : null;
            str = a17.getClass().getName();
        } else {
            str = null;
            str2 = null;
        }
        if (a16 != null) {
            String className3 = HippyTag.getClassName(a16);
            r2 = className3 != null ? className3.toString() : null;
            str3 = a16.getClass().getName();
        } else {
            str3 = null;
        }
        this.f337639a.getGlobalConfigs().getExceptionHandler().handleNativeException(new RuntimeException("child null or parent not ViewGroup pid " + i3 + " parentTag " + str2 + " parentClass " + str + " renderNodeClass " + className + " id " + i16 + " childTag " + r2 + " childClass " + str3), true);
    }

    public void a() {
        this.f337639a.removeInstanceLifecycleEventListener(this);
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mtt.hippy.uimanager.ControllerManager.1
            @Override // java.lang.Runnable
            public void run() {
                int a16 = ControllerManager.this.f337640b.a();
                if (a16 > 0) {
                    for (int i3 = a16 - 1; i3 >= 0; i3--) {
                        ControllerManager controllerManager = ControllerManager.this;
                        controllerManager.c(controllerManager.f337640b.b(i3));
                    }
                }
            }
        });
    }

    public void b(int i3, int i16, int i17) {
        View a16 = this.f337640b.a(i3);
        View a17 = this.f337640b.a(i16);
        if (!(a16 instanceof ViewGroup) || a17 == null) {
            return;
        }
        a((ViewGroup) a16, a17, i17);
    }

    public void c(String str, int i3) {
        HippyViewController b16 = this.f337640b.b(str);
        View a16 = this.f337640b.a(i3);
        if (a16 != null) {
            b16.onManageChildComplete(a16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(int i3, int i16) {
        View a16 = this.f337640b.a(i3);
        this.f337640b.d(i3);
        if (a16 == 0) {
            LogUtils.d("HippyListView", "error replaceID null oldId " + i3);
            return;
        }
        if (a16 instanceof HippyRecycler) {
            ((HippyRecycler) a16).clear();
        }
        a16.setId(i16);
        if (a16 instanceof HippyHorizontalScrollView) {
            ((HippyHorizontalScrollView) a16).setContentOffset4Reuse();
        }
        this.f337640b.a(a16);
    }

    public void b(String str, int i3) {
        HippyViewController b16 = this.f337640b.b(str);
        View a16 = this.f337640b.a(i3);
        if (a16 != null) {
            if (b16.canControlView(a16, "onBatchStart")) {
                b16.onBatchStart(a16);
                return;
            }
            ExceptionUtil.handleNativeException(this.f337639a, new Exception(("ControllerManager.onBatchStart can't control, id:" + i3) + " class:" + a16.getClass().getName()), "");
        }
    }

    private void b(List<HippyAPIProvider> list) {
        a(list);
        this.f337640b.a(NodeProps.ROOT_NODE, new a(new HippyViewGroupController(), false));
    }

    public void a(int i3, int i16, int i17) {
        View a16 = this.f337640b.a(i3);
        if (a16 != null) {
            if (a16.getParent() != null) {
                ((ViewGroup) a16.getParent()).removeView(a16);
            }
            View a17 = this.f337640b.a(i16);
            if (a17 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) this.f337640b.a(i16);
                if (viewGroup != null) {
                    this.f337640b.b(HippyTag.getClassName(viewGroup)).addView(viewGroup, a16, i17);
                }
                LogUtils.d("ControllerManager", "move id: " + i3 + " toid: " + i16);
                return;
            }
            String str = "ControllerManager.move crash, toId:" + i16;
            if (a17 instanceof HippyTextView) {
                str = str + " text:" + ((HippyTextView) a17).getText();
            }
            ExceptionUtil.handleNativeException(this.f337639a, new Exception(str), "");
        }
    }

    public void a(int i3, HippyRootView hippyRootView, boolean z16, Promise promise) {
        int i16;
        int i17;
        View a16 = this.f337640b.a(i3);
        if (a16 == null) {
            com.tencent.mtt.hippy.runtime.builtins.e eVar = new com.tencent.mtt.hippy.runtime.builtins.e();
            eVar.a("errMsg", "this view is null");
            promise.resolve(eVar);
            return;
        }
        int width = a16.getWidth();
        int height = a16.getHeight();
        int[] iArr = new int[2];
        if (!z16) {
            a16.getLocationOnScreen(iArr);
            i16 = iArr[0];
            i17 = iArr[1];
        } else if (hippyRootView == null) {
            com.tencent.mtt.hippy.runtime.builtins.e eVar2 = new com.tencent.mtt.hippy.runtime.builtins.e();
            eVar2.a("errMsg", "container is null");
            promise.resolve(eVar2);
            return;
        } else {
            a16.getLocationInWindow(iArr);
            int i18 = iArr[0];
            int i19 = iArr[1];
            hippyRootView.getLocationInWindow(iArr);
            i16 = i18 - iArr[0];
            i17 = i19 - iArr[1];
        }
        com.tencent.mtt.hippy.runtime.builtins.e eVar3 = new com.tencent.mtt.hippy.runtime.builtins.e();
        eVar3.a(HippyTKDListViewAdapter.X, Float.valueOf(PixelUtil.px2dp(i16)));
        eVar3.a("y", Float.valueOf(PixelUtil.px2dp(i17)));
        eVar3.a("width", Float.valueOf(PixelUtil.px2dp(width)));
        eVar3.a("height", Float.valueOf(PixelUtil.px2dp(height)));
        promise.resolve(eVar3);
    }

    @SuppressLint({"Range"})
    public void a(int i3, Promise promise) {
        View a16 = this.f337640b.a(i3);
        if (a16 == null) {
            promise.resolve("this view is null");
            return;
        }
        int[] iArr = new int[4];
        try {
            a16.getLocationOnScreen(iArr);
            int statusBarHeight = DimensionsUtil.getStatusBarHeight();
            if (statusBarHeight > 0) {
                iArr[1] = iArr[1] - statusBarHeight;
            }
            iArr[2] = a16.getWidth();
            iArr[3] = a16.getHeight();
            float px2dp = PixelUtil.px2dp(iArr[0]);
            float px2dp2 = PixelUtil.px2dp(iArr[1]);
            float px2dp3 = PixelUtil.px2dp(iArr[2]);
            float px2dp4 = PixelUtil.px2dp(iArr[3]);
            float px2dp5 = PixelUtil.px2dp(statusBarHeight);
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushDouble(HippyTKDListViewAdapter.X, px2dp);
            hippyMap.pushDouble("y", px2dp2);
            hippyMap.pushDouble("width", px2dp3);
            hippyMap.pushDouble("height", px2dp4);
            hippyMap.pushDouble("statusBarHeight", px2dp5);
            promise.resolve(hippyMap);
        } catch (Throwable th5) {
            promise.resolve("exception" + th5.getMessage());
            th5.printStackTrace();
        }
    }

    public void a(int i3, String str, HippyMap hippyMap) {
        View a16 = this.f337640b.a(i3);
        HippyViewController b16 = this.f337640b.b(str);
        if (a16 == null || b16 == null || hippyMap == null) {
            return;
        }
        this.f337641c.a(b16, a16, hippyMap);
        b16.onAfterUpdateProps(a16);
    }

    public void a(int i3, String str, Object obj) {
        this.f337640b.b(str).updateExtra(this.f337640b.a(i3), obj);
    }

    public void a(int i3, String str, String str2, HippyArray hippyArray, Promise promise) {
        HippyViewController b16 = this.f337640b.b(str);
        View a16 = this.f337640b.a(i3);
        if (promise.isCallback()) {
            b16.dispatchFunction(a16, str2, hippyArray, promise);
        } else {
            b16.dispatchFunction(a16, str2, hippyArray);
        }
    }

    public void a(ViewGroup viewGroup, View view, int i3) {
        HippyViewController hippyViewController;
        if (viewGroup == null || view == null) {
            return;
        }
        String className = HippyTag.getClassName(view);
        if (TextUtils.isEmpty(className)) {
            hippyViewController = null;
        } else {
            hippyViewController = this.f337640b.b(className);
            if (hippyViewController != null) {
                hippyViewController.onViewDestroy(view);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            if (hippyViewController != null) {
                for (int childCount = hippyViewController.getChildCount(viewGroup2) - 1; childCount >= 0; childCount--) {
                    a(viewGroup2, hippyViewController.getChildAt(viewGroup2, childCount), -1);
                }
            } else {
                for (int childCount2 = viewGroup2.getChildCount() - 1; childCount2 >= 0; childCount2--) {
                    a(viewGroup2, viewGroup2.getChildAt(childCount2), -1);
                }
            }
        }
        if (this.f337640b.a(view.getId()) == view || this.f337640b.a(viewGroup.getId()) == viewGroup) {
            String className2 = HippyTag.getClassName(viewGroup);
            if (className2 == null) {
                viewGroup.removeView(view);
            } else if (this.f337640b.a(className2) != null) {
                this.f337640b.b(className2).deleteChild(viewGroup, view, i3);
            }
            this.f337640b.d(view.getId());
        }
    }

    public void a(@NonNull HippyRootView hippyRootView) {
        this.f337640b.a(hippyRootView);
    }

    public void a(HippyRootView hippyRootView, int i3, String str, HippyMap hippyMap) {
        if (this.f337640b.a(i3) == null) {
            this.f337642d.put(i3, this.f337640b.b(str).createView(hippyRootView, i3, this.f337639a, str, hippyMap));
        }
    }

    public void a(String str, int i3) {
        HippyViewController b16 = this.f337640b.b(str);
        View a16 = this.f337640b.a(i3);
        if (a16 == null || !b16.canControlView(a16, "onBatchComplete")) {
            return;
        }
        b16.onBatchComplete(a16);
    }

    public void a(String str, int i3, int i16, int i17, int i18, int i19) {
        this.f337640b.b(str).updateLayout(i3, i16, i17, i18, i19, this.f337640b);
    }

    public void a(List<HippyAPIProvider> list) {
        if (list == null) {
            return;
        }
        Iterator<HippyAPIProvider> it = list.iterator();
        while (it.hasNext()) {
            List<Class<? extends HippyViewController>> controllers = it.next().getControllers();
            if (controllers != null) {
                for (Class<? extends HippyViewController> cls : controllers) {
                    HippyController hippyController = (HippyController) cls.getAnnotation(HippyController.class);
                    if (!f337638e && hippyController == null) {
                        throw new AssertionError();
                    }
                    String name = hippyController.name();
                    String[] names = hippyController.names();
                    try {
                        a aVar = new a(cls.newInstance(), hippyController.isLazyLoad());
                        this.f337640b.a(name, aVar);
                        if (names.length > 0) {
                            for (String str : names) {
                                this.f337640b.a(str, aVar);
                            }
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean a(int i3) {
        return this.f337640b.a(i3) != null;
    }

    public boolean a(String str) {
        return this.f337640b.a(str).f337666b;
    }

    @Override // com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener
    public void onInstanceDestroy(int i3) {
    }

    @Override // com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener
    public void onInstancePause(int i3) {
    }

    @Override // com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener
    public void onInstanceResume(int i3) {
    }
}
