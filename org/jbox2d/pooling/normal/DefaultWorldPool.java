package org.jbox2d.pooling.normal;

import java.util.HashMap;
import org.jbox2d.collision.AABB;
import org.jbox2d.collision.Collision;
import org.jbox2d.collision.Distance;
import org.jbox2d.collision.TimeOfImpact;
import org.jbox2d.common.Mat22;
import org.jbox2d.common.Mat33;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Settings;
import org.jbox2d.common.Vec2;
import org.jbox2d.common.Vec3;
import org.jbox2d.dynamics.contacts.ChainAndCircleContact;
import org.jbox2d.dynamics.contacts.ChainAndPolygonContact;
import org.jbox2d.dynamics.contacts.CircleContact;
import org.jbox2d.dynamics.contacts.Contact;
import org.jbox2d.dynamics.contacts.EdgeAndCircleContact;
import org.jbox2d.dynamics.contacts.EdgeAndPolygonContact;
import org.jbox2d.dynamics.contacts.PolygonAndCircleContact;
import org.jbox2d.dynamics.contacts.PolygonContact;
import org.jbox2d.pooling.IDynamicStack;
import org.jbox2d.pooling.IWorldPool;

/* loaded from: classes29.dex */
public class DefaultWorldPool implements IWorldPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final OrderedStack<AABB> aabbs;
    private final OrderedStack<Mat33> mat33s;
    private final OrderedStack<Mat22> mats;
    private final OrderedStack<Rot> rots;
    private final OrderedStack<Vec3> vec3s;
    private final OrderedStack<Vec2> vecs;
    private final HashMap<Integer, float[]> afloats = new HashMap<>();
    private final HashMap<Integer, int[]> aints = new HashMap<>();
    private final HashMap<Integer, Vec2[]> avecs = new HashMap<>();
    private final IWorldPool world = this;
    private final MutableStack<Contact> pcstack = new MutableStack<Contact>(Settings.CONTACT_STACK_INIT_SIZE) { // from class: org.jbox2d.pooling.normal.DefaultWorldPool.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jbox2d.pooling.normal.MutableStack
        public Contact newInstance() {
            return new PolygonContact(DefaultWorldPool.this.world);
        }
    };
    private final MutableStack<Contact> ccstack = new MutableStack<Contact>(Settings.CONTACT_STACK_INIT_SIZE) { // from class: org.jbox2d.pooling.normal.DefaultWorldPool.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jbox2d.pooling.normal.MutableStack
        public Contact newInstance() {
            return new CircleContact(DefaultWorldPool.this.world);
        }
    };
    private final MutableStack<Contact> cpstack = new MutableStack<Contact>(Settings.CONTACT_STACK_INIT_SIZE) { // from class: org.jbox2d.pooling.normal.DefaultWorldPool.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jbox2d.pooling.normal.MutableStack
        public Contact newInstance() {
            return new PolygonAndCircleContact(DefaultWorldPool.this.world);
        }
    };
    private final MutableStack<Contact> ecstack = new MutableStack<Contact>(Settings.CONTACT_STACK_INIT_SIZE) { // from class: org.jbox2d.pooling.normal.DefaultWorldPool.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jbox2d.pooling.normal.MutableStack
        public Contact newInstance() {
            return new EdgeAndCircleContact(DefaultWorldPool.this.world);
        }
    };
    private final MutableStack<Contact> epstack = new MutableStack<Contact>(Settings.CONTACT_STACK_INIT_SIZE) { // from class: org.jbox2d.pooling.normal.DefaultWorldPool.5
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jbox2d.pooling.normal.MutableStack
        public Contact newInstance() {
            return new EdgeAndPolygonContact(DefaultWorldPool.this.world);
        }
    };
    private final MutableStack<Contact> chcstack = new MutableStack<Contact>(Settings.CONTACT_STACK_INIT_SIZE) { // from class: org.jbox2d.pooling.normal.DefaultWorldPool.6
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jbox2d.pooling.normal.MutableStack
        public Contact newInstance() {
            return new ChainAndCircleContact(DefaultWorldPool.this.world);
        }
    };
    private final MutableStack<Contact> chpstack = new MutableStack<Contact>(Settings.CONTACT_STACK_INIT_SIZE) { // from class: org.jbox2d.pooling.normal.DefaultWorldPool.7
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jbox2d.pooling.normal.MutableStack
        public Contact newInstance() {
            return new ChainAndPolygonContact(DefaultWorldPool.this.world);
        }
    };
    private final Distance dist = new Distance();
    private final Collision collision = new Collision(this);
    private final TimeOfImpact toi = new TimeOfImpact(this);

    public DefaultWorldPool(int i3, int i16) {
        this.vecs = new OrderedStack<Vec2>(i3, i16) { // from class: org.jbox2d.pooling.normal.DefaultWorldPool.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jbox2d.pooling.normal.OrderedStack
            public Vec2 newInstance() {
                return new Vec2();
            }
        };
        this.vec3s = new OrderedStack<Vec3>(i3, i16) { // from class: org.jbox2d.pooling.normal.DefaultWorldPool.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jbox2d.pooling.normal.OrderedStack
            public Vec3 newInstance() {
                return new Vec3();
            }
        };
        this.mats = new OrderedStack<Mat22>(i3, i16) { // from class: org.jbox2d.pooling.normal.DefaultWorldPool.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jbox2d.pooling.normal.OrderedStack
            public Mat22 newInstance() {
                return new Mat22();
            }
        };
        this.aabbs = new OrderedStack<AABB>(i3, i16) { // from class: org.jbox2d.pooling.normal.DefaultWorldPool.11
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jbox2d.pooling.normal.OrderedStack
            public AABB newInstance() {
                return new AABB();
            }
        };
        this.rots = new OrderedStack<Rot>(i3, i16) { // from class: org.jbox2d.pooling.normal.DefaultWorldPool.12
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jbox2d.pooling.normal.OrderedStack
            public Rot newInstance() {
                return new Rot();
            }
        };
        this.mat33s = new OrderedStack<Mat33>(i3, i16) { // from class: org.jbox2d.pooling.normal.DefaultWorldPool.13
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jbox2d.pooling.normal.OrderedStack
            public Mat33 newInstance() {
                return new Mat33();
            }
        };
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public IDynamicStack<Contact> getChainCircleContactStack() {
        return this.chcstack;
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public IDynamicStack<Contact> getChainPolyContactStack() {
        return this.chpstack;
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final IDynamicStack<Contact> getCircleContactStack() {
        return this.ccstack;
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final Collision getCollision() {
        return this.collision;
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final Distance getDistance() {
        return this.dist;
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public IDynamicStack<Contact> getEdgeCircleContactStack() {
        return this.ecstack;
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public IDynamicStack<Contact> getEdgePolyContactStack() {
        return this.epstack;
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final float[] getFloatArray(int i3) {
        if (!this.afloats.containsKey(Integer.valueOf(i3))) {
            this.afloats.put(Integer.valueOf(i3), new float[i3]);
        }
        return this.afloats.get(Integer.valueOf(i3));
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final int[] getIntArray(int i3) {
        if (!this.aints.containsKey(Integer.valueOf(i3))) {
            this.aints.put(Integer.valueOf(i3), new int[i3]);
        }
        return this.aints.get(Integer.valueOf(i3));
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final IDynamicStack<Contact> getPolyCircleContactStack() {
        return this.cpstack;
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final IDynamicStack<Contact> getPolyContactStack() {
        return this.pcstack;
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final TimeOfImpact getTimeOfImpact() {
        return this.toi;
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final Vec2[] getVec2Array(int i3) {
        if (!this.avecs.containsKey(Integer.valueOf(i3))) {
            Vec2[] vec2Arr = new Vec2[i3];
            for (int i16 = 0; i16 < i3; i16++) {
                vec2Arr[i16] = new Vec2();
            }
            this.avecs.put(Integer.valueOf(i3), vec2Arr);
        }
        return this.avecs.get(Integer.valueOf(i3));
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final AABB popAABB() {
        return this.aabbs.pop();
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final Mat22 popMat22() {
        return this.mats.pop();
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final Mat33 popMat33() {
        return this.mat33s.pop();
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final Rot popRot() {
        return this.rots.pop();
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final Vec2 popVec2() {
        return this.vecs.pop();
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final Vec3 popVec3() {
        return this.vec3s.pop();
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final void pushAABB(int i3) {
        this.aabbs.push(i3);
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final void pushMat22(int i3) {
        this.mats.push(i3);
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final void pushMat33(int i3) {
        this.mat33s.push(i3);
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final void pushRot(int i3) {
        this.rots.push(i3);
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final void pushVec2(int i3) {
        this.vecs.push(i3);
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final void pushVec3(int i3) {
        this.vec3s.push(i3);
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final AABB[] popAABB(int i3) {
        return this.aabbs.pop(i3);
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final Mat22[] popMat22(int i3) {
        return this.mats.pop(i3);
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final Vec2[] popVec2(int i3) {
        return this.vecs.pop(i3);
    }

    @Override // org.jbox2d.pooling.IWorldPool
    public final Vec3[] popVec3(int i3) {
        return this.vec3s.pop(i3);
    }
}
