package com.tencent.tavcut.core.render.audio.voicechanger;

import com.tencent.tavcut.core.render.log.TavLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0082 J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0082 J\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\rH\u0082 J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/tavcut/core/render/audio/voicechanger/VoiceChanger;", "", "sampleRate", "", "voiceKind", "environment", "(III)V", "changeFrames", "", "recordedFrame", "initVoiceChanger", "", "release", "", "releaseVoiceChanger", "short2Byte", "", "sData", "writeVoiceFrameByShort", "writeVoiceFrames", "Companion", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class VoiceChanger {
    private static final String TAG = "VoiceChanger";

    static {
        try {
            System.loadLibrary("voicechanger_shared");
            System.loadLibrary("tavcut_voice");
        } catch (Exception e16) {
            TavLogger.e(TAG, "voice changer loadLibrary Error:" + e16.getMessage());
        } catch (UnsatisfiedLinkError e17) {
            TavLogger.e(TAG, "voice changer UnsatisfiedLinkError:" + e17.getMessage());
        }
    }

    public VoiceChanger(int i3, int i16, int i17) {
        initVoiceChanger(i3, i16, i17);
    }

    private final native short[] changeFrames(short[] recordedFrame);

    private final native long initVoiceChanger(int sampleRate, int voiceKind, int environment);

    private final native void releaseVoiceChanger();

    private final byte[] short2Byte(short[] sData) {
        byte[] bArr = new byte[sData.length * 2];
        int length = sData.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            short s16 = sData[i3];
            int i17 = i16 + 1;
            int i18 = i16 * 2;
            bArr[i18] = (byte) (s16 & 255);
            bArr[i18 + 1] = (byte) (s16 >> 8);
            i3++;
            i16 = i17;
        }
        return bArr;
    }

    public final void release() {
        releaseVoiceChanger();
        TavLogger.i(TAG, "releaseVoiceChanger()");
    }

    @Nullable
    public final short[] writeVoiceFrameByShort(@NotNull short[] recordedFrame) {
        Intrinsics.checkParameterIsNotNull(recordedFrame, "recordedFrame");
        TavLogger.i(TAG, "writeVoiceFrames()");
        return changeFrames(recordedFrame);
    }

    @Nullable
    public final byte[] writeVoiceFrames(@NotNull short[] recordedFrame) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(recordedFrame, "recordedFrame");
        TavLogger.i(TAG, "writeVoiceFrames()");
        short[] changeFrames = changeFrames(recordedFrame);
        if (changeFrames != null) {
            if (changeFrames.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return short2Byte(changeFrames);
            }
        }
        return null;
    }
}
