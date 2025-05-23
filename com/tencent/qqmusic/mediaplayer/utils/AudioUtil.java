package com.tencent.qqmusic.mediaplayer.utils;

import android.media.AudioTrack;
import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.audioplaylist.AudioPlayListItemInfo;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.seektable.NativeSeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AudioUtil {
    private static final int DEFAULT_DECODE_BUFFER_SIZE = 8192;
    private static final String TAG = "AudioUtil";

    public static int getDecodeBufferSize(NativeDecoder nativeDecoder) {
        int i3;
        AudioInformation audioInformation = nativeDecoder.getAudioInformation();
        if (audioInformation != null && audioInformation.getAudioType() == AudioFormat.AudioType.FLAC) {
            i3 = (int) nativeDecoder.getMinBufferSize();
        } else {
            i3 = 0;
        }
        if (i3 <= 0) {
            return 8192;
        }
        return i3;
    }

    public static int getDecodeBufferSizeForPlay(NativeDecoder nativeDecoder) {
        int i3;
        int decodeBufferSize = getDecodeBufferSize(nativeDecoder);
        AudioInformation audioInformation = nativeDecoder.getAudioInformation();
        if (audioInformation != null && audioInformation.getAudioType() != AudioFormat.AudioType.FLAC) {
            int channels = audioInformation.getChannels();
            int i16 = 2;
            if (channels == 1) {
                i3 = 4;
            } else {
                if (channels != 2) {
                    if (channels == 6) {
                        i3 = 252;
                    } else if (channels == 8) {
                        i3 = 1020;
                    }
                }
                i3 = 12;
            }
            if (audioInformation.getBitDepth() == 1) {
                i16 = 3;
            }
            return Math.max(AudioTrack.getMinBufferSize((int) audioInformation.getSampleRate(), i3, i16), decodeBufferSize);
        }
        return decodeBufferSize;
    }

    public static NativeDecoder getDecoder(String str, boolean z16, long j3, long j16) {
        if (z16) {
            return getDecoderFromTrack(str, j3, j16);
        }
        return AudioRecognition.getDecoderFormFile(str);
    }

    public static NativeDecoder getDecoderFromTrack(String str, long j3, long j16) {
        if (TextUtils.isEmpty(str) || j3 >= j16) {
            return null;
        }
        NativeDecoder nativeDecoder = new NativeDecoder();
        TrackInfo trackInfo = new TrackInfo(AudioPlayListItemInfo.TYPE_CUE);
        trackInfo.setFilePath(str);
        trackInfo.setStartPosition(j3);
        trackInfo.setEndPostion(j16);
        try {
            TrackDataSource trackDataSource = new TrackDataSource(trackInfo);
            if (nativeDecoder.init(trackDataSource) != 0) {
                Logger.e(TAG, "init decoder from track failed!");
                return null;
            }
            long seek = new NativeSeekTable(nativeDecoder).seek(j16);
            if (seek <= 0) {
                Logger.e(TAG, "endPos from track <= 0");
                return null;
            }
            trackDataSource.setEndBytePosition(seek);
            nativeDecoder.seekTo((int) j3);
            return nativeDecoder;
        } catch (Exception e16) {
            Logger.e(TAG, e16);
            return null;
        }
    }

    public static int getPlaybackHeadPositionSafely(AudioTrack audioTrack) {
        if (audioTrack != null) {
            try {
                return audioTrack.getPlaybackHeadPosition();
            } catch (Exception e16) {
                Logger.e(TAG, "getPlaybackHeadPositionSafely", e16);
            }
        }
        return 0;
    }
}
