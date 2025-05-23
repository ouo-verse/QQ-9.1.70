package org.jf.dexlib2;

/* compiled from: P */
/* loaded from: classes29.dex */
public class VersionMap {
    public static final int NO_VERSION = -1;

    public static int mapApiToArtVersion(int i3) {
        if (i3 < 19) {
            return -1;
        }
        switch (i3) {
            case 19:
            case 20:
                return 7;
            case 21:
                return 39;
            case 22:
                return 45;
            case 23:
                return 64;
            case 24:
            case 25:
                return 79;
            case 26:
                return 124;
            case 27:
                return 131;
            case 28:
                return 138;
            case 29:
                return 170;
            default:
                return 178;
        }
    }

    public static int mapApiToDexVersion(int i3) {
        if (i3 <= 23) {
            return 35;
        }
        if (i3 <= 25) {
            return 37;
        }
        if (i3 <= 27) {
            return 38;
        }
        return 39;
    }

    public static int mapArtVersionToApi(int i3) {
        if (i3 >= 170) {
            return 29;
        }
        if (i3 >= 138) {
            return 28;
        }
        if (i3 >= 131) {
            return 27;
        }
        if (i3 >= 124) {
            return 26;
        }
        if (i3 >= 79) {
            return 24;
        }
        if (i3 >= 64) {
            return 23;
        }
        if (i3 >= 45) {
            return 22;
        }
        if (i3 >= 39) {
            return 21;
        }
        return 19;
    }

    public static int mapDexVersionToApi(int i3) {
        switch (i3) {
            case 35:
                return 23;
            case 36:
            default:
                return -1;
            case 37:
                return 25;
            case 38:
                return 27;
            case 39:
                return 28;
        }
    }
}
