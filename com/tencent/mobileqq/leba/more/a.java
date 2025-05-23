package com.tencent.mobileqq.leba.more;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.i;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_;
    protected GridLayoutManager C;
    protected e D;
    protected boolean E;
    protected boolean F;
    protected com.tencent.mobileqq.leba.business.g G;
    protected int H;
    protected int I;

    /* renamed from: d, reason: collision with root package name */
    protected Drawable f240694d;

    /* renamed from: e, reason: collision with root package name */
    protected Drawable f240695e;

    /* renamed from: f, reason: collision with root package name */
    protected int f240696f;

    /* renamed from: h, reason: collision with root package name */
    protected int f240697h;

    /* renamed from: i, reason: collision with root package name */
    protected Context f240698i;

    /* renamed from: m, reason: collision with root package name */
    protected LebaMoreDataLogic f240699m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.leba.more.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class ViewOnClickListenerC7965a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f240700d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ i f240701e;

        ViewOnClickListenerC7965a(f fVar, i iVar) {
            this.f240700d = fVar;
            this.f240701e = iVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, fVar, iVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                a aVar = a.this;
                if (aVar.F) {
                    this.f240700d.f240714f.performClick();
                } else {
                    e eVar = aVar.D;
                    if (eVar != null) {
                        eVar.o2(view, this.f240701e.f240488c);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f240703d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ i f240704e;

        b(f fVar, i iVar) {
            this.f240703d = fVar;
            this.f240704e = iVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, fVar, iVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ImageView imageView = this.f240703d.f240714f;
                i iVar = this.f240704e;
                com.tencent.mobileqq.leba.report.d.o(imageView, iVar.f240489d, iVar.f240488c.f240505b.getDaTongID());
                a.this.s(this.f240703d, this.f240704e);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f240706d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ i f240707e;

        c(f fVar, i iVar) {
            this.f240706d = fVar;
            this.f240707e = iVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, fVar, iVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ImageView imageView = this.f240706d.f240714f;
                i iVar = this.f240707e;
                com.tencent.mobileqq.leba.report.d.o(imageView, iVar.f240489d, iVar.f240488c.f240505b.getDaTongID());
                a.this.t(this.f240706d, this.f240707e);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f240709d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ i f240710e;

        d(f fVar, i iVar) {
            this.f240709d = fVar;
            this.f240710e = iVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, fVar, iVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                a aVar = a.this;
                if (aVar.F) {
                    this.f240709d.f240714f.performClick();
                } else {
                    com.tencent.mobileqq.leba.business.g gVar = aVar.G;
                    if (gVar != null) {
                        gVar.b(this.f240710e);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface e {
        void o2(View view, n nVar);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class f extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f240712d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f240713e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f240714f;

        /* renamed from: h, reason: collision with root package name */
        public RelativeLayout f240715h;

        public f(View view, Context context, int i3, boolean z16) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, view, context, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            this.f240713e = (TextView) view.findViewById(R.id.tv_name);
            this.f240712d = (ImageView) view.findViewById(R.id.dvu);
            this.f240714f = (ImageView) view.findViewById(R.id.xzl);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.ibr);
            this.f240715h = relativeLayout;
            relativeLayout.setBackgroundResource(R.drawable.qui_common_fill_light_secondary_bg_selector);
            this.f240713e.setTextColor(context.getResources().getColor(R.color.qui_common_text_primary));
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class g extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private TextView f240716d;

        public g(Context context, View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) view);
                return;
            }
            TextView textView = (TextView) view.findViewById(R.id.title);
            this.f240716d = textView;
            textView.setTextColor(context.getResources().getColor(R.color.qui_common_text_secondary));
        }

        public void b(i iVar) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) iVar);
                return;
            }
            if (TextUtils.isEmpty(iVar.f240487b)) {
                str = "";
            } else {
                str = iVar.f240487b;
            }
            if (!str.equals(this.f240716d.getText().toString())) {
                this.f240716d.setText(str);
            }
        }
    }

    public a(Context context, LebaMoreDataLogic lebaMoreDataLogic, boolean z16, int i3, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, lebaMoreDataLogic, Boolean.valueOf(z16), Integer.valueOf(i3), eVar);
            return;
        }
        this.F = false;
        this.f240698i = context;
        this.f240694d = context.getResources().getDrawable(R.drawable.ew8);
        this.f240695e = context.getResources().getDrawable(R.drawable.neu);
        this.f240696f = context.getResources().getDisplayMetrics().densityDpi;
        this.f240697h = ViewUtils.dip2px(24.0f);
        this.f240699m = lebaMoreDataLogic;
        this.E = z16;
        this.I = i3;
        this.D = eVar;
    }

    private void r(ImageView imageView, String str, boolean z16) {
        if (this.f240698i != null && imageView != null) {
            StringBuilder sb5 = new StringBuilder();
            if (z16) {
                sb5.append(this.f240698i.getString(R.string.f162051zd));
            } else {
                sb5.append(this.f240698i.getString(R.string.f162041zc));
            }
            sb5.append(TokenParser.SP);
            sb5.append(str);
            imageView.setContentDescription(sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(f fVar, i iVar) {
        if (!iVar.f240488c.c()) {
            return;
        }
        if (iVar.f240489d) {
            this.f240699m.p(this, iVar, fVar);
        } else {
            this.f240699m.q(this, iVar, fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(f fVar, i iVar) {
        if (!iVar.f240494i) {
            return;
        }
        if (iVar.f240489d) {
            this.f240699m.p(this, iVar, fVar);
        } else {
            this.f240699m.q(this, iVar, fVar);
        }
    }

    public void A(com.tencent.mobileqq.leba.business.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gVar);
        } else {
            this.G = gVar;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f240699m.g();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, i3)).intValue();
        }
        return this.f240699m.h(i3);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) viewHolder, i3);
        } else {
            i f16 = this.f240699m.f(i3);
            if (f16 != null) {
                if (viewHolder instanceof g) {
                    ((g) viewHolder).b(f16);
                } else if (viewHolder instanceof f) {
                    f fVar = (f) viewHolder;
                    u(fVar, f16);
                    w(fVar, f16);
                }
            }
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewGroup, i3);
        }
        if (i3 == 1) {
            return new g(this.f240698i, LayoutInflater.from(this.f240698i).inflate(R.layout.gxl, viewGroup, false));
        }
        if (i3 == 2) {
            return new f(LayoutInflater.from(this.f240698i).inflate(R.layout.gxk, viewGroup, false), this.f240698i, this.H, this.E);
        }
        return null;
    }

    public void u(f fVar, i iVar) {
        boolean z16;
        Drawable drawable;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) fVar, (Object) iVar);
            return;
        }
        if (iVar.f240490e) {
            v(fVar, iVar);
            return;
        }
        n nVar = iVar.f240488c;
        String str2 = "";
        if (nVar != null && nVar.f240505b != null) {
            fVar.itemView.setEnabled(true);
            fVar.itemView.setOnClickListener(new ViewOnClickListenerC7965a(fVar, iVar));
            LebaPluginInfo lebaPluginInfo = iVar.f240488c.f240505b;
            if (this.I == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            String pluginName = lebaPluginInfo.getPluginName(z16);
            if (!TextUtils.isEmpty(pluginName)) {
                str2 = pluginName;
            }
            if (!str2.equals(fVar.f240713e.getText().toString())) {
                fVar.f240713e.setText(str2);
            }
            int i3 = this.H;
            if (i3 == 2) {
                drawable = this.f240695e;
            } else {
                drawable = this.f240694d;
            }
            if (i3 == 2) {
                str = iVar.f240488c.b();
            } else {
                str = iVar.f240488c.f240505b.strResURL;
            }
            fVar.f240712d.setVisibility(0);
            if (!TextUtils.isEmpty(str)) {
                try {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    int i16 = this.f240697h;
                    obtain.mRequestWidth = i16;
                    obtain.mRequestHeight = i16;
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = drawable;
                    URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
                    drawable2.setTargetDensity(this.f240696f);
                    if (drawable2.getStatus() == 2) {
                        drawable2.restartDownload();
                    }
                    fVar.f240712d.setImageDrawable(drawable2);
                } catch (Exception unused) {
                }
            } else {
                int i17 = iVar.f240488c.f240505b.cIconResId;
                if (i17 != 0) {
                    try {
                        fVar.f240712d.setImageResource(i17);
                    } catch (Exception e16) {
                        QLog.e("LebaPluginViewUtil", 1, "setIconAndText", e16);
                    }
                } else {
                    fVar.f240712d.setImageDrawable(drawable);
                }
            }
            if (this.F && iVar.f240488c.c()) {
                fVar.f240714f.setVisibility(0);
                if (iVar.f240489d) {
                    fVar.f240714f.setImageResource(R.drawable.krp);
                } else {
                    fVar.f240714f.setImageResource(R.drawable.kro);
                }
                r(fVar.f240714f, str2, iVar.f240489d);
            } else {
                fVar.f240714f.setVisibility(8);
            }
            fVar.f240714f.setOnClickListener(new b(fVar, iVar));
            com.tencent.mobileqq.leba.utils.e.c(fVar.f240712d);
            if (AppSetting.f99565y) {
                AccessibilityUtil.c(fVar.itemView, str2, Button.class.getName());
                return;
            }
            return;
        }
        fVar.itemView.setEnabled(false);
        fVar.itemView.setOnClickListener(null);
        fVar.f240713e.setText("");
        fVar.f240712d.setVisibility(8);
        fVar.f240714f.setVisibility(8);
        if (AppSetting.f99565y) {
            AccessibilityUtil.c(fVar.itemView, "", Button.class.getName());
        }
    }

    public void v(f fVar, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) fVar, (Object) iVar);
            return;
        }
        String str = iVar.f240493h;
        fVar.f240713e.setText(str);
        fVar.f240712d.setVisibility(0);
        fVar.f240712d.setImageResource(iVar.f240492g);
        com.tencent.mobileqq.leba.utils.e.c(fVar.f240712d);
        if (iVar.f240494i && this.F) {
            fVar.f240714f.setVisibility(0);
            if (iVar.f240489d) {
                fVar.f240714f.setImageResource(R.drawable.krp);
            } else {
                fVar.f240714f.setImageResource(R.drawable.kro);
            }
            r(fVar.f240714f, str, iVar.f240489d);
        } else {
            fVar.f240714f.setVisibility(8);
        }
        fVar.f240714f.setOnClickListener(new c(fVar, iVar));
        fVar.itemView.setEnabled(true);
        fVar.itemView.setOnClickListener(new d(fVar, iVar));
        if (AppSetting.f99565y) {
            AccessibilityUtil.c(fVar.itemView, str, Button.class.getName());
        }
    }

    void w(f fVar, i iVar) {
        View view;
        n nVar;
        LebaPluginInfo lebaPluginInfo;
        if (fVar != null && (view = fVar.itemView) != null && iVar != null && (nVar = iVar.f240488c) != null && (lebaPluginInfo = nVar.f240505b) != null) {
            if (this.F) {
                VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
                VideoReport.setElementClickPolicy(fVar.itemView, ClickPolicy.REPORT_NONE);
                return;
            }
            if (iVar.f240490e) {
                int i3 = iVar.f240491f;
                if (i3 == 1) {
                    com.tencent.mobileqq.leba.report.d.p(view, "friendmomt");
                    return;
                } else if (i3 == 2) {
                    com.tencent.mobileqq.leba.report.d.p(view, "wezone");
                    return;
                } else {
                    com.tencent.mobileqq.leba.report.d.p(view, "default");
                    return;
                }
            }
            com.tencent.mobileqq.leba.report.d.p(view, lebaPluginInfo.getDaTongID());
        }
    }

    public void x(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.F = z16;
            notifyDataSetChanged();
        }
    }

    public void y(GridLayoutManager gridLayoutManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gridLayoutManager);
        } else {
            this.C = gridLayoutManager;
        }
    }

    public void z(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.H = i3;
        }
    }
}
