package com.tencent.ams.dsdk.core;

import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKHippyViewEvent {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKHippyViewEvent";
    private final String mEventName;

    public DKHippyViewEvent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.mEventName = str;
        }
    }

    public void send(View view, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, obj);
            return;
        }
        if (!TextUtils.isEmpty(this.mEventName)) {
            new HippyViewEvent(this.mEventName).send(view, obj);
            DLog.d(TAG, "send event:" + this.mEventName + ", view:" + view + ", data:" + obj);
            return;
        }
        DLog.e(TAG, "send event failed: invalid event name");
    }
}
