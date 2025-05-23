package com.tencent.richframework.widget.refresh.layout.constant;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SpinnerStyle {
    public static final SpinnerStyle FixedBehind;
    public static final SpinnerStyle FixedFront;
    public static final SpinnerStyle MatchLayout;

    @Deprecated
    public static final SpinnerStyle Scale;
    public static final SpinnerStyle Translate;
    public static final SpinnerStyle[] values;
    public final boolean front;
    public final int ordinal;
    public final boolean scale;

    static {
        SpinnerStyle spinnerStyle = new SpinnerStyle(0, true, false);
        Translate = spinnerStyle;
        SpinnerStyle spinnerStyle2 = new SpinnerStyle(1, true, true);
        Scale = spinnerStyle2;
        SpinnerStyle spinnerStyle3 = new SpinnerStyle(2, false, false);
        FixedBehind = spinnerStyle3;
        SpinnerStyle spinnerStyle4 = new SpinnerStyle(3, true, false);
        FixedFront = spinnerStyle4;
        SpinnerStyle spinnerStyle5 = new SpinnerStyle(4, true, false);
        MatchLayout = spinnerStyle5;
        values = new SpinnerStyle[]{spinnerStyle, spinnerStyle2, spinnerStyle3, spinnerStyle4, spinnerStyle5};
    }

    protected SpinnerStyle(int i3, boolean z16, boolean z17) {
        this.ordinal = i3;
        this.front = z16;
        this.scale = z17;
    }
}
