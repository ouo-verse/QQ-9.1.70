package com.tencent.mobileqq.mutualmark.widget.detailcard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.mutualmark.widget.detailcard.b;
import com.tencent.mobileqq.mutualmark.widget.detailcard.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.u;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Context f252415a;

    /* renamed from: b, reason: collision with root package name */
    private final View f252416b;

    /* renamed from: c, reason: collision with root package name */
    private RelativeLayout f252417c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f252418d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f252419e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f252420f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f252421g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f252422h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f252423i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f252424j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f252425k;

    /* renamed from: l, reason: collision with root package name */
    private h f252426l;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.mutualmark.widget.detailcard.b f252427m;

    /* renamed from: n, reason: collision with root package name */
    public com.tencent.mobileqq.mutualmark.widget.util.a f252428n;

    /* renamed from: o, reason: collision with root package name */
    private com.tencent.mobileqq.mutualmark.widget.util.d f252429o;

    /* renamed from: p, reason: collision with root package name */
    private MutualMarkModel f252430p;

    /* renamed from: q, reason: collision with root package name */
    private MutualMarkDetailListHelper f252431q;

    /* renamed from: r, reason: collision with root package name */
    private b.d f252432r;

    /* renamed from: s, reason: collision with root package name */
    b.d f252433s;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements h.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MutualMarkModel f252434a;

        a(MutualMarkModel mutualMarkModel) {
            this.f252434a = mutualMarkModel;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this, (Object) mutualMarkModel);
            }
        }

        @Override // com.tencent.mobileqq.mutualmark.widget.detailcard.h.a
        public void onClick(int i3) {
            List<MutualMarkModel.Graded> list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            MutualMarkModel mutualMarkModel = this.f252434a;
            if (mutualMarkModel != null && (list = mutualMarkModel.Y) != null && i3 >= 0 && i3 < list.size()) {
                this.f252434a.f252156d = i3;
                i.this.f252424j.setText(this.f252434a.Y.get(i3).f252169e);
                ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).setDescProgressThresholdTextView(i.this.f252425k, this.f252434a, i3);
                ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).setProgressIconWithModel(i.this.f252419e, this.f252434a, i3, null);
                i.this.o(this.f252434a, Integer.valueOf(i3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements b.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // com.tencent.mobileqq.mutualmark.widget.detailcard.b.d
        public boolean a(View view, String str, MutualMarkModel.Button button, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, view, str, button, Integer.valueOf(i3))).booleanValue();
            }
            if (u.a().b()) {
                return true;
            }
            if (i.this.f252432r != null && i.this.f252432r.a(view, str, button, i3)) {
                return true;
            }
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).jumpUrl(i.this.f252415a, str);
            i iVar = i.this;
            iVar.p(iVar.f252430p, button, i3);
            if (i.this.u(str) && i.this.f252431q != null) {
                i.this.f252431q.l(i.this.f252415a);
            }
            return true;
        }

        @Override // com.tencent.mobileqq.mutualmark.widget.detailcard.b.d
        public boolean b(View view, String str, MutualMarkModel.Button button, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, view, str, button, Integer.valueOf(i3))).booleanValue();
            }
            if (u.a().b()) {
                return true;
            }
            if (i.this.f252432r != null && i.this.f252432r.b(view, str, button, i3)) {
                return true;
            }
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).jumpUrl(i.this.f252415a, str);
            i iVar = i.this;
            iVar.p(iVar.f252430p, button, i3);
            if (i.this.u(str) && i.this.f252431q != null) {
                i.this.f252431q.l(i.this.f252415a);
            }
            return true;
        }
    }

    public i(Context context, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) view);
            return;
        }
        this.f252428n = new com.tencent.mobileqq.mutualmark.widget.util.a();
        this.f252430p = null;
        this.f252431q = null;
        this.f252432r = null;
        this.f252433s = new b();
        this.f252415a = context;
        this.f252416b = view;
        this.f252417c = (RelativeLayout) view.findViewById(R.id.zku);
        this.f252418d = (ImageView) view.findViewById(R.id.zkt);
        this.f252419e = (ImageView) view.findViewById(R.id.zkv);
        this.f252420f = (ImageView) view.findViewById(R.id.zl_);
        this.f252421g = (ImageView) view.findViewById(R.id.zl9);
        this.f252422h = (ImageView) view.findViewById(R.id.f166369zl3);
        this.f252423i = (ImageView) view.findViewById(R.id.f166370zl4);
        this.f252424j = (TextView) view.findViewById(R.id.zl7);
        this.f252425k = (TextView) view.findViewById(R.id.zla);
        this.f252426l = new h((LinearLayout) view.findViewById(R.id.zl8));
        this.f252427m = new com.tencent.mobileqq.mutualmark.widget.detailcard.b(view);
        if (QQTheme.isNowThemeIsNight()) {
            this.f252422h.setAlpha(0.5f);
            this.f252423i.setAlpha(0.5f);
        }
    }

    private void l(List<MutualMarkModel.Button> list) {
        this.f252427m.n(list).k(this.f252433s);
    }

    private void m() {
        Resources resources;
        com.tencent.mobileqq.mutualmark.model.b cardResource = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getCardResource(0);
        if (cardResource == null || (resources = this.f252416b.getResources()) == null) {
            return;
        }
        this.f252417c.setBackground(resources.getDrawable(R.drawable.ksr, null));
        this.f252418d.setVisibility(0);
        this.f252422h.setVisibility(8);
        this.f252423i.setImageDrawable(com.tencent.mobileqq.mutualmark.widget.util.f.a(cardResource.f252174b));
        com.tencent.mobileqq.mutualmark.widget.util.d dVar = this.f252429o;
        if (dVar != null) {
            dVar.l();
        }
        this.f252424j.setTextColor(resources.getColor(R.color.qui_common_text_primary, null));
        this.f252425k.setTextColor(resources.getColor(R.color.qui_common_text_secondary, null));
        TextView textView = (TextView) this.f252416b.findViewById(R.id.f166368zl2);
        if (textView != null) {
            textView.setTextColor(resources.getColor(R.color.qui_common_text_secondary, null));
            textView.setBackground(resources.getDrawable(R.drawable.ksl, null));
        }
        this.f252427m.i();
    }

    private void n() {
        com.tencent.mobileqq.mutualmark.model.b cardResource = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getCardResource(1);
        if (cardResource != null) {
            Resources resources = this.f252416b.getResources();
            if (resources != null) {
                RelativeLayout relativeLayout = this.f252417c;
                relativeLayout.setBackground(com.tencent.mobileqq.mutualmark.widget.util.f.c(cardResource.f252175c, null, relativeLayout.getBackground(), resources.getDrawable(R.drawable.ksr)));
            }
            this.f252418d.setVisibility(8);
            this.f252422h.setImageDrawable(com.tencent.mobileqq.mutualmark.widget.util.f.a(cardResource.f252174b));
            this.f252423i.setImageDrawable(com.tencent.mobileqq.mutualmark.widget.util.f.a(cardResource.f252174b));
            this.f252420f.setVisibility(0);
            this.f252426l.s(this.f252430p);
            com.tencent.mobileqq.mutualmark.widget.util.d dVar = this.f252429o;
            if (dVar != null) {
                dVar.j("mutual_mark_lottie/star.json");
            }
            this.f252424j.setTextColor(Color.parseColor(cardResource.f252179g.f252183a));
            this.f252425k.setTextColor(Color.parseColor(cardResource.f252180h.f252183a));
            TextView textView = (TextView) this.f252416b.findViewById(R.id.f166368zl2);
            if (textView != null) {
                textView.setTextColor(Color.parseColor(cardResource.f252181i.f252183a));
                if (resources != null) {
                    Drawable drawable = resources.getDrawable(R.drawable.ksm, null);
                    drawable.setTint(Color.parseColor(cardResource.f252181i.f252184b));
                    textView.setBackground(drawable);
                }
            }
            this.f252427m.l(Color.parseColor(cardResource.f252182j.f252183a), Color.parseColor(cardResource.f252182j.f252184b), cardResource.f252178f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(MutualMarkModel mutualMarkModel, Integer num) {
        List<MutualMarkModel.Graded> list;
        TextView textView = (TextView) this.f252416b.findViewById(R.id.f166368zl2);
        TextView textView2 = (TextView) this.f252416b.findViewById(R.id.f166367zl1);
        Resources resources = this.f252416b.getResources();
        if (num != null && (list = mutualMarkModel.Y) != null && list.size() > num.intValue() && mutualMarkModel.Y.get(num.intValue()).f252168d > mutualMarkModel.H) {
            textView2.setVisibility(8);
            textView.setVisibility(0);
            textView.setText(HardCodeUtil.qqStr(R.string.f158701qb));
            return;
        }
        if (mutualMarkModel.J > 0) {
            textView2.setVisibility(8);
            textView.setVisibility(0);
            textView.setText(HardCodeUtil.qqStr(R.string.f158691qa) + mutualMarkModel.J + "\u4e2a");
            return;
        }
        if (mutualMarkModel.R) {
            textView2.setVisibility(8);
            textView.setVisibility(0);
            textView.setBackgroundResource(R.drawable.ksn);
            textView.getBackground().setAlpha(25);
            if (resources != null) {
                textView.setTextColor(resources.getColor(R.color.qui_common_feedback_error, null));
            }
            textView.setText(HardCodeUtil.qqStr(R.string.f169976yj1));
            return;
        }
        if (mutualMarkModel.M) {
            textView2.setVisibility(8);
            textView.setVisibility(0);
            textView.setText(HardCodeUtil.qqStr(R.string.f158711qc));
        } else if (mutualMarkModel.N) {
            textView2.setVisibility(8);
            textView.setVisibility(0);
            textView.setText(HardCodeUtil.qqStr(R.string.f158691qa));
        } else if (mutualMarkModel.T) {
            textView2.setVisibility(0);
            textView.setVisibility(8);
        } else {
            textView2.setVisibility(8);
            textView.setVisibility(0);
            textView.setText(HardCodeUtil.qqStr(R.string.f158701qb));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(MutualMarkModel mutualMarkModel, MutualMarkModel.Button button, int i3) {
        String str;
        if (mutualMarkModel != null && button != null) {
            HashMap<String, Object> pgTagProfileData = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagProfileData();
            String str2 = "NULL";
            if (i3 != 0) {
                str = "NULL";
            } else {
                str = button.f252163e;
            }
            pgTagProfileData.put("interact_tag_profile_bottom_text_one", str);
            if (i3 == 1) {
                str2 = button.f252163e;
            }
            pgTagProfileData.put("interact_tag_profile_bottom_text_second", str2);
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_clck", "pg_tag_detail", "em_interact_tag_profile_bottom", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagDetailData(), pgTagProfileData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(String str) {
        if (!TextUtils.isEmpty(str) && (str.contains("mqqapi://mutualmark/wear") || str.contains("mqqapi://mutualmark/unwear") || str.contains("mqqapi://mutualmark/poke"))) {
            return false;
        }
        return true;
    }

    public com.tencent.mobileqq.mutualmark.widget.detailcard.b k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.mutualmark.widget.detailcard.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f252427m;
    }

    public void q(MutualMarkModel mutualMarkModel) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) mutualMarkModel);
            return;
        }
        if (mutualMarkModel == null) {
            return;
        }
        MutualMarkModel mutualMarkModel2 = this.f252430p;
        if (mutualMarkModel2 != null && mutualMarkModel2.D == mutualMarkModel.D) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f252430p = mutualMarkModel;
        l(mutualMarkModel.Z);
        this.f252426l.s(mutualMarkModel).q(new a(mutualMarkModel));
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).setIconWithModel(this.f252419e, mutualMarkModel, z16, null);
        if (mutualMarkModel.R) {
            this.f252419e.setAlpha(0.5f);
        } else {
            this.f252419e.setAlpha(1.0f);
        }
        if (!TextUtils.isEmpty(mutualMarkModel.f252160i)) {
            this.f252420f.setVisibility(0);
            this.f252420f.setImageDrawable(com.tencent.mobileqq.mutualmark.widget.util.f.a(mutualMarkModel.f252160i));
        } else {
            this.f252420f.setVisibility(8);
        }
        if (mutualMarkModel.M) {
            this.f252421g.setVisibility(0);
            this.f252421g.setImageDrawable(com.tencent.mobileqq.mutualmark.widget.util.f.a("https://downv6.qq.com/extendfriend/mutual_tag_peidai.png"));
        } else if (mutualMarkModel.S) {
            this.f252421g.setVisibility(0);
            this.f252421g.setImageDrawable(com.tencent.mobileqq.mutualmark.widget.util.f.a("https://downv6.qq.com/extendfriend/mutual_tag_new.png"));
        } else {
            this.f252421g.setVisibility(8);
        }
        this.f252424j.setText(mutualMarkModel.E);
        if (mutualMarkModel.Y != null) {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).setDescThresholdTextView(this.f252425k, mutualMarkModel);
        }
        int i3 = mutualMarkModel.G;
        if (i3 != 0) {
            if (i3 == 1) {
                n();
            }
        } else {
            m();
        }
        o(mutualMarkModel, null);
    }

    public void r(MutualMarkDetailListHelper mutualMarkDetailListHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) mutualMarkDetailListHelper);
        } else {
            this.f252431q = mutualMarkDetailListHelper;
        }
    }

    public void s(com.tencent.mobileqq.mutualmark.widget.util.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
        } else {
            this.f252429o = dVar;
        }
    }

    public void t(b.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dVar);
        } else {
            this.f252432r = dVar;
        }
    }
}
