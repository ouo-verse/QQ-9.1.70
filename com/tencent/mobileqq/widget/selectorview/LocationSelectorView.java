package com.tencent.mobileqq.widget.selectorview;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.mobileqq.widget.selectorview.h;
import com.tencent.mobileqq.widget.selectorview.model.BaseAddress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class LocationSelectorView {

    /* renamed from: a, reason: collision with root package name */
    public Context f317312a;

    /* renamed from: b, reason: collision with root package name */
    public Activity f317313b;

    /* renamed from: c, reason: collision with root package name */
    public BaseQQAppInterface f317314c;

    /* renamed from: d, reason: collision with root package name */
    public QActionSheet f317315d;

    /* renamed from: e, reason: collision with root package name */
    private String f317316e;

    /* renamed from: f, reason: collision with root package name */
    private String f317317f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f317318g;

    /* renamed from: h, reason: collision with root package name */
    private String f317319h;

    /* renamed from: i, reason: collision with root package name */
    private List<BaseAddress> f317320i;

    /* renamed from: j, reason: collision with root package name */
    private BaseAddress f317321j;

    /* renamed from: k, reason: collision with root package name */
    private View f317322k;

    /* renamed from: l, reason: collision with root package name */
    private View f317323l;

    /* renamed from: m, reason: collision with root package name */
    private View f317324m;

    /* renamed from: n, reason: collision with root package name */
    private View f317325n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f317326o;

    /* renamed from: p, reason: collision with root package name */
    private TextView f317327p;

    /* renamed from: q, reason: collision with root package name */
    private TextView f317328q;

    /* renamed from: r, reason: collision with root package name */
    private ImageView f317329r;

    /* renamed from: s, reason: collision with root package name */
    private ProvinceSelectorView f317330s;

    /* renamed from: t, reason: collision with root package name */
    private h.b f317331t;

    /* renamed from: u, reason: collision with root package name */
    private long f317332u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f317333v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f317334w;

    /* renamed from: x, reason: collision with root package name */
    private g f317335x;

    /* renamed from: y, reason: collision with root package name */
    private e f317336y;

    /* renamed from: z, reason: collision with root package name */
    f f317337z = new f() { // from class: com.tencent.mobileqq.widget.selectorview.LocationSelectorView.1
        @Override // com.tencent.mobileqq.widget.selectorview.LocationSelectorView.f
        public void onGetUserLocation(final boolean z16, final String[] strArr, boolean z17) {
            QActionSheet qActionSheet = LocationSelectorView.this.f317315d;
            if (qActionSheet != null && z17 && !qActionSheet.isShowing()) {
                LocationSelectorView.this.f317315d.show();
            }
            if (Math.abs(System.currentTimeMillis() - LocationSelectorView.this.f317332u) > 1200) {
                if (LocationSelectorView.this.f317335x != null) {
                    LocationSelectorView.this.f317335x.a(z16, strArr);
                    LocationSelectorView.this.f317335x.onConfirm();
                    return;
                }
                return;
            }
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.widget.selectorview.LocationSelectorView.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LocationSelectorView.this.f317335x != null) {
                        LocationSelectorView.this.f317335x.a(z16, strArr);
                        LocationSelectorView.this.f317335x.onConfirm();
                    }
                }
            }, 16, null, false, 1200L);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!u.a().b()) {
                LocationSelectorView.this.v();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!u.a().b()) {
                LocationSelectorView locationSelectorView = LocationSelectorView.this;
                com.tencent.mobileqq.widget.selectorview.c cVar = new com.tencent.mobileqq.widget.selectorview.c(locationSelectorView.f317312a, locationSelectorView.f317319h, LocationSelectorView.this.f317333v, LocationSelectorView.this.f317320i);
                cVar.p0(LocationSelectorView.this.f317337z);
                cVar.show();
                LocationSelectorView.this.f317315d.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface e {
        void a();

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface f {
        void onGetUserLocation(boolean z16, String[] strArr, boolean z17);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface g {
        void a(boolean z16, String[] strArr);

        void onConfirm();
    }

    public LocationSelectorView(BaseAddress baseAddress, List<BaseAddress> list, boolean z16, boolean z17) {
        this.f317319h = "1";
        this.f317333v = false;
        this.f317334w = false;
        this.f317321j = baseAddress;
        if (baseAddress != null) {
            this.f317319h = baseAddress.code;
        }
        this.f317320i = list;
        this.f317334w = z16;
        this.f317333v = z17;
    }

    private void C() {
        String str;
        boolean z16;
        ColorStateList colorStateList;
        if (this.f317325n != null && this.f317328q != null && this.f317326o != null) {
            if (IProfileCardConst.NAME_NO_LIMIT.equals(this.f317317f)) {
                str = "";
            } else {
                str = this.f317317f;
            }
            this.f317328q.setText(str);
            BaseAddress baseAddress = this.f317321j;
            if (baseAddress != null && baseAddress.hasProvince) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f317325n.setClickable(z16);
            TextView textView = this.f317326o;
            if (z16) {
                colorStateList = this.f317312a.getResources().getColorStateList(R.color.qui_common_text_primary, null);
            } else {
                colorStateList = this.f317312a.getResources().getColorStateList(R.color.qui_common_text_secondary, null);
            }
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.selectorview.LocationSelectorView.7
            @Override // java.lang.Runnable
            public void run() {
                if (LocationSelectorView.this.f317331t != null) {
                    LocationSelectorView.this.f317331t.dismiss();
                }
            }
        }, 200L);
    }

    private void q() {
        this.f317315d.j0(new d());
    }

    private void r() {
        if (!TextUtils.isEmpty(this.f317316e)) {
            this.f317327p.setText(this.f317316e);
            this.f317327p.setContentDescription(HardCodeUtil.qqStr(R.string.f2040651w) + this.f317316e);
        }
        this.f317324m.setOnClickListener(new b());
    }

    private void s() {
        this.f317323l.setOnClickListener(new a());
    }

    private void t() {
        int i3;
        QActionSheet Y = QActionSheet.Y(this.f317312a, this.f317333v);
        this.f317315d = Y;
        this.f317322k = Y.findViewById(R.id.f62032zq);
        this.f317315d.setTitle(HardCodeUtil.qqStr(R.string.f2040351t));
        View findViewById = this.f317315d.findViewById(R.id.f82364go);
        this.f317323l = findViewById;
        if (this.f317334w) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        this.f317324m = this.f317315d.findViewById(R.id.f82294gh);
        this.f317325n = this.f317315d.findViewById(R.id.f82334gl);
        this.f317326o = (TextView) this.f317315d.findViewById(R.id.f82344gm);
        this.f317327p = (TextView) this.f317315d.findViewById(R.id.f82314gj);
        this.f317328q = (TextView) this.f317315d.findViewById(R.id.f82354gn);
        this.f317329r = (ImageView) this.f317315d.findViewById(R.id.f82324gk);
        s();
        r();
        u();
        q();
        try {
            Activity activity = this.f317313b;
            if (activity != null && !activity.isFinishing()) {
                y();
                this.f317315d.show();
            }
        } catch (Exception e16) {
            QLog.e("ProfileLocationActionSheet", 1, "action sheet show error", e16);
        }
    }

    private void u() {
        this.f317325n.setOnClickListener(new c());
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        ImageView imageView = this.f317329r;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ReportController.o(this.f317314c, "CliOper", "", "", "0X8004246", "0X8004246", 0, 0, "", "", "", "");
        if (this.f317336y != null) {
            this.f317332u = System.currentTimeMillis();
            this.f317336y.a();
        }
    }

    private void w(String[] strArr) {
        if (strArr != null && strArr.length == 4) {
            if (this.f317318g == null) {
                this.f317318g = new String[]{IProfileCardConst.NAME_NO_LIMIT, IProfileCardConst.NAME_NO_LIMIT, IProfileCardConst.NAME_NO_LIMIT};
            }
            System.arraycopy(strArr, 1, this.f317318g, 0, strArr.length - 1);
        }
    }

    private void y() {
        if (this.f317331t == null) {
            this.f317331t = new h.b(this.f317312a);
        }
        this.f317331t.show();
    }

    public void A(BaseAddress baseAddress) {
        if (baseAddress == null) {
            return;
        }
        this.f317321j = baseAddress;
        this.f317319h = baseAddress.code;
    }

    public void B(String[] strArr, String str, String str2) {
        w(strArr);
        this.f317316e = str;
        this.f317317f = str2;
    }

    public void o() {
        ImageView imageView = this.f317329r;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void p(@NonNull Context context, BaseQQAppInterface baseQQAppInterface, g gVar, e eVar) {
        this.f317314c = baseQQAppInterface;
        this.f317312a = context;
        this.f317313b = (Activity) context;
        this.f317335x = gVar;
        this.f317336y = eVar;
    }

    public void x() {
        if (this.f317314c != null && this.f317312a != null && this.f317335x != null) {
            t();
        }
    }

    public void z(String[] strArr, String str, String str2) {
        if (this.f317312a == null) {
            return;
        }
        B(strArr, str, str2);
        TextView textView = this.f317327p;
        if (textView != null) {
            textView.setText(this.f317316e);
        }
        C();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String[] strArr;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!u.a().b()) {
                LocationSelectorView locationSelectorView = LocationSelectorView.this;
                if (locationSelectorView.f317318g != null) {
                    strArr = LocationSelectorView.this.f317318g;
                } else {
                    strArr = new String[]{"0", "0", "0"};
                }
                locationSelectorView.f317318g = strArr;
                if (LocationSelectorView.this.f317330s == null) {
                    LocationSelectorView locationSelectorView2 = LocationSelectorView.this;
                    locationSelectorView2.f317330s = new ProvinceSelectorView(locationSelectorView2.f317313b, locationSelectorView2.f317333v);
                    LocationSelectorView.this.f317330s.k(HardCodeUtil.qqStr(R.string.f2040451u));
                }
                LocationSelectorView.this.f317330s.v(LocationSelectorView.this.f317319h, LocationSelectorView.this.f317318g, LocationSelectorView.this.f317321j);
                if (LocationSelectorView.this.f317330s.e() == null) {
                    LocationSelectorView.this.f317330s.i(new a());
                }
                LocationSelectorView.this.f317330s.m();
                LocationSelectorView.this.f317315d.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* compiled from: P */
        /* loaded from: classes20.dex */
        class a implements QActionSheet.f {
            a() {
            }

            @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
            public void onConfirm() {
                String[] t16 = LocationSelectorView.this.f317330s.t();
                boolean z16 = false;
                if (t16 != null && t16.length > 0) {
                    t16[0] = LocationSelectorView.this.f317319h;
                }
                f fVar = LocationSelectorView.this.f317337z;
                if (t16 != null) {
                    z16 = true;
                }
                fVar.onGetUserLocation(z16, t16, true);
            }

            @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
            public void onDismiss() {
                LocationSelectorView.this.f317337z.onGetUserLocation(false, null, true);
            }

            @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
            public void t() {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements QActionSheet.f {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            LocationSelectorView.this.n();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
            LocationSelectorView.this.n();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }
}
