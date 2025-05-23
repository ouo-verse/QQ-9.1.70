package com.tencent.trtc;

import com.tencent.component.room.protocol.pbenterroom.pbenterroom;
import com.tencent.liteav.trtc.TXChorusMusicPlayerImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.trtc.TRTCCloudDef;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes27.dex */
public abstract class TXChorusMusicPlayer {
    static IPatchRedirector $redirector_;

    /* loaded from: classes27.dex */
    public interface ITXChorusPlayerListener {
        void onChorusError(TXChorusError tXChorusError, String str);

        void onChorusMusicLoadProgress(String str, float f16);

        void onChorusMusicLoadSucceed(String str, List<TXLyricLine> list, List<TXReferencePitch> list2);

        void onChorusPaused();

        void onChorusRequireLoadMusic(String str);

        void onChorusResumed();

        void onChorusStarted();

        void onChorusStopped();

        void onMusicProgressUpdated(long j3, long j16);

        void onNetworkQualityUpdated(int i3, int i16, int i17);

        void onVoicePitchUpdated(int i3, boolean z16, long j3);

        void onVoiceScoreUpdated(int i3, int i16, int i17);

        void shouldDecryptAudioData(ByteBuffer byteBuffer);
    }

    /* loaded from: classes27.dex */
    public static class TXChorusCopyrightedMusicParams {
        static IPatchRedirector $redirector_;
        public String copyrightedLicenseKey;
        public String copyrightedLicenseUrl;
        public String musicId;
        public String playToken;

        public TXChorusCopyrightedMusicParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.musicId = null;
            this.playToken = null;
            this.copyrightedLicenseKey = null;
            this.copyrightedLicenseUrl = null;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes27.dex */
    public static final class TXChorusError {
        private static final /* synthetic */ TXChorusError[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TXChorusError TXChorusErrorEnterRoomFailed;
        public static final TXChorusError TXChorusErrorInvalidParameters;
        public static final TXChorusError TXChorusErrorMusicDecodeFailed;
        public static final TXChorusError TXChorusErrorMusicLoadFailed;
        public static final TXChorusError TXChorusErrorMusicPreloadRequired;
        public static final TXChorusError TXChorusErrorRestrictedToLeadSinger;
        public static final TXChorusError TXChorusErrorRoomDisconnected;
        public static final TXChorusError TXChorusErrorTrtcCloudNotFound;
        public static final TXChorusError TXChorusErrorTrtcError;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(pbenterroom.CMD_NEW_ACCESS);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TXChorusError tXChorusError = new TXChorusError("TXChorusErrorInvalidParameters", 0);
            TXChorusErrorInvalidParameters = tXChorusError;
            TXChorusError tXChorusError2 = new TXChorusError("TXChorusErrorTrtcCloudNotFound", 1);
            TXChorusErrorTrtcCloudNotFound = tXChorusError2;
            TXChorusError tXChorusError3 = new TXChorusError("TXChorusErrorRestrictedToLeadSinger", 2);
            TXChorusErrorRestrictedToLeadSinger = tXChorusError3;
            TXChorusError tXChorusError4 = new TXChorusError("TXChorusErrorMusicPreloadRequired", 3);
            TXChorusErrorMusicPreloadRequired = tXChorusError4;
            TXChorusError tXChorusError5 = new TXChorusError("TXChorusErrorMusicLoadFailed", 4);
            TXChorusErrorMusicLoadFailed = tXChorusError5;
            TXChorusError tXChorusError6 = new TXChorusError("TXChorusErrorMusicDecodeFailed", 5);
            TXChorusErrorMusicDecodeFailed = tXChorusError6;
            TXChorusError tXChorusError7 = new TXChorusError("TXChorusErrorEnterRoomFailed", 6);
            TXChorusErrorEnterRoomFailed = tXChorusError7;
            TXChorusError tXChorusError8 = new TXChorusError("TXChorusErrorRoomDisconnected", 7);
            TXChorusErrorRoomDisconnected = tXChorusError8;
            TXChorusError tXChorusError9 = new TXChorusError("TXChorusErrorTrtcError", 8);
            TXChorusErrorTrtcError = tXChorusError9;
            $VALUES = new TXChorusError[]{tXChorusError, tXChorusError2, tXChorusError3, tXChorusError4, tXChorusError5, tXChorusError6, tXChorusError7, tXChorusError8, tXChorusError9};
        }

        TXChorusError(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static TXChorusError valueOf(String str) {
            return (TXChorusError) Enum.valueOf(TXChorusError.class, str);
        }

        public static TXChorusError[] values() {
            return (TXChorusError[]) $VALUES.clone();
        }
    }

    /* loaded from: classes27.dex */
    public static class TXChorusExternalMusicParams {
        static IPatchRedirector $redirector_;
        public String accompanyUrl;
        public int encryptBlockLength;
        public boolean isEncrypted;
        public String musicId;
        public String musicUrl;

