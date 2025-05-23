package com.tencent.aelight.camera.ae.play;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.tavcut.view.TAVCutVideoView;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.tav.coremedia.CMTime;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.util.QZLog;
import er.c;

/* loaded from: classes32.dex */
public class AEVideoPreviewFragment extends AbsAEPublishVideoProcessFragment implements View.OnClickListener {
    private static final String TAG = "AEVideoPreviewFragment";
    private ImageView ivClose;
    private ImageView ivDelete;
    private ImageView ivPlayOrPause;
    boolean needPlayWhenResume = false;
    private RelativeLayout rlVideoController;
    private SeekBar seekBarVideoProgress;
    TextView tvCurrentDuration;
    TextView tvTotalDuration;

    /* JADX INFO: Access modifiers changed from: private */
    public void pause() {
        this.ivPlayOrPause.setVisibility(0);
        this.mMoviePlayer.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        this.ivPlayOrPause.setVisibility(8);
        this.mMoviePlayer.play();
    }

    private void registerDaTongReport(View view) {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, QCircleDaTongConstant.PageId.PG_XSJ_PUBLISH_PAGE_PREVIEW_VIDEOS);
        VideoReport.setPageParams(view, new QCircleDTParamBuilder().buildPageParams(TAG));
        QLog.i(TAG, 1, "reportDaTongRegister  subPage: AEVideoPreviewFragment");
    }

    private void showCustomAlertDialog() {
        try {
            DialogUtil.createCustomDialog(getBaseActivity(), 230, QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadGiveUpVideo", "\u653e\u5f03\u4e0a\u4f20\u8fd9\u4e2a\u89c6\u9891\u5417\uff1f"), (CharSequence) null, getResources().getString(R.string.cancel), getResources().getString(R.string.a8j), new DialogInterface.OnClickListener() { // from class: com.tencent.aelight.camera.ae.play.AEVideoPreviewFragment.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    int mediaPosition = AEVideoPreviewFragment.this.getMediaPosition();
                    Intent intent = new Intent(AEEditorConstants.AEEDITOR_GENERATE_STATUS_DELETE);
                    intent.putExtra(AEEditorConstants.DELETE_POSITION, mediaPosition);
                    intent.setPackage(BaseApplication.getContext().getPackageName());
                    BaseApplication.getContext().sendBroadcast(intent);
                    AEVideoPreviewFragment.this.getBaseActivity().finish();
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.aelight.camera.ae.play.AEVideoPreviewFragment.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                }
            }).show();
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment
    void customizeBindingData(VideoResourceModel videoResourceModel) {
        play();
        TAVCutVideoSession tAVCutVideoSession = this.tavCutVideoSession;
        if (tAVCutVideoSession != null && tAVCutVideoSession.getDuration() != null) {
            this.seekBarVideoProgress.setMax((int) this.tavCutVideoSession.getDuration().getTimeUs());
            this.tvTotalDuration.setText(c.b(this.tavCutVideoSession.getDuration().getTimeSeconds() * 1000.0f));
        }
        this.mMoviePlayer.setVideoProgressListener(new MoviePlayer.onVideoProgressListener() { // from class: com.tencent.aelight.camera.ae.play.AEVideoPreviewFragment.1
            @Override // com.tencent.qcircle.tavcut.player.MoviePlayer.onVideoProgressListener
            public void updateVideoProgress(long j3) {
                AEVideoPreviewFragment aEVideoPreviewFragment = AEVideoPreviewFragment.this;
                if (aEVideoPreviewFragment.tavCutVideoSession != null) {
                    aEVideoPreviewFragment.seekBarVideoProgress.setProgress(((int) j3) * 1000);
                }
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment
    protected int getLayoutId() {
        return R.layout.dnr;
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment
    protected int getPlayerBackColor() {
        return getResources().getColor(R.color.black);
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        switch (view.getId()) {
            case R.id.rvm /* 2097545568 */:
                getBaseActivity().finish();
                break;
            case R.id.rvq /* 2097545572 */:
                showCustomAlertDialog();
                break;
            case R.id.f163766rw3 /* 2097545585 */:
                if (this.mMoviePlayer != null) {
                    play();
                    break;
                }
                break;
            case R.id.f163787s04 /* 2097545734 */:
                MoviePlayer moviePlayer = this.mMoviePlayer;
                if (moviePlayer != null && moviePlayer.isPlaying()) {
                    pause();
                    break;
                } else if (this.mMoviePlayer != null) {
                    play();
                    break;
                }
                break;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.needPlayWhenResume = this.mMoviePlayer.isPlaying();
        if (this.mMoviePlayer.isPlaying()) {
            pause();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.needPlayWhenResume) {
            play();
        }
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment
    void bindViews(View view) {
        this.tavCutVideoView = (TAVCutVideoView) view.findViewById(R.id.s29);
        this.rlVideoController = (RelativeLayout) view.findViewById(R.id.f163787s04);
        this.ivClose = (ImageView) view.findViewById(R.id.rvm);
        this.ivDelete = (ImageView) view.findViewById(R.id.rvq);
        this.ivPlayOrPause = (ImageView) view.findViewById(R.id.f163766rw3);
        this.seekBarVideoProgress = (SeekBar) view.findViewById(R.id.s0l);
        this.tvTotalDuration = (TextView) view.findViewById(R.id.f163812s45);
        this.tvCurrentDuration = (TextView) view.findViewById(R.id.s3h);
        this.rlVideoController.setOnClickListener(this);
        this.ivClose.setOnClickListener(this);
        this.ivDelete.setOnClickListener(this);
        this.ivPlayOrPause.setOnClickListener(this);
        this.seekBarVideoProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.tencent.aelight.camera.ae.play.AEVideoPreviewFragment.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                AEVideoPreviewFragment.this.pause();
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
                AEVideoPreviewFragment.this.play();
                EventCollector.getInstance().onStopTrackingTouch(seekBar);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
                float f16 = (i3 / 1000.0f) / 1000.0f;
                if (z16) {
                    AEVideoPreviewFragment.this.mMoviePlayer.seekToTime(new CMTime(f16));
                }
                AEVideoPreviewFragment.this.tvCurrentDuration.setText(c.b(f16 * 1000.0f));
            }
        });
        registerDaTongReport(view);
    }
}
