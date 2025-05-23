package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float epsilon = 0.001f;
    protected final Cache mCache;
    private final ArrayRow mRow;
    private final int NONE = -1;
    private int SIZE = 16;
    private int HASH_SIZE = 16;
    int[] keys = new int[16];
    int[] nextKeys = new int[16];
    int[] variables = new int[16];
    float[] values = new float[16];
    int[] previous = new int[16];
    int[] next = new int[16];
    int mCount = 0;
    int head = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    private void addToHashMap(SolverVariable solverVariable, int i3) {
        int[] iArr;
        int i16 = solverVariable.f26465id % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i17 = iArr2[i16];
        if (i17 == -1) {
            iArr2[i16] = i3;
        } else {
            while (true) {
                iArr = this.nextKeys;
                int i18 = iArr[i17];
                if (i18 == -1) {
                    break;
                } else {
                    i17 = i18;
                }
            }
            iArr[i17] = i3;
        }
        this.nextKeys[i3] = -1;
    }

    private void addVariable(int i3, SolverVariable solverVariable, float f16) {
        this.variables[i3] = solverVariable.f26465id;
        this.values[i3] = f16;
        this.previous[i3] = -1;
        this.next[i3] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        for (int i3 = 0; i3 < this.HASH_SIZE; i3++) {
            if (this.keys[i3] != -1) {
                String str = hashCode() + " hash [" + i3 + "] => ";
                int i16 = this.keys[i3];
                boolean z16 = false;
                while (!z16) {
                    str = str + " " + this.variables[i16];
                    int i17 = this.nextKeys[i16];
                    if (i17 != -1) {
                        i16 = i17;
                    } else {
                        z16 = true;
                    }
                }
                System.out.println(str);
            }
        }
    }

    private int findEmptySlot() {
        for (int i3 = 0; i3 < this.SIZE; i3++) {
            if (this.variables[i3] == -1) {
                return i3;
            }
        }
        return -1;
    }

    private void increaseSize() {
        int i3 = this.SIZE * 2;
        this.variables = Arrays.copyOf(this.variables, i3);
        this.values = Arrays.copyOf(this.values, i3);
        this.previous = Arrays.copyOf(this.previous, i3);
        this.next = Arrays.copyOf(this.next, i3);
        this.nextKeys = Arrays.copyOf(this.nextKeys, i3);
        for (int i16 = this.SIZE; i16 < i3; i16++) {
            this.variables[i16] = -1;
            this.nextKeys[i16] = -1;
        }
        this.SIZE = i3;
    }

    private void insertVariable(int i3, SolverVariable solverVariable, float f16) {
        int findEmptySlot = findEmptySlot();
        addVariable(findEmptySlot, solverVariable, f16);
        if (i3 != -1) {
            this.previous[findEmptySlot] = i3;
            int[] iArr = this.next;
            iArr[findEmptySlot] = iArr[i3];
            iArr[i3] = findEmptySlot;
        } else {
            this.previous[findEmptySlot] = -1;
            if (this.mCount > 0) {
                this.next[findEmptySlot] = this.head;
                this.head = findEmptySlot;
            } else {
                this.next[findEmptySlot] = -1;
            }
        }
        int i16 = this.next[findEmptySlot];
        if (i16 != -1) {
            this.previous[i16] = findEmptySlot;
        }
        addToHashMap(solverVariable, findEmptySlot);
    }

    private void removeFromHashMap(SolverVariable solverVariable) {
        int[] iArr;
        int i3;
        int i16 = solverVariable.f26465id;
        int i17 = i16 % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i18 = iArr2[i17];
        if (i18 == -1) {
            return;
        }
        if (this.variables[i18] == i16) {
            int[] iArr3 = this.nextKeys;
            iArr2[i17] = iArr3[i18];
            iArr3[i18] = -1;
            return;
        }
        while (true) {
            iArr = this.nextKeys;
            i3 = iArr[i18];
            if (i3 == -1 || this.variables[i3] == i16) {
                break;
            } else {
                i18 = i3;
            }
        }
        if (i3 != -1 && this.variables[i3] == i16) {
            iArr[i18] = iArr[i3];
            iArr[i3] = -1;
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f16, boolean z16) {
        float f17 = epsilon;
        if (f16 > (-f17) && f16 < f17) {
            return;
        }
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            put(solverVariable, f16);
            return;
        }
        float[] fArr = this.values;
        float f18 = fArr[indexOf] + f16;
        fArr[indexOf] = f18;
        float f19 = epsilon;
        if (f18 > (-f19) && f18 < f19) {
            fArr[indexOf] = 0.0f;
            remove(solverVariable, z16);
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void clear() {
        int i3 = this.mCount;
        for (int i16 = 0; i16 < i3; i16++) {
            SolverVariable variable = getVariable(i16);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i17 = 0; i17 < this.SIZE; i17++) {
            this.variables[i17] = -1;
            this.nextKeys[i17] = -1;
        }
        for (int i18 = 0; i18 < this.HASH_SIZE; i18++) {
            this.keys[i18] = -1;
        }
        this.mCount = 0;
        this.head = -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        if (indexOf(solverVariable) != -1) {
            return true;
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void display() {
        int i3 = this.mCount;
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
        int i3 = this.mCount;
        int i16 = this.head;
        for (int i17 = 0; i17 < i3; i17++) {
            float[] fArr = this.values;
            fArr[i16] = fArr[i16] / f16;
            i16 = this.next[i16];
            if (i16 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float get(SolverVariable solverVariable) {
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            return this.values[indexOf];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCount;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i3) {
        int i16 = this.mCount;
        if (i16 == 0) {
            return null;
        }
        int i17 = this.head;
        for (int i18 = 0; i18 < i16; i18++) {
            if (i18 == i3 && i17 != -1) {
                return this.mCache.mIndexedVariables[this.variables[i17]];
            }
            i17 = this.next[i17];
            if (i17 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i3) {
        int i16 = this.mCount;
        int i17 = this.head;
        for (int i18 = 0; i18 < i16; i18++) {
            if (i18 == i3) {
                return this.values[i17];
            }
            i17 = this.next[i17];
            if (i17 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        if (this.mCount != 0 && solverVariable != null) {
            int i3 = solverVariable.f26465id;
            int i16 = this.keys[i3 % this.HASH_SIZE];
            if (i16 == -1) {
                return -1;
            }
            if (this.variables[i16] == i3) {
                return i16;
            }
            do {
                i16 = this.nextKeys[i16];
                if (i16 == -1) {
                    break;
                }
            } while (this.variables[i16] != i3);
            if (i16 != -1 && this.variables[i16] == i3) {
                return i16;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void invert() {
        int i3 = this.mCount;
        int i16 = this.head;
        for (int i17 = 0; i17 < i3; i17++) {
            float[] fArr = this.values;
            fArr[i16] = fArr[i16] * (-1.0f);
            i16 = this.next[i16];
            if (i16 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void put(SolverVariable solverVariable, float f16) {
        float f17 = epsilon;
        if (f16 > (-f17) && f16 < f17) {
            remove(solverVariable, true);
            return;
        }
        if (this.mCount == 0) {
            addVariable(0, solverVariable, f16);
            addToHashMap(solverVariable, 0);
            this.head = 0;
            return;
        }
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            this.values[indexOf] = f16;
            return;
        }
        if (this.mCount + 1 >= this.SIZE) {
            increaseSize();
        }
        int i3 = this.mCount;
        int i16 = this.head;
        int i17 = -1;
        for (int i18 = 0; i18 < i3; i18++) {
            int i19 = this.variables[i16];
            int i26 = solverVariable.f26465id;
            if (i19 == i26) {
                this.values[i16] = f16;
                return;
            }
            if (i19 < i26) {
                i17 = i16;
            }
            i16 = this.next[i16];
            if (i16 == -1) {
                break;
            }
        }
        insertVariable(i17, solverVariable, f16);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable solverVariable, boolean z16) {
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f16 = this.values[indexOf];
        if (this.head == indexOf) {
            this.head = this.next[indexOf];
        }
        this.variables[indexOf] = -1;
        int[] iArr = this.previous;
        int i3 = iArr[indexOf];
        if (i3 != -1) {
            int[] iArr2 = this.next;
            iArr2[i3] = iArr2[indexOf];
        }
        int i16 = this.next[indexOf];
        if (i16 != -1) {
            iArr[i16] = iArr[indexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z16) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f16;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i3 = this.mCount;
        for (int i16 = 0; i16 < i3; i16++) {
            SolverVariable variable = getVariable(i16);
            if (variable != null) {
                String str4 = str3 + variable + " = " + getVariableValue(i16) + " ";
                int indexOf = indexOf(variable);
                String str5 = str4 + "[p: ";
                if (this.previous[indexOf] != -1) {
                    str = str5 + this.mCache.mIndexedVariables[this.variables[this.previous[indexOf]]];
                } else {
                    str = str5 + "none";
                }
                String str6 = str + ", n: ";
                if (this.next[indexOf] != -1) {
                    str2 = str6 + this.mCache.mIndexedVariables[this.variables[this.next[indexOf]]];
                } else {
                    str2 = str6 + "none";
                }
                str3 = str2 + "]";
            }
        }
        return str3 + " }";
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z16) {
        float f16 = get(arrayRow.variable);
        remove(arrayRow.variable, z16);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i3 = 0;
        int i16 = 0;
        while (i3 < currentSize) {
            int i17 = solverVariableValues.variables[i16];
            if (i17 != -1) {
                add(this.mCache.mIndexedVariables[i17], solverVariableValues.values[i16] * f16, z16);
                i3++;
            }
            i16++;
        }
        return f16;
    }
}
