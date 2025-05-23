package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class Rcode {
    public static final int BADALG = 21;
    public static final int BADCOOKIE = 23;
    public static final int BADKEY = 17;
    public static final int BADMODE = 19;
    public static final int BADNAME = 20;
    public static final int BADSIG = 16;
    public static final int BADTIME = 18;
    public static final int BADTRUNC = 22;
    public static final int BADVERS = 16;
    public static final int FORMERR = 1;
    public static final int NOERROR = 0;
    public static final int NOTAUTH = 9;
    public static final int NOTIMP = 4;

    @Deprecated
    public static final int NOTIMPL = 4;
    public static final int NOTZONE = 10;
    public static final int NXDOMAIN = 3;
    public static final int NXRRSET = 8;
    public static final int REFUSED = 5;
    public static final int SERVFAIL = 2;
    public static final int YXDOMAIN = 6;
    public static final int YXRRSET = 7;
    private static final Mnemonic rcodes;

    static {
        Mnemonic mnemonic = new Mnemonic("DNS Rcode", 2);
        rcodes = mnemonic;
        mnemonic.setMaximum(4095);
        mnemonic.setPrefix("RESERVED");
        mnemonic.setNumericAllowed(true);
        mnemonic.add(0, "NOERROR");
        mnemonic.add(1, "FORMERR");
        mnemonic.add(2, "SERVFAIL");
        mnemonic.add(3, "NXDOMAIN");
        mnemonic.add(4, "NOTIMP");
        mnemonic.addAlias(4, "NOTIMPL");
        mnemonic.add(5, "REFUSED");
        mnemonic.add(6, "YXDOMAIN");
        mnemonic.add(7, "YXRRSET");
        mnemonic.add(8, "NXRRSET");
        mnemonic.add(9, "NOTAUTH");
        mnemonic.add(10, "NOTZONE");
        mnemonic.add(16, "BADVERS");
        mnemonic.add(17, "BADKEY");
        mnemonic.add(18, "BADTIME");
        mnemonic.add(19, "BADMODE");
        mnemonic.add(20, "BADNAME");
        mnemonic.add(21, "BADALG");
        mnemonic.add(22, "BADTRUNC");
        mnemonic.add(23, "BADCOOKIE");
    }

    Rcode() {
    }

    public static String TSIGstring(int i3) {
        if (i3 == 16) {
            return "BADSIG";
        }
        return string(i3);
    }

    public static String string(int i3) {
        return rcodes.getText(i3);
    }

    public static int value(String str) {
        if ("BADSIG".equalsIgnoreCase(str)) {
            return 16;
        }
        return rcodes.getValue(str);
    }
}
