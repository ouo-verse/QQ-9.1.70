package com.tencent.trtc.txcopyrightedmedia;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class TXCopyrightedMedia {
    static IPatchRedirector $redirector_;
    public static TXCopyrightedMediaImpl impl;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ITXMusicPreloadCallback {
        void onPreloadComplete(String str, String str2, int i3, String str3);

        void onPreloadProgress(String str, String str2, float f16);

        void onPreloadStart(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ITXSongScore {
        int calculateTotalScore();

        void destroy();

        void finish();

        TXSongScoreNoteItem[] getAllGrove();

        void prepare();

        void process(byte[] bArr, int i3, float f16);

        void setKeyShift(int i3);

        void setSongScoreCallback(ITXSongScoreCallback iTXSongScoreCallback);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ITXSongScoreCallback {
        void onMIDIGroveAndHint(String str, boolean z16, float f16, float f17, int i3);

        void onMIDISCoreUpdate(String str, int i3, int i16, int i17);

        void onMIDIScoreError(String str, int i3, String str2);

        void onMIDIScoreFinish(String str, int[] iArr, int i3);

        void onMIDIScorePrepared(String str);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TXCopyrightedError {
        static IPatchRedirector $redirector_;
        public static int ERR_ACCOMPANIMENT_NOT_EXIST;
        public static int ERR_CANCEL;
        public static int ERR_INNER_ERROR;
        public static int ERR_LICENSE_FAILED;
        public static int ERR_LYRIC_NOT_EXIST;
        public static int ERR_MIDI_NOT_EXIST;
        public static int ERR_MUSIC_IS_DOWNLOADING;
        public static int ERR_NET_FAILED;
        public static int ERR_NONE;
        public static int ERR_NOT_PREPARE;
        public static int ERR_ORIGIN_NOT_EXIST;
        public static int ERR_PREPARE_FAILED;
        public static int ERR_TOKEN_OVERDUE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15049);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ERR_NONE = 0;
            ERR_CANCEL = -1;
            ERR_TOKEN_OVERDUE = -2;
            ERR_NET_FAILED = -3;
            ERR_INNER_ERROR = -4;
            ERR_LICENSE_FAILED = -5;
            ERR_MUSIC_IS_DOWNLOADING = -6;
            ERR_ACCOMPANIMENT_NOT_EXIST = -7;
            ERR_ORIGIN_NOT_EXIST = -8;
            ERR_LYRIC_NOT_EXIST = -9;
            ERR_MIDI_NOT_EXIST = -10;
            ERR_PREPARE_FAILED = -11;
            ERR_NOT_PREPARE = -12;
        }

        public TXCopyrightedError() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TXSongScoreNoteItem {
        static IPatchRedirector $redirector_ = null;
        public static final int INVALID_GROVE_VALUE = -1;
        public static final int MAX_GROVE_VALUE = 100;
        public static final int MAX_VOICE_PITCH_VALUE = 90;
        public int duration;
        public int endTime;
        public int noteHeight;
        public int startTime;

        public TXSongScoreNoteItem() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public int getEndTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.startTime + this.duration;
        }

        public boolean isSame(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
            }
            if (Math.abs(this.noteHeight - i3) < 11 && this.noteHeight > 0 && i3 > 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return String.format("startTime = %d ; endTime = %d ; duration = %d ; height = %d;", Integer.valueOf(this.startTime), Integer.valueOf(this.endTime), Integer.valueOf(this.duration), Integer.valueOf(this.noteHeight));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15057);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            impl = new TXCopyrightedMediaImpl();
        }
    }

    public TXCopyrightedMedia() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static TXCopyrightedMedia instance() {
        return impl;
    }

    public abstract void cancelPreloadMusic(String str, String str2);

    public abstract void clearMusicCache();

    public abstract ITXSongScore createSongScore(String str, int i3, int i16, String str2, String str3, String str4);

    public abstract void destroy();

    public abstract String genMusicURI(String str, int i3, String str2);

    public abstract void init();

    public abstract boolean isMusicPreloaded(String str, String str2);

    public abstract void preloadMusic(String str, String str2, String str3);

    public abstract void setLicense(Context context, String str, String str2);

    public abstract void setMusicCacheMaxCount(int i3);

    public abstract void setMusicPreloadCallback(ITXMusicPreloadCallback iTXMusicPreloadCallback);
}
