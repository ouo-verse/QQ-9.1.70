package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public class VerticalChainReference extends ChainReference {
    private Object mBottomToBottom;
    private Object mBottomToTop;
    private Object mTopToBottom;
    private Object mTopToTop;

    /* compiled from: P */
    /* renamed from: androidx.constraintlayout.solver.state.helpers.VerticalChainReference$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Chain;

        static {
            int[] iArr = new int[State.Chain.values().length];
            $SwitchMap$androidx$constraintlayout$solver$state$State$Chain = iArr;
            try {
                iArr[State.Chain.SPREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Chain[State.Chain.SPREAD_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Chain[State.Chain.PACKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public VerticalChainReference(State state) {
        super(state, State.Helper.VERTICAL_CHAIN);
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        Iterator<Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            this.mState.constraints(it.next()).clearVertical();
        }
        Iterator<Object> it5 = this.mReferences.iterator();
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        while (it5.hasNext()) {
            ConstraintReference constraints = this.mState.constraints(it5.next());
            if (constraintReference2 == null) {
                Object obj = this.mTopToTop;
                if (obj != null) {
                    constraints.topToTop(obj);
                } else {
                    Object obj2 = this.mTopToBottom;
                    if (obj2 != null) {
                        constraints.topToBottom(obj2);
                    } else {
                        constraints.topToTop(State.PARENT);
                    }
                }
                constraintReference2 = constraints;
            }
            if (constraintReference != null) {
                constraintReference.bottomToTop(constraints.getKey());
                constraints.topToBottom(constraintReference.getKey());
            }
            constraintReference = constraints;
        }
        if (constraintReference != null) {
            Object obj3 = this.mBottomToTop;
            if (obj3 != null) {
                constraintReference.bottomToTop(obj3);
            } else {
                Object obj4 = this.mBottomToBottom;
                if (obj4 != null) {
                    constraintReference.bottomToBottom(obj4);
                } else {
                    constraintReference.bottomToBottom(State.PARENT);
                }
            }
        }
        if (constraintReference2 != null) {
            float f16 = this.mBias;
            if (f16 != 0.5f) {
                constraintReference2.verticalBias(f16);
            }
        }
        int i3 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[this.mStyle.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    constraintReference2.setVerticalChainStyle(2);
                    return;
                }
                return;
            }
            constraintReference2.setVerticalChainStyle(1);
            return;
        }
        constraintReference2.setVerticalChainStyle(0);
    }

    public void bottomToBottom(Object obj) {
        this.mBottomToBottom = obj;
    }

    public void bottomToTop(Object obj) {
        this.mBottomToTop = obj;
    }

    public void topToBottom(Object obj) {
        this.mTopToBottom = obj;
    }

    public void topToTop(Object obj) {
        this.mTopToTop = obj;
    }
}
