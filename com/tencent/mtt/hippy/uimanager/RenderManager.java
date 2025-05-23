package com.tencent.mtt.hippy.uimanager;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RenderManager {

    /* renamed from: a, reason: collision with root package name */
    final SparseArray<RenderNode> f337652a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    final SparseArray<Boolean> f337653b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList<RenderNode> f337654c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    final ArrayList<RenderNode> f337655d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    final HippyEngineContext f337656e;

    /* renamed from: f, reason: collision with root package name */
    final ControllerManager f337657f;

    public RenderManager(HippyEngineContext hippyEngineContext, List<HippyAPIProvider> list) {
        this.f337656e = hippyEngineContext;
        this.f337657f = new ControllerManager(hippyEngineContext, list);
    }

    public com.tencent.mtt.hippy.dom.node.b a(String str, boolean z16, int i3, int i16) {
        StyleNode a16 = this.f337657f.a(str, z16, i16);
        a16.setViewClassName(str);
        a16.setId(i3);
        return a16;
    }

    public void addUpdateNodeIfNeeded(RenderNode renderNode) {
        if (!this.f337654c.contains(renderNode) && renderNode != null) {
            this.f337654c.add(renderNode);
        }
    }

    public void b() {
        LogUtils.d("RenderManager", "do batch size " + this.f337654c.size());
        for (int i3 = 0; i3 < this.f337654c.size(); i3++) {
            this.f337654c.get(i3).batchStart();
        }
        for (int i16 = 0; i16 < this.f337654c.size(); i16++) {
            this.f337654c.get(i16).createView();
        }
        for (int i17 = 0; i17 < this.f337654c.size(); i17++) {
            this.f337654c.get(i17).update();
        }
        for (int i18 = 0; i18 < this.f337654c.size(); i18++) {
            this.f337654c.get(i18).batchComplete();
        }
        this.f337654c.clear();
        for (int i19 = 0; i19 < this.f337655d.size(); i19++) {
            this.f337655d.get(i19).createView();
        }
        for (int i26 = 0; i26 < this.f337655d.size(); i26++) {
            this.f337655d.get(i26).update();
        }
        this.f337655d.clear();
    }

    public ControllerManager getControllerManager() {
        return this.f337657f;
    }

    public RenderNode getRenderNode(int i3) {
        try {
            return this.f337652a.get(i3);
        } catch (Exception unused) {
            return null;
        }
    }

    public void a() {
        getControllerManager().a();
    }

    public void b(int i3) {
        RenderNode renderNode = this.f337652a.get(i3);
        renderNode.setDelete(true);
        RenderNode renderNode2 = renderNode.mParent;
        if (renderNode2 != null) {
            renderNode2.addDeleteId(i3, renderNode);
            addUpdateNodeIfNeeded(renderNode.mParent);
        } else if (TextUtils.equals(NodeProps.ROOT_NODE, renderNode.getClassName())) {
            addUpdateNodeIfNeeded(renderNode);
        }
        b(renderNode);
    }

    public void a(int i3) {
        this.f337652a.put(i3, new RenderNode(i3, NodeProps.ROOT_NODE, this.f337657f));
    }

    public void b(HippyRootView hippyRootView, int i3, int i16, int i17, String str, HippyMap hippyMap) {
        boolean a16 = this.f337657f.a(str);
        RenderNode renderNode = this.f337652a.get(i16);
        boolean z16 = false;
        if (renderNode == null ? a16 || this.f337653b.get(i16).booleanValue() : a16 || renderNode.mIsLazyLoad) {
            z16 = true;
        }
        this.f337653b.put(i3, Boolean.valueOf(z16));
        if (z16) {
            return;
        }
        this.f337657f.a(hippyRootView, i3, str, hippyMap);
    }

    private void b(RenderNode renderNode) {
        if (renderNode == null) {
            return;
        }
        LogUtils.d("RenderManager", "delete RenderNode " + renderNode.mId + " class " + renderNode.mClassName);
        int childCount = renderNode.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            b(renderNode.getChildAt(0));
        }
        RenderNode renderNode2 = renderNode.mParent;
        if (renderNode2 != null) {
            renderNode2.removeChild(renderNode);
        }
        this.f337652a.remove(renderNode.mId);
    }

    public void a(int i3, int i16, int i17, int i18, int i19) {
        LogUtils.d("RenderManager", "updateLayout ID " + i3);
        RenderNode renderNode = this.f337652a.get(i3);
        renderNode.updateLayout(i16, i17, i18, i19);
        addUpdateNodeIfNeeded(renderNode);
    }

    public void a(int i3, HippyMap hippyMap) {
        LogUtils.d("RenderManager", "updateNode ID " + i3);
        RenderNode renderNode = this.f337652a.get(i3);
        renderNode.updateNode(hippyMap);
        addUpdateNodeIfNeeded(renderNode);
    }

    public void a(int i3, com.tencent.mtt.hippy.runtime.builtins.e eVar, Promise promise) {
        Object obj;
        RenderNode renderNode = this.f337652a.get(i3);
        if (renderNode != null) {
            renderNode.measureInWindow(eVar, promise);
            a(renderNode);
            return;
        }
        if (eVar.a(RenderNode.KEY_COMPATIBLE) == Boolean.TRUE) {
            obj = "this view is null";
        } else {
            com.tencent.mtt.hippy.runtime.builtins.e eVar2 = new com.tencent.mtt.hippy.runtime.builtins.e();
            eVar2.a("errMsg", "this node is null");
            obj = eVar2;
        }
        promise.resolve(obj);
    }

    public void a(int i3, Object obj) {
        LogUtils.d("RenderManager", "updateExtra ID " + i3);
        RenderNode renderNode = this.f337652a.get(i3);
        renderNode.updateExtra(obj);
        addUpdateNodeIfNeeded(renderNode);
    }

    public void a(int i3, String str, HippyArray hippyArray, Promise promise) {
        RenderNode renderNode = this.f337652a.get(i3);
        if (renderNode == null) {
            LogUtils.d("RenderManager", "dispatchUIFunction Node Null");
        } else {
            renderNode.dispatchUIFunction(str, hippyArray, promise);
            a(renderNode);
        }
    }

    public void a(HippyRootView hippyRootView, int i3, int i16, int i17, String str, HippyMap hippyMap) {
        LogUtils.d("RenderManager", "createNode ID " + i3 + " mParentId " + i16 + " index " + i17 + PushClientConstants.TAG_CLASS_NAME + str);
        RenderNode renderNode = this.f337652a.get(i16);
        RenderNode a16 = this.f337657f.a(i3, hippyMap, str, hippyRootView, this.f337657f.a(str) || renderNode.mIsLazyLoad);
        this.f337652a.put(i3, a16);
        this.f337653b.remove(i3);
        renderNode.addChild(a16, i17);
        addUpdateNodeIfNeeded(renderNode);
        addUpdateNodeIfNeeded(a16);
    }

    void a(RenderNode renderNode) {
        if (this.f337655d.contains(renderNode)) {
            return;
        }
        this.f337655d.add(renderNode);
    }

    public void a(ArrayList<Integer> arrayList, int i3, int i16) {
        RenderNode renderNode = this.f337652a.get(i3);
        RenderNode renderNode2 = this.f337652a.get(i16);
        ArrayList arrayList2 = new ArrayList();
        for (int i17 = 0; i17 < arrayList.size(); i17++) {
            RenderNode renderNode3 = this.f337652a.get(arrayList.get(i17).intValue());
            arrayList2.add(renderNode3);
            renderNode.removeChild(renderNode3);
            renderNode2.addChild(renderNode3, i17);
        }
        renderNode.move(arrayList2, i16);
        addUpdateNodeIfNeeded(renderNode);
        addUpdateNodeIfNeeded(renderNode2);
    }
}
