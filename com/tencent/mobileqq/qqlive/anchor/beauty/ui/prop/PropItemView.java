package com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api.PropDownloadIconStatusListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes17.dex */
public class PropItemView extends FrameLayout implements PropDownloadIconStatusListener, View.OnClickListener {
    static IPatchRedirector $redirector_;
    private final IAegisLogApi C;

    /* renamed from: d, reason: collision with root package name */
    private View f270472d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f270473e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f270474f;

    /* renamed from: h, reason: collision with root package name */
    private ProgressBar f270475h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.viewmodel.b f270476i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api.a f270477m;

    public PropItemView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.C = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        e();
        d(context);
    }

    private void e() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hb7, (ViewGroup) this, true);
        this.f270472d = inflate;
        this.f270473e = (ImageView) inflate.findViewById(R.id.t5q);
        this.f270474f = (ImageView) this.f270472d.findViewById(R.id.a6w);
        this.f270475h = (ProgressBar) this.f270472d.findViewById(R.id.ul5);
        setOnClickListener(this);
    }

    private void f(com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar) {
        if (aVar.c() == 1) {
            a(aVar, PropDownloadIconStatusListener.IconType.ICON_PROGRESS);
        } else if (aVar.c() == 2) {
            a(aVar, PropDownloadIconStatusListener.IconType.ICON_NULL);
        } else {
            a(aVar, PropDownloadIconStatusListener.IconType.ICON_DOWNLOAD);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api.PropDownloadIconStatusListener
    public void a(@NonNull com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar, PropDownloadIconStatusListener.IconType iconType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar, (Object) iconType);
            return;
        }
        if (iconType == PropDownloadIconStatusListener.IconType.ICON_NULL) {
            b(false);
            c(false);
        } else if (iconType == PropDownloadIconStatusListener.IconType.ICON_DOWNLOAD) {
            b(true);
            c(false);
        } else if (iconType == PropDownloadIconStatusListener.IconType.ICON_PROGRESS) {
            b(false);
            c(true);
        }
    }

    public void b(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        ImageView imageView = this.f270474f;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        imageView.setVisibility(i3);
    }

    public void c(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        ProgressBar progressBar = this.f270475h;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        progressBar.setVisibility(i3);
    }

    public void d(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) context);
            return;
        }
        com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.viewmodel.b bVar = new com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.viewmodel.b();
        this.f270476i = bVar;
        bVar.S1(this);
    }

    public void g(com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestHeight = com.tencent.mobileqq.qqlive.anchor.beauty.utils.d.a(getContext(), 56.0f);
        obtain.mRequestWidth = com.tencent.mobileqq.qqlive.anchor.beauty.utils.d.a(getContext(), 56.0f);
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        this.f270473e.setImageDrawable(URLDrawable.getDrawable(aVar.f270494d, obtain));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else {
            if (this.f270477m != null && this.f270476i.O1() != null) {
                this.f270477m.b(this, this.f270476i.O1());
            }
            this.f270476i.U1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setData(com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        this.f270476i.R1(aVar);
        f(aVar);
        g(aVar);
    }

    public void setPropItemClickListener(com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.f270477m = aVar;
        }
    }

    public PropItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.C = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        e();
        d(context);
    }

    public PropItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.C = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        e();
        d(context);
    }
}
