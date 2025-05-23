package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.util.LiuHaiUtils;
import cooperation.qzone.util.QZLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes32.dex */
public class QzoneEditPicturePartManager extends EditPicPartManager {
    public String A0;
    public String B0;
    public boolean E0;
    public boolean G0;
    public String K0;
    public String M0;
    private boolean N0;
    private final QzoneEditPictureActivity O0;
    private boolean P0;

    /* renamed from: u0, reason: collision with root package name */
    private e f66348u0;

    /* renamed from: v0, reason: collision with root package name */
    private h f66349v0;

    /* renamed from: w0, reason: collision with root package name */
    private g f66350w0;

    /* renamed from: x0, reason: collision with root package name */
    public View f66351x0;

    /* renamed from: y0, reason: collision with root package name */
    public ArrayList<String> f66352y0 = null;

    /* renamed from: z0, reason: collision with root package name */
    public int f66353z0 = 1;
    public String C0 = "";
    public boolean D0 = true;
    public boolean F0 = true;
    public boolean H0 = true;
    public int I0 = -1;
    public int J0 = -1;
    public int L0 = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes32.dex */
    @interface UIEditExtraType {
    }

    public QzoneEditPicturePartManager(QzoneEditPictureActivity qzoneEditPictureActivity, boolean z16) {
        this.O0 = qzoneEditPictureActivity;
        this.P0 = z16;
    }

    private f G1() {
        for (u uVar : Z()) {
            if (uVar instanceof f) {
                return (f) uVar;
            }
        }
        return null;
    }

    private void H1() {
        RelativeLayout relativeLayout = (RelativeLayout) this.O0.findViewById(R.id.rya);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.O0).inflate(R.layout.bkd, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, LiuHaiUtils.sNotchHeight, 0, 0);
        layoutParams.addRule(11);
        relativeLayout.addView(linearLayout, layoutParams);
        linearLayout.findViewById(R.id.hgj).setVisibility(0);
        linearLayout.findViewById(R.id.hgh).setVisibility(0);
        linearLayout.findViewById(R.id.hgk).setVisibility(8);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.O0.getLayoutInflater().inflate(R.layout.bkb, (ViewGroup) relativeLayout, false);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, BaseAIOUtils.f(50.0f, d0().getContext().getResources()));
        relativeLayout2.setVisibility(0);
        layoutParams2.addRule(12);
        int i3 = LiuHaiUtils.BOTTOM_HEIGHT;
        if (i3 <= 0) {
            i3 = BaseAIOUtils.f(60.0f, this.O0.getResources());
        }
        layoutParams2.bottomMargin = i3;
        View view = new View(this.O0);
        view.setBackgroundColor(Color.argb(128, 0, 0, 0));
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        view.setVisibility(8);
        relativeLayout.addView(relativeLayout2, layoutParams2);
        relativeLayout.addView(view);
        this.f66351x0 = view;
    }

    public boolean I1() {
        return this.P0;
    }

    public boolean J1() {
        return this.N0;
    }

    public void K1(int i3) {
        f G1 = G1();
        if (G1 != null) {
            G1.editVideoStateChanged(i3, null);
        }
    }

    public void L1(boolean z16) {
        this.N0 = z16;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public void Z0(Context context) {
        super.Z0(context);
        K1(3005);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager, com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    protected void j0(EditVideoParams editVideoParams) {
        int i3 = (editVideoParams.f204057f | 8192) & (-4097);
        if (I1()) {
            super.j0(new EditVideoParams(editVideoParams.f204055d, i3 & (-513), editVideoParams.f204059i, editVideoParams.f204058h));
            p(this.D);
            return;
        }
        super.j0(new EditVideoParams(editVideoParams.f204055d, i3, editVideoParams.f204059i, editVideoParams.f204058h));
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public void n1() {
        super.n1();
        K1(3006);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public void p(List<u> list) {
        super.p(list);
        if (I1()) {
            e eVar = new e(this);
            this.f66348u0 = eVar;
            list.add(eVar);
            h hVar = new h(this);
            this.f66349v0 = hVar;
            list.add(hVar);
            g gVar = new g(this);
            this.f66350w0 = gVar;
            list.add(gVar);
        }
        try {
            list.add(new j(this));
        } catch (Exception unused) {
            QZLog.e("QzEditVideoPartManager", 2, "addExtraParts", " add report part error");
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public void u0() {
        if (I1()) {
            H1();
        }
        super.u0();
    }
}
