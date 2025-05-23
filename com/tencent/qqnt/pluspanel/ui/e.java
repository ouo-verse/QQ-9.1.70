package com.tencent.qqnt.pluspanel.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e extends ReportDialog {
    static IPatchRedirector $redirector_;
    FrameLayout C;
    private RecyclerView D;
    ScrollView E;
    private final boolean[] F;
    private final QUSHalfScreenFloatingView G;
    private ArrayList<com.tencent.qqnt.pluspanel.data.a> H;
    private View.OnClickListener I;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends com.tencent.mobileqq.widget.qus.e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float f16, float f17) {
            int findFirstVisibleItemPosition;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            if (e.this.D != null) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) e.this.D.getLayoutManager();
                if (gridLayoutManager == null) {
                    findFirstVisibleItemPosition = 0;
                } else {
                    findFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
                }
                if (findFirstVisibleItemPosition != 0) {
                    return true;
                }
                View childAt = e.this.D.getChildAt(0);
                boolean[] zArr = e.this.F;
                if (childAt == null || childAt.getTop() != 0) {
                    z16 = true;
                }
                zArr[1] = z16;
                return e.this.F[1];
            }
            if (e.this.E.getScrollY() == 0) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float f16, float f17) {
            int findLastVisibleItemPosition;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            if (e.this.D != null) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) e.this.D.getLayoutManager();
                if (gridLayoutManager == null) {
                    findLastVisibleItemPosition = 0;
                } else {
                    findLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
                }
                if (findLastVisibleItemPosition != e.this.D.getChildCount() - 1) {
                    return true;
                }
                View childAt = e.this.D.getChildAt(e.this.D.getChildCount() - 1);
                boolean[] zArr = e.this.F;
                if (childAt != null && childAt.getBottom() == e.this.D.getHeight()) {
                    z16 = false;
                }
                zArr[0] = z16;
                return e.this.F[0];
            }
            if (e.this.E.getScrollY() != e.this.C.getHeight() + e.this.E.getHeight()) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @SuppressLint({"UseCompatLoadingForDrawables"})
        /* renamed from: createContentView */
        public View getF52508d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (View) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            e.this.C = new FrameLayout(e.this.getContext());
            e.this.C.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            e eVar = e.this;
            eVar.C.setBackgroundColor(eVar.getContext().getResources().getColor(R.color.qui_common_bg_middle_standard));
            int dpToPx = ViewUtils.dpToPx(32.0f);
            e.this.C.setPadding(dpToPx, ViewUtils.dpToPx(25.0f), dpToPx, 0);
            e.this.initView();
            return e.this.C;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return ViewUtils.dip2px(339.0f);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b extends com.tencent.mobileqq.widget.qus.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefault() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefaultStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMinStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotalStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (e.this.isShowing()) {
                e.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (e.this.I != null) {
                    e.this.I.onClick(view);
                }
                if (e.this.isShowing()) {
                    e.this.dismiss();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public e(@NonNull Context context, ArrayList<com.tencent.qqnt.pluspanel.data.a> arrayList, View.OnClickListener onClickListener) {
        super(context, R.style.f173448dl);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, arrayList, onClickListener);
            return;
        }
        this.F = new boolean[2];
        initWindow();
        setContentView(R.layout.e3i);
        this.H = arrayList;
        this.I = onClickListener;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById(R.id.f66733bf);
        this.G = qUSHalfScreenFloatingView;
        S();
        qUSHalfScreenFloatingView.setQUSDragFloatController(new a());
        qUSHalfScreenFloatingView.j(new b());
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.qqnt.pluspanel.ui.c
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                e.this.dismiss();
            }
        });
    }

    private void S() {
        for (int i3 = 0; i3 < this.G.getChildCount(); i3++) {
            View childAt = this.G.getChildAt(i3);
            if (childAt instanceof LinearLayout) {
                View childAt2 = ((LinearLayout) childAt).getChildAt(0);
                childAt2.setBackgroundResource(R.drawable.k0l);
                childAt2.setOnClickListener(new c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean U(View view) {
        return false;
    }

    private boolean W(@NonNull MotionEvent motionEvent) {
        Activity X = X(getContext());
        if (X != null && X.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    private static Activity X(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        return X(((ContextWrapper) context).getBaseContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        com.tencent.qqnt.pluspanel.adapter.d dVar = new com.tencent.qqnt.pluspanel.adapter.d(new d(), new View.OnLongClickListener() { // from class: com.tencent.qqnt.pluspanel.ui.d
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean U;
                U = e.U(view);
                return U;
            }
        }, "em_group_panel_application");
        dVar.p0(this.H);
        dVar.q0(false);
        RecyclerView recyclerView = new RecyclerView(getContext());
        this.D = recyclerView;
        recyclerView.setAdapter(dVar);
        this.D.setLayoutManager(new GridLayoutManager(getContext(), 4));
        this.D.addItemDecoration(new f(this.C));
        this.C.addView(this.D);
    }

    private void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        window.setDimAmount(0.1f);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("MoreAppFloatingDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (super.onTouchEvent(motionEvent) || W(motionEvent)) {
            return true;
        }
        return false;
    }
}
