package com.tencent.aelight.camera.aioeditor.capture.text;

import android.app.Activity;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CaptureComboText extends com.tencent.aelight.camera.aioeditor.capture.data.a {
    private List<String> C;
    private float D;
    private float E;
    private float F;
    private DynamicTextConfigManager G;
    private DynamicTextConfigManager.DynamicTextConfigBean H;
    private volatile int I;
    private volatile float J;
    private DynamicTextConfigManager.b K;

    /* renamed from: m, reason: collision with root package name */
    private String f66863m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements DynamicTextConfigManager.b {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.b
        public void a(float f16, String str, int i3) {
            if (QLog.isColorLevel()) {
                QLog.i("QComboDText", 2, "CaptureComboText onUpdateProgress, progress is : " + f16);
            }
            CaptureComboText.this.J = f16;
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.b
        public void v(boolean z16, String str) {
            if (QLog.isColorLevel()) {
                QLog.i("QComboDText", 2, "CaptureComboText onDownloadFinish, success: " + z16);
            }
            if (z16) {
                CaptureComboText.this.I = 3;
                CaptureComboText.this.n();
            } else {
                CaptureComboText.this.I = 2;
                CaptureComboText.this.m(4);
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public int g(Activity activity, int i3) {
        final DoodleLayout b16;
        if (QLog.isColorLevel()) {
            QLog.d("QComboDText", 2, "apply ComboText");
        }
        DynamicTextConfigManager.DynamicTextConfigBean dynamicTextConfigBean = this.H;
        if (dynamicTextConfigBean != null && this.G.q(dynamicTextConfigBean) && activity != null && (b16 = com.tencent.aelight.camera.aioeditor.capture.util.b.c().b(i3)) != null && b16.C0() != null) {
            b16.C0().f0(4);
            DynamicTextItem b17 = new DynamicTextBuilder().b(Integer.valueOf(this.f66863m).intValue(), this.C);
            if (b17 != null) {
                float w3 = (ScreenUtil.SCREEN_WIDTH * this.F) / b17.w();
                float f16 = this.D;
                int i16 = ScreenUtil.SCREEN_WIDTH;
                if (b16.C0().K(new g.b(i16 * f16, this.E * i16, w3, 0.0f, 0.0f, 0.0f, b17.w(), b17.m()), this.f66708h, b16.n0()) != null) {
                    b17.L(true);
                    b16.C0().j0(b17);
                    b16.C0().n();
                } else {
                    QQToast.makeText(activity, activity.getString(R.string.f2q), 0).show();
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.text.CaptureComboText.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b16.h1(0, Boolean.FALSE);
                        }
                    });
                }
            }
        }
        return 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public int h() {
        if (QLog.isColorLevel()) {
            QLog.i("QComboDText", 2, "CaptureComboText download, state is: " + this.I);
        }
        if (this.I != 1 && this.I != 3) {
            if (this.H == null) {
                this.H = this.G.g(this.f66863m);
            }
            if (this.H == null) {
                this.G.m();
                this.H = this.G.g(this.f66863m);
            }
            if (this.H == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("QComboDText", 2, "CaptureComboText download, bean is null.");
                }
                this.I = 2;
                return 2;
            }
            l();
            if (this.G.q(this.H)) {
                if (QLog.isColorLevel()) {
                    QLog.i("QComboDText", 2, "startDownload dynamicText is usable.");
                }
                n();
                this.I = 3;
                return 2;
            }
            this.G.s(this.H, this.K);
            this.I = 1;
            return 1;
        }
        return this.I;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public float i() {
        if (QLog.isColorLevel()) {
            QLog.i("QComboDText", 2, "CaptureComboText getProgress, progress is: " + this.J);
        }
        return this.J * 0.01f;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public int j() {
        int i3;
        if (this.H == null) {
            this.G.m();
            this.H = this.G.g(this.f66863m);
        }
        DynamicTextConfigManager.DynamicTextConfigBean dynamicTextConfigBean = this.H;
        if (dynamicTextConfigBean == null) {
            i3 = 2;
        } else {
            i3 = (this.G.q(dynamicTextConfigBean) && this.I == 2) ? 3 : this.I;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QComboDText", 2, "CaptureComboText getState, state is: " + i3 + " id is: " + this.f66863m);
        }
        return i3;
    }

    public String toString() {
        return "Text@" + Arrays.toString(this.C.toArray()) + "@" + hashCode();
    }

    public CaptureComboText(String str, List<String> list, float f16, float f17, float f18) {
        super(null);
        this.I = 2;
        this.K = new a();
        ArrayList arrayList = new ArrayList();
        this.C = arrayList;
        this.f66863m = str;
        arrayList.addAll(list);
        this.D = f16;
        this.E = f17;
        this.F = f18;
        this.G = (DynamicTextConfigManager) fr.f.c(7);
        if (QLog.isColorLevel()) {
            QLog.i("QComboDText", 2, "CaptureComboText id is: " + str);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public void q(Activity activity, int i3) {
        DoodleLayout b16;
        if (activity == null || (b16 = com.tencent.aelight.camera.aioeditor.capture.util.b.c().b(i3)) == null || b16.C0() == null) {
            return;
        }
        b16.C0().f0(4);
        b16.C0().P();
        b16.C0().n();
    }
}
