package com.tencent.aelight.camera.ae.camera.ui.gallery;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

/* loaded from: classes32.dex */
public class PhotoListCustomizationAECapture extends PhotoListCustomizationDefault {
    public static final String N = "com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoListCustomizationAECapture";
    private AppInterface F;
    private CameraPeakServiceHandler G;
    private com.tencent.aelight.camera.ae.config.g H;
    private Dialog I;
    private int J;
    private int K;
    private boolean L;
    private int M;

    public PhotoListCustomizationAECapture(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        AppInterface a16 = QQStoryContext.a();
        this.F = a16;
        this.G = (CameraPeakServiceHandler) a16.getBusinessHandler(PeakAppInterface.I);
        this.M = Integer.MAX_VALUE;
        Intent intent = abstractPhotoListActivity.getIntent();
        if (intent != null) {
            this.J = intent.getIntExtra("MaterialConfig.minImageWidth", 0);
            this.K = intent.getIntExtra("MaterialConfig.minImageHeight", 0);
            this.L = intent.getBooleanExtra("MaterialConfig.needFace", false);
            this.M = intent.getIntExtra(IPhotoLogicFactory.ENTER_FROM, Integer.MAX_VALUE);
        }
    }

    private void N0(final LocalMediaInfo localMediaInfo) {
        Button button = this.f184313i.K;
        if (button != null && button.getVisibility() == 0) {
            this.f184313i.K.setClickable(false);
        }
        com.tencent.aelight.camera.ae.config.g gVar = this.H;
        if (gVar != null) {
            this.F.removeObserver(gVar);
        }
        this.H = new com.tencent.aelight.camera.ae.config.g() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoListCustomizationAECapture.1
            @Override // com.tencent.aelight.camera.ae.config.g
            public void onUpdateFaceDetect(final boolean z16, final int i3) {
                PhotoListCustomizationAECapture.this.F.removeObserver(this);
                PhotoListCustomizationAECapture.this.H = null;
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoListCustomizationAECapture.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        PhotoListCustomizationAECapture.this.O0(localMediaInfo, z16, i3);
                    }
                });
            }
        };
        U0();
        this.F.addObserver(this.H);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoListCustomizationAECapture.2
            @Override // java.lang.Runnable
            public void run() {
                if (PhotoListCustomizationAECapture.this.G == null || localMediaInfo == null) {
                    return;
                }
                PhotoListCustomizationAECapture.this.G.r3(localMediaInfo.path);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(LocalMediaInfo localMediaInfo, boolean z16, int i3) {
        P0();
        Button button = this.f184313i.K;
        if (button != null && button.getVisibility() == 0) {
            this.f184313i.K.setClickable(true);
        }
        if (z16) {
            if (i3 == 0 || i3 == -2) {
                M0(localMediaInfo);
                return;
            } else {
                if (i3 == -1) {
                    V0(this.D.getString(R.string.y0u));
                    return;
                }
                return;
            }
        }
        if (i3 == -100) {
            if (!this.L) {
                M0(localMediaInfo);
                return;
            } else {
                V0(this.D.getString(R.string.y0x));
                return;
            }
        }
        V0(this.D.getString(R.string.y0v));
    }

    private void P0() {
        Dialog dialog;
        BasePhotoListActivity basePhotoListActivity = this.D;
        if (basePhotoListActivity == null || basePhotoListActivity.isFinishing() || (dialog = this.I) == null || !dialog.isShowing()) {
            return;
        }
        Dialog dialog2 = this.I;
        if (dialog2 instanceof QCircleCommonLoadingDialog) {
            ((QCircleCommonLoadingDialog) dialog2).setProgress(100);
        }
        this.I.dismiss();
    }

    private boolean R0() {
        return this.f184310e.selectedPhotoList.size() < this.f184310e.maxSelectNum;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(DialogInterface dialogInterface) {
        com.tencent.aelight.camera.ae.config.g gVar = this.H;
        if (gVar != null) {
            this.F.removeObserver(gVar);
            this.H = null;
        }
        this.f184313i.K.setClickable(true);
    }

    private void U0() {
        BasePhotoListActivity basePhotoListActivity = this.D;
        if (basePhotoListActivity == null || basePhotoListActivity.isFinishing()) {
            return;
        }
        if (this.I == null) {
            if (this.M == 31) {
                QCircleCommonLoadingDialog a16 = new QCircleCommonLoadingDialog.c(this.D).n(true).p(this.D.getString(R.string.y0s)).j("").d(new Callable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.ad
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        Boolean bool;
                        bool = Boolean.TRUE;
                        return bool;
                    }
                }).a();
                this.I = a16;
                a16.setProgress(70);
            } else {
                ReportDialog reportDialog = new ReportDialog(this.D, R.style.qZoneInputDialog);
                this.I = reportDialog;
                reportDialog.setContentView(R.layout.f168383uh);
                ((TextView) this.I.findViewById(R.id.photo_prievew_progress_dialog_text)).setText(R.string.y0y);
            }
            this.I.setCancelable(true);
            this.I.setCanceledOnTouchOutside(false);
            this.I.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.ae
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    PhotoListCustomizationAECapture.this.T0(dialogInterface);
                }
            });
        }
        this.I.show();
    }

    private void V0(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mobileqq.activity.photo.album.g gVar = this.C;
        if (currentTimeMillis - gVar.f184299j >= 1000) {
            gVar.f184299j = currentTimeMillis;
            QQToast.makeText(this.D, str, 0).show();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void J(View view, int i3, CheckBox checkBox) {
        if (!R0() && this.f184313i.Q.m0(i3).selectStatus != 1) {
            V0(String.format(this.D.getString(R.string.y5b), Integer.valueOf(this.f184310e.maxSelectNum)));
        } else {
            super.J(view, i3, checkBox);
        }
    }

    protected void M0(LocalMediaInfo localMediaInfo) {
        os.a.f423933a.g(localMediaInfo);
        Intent intent = new Intent();
        intent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", new ArrayList<>(Collections.singletonList(localMediaInfo.path)));
        intent.putParcelableArrayListExtra("selected_local_infos", new ArrayList<>(Collections.singletonList(localMediaInfo)));
        this.D.setResult(-1, intent);
        this.D.finish();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void O(View view) {
        int i3;
        if (R0()) {
            V0(String.format(this.D.getString(R.string.y5c), Integer.valueOf(this.f184310e.maxSelectNum)));
            return;
        }
        if (!com.tencent.biz.qqstory.utils.e.a(this.D)) {
            V0(this.D.getString(R.string.y0v));
            return;
        }
        String str = this.f184310e.selectedPhotoList.get(0);
        LocalMediaInfo localMediaInfo = this.f184310e.allMediaInfoHashMap.get(str);
        int i16 = this.J;
        if (i16 > 0 && (i3 = this.K) > 0 && localMediaInfo != null && (localMediaInfo.mediaWidth < i16 || localMediaInfo.mediaHeight < i3)) {
            V0(String.format(this.D.getString(R.string.y0t), Integer.valueOf(this.J), Integer.valueOf(this.K)));
        } else if (Q0(str, localMediaInfo)) {
            V0(this.D.getString(R.string.y0u));
        } else {
            N0(localMediaInfo);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void T() {
        super.T();
        this.f184313i.K.setText(this.D.getString(R.string.y0w) + " " + this.f184310e.selectedPhotoList.size() + "/" + this.f184310e.maxSelectNum);
        this.f184313i.K.setEnabled(true);
        if (R0()) {
            this.f184313i.K.setBackgroundResource(R.drawable.skin_aio_album_send_button_disabled);
        } else {
            this.f184313i.K.setBackgroundResource(R.drawable.f160083a4);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void l(View view, int i3) {
        int i16;
        if (!com.tencent.biz.qqstory.utils.e.a(this.D)) {
            V0(this.D.getString(R.string.y0v));
            return;
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        int i17 = this.J;
        if (i17 > 0 && (i16 = this.K) > 0 && (m06.mediaWidth < i17 || m06.mediaHeight < i16)) {
            V0(String.format(this.D.getString(R.string.y0t), Integer.valueOf(this.J), Integer.valueOf(this.K)));
        } else if (Q0(m06.path, m06)) {
            V0(this.D.getString(R.string.y0u));
        } else {
            N0(m06);
        }
    }

    private boolean Q0(String str, LocalMediaInfo localMediaInfo) {
        if (str == null || !str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
            return localMediaInfo != null && "image/gif".equalsIgnoreCase(localMediaInfo.mMimeType);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public boolean a(LocalMediaInfo localMediaInfo, boolean z16) {
        if (localMediaInfo == null) {
            return false;
        }
        if (localMediaInfo.selectStatus == 2 && z16 && !R0()) {
            V0(String.format(this.D.getString(R.string.y5b), Integer.valueOf(this.f184310e.maxSelectNum)));
            return false;
        }
        return super.a(localMediaInfo, z16);
    }
}
