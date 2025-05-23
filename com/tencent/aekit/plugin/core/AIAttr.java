package com.tencent.aekit.plugin.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AIAttr {
    static IPatchRedirector $redirector_;
    private AIAttrProvider aiAttrProvider;
    private long mNextSurfaceTime;
    private long mSurfaceTime;
    private int outTexture;
    private int texHeight;
    private int texWidth;

    public AIAttr(AIAttrProvider aIAttrProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIAttrProvider);
        } else {
            this.outTexture = -1;
            this.aiAttrProvider = aIAttrProvider;
        }
    }

    public Object getAvailableData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        AIAttrProvider aIAttrProvider = this.aiAttrProvider;
        if (aIAttrProvider == null) {
            return null;
        }
        return aIAttrProvider.getAvailableData(str);
    }

    public Object getFaceAttr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return getRealtimeData(AEDetectorType.FACE.value);
    }

    public long getNextSurfaceTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.mNextSurfaceTime;
    }

    public int getOutTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.outTexture;
    }

    public Object getRealtimeData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        AIAttrProvider aIAttrProvider = this.aiAttrProvider;
        if (aIAttrProvider == null) {
            return null;
        }
        return aIAttrProvider.getRealtimeData(str);
    }

    public float[] getRotationMatrix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (float[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        AIAttrProvider aIAttrProvider = this.aiAttrProvider;
        if (aIAttrProvider == null) {
            return null;
        }
        return aIAttrProvider.getRotationMatrix();
    }

    public long getSurfaceTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.mSurfaceTime;
    }

    public int getTexHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.texHeight;
    }

    public int getTexWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.texWidth;
    }

    public void setFaceAttr(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, obj);
            return;
        }
        AIAttrProvider aIAttrProvider = this.aiAttrProvider;
        if (aIAttrProvider != null) {
            aIAttrProvider.setFaceAttr(obj);
        }
    }

    public void setNextSurfaceTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, j3);
        } else {
            this.mNextSurfaceTime = j3;
        }
    }

    public void setOutTexture(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.outTexture = i3;
        }
    }

    public void setSurfaceTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
        } else {
            this.mSurfaceTime = j3;
        }
    }

    public void setTexHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.texHeight = i3;
        }
    }

    public void setTexWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.texWidth = i3;
        }
    }

    public void setTexWidthAndHeight(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.texWidth = i3;
            this.texHeight = i16;
        }
    }
}
