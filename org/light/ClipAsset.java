package org.light;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcel;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ClipAsset {
    public static int EXTERNAL = 3;
    public static int PHOTO = 1;
    public static int VIDEO;
    public RectF clipRect;
    public long duration;
    public Matrix matrix;
    public String path;
    protected int type;

    public ClipAsset() {
        this.type = -1;
        this.clipRect = new RectF();
        this.matrix = new Matrix();
    }

    public int type() {
        return this.type;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ClipAsset(Parcel parcel) {
        this.type = -1;
        this.clipRect = new RectF();
        this.matrix = new Matrix();
        this.type = parcel.readInt();
        this.duration = parcel.readLong();
        this.path = parcel.readString();
        this.clipRect = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
        float[] fArr = new float[9];
        parcel.readFloatArray(fArr);
        this.matrix.setValues(fArr);
    }
}
