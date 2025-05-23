package com.tencent.creatorad.ui.box;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.creatorad.pb.CreatorReader$ShareAD;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends ReportDialog {
    static IPatchRedirector $redirector_;
    private static final int H;
    private static final int I;
    private static final int J;
    private static final int K;
    private static final int L;
    private static final int M;
    private View C;
    private GridLayout D;
    private CreatorReader$ShareAD E;
    private InterfaceC1021c F;
    private d G;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f100390d;

        b(int i3) {
            this.f100390d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, i3);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (c.this.F != null) {
                c.this.F.onClick(view, this.f100390d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.creatorad.ui.box.c$c, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1021c {
        void onClick(View view, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface d {
        void a(View view, int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26644);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        H = ViewUtils.dip2px(68.0f);
        I = ViewUtils.dip2px(89.0f);
        J = ViewUtils.dip2px(16.0f);
        K = ViewUtils.dip2px(6.0f);
        L = ViewUtils.dip2px(180.0f);
        M = ViewUtils.dip2px(14.0f);
    }

    public c(@NonNull Context context) {
        super(context, R.style.qZoneInputDialog);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void R() {
        if (!com.tencent.creatorad.utils.c.g(this.E)) {
            GdtLog.d("BoxAdDialog", "bindData() with invalid data");
            this.C.post(new Runnable() { // from class: com.tencent.creatorad.ui.box.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.dismiss();
                }
            });
            return;
        }
        int size = this.E.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.size();
        if (size > 9) {
            size = 9;
        }
        int ceil = (int) Math.ceil((size * 1.0f) / 3);
        this.D.setColumnCount(3);
        this.D.setRowCount(ceil);
        this.D.removeAllViews();
        LayoutInflater from = LayoutInflater.from(getContext().getApplicationContext());
        for (int i3 = 0; i3 < ceil; i3++) {
            for (int i16 = 0; i16 < 3; i16++) {
                int i17 = (3 * i3) + i16;
                if (i17 >= size) {
                    break;
                }
                qq_ad_get.QQAdGetRsp.AdInfo adInfo = this.E.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.get(i17);
                LinearLayout linearLayout = (LinearLayout) from.inflate(R.layout.e4s, (ViewGroup) this.D, false);
                Q(linearLayout, adInfo, i17);
                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
                layoutParams.width = H;
                layoutParams.height = I;
                int i18 = K;
                layoutParams.leftMargin = i18;
                layoutParams.rightMargin = i18;
                layoutParams.topMargin = J;
                this.D.addView(linearLayout, layoutParams);
            }
        }
        ViewGroup.LayoutParams layoutParams2 = this.D.getLayoutParams();
        layoutParams2.width = (H + (K * 2)) * Math.min(size, 3);
        layoutParams2.height = (I + J) * ceil;
        this.D.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.C.getLayoutParams();
        layoutParams3.width = Math.max(layoutParams2.width + (M * 2), L);
        this.C.setLayoutParams(layoutParams3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void initView() {
        FrameLayout frameLayout = (FrameLayout) getWindow().getDecorView();
        View inflate = getLayoutInflater().inflate(R.layout.e4r, (ViewGroup) frameLayout, false);
        this.C = inflate;
        setContentView(inflate);
        setOnDismissListener(new a());
        this.D = (GridLayout) frameLayout.findViewById(R.id.tbe);
        View findViewById = findViewById(R.id.tbd);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.creatorad.ui.box.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.this.S(view);
            }
        });
        findViewById.setContentDescription(HardCodeUtil.qqStr(R.string.yjt));
        setCanceledOnTouchOutside(false);
    }

    public void P(CreatorReader$ShareAD creatorReader$ShareAD) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) creatorReader$ShareAD);
        } else {
            this.E = creatorReader$ShareAD;
        }
    }

    protected void Q(LinearLayout linearLayout, qq_ad_get.QQAdGetRsp.AdInfo adInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, linearLayout, adInfo, Integer.valueOf(i3));
            return;
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.icon);
        imageView.setImageDrawable(URLDrawable.getDrawable(adInfo.display_info.basic_info.img.get(), URLDrawable.URLDrawableOptions.obtain()));
        TextView textView = (TextView) linearLayout.findViewById(R.id.f5e);
        String trim = adInfo.display_info.mini_program_name.get().trim();
        textView.setText(trim);
        textView.getPaint().setAntiAlias(true);
        imageView.setContentDescription(trim);
        textView.setContentDescription(trim);
        linearLayout.setOnClickListener(new b(i3));
        d dVar = this.G;
        if (dVar != null) {
            dVar.a(linearLayout, i3);
        }
    }

    public void U(InterfaceC1021c interfaceC1021c) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) interfaceC1021c);
        } else {
            this.F = interfaceC1021c;
        }
    }

    public void W(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
        } else {
            this.G = dVar;
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        initView();
        R();
    }
}
