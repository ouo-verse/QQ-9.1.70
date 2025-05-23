package com.tencent.mobileqq.mutualmark.widget.detailcard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private LinearLayout f252404a;

    /* renamed from: b, reason: collision with root package name */
    private LinearLayout f252405b;

    /* renamed from: c, reason: collision with root package name */
    private MutualMarkModel f252406c;

    /* renamed from: d, reason: collision with root package name */
    private String f252407d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f252408e;

    /* renamed from: f, reason: collision with root package name */
    private int f252409f;

    /* renamed from: g, reason: collision with root package name */
    private long f252410g;

    /* renamed from: h, reason: collision with root package name */
    private a f252411h;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void onClick(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public RelativeLayout f252412a;

        /* renamed from: b, reason: collision with root package name */
        public int f252413b;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }
    }

    public h(LinearLayout linearLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) linearLayout);
        } else {
            this.f252408e = linearLayout;
        }
    }

    private int c() {
        int e16 = e();
        if (e16 <= 1) {
            return 0;
        }
        return (264 - (e16 * 20)) / e16;
    }

    private void d() {
        int c16;
        if (this.f252408e == null || (c16 = c()) < 0) {
            return;
        }
        k();
        int i3 = c16 / 2;
        this.f252404a.addView(f(i3));
        this.f252405b.addView(f(i3));
        int e16 = e() - 1;
        for (int i16 = 0; i16 <= e16; i16++) {
            ImageView g16 = g(i16);
            if (g16 != null) {
                this.f252404a.addView(g16);
                RelativeLayout j3 = j();
                this.f252405b.addView(j3);
                r(g16, j3, i16);
                if (i16 < e16) {
                    this.f252404a.addView(f(c16));
                    RelativeLayout i17 = i(c16, i16);
                    if (i17 != null) {
                        this.f252405b.addView(i17);
                    }
                }
            }
        }
        this.f252404a.addView(f(i3));
        this.f252405b.addView(f(i3));
    }

    private int e() {
        return this.f252409f;
    }

    private RelativeLayout f(int i3) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.width = ViewUtils.dip2px(i3);
        RelativeLayout relativeLayout = new RelativeLayout(this.f252408e.getContext());
        relativeLayout.setLayoutParams(layoutParams);
        return relativeLayout;
    }

    private ImageView g(int i3) {
        ImageView imageView = new ImageView(this.f252408e.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.width = ViewUtils.dip2px(20.0f);
        layoutParams.height = ViewUtils.dip2px(20.0f);
        layoutParams.gravity = 16;
        imageView.setLayoutParams(layoutParams);
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).setProgressIconWithModel(imageView, this.f252406c, i3, null);
        return imageView;
    }

    private RelativeLayout h(int i3) {
        RelativeLayout relativeLayout = new RelativeLayout(this.f252408e.getContext());
        float f16 = i3;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(f16), ViewUtils.dip2px(6.0f));
        layoutParams.gravity = 16;
        relativeLayout.setLayoutParams(layoutParams);
        View relativeLayout2 = new RelativeLayout(this.f252408e.getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(f16), ViewUtils.dip2px(2.0f));
        layoutParams2.addRule(13);
        relativeLayout2.setLayoutParams(layoutParams2);
        relativeLayout2.setBackgroundResource(R.drawable.kso);
        relativeLayout.addView(relativeLayout2);
        return relativeLayout;
    }

    private RelativeLayout i(int i3, int i16) {
        int i17;
        int i18;
        if (this.f252408e != null && this.f252406c != null) {
            if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isIntimateType(this.f252406c.D)) {
                i17 = i16;
            } else {
                i17 = i16 + 1;
            }
            if (i17 > this.f252406c.H) {
                return h(i3);
            }
            Resources resources = this.f252408e.getResources();
            Context context = this.f252408e.getContext();
            if (resources != null && context != null) {
                ProgressBar progressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
                progressBar.setProgressDrawable(resources.getDrawable(R.drawable.ksu, null));
                float f16 = i3;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(f16), ViewUtils.dip2px(2.0f));
                layoutParams.addRule(13);
                progressBar.setLayoutParams(layoutParams);
                List<MutualMarkModel.Graded> list = this.f252406c.Y;
                if (list != null && i16 >= 0 && (i18 = i16 + 1) < list.size()) {
                    progressBar.setMax(this.f252406c.Y.get(i18).f252170f);
                    progressBar.setProgress((int) this.f252406c.L);
                }
                RelativeLayout relativeLayout = new RelativeLayout(this.f252408e.getContext());
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewUtils.dip2px(f16), ViewUtils.dip2px(6.0f));
                layoutParams2.gravity = 16;
                relativeLayout.setLayoutParams(layoutParams2);
                relativeLayout.addView(progressBar);
                return relativeLayout;
            }
        }
        return null;
    }

    private RelativeLayout j() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f252408e.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(20.0f), ViewUtils.dip2px(6.0f));
        layoutParams.gravity = 16;
        relativeLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(this.f252408e.getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(6.0f), ViewUtils.dip2px(6.0f));
        layoutParams2.addRule(13);
        imageView.setLayoutParams(layoutParams2);
        Drawable drawable = this.f252408e.getResources().getDrawable(R.drawable.nfg, null);
        drawable.setTint(this.f252408e.getResources().getColor(R.color.qui_common_border_standard, null));
        imageView.setImageDrawable(drawable);
        relativeLayout.addView(imageView);
        return relativeLayout;
    }

    private void k() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(264.0f), ViewUtils.dip2px(20.0f));
        layoutParams.gravity = 1;
        LinearLayout linearLayout = new LinearLayout(this.f252408e.getContext());
        this.f252404a = linearLayout;
        linearLayout.setOrientation(0);
        this.f252404a.setLayoutParams(layoutParams);
        this.f252408e.addView(this.f252404a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewUtils.dip2px(264.0f), ViewUtils.dip2px(6.0f));
        layoutParams2.topMargin = ViewUtils.dip2px(2.0f);
        layoutParams2.gravity = 1;
        LinearLayout linearLayout2 = new LinearLayout(this.f252408e.getContext());
        this.f252405b = linearLayout2;
        linearLayout2.setOrientation(0);
        this.f252405b.setLayoutParams(layoutParams2);
        this.f252408e.addView(this.f252405b);
    }

    private void l(int i3) {
        LinearLayout linearLayout = this.f252408e;
        if (linearLayout == null) {
            return;
        }
        linearLayout.removeAllViews();
        if (e() > 1 && (i3 == 1 || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_mutualmark_progress", true))) {
            d();
            return;
        }
        this.f252408e.removeAllViews();
        ImageView imageView = new ImageView(this.f252408e.getContext());
        imageView.setImageDrawable(null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(192.0f), ViewUtils.dip2px(26.0f));
        layoutParams.gravity = 17;
        this.f252408e.addView(imageView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        o(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        o(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void o(View view) {
        b bVar = (b) view.getTag();
        a aVar = this.f252411h;
        if (aVar != null) {
            aVar.onClick(bVar.f252413b);
        }
    }

    private void r(ImageView imageView, RelativeLayout relativeLayout, int i3) {
        b bVar = new b();
        bVar.f252412a = relativeLayout;
        bVar.f252413b = i3;
        imageView.setTag(bVar);
        relativeLayout.setTag(bVar);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mutualmark.widget.detailcard.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.this.m(view);
            }
        });
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mutualmark.widget.detailcard.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.this.n(view);
            }
        });
    }

    public void p(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
            return;
        }
        LinearLayout linearLayout = this.f252408e;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setAlpha(f16);
    }

    public h q(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (h) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
        this.f252411h = aVar;
        return this;
    }

    public h s(MutualMarkModel mutualMarkModel) {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h) iPatchRedirector.redirect((short) 2, (Object) this, (Object) mutualMarkModel);
        }
        this.f252406c = mutualMarkModel;
        List<MutualMarkModel.Graded> list = mutualMarkModel.Y;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        String str = this.f252407d;
        if (str != null && str.equals(mutualMarkModel.U) && this.f252409f == size && this.f252410g == mutualMarkModel.H) {
            return this;
        }
        this.f252407d = mutualMarkModel.U;
        this.f252409f = size;
        this.f252410g = mutualMarkModel.H;
        l(this.f252406c.F);
        return this;
    }
}
