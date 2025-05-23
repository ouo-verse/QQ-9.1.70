package com.tencent.aelight.camera.ae.play;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.util.e;
import com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.ab;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.qqstory.utils.d;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.en;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.aj;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.videoshelf.data.Constants;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener;
import com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer;
import com.tencent.ttpic.videoshelf.model.processor.PagVideoShelfProcessor;
import com.tencent.ttpic.videoshelf.ui.VideoShelfPlayView;
import com.tencent.ttpic.videoshelf.utils.TTPTLogger;
import com.tencent.util.UiThreadUtil;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes32.dex */
public class AEVideoShelfPreviewFragment extends PublicBaseFragment implements View.OnClickListener, IVideoShelfPlayerListener, en {
    private static final int AUDIO_UPDATE_PROGRESS_TIME = 200;
    public static final String FROM = "from";
    public static final String FROM_FLAG_BACK_FROM_QUDONG_TO_AIO = "FROM_FLAG_BACK_FROM_QUDONG_TO_AIO";
    private static final long INTERVAL_UPDATE_PROGRESS = 200;
    public static final String IS_NEED_EDIT_BTN = "isNeedEditButton";
    private static final double PROCESS_STEP = 0.3d;
    public static final int REQUEST_CODE_EDIT = 22;
    private static final int STATUS_NONE = 0;
    private static final int STATUS_PLAY = 2;
    private static final int STATUS_READY = 1;
    private static final String TAG = "AEVideoShelfPreviewFragment";
    private static final int VIDEO_DEFAULT_HEIGHT = 960;
    private static final int VIDEO_DEFAULT_WIDTH = 540;
    private static PowerManager.WakeLock wakeLock;
    private Button editButton;
    private String mAudioPath;
    private Dialog mDialog;
    private VideoShelfEngine mEngine;
    private long mGenerateBegin;
    private String mInputVideo;
    private int mJumpFrom;
    private String mMaterialId;
    private String mMaterialName;
    private int mOutVideoHeight;
    private int mOutVideoWidth;
    private HashMap<String, int[]> mPagSettings;
    private TextView mPlayerRateView;
    private ArrayList<String> mSelectedPhotoList;
    private String mTakeSameName;
    private String mTemplatePath;
    private Timer mTimer;
    private String mVideoPath;
    private View playButton;
    aj ppd;
    private View videoGroup;
    private VideoShelfPlayView videoView;
    private int status = 0;
    private boolean mIsVideoComplete = false;
    private boolean mHadEncodedStart = false;
    private boolean mIsNeedShowdialog = false;
    private boolean mIsPagPreview = false;
    private boolean isFromNewVideo = false;
    private boolean mIsFirstVideoPlay = true;
    private boolean mIsNeedEditBtn = false;
    private volatile boolean mCancelGenerateByUser = false;
    private long mLastUpdateProgressTimeMs = 0;
    private double mSaveDialogProcessLowValue = 0.0d;
    private double mSaveDialogProgress = 0.0d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class EngineCallback implements VideoShelfEngine.Callback {
        private WeakReference<AEVideoShelfPreviewFragment> mRef;

        public EngineCallback(AEVideoShelfPreviewFragment aEVideoShelfPreviewFragment) {
            this.mRef = new WeakReference<>(aEVideoShelfPreviewFragment);
        }

        @Override // com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback
        public void onCancelCompleted() {
            WeakReference<AEVideoShelfPreviewFragment> weakReference = this.mRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mRef.get().onCancelCompleted();
        }

        @Override // com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback
        public void onCompleted() {
            WeakReference<AEVideoShelfPreviewFragment> weakReference = this.mRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mRef.get().onCompletion();
        }

        @Override // com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback
        public void onError(int i3, int i16, String str) {
            WeakReference<AEVideoShelfPreviewFragment> weakReference = this.mRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mRef.get().onError(i3, i16, str);
        }

        @Override // com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback
        public void onProgress(int i3) {
            WeakReference<AEVideoShelfPreviewFragment> weakReference = this.mRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mRef.get().onProgress(i3);
        }

        @Override // com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback
        public void onStartGenerate() {
            WeakReference<AEVideoShelfPreviewFragment> weakReference = this.mRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mRef.get().onStartGenerate();
        }
    }

