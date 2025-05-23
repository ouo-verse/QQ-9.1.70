package com.tencent.trtc.txcopyrightedmedia;

import android.content.Context;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia;

/* compiled from: P */
@JNINamespace("liteav::extensions")
/* loaded from: classes27.dex */
public class TXCopyrightedMediaImpl extends TXCopyrightedMedia {
    static IPatchRedirector $redirector_;
    private long mNativeTXCopyrightedMediaImpl;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class TXSongScoreImpl implements TXCopyrightedMedia.ITXSongScore {
        static IPatchRedirector $redirector_;
        private long mNativeTXCopyrightedSongScore;

        public TXSongScoreImpl(String str, int i3, int i16, String str2, String str3, String str4) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TXCopyrightedMediaImpl.this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, str3, str4);
            } else {
                this.mNativeTXCopyrightedSongScore = 0L;
                this.mNativeTXCopyrightedSongScore = TXCopyrightedMediaImpl.nativeCreateSongScore(TXCopyrightedMediaImpl.this.mNativeTXCopyrightedMediaImpl, this, str, i3, i16, str2, str3, str4);
            }
        }

        @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia.ITXSongScore
        public int calculateTotalScore() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return TXCopyrightedMediaImpl.nativeCalculateTotalScore(this.mNativeTXCopyrightedSongScore);
            }
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }

        @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia.ITXSongScore
        public void destroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                TXCopyrightedMediaImpl.nativeDestroySongScore(this.mNativeTXCopyrightedSongScore);
                this.mNativeTXCopyrightedSongScore = 0L;
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia.ITXSongScore
        public void finish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                TXCopyrightedMediaImpl.nativeFinish(this.mNativeTXCopyrightedSongScore);
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia.ITXSongScore
        public TXCopyrightedMedia.TXSongScoreNoteItem[] getAllGrove() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                return TXCopyrightedMediaImpl.nativeGetAllGrove(this.mNativeTXCopyrightedSongScore);
            }
            return (TXCopyrightedMedia.TXSongScoreNoteItem[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }

        public void onMIDIGroveAndHint(String str, boolean z16, float f16, float f17, int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, this, str, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), obj);
            } else {
                ((TXCopyrightedMedia.ITXSongScoreCallback) obj).onMIDIGroveAndHint(str, z16, f16, f17, i3);
            }
        }

        public void onMIDISCoreUpdate(String str, int i3, int i16, int i17, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), obj);
            } else {
                ((TXCopyrightedMedia.ITXSongScoreCallback) obj).onMIDISCoreUpdate(str, i3, i16, i17);
            }
        }

        public void onMIDIScoreError(String str, int i3, String str2, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, this, str, Integer.valueOf(i3), str2, obj);
            } else {
                ((TXCopyrightedMedia.ITXSongScoreCallback) obj).onMIDIScoreError(str, i3, str2);
            }
        }

        public void onMIDIScoreFinish(String str, int[] iArr, int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, this, str, iArr, Integer.valueOf(i3), obj);
            } else {
                ((TXCopyrightedMedia.ITXSongScoreCallback) obj).onMIDIScoreFinish(str, iArr, i3);
            }
        }

        public void onMIDIScorePrepared(String str, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, obj);
            } else {
                ((TXCopyrightedMedia.ITXSongScoreCallback) obj).onMIDIScorePrepared(str);
            }
        }

        @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia.ITXSongScore
        public void prepare() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                TXCopyrightedMediaImpl.nativePrepare(this.mNativeTXCopyrightedSongScore);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia.ITXSongScore
        public void process(byte[] bArr, int i3, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                TXCopyrightedMediaImpl.nativeProcess(this.mNativeTXCopyrightedSongScore, bArr, i3, f16);
            } else {
                iPatchRedirector.redirect((short) 6, this, bArr, Integer.valueOf(i3), Float.valueOf(f16));
            }
        }

        @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia.ITXSongScore
        public void setKeyShift(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                TXCopyrightedMediaImpl.nativeSetKeyShift(this.mNativeTXCopyrightedSongScore, i3);
            } else {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
        }

        @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia.ITXSongScore
        public void setSongScoreCallback(TXCopyrightedMedia.ITXSongScoreCallback iTXSongScoreCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TXCopyrightedMediaImpl.nativeSetSongScoreCallback(this.mNativeTXCopyrightedSongScore, iTXSongScoreCallback);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) iTXSongScoreCallback);
            }
        }
    }

    public TXCopyrightedMediaImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mNativeTXCopyrightedMediaImpl = 0L;
        }
    }

    public static Object createSongScoreNoteItem(int i3, int i16, int i17, int i18) {
        TXCopyrightedMedia.TXSongScoreNoteItem tXSongScoreNoteItem = new TXCopyrightedMedia.TXSongScoreNoteItem();
        tXSongScoreNoteItem.startTime = i3;
        tXSongScoreNoteItem.duration = i16;
        tXSongScoreNoteItem.noteHeight = i17;
        tXSongScoreNoteItem.endTime = i18;
        return tXSongScoreNoteItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeCalculateTotalScore(long j3);

    private static native void nativeCancelPreloadMusic(long j3, String str, String str2);

    private static native void nativeClearMusicCache(long j3);

    private static native long nativeCreateCopyRightedMedia(TXCopyrightedMediaImpl tXCopyrightedMediaImpl);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeCreateSongScore(long j3, TXSongScoreImpl tXSongScoreImpl, String str, int i3, int i16, String str2, String str3, String str4);

    private static native void nativeDestroyCopyRightedMedia(TXCopyrightedMediaImpl tXCopyrightedMediaImpl, long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeDestroySongScore(long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeFinish(long j3);

    private static native String nativeGenMusicURI(long j3, String str, int i3, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native TXCopyrightedMedia.TXSongScoreNoteItem[] nativeGetAllGrove(long j3);

    private static native boolean nativeIsMusicPreloaded(long j3, String str, String str2);

    private static native void nativePreloadMusic(long j3, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativePrepare(long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProcess(long j3, byte[] bArr, int i3, float f16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetKeyShift(long j3, int i3);

    private static native void nativeSetLicense(long j3, Context context, String str, String str2);

    private static native void nativeSetMusicCacheMaxCount(long j3, int i3);

    private static native void nativeSetMusicPreloadCallback(long j3, Object obj);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetSongScoreCallback(long j3, Object obj);

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void cancelPreloadMusic(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        } else {
            nativeCancelPreloadMusic(this.mNativeTXCopyrightedMediaImpl, str, str2);
        }
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void clearMusicCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            nativeClearMusicCache(this.mNativeTXCopyrightedMediaImpl);
        }
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public TXCopyrightedMedia.ITXSongScore createSongScore(String str, int i3, int i16, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TXCopyrightedMedia.ITXSongScore) iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, str3, str4);
        }
        return new TXSongScoreImpl(str, i3, i16, str2, str3, str4);
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        long j3 = this.mNativeTXCopyrightedMediaImpl;
        if (j3 != 0) {
            nativeDestroyCopyRightedMedia(this, j3);
            this.mNativeTXCopyrightedMediaImpl = 0L;
        }
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public String genMusicURI(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2);
        }
        return nativeGenMusicURI(this.mNativeTXCopyrightedMediaImpl, str, i3, str2);
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.mNativeTXCopyrightedMediaImpl == 0) {
            this.mNativeTXCopyrightedMediaImpl = nativeCreateCopyRightedMedia(this);
        }
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public boolean isMusicPreloaded(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        return nativeIsMusicPreloaded(this.mNativeTXCopyrightedMediaImpl, str, str2);
    }

    public void onPreloadComplete(String str, String str2, int i3, String str3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, str2, Integer.valueOf(i3), str3, obj);
        } else {
            ((TXCopyrightedMedia.ITXMusicPreloadCallback) obj).onPreloadComplete(str, str2, i3, str3);
        }
    }

    public void onPreloadProgress(String str, String str2, float f16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, str2, Float.valueOf(f16), obj);
        } else {
            ((TXCopyrightedMedia.ITXMusicPreloadCallback) obj).onPreloadProgress(str, str2, f16);
        }
    }

    public void onPreloadStart(String str, String str2, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, str2, obj);
        } else {
            ((TXCopyrightedMedia.ITXMusicPreloadCallback) obj).onPreloadStart(str, str2);
        }
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void preloadMusic(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, str3);
        } else {
            nativePreloadMusic(this.mNativeTXCopyrightedMediaImpl, str, str2, str3);
        }
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void setLicense(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, str, str2);
        } else {
            nativeSetLicense(this.mNativeTXCopyrightedMediaImpl, context, str, str2);
        }
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void setMusicCacheMaxCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            nativeSetMusicCacheMaxCount(this.mNativeTXCopyrightedMediaImpl, i3);
        }
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void setMusicPreloadCallback(TXCopyrightedMedia.ITXMusicPreloadCallback iTXMusicPreloadCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iTXMusicPreloadCallback);
        } else {
            nativeSetMusicPreloadCallback(this.mNativeTXCopyrightedMediaImpl, iTXMusicPreloadCallback);
        }
    }
}
