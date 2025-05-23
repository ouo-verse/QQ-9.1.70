package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.module.feedcomponent.manage.FeedZipResDownloadManager;
import com.qzone.proxy.feedcomponent.model.AudioInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.widget.AudioMediaPlayer;
import com.qzone.proxy.feedcomponent.widget.PieChart;
import com.qzone.proxy.feedcomponent.widget.ToastUtils;
import com.qzone.proxy.feedcomponent.widget.c;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.component.media.photogif.QzoneAnimationDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AudioFeedBubble extends LinearLayout implements com.qzone.proxy.feedcomponent.widget.d {
    private static final String FRAME_RESOURCE_URL = "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/audio_btn_playing_frames/audio_btn_playing_frames.zip";
    public static final int IS_LOADING = 2;
    public static final double MAX_AUDIO_LENGTH = 60.0d;
    public static final int PLAY = 1;
    public static final int STOP = 0;
    static ArrayList<WeakReference<AudioFeedBubble>> bubbleList;
    QzoneAnimationDrawable animationDrawable;
    AudioInfo audioInfo;
    AudioMediaPlayer audioMediaPlayer;
    ImageView audioPlayButtonIcon;
    PieChart audioPlayButtonProgress;
    TextView audioPlayButtonText;
    boolean canPlay;
    int currentState;
    int feedPos;
    boolean isWithPic;
    BusinessFeedData mFeedData;
    RotateAnimation mRotateAnimation;
    View.OnClickListener onClickListener;
    MediaPlayer.OnCompletionListener onCompletionListener;
    MediaPlayer.OnErrorListener onErrorListener;
    AudioMediaPlayer.c onProgressListener;
    String referId;
    String uniKey;
    private static String audioFileNotExist = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AudioFileNotExist", "\u97f3\u9891\u6587\u4ef6\u4e0d\u5b58\u5728");
    private static String urlNotExist = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AudioFileUrlNotExist", "\u97f3\u9891\u6587\u4ef6URL\u5730\u5740\u4e0d\u5b58\u5728");
    private static String playFail = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AudioPlayFail", "\u64ad\u653e\u8bed\u97f3\u6587\u4ef6\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
    private static String fileNotExistError = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AudioFileNotExistError", ImageTaskConst.ErrorDesciption.IMAGE_TASK_NO_SUCH_FILE_DESC);

    public AudioFeedBubble(Context context) {
        super(context);
        this.canPlay = true;
        this.currentState = 0;
        this.feedPos = -1;
        this.onClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                AudioFeedBubble audioFeedBubble = AudioFeedBubble.this;
                if (audioFeedBubble.canPlay) {
                    int i3 = audioFeedBubble.currentState;
                    if (i3 == 0) {
                        audioFeedBubble.play();
                    } else if (i3 == 1 || i3 == 2) {
                        audioFeedBubble.stop();
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.onCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.4
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                AudioFeedBubble.this.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AudioFeedBubble.this.stop();
                    }
                });
            }
        };
        this.onProgressListener = new AudioMediaPlayer.c() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.5
            @Override // com.qzone.proxy.feedcomponent.widget.AudioMediaPlayer.c
            public void onProgress(int i3, int i16) {
                AudioFeedBubble audioFeedBubble = AudioFeedBubble.this;
                PieChart pieChart = audioFeedBubble.audioPlayButtonProgress;
                if (pieChart == null || audioFeedBubble.currentState != 1) {
                    return;
                }
                if (pieChart.getVisibility() == 8) {
                    AudioFeedBubble.this.startAnimate();
                }
                AudioFeedBubble.this.audioPlayButtonProgress.setPercent(i3 / i16);
                AudioFeedBubble.this.setAudioText((int) Math.ceil(r4 / 1000.0f));
            }
        };
        this.onErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.6
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
                String str = AudioFeedBubble.playFail;
                if (i3 == -2) {
                    str = AudioFeedBubble.fileNotExistError;
                }
                AudioFeedBubble.this.handleOnError(str);
                return false;
            }
        };
        init();
    }

    private QzoneAnimationDrawable getAnimationDrawable() {
        if (this.animationDrawable == null) {
            String unzippedFolderPath = FeedZipResDownloadManager.getInstance().getUnzippedFolderPath(FRAME_RESOURCE_URL, new FeedZipResDownloadManager.FeedZipResDownloadListener() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.7
                @Override // com.qzone.module.feedcomponent.manage.FeedZipResDownloadManager.FeedZipResDownloadListener
                public void onDownloaded(String str, String str2) {
                    AudioFeedBubble audioFeedBubble = AudioFeedBubble.this;
                    audioFeedBubble.animationDrawable = audioFeedBubble.getDrawable(str2);
                    AudioFeedBubble audioFeedBubble2 = AudioFeedBubble.this;
                    if (audioFeedBubble2.currentState == 1) {
                        audioFeedBubble2.animationDrawable.start();
                        if (AudioFeedBubble.this.getHandler() != null) {
                            AudioFeedBubble.this.getHandler().post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AudioFeedBubble audioFeedBubble3 = AudioFeedBubble.this;
                                    audioFeedBubble3.audioPlayButtonIcon.setBackgroundDrawable(audioFeedBubble3.animationDrawable);
                                }
                            });
                        }
                    }
                    com.qzone.proxy.feedcomponent.b.e("FRAME_ANIMATION", "success to download resource, path: " + str2);
                }

                @Override // com.qzone.module.feedcomponent.manage.FeedZipResDownloadManager.FeedZipResDownloadListener
                public void onFailed(String str) {
                    com.qzone.proxy.feedcomponent.b.e("FRAME_ANIMATION", "failed to download resource " + str);
                }
            });
            if (unzippedFolderPath == null) {
                return null;
            }
            this.animationDrawable = getDrawable(unzippedFolderPath);
            com.qzone.proxy.feedcomponent.b.e("FRAME_ANIMATION", unzippedFolderPath);
        }
        return this.animationDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QzoneAnimationDrawable getDrawable(String str) {
        if (new File(str).list() == null) {
            return null;
        }
        int length = new File(str).list().length;
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(str + "/audio_btn_playing_" + i3 + ".png");
        }
        return QzoneAnimationDrawable.Builder.create().setPhotos(arrayList).setDelayTime(40L).setReqWidth(51).setReqHeight(51).setRepeatCount(0).build();
    }

    public static void stopAll() {
        try {
            if (bubbleList == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(bubbleList);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                WeakReference weakReference = (WeakReference) arrayList.get(size);
                if (weakReference != null) {
                    AudioFeedBubble audioFeedBubble = (AudioFeedBubble) weakReference.get();
                    if (audioFeedBubble != null) {
                        audioFeedBubble.stop();
                    }
                } else {
                    bubbleList.remove(weakReference);
                }
            }
        } catch (Throwable th5) {
            com.qzone.proxy.feedcomponent.b.d("AudioBubble", "stopAll exception", th5);
        }
    }

    public void bindPlayerListener() {
        if (this.audioMediaPlayer == null) {
            this.audioMediaPlayer = AudioMediaPlayer.a();
        }
        this.audioMediaPlayer.h(this.onCompletionListener);
        this.audioMediaPlayer.i(this.onErrorListener);
        this.audioMediaPlayer.j(this.onProgressListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getSaveDir() {
        if (TextUtils.isEmpty(this.uniKey)) {
            this.uniKey = String.valueOf(System.currentTimeMillis());
        }
        return com.qzone.adapter.feedcomponent.i.H().M(com.qzone.adapter.feedcomponent.i.H().j0(), this.uniKey);
    }

    @Override // com.qzone.proxy.feedcomponent.widget.d
    public String getUniKey() {
        return this.uniKey;
    }

    void handleOnError(String str) {
        ToastUtils.b(getContext(), str);
        stop();
    }

    void init() {
        try {
            LayoutInflater.from(getContext()).inflate(com.qzone.adapter.feedcomponent.j.j(1698), this);
            this.audioPlayButtonIcon = (ImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2584));
            this.audioPlayButtonText = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2585));
            this.audioPlayButtonProgress = (PieChart) findViewById(com.qzone.adapter.feedcomponent.j.O(2586));
            setOnClickListener(this.onClickListener);
            if (bubbleList == null) {
                bubbleList = new ArrayList<>();
                com.qzone.proxy.feedcomponent.widget.a.f50942a = false;
            }
            bubbleList.add(new WeakReference<>(this));
            getContext();
            this.currentState = 0;
            PieChart pieChart = this.audioPlayButtonProgress;
            if (pieChart != null) {
                pieChart.setColor(-16344);
                this.audioPlayButtonProgress.setVisibility(8);
            }
        } catch (Throwable th5) {
            com.qzone.proxy.feedcomponent.b.d("mars", "AudioFeedBubble error ", th5);
        }
    }

    public void onRecycled() {
        stopAnimate();
        RotateAnimation rotateAnimation = this.mRotateAnimation;
        if (rotateAnimation != null) {
            rotateAnimation.reset();
            this.mRotateAnimation = null;
        }
    }

    @Override // com.qzone.proxy.feedcomponent.widget.d
    public void play() {
        String str;
        if (this.isWithPic) {
            str = "2";
        } else {
            str = "1";
        }
        com.qzone.adapter.feedcomponent.i.H().X1("310", str, "", 311, this.referId);
        stopAll();
        setCurrentState(2);
        AudioInfo audioInfo = this.audioInfo;
        if (audioInfo == null) {
            handleOnError(audioFileNotExist);
            return;
        }
        if (!TextUtils.isEmpty(audioInfo.errorMessage)) {
            handleOnError(this.audioInfo.errorMessage);
            return;
        }
        String str2 = this.audioInfo.audioKey;
        if (TextUtils.isEmpty(str2)) {
            handleOnError(urlNotExist);
            return;
        }
        com.qzone.adapter.feedcomponent.i.H().c(this.mFeedData, 3);
        if (TextUtils.isEmpty(this.uniKey)) {
            this.uniKey = str2;
        }
        com.qzone.proxy.feedcomponent.widget.c i06 = com.qzone.adapter.feedcomponent.i.H().i0(str2, getSaveDir(), getContext());
        i06.c(new String[]{"text/html", "image", "text/plain"});
        i06.a(new c.a() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.1
            @Override // com.qzone.proxy.feedcomponent.widget.c.a
            public void onUploadError(int i3, String str3, final String str4) {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    AudioFeedBubble.this.handleOnError(str4);
                } else if (AudioFeedBubble.this.getHandler() != null) {
                    AudioFeedBubble.this.getHandler().post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioFeedBubble.this.handleOnError(str4);
                        }
                    });
                }
            }

            @Override // com.qzone.proxy.feedcomponent.widget.c.a
            public void onUploadSucceed(String str3, final String str4) {
                if (AudioFeedBubble.this.currentState == 2) {
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        AudioFeedBubble.this.playAudio(str4);
                    } else if (AudioFeedBubble.this.getHandler() != null) {
                        AudioFeedBubble.this.getHandler().post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AudioFeedBubble.this.playAudio(str4);
                            }
                        });
                    }
                }
            }

            @Override // com.qzone.proxy.feedcomponent.widget.c.a
            public void onLoadFileStart() {
            }
        });
        i06.b();
    }

    public void resetState() {
        try {
            bindPlayerListener();
            int i3 = this.currentState;
            if (i3 == 0) {
                stopAnimate();
            } else if (i3 == 1) {
                startAnimate();
            } else if (i3 == 2) {
                startLoadingAnimate();
            }
        } catch (Error e16) {
            com.qzone.proxy.feedcomponent.b.d("AudioFeedBubble", "resetState:", e16);
        }
    }

    public void setAudioInfo(AudioInfo audioInfo) {
        this.audioInfo = audioInfo;
        FeedZipResDownloadManager.getInstance().getUnzippedFolderPath(FRAME_RESOURCE_URL, null);
        setAudioText(audioInfo.audioTime);
    }

    public void setBusinessFeedData(BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
    }

    public void setCanPlay(boolean z16) {
        this.canPlay = z16;
    }

    public void setCurrentState(int i3) {
        if (this.currentState == i3) {
            return;
        }
        this.currentState = i3;
        resetState();
    }

    public void setFeedPosition(int i3) {
        this.feedPos = i3;
    }

    public void setIsWithPic(boolean z16) {
        this.isWithPic = z16;
    }

    public void setUniKey(String str) {
        this.uniKey = str;
    }

    void startAnimate() {
        this.audioPlayButtonIcon.clearAnimation();
        this.audioPlayButtonIcon.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(com.tencent.luggage.wxa.he.e.CTRL_INDEX));
        QzoneAnimationDrawable animationDrawable = getAnimationDrawable();
        if (animationDrawable != null) {
            this.audioPlayButtonIcon.setBackgroundDrawable(animationDrawable);
            animationDrawable.start();
        }
    }

    void startLoadingAnimate() {
        this.audioPlayButtonIcon.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(778));
        if (this.mRotateAnimation == null) {
            LinearInterpolator linearInterpolator = new LinearInterpolator();
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            this.mRotateAnimation = rotateAnimation;
            rotateAnimation.setInterpolator(linearInterpolator);
            this.mRotateAnimation.setDuration(600L);
            this.mRotateAnimation.setRepeatCount(-1);
            this.mRotateAnimation.setRepeatMode(1);
        }
        this.audioPlayButtonIcon.startAnimation(this.mRotateAnimation);
    }

    void stopAnimate() {
        ImageView imageView = this.audioPlayButtonIcon;
        if (imageView != null) {
            imageView.clearAnimation();
            this.audioPlayButtonIcon.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(776));
        }
        PieChart pieChart = this.audioPlayButtonProgress;
        if (pieChart != null) {
            pieChart.setVisibility(8);
        }
    }

    void playAudio(String str) {
        setCurrentState(1);
        this.audioMediaPlayer.k(this, str);
    }

    void setAudioText(int i3) {
        int i16;
        int max = Math.max(0, i3);
        AudioInfo audioInfo = this.audioInfo;
        if (audioInfo != null && (i16 = audioInfo.audioTime) > 0) {
            max = Math.min(max, i16);
        }
        this.audioPlayButtonText.setText(max + "\"");
    }

    @Override // com.qzone.proxy.feedcomponent.widget.d
    public void stop() {
        com.qzone.proxy.feedcomponent.widget.d c16;
        setCurrentState(0);
        AudioMediaPlayer audioMediaPlayer = this.audioMediaPlayer;
        if (audioMediaPlayer != null && (c16 = audioMediaPlayer.c()) != null && c16.getUniKey() != null && c16.getUniKey().equals(getUniKey())) {
            this.audioMediaPlayer.n();
        }
        this.audioPlayButtonProgress.b();
        if (this.audioInfo != null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                setAudioText(this.audioInfo.audioTime);
            } else if (getHandler() != null) {
                getHandler().post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AudioFeedBubble audioFeedBubble = AudioFeedBubble.this;
                        audioFeedBubble.setAudioText(audioFeedBubble.audioInfo.audioTime);
                    }
                });
            }
        }
    }

    public AudioFeedBubble(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.canPlay = true;
        this.currentState = 0;
        this.feedPos = -1;
        this.onClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                AudioFeedBubble audioFeedBubble = AudioFeedBubble.this;
                if (audioFeedBubble.canPlay) {
                    int i3 = audioFeedBubble.currentState;
                    if (i3 == 0) {
                        audioFeedBubble.play();
                    } else if (i3 == 1 || i3 == 2) {
                        audioFeedBubble.stop();
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.onCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.4
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                AudioFeedBubble.this.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AudioFeedBubble.this.stop();
                    }
                });
            }
        };
        this.onProgressListener = new AudioMediaPlayer.c() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.5
            @Override // com.qzone.proxy.feedcomponent.widget.AudioMediaPlayer.c
            public void onProgress(int i3, int i16) {
                AudioFeedBubble audioFeedBubble = AudioFeedBubble.this;
                PieChart pieChart = audioFeedBubble.audioPlayButtonProgress;
                if (pieChart == null || audioFeedBubble.currentState != 1) {
                    return;
                }
                if (pieChart.getVisibility() == 8) {
                    AudioFeedBubble.this.startAnimate();
                }
                AudioFeedBubble.this.audioPlayButtonProgress.setPercent(i3 / i16);
                AudioFeedBubble.this.setAudioText((int) Math.ceil(r4 / 1000.0f));
            }
        };
        this.onErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.6
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
                String str = AudioFeedBubble.playFail;
                if (i3 == -2) {
                    str = AudioFeedBubble.fileNotExistError;
                }
                AudioFeedBubble.this.handleOnError(str);
                return false;
            }
        };
        init();
    }

    public AudioFeedBubble(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.canPlay = true;
        this.currentState = 0;
        this.feedPos = -1;
        this.onClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                AudioFeedBubble audioFeedBubble = AudioFeedBubble.this;
                if (audioFeedBubble.canPlay) {
                    int i36 = audioFeedBubble.currentState;
                    if (i36 == 0) {
                        audioFeedBubble.play();
                    } else if (i36 == 1 || i36 == 2) {
                        audioFeedBubble.stop();
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.onCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.4
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                AudioFeedBubble.this.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AudioFeedBubble.this.stop();
                    }
                });
            }
        };
        this.onProgressListener = new AudioMediaPlayer.c() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.5
            @Override // com.qzone.proxy.feedcomponent.widget.AudioMediaPlayer.c
            public void onProgress(int i36, int i16) {
                AudioFeedBubble audioFeedBubble = AudioFeedBubble.this;
                PieChart pieChart = audioFeedBubble.audioPlayButtonProgress;
                if (pieChart == null || audioFeedBubble.currentState != 1) {
                    return;
                }
                if (pieChart.getVisibility() == 8) {
                    AudioFeedBubble.this.startAnimate();
                }
                AudioFeedBubble.this.audioPlayButtonProgress.setPercent(i36 / i16);
                AudioFeedBubble.this.setAudioText((int) Math.ceil(r4 / 1000.0f));
            }
        };
        this.onErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.qzone.module.feedcomponent.ui.AudioFeedBubble.6
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i36, int i16) {
                String str = AudioFeedBubble.playFail;
                if (i36 == -2) {
                    str = AudioFeedBubble.fileNotExistError;
                }
                AudioFeedBubble.this.handleOnError(str);
                return false;
            }
        };
        init();
    }
}
