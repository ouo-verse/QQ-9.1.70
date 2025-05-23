package com.tencent.mobileqq.qqlive.api.room;

import android.view.Surface;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QCircleLiveFeedReplaceSurfaceEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;
    private long mRoomId;
    private Surface mSurface;

    public QCircleLiveFeedReplaceSurfaceEvent(long j3, Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), surface);
        } else {
            this.mRoomId = j3;
            this.mSurface = surface;
        }
    }

    public long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.mRoomId;
    }

    public Surface getSurface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Surface) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mSurface;
    }
}
