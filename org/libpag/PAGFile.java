package org.libpag;

import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;

/* loaded from: classes29.dex */
public class PAGFile extends PAGComposition {

    /* loaded from: classes29.dex */
    public interface LoadListener {
        void onLoad(PAGFile pAGFile);
    }

    static {
        org.extra.tools.a.b("pag");
        nativeInit();
    }

    PAGFile(long j3) {
        super(j3);
    }

    public static PAGFile Load(String str) {
        if (!TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"))) {
            byte[] a16 = b.a(str);
            if (a16 == null) {
                return null;
            }
            return LoadFromBytes(a16, a16.length, str);
        }
        return LoadFromPath(str);
    }

    public static void LoadAsync(final String str, final LoadListener loadListener) {
        NativeTask.Run(new Runnable() { // from class: org.libpag.e
            @Override // java.lang.Runnable
            public final void run() {
                PAGFile.a(str, loadListener);
            }
        });
    }

    private static native PAGFile LoadFromAssets(AssetManager assetManager, String str);

    private static native PAGFile LoadFromBytes(byte[] bArr, int i3, String str);

    private static native PAGFile LoadFromPath(String str);

    public static native int MaxSupportedTagLevel();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, LoadListener loadListener) {
        PAGFile Load = PagViewMonitor.Load(str);
        if (loadListener != null) {
            loadListener.onLoad(Load);
        }
    }

    private static final native void nativeInit();

    public native PAGFile copyOriginal();

    public native int[] getEditableIndices(int i3);

    public native PAGLayer[] getLayersByEditableIndex(int i3, int i16);

    public native PAGText getTextData(int i3);

    public native void nativeReplaceImage(int i3, long j3);

    public native void nativeReplaceImageByName(String str, long j3);

    public native int numImages();

    public native int numTexts();

    public native int numVideos();

    public native String path();

    public void replaceImage(int i3, PAGImage pAGImage) {
        if (pAGImage == null) {
            nativeReplaceImage(i3, 0L);
        } else {
            nativeReplaceImage(i3, pAGImage.nativeContext);
        }
    }

    public void replaceImageByName(String str, PAGImage pAGImage) {
        if (pAGImage == null) {
            nativeReplaceImageByName(str, 0L);
        } else {
            nativeReplaceImageByName(str, pAGImage.nativeContext);
        }
    }

    public native void replaceText(int i3, PAGText pAGText);

    public native void setDuration(long j3);

    public native void setTimeStretchMode(int i3);

    public native int tagLevel();

    public native int timeStretchMode();

    public static PAGFile Load(byte[] bArr) {
        return LoadFromBytes(bArr, bArr.length, "");
    }

    public static PAGFile Load(AssetManager assetManager, String str) {
        return LoadFromAssets(assetManager, str);
    }
}
