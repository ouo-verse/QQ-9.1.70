package com.tencent.tdf.embed;

import android.graphics.Rect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes26.dex */
public interface IGestureInfoProvider {
    public static final IPatchRedirector $redirector_ = null;
    public static final int kDoubleTap = 2;
    public static final int kForcePress = 16;
    public static final int kLongPress = 8;
    public static final int kMultiDrag = 128;
    public static final int kMultiTap = 4;
    public static final int kNone = 0;
    public static final int kPan = 32;
    public static final int kPinchRotate = 64;
    public static final int kTap = 1;

    boolean needUpdate();

    Rect provideHitTestRect();

    int provideSupportGestures();

    boolean useCustomHitTestRect();
}
