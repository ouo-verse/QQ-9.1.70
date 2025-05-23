package com.tencent.ams.mosaic.jsengine.component.video;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoContainerView extends FrameLayout {
    static IPatchRedirector $redirector_;

    public VideoContainerView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            setBackgroundColor(-16777216);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        com.tencent.ams.mosaic.utils.f.e("VideoSurfaceView", "onSizeChanged w:" + i3 + ", h:" + i16);
        View childAt = getChildAt(0);
        if (childAt instanceof VideoSurfaceView) {
            ((VideoSurfaceView) childAt).d(getWidth(), getHeight());
        }
    }
}
