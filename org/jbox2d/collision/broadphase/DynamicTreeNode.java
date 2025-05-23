package org.jbox2d.collision.broadphase;

import org.jbox2d.collision.AABB;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DynamicTreeNode {
    public final AABB aabb = new AABB();
    protected DynamicTreeNode child1;
    protected DynamicTreeNode child2;
    protected int height;

    /* renamed from: id, reason: collision with root package name */
    protected final int f423632id;
    protected boolean leaf;
    protected DynamicTreeNode parent;
    public Object userData;

    /* JADX INFO: Access modifiers changed from: protected */
    public DynamicTreeNode(int i3) {
        this.f423632id = i3;
    }

    public Object getUserData() {
        return this.userData;
    }

    public final boolean isLeaf() {
        if (this.child1 == null) {
            return true;
        }
        return false;
    }

    public void setUserData(Object obj) {
        this.userData = obj;
    }
}
