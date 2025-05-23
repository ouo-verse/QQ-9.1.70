package com.tencent.aelight.camera.struct.camera;

import android.graphics.Bitmap;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class AEPhotoCaptureResult implements Serializable {
    public static final int TYPE_CAPTURE_FRAME = 0;
    public static final int TYPE_TAKE_PICTURE = 1;
    public Bitmap bitmap;
    public int errorCode;
    public String filePath;
    public int orientation;
    public long photoId;
    public int type;

    public AEPhotoCaptureResult(int i3, int i16, String str, Bitmap bitmap, long j3, int i17) {
        this.type = i3;
        this.errorCode = i16;
        this.filePath = str;
        this.bitmap = bitmap;
        this.photoId = j3;
        this.orientation = i17;
    }
}
