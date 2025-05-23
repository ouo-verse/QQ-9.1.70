package e04;

import android.graphics.Rect;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface b {
    Rect getAnimationEndDstRect();

    boolean needEnterRectAnimation();

    boolean needExitRectAnimation();

    void onEnterAnimationEnd();

    void onEnterAnimationStart();

    void onExitAnimationEnd();

    void onExitAnimationStart();
}
