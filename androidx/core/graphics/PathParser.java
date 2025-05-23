package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PathParser {
    private static final String LOGTAG = "PathParser";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
        }
    }

    PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c16, float[] fArr) {
        arrayList.add(new PathDataNode(c16, fArr));
    }

    public static boolean canMorph(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i3 = 0; i3 < pathDataNodeArr.length; i3++) {
            PathDataNode pathDataNode = pathDataNodeArr[i3];
            char c16 = pathDataNode.mType;
            PathDataNode pathDataNode2 = pathDataNodeArr2[i3];
            if (c16 != pathDataNode2.mType || pathDataNode.mParams.length != pathDataNode2.mParams.length) {
                return false;
            }
        }
        return true;
    }

    static float[] copyOfRange(float[] fArr, int i3, int i16) {
        if (i3 <= i16) {
            int length = fArr.length;
            if (i3 >= 0 && i3 <= length) {
                int i17 = i16 - i3;
                int min = Math.min(i17, length - i3);
                float[] fArr2 = new float[i17];
                System.arraycopy(fArr, i3, fArr2, 0, min);
                return fArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 1;
        int i16 = 0;
        while (i3 < str.length()) {
            int nextStart = nextStart(str, i3);
            String trim = str.substring(i16, nextStart).trim();
            if (trim.length() > 0) {
                addNode(arrayList, trim.charAt(0), getFloats(trim));
            }
            i16 = nextStart;
            i3 = nextStart + 1;
        }
        if (i3 - i16 == 1 && i16 < str.length()) {
            addNode(arrayList, str.charAt(i16), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathDataNode[] createNodesFromPathData = createNodesFromPathData(str);
        if (createNodesFromPathData != null) {
            try {
                PathDataNode.nodesToPath(createNodesFromPathData, path);
                return path;
            } catch (RuntimeException e16) {
                throw new RuntimeException("Error in parsing " + str, e16);
            }
        }
        return null;
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i3 = 0; i3 < pathDataNodeArr.length; i3++) {
            pathDataNodeArr2[i3] = new PathDataNode(pathDataNodeArr[i3]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x001e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a A[LOOP:0: B:2:0x0007->B:14:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void extract(String str, int i3, ExtractFloatResult extractFloatResult) {
        extractFloatResult.mEndWithNegOrDot = false;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        for (int i16 = i3; i16 < str.length(); i16++) {
            char charAt = str.charAt(i16);
            if (charAt != ' ') {
                if (charAt != 'E' && charAt != 'e') {
                    switch (charAt) {
                        case ',':
                            break;
                        case '-':
                            if (i16 != i3 && !z16) {
                                extractFloatResult.mEndWithNegOrDot = true;
                                break;
                            }
                            z16 = false;
                            break;
                        case '.':
                            if (!z17) {
                                z16 = false;
                                z17 = true;
                                break;
                            } else {
                                extractFloatResult.mEndWithNegOrDot = true;
                                break;
                            }
                        default:
                            z16 = false;
                            break;
                    }
                } else {
                    z16 = true;
                }
                if (!z18) {
                    extractFloatResult.mEndPosition = i16;
                }
            }
            z16 = false;
            z18 = true;
            if (!z18) {
            }
        }
        extractFloatResult.mEndPosition = i16;
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) != 'z' && str.charAt(0) != 'Z') {
            try {
                float[] fArr = new float[str.length()];
                ExtractFloatResult extractFloatResult = new ExtractFloatResult();
                int length = str.length();
                int i3 = 1;
                int i16 = 0;
                while (i3 < length) {
                    extract(str, i3, extractFloatResult);
                    int i17 = extractFloatResult.mEndPosition;
                    if (i3 < i17) {
                        fArr[i16] = Float.parseFloat(str.substring(i3, i17));
                        i16++;
                    }
                    if (extractFloatResult.mEndWithNegOrDot) {
                        i3 = i17;
                    } else {
                        i3 = i17 + 1;
                    }
                }
                return copyOfRange(fArr, 0, i16);
            } catch (NumberFormatException e16) {
                throw new RuntimeException("error in parsing \"" + str + "\"", e16);
            }
        }
        return new float[0];
    }

    public static boolean interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3, float f16) {
        if (pathDataNodeArr != null && pathDataNodeArr2 != null && pathDataNodeArr3 != null) {
            if (pathDataNodeArr.length == pathDataNodeArr2.length && pathDataNodeArr2.length == pathDataNodeArr3.length) {
                if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
                    return false;
                }
                for (int i3 = 0; i3 < pathDataNodeArr.length; i3++) {
                    pathDataNodeArr[i3].interpolatePathDataNode(pathDataNodeArr2[i3], pathDataNodeArr3[i3], f16);
                }
                return true;
            }
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
        }
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
    }

    private static int nextStart(String str, int i3) {
        while (i3 < str.length()) {
            char charAt = str.charAt(i3);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i3;
            }
            i3++;
        }
        return i3;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i3 = 0; i3 < pathDataNodeArr2.length; i3++) {
            pathDataNodeArr[i3].mType = pathDataNodeArr2[i3].mType;
            int i16 = 0;
            while (true) {
                float[] fArr = pathDataNodeArr2[i3].mParams;
                if (i16 < fArr.length) {
                    pathDataNodeArr[i3].mParams[i16] = fArr[i16];
                    i16++;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class PathDataNode {
        public float[] mParams;
        public char mType;

        PathDataNode(char c16, float[] fArr) {
            this.mType = c16;
            this.mParams = fArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void addCommand(Path path, float[] fArr, char c16, char c17, float[] fArr2) {
            int i3;
            int i16;
            int i17;
            float f16;
            float f17;
            float f18;
            float f19;
            float f26;
            float f27;
            float f28;
            float f29;
            char c18 = c17;
            boolean z16 = false;
            float f36 = fArr[0];
            float f37 = fArr[1];
            float f38 = fArr[2];
            float f39 = fArr[3];
            float f46 = fArr[4];
            float f47 = fArr[5];
            switch (c18) {
                case 'A':
                case 'a':
                    i3 = 7;
                    i16 = i3;
                    break;
                case 'C':
                case 'c':
                    i3 = 6;
                    i16 = i3;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i16 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i16 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i16 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f46, f47);
                    f36 = f46;
                    f38 = f36;
                    f37 = f47;
                    f39 = f37;
                    i16 = 2;
                    break;
            }
            float f48 = f36;
            float f49 = f37;
            float f56 = f46;
            float f57 = f47;
            int i18 = 0;
            char c19 = c16;
            while (i18 < fArr2.length) {
                if (c18 != 'A') {
                    if (c18 == 'C') {
                        i17 = i18;
                        int i19 = i17 + 2;
                        int i26 = i17 + 3;
                        int i27 = i17 + 4;
                        int i28 = i17 + 5;
                        path.cubicTo(fArr2[i17 + 0], fArr2[i17 + 1], fArr2[i19], fArr2[i26], fArr2[i27], fArr2[i28]);
                        f48 = fArr2[i27];
                        float f58 = fArr2[i28];
                        float f59 = fArr2[i19];
                        float f65 = fArr2[i26];
                        f49 = f58;
                        f39 = f65;
                        f38 = f59;
                    } else if (c18 == 'H') {
                        i17 = i18;
                        int i29 = i17 + 0;
                        path.lineTo(fArr2[i29], f49);
                        f48 = fArr2[i29];
                    } else if (c18 == 'Q') {
                        i17 = i18;
                        int i36 = i17 + 0;
                        int i37 = i17 + 1;
                        int i38 = i17 + 2;
                        int i39 = i17 + 3;
                        path.quadTo(fArr2[i36], fArr2[i37], fArr2[i38], fArr2[i39]);
                        float f66 = fArr2[i36];
                        float f67 = fArr2[i37];
                        f48 = fArr2[i38];
                        f49 = fArr2[i39];
                        f38 = f66;
                        f39 = f67;
                    } else if (c18 == 'V') {
                        i17 = i18;
                        int i46 = i17 + 0;
                        path.lineTo(f48, fArr2[i46]);
                        f49 = fArr2[i46];
                    } else if (c18 != 'a') {
                        if (c18 != 'c') {
                            if (c18 == 'h') {
                                int i47 = i18 + 0;
                                path.rLineTo(fArr2[i47], 0.0f);
                                f48 += fArr2[i47];
                            } else if (c18 != 'q') {
                                if (c18 == 'v') {
                                    int i48 = i18 + 0;
                                    path.rLineTo(0.0f, fArr2[i48]);
                                    f19 = fArr2[i48];
                                } else if (c18 == 'L') {
                                    int i49 = i18 + 0;
                                    int i56 = i18 + 1;
                                    path.lineTo(fArr2[i49], fArr2[i56]);
                                    f48 = fArr2[i49];
                                    f49 = fArr2[i56];
                                } else if (c18 == 'M') {
                                    f48 = fArr2[i18 + 0];
                                    f49 = fArr2[i18 + 1];
                                    if (i18 > 0) {
                                        path.lineTo(f48, f49);
                                    } else {
                                        path.moveTo(f48, f49);
                                        i17 = i18;
                                        f57 = f49;
                                        f56 = f48;
                                    }
                                } else if (c18 == 'S') {
                                    if (c19 == 'c' || c19 == 's' || c19 == 'C' || c19 == 'S') {
                                        f48 = (f48 * 2.0f) - f38;
                                        f49 = (f49 * 2.0f) - f39;
                                    }
                                    float f68 = f49;
                                    int i57 = i18 + 0;
                                    int i58 = i18 + 1;
                                    int i59 = i18 + 2;
                                    int i65 = i18 + 3;
                                    path.cubicTo(f48, f68, fArr2[i57], fArr2[i58], fArr2[i59], fArr2[i65]);
                                    f16 = fArr2[i57];
                                    f17 = fArr2[i58];
                                    f48 = fArr2[i59];
                                    f49 = fArr2[i65];
                                    f38 = f16;
                                    f39 = f17;
                                } else if (c18 == 'T') {
                                    if (c19 == 'q' || c19 == 't' || c19 == 'Q' || c19 == 'T') {
                                        f48 = (f48 * 2.0f) - f38;
                                        f49 = (f49 * 2.0f) - f39;
                                    }
                                    int i66 = i18 + 0;
                                    int i67 = i18 + 1;
                                    path.quadTo(f48, f49, fArr2[i66], fArr2[i67]);
                                    float f69 = fArr2[i66];
                                    float f75 = fArr2[i67];
                                    i17 = i18;
                                    f39 = f49;
                                    f38 = f48;
                                    f48 = f69;
                                    f49 = f75;
                                } else if (c18 == 'l') {
                                    int i68 = i18 + 0;
                                    int i69 = i18 + 1;
                                    path.rLineTo(fArr2[i68], fArr2[i69]);
                                    f48 += fArr2[i68];
                                    f19 = fArr2[i69];
                                } else if (c18 == 'm') {
                                    float f76 = fArr2[i18 + 0];
                                    f48 += f76;
                                    float f77 = fArr2[i18 + 1];
                                    f49 += f77;
                                    if (i18 > 0) {
                                        path.rLineTo(f76, f77);
                                    } else {
                                        path.rMoveTo(f76, f77);
                                        i17 = i18;
                                        f57 = f49;
                                        f56 = f48;
                                    }
                                } else if (c18 == 's') {
                                    if (c19 == 'c' || c19 == 's' || c19 == 'C' || c19 == 'S') {
                                        float f78 = f48 - f38;
                                        f26 = f49 - f39;
                                        f27 = f78;
                                    } else {
                                        f27 = 0.0f;
                                        f26 = 0.0f;
                                    }
                                    int i75 = i18 + 0;
                                    int i76 = i18 + 1;
                                    int i77 = i18 + 2;
                                    int i78 = i18 + 3;
                                    path.rCubicTo(f27, f26, fArr2[i75], fArr2[i76], fArr2[i77], fArr2[i78]);
                                    f16 = fArr2[i75] + f48;
                                    f17 = fArr2[i76] + f49;
                                    f48 += fArr2[i77];
                                    f18 = fArr2[i78];
                                } else if (c18 == 't') {
                                    if (c19 == 'q' || c19 == 't' || c19 == 'Q' || c19 == 'T') {
                                        f28 = f48 - f38;
                                        f29 = f49 - f39;
                                    } else {
                                        f29 = 0.0f;
                                        f28 = 0.0f;
                                    }
                                    int i79 = i18 + 0;
                                    int i85 = i18 + 1;
                                    path.rQuadTo(f28, f29, fArr2[i79], fArr2[i85]);
                                    float f79 = f28 + f48;
                                    float f85 = f29 + f49;
                                    f48 += fArr2[i79];
                                    f49 += fArr2[i85];
                                    f39 = f85;
                                    f38 = f79;
                                }
                                f49 += f19;
                            } else {
                                int i86 = i18 + 0;
                                int i87 = i18 + 1;
                                int i88 = i18 + 2;
                                int i89 = i18 + 3;
                                path.rQuadTo(fArr2[i86], fArr2[i87], fArr2[i88], fArr2[i89]);
                                f16 = fArr2[i86] + f48;
                                f17 = fArr2[i87] + f49;
                                f48 += fArr2[i88];
                                f18 = fArr2[i89];
                            }
                            i17 = i18;
                        } else {
                            int i95 = i18 + 2;
                            int i96 = i18 + 3;
                            int i97 = i18 + 4;
                            int i98 = i18 + 5;
                            path.rCubicTo(fArr2[i18 + 0], fArr2[i18 + 1], fArr2[i95], fArr2[i96], fArr2[i97], fArr2[i98]);
                            f16 = fArr2[i95] + f48;
                            f17 = fArr2[i96] + f49;
                            f48 += fArr2[i97];
                            f18 = fArr2[i98];
                        }
                        f49 += f18;
                        f38 = f16;
                        f39 = f17;
                        i17 = i18;
                    } else {
                        int i99 = i18 + 5;
                        int i100 = i18 + 6;
                        i17 = i18;
                        drawArc(path, f48, f49, fArr2[i99] + f48, fArr2[i100] + f49, fArr2[i18 + 0], fArr2[i18 + 1], fArr2[i18 + 2], fArr2[i18 + 3] != 0.0f, fArr2[i18 + 4] != 0.0f);
                        f48 += fArr2[i99];
                        f49 += fArr2[i100];
                    }
                    i18 = i17 + i16;
                    c19 = c17;
                    c18 = c19;
                    z16 = false;
                } else {
                    i17 = i18;
                    int i101 = i17 + 5;
                    int i102 = i17 + 6;
                    drawArc(path, f48, f49, fArr2[i101], fArr2[i102], fArr2[i17 + 0], fArr2[i17 + 1], fArr2[i17 + 2], fArr2[i17 + 3] != 0.0f, fArr2[i17 + 4] != 0.0f);
                    f48 = fArr2[i101];
                    f49 = fArr2[i102];
                }
                f39 = f49;
                f38 = f48;
                i18 = i17 + i16;
                c19 = c17;
                c18 = c19;
                z16 = false;
            }
            fArr[z16 ? 1 : 0] = f48;
            fArr[1] = f49;
            fArr[2] = f38;
            fArr[3] = f39;
            fArr[4] = f56;
            fArr[5] = f57;
        }

        private static void arcToBezier(Path path, double d16, double d17, double d18, double d19, double d26, double d27, double d28, double d29, double d36) {
            double d37 = d18;
            int ceil = (int) Math.ceil(Math.abs((d36 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d28);
            double sin = Math.sin(d28);
            double cos2 = Math.cos(d29);
            double sin2 = Math.sin(d29);
            double d38 = -d37;
            double d39 = d38 * cos;
            double d46 = d19 * sin;
            double d47 = (d39 * sin2) - (d46 * cos2);
            double d48 = d38 * sin;
            double d49 = d19 * cos;
            double d56 = (sin2 * d48) + (cos2 * d49);
            double d57 = d36 / ceil;
            double d58 = d56;
            double d59 = d47;
            int i3 = 0;
            double d65 = d26;
            double d66 = d27;
            double d67 = d29;
            while (i3 < ceil) {
                double d68 = d67 + d57;
                double sin3 = Math.sin(d68);
                double cos3 = Math.cos(d68);
                double d69 = (d16 + ((d37 * cos) * cos3)) - (d46 * sin3);
                double d75 = d17 + (d37 * sin * cos3) + (d49 * sin3);
                double d76 = (d39 * sin3) - (d46 * cos3);
                double d77 = (sin3 * d48) + (cos3 * d49);
                double d78 = d68 - d67;
                double tan = Math.tan(d78 / 2.0d);
                double sin4 = (Math.sin(d78) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d79 = d65 + (d59 * sin4);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d79, (float) (d66 + (d58 * sin4)), (float) (d69 - (sin4 * d76)), (float) (d75 - (sin4 * d77)), (float) d69, (float) d75);
                i3++;
                d57 = d57;
                sin = sin;
                d65 = d69;
                d48 = d48;
                cos = cos;
                d67 = d68;
                d58 = d77;
                d59 = d76;
                ceil = ceil;
                d66 = d75;
                d37 = d18;
            }
        }

        private static void drawArc(Path path, float f16, float f17, float f18, float f19, float f26, float f27, float f28, boolean z16, boolean z17) {
            double d16;
            double d17;
            boolean z18;
            double radians = Math.toRadians(f28);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d18 = f16;
            double d19 = d18 * cos;
            double d26 = f17;
            double d27 = f26;
            double d28 = (d19 + (d26 * sin)) / d27;
            double d29 = ((-f16) * sin) + (d26 * cos);
            double d36 = f27;
            double d37 = d29 / d36;
            double d38 = f19;
            double d39 = ((f18 * cos) + (d38 * sin)) / d27;
            double d46 = (((-f18) * sin) + (d38 * cos)) / d36;
            double d47 = d28 - d39;
            double d48 = d37 - d46;
            double d49 = (d28 + d39) / 2.0d;
            double d56 = (d37 + d46) / 2.0d;
            double d57 = (d47 * d47) + (d48 * d48);
            if (d57 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d58 = (1.0d / d57) - 0.25d;
            if (d58 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d57);
                float sqrt = (float) (Math.sqrt(d57) / 1.99999d);
                drawArc(path, f16, f17, f18, f19, f26 * sqrt, f27 * sqrt, f28, z16, z17);
                return;
            }
            double sqrt2 = Math.sqrt(d58);
            double d59 = d47 * sqrt2;
            double d65 = sqrt2 * d48;
            if (z16 == z17) {
                d16 = d49 - d65;
                d17 = d56 + d59;
            } else {
                d16 = d49 + d65;
                d17 = d56 - d59;
            }
            double atan2 = Math.atan2(d37 - d17, d28 - d16);
            double atan22 = Math.atan2(d46 - d17, d39 - d16) - atan2;
            if (atan22 >= 0.0d) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z17 != z18) {
                if (atan22 > 0.0d) {
                    atan22 -= 6.283185307179586d;
                } else {
                    atan22 += 6.283185307179586d;
                }
            }
            double d66 = d16 * d27;
            double d67 = d17 * d36;
            arcToBezier(path, (d66 * cos) - (d67 * sin), (d66 * sin) + (d67 * cos), d27, d36, d18, d26, radians, atan2, atan22);
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            float[] fArr = new float[6];
            char c16 = 'm';
            for (int i3 = 0; i3 < pathDataNodeArr.length; i3++) {
                PathDataNode pathDataNode = pathDataNodeArr[i3];
                addCommand(path, fArr, c16, pathDataNode.mType, pathDataNode.mParams);
                c16 = pathDataNodeArr[i3].mType;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f16) {
            this.mType = pathDataNode.mType;
            int i3 = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i3 < fArr.length) {
                    this.mParams[i3] = (fArr[i3] * (1.0f - f16)) + (pathDataNode2.mParams[i3] * f16);
                    i3++;
                } else {
                    return;
                }
            }
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }
    }
}
