package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.exception.InvalidDClassException;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class DClass {
    public static final int ANY = 255;
    public static final int CH = 3;
    public static final int CHAOS = 3;
    public static final int HESIOD = 4;
    public static final int HS = 4;
    public static final int IN = 1;
    public static final int NONE = 254;
    private static final Mnemonic classes;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class DClassMnemonic extends Mnemonic {
        public DClassMnemonic() {
            super("DClass", 2);
            setPrefix("CLASS");
        }

        @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Mnemonic
        public void check(int i3) {
            DClass.check(i3);
        }
    }

    static {
        DClassMnemonic dClassMnemonic = new DClassMnemonic();
        classes = dClassMnemonic;
        dClassMnemonic.add(1, "IN");
        dClassMnemonic.add(3, "CH");
        dClassMnemonic.addAlias(3, "CHAOS");
        dClassMnemonic.add(4, "HS");
        dClassMnemonic.addAlias(4, "HESIOD");
        dClassMnemonic.add(254, "NONE");
        dClassMnemonic.add(255, "ANY");
    }

    DClass() {
    }

    public static void check(int i3) {
        if (i3 >= 0 && i3 <= 65535) {
        } else {
            throw new InvalidDClassException(i3);
        }
    }

    public static String string(int i3) {
        return classes.getText(i3);
    }

    public static int value(String str) {
        return classes.getValue(str);
    }
}
