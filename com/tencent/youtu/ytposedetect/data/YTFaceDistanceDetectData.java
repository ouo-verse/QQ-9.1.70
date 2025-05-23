package com.tencent.youtu.ytposedetect.data;

import android.graphics.Rect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YTFaceDistanceDetectData {
    static IPatchRedirector $redirector_;
    public float detectScore;
    public FrameData[] frameList;
    public Rect[] processRect;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class FrameData {
        static IPatchRedirector $redirector_;
        public float areaRatio;
        public float[] faceAlign;
        public ImageData img;
        public float iou;
        public int rectH;
        public int rectW;
        public int rectX;
        public int rectY;
        public long timestamp;

        /* renamed from: x, reason: collision with root package name */
        public int f385208x;

        /* renamed from: y, reason: collision with root package name */
        public int f385209y;

        public FrameData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) YTFaceDistanceDetectData.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class ImageData {
        static IPatchRedirector $redirector_;
        public int height;
        public byte[] rgb;
        public int width;

        public ImageData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) YTFaceDistanceDetectData.this);
            }
        }
    }

    public YTFaceDistanceDetectData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
