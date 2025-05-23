package com.tencent.liteav.trtc;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TXChorusMusicPlayer;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@JNINamespace("liteav::chorus")
/* loaded from: classes7.dex */
public class TXChorusMusicPlayerImpl extends TXChorusMusicPlayer {
    private static final String TAG = "TXChorusMusicPlayerImpl";
    private final ChorusPlayerListener mListener = new ChorusPlayerListener(0);
    private long mNativePtr;
    private TRTCCloud mSubTRTCCloud;
    private TRTCCloud mTRTCCloud;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.trtc.TXChorusMusicPlayerImpl$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f119159a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f119160b;

        static {
            int[] iArr = new int[TXChorusMusicPlayer.TXChorusMusicTrack.values().length];
            f119160b = iArr;
            try {
                iArr[TXChorusMusicPlayer.TXChorusMusicTrack.TXChorusAccompaniment.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f119160b[TXChorusMusicPlayer.TXChorusMusicTrack.TXChorusOriginalSong.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[TXChorusMusicPlayer.TXChorusRole.values().length];
            f119159a = iArr2;
            try {
                iArr2[TXChorusMusicPlayer.TXChorusRole.TXChorusRoleLeadSinger.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f119159a[TXChorusMusicPlayer.TXChorusRole.TXChorusRoleBackSinger.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f119159a[TXChorusMusicPlayer.TXChorusRole.TXChorusRoleAnchor.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f119159a[TXChorusMusicPlayer.TXChorusRole.TXChorusRoleAudience.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes7.dex */
    static class EnterRoomParams {

        /* renamed from: a, reason: collision with root package name */
        private final TRTCCloudDef.TRTCParams f119162a;

        public EnterRoomParams(TRTCCloudDef.TRTCParams tRTCParams) {
            this.f119162a = tRTCParams;
        }

        public String getBusinessInfo() {
            return this.f119162a.businessInfo;
        }

        public String getPrivateMapKey() {
            return this.f119162a.privateMapKey;
        }

        public int getRole() {
            return this.f119162a.role;
        }

        public int getRoomId() {
            return this.f119162a.roomId;
        }

        public int getSdkAppId() {
            return this.f119162a.sdkAppId;
        }

        public String getStrRoomId() {
            return this.f119162a.strRoomId;
        }

        public String getStreamId() {
            return this.f119162a.streamId;
        }

        public String getUserDefineRecordId() {
            return this.f119162a.userDefineRecordId;
        }

        public String getUserId() {
            return this.f119162a.userId;
        }

        public String getUserSig() {
            return this.f119162a.userSig;
        }
    }

    /* loaded from: classes7.dex */
    static class TXChorusLyricCharacterList {

        /* renamed from: a, reason: collision with root package name */
        final List<TXChorusMusicPlayer.TXChorusLyricCharacter> f119163a;

        public TXChorusLyricCharacterList(int i3) {
            this.f119163a = new ArrayList(i3);
        }

        public void add(int i3, long j3, long j16, String str) {
            TXChorusMusicPlayer.TXChorusLyricCharacter tXChorusLyricCharacter = new TXChorusMusicPlayer.TXChorusLyricCharacter();
            tXChorusLyricCharacter.startTimeMs = j3;
            tXChorusLyricCharacter.durationMs = j16;
            tXChorusLyricCharacter.utf8Character = str;
            this.f119163a.add(i3, tXChorusLyricCharacter);
        }

        public List<TXChorusMusicPlayer.TXChorusLyricCharacter> getChorusLyricCharacterList() {
            return this.f119163a;
        }
    }

    /* loaded from: classes7.dex */
    static class TXLyricLineList {

        /* renamed from: a, reason: collision with root package name */
        final List<TXChorusMusicPlayer.TXLyricLine> f119164a;

        public TXLyricLineList(int i3) {
            this.f119164a = new ArrayList(i3);
        }

        public void add(int i3, long j3, long j16, List<TXChorusMusicPlayer.TXChorusLyricCharacter> list) {
            TXChorusMusicPlayer.TXLyricLine tXLyricLine = new TXChorusMusicPlayer.TXLyricLine();
            tXLyricLine.startTimeMs = j3;
            tXLyricLine.durationMs = j16;
            tXLyricLine.characterArray = list;
            this.f119164a.add(i3, tXLyricLine);
        }

        public List<TXChorusMusicPlayer.TXLyricLine> getLyricLineList() {
            return this.f119164a;
        }
    }

    /* loaded from: classes7.dex */
    static class TXReferencePitchList {

        /* renamed from: a, reason: collision with root package name */
        final List<TXChorusMusicPlayer.TXReferencePitch> f119165a;

        public TXReferencePitchList(int i3) {
            this.f119165a = new ArrayList(i3);
        }

        public void add(int i3, long j3, long j16, int i16) {
            TXChorusMusicPlayer.TXReferencePitch tXReferencePitch = new TXChorusMusicPlayer.TXReferencePitch();
            tXReferencePitch.startTimeMs = j3;
            tXReferencePitch.durationMs = j16;
            tXReferencePitch.referencePitch = i16;
            this.f119165a.add(i3, tXReferencePitch);
        }

        public List<TXChorusMusicPlayer.TXReferencePitch> getTXReferencePitchList() {
            return this.f119165a;
        }
    }

    TXChorusMusicPlayerImpl(TRTCCloud tRTCCloud, String str, TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener) {
        long j3;
        long j16 = 0;
        this.mNativePtr = 0L;
        this.mTRTCCloud = null;
        this.mSubTRTCCloud = null;
        if (tRTCCloud == null) {
            return;
        }
        this.mTRTCCloud = tRTCCloud;
        try {
            j3 = parseNativePointer(tRTCCloud.callExperimentalAPI("{\"api\":\"getNativeHandle\"}"));
        } catch (Throwable th5) {
            LiteavLog.e(TAG, "get main trtcCloud native handle fail.", th5);
            j3 = 0;
        }
        try {
            TRTCCloud createSubCloud = tRTCCloud.createSubCloud();
            this.mSubTRTCCloud = createSubCloud;
            j16 = parseNativePointer(createSubCloud.callExperimentalAPI("{\"api\":\"getNativeHandle\"}"));
        } catch (Throwable th6) {
            LiteavLog.e(TAG, "get sub trtcCloud native handle fail.", th6);
        }
        ChorusPlayerListener chorusPlayerListener = this.mListener;
        chorusPlayerListener.f119161a = iTXChorusPlayerListener;
        this.mNativePtr = nativeCreate(j3, j16, str, chorusPlayerListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TXChorusMusicPlayer.TXChorusError convertIntValueToTXChorusError(int i3) {
        switch (i3) {
            case 1:
                return TXChorusMusicPlayer.TXChorusError.TXChorusErrorInvalidParameters;
            case 2:
                return TXChorusMusicPlayer.TXChorusError.TXChorusErrorTrtcCloudNotFound;
            case 3:
                return TXChorusMusicPlayer.TXChorusError.TXChorusErrorRestrictedToLeadSinger;
            case 4:
                return TXChorusMusicPlayer.TXChorusError.TXChorusErrorMusicPreloadRequired;
            case 5:
                return TXChorusMusicPlayer.TXChorusError.TXChorusErrorMusicLoadFailed;
            case 6:
                return TXChorusMusicPlayer.TXChorusError.TXChorusErrorMusicDecodeFailed;
            case 7:
                return TXChorusMusicPlayer.TXChorusError.TXChorusErrorEnterRoomFailed;
            case 8:
                return TXChorusMusicPlayer.TXChorusError.TXChorusErrorRoomDisconnected;
            case 9:
                return TXChorusMusicPlayer.TXChorusError.TXChorusErrorTrtcError;
            default:
                LiteavLog.w(TAG, "chorus error value is undefined. chorusErrorValue=".concat(String.valueOf(i3)));
                return null;
        }
    }

    public static TXChorusMusicPlayer create(TRTCCloud tRTCCloud, String str, TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener) {
        return new TXChorusMusicPlayerImpl(tRTCCloud, str, iTXChorusPlayerListener);
    }

    private static int getTXChorusMusicTrackIntValue(TXChorusMusicPlayer.TXChorusMusicTrack tXChorusMusicTrack) {
        if (tXChorusMusicTrack == null) {
            LiteavLog.w(TAG, "music track enum is null. musicTrack=".concat(String.valueOf(tXChorusMusicTrack)));
            return -1;
        }
        int i3 = AnonymousClass1.f119160b[tXChorusMusicTrack.ordinal()];
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2) {
                LiteavLog.w(TAG, "music track enum is unknown. musicTrack=".concat(String.valueOf(tXChorusMusicTrack)));
                return -1;
            }
        }
        return i16;
    }

    private static int getTXChorusRoleIntValue(TXChorusMusicPlayer.TXChorusRole tXChorusRole) {
        if (tXChorusRole == null) {
            LiteavLog.w(TAG, "chorus role enum is null. chorusRole=".concat(String.valueOf(tXChorusRole)));
            return -1;
        }
        int i3 = AnonymousClass1.f119159a[tXChorusRole.ordinal()];
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2) {
                i16 = 3;
                if (i3 != 3) {
                    i16 = 4;
                    if (i3 != 4) {
                        LiteavLog.w(TAG, "chorus role enum is unknown. chorusRole=".concat(String.valueOf(tXChorusRole)));
                        return -1;
                    }
                }
            }
        }
        return i16;
    }

    private static native long nativeCreate(long j3, long j16, String str, ChorusPlayerListener chorusPlayerListener);

    private static native void nativeDestroy(long j3);

    private static native void nativeLoadExternalMusic(long j3, String str, String str2, String str3, boolean z16, int i3);

    private static native void nativeLoadMusic(long j3, String str, String str2, String str3, String str4);

    private static native void nativePause(long j3);

    private static native void nativeResume(long j3);

    private static native void nativeSeek(long j3, long j16);

    private static native void nativeSetChorusRole(long j3, int i3, EnterRoomParams enterRoomParams);

    private static native void nativeSetPlayoutVolume(long j3, int i3);

    private static native void nativeSetPublishVolume(long j3, int i3);

    private static native void nativeStart(long j3);

    private static native void nativeStop(long j3);

    private static native void nativeSwitchMusicTrack(long j3, int i3);

    private static long parseNativePointer(String str) {
        try {
            BigInteger bigInteger = new BigInteger(str);
            if (bigInteger.bitLength() > 64) {
                LiteavLog.e(TAG, "Parsing pointer exceeding 64 bits. native pointer is ".concat(String.valueOf(str)));
                return 0L;
            }
            return bigInteger.longValue();
        } catch (Throwable th5) {
            LiteavLog.e(TAG, "Parsing pointer fail. native pointer is ".concat(String.valueOf(str)), th5);
            return 0L;
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void destroy() {
        TRTCCloud tRTCCloud;
        long j3 = this.mNativePtr;
        if (j3 != 0) {
            nativeDestroy(j3);
            this.mNativePtr = 0L;
        }
        TRTCCloud tRTCCloud2 = this.mTRTCCloud;
        if (tRTCCloud2 != null && (tRTCCloud = this.mSubTRTCCloud) != null) {
            tRTCCloud2.destroySubCloud(tRTCCloud);
            this.mSubTRTCCloud = null;
            this.mTRTCCloud = null;
        }
        this.mListener.f119161a = null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        long j3 = this.mNativePtr;
        if (j3 != 0) {
            LiteavLog.w(TAG, "object is not destroyed. will be memory leak. native pointer is %#x.", Long.valueOf(j3));
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void loadExternalMusic(TXChorusMusicPlayer.TXChorusExternalMusicParams tXChorusExternalMusicParams) {
        long j3 = this.mNativePtr;
        if (j3 != 0 && tXChorusExternalMusicParams != null) {
            nativeLoadExternalMusic(j3, tXChorusExternalMusicParams.musicId, tXChorusExternalMusicParams.musicUrl, tXChorusExternalMusicParams.accompanyUrl, tXChorusExternalMusicParams.isEncrypted, tXChorusExternalMusicParams.encryptBlockLength);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void loadMusic(TXChorusMusicPlayer.TXChorusCopyrightedMusicParams tXChorusCopyrightedMusicParams) {
        long j3 = this.mNativePtr;
        if (j3 != 0 && tXChorusCopyrightedMusicParams != null) {
            nativeLoadMusic(j3, tXChorusCopyrightedMusicParams.musicId, tXChorusCopyrightedMusicParams.playToken, tXChorusCopyrightedMusicParams.copyrightedLicenseKey, tXChorusCopyrightedMusicParams.copyrightedLicenseUrl);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void pause() {
        long j3 = this.mNativePtr;
        if (j3 != 0) {
            nativePause(j3);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void resume() {
        long j3 = this.mNativePtr;
        if (j3 != 0) {
            nativeResume(j3);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void seek(long j3) {
        long j16 = this.mNativePtr;
        if (j16 != 0) {
            nativeSeek(j16, j3);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void setChorusRole(TXChorusMusicPlayer.TXChorusRole tXChorusRole, TRTCCloudDef.TRTCParams tRTCParams) {
        EnterRoomParams enterRoomParams;
        if (this.mNativePtr != 0 && tXChorusRole != null) {
            if (tRTCParams != null) {
                enterRoomParams = new EnterRoomParams(tRTCParams);
            } else {
                enterRoomParams = null;
            }
            nativeSetChorusRole(this.mNativePtr, getTXChorusRoleIntValue(tXChorusRole), enterRoomParams);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public void setListener(TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener) {
        this.mListener.f119161a = iTXChorusPlayerListener;
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void setPlayoutVolume(int i3) {
        long j3 = this.mNativePtr;
        if (j3 != 0) {
            nativeSetPlayoutVolume(j3, i3);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void setPublishVolume(int i3) {
        long j3 = this.mNativePtr;
        if (j3 != 0) {
            nativeSetPublishVolume(j3, i3);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void start() {
        long j3 = this.mNativePtr;
        if (j3 != 0) {
            nativeStart(j3);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void stop() {
        long j3 = this.mNativePtr;
        if (j3 != 0) {
            nativeStop(j3);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void switchMusicTrack(TXChorusMusicPlayer.TXChorusMusicTrack tXChorusMusicTrack) {
        long j3 = this.mNativePtr;
        if (j3 != 0 && tXChorusMusicTrack != null) {
            nativeSwitchMusicTrack(j3, getTXChorusMusicTrackIntValue(tXChorusMusicTrack));
        }
    }

    /* loaded from: classes7.dex */
    static class ChorusPlayerListener {

        /* renamed from: a, reason: collision with root package name */
        TXChorusMusicPlayer.ITXChorusPlayerListener f119161a;

        ChorusPlayerListener() {
            this.f119161a = null;
        }

        public void onChorusError(int i3, String str) {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.f119161a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onChorusError(TXChorusMusicPlayerImpl.convertIntValueToTXChorusError(i3), str);
            }
        }

        public void onChorusMusicLoadProgress(String str, float f16) {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.f119161a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onChorusMusicLoadProgress(str, f16);
            }
        }

        public void onChorusMusicLoadSucceed(String str, List<TXChorusMusicPlayer.TXLyricLine> list, List<TXChorusMusicPlayer.TXReferencePitch> list2) {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.f119161a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onChorusMusicLoadSucceed(str, list, list2);
            }
        }

        public void onChorusPaused() {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.f119161a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onChorusPaused();
            }
        }

        public void onChorusRequireLoadMusic(String str) {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.f119161a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onChorusRequireLoadMusic(str);
            }
        }

        public void onChorusResumed() {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.f119161a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onChorusResumed();
            }
        }

        public void onChorusStarted() {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.f119161a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onChorusStarted();
            }
        }

        public void onChorusStopped() {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.f119161a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onChorusStopped();
            }
        }

        public void onMusicProgressUpdated(long j3, long j16) {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.f119161a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onMusicProgressUpdated(j3, j16);
            }
        }

        public void onNetworkQualityUpdated(int i3, int i16, int i17) {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.f119161a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onNetworkQualityUpdated(i3, i16, i17);
            }
        }

        public void onVoicePitchUpdated(int i3, boolean z16, long j3) {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.f119161a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onVoicePitchUpdated(i3, z16, j3);
            }
        }

        public void onVoiceScoreUpdated(int i3, int i16, int i17) {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.f119161a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onVoiceScoreUpdated(i3, i16, i17);
            }
        }

        public void shouldDecryptAudioData(ByteBuffer byteBuffer) {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.f119161a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.shouldDecryptAudioData(byteBuffer);
            }
        }

        /* synthetic */ ChorusPlayerListener(byte b16) {
            this();
        }
    }
}
