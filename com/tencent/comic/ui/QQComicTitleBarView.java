package com.tencent.comic.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.webview.swift.r;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import com.tencent.mobileqq.widget.WebViewProgressBar;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQComicTitleBarView extends SwiftIphoneTitleBarUI {

    /* renamed from: s0, reason: collision with root package name */
    private boolean f99457s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f99458t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f99459u0;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity = QQComicTitleBarView.this.f314045d.E;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            QQComicTitleBarView.this.f314045d.E.finish();
        }
    }

    public QQComicTitleBarView(v vVar) {
        super(vVar);
        this.f99457s0 = true;
        this.f99458t0 = true;
        this.f99459u0 = true;
        Intent intent = vVar.E.getIntent();
        int intExtra = intent.getIntExtra("key_subtab", 0);
        intent.removeExtra("key_subtab");
        if (this.f314047e.f314627j != intExtra) {
            a0(intExtra);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void U(boolean z16) {
        super.U(z16);
        if (z16) {
            if (this.f99457s0) {
                S(-1);
            }
            if (this.f99458t0) {
                W(-1);
            }
            WebViewTopTabView webViewTopTabView = this.f314060m0;
            if (webViewTopTabView != null) {
                webViewTopTabView.setButtonBackgroundResource(R.drawable.b7w, R.drawable.b7x, R.drawable.b7y);
                this.f314060m0.setButtonTextColorStateList(R.color.aks);
                this.f314060m0.setLeftAndRightPaddingByDp(14);
                return;
            }
            return;
        }
        if (this.f99457s0) {
            S(-16777216);
        }
        if (this.f99458t0) {
            W(-16777216);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void o() {
        int i3;
        super.o();
        ViewGroup viewGroup = this.f314045d.S;
        if (viewGroup instanceof RefreshView) {
            ((RefreshView) viewGroup).a(false);
        }
        View view = this.f314045d.f314500b0;
        if (view != null) {
            view.setVisibility(8);
        }
        r rVar = this.f314047e;
        rVar.f314631n = true;
        if (rVar.K != null) {
            this.f99457s0 = !r0.has("txtclr");
            this.f99458t0 = !this.f314047e.K.has("titleclr");
            this.f99459u0 = !this.f314047e.K.has("bgclr");
        }
        if (this.f99459u0) {
            int paddingTop = this.M.getPaddingTop();
            int paddingBottom = this.M.getPaddingBottom();
            int paddingLeft = this.M.getPaddingLeft();
            int paddingRight = this.M.getPaddingRight();
            this.M.setBackgroundColor(-1);
            this.M.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            WebViewProvider webViewProvider = this.f314045d.P;
            if (webViewProvider != null) {
                webViewProvider.getWebTitleBarInterface().u6(true);
                this.f314045d.P.getWebTitleBarInterface().Pg(true);
                if (this.f314045d.P.getWebTitleBarInterface().a3() == null) {
                    this.f314045d.P.getWebTitleBarInterface().Ad(false);
                }
                if (this.f314045d.P.getWebTitleBarInterface().a3() != null) {
                    this.f314045d.P.getWebTitleBarInterface().a3().setBackgroundColor(-4210753);
                    this.f314047e.f314637t = true;
                }
            }
        }
        if (!this.f99459u0 || !this.f99458t0 || !this.f99457s0) {
            this.f314045d.o(this.f314047e.K, true);
        }
        if ((this.f314047e.f314625h & 32) != 0) {
            this.f314054i.setVisibility(4);
            i3 = 4;
            G("", this.C.getResources().getString(R.string.xxc), "", false, 0, 0, null, null, null);
            this.C.setOnClickListener(new a());
        } else {
            i3 = 4;
        }
        if ((this.f314047e.f314625h & 64) != 0) {
            this.f314054i.setVisibility(i3);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.P.getLayoutParams();
            layoutParams.addRule(15);
            layoutParams.addRule(9);
            layoutParams.leftMargin = x.c(this.P.getContext(), 15.0f);
            this.P.setLayoutParams(layoutParams);
        }
        r rVar2 = this.f314047e;
        int i16 = rVar2.f314628k;
        if (i16 != -1) {
            R(i16);
        } else if ((rVar2.f314620c & 16777216) <= 0 && (rVar2.f314625h & 1) <= 0) {
            R(255);
        } else {
            R(0);
        }
        this.f314054i.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.f314059m.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.C.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        WebViewProgressBar webViewProgressBar = this.f314045d.T;
        if (webViewProgressBar != null) {
            webViewProgressBar.setVisibility(8);
        }
    }
}
