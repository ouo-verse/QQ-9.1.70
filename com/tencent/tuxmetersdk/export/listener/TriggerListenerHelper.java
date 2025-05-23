package com.tencent.tuxmetersdk.export.listener;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback;
import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TriggerListenerHelper {
    static IPatchRedirector $redirector_;
    List<ITuxTriggerListener> listenerList;

    public TriggerListenerHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.listenerList = new ArrayList();
        }
    }

    public void addTriggerListener(ITuxTriggerListener iTuxTriggerListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iTuxTriggerListener);
        } else {
            if (iTuxTriggerListener == null) {
                return;
            }
            this.listenerList.add(iTuxTriggerListener);
        }
    }

    public void doTriggerListeners(TuxSurveyConfig tuxSurveyConfig, ITuxSurveyEventCallback iTuxSurveyEventCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) tuxSurveyConfig, (Object) iTuxSurveyEventCallback);
            return;
        }
        Iterator it = new ArrayList(this.listenerList).iterator();
        while (it.hasNext()) {
            ITuxTriggerListener iTuxTriggerListener = (ITuxTriggerListener) it.next();
            if (iTuxTriggerListener != null) {
                iTuxTriggerListener.onTrigger(tuxSurveyConfig, iTuxSurveyEventCallback);
            }
        }
    }

    public void removeAllTriggerListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.listenerList.clear();
        }
    }

    public void removeTriggerListener(ITuxTriggerListener iTuxTriggerListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iTuxTriggerListener);
        } else {
            if (iTuxTriggerListener == null) {
                return;
            }
            this.listenerList.remove(iTuxTriggerListener);
        }
    }
}
