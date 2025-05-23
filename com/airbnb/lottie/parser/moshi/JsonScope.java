package com.airbnb.lottie.parser.moshi;

/* compiled from: P */
/* loaded from: classes.dex */
final class JsonScope {
    static final int CLOSED = 8;
    static final int DANGLING_NAME = 4;
    static final int EMPTY_ARRAY = 1;
    static final int EMPTY_DOCUMENT = 6;
    static final int EMPTY_OBJECT = 3;
    static final int NONEMPTY_ARRAY = 2;
    static final int NONEMPTY_DOCUMENT = 7;
    static final int NONEMPTY_OBJECT = 5;

    JsonScope() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getPath(int i3, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append('$');
        for (int i16 = 0; i16 < i3; i16++) {
            int i17 = iArr[i16];
            if (i17 != 1 && i17 != 2) {
                if (i17 == 3 || i17 == 4 || i17 == 5) {
                    sb5.append('.');
                    String str = strArr[i16];
                    if (str != null) {
                        sb5.append(str);
                    }
                }
            } else {
                sb5.append('[');
                sb5.append(iArr2[i16]);
                sb5.append(']');
            }
        }
        return sb5.toString();
    }
}
