package com.tencent.mobileqq.qqlive.data.room.stream;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ServiceStreamInfo {
    static IPatchRedirector $redirector_;
    public ArrayList<ServiceFrameInfo> frames;
    public String name;
    public int rawLevel;

    public ServiceStreamInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.frames = new ArrayList<>();
            this.name = "";
        }
    }
}
