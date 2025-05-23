package com.caverock.androidsvg;

/* loaded from: classes.dex */
public class PreserveAspectRatio {
    public static final PreserveAspectRatio BOTTOM;
    public static final PreserveAspectRatio END;
    public static final PreserveAspectRatio FULLSCREEN;
    public static final PreserveAspectRatio FULLSCREEN_START;
    public static final PreserveAspectRatio LETTERBOX;
    public static final PreserveAspectRatio START;
    public static final PreserveAspectRatio TOP;
    private Alignment alignment;
    private Scale scale;
    public static final PreserveAspectRatio UNSCALED = new PreserveAspectRatio(null, null);
    public static final PreserveAspectRatio STRETCH = new PreserveAspectRatio(Alignment.None, null);

    /* loaded from: classes.dex */
    public enum Alignment {
        None,
        XMinYMin,
        XMidYMin,
        XMaxYMin,
        XMinYMid,
        XMidYMid,
        XMaxYMid,
        XMinYMax,
        XMidYMax,
        XMaxYMax;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Alignment[] valuesCustom() {
            Alignment[] valuesCustom = values();
            int length = valuesCustom.length;
            Alignment[] alignmentArr = new Alignment[length];
            System.arraycopy(valuesCustom, 0, alignmentArr, 0, length);
            return alignmentArr;
        }
    }

    /* loaded from: classes.dex */
    public enum Scale {
        Meet,
        Slice;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Scale[] valuesCustom() {
            Scale[] valuesCustom = values();
            int length = valuesCustom.length;
            Scale[] scaleArr = new Scale[length];
            System.arraycopy(valuesCustom, 0, scaleArr, 0, length);
            return scaleArr;
        }
    }

    static {
        Alignment alignment = Alignment.XMidYMid;
        Scale scale = Scale.Meet;
        LETTERBOX = new PreserveAspectRatio(alignment, scale);
        Alignment alignment2 = Alignment.XMinYMin;
        START = new PreserveAspectRatio(alignment2, scale);
        END = new PreserveAspectRatio(Alignment.XMaxYMax, scale);
        TOP = new PreserveAspectRatio(Alignment.XMidYMin, scale);
        BOTTOM = new PreserveAspectRatio(Alignment.XMidYMax, scale);
        Scale scale2 = Scale.Slice;
        FULLSCREEN = new PreserveAspectRatio(alignment, scale2);
        FULLSCREEN_START = new PreserveAspectRatio(alignment2, scale2);
    }

    public PreserveAspectRatio(Alignment alignment, Scale scale) {
        this.alignment = alignment;
        this.scale = scale;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
        if (this.alignment == preserveAspectRatio.alignment && this.scale == preserveAspectRatio.scale) {
            return true;
        }
        return false;
    }

    public Alignment getAlignment() {
        return this.alignment;
    }

    public Scale getScale() {
        return this.scale;
    }
}
