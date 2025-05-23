package org.jbox2d.collision.broadphase;

import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.callbacks.TreeCallback;
import org.jbox2d.callbacks.TreeRayCastCallback;
import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.common.Color3f;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DynamicTree implements BroadPhaseStrategy {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MAX_STACK_SIZE = 64;
    public static final int NULL_NODE = -1;
    private int m_freeList;
    private int m_insertionCount;
    private final Vec2[] drawVecs = new Vec2[4];
    private final TreeNodeStack nodeStack = new TreeNodeStack(10);

    /* renamed from: r, reason: collision with root package name */
    private final Vec2 f423631r = new Vec2();
    private final AABB aabb = new AABB();
    private final RayCastInput subInput = new RayCastInput();
    private final AABB combinedAABB = new AABB();
    private final Color3f color = new Color3f();
    private final Vec2 textVec = new Vec2();
    private DynamicTreeNode m_root = null;
    private int m_nodeCount = 0;
    private int m_nodeCapacity = 16;
    private DynamicTreeNode[] m_nodes = new DynamicTreeNode[16];

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class TreeNodeStack {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int position = 0;
        private int size;
        private DynamicTreeNode[] stack;

        public TreeNodeStack(int i3) {
            this.stack = new DynamicTreeNode[i3];
            this.size = i3;
        }

        public int getCount() {
            return this.position;
        }

        public DynamicTreeNode pop() {
            DynamicTreeNode[] dynamicTreeNodeArr = this.stack;
            int i3 = this.position - 1;
            this.position = i3;
            return dynamicTreeNodeArr[i3];
        }

        public void push(DynamicTreeNode dynamicTreeNode) {
            int i3 = this.position;
            int i16 = this.size;
            if (i3 == i16) {
                DynamicTreeNode[] dynamicTreeNodeArr = this.stack;
                DynamicTreeNode[] dynamicTreeNodeArr2 = new DynamicTreeNode[i16 * 2];
                this.stack = dynamicTreeNodeArr2;
                this.size = dynamicTreeNodeArr2.length;
                System.arraycopy(dynamicTreeNodeArr, 0, dynamicTreeNodeArr2, 0, dynamicTreeNodeArr.length);
            }
            DynamicTreeNode[] dynamicTreeNodeArr3 = this.stack;
            int i17 = this.position;
            this.position = i17 + 1;
            dynamicTreeNodeArr3[i17] = dynamicTreeNode;
        }

        public void reset() {
            this.position = 0;
        }
    }

    public DynamicTree() {
        DynamicTreeNode dynamicTreeNode;
        int i3 = 0;
        for (int i16 = 16 - 1; i16 >= 0; i16--) {
            this.m_nodes[i16] = new DynamicTreeNode(i16);
            DynamicTreeNode[] dynamicTreeNodeArr = this.m_nodes;
            DynamicTreeNode dynamicTreeNode2 = dynamicTreeNodeArr[i16];
            if (i16 == this.m_nodeCapacity - 1) {
                dynamicTreeNode = null;
            } else {
                dynamicTreeNode = dynamicTreeNodeArr[i16 + 1];
            }
            dynamicTreeNode2.parent = dynamicTreeNode;
            dynamicTreeNode2.height = -1;
        }
        this.m_freeList = 0;
        this.m_insertionCount = 0;
        while (true) {
            Vec2[] vec2Arr = this.drawVecs;
            if (i3 < vec2Arr.length) {
                vec2Arr[i3] = new Vec2();
                i3++;
            } else {
                return;
            }
        }
    }

    private final DynamicTreeNode allocateNode() {
        int i3;
        DynamicTreeNode dynamicTreeNode;
        int i16 = -1;
        if (this.m_freeList == -1) {
            DynamicTreeNode[] dynamicTreeNodeArr = this.m_nodes;
            int i17 = this.m_nodeCapacity * 2;
            this.m_nodeCapacity = i17;
            DynamicTreeNode[] dynamicTreeNodeArr2 = new DynamicTreeNode[i17];
            this.m_nodes = dynamicTreeNodeArr2;
            System.arraycopy(dynamicTreeNodeArr, 0, dynamicTreeNodeArr2, 0, dynamicTreeNodeArr.length);
            int i18 = this.m_nodeCapacity;
            while (true) {
                i18--;
                i3 = this.m_nodeCount;
                if (i18 < i3) {
                    break;
                }
                this.m_nodes[i18] = new DynamicTreeNode(i18);
                DynamicTreeNode[] dynamicTreeNodeArr3 = this.m_nodes;
                DynamicTreeNode dynamicTreeNode2 = dynamicTreeNodeArr3[i18];
                if (i18 == this.m_nodeCapacity - 1) {
                    dynamicTreeNode = null;
                } else {
                    dynamicTreeNode = dynamicTreeNodeArr3[i18 + 1];
                }
                dynamicTreeNode2.parent = dynamicTreeNode;
                dynamicTreeNode2.height = -1;
            }
            this.m_freeList = i3;
        }
        DynamicTreeNode dynamicTreeNode3 = this.m_nodes[this.m_freeList];
        DynamicTreeNode dynamicTreeNode4 = dynamicTreeNode3.parent;
        if (dynamicTreeNode4 != null) {
            i16 = dynamicTreeNode4.f423632id;
        }
        this.m_freeList = i16;
        dynamicTreeNode3.parent = null;
        dynamicTreeNode3.child1 = null;
        dynamicTreeNode3.child2 = null;
        dynamicTreeNode3.height = 0;
        dynamicTreeNode3.userData = null;
        this.m_nodeCount++;
        return dynamicTreeNode3;
    }

    private DynamicTreeNode balance(DynamicTreeNode dynamicTreeNode) {
        if (!dynamicTreeNode.isLeaf() && dynamicTreeNode.height >= 2) {
            DynamicTreeNode dynamicTreeNode2 = dynamicTreeNode.child1;
            DynamicTreeNode dynamicTreeNode3 = dynamicTreeNode.child2;
            int i3 = dynamicTreeNode3.height - dynamicTreeNode2.height;
            if (i3 > 1) {
                DynamicTreeNode dynamicTreeNode4 = dynamicTreeNode3.child1;
                DynamicTreeNode dynamicTreeNode5 = dynamicTreeNode3.child2;
                dynamicTreeNode3.child1 = dynamicTreeNode;
                dynamicTreeNode3.parent = dynamicTreeNode.parent;
                dynamicTreeNode.parent = dynamicTreeNode3;
                DynamicTreeNode dynamicTreeNode6 = dynamicTreeNode3.parent;
                if (dynamicTreeNode6 != null) {
                    if (dynamicTreeNode6.child1 == dynamicTreeNode) {
                        dynamicTreeNode6.child1 = dynamicTreeNode3;
                    } else {
                        dynamicTreeNode6.child2 = dynamicTreeNode3;
                    }
                } else {
                    this.m_root = dynamicTreeNode3;
                }
                if (dynamicTreeNode4.height > dynamicTreeNode5.height) {
                    dynamicTreeNode3.child2 = dynamicTreeNode4;
                    dynamicTreeNode.child2 = dynamicTreeNode5;
                    dynamicTreeNode5.parent = dynamicTreeNode;
                    dynamicTreeNode.aabb.combine(dynamicTreeNode2.aabb, dynamicTreeNode5.aabb);
                    dynamicTreeNode3.aabb.combine(dynamicTreeNode.aabb, dynamicTreeNode4.aabb);
                    int max = MathUtils.max(dynamicTreeNode2.height, dynamicTreeNode5.height) + 1;
                    dynamicTreeNode.height = max;
                    dynamicTreeNode3.height = MathUtils.max(max, dynamicTreeNode4.height) + 1;
                } else {
                    dynamicTreeNode3.child2 = dynamicTreeNode5;
                    dynamicTreeNode.child2 = dynamicTreeNode4;
                    dynamicTreeNode4.parent = dynamicTreeNode;
                    dynamicTreeNode.aabb.combine(dynamicTreeNode2.aabb, dynamicTreeNode4.aabb);
                    dynamicTreeNode3.aabb.combine(dynamicTreeNode.aabb, dynamicTreeNode5.aabb);
                    int max2 = MathUtils.max(dynamicTreeNode2.height, dynamicTreeNode4.height) + 1;
                    dynamicTreeNode.height = max2;
                    dynamicTreeNode3.height = MathUtils.max(max2, dynamicTreeNode5.height) + 1;
                }
                return dynamicTreeNode3;
            }
            if (i3 < -1) {
                DynamicTreeNode dynamicTreeNode7 = dynamicTreeNode2.child1;
                DynamicTreeNode dynamicTreeNode8 = dynamicTreeNode2.child2;
                dynamicTreeNode2.child1 = dynamicTreeNode;
                dynamicTreeNode2.parent = dynamicTreeNode.parent;
                dynamicTreeNode.parent = dynamicTreeNode2;
                DynamicTreeNode dynamicTreeNode9 = dynamicTreeNode2.parent;
                if (dynamicTreeNode9 != null) {
                    if (dynamicTreeNode9.child1 == dynamicTreeNode) {
                        dynamicTreeNode9.child1 = dynamicTreeNode2;
                    } else {
                        dynamicTreeNode9.child2 = dynamicTreeNode2;
                    }
                } else {
                    this.m_root = dynamicTreeNode2;
                }
                if (dynamicTreeNode7.height > dynamicTreeNode8.height) {
                    dynamicTreeNode2.child2 = dynamicTreeNode7;
                    dynamicTreeNode.child1 = dynamicTreeNode8;
                    dynamicTreeNode8.parent = dynamicTreeNode;
                    dynamicTreeNode.aabb.combine(dynamicTreeNode3.aabb, dynamicTreeNode8.aabb);
                    dynamicTreeNode2.aabb.combine(dynamicTreeNode.aabb, dynamicTreeNode7.aabb);
                    int max3 = MathUtils.max(dynamicTreeNode3.height, dynamicTreeNode8.height) + 1;
                    dynamicTreeNode.height = max3;
                    dynamicTreeNode2.height = MathUtils.max(max3, dynamicTreeNode7.height) + 1;
                } else {
                    dynamicTreeNode2.child2 = dynamicTreeNode8;
                    dynamicTreeNode.child1 = dynamicTreeNode7;
                    dynamicTreeNode7.parent = dynamicTreeNode;
                    dynamicTreeNode.aabb.combine(dynamicTreeNode3.aabb, dynamicTreeNode7.aabb);
                    dynamicTreeNode2.aabb.combine(dynamicTreeNode.aabb, dynamicTreeNode8.aabb);
                    int max4 = MathUtils.max(dynamicTreeNode3.height, dynamicTreeNode7.height) + 1;
                    dynamicTreeNode.height = max4;
                    dynamicTreeNode2.height = MathUtils.max(max4, dynamicTreeNode8.height) + 1;
                }
                return dynamicTreeNode2;
            }
        }
        return dynamicTreeNode;
    }

    private final void freeNode(DynamicTreeNode dynamicTreeNode) {
        DynamicTreeNode dynamicTreeNode2;
        int i3 = this.m_freeList;
        if (i3 != -1) {
            dynamicTreeNode2 = this.m_nodes[i3];
        } else {
            dynamicTreeNode2 = null;
        }
        dynamicTreeNode.parent = dynamicTreeNode2;
        dynamicTreeNode.height = -1;
        this.m_freeList = dynamicTreeNode.f423632id;
        this.m_nodeCount--;
    }

    private final void insertLeaf(int i3) {
        float perimeter;
        float perimeter2;
        this.m_insertionCount++;
        DynamicTreeNode dynamicTreeNode = this.m_nodes[i3];
        DynamicTreeNode dynamicTreeNode2 = this.m_root;
        if (dynamicTreeNode2 == null) {
            this.m_root = dynamicTreeNode;
            dynamicTreeNode.parent = null;
            return;
        }
        AABB aabb = dynamicTreeNode.aabb;
        while (true) {
            DynamicTreeNode dynamicTreeNode3 = dynamicTreeNode2.child1;
            if (dynamicTreeNode3 == null) {
                break;
            }
            DynamicTreeNode dynamicTreeNode4 = dynamicTreeNode2.child2;
            float perimeter3 = dynamicTreeNode2.aabb.getPerimeter();
            this.combinedAABB.combine(dynamicTreeNode2.aabb, aabb);
            float perimeter4 = this.combinedAABB.getPerimeter();
            float f16 = perimeter4 * 2.0f;
            float f17 = (perimeter4 - perimeter3) * 2.0f;
            if (dynamicTreeNode3.isLeaf()) {
                this.combinedAABB.combine(aabb, dynamicTreeNode3.aabb);
                perimeter = this.combinedAABB.getPerimeter() + f17;
            } else {
                this.combinedAABB.combine(aabb, dynamicTreeNode3.aabb);
                perimeter = (this.combinedAABB.getPerimeter() - dynamicTreeNode3.aabb.getPerimeter()) + f17;
            }
            if (dynamicTreeNode4.isLeaf()) {
                this.combinedAABB.combine(aabb, dynamicTreeNode4.aabb);
                perimeter2 = this.combinedAABB.getPerimeter() + f17;
            } else {
                this.combinedAABB.combine(aabb, dynamicTreeNode4.aabb);
                perimeter2 = (this.combinedAABB.getPerimeter() - dynamicTreeNode4.aabb.getPerimeter()) + f17;
            }
            if (f16 < perimeter && f16 < perimeter2) {
                break;
            } else if (perimeter < perimeter2) {
                dynamicTreeNode2 = dynamicTreeNode3;
            } else {
                dynamicTreeNode2 = dynamicTreeNode4;
            }
        }
        DynamicTreeNode dynamicTreeNode5 = this.m_nodes[dynamicTreeNode2.f423632id].parent;
        DynamicTreeNode allocateNode = allocateNode();
        allocateNode.parent = dynamicTreeNode5;
        allocateNode.userData = null;
        allocateNode.aabb.combine(aabb, dynamicTreeNode2.aabb);
        allocateNode.height = dynamicTreeNode2.height + 1;
        if (dynamicTreeNode5 != null) {
            if (dynamicTreeNode5.child1 == dynamicTreeNode2) {
                dynamicTreeNode5.child1 = allocateNode;
            } else {
                dynamicTreeNode5.child2 = allocateNode;
            }
            allocateNode.child1 = dynamicTreeNode2;
            allocateNode.child2 = dynamicTreeNode;
            dynamicTreeNode2.parent = allocateNode;
            dynamicTreeNode.parent = allocateNode;
        } else {
            allocateNode.child1 = dynamicTreeNode2;
            allocateNode.child2 = dynamicTreeNode;
            dynamicTreeNode2.parent = allocateNode;
            dynamicTreeNode.parent = allocateNode;
            this.m_root = allocateNode;
        }
        DynamicTreeNode dynamicTreeNode6 = dynamicTreeNode.parent;
        while (dynamicTreeNode6 != null) {
            DynamicTreeNode balance = balance(dynamicTreeNode6);
            DynamicTreeNode dynamicTreeNode7 = balance.child1;
            DynamicTreeNode dynamicTreeNode8 = balance.child2;
            balance.height = MathUtils.max(dynamicTreeNode7.height, dynamicTreeNode8.height) + 1;
            balance.aabb.combine(dynamicTreeNode7.aabb, dynamicTreeNode8.aabb);
            dynamicTreeNode6 = balance.parent;
        }
    }

    private final void removeLeaf(DynamicTreeNode dynamicTreeNode) {
        if (dynamicTreeNode == this.m_root) {
            this.m_root = null;
            return;
        }
        DynamicTreeNode dynamicTreeNode2 = dynamicTreeNode.parent;
        DynamicTreeNode dynamicTreeNode3 = dynamicTreeNode2.parent;
        DynamicTreeNode dynamicTreeNode4 = dynamicTreeNode2.child1;
        if (dynamicTreeNode4 == dynamicTreeNode) {
            dynamicTreeNode4 = dynamicTreeNode2.child2;
        }
        if (dynamicTreeNode3 != null) {
            if (dynamicTreeNode3.child1 == dynamicTreeNode2) {
                dynamicTreeNode3.child1 = dynamicTreeNode4;
            } else {
                dynamicTreeNode3.child2 = dynamicTreeNode4;
            }
            dynamicTreeNode4.parent = dynamicTreeNode3;
            freeNode(dynamicTreeNode2);
            while (dynamicTreeNode3 != null) {
                DynamicTreeNode balance = balance(dynamicTreeNode3);
                DynamicTreeNode dynamicTreeNode5 = balance.child1;
                DynamicTreeNode dynamicTreeNode6 = balance.child2;
                balance.aabb.combine(dynamicTreeNode5.aabb, dynamicTreeNode6.aabb);
                balance.height = MathUtils.max(dynamicTreeNode5.height, dynamicTreeNode6.height) + 1;
                dynamicTreeNode3 = balance.parent;
            }
            return;
        }
        this.m_root = dynamicTreeNode4;
        dynamicTreeNode4.parent = null;
        freeNode(dynamicTreeNode2);
    }

    private void validateMetrics(DynamicTreeNode dynamicTreeNode) {
        if (dynamicTreeNode == null) {
            return;
        }
        DynamicTreeNode dynamicTreeNode2 = dynamicTreeNode.child1;
        DynamicTreeNode dynamicTreeNode3 = dynamicTreeNode.child2;
        if (dynamicTreeNode.isLeaf()) {
            return;
        }
        MathUtils.max(dynamicTreeNode2.height, dynamicTreeNode3.height);
        new AABB().combine(dynamicTreeNode2.aabb, dynamicTreeNode3.aabb);
        validateMetrics(dynamicTreeNode2);
        validateMetrics(dynamicTreeNode3);
    }

    private void validateStructure(DynamicTreeNode dynamicTreeNode) {
        if (dynamicTreeNode == null) {
            return;
        }
        DynamicTreeNode dynamicTreeNode2 = this.m_root;
        DynamicTreeNode dynamicTreeNode3 = dynamicTreeNode.child1;
        DynamicTreeNode dynamicTreeNode4 = dynamicTreeNode.child2;
        if (dynamicTreeNode.isLeaf()) {
            return;
        }
        validateStructure(dynamicTreeNode3);
        validateStructure(dynamicTreeNode4);
    }

    @Override // org.jbox2d.collision.broadphase.BroadPhaseStrategy
    public final int computeHeight() {
        return computeHeight(this.m_root);
    }

    @Override // org.jbox2d.collision.broadphase.BroadPhaseStrategy
    public final int createProxy(AABB aabb, Object obj) {
        DynamicTreeNode allocateNode = allocateNode();
        int i3 = allocateNode.f423632id;
        AABB aabb2 = allocateNode.aabb;
        Vec2 vec2 = aabb2.lowerBound;
        Vec2 vec22 = aabb.lowerBound;
        vec2.f423649x = vec22.f423649x - 0.1f;
        vec2.f423650y = vec22.f423650y - 0.1f;
        Vec2 vec23 = aabb2.upperBound;
        Vec2 vec24 = aabb.upperBound;
        vec23.f423649x = vec24.f423649x + 0.1f;
        vec23.f423650y = vec24.f423650y + 0.1f;
        allocateNode.userData = obj;
        insertLeaf(i3);
        return i3;
    }

    @Override // org.jbox2d.collision.broadphase.BroadPhaseStrategy
    public final void destroyProxy(int i3) {
        DynamicTreeNode dynamicTreeNode = this.m_nodes[i3];
        removeLeaf(dynamicTreeNode);
        freeNode(dynamicTreeNode);
    }

    @Override // org.jbox2d.collision.broadphase.BroadPhaseStrategy
    public void drawTree(DebugDraw debugDraw) {
        if (this.m_root == null) {
            return;
        }
        drawTree(debugDraw, this.m_root, 0, computeHeight());
    }

    @Override // org.jbox2d.collision.broadphase.BroadPhaseStrategy
    public float getAreaRatio() {
        DynamicTreeNode dynamicTreeNode = this.m_root;
        float f16 = 0.0f;
        if (dynamicTreeNode == null) {
            return 0.0f;
        }
        float perimeter = dynamicTreeNode.aabb.getPerimeter();
        for (int i3 = 0; i3 < this.m_nodeCapacity; i3++) {
            DynamicTreeNode dynamicTreeNode2 = this.m_nodes[i3];
            if (dynamicTreeNode2.height >= 0) {
                f16 += dynamicTreeNode2.aabb.getPerimeter();
            }
        }
        return f16 / perimeter;
    }

    @Override // org.jbox2d.collision.broadphase.BroadPhaseStrategy
    public final AABB getFatAABB(int i3) {
        return this.m_nodes[i3].aabb;
    }

    @Override // org.jbox2d.collision.broadphase.BroadPhaseStrategy
    public int getHeight() {
        DynamicTreeNode dynamicTreeNode = this.m_root;
        if (dynamicTreeNode == null) {
            return 0;
        }
        return dynamicTreeNode.height;
    }

    @Override // org.jbox2d.collision.broadphase.BroadPhaseStrategy
    public int getInsertionCount() {
        return this.m_insertionCount;
    }

    @Override // org.jbox2d.collision.broadphase.BroadPhaseStrategy
    public int getMaxBalance() {
        int i3 = 0;
        for (int i16 = 0; i16 < this.m_nodeCapacity; i16++) {
            DynamicTreeNode dynamicTreeNode = this.m_nodes[i16];
            if (dynamicTreeNode.height > 1) {
                i3 = MathUtils.max(i3, MathUtils.abs(dynamicTreeNode.child2.height - dynamicTreeNode.child1.height));
            }
        }
        return i3;
    }

    @Override // org.jbox2d.collision.broadphase.BroadPhaseStrategy
    public final Object getUserData(int i3) {
        return this.m_nodes[i3].userData;
    }

    @Override // org.jbox2d.collision.broadphase.BroadPhaseStrategy
    public final boolean moveProxy(int i3, AABB aabb, Vec2 vec2) {
        DynamicTreeNode dynamicTreeNode = this.m_nodes[i3];
        AABB aabb2 = dynamicTreeNode.aabb;
        Vec2 vec22 = aabb2.lowerBound;
        float f16 = vec22.f423649x;
        Vec2 vec23 = aabb.lowerBound;
        if (f16 > vec23.f423649x && vec22.f423650y > vec23.f423650y) {
            Vec2 vec24 = aabb.upperBound;
            float f17 = vec24.f423649x;
            Vec2 vec25 = aabb2.upperBound;
            if (f17 > vec25.f423649x && vec24.f423650y > vec25.f423650y) {
                return false;
            }
        }
        removeLeaf(dynamicTreeNode);
        Vec2 vec26 = aabb2.lowerBound;
        Vec2 vec27 = aabb2.upperBound;
        Vec2 vec28 = aabb.lowerBound;
        vec26.f423649x = vec28.f423649x - 0.1f;
        vec26.f423650y = vec28.f423650y - 0.1f;
        Vec2 vec29 = aabb.upperBound;
        float f18 = vec29.f423649x + 0.1f;
        vec27.f423649x = f18;
        float f19 = vec29.f423650y + 0.1f;
        vec27.f423650y = f19;
        float f26 = vec2.f423649x * 2.0f;
        float f27 = vec2.f423650y * 2.0f;
        if (f26 < 0.0f) {
            vec26.f423649x += f26;
        } else {
            vec27.f423649x = f18 + f26;
        }
        if (f27 < 0.0f) {
            vec26.f423650y += f27;
        } else {
            vec27.f423650y = f19 + f27;
        }
        insertLeaf(i3);
        return true;
    }

    @Override // org.jbox2d.collision.broadphase.BroadPhaseStrategy
    public final void query(TreeCallback treeCallback, AABB aabb) {
        this.nodeStack.reset();
        this.nodeStack.push(this.m_root);
        while (this.nodeStack.getCount() > 0) {
            DynamicTreeNode pop = this.nodeStack.pop();
            if (pop != null && AABB.testOverlap(pop.aabb, aabb)) {
                DynamicTreeNode dynamicTreeNode = pop.child1;
                if (dynamicTreeNode == null) {
                    if (!treeCallback.treeCallback(pop.f423632id)) {
                        return;
                    }
                } else {
                    this.nodeStack.push(dynamicTreeNode);
                    this.nodeStack.push(pop.child2);
                }
            }
        }
    }

    @Override // org.jbox2d.collision.broadphase.BroadPhaseStrategy
    public void raycast(TreeRayCastCallback treeRayCastCallback, RayCastInput rayCastInput) {
        float f16;
        float f17;
        float f18;
        AABB aabb;
        float f19;
        AABB aabb2;
        float f26;
        float f27;
        float f28;
        Vec2 vec2 = rayCastInput.f423628p1;
        Vec2 vec22 = rayCastInput.f423629p2;
        float f29 = vec2.f423649x;
        float f36 = vec22.f423649x;
        float f37 = vec2.f423650y;
        float f38 = vec22.f423650y;
        Vec2 vec23 = this.f423631r;
        float f39 = f36 - f29;
        vec23.f423649x = f39;
        float f46 = f38 - f37;
        vec23.f423650y = f46;
        vec23.normalize();
        Vec2 vec24 = this.f423631r;
        float f47 = vec24.f423649x;
        float f48 = vec24.f423650y * (-1.0f);
        float f49 = f47 * 1.0f;
        float abs = MathUtils.abs(f48);
        float abs2 = MathUtils.abs(f49);
        float f56 = rayCastInput.maxFraction;
        AABB aabb3 = this.aabb;
        float f57 = (f39 * f56) + f29;
        float f58 = (f46 * f56) + f37;
        Vec2 vec25 = aabb3.lowerBound;
        if (f29 < f57) {
            f16 = f56;
            f17 = f29;
        } else {
            f16 = f56;
            f17 = f57;
        }
        vec25.f423649x = f17;
        if (f37 < f58) {
            f18 = f37;
        } else {
            f18 = f58;
        }
        vec25.f423650y = f18;
        Vec2 vec26 = aabb3.upperBound;
        if (f29 > f57) {
            f57 = f29;
        }
        vec26.f423649x = f57;
        if (f37 > f58) {
            f58 = f37;
        }
        vec26.f423650y = f58;
        this.nodeStack.reset();
        this.nodeStack.push(this.m_root);
        float f59 = f16;
        while (this.nodeStack.getCount() > 0) {
            DynamicTreeNode pop = this.nodeStack.pop();
            if (pop != null) {
                AABB aabb4 = pop.aabb;
                if (AABB.testOverlap(aabb4, aabb3)) {
                    Vec2 vec27 = aabb4.lowerBound;
                    aabb = aabb3;
                    float f65 = vec27.f423649x;
                    Vec2 vec28 = aabb4.upperBound;
                    f19 = f46;
                    float f66 = vec28.f423649x;
                    float f67 = (f65 + f66) * 0.5f;
                    float f68 = vec27.f423650y;
                    float f69 = vec28.f423650y;
                    if (MathUtils.abs(((f29 - f67) * f48) + ((f37 - ((f68 + f69) * 0.5f)) * f49)) - ((((f66 - f65) * 0.5f) * abs) + (((f69 - f68) * 0.5f) * abs2)) <= 0.0f) {
                        if (pop.isLeaf()) {
                            RayCastInput rayCastInput2 = this.subInput;
                            Vec2 vec29 = rayCastInput2.f423628p1;
                            vec29.f423649x = f29;
                            vec29.f423650y = f37;
                            Vec2 vec210 = rayCastInput2.f423629p2;
                            vec210.f423649x = f36;
                            vec210.f423650y = f38;
                            rayCastInput2.maxFraction = f59;
                            float raycastCallback = treeRayCastCallback.raycastCallback(rayCastInput2, pop.f423632id);
                            if (raycastCallback == 0.0f) {
                                return;
                            }
                            if (raycastCallback > 0.0f) {
                                float f75 = (f39 * raycastCallback) + f29;
                                float f76 = (f19 * raycastCallback) + f37;
                                aabb2 = aabb;
                                Vec2 vec211 = aabb2.lowerBound;
                                if (f29 < f75) {
                                    f26 = f38;
                                    f27 = f29;
                                } else {
                                    f26 = f38;
                                    f27 = f75;
                                }
                                vec211.f423649x = f27;
                                if (f37 < f76) {
                                    f28 = f37;
                                } else {
                                    f28 = f76;
                                }
                                vec211.f423650y = f28;
                                Vec2 vec212 = aabb2.upperBound;
                                if (f29 > f75) {
                                    f75 = f29;
                                }
                                vec212.f423649x = f75;
                                if (f37 > f76) {
                                    f76 = f37;
                                }
                                vec212.f423650y = f76;
                                f59 = raycastCallback;
                            } else {
                                aabb2 = aabb;
                                f26 = f38;
                            }
                        } else {
                            aabb2 = aabb;
                            f26 = f38;
                            this.nodeStack.push(pop.child1);
                            this.nodeStack.push(pop.child2);
                        }
                        aabb3 = aabb2;
                        f38 = f26;
                        f46 = f19;
                    }
                    aabb3 = aabb;
                    f46 = f19;
                }
            }
            f19 = f46;
            aabb = aabb3;
            aabb3 = aabb;
            f46 = f19;
        }
    }

    public void rebuildBottomUp() {
        int[] iArr = new int[this.m_nodeCount];
        int i3 = 0;
        for (int i16 = 0; i16 < this.m_nodeCapacity; i16++) {
            DynamicTreeNode dynamicTreeNode = this.m_nodes[i16];
            if (dynamicTreeNode.height >= 0) {
                if (dynamicTreeNode.isLeaf()) {
                    dynamicTreeNode.parent = null;
                    iArr[i3] = i16;
                    i3++;
                } else {
                    freeNode(dynamicTreeNode);
                }
            }
        }
        AABB aabb = new AABB();
        while (i3 > 1) {
            int i17 = -1;
            int i18 = 0;
            float f16 = Float.MAX_VALUE;
            int i19 = -1;
            while (i18 < i3) {
                AABB aabb2 = this.m_nodes[iArr[i18]].aabb;
                int i26 = i18 + 1;
                for (int i27 = i26; i27 < i3; i27++) {
                    aabb.combine(aabb2, this.m_nodes[iArr[i27]].aabb);
                    float perimeter = aabb.getPerimeter();
                    if (perimeter < f16) {
                        i17 = i18;
                        i19 = i27;
                        f16 = perimeter;
                    }
                }
                i18 = i26;
            }
            int i28 = iArr[i17];
            int i29 = iArr[i19];
            DynamicTreeNode[] dynamicTreeNodeArr = this.m_nodes;
            DynamicTreeNode dynamicTreeNode2 = dynamicTreeNodeArr[i28];
            DynamicTreeNode dynamicTreeNode3 = dynamicTreeNodeArr[i29];
            DynamicTreeNode allocateNode = allocateNode();
            allocateNode.child1 = dynamicTreeNode2;
            allocateNode.child2 = dynamicTreeNode3;
            allocateNode.height = MathUtils.max(dynamicTreeNode2.height, dynamicTreeNode3.height) + 1;
            allocateNode.aabb.combine(dynamicTreeNode2.aabb, dynamicTreeNode3.aabb);
            allocateNode.parent = null;
            dynamicTreeNode2.parent = allocateNode;
            dynamicTreeNode3.parent = allocateNode;
            iArr[i19] = iArr[i3 - 1];
            iArr[i17] = allocateNode.f423632id;
            i3--;
        }
        this.m_root = this.m_nodes[iArr[0]];
        validate();
    }

    public void validate() {
        DynamicTreeNode dynamicTreeNode;
        validateStructure(this.m_root);
        validateMetrics(this.m_root);
        int i3 = this.m_freeList;
        if (i3 != -1) {
            dynamicTreeNode = this.m_nodes[i3];
        } else {
            dynamicTreeNode = null;
        }
        while (dynamicTreeNode != null) {
            dynamicTreeNode = dynamicTreeNode.parent;
        }
    }

    private final int computeHeight(DynamicTreeNode dynamicTreeNode) {
        if (dynamicTreeNode.isLeaf()) {
            return 0;
        }
        return MathUtils.max(computeHeight(dynamicTreeNode.child1), computeHeight(dynamicTreeNode.child2)) + 1;
    }

    public void drawTree(DebugDraw debugDraw, DynamicTreeNode dynamicTreeNode, int i3, int i16) {
        dynamicTreeNode.aabb.getVertices(this.drawVecs);
        float f16 = ((i16 - i3) * 1.0f) / i16;
        this.color.set(1.0f, f16, f16);
        debugDraw.drawPolygon(this.drawVecs, 4, this.color);
        debugDraw.getViewportTranform().getWorldToScreen(dynamicTreeNode.aabb.upperBound, this.textVec);
        Vec2 vec2 = this.textVec;
        float f17 = vec2.f423649x;
        float f18 = vec2.f423650y;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(dynamicTreeNode.f423632id);
        sb5.append("-");
        int i17 = i3 + 1;
        sb5.append(i17);
        sb5.append("/");
        sb5.append(i16);
        debugDraw.drawString(f17, f18, sb5.toString(), this.color);
        DynamicTreeNode dynamicTreeNode2 = dynamicTreeNode.child1;
        if (dynamicTreeNode2 != null) {
            drawTree(debugDraw, dynamicTreeNode2, i17, i16);
        }
        DynamicTreeNode dynamicTreeNode3 = dynamicTreeNode.child2;
        if (dynamicTreeNode3 != null) {
            drawTree(debugDraw, dynamicTreeNode3, i17, i16);
        }
    }
}
