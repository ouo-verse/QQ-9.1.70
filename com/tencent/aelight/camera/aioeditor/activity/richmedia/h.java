package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h extends u implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f66448d;

    /* renamed from: e, reason: collision with root package name */
    private Button f66449e;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            id0.a.n("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
            if (!h.this.l0().J1()) {
                h.this.m0();
            } else {
                h.this.l0().L1(false);
                h.this.f66449e.setSelected(false);
                h.this.l0().K1(3003);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            ((QzoneEditPicturePartManager) h.this.mParent).L1(true);
            h.this.f66449e.setSelected(true);
            ((QzoneEditPicturePartManager) h.this.mParent).K1(3002);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            ((QzoneEditPicturePartManager) h.this.mParent).L1(false);
            h.this.f66449e.setSelected(false);
        }
    }

    public h(QzoneEditPicturePartManager qzoneEditPicturePartManager) {
        super(qzoneEditPicturePartManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        DialogUtil.createCustomDialog(getUi().getActivity(), 230).setMessage(R.string.gp8).setPositiveButton(R.string.gd5, new c()).setNegativeButton(R.string.a8j, new b()).show();
    }

    public QzoneEditPicturePartManager l0() {
        return (QzoneEditPicturePartManager) this.mParent;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        this.f66448d = (LinearLayout) findViewSure(R.id.hgj);
        Button button = (Button) findViewSure(R.id.cer);
        this.f66449e = button;
        button.setOnClickListener(new a());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        if (i3 != 0) {
            this.f66448d.setVisibility(8);
        } else {
            this.f66448d.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
