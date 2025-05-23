package com.qzone.reborn.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.tencent.biz.subscribe.part.block.base.RefreshHeaderView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.model.MaintEntryType;
import com.tencent.mobileqq.zplan.model.ZPlanMaintInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.api.IZPlanRefreshMoveListener;
import cooperation.qzone.api.OnRefreshStateListener;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* loaded from: classes37.dex */
public class ZPlanRefreshHeaderView extends RefreshHeaderView {

    /* renamed from: c0, reason: collision with root package name */
    public static int f59675c0 = 1000;

    /* renamed from: d0, reason: collision with root package name */
    public static int f59676d0 = 1000;
    private ArrayList<OnRefreshStateListener> U;
    private ArrayList<IZPlanRefreshMoveListener> V;
    private b W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f59677a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f59678b0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes37.dex */
    public interface b {
        boolean a();
    }

    /* loaded from: classes37.dex */
    public interface c {
    }

    public ZPlanRefreshHeaderView(Context context) {
        super(context);
        this.U = new ArrayList<>();
        this.V = new ArrayList<>();
        this.f59677a0 = true;
        this.f59678b0 = 0;
        r();
        Integer e16 = ni3.a.f420201a.e();
        if (e16 != null) {
            setVisibleHeight(e16.intValue());
        }
        f59676d0 = 13;
    }

    private void A(int i3) {
        int i16 = this.D;
        if (i3 == 3 && i16 == 17) {
            return;
        }
        if (i3 == 3 && i16 == -1 && !QZoneConfigHelper.P0()) {
            q(false);
            return;
        }
        super.setState(i3);
        if (i3 == 3) {
            this.D = 13;
        }
        f59676d0 = this.D;
    }

    private void r() {
        ProgressBar progressBar = this.f96189h;
        if (progressBar == null || !(progressBar.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            return;
        }
        this.f96189h.setIndeterminateDrawable(getResources().getDrawable(R.drawable.common_loading2));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f96189h.getLayoutParams();
        layoutParams.topMargin = ImmersiveUtils.dpToPx(51.0f);
        layoutParams.rightMargin = 0;
        layoutParams.gravity = 48;
        this.f96189h.setLayoutParams(layoutParams);
    }

    private void s(int i3) {
        Iterator<IZPlanRefreshMoveListener> it = this.V.iterator();
        while (it.hasNext()) {
            IZPlanRefreshMoveListener next = it.next();
            if (next != null) {
                next.onMove(i3);
            }
        }
    }

    private void u(int i3) {
        QZLog.i("QZoneConciseZPlan ZPlanRefreshHeaderView", 1, "[callBackRefreshStateChangeListener] state=" + i3);
        Iterator<IZPlanRefreshMoveListener> it = this.V.iterator();
        while (it.hasNext()) {
            IZPlanRefreshMoveListener next = it.next();
            if (next != null) {
                next.onStateChange(i3);
            }
        }
    }

    public static boolean y() {
        int i3 = f59676d0;
        return i3 == f59675c0 || i3 == -1;
    }

    public void B(IZPlanRefreshMoveListener iZPlanRefreshMoveListener) {
        ArrayList<IZPlanRefreshMoveListener> arrayList = this.V;
        if (arrayList == null || iZPlanRefreshMoveListener == null) {
            return;
        }
        arrayList.add(iZPlanRefreshMoveListener);
    }

    public void C(OnRefreshStateListener onRefreshStateListener) {
        ArrayList<OnRefreshStateListener> arrayList = this.U;
        if (arrayList == null || onRefreshStateListener == null) {
            return;
        }
        arrayList.add(onRefreshStateListener);
    }

    public void D() {
        ZPlanMaintInfo maintenanceInfo = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getMaintenanceInfo(MaintEntryType.ALL);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230);
        createCustomDialog.setTitle(maintenanceInfo.f());
        createCustomDialog.setMessage(maintenanceInfo.g());
        createCustomDialog.setPositiveButton(R.string.f172538rr3, (DialogInterface.OnClickListener) new a(), true);
        createCustomDialog.setNegativeButton((String) null, (DialogInterface.OnClickListener) null);
        createCustomDialog.setCancelable(true);
        createCustomDialog.show();
    }

    public void E() {
        if (this.H) {
            q(false);
        }
        setState(-1);
        n(w());
    }

