package com.tencent.mtt.hippy.uimanager;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RenderNode {
    public static final String KEY_COMPATIBLE = "compatible";
    public static final String KEY_ERR_MSG = "errMsg";
    public static final String KEY_REL_TO_CONTAINER = "relToContainer";
    final List<RenderNode> mChildPendingList;
    final List<RenderNode> mChildren;
    final String mClassName;
    final ControllerManager mComponentManager;
    SparseArray<Integer> mDeletedIdIndexMap;
    public boolean mHasSetDteblId;
    boolean mHasUpdateLayout;
    int mHeight;
    final int mId;
    boolean mIsDelete;
    boolean mIsLazyLoad;
    boolean mIsRootHasDelete;
    List<Pair<com.tencent.mtt.hippy.runtime.builtins.e, Promise>> mMeasureInWindows;
    List<a> mMoveHolders;
    boolean mNotifyManageChildren;
    RenderNode mParent;
    HippyMap mProps;
    HippyMap mPropsToUpdate;
    HippyRootView mRootView;
    Object mTextExtra;
    Object mTextExtraUpdate;
    List<b> mUIFunction;
    int mWidth;
    int mX;
    int mY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final List<RenderNode> f337660a;

        /* renamed from: b, reason: collision with root package name */
        final int f337661b;

        public a(List<RenderNode> list, int i3) {
            this.f337660a = list;
            this.f337661b = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final String f337662a;

        /* renamed from: b, reason: collision with root package name */
        final HippyArray f337663b;

        /* renamed from: c, reason: collision with root package name */
        final Promise f337664c;

        public b(String str, HippyArray hippyArray, Promise promise) {
            this.f337662a = str;
            this.f337663b = hippyArray;
            this.f337664c = promise;
        }
    }

    public RenderNode(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, ControllerManager controllerManager, boolean z16) {
        this.mHasUpdateLayout = false;
        this.mProps = null;
        this.mChildren = new ArrayList();
        this.mMoveHolders = null;
        this.mMeasureInWindows = null;
        this.mParent = null;
        this.mIsDelete = false;
        this.mIsRootHasDelete = false;
        this.mIsLazyLoad = false;
        this.mNotifyManageChildren = false;
        this.mHasSetDteblId = false;
        this.mUIFunction = null;
        this.mChildPendingList = new ArrayList();
        this.mId = i3;
        this.mPropsToUpdate = hippyMap;
        this.mClassName = str;
        this.mRootView = hippyRootView;
        this.mComponentManager = controllerManager;
        this.mIsLazyLoad = z16;
        this.mProps = hippyMap;
    }

    private boolean shouldCreateView() {
        if (!this.mIsLazyLoad && !this.mComponentManager.a(this.mId)) {
            return true;
        }
        return false;
    }

    private boolean shouldUpdateView() {
        return this.mComponentManager.a(this.mId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addChild(RenderNode renderNode, int i3) {
        this.mChildren.add(i3, renderNode);
        renderNode.mParent = this;
    }

    protected void addChildToPendingList(RenderNode renderNode) {
        this.mChildPendingList.add(renderNode);
    }

    public void addDeleteId(int i3, RenderNode renderNode) {
        if (shouldUpdateView()) {
            if (this.mDeletedIdIndexMap == null) {
                this.mDeletedIdIndexMap = new SparseArray<>();
            }
            this.mDeletedIdIndexMap.put(i3, Integer.valueOf(this.mChildren.indexOf(renderNode)));
        }
    }

    public void batchComplete() {
        if (!this.mIsLazyLoad && !this.mIsDelete) {
            this.mComponentManager.a(this.mClassName, this.mId);
        }
    }

    public void batchStart() {
        if (!this.mIsLazyLoad && !this.mIsDelete) {
            this.mComponentManager.b(this.mClassName, this.mId);
        }
    }

    public View createView() {
        RenderNode renderNode;
        SparseArray<Integer> sparseArray = this.mDeletedIdIndexMap;
        if (sparseArray != null && sparseArray.size() > 0) {
            for (int i3 = 0; i3 < this.mDeletedIdIndexMap.size(); i3++) {
                this.mComponentManager.b(this.mId, this.mDeletedIdIndexMap.keyAt(i3), this.mDeletedIdIndexMap.get(this.mDeletedIdIndexMap.keyAt(i3)).intValue());
            }
            this.mDeletedIdIndexMap.clear();
            this.mNotifyManageChildren = true;
        }
        if (this.mIsDelete && TextUtils.equals(NodeProps.ROOT_NODE, this.mClassName) && !this.mIsRootHasDelete) {
            this.mIsRootHasDelete = true;
            this.mComponentManager.c(this.mId);
        }
        if (!shouldCreateView() || TextUtils.equals(NodeProps.ROOT_NODE, this.mClassName) || (renderNode = this.mParent) == null) {
            return null;
        }
        this.mPropsToUpdate = null;
        renderNode.addChildToPendingList(this);
        return this.mComponentManager.b(this.mRootView, this.mId, this.mClassName, this.mProps);
    }

    public View createViewRecursive() {
        View createView = createView();
        this.mHasUpdateLayout = true;
        this.mTextExtraUpdate = this.mTextExtra;
        Iterator<RenderNode> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().createViewRecursive();
        }
        return createView;
    }

    public void dispatchUIFunction(String str, HippyArray hippyArray, Promise promise) {
        if (this.mUIFunction == null) {
            this.mUIFunction = new ArrayList();
        }
        this.mUIFunction.add(new b(str, hippyArray, promise));
    }

    public RenderNode getChildAt(int i3) {
        if (i3 >= 0 && i3 < getChildCount()) {
            return this.mChildren.get(i3);
        }
        return null;
    }

    public int getChildCount() {
        return this.mChildren.size();
    }

    public String getClassName() {
        return this.mClassName;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getId() {
        return this.mId;
    }

    public RenderNode getParent() {
        return this.mParent;
    }

    public HippyMap getProps() {
        return this.mProps;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getX() {
        return this.mX;
    }

    public int getY() {
        return this.mY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int indexFromParent() {
        RenderNode renderNode = this.mParent;
        if (renderNode != null) {
            return renderNode.mChildren.indexOf(this);
        }
        return 0;
    }

    public boolean isDelete() {
        return this.mIsDelete;
    }

    public boolean isIsLazyLoad() {
        return this.mIsLazyLoad;
    }

    public void manageChildrenComplete() {
        if (!this.mIsLazyLoad && !this.mIsDelete) {
            this.mComponentManager.c(this.mClassName, this.mId);
        }
    }

    public void measureInWindow(com.tencent.mtt.hippy.runtime.builtins.e eVar, Promise promise) {
        if (this.mMeasureInWindows == null) {
            this.mMeasureInWindows = new ArrayList();
        }
        this.mMeasureInWindows.add(new Pair<>(eVar, promise));
    }

    public void move(List<RenderNode> list, int i3) {
        if (shouldUpdateView()) {
            if (this.mMoveHolders == null) {
                this.mMoveHolders = new ArrayList();
            }
            this.mMoveHolders.add(new a(list, i3));
        }
    }

    void printChild(RenderNode renderNode, StringBuilder sb5) {
        sb5.append(" [Id:");
        sb5.append(renderNode.getId());
        sb5.append(renderNode.mClassName);
        Iterator<RenderNode> it = renderNode.mChildren.iterator();
        while (it.hasNext()) {
            printChild(it.next(), sb5);
        }
        sb5.append("]");
    }

    public void remove(int i3) {
        this.mChildren.remove(i3).mParent = null;
    }

    public boolean removeChild(RenderNode renderNode) {
        renderNode.mParent = null;
        return this.mChildren.remove(renderNode);
    }

    public void setDelete(boolean z16) {
        this.mIsDelete = z16;
    }

    void setLazy(RenderNode renderNode, boolean z16) {
        renderNode.mIsLazyLoad = z16;
        for (int i3 = 0; i3 < renderNode.getChildCount(); i3++) {
            setLazy(renderNode.getChildAt(i3), z16);
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        printChild(this, sb5);
        return sb5.toString();
    }

    public void update() {
        boolean z16;
        LogUtils.d("UINode", "mId" + this.mId + " updateStyle");
        if (shouldUpdateView()) {
            if (this.mChildPendingList.size() > 0) {
                Collections.sort(this.mChildPendingList, new Comparator<RenderNode>() { // from class: com.tencent.mtt.hippy.uimanager.RenderNode.1
                    @Override // java.util.Comparator
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(RenderNode renderNode, RenderNode renderNode2) {
                        if (renderNode.indexFromParent() < renderNode2.indexFromParent()) {
                            return -1;
                        }
                        return 0;
                    }
                });
                for (int i3 = 0; i3 < this.mChildPendingList.size(); i3++) {
                    RenderNode renderNode = this.mChildPendingList.get(i3);
                    this.mComponentManager.c(this.mId, renderNode.getId(), renderNode.indexFromParent());
                }
                this.mChildPendingList.clear();
                this.mNotifyManageChildren = true;
            }
            HippyMap hippyMap = this.mPropsToUpdate;
            if (hippyMap != null) {
                this.mComponentManager.a(this.mId, this.mClassName, hippyMap);
                this.mPropsToUpdate = null;
            }
            List<a> list = this.mMoveHolders;
            if (list != null) {
                for (a aVar : list) {
                    Collections.sort(aVar.f337660a, new Comparator<RenderNode>() { // from class: com.tencent.mtt.hippy.uimanager.RenderNode.2
                        @Override // java.util.Comparator
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public int compare(RenderNode renderNode2, RenderNode renderNode3) {
                            if (renderNode2.indexFromParent() < renderNode3.indexFromParent()) {
                                return -1;
                            }
                            return 0;
                        }
                    });
                    for (int i16 = 0; i16 < aVar.f337660a.size(); i16++) {
                        RenderNode renderNode2 = aVar.f337660a.get(i16);
                        this.mComponentManager.a(renderNode2.getId(), aVar.f337661b, renderNode2.indexFromParent());
                    }
                }
                this.mMoveHolders = null;
            }
            if (this.mHasUpdateLayout && !TextUtils.equals(NodeProps.ROOT_NODE, this.mClassName)) {
                this.mComponentManager.a(this.mClassName, this.mId, this.mX, this.mY, this.mWidth, this.mHeight);
                LogUtils.d("UINode", "mId" + this.mId + " updateLayout");
                this.mHasUpdateLayout = false;
            }
            Object obj = this.mTextExtraUpdate;
            if (obj != null) {
                this.mComponentManager.a(this.mId, this.mClassName, obj);
                this.mTextExtraUpdate = null;
            }
            List<b> list2 = this.mUIFunction;
            if (list2 != null && list2.size() > 0) {
                for (int i17 = 0; i17 < this.mUIFunction.size(); i17++) {
                    b bVar = this.mUIFunction.get(i17);
                    this.mComponentManager.a(this.mId, this.mClassName, bVar.f337662a, bVar.f337663b, bVar.f337664c);
                }
                this.mUIFunction.clear();
                this.mUIFunction = null;
            }
            List<Pair<com.tencent.mtt.hippy.runtime.builtins.e, Promise>> list3 = this.mMeasureInWindows;
            if (list3 != null && list3.size() > 0) {
                for (int i18 = 0; i18 < this.mMeasureInWindows.size(); i18++) {
                    Pair<com.tencent.mtt.hippy.runtime.builtins.e, Promise> pair = this.mMeasureInWindows.get(i18);
                    Object a16 = ((com.tencent.mtt.hippy.runtime.builtins.e) pair.first).a(KEY_COMPATIBLE);
                    Boolean bool = Boolean.TRUE;
                    if (a16 == bool) {
                        this.mComponentManager.a(this.mId, (Promise) pair.second);
                    } else {
                        if (((com.tencent.mtt.hippy.runtime.builtins.e) pair.first).a(KEY_REL_TO_CONTAINER) == bool) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        this.mComponentManager.a(this.mId, this.mRootView, z16, (Promise) pair.second);
                    }
                }
                this.mMeasureInWindows.clear();
                this.mMeasureInWindows = null;
            }
            if (this.mNotifyManageChildren) {
                manageChildrenComplete();
                this.mNotifyManageChildren = false;
            }
        }
        LogUtils.d("UINode", "mId" + this.mId + " end updateStyle");
    }

    public void updateExtra(Object obj) {
        this.mTextExtra = obj;
        this.mTextExtraUpdate = obj;
    }

    public void updateLayout(int i3, int i16, int i17, int i18) {
        this.mX = i3;
        this.mY = i16;
        this.mWidth = i17;
        this.mHeight = i18;
        this.mHasUpdateLayout = true;
    }

    public void updateNode(HippyMap hippyMap) {
        Object obj;
        HippyMap hippyMap2;
        HippyMap hippyMap3 = this.mPropsToUpdate;
        if (hippyMap3 != null) {
            HippyMap diffProps = DiffUtils.diffProps(hippyMap3, hippyMap, 0);
            if (diffProps != null && diffProps.size() > 0) {
                for (String str : diffProps.keySet()) {
                    if (TextUtils.equals("style", str)) {
                        HippyMap map = diffProps.getMap(str);
                        if (map != null) {
                            HippyMap map2 = this.mPropsToUpdate.getMap(str);
                            HippyMap hippyMap4 = map2;
                            if (map2 == null) {
                                hippyMap4 = new HippyMap();
                            }
                            for (String str2 : map.keySet()) {
                                hippyMap4.pushObject(str2, map.get(str2));
                            }
                            hippyMap2 = this.mPropsToUpdate;
                            obj = hippyMap4;
                        }
                    } else {
                        hippyMap2 = this.mPropsToUpdate;
                        obj = diffProps.get(str);
                    }
                    hippyMap2.pushObject(str, obj);
                }
            }
        } else {
            this.mPropsToUpdate = DiffUtils.diffProps(this.mProps, hippyMap, 0);
        }
        this.mProps = hippyMap;
    }

    public void updateViewRecursive() {
        update();
        Iterator<RenderNode> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().updateViewRecursive();
        }
    }

    public RenderNode(int i3, String str, ControllerManager controllerManager) {
        this.mHasUpdateLayout = false;
        this.mProps = null;
        this.mChildren = new ArrayList();
        this.mMoveHolders = null;
        this.mMeasureInWindows = null;
        this.mParent = null;
        this.mIsDelete = false;
        this.mIsRootHasDelete = false;
        this.mIsLazyLoad = false;
        this.mNotifyManageChildren = false;
        this.mHasSetDteblId = false;
        this.mUIFunction = null;
        this.mChildPendingList = new ArrayList();
        this.mId = i3;
        this.mClassName = str;
        this.mComponentManager = controllerManager;
    }

    public void setLazy(boolean z16) {
        setLazy(this, z16);
    }
}
