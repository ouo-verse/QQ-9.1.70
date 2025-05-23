package com.tencent.richframework.widget.refresh.layout.constant;

/* compiled from: P */
/* loaded from: classes25.dex */
public class DimensionStatus {
    public static final DimensionStatus CodeExact;
    public static final DimensionStatus CodeExactUnNotify;
    public static final DimensionStatus DeadLock;
    public static final DimensionStatus DeadLockUnNotify;
    public static final DimensionStatus Default;
    public static final DimensionStatus DefaultUnNotify;
    public static final DimensionStatus XmlExact;
    public static final DimensionStatus XmlExactUnNotify;
    public static final DimensionStatus XmlLayout;
    public static final DimensionStatus XmlLayoutUnNotify;
    public static final DimensionStatus XmlWrap;
    public static final DimensionStatus XmlWrapUnNotify;
    public static final DimensionStatus[] values;
    public final boolean notified;
    public final int ordinal;

    static {
        DimensionStatus dimensionStatus = new DimensionStatus(0, false);
        DefaultUnNotify = dimensionStatus;
        DimensionStatus dimensionStatus2 = new DimensionStatus(1, true);
        Default = dimensionStatus2;
        DimensionStatus dimensionStatus3 = new DimensionStatus(2, false);
        XmlWrapUnNotify = dimensionStatus3;
        DimensionStatus dimensionStatus4 = new DimensionStatus(3, true);
        XmlWrap = dimensionStatus4;
        DimensionStatus dimensionStatus5 = new DimensionStatus(4, false);
        XmlExactUnNotify = dimensionStatus5;
        DimensionStatus dimensionStatus6 = new DimensionStatus(5, true);
        XmlExact = dimensionStatus6;
        DimensionStatus dimensionStatus7 = new DimensionStatus(6, false);
        XmlLayoutUnNotify = dimensionStatus7;
        DimensionStatus dimensionStatus8 = new DimensionStatus(7, true);
        XmlLayout = dimensionStatus8;
        DimensionStatus dimensionStatus9 = new DimensionStatus(8, false);
        CodeExactUnNotify = dimensionStatus9;
        DimensionStatus dimensionStatus10 = new DimensionStatus(9, true);
        CodeExact = dimensionStatus10;
        DimensionStatus dimensionStatus11 = new DimensionStatus(10, false);
        DeadLockUnNotify = dimensionStatus11;
        DimensionStatus dimensionStatus12 = new DimensionStatus(10, true);
        DeadLock = dimensionStatus12;
        values = new DimensionStatus[]{dimensionStatus, dimensionStatus2, dimensionStatus3, dimensionStatus4, dimensionStatus5, dimensionStatus6, dimensionStatus7, dimensionStatus8, dimensionStatus9, dimensionStatus10, dimensionStatus11, dimensionStatus12};
    }

    DimensionStatus(int i3, boolean z16) {
        this.ordinal = i3;
        this.notified = z16;
    }

    public boolean canReplaceWith(DimensionStatus dimensionStatus) {
        int i3 = this.ordinal;
        int i16 = dimensionStatus.ordinal;
        if (i3 >= i16 && ((this.notified && CodeExact != this) || i3 != i16)) {
            return false;
        }
        return true;
    }

    public DimensionStatus notified() {
        if (!this.notified) {
            return values[this.ordinal + 1];
        }
        return this;
    }

    public DimensionStatus unNotify() {
        if (this.notified) {
            DimensionStatus dimensionStatus = values[this.ordinal - 1];
            if (!dimensionStatus.notified) {
                return dimensionStatus;
            }
            return DefaultUnNotify;
        }
        return this;
    }
}
