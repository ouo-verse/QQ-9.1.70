package com.tencent.aelight.camera.ae.play;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import ar.d;
import ar.f;
import com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.tavcut.timeline.CoverSelectView;
import com.tencent.qcircle.tavcut.view.TAVCutVideoView;
import com.tencent.qcircle.weseevideo.model.ModelExtKt;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AECoverSelectFragment extends AbsAEPublishVideoProcessFragment implements View.OnClickListener {
    public static final float DEFAULT_COVER_PROGRESS = 0.0f;
    private static final String TAG = "AECoverSelectFragment";
    CoverSelectView coverSelectView;
    TAVCutVideoSession coverVideoSession;
    private float defaultCoverProgress;
    FrameLayout flCoverSelectContainer;
    LinearLayout llBottomContainer;
    TextView tvCancel;
    TextView tvConfirm;

    private void addCoverSelectView() {
        CoverSelectView.UIConfigWrapper uIConfigWrapper = new CoverSelectView.UIConfigWrapper(getBaseActivity(), R.drawable.ixi, R.drawable.it5, R.drawable.f159988it4, R.drawable.ite, R.drawable.itf, R.drawable.ixd, R.drawable.ixe, R.drawable.itg, 11);
        uIConfigWrapper.setPrevibarHeight(zr.a.a(getBaseActivity(), 59.0f)).setPreviewBarWidth(zr.a.a(getBaseActivity(), 34.0f)).setCoverDefaultProgress(this.defaultCoverProgress);
        this.coverSelectView = new CoverSelectView(getBaseActivity(), uIConfigWrapper);
        int a16 = zr.a.a(getBaseActivity(), 4.0f);
        int a17 = zr.a.a(getBaseActivity(), 2.0f);
        Log.d(TAG, "addCoverSelectView: pixValue2Dip = " + a17);
        int a18 = zr.a.a(getBaseActivity(), 16.0f);
        int a19 = zr.a.a(getBaseActivity(), 13.0f);
        AERoundCornerImageView aERoundCornerImageView = new AERoundCornerImageView(getBaseActivity());
        aERoundCornerImageView.setCorner(a17);
        aERoundCornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        float f16 = a16;
        shapeDrawable.setShape(new RoundRectShape(new float[]{f16, f16, f16, f16, f16, f16, f16, f16}, null, null));
        shapeDrawable.getPaint().setColor(-1);
        aERoundCornerImageView.setBackgroundDrawable(shapeDrawable);
        aERoundCornerImageView.setPadding(a17, a17, a17, a17);
        this.coverSelectView.setCoverPreviewBarBg(shapeDrawable);
        this.coverSelectView.setPreviewBar(aERoundCornerImageView);
        this.coverSelectView.setPreviewBarElevation(15.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 16;
        this.coverSelectView.setTimelineViewPadding(a18, a19, a18, a19);
        this.flCoverSelectContainer.addView(this.coverSelectView, layoutParams);
    }

    private float getDefaultCoverProgress() {
        Bundle arguments = getArguments();
        float floatExtra = getBaseActivity().getIntent().getExtras() != null ? getBaseActivity().getIntent().getFloatExtra(AEEditorConstants.KEY_VIDEO_COVER_POSITION, 0.0f) : 0.0f;
        return (floatExtra == 0.0f && arguments != null && arguments.containsKey(AEEditorConstants.KEY_VIDEO_COVER_POSITION)) ? arguments.getFloat(AEEditorConstants.KEY_VIDEO_COVER_POSITION, 0.0f) : floatExtra;
    }

    private long getTotalDuration(VideoResourceModel videoResourceModel) {
        String str = this.missionId;
        if (str != null && str.startsWith("multi_video_")) {
            return this.tavCutVideoSession.getDuration().getTimeUs() / 1000;
        }
        return videoResourceModel.getSelectTimeDuration();
    }

    private void setSystemBarComp() {
        if (!(getActivity() instanceof QBaseActivity) || SystemBarActivityModule.getSystemBarComp((QBaseActivity) getActivity()) == null) {
            return;
        }
        SystemBarActivityModule.getSystemBarComp((QBaseActivity) getActivity()).init();
        SystemBarActivityModule.getSystemBarComp((QBaseActivity) getActivity()).setStatusBarColor(-1);
        SystemBarActivityModule.getSystemBarComp((QBaseActivity) getActivity()).setStatusBarDrawable(null);
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment
    void customizeBindingData(VideoResourceModel videoResourceModel) {
        addCoverSelectView();
        this.coverVideoSession = new TAVCutVideoSession();
        AEEditorVideoEditFragment.vh(getActivity(), this.coverVideoSession, dr.b.a(), this.tavCutVideoSession.getMediaModel(), null, null);
        this.coverVideoSession.restoreStickersWithLyric(new ArrayList(this.tavCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList()));
        this.coverVideoSession.setStickerTouchEnable(false);
        if (ModelExtKt.isLightTemplate(this.coverVideoSession.getMediaModel())) {
            this.coverVideoSession.getMediaModel().getMediaEffectModel().setAeKitModel(null);
        }
        this.coverSelectView.bindPlayer(this.mMoviePlayer);
        Log.d(TAG, "initTavCutAndPlayer: \nresource.selectDuration = " + videoResourceModel.getSelectTimeDuration() + "\nresource.start = " + videoResourceModel.getSelectTimeStart() + "\n resource.end = " + (videoResourceModel.getSelectTimeStart() + videoResourceModel.getSelectTimeDuration()));
        this.coverSelectView.updateTavVideoSession(this.coverVideoSession);
        this.coverSelectView.setClipAndSpeed(videoResourceModel.getSpeed(), getTotalDuration(videoResourceModel), videoResourceModel.getSelectTimeStart(), getTotalDuration(videoResourceModel) + videoResourceModel.getSelectTimeStart());
        this.mMoviePlayer.pause();
        this.mMoviePlayer.seekToTime(CMTime.fromUs((long) ((((float) this.tavCutVideoSession.getDuration().getTimeUs()) * this.defaultCoverProgress) / 100.0f)));
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment
    protected int getLayoutId() {
        return R.layout.dnj;
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return true;
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.s3_) {
            getBaseActivity().setResult(0);
            getBaseActivity().finish();
        } else if (id5 == R.id.s3e) {
            saveDataAndQuit();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSystemBarComp();
        ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), getActivity().getWindow());
        this.defaultCoverProgress = getDefaultCoverProgress();
        ms.a.a(TAG, "[coverGen][onCreate] missionId = " + this.missionId);
        com.tencent.aelight.camera.aeeditor.data.b f16 = f.g().f(this.missionId);
        if (f16 == null || f16.f66109g.equals(AEEditorConstants.AEEDITOR_GENERATE_STATUS_READY)) {
            return;
        }
        ms.a.a(TAG, "[coverGen][onCreate][tryToKillExport] videoInfo = " + f16.toString());
        if (f16.f66111i.e() != null) {
            f16.f66111i.e().cancel();
        }
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        this.coverVideoSession.release();
        this.coverSelectView.release();
        com.tencent.aelight.camera.aeeditor.data.b f16 = f.g().f(this.missionId);
        if (f16 != null && f16.f66109g.equals(AEEditorConstants.AEEDITOR_GENERATE_STATUS_CANEL)) {
            f.g().l(this.missionId);
        }
        super.onFinish();
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mMoviePlayer.seekToTime(CMTime.fromUs((((float) this.tavCutVideoSession.getDuration().getTimeUs()) * this.coverSelectView.getCurrCoverProgress()) / 100.0f));
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    private void saveDataAndQuit() {
        showLoading(true);
        float currCoverProgress = this.coverSelectView.getCurrCoverProgress();
        if (currCoverProgress == 100.0f) {
            currCoverProgress = (float) (currCoverProgress - 0.5d);
        }
        Bitmap currCoverBitmap = this.coverSelectView.getCurrCoverBitmap();
        try {
            if (currCoverBitmap == null) {
                ms.a.c(TAG, "\u83b7\u53d6\u5c01\u9762\u56fe\u5931\u8d25");
                showLoading(false);
                return;
            }
            try {
                ms.a.f(TAG, "saveDataAndQuit: w=" + currCoverBitmap.getWidth() + " h=" + currCoverBitmap.getHeight());
                String str = d.f26774g + File.separator + this.missionId + "_" + System.currentTimeMillis() + ".JPG";
                File file = new File(str);
                if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                    ms.a.c(TAG, "\u4fdd\u5b58\u5c01\u9762\uff0c\u521b\u5efa\u7236\u8def\u5f84\u5931\u8d25");
                }
                if (!file.createNewFile()) {
                    ms.a.c(TAG, "\u4fdd\u5b58\u5c01\u9762\uff0c\u521b\u5efa\u5c01\u9762\u6587\u4ef6\u5931\u8d25");
                }
                if (q.q(currCoverBitmap, str)) {
                    ms.a.f(TAG, "\u5c01\u9762\u4fdd\u5b58\u6210\u529f,path=" + str);
                    Intent intent = new Intent();
                    intent.putExtra(AEEditorConstants.KEY_VIDEO_COVER_POSITION, currCoverProgress);
                    intent.putExtra(AEEditorConstants.KEY_VIDEO_COVER_PATH, str);
                    intent.putExtra(AEEditorConstants.KEY_VIDEO_MEDIA_PATH, getMediaPath());
                    getBaseActivity().setResult(-1, intent);
                } else {
                    ms.a.c(TAG, "\u5c01\u9762\u4fdd\u5b58\u51fa\u9519");
                    getBaseActivity().setResult(0);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                ms.a.c(TAG, "\u5c01\u9762\u4fdd\u5b58\u51fa\u9519:" + e16.toString());
                getBaseActivity().setResult(0);
            }
        } finally {
            showLoading(false);
            getBaseActivity().finish();
        }
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment
    void bindViews(View view) {
        this.tavCutVideoView = (TAVCutVideoView) view.findViewById(R.id.s29);
        this.llBottomContainer = (LinearLayout) view.findViewById(R.id.rwg);
        this.flCoverSelectContainer = (FrameLayout) view.findViewById(R.id.rtm);
        this.tvCancel = (TextView) view.findViewById(R.id.s3_);
        this.tvConfirm = (TextView) view.findViewById(R.id.s3e);
        this.tvCancel.setOnClickListener(this);
        this.tvConfirm.setOnClickListener(this);
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dnj, viewGroup, false);
    }

    @Override // com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
    }
}
