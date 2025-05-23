package com.tencent.av.ui.effect.menuview;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.n;
import com.tencent.av.opengl.effects.j;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavMenuBaseView;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.c;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.h;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class QavEffectBaseMenuView extends QavMenuBaseView {
    protected boolean C;
    private VideoObserver D;

    /* renamed from: h, reason: collision with root package name */
    protected WeakReference<AVActivity> f75550h;

    /* renamed from: i, reason: collision with root package name */
    protected SparseArray<BaseToolbar> f75551i;

    /* renamed from: m, reason: collision with root package name */
    protected int f75552m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends VideoObserver {
        a() {
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void K() {
            QavEffectBaseMenuView.this.w("onPauseVideo");
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void L(String str, boolean z16) {
            int i3 = n.e().f().f73035i;
            if ((i3 == 2 || i3 == 1) && z16) {
                QavEffectBaseMenuView.this.w("onPeerSwitchTerminal");
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void U(long j3) {
            QavEffectBaseMenuView.this.w("onResumeVideo");
        }
    }

    public QavEffectBaseMenuView(Context context) {
        super(context);
        this.f75550h = null;
        this.f75551i = new SparseArray<>();
        this.f75552m = -1;
        this.C = false;
        if (context instanceof AVActivity) {
            this.f75550h = new WeakReference<>((AVActivity) context);
        }
    }

    private void B(boolean z16) {
        this.C = z16;
    }

    void A(int i3, boolean z16) {
        BaseToolbar baseToolbar = this.f75551i.get(i3);
        if (baseToolbar != null) {
            baseToolbar.setEffectBtnVisibility(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean C(long j3, int i3, boolean z16) {
        boolean z17;
        BaseToolbar.keepInToolbar(this.f75038e, j3);
        BaseToolbar baseToolbar = this.f75551i.get(i3);
        int i16 = this.f75552m;
        if (baseToolbar != null) {
            z17 = baseToolbar.tryShowToolbar(j3, r(), i16, z16);
        } else {
            z17 = true;
        }
        QLog.w(this.f75037d, 1, "tryShowToolbar, SelectedId[" + i16 + "->" + i3 + "], bFromPerformClick[" + z16 + "], showToolbar[" + z17 + "], seq[" + j3 + "]");
        if (z17) {
            if (i16 != i3) {
                BaseToolbar baseToolbar2 = this.f75551i.get(i16);
                setCurSelectedId(i3, "tryShowToolbar");
                if (baseToolbar2 != null && this.f75552m != i16) {
                    baseToolbar2.hideToolbar(j3);
                }
                this.f75550h.get().R2(j3);
            }
            for (int i17 = 1; i17 <= 7; i17++) {
                BaseToolbar baseToolbar3 = this.f75551i.get(i17);
                if (baseToolbar3 != null && i17 != i3 && baseToolbar3.isAvailable()) {
                    baseToolbar3.hideToolbar(j3);
                    if (QLog.isColorLevel()) {
                        QLog.i(this.f75037d, 2, "tryShowToolbar, check fail, id[" + i17 + "]");
                    }
                }
            }
        } else {
            if (i3 == 1) {
                if (VideoUtil.a(this.f75038e)) {
                    h.d("0X8007F27");
                } else if (VideoUtil.b(this.f75038e)) {
                    h.d("0X8007F2D");
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(this.f75037d, 4, String.format("\u6309\u94ae\u70b9\u51fb\u5931\u8d25, lastSelectedId[%s], newSelectId[%s]", Integer.valueOf(i16), Integer.valueOf(i3)));
            }
        }
        if (baseToolbar != null) {
            baseToolbar.onButtonClick(i16, z16, z17);
        }
        return z17;
    }

    public void D(long j3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.w(this.f75037d, 1, "updateBtnStatus, reselect[" + z16 + "], mCurSelectedId[" + this.f75552m + "], isShown[" + isShown() + "], seq[" + j3 + "]");
        }
        for (int i3 = 0; i3 < this.f75551i.size(); i3++) {
            this.f75551i.valueAt(i3).updateEffectBtnStatus();
        }
        if (z16) {
            BaseToolbar baseToolbar = this.f75551i.get(this.f75552m);
            if (baseToolbar != null) {
                baseToolbar.hideToolbar(j3);
            }
            setCurSelectedId(-1, "updateBtnStatus");
        }
        if (isShown()) {
            y(this.f75552m, -1);
        }
    }

    public void E() {
        boolean z16;
        boolean z17;
        SessionInfo f16 = n.e().f();
        boolean z18 = true;
        if (f16 != null && !f16.N) {
            A(5, true);
            A(3, false);
            A(2, false);
            A(7, false);
            A(1, false);
            A(4, false);
            A(8, false);
            if (p() != null) {
                p().setVisibility(8);
                return;
            }
            return;
        }
        if (p() != null) {
            p().setVisibility(0);
        }
        boolean D = j.D();
        BaseToolbar baseToolbar = this.f75551i.get(1);
        if (baseToolbar != null) {
            baseToolbar.updateEffectBtnStatus();
        }
        A(5, true);
        A(1, D);
        A(4, D);
        A(8, D);
        boolean g16 = VideoUtil.g(this.f75038e, true);
        if (g16 && D) {
            z16 = true;
        } else {
            z16 = false;
        }
        A(3, z16);
        if (g16 && D) {
            z17 = true;
        } else {
            z17 = false;
        }
        A(2, z17);
        if (!g16 || !D) {
            z18 = false;
        }
        A(7, z18);
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f75037d, 4, "updateBtnUi, enableAE[" + D + "], visibility[" + g16 + "]");
        }
    }

    public boolean F(long j3, int i3) {
        E();
        int i16 = this.f75552m;
        if (i3 != -1) {
            i16 = i3;
        }
        int j16 = j(i16, -1);
        QLog.w(this.f75037d, 1, "show, EffectBtnID \u539f[" + this.f75552m + "], \u671f\u671b[" + i3 + "], \u6700\u7ec8[" + j16 + "], seq[" + j3 + "]");
        if (!this.C) {
            QQToast.makeText(this.f75550h.get(), this.f75550h.get().getString(R.string.d8r), 1).show();
            c.a();
            return isShown();
        }
        c.b(n.e().f().S0, VideoUtil.d(this.f75038e));
        BaseToolbar baseToolbar = this.f75551i.get(j16);
        if (baseToolbar != null) {
            baseToolbar.performClick();
        }
        SessionInfo f16 = n.e().f();
        if (f16 != null && f16.K() && f16.f73035i == 2) {
            ReportController.o(null, "dc00898", "", "", "0X8008AD5", "0X8008AD5", 0, 0, "", "", "", "");
        }
        return true;
    }

    @Override // com.tencent.av.ui.QavMenuBaseView
    public void a(QavPanel qavPanel) {
        super.a(qavPanel);
        u();
    }

    @Override // com.tencent.av.ui.QavMenuBaseView
    public void e(long j3) {
        k();
        l(j3);
        super.e(j3);
    }

    @Override // android.view.View
    public boolean isShown() {
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    protected int j(int i3, int i16) {
        BaseToolbar baseToolbar = this.f75551i.get(i3);
        if (baseToolbar != null && baseToolbar.isAvailable()) {
            if (QLog.isDevelopLevel()) {
                QLog.d(this.f75037d, 4, String.format("checkAbility \u671f\u671b\u7684\u6309\u94ae\u53ef\u7528, effectBtnID[%s]", Integer.valueOf(i3)));
            }
            B(true);
            return i3;
        }
        int z16 = z(i16);
        if (this.f75551i.get(z16) != null) {
            B(true);
        } else {
            B(false);
        }
        return z16;
    }

    public void k() {
        this.f75038e.deleteObserver(this.D);
    }

    void l(long j3) {
        for (int i3 = 0; i3 < this.f75551i.size(); i3++) {
            this.f75551i.valueAt(i3).destroy(j3, this.f75038e);
        }
        this.f75551i.clear();
    }

    public void m(int i3) {
        long d16 = e.d();
        QLog.w(this.f75037d, 1, "exitSubEffectPanel, ExitID[" + i3 + "], mCurSelectedId[" + this.f75552m + "], isShown[" + isShown() + "], seq[" + d16 + "]");
        if (this.f75552m == i3) {
            int j3 = j(-1, i3);
            if (isShown()) {
                if (j3 > i3) {
                    s(d16);
                    return;
                } else {
                    y(j3, i3);
                    return;
                }
            }
            BaseToolbar baseToolbar = this.f75551i.get(this.f75552m);
            if (baseToolbar != null) {
                baseToolbar.hideToolbar(d16);
            }
            setCurSelectedId(-1, "exitSubEffectPanel");
        }
    }

    protected abstract View.OnClickListener n();

    protected abstract ViewGroup o();

    protected abstract ViewGroup p();

    public int q() {
        return this.f75552m;
    }

    protected abstract ViewGroup r();

    protected abstract void s(long j3);

    public void setCurSelectedId(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(this.f75037d, 2, "setCurSelectedId, [" + this.f75552m + "--->" + i3 + "], from[" + str + "]");
        }
        if (this.f75552m != i3) {
            this.f75552m = i3;
        }
    }

    public void setSelectedBtn(int i3) {
        if (i3 == this.f75552m) {
            return;
        }
        y(i3, -1);
        setCurSelectedId(i3, "setSelectedBtn");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseToolbar t(boolean z16, Class<? extends BaseToolbar> cls) {
        BaseToolbar createToolbar = BaseToolbar.createToolbar(this.f75038e, this.f75550h.get(), cls);
        createToolbar.initBtn(o(), z16, n());
        this.f75551i.put(createToolbar.getEffectBtnId(), createToolbar);
        createToolbar.updateEffectBtnStatus();
        return createToolbar;
    }

    public void u() {
        a aVar = new a();
        this.D = aVar;
        this.f75038e.addObserver(aVar);
    }

    public boolean v(int i3) {
        if (this.f75552m == i3 && isShown()) {
            return true;
        }
        return false;
    }

    void w(String str) {
        final long d16 = e.d();
        if (QLog.isColorLevel()) {
            QLog.i(this.f75037d, 2, "notifyStatusChange, seq[" + d16 + "]from " + str);
        }
        VideoAppInterface videoAppInterface = this.f75038e;
        if (videoAppInterface == null) {
            return;
        }
        videoAppInterface.M().post(new Runnable() { // from class: com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (((QavMenuBaseView) QavEffectBaseMenuView.this).f75038e != null && QavEffectBaseMenuView.this.o() != null) {
                    QavEffectBaseMenuView.this.D(d16, false);
                }
            }
        });
    }

    public boolean x() {
        if (!this.f75550h.get().I0.I()) {
            return false;
        }
        s(-1012L);
        return true;
    }

    protected boolean y(int i3, int i16) {
        boolean z16;
        int j3 = j(i3, i16);
        BaseToolbar baseToolbar = this.f75551i.get(j3);
        if (baseToolbar != null) {
            baseToolbar.performClick();
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f75037d, 1, "reSelectBtn, effectBtnID[" + i3 + "], ignoreID[" + i16 + "], selectid[" + j3 + "], ret[" + z16 + "]");
        }
        return z16;
    }

    int z(int i3) {
        for (int i16 = 0; i16 < this.f75551i.size(); i16++) {
            BaseToolbar valueAt = this.f75551i.valueAt(i16);
            if (valueAt != null && valueAt.getEffectBtnId() != i3 && valueAt.isAvailable()) {
                return valueAt.getEffectBtnId();
            }
        }
        return -1;
    }
}
