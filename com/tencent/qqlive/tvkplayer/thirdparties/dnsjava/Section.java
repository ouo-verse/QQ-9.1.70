package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import com.tencent.av.ui.an;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class Section {
    public static final int ADDITIONAL = 3;
    public static final int ANSWER = 1;
    public static final int AUTHORITY = 2;
    public static final int PREREQ = 1;
    public static final int QUESTION = 0;
    public static final int UPDATE = 2;
    public static final int ZONE = 0;
    private static final String[] longSections;
    private static final Mnemonic sections;
    private static final String[] updateSections;

    static {
        Mnemonic mnemonic = new Mnemonic("Message Section", 3);
        sections = mnemonic;
        longSections = r3;
        updateSections = r1;
        mnemonic.setMaximum(3);
        mnemonic.setNumericAllowed(true);
        mnemonic.add(0, "qd");
        mnemonic.add(1, an.f75362j);
        mnemonic.add(2, "au");
        mnemonic.add(3, "ad");
        String[] strArr = {"QUESTIONS", "ANSWERS", "AUTHORITY RECORDS", "ADDITIONAL RECORDS"};
        String[] strArr2 = {"ZONE", "PREREQUISITES", "UPDATE RECORDS", "ADDITIONAL RECORDS"};
    }

    Section() {
    }

    public static String longString(int i3) {
        sections.check(i3);
        return longSections[i3];
    }

    public static String string(int i3) {
        return sections.getText(i3);
    }

    public static String updString(int i3) {
        sections.check(i3);
        return updateSections[i3];
    }

    public static int value(String str) {
        return sections.getValue(str);
    }
}
