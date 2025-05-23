package com.tencent.creatorad.ui.presenter;

import android.view.View;
import android.widget.ImageView;
import com.tencent.creatorad.pb.CreatorReader$ShareAD;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends com.tencent.creatorad.ui.b {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    public static final int f100406j;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f100407f;

    /* renamed from: g, reason: collision with root package name */
    private View f100408g;

    /* renamed from: h, reason: collision with root package name */
    private final View.OnClickListener f100409h;

    /* renamed from: i, reason: collision with root package name */
    private final View.OnClickListener f100410i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26648);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f100406j = com.tencent.creatorad.ui.c.c(1, true, 1);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f100409h = new View.OnClickListener() { // from class: com.tencent.creatorad.ui.presenter.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.this.s(view);
                }
            };
            this.f100410i = new View.OnClickListener() { // from class: com.tencent.creatorad.ui.presenter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.this.t(view);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        n(this.f100382a, 0);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        d(this.f100382a, 0);
        com.tencent.creatorad.ui.f.a(this.f100382a, 0);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.creatorad.ui.b
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return f100406j;
    }

    @Override // com.tencent.creatorad.ui.b
    protected int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.e4q;
    }

    @Override // com.tencent.creatorad.ui.b
    protected void j(CreatorReader$ShareAD creatorReader$ShareAD) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) creatorReader$ShareAD);
        } else {
            if (!com.tencent.creatorad.utils.c.g(creatorReader$ShareAD)) {
                QLog.e("BasePresenter", 1, "isSharedAdValid false");
                return;
            }
            this.f100407f.setImageDrawable(URLDrawable.getDrawable(creatorReader$ShareAD.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.get(0).display_info.basic_info.img.get(), URLDrawable.URLDrawableOptions.obtain()));
            com.tencent.creatorad.ui.f.b(creatorReader$ShareAD, 0);
        }
    }

    @Override // com.tencent.creatorad.ui.b
    protected void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f100407f = (ImageView) this.f100384c.findViewById(R.id.ube);
        View findViewById = this.f100384c.findViewById(R.id.ubf);
        this.f100408g = findViewById;
        findViewById.setOnClickListener(this.f100409h);
        this.f100385d.setOnClickListener(this.f100410i);
    }
}
