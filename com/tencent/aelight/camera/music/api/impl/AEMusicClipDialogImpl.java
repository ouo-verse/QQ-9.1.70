package com.tencent.aelight.camera.music.api.impl;

import android.R;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView;
import com.tencent.aelight.camera.music.api.IAEMusicClipDialog;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.lyric.d;
import com.tencent.mobileqq.wink.editor.music.lyric.e;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.IOException;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEMusicClipDialogImpl implements IAEMusicClipDialog, d.InterfaceC9031d, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
    public static final String TAG = "AEMusicClipDialogImpl";
    public static final int WINK_MUSIC_WAVE_VIEW_HEIGHT = 59;
    private FrameLayout loadingContainer;
    private BroadcastReceiver loadingReceiver;
    private AEEditorLoadingView loadingView;
    private WeakReference<Context> mContext;
    private MediaPlayer mediaPlayer;
    private JSONObject musicData;
    private Handler playHandler;
    private ViewGroup viewRoot;
    private int waveViewHeight;
    private d winkDialog;
    private int videoClipDuration = 0;
    private int musicClipDuration = 0;
    private int currentStartPosition = 0;
    private int recommStartPosition = 0;
    private int currentPosition = 0;
    private Integer cachedStartTimeInMs = null;
    private boolean isLoadingShow = false;
    private boolean isQCircle = true;
    private Runnable runnable = new Runnable() { // from class: com.tencent.aelight.camera.music.api.impl.AEMusicClipDialogImpl.2
        @Override // java.lang.Runnable
        public void run() {
            AEMusicClipDialogImpl aEMusicClipDialogImpl = AEMusicClipDialogImpl.this;
            aEMusicClipDialogImpl.currentPosition = aEMusicClipDialogImpl.mediaPlayer.getCurrentPosition();
            if (!AEMusicClipDialogImpl.this.isQCircle) {
                if (AEMusicClipDialogImpl.this.currentPosition > AEMusicClipDialogImpl.this.currentStartPosition + AEMusicClipDialogImpl.this.videoClipDuration) {
                    AEMusicClipDialogImpl.this.mediaPlayer.seekTo(AEMusicClipDialogImpl.this.currentStartPosition);
                    AEMusicClipDialogImpl.this.winkDialog.Z(0, AEMusicClipDialogImpl.this.videoClipDuration);
                    e.a().e(0L, AEMusicClipDialogImpl.this.videoClipDuration);
                } else {
                    AEMusicClipDialogImpl.this.winkDialog.Z(AEMusicClipDialogImpl.this.currentPosition - AEMusicClipDialogImpl.this.currentStartPosition, AEMusicClipDialogImpl.this.videoClipDuration);
                    e.a().e(AEMusicClipDialogImpl.this.currentPosition - AEMusicClipDialogImpl.this.currentStartPosition, AEMusicClipDialogImpl.this.videoClipDuration);
                }
            }
            AEMusicClipDialogImpl.this.playHandler.postDelayed(this, 100L);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ms.a.f(AEMusicClipDialogImpl.TAG, "[showMusicClipDialogOnWebView.BroadcastReceiver.onReceive]");
            String action = intent.getAction();
            if (!QQWinkConstants.QQWinkBroadcast.ACTION_DISPATCH_MUSIC_EVENT.equals(action)) {
                ms.a.f(AEMusicClipDialogImpl.TAG, "[showMusicClipDialogOnWebView.BroadcastReceiver.onReceive], invalid action = " + action);
                return;
            }
            String stringExtra = intent.getStringExtra("event");
            if (QQWinkConstants.JS_PLUGIN_EVENT_PLAY_MEDIA_CACHE_MUSIC_SUCCESS.equals(stringExtra)) {
                AEMusicClipDialogImpl.this.hideLoadingView();
                AEMusicClipDialogImpl.this.destroyLoadingView();
                AEMusicClipDialogImpl.this.closeMusicWebViewActivity();
            } else {
                ms.a.f(AEMusicClipDialogImpl.TAG, "[showMusicClipDialogOnWebView.BroadcastReceiver.onReceive], not cache event, event = " + stringExtra);
            }
        }
    }

    private void bindPlayerWithDialogHandler() {
        if (this.mediaPlayer == null) {
            return;
        }
        Handler handler = new Handler();
        this.playHandler = handler;
        handler.post(this.runnable);
    }

    private void closeMusicClipDialog() {
        Handler handler = this.playHandler;
        if (handler != null) {
            handler.removeCallbacks(this.runnable);
            this.playHandler = null;
        }
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
        d dVar = this.winkDialog;
        if (dVar != null) {
            dVar.dismiss();
            this.winkDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeMusicWebViewActivity() {
        closeMusicClipDialog();
        if (this.loadingReceiver != null) {
            try {
                BaseApplicationImpl.getApplication().unregisterReceiver(this.loadingReceiver);
            } catch (Exception e16) {
                ms.a.a(TAG, "closeMusicWebViewActivity, " + e16.toString());
            }
        }
        this.loadingReceiver = null;
        clearAllMemberObject();
        Intent intent = new Intent("com.tencent.mobileqq.action.closewebview");
        intent.putExtra("event", "closeWebView");
        BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyLoadingView() {
        if (this.mContext.get() == null) {
            return;
        }
        ViewGroup viewGroup = this.viewRoot;
        if (viewGroup != null) {
            viewGroup.removeView(this.loadingContainer);
            this.viewRoot = null;
        }
        FrameLayout frameLayout = this.loadingContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.loadingContainer = null;
        }
        if (this.loadingView != null) {
            this.loadingView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.mContext.get() == null) {
            return;
        }
        AEEditorLoadingView aEEditorLoadingView = this.loadingView;
        if (aEEditorLoadingView != null) {
            aEEditorLoadingView.i();
        }
        ViewGroup viewGroup = this.viewRoot;
        if (viewGroup != null) {
            viewGroup.removeView(this.loadingContainer);
        }
    }

    private void initExtras(Context context) {
        Intent intent;
        if ((context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null) {
            this.videoClipDuration = intent.getIntExtra("videoclipduration", 0);
            String stringExtra = intent.getStringExtra("videofrom");
            if (stringExtra == null || !stringExtra.equals("fromqqwink")) {
                return;
            }
            this.isQCircle = false;
        }
    }

    private void initLoadingView() {
        if (this.mContext.get() == null) {
            return;
        }
        if (this.loadingView == null) {
            AEEditorLoadingView aEEditorLoadingView = new AEEditorLoadingView(this.mContext.get());
            this.loadingView = aEEditorLoadingView;
            aEEditorLoadingView.setFromQCircle(this.isQCircle);
            this.loadingView.o(4);
        }
        if (this.loadingContainer == null) {
            FrameLayout frameLayout = new FrameLayout(this.mContext.get());
            this.loadingContainer = frameLayout;
            frameLayout.addView(this.loadingView, -1, -1);
        }
        if (this.viewRoot == null) {
            this.viewRoot = (ViewGroup) ((Activity) this.mContext.get()).findViewById(R.id.content);
        }
    }

    private void initMusicInfo(VsMusicItemInfo vsMusicItemInfo) {
        if (vsMusicItemInfo != null) {
            int i3 = vsMusicItemInfo.musicStart;
            this.recommStartPosition = i3;
            this.currentStartPosition = i3;
        }
    }

    private void pauseMusic() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    private void playMusic() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    private void prepareClipMusic(VsMusicItemInfo vsMusicItemInfo) throws IOException {
        if (this.mediaPlayer == null || vsMusicItemInfo == null || TextUtils.isEmpty(vsMusicItemInfo.mUrl)) {
            return;
        }
        this.mediaPlayer.setDataSource(vsMusicItemInfo.mUrl);
        this.mediaPlayer.setVolume(0.8f, 0.8f);
        this.mediaPlayer.setOnPreparedListener(this);
        this.mediaPlayer.setOnSeekCompleteListener(this);
        this.mediaPlayer.prepareAsync();
    }

    private void registerLoadingFilter() {
        if (this.loadingReceiver == null) {
            this.loadingReceiver = new a();
            BaseApplicationImpl.getApplication().registerReceiver(this.loadingReceiver, new IntentFilter(QQWinkConstants.QQWinkBroadcast.ACTION_DISPATCH_MUSIC_EVENT));
        }
    }

    private void requestDetailedMusicInfoForWeb(com.tencent.mobileqq.wink.editor.music.VsMusicItemInfo vsMusicItemInfo) {
        if (!TextUtils.isEmpty(vsMusicItemInfo.mSongMid) && WinkEditorMusicHelper.L(vsMusicItemInfo)) {
            WinkEditorMusicInfo winkEditorMusicInfo = new WinkEditorMusicInfo(vsMusicItemInfo, false, 2, "");
            if (winkEditorMusicInfo.j() != null) {
                winkEditorMusicInfo.j().musicStart = this.recommStartPosition;
            }
            this.musicClipDuration = winkEditorMusicInfo.n();
            showClipDialog(winkEditorMusicInfo);
            try {
                prepareClipMusic(vsMusicItemInfo);
            } catch (IOException e16) {
                ms.a.f(TAG, "[requestDetailedMusicInfo] exception = " + e16.toString());
            }
        }
    }

    private void showClipDialog(WinkEditorMusicInfo winkEditorMusicInfo) {
        if (this.winkDialog.isShowing()) {
            return;
        }
        this.winkDialog.c0(winkEditorMusicInfo, this.currentStartPosition, this.videoClipDuration, ViewUtils.getScreenWidth(), this.waveViewHeight, false);
        d dVar = this.winkDialog;
        int i3 = this.currentStartPosition;
        dVar.a0(i3, this.videoClipDuration + i3);
        this.winkDialog.Y(this);
        this.winkDialog.show();
    }

    private void showLoadingView() {
        if (this.mContext.get() == null) {
            return;
        }
        this.viewRoot.addView(this.loadingContainer, -1, -1);
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.music.api.impl.AEMusicClipDialogImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (AEMusicClipDialogImpl.this.viewRoot != null) {
                    AEMusicClipDialogImpl.this.hideLoadingView();
                    AEMusicClipDialogImpl.this.destroyLoadingView();
                }
            }
        }, 10000L);
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
    public void onBlankClick() {
        closeMusicClipDialog();
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
    public void onClickConfirmBtn() {
        Intent intent = new Intent();
        intent.setAction(QQWinkConstants.QQWinkBroadcast.ACTION_DISPATCH_MUSIC_EVENT);
        intent.putExtra("data", this.musicData.toString());
        intent.putExtra("event", QQWinkConstants.JS_PLUGIN_EVENT_CLIP_MUSIC);
        intent.putExtra("clipStartTime", this.currentStartPosition);
        BaseApplicationImpl.getApplication().sendBroadcast(intent);
        this.cachedStartTimeInMs = null;
        if (this.isQCircle) {
            return;
        }
        hideLoadingView();
        destroyLoadingView();
        closeMusicWebViewActivity();
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
    public void onIndicatorDragged(int i3) {
        this.mediaPlayer.seekTo(this.currentStartPosition + i3);
        if (this.isQCircle) {
            return;
        }
        this.winkDialog.Z(i3, this.videoClipDuration);
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
    public void onMusicWaveMoveEnd(boolean z16) {
        Integer num = this.cachedStartTimeInMs;
        if (num != null) {
            this.mediaPlayer.seekTo(num.intValue());
            this.currentStartPosition = this.cachedStartTimeInMs.intValue();
            if (!this.isQCircle) {
                this.winkDialog.Z(0, this.videoClipDuration);
                e.a().d(this.cachedStartTimeInMs.intValue(), Math.min(this.cachedStartTimeInMs.intValue() + this.videoClipDuration, this.musicClipDuration));
            }
            this.cachedStartTimeInMs = null;
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
    public void onMusicWaveMoving(int i3, int i16) {
        if (!this.isQCircle) {
            this.winkDialog.a0(i3, i16);
        }
        this.cachedStartTimeInMs = Integer.valueOf(i3);
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
    public void onResetMusicRangeToRecommend(int i3) {
        this.currentStartPosition = i3;
        this.mediaPlayer.seekTo(i3);
        if (this.isQCircle) {
            return;
        }
        e.a().d(i3, Math.min(this.currentStartPosition + this.videoClipDuration, this.musicClipDuration));
        this.winkDialog.Z(0, this.videoClipDuration);
        d dVar = this.winkDialog;
        int i16 = this.currentStartPosition;
        dVar.a0(i16, this.videoClipDuration + i16);
        this.winkDialog.b0(this.currentStartPosition);
    }

    @Override // com.tencent.aelight.camera.music.api.IAEMusicClipDialog
    public void setIsQCircle(boolean z16) {
        this.isQCircle = z16;
    }

    @Override // com.tencent.aelight.camera.music.api.IAEMusicClipDialog
    public void showMusicClipDialogOnWebView(JSONObject jSONObject, Context context) {
        if (!(context instanceof Activity) || jSONObject == null) {
            return;
        }
        initExtras(context);
        this.musicData = jSONObject;
        this.waveViewHeight = ViewUtils.dpToPx(59.0f);
        if (!this.isQCircle) {
            this.winkDialog = new d(context);
        }
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        this.mediaPlayer = reportMediaPlayer;
        reportMediaPlayer.setAudioStreamType(3);
        if (!this.isQCircle) {
            com.tencent.mobileqq.wink.editor.music.VsMusicItemInfo k3 = WinkEditorMusicHelper.k(jSONObject);
            initMusicInfo(k3);
            requestDetailedMusicInfoForWeb(k3);
        }
        this.mContext = new WeakReference<>(context);
        registerLoadingFilter();
    }

    @Override // com.tencent.aelight.camera.music.api.IAEMusicClipDialog
    public void showMusicSelectLoadingOnWebView(JSONObject jSONObject, Context context) {
        if (!(context instanceof Activity) || jSONObject == null) {
            return;
        }
        initExtras(context);
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.mContext = weakReference;
        if (weakReference.get() instanceof QQBrowserActivity) {
            ((QQBrowserActivity) this.mContext.get()).getCurrentUrl();
        }
        Intent intent = new Intent();
        intent.setAction(QQWinkConstants.QQWinkBroadcast.ACTION_DISPATCH_MUSIC_EVENT);
        intent.putExtra("event", QQWinkConstants.JS_PLUGIN_EVENT_SELECT_MUSIC);
        intent.putExtra("data", jSONObject.toString());
        BaseApplicationImpl.getApplication().sendBroadcast(intent);
        if (this.isQCircle) {
            return;
        }
        hideLoadingView();
        destroyLoadingView();
        closeMusicWebViewActivity();
    }

    private void clearAllMemberObject() {
        this.mContext = null;
        this.winkDialog = null;
        this.mediaPlayer = null;
        this.playHandler = null;
        this.viewRoot = null;
        this.loadingView = null;
        this.loadingContainer = null;
        this.musicData = null;
        this.cachedStartTimeInMs = null;
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
    public void onClickCancelBtn(boolean z16) {
        this.cachedStartTimeInMs = null;
        closeMusicClipDialog();
    }

    private void initMusicInfo(com.tencent.mobileqq.wink.editor.music.VsMusicItemInfo vsMusicItemInfo) {
        if (vsMusicItemInfo != null) {
            int i3 = vsMusicItemInfo.musicStart;
            this.recommStartPosition = i3;
            this.currentStartPosition = i3;
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(this.currentStartPosition);
            if (!this.isQCircle) {
                this.winkDialog.Z(0, this.videoClipDuration);
            }
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
            bindPlayerWithDialogHandler();
        }
    }

    private void prepareClipMusic(com.tencent.mobileqq.wink.editor.music.VsMusicItemInfo vsMusicItemInfo) throws IOException {
        if (this.mediaPlayer == null || vsMusicItemInfo == null || TextUtils.isEmpty(vsMusicItemInfo.mUrl)) {
            return;
        }
        this.mediaPlayer.setDataSource(vsMusicItemInfo.mUrl);
        this.mediaPlayer.setVolume(0.8f, 0.8f);
        this.mediaPlayer.setOnPreparedListener(this);
        this.mediaPlayer.setOnSeekCompleteListener(this);
        this.mediaPlayer.prepareAsync();
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
    public void onLyricClick(int i3) {
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
    public void show(boolean z16) {
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
    public void onMusicWaveMoveStart() {
    }
}
