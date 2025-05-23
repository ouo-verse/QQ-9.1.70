package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes.dex */
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    private static int POOL_SIZE = 1000;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    final Cache mCache;
    private Row mGoal;
    ArrayRow[] mRows;
    private Row mTempGoal;
    public boolean hasSimpleDefinition = false;
    int mVariablesID = 0;
    private HashMap<String, SolverVariable> mVariables = null;
    private int TABLE_SIZE = 32;
    private int mMaxColumns = 32;
    public boolean graphOptimizer = false;
    public boolean newgraphOptimizer = false;
    private boolean[] mAlreadyTestedCandidates = new boolean[32];
    int mNumColumns = 1;
    int mNumRows = 0;
    private int mMaxRows = 32;
    private SolverVariable[] mPoolVariables = new SolverVariable[POOL_SIZE];
    private int mPoolVariablesCount = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z16);

        void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z16);

        void updateFromSystem(LinearSystem linearSystem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class ValuesRow extends ArrayRow {
        public ValuesRow(Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        this.mRows = null;
        this.mRows = new ArrayRow[32];
        releaseRows();
        Cache cache = new Cache();
        this.mCache = cache;
        this.mGoal = new PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(cache);
        } else {
            this.mTempGoal = new ArrayRow(cache);
        }
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        SolverVariable acquire = this.mCache.solverVariablePool.acquire();
        if (acquire == null) {
            acquire = new SolverVariable(type, str);
            acquire.setType(type, str);
        } else {
            acquire.reset();
            acquire.setType(type, str);
        }
        int i3 = this.mPoolVariablesCount;
        int i16 = POOL_SIZE;
        if (i3 >= i16) {
            int i17 = i16 * 2;
            POOL_SIZE = i17;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, i17);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i18 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i18 + 1;
        solverVariableArr[i18] = acquire;
        return acquire;
    }

    private void addError(ArrayRow arrayRow) {
        arrayRow.addError(this, 0);
    }

    private final void addRow(ArrayRow arrayRow) {
        int i3;
        if (SIMPLIFY_SYNONYMS && arrayRow.isSimpleDefinition) {
            arrayRow.variable.setFinalValue(this, arrayRow.constantValue);
        } else {
            ArrayRow[] arrayRowArr = this.mRows;
            int i16 = this.mNumRows;
            arrayRowArr[i16] = arrayRow;
            SolverVariable solverVariable = arrayRow.variable;
            solverVariable.definitionId = i16;
            this.mNumRows = i16 + 1;
            solverVariable.updateReferencesWithNewDefinition(this, arrayRow);
        }
        if (SIMPLIFY_SYNONYMS && this.hasSimpleDefinition) {
            int i17 = 0;
            while (i17 < this.mNumRows) {
                if (this.mRows[i17] == null) {
                    System.out.println("WTF");
                }
                ArrayRow arrayRow2 = this.mRows[i17];
                if (arrayRow2 != null && arrayRow2.isSimpleDefinition) {
                    arrayRow2.variable.setFinalValue(this, arrayRow2.constantValue);
                    if (OPTIMIZED_ENGINE) {
                        this.mCache.optimizedArrayRowPool.release(arrayRow2);
                    } else {
                        this.mCache.arrayRowPool.release(arrayRow2);
                    }
                    this.mRows[i17] = null;
                    int i18 = i17 + 1;
                    int i19 = i18;
                    while (true) {
                        i3 = this.mNumRows;
                        if (i18 >= i3) {
                            break;
                        }
                        ArrayRow[] arrayRowArr2 = this.mRows;
                        int i26 = i18 - 1;
                        ArrayRow arrayRow3 = arrayRowArr2[i18];
                        arrayRowArr2[i26] = arrayRow3;
                        SolverVariable solverVariable2 = arrayRow3.variable;
                        if (solverVariable2.definitionId == i18) {
                            solverVariable2.definitionId = i26;
                        }
                        i19 = i18;
                        i18++;
                    }
                    if (i19 < i3) {
                        this.mRows[i19] = null;
                    }
                    this.mNumRows = i3 - 1;
                    i17--;
                }
                i17++;
            }
            this.hasSimpleDefinition = false;
        }
    }

    private void addSingleError(ArrayRow arrayRow, int i3) {
        addSingleError(arrayRow, i3, 0);
    }

    private void computeValues() {
        for (int i3 = 0; i3 < this.mNumRows; i3++) {
            ArrayRow arrayRow = this.mRows[i3];
            arrayRow.variable.computedValue = arrayRow.constantValue;
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f16) {
        return linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f16);
    }

    private SolverVariable createVariable(String str, SolverVariable.Type type) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.variables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(type, null);
        acquireSolverVariable.setName(str);
        int i3 = this.mVariablesID + 1;
        this.mVariablesID = i3;
        this.mNumColumns++;
        acquireSolverVariable.f26465id = i3;
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        this.mVariables.put(str, acquireSolverVariable);
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    private void displayRows() {
        displaySolverVariables();
        String str = "";
        for (int i3 = 0; i3 < this.mNumRows; i3++) {
            str = (str + this.mRows[i3]) + "\n";
        }
        System.out.println(str + this.mGoal + "\n");
    }

    private void displaySolverVariables() {
        System.out.println("Display Rows (" + this.mNumRows + HippyTKDListViewAdapter.X + this.mNumColumns + ")\n");
    }

    private int enforceBFS(Row row) throws Exception {
        boolean z16;
        int i3 = 0;
        while (true) {
            if (i3 < this.mNumRows) {
                ArrayRow arrayRow = this.mRows[i3];
                if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && arrayRow.constantValue < 0.0f) {
                    z16 = true;
                    break;
                }
                i3++;
            } else {
                z16 = false;
                break;
            }
        }
        if (z16) {
            boolean z17 = false;
            int i16 = 0;
            while (!z17) {
                Metrics metrics = sMetrics;
                if (metrics != null) {
                    metrics.bfs++;
                }
                i16++;
                float f16 = Float.MAX_VALUE;
                int i17 = -1;
                int i18 = -1;
                int i19 = 0;
                for (int i26 = 0; i26 < this.mNumRows; i26++) {
                    ArrayRow arrayRow2 = this.mRows[i26];
                    if (arrayRow2.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow2.isSimpleDefinition && arrayRow2.constantValue < 0.0f) {
                        int i27 = 9;
                        if (SKIP_COLUMNS) {
                            int currentSize = arrayRow2.variables.getCurrentSize();
                            int i28 = 0;
                            while (i28 < currentSize) {
                                SolverVariable variable = arrayRow2.variables.getVariable(i28);
                                float f17 = arrayRow2.variables.get(variable);
                                if (f17 > 0.0f) {
                                    int i29 = 0;
                                    while (i29 < i27) {
                                        float f18 = variable.strengthVector[i29] / f17;
                                        if ((f18 < f16 && i29 == i19) || i29 > i19) {
                                            i18 = variable.f26465id;
                                            i19 = i29;
                                            i17 = i26;
                                            f16 = f18;
                                        }
                                        i29++;
                                        i27 = 9;
                                    }
                                }
                                i28++;
                                i27 = 9;
                            }
                        } else {
                            for (int i36 = 1; i36 < this.mNumColumns; i36++) {
                                SolverVariable solverVariable = this.mCache.mIndexedVariables[i36];
                                float f19 = arrayRow2.variables.get(solverVariable);
                                if (f19 > 0.0f) {
                                    for (int i37 = 0; i37 < 9; i37++) {
                                        float f26 = solverVariable.strengthVector[i37] / f19;
                                        if ((f26 < f16 && i37 == i19) || i37 > i19) {
                                            i18 = i36;
                                            i19 = i37;
                                            i17 = i26;
                                            f16 = f26;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (i17 != -1) {
                    ArrayRow arrayRow3 = this.mRows[i17];
                    arrayRow3.variable.definitionId = -1;
                    Metrics metrics2 = sMetrics;
                    if (metrics2 != null) {
                        metrics2.pivots++;
                    }
                    arrayRow3.pivot(this.mCache.mIndexedVariables[i18]);
                    SolverVariable solverVariable2 = arrayRow3.variable;
                    solverVariable2.definitionId = i17;
                    solverVariable2.updateReferencesWithNewDefinition(this, arrayRow3);
                } else {
                    z17 = true;
                }
                if (i16 > this.mNumColumns / 2) {
                    z17 = true;
                }
            }
            return i16;
        }
        return 0;
    }

    private String getDisplaySize(int i3) {
        int i16 = i3 * 4;
        int i17 = i16 / 1024;
        int i18 = i17 / 1024;
        if (i18 > 0) {
            return "" + i18 + " Mb";
        }
        if (i17 > 0) {
            return "" + i17 + " Kb";
        }
        return "" + i16 + " bytes";
    }

    private String getDisplayStrength(int i3) {
        if (i3 == 1) {
            return "LOW";
        }
        if (i3 == 2) {
            return "MEDIUM";
        }
        if (i3 == 3) {
            return "HIGH";
        }
        if (i3 == 4) {
            return "HIGHEST";
        }
        if (i3 == 5) {
            return "EQUALITY";
        }
        if (i3 == 8) {
            return "FIXED";
        }
        if (i3 == 6) {
            return "BARRIER";
        }
        return "NONE";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int i3 = this.TABLE_SIZE * 2;
        this.TABLE_SIZE = i3;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, i3);
        Cache cache = this.mCache;
        cache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(cache.mIndexedVariables, this.TABLE_SIZE);
        int i16 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[i16];
        this.mMaxColumns = i16;
        this.mMaxRows = i16;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            metrics.maxTableSize = Math.max(metrics.maxTableSize, i16);
            Metrics metrics2 = sMetrics;
            metrics2.lastTableSize = metrics2.maxTableSize;
        }
    }

    private final int optimize(Row row, boolean z16) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        for (int i3 = 0; i3 < this.mNumColumns; i3++) {
            this.mAlreadyTestedCandidates[i3] = false;
        }
        boolean z17 = false;
        int i16 = 0;
        while (!z17) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            i16++;
            if (i16 >= this.mNumColumns * 2) {
                return i16;
            }
            if (row.getKey() != null) {
                this.mAlreadyTestedCandidates[row.getKey().f26465id] = true;
            }
            SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
            if (pivotCandidate != null) {
                boolean[] zArr = this.mAlreadyTestedCandidates;
                int i17 = pivotCandidate.f26465id;
                if (zArr[i17]) {
                    return i16;
                }
                zArr[i17] = true;
            }
            if (pivotCandidate != null) {
                float f16 = Float.MAX_VALUE;
                int i18 = -1;
                for (int i19 = 0; i19 < this.mNumRows; i19++) {
                    ArrayRow arrayRow = this.mRows[i19];
                    if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.hasVariable(pivotCandidate)) {
                        float f17 = arrayRow.variables.get(pivotCandidate);
                        if (f17 < 0.0f) {
                            float f18 = (-arrayRow.constantValue) / f17;
                            if (f18 < f16) {
                                i18 = i19;
                                f16 = f18;
                            }
                        }
                    }
                }
                if (i18 > -1) {
                    ArrayRow arrayRow2 = this.mRows[i18];
                    arrayRow2.variable.definitionId = -1;
                    Metrics metrics3 = sMetrics;
                    if (metrics3 != null) {
                        metrics3.pivots++;
                    }
                    arrayRow2.pivot(pivotCandidate);
                    SolverVariable solverVariable = arrayRow2.variable;
                    solverVariable.definitionId = i18;
                    solverVariable.updateReferencesWithNewDefinition(this, arrayRow2);
                }
            } else {
                z17 = true;
            }
        }
        return i16;
    }

    private void releaseRows() {
        int i3 = 0;
        if (OPTIMIZED_ENGINE) {
            while (i3 < this.mNumRows) {
                ArrayRow arrayRow = this.mRows[i3];
                if (arrayRow != null) {
                    this.mCache.optimizedArrayRowPool.release(arrayRow);
                }
                this.mRows[i3] = null;
                i3++;
            }
            return;
        }
        while (i3 < this.mNumRows) {
            ArrayRow arrayRow2 = this.mRows[i3];
            if (arrayRow2 != null) {
                this.mCache.arrayRowPool.release(arrayRow2);
            }
            this.mRows[i3] = null;
            i3++;
        }
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f16, int i3) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable createObjectVariable = createObjectVariable(constraintWidget.getAnchor(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable createObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable createObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable createObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(type4));
        SolverVariable createObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(type));
        SolverVariable createObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(type2));
        SolverVariable createObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(type3));
        SolverVariable createObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(type4));
        ArrayRow createRow = createRow();
        double d16 = f16;
        double d17 = i3;
        createRow.createRowWithAngle(createObjectVariable2, createObjectVariable4, createObjectVariable6, createObjectVariable8, (float) (Math.sin(d16) * d17));
        addConstraint(createRow);
        ArrayRow createRow2 = createRow();
        createRow2.createRowWithAngle(createObjectVariable, createObjectVariable3, createObjectVariable5, createObjectVariable7, (float) (Math.cos(d16) * d17));
        addConstraint(createRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, float f16, SolverVariable solverVariable3, SolverVariable solverVariable4, int i16, int i17) {
        ArrayRow createRow = createRow();
        createRow.createRowCentering(solverVariable, solverVariable2, i3, f16, solverVariable3, solverVariable4, i16);
        if (i17 != 8) {
            createRow.addError(this, i17);
        }
        addConstraint(createRow);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addConstraint(ArrayRow arrayRow) {
        SolverVariable pickPivot;
        if (arrayRow == null) {
            return;
        }
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.constraints++;
            if (arrayRow.isSimpleDefinition) {
                metrics.simpleconstraints++;
            }
        }
        boolean z16 = true;
        if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        boolean z17 = false;
        if (!arrayRow.isSimpleDefinition) {
            arrayRow.updateFromSystem(this);
            if (arrayRow.isEmpty()) {
                return;
            }
            arrayRow.ensurePositiveConstant();
            if (arrayRow.chooseSubject(this)) {
                SolverVariable createExtraVariable = createExtraVariable();
                arrayRow.variable = createExtraVariable;
                int i3 = this.mNumRows;
                addRow(arrayRow);
                if (this.mNumRows == i3 + 1) {
                    this.mTempGoal.initFromRow(arrayRow);
                    optimize(this.mTempGoal, true);
                    if (createExtraVariable.definitionId == -1) {
                        if (arrayRow.variable == createExtraVariable && (pickPivot = arrayRow.pickPivot(createExtraVariable)) != null) {
                            Metrics metrics2 = sMetrics;
                            if (metrics2 != null) {
                                metrics2.pivots++;
                            }
                            arrayRow.pivot(pickPivot);
                        }
                        if (!arrayRow.isSimpleDefinition) {
                            arrayRow.variable.updateReferencesWithNewDefinition(this, arrayRow);
                        }
                        if (OPTIMIZED_ENGINE) {
                            this.mCache.optimizedArrayRowPool.release(arrayRow);
                        } else {
                            this.mCache.arrayRowPool.release(arrayRow);
                        }
                        this.mNumRows--;
                    }
                    if (arrayRow.hasKeyVariable()) {
                        return;
                    } else {
                        z17 = z16;
                    }
                }
            }
            z16 = false;
            if (arrayRow.hasKeyVariable()) {
            }
        }
        if (!z17) {
            addRow(arrayRow);
        }
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, int i16) {
        if (USE_BASIC_SYNONYMS && i16 == 8 && solverVariable2.isFinalValue && solverVariable.definitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + i3);
            return null;
        }
        ArrayRow createRow = createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i3);
        if (i16 != 8) {
            createRow.addError(this, i16);
        }
        addConstraint(createRow);
        return createRow;
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, boolean z16) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i3);
        addConstraint(createRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, int i16) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i3);
        if (i16 != 8) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i16);
        }
        addConstraint(createRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, boolean z16) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i3);
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, int i16) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i3);
        if (i16 != 8) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i16);
        }
        addConstraint(createRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f16, int i3) {
        ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f16);
        if (i3 != 8) {
            createRow.addError(this, i3);
        }
        addConstraint(createRow);
    }

    public void addSynonym(SolverVariable solverVariable, SolverVariable solverVariable2, int i3) {
        if (solverVariable.definitionId == -1 && i3 == 0) {
            if (solverVariable2.isSynonym) {
                solverVariable2 = this.mCache.mIndexedVariables[solverVariable2.synonym];
            }
            if (solverVariable.isSynonym) {
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[solverVariable.synonym];
                return;
            } else {
                solverVariable.setSynonym(this, solverVariable2, 0.0f);
                return;
            }
        }
        addEquality(solverVariable, solverVariable2, i3, 8);
    }

    final void cleanupRows() {
        int i3;
        int i16 = 0;
        while (i16 < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[i16];
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
            }
            if (arrayRow.isSimpleDefinition) {
                SolverVariable solverVariable = arrayRow.variable;
                solverVariable.computedValue = arrayRow.constantValue;
                solverVariable.removeFromRow(arrayRow);
                int i17 = i16;
                while (true) {
                    i3 = this.mNumRows;
                    if (i17 >= i3 - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.mRows;
                    int i18 = i17 + 1;
                    arrayRowArr[i17] = arrayRowArr[i18];
                    i17 = i18;
                }
                this.mRows[i3 - 1] = null;
                this.mNumRows = i3 - 1;
                i16--;
                if (OPTIMIZED_ENGINE) {
                    this.mCache.optimizedArrayRowPool.release(arrayRow);
                } else {
                    this.mCache.arrayRowPool.release(arrayRow);
                }
            }
            i16++;
        }
    }

    public SolverVariable createErrorVariable(int i3, String str) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
        int i16 = this.mVariablesID + 1;
        this.mVariablesID = i16;
        this.mNumColumns++;
        acquireSolverVariable.f26465id = i16;
        acquireSolverVariable.strength = i3;
        this.mCache.mIndexedVariables[i16] = acquireSolverVariable;
        this.mGoal.addError(acquireSolverVariable);
        return acquireSolverVariable;
    }

    public SolverVariable createExtraVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i3 = this.mVariablesID + 1;
        this.mVariablesID = i3;
        this.mNumColumns++;
        acquireSolverVariable.f26465id = i3;
        this.mCache.mIndexedVariables[i3] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.mCache);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            int i3 = solverVariable.f26465id;
            if (i3 == -1 || i3 > this.mVariablesID || this.mCache.mIndexedVariables[i3] == null) {
                if (i3 != -1) {
                    solverVariable.reset();
                }
                int i16 = this.mVariablesID + 1;
                this.mVariablesID = i16;
                this.mNumColumns++;
                solverVariable.f26465id = i16;
                solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
                this.mCache.mIndexedVariables[i16] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow acquire;
        if (OPTIMIZED_ENGINE) {
            acquire = this.mCache.optimizedArrayRowPool.acquire();
            if (acquire == null) {
                acquire = new ValuesRow(this.mCache);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                acquire.reset();
            }
        } else {
            acquire = this.mCache.arrayRowPool.acquire();
            if (acquire == null) {
                acquire = new ArrayRow(this.mCache);
                ARRAY_ROW_CREATION++;
            } else {
                acquire.reset();
            }
        }
        SolverVariable.increaseErrorId();
        return acquire;
    }

    public SolverVariable createSlackVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i3 = this.mVariablesID + 1;
        this.mVariablesID = i3;
        this.mNumColumns++;
        acquireSolverVariable.f26465id = i3;
        this.mCache.mIndexedVariables[i3] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String str = " num vars " + this.mVariablesID + "\n";
        for (int i3 = 0; i3 < this.mVariablesID + 1; i3++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[i3];
            if (solverVariable != null && solverVariable.isFinalValue) {
                str = str + " $[" + i3 + "] => " + solverVariable + " = " + solverVariable.computedValue + "\n";
            }
        }
        String str2 = str + "\n";
        for (int i16 = 0; i16 < this.mVariablesID + 1; i16++) {
            SolverVariable[] solverVariableArr = this.mCache.mIndexedVariables;
            SolverVariable solverVariable2 = solverVariableArr[i16];
            if (solverVariable2 != null && solverVariable2.isSynonym) {
                str2 = str2 + " ~[" + i16 + "] => " + solverVariable2 + " = " + solverVariableArr[solverVariable2.synonym] + " + " + solverVariable2.synonymDelta + "\n";
            }
        }
        String str3 = str2 + "\n\n #  ";
        for (int i17 = 0; i17 < this.mNumRows; i17++) {
            str3 = (str3 + this.mRows[i17].toReadableString()) + "\n #  ";
        }
        if (this.mGoal != null) {
            str3 = str3 + "Goal: " + this.mGoal + "\n";
        }
        System.out.println(str3);
    }

    void displaySystemInformations() {
        int i3 = 0;
        for (int i16 = 0; i16 < this.TABLE_SIZE; i16++) {
            ArrayRow arrayRow = this.mRows[i16];
            if (arrayRow != null) {
                i3 += arrayRow.sizeInBytes();
            }
        }
        int i17 = 0;
        for (int i18 = 0; i18 < this.mNumRows; i18++) {
            ArrayRow arrayRow2 = this.mRows[i18];
            if (arrayRow2 != null) {
                i17 += arrayRow2.sizeInBytes();
            }
        }
        PrintStream printStream = System.out;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Linear System -> Table size: ");
        sb5.append(this.TABLE_SIZE);
        sb5.append(" (");
        int i19 = this.TABLE_SIZE;
        sb5.append(getDisplaySize(i19 * i19));
        sb5.append(") -- row sizes: ");
        sb5.append(getDisplaySize(i3));
        sb5.append(", actual size: ");
        sb5.append(getDisplaySize(i17));
        sb5.append(" rows: ");
        sb5.append(this.mNumRows);
        sb5.append("/");
        sb5.append(this.mMaxRows);
        sb5.append(" cols: ");
        sb5.append(this.mNumColumns);
        sb5.append("/");
        sb5.append(this.mMaxColumns);
        sb5.append(" ");
        sb5.append(0);
        sb5.append(" occupied cells, ");
        sb5.append(getDisplaySize(0));
        printStream.println(sb5.toString());
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String str = "";
        for (int i3 = 0; i3 < this.mNumRows; i3++) {
            if (this.mRows[i3].variable.mType == SolverVariable.Type.UNRESTRICTED) {
                str = (str + this.mRows[i3].toReadableString()) + "\n";
            }
        }
        System.out.println(str + this.mGoal + "\n");
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.mCache;
    }

    Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int i3 = 0;
        for (int i16 = 0; i16 < this.mNumRows; i16++) {
            ArrayRow arrayRow = this.mRows[i16];
            if (arrayRow != null) {
                i3 += arrayRow.sizeInBytes();
            }
        }
        return i3;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    ArrayRow getRow(int i3) {
        return this.mRows[i3];
    }

    float getValueFor(String str) {
        SolverVariable variable = getVariable(str, SolverVariable.Type.UNRESTRICTED);
        if (variable == null) {
            return 0.0f;
        }
        return variable.computedValue;
    }

    SolverVariable getVariable(String str, SolverVariable.Type type) {
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        SolverVariable solverVariable = this.mVariables.get(str);
        if (solverVariable == null) {
            return createVariable(str, type);
        }
        return solverVariable;
    }

    public void minimize() throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        if (this.mGoal.isEmpty()) {
            computeValues();
            return;
        }
        if (!this.graphOptimizer && !this.newgraphOptimizer) {
            minimizeGoal(this.mGoal);
            return;
        }
        Metrics metrics2 = sMetrics;
        if (metrics2 != null) {
            metrics2.graphOptimizer++;
        }
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 < this.mNumRows) {
                if (!this.mRows[i3].isSimpleDefinition) {
                    break;
                } else {
                    i3++;
                }
            } else {
                z16 = true;
                break;
            }
        }
        if (!z16) {
            minimizeGoal(this.mGoal);
            return;
        }
        Metrics metrics3 = sMetrics;
        if (metrics3 != null) {
            metrics3.fullySolved++;
        }
        computeValues();
    }

    void minimizeGoal(Row row) throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimizeGoal++;
            metrics.maxVariables = Math.max(metrics.maxVariables, this.mNumColumns);
            Metrics metrics2 = sMetrics;
            metrics2.maxRows = Math.max(metrics2.maxRows, this.mNumRows);
        }
        enforceBFS(row);
        optimize(row, false);
        computeValues();
    }

    public void removeRow(ArrayRow arrayRow) {
        SolverVariable solverVariable;
        int i3;
        if (arrayRow.isSimpleDefinition && (solverVariable = arrayRow.variable) != null) {
            int i16 = solverVariable.definitionId;
            if (i16 != -1) {
                while (true) {
                    i3 = this.mNumRows;
                    if (i16 >= i3 - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.mRows;
                    int i17 = i16 + 1;
                    ArrayRow arrayRow2 = arrayRowArr[i17];
                    SolverVariable solverVariable2 = arrayRow2.variable;
                    if (solverVariable2.definitionId == i17) {
                        solverVariable2.definitionId = i16;
                    }
                    arrayRowArr[i16] = arrayRow2;
                    i16 = i17;
                }
                this.mNumRows = i3 - 1;
            }
            SolverVariable solverVariable3 = arrayRow.variable;
            if (!solverVariable3.isFinalValue) {
                solverVariable3.setFinalValue(this, arrayRow.constantValue);
            }
            if (OPTIMIZED_ENGINE) {
                this.mCache.optimizedArrayRowPool.release(arrayRow);
            } else {
                this.mCache.arrayRowPool.release(arrayRow);
            }
        }
    }

    public void reset() {
        Cache cache;
        int i3 = 0;
        while (true) {
            cache = this.mCache;
            SolverVariable[] solverVariableArr = cache.mIndexedVariables;
            if (i3 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i3];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i3++;
        }
        cache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.mVariables;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (int i16 = 0; i16 < this.mNumRows; i16++) {
            ArrayRow arrayRow = this.mRows[i16];
            if (arrayRow != null) {
                arrayRow.used = false;
            }
        }
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this.mCache);
        } else {
            this.mTempGoal = new ArrayRow(this.mCache);
        }
    }

    void addSingleError(ArrayRow arrayRow, int i3, int i16) {
        arrayRow.addSingleError(createErrorVariable(i16, null), i3);
    }

    public void addEquality(SolverVariable solverVariable, int i3) {
        if (USE_BASIC_SYNONYMS && solverVariable.definitionId == -1) {
            float f16 = i3;
            solverVariable.setFinalValue(this, f16);
            for (int i16 = 0; i16 < this.mVariablesID + 1; i16++) {
                SolverVariable solverVariable2 = this.mCache.mIndexedVariables[i16];
                if (solverVariable2 != null && solverVariable2.isSynonym && solverVariable2.synonym == solverVariable.f26465id) {
                    solverVariable2.setFinalValue(this, solverVariable2.synonymDelta + f16);
                }
            }
            return;
        }
        int i17 = solverVariable.definitionId;
        if (i17 != -1) {
            ArrayRow arrayRow = this.mRows[i17];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = i3;
                return;
            }
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
                arrayRow.constantValue = i3;
                return;
            } else {
                ArrayRow createRow = createRow();
                createRow.createRowEquals(solverVariable, i3);
                addConstraint(createRow);
                return;
            }
        }
        ArrayRow createRow2 = createRow();
        createRow2.createRowDefinition(solverVariable, i3);
        addConstraint(createRow2);
    }
}