    public void F(IZPlanRefreshMoveListener iZPlanRefreshMoveListener) {
        ArrayList<IZPlanRefreshMoveListener> arrayList = this.V;
        if (arrayList == null) {
            return;
        }
        Iterator<IZPlanRefreshMoveListener> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().equals(iZPlanRefreshMoveListener)) {
                it.remove();
                return;
            }
        }
    }

    public void G(OnRefreshStateListener onRefreshStateListener) {
        ArrayList<OnRefreshStateListener> arrayList = this.U;
        if (arrayList == null || onRefreshStateListener == null) {
            return;
        }
        arrayList.remove(onRefreshStateListener);
    }

    @Override // com.tencent.biz.subscribe.part.block.base.RefreshHeaderView
    public boolean e() {
        if (this.D == 17 || Math.abs(this.F) <= 5.0f) {
            return false;
        }
        return this.D != -1 || (f() && this.S);
    }

    @Override // com.tencent.biz.subscribe.part.block.base.RefreshHeaderView
    public void i(float f16, float f17) {
        int b16 = b();
        if (this.D != 17) {
            if (b16 > 0 || f16 > 0.0f) {
                setVisibleHeight(((int) f16) + b16);
                ni3.a aVar = ni3.a.f420201a;
                Integer d16 = aVar.d();
                if (d16 != null && b16 > d16.intValue()) {
                    setState(16);
                    return;
                }
                Integer g16 = aVar.g();
                if (g16 != null && b16 > g16.intValue()) {
                    setState(15);
                    q(false);
                    return;
                }
                Integer f18 = aVar.f();
                if (f18 != null && b16 > f18.intValue()) {
                    setState(14);
                    return;
                }
                Integer e16 = aVar.e();
                if (e16 != null && b16 >= e16.intValue()) {
                    setState(13);
                    return;
                }
                Integer a16 = aVar.a();
                if (a16 != null && b16 > a16.intValue()) {
                    setState(12);
                    return;
                }
                Integer b17 = aVar.b();
                if (b17 != null && b16 > b17.intValue()) {
                    setState(11);
                    return;
                }
                if (xe.a.f447839a.e()) {
                    if (b16 > 0) {
                        setState(10);
                    }
                } else if (b16 > w()) {
                    setState(10);
                }
            }
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.base.RefreshHeaderView
    public boolean k() {
        String valueOf;
        b bVar = this.W;
        if (bVar == null) {
            valueOf = "null";
        } else {
            valueOf = String.valueOf(bVar.a());
        }
        QZLog.i("QZoneConciseZPlan ZPlanRefreshHeaderView", 1, "[onRelease] mState=" + this.D + "| mSetRefreshInRefreshZoom=" + this.f59677a0 + "| mZPlanEnableEnterFullScreen=" + valueOf);
        u(this.D);
        t();
        int i3 = this.D;
        if (i3 == 15) {
            if (this.f59677a0) {
                setState(2);
                return true;
            }
            p();
            return false;
        }
        if (i3 == 16) {
            b bVar2 = this.W;
            if (bVar2 != null && bVar2.a()) {
                setState(17);
                return false;
            }
            if (z()) {
                D();
            }
            setState(2);
            return true;
        }
        if (i3 == 13 || i3 == 14 || i3 == 12) {
            p();
            return false;
        }
        if (i3 != 11) {
            if (i3 == 10) {
                E();
            }
            return false;
        }
        if (this.S) {
            p();
        } else {
            E();
        }
        return false;
    }

    @Override // com.tencent.biz.subscribe.part.block.base.RefreshHeaderView
    public void p() {
        if (this.D == -1) {
            return;
        }
        Integer e16 = ni3.a.f420201a.e();
        if (e16 == null) {
            QLog.e("QZoneConciseZPlan ZPlanRefreshHeaderView", 1, "smoothScrollToDefaultHeight failed, initHeight null.");
            return;
        }
        if (this.H) {
            q(false);
            this.H = false;
        }
        this.f59677a0 = true;
        setState(13);
        n(e16.intValue());
    }

    @Override // com.tencent.biz.subscribe.part.block.base.RefreshHeaderView
    public void q(boolean z16) {
        QZLog.i("QZoneConciseZPlan ZPlanRefreshHeaderView", 1, "[toggleProgressBar] isZPlanRefreshing=false| qZoneRefreshIsVisible=" + z16);
        super.q(z16);
    }

    public void setMaxVisibilityHeight(int i3) {
        this.f59678b0 = i3;
    }

    @Override // com.tencent.biz.subscribe.part.block.base.RefreshHeaderView, com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setState(int i3) {
        setState(i3, null);
    }

    @Override // com.tencent.biz.subscribe.part.block.base.RefreshHeaderView
    public void setVisibleHeight(int i3) {
        int i16 = this.f59678b0;
        if (i16 > 0 && i3 > i16) {
            i3 = i16;
        }
        super.setVisibleHeight(i3);
        s(i3);
    }

    public void setZPlanEnableEnterFullScreen(b bVar) {
        this.W = bVar;
    }

    public int w() {
        if (QZoneConfigHelper.l()) {
            return QZoneFeedxViewUtils.e(getContext());
        }
        return ni3.a.f420201a.c();
    }

    public int x() {
        return this.D;
    }

    public boolean z() {
        return com.tencent.mobileqq.zplan.model.j.a(((IZPlanApi) QRoute.api(IZPlanApi.class)).getMaintenanceInfo(MaintEntryType.ALL), new Date());
    }

    private void t() {
        QZLog.i("QZoneConciseZPlan ZPlanRefreshHeaderView", 1, "[callBackRefreshReleaseListener]");
        Iterator<IZPlanRefreshMoveListener> it = this.V.iterator();
        while (it.hasNext()) {
            IZPlanRefreshMoveListener next = it.next();
            if (next != null) {
                next.onRelease();
            }
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.base.RefreshHeaderView
    public void l() {
        setState(-1);
    }

    public void setState(int i3, Object obj) {
        int i16 = this.D;
        A(i3);
        v(i16, this.D, obj);
    }

    public void setZPlanIsRefreshing(c cVar) {
        QZLog.i("QZoneConciseZPlan ZPlanRefreshHeaderView", 1, "[setZPlanIsRefreshing]");
    }

    @Override // com.tencent.biz.subscribe.part.block.base.RefreshHeaderView
    public void c() {
        this.E = -1.0f;
        if (this.D == -1 || !e()) {
            return;
        }
        k();
    }

    private void v(int i3, int i16, Object obj) {
        int i17 = i16 != 2 ? i16 : 15;
        if (i3 != i16) {
            Iterator<OnRefreshStateListener> it = this.U.iterator();
            while (it.hasNext()) {
                OnRefreshStateListener next = it.next();
                if (next != null) {
                    next.onRefreshStateChange(i17, obj);
                }
            }
        }
    }
}
