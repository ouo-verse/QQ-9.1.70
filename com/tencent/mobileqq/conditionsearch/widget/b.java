package com.tencent.mobileqq.conditionsearch.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.InterestLabelTextView;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenTitleBarHeaderView;
import com.tencent.mobileqq.widget.qus.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends ReportDialog implements AdapterView.OnItemClickListener {
    static IPatchRedirector $redirector_;
    private static final String J;
    private static final int K;
    private final QUSHalfScreenFloatingView C;
    private FrameLayout D;
    private ListView E;
    private C7468b F;
    private int G;
    private c H;
    private Context I;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float f16, float f17) {
            View childAt;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            if (b.this.E == null) {
                return false;
            }
            if (b.this.E.getFirstVisiblePosition() != 0 || (childAt = b.this.E.getChildAt(0)) == null || childAt.getTop() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            if (b.this.E == null) {
                return false;
            }
            if (b.this.E.getLastVisiblePosition() != b.this.E.getChildCount() - 1) {
                return true;
            }
            View childAt = b.this.E.getChildAt(b.this.E.getChildCount() - 1);
            if (childAt != null && childAt.getBottom() == b.this.E.getHeight()) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF57419d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (View) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            b.this.D = new FrameLayout(b.this.getContext());
            b.this.D.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            b.this.D.setBackgroundResource(R.drawable.b4k);
            b.this.initView();
            return b.this.D;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            b bVar = b.this;
            return bVar.X(750.0f, bVar.I.getResources());
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.conditionsearch.widget.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C7468b extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final String[] f202044d;

        /* renamed from: e, reason: collision with root package name */
        private final String[] f202045e;

        /* renamed from: f, reason: collision with root package name */
        private final int[] f202046f;

        C7468b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                return;
            }
            this.f202044d = ConditionSearchManager.f194488p0;
            this.f202045e = ConditionSearchManager.f194489q0;
            this.f202046f = ConditionSearchManager.f194490r0;
        }

        private void a(int i3, d dVar) {
            if (i3 < this.f202044d.length - 1) {
                dVar.f202048a.setVisibility(0);
            } else {
                dVar.f202048a.setVisibility(4);
            }
            if (i3 == 0) {
                dVar.f202048a.setVisibility(4);
            }
            dVar.f202049b.setText(this.f202044d[i3]);
            if (b.this.G == i3) {
                dVar.f202050c.setVisibility(0);
            } else {
                dVar.f202050c.setVisibility(4);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f202044d.length - 2;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return this.f202044d[b.this.a0(i3)];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = b.this.getLayoutInflater().inflate(R.layout.gw_, viewGroup, false);
                    d dVar = new d();
                    dVar.f202048a = (InterestLabelTextView) view.findViewById(R.id.f166942ja3);
                    dVar.f202049b = (TextView) view.findViewById(R.id.f5e);
                    dVar.f202050c = (ImageView) view.findViewById(R.id.ax4);
                    view.setTag(dVar);
                }
                d dVar2 = (d) view.getTag();
                int a06 = b.this.a0(i3);
                if (b.this.I != null && b.this.I.getResources() != null) {
                    Drawable drawable = b.this.I.getResources().getDrawable(this.f202046f[a06]);
                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                    if (runtime instanceof AppInterface) {
                        ProfileCardUtils.setNightModeFilterForDrawable((AppInterface) runtime, drawable);
                    }
                    dVar2.f202048a.setText(this.f202045e[a06]);
                    dVar2.f202048a.setBackgroundDrawable(drawable);
                    int f16 = BaseAIOUtils.f(4.0f, b.this.I.getResources());
                    dVar2.f202048a.setPadding(f16, 0, f16, 0);
                }
                a(a06, dVar2);
                if (b.this.G == a06) {
                    view.setContentDescription(HardCodeUtil.qqStr(R.string.znb) + "," + dVar2.f202048a.getText().toString() + "," + dVar2.f202049b.getText().toString());
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void onUpdate(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public InterestLabelTextView f202048a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f202049b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f202050c;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71293);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            J = HardCodeUtil.qqStr(R.string.f170770zn1);
            K = Color.parseColor("#FF808080");
        }
    }

    public b(@NonNull Context context, int i3, c cVar) {
        super(context, R.style.f173448dl);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), cVar);
            return;
        }
        initWindow();
        setContentView(R.layout.e3i);
        this.I = context;
        this.G = i3;
        this.H = cVar;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById(R.id.f66733bf);
        this.C = qUSHalfScreenFloatingView;
        qUSHalfScreenFloatingView.setQUSDragFloatController(new a());
        Y();
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.conditionsearch.widget.a
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                b.this.Z();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int X(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    private void Y() {
        QUSHalfScreenTitleBarHeaderView qUSHalfScreenTitleBarHeaderView = new QUSHalfScreenTitleBarHeaderView(getContext());
        qUSHalfScreenTitleBarHeaderView.setTitle(J);
        qUSHalfScreenTitleBarHeaderView.setHalfScreenView(this.C);
        this.C.setHeaderView(qUSHalfScreenTitleBarHeaderView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z() {
        try {
            dismiss();
        } catch (Exception e16) {
            QLog.e("JobHalfScreenFloatingDialog", 1, e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        this.F = new C7468b();
        ListView listView = new ListView(getContext());
        this.E = listView;
        listView.setAdapter((ListAdapter) this.F);
        this.E.setDivider(new ColorDrawable(K));
        this.E.setOnItemClickListener(this);
        this.D.addView(this.E);
    }

    private void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("JobHalfScreenFloatingDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    int a0(int i3) {
        if (i3 >= ConditionSearchManager.f194492t0[0]) {
            return i3 + 2;
        }
        return i3;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            this.G = a0(i3);
            this.F.notifyDataSetChanged();
            c cVar = this.H;
            if (cVar != null) {
                cVar.onUpdate(this.G);
            }
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime != null) {
                ReportController.o(runtime, "CliOper", "", "", "0X8006F0A", "0X8006F0A", 0, 0, this.G + "", "", "", "");
            }
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.C;
            if (qUSHalfScreenFloatingView != null) {
                try {
                    qUSHalfScreenFloatingView.t();
                } catch (Exception e16) {
                    QLog.e("JobHalfScreenFloatingDialog", 1, "mQusHalfScreenFloatingView.dismissWithAnimation error:" + e16.getMessage());
                }
            }
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }
}