        public TXChorusExternalMusicParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.musicId = null;
            this.musicUrl = null;
            this.accompanyUrl = null;
            this.isEncrypted = false;
            this.encryptBlockLength = 0;
        }
    }

    /* loaded from: classes27.dex */
    public static class TXChorusLyricCharacter {
        static IPatchRedirector $redirector_;
        public long durationMs;
        public long startTimeMs;
        public String utf8Character;

        public TXChorusLyricCharacter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.startTimeMs = 0L;
            this.durationMs = 0L;
            this.utf8Character = null;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes27.dex */
    public static final class TXChorusMusicTrack {
        private static final /* synthetic */ TXChorusMusicTrack[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TXChorusMusicTrack TXChorusAccompaniment;
        public static final TXChorusMusicTrack TXChorusOriginalSong;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14778);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TXChorusMusicTrack tXChorusMusicTrack = new TXChorusMusicTrack("TXChorusAccompaniment", 0);
            TXChorusAccompaniment = tXChorusMusicTrack;
            TXChorusMusicTrack tXChorusMusicTrack2 = new TXChorusMusicTrack("TXChorusOriginalSong", 1);
            TXChorusOriginalSong = tXChorusMusicTrack2;
            $VALUES = new TXChorusMusicTrack[]{tXChorusMusicTrack, tXChorusMusicTrack2};
        }

        TXChorusMusicTrack(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static TXChorusMusicTrack valueOf(String str) {
            return (TXChorusMusicTrack) Enum.valueOf(TXChorusMusicTrack.class, str);
        }

        public static TXChorusMusicTrack[] values() {
            return (TXChorusMusicTrack[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes27.dex */
    public static final class TXChorusRole {
        private static final /* synthetic */ TXChorusRole[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TXChorusRole TXChorusRoleAnchor;
        public static final TXChorusRole TXChorusRoleAudience;
        public static final TXChorusRole TXChorusRoleBackSinger;
        public static final TXChorusRole TXChorusRoleLeadSinger;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15176);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TXChorusRole tXChorusRole = new TXChorusRole("TXChorusRoleLeadSinger", 0);
            TXChorusRoleLeadSinger = tXChorusRole;
            TXChorusRole tXChorusRole2 = new TXChorusRole("TXChorusRoleBackSinger", 1);
            TXChorusRoleBackSinger = tXChorusRole2;
            TXChorusRole tXChorusRole3 = new TXChorusRole("TXChorusRoleAnchor", 2);
            TXChorusRoleAnchor = tXChorusRole3;
            TXChorusRole tXChorusRole4 = new TXChorusRole("TXChorusRoleAudience", 3);
            TXChorusRoleAudience = tXChorusRole4;
            $VALUES = new TXChorusRole[]{tXChorusRole, tXChorusRole2, tXChorusRole3, tXChorusRole4};
        }

        TXChorusRole(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static TXChorusRole valueOf(String str) {
            return (TXChorusRole) Enum.valueOf(TXChorusRole.class, str);
        }

        public static TXChorusRole[] values() {
            return (TXChorusRole[]) $VALUES.clone();
        }
    }

    /* loaded from: classes27.dex */
    public static class TXLyricLine {
        static IPatchRedirector $redirector_;
        public List<TXChorusLyricCharacter> characterArray;
        public long durationMs;
        public long startTimeMs;

        public TXLyricLine() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.startTimeMs = 0L;
            this.durationMs = 0L;
            this.characterArray = null;
        }
    }

    /* loaded from: classes27.dex */
    public static class TXReferencePitch {
        static IPatchRedirector $redirector_;
        public long durationMs;
        public int referencePitch;
        public long startTimeMs;

        public TXReferencePitch() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.startTimeMs = 0L;
            this.durationMs = 0L;
            this.referencePitch = 0;
        }
    }

    public TXChorusMusicPlayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static TXChorusMusicPlayer create(TRTCCloud tRTCCloud, String str, ITXChorusPlayerListener iTXChorusPlayerListener) {
        return TXChorusMusicPlayerImpl.create(tRTCCloud, str, iTXChorusPlayerListener);
    }

    public abstract void destroy();

    public abstract void loadExternalMusic(TXChorusExternalMusicParams tXChorusExternalMusicParams);

    public abstract void loadMusic(TXChorusCopyrightedMusicParams tXChorusCopyrightedMusicParams);

    public abstract void pause();

    public abstract void resume();

    public abstract void seek(long j3);

    public abstract void setChorusRole(TXChorusRole tXChorusRole, TRTCCloudDef.TRTCParams tRTCParams);

    public abstract void setListener(ITXChorusPlayerListener iTXChorusPlayerListener);

    public abstract void setPlayoutVolume(int i3);

    public abstract void setPublishVolume(int i3);

    public abstract void start();

    public abstract void stop();

    public abstract void switchMusicTrack(TXChorusMusicTrack tXChorusMusicTrack);
}
