package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes.dex */
public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    static final int NOT_FOUND = -1;
    private static final float epsilon = 1.0E-4f;
    private int TABLE_SIZE;
    GoalVariableAccessor accessor;
    private SolverVariable[] arrayGoals;
    Cache mCache;
    private int numGoals;
    private SolverVariable[] sortArray;

    /* loaded from: classes.dex */
    class GoalVariableAccessor implements Comparable {
        PriorityGoalRow row;
        SolverVariable variable;

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.row = priorityGoalRow;
        }

        public void add(SolverVariable solverVariable) {
            for (int i3 = 0; i3 < 9; i3++) {
                float[] fArr = this.variable.goalStrengthVector;
                float f16 = fArr[i3] + solverVariable.goalStrengthVector[i3];
                fArr[i3] = f16;
                if (Math.abs(f16) < 1.0E-4f) {
                    this.variable.goalStrengthVector[i3] = 0.0f;
                }
            }
        }

        public boolean addToGoal(SolverVariable solverVariable, float f16) {
            boolean z16 = true;
            if (this.variable.inGoal) {
                for (int i3 = 0; i3 < 9; i3++) {
                    float[] fArr = this.variable.goalStrengthVector;
                    float f17 = fArr[i3] + (solverVariable.goalStrengthVector[i3] * f16);
                    fArr[i3] = f17;
                    if (Math.abs(f17) < 1.0E-4f) {
                        this.variable.goalStrengthVector[i3] = 0.0f;
                    } else {
                        z16 = false;
                    }
                }
                if (z16) {
                    PriorityGoalRow.this.removeGoal(this.variable);
                }
                return false;
            }
            for (int i16 = 0; i16 < 9; i16++) {
                float f18 = solverVariable.goalStrengthVector[i16];
                if (f18 != 0.0f) {
                    float f19 = f18 * f16;
                    if (Math.abs(f19) < 1.0E-4f) {
                        f19 = 0.0f;
                    }
                    this.variable.goalStrengthVector[i16] = f19;
                } else {
                    this.variable.goalStrengthVector[i16] = 0.0f;
                }
            }
            return true;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.variable.f26465id - ((SolverVariable) obj).f26465id;
        }

        public void init(SolverVariable solverVariable) {
            this.variable = solverVariable;
        }

        public final boolean isNegative() {
            for (int i3 = 8; i3 >= 0; i3--) {
                float f16 = this.variable.goalStrengthVector[i3];
                if (f16 > 0.0f) {
                    return false;
                }
                if (f16 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isNull() {
            for (int i3 = 0; i3 < 9; i3++) {
                if (this.variable.goalStrengthVector[i3] != 0.0f) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isSmallerThan(SolverVariable solverVariable) {
            int i3 = 8;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                float f16 = solverVariable.goalStrengthVector[i3];
                float f17 = this.variable.goalStrengthVector[i3];
                if (f17 == f16) {
                    i3--;
                } else if (f17 < f16) {
                    return true;
                }
            }
            return false;
        }

        public void reset() {
            Arrays.fill(this.variable.goalStrengthVector, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.variable != null) {
                for (int i3 = 0; i3 < 9; i3++) {
                    str = str + this.variable.goalStrengthVector[i3] + " ";
                }
            }
            return str + "] " + this.variable;
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.TABLE_SIZE = 128;
        this.arrayGoals = new SolverVariable[128];
        this.sortArray = new SolverVariable[128];
        this.numGoals = 0;
        this.accessor = new GoalVariableAccessor(this);
        this.mCache = cache;
    }

    private final void addToGoal(SolverVariable solverVariable) {
        int i3;
        int i16 = this.numGoals + 1;
        SolverVariable[] solverVariableArr = this.arrayGoals;
        if (i16 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.arrayGoals = solverVariableArr2;
            this.sortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.arrayGoals;
        int i17 = this.numGoals;
        solverVariableArr3[i17] = solverVariable;
        int i18 = i17 + 1;
        this.numGoals = i18;
        if (i18 > 1 && solverVariableArr3[i18 - 1].f26465id > solverVariable.f26465id) {
            int i19 = 0;
            while (true) {
                i3 = this.numGoals;
                if (i19 >= i3) {
                    break;
                }
                this.sortArray[i19] = this.arrayGoals[i19];
                i19++;
            }
            Arrays.sort(this.sortArray, 0, i3, new Comparator<SolverVariable>() { // from class: androidx.constraintlayout.solver.PriorityGoalRow.1
                @Override // java.util.Comparator
                public int compare(SolverVariable solverVariable2, SolverVariable solverVariable3) {
                    return solverVariable2.f26465id - solverVariable3.f26465id;
                }
            });
            for (int i26 = 0; i26 < this.numGoals; i26++) {
                this.arrayGoals[i26] = this.sortArray[i26];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeGoal(SolverVariable solverVariable) {
        int i3 = 0;
        while (i3 < this.numGoals) {
            if (this.arrayGoals[i3] == solverVariable) {
                while (true) {
                    int i16 = this.numGoals;
                    if (i3 < i16 - 1) {
                        SolverVariable[] solverVariableArr = this.arrayGoals;
                        int i17 = i3 + 1;
                        solverVariableArr[i3] = solverVariableArr[i17];
                        i3 = i17;
                    } else {
                        this.numGoals = i16 - 1;
                        solverVariable.inGoal = false;
                        return;
                    }
                }
            } else {
                i3++;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        this.accessor.init(solverVariable);
        this.accessor.reset();
        solverVariable.goalStrengthVector[solverVariable.strength] = 1.0f;
        addToGoal(solverVariable);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        this.numGoals = 0;
        this.constantValue = 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        int i3 = -1;
        for (int i16 = 0; i16 < this.numGoals; i16++) {
            SolverVariable solverVariable = this.arrayGoals[i16];
            if (!zArr[solverVariable.f26465id]) {
                this.accessor.init(solverVariable);
                if (i3 == -1) {
                    if (!this.accessor.isNegative()) {
                    }
                    i3 = i16;
                } else {
                    if (!this.accessor.isSmallerThan(this.arrayGoals[i3])) {
                    }
                    i3 = i16;
                }
            }
        }
        if (i3 == -1) {
            return null;
        }
        return this.arrayGoals[i3];
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public boolean isEmpty() {
        if (this.numGoals == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow
    public String toString() {
        String str = " goal -> (" + this.constantValue + ") : ";
        for (int i3 = 0; i3 < this.numGoals; i3++) {
            this.accessor.init(this.arrayGoals[i3]);
            str = str + this.accessor + " ";
        }
        return str;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z16) {
        SolverVariable solverVariable = arrayRow.variable;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i3 = 0; i3 < currentSize; i3++) {
            SolverVariable variable = arrayRowVariables.getVariable(i3);
            float variableValue = arrayRowVariables.getVariableValue(i3);
            this.accessor.init(variable);
            if (this.accessor.addToGoal(solverVariable, variableValue)) {
                addToGoal(variable);
            }
            this.constantValue += arrayRow.constantValue * variableValue;
        }
        removeGoal(solverVariable);
    }
}
