package com.tencent.mtt.hippy.modules.nativemodules.uimanager;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.b;
import com.tencent.mtt.hippy.dom.node.a;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.runtime.builtins.e;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.utils.LogUtils;

/* compiled from: P */
@HippyNativeModule(name = UIManagerModule.CLASS_NAME, thread = HippyNativeModule.Thread.DOM)
/* loaded from: classes20.dex */
public class UIManagerModule extends HippyNativeModuleBase {
    public static final String CLASS_NAME = "UIManagerModule";

    /* renamed from: a, reason: collision with root package name */
    final String f337549a;

    /* renamed from: b, reason: collision with root package name */
    final String f337550b;

    /* renamed from: c, reason: collision with root package name */
    final String f337551c;

    /* renamed from: d, reason: collision with root package name */
    final String f337552d;

    /* renamed from: e, reason: collision with root package name */
    final String f337553e;

    /* renamed from: f, reason: collision with root package name */
    final String f337554f;

    /* renamed from: g, reason: collision with root package name */
    final String f337555g;

    /* renamed from: h, reason: collision with root package name */
    final String f337556h;

    /* renamed from: i, reason: collision with root package name */
    final String f337557i;

    /* renamed from: j, reason: collision with root package name */
    final String f337558j;

    /* renamed from: k, reason: collision with root package name */
    final String f337559k;

