package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes.dex */
public class ArrayRow implements LinearSystem.Row {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    public ArrayRowVariables variables;
    SolverVariable variable = null;
    float constantValue = 0.0f;
    boolean used = false;
    ArrayList<SolverVariable> variablesToUpdate = new ArrayList<>();
    boolean isSimpleDefinition = false;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface ArrayRowVariables {
        void add(SolverVariable solverVariable, float f16, boolean z16);

        void clear();

        boolean contains(SolverVariable solverVariable);

        void display();

        void divideByAmount(float f16);

        float get(SolverVariable solverVariable);

        int getCurrentSize();

        SolverVariable getVariable(int i3);

        float getVariableValue(int i3);

        int indexOf(SolverVariable solverVariable);

        void invert();

        void put(SolverVariable solverVariable, float f16);

        float remove(SolverVariable solverVariable, boolean z16);

        int sizeInBytes();

        float use(ArrayRow arrayRow, boolean z16);
    }

    public ArrayRow() {
    }

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        if (solverVariable.usageInRowCount <= 1) {
            return true;
        }
        return false;
    }

    private SolverVariable pickPivotInVariables(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable2 = null;
        float f16 = 0.0f;
        for (int i3 = 0; i3 < currentSize; i3++) {
            float variableValue = this.variables.getVariableValue(i3);
            if (variableValue < 0.0f) {
                SolverVariable variable = this.variables.getVariable(i3);
                if ((zArr == null || !zArr[variable.f26465id]) && variable != solverVariable && (((type = variable.mType) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && variableValue < f16)) {
                    f16 = variableValue;
                    solverVariable2 = variable;
                }
            }
        }
        return solverVariable2;
    }

    public ArrayRow addError(LinearSystem linearSystem, int i3) {
        this.variables.put(linearSystem.createErrorVariable(i3, "ep"), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(i3, "em"), -1.0f);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayRow addSingleError(SolverVariable solverVariable, int i3) {
        this.variables.put(solverVariable, i3);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean chooseSubject(LinearSystem linearSystem) {
        boolean z16;
        SolverVariable chooseSubjectInVariables = chooseSubjectInVariables(linearSystem);
        if (chooseSubjectInVariables == null) {
            z16 = true;
        } else {
            pivot(chooseSubjectInVariables);
            z16 = false;
        }
        if (this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
        }
        return z16;
    }

    SolverVariable chooseSubjectInVariables(LinearSystem linearSystem) {
        boolean isNew;
        boolean isNew2;
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable = null;
        float f16 = 0.0f;
        float f17 = 0.0f;
        boolean z16 = false;
        boolean z17 = false;
        SolverVariable solverVariable2 = null;
        for (int i3 = 0; i3 < currentSize; i3++) {
            float variableValue = this.variables.getVariableValue(i3);
            SolverVariable variable = this.variables.getVariable(i3);
            if (variable.mType == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null) {
                    isNew2 = isNew(variable, linearSystem);
                } else if (f16 > variableValue) {
                    isNew2 = isNew(variable, linearSystem);
                } else if (!z16 && isNew(variable, linearSystem)) {
                    f16 = variableValue;
                    solverVariable = variable;
                    z16 = true;
                }
                z16 = isNew2;
                f16 = variableValue;
                solverVariable = variable;
            } else if (solverVariable == null && variableValue < 0.0f) {
                if (solverVariable2 == null) {
                    isNew = isNew(variable, linearSystem);
                } else if (f17 > variableValue) {
                    isNew = isNew(variable, linearSystem);
                } else if (!z17 && isNew(variable, linearSystem)) {
                    f17 = variableValue;
                    solverVariable2 = variable;
                    z17 = true;
                }
                z17 = isNew;
                f17 = variableValue;
                solverVariable2 = variable;
            }
        }
        if (solverVariable != null) {
            return solverVariable;
        }
        return solverVariable2;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        this.variables.clear();
        this.variable = null;
        this.constantValue = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayRow createRowCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, float f16, SolverVariable solverVariable3, SolverVariable solverVariable4, int i16) {
        if (solverVariable2 == solverVariable3) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable2, -2.0f);
            return this;
        }
        if (f16 == 0.5f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            if (i3 > 0 || i16 > 0) {
                this.constantValue = (-i3) + i16;
            }
        } else if (f16 <= 0.0f) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.constantValue = i3;
        } else if (f16 >= 1.0f) {
            this.variables.put(solverVariable4, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
            this.constantValue = -i16;
        } else {
            float f17 = 1.0f - f16;
            this.variables.put(solverVariable, f17 * 1.0f);
            this.variables.put(solverVariable2, f17 * (-1.0f));
            this.variables.put(solverVariable3, (-1.0f) * f16);
            this.variables.put(solverVariable4, 1.0f * f16);
            if (i3 > 0 || i16 > 0) {
                this.constantValue = ((-i3) * f17) + (i16 * f16);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayRow createRowDefinition(SolverVariable solverVariable, int i3) {
        this.variable = solverVariable;
        float f16 = i3;
        solverVariable.computedValue = f16;
        this.constantValue = f16;
        this.isSimpleDefinition = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayRow createRowDimensionPercent(SolverVariable solverVariable, SolverVariable solverVariable2, float f16) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, f16);
        return this;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f16) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, f16);
        this.variables.put(solverVariable4, -f16);
        return this;
    }

    public ArrayRow createRowEqualDimension(float f16, float f17, float f18, SolverVariable solverVariable, int i3, SolverVariable solverVariable2, int i16, SolverVariable solverVariable3, int i17, SolverVariable solverVariable4, int i18) {
        if (f17 != 0.0f && f16 != f18) {
            float f19 = (f16 / f17) / (f18 / f17);
            this.constantValue = ((-i3) - i16) + (i17 * f19) + (i18 * f19);
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, f19);
            this.variables.put(solverVariable3, -f19);
        } else {
            this.constantValue = ((-i3) - i16) + i17 + i18;
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowEqualMatchDimensions(float f16, float f17, float f18, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.constantValue = 0.0f;
        if (f17 != 0.0f && f16 != f18) {
            if (f16 == 0.0f) {
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
            } else if (f18 == 0.0f) {
                this.variables.put(solverVariable3, 1.0f);
                this.variables.put(solverVariable4, -1.0f);
            } else {
                float f19 = (f16 / f17) / (f18 / f17);
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
                this.variables.put(solverVariable4, f19);
                this.variables.put(solverVariable3, -f19);
            }
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int i3) {
        if (i3 < 0) {
            this.constantValue = i3 * (-1);
            this.variables.put(solverVariable, 1.0f);
        } else {
            this.constantValue = i3;
            this.variables.put(solverVariable, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i3) {
        boolean z16 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z16 = true;
            }
            this.constantValue = i3;
        }
        if (!z16) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i3) {
        boolean z16 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z16 = true;
            }
            this.constantValue = i3;
        }
        if (!z16) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
        }
        return this;
    }

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f16) {
        this.variables.put(solverVariable3, 0.5f);
        this.variables.put(solverVariable4, 0.5f);
        this.variables.put(solverVariable, -0.5f);
        this.variables.put(solverVariable2, -0.5f);
        this.constantValue = -f16;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ensurePositiveConstant() {
        float f16 = this.constantValue;
        if (f16 < 0.0f) {
            this.constantValue = f16 * (-1.0f);
            this.variables.invert();
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getKey() {
        return this.variable;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        return pickPivotInVariables(zArr, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasKeyVariable() {
        SolverVariable solverVariable = this.variable;
        if (solverVariable != null && (solverVariable.mType == SolverVariable.Type.UNRESTRICTED || this.constantValue >= 0.0f)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasVariable(SolverVariable solverVariable) {
        return this.variables.contains(solverVariable);
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void initFromRow(LinearSystem.Row row) {
        if (row instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.variable = null;
            this.variables.clear();
            for (int i3 = 0; i3 < arrayRow.variables.getCurrentSize(); i3++) {
                this.variables.add(arrayRow.variables.getVariable(i3), arrayRow.variables.getVariableValue(i3), true);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public boolean isEmpty() {
        if (this.variable == null && this.constantValue == 0.0f && this.variables.getCurrentSize() == 0) {
            return true;
        }
        return false;
    }

    public SolverVariable pickPivot(SolverVariable solverVariable) {
        return pickPivotInVariables(null, solverVariable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pivot(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.variable;
        if (solverVariable2 != null) {
            this.variables.put(solverVariable2, -1.0f);
            this.variable.definitionId = -1;
            this.variable = null;
        }
        float remove = this.variables.remove(solverVariable, true) * (-1.0f);
        this.variable = solverVariable;
        if (remove == 1.0f) {
            return;
        }
        this.constantValue /= remove;
        this.variables.divideByAmount(remove);
    }

    public void reset() {
        this.variable = null;
        this.variables.clear();
        this.constantValue = 0.0f;
        this.isSimpleDefinition = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int sizeInBytes() {
        int i3;
        if (this.variable != null) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        return i3 + 4 + 4 + this.variables.sizeInBytes();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toReadableString() {
        String str;
        boolean z16;
        if (this.variable == null) {
            str = "0";
        } else {
            str = "" + this.variable;
        }
        String str2 = str + " = ";
        if (this.constantValue != 0.0f) {
            str2 = str2 + this.constantValue;
            z16 = true;
        } else {
            z16 = false;
        }
        int currentSize = this.variables.getCurrentSize();
        for (int i3 = 0; i3 < currentSize; i3++) {
            SolverVariable variable = this.variables.getVariable(i3);
            if (variable != null) {
                float variableValue = this.variables.getVariableValue(i3);
                if (variableValue != 0.0f) {
                    String solverVariable = variable.toString();
                    if (!z16) {
                        if (variableValue < 0.0f) {
                            str2 = str2 + "- ";
                            variableValue *= -1.0f;
                        }
                        if (variableValue == 1.0f) {
                            str2 = str2 + solverVariable;
                        } else {
                            str2 = str2 + variableValue + " " + solverVariable;
                        }
                        z16 = true;
                    } else if (variableValue > 0.0f) {
                        str2 = str2 + " + ";
                        if (variableValue == 1.0f) {
                        }
                        z16 = true;
                    } else {
                        str2 = str2 + " - ";
                        variableValue *= -1.0f;
                        if (variableValue == 1.0f) {
                        }
                        z16 = true;
                    }
                }
            }
        }
        if (!z16) {
            return str2 + "0.0";
        }
        return str2;
    }

    public String toString() {
        return toReadableString();
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z16) {
        if (!solverVariable.isFinalValue) {
            return;
        }
        this.constantValue += solverVariable.computedValue * this.variables.get(solverVariable);
        this.variables.remove(solverVariable, z16);
        if (z16) {
            solverVariable.removeFromRow(this);
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z16) {
        this.constantValue += arrayRow.constantValue * this.variables.use(arrayRow, z16);
        if (z16) {
            arrayRow.variable.removeFromRow(this);
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.variable != null && this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    public void updateFromSynonymVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z16) {
        if (!solverVariable.isSynonym) {
            return;
        }
        float f16 = this.variables.get(solverVariable);
        this.constantValue += solverVariable.synonymDelta * f16;
        this.variables.remove(solverVariable, z16);
        if (z16) {
            solverVariable.removeFromRow(this);
        }
        this.variables.add(linearSystem.mCache.mIndexedVariables[solverVariable.synonym], f16, z16);
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromSystem(LinearSystem linearSystem) {
        if (linearSystem.mRows.length == 0) {
            return;
        }
        boolean z16 = false;
        while (!z16) {
            int currentSize = this.variables.getCurrentSize();
            for (int i3 = 0; i3 < currentSize; i3++) {
                SolverVariable variable = this.variables.getVariable(i3);
                if (variable.definitionId != -1 || variable.isFinalValue || variable.isSynonym) {
                    this.variablesToUpdate.add(variable);
                }
            }
            int size = this.variablesToUpdate.size();
            if (size > 0) {
                for (int i16 = 0; i16 < size; i16++) {
                    SolverVariable solverVariable = this.variablesToUpdate.get(i16);
                    if (solverVariable.isFinalValue) {
                        updateFromFinalVariable(linearSystem, solverVariable, true);
                    } else if (solverVariable.isSynonym) {
                        updateFromSynonymVariable(linearSystem, solverVariable, true);
                    } else {
                        updateFromRow(linearSystem, linearSystem.mRows[solverVariable.definitionId], true);
                    }
                }
                this.variablesToUpdate.clear();
            } else {
                z16 = true;
            }
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.variable != null && this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        int i3 = solverVariable.strength;
        float f16 = 1.0f;
        if (i3 != 1) {
            if (i3 == 2) {
                f16 = 1000.0f;
            } else if (i3 == 3) {
                f16 = 1000000.0f;
            } else if (i3 == 4) {
                f16 = 1.0E9f;
            } else if (i3 == 5) {
                f16 = 1.0E12f;
            }
        }
        this.variables.put(solverVariable, f16);
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int i3) {
        boolean z16 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z16 = true;
            }
            this.constantValue = i3;
        }
        if (!z16) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
        }
        return this;
    }

    public ArrayRow(Cache cache) {
        this.variables = new ArrayLinkedVariables(this, cache);
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, int i3, SolverVariable solverVariable2) {
        this.constantValue = i3;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }
}
