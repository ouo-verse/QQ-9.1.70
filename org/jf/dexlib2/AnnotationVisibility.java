package org.jf.dexlib2;

import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AnnotationVisibility {
    public static final int BUILD = 0;
    private static String[] NAMES = {"build", "runtime", TVKPlayerMsg.PLAYER_CHOICE_SYSTEM};
    public static final int RUNTIME = 1;
    public static final int SYSTEM = 2;

    AnnotationVisibility() {
    }

    public static String getVisibility(int i3) {
        if (i3 >= 0) {
            String[] strArr = NAMES;
            if (i3 < strArr.length) {
                return strArr[i3];
            }
        }
        throw new ExceptionWithContext("Invalid annotation visibility %d", Integer.valueOf(i3));
    }

    public static int getVisibility(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("build")) {
            return 0;
        }
        if (lowerCase.equals("runtime")) {
            return 1;
        }
        if (lowerCase.equals(TVKPlayerMsg.PLAYER_CHOICE_SYSTEM)) {
            return 2;
        }
        throw new ExceptionWithContext("Invalid annotation visibility: %s", lowerCase);
    }
}
