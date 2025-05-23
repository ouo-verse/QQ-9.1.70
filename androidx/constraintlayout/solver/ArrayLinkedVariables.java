package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import com.tencent.component.media.image.ProgressTracer;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes.dex */
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    static final int NONE = -1;
    private static float epsilon = 0.001f;
    protected final Cache mCache;
    private final ArrayRow mRow;
    int currentSize = 0;
    private int ROW_SIZE = 8;
    private SolverVariable candidate = null;
    private int[] mArrayIndices = new int[8];
    private int[] mArrayNextIndices = new int[8];
    private float[] mArrayValues = new float[8];
    private int mHead = -1;
    private int mLast = -1;
    private boolean mDidFillOnce = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f16, boolean z16) {
        float f17 = epsilon;
        if (f16 > (-f17) && f16 < f17) {
            return;
        }
        int i3 = this.mHead;
        if (i3 == -1) {
            this.mHead = 0;
            this.mArrayValues[0] = f16;
            this.mArrayIndices[0] = solverVariable.f26465id;
            this.mArrayNextIndices[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                int i16 = this.mLast + 1;
                this.mLast = i16;
                int[] iArr = this.mArrayIndices;
                if (i16 >= iArr.length) {
                    this.mDidFillOnce = true;
                    this.mLast = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i17 = -1;
        for (int i18 = 0; i3 != -1 && i18 < this.currentSize; i18++) {
            int i19 = this.mArrayIndices[i3];
            int i26 = solverVariable.f26465id;
            if (i19 == i26) {
                float[] fArr = this.mArrayValues;
                float f18 = fArr[i3] + f16;
                float f19 = epsilon;
                if (f18 > (-f19) && f18 < f19) {
                    f18 = 0.0f;
                }
                fArr[i3] = f18;
                if (f18 == 0.0f) {
                    if (i3 == this.mHead) {
                        this.mHead = this.mArrayNextIndices[i3];
                    } else {
                        int[] iArr2 = this.mArrayNextIndices;
                        iArr2[i17] = iArr2[i3];
                    }
                    if (z16) {
                        solverVariable.removeFromRow(this.mRow);
                    }
                    if (this.mDidFillOnce) {
                        this.mLast = i3;
                    }
                    solverVariable.usageInRowCount--;
                    this.currentSize--;
                    return;
                }
                return;
            }
            if (i19 < i26) {
                i17 = i3;
            }
            i3 = this.mArrayNextIndices[i3];
        }
        int i27 = this.mLast;
        int i28 = i27 + 1;
        if (this.mDidFillOnce) {
            int[] iArr3 = this.mArrayIndices;
            if (iArr3[i27] != -1) {
                i27 = iArr3.length;
            }
        } else {
            i27 = i28;
        }
        int[] iArr4 = this.mArrayIndices;
        if (i27 >= iArr4.length && this.currentSize < iArr4.length) {
            int i29 = 0;
            while (true) {
                int[] iArr5 = this.mArrayIndices;
                if (i29 >= iArr5.length) {
                    break;
                }
                if (iArr5[i29] == -1) {
                    i27 = i29;
                    break;
                }
                i29++;
            }
        }
        int[] iArr6 = this.mArrayIndices;
        if (i27 >= iArr6.length) {
            i27 = iArr6.length;
            int i36 = this.ROW_SIZE * 2;
            this.ROW_SIZE = i36;
            this.mDidFillOnce = false;
            this.mLast = i27 - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, i36);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
        }
        this.mArrayIndices[i27] = solverVariable.f26465id;
        this.mArrayValues[i27] = f16;
        if (i17 != -1) {
            int[] iArr7 = this.mArrayNextIndices;
            iArr7[i27] = iArr7[i17];
            iArr7[i17] = i27;
        } else {
            this.mArrayNextIndices[i27] = this.mHead;
            this.mHead = i27;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.mRow);
        this.currentSize++;
        if (!this.mDidFillOnce) {
            this.mLast++;
        }
        int i37 = this.mLast;
        int[] iArr8 = this.mArrayIndices;
        if (i37 >= iArr8.length) {
            this.mDidFillOnce = true;
            this.mLast = iArr8.length - 1;
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void clear() {
        int i3 = this.mHead;
        for (int i16 = 0; i3 != -1 && i16 < this.currentSize; i16++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i3]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
            i3 = this.mArrayNextIndices[i3];
        }
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.currentSize = 0;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        int i3 = this.mHead;
        if (i3 == -1) {
            return false;
        }
        for (int i16 = 0; i3 != -1 && i16 < this.currentSize; i16++) {
            if (this.mArrayIndices[i3] == solverVariable.f26465id) {
                return true;
            }
            i3 = this.mArrayNextIndices[i3];
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void display() {
        int i3 = this.currentSize;
        System.out.print("{ ");
        for (int i16 = 0; i16 < i3; i16++) {
            SolverVariable variable = getVariable(i16);
            if (variable != null) {
                System.out.print(variable + " = " + getVariableValue(i16) + " ");
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f16) {
        int i3 = this.mHead;
        for (int i16 = 0; i3 != -1 && i16 < this.currentSize; i16++) {
            float[] fArr = this.mArrayValues;
            fArr[i3] = fArr[i3] / f16;
            i3 = this.mArrayNextIndices[i3];
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable solverVariable) {
        int i3 = this.mHead;
        for (int i16 = 0; i3 != -1 && i16 < this.currentSize; i16++) {
            if (this.mArrayIndices[i3] == solverVariable.f26465id) {
                return this.mArrayValues[i3];
            }
            i3 = this.mArrayNextIndices[i3];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getHead() {
        return this.mHead;
    }

    public final int getId(int i3) {
        return this.mArrayIndices[i3];
    }

    public final int getNextIndice(int i3) {
        return this.mArrayNextIndices[i3];
    }

    SolverVariable getPivotCandidate() {
        SolverVariable solverVariable = this.candidate;
        if (solverVariable == null) {
            int i3 = this.mHead;
            SolverVariable solverVariable2 = null;
            for (int i16 = 0; i3 != -1 && i16 < this.currentSize; i16++) {
                if (this.mArrayValues[i3] < 0.0f) {
                    SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i3]];
                    if (solverVariable2 == null || solverVariable2.strength < solverVariable3.strength) {
                        solverVariable2 = solverVariable3;
                    }
                }
                i3 = this.mArrayNextIndices[i3];
            }
            return solverVariable2;
        }
        return solverVariable;
    }

    public final float getValue(int i3) {
        return this.mArrayValues[i3];
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i3) {
        int i16 = this.mHead;
        for (int i17 = 0; i16 != -1 && i17 < this.currentSize; i17++) {
            if (i17 == i3) {
                return this.mCache.mIndexedVariables[this.mArrayIndices[i16]];
            }
            i16 = this.mArrayNextIndices[i16];
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i3) {
        int i16 = this.mHead;
        for (int i17 = 0; i16 != -1 && i17 < this.currentSize; i17++) {
            if (i17 == i3) {
                return this.mArrayValues[i16];
            }
            i16 = this.mArrayNextIndices[i16];
        }
        return 0.0f;
    }

    boolean hasAtLeastOnePositiveVariable() {
        int i3 = this.mHead;
        for (int i16 = 0; i3 != -1 && i16 < this.currentSize; i16++) {
            if (this.mArrayValues[i3] > 0.0f) {
                return true;
            }
            i3 = this.mArrayNextIndices[i3];
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        int i3 = this.mHead;
        if (i3 == -1) {
            return -1;
        }
        for (int i16 = 0; i3 != -1 && i16 < this.currentSize; i16++) {
            if (this.mArrayIndices[i3] == solverVariable.f26465id) {
                return i3;
            }
            i3 = this.mArrayNextIndices[i3];
        }
        return -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void invert() {
        int i3 = this.mHead;
        for (int i16 = 0; i3 != -1 && i16 < this.currentSize; i16++) {
            float[] fArr = this.mArrayValues;
            fArr[i3] = fArr[i3] * (-1.0f);
            i3 = this.mArrayNextIndices[i3];
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable solverVariable, float f16) {
        if (f16 == 0.0f) {
            remove(solverVariable, true);
            return;
        }
        int i3 = this.mHead;
        if (i3 == -1) {
            this.mHead = 0;
            this.mArrayValues[0] = f16;
            this.mArrayIndices[0] = solverVariable.f26465id;
            this.mArrayNextIndices[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                int i16 = this.mLast + 1;
                this.mLast = i16;
                int[] iArr = this.mArrayIndices;
                if (i16 >= iArr.length) {
                    this.mDidFillOnce = true;
                    this.mLast = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i17 = -1;
        for (int i18 = 0; i3 != -1 && i18 < this.currentSize; i18++) {
            int i19 = this.mArrayIndices[i3];
            int i26 = solverVariable.f26465id;
            if (i19 == i26) {
                this.mArrayValues[i3] = f16;
                return;
            }
            if (i19 < i26) {
                i17 = i3;
            }
            i3 = this.mArrayNextIndices[i3];
        }
        int i27 = this.mLast;
        int i28 = i27 + 1;
        if (this.mDidFillOnce) {
            int[] iArr2 = this.mArrayIndices;
            if (iArr2[i27] != -1) {
                i27 = iArr2.length;
            }
        } else {
            i27 = i28;
        }
        int[] iArr3 = this.mArrayIndices;
        if (i27 >= iArr3.length && this.currentSize < iArr3.length) {
            int i29 = 0;
            while (true) {
                int[] iArr4 = this.mArrayIndices;
                if (i29 >= iArr4.length) {
                    break;
                }
                if (iArr4[i29] == -1) {
                    i27 = i29;
                    break;
                }
                i29++;
            }
        }
        int[] iArr5 = this.mArrayIndices;
        if (i27 >= iArr5.length) {
            i27 = iArr5.length;
            int i36 = this.ROW_SIZE * 2;
            this.ROW_SIZE = i36;
            this.mDidFillOnce = false;
            this.mLast = i27 - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, i36);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
        }
        this.mArrayIndices[i27] = solverVariable.f26465id;
        this.mArrayValues[i27] = f16;
        if (i17 != -1) {
            int[] iArr6 = this.mArrayNextIndices;
            iArr6[i27] = iArr6[i17];
            iArr6[i17] = i27;
        } else {
            this.mArrayNextIndices[i27] = this.mHead;
            this.mHead = i27;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.mRow);
        int i37 = this.currentSize + 1;
        this.currentSize = i37;
        if (!this.mDidFillOnce) {
            this.mLast++;
        }
        int[] iArr7 = this.mArrayIndices;
        if (i37 >= iArr7.length) {
            this.mDidFillOnce = true;
        }
        if (this.mLast >= iArr7.length) {
            this.mDidFillOnce = true;
            this.mLast = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable solverVariable, boolean z16) {
        if (this.candidate == solverVariable) {
            this.candidate = null;
        }
        int i3 = this.mHead;
        if (i3 == -1) {
            return 0.0f;
        }
        int i16 = 0;
        int i17 = -1;
        while (i3 != -1 && i16 < this.currentSize) {
            if (this.mArrayIndices[i3] == solverVariable.f26465id) {
                if (i3 == this.mHead) {
                    this.mHead = this.mArrayNextIndices[i3];
                } else {
                    int[] iArr = this.mArrayNextIndices;
                    iArr[i17] = iArr[i3];
                }
                if (z16) {
                    solverVariable.removeFromRow(this.mRow);
                }
                solverVariable.usageInRowCount--;
                this.currentSize--;
                this.mArrayIndices[i3] = -1;
                if (this.mDidFillOnce) {
                    this.mLast = i3;
                }
                return this.mArrayValues[i3];
            }
            i16++;
            i17 = i3;
            i3 = this.mArrayNextIndices[i3];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return (this.mArrayIndices.length * 4 * 3) + 0 + 36;
    }

    public String toString() {
        int i3 = this.mHead;
        String str = "";
        for (int i16 = 0; i3 != -1 && i16 < this.currentSize; i16++) {
            str = ((str + " -> ") + this.mArrayValues[i3] + ProgressTracer.SEPARATOR) + this.mCache.mIndexedVariables[this.mArrayIndices[i3]];
            i3 = this.mArrayNextIndices[i3];
        }
        return str;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z16) {
        float f16 = get(arrayRow.variable);
        remove(arrayRow.variable, z16);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i3 = 0; i3 < currentSize; i3++) {
            SolverVariable variable = arrayRowVariables.getVariable(i3);
            add(variable, arrayRowVariables.get(variable) * f16, z16);
        }
        return f16;
    }
}
