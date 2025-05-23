package SLICE_UPLOAD;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UploadModel implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _MODEL_COMPOSITE_UPLOAD = 2;
    public static final int _MODEL_NORMAL = 0;
    public static final int _MODEL_PRE_UPLOAD = 1;
    private String __T;
    private int __value;
    private static UploadModel[] __values = new UploadModel[3];
    public static final UploadModel MODEL_NORMAL = new UploadModel(0, 0, "MODEL_NORMAL");
    public static final UploadModel MODEL_PRE_UPLOAD = new UploadModel(1, 1, "MODEL_PRE_UPLOAD");
    public static final UploadModel MODEL_COMPOSITE_UPLOAD = new UploadModel(2, 2, "MODEL_COMPOSITE_UPLOAD");

    UploadModel(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static UploadModel convert(int i3) {
        int i16 = 0;
        while (true) {
            UploadModel[] uploadModelArr = __values;
            if (i16 >= uploadModelArr.length) {
                return null;
            }
            if (uploadModelArr[i16].value() == i3) {
                return __values[i16];
            }
            i16++;
        }
    }

    public String toString() {
        return this.__T;
    }

    public int value() {
        return this.__value;
    }

    public static UploadModel convert(String str) {
        int i3 = 0;
        while (true) {
            UploadModel[] uploadModelArr = __values;
            if (i3 >= uploadModelArr.length) {
                return null;
            }
            if (uploadModelArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
