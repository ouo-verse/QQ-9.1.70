package org.jbox2d.collision.broadphase;

import java.util.Arrays;
import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.callbacks.PairCallback;
import org.jbox2d.callbacks.TreeCallback;
import org.jbox2d.callbacks.TreeRayCastCallback;
import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.common.Vec2;

/* loaded from: classes29.dex */
public class BroadPhase implements TreeCallback {
    public static final int NULL_PROXY = -1;
    private int[] m_moveBuffer;
    private int m_moveCapacity;
    private int m_moveCount;
    private int m_queryProxyId;
    private final BroadPhaseStrategy m_tree;
    private int m_proxyCount = 0;
    private int m_pairCapacity = 16;
    private int m_pairCount = 0;
    private Pair[] m_pairBuffer = new Pair[16];

    public BroadPhase(BroadPhaseStrategy broadPhaseStrategy) {
        for (int i3 = 0; i3 < this.m_pairCapacity; i3++) {
            this.m_pairBuffer[i3] = new Pair();
        }
        this.m_moveCapacity = 16;
        this.m_moveCount = 0;
        this.m_moveBuffer = new int[16];
        this.m_tree = broadPhaseStrategy;
        this.m_queryProxyId = -1;
    }

    protected final void bufferMove(int i3) {
        int i16 = this.m_moveCount;
        int i17 = this.m_moveCapacity;
        if (i16 == i17) {
            int[] iArr = this.m_moveBuffer;
            int i18 = i17 * 2;
            this.m_moveCapacity = i18;
            int[] iArr2 = new int[i18];
            this.m_moveBuffer = iArr2;
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        }
        int[] iArr3 = this.m_moveBuffer;
        int i19 = this.m_moveCount;
        iArr3[i19] = i3;
        this.m_moveCount = i19 + 1;
    }

    public final int createProxy(AABB aabb, Object obj) {
        int createProxy = this.m_tree.createProxy(aabb, obj);
        this.m_proxyCount++;
        bufferMove(createProxy);
        return createProxy;
    }

    public final void destroyProxy(int i3) {
        unbufferMove(i3);
        this.m_proxyCount--;
        this.m_tree.destroyProxy(i3);
    }

    public void drawTree(DebugDraw debugDraw) {
        this.m_tree.drawTree(debugDraw);
    }

    public AABB getFatAABB(int i3) {
        return this.m_tree.getFatAABB(i3);
    }

    public final int getProxyCount() {
        return this.m_proxyCount;
    }

    public int getTreeBalance() {
        return this.m_tree.getMaxBalance();
    }

    public final int getTreeHeight() {
        return this.m_tree.computeHeight();
    }

    public float getTreeQuality() {
        return this.m_tree.getAreaRatio();
    }

    public Object getUserData(int i3) {
        return this.m_tree.getUserData(i3);
    }

    public final void moveProxy(int i3, AABB aabb, Vec2 vec2) {
        if (this.m_tree.moveProxy(i3, aabb, vec2)) {
            bufferMove(i3);
        }
    }

    public final void query(TreeCallback treeCallback, AABB aabb) {
        this.m_tree.query(treeCallback, aabb);
    }

    public final void raycast(TreeRayCastCallback treeRayCastCallback, RayCastInput rayCastInput) {
        this.m_tree.raycast(treeRayCastCallback, rayCastInput);
    }

    public boolean testOverlap(int i3, int i16) {
        AABB fatAABB = this.m_tree.getFatAABB(i3);
        AABB fatAABB2 = this.m_tree.getFatAABB(i16);
        Vec2 vec2 = fatAABB2.lowerBound;
        float f16 = vec2.f423649x;
        Vec2 vec22 = fatAABB.upperBound;
        if (f16 - vec22.f423649x <= 0.0f && vec2.f423650y - vec22.f423650y <= 0.0f) {
            Vec2 vec23 = fatAABB.lowerBound;
            float f17 = vec23.f423649x;
            Vec2 vec24 = fatAABB2.upperBound;
            if (f17 - vec24.f423649x <= 0.0f && vec23.f423650y - vec24.f423650y <= 0.0f) {
                return true;
            }
        }
        return false;
    }

    public void touchProxy(int i3) {
        bufferMove(i3);
    }

    @Override // org.jbox2d.callbacks.TreeCallback
    public final boolean treeCallback(int i3) {
        if (i3 == this.m_queryProxyId) {
            return true;
        }
        int i16 = this.m_pairCount;
        int i17 = this.m_pairCapacity;
        if (i16 == i17) {
            Pair[] pairArr = this.m_pairBuffer;
            int i18 = i17 * 2;
            this.m_pairCapacity = i18;
            Pair[] pairArr2 = new Pair[i18];
            this.m_pairBuffer = pairArr2;
            System.arraycopy(pairArr, 0, pairArr2, 0, pairArr.length);
            for (int length = pairArr.length; length < this.m_pairCapacity; length++) {
                this.m_pairBuffer[length] = new Pair();
            }
        }
        int i19 = this.m_queryProxyId;
        if (i3 < i19) {
            Pair pair = this.m_pairBuffer[this.m_pairCount];
            pair.proxyIdA = i3;
            pair.proxyIdB = i19;
        } else {
            Pair pair2 = this.m_pairBuffer[this.m_pairCount];
            pair2.proxyIdA = i19;
            pair2.proxyIdB = i3;
        }
        this.m_pairCount++;
        return true;
    }

    protected final void unbufferMove(int i3) {
        for (int i16 = 0; i16 < this.m_moveCount; i16++) {
            int[] iArr = this.m_moveBuffer;
            if (iArr[i16] == i3) {
                iArr[i16] = -1;
            }
        }
    }

    public final void updatePairs(PairCallback pairCallback) {
        Pair pair;
        int i3 = 0;
        this.m_pairCount = 0;
        for (int i16 = 0; i16 < this.m_moveCount; i16++) {
            int i17 = this.m_moveBuffer[i16];
            this.m_queryProxyId = i17;
            if (i17 != -1) {
                this.m_tree.query(this, this.m_tree.getFatAABB(i17));
            }
        }
        this.m_moveCount = 0;
        Arrays.sort(this.m_pairBuffer, 0, this.m_pairCount);
        while (i3 < this.m_pairCount) {
            Pair pair2 = this.m_pairBuffer[i3];
            pairCallback.addPair(this.m_tree.getUserData(pair2.proxyIdA), this.m_tree.getUserData(pair2.proxyIdB));
            do {
                i3++;
                if (i3 < this.m_pairCount) {
                    pair = this.m_pairBuffer[i3];
                    if (pair.proxyIdA == pair2.proxyIdA) {
                    }
                }
            } while (pair.proxyIdB == pair2.proxyIdB);
        }
    }
}
