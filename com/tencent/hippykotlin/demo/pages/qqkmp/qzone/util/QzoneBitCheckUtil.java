package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/util/QzoneBitCheckUtil;", "", "()V", "checkBitEnabled", "", "bitMask", "", "bitPosition", "", "disableBit", "enableBit", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneBitCheckUtil {
    public static final int $stable = 0;
    public static final QzoneBitCheckUtil INSTANCE = new QzoneBitCheckUtil();

    QzoneBitCheckUtil() {
    }

    public final boolean checkBitEnabled(long bitMask, int bitPosition) {
        if ((bitMask & (1 << bitPosition)) != 0) {
            return true;
        }
        return false;
    }

    public final long disableBit(long bitMask, int bitPosition) {
        return bitMask & (~(1 << bitPosition));
    }

    public final long enableBit(long bitMask, int bitPosition) {
        return bitMask | (1 << bitPosition);
    }
}
