package cooperation.qzone.zipanimate;

import android.graphics.drawable.Drawable;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface ZipDrawableLoaderInterface {
    int getCurFrameNum();

    Drawable getCurrentDrawable();

    int getFrameCount();

    CopyOnWriteArrayList<AnimationFrame> getFrames();

    void loadFrame(int i3, ZipFrameLoadedListener zipFrameLoadedListener);

    boolean nextFrame();

    void release();

    void setDrawableData(String str, int i3, boolean z16);

    void setDrawableData(String str, String str2, String str3, int i3, boolean z16);

    void setFrame(int i3);

    void setPreloadNum(int i3);

    void setRecycleFlag(boolean z16);

    void setSize(int i3, int i16);

    void setZipLoadedListener(ZipLoadedListener zipLoadedListener);
}
