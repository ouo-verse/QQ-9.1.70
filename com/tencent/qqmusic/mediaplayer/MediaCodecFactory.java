package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.ape.ApeRecognition;
import com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegRecognition;
import com.tencent.qqmusic.mediaplayer.codec.flac.FLACRecognition;
import com.tencent.qqmusic.mediaplayer.codec.mp3.MP3Recognition;
import com.tencent.qqmusic.mediaplayer.codec.ogg.VorbisRecognition;
import com.tencent.qqmusic.mediaplayer.codec.wav.WavRecognition;
import com.tencent.qqmusic.mediaplayer.codec.wma.WmaRecognition;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MediaCodecFactory {
    private static final String TAG = "MediaCodecFactory";
    private static HashMap<AudioFormat.AudioType, Class<? extends IAudioRecognition>> mDecoderMap = new HashMap<>();
    private static ArrayList<AudioFormat.AudioType> mSupportAudioType = new ArrayList<>();

    static {
        registerDecoder(AudioFormat.AudioType.M4A, FfmpegRecognition.class);
        registerDecoder(AudioFormat.AudioType.OGG, VorbisRecognition.class);
        registerDecoder(AudioFormat.AudioType.FLAC, FLACRecognition.class);
        registerDecoder(AudioFormat.AudioType.MP3, MP3Recognition.class);
        registerDecoder(AudioFormat.AudioType.APE, ApeRecognition.class);
        registerDecoder(AudioFormat.AudioType.WAV, WavRecognition.class);
        registerDecoder(AudioFormat.AudioType.WMA, WmaRecognition.class);
        registerDecoder(AudioFormat.AudioType.MP4, FfmpegRecognition.class);
        registerDecoder(AudioFormat.AudioType.AAC, FfmpegRecognition.class);
    }

    public static IAudioRecognition createDecoderByType(AudioFormat.AudioType audioType) {
        if (!AudioFormat.isAudioType(audioType) || !mDecoderMap.containsKey(audioType)) {
            return null;
        }
        try {
            return mDecoderMap.get(audioType).newInstance();
        } catch (Throwable th5) {
            Logger.e(TAG, "createDecoderByType error", th5);
            return null;
        }
    }

    public static ArrayList<AudioFormat.AudioType> getSupportAudioType() {
        return new ArrayList<>(mSupportAudioType);
    }

    private static void registerDecoder(AudioFormat.AudioType audioType, Class<? extends IAudioRecognition> cls) {
        mDecoderMap.put(audioType, cls);
        mSupportAudioType.add(audioType);
    }

    public static void unRegisterDecoder(AudioFormat.AudioType audioType) {
        mSupportAudioType.remove(audioType);
        mDecoderMap.remove(audioType);
    }
}
