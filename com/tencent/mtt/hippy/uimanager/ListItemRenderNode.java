package com.tencent.mtt.hippy.uimanager;

import android.view.View;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.views.list.IRecycleItemTypeChange;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ListItemRenderNode extends RenderNode {

    /* renamed from: a, reason: collision with root package name */
    private boolean f337646a;

    /* renamed from: b, reason: collision with root package name */
    private IRecycleItemTypeChange f337647b;

    public ListItemRenderNode(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, ControllerManager controllerManager, boolean z16) {
        super(i3, hippyMap, str, hippyRootView, controllerManager, z16);
        if (this.mProps.get("sticky") != null) {
            this.f337646a = this.mProps.getBoolean("sticky");
        }
    }

    public int a() {
        return a(this.mProps);
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        if (!this.mComponentManager.a(this.mId) || this.mComponentManager.b(this.mRootView, this.mId, this.mClassName, this.mProps).getParent() != null) {
            return false;
        }
        return true;
    }

    public View e() {
        return this.mComponentManager.findView(this.mId);
    }

    public boolean f() {
        return this.mComponentManager.a(this.mId);
    }

    public boolean g() {
        if (this.mRootView != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mtt.hippy.uimanager.RenderNode
    public int indexFromParent() {
        return super.indexFromParent();
    }

    public boolean shouldSticky() {
        return this.f337646a;
    }

    @Override // com.tencent.mtt.hippy.uimanager.RenderNode
    public void updateLayout(int i3, int i16, int i17, int i18) {
        int i19;
        ControllerManager controllerManager;
        HippyEngineContext hippyEngineContext;
        RenderManager renderManager;
        super.updateLayout(i3, i16, i17, i18);
        View a16 = this.mComponentManager.f337640b.a(this.mId);
        if (a16 != null) {
            i19 = a16.getTop();
        } else {
            i19 = 0;
        }
        this.mY = i19;
        if (getParent() != null && (controllerManager = this.mComponentManager) != null && (hippyEngineContext = controllerManager.f337639a) != null && (renderManager = hippyEngineContext.getRenderManager()) != null) {
            renderManager.addUpdateNodeIfNeeded(getParent());
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.RenderNode
    public void updateNode(HippyMap hippyMap) {
        int a16 = a(this.mProps);
        int a17 = a(hippyMap);
        IRecycleItemTypeChange iRecycleItemTypeChange = this.f337647b;
        if (iRecycleItemTypeChange != null && a16 != a17) {
            iRecycleItemTypeChange.onRecycleItemTypeChanged(a16, a17, this);
        }
        super.updateNode(hippyMap);
        if (this.mProps.get("sticky") != null) {
            this.f337646a = this.mProps.getBoolean("sticky");
        }
    }

    private int a(HippyMap hippyMap) {
        int i3 = hippyMap.getInt("type");
        if (i3 <= 0 && hippyMap.getString("type") != null) {
            try {
                i3 = Integer.parseInt(hippyMap.getString("type"));
            } catch (NumberFormatException unused) {
            }
        }
        return i3 <= 0 ? hippyMap.getInt("itemViewType") : i3;
    }

    public void a(IRecycleItemTypeChange iRecycleItemTypeChange) {
        this.f337647b = iRecycleItemTypeChange;
    }
}
