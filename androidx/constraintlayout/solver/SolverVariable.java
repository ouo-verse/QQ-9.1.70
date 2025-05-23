package androidx.constraintlayout.solver;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes.dex */
public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    int definitionId;
    float[] goalStrengthVector;

    /* renamed from: id, reason: collision with root package name */
    public int f26465id;
    public boolean inGoal;
    HashSet<ArrayRow> inRows;
    public boolean isFinalValue;
    boolean isSynonym;
    ArrayRow[] mClientEquations;
    int mClientEquationsCount;
    private String mName;
    Type mType;
    public int strength;
    float[] strengthVector;
    int synonym;
    float synonymDelta;
    public int usageInRowCount;

    /* compiled from: P */
    /* renamed from: androidx.constraintlayout.solver.SolverVariable$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type = iArr;
            try {
                iArr[Type.UNRESTRICTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.CONSTANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.SLACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(String str, Type type) {
        this.f26465id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mName = str;
        this.mType = type;
    }

    private static String getUniqueName(Type type, String str) {
        if (str != null) {
            return str + uniqueErrorId;
        }
        int i3 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[type.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("V");
                            int i16 = uniqueId + 1;
                            uniqueId = i16;
                            sb5.append(i16);
                            return sb5.toString();
                        }
                        throw new AssertionError(type.name());
                    }
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("e");
                    int i17 = uniqueErrorId + 1;
                    uniqueErrorId = i17;
                    sb6.append(i17);
                    return sb6.toString();
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append(ExifInterface.LATITUDE_SOUTH);
                int i18 = uniqueSlackId + 1;
                uniqueSlackId = i18;
                sb7.append(i18);
                return sb7.toString();
            }
            StringBuilder sb8 = new StringBuilder();
            sb8.append(BdhLogUtil.LogTag.Tag_Conn);
            int i19 = uniqueConstantId + 1;
            uniqueConstantId = i19;
            sb8.append(i19);
            return sb8.toString();
        }
        StringBuilder sb9 = new StringBuilder();
        sb9.append("U");
        int i26 = uniqueUnrestrictedId + 1;
        uniqueUnrestrictedId = i26;
        sb9.append(i26);
        return sb9.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void increaseErrorId() {
        uniqueErrorId++;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i3 = 0;
        while (true) {
            int i16 = this.mClientEquationsCount;
            if (i3 < i16) {
                if (this.mClientEquations[i3] == arrayRow) {
                    return;
                } else {
                    i3++;
                }
            } else {
                ArrayRow[] arrayRowArr = this.mClientEquations;
                if (i16 >= arrayRowArr.length) {
                    this.mClientEquations = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int i17 = this.mClientEquationsCount;
                arrayRowArr2[i17] = arrayRow;
                this.mClientEquationsCount = i17 + 1;
                return;
            }
        }
    }

    void clearStrengths() {
        for (int i3 = 0; i3 < 9; i3++) {
            this.strengthVector[i3] = 0.0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i3 = this.mClientEquationsCount;
        int i16 = 0;
        while (i16 < i3) {
            if (this.mClientEquations[i16] == arrayRow) {
                while (i16 < i3 - 1) {
                    ArrayRow[] arrayRowArr = this.mClientEquations;
                    int i17 = i16 + 1;
                    arrayRowArr[i16] = arrayRowArr[i17];
                    i16 = i17;
                }
                this.mClientEquationsCount--;
                return;
            }
            i16++;
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.f26465id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int i3 = this.mClientEquationsCount;
        for (int i16 = 0; i16 < i3; i16++) {
            this.mClientEquations[i16] = null;
        }
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.goalStrengthVector, 0.0f);
    }

    public void setFinalValue(LinearSystem linearSystem, float f16) {
        this.computedValue = f16;
        this.isFinalValue = true;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int i3 = this.mClientEquationsCount;
        this.definitionId = -1;
        for (int i16 = 0; i16 < i3; i16++) {
            this.mClientEquations[i16].updateFromFinalVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setSynonym(LinearSystem linearSystem, SolverVariable solverVariable, float f16) {
        this.isSynonym = true;
        this.synonym = solverVariable.f26465id;
        this.synonymDelta = f16;
        int i3 = this.mClientEquationsCount;
        this.definitionId = -1;
        for (int i16 = 0; i16 < i3; i16++) {
            this.mClientEquations[i16].updateFromSynonymVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
        linearSystem.displayReadableRows();
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    String strengthsToString() {
        String str = this + "[";
        boolean z16 = false;
        boolean z17 = true;
        for (int i3 = 0; i3 < this.strengthVector.length; i3++) {
            String str2 = str + this.strengthVector[i3];
            float[] fArr = this.strengthVector;
            float f16 = fArr[i3];
            if (f16 > 0.0f) {
                z16 = false;
            } else if (f16 < 0.0f) {
                z16 = true;
            }
            if (f16 != 0.0f) {
                z17 = false;
            }
            if (i3 < fArr.length - 1) {
                str = str2 + ", ";
            } else {
                str = str2 + "] ";
            }
        }
        if (z16) {
            str = str + " (-)";
        }
        if (z17) {
            return str + " (*)";
        }
        return str;
    }

    public String toString() {
        if (this.mName != null) {
            return "" + this.mName;
        }
        return "" + this.f26465id;
    }

    public final void updateReferencesWithNewDefinition(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i3 = this.mClientEquationsCount;
        for (int i16 = 0; i16 < i3; i16++) {
            this.mClientEquations[i16].updateFromRow(linearSystem, arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }

    public SolverVariable(Type type, String str) {
        this.f26465id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mType = type;
    }
}
