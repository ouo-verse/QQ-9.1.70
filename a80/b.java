package a80;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import org.libpag.PAGFile;

/* compiled from: P */
/* loaded from: classes4.dex */
public interface b {
    void a(f fVar);

    void b(@NonNull FrameLayout frameLayout);

    void c(f fVar);

    boolean flush();

    ViewGroup.LayoutParams getLayoutParams();

    boolean isPlaying();

    void play();

    void setComposition(PAGFile pAGFile);

    void setLayoutParams(FrameLayout.LayoutParams layoutParams);

    void setProgress(double d16);

    void setRepeatCount(int i3);

    void setScaleMode(int i3);

    void setStaticImageMode(boolean z16);

    void setVisibility(int i3);

    void stop();
}
