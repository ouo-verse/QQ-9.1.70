package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer;
import com.tencent.aelight.camera.aioeditor.takevideo.aa;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.aelight.camera.aioeditor.takevideo.y;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes32.dex */
public class QzEditVideoPartManager extends EditVideoPartManager {
    public boolean A0;
    public boolean C0;
    public boolean E0;
    public String J0;
    public String L0;
    public boolean M0;
    public boolean N0;
    public int O0;
    public QzoneVerticalVideoTopicInfo P0;
    public boolean Q0;
    public boolean R0;
    public boolean S0;
    public boolean T0;
    private int U0;

    /* renamed from: t0, reason: collision with root package name */
    public Activity f66338t0;

    /* renamed from: u0, reason: collision with root package name */
    public View f66339u0;

    /* renamed from: x0, reason: collision with root package name */
    public String f66342x0;

    /* renamed from: y0, reason: collision with root package name */
    public String f66343y0;

    /* renamed from: v0, reason: collision with root package name */
    public ArrayList<String> f66340v0 = null;

    /* renamed from: w0, reason: collision with root package name */
    public int f66341w0 = 1;

    /* renamed from: z0, reason: collision with root package name */
    public String f66344z0 = "";
    public boolean B0 = true;
    public boolean D0 = true;
    public boolean F0 = true;
    public boolean G0 = true;
    public int H0 = -1;
    public int I0 = -1;
    public int K0 = -1;
    public boolean V0 = false;

    /* loaded from: classes32.dex */
    @interface UIEditExtraType {
    }

    public QzEditVideoPartManager(Activity activity) {
        this.T0 = false;
        this.U0 = -1;
        this.f66338t0 = activity;
        this.T0 = activity.getIntent().getIntExtra("qqstory_slide_show_scene", -1) == 22;
        this.U0 = activity.getIntent().getIntExtra("qqstory_slide_show_entrance", -1);
    }

    static void s1(String str, String str2, String str3, boolean z16) {
        QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
        reportInfo.actionType = str;
        reportInfo.subactionType = str2;
        reportInfo.reserves = str3;
        QZoneClickReport.report(QQStoryContext.h().d(), reportInfo, z16);
    }

    private j t1() {
        for (u uVar : Z()) {
            if (uVar instanceof j) {
                return (j) uVar;
            }
        }
        return null;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public void Y0(String str, String str2, String str3, boolean z16) {
        s1(str, str2, str3, z16);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public void Z0(Context context) {
        super.Z0(context);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public void b1() {
        int i3;
        s1("608", "1", "0", true);
        if (!this.M0 && (i3 = this.O0) > 0) {
            CodecParam.mMaxrate /= i3;
        }
        super.b1();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public void n1() {
        super.n1();
        v1(3005);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public void p(List<u> list) {
        int i3;
        if (!this.T0 || ((i3 = this.U0) != 14 && i3 != 19)) {
            list.add(new a(this));
        }
        if (this.T0) {
            list.add(new y(this));
        }
        if (this.N0 && !this.T0) {
            list.add(new k(this, this.f66338t0));
        }
        QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo = this.P0;
        if (qzoneVerticalVideoTopicInfo != null) {
            list.add(new i(this, qzoneVerticalVideoTopicInfo));
        }
        list.add(new j(this));
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public void r(aa aaVar, EditVideoParams editVideoParams) {
        super.r(aaVar, editVideoParams);
        if (editVideoParams == null || editVideoParams.f204058h == null) {
            return;
        }
        int i3 = this.U0;
        if (i3 == 17 || i3 == 18) {
            editVideoParams.f204058h.putString("extra_publish_text", this.f66338t0.getResources().getString(R.string.gly));
        }
    }

    public void u1() {
        HWEditLocalVideoPlayer hWEditLocalVideoPlayer = this.f67800r0;
        if (hWEditLocalVideoPlayer != null) {
            hWEditLocalVideoPlayer.pause();
        }
    }

    public void v1(int i3) {
        j t16 = t1();
        if (t16 != null) {
            t16.editVideoStateChanged(i3, null);
        }
    }
}
