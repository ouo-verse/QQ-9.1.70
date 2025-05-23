package com.tencent.aelight.camera.ae.play;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import ar.f;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.tavcut.TAVCut;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.tavcut.session.config.SessionConfig;
import com.tencent.qcircle.tavcut.view.TAVCutVideoView;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import dr.d;
import java.util.ArrayList;

/* loaded from: classes32.dex */
public abstract class AbsAEPublishVideoProcessFragment extends PublicBaseFragment {
    private static final String TAG = "AbsAEPublishVideoProces";
    private Dialog mLoadingDialog;
    protected MoviePlayer mMoviePlayer;
    protected String missionId;
    protected TAVCutVideoSession tavCutVideoSession;
    protected TAVCutVideoView tavCutVideoView;
    private d videoParam = dr.b.a();

    private String getMissionId() {
        String str;
        Log.d(TAG, "missionId\u5c1d\u8bd5\u83b7\u53d6");
        Bundle arguments = getArguments();
        if (getBaseActivity().getIntent().getExtras() != null) {
            str = getBaseActivity().getIntent().getStringExtra(AEEditorConstants.KEY_AE_VIDEO_MISSION_ID);
        } else {
            str = "";
        }
        return (StringUtil.isEmpty(str) && arguments != null && arguments.containsKey(AEEditorConstants.KEY_AE_VIDEO_MISSION_ID)) ? arguments.getString(AEEditorConstants.KEY_AE_VIDEO_MISSION_ID) : str;
    }

    private void initTavCutAndPlayer() {
        Log.d(TAG, "initTavCutAndPlayer: \u5f00\u59cb\u521d\u59cb\u5316tavcutsession\u3001moviePlayer");
        MediaModel h16 = f.g().h(this.missionId);
        if (!StringUtil.isEmpty(this.missionId) && !isMediaModelBroken(h16)) {
            VideoResourceModel resource = h16.getMediaResourceModel().getVideos().get(0).getResource();
            MoviePlayer moviePlayer = new MoviePlayer();
            this.mMoviePlayer = moviePlayer;
            moviePlayer.setLoopPlay(true);
            this.mMoviePlayer.setBackColor(getPlayerBackColor());
            this.tavCutVideoSession = new TAVCutVideoSession();
            SessionConfig sessionConfig = new SessionConfig();
            sessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
            sessionConfig.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
            sessionConfig.setMaxIntermediateRenderSize(this.videoParam.c());
            String str = this.missionId;
            if (str != null && str.startsWith("multi_video_")) {
                AEEditorVideoEditFragment.vh(getBaseActivity(), this.tavCutVideoSession, this.videoParam, h16, this.mMoviePlayer, this.tavCutVideoView);
                this.tavCutVideoSession.restoreStickersWithLyric(new ArrayList(h16.getMediaEffectModel().getStickerModelList()));
            } else {
                this.tavCutVideoSession.setSessionConfig(sessionConfig);
                this.tavCutVideoSession.setVideoPath(resource.getPath());
                this.tavCutVideoSession.setMediaModel(h16);
                this.tavCutVideoSession.addPlayer(this.mMoviePlayer);
                this.tavCutVideoSession.setTAVCutVideoView(this.tavCutVideoView);
                this.tavCutVideoSession.init(getBaseActivity());
                this.tavCutVideoSession.setClip(Long.valueOf(resource.getSelectTimeStart()), Long.valueOf(resource.getSelectTimeDuration()), true);
            }
            this.tavCutVideoSession.setStickerTouchEnable(false);
            customizeBindingData(resource);
            return;
        }
        Log.e(TAG, "missionId\u5f02\u5e38\uff01\u5408\u6210model\u635f\u574f\uff1a" + isMediaModelBroken(h16));
        QQToast.makeText(getBaseActivity(), "\u89c6\u9891\u5408\u6210\u4fe1\u606f\u5f02\u5e38", 0).show();
    }

