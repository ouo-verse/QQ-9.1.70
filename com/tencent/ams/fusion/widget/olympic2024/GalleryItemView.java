package com.tencent.ams.fusion.widget.olympic2024;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.olympic2024.TextureVideoView;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GalleryItemView extends RoundCornerFrameLayout {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "GalleryItemView";
    private static final String VIDEO_THREAD_NAME = "GalleryVideoItemThread";
    private GalleryItem mGalleryItem;
    private int mGalleryType;
    private ImageView mImageView;
    private int mIndex;
    private volatile Handler mVideoHandler;
    private VideoStatusListener mVideoStatusListener;
    private volatile HandlerThread mVideoThread;
    private TextureVideoView mVideoView;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface VideoStatusListener {
        void onVideoComplete(int i3, MediaPlayer mediaPlayer);

        void onVideoError(int i3, int i16);

        void onVideoPause(int i3);

        void onVideoPlayUpdate(int i3, long j3);

        void onVideoResume(int i3);

        void onVideoStarted(int i3, long j3);
    }

    public GalleryItemView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private boolean checkItem(GalleryItem galleryItem) {
        if (galleryItem == null) {
            return false;
        }
        if (galleryItem.getImage() == null && TextUtils.isEmpty(galleryItem.getVideoPath())) {
            return false;
        }
        return true;
    }

    private void closeVideoThread() {
        Logger.i("closeVideoThread");
        HandlerThread handlerThread = this.mVideoThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.mVideoThread = null;
        }
        Handler handler = this.mVideoHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mVideoHandler = null;
        }
    }

    private ImageView createImageView(@NonNull GalleryItem galleryItem) {
        if (galleryItem.getImage() == null) {
            return null;
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageBitmap(galleryItem.getImage());
        return imageView;
    }

    private TextureVideoView createVideoView(@NonNull GalleryItem galleryItem) {
        TextureVideoView textureVideoView = new TextureVideoView(getContext());
        textureVideoView.setScaleType(TextureVideoView.ScaleType.FIT_XY);
        textureVideoView.setVideoURI(Uri.parse(galleryItem.getVideoPath()));
        textureVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.GalleryItemView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GalleryItemView.this);
                }
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    GalleryItemView.this.showImage();
                    if (GalleryItemView.this.mVideoStatusListener != null) {
                        GalleryItemView.this.mVideoStatusListener.onVideoError(GalleryItemView.this.mIndex, i3);
                    }
                    return true;
                }
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
            }
        });
        textureVideoView.setOnInfoListener(new MediaPlayer.OnInfoListener(textureVideoView) { // from class: com.tencent.ams.fusion.widget.olympic2024.GalleryItemView.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ TextureVideoView val$videoView;

            {
                this.val$videoView = textureVideoView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GalleryItemView.this, (Object) textureVideoView);
                }
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i3, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
                }
                if (i3 == 3) {
                    GalleryItemView.this.hideImage();
                    if (GalleryItemView.this.mVideoStatusListener != null) {
                        GalleryItemView.this.mVideoStatusListener.onVideoStarted(GalleryItemView.this.mIndex, this.val$videoView.getDuration());
                    }
                }
                return true;
            }
        });
        textureVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.GalleryItemView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GalleryItemView.this);
                }
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaPlayer);
                } else if (GalleryItemView.this.mVideoStatusListener != null) {
                    GalleryItemView.this.mVideoStatusListener.onVideoComplete(GalleryItemView.this.mIndex, mediaPlayer);
                }
            }
        });
        textureVideoView.setVideoStatusListener(new com.tencent.ams.fusion.widget.olympic2024.VideoStatusListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.GalleryItemView.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GalleryItemView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.olympic2024.VideoStatusListener
            public void onVideoPause() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (GalleryItemView.this.mVideoStatusListener != null) {
                    GalleryItemView.this.mVideoStatusListener.onVideoPause(GalleryItemView.this.mIndex);
                }
            }

            @Override // com.tencent.ams.fusion.widget.olympic2024.VideoStatusListener
            public void onVideoPlayUpdate(long j3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, j3);
                } else if (GalleryItemView.this.mVideoStatusListener != null) {
                    GalleryItemView.this.mVideoStatusListener.onVideoPlayUpdate(GalleryItemView.this.mIndex, j3);
                }
            }

            @Override // com.tencent.ams.fusion.widget.olympic2024.VideoStatusListener
            public void onVideoResume() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                } else if (GalleryItemView.this.mVideoStatusListener != null) {
                    GalleryItemView.this.mVideoStatusListener.onVideoResume(GalleryItemView.this.mIndex);
                }
            }
        });
        initVideoThread();
        return textureVideoView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideImage() {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    private void initVideoThread() {
        if (this.mVideoThread == null) {
            Logger.i("initVideoThread");
            this.mVideoThread = new BaseHandlerThread(VIDEO_THREAD_NAME);
            this.mVideoThread.start();
            this.mVideoHandler = new Handler(this.mVideoThread.getLooper());
        }
    }

    private void initView(GalleryItem galleryItem, int i3) {
        if (galleryItem == null) {
            return;
        }
        removeAllViews();
        if (isVideoType(galleryItem)) {
            TextureVideoView createVideoView = createVideoView(galleryItem);
            this.mVideoView = createVideoView;
            addView(createVideoView);
        }
        this.mImageView = createImageView(galleryItem);
        setRadius(galleryItem.getRadius());
        if (this.mIndex != 0) {
            setAlpha(galleryItem.getInitAlpha());
        }
        if (this.mGalleryType == 0) {
            int i16 = this.mIndex;
            if (i16 == 0) {
                galleryItem.setInitRotation(1.0f);
                galleryItem.setDisplayRotation(3.0f);
                galleryItem.setDismissRotation(1.0f);
            } else if (i16 == i3 - 1) {
                galleryItem.setInitRotation(-1.0f);
                galleryItem.setDisplayRotation(0.0f);
            } else {
                galleryItem.setInitRotation(-1.0f);
                galleryItem.setDisplayRotation(3.0f);
                galleryItem.setDismissRotation(1.0f);
            }
            setRotation(galleryItem.getInitRotation());
        }
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            addView(imageView);
        }
    }

    private boolean isVideoType(GalleryItem galleryItem) {
        return (galleryItem == null || TextUtils.isEmpty(galleryItem.getVideoPath())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideoImpl() {
        TextureVideoView textureVideoView = this.mVideoView;
        if (textureVideoView != null) {
            textureVideoView.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeVideoImpl() {
        TextureVideoView textureVideoView = this.mVideoView;
        if (textureVideoView != null) {
            textureVideoView.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showImage() {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVideoImpl() {
        TextureVideoView textureVideoView = this.mVideoView;
        if (textureVideoView != null) {
            textureVideoView.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVideoImpl() {
        TextureVideoView textureVideoView = this.mVideoView;
        if (textureVideoView != null) {
            textureVideoView.stopPlayback();
        }
        closeVideoThread();
    }

    public GalleryItem getGalleryItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (GalleryItem) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mGalleryItem;
    }

    public long getVideoDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        if (this.mVideoView != null) {
            return r0.getDuration();
        }
        return 0L;
    }

    public void pauseVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Handler handler = this.mVideoHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.ams.fusion.widget.olympic2024.GalleryItemView.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GalleryItemView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        GalleryItemView.this.pauseVideoImpl();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            Logger.e(TAG, "pauseVideo videoHandler null");
        }
    }

    public void resumeVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Handler handler = this.mVideoHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.ams.fusion.widget.olympic2024.GalleryItemView.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GalleryItemView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        GalleryItemView.this.resumeVideoImpl();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            Logger.e(TAG, "resumeVideo videoHandler null");
        }
    }

    public void setCompleteListener(VideoStatusListener videoStatusListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) videoStatusListener);
        } else {
            this.mVideoStatusListener = videoStatusListener;
        }
    }

    public void setGalleryItem(GalleryItem galleryItem, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, galleryItem, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (!checkItem(galleryItem)) {
            Logger.w(TAG, "invalid gallery item, please check!");
            return;
        }
        this.mGalleryType = i3;
        if (!galleryItem.equals(this.mGalleryItem)) {
            this.mGalleryItem = galleryItem;
            initView(galleryItem, i16);
        }
    }

    public void setIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.mIndex = i3;
        }
    }

    public void startVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            startVideo(0L);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public void stopVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Handler handler = this.mVideoHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.ams.fusion.widget.olympic2024.GalleryItemView.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GalleryItemView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        GalleryItemView.this.stopVideoImpl();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            Logger.e(TAG, "stopVideo videoHandler null");
        }
    }

    public boolean isVideoType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.mVideoView != null : ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
    }

    public void startVideo(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
            return;
        }
        Handler handler = this.mVideoHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.tencent.ams.fusion.widget.olympic2024.GalleryItemView.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GalleryItemView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        GalleryItemView.this.startVideoImpl();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, j3);
        } else {
            Logger.e(TAG, "startVideo videoHandler null");
        }
    }
}
