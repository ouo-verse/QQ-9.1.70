package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.MediaCodecDecoder;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AudioRecognition {
    private static final int READ_FILE_HEADER_SIZE = 64;
    private static String TAG = "AudioRecognition";
    private static HashMap<String, AudioFormat.AudioType> mRecognitionResultCache = new HashMap<>();
    private static HashMap<String, AudioFormat.AudioType> mGuessFormatResultCache = new HashMap<>();

    public static int calcBitDept(long j3, long j16, int i3, long j17) {
        if (0 != j16 && i3 != 0) {
            double d16 = (((float) j3) * 1000.0f) / ((float) ((i3 * j16) * j17));
            int round = (int) Math.round(d16);
            Logger.i(TAG, "byteNumbers = " + j3 + ",time = " + j16 + ",channels = " + i3 + ",sampleRate = " + j17 + ",bitDept = " + d16);
            return round;
        }
        return 0;
    }

    public static int getAudioBitDept(BaseDecoder baseDecoder, AudioInformation audioInformation) {
        boolean z16;
        int i3 = 0;
        if (audioInformation.getAudioType() == AudioFormat.AudioType.FLAC) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                i3 = (int) baseDecoder.getMinBufferSize();
            } catch (Throwable th5) {
                Logger.e(TAG, th5);
            }
        }
        int minBufferSize = AudioTrack.getMinBufferSize((int) audioInformation.getSampleRate(), audioInformation.getChannels(), 2);
        if (!z16) {
            if (minBufferSize % 2048 != 0) {
                i3 = ((minBufferSize / 2048) + 1) * 2048;
            } else {
                i3 = minBufferSize;
            }
        }
        int decodeData = baseDecoder.decodeData(i3, new byte[i3]);
        if (decodeData <= 0) {
            decodeData = i3 * 2;
        }
        return calcBitDept(decodeData, baseDecoder.getCurrentTime(), audioInformation.getChannels(), audioInformation.getSampleRate());
    }

    public static NativeDecoder getDecoderFormFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        NativeDecoder nativeDecoder = new NativeDecoder();
        if (nativeDecoder.init(str, false) != 0) {
            return null;
        }
        return nativeDecoder;
    }

    public static AudioFormat.AudioType guessFormat(String str) {
        HashMap<String, AudioFormat.AudioType> hashMap = mGuessFormatResultCache;
        if (hashMap != null && hashMap.containsKey(str)) {
            return mGuessFormatResultCache.get(str);
        }
        Iterator<AudioFormat.AudioType> it = MediaCodecFactory.getSupportAudioType().iterator();
        while (it.hasNext()) {
            IAudioRecognition createDecoderByType = MediaCodecFactory.createDecoderByType(it.next());
            if (createDecoderByType != null) {
                AudioFormat.AudioType guessAudioType = createDecoderByType.guessAudioType(str);
                if (AudioFormat.isAudioType(guessAudioType)) {
                    mGuessFormatResultCache.put(str, guessAudioType);
                    return guessAudioType;
                }
            }
        }
        return AudioFormat.AudioType.UNSUPPORT;
    }

    public static AudioFormat.AudioType recognitionAudioFormatByExtensions(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (mRecognitionResultCache.containsKey(str)) {
            AudioFormat.AudioType audioType = mRecognitionResultCache.get(str);
            Logger.w(TAG, "Get from cache " + audioType + ",filepath = " + str + ",retType = " + audioType);
            return audioType;
        }
        AudioFormat.AudioType guessFormat = guessFormat(str);
        if (!AudioFormat.isAudioType(guessFormat)) {
            Logger.i(TAG, "recognitionAudioFormatByExtensions guessAudioType = null,so recognitionAudioFormatExactly filepath = " + str);
            try {
                guessFormat = recognitionAudioFormatExactly(str);
            } catch (IOException e16) {
                Logger.e(TAG, e16);
            }
        }
        Logger.i(TAG, "recognitionAudioFormatByExtensions filepath = " + str + ",guessAudioType = " + guessFormat);
        return guessFormat;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x015f A[EDGE_INSN: B:51:0x015f->B:19:0x015f BREAK  A[LOOP:0: B:35:0x00ed->B:46:0x00ed], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AudioFormat.AudioType recognitionAudioFormatExactly(String str) throws IOException {
        Exception exc;
        byte[] bArr;
        Iterator<AudioFormat.AudioType> it;
        AudioFormat.AudioType audioType;
        ?? r06 = 0;
        r0 = null;
        byte[] bArr2 = null;
        FileInputStream fileInputStream = null;
        if (str == null) {
            return null;
        }
        mGuessFormatResultCache.remove(str);
        Logger.i(TAG, "recognitionAudioFormatExactly  path = " + str);
        File file = new File(str);
        if (file.exists()) {
            if (file.canRead()) {
                Logger.i(TAG, "recognitionAudioFormatExactly file length = " + file.length());
                long currentTimeMillis = System.currentTimeMillis();
                AudioFormat.AudioType guessFormat = guessFormat(str);
                ArrayList<AudioFormat.AudioType> supportAudioType = MediaCodecFactory.getSupportAudioType();
                if (guessFormat != null && supportAudioType.contains(guessFormat)) {
                    supportAudioType.remove(guessFormat);
                    supportAudioType.add(0, guessFormat);
                    if (AudioFormat.AudioType.MP3.equals(guessFormat)) {
                        AudioFormat.AudioType audioType2 = AudioFormat.AudioType.FLAC;
                        supportAudioType.remove(audioType2);
                        supportAudioType.add(0, audioType2);
                    }
                }
                AudioFormat.AudioType audioType3 = MediaCodecDecoder.getAudioType(str);
                try {
                    if (!AudioFormat.isAudioType(audioType3)) {
                        try {
                            FileInputStream fileInputStream2 = new FileInputStream(str);
                            try {
                                byte[] bArr3 = new byte[1024];
                                int read = fileInputStream2.read(bArr3);
                                if (read >= 64) {
                                    byte[] bArr4 = new byte[64];
                                    System.arraycopy(bArr3, 0, bArr4, 0, 64);
                                    bArr2 = bArr4;
                                }
                                Logger.i(TAG, "recognitionAudioFormatExactly header = " + new String(bArr3, 0, read) + ",path = " + str);
                                try {
                                    fileInputStream2.close();
                                    r06 = bArr2;
                                } catch (Exception e16) {
                                    Logger.e(TAG, e16);
                                    r06 = bArr2;
                                }
                            } catch (Exception e17) {
                                bArr = bArr2;
                                fileInputStream = fileInputStream2;
                                exc = e17;
                                Logger.e(TAG, exc);
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e18) {
                                        Logger.e(TAG, e18);
                                    }
                                }
                                r06 = bArr;
                                it = supportAudioType.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                    }
                                }
                                if (audioType3 != null) {
                                }
                                Logger.i(TAG, "recognitionAudioFormatExactly checkFilePath = " + str + ",retType = " + audioType3);
                                return audioType3;
                            } catch (Throwable th5) {
                                th = th5;
                                r06 = fileInputStream2;
                                if (r06 != 0) {
                                    try {
                                        r06.close();
                                    } catch (Exception e19) {
                                        Logger.e(TAG, e19);
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e26) {
                            exc = e26;
                            bArr = null;
                        }
                        it = supportAudioType.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ?? createDecoderByType = MediaCodecFactory.createDecoderByType(it.next());
                            if (createDecoderByType != 0) {
                                try {
                                    audioType = createDecoderByType.getAudioType(str, r06);
                                } catch (SoNotFindException e27) {
                                    Logger.e(TAG, "so not find!", e27);
                                    audioType = AudioFormat.AudioType.UNSUPPORT;
                                }
                                if (AudioFormat.isAudioType(audioType)) {
                                    Logger.w(TAG, "soft recognition  = " + audioType + ",file path = " + str + ",recognition time = " + (System.currentTimeMillis() - currentTimeMillis) + ",guess file format = " + audioType.equals(guessFormat));
                                    audioType3 = audioType;
                                    break;
                                }
                            }
                        }
                    }
                    if (audioType3 != null) {
                        audioType3 = AudioFormat.AudioType.UNSUPPORT;
                    } else {
                        Logger.i(TAG, "[recognitionAudioFormatExactly] add to cache, file path checkFilePath = [" + str + "]. retType = [" + audioType3 + "].");
                        mRecognitionResultCache.put(str, audioType3);
                        mGuessFormatResultCache.put(str, audioType3);
                    }
                    Logger.i(TAG, "recognitionAudioFormatExactly checkFilePath = " + str + ",retType = " + audioType3);
                    return audioType3;
                } catch (Throwable th6) {
                    th = th6;
                }
            } else {
                throw new IOException("Can not read file :" + str);
            }
        } else {
            throw new FileNotFoundException("File not found :" + str);
        }
    }
}
