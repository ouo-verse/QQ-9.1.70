package com.tencent.youtu.ytagreflectlivecheck.jni.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester;
import java.util.ArrayList;

/* loaded from: classes27.dex */
public class PersonLive {
    static IPatchRedirector $redirector_;
    private String app_id;
    public String client_version;
    private String color_data;
    private ArrayList<FaceFrame> frames;
    private int platform;
    private ReflectColorData reflect_data;
    public LiveStyleRequester.SeleceData select_data;

    public PersonLive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.app_id = "";
        }
    }

    public String getColor_data() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.color_data;
    }

    public ArrayList<FaceFrame> getFrames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.frames;
    }

    public int getPlatform() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.platform;
    }

    public ReflectColorData getReflect_data() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ReflectColorData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.reflect_data;
    }

    public void setColor_data(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.color_data = str;
        }
    }

    public void setFrames(ArrayList<FaceFrame> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) arrayList);
        } else {
            this.frames = arrayList;
        }
    }

    public void setPlatform(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.platform = i3;
        }
    }

    public void setReflect_data(ReflectColorData reflectColorData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) reflectColorData);
        } else {
            this.reflect_data = reflectColorData;
        }
    }
}
