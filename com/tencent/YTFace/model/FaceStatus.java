package com.tencent.YTFace.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FaceStatus implements Serializable {
    static IPatchRedirector $redirector_;
    public String cate_id;
    public float[] feature;
    public int height;
    public double illumination_score;
    public int left_eye_open;
    public float pitch;
    public int right_eye_open;
    public float roll;
    public float rotate;
    public int smile;
    public int trace_id;
    public int width;

    /* renamed from: x, reason: collision with root package name */
    public int f61315x;
    public float[] xys;

    /* renamed from: y, reason: collision with root package name */
    public int f61316y;
    public float yaw;

    public FaceStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.cate_id = "";
            this.smile = -1;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "FaceStatus{ pitch=" + this.pitch + ", yaw=" + this.yaw + ", roll=" + this.roll + ", illumination_score=" + this.illumination_score + ", trace_id=" + this.trace_id + ", x=" + this.f61315x + ", y=" + this.f61316y + ", width=" + this.width + ", height=" + this.height + '}';
    }
}
