package com.tencent.tav.extractor;

import android.media.MediaFormat;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.ResourceLoadUtil;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.wrapper.ExtractorLoader;
import com.tencent.tav.extractor.wrapper.ExtractorWrapperPool;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AssetExtractor implements Cloneable {
    public static boolean DOWNGRADING = false;
    public static final int SAMPLE_FLAG_ENCRYPTED = 2;
    public static final int SAMPLE_FLAG_SYNC = 1;
    public static final int SEEK_TO_CLOSEST_SYNC = 2;
    public static final int SEEK_TO_NEXT_SYNC = 1;
    public static final int SEEK_TO_PREVIOUS_SYNC = 0;
    private final String TAG;

    @Nullable
    private IExtractorDelegate delegate;
    private long duration;
    private long mNativeContext;
    private int preferRotation;
    private boolean released;
    private CGSize size;
    private String sourcePath;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface SampleFlag {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface SeekMode {
    }

    static {
        if (ResourceLoadUtil.isLoaded()) {
            nativeInit();
            Logger.w("AssetExtractor", "1.nativeInited");
        } else {
            System.out.println("loadlibrary : tav start");
            try {
                System.loadLibrary("tav");
                ResourceLoadUtil.setLoaded(true);
                nativeInit();
                Logger.w("AssetExtractor", "2.nativeInited");
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        DOWNGRADING = false;
    }

    public AssetExtractor() {
        this(DOWNGRADING);
    }

    private native synchronized boolean advanceNative();

    private native synchronized long getSampleTimeNative();

    private native synchronized int getSampleTrackIndexNative();

    private final native synchronized int getTrackCountNative();

    @NonNull
    private native synchronized Map<String, Object> getTrackFormatNative(int i3);

    private final native synchronized void nativeFinalize();

    private static final native synchronized void nativeInit();

    private native synchronized int readSampleDataNative(@NonNull ByteBuffer byteBuffer, int i3);

    private final native synchronized void releaseNative();

    private native void seekToNative(long j3, int i3);

    private native synchronized void selectTrackNative(int i3);

    private native synchronized void unselectTrackNative(int i3);

    public synchronized boolean advance() {
        IExtractorDelegate iExtractorDelegate = this.delegate;
        if (iExtractorDelegate != null) {
            return iExtractorDelegate.advance();
        }
        if (!this.released) {
            return advanceNative();
        }
        return false;
    }

    public synchronized void dispose() {
        if (this.sourcePath.isEmpty()) {
            return;
        }
        if (!this.released && this.delegate == null) {
            try {
                releaseNative();
            } catch (Exception e16) {
                Logger.w(this.TAG, "releaseNative: " + e16.getMessage());
            }
        }
    }

    protected void finalize() {
        if (this.delegate != null || this.released) {
            return;
        }
        synchronized (this) {
            if (!this.released) {
                this.released = true;
                nativeFinalize();
            }
        }
    }

    public synchronized long getAudioDuration() {
        return ExtractorUtils.getAudioDuration(this);
    }

    public synchronized long getDuration() {
        if (this.duration == 0) {
            this.duration = ExtractorUtils.getDuration(this);
        }
        return this.duration;
    }

    public synchronized int getPreferRotation() {
        if (this.preferRotation == -1) {
            this.preferRotation = ExtractorUtils.getPreferRotation(this);
        }
        return this.preferRotation;
    }

    public native int getSampleFlags();

    public synchronized long getSampleTime() {
        IExtractorDelegate iExtractorDelegate = this.delegate;
        if (iExtractorDelegate != null) {
            long sampleTime = iExtractorDelegate.getSampleTime();
            Logger.v(this.TAG, "getSampleTime(delegate) :" + sampleTime);
            return sampleTime;
        }
        if (!this.released) {
            long sampleTimeNative = getSampleTimeNative();
            Logger.v(this.TAG, "getSampleTime: " + sampleTimeNative);
            return sampleTimeNative;
        }
        return -1L;
    }

    public synchronized int getSampleTrackIndex() {
        IExtractorDelegate iExtractorDelegate = this.delegate;
        if (iExtractorDelegate != null) {
            return iExtractorDelegate.getSampleTrackIndex();
        }
        if (!this.released) {
            return getSampleTrackIndexNative();
        }
        return -1;
    }

    public synchronized CGSize getSize() {
        if (this.size == null) {
            this.size = ExtractorUtils.getVideoSize(this);
        }
        return this.size;
    }

    public String getSourcePath() {
        return this.sourcePath;
    }

    public final synchronized int getTrackCount() {
        IExtractorDelegate iExtractorDelegate = this.delegate;
        if (iExtractorDelegate != null) {
            return iExtractorDelegate.getTrackCount();
        }
        if (!this.released) {
            return getTrackCountNative();
        }
        return 0;
    }

    @NonNull
    public synchronized MediaFormat getTrackFormat(int i3) {
        IExtractorDelegate iExtractorDelegate = this.delegate;
        if (iExtractorDelegate != null) {
            try {
                MediaFormat trackFormat = iExtractorDelegate.getTrackFormat(i3);
                Logger.v(this.TAG, "getTrackFormat(delegate): index = " + i3 + ", format = " + trackFormat);
                return trackFormat;
            } catch (Exception e16) {
                Logger.w(this.TAG, "delegate.getTrackFormat: " + e16.getMessage());
            }
        }
        MediaFormat mediaFormat = new MediaFormat();
        if (this.released) {
            return mediaFormat;
        }
        Map<String, Object> trackFormatNative = getTrackFormatNative(i3);
        try {
            Field declaredField = MediaFormat.class.getDeclaredField("mMap");
            declaredField.setAccessible(true);
            declaredField.set(mediaFormat, trackFormatNative);
        } catch (Exception e17) {
            Log.e("VideoCore", e17.getMessage());
        }
        Logger.v(this.TAG, "getTrackFormat: index = " + i3 + ", format = " + mediaFormat);
        return mediaFormat;
    }

    public boolean isReleased() {
        return this.released;
    }

    public boolean needMirror() {
        IExtractorDelegate iExtractorDelegate = this.delegate;
        if (iExtractorDelegate != null) {
            return iExtractorDelegate.needMirror();
        }
        return true;
    }

    public synchronized int readSampleData(@NonNull ByteBuffer byteBuffer, int i3) {
        IExtractorDelegate iExtractorDelegate = this.delegate;
        if (iExtractorDelegate != null) {
            return iExtractorDelegate.readSampleData(byteBuffer, i3);
        }
        if (!this.released) {
            return readSampleDataNative(byteBuffer, i3);
        }
        return -1;
    }

    public final synchronized void release() {
        IExtractorDelegate iExtractorDelegate = this.delegate;
        if (iExtractorDelegate != null) {
            iExtractorDelegate.release();
            this.delegate = null;
            return;
        }
        if (!this.released) {
            try {
                releaseNative();
            } catch (Exception e16) {
                Logger.w(this.TAG, "releaseNative: " + e16.getMessage());
            }
            this.released = true;
        }
    }

    public synchronized void seekTo(long j3, int i3) {
        Logger.v(this.TAG, "seekTo() called with: timeUs = [" + j3 + "], mode = [" + i3 + "]");
        IExtractorDelegate iExtractorDelegate = this.delegate;
        if (iExtractorDelegate != null) {
            iExtractorDelegate.seekTo(j3, i3);
        } else {
            if (!this.released) {
                seekToNative(j3, i3);
            }
        }
    }

    public synchronized void selectTrack(int i3) {
        IExtractorDelegate iExtractorDelegate = this.delegate;
        if (iExtractorDelegate != null) {
            try {
                iExtractorDelegate.selectTrack(i3);
                return;
            } catch (Exception e16) {
                Logger.w(this.TAG, "delegate.selectTrack: " + e16.getMessage());
                this.delegate = null;
            }
        }
        if (!this.released) {
            selectTrackNative(i3);
        }
    }

    public final native void setDataSource(@NonNull FileDescriptor fileDescriptor, long j3, long j16) throws IOException;

    public final synchronized void setDataSource(@NonNull String str) {
        IExtractorDelegate iExtractorDelegate = this.delegate;
        if (iExtractorDelegate != null) {
            try {
                iExtractorDelegate.setDataSource(str);
            } catch (Exception e16) {
                Logger.w(this.TAG, "delegate.setDataSource: " + e16.getMessage());
                this.delegate = null;
            }
        }
        this.sourcePath = str;
        if (ExtractorWrapperPool.contains(str)) {
            ExtractorWrapperPool.fillIn(this.sourcePath, this);
            Logger.w(this.TAG, "setDataSource:ExtractorWrapperPool.fillIn");
        } else {
            ExtractorLoader.cacheExtractor(str);
            Logger.w(this.TAG, "setDataSource:ExtractorLoader.cacheExtractor");
        }
    }

    public void setDuration(long j3) {
        this.duration = j3;
    }

    public void setPreferRotation(int i3) {
        this.preferRotation = i3;
    }

    public void setSize(CGSize cGSize) {
        this.size = cGSize;
    }

    public synchronized void unselectTrack(int i3) {
        IExtractorDelegate iExtractorDelegate = this.delegate;
        if (iExtractorDelegate != null) {
            iExtractorDelegate.unselectTrack(i3);
        } else {
            if (!this.released) {
                unselectTrackNative(i3);
            }
        }
    }

    public AssetExtractor(boolean z16) {
        this.TAG = "AssetExtractor@" + Integer.toHexString(hashCode());
        this.released = false;
        this.mNativeContext = 0L;
        this.sourcePath = "";
        this.duration = 0L;
        this.size = null;
        this.preferRotation = -1;
        if (z16) {
            this.delegate = ExtractorDelegateFactory.createDelegate();
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AssetExtractor m264clone() {
        AssetExtractor assetExtractor = new AssetExtractor();
        assetExtractor.setSize(getSize());
        assetExtractor.setPreferRotation(getPreferRotation());
        assetExtractor.setDuration(getDuration());
        assetExtractor.setDataSource(this.sourcePath);
        return assetExtractor;
    }
}
