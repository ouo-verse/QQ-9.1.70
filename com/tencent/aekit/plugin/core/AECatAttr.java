package com.tencent.aekit.plugin.core;

import android.graphics.PointF;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AECatAttr {
    static IPatchRedirector $redirector_ = null;
    public static final int CAT_TRIGGER_TYPE = 700;
    private float[] angles;
    private List<PointF> catPointList;
    private int detectHeight;
    private long detectTime;
    private int detectWidth;

    public AECatAttr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.detectTime = 0L;
        this.catPointList = null;
        this.angles = new float[]{0.0f, 0.0f, 0.0f};
    }

    public float[] getAngles() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (float[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.angles;
    }

    public List<PointF> getCatPointList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.catPointList;
    }

    public int getDetectHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.detectHeight;
    }

    public int getDetectWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.detectWidth;
    }

    public void setAngles(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fArr);
        } else {
            this.angles = fArr;
        }
    }

    public void setCatPointList(List<PointF> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        } else {
            this.catPointList = list;
        }
    }

    public void setDetectHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.detectHeight = i3;
        }
    }

    public void setDetectTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.detectTime = j3;
        }
    }

    public void setDetectWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.detectWidth = i3;
        }
    }
}
