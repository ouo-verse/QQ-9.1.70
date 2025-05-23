package com.tencent.biz.pubaccount.weishi;

import UserGrowth.stAnnexation;
import UserGrowth.stGlobalConfig;
import UserGrowth.stPopWindowsButton;
import UserGrowth.stPopWindowsConfig;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi.util.ao;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdConfigDefine$APPID;
import java.net.URLDecoder;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e extends com.tencent.biz.subscribe.comment.p implements View.OnClickListener {
    private Context D;
    private int E;
    private int F;
    private URLImageView G;
    private ImageView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private long N;
    public stPopWindowsConfig P;
    private o Q;
    private boolean R;
    private TextView S;
    private View T;
    private stGlobalConfig U;
    private String V;
    private int W;
    private int X;
    private String Y;

    public e(Context context, int i3, int i16, String str) {
        this(context, -1, -1);
        this.D = context;
        this.W = i3;
        this.X = i16;
        this.Y = str;
    }

    private void Z() {
        stPopWindowsConfig stpopwindowsconfig = this.P;
        if (stpopwindowsconfig != null && stpopwindowsconfig.type != 1) {
            this.J.setVisibility(4);
            this.K.setVisibility(4);
            this.L.setVisibility(4);
            this.M.setVisibility(4);
            this.S.setVisibility(4);
            this.I.setVisibility(4);
            com.tencent.biz.pubaccount.weishi.util.x.i("weishi-813", "\u5c55\u793a\u56fe\u7247");
            return;
        }
        com.tencent.biz.pubaccount.weishi.util.x.i("weishi-813", "\u5c55\u793a\u7ea2\u5305");
    }

    private void b0() {
        if (isShowing()) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c0() {
        int i3 = this.P.type;
        if (i3 != 2) {
            return i3 != 3 ? 6 : 7;
        }
        return 401;
    }

    private boolean d0() {
        return this.W == 0;
    }

    private void e0(int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.N < 1500) {
            com.tencent.biz.pubaccount.weishi.util.x.h("RichBlockDialog", 1, "\u70b9\u51fb\u65f6\u95f4\u5c0f\u4e8e1.5\u79d2\uff0c\u4e0d\u505a\u54cd\u5e94");
            return;
        }
        this.N = currentTimeMillis;
        stPopWindowsConfig stpopwindowsconfig = this.P;
        if (stpopwindowsconfig != null && stpopwindowsconfig.jp_button != null) {
            g0(112, "popup_clk");
            Context context = getContext();
            if (context instanceof ContextThemeWrapper) {
                context = ((ContextThemeWrapper) context).getBaseContext();
            }
            stPopWindowsConfig stpopwindowsconfig2 = this.P;
            bb.e(this.D, stpopwindowsconfig2.schema_url, stpopwindowsconfig2.h5url, "", stpopwindowsconfig2.type, new a(context));
        }
        b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        int i3;
        stPopWindowsConfig stpopwindowsconfig = this.P;
        if (stpopwindowsconfig != null) {
            if (!TextUtils.isEmpty(stpopwindowsconfig.title)) {
                this.J.setText(this.P.title);
            }
            stPopWindowsConfig stpopwindowsconfig2 = this.P;
            if (stpopwindowsconfig2.type == 1) {
                stAnnexation stannexation = stpopwindowsconfig2.annexation;
                if (stannexation != null && (i3 = stannexation.money) > 0) {
                    this.K.setText(l0(i3));
                }
            } else if (stpopwindowsconfig2.annexation != null) {
                this.K.setText(this.P.annexation.money + "");
            }
            stPopWindowsButton stpopwindowsbutton = this.P.jp_button;
            if (stpopwindowsbutton != null && !TextUtils.isEmpty(stpopwindowsbutton.title)) {
                this.I.setText(this.P.jp_button.title);
            }
            if (!TextUtils.isEmpty(this.P.text)) {
                this.L.setText(this.P.text);
            }
            if (!TextUtils.isEmpty(this.P.remark)) {
                this.M.setText(this.P.remark);
            }
            show();
            g0(6, "popup_exp");
            WSPublicAccReport wSPublicAccReport = WSPublicAccReport.getInstance();
            stPopWindowsConfig stpopwindowsconfig3 = this.P;
            wSPublicAccReport.reportExposeRichBlockPop(stpopwindowsconfig3.windowsid, stpopwindowsconfig3.trace_id, this.Y, this.X);
            a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(int i3, String str) {
        if (d0()) {
            stPopWindowsConfig stpopwindowsconfig = this.P;
            WSReportDc00898.w(i3, stpopwindowsconfig.type, stpopwindowsconfig.windowsid);
        } else {
            stPopWindowsConfig stpopwindowsconfig2 = this.P;
            com.tencent.biz.pubaccount.weishi.report.dc898.d.f(str, stpopwindowsconfig2.type, stpopwindowsconfig2.windowsid);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        com.tencent.biz.pubaccount.weishi.util.x.a("RichBlockDialog", 2, "dismiss()");
        try {
            this.R = false;
            o oVar = this.Q;
            if (oVar != null) {
                oVar.c();
                this.Q = null;
            }
            super.dismiss();
        } catch (Exception e16) {
            com.tencent.biz.pubaccount.weishi.util.x.e("RichBlockDialog", 2, e16.getLocalizedMessage());
        }
    }

    public void i0(stGlobalConfig stglobalconfig) {
        a0();
        if (stglobalconfig != null) {
            this.U = stglobalconfig;
            ArrayList<stPopWindowsConfig> arrayList = stglobalconfig.windows_config;
            if (arrayList != null && arrayList.size() > 0) {
                stPopWindowsConfig stpopwindowsconfig = stglobalconfig.windows_config.get(0);
                if (stpopwindowsconfig != null) {
                    int i3 = stpopwindowsconfig.type;
                    if (i3 == 1) {
                        this.P = stpopwindowsconfig;
                    } else if (i3 == 2) {
                        this.P = stpopwindowsconfig;
                    } else {
                        this.P = stpopwindowsconfig;
                    }
                    com.tencent.biz.pubaccount.weishi.util.x.i("weishi-813", "\u963b\u65ad\u9875rich\u5316 type\u662f\uff1a" + stpopwindowsconfig.type);
                } else {
                    com.tencent.biz.pubaccount.weishi.util.x.i("weishi-813", "\u963b\u65ad\u9875rich\u5316 windowsConfig\u4e3anull");
                }
            } else {
                com.tencent.biz.pubaccount.weishi.util.x.l("weishi-813", "\u7011\u5e03\u6d41\u963b\u65ad\u9875rich\u5316 windowsConfig size\u4e3a0");
            }
            Z();
        }
    }

    public void j0(String str, Drawable drawable, Drawable drawable2, String str2) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable2;
        URLDrawable drawable3 = URLDrawable.getDrawable(str, obtain);
        this.G.setImageDrawable(drawable3);
        this.G.setURLDrawableDownListener(new b());
        this.G.setImageDrawable(drawable3);
        if (1 == drawable3.getStatus()) {
            f0();
        } else {
            drawable3.startDownload();
        }
    }

    @Override // com.tencent.biz.subscribe.comment.p, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        com.tencent.biz.pubaccount.weishi.util.x.a("RichBlockDialog", 2, "show()");
        try {
            super.show();
            this.R = true;
        } catch (Exception e16) {
            com.tencent.biz.pubaccount.weishi.util.x.e("RichBlockDialog", 2, e16.getLocalizedMessage());
        }
    }

    private void initView() {
        this.R = false;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.cdz, (ViewGroup) null, false);
        this.T = inflate;
        setContentView(inflate);
        this.G = (URLImageView) this.T.findViewById(R.id.m4p);
        this.J = (TextView) this.T.findViewById(R.id.m4t);
        this.K = (TextView) this.T.findViewById(R.id.m4q);
        this.L = (TextView) this.T.findViewById(R.id.m4s);
        this.M = (TextView) this.T.findViewById(R.id.m4r);
        this.H = (ImageView) this.T.findViewById(R.id.m4n);
        this.I = (TextView) this.T.findViewById(R.id.m4m);
        this.S = (TextView) this.T.findViewById(R.id.m4u);
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.G.setOnClickListener(this);
    }

    public void k0(Context context) {
        stPopWindowsConfig stpopwindowsconfig;
        if (context == null || (stpopwindowsconfig = this.P) == null) {
            return;
        }
        if (!TextUtils.isEmpty(stpopwindowsconfig.bg_img_url)) {
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.d7y);
            stPopWindowsConfig stpopwindowsconfig2 = this.P;
            int i3 = stpopwindowsconfig2.type;
            if (i3 == 2) {
                j0(stpopwindowsconfig2.bg_img_url, drawable, drawable, HardCodeUtil.qqStr(R.string.t1s));
                return;
            }
            if (i3 != 3) {
                b0();
                return;
            }
            o oVar = new o();
            this.Q = oVar;
            oVar.f(this.G, drawable, this.P.bg_img_url, true, false);
            f0();
            return;
        }
        b0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        switch (view.getId()) {
            case R.id.m4m /* 2131385093 */:
                com.tencent.biz.pubaccount.weishi.util.x.i("weishi-813", "\u70b9\u51fb\u4e86\u7ea2\u5305 \u63d0\u73b0");
                e0(1);
                return;
            case R.id.m4n /* 2131385094 */:
                b0();
                if (this.P != null) {
                    g0(117, "popup_close");
                    WSPublicAccReport wSPublicAccReport = WSPublicAccReport.getInstance();
                    stPopWindowsConfig stpopwindowsconfig = this.P;
                    wSPublicAccReport.reportClickRichBlockPop(QAdConfigDefine$APPID.QQLIVE, stpopwindowsconfig.windowsid, stpopwindowsconfig.trace_id, this.Y, this.X);
                    return;
                }
                return;
            case R.id.m4o /* 2131385095 */:
            default:
                return;
            case R.id.m4p /* 2131385096 */:
                com.tencent.biz.pubaccount.weishi.util.x.i("weishi-813", "\u70b9\u51fb\u4e86\u56fe\u7247 \u80cc\u666f\u56fe");
                e0(2);
                return;
        }
    }

    e(Context context, int i3, int i16) {
        this(context, R.style.f174285y0, i3, i16);
    }

    private String l0(int i3) {
        String format = String.format("%.3f", Double.valueOf(i3 / 100.0d));
        return format.indexOf(".") > 0 ? format.replaceAll("0+?$", "").replaceAll("[.]$", "") : format;
    }

    e(Context context, int i3, int i16, int i17) {
        super(context, i3);
        this.E = 12;
        this.F = 5;
        this.R = false;
        this.V = "weishi://main";
        initView();
        Window window = getWindow();
        if (window == null) {
            com.tencent.biz.pubaccount.weishi.util.x.a("RichBlockDialog", 2, "ScrollMoreDialog() window == null.");
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes == null) {
            com.tencent.biz.pubaccount.weishi.util.x.a("RichBlockDialog", 2, "ScrollMoreDialog() params == null.");
        } else {
            attributes.width = i16;
            attributes.height = i17;
        }
    }

    public void a0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements bb.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f80701a;

        a(Context context) {
            this.f80701a = context;
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.bb.c
        public void c(String str, int i3) {
            ao.f(e.this.D, "biz_src_jc_gzh_weishi", str, 1, e.this.U.link_strategy_type, e.this.c0());
            e.this.g0(114, "popup_clk_ws");
            WSPublicAccReport wSPublicAccReport = WSPublicAccReport.getInstance();
            e eVar = e.this;
            stPopWindowsConfig stpopwindowsconfig = eVar.P;
            wSPublicAccReport.reportClickRichBlockPop(1000003, stpopwindowsconfig.windowsid, stpopwindowsconfig.trace_id, eVar.Y, e.this.X);
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.bb.c
        public void d(String str, int i3) {
            if (this.f80701a instanceof Activity) {
                String decode = URLDecoder.decode(str);
                ((IRIJJumpUtils) QRoute.api(IRIJJumpUtils.class)).jumpToUrl(e.this.D, decode);
                com.tencent.biz.pubaccount.weishi.util.x.i("weishi-813", "\u963b\u65adrich\u5f39\u7a97:" + decode);
                stPopWindowsConfig stpopwindowsconfig = e.this.P;
                WSReportDc00898.w(140, stpopwindowsconfig.type, stpopwindowsconfig.windowsid);
                WSPublicAccReport wSPublicAccReport = WSPublicAccReport.getInstance();
                e eVar = e.this;
                stPopWindowsConfig stpopwindowsconfig2 = eVar.P;
                wSPublicAccReport.reportClickRichBlockPop(1000004, stpopwindowsconfig2.windowsid, stpopwindowsconfig2.trace_id, eVar.Y, e.this.X);
                return;
            }
            com.tencent.biz.pubaccount.weishi.util.x.l("weishi-813", "\u963b\u65adrich\u5f39\u7a97:context \u4e0d\u662fActivity");
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.bb.c
        public void b(Activity activity) {
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.bb.c
        public void a(String str, int i3) {
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.bb.c
        public void e(String str, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements URLDrawableDownListener {
        b() {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            com.tencent.biz.pubaccount.weishi.util.x.l("RichBlockDialog", "onLoadCanceled - ");
            if (e.this.G != null) {
                e.this.G.setImageResource(R.drawable.d7y);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            if (e.this.G != null) {
                e.this.G.setImageResource(R.drawable.d7y);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            e.this.f0();
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
        }
    }
}
