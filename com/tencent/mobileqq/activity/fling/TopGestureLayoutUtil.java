package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.view.GestureDetector;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.fling.FlingHelperUtils;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TopGestureLayoutUtil implements FlingHelperUtils.IFlingHelperUtils {
    static IPatchRedirector $redirector_;

    public TopGestureLayoutUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.fling.FlingHelperUtils.IFlingHelperUtils
    public boolean isDragFrameLayoutClass(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view)).booleanValue();
        }
        return view instanceof DragFrameLayout;
    }

    @Override // com.tencent.mobileqq.activity.fling.FlingHelperUtils.IFlingHelperUtils
    public boolean isInTwoFingerMode(@Nullable GestureDetector gestureDetector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) gestureDetector)).booleanValue();
        }
        if (gestureDetector instanceof StickerDismissGestureDetector) {
            return ((StickerDismissGestureDetector) gestureDetector).isInTowFingerMode;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.fling.FlingHelperUtils.IFlingHelperUtils
    public GestureDetector newStickerDismissGestureDetectorInstance(TopGestureLayout topGestureLayout, Context context, GestureDetector.OnGestureListener onGestureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (GestureDetector) iPatchRedirector.redirect((short) 4, this, topGestureLayout, context, onGestureListener);
        }
        return new StickerDismissGestureDetector(topGestureLayout, context, onGestureListener);
    }
}
