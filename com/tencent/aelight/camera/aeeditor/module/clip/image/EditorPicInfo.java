package com.tencent.aelight.camera.aeeditor.module.clip.image;

import java.io.Serializable;

/* loaded from: classes32.dex */
public class EditorPicInfo implements Serializable {

    /* renamed from: h, reason: collision with root package name */
    public double f66184h;
    public double originPicHeight;
    public double originPicWidth;
    public String picPath;
    public double rotate;

    /* renamed from: w, reason: collision with root package name */
    public double f66185w;

    /* renamed from: x, reason: collision with root package name */
    public double f66186x;

    /* renamed from: y, reason: collision with root package name */
    public double f66187y;

    public String toString() {
        return "EditorPicInfo{picPath=" + this.picPath + ", x=" + this.f66186x + ", y=" + this.f66187y + ", w=" + this.f66185w + ", h=" + this.f66184h + ", rotate=" + this.rotate + ", originPicWidth=" + this.originPicWidth + ", originPicHeight=" + this.originPicHeight + "}";
    }
}
