package com.tencent.aelight.camera.ae.play;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.ae.config.g;
import com.tencent.aelight.camera.ae.d;
import com.tencent.aelight.camera.ae.play.FaceChangeUtils;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.richframework.compat.f;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.en;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import javax.annotation.Nullable;

/* loaded from: classes32.dex */
public class AETakeFacePhotoPreviewFragment extends PublicBaseFragment implements en, View.OnClickListener {
    public static final String INTENT_KEY_PHOTO_PATH = "photo_path";
    private static String detectFacePath = "";
    private long faceDetectStartTime;
    private AppInterface mAppInterface;
    private CameraPeakServiceHandler mHandler;
    private ImageView mImgFacePreview;
    private Dialog mLoadingDialog;
    private g mObserver;
    private Bitmap mPhotoBitmap;
    private String mPhotoPath;
    private TextView mTvAgain;
    private TextView mTvConfirm;
    private int screenHeight;
    private int screenWidth;

    public AETakeFacePhotoPreviewFragment() {
        AppInterface a16 = QQStoryContext.a();
        this.mAppInterface = a16;
        this.mHandler = (CameraPeakServiceHandler) a16.getBusinessHandler(PeakAppInterface.I);
    }

    private void choosePhotoAndBack() {
        Intent intent = new Intent();
        intent.putExtra(AECameraConstants.INTENT_RESULT_KEY_TAKE_PHOTO_PATH, this.mPhotoPath);
        getBaseActivity().setResult(-1, intent);
        onBackPressed();
    }

    public static String getDetectFacePath() {
        return detectFacePath;
    }

