package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import com.tencent.oskplayer.PlayerConfig;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class Flags {
    public static final byte AA = 5;
    public static final byte AD = 10;
    public static final byte CD = 11;
    public static final byte QR = 0;
    public static final byte RA = 8;
    public static final byte RD = 7;
    public static final byte TC = 6;
    private static final Mnemonic flags;

    static {
        Mnemonic mnemonic = new Mnemonic("DNS Header Flag", 3);
        flags = mnemonic;
        mnemonic.setMaximum(15);
        mnemonic.setPrefix("FLAG");
        mnemonic.setNumericAllowed(true);
        mnemonic.add(0, "qr");
        mnemonic.add(5, "aa");
        mnemonic.add(6, PlayerConfig.TC_CACHE_DIR_NAME);
        mnemonic.add(7, "rd");
        mnemonic.add(8, "ra");
        mnemonic.add(10, "ad");
        mnemonic.add(11, "cd");
    }

    Flags() {
    }

    public static boolean isFlag(int i3) {
        flags.check(i3);
        if ((i3 < 1 || i3 > 4) && i3 < 12) {
            return true;
        }
        return false;
    }

    public static String string(int i3) {
        return flags.getText(i3);
    }

    public static int value(String str) {
        return flags.getValue(str);
    }
}
