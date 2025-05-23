package com.tencent.mobileqq.minigame.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.minigame.data.MiniGameQCircleShareInfo;
import com.tencent.mobileqq.minigame.manager.FileDownloadManager;
import com.tencent.mobileqq.minigame.widget.MiniGameShareQCircleDialog;
import com.tencent.mobileqq.minigame.widget.MiniGameShareVideoStateView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.io.File;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniGameShareQCircleDialog extends DialogFragment implements View.OnClickListener, MiniGameShareVideoStateView.MiniGameShareMediaViewClickListener {
    private static final float DP_LANDSCAPE_COVER_HEIGHT = 169.0f;
    private static final float DP_LANDSCAPE_COVER_WIDTH = 236.0f;
    private static final float DP_PORTRAIT_COVER_HEIGHT = 390.0f;
    private static final float DP_PORTRAIT_COVER_WIDTH = 236.0f;
    private static final int NETWORK_STATE_WIFI = 1;
    private static final String REPORT_CLOSE_CLICK = "minigame_toxsj_popwindow_share_page_close";
    private static final String REPORT_DIALOG_SHOW = "minigame_toxsj_popwindow_share_page";
    private static final String REPORT_SEND_CLICK = "minigame_toxsj_popwindow_share_page_confirm";
    private static final String SAVE_KEY_SHARE_INFO = "save_key_share_info";
    public static final String TAG = "MiniGameShareQCircleDialog";
    public static final int VIDEO_STATE_END = 5;
    public static final int VIDEO_STATE_ERROR = 6;
    public static final int VIDEO_STATE_INIT = 1;
    public static final int VIDEO_STATE_PAUSE = 4;
    public static final int VIDEO_STATE_PLAYING = 3;
    public static final int VIDEO_STATE_PREPARED = 2;
    public static final int VIDEO_STATE_UN_KNOW = 0;
    private ImageView cover;
    private FrameLayout mediaContainer;
    private MiniGameShareVideoStateView mediaIconContainer;
    private Button negativeButton;
    private View.OnClickListener negativeListener;
    private Button positiveButton;
    private View.OnClickListener positiveListener;
    private View rootView;
    private MiniGameQCircleShareInfo shareInfo;
    private ISuperPlayer videoPlayer;
    private View videoView;
    private int videoState = 0;
    private int orientation = -1;
    private boolean isDismissed = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class PlayerListener implements ISuperPlayer.OnErrorListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnVideoPreparedListener {
        private final WeakReference<MiniGameShareQCircleDialog> dialogRef;

        public PlayerListener(MiniGameShareQCircleDialog miniGameShareQCircleDialog) {
            this.dialogRef = new WeakReference<>(miniGameShareQCircleDialog);
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            final MiniGameShareQCircleDialog miniGameShareQCircleDialog = this.dialogRef.get();
            if (miniGameShareQCircleDialog == null) {
                return;
            }
            miniGameShareQCircleDialog.videoState = 5;
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.widget.MiniGameShareQCircleDialog.PlayerListener.2
                @Override // java.lang.Runnable
                public void run() {
                    miniGameShareQCircleDialog.mediaIconContainer.updateIconState(1);
                    miniGameShareQCircleDialog.videoView.setVisibility(8);
                    miniGameShareQCircleDialog.cover.setVisibility(0);
                }
            });
            MiniSDK.setAudioMute(miniGameShareQCircleDialog.getContext(), false);
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
        public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
            final MiniGameShareQCircleDialog miniGameShareQCircleDialog = this.dialogRef.get();
            if (miniGameShareQCircleDialog == null) {
                return false;
            }
            QLog.e(MiniGameShareQCircleDialog.TAG, 1, "PlayerListener onError i:" + i3 + ", i1:" + i16 + ", i2:" + i17 + ", s:" + str);
            miniGameShareQCircleDialog.videoState = 6;
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.widget.MiniGameShareQCircleDialog.PlayerListener.1
                @Override // java.lang.Runnable
                public void run() {
                    miniGameShareQCircleDialog.mediaIconContainer.updateIconState(3);
                    QQToast.makeText(miniGameShareQCircleDialog.getContext(), "\u5f53\u524d\u7f51\u7edc\u6545\u969c\uff0c\u8bf7\u91cd\u8bd5", 0).show();
                    miniGameShareQCircleDialog.videoView.setVisibility(8);
                    miniGameShareQCircleDialog.cover.setVisibility(0);
                }
            });
            MiniSDK.setAudioMute(miniGameShareQCircleDialog.getContext(), false);
            return false;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
        public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
            final MiniGameShareQCircleDialog miniGameShareQCircleDialog = this.dialogRef.get();
            if (miniGameShareQCircleDialog == null) {
                return;
            }
            miniGameShareQCircleDialog.videoState = 2;
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.widget.c
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGameShareQCircleDialog.vh(MiniGameShareQCircleDialog.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class VideoDownloadListener implements DownloaderProxy.DownloadListener {
        private WeakReference<MiniGameShareQCircleDialog> dialogRef;

        public VideoDownloadListener(MiniGameShareQCircleDialog miniGameShareQCircleDialog) {
            this.dialogRef = new WeakReference<>(miniGameShareQCircleDialog);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDownloadProgress$1(float f16) {
            MiniGameShareQCircleDialog miniGameShareQCircleDialog = this.dialogRef.get();
            if (miniGameShareQCircleDialog == null) {
                return;
            }
            int i3 = (int) (f16 * 100.0f);
            QLog.d(MiniGameShareQCircleDialog.TAG, 4, "onDownloadProgress process:" + i3);
            miniGameShareQCircleDialog.mediaIconContainer.updateProgress((float) i3);
        }

        private void updateIconState(final int i3) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.widget.MiniGameShareQCircleDialog.VideoDownloadListener.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    MiniGameShareQCircleDialog miniGameShareQCircleDialog = (MiniGameShareQCircleDialog) VideoDownloadListener.this.dialogRef.get();
                    if (miniGameShareQCircleDialog == null) {
                        return;
                    }
                    if (i3 == 3) {
                        QQToast.makeText(miniGameShareQCircleDialog.getContext(), "\u5f53\u524d\u7f51\u7edc\u6545\u969c\uff0c\u8bf7\u91cd\u8bd5", 0).show();
                    }
                    miniGameShareQCircleDialog.mediaIconContainer.updateIconState(i3);
                }
            });
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadFailed(int i3, String str) {
            QLog.e(MiniGameShareQCircleDialog.TAG, 1, "onDownloadFailed i:" + i3 + ", s:" + str);
            MiniGameShareQCircleDialog miniGameShareQCircleDialog = this.dialogRef.get();
            if (miniGameShareQCircleDialog == null) {
                return;
            }
            updateIconState(3);
            miniGameShareQCircleDialog.shareInfo.setVideoState(-1);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadHeadersReceived(int i3, Map<String, List<String>> map) {
            QLog.d(MiniGameShareQCircleDialog.TAG, 4, "onDownloadHeadersReceived");
            MiniGameShareQCircleDialog miniGameShareQCircleDialog = this.dialogRef.get();
            if (miniGameShareQCircleDialog == null) {
                return;
            }
            updateIconState(4);
            miniGameShareQCircleDialog.shareInfo.setVideoState(3);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadProgress(final float f16, long j3, long j16) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.widget.d
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGameShareQCircleDialog.VideoDownloadListener.this.lambda$onDownloadProgress$1(f16);
                }
            });
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadSucceed(int i3, String str, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
            QLog.d(MiniGameShareQCircleDialog.TAG, 4, "onDownloadSucceed");
            final MiniGameShareQCircleDialog miniGameShareQCircleDialog = this.dialogRef.get();
            if (miniGameShareQCircleDialog == null) {
                return;
            }
            updateIconState(1);
            miniGameShareQCircleDialog.shareInfo.setVideoState(1);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.widget.e
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGameShareQCircleDialog.vh(MiniGameShareQCircleDialog.this);
                }
            });
        }
    }

    private void checkAndUpdateVideoState() {
        MiniGameQCircleShareInfo miniGameQCircleShareInfo = this.shareInfo;
        if (miniGameQCircleShareInfo == null) {
            return;
        }
        int videoState = miniGameQCircleShareInfo.getVideoState();
        if (videoState == -1) {
            this.mediaIconContainer.updateIconState(3);
            QQToast.makeText(BaseApplication.getContext(), "\u5f53\u524d\u7f51\u7edc\u6545\u969c\uff0c\u8bf7\u91cd\u8bd5", 0).show();
        } else if (videoState != 3) {
            this.mediaIconContainer.updateIconState(1);
        } else {
            this.mediaIconContainer.updateIconState(4);
        }
    }

    public static MiniGameShareQCircleDialog getInstance(MiniGameQCircleShareInfo miniGameQCircleShareInfo) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(SAVE_KEY_SHARE_INFO, miniGameQCircleShareInfo);
        MiniGameShareQCircleDialog miniGameShareQCircleDialog = new MiniGameShareQCircleDialog();
        miniGameShareQCircleDialog.setArguments(bundle);
        return miniGameShareQCircleDialog;
    }

    private void handleDownloadVideo(boolean z16) {
        final MiniGameQCircleShareInfo miniGameQCircleShareInfo = this.shareInfo;
        if (miniGameQCircleShareInfo == null) {
            return;
        }
        final String video = miniGameQCircleShareInfo.getVideo();
        final String videoPath = miniGameQCircleShareInfo.getVideoPath();
        QLog.d(TAG, 2, "handleDownloadVideo video:" + video + ", videoPath:" + videoPath);
        if (!z16 && new File(videoPath).exists()) {
            miniGameQCircleShareInfo.setVideoState(1);
            handleVideStart();
        } else {
            this.mediaIconContainer.updateIconState(4);
            this.mediaIconContainer.updateProgress(0.0f);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.widget.b
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGameShareQCircleDialog.this.lambda$handleDownloadVideo$0(video, videoPath, miniGameQCircleShareInfo);
                }
            }, 64, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideStart() {
        if (this.videoPlayer == null) {
            preparedVideo();
        }
        if (this.videoState >= 2) {
            if (this.cover.getVisibility() != 8) {
                this.cover.setVisibility(8);
            }
            if (this.videoView.getVisibility() != 0) {
                this.videoView.setVisibility(0);
            }
        }
        this.mediaIconContainer.updateIconState(0);
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.start();
        }
        if (this.videoState >= 2) {
            this.videoState = 3;
        }
        MiniSDK.setAudioMute(BaseApplication.getContext(), true);
    }

    private void initVideo(ViewGroup viewGroup) {
        View view = (View) SuperPlayerFactory.createPlayerVideoView(viewGroup.getContext());
        this.videoView = view;
        view.setId(R.id.rif);
        this.videoView.setBackgroundColor(0);
        this.videoView.setVisibility(8);
        this.videoView.setOnClickListener(this);
        viewGroup.addView(this.videoView, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleDownloadVideo$0(String str, String str2, MiniGameQCircleShareInfo miniGameQCircleShareInfo) {
        FileDownloadManager.download(str, null, str2, 60, new VideoDownloadListener(this));
        miniGameQCircleShareInfo.setVideoState(3);
    }

    private void preparedVideo() {
        MiniGameQCircleShareInfo miniGameQCircleShareInfo = this.shareInfo;
        if (miniGameQCircleShareInfo == null) {
            return;
        }
        PlayerListener playerListener = new PlayerListener(this);
        BaseApplication context = BaseApplication.getContext();
        SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(miniGameQCircleShareInfo.getVideo(), 1, miniGameQCircleShareInfo.getVideoPath());
        ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(context, 104, (ISPlayerVideoView) this.videoView);
        this.videoPlayer = createMediaPlayer;
        createMediaPlayer.setOnErrorListener(playerListener);
        this.videoPlayer.setOnCompletionListener(playerListener);
        this.videoPlayer.setLoopback(false);
        this.videoPlayer.setOnVideoPreparedListener(playerListener);
        this.videoPlayer.openMediaPlayer(context, createVideoInfoForUrl, 0L);
        this.videoState = 1;
    }

    private void report(String str, String str2) {
        MiniGameQCircleShareInfo miniGameQCircleShareInfo = this.shareInfo;
        if (miniGameQCircleShareInfo == null) {
            return;
        }
        if (miniGameQCircleShareInfo.getMiniAppInfo() == null) {
            QLog.w(TAG, 1, "miniAppInfo is null");
        } else {
            MiniProgramLpReportDC04239.reportAsyncWithReferAndVia("page_view", str, str2, String.valueOf(miniGameQCircleShareInfo.getMiniAppInfo().launchParam.scene), miniGameQCircleShareInfo.getMiniAppInfo().via);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void vh(MiniGameShareQCircleDialog miniGameShareQCircleDialog) {
        miniGameShareQCircleDialog.handleVideStart();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.rif) {
            handleVideoPause(true);
            return;
        }
        if (view.getId() == R.id.rid) {
            handleVideoPause(true);
            View.OnClickListener onClickListener = this.negativeListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            report("em_click", REPORT_CLOSE_CLICK);
            return;
        }
        if (view.getId() == R.id.rie) {
            MiniGameQCircleShareInfo miniGameQCircleShareInfo = this.shareInfo;
            int videoState = miniGameQCircleShareInfo == null ? 0 : miniGameQCircleShareInfo.getVideoState();
            if (videoState == 1) {
                handleVideoPause(true);
                View.OnClickListener onClickListener2 = this.positiveListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
            } else if (videoState == 3) {
                QQToast.makeText(view.getContext(), "\u89c6\u9891\u4e0b\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u5019", 0).show();
            } else if (videoState == 2) {
                handleDownloadVideo(false);
                QQToast.makeText(view.getContext(), "\u89c6\u9891\u4e0b\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u5019", 0).show();
            } else {
                QQToast.makeText(view.getContext(), "\u89c6\u9891\u4e0b\u8f7d\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5\u540e\u5206\u4eab", 0).show();
            }
            report("em_click", REPORT_SEND_CLICK);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.shareInfo = (MiniGameQCircleShareInfo) arguments.getParcelable(SAVE_KEY_SHARE_INFO);
        }
        if (getDialog() != null) {
            getDialog().requestWindowFeature(1);
            Window window = getDialog().getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setWindowAnimations(R.style.f243430s);
                window.setBackgroundDrawableResource(R.drawable.ipc);
            }
        }
        View inflate = layoutInflater.inflate(R.layout.dkg, viewGroup, false);
        this.rootView = inflate;
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        releaseVideo();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        handleVideoPause(true);
        this.videoView.setVisibility(8);
        this.cover.setVisibility(0);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setRequestedOrientation(this.orientation);
            QLog.e(TAG, 4, "onPause orientation:" + this.orientation);
        }
    }

    @Override // com.tencent.mobileqq.minigame.widget.MiniGameShareVideoStateView.MiniGameShareMediaViewClickListener
    public void onPlayClick() {
        MiniGameQCircleShareInfo miniGameQCircleShareInfo = this.shareInfo;
        if (miniGameQCircleShareInfo == null) {
            return;
        }
        if (miniGameQCircleShareInfo.getVideoState() == 1) {
            handleVideStart();
        } else if (miniGameQCircleShareInfo.getVideoState() == 2) {
            handleDownloadVideo(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.isDismissed) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.widget.MiniGameShareQCircleDialog.1
            @Override // java.lang.Runnable
            public void run() {
                FragmentActivity activity = MiniGameShareQCircleDialog.this.getActivity();
                if (activity != null) {
                    activity.setRequestedOrientation(1);
                    QLog.e(MiniGameShareQCircleDialog.TAG, 4, "onResume ActivityInfo.SCREEN_ORIENTATION_PORTRAIT");
                }
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mediaContainer = (FrameLayout) view.findViewById(R.id.rib);
        this.cover = (ImageView) view.findViewById(R.id.ri8);
        this.negativeButton = (Button) view.findViewById(R.id.rid);
        this.positiveButton = (Button) view.findViewById(R.id.rie);
        this.mediaIconContainer = (MiniGameShareVideoStateView) view.findViewById(R.id.ric);
        initUI();
        if (NetworkUtil.getNetworkType(getContext()) == 1) {
            handleDownloadVideo(false);
        }
        report("em_expo", REPORT_DIALOG_SHOW);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.orientation = activity.getRequestedOrientation();
            if (this.isDismissed) {
                return;
            }
            activity.setRequestedOrientation(1);
            QLog.e(TAG, 4, "onViewCreated ActivityInfo.SCREEN_ORIENTATION_PORTRAIT");
        }
    }

    public void setNegativeClickListener(View.OnClickListener onClickListener) {
        this.negativeListener = onClickListener;
    }

    public void setPositiveClickListener(View.OnClickListener onClickListener) {
        this.positiveListener = onClickListener;
    }

    private void initUI() {
        setCancelable(false);
        MiniGameQCircleShareInfo miniGameQCircleShareInfo = this.shareInfo;
        if (miniGameQCircleShareInfo == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mediaContainer.getLayoutParams();
        if (miniGameQCircleShareInfo.isLandscape()) {
            layoutParams.width = ViewUtils.dpToPx(236.0f);
            layoutParams.height = ViewUtils.dpToPx(DP_LANDSCAPE_COVER_HEIGHT);
        } else {
            layoutParams.width = ViewUtils.dpToPx(236.0f);
            layoutParams.height = ViewUtils.dpToPx(DP_PORTRAIT_COVER_HEIGHT);
        }
        this.mediaContainer.setLayoutParams(layoutParams);
        this.cover.setImageDrawable(MiniAppUtils.getIcon(BaseApplication.getContext(), miniGameQCircleShareInfo.getCover(), true));
        this.mediaIconContainer.setClickListener(this);
        this.negativeButton.setOnClickListener(this);
        this.positiveButton.setOnClickListener(this);
        initVideo(this.mediaContainer);
        checkAndUpdateVideoState();
    }

    private void releaseVideo() {
        handleVideoPause(false);
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnErrorListener(null);
            this.videoPlayer.setOnCompletionListener(null);
            this.videoPlayer.setOnVideoPreparedListener(null);
            this.videoPlayer.reset();
            this.videoPlayer.release();
            this.videoPlayer = null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        this.isDismissed = true;
        releaseVideo();
        if (getActivity() != null) {
            getActivity().setRequestedOrientation(this.orientation);
            QLog.e(TAG, 4, "dismiss orientation:" + this.orientation);
        }
        MiniGameQCircleShareInfo miniGameQCircleShareInfo = this.shareInfo;
        if (miniGameQCircleShareInfo != null && miniGameQCircleShareInfo.getVideoState() == 3) {
            FileDownloadManager.abort(miniGameQCircleShareInfo.getVideo());
        }
        super.dismiss();
        QLog.d(TAG, 4, "dismiss");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        this.isDismissed = false;
        super.onAttach(context);
        QLog.d(TAG, 4, "onAttach");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        this.isDismissed = true;
        super.onDetach();
        QLog.d(TAG, 4, "onDetach");
        releaseVideo();
    }

    @Override // com.tencent.mobileqq.minigame.widget.MiniGameShareVideoStateView.MiniGameShareMediaViewClickListener
    public void onRetryClick() {
        handleDownloadVideo(true);
    }

    private void handleVideoPause(boolean z16) {
        if (z16) {
            this.mediaIconContainer.updateIconState(1);
        }
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.pause();
            this.videoState = 4;
        }
        MiniSDK.setAudioMute(BaseApplication.getContext(), false);
    }
}
