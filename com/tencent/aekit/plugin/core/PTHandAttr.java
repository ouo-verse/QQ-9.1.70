package com.tencent.aekit.plugin.core;

import android.graphics.PointF;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;

/* loaded from: classes3.dex */
public class PTHandAttr {
    static IPatchRedirector $redirector_ = null;
    public static final int FORE_FINGER = 2;
    public static final int HAND_LABEL_EIGHT = 211;
    public static final int HAND_LABEL_FINGER = 220;
    public static final int HAND_LABEL_FIST = 204;
    public static final int HAND_LABEL_FOUR = 214;
    public static final int HAND_LABEL_HAND = 200;
    public static final int HAND_LABEL_HEART = 201;
    public static final int HAND_LABEL_LIFT = 212;
    public static final int HAND_LABEL_LIKE = 207;
    public static final int HAND_LABEL_LOVE = 206;
    public static final int HAND_LABEL_OK = 208;
    public static final int HAND_LABEL_ONE = 205;
    public static final int HAND_LABEL_PAPER = 202;
    public static final int HAND_LABEL_ROCK = 209;
    public static final int HAND_LABEL_SCISSOR = 203;
    public static final int HAND_LABEL_SIX = 210;
    public static final int HAND_LABEL_ST_BLESS = 214;
    public static final int HAND_LABEL_ST_CONGRATULATE = 213;
    public static final int HAND_LABEL_ST_ILOVEYOU = 215;
    public static final int HAND_LABEL_THREE = 213;
    public static final int LITTLE_FINGER = 5;
    public static final int MIDDLE_FINGER = 3;
    public static final int RING_FINGER = 4;
    public static final int THUMB_FINGER = 1;
    public static final int[] handTypes;
    protected float confidence;
    private int detectHeight;
    private int detectWidth;
    private long gestureTime;
    private List<PointF> handPointList;
    protected int handType;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12218);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            handTypes = new int[]{200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 213, 214, 215};
        }
    }

    public PTHandAttr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.handPointList = null;
        this.handType = 0;
        this.gestureTime = 0L;
        this.confidence = 0.0f;
    }

    public float getConfidence() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this)).floatValue();
        }
        return this.confidence;
    }

    public int getDetectHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.detectHeight;
    }

    public int getDetectWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.detectWidth;
    }

    public long getGestureDetectTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return this.gestureTime;
    }

    public List<PointF> getHandPointList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.handPointList;
    }

    public int getHandType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.handType;
    }

    public int getHandTypeIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i3 = this.handType;
        if (i3 >= 201) {
            return i3 - 201;
        }
        return -1;
    }

    public void setConfidence(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
        } else {
            this.confidence = f16;
        }
    }

    public void setDetectHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.detectHeight = i3;
        }
    }

    public void setDetectWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.detectWidth = i3;
        }
    }

    public void setGestureTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            this.gestureTime = j3;
        }
    }

    public void setHandPointList(List<PointF> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        } else {
            this.handPointList = list;
        }
    }

    public void setHandType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.handType = i3;
        }
    }
}
