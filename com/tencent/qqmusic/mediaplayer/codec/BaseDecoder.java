package com.tencent.qqmusic.mediaplayer.codec;

import android.media.AudioTrack;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.SoNotFindException;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class BaseDecoder {
    public int mNativeApeDecoderRef = 0;
    private AudioFormat.AudioType mAudioType = null;
    private final boolean mHasLoadSoSuccess = NativeLibs.loadAll(getNativeLibs());

    private void throwIfSoNotLoadSuccess() {
        if (this.mHasLoadSoSuccess) {
        } else {
            throw new SoNotFindException("has't load so success , can't call native funcation");
        }
    }

    public int decodeData(int i3, byte[] bArr) {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public AudioInformation getAudioInformation() {
        throwIfSoNotLoadSuccess();
        return null;
    }

    public AudioFormat.AudioType getAudioType() {
        return this.mAudioType;
    }

    public abstract long getBytePositionOfTime(long j3);

    public long getCurrentTime() {
        throwIfSoNotLoadSuccess();
        return -1L;
    }

    public long getDuration() {
        return -1L;
    }

    public int getErrorCodeMask() {
        return -1;
    }

    public long getMinBufferSize() {
        return 0L;
    }

    public abstract List<NativeLibs> getNativeLibs();

    public int init(String str, boolean z16) {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public int release() {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public int seekTo(int i3) {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public void setAudioType(AudioFormat.AudioType audioType) {
        this.mAudioType = audioType;
    }

    public int init(IDataSource iDataSource) {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public int init(INativeDataSource iNativeDataSource) {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public void setAudioTrack(AudioTrack audioTrack) {
    }
}