    private void bindData(Intent intent) {
        boolean z16;
        if (this.mIsNeedEditBtn) {
            this.editButton.setVisibility(0);
        } else {
            this.editButton.setVisibility(8);
        }
        if (this.mJumpFrom == 2) {
            this.editButton.setVisibility(8);
        }
        this.videoView.setVideoType(!this.mIsPagPreview);
        this.mIsVideoComplete = false;
        if (this.mIsPagPreview) {
            z16 = pagFileInit(intent);
        } else {
            String stringExtra = intent.getStringExtra(Constants.INTENT_KEY_FINAL_VIDEO_PATH);
            this.mInputVideo = stringExtra;
            z16 = !TextUtils.isEmpty(stringExtra);
            if (z16) {
                this.videoView.setVideoFilePath(this.mInputVideo);
                this.mIsVideoComplete = true;
                this.mVideoPath = this.mInputVideo;
            }
        }
        if (z16) {
            this.videoView.start();
        }
    }

    private aj createProgressPie() {
        aj ajVar = new aj(getBaseActivity());
        ajVar.h(BaseAIOUtils.f(50.0f, getBaseActivity().getResources()));
        ajVar.f(true);
        ajVar.o(false);
        ajVar.r(-1);
        ajVar.e(0);
        ajVar.j(-15550475);
        ajVar.l(3);
        ajVar.E = true;
        ajVar.A = 2;
        ajVar.n(true);
        ajVar.g(new aj.b() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment.3
            @Override // com.tencent.mobileqq.widget.aj.b
            public void onProgressCompleted(aj ajVar2) {
            }

            @Override // com.tencent.mobileqq.widget.aj.b
            public void onProgressChanged(aj ajVar2, int i3, int i16) {
            }
        });
        return ajVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissProgressDialog() {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private void finishAudioVideoMerge() {
        String str;
        String b16;
        String str2;
        if (this.mEngine == null) {
            return;
        }
        File file = this.mAudioPath != null ? new File(this.mAudioPath) : null;
        boolean hasStoragePermission = AEVideoShelfEditFragment.hasStoragePermission(BaseApplication.getContext());
        if (file != null && file.exists() && (str = this.mAudioPath) != null && str.toLowerCase().endsWith(".m4a")) {
            if (hasStoragePermission) {
                b16 = g.b(g.a());
            } else {
                b16 = g.b(g.c.b.f65292f + File.separator);
            }
            String str3 = TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("outputDir: ");
            sb5.append(b16);
            if (new File(b16).exists()) {
                str2 = " exist";
            } else {
                str2 = " not exist";
            }
            sb5.append(str2);
            ms.a.f(str3, sb5.toString());
            BaseTimer baseTimer = new BaseTimer();
            this.mTimer = baseTimer;
            baseTimer.schedule(new TimerTask() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment.7
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AEVideoShelfPreviewFragment.this.mSaveDialogProgress < 100.0d) {
                                AEVideoShelfPreviewFragment.this.mSaveDialogProgress += AEVideoShelfPreviewFragment.PROCESS_STEP;
                                AEVideoShelfPreviewFragment aEVideoShelfPreviewFragment = AEVideoShelfPreviewFragment.this;
                                aEVideoShelfPreviewFragment.updateProgress((int) aEVideoShelfPreviewFragment.mSaveDialogProgress);
                            }
                        }
                    });
                }
            }, 0L, INTERVAL_UPDATE_PROGRESS);
            if (com.tencent.aelight.camera.aioeditor.shortvideo.util.b.m(this.mEngine.getOutputVideoPath(), this.mAudioPath, b16, 0) == 0) {
                File file2 = new File(this.mEngine.getOutputVideoPath());
                if (file2.exists()) {
                    ms.a.f(str3, "finishAudioVideoMerge done");
                    file2.delete();
                }
                this.mVideoPath = b16;
            }
            this.mTimer.cancel();
            this.mTimer = null;
        }
        if (!hasStoragePermission || this.mVideoPath == null) {
            return;
        }
        d.b(BaseApplication.getContext(), new File(this.mVideoPath));
    }

    public static Bitmap getVideoThumbnail(String str, int i3, int i16) {
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, i16);
        int width = createVideoThumbnail.getWidth();
        int height = createVideoThumbnail.getHeight();
        if (width > i3) {
            height = (int) (((height * 1.0d) * i3) / width);
        } else {
            i3 = width;
        }
        return ThumbnailUtils.extractThumbnail(createVideoThumbnail, i3, height, 2);
    }

    private void initProgressDialog() {
        ReportDialog reportDialog = new ReportDialog(getBaseActivity());
        this.mDialog = reportDialog;
        Window window = reportDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable());
            window.setDimAmount(0.0f);
        }
        this.mDialog.requestWindowFeature(1);
        this.mDialog.setContentView(R.layout.ba8);
        ImageView imageView = (ImageView) this.mDialog.findViewById(R.id.g1f);
        aj createProgressPie = createProgressPie();
        this.ppd = createProgressPie;
        if (imageView != null) {
            imageView.setImageDrawable(createProgressPie);
        }
        ((TextView) this.mDialog.findViewById(R.id.f166327f13)).setText(R.string.y6c);
        this.mDialog.setCancelable(true);
        this.mDialog.setCanceledOnTouchOutside(false);
        this.mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                AEVideoShelfPreviewFragment.this.mEngine.cancelSave();
                File file = new File(AEVideoShelfPreviewFragment.this.mEngine.getOutputVideoPath());
                if (file.exists()) {
                    TTPTLogger.i(AEVideoShelfPreviewFragment.TAG, "delete temp silent video");
                    file.delete();
                }
                AEVideoShelfPreviewFragment.this.mCancelGenerateByUser = true;
            }
        });
        this.ppd.i(0);
    }

    private void initView() {
        Window window = getBaseActivity().getWindow();
        if (window != null) {
            window.setStatusBarColor(-16777216);
        }
        TextView textView = (TextView) getBaseActivity().findViewById(R.id.ryh);
        this.mPlayerRateView = textView;
        textView.setText("0(fps)");
        this.mPlayerRateView.setTextColor(SupportMenu.CATEGORY_MASK);
        View findViewById = getBaseActivity().findViewById(R.id.s47);
        this.videoGroup = findViewById;
        findViewById.setOnClickListener(this);
        VideoShelfPlayView videoShelfPlayView = (VideoShelfPlayView) this.videoGroup.findViewById(R.id.s49);
        this.videoView = videoShelfPlayView;
        videoShelfPlayView.setOnPlayerListener(this);
        this.playButton = this.videoGroup.findViewById(R.id.rye);
        Button button = (Button) getBaseActivity().findViewById(R.id.rs8);
        this.editButton = button;
        button.setOnClickListener(this);
        this.videoView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AEVideoShelfPreviewFragment.this.videoView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                AEVideoShelfPreviewFragment.this.videoView.updateVideoSize(AEVideoShelfPreviewFragment.this.videoView.getVideoWidth(), AEVideoShelfPreviewFragment.this.videoView.getVideoHeight());
            }
        });
        getBaseActivity().findViewById(R.id.roi).setOnClickListener(this);
        TextView textView2 = (TextView) getBaseActivity().findViewById(R.id.rpg);
        textView2.setOnClickListener(this);
        textView2.setText(R.string.f169892y60);
        initProgressDialog();
    }

    private void jumpToEditFragment() {
        if (this.mJumpFrom == 2) {
            getBaseActivity().finish();
        } else {
            AEVideoShelfEditFragment.jumpToMeForResult(getBaseActivity(), 22, this.mTemplatePath, this.mMaterialId, this.mMaterialName, this.mSelectedPhotoList, 3);
        }
    }

    public static void jumpToMe(Context context, Intent intent, int i3) {
        intent.putExtra(AEQuDongConstants.INTENT_KEY_FROM, i3);
        PublicFragmentActivity.b.a(context, intent, PublicFragmentActivityForPeak.class, AEVideoShelfPreviewFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCancelCompleted() {
        String str = TAG;
        ms.a.f(str, "Merge Video step onCancelCompleted");
        this.mGenerateBegin = 0L;
        this.mHadEncodedStart = false;
        this.mIsNeedShowdialog = false;
        String outputVideoPath = this.mEngine.getOutputVideoPath();
        if (!TextUtils.isEmpty(outputVideoPath)) {
            File file = new File(outputVideoPath);
            if (file.exists()) {
                file.delete();
                ms.a.f(str, "onCancelCompleted---delete temp video because user cancel");
            }
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment.10
            @Override // java.lang.Runnable
            public void run() {
                AEVideoShelfPreviewFragment.this.mSaveDialogProgress = 0.0d;
                AEVideoShelfPreviewFragment.this.mSaveDialogProcessLowValue = 0.0d;
                AEVideoShelfPreviewFragment.this.dismissProgressDialog();
                AEVideoShelfPreviewFragment.keepScreenOn(AEVideoShelfPreviewFragment.this.getBaseActivity(), false);
            }
        });
        this.mIsVideoComplete = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProgress(final int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastUpdateProgressTimeMs > INTERVAL_UPDATE_PROGRESS) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    AEVideoShelfPreviewFragment.this.mSaveDialogProgress = i3 * 0.9d;
                    AEVideoShelfPreviewFragment.this.updateProgress((int) (((AEVideoShelfPreviewFragment.this.mSaveDialogProgress - AEVideoShelfPreviewFragment.this.mSaveDialogProcessLowValue) * 90.0d) / (90.0d - AEVideoShelfPreviewFragment.this.mSaveDialogProcessLowValue)));
                }
            });
            this.mLastUpdateProgressTimeMs = currentTimeMillis;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStartGenerate() {
        ms.a.f(TAG, "Merge Video step onStartGenerate");
        this.mGenerateBegin = System.currentTimeMillis();
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment.8
            @Override // java.lang.Runnable
            public void run() {
                AEVideoShelfPreviewFragment.this.mCancelGenerateByUser = false;
                AEVideoShelfPreviewFragment.this.updateProgress(0);
                if (AEVideoShelfPreviewFragment.this.mIsNeedShowdialog) {
                    AEVideoShelfPreviewFragment.this.showProgressDialog();
                }
            }
        });
    }

    private void saveVideoTemplate() {
        if (this.videoView == null) {
            return;
        }
        if (this.mEngine == null) {
            try {
                this.mEngine = new VideoShelfEngine(false);
            } catch (PagNotSupportSystemException e16) {
                this.mEngine = null;
                ms.a.c(TAG, e16.getMessage());
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment.11
                    @Override // java.lang.Runnable
                    public void run() {
                        AEVideoShelfPreviewFragment.this.getBaseActivity().finish();
                    }
                }, 2000L);
                return;
            }
        }
        IVideoShelfPlayer player = this.videoView.getPlayer();
        if (player instanceof PagShelfPlayer) {
            this.mEngine.setSrcPath(this.mInputVideo);
            this.mEngine.setParam(PagVideoShelfProcessor.PAG_IMG_LIST, this.mPagSettings);
            this.mEngine.setOutputVideoPath(ShortVideoUtils.getLocalShortVideoPath());
            this.mEngine.setCallback(new EngineCallback(this));
            this.mEngine.save(this.mOutVideoWidth, this.mOutVideoHeight);
            this.mHadEncodedStart = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendVideo() {
        if (gq.a.f(AETemplateInfoFragment.getFromType(getContext()))) {
            ms.a.f(TAG, "sendVideo--aio case");
            Intent intent = new Intent(getContext(), (Class<?>) QIMCameraCaptureActivity.class);
            intent.putExtra(FROM_FLAG_BACK_FROM_QUDONG_TO_AIO, "");
            intent.addFlags(67108864);
            intent.addFlags(536870912);
            intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_PATH, getThumbPath());
            intent.putExtra("file_send_path", this.mVideoPath);
            ab.i(getActivity(), intent);
            startActivity(intent);
            return;
        }
        ms.a.f(TAG, "sendVideo--non aio case");
        ab.g(getBaseActivity(), this.mVideoPath, getThumbPath(), gq.a.K(getBaseActivity()), "caller_aecamera");
    }

    private void showDialogIfNeed() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment.6
            @Override // java.lang.Runnable
            public void run() {
                if (AEVideoShelfPreviewFragment.this.mIsNeedShowdialog) {
                    AEVideoShelfPreviewFragment.this.showProgressDialog();
                    AEVideoShelfPreviewFragment aEVideoShelfPreviewFragment = AEVideoShelfPreviewFragment.this;
                    aEVideoShelfPreviewFragment.mSaveDialogProcessLowValue = aEVideoShelfPreviewFragment.mSaveDialogProgress;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog() {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(int i3) {
        aj ajVar = this.ppd;
        if (ajVar == null) {
            return;
        }
        ajVar.t();
        this.ppd.i(i3);
        this.ppd.p(true);
        this.ppd.m(false);
        this.ppd.q(i3 + "%");
    }

    public String getThumbPath() {
        Bitmap videoThumbnail = getVideoThumbnail(this.mVideoPath, 300, 1);
        String str = g.c.b.f65291e;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str2 = str + File.separator + Md5Utils.getMD5(this.mVideoPath) + ".jpg";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
            if (videoThumbnail != null) {
                videoThumbnail.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
                videoThumbnail.recycle();
            }
            return str2;
        } catch (Exception e16) {
            e16.printStackTrace();
            if (videoThumbnail == null) {
                return null;
            }
            videoThumbnail.recycle();
            return null;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        Intent qzoneFriendFeedActivity;
        super.onActivityResult(i3, i16, intent);
        if (i3 == 22) {
            if (i16 == -1) {
                initData(intent);
                bindData(intent);
                return;
            }
            return;
        }
        if (i3 == 21) {
            com.tencent.aelight.camera.ae.report.b.b().u1(this.mMaterialId);
            if (i16 == -1) {
                if (!gq.a.K(getBaseActivity()) && !gq.a.Q(getBaseActivity().getIntent())) {
                    qzoneFriendFeedActivity = SplashActivity.getAliasIntent(getBaseActivity());
                } else {
                    qzoneFriendFeedActivity = QZoneHelper.getQzoneFriendFeedActivity(getBaseActivity());
                }
                qzoneFriendFeedActivity.addFlags(67108864);
                qzoneFriendFeedActivity.addFlags(536870912);
                startActivity(qzoneFriendFeedActivity);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.en
    public void onBackPressed() {
        getBaseActivity().finish();
        com.tencent.aelight.camera.ae.report.b.b().E1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!e.a(view)) {
            switch (view.getId()) {
                case R.id.roi /* 2097545307 */:
                    onBackPressed();
                    break;
                case R.id.rpg /* 2097545341 */:
                    if (!this.mIsVideoComplete) {
                        pauseVideo();
                        this.mIsNeedShowdialog = true;
                        if (!this.mHadEncodedStart) {
                            saveVideoTemplate();
                            break;
                        } else {
                            showDialogIfNeed();
                            break;
                        }
                    } else {
                        sendVideo();
                        break;
                    }
                case R.id.rs8 /* 2097545443 */:
                    jumpToEditFragment();
                    com.tencent.aelight.camera.ae.report.b.b().z1();
                    break;
                case R.id.s47 /* 2097545885 */:
                    toggleVideoStatus();
                    break;
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener
    public void onCompletion() {
        final long currentTimeMillis = this.mGenerateBegin > 0 ? System.currentTimeMillis() - this.mGenerateBegin : 0L;
        this.mGenerateBegin = 0L;
        finishAudioVideoMerge();
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment.5
            @Override // java.lang.Runnable
            public void run() {
                if (!AEVideoShelfPreviewFragment.this.mCancelGenerateByUser) {
                    if (((int) AEVideoShelfPreviewFragment.this.mSaveDialogProgress) < 100) {
                        AEVideoShelfPreviewFragment.this.updateProgress(100);
                        new BaseTimer().schedule(new TimerTask() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment.5.1
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                AEVideoShelfPreviewFragment.this.dismissProgressDialog();
                            }
                        }, 0L);
                    } else {
                        AEVideoShelfPreviewFragment.this.dismissProgressDialog();
                    }
                    AEVideoShelfPreviewFragment.this.mSaveDialogProgress = 0.0d;
                    AEVideoShelfPreviewFragment.this.mSaveDialogProcessLowValue = 0.0d;
                    if (AEVideoShelfPreviewFragment.this.mIsNeedShowdialog) {
                        AEVideoShelfPreviewFragment.this.mIsNeedShowdialog = false;
                        AEVideoShelfPreviewFragment.keepScreenOn(AEVideoShelfPreviewFragment.this.getBaseActivity(), false);
                    }
                    AEVideoShelfPreviewFragment.this.sendVideo();
                    return;
                }
                String outputVideoPath = AEVideoShelfPreviewFragment.this.mEngine.getOutputVideoPath();
                if (!TextUtils.isEmpty(outputVideoPath)) {
                    File file = new File(outputVideoPath);
                    if (file.exists()) {
                        file.delete();
                        ms.a.f(AEVideoShelfPreviewFragment.TAG, "onCompletion---delete temp silent file because user cancel generation: " + outputVideoPath);
                    }
                }
                if (!TextUtils.isEmpty(AEVideoShelfPreviewFragment.this.mVideoPath)) {
                    File file2 = new File(AEVideoShelfPreviewFragment.this.mVideoPath);
                    if (file2.exists()) {
                        file2.delete();
                        ms.a.f(AEVideoShelfPreviewFragment.TAG, "onCompletion---delete final file because user cancel generation: " + AEVideoShelfPreviewFragment.this.mVideoPath);
                    }
                }
                AEVideoShelfPreviewFragment.this.mIsVideoComplete = false;
            }
        });
        this.mHadEncodedStart = false;
        this.mIsVideoComplete = true;
        ms.a.f(TAG, "Merge Video step onCompletion");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        HashMap<String, int[]> hashMap = this.mPagSettings;
        if (hashMap != null) {
            hashMap.clear();
        }
        ArrayList<String> arrayList = this.mSelectedPhotoList;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.videoView.setOnPlayerListener(null);
        this.videoView.stop();
        this.videoView = null;
        keepScreenOn(getBaseActivity(), false);
        super.onDestroy();
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener
    public boolean onError(int i3, String str, Object obj) {
        int i16 = 1;
        if (-3 == i3) {
            return true;
        }
        File file = this.mInputVideo != null ? new File(this.mInputVideo) : null;
        long length = (file != null && file.exists() && file.isFile()) ? file.length() : -1L;
        String str2 = this.mInputVideo;
        if (str2 != null) {
            String str3 = File.separator;
            if (str2.contains(str3)) {
                String str4 = this.mInputVideo;
                String substring = str4.substring(0, str4.lastIndexOf(str3));
                if (new File(substring).exists()) {
                    i16 = FileUtils.canWriteFile(substring, false) ? 0 : 3;
                } else {
                    i16 = 2;
                }
            } else {
                i16 = -1;
            }
        }
        ms.a.c(TAG, "Fun video videoShelfPlayView onError: what: " + i3 + ", extra: " + str + ", FilePath: " + this.mInputVideo + ", FileSize: " + length + " dirInfo: " + i16);
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Log.i("VideoShelfPlayView", "onPause...");
        pauseVideo();
        if (this.mHadEncodedStart || !this.mIsVideoComplete) {
            VideoShelfEngine videoShelfEngine = this.mEngine;
            if (videoShelfEngine != null) {
                videoShelfEngine.cancelSave();
            }
            this.mHadEncodedStart = false;
            this.mIsNeedShowdialog = false;
        }
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Log.i("VideoShelfPlayView", "onResume...");
        super.onResume();
        this.videoView.flush();
        if (this.mIsFirstVideoPlay) {
            int i3 = this.status;
            if (2 == i3 || 1 == i3) {
                this.videoView.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AEVideoShelfPreviewFragment.this.playVideo();
                    }
                }, INTERVAL_UPDATE_PROGRESS);
            }
            this.mIsFirstVideoPlay = false;
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener
    public void onUpdateRate(long j3) {
        this.mPlayerRateView.setText(j3 + "(fps)");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        initView();
        Intent intent = getBaseActivity().getIntent();
        if (intent == null) {
            return;
        }
        initData(intent);
        bindData(intent);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    private void initData(Intent intent) {
        this.mIsFirstVideoPlay = true;
        this.mJumpFrom = intent.getIntExtra(AEQuDongConstants.INTENT_KEY_FROM, 0);
        this.mTemplatePath = intent.getStringExtra(Constants.INTENT_KEY_MATERIAL_PATH);
        this.mMaterialName = intent.getStringExtra(Constants.INTENT_KEY_MATERIAL_NAME);
        this.mMaterialId = intent.getStringExtra(Constants.INTENT_KEY_MATERIAL_ID);
        if (TextUtils.isEmpty(this.mTakeSameName)) {
            this.mTakeSameName = intent.getStringExtra(AECameraConstants.LOC_PLAY_SHOW_TAKE_SAME_NAME);
        }
        getBaseActivity().getIntent().putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, this.mTakeSameName);
        this.mSelectedPhotoList = intent.getStringArrayListExtra(AEQuDongConstants.INTENT_KEY_PHOTOLIST);
        this.isFromNewVideo = intent.getBooleanExtra("from", true);
        this.mIsNeedEditBtn = intent.getBooleanExtra(IS_NEED_EDIT_BTN, false);
        this.mIsPagPreview = intent.getBooleanExtra(Constants.USE_PAG_PREVIEW, false);
    }

    private void pauseVideo() {
        this.status = 1;
        this.videoView.pause();
        this.playButton.setVisibility(0);
        this.mPlayerRateView.setText("0(fps)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo() {
        this.status = 2;
        this.videoView.resume();
        this.playButton.setVisibility(8);
    }

    private void toggleVideoStatus() {
        if (2 == this.status) {
            pauseVideo();
        } else {
            playVideo();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        activity.requestWindowFeature(1);
        activity.getWindow().setFlags(1024, 1024);
    }

    public static void keepScreenOn(Context context, boolean z16) {
        if (z16) {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            String str = TAG;
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870922, str);
            wakeLock = newWakeLock;
            newWakeLock.acquire();
            ms.a.f(str, "keepScreenOn!");
            return;
        }
        PowerManager.WakeLock wakeLock2 = wakeLock;
        if (wakeLock2 != null) {
            wakeLock2.release();
            wakeLock = null;
        }
        ms.a.f(TAG, "keepScreenOff!");
    }

    private boolean pagFileInit(Intent intent) {
        if (intent != null && this.videoView != null) {
            this.mInputVideo = intent.getStringExtra(Constants.PAG_FILE_PATH);
            this.mAudioPath = intent.getStringExtra(Constants.AUDIO_FILE_PATH);
            if (intent.getBooleanExtra(Constants.IS_FROM_ASSET, false)) {
                if (!TextUtils.isEmpty(this.mAudioPath)) {
                    this.videoView.setAudioPathFromAsset(this.mAudioPath, getBaseActivity().getAssets());
                }
                if (!TextUtils.isEmpty(this.mInputVideo)) {
                    this.videoView.setVideoFilePathFromAsset(this.mInputVideo, getBaseActivity().getAssets());
                } else {
                    ms.a.i(TAG, "pagFileInit Asset Path error");
                    return false;
                }
            } else {
                if (!TextUtils.isEmpty(this.mAudioPath)) {
                    this.videoView.setAudioPath(this.mAudioPath);
                }
                if (!TextUtils.isEmpty(this.mInputVideo)) {
                    this.videoView.setVideoFilePath(this.mInputVideo);
                } else {
                    ms.a.i(TAG, "pagFileInit not Asset Path error");
                    return false;
                }
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                Serializable serializable = extras.getSerializable(Constants.NODE_IMG_LIST);
                if (serializable instanceof HashMap) {
                    HashMap<String, int[]> hashMap = (HashMap) serializable;
                    this.mPagSettings = hashMap;
                    this.videoView.setParam(PagShelfPlayer.IMG_GROUP, hashMap);
                }
            }
            this.mOutVideoWidth = intent.getIntExtra(Constants.VIDEO_OUT_WIDTH, VIDEO_DEFAULT_WIDTH);
            this.mOutVideoHeight = intent.getIntExtra(Constants.VIDEO_OUT_HEIGHT, 960);
            return true;
        }
        ms.a.i(TAG, "pagFileInit error");
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dlv, viewGroup, false);
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener
    public void onPrepared(IVideoShelfPlayer iVideoShelfPlayer) {
        if (iVideoShelfPlayer == null) {
            return;
        }
        iVideoShelfPlayer.setLooping(true);
        this.status = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i3, int i16, String str) {
        ms.a.i(TAG, "Merge Video step onError");
        this.mGenerateBegin = 0L;
        onError(i3, str, (Object) null);
        this.mHadEncodedStart = false;
        keepScreenOn(getBaseActivity(), false);
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener
    public void onChangVideoSize(int i3, int i16) {
    }
}