    private boolean isMediaModelBroken(MediaModel mediaModel) {
        Log.e(TAG, "\u68c0\u67e5\u635f\u574f\uff1amediaModel = " + mediaModel);
        if (mediaModel != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u635f\u574f\u539f\u56e0\uff1avideos.size = 0 ");
            sb5.append(mediaModel.getMediaResourceModel().getVideos().size() == 0);
            Log.e(TAG, sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("\u635f\u574f\u539f\u56e0\uff1avideo == null ");
            sb6.append(mediaModel.getMediaResourceModel().getVideos().get(0) == null);
            Log.e(TAG, sb6.toString());
        }
        return mediaModel == null || mediaModel.getMediaResourceModel().getVideos().size() == 0 || mediaModel.getMediaResourceModel().getVideos().get(0) == null;
    }

    abstract void bindViews(View view);

    abstract void customizeBindingData(VideoResourceModel videoResourceModel);

    protected abstract int getLayoutId();

    /* JADX INFO: Access modifiers changed from: protected */
    public String getMediaPath() {
        String str;
        Log.d(TAG, "MediaPath\u5c1d\u8bd5\u83b7\u53d6");
        Bundle arguments = getArguments();
        if (getBaseActivity().getIntent().getExtras() != null) {
            str = getBaseActivity().getIntent().getStringExtra(AEEditorConstants.KEY_VIDEO_MEDIA_PATH);
        } else {
            str = "";
        }
        return (StringUtil.isEmpty(str) && arguments != null && arguments.containsKey(AEEditorConstants.KEY_VIDEO_MEDIA_PATH)) ? arguments.getString(AEEditorConstants.KEY_VIDEO_MEDIA_PATH) : str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getMediaPosition() {
        Log.d(TAG, "mediaPosition\u5c1d\u8bd5\u83b7\u53d6");
        Bundle arguments = getArguments();
        int intExtra = getBaseActivity().getIntent().getExtras() != null ? getBaseActivity().getIntent().getIntExtra(AEEditorConstants.KEY_VIDEO_MEDIA_POSITION, -1) : 0;
        return (intExtra == -1 && arguments != null && arguments.containsKey(AEEditorConstants.KEY_VIDEO_MEDIA_POSITION)) ? arguments.getInt(AEEditorConstants.KEY_VIDEO_MEDIA_POSITION, 0) : intExtra;
    }

    protected int getPlayerBackColor() {
        return getResources().getColor(R.color.afa);
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

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (getBaseActivity() != null && !getBaseActivity().isFinishing()) {
            getBaseActivity().setResult(0);
            getBaseActivity().finish();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.missionId = getMissionId();
        com.tencent.aelight.camera.ae.d.j();
        FeatureManager.Features.YT_COMMON.init();
        FeatureManager.Features.PTU_TOOLS.init();
        FeatureManager.Features.PTU_ALGO.init();
        FeatureManager.Features.PAG.init();
        com.tencent.aelight.camera.ae.d.s();
        FeatureManager.Features.IMAGE_ALGO.init();
        TAVCut.initTAVCut(getBaseActivity(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), AEResUtil.y(), new TAVCut.Callback() { // from class: com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment.1
            @Override // com.tencent.qcircle.tavcut.TAVCut.Callback
            public void onDone(int i3) {
                if (i3 == -2) {
                    ms.a.c(AbsAEPublishVideoProcessFragment.TAG, "\u521d\u59cb\u5316TAVCut\u5931\u8d25\uff1apag so\u5e93\u52a0\u8f7d\u5f02\u5e38");
                } else if (i3 == -1) {
                    ms.a.c(AbsAEPublishVideoProcessFragment.TAG, "\u521d\u59cb\u5316TAVCut\u5931\u8d25\uff1atavkit so\u5e93\u52a0\u8f7d\u5f02\u5e38");
                } else {
                    if (i3 != 0) {
                        return;
                    }
                    ms.a.a(AbsAEPublishVideoProcessFragment.TAG, "\u521d\u59cb\u5316TAVCut\u6210\u529f");
                }
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(getLayoutId(), viewGroup, false);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        this.mMoviePlayer.release();
        this.tavCutVideoSession.release();
        super.onFinish();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bindViews(view);
        initTavCutAndPlayer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLoading(boolean z16) {
        if (getBaseActivity().isFinishing()) {
            return;
        }
        if (z16) {
            if (this.mLoadingDialog == null) {
                ReportDialog reportDialog = new ReportDialog(getBaseActivity(), R.style.qZoneInputDialog);
                this.mLoadingDialog = reportDialog;
                reportDialog.setCancelable(false);
                this.mLoadingDialog.setCanceledOnTouchOutside(false);
                this.mLoadingDialog.setContentView(R.layout.f168383uh);
                ((TextView) this.mLoadingDialog.findViewById(R.id.photo_prievew_progress_dialog_text)).setText("\u6b63\u5728\u4fdd\u5b58\u5c01\u9762...");
            }
            this.mLoadingDialog.show();
            return;
        }
        Dialog dialog = this.mLoadingDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.mLoadingDialog.dismiss();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
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

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            getBaseActivity().setResult(0);
            getBaseActivity().finish();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }
}
