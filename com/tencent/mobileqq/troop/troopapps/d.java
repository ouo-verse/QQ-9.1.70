package com.tencent.mobileqq.troop.troopapps;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopapps.AddTroopAppCgi;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.r;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d extends b implements View.OnClickListener, AddTroopAppCgi.c {
    static IPatchRedirector $redirector_;
    protected TroopAppShortcutContainer.e F;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ImageView f299417a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f299418b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f299419c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f299420d;

        /* renamed from: e, reason: collision with root package name */
        public Button f299421e;

        /* renamed from: f, reason: collision with root package name */
        public RelativeLayout f299422f;

        /* renamed from: g, reason: collision with root package name */
        public List<ImageView> f299423g;

        /* renamed from: h, reason: collision with root package name */
        public RelativeLayout f299424h;

        /* renamed from: i, reason: collision with root package name */
        public List<TextView> f299425i;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, Activity activity, TroopAppShortcutContainer troopAppShortcutContainer, Bundle bundle) {
        super(context, activity, troopAppShortcutContainer, bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, activity, troopAppShortcutContainer, bundle);
        } else {
            this.F = new TroopAppShortcutContainer.e();
        }
    }

    private String g(int i3) {
        if (i3 > 100000000) {
            return String.valueOf(i3 / 100000000) + "\u4ebf";
        }
        if (i3 > 10000) {
            return String.valueOf(i3 / 10000) + "\u4e07";
        }
        return String.valueOf(i3);
    }

    private GradientDrawable h() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(34.0f);
        gradientDrawable.setColor(this.f299406i.getColorStateList(R.color.qui_common_bg_bottom_standard));
        return gradientDrawable;
    }

    private void i(a aVar, int i3) {
        if (this.D) {
            if (this.F.f299343k) {
                aVar.f299421e.setEnabled(false);
            } else {
                aVar.f299421e.setEnabled(true);
                aVar.f299421e.setText(this.f299406i.getResources().getString(R.string.f2068959j));
            }
        } else {
            aVar.f299421e.setEnabled(true);
            aVar.f299421e.setText(this.f299406i.getResources().getString(R.string.f2069759r));
        }
        aVar.f299421e.setVisibility(0);
        aVar.f299421e.setClickable(true);
        aVar.f299421e.setOnClickListener(this);
        o(aVar.f299421e, aVar.f299418b.getText().toString(), aVar.f299421e.getText().toString(), i3);
    }

    private void j(a aVar) {
        int size = this.F.f299350r.size();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.f299419c.getLayoutParams();
        if (size > 0) {
            layoutParams.leftMargin = BaseAIOUtils.f(-21.0f, aVar.f299419c.getResources());
            aVar.f299419c.setLayoutParams(layoutParams);
            TextView textView = aVar.f299419c;
            textView.setPadding(BaseAIOUtils.f(19.0f, textView.getResources()), 0, BaseAIOUtils.f(7.0f, aVar.f299419c.getResources()), 0);
            aVar.f299422f.setVisibility(0);
            for (int i3 = 0; i3 < aVar.f299423g.size(); i3++) {
                if (i3 >= size) {
                    aVar.f299423g.get(i3).setVisibility(8);
                } else {
                    String str = this.F.f299350r.get(i3);
                    if (!TextUtils.isEmpty(str) && TroopUtils.f() != null) {
                        Drawable defaultFaceDrawable = BaseImageUtil.getDefaultFaceDrawable(true);
                        FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(TroopUtils.f(), 1, str, 4, defaultFaceDrawable, defaultFaceDrawable);
                        Drawable drawable = aVar.f299423g.get(i3).getDrawable();
                        if (drawable != null && drawable != faceDrawable && (drawable instanceof FaceDrawable)) {
                            ((FaceDrawable) drawable).cancel();
                        }
                        aVar.f299423g.get(i3).setImageDrawable(faceDrawable);
                        aVar.f299423g.get(i3).setVisibility(0);
                    } else {
                        aVar.f299423g.get(i3).setImageDrawable(BaseImageUtil.getDefaultFaceDrawable(true));
                        aVar.f299423g.get(i3).setVisibility(0);
                    }
                }
            }
            return;
        }
        layoutParams.leftMargin = BaseAIOUtils.f(0.0f, aVar.f299419c.getResources());
        aVar.f299419c.setLayoutParams(layoutParams);
        TextView textView2 = aVar.f299419c;
        textView2.setPadding(BaseAIOUtils.f(7.0f, textView2.getResources()), 0, BaseAIOUtils.f(7.0f, aVar.f299419c.getResources()), 0);
        aVar.f299422f.setVisibility(8);
    }

    private void k(a aVar) {
        TroopAppShortcutContainer.e eVar = this.F;
        int i3 = eVar.f299347o;
        if (i3 <= 0 && eVar.f299348p <= 0 && eVar.f299349q <= 0) {
            aVar.f299419c.setVisibility(8);
            return;
        }
        if (i3 > 0) {
            aVar.f299419c.setText(String.format(this.f299406i.getResources().getString(R.string.f2069859s).replace("$COUNT", g(this.F.f299347o)), new Object[0]));
        } else if (eVar.f299348p > 0) {
            aVar.f299419c.setText(String.format(this.f299406i.getResources().getString(R.string.f2069059k).replace("$COUNT", g(this.F.f299348p)), new Object[0]));
        } else if (eVar.f299349q > 0) {
            aVar.f299419c.setText(String.format(this.f299406i.getResources().getString(R.string.f2069959t).replace("$COUNT", g(this.F.f299349q)), new Object[0]));
        }
        aVar.f299419c.setVisibility(0);
        aVar.f299419c.setBackground(h());
        aVar.f299419c.setTextColor(this.f299406i.getColorStateList(R.color.qui_common_text_secondary));
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x001d, code lost:
    
        if (r0 > 1) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        if (r0 > 2) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        r0 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l(a aVar) {
        int i3;
        int size = this.F.f299351s.size();
        TroopAppShortcutContainer.e eVar = this.F;
        if (eVar.f299347o <= 0 && eVar.f299348p <= 0 && eVar.f299349q <= 0) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        if (size > 0) {
            for (int i16 = 0; i16 < aVar.f299425i.size(); i16++) {
                if (i16 >= size) {
                    aVar.f299425i.get(i16).setVisibility(8);
                } else {
                    aVar.f299425i.get(i16).setText(this.F.f299351s.get(i16));
                    aVar.f299425i.get(i16).setVisibility(0);
                    aVar.f299425i.get(i16).setTextColor(this.f299406i.getColorStateList(R.color.qui_common_text_secondary));
                    aVar.f299425i.get(i16).setBackgroundDrawable(h());
                }
            }
            return;
        }
        aVar.f299424h.setVisibility(8);
    }

    private void m(View view) {
        ReportController.o(null, "dc00898", "", String.valueOf(this.f299402d), "0X800AFBE", "0X800AFBE", 0, 0, String.valueOf(this.f299403e), String.valueOf(this.F.f299336d), "", this.F.f299345m);
        if (!r.h(TroopUtils.f(), this.f299402d)) {
            QQToast.makeText(this.f299407m, 1, this.f299406i.getString(R.string.f2069459o), 0).show();
            return;
        }
        String valueOf = String.valueOf(this.f299402d);
        TroopAppShortcutContainer.e eVar = this.F;
        new AddTroopAppCgi(this, valueOf, eVar.f299336d, eVar.f299335c, false, eVar).g(TroopUtils.f());
        if (QLog.isColorLevel()) {
            QLog.d("AppsRecommendViewBuilder", 2, "onClickAdd mTroopUin:" + this.f299402d + " append_appid:" + this.F.f299336d);
        }
    }

    private void n(View view) {
        QQAppInterface f16 = TroopUtils.f();
        Context context = this.f299406i;
        Activity activity = this.f299407m;
        String valueOf = String.valueOf(this.f299402d);
        TroopAppShortcutContainer.e eVar = this.F;
        r.e(f16, context, activity, valueOf, eVar.f299336d, eVar.f299339g, 1, 0, false);
        ReportController.o(null, "dc00898", "", String.valueOf(this.f299402d), "0X800AFBD", "0X800AFBD", 0, 0, String.valueOf(this.f299403e), String.valueOf(this.F.f299336d), "", this.F.f299345m);
    }

    private static void o(View view, String str, String str2, int i3) {
        VideoReport.setElementId(view, "em_group_app_add_btn");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementParam(view, "app_name", str);
        VideoReport.setElementParam(view, "btn_content", str2);
        VideoReport.setElementParam(view, "rank", String.valueOf(i3));
    }

    private static void p(View view, TroopAppShortcutContainer.e eVar, int i3) {
        VideoReport.setElementId(view, "em_group_plus_application");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementParam(view, "app_name", eVar.f299337e);
        VideoReport.setElementParam(view, "group_app_type", "hot");
        VideoReport.setElementParam(view, "rank", String.valueOf(i3));
        VideoReport.setElementParam(view, "appid", String.valueOf(eVar.f299336d));
    }

    @Override // com.tencent.mobileqq.troop.troopapps.AddTroopAppCgi.c
    public void a(Object obj) {
        int indexOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, obj);
            return;
        }
        if (obj != null && (obj instanceof TroopAppShortcutContainer.e)) {
            TroopAppShortcutContainer.e eVar = (TroopAppShortcutContainer.e) obj;
            j jVar = (j) TroopUtils.f().getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
            if (jVar != null) {
                ArrayList<TroopAppShortcutContainer.e> b16 = jVar.b(this.f299402d);
                if (b16 != null && !b16.contains(eVar)) {
                    b16.add(eVar);
                    this.f299405h.V(TroopAppShortCutUpdateSource.AddTroopRecommendApp);
                }
                ArrayList<TroopAppShortcutContainer.e> c16 = jVar.c(this.f299402d);
                if (c16 != null && (indexOf = c16.indexOf(eVar)) >= 0 && indexOf < c16.size()) {
                    c16.get(indexOf).f299343k = true;
                    this.f299405h.W();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.AddTroopAppCgi.c
    public void b(int i3, String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), str, obj);
            return;
        }
        QLog.e("AppsRecommendViewBuilder", 1, "add appid retCode: ", Integer.valueOf(i3));
        if (i3 == 41005) {
            int k3 = this.f299405h.k();
            if (k3 > 0) {
                QQToast.makeText(this.f299407m, 1, this.f299406i.getString(R.string.f2069659q).replace("$COUNT", String.valueOf(k3)), 0).show();
                return;
            } else {
                QQToast.makeText(this.f299407m, 1, this.f299406i.getString(R.string.f2069559p), 0).show();
                return;
            }
        }
        QQToast.makeText(this.f299407m, 1, this.f299406i.getString(R.string.f2069459o), 0).show();
    }

    @Override // com.tencent.mobileqq.troop.troopapps.b
    public Object c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.F;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.b
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.b
    public View e(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), view, viewGroup);
        }
        if (view == null) {
            a aVar2 = new a();
            View inflate = LayoutInflater.from(this.f299406i).inflate(R.layout.f168547fv2, viewGroup, false);
            aVar2.f299417a = (ImageView) inflate.findViewById(R.id.f164379vi);
            aVar2.f299418b = (TextView) inflate.findViewById(R.id.f164389w0);
            aVar2.f299419c = (TextView) inflate.findViewById(R.id.str);
            aVar2.f299420d = (TextView) inflate.findViewById(R.id.f164378vg);
            aVar2.f299421e = (Button) inflate.findViewById(R.id.sqg);
            aVar2.f299423g = new ArrayList();
            aVar2.f299422f = (RelativeLayout) inflate.findViewById(R.id.f164391su0);
            for (int i16 = 0; i16 < aVar2.f299422f.getChildCount(); i16++) {
                ImageView imageView = (ImageView) aVar2.f299422f.getChildAt(i16);
                imageView.setVisibility(8);
                aVar2.f299423g.add(imageView);
            }
            aVar2.f299425i = new ArrayList();
            aVar2.f299424h = (RelativeLayout) inflate.findViewById(R.id.jbc);
            for (int i17 = 0; i17 < aVar2.f299424h.getChildCount(); i17++) {
                TextView textView = (TextView) aVar2.f299424h.getChildAt(i17);
                textView.setVisibility(8);
                aVar2.f299425i.add(textView);
            }
            inflate.setTag(aVar2);
            aVar = aVar2;
            view = inflate;
        } else {
            aVar = (a) view.getTag();
        }
        view.setClickable(true);
        view.setOnClickListener(this);
        Context context = this.f299406i;
        ImageView imageView2 = aVar.f299417a;
        TroopAppShortcutContainer.e eVar = this.F;
        String str = eVar.f299338f;
        if (eVar.f299346n == 1) {
            z16 = true;
        }
        r.l(context, imageView2, str, 48.0f, z16);
        j(aVar);
        k(aVar);
        l(aVar);
        aVar.f299418b.setText(this.F.f299337e);
        aVar.f299420d.setText(this.F.f299342j);
        i(aVar, i3);
        p(view, this.F, i3);
        return view;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.b
    public void f(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj);
        } else if (obj instanceof TroopAppShortcutContainer.e) {
            this.F = (TroopAppShortcutContainer.e) obj;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.f164392su1) {
                n(view);
            } else if (id5 == R.id.sqg) {
                if (this.D) {
                    m(view);
                } else {
                    n(view);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
