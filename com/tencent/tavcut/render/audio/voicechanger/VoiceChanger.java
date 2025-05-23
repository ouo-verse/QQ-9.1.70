package com.tencent.tavcut.render.audio.voicechanger;

import ee4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0082 J\t\u0010\t\u001a\u00020\bH\u0082 J!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0082 J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/tavcut/render/audio/voicechanger/VoiceChanger;", "", "", "sData", "", "b", "recordedFrame", "changeFrames", "", "releaseVoiceChanger", "", "sampleRate", "voiceKind", "environment", "", "initVoiceChanger", "c", "a", "<init>", "(III)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class VoiceChanger {
    static {
        try {
            System.loadLibrary("voicechanger_shared");
            System.loadLibrary("tavcut_voice");
        } catch (Exception e16) {
            b.b("VoiceChanger", "voice changer loadLibrary Error:" + e16.getMessage());
        } catch (UnsatisfiedLinkError e17) {
            b.b("VoiceChanger", "voice changer UnsatisfiedLinkError:" + e17.getMessage());
        }
    }

    public VoiceChanger(int i3, int i16, int i17) {
        initVoiceChanger(i3, i16, i17);
    }

    private final byte[] b(short[] sData) {
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

    private final native short[] changeFrames(short[] recordedFrame);

    private final native long initVoiceChanger(int sampleRate, int voiceKind, int environment);

    private final native void releaseVoiceChanger();

    public final void a() {
        releaseVoiceChanger();
        b.e("VoiceChanger", "releaseVoiceChanger()");
    }

    @Nullable
    public final byte[] c(@NotNull short[] recordedFrame) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(recordedFrame, "recordedFrame");
        b.e("VoiceChanger", "writeVoiceFrames()");
        short[] changeFrames = changeFrames(recordedFrame);
        if (changeFrames != null) {
            if (changeFrames.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return b(changeFrames);
            }
        }
        return null;
    }
}
