package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.mobileqq.highway.transaction.Tracker;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class Opcode {
    public static final int DSO = 6;
    public static final int IQUERY = 1;
    public static final int NOTIFY = 4;
    public static final int QUERY = 0;
    public static final int STATUS = 2;
    public static final int UPDATE = 5;
    private static final Mnemonic opcodes;

    static {
        Mnemonic mnemonic = new Mnemonic("DNS Opcode", 2);
        opcodes = mnemonic;
        mnemonic.setMaximum(15);
        mnemonic.setPrefix("RESERVED");
        mnemonic.setNumericAllowed(true);
        mnemonic.add(0, Tracker.QUERY);
        mnemonic.add(1, "IQUERY");
        mnemonic.add(2, CommonConstant.RETKEY.STATUS);
        mnemonic.add(4, "NOTIFY");
        mnemonic.add(5, QzoneDataUpdateAction.UPDATE);
        mnemonic.add(6, "DSO");
    }

    Opcode() {
    }

    public static String string(int i3) {
        return opcodes.getText(i3);
    }

    public static int value(String str) {
        return opcodes.getValue(str);
    }
}
