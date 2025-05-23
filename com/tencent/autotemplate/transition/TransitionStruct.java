package com.tencent.autotemplate.transition;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.TAVClip;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TransitionStruct {
    static IPatchRedirector $redirector_;
    public List<List<TAVClip>> channels;
    public List<TAVClip> curChannel;
    public TAVClip curClip;
    public int index;
    public List<TAVClip> lastChannel;
    public TAVClip lastClip;
    public CMTime lastTransitionEndTime;
    public long totalDurationMsInTimeLine;

    public TransitionStruct() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.totalDurationMsInTimeLine = 0L;
        this.lastTransitionEndTime = CMTime.CMTimeZero;
        this.lastClip = null;
        this.curClip = null;
        this.lastChannel = null;
    }
}
