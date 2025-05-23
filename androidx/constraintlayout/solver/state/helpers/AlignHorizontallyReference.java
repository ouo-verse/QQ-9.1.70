package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public class AlignHorizontallyReference extends HelperReference {
    private float mBias;
    private Object mEndToEnd;
    private Object mEndToStart;
    private Object mStartToEnd;
    private Object mStartToStart;

    public AlignHorizontallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        Iterator<Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            ConstraintReference constraints = this.mState.constraints(it.next());
            constraints.clearHorizontal();
            Object obj = this.mStartToStart;
            if (obj != null) {
                constraints.startToStart(obj);
            } else {
                Object obj2 = this.mStartToEnd;
                if (obj2 != null) {
                    constraints.startToEnd(obj2);
                } else {
                    constraints.startToStart(State.PARENT);
                }
            }
            Object obj3 = this.mEndToStart;
            if (obj3 != null) {
                constraints.endToStart(obj3);
            } else {
                Object obj4 = this.mEndToEnd;
                if (obj4 != null) {
                    constraints.endToEnd(obj4);
                } else {
                    constraints.endToEnd(State.PARENT);
                }
            }
            float f16 = this.mBias;
            if (f16 != 0.5f) {
                constraints.horizontalBias(f16);
            }
        }
    }

    public void bias(float f16) {
        this.mBias = f16;
    }

    public void endToEnd(Object obj) {
        this.mEndToEnd = obj;
    }

    public void endToStart(Object obj) {
        this.mEndToStart = obj;
    }

    public void startToEnd(Object obj) {
        this.mStartToEnd = obj;
    }

    public void startToStart(Object obj) {
        this.mStartToStart = obj;
    }
}