    public UIManagerModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.f337549a = "optionType";
        this.f337550b = "createNode";
        this.f337551c = "updateNode";
        this.f337552d = "deleteNode";
        this.f337553e = "param";
        this.f337554f = "id";
        this.f337555g = "pId";
        this.f337556h = "index";
        this.f337557i = "name";
        this.f337558j = "props";
        this.f337559k = "tagName";
    }

    @HippyMethod(name = "callUIFunction")
    public void callUIFunction(HippyArray hippyArray, Promise promise) {
        if (this.mContext.getDomOperateInterceptor() != null) {
            this.mContext.getDomOperateInterceptor().callUIFunction(hippyArray, promise);
            return;
        }
        b domManager = this.mContext.getDomManager();
        if (hippyArray != null && hippyArray.size() > 0 && domManager != null) {
            domManager.a(hippyArray.getInt(0), hippyArray.getString(1), hippyArray.getArray(2), promise);
        }
    }

    @HippyMethod(name = "createNode")
    public void createNode(int i3, HippyArray hippyArray) {
        LogUtils.d(CLASS_NAME, "mContext.getDomOperateInterceptor() = " + this.mContext.getDomOperateInterceptor());
        if (this.mContext.getDomOperateInterceptor() != null) {
            this.mContext.getDomOperateInterceptor().createNode(i3, hippyArray);
            return;
        }
        HippyRootView hippyEngineContext = this.mContext.getInstance(i3);
        b domManager = this.mContext.getDomManager();
        if (hippyArray != null && hippyEngineContext != null && domManager != null) {
            int size = hippyArray.size();
            for (int i16 = 0; i16 < size; i16++) {
                HippyMap map = hippyArray.getMap(i16);
                int intValue = ((Number) map.get("id")).intValue();
                int intValue2 = ((Number) map.get("pId")).intValue();
                int intValue3 = ((Number) map.get("index")).intValue();
                if (intValue >= 0 && intValue2 >= 0 && intValue3 >= 0) {
                    domManager.a(hippyEngineContext, i3, intValue, intValue2, intValue3, (String) map.get("name"), (String) map.get("tagName"), (HippyMap) map.get("props"));
                } else {
                    throw new IllegalArgumentException("createNode invalid value: id=" + intValue + ", pId=" + intValue2 + ", index=" + intValue3);
                }
            }
        }
    }

    @HippyMethod(name = "deleteNode")
    public void deleteNode(int i3, HippyArray hippyArray) {
        if (this.mContext.getDomOperateInterceptor() != null) {
            this.mContext.getDomOperateInterceptor().deleteNode(i3, hippyArray);
            return;
        }
        b domManager = this.mContext.getDomManager();
        if (hippyArray != null && hippyArray.size() > 0 && domManager != null) {
            int size = hippyArray.size();
            for (int i16 = 0; i16 < size; i16++) {
                int intValue = ((Number) hippyArray.getMap(i16).get("id")).intValue();
                if (intValue >= 0) {
                    domManager.d(intValue);
                } else {
                    throw new IllegalArgumentException("deleteNode invalid value: id=" + intValue);
                }
            }
        }
    }

    @HippyMethod(name = "endBatch")
    public void endBatch() {
        if (this.mContext.getDomOperateInterceptor() != null) {
            this.mContext.getDomOperateInterceptor().endBatch();
            return;
        }
        b domManager = this.mContext.getDomManager();
        if (domManager != null) {
            domManager.d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0082 A[SYNTHETIC] */
    @HippyMethod(name = "flushBatch")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void flushBatch(int i3, HippyArray hippyArray) {
        if (this.mContext.getDomOperateInterceptor() != null) {
            this.mContext.getDomOperateInterceptor().flushBatch(i3, hippyArray);
            return;
        }
        if (hippyArray != null && hippyArray.size() > 0) {
            int size = hippyArray.size();
            for (int i16 = 0; i16 < size; i16++) {
                HippyMap map = hippyArray.getMap(i16);
                String str = (String) map.get("optionType");
                str.hashCode();
                char c16 = '\uffff';
                switch (str.hashCode()) {
                    case -296104341:
                        if (str.equals("updateNode")) {
                            c16 = 0;
                        }
                        switch (c16) {
                            case 0:
                                updateNode(i3, (HippyArray) map.get("param"));
                                break;
                            case 1:
                                createNode(i3, (HippyArray) map.get("param"));
                                break;
                            case 2:
                                deleteNode(i3, (HippyArray) map.get("param"));
                                break;
                        }
                        break;
                    case 1369040158:
                        if (str.equals("createNode")) {
                            c16 = 1;
                        }
                        switch (c16) {
                        }
                        break;
                    case 1764416077:
                        if (str.equals("deleteNode")) {
                            c16 = 2;
                        }
                        switch (c16) {
                        }
                        break;
                    default:
                        switch (c16) {
                        }
                        break;
                }
            }
        }
    }

    @HippyMethod(name = "getBoundingClientRect", useJSValueType = true)
    public void getBoundingClientRect(int i3, e eVar, Promise promise) {
        if (this.mContext.getDomOperateInterceptor() != null) {
            this.mContext.getDomOperateInterceptor().getBoundingClientRect(i3, eVar, promise);
            return;
        }
        b domManager = this.mContext.getDomManager();
        if (domManager == null) {
            e eVar2 = new e();
            eVar2.a("errMsg", "DomManager is null");
            promise.resolve(eVar2);
            return;
        }
        domManager.a(i3, eVar, promise);
        LogUtils.d(CLASS_NAME, "getBoundingClientRect" + i3 + " " + eVar + " " + promise);
    }

    @HippyMethod(name = "getNodeForLocation")
    public void getNodeForLocation(HippyMap hippyMap, Promise promise) {
        if (this.mContext.getDomOperateInterceptor() != null) {
            this.mContext.getDomOperateInterceptor().getNodeForLocation(hippyMap, promise);
            return;
        }
        RenderNode a16 = com.tencent.mtt.hippy.a.a.b.b.a(this.mContext, ((Number) hippyMap.get(HippyTKDListViewAdapter.X)).intValue(), ((Number) hippyMap.get("y")).intValue());
        b domManager = this.mContext.getDomManager();
        if (domManager != null && a16 != null) {
            com.tencent.mtt.hippy.dom.node.b c16 = domManager.c(a16.getId());
            if (c16 == null) {
                promise.resolve(null);
                return;
            } else {
                promise.resolve(com.tencent.mtt.hippy.a.a.b.b.a((a) c16.getDomNodeRecord(), 1).toString());
                return;
            }
        }
        promise.resolve(null);
    }

    @HippyMethod(name = "measureInWindow")
    public void measureInWindow(int i3, Promise promise) {
        if (this.mContext.getDomOperateInterceptor() != null) {
            this.mContext.getDomOperateInterceptor().measureInWindow(i3, promise);
            return;
        }
        b domManager = this.mContext.getDomManager();
        if (domManager != null) {
            e eVar = new e();
            eVar.a(RenderNode.KEY_COMPATIBLE, Boolean.TRUE);
            domManager.a(i3, eVar, promise);
        }
        LogUtils.d(CLASS_NAME, "measureInWindow" + i3 + " " + promise);
    }

    @HippyMethod(name = "startBatch")
    public void startBatch() {
        if (this.mContext.getDomOperateInterceptor() != null) {
            this.mContext.getDomOperateInterceptor().startBatch();
            return;
        }
        b domManager = this.mContext.getDomManager();
        if (domManager != null) {
            domManager.c();
        }
    }

    @HippyMethod(name = "updateNode")
    public void updateNode(int i3, HippyArray hippyArray) {
        if (this.mContext.getDomOperateInterceptor() != null) {
            this.mContext.getDomOperateInterceptor().updateNode(i3, hippyArray);
            return;
        }
        HippyRootView hippyEngineContext = this.mContext.getInstance(i3);
        b domManager = this.mContext.getDomManager();
        if (hippyArray != null && hippyArray.size() > 0 && hippyEngineContext != null && domManager != null) {
            int size = hippyArray.size();
            for (int i16 = 0; i16 < size; i16++) {
                HippyMap map = hippyArray.getMap(i16);
                int intValue = ((Number) map.get("id")).intValue();
                if (intValue >= 0) {
                    domManager.a(intValue, (HippyMap) map.get("props"), hippyEngineContext);
                } else {
                    throw new IllegalArgumentException("updateNode invalid value: id=" + intValue);
                }
            }
        }
    }
}