    private void hideLoading() {
        Dialog dialog;
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || baseActivity.isFinishing() || (dialog = this.mLoadingDialog) == null || !dialog.isShowing()) {
            return;
        }
        this.mLoadingDialog.dismiss();
    }

    private void initData() {
        this.screenWidth = zr.a.f(getBaseActivity());
        this.screenHeight = zr.a.e(getBaseActivity());
        String string = getArguments().getString(INTENT_KEY_PHOTO_PATH);
        this.mPhotoPath = string;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        Bitmap decodeSampleBitmap = BitmapUtils.decodeSampleBitmap(getBaseActivity(), this.mPhotoPath, this.screenWidth, this.screenHeight);
        this.mPhotoBitmap = decodeSampleBitmap;
        if (decodeSampleBitmap != null) {
            this.mImgFacePreview.setImageBitmap(decodeSampleBitmap);
            initDetectData();
            this.mTvAgain.setOnClickListener(this);
            this.mTvConfirm.setOnClickListener(this);
        }
    }

    private void initDetectData() {
        detectFacePath = "";
        if (FaceChangeUtils.hasFaceInPic(this.mPhotoBitmap)) {
            FaceChangeUtils.cropFace(this.mPhotoBitmap, new FaceChangeUtils.CropFaceCallback() { // from class: com.tencent.aelight.camera.ae.play.AETakeFacePhotoPreviewFragment.1
                @Override // com.tencent.aelight.camera.ae.play.FaceChangeUtils.CropFaceCallback
                public void onSuccess(Bitmap bitmap) {
                    AETakeFacePhotoPreviewFragment.detectFacePath = CameraPeakServiceHandler.b3(AETakeFacePhotoPreviewFragment.this.getBaseActivity(), bitmap);
                }

                @Override // com.tencent.aelight.camera.ae.play.FaceChangeUtils.CropFaceCallback
                public void onFail(int i3) {
                }
            });
        }
    }

    public static void jumpToMeForResult(Activity activity, Intent intent, int i3) {
        PublicFragmentActivity.b.d(activity, intent, PublicFragmentActivityForPeak.class, AETakeFacePhotoPreviewFragment.class, i3);
    }

    private void onPressConfirmBtn(@Nullable Bitmap bitmap, @Nullable String str) {
        if (TextUtils.isEmpty(str) || bitmap == null) {
            return;
        }
        AEVideoShelfEditFragment.keepScreenOn(BaseApplication.getContext(), true);
        showLoading();
        Intent intent = getBaseActivity().getIntent();
        if (!intent.getBooleanExtra(AECameraConstants.KEY_DISABLE_FACE_DETECT, false) || gq.a.C(intent)) {
            if (!d.t()) {
                QQToast.makeText(getBaseActivity(), R.string.y6j, 0).show();
                hideLoading();
                onBackPressed();
                return;
            } else if (!FaceChangeUtils.hasFaceInPic(bitmap)) {
                QQToast.makeText(getBaseActivity(), R.string.f169896y64, 0).show();
                hideLoading();
                onBackPressed();
                return;
            }
        }
        if (!intent.getBooleanExtra(AECameraConstants.KEY_NEED_CHECK_SENSITIVE, false) && !gq.a.C(intent)) {
            handleSensitiveFaceDetectResult(true, 0);
            return;
        }
        removeOldObserver();
        this.mObserver = new g() { // from class: com.tencent.aelight.camera.ae.play.AETakeFacePhotoPreviewFragment.2
            @Override // com.tencent.aelight.camera.ae.config.g
            public void onUpdateFaceDetect(final boolean z16, final int i3) {
                AETakeFacePhotoPreviewFragment.this.mAppInterface.removeObserver(this);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AETakeFacePhotoPreviewFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AETakeFacePhotoPreviewFragment.this.handleSensitiveFaceDetectResult(z16, i3);
                    }
                });
            }
        };
        this.faceDetectStartTime = System.currentTimeMillis();
        this.mAppInterface.addObserver(this.mObserver);
        this.mHandler.r3(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOldObserver() {
        g gVar = this.mObserver;
        if (gVar != null) {
            this.mAppInterface.removeObserver(gVar);
            this.mObserver = null;
        }
    }

    private void showLoading() {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || baseActivity.isFinishing()) {
            return;
        }
        if (this.mLoadingDialog == null) {
            ReportDialog reportDialog = new ReportDialog(baseActivity, R.style.qZoneInputDialog);
            this.mLoadingDialog = reportDialog;
            reportDialog.setContentView(R.layout.f168383uh);
            ((TextView) this.mLoadingDialog.findViewById(R.id.photo_prievew_progress_dialog_text)).setText(R.string.f169893y61);
            this.mLoadingDialog.setCancelable(true);
            this.mLoadingDialog.setCanceledOnTouchOutside(false);
            this.mLoadingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.aelight.camera.ae.play.AETakeFacePhotoPreviewFragment.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    AETakeFacePhotoPreviewFragment.this.removeOldObserver();
                    AEVideoShelfEditFragment.keepScreenOn(BaseApplication.getContext(), false);
                }
            });
        }
        this.mLoadingDialog.show();
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

    @Override // com.tencent.mobileqq.activity.en
    public void onBackPressed() {
        getBaseActivity().finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.rnu) {
            if (!TextUtils.isEmpty(this.mPhotoPath) || this.mPhotoBitmap != null) {
                com.tencent.aelight.camera.ae.report.b.b().G1();
                onPressConfirmBtn(this.mPhotoBitmap, this.mPhotoPath);
            }
        } else if (id5 == R.id.rnt) {
            com.tencent.aelight.camera.ae.report.b.b().H1();
            onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.mPhotoBitmap;
        if (bitmap != null) {
            BitmapUtils.recycle(bitmap);
        }
        String str = detectFacePath;
        if (str == null || str.length() <= 0) {
            return;
        }
        FileUtils.delete(detectFacePath);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        hideLoading();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        initView(view);
        initData();
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
        if (Build.VERSION.SDK_INT >= 29) {
            com.tencent.biz.subscribe.utils.g.c(activity.getWindow());
        }
    }

    private void initView(View view) {
        this.mImgFacePreview = (ImageView) view.findViewById(R.id.rnd);
        this.mTvAgain = (TextView) view.findViewById(R.id.rnt);
        this.mTvConfirm = (TextView) view.findViewById(R.id.rnu);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dls, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSensitiveFaceDetectResult(boolean z16, int i3) {
        if (!z16) {
            QQToast.makeText(getBaseActivity(), R.string.evd, 0).show();
        } else if (i3 == 0) {
            choosePhotoAndBack();
        } else if (i3 == -1) {
            QQToast.makeText(getBaseActivity(), R.string.f169894y62, 0).show();
        } else if (i3 == -2) {
            QQToast.makeText(getBaseActivity(), R.string.evd, 0).show();
        }
        hideLoading();
    }
}
