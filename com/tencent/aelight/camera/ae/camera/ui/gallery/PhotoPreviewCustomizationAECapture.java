package com.tencent.aelight.camera.ae.camera.ui.gallery;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.BasePhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes32.dex */
public class PhotoPreviewCustomizationAECapture extends PhotoPreviewCustomizationDefault {
    public static final String M = "com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoPreviewCustomizationAECapture";
    public static final String N = "PhotoPreviewCustomizationAECapture";
    private AppInterface G;
    private CameraPeakServiceHandler H;
    private com.tencent.aelight.camera.ae.config.g I;
    private Dialog J;
    private int K;
    private int L;

    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (PhotoPreviewCustomizationAECapture.this.h0()) {
                QLog.d(PhotoPreviewCustomizationAECapture.N, 2, "need more pic.");
                PhotoPreviewCustomizationAECapture photoPreviewCustomizationAECapture = PhotoPreviewCustomizationAECapture.this;
                photoPreviewCustomizationAECapture.j0(String.format(((PhotoPreviewCustomizationDefault) photoPreviewCustomizationAECapture).f184197m.getString(R.string.y5c), Integer.valueOf(PhotoPreviewCustomizationAECapture.this.f184334e.maxSelectNum)));
            } else if (!com.tencent.biz.qqstory.utils.e.a(((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationAECapture.this).f184197m)) {
                PhotoPreviewCustomizationAECapture photoPreviewCustomizationAECapture2 = PhotoPreviewCustomizationAECapture.this;
                photoPreviewCustomizationAECapture2.j0(((PhotoPreviewCustomizationDefault) photoPreviewCustomizationAECapture2).f184197m.getString(R.string.y0v));
            } else {
                String str = PhotoPreviewCustomizationAECapture.this.f184334e.selectedPhotoList.get(0);
                LocalMediaInfo localMediaInfo = PhotoPreviewCustomizationAECapture.this.f184334e.allMediaInfoHashMap.get(str);
                if (PhotoPreviewCustomizationAECapture.this.K <= 0 || PhotoPreviewCustomizationAECapture.this.L <= 0 || localMediaInfo == null || (localMediaInfo.mediaWidth >= PhotoPreviewCustomizationAECapture.this.K && localMediaInfo.mediaHeight >= PhotoPreviewCustomizationAECapture.this.L)) {
                    if (!PhotoPreviewCustomizationAECapture.this.g0(str, localMediaInfo)) {
                        PhotoPreviewCustomizationAECapture.this.d0(str, localMediaInfo);
                    } else {
                        PhotoPreviewCustomizationAECapture photoPreviewCustomizationAECapture3 = PhotoPreviewCustomizationAECapture.this;
                        photoPreviewCustomizationAECapture3.j0(((PhotoPreviewCustomizationDefault) photoPreviewCustomizationAECapture3).f184197m.getString(R.string.y0u));
                    }
                } else {
                    PhotoPreviewCustomizationAECapture photoPreviewCustomizationAECapture4 = PhotoPreviewCustomizationAECapture.this;
                    photoPreviewCustomizationAECapture4.j0(String.format(((PhotoPreviewCustomizationDefault) photoPreviewCustomizationAECapture4).f184197m.getString(R.string.y0t), Integer.valueOf(PhotoPreviewCustomizationAECapture.this.K), Integer.valueOf(PhotoPreviewCustomizationAECapture.this.L)));
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (PhotoPreviewCustomizationAECapture.this.I != null) {
                PhotoPreviewCustomizationAECapture.this.G.removeObserver(PhotoPreviewCustomizationAECapture.this.I);
                PhotoPreviewCustomizationAECapture.this.I = null;
            }
            PhotoPreviewCustomizationAECapture.this.v().H.setClickable(true);
        }
    }

    public PhotoPreviewCustomizationAECapture(AbstractPhotoPreviewActivity abstractPhotoPreviewActivity) {
        super(abstractPhotoPreviewActivity);
        AppInterface a16 = QQStoryContext.a();
        this.G = a16;
        this.H = (CameraPeakServiceHandler) a16.getBusinessHandler(PeakAppInterface.I);
        Intent intent = abstractPhotoPreviewActivity.getIntent();
        if (intent != null) {
            this.K = intent.getIntExtra("MaterialConfig.minImageWidth", 0);
            this.L = intent.getIntExtra("MaterialConfig.minImageHeight", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(final String str, final LocalMediaInfo localMediaInfo) {
        if (v().H != null && v().H.getVisibility() == 0) {
            v().H.setClickable(false);
        }
        com.tencent.aelight.camera.ae.config.g gVar = this.I;
        if (gVar != null) {
            this.G.removeObserver(gVar);
        }
        this.I = new com.tencent.aelight.camera.ae.config.g() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoPreviewCustomizationAECapture.2
            @Override // com.tencent.aelight.camera.ae.config.g
            public void onUpdateFaceDetect(final boolean z16, final int i3) {
                PhotoPreviewCustomizationAECapture.this.G.removeObserver(this);
                PhotoPreviewCustomizationAECapture.this.I = null;
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoPreviewCustomizationAECapture.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        PhotoPreviewCustomizationAECapture.this.e0(str, z16, i3, localMediaInfo);
                    }
                });
            }
        };
        i0();
        this.G.addObserver(this.I);
        this.H.r3(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(String str, boolean z16, int i3, LocalMediaInfo localMediaInfo) {
        f0();
        if (v().H != null && v().H.getVisibility() == 0) {
            v().H.setClickable(true);
        }
        if (!z16) {
            if (i3 == -100) {
                c0(str, localMediaInfo);
                return;
            } else {
                j0(this.f184197m.getString(R.string.y0v));
                return;
            }
        }
        if (i3 == 0 || i3 == -2) {
            c0(str, localMediaInfo);
        } else if (i3 == -1) {
            j0(this.f184197m.getString(R.string.y0u));
        }
    }

    private void f0() {
        Dialog dialog;
        BasePhotoPreviewActivity basePhotoPreviewActivity = this.f184197m;
        if (basePhotoPreviewActivity == null || basePhotoPreviewActivity.isFinishing() || (dialog = this.J) == null || !dialog.isShowing()) {
            return;
        }
        this.J.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h0() {
        return this.f184334e.selectedPhotoList.size() < this.f184334e.maxSelectNum;
    }

    private void i0() {
        BasePhotoPreviewActivity basePhotoPreviewActivity = this.f184197m;
        if (basePhotoPreviewActivity == null || basePhotoPreviewActivity.isFinishing()) {
            return;
        }
        if (this.J == null) {
            ReportDialog reportDialog = new ReportDialog(this.f184197m, R.style.qZoneInputDialog);
            this.J = reportDialog;
            reportDialog.setContentView(R.layout.f168383uh);
            ((TextView) this.J.findViewById(R.id.photo_prievew_progress_dialog_text)).setText(R.string.y0y);
            this.J.setCancelable(true);
            this.J.setCanceledOnTouchOutside(false);
            this.J.setOnDismissListener(new b());
        }
        this.J.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mobileqq.activity.photo.album.i iVar = this.C;
        if (currentTimeMillis - iVar.f184328f >= 700) {
            iVar.f184328f = currentTimeMillis;
            QQToast.makeText(this.f184197m, str, 0).show(this.f184197m.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void a() {
        super.a();
        v().H.setOnClickListener(new a());
    }

    protected void c0(String str, LocalMediaInfo localMediaInfo) {
        os.a.f423933a.g(localMediaInfo);
        Intent intent = new Intent();
        intent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", new ArrayList<>(Collections.singletonList(str)));
        intent.putParcelableArrayListExtra("selected_local_infos", new ArrayList<>(Collections.singletonList(localMediaInfo)));
        this.f184197m.setResult(-1, intent);
        this.f184197m.finish();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void g() {
        super.g();
        v().H.setText(this.f184197m.getString(R.string.y0w) + " " + this.f184334e.selectedPhotoList.size() + "/" + this.f184334e.maxSelectNum);
        v().H.setEnabled(true);
        if (h0()) {
            v().H.setBackgroundResource(R.drawable.skin_aio_album_send_button_disabled);
        } else {
            v().H.setBackgroundResource(R.drawable.f160083a4);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void p(View view) {
        if (!this.f184334e.selectedIndex.contains(Integer.valueOf(v().i())) && this.f184334e.selectedPhotoList.size() >= this.f184334e.maxSelectNum) {
            j0(String.format(this.f184197m.getString(R.string.y5b), Integer.valueOf(this.f184334e.maxSelectNum)));
        } else {
            super.p(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g0(String str, LocalMediaInfo localMediaInfo) {
        if (str == null || !str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
            return localMediaInfo != null && "image/gif".equalsIgnoreCase(localMediaInfo.mMimeType);
        }
        return true;
    }
}
