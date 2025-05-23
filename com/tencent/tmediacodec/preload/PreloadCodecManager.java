package com.tencent.tmediacodec.preload;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmediacodec.TCodecManager;
import com.tencent.tmediacodec.TMediaCodec;
import com.tencent.tmediacodec.preload.glrender.OutputSurface;
import com.tencent.tmediacodec.reuse.ReusePolicy;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.TUtils;
import com.tencent.tmediacodec.util.ThreadManager;
import java.util.Set;

/* loaded from: classes26.dex */
public final class PreloadCodecManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PreloadCodecManager";
    private boolean isPreloaded;

    public PreloadCodecManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final MediaFormat getPreloadMediaFormat(String str) {
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
    private final Surface getSurface() {
        return new OutputSurface(1, 1).getSurface();
    }

    public static boolean isInvalideMimeType(String str) {
        if (!TextUtils.equals(str, "video/avc") && !TextUtils.equals(str, "video/hevc")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void preloadCodecByMimeType(String str) {
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

    public final void preload(@NonNull Set<String> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) set);
            return;
        }
        if (!this.isPreloaded) {
            ThreadManager.execute(new Runnable(set) { // from class: com.tencent.tmediacodec.preload.PreloadCodecManager.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Set val$sampleMimeTypeSet;

                {
                    this.val$sampleMimeTypeSet = set;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreloadCodecManager.this, (Object) set);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    for (String str : this.val$sampleMimeTypeSet) {
                        if (PreloadCodecManager.isInvalideMimeType(str)) {
                            PreloadCodecManager.this.preloadCodecByMimeType(str);
                        }
                    }
                }
            });
            return;
        }
        LogUtils.w(TAG, "preload codec return, for isPreload:" + this.isPreloaded + " apiLevel:" + Build.VERSION.SDK_INT);
    }
}
