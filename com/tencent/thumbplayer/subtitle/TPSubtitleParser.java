package com.tencent.thumbplayer.subtitle;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.common.TPSubtitleRenderParams;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.core.utils.TPFieldCalledByNative;
import com.tencent.thumbplayer.libloader.TPLibraryLoader;
import com.tencent.thumbplayer.subtitle.TPSubtitleParser;

/* loaded from: classes26.dex */
public class TPSubtitleParser {
    private static final String TAG = "TPSubtitleParser";
    private Handler mListenerHandler = null;

    @TPFieldCalledByNative
    private long mSubtitleParserContext = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class TPSubtitleParserListener implements ITPSubtitleParserListener {
        private ITPSubtitleParserListener mSubtitleParserListener;

        public TPSubtitleParserListener(@NonNull ITPSubtitleParserListener iTPSubtitleParserListener) {
            this.mSubtitleParserListener = iTPSubtitleParserListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDeselectError$3(TPError tPError, long j3) {
            this.mSubtitleParserListener.onDeselectError(tPError, j3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDeselectSuccess$2(long j3) {
            this.mSubtitleParserListener.onDeselectSuccess(j3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSelectError$1(TPError tPError, long j3) {
            this.mSubtitleParserListener.onSelectError(tPError, j3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSelectSuccess$0(long j3) {
            this.mSubtitleParserListener.onSelectSuccess(j3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSubtitleData$5(TPSubtitleData tPSubtitleData) {
            this.mSubtitleParserListener.onSubtitleData(tPSubtitleData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSubtitleError$4(int i3, TPError tPError) {
            this.mSubtitleParserListener.onSubtitleError(i3, tPError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSubtitleNote$6(int i3, String str) {
            this.mSubtitleParserListener.onSubtitleNote(i3, str);
        }

        @Override // com.tencent.thumbplayer.subtitle.ITPSubtitleParserListener
        public void onDeselectError(final TPError tPError, final long j3) {
            if (TPSubtitleParser.this.mListenerHandler != null) {
                TPSubtitleParser.this.mListenerHandler.post(new Runnable() { // from class: com.tencent.thumbplayer.subtitle.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        TPSubtitleParser.TPSubtitleParserListener.this.lambda$onDeselectError$3(tPError, j3);
                    }
                });
            } else {
                this.mSubtitleParserListener.onDeselectError(tPError, j3);
            }
        }

        @Override // com.tencent.thumbplayer.subtitle.ITPSubtitleParserListener
        public void onDeselectSuccess(final long j3) {
            if (TPSubtitleParser.this.mListenerHandler != null) {
                TPSubtitleParser.this.mListenerHandler.post(new Runnable() { // from class: com.tencent.thumbplayer.subtitle.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        TPSubtitleParser.TPSubtitleParserListener.this.lambda$onDeselectSuccess$2(j3);
                    }
                });
            } else {
                this.mSubtitleParserListener.onDeselectSuccess(j3);
            }
        }

        @Override // com.tencent.thumbplayer.subtitle.ITPSubtitleParserListener
        public long onGetCurrentPlayPositionMs() {
            return this.mSubtitleParserListener.onGetCurrentPlayPositionMs();
        }

        @Override // com.tencent.thumbplayer.subtitle.ITPSubtitleParserListener
        public void onSelectError(final TPError tPError, final long j3) {
            if (TPSubtitleParser.this.mListenerHandler != null) {
                TPSubtitleParser.this.mListenerHandler.post(new Runnable() { // from class: com.tencent.thumbplayer.subtitle.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        TPSubtitleParser.TPSubtitleParserListener.this.lambda$onSelectError$1(tPError, j3);
                    }
                });
            } else {
                this.mSubtitleParserListener.onSelectError(tPError, j3);
            }
        }

        @Override // com.tencent.thumbplayer.subtitle.ITPSubtitleParserListener
        public void onSelectSuccess(final long j3) {
            if (TPSubtitleParser.this.mListenerHandler != null) {
                TPSubtitleParser.this.mListenerHandler.post(new Runnable() { // from class: com.tencent.thumbplayer.subtitle.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        TPSubtitleParser.TPSubtitleParserListener.this.lambda$onSelectSuccess$0(j3);
                    }
                });
            } else {
                this.mSubtitleParserListener.onSelectSuccess(j3);
            }
        }

        @Override // com.tencent.thumbplayer.subtitle.ITPSubtitleParserListener
        public void onSubtitleData(final TPSubtitleData tPSubtitleData) {
            if (TPSubtitleParser.this.mListenerHandler != null) {
                TPSubtitleParser.this.mListenerHandler.post(new Runnable() { // from class: com.tencent.thumbplayer.subtitle.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        TPSubtitleParser.TPSubtitleParserListener.this.lambda$onSubtitleData$5(tPSubtitleData);
                    }
                });
            } else {
                this.mSubtitleParserListener.onSubtitleData(tPSubtitleData);
            }
        }

        @Override // com.tencent.thumbplayer.subtitle.ITPSubtitleParserListener
        public void onSubtitleError(final int i3, final TPError tPError) {
            if (TPSubtitleParser.this.mListenerHandler != null) {
                TPSubtitleParser.this.mListenerHandler.post(new Runnable() { // from class: com.tencent.thumbplayer.subtitle.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        TPSubtitleParser.TPSubtitleParserListener.this.lambda$onSubtitleError$4(i3, tPError);
                    }
                });
            } else {
                this.mSubtitleParserListener.onSubtitleError(i3, tPError);
            }
        }

        @Override // com.tencent.thumbplayer.subtitle.ITPSubtitleParserListener
        public void onSubtitleNote(final int i3, final String str) {
            if (TPSubtitleParser.this.mListenerHandler != null) {
                TPSubtitleParser.this.mListenerHandler.post(new Runnable() { // from class: com.tencent.thumbplayer.subtitle.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        TPSubtitleParser.TPSubtitleParserListener.this.lambda$onSubtitleNote$6(i3, str);
                    }
                });
            } else {
                this.mSubtitleParserListener.onSubtitleNote(i3, str);
            }
        }
    }

    public TPSubtitleParser() throws TPLoadLibraryException, UnsupportedOperationException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                int native_create = native_create();
                if (native_create == 0) {
                    return;
                }
                throw new UnsupportedOperationException("failed to call native create" + native_create);
            } catch (UnsatisfiedLinkError unused) {
                throw new TPLoadLibraryException("failed to call native create");
            }
        }
        throw new TPLoadLibraryException("native library not successfully loaded");
    }

    private native int native_addDataSource(ITPMediaAsset iTPMediaAsset, String str);

    private native void native_addOptionalParam(TPOptionalParam tPOptionalParam);

    private native int native_create();

    private native int native_deselectTrackAsync(int i3, long j3);

    private native TPTrackInfo[] native_getTrackInfo();

    private native int native_init(int i3, ITPSubtitleParserListener iTPSubtitleParserListener);

    private native int native_pause();

    private native void native_release();

    private native int native_removeTrack(int i3);

    private native void native_reset();

    private native int native_seekToAsync(long j3, long j16);

    private native int native_selectTrackAsync(int i3, long j3);

    private native int native_setPlaySpeedRatio(float f16);

    private native void native_setRenderParams(TPSubtitleRenderParams tPSubtitleRenderParams);

    private native int native_start();

    public void addDataSource(ITPMediaAsset iTPMediaAsset, String str) throws IllegalArgumentException, TPLoadLibraryException, UnsupportedOperationException {
        if (iTPMediaAsset != null && iTPMediaAsset.isValid()) {
            try {
                int native_addDataSource = native_addDataSource(iTPMediaAsset, str);
                if (native_addDataSource == 0) {
                    return;
                }
                throw new UnsupportedOperationException("failed to call native addDataSource" + native_addDataSource);
            } catch (UnsatisfiedLinkError unused) {
                throw new TPLoadLibraryException("failed to call native addDataSource");
            }
        }
        throw new IllegalArgumentException("Invalid asset: " + iTPMediaAsset);
    }

    public void addOptionalParam(TPOptionalParam<?> tPOptionalParam) throws TPLoadLibraryException {
        try {
            native_addOptionalParam(tPOptionalParam);
        } catch (UnsatisfiedLinkError unused) {
            throw new TPLoadLibraryException("failed to call native addOptionalParam");
        }
    }

    public void deselectTrackAsync(int i3, long j3) throws TPLoadLibraryException, UnsupportedOperationException {
        try {
            if (native_deselectTrackAsync(i3, j3) == 0) {
            } else {
                throw new UnsupportedOperationException("failed to call native deselectTrackAsync + ret");
            }
        } catch (UnsatisfiedLinkError unused) {
            throw new TPLoadLibraryException("failed to call native deselectTrackAsync");
        }
    }

    @Nullable
    public TPTrackInfo[] getTrackInfo() throws TPLoadLibraryException {
        try {
            return native_getTrackInfo();
        } catch (UnsatisfiedLinkError unused) {
            throw new TPLoadLibraryException("failed to call native getTrackInfo");
        }
    }

    public void init(int i3, @NonNull ITPSubtitleParserListener iTPSubtitleParserListener) throws IllegalArgumentException, TPLoadLibraryException, UnsupportedOperationException {
        if (iTPSubtitleParserListener != null) {
            try {
                int native_init = native_init(i3, new TPSubtitleParserListener(iTPSubtitleParserListener));
                if (native_init == 0) {
                    if (Looper.myLooper() != null) {
                        this.mListenerHandler = new Handler(Looper.myLooper());
                        return;
                    }
                    return;
                } else {
                    throw new UnsupportedOperationException("failed to call native init" + native_init);
                }
            } catch (UnsatisfiedLinkError unused) {
                throw new TPLoadLibraryException("failed to call native init");
            }
        }
        throw new IllegalArgumentException("Failed to init due to listener is null.");
    }

    public void pause() throws TPLoadLibraryException, UnsupportedOperationException {
        try {
            int native_pause = native_pause();
            if (native_pause == 0) {
                return;
            }
            throw new UnsupportedOperationException("failed to call native pause" + native_pause);
        } catch (UnsatisfiedLinkError unused) {
            throw new TPLoadLibraryException("failed to call native pause");
        }
    }

    public void release() throws TPLoadLibraryException {
        try {
            native_release();
        } catch (UnsatisfiedLinkError unused) {
            throw new TPLoadLibraryException("failed to call native release");
        }
    }

    public void removeTrack(int i3) throws IllegalArgumentException, TPLoadLibraryException {
        try {
            int native_removeTrack = native_removeTrack(i3);
            if (native_removeTrack == 0) {
                return;
            }
            throw new IllegalArgumentException("failed to call native removeTrack" + native_removeTrack);
        } catch (UnsatisfiedLinkError unused) {
            throw new TPLoadLibraryException("failed to call native removeTrack");
        }
    }

    public void reset() throws TPLoadLibraryException {
        try {
            native_reset();
        } catch (UnsatisfiedLinkError unused) {
            throw new TPLoadLibraryException("failed to call native reset");
        }
    }

    public void seekToAsync(long j3, long j16) throws TPLoadLibraryException, UnsupportedOperationException {
        try {
            int native_seekToAsync = native_seekToAsync(j3, j16);
            if (native_seekToAsync == 0) {
                return;
            }
            throw new UnsupportedOperationException("failed to call native seekToAsync" + native_seekToAsync);
        } catch (UnsatisfiedLinkError unused) {
            throw new TPLoadLibraryException("failed to call native seekToAsync");
        }
    }

    public void selectTrackAsync(int i3, long j3) throws TPLoadLibraryException, UnsupportedOperationException {
        try {
            int native_selectTrackAsync = native_selectTrackAsync(i3, j3);
            if (native_selectTrackAsync == 0) {
                return;
            }
            throw new UnsupportedOperationException("failed to call native selectTrackAsync" + native_selectTrackAsync);
        } catch (UnsatisfiedLinkError unused) {
            throw new TPLoadLibraryException("failed to call native selectTrackAsync");
        }
    }

    public void setPlaySpeedRatio(float f16) throws TPLoadLibraryException {
        try {
            native_setPlaySpeedRatio(f16);
        } catch (UnsatisfiedLinkError unused) {
            throw new TPLoadLibraryException("failed to call native setSpeedRatio");
        }
    }

    public void setRenderParams(TPSubtitleRenderParams tPSubtitleRenderParams) throws TPLoadLibraryException {
        try {
            native_setRenderParams(tPSubtitleRenderParams);
        } catch (UnsatisfiedLinkError unused) {
            throw new TPLoadLibraryException("failed to call native setRenderParams");
        }
    }

    public void start() throws TPLoadLibraryException, UnsupportedOperationException {
        try {
            int native_start = native_start();
            if (native_start == 0) {
                return;
            }
            throw new UnsupportedOperationException("failed to call native start" + native_start);
        } catch (UnsatisfiedLinkError unused) {
            throw new TPLoadLibraryException("failed to call native start");
        }
    }
}
