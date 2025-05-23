package com.tencent.bugly.matrix.util;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MatrixLog {
    private static MatrixLogImp debugLog;
    private static MatrixLogImp matrixLogImp;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface MatrixLogImp {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th5, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    static {
        MatrixLogImp matrixLogImp2 = new MatrixLogImp() { // from class: com.tencent.bugly.matrix.util.MatrixLog.1
            @Override // com.tencent.bugly.matrix.util.MatrixLog.MatrixLogImp
            public void d(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                Log.d(str, str2);
            }

            @Override // com.tencent.bugly.matrix.util.MatrixLog.MatrixLogImp
            public void e(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                Log.e(str, str2);
            }

            @Override // com.tencent.bugly.matrix.util.MatrixLog.MatrixLogImp
            public void i(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                Log.i(str, str2);
            }

            @Override // com.tencent.bugly.matrix.util.MatrixLog.MatrixLogImp
            public void printErrStackTrace(String str, Throwable th5, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                if (str2 == null) {
                    str2 = "";
                }
                Log.e(str, str2 + "  " + Log.getStackTraceString(th5));
            }

            @Override // com.tencent.bugly.matrix.util.MatrixLog.MatrixLogImp
            public void v(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                Log.v(str, str2);
            }

            @Override // com.tencent.bugly.matrix.util.MatrixLog.MatrixLogImp
            public void w(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                Log.w(str, str2);
            }
        };
        debugLog = matrixLogImp2;
        matrixLogImp = matrixLogImp2;
    }

    MatrixLog() {
    }

    public static void d(String str, String str2, Object... objArr) {
        MatrixLogImp matrixLogImp2 = matrixLogImp;
        if (matrixLogImp2 != null) {
            matrixLogImp2.d(str, str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        MatrixLogImp matrixLogImp2 = matrixLogImp;
        if (matrixLogImp2 != null) {
            matrixLogImp2.e(str, str2, objArr);
        }
    }

    public static MatrixLogImp getImpl() {
        return matrixLogImp;
    }

    public static void i(String str, String str2, Object... objArr) {
        MatrixLogImp matrixLogImp2 = matrixLogImp;
        if (matrixLogImp2 != null) {
            matrixLogImp2.i(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th5, String str2, Object... objArr) {
        MatrixLogImp matrixLogImp2 = matrixLogImp;
        if (matrixLogImp2 != null) {
            matrixLogImp2.printErrStackTrace(str, th5, str2, objArr);
        }
    }

    public static void setMatrixLogImp(MatrixLogImp matrixLogImp2) {
        matrixLogImp = matrixLogImp2;
    }

    public static void v(String str, String str2, Object... objArr) {
        MatrixLogImp matrixLogImp2 = matrixLogImp;
        if (matrixLogImp2 != null) {
            matrixLogImp2.v(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        MatrixLogImp matrixLogImp2 = matrixLogImp;
        if (matrixLogImp2 != null) {
            matrixLogImp2.w(str, str2, objArr);
        }
    }
}
