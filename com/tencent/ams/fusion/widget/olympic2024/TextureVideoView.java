package com.tencent.ams.fusion.widget.olympic2024;

import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TextureVideoView extends TextureView implements MediaController.MediaPlayerControl {
    static IPatchRedirector $redirector_ = null;
    private static final String LOG_TAG = "TextureVideoView";
    private static final int MSG_UPDATE_COUNTDOWN = 0;
    private static final int MSG_UPDATE_COUNTDOWN_INTERVAL = 200;
    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 5;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    private static final ScaleType[] sScaleTypeArray;
    private final MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener;
    private final MediaPlayer.OnCompletionListener mCompletionListener;
    private Context mContext;
    private int mCurrentBufferPercentage;
    private int mCurrentState;
    private final MediaPlayer.OnErrorListener mErrorListener;
    private final Handler mHandler;
    private final MediaPlayer.OnInfoListener mInfoListener;
    private boolean mIsSound;
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mOnCompletionListener;
    private MediaPlayer.OnErrorListener mOnErrorListener;
    private MediaPlayer.OnInfoListener mOnInfoListener;
    private MediaPlayer.OnPreparedListener mOnPreparedListener;
    private final MediaPlayer.OnPreparedListener mPreparedListener;
    private ScaleType mScaleType;
    private final MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener;
    private Surface mSurface;
    private final TextureView.SurfaceTextureListener mSurfaceTextureListener;
    private int mTargetState;
    private Uri mUri;
    private int mVideoHeight;
    private VideoStatusListener mVideoStatusListener;
    private int mVideoWidth;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.ams.fusion.widget.olympic2024.TextureVideoView$9, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$ams$fusion$widget$olympic2024$TextureVideoView$ScaleType;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18556);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[ScaleType.values().length];
            $SwitchMap$com$tencent$ams$fusion$widget$olympic2024$TextureVideoView$ScaleType = iArr;
            try {
                iArr[ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$ams$fusion$widget$olympic2024$TextureVideoView$ScaleType[ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$ams$fusion$widget$olympic2024$TextureVideoView$ScaleType[ScaleType.MATRIX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$ams$fusion$widget$olympic2024$TextureVideoView$ScaleType[ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$ams$fusion$widget$olympic2024$TextureVideoView$ScaleType[ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tencent$ams$fusion$widget$olympic2024$TextureVideoView$ScaleType[ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$tencent$ams$fusion$widget$olympic2024$TextureVideoView$ScaleType[ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$tencent$ams$fusion$widget$olympic2024$TextureVideoView$ScaleType[ScaleType.CENTER_INSIDE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class ScaleType {
        private static final /* synthetic */ ScaleType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ScaleType CENTER;
        public static final ScaleType CENTER_CROP;
        public static final ScaleType CENTER_INSIDE;
        public static final ScaleType FIT_CENTER;
        public static final ScaleType FIT_END;
        public static final ScaleType FIT_START;
        public static final ScaleType FIT_XY;
        public static final ScaleType MATRIX;
        final int nativeInt;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19998);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ScaleType scaleType = new ScaleType("MATRIX", 0, 0);
            MATRIX = scaleType;
            ScaleType scaleType2 = new ScaleType("FIT_XY", 1, 1);
            FIT_XY = scaleType2;
            ScaleType scaleType3 = new ScaleType("FIT_START", 2, 2);
            FIT_START = scaleType3;
            ScaleType scaleType4 = new ScaleType("FIT_CENTER", 3, 3);
            FIT_CENTER = scaleType4;
            ScaleType scaleType5 = new ScaleType("FIT_END", 4, 4);
            FIT_END = scaleType5;
            ScaleType scaleType6 = new ScaleType("CENTER", 5, 5);
            CENTER = scaleType6;
            ScaleType scaleType7 = new ScaleType("CENTER_CROP", 6, 6);
            CENTER_CROP = scaleType7;
            ScaleType scaleType8 = new ScaleType("CENTER_INSIDE", 7, 7);
            CENTER_INSIDE = scaleType8;
            $VALUES = new ScaleType[]{scaleType, scaleType2, scaleType3, scaleType4, scaleType5, scaleType6, scaleType7, scaleType8};
        }

        ScaleType(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.nativeInt = i16;
            }
        }

        public static ScaleType valueOf(String str) {
            return (ScaleType) Enum.valueOf(ScaleType.class, str);
        }

        public static ScaleType[] values() {
            return (ScaleType[]) $VALUES.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18735);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 33)) {
            redirector.redirect((short) 33);
        } else {
            sScaleTypeArray = new ScaleType[]{ScaleType.MATRIX, ScaleType.FIT_XY, ScaleType.FIT_START, ScaleType.FIT_CENTER, ScaleType.FIT_END, ScaleType.CENTER, ScaleType.CENTER_CROP, ScaleType.CENTER_INSIDE};
        }
    }

    public TextureVideoView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.ams.fusion.widget.olympic2024.TextureVideoView.1
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TextureVideoView.this, (Object) r5);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
                    return;
                }
                try {
                    if (message.what == 0) {
                        long currentPosition = TextureVideoView.this.getCurrentPosition();
                        if (TextureVideoView.this.mVideoStatusListener != null) {
                            TextureVideoView.this.mVideoStatusListener.onVideoPlayUpdate(currentPosition);
                        }
                        sendEmptyMessageDelayed(0, 200L);
                    }
                } catch (Throwable unused) {
                }
            }
        };
        this.mSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.TextureVideoView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TextureVideoView.this);
                }
            }

            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    TextureVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                    TextureVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                    if (TextureVideoView.this.mVideoWidth != 0 && TextureVideoView.this.mVideoHeight != 0) {
                        Utils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.fusion.widget.olympic2024.TextureVideoView.2.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    TextureVideoView.this.requestLayout();
                                    TextureVideoView.this.initVideo();
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        };
        this.mPreparedListener = new MediaPlayer.OnPreparedListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.TextureVideoView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TextureVideoView.this);
                }
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) mediaPlayer);
                    return;
                }
                Logger.i(TextureVideoView.LOG_TAG, "video prepared");
                TextureVideoView.this.mCurrentState = 2;
                MediaPlayer.OnPreparedListener onPreparedListener = TextureVideoView.this.mOnPreparedListener;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared(mediaPlayer);
                }
                TextureVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                TextureVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                TextureVideoView.this.seekTo(1);
                if (TextureVideoView.this.mVideoWidth != 0 && TextureVideoView.this.mVideoHeight != 0) {
                    TextureVideoView.this.initVideo();
                    if (TextureVideoView.this.mTargetState == 3) {
                        TextureVideoView.this.start();
                        return;
                    }
                    return;
                }
                if (TextureVideoView.this.mTargetState == 3) {
                    TextureVideoView.this.start();
                }
            }
        };
        this.mCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.TextureVideoView.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TextureVideoView.this);
                }
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    TextureVideoView.this.mCurrentState = 5;
                    TextureVideoView.this.mTargetState = 5;
                    MediaPlayer.OnCompletionListener onCompletionListener = TextureVideoView.this.mOnCompletionListener;
                    if (onCompletionListener != null) {
                        onCompletionListener.onCompletion(TextureVideoView.this.mMediaPlayer);
                        TextureVideoView.this.mHandler.removeMessages(0);
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) mediaPlayer);
            }
        };
        this.mInfoListener = new MediaPlayer.OnInfoListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.TextureVideoView.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TextureVideoView.this);
                }
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    MediaPlayer.OnInfoListener onInfoListener = TextureVideoView.this.mOnInfoListener;
                    if (onInfoListener != null) {
                        onInfoListener.onInfo(mediaPlayer, i3, i16);
                    }
                    return true;
                }
                return ((Boolean) iPatchRedirector2.redirect((short) 2, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
            }
        };
        this.mErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.TextureVideoView.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TextureVideoView.this);
                }
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
                }
                Log.d(TextureVideoView.LOG_TAG, "Error: " + i3 + "," + i16);
                TextureVideoView.this.mCurrentState = -1;
                TextureVideoView.this.mTargetState = -1;
                TextureVideoView.this.mHandler.removeMessages(0);
                MediaPlayer.OnErrorListener onErrorListener = TextureVideoView.this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(TextureVideoView.this.mMediaPlayer, i3, i16);
                }
                return true;
            }
        };
        this.mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.TextureVideoView.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TextureVideoView.this);
                }
            }

            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    TextureVideoView.this.mCurrentBufferPercentage = i3;
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) mediaPlayer, i3);
                }
            }
        };
        this.mSurfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.TextureVideoView.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TextureVideoView.this);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                Logger.i(TextureVideoView.LOG_TAG, "onSurfaceTextureAvailable");
                TextureVideoView.this.mSurface = new Surface(surfaceTexture);
                TextureVideoView.this.openVideo();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 4)) {
                    MediaPlayer mediaPlayer = TextureVideoView.this.mMediaPlayer;
                    if (mediaPlayer != null) {
                        mediaPlayer.reset();
                        mediaPlayer.release();
                        TextureVideoView.this.mMediaPlayer = null;
                    }
                    if (TextureVideoView.this.mSurface != null) {
                        TextureVideoView.this.mSurface.release();
                        TextureVideoView.this.mSurface = null;
                        return true;
                    }
                    return true;
                }
                return ((Boolean) iPatchRedirector2.redirect((short) 4, (Object) this, (Object) surfaceTexture)).booleanValue();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
                boolean z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                boolean z17 = true;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                if (TextureVideoView.this.mTargetState == 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (TextureVideoView.this.mVideoWidth != i3 || TextureVideoView.this.mVideoHeight != i16) {
                    z17 = false;
                }
                if (TextureVideoView.this.mMediaPlayer != null && z16 && z17) {
                    TextureVideoView.this.start();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) surfaceTexture);
                }
            }
        };
        this.mContext = context;
        initVideoView();
        setScaleType(ScaleType.FIT_CENTER);
    }

    private void center() {
        try {
            Matrix matrix = new Matrix();
            int width = getWidth();
            int height = getHeight();
            float f16 = this.mVideoWidth / width;
            float f17 = this.mVideoHeight / height;
            if (width != 0 && height != 0) {
                matrix.setScale(f16, f17);
                matrix.postTranslate((width - r3) / 2.0f, (height - r5) / 2.0f);
                setTransform(matrix);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private void centerCrop() {
        float f16;
        try {
            Matrix matrix = new Matrix();
            int width = getWidth();
            int height = getHeight();
            if (width != 0 && height != 0) {
                int i3 = this.mVideoWidth;
                float f17 = width;
                float f18 = i3 / f17;
                int i16 = this.mVideoHeight;
                float f19 = height;
                float f26 = i16 / f19;
                float f27 = 0.0f;
                if (f18 != 0.0f && f26 != 0.0f) {
                    float f28 = f17 - (i3 / f26);
                    float f29 = f19 - (i16 / f18);
                    float f36 = 1.0f;
                    if (f18 < f26) {
                        f16 = f26 * (1.0f / f18);
                    } else {
                        float f37 = f18 * (1.0f / f26);
                        f16 = 1.0f;
                        f29 = 0.0f;
                        f27 = f28;
                        f36 = f37;
                    }
                    matrix.setScale(f36, f16);
                    matrix.postTranslate(f27 / 2.0f, f29 / 2.0f);
                    setTransform(matrix);
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private void centerInside() {
        try {
            Matrix matrix = new Matrix();
            int width = getWidth();
            int height = getHeight();
            if (width != 0 && height != 0) {
                float f16 = this.mVideoWidth / width;
                float f17 = this.mVideoHeight / height;
                if (f16 <= 1.0f && f17 <= 1.0f) {
                    matrix.setScale(f16, f17);
                    matrix.postTranslate((width - r3) / 2.0f, (height - r5) / 2.0f);
                    setTransform(matrix);
                }
                fitCenter();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private void fitCenter() {
        float f16;
        try {
            Matrix matrix = new Matrix();
            int width = getWidth();
            int height = getHeight();
            if (width != 0 && height != 0) {
                int i3 = this.mVideoWidth;
                float f17 = width;
                float f18 = i3 / f17;
                int i16 = this.mVideoHeight;
                float f19 = height;
                float f26 = i16 / f19;
                float f27 = 0.0f;
                if (f18 != 0.0f && f26 != 0.0f) {
                    float f28 = f17 - (i3 / f26);
                    float f29 = f19 - (i16 / f18);
                    float f36 = 1.0f;
                    if (f18 > f26) {
                        f16 = f26 * (1.0f / f18);
                    } else {
                        float f37 = f18 * (1.0f / f26);
                        f16 = 1.0f;
                        f29 = 0.0f;
                        f27 = f28;
                        f36 = f37;
                    }
                    matrix.setScale(f36, f16);
                    matrix.postTranslate(f27 / 2.0f, f29 / 2.0f);
                    setTransform(matrix);
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private void fitEnd() {
        float f16;
        try {
            Matrix matrix = new Matrix();
            int width = getWidth();
            int height = getHeight();
            if (width != 0 && height != 0) {
                int i3 = this.mVideoWidth;
                float f17 = width;
                float f18 = i3 / f17;
                int i16 = this.mVideoHeight;
                float f19 = height;
                float f26 = i16 / f19;
                float f27 = 0.0f;
                if (f18 != 0.0f && f26 != 0.0f) {
                    float f28 = f17 - (i3 / f26);
                    float f29 = f19 - (i16 / f18);
                    float f36 = 1.0f;
                    if (f18 > f26) {
                        f16 = f26 * (1.0f / f18);
                    } else {
                        float f37 = f18 * (1.0f / f26);
                        f16 = 1.0f;
                        f29 = 0.0f;
                        f27 = f28;
                        f36 = f37;
                    }
                    matrix.setScale(f36, f16);
                    matrix.postTranslate(f27, f29);
                    setTransform(matrix);
                }
            }
        } catch (Throwable unused) {
            Logger.w(LOG_TAG, "fitEnd failed");
        }
    }

    private void fitStart() {
        float f16;
        try {
            Matrix matrix = new Matrix();
            int width = getWidth();
            int height = getHeight();
            if (width != 0 && height != 0) {
                float f17 = this.mVideoWidth / width;
                float f18 = this.mVideoHeight / height;
                if (f17 != 0.0f && f18 != 0.0f) {
                    float f19 = 1.0f;
                    if (f17 > f18) {
                        f16 = f18 * (1.0f / f17);
                    } else {
                        float f26 = f17 * (1.0f / f18);
                        f16 = 1.0f;
                        f19 = f26;
                    }
                    matrix.setScale(f19, f16);
                    matrix.postTranslate(0.0f, 0.0f);
                    setTransform(matrix);
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private void fitXY() {
        try {
            Matrix matrix = new Matrix();
            matrix.setScale(1.0f, 1.0f);
            setTransform(matrix);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initVideo() {
        switch (AnonymousClass9.$SwitchMap$com$tencent$ams$fusion$widget$olympic2024$TextureVideoView$ScaleType[this.mScaleType.ordinal()]) {
            case 1:
                fitCenter();
                return;
            case 2:
                centerCrop();
                return;
            case 3:
                matrix();
                return;
            case 4:
                fitXY();
                return;
            case 5:
                fitStart();
                return;
            case 6:
                fitEnd();
                return;
            case 7:
                center();
                return;
            case 8:
                centerInside();
                return;
            default:
                return;
        }
    }

    private boolean isInPlaybackState() {
        int i3;
        if (this.mMediaPlayer != null && (i3 = this.mCurrentState) != -1 && i3 != 0 && i3 != 1) {
            return true;
        }
        return false;
    }

    private void matrix() {
        try {
            Matrix matrix = new Matrix();
            int width = getWidth();
            int height = getHeight();
            if (width != 0 && height != 0) {
                matrix.setScale(this.mVideoWidth / width, this.mVideoHeight / height);
                setTransform(matrix);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private void realStart(boolean z16) {
        if (isInPlaybackState()) {
            try {
                this.mMediaPlayer.start();
                this.mCurrentState = 3;
                this.mHandler.removeMessages(0);
                this.mHandler.sendEmptyMessage(0);
            } catch (Throwable unused) {
                Logger.w(LOG_TAG, "start failed");
            }
        }
        if (this.mTargetState == 4 && !z16) {
            pause();
        } else {
            this.mTargetState = 3;
        }
    }

    private void release(boolean z16) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.reset();
                mediaPlayer.release();
                this.mMediaPlayer = null;
                this.mCurrentState = 0;
                if (z16) {
                    this.mTargetState = 0;
                }
            } catch (Throwable unused) {
                Logger.w(LOG_TAG, "release failed");
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        return -1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        if (this.mMediaPlayer != null) {
            return this.mCurrentBufferPercentage;
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getDuration();
        }
        return -1;
    }

    public int getVideoHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        return this.mVideoHeight;
    }

    public int getVideoWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        return this.mVideoWidth;
    }

    public void initVideoView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        setFocusable(false);
        setSurfaceTextureListener(this.mSurfaceTextureListener);
        this.mCurrentState = 0;
        this.mTargetState = 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        super.onDetachedFromWindow();
        stopPlayback();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) accessibilityEvent);
        } else {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(VideoView.class.getName());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) accessibilityNodeInfo);
        } else {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(VideoView.class.getName());
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) view, i3);
            return;
        }
        super.onVisibilityChanged(view, i3);
        if ((i3 == 4 || i3 == 8) && isPlaying()) {
            stopPlayback();
        }
    }

    public void openVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.mUri != null && this.mSurface != null) {
            if (this.mIsSound && this.mContext != null) {
                Intent intent = new Intent("com.android.music.musicservicecommand");
                intent.putExtra("command", "pause");
                this.mContext.sendBroadcast(intent);
            }
            release(false);
            try {
                ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
                this.mMediaPlayer = reportMediaPlayer;
                if (!this.mIsSound) {
                    reportMediaPlayer.setVolume(0.0f, 0.0f);
                } else {
                    reportMediaPlayer.setVolume(1.0f, 1.0f);
                }
                this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
                this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
                this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
                this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
                this.mMediaPlayer.setOnInfoListener(this.mInfoListener);
                this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
                this.mCurrentBufferPercentage = 0;
                this.mMediaPlayer.setDataSource(this.mContext, this.mUri);
                this.mMediaPlayer.setSurface(this.mSurface);
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.setScreenOnWhilePlaying(true);
                this.mMediaPlayer.prepareAsync();
                this.mCurrentState = 1;
            } catch (Throwable unused) {
                this.mCurrentState = -1;
                this.mTargetState = -1;
                Logger.w(LOG_TAG, "openVideo failed");
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (isInPlaybackState()) {
            try {
                if (this.mMediaPlayer.isPlaying()) {
                    this.mMediaPlayer.pause();
                    this.mCurrentState = 4;
                    this.mHandler.removeMessages(0);
                    VideoStatusListener videoStatusListener = this.mVideoStatusListener;
                    if (videoStatusListener != null) {
                        videoStatusListener.onVideoPause();
                    }
                }
            } catch (Throwable unused) {
                Logger.w(LOG_TAG, "pause failed");
            }
        }
        this.mTargetState = 4;
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        realStart(true);
        VideoStatusListener videoStatusListener = this.mVideoStatusListener;
        if (videoStatusListener != null) {
            videoStatusListener.onVideoResume();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else if (isInPlaybackState()) {
            try {
                this.mMediaPlayer.seekTo(i3);
            } catch (Throwable unused) {
                Logger.w(LOG_TAG, "seekTo failed");
            }
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) onCompletionListener);
        } else {
            this.mOnCompletionListener = onCompletionListener;
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) onErrorListener);
        } else {
            this.mOnErrorListener = onErrorListener;
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) onInfoListener);
        } else {
            this.mOnInfoListener = onInfoListener;
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) onPreparedListener);
        } else {
            this.mOnPreparedListener = onPreparedListener;
        }
    }

    public void setScaleType(@NonNull ScaleType scaleType) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) scaleType);
            return;
        }
        if (scaleType != null && this.mScaleType != scaleType) {
            this.mScaleType = scaleType;
            if (scaleType == ScaleType.CENTER) {
                z16 = true;
            } else {
                z16 = false;
            }
            setWillNotCacheDrawing(z16);
            requestLayout();
            invalidate();
            initVideo();
        }
    }

    public void setSound(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
            return;
        }
        this.mIsSound = z16;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            if (!z16) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                mediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
    }

    public void setVideoPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else if (str != null) {
            setVideoURI(Uri.parse(str));
        }
    }

    public void setVideoStatusListener(VideoStatusListener videoStatusListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) videoStatusListener);
        } else {
            this.mVideoStatusListener = videoStatusListener;
        }
    }

    public void setVideoURI(Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) uri);
            return;
        }
        this.mUri = uri;
        openVideo();
        requestLayout();
        invalidate();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            realStart(false);
        }
    }

    public void stopPlayback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && this.mCurrentState != 0) {
            try {
                mediaPlayer.stop();
                mediaPlayer.reset();
                mediaPlayer.release();
            } catch (Throwable th5) {
                Logger.e("stopPlayback error:", th5);
            }
            this.mHandler.removeMessages(0);
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            this.mTargetState = 0;
        }
    }

    public void suspend() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            release(false);
        }
    }
}
