package com.tencent.thumbplayer.core.codec.tmediacodec.preload;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.codec.tmediacodec.TCodecManager;
import com.tencent.thumbplayer.core.codec.tmediacodec.TMediaCodec;
import com.tencent.thumbplayer.core.codec.tmediacodec.preload.glrender.OutputSurface;
import com.tencent.thumbplayer.core.codec.tmediacodec.reuse.ReusePolicy;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.LogUtils;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.TUtils;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.ThreadManager;
import java.util.Set;

/* loaded from: classes26.dex */
public final class PreloadCodecManager {
    private static final String TAG = "PreloadCodecManager";
    private boolean mIsPreloaded;

    private MediaFormat getPreloadMediaFormat(String str) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        ReusePolicy reusePolicy = TCodecManager.getInstance().getReusePolicy();
        int i3 = reusePolicy.initWidth;
        int i16 = reusePolicy.initHeight;
        int max = Math.max(0, TUtils.getCodecMaxInputSize(str, i3, i16));
        mediaFormat.setInteger("width", 1);
        mediaFormat.setInteger("height", 1);
        mediaFormat.setInteger("rotation-degrees", 0);
        mediaFormat.setInteger("max-input-size", Math.max(max, 0));
        mediaFormat.setInteger("max-width", i3);
        mediaFormat.setInteger("max-height", i16);
        return mediaFormat;
    }

    @TargetApi(17)
    private Surface getSurface() {
        return new OutputSurface(1, 1).getSurface();
    }

    public static boolean isInvalidMimeType(String str) {
        if (!TextUtils.equals(str, "video/avc") && !TextUtils.equals(str, "video/hevc")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadCodecByMimeType(String str) {
        Surface surface = getSurface();
        if (surface != null) {
            try {
                TMediaCodec createDecoderByType = TMediaCodec.createDecoderByType(str);
                createDecoderByType.configure(getPreloadMediaFormat(str), surface, (MediaCrypto) null, 0);
                createDecoderByType.start();
                createDecoderByType.stop();
                createDecoderByType.release();
                LogUtils.d(TAG, "preloadCodecByMimeType sampleMimeType:" + str + " surface:" + surface + " success");
                return;
            } catch (Throwable th5) {
                LogUtils.w(TAG, "preloadCodecByMimeType sampleMimeType:" + str + " exception...", th5);
                return;
            }
        }
        LogUtils.w(TAG, "preloadCodecByMimeType sampleMimeType:" + str + " failed...");
    }

    public final void preload(@NonNull final Set<String> set) {
        if (!this.mIsPreloaded) {
            ThreadManager.execute(new Runnable() { // from class: com.tencent.thumbplayer.core.codec.tmediacodec.preload.PreloadCodecManager.1
                @Override // java.lang.Runnable
                public void run() {
                    for (String str : set) {
                        if (PreloadCodecManager.isInvalidMimeType(str)) {
                            PreloadCodecManager.this.preloadCodecByMimeType(str);
                        }
                    }
                }
            });
            return;
        }
        LogUtils.w(TAG, "preload codec return, for isPreload:" + this.mIsPreloaded + " apiLevel:" + Build.VERSION.SDK_INT);
    }
}
