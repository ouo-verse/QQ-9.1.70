package com.tencent.av.ui.part.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.utils.DataReport;
import com.tencent.av.widget.ChildLockCircle;
import com.tencent.av.widget.ChildLockSign;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.util.WeakReference;

/* loaded from: classes32.dex */
public class AVChildGuideUIPart extends nw.a {

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<Context> f76187e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<VideoAppInterface> f76188f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.av.ui.g f76189h;

    /* renamed from: i, reason: collision with root package name */
    private ChildLockCircle f76190i;

    /* renamed from: m, reason: collision with root package name */
    Runnable f76191m = new Runnable() { // from class: com.tencent.av.ui.part.base.AVChildGuideUIPart.1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            ChildLockSign childLockSign = (AVChildGuideUIPart.this.f76187e == null || AVChildGuideUIPart.this.f76187e.get() == 0) ? null : (ChildLockSign) ((Activity) AVChildGuideUIPart.this.f76187e.get()).findViewById(R.id.m0u);
            if (childLockSign != null) {
                childLockSign.setVisibility(8);
            }
        }
    };

    private void F9() {
        this.f76188f.get().M().removeCallbacks(this.f76191m);
        this.f76188f.get().M().postDelayed(this.f76191m, 3000L);
    }

    private void H9(SessionInfo sessionInfo) {
        ChildLockCircle C9 = C9(this.f76187e.get());
        if (C9 != null) {
            C9.C(sessionInfo == null || !sessionInfo.f73048l0);
        }
    }

    public boolean D9() {
        com.tencent.av.ui.g gVar = this.f76189h;
        return gVar != null && gVar.d();
    }

    public void E9() {
        com.tencent.av.ui.g gVar = this.f76189h;
        if (gVar == null || !gVar.d()) {
            return;
        }
        this.f76189h.b();
    }

    public void G9(int i3) {
        WeakReference<Context> weakReference;
        if (this.f76190i == null && (weakReference = this.f76187e) != null && weakReference.get() != null) {
            this.f76190i = (ChildLockCircle) ((Activity) this.f76187e.get()).findViewById(R.id.g7h);
        }
        ChildLockCircle childLockCircle = this.f76190i;
        if (childLockCircle != null) {
            childLockCircle.setRotation(360 - i3);
        }
    }

    public void I9() {
        WeakReference<Context> weakReference;
        if (this.f76190i == null && (weakReference = this.f76187e) != null && weakReference.get() != null) {
            this.f76190i = (ChildLockCircle) ((Activity) this.f76187e.get()).findViewById(R.id.g7h);
        }
        ChildLockCircle childLockCircle = this.f76190i;
        if (childLockCircle != null) {
            childLockCircle.E();
        }
    }

    public void J9(int i3, boolean z16) {
        VideoAppInterface videoAppInterface = this.f76188f.get();
        AVActivity x95 = x9(this.f76187e);
        com.tencent.av.ui.g gVar = this.f76189h;
        if ((gVar == null || !gVar.d()) && x95 != null) {
            if (this.f76189h == null) {
                ((ViewStub) x95.findViewById(R.id.f30050na)).inflate();
                this.f76189h = new com.tencent.av.ui.g(videoAppInterface, x95, (ViewGroup) x95.findViewById(R.id.g7i));
            }
            if (this.f76189h.a()) {
                this.f76189h.g();
                DataReport.T(null, "CliOper", "", "", "0X80061F6", "0X80061F6", 0, 0, "", "", "", "");
                return;
            }
            SessionInfo f16 = (videoAppInterface == null || r.h0() == null) ? null : n.e().f();
            if (1 == i3) {
                if (z16) {
                    return;
                }
                H9(f16);
                return;
            }
            if (i3 == 0) {
                I9();
                return;
            }
            if (3 == i3) {
                ChildLockSign B9 = B9(this.f76187e.get());
                if (f16 == null || f16.f73056n0 != 2 || B9 == null || !B9.isEnabled()) {
                    return;
                }
                if (B9.getVisibility() != 0) {
                    B9.setLocked(true);
                    B9.setVisibility(0);
                    F9();
                } else {
                    B9.setVisibility(8);
                    videoAppInterface.M().removeCallbacks(this.f76191m);
                }
            }
        }
    }

    public boolean onBackPressed() {
        com.tencent.av.ui.g gVar = this.f76189h;
        if (gVar == null || !gVar.d()) {
            return false;
        }
        return this.f76189h.e();
    }

    public boolean onClick(View view) {
        if (!D9()) {
            return false;
        }
        this.f76189h.onClick(view);
        return true;
    }

    @Override // nw.a
    public void onDestroy() {
        super.onDestroy();
        com.tencent.av.ui.g gVar = this.f76189h;
        if (gVar != null) {
            gVar.f();
            this.f76189h = null;
        }
        this.f76187e = null;
        this.f76191m = null;
    }

    @Override // nw.a, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        z9(getContext(), nw.b.b());
        super.onInitView(view);
        this.f76190i = (ChildLockCircle) view.findViewById(R.id.g7h);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        onDestroy();
    }

    @Override // nw.a
    public void z9(Context context, AppInterface appInterface) {
        super.z9(context, appInterface);
        this.f76187e = new WeakReference<>(context);
        this.f76188f = new WeakReference<>((VideoAppInterface) appInterface);
    }

    private ChildLockSign B9(Context context) {
        if (context == null) {
            return null;
        }
        Activity activity = (Activity) context;
        ChildLockSign childLockSign = (ChildLockSign) activity.findViewById(R.id.m0u);
        if (childLockSign != null) {
            return childLockSign;
        }
        ChildLockSign childLockSign2 = new ChildLockSign(activity);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.bok);
        Resources resources = viewGroup.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.b7o);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.b7l);
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(activity);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(R.dimen.b7m);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelOffset, dimensionPixelOffset2);
        layoutParams.setMargins(0, statusBarHeight, dimensionPixelOffset3, 0);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        viewGroup.addView(childLockSign2, layoutParams);
        childLockSign2.setVisibility(8);
        QLog.d(this.f421444d, 1, "initChildLockSignUI");
        return childLockSign2;
    }

    private ChildLockCircle C9(Context context) {
        if (context != null) {
            Activity activity = (Activity) context;
            ChildLockCircle childLockCircle = (ChildLockCircle) activity.findViewById(R.id.g7h);
            this.f76190i = childLockCircle;
            if (childLockCircle == null) {
                this.f76190i = new ChildLockCircle(activity);
                ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.bok);
                Resources resources = viewGroup.getResources();
                int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.a2r);
                int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.a2q);
                int dimensionPixelOffset3 = resources.getDimensionPixelOffset(R.dimen.f159360a81);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelOffset, dimensionPixelOffset2);
                layoutParams.setMargins(0, dimensionPixelOffset3, 0, 0);
                layoutParams.addRule(10);
                layoutParams.addRule(14);
                viewGroup.addView(this.f76190i, layoutParams);
                this.f76190i.F();
            }
        }
        return this.f76190i;
    }
}
