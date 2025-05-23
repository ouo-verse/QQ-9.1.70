package com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup;

import android.content.Context;
import android.content.DialogInterface;
import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.beauty.BeautyProcessor;
import com.tencent.mobileqq.qqlive.anchor.beauty.model.CategoryItem;
import com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel;
import com.tencent.mobileqq.qqlive.anchor.beauty.utils.AEMetaDataUtils;
import com.tencent.mobileqq.qqlive.anchor.beauty.widget.BeautyGroupEventor;
import com.tencent.mobileqq.qqlive.anchor.beauty.widget.QQLiveLoadingView;
import com.tencent.mobileqq.qqlive.anchor.beauty.widget.StartPointSeekBar;
import com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup.EffectPageItemView;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.Foreground;

/* loaded from: classes17.dex */
public class EffectPageItemView extends FrameLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private ImageView C;
    private View D;
    private QQLiveLoadingView E;
    private CategoryItem.a F;
    private i G;
    private h H;
    private int I;
    private int J;
    private StartPointSeekBar.a K;

    /* renamed from: d, reason: collision with root package name */
    private TextView f270582d;

    /* renamed from: e, reason: collision with root package name */
    private View f270583e;

    /* renamed from: f, reason: collision with root package name */
    private URLImageView f270584f;

    /* renamed from: h, reason: collision with root package name */
    private StartPointSeekBar f270585h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f270586i;

    /* renamed from: m, reason: collision with root package name */
    private View f270587m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a implements AEMetaDataUtils.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f270589a;

        a(String str) {
            this.f270589a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EffectPageItemView.this, (Object) str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h() {
            if (EffectPageItemView.this.H != null) {
                EffectPageItemView.this.H.a(EffectPageItemView.this.F.hashCode(), 1, 100);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i() {
            if (EffectPageItemView.this.H != null) {
                EffectPageItemView.this.H.a(EffectPageItemView.this.F.hashCode(), 2, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(int i3) {
            if (EffectPageItemView.this.H != null) {
                EffectPageItemView.this.H.a(EffectPageItemView.this.F.hashCode(), 3, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k() {
            if (EffectPageItemView.this.H != null) {
                EffectPageItemView.this.H.a(EffectPageItemView.this.F.hashCode(), 3, 0);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.utils.AEMetaDataUtils.a
        public void a(AEMaterialMetaData aEMaterialMetaData, final int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aEMaterialMetaData, i3);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        EffectPageItemView.a.this.j(i3);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.utils.AEMetaDataUtils.a
        public void b(AEMaterialMetaData aEMaterialMetaData, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) aEMaterialMetaData, i3);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        EffectPageItemView.a.this.i();
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.utils.AEMetaDataUtils.a
        public void c(AEMaterialMetaData aEMaterialMetaData, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) aEMaterialMetaData, (Object) str);
            } else {
                BeautyProcessor.n().H(str, this.f270589a);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        EffectPageItemView.a.this.h();
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.utils.AEMetaDataUtils.a
        public void onDownloadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        EffectPageItemView.a.this.k();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class b implements AEMetaDataUtils.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f270591a;

        b(String str) {
            this.f270591a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EffectPageItemView.this, (Object) str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h() {
            if (EffectPageItemView.this.H != null) {
                EffectPageItemView.this.H.a(EffectPageItemView.this.F.hashCode(), 1, 100);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i() {
            if (EffectPageItemView.this.H != null) {
                EffectPageItemView.this.H.a(EffectPageItemView.this.F.hashCode(), 2, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(int i3) {
            if (EffectPageItemView.this.H != null) {
                EffectPageItemView.this.H.a(EffectPageItemView.this.F.hashCode(), 3, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k() {
            if (EffectPageItemView.this.H != null) {
                EffectPageItemView.this.H.a(EffectPageItemView.this.F.hashCode(), 3, 0);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.utils.AEMetaDataUtils.a
        public void a(AEMaterialMetaData aEMaterialMetaData, final int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aEMaterialMetaData, i3);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        EffectPageItemView.b.this.j(i3);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.utils.AEMetaDataUtils.a
        public void b(AEMaterialMetaData aEMaterialMetaData, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) aEMaterialMetaData, i3);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        EffectPageItemView.b.this.i();
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.utils.AEMetaDataUtils.a
        public void c(AEMaterialMetaData aEMaterialMetaData, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) aEMaterialMetaData, (Object) str);
            } else {
                BeautyProcessor.n().G(str, this.f270591a);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        EffectPageItemView.b.this.h();
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.utils.AEMetaDataUtils.a
        public void onDownloadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        EffectPageItemView.b.this.k();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EffectPageItemView.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (EffectPageItemView.this.F != null) {
                i16 = EffectPageItemView.this.F.f270413a;
            } else {
                i16 = 0;
            }
            BeautyProcessor.n().x(i16);
            if (EffectPageItemView.this.G != null) {
                EffectPageItemView.this.G.a(EffectPageItemView.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EffectPageItemView.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EffectPageItemView.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (EffectPageItemView.this.F != null) {
                i16 = EffectPageItemView.this.F.f270413a;
            } else {
                i16 = 0;
            }
            BeautyProcessor.n().h(i16);
            if (EffectPageItemView.this.G != null) {
                EffectPageItemView.this.G.a(EffectPageItemView.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class f implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EffectPageItemView.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* loaded from: classes17.dex */
    class g implements StartPointSeekBar.a {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EffectPageItemView.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.widget.StartPointSeekBar.a
        public void a(StartPointSeekBar startPointSeekBar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) startPointSeekBar);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.widget.StartPointSeekBar.a
        public void b(StartPointSeekBar startPointSeekBar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) startPointSeekBar);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.widget.StartPointSeekBar.a
        public void c(StartPointSeekBar startPointSeekBar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                EffectPageItemView.this.g(i3);
                EffectPageItemView.this.v();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) startPointSeekBar, i3);
            }
        }
    }

    /* loaded from: classes17.dex */
    public interface h {
        void a(int i3, int i16, int i17);
    }

    /* loaded from: classes17.dex */
    public interface i {
        void a(EffectPageItemView effectPageItemView);
    }

    public EffectPageItemView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.I = 0;
        this.J = 0;
        this.K = new g();
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i3) {
        this.F.l(i3);
        CategoryItem.a aVar = this.F;
        int i16 = aVar.f270413a;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 == 11) {
                        if (aVar.f270417e.getParent() != null) {
                            this.F.f270417e.getParent().setCurValue(i3);
                        }
                        p(i3);
                        return;
                    }
                    return;
                }
                r(i3);
                return;
            }
            s(i3);
            return;
        }
        o(i3);
    }

    private void h() {
        DialogUtil.createCustomDialog(Foreground.getTopActivity(), 230, (String) null, getContext().getText(R.string.ztx).toString(), getContext().getText(R.string.ztv).toString(), getContext().getText(R.string.ztw).toString(), new e(), new f()).show();
    }

    private void j() {
        int c16;
        CategoryItem.a aVar = this.F;
        if (aVar == null) {
            return;
        }
        int i3 = 0;
        if (aVar.g() > 0) {
            if (aVar.a() != Integer.MIN_VALUE) {
                c16 = aVar.a();
            } else {
                c16 = aVar.c();
            }
            this.f270587m.setVisibility(0);
            this.f270585h.setAbsoluteMinMaxValue(aVar.h(), aVar.g());
            this.f270585h.setDefaultValue(aVar.c());
            this.f270585h.setOnSeekBarChangeListener(this.K);
            this.f270585h.setProgress(c16);
            i3 = c16;
        } else {
            this.f270587m.setVisibility(4);
            this.f270585h.setProgress(0);
            this.f270585h.setOnSeekBarChangeListener(null);
        }
        this.f270585h.post(new Runnable(i3) { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup.EffectPageItemView.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f270588d;

            {
                this.f270588d = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) EffectPageItemView.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    StartPointSeekBar.s(EffectPageItemView.this.f270585h, this.f270588d, EffectPageItemView.this.f270586i);
                }
            }
        });
    }

    private void k() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.h_d, (ViewGroup) this, true);
        this.f270584f = (URLImageView) inflate.findViewById(R.id.t5q);
        this.f270582d = (TextView) inflate.findViewById(R.id.t5v);
        this.f270583e = inflate.findViewById(R.id.t5s);
        this.C = (ImageView) inflate.findViewById(R.id.a6w);
        this.D = inflate.findViewById(R.id.f165016ul4);
        this.E = (QQLiveLoadingView) inflate.findViewById(R.id.g2d);
        this.f270584f.setOnClickListener(this);
        this.f270582d.setOnClickListener(this);
        inflate.setOnClickListener(this);
    }

    private void l(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            this.f270584f.setImageResource(i3);
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        int dip2px = ViewUtils.dip2px(56.0f);
        int dip2px2 = ViewUtils.dip2px(56.0f);
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        drawable.setTag(new int[]{dip2px, dip2px2});
        drawable.setDecodeHandler(com.tencent.mobileqq.qqlive.room.prepare.b.f271920m);
        this.f270584f.setImageDrawable(drawable);
    }

    private void n() {
        DialogUtil.createCustomDialog(Foreground.getTopActivity(), 230, (String) null, getContext().getText(R.string.zty).toString(), getContext().getText(R.string.ztv).toString(), getContext().getText(R.string.ztw).toString(), new c(), new d()).show();
    }

    private void o(int i3) {
        DataModel.BeautyItem beautyItem = this.F.f270414b;
        if (beautyItem == null) {
            return;
        }
        if (beautyItem == DataModel.BeautyItem.NONE) {
            h();
            return;
        }
        if (beautyItem == DataModel.BeautyItem.RESET) {
            n();
            return;
        }
        i iVar = this.G;
        if (iVar != null) {
            iVar.a(this);
        }
        if (this.F.f270414b == DataModel.BeautyItem.BASIC_FACE) {
            SimpleEventBus.getInstance().dispatchEvent(new BeautyGroupEventor(this.F));
        }
        BeautyProcessor.n().E(this.F.f270414b.getLightInterface(), String.valueOf(i3 / 100.0f));
    }

    private void p(int i3) {
        if (this.F.f270417e == null) {
            return;
        }
        i iVar = this.G;
        if (iVar != null) {
            iVar.a(this);
        }
        BeautyProcessor.n().F(this.F.f270417e.getParent().getLightInterface(), String.valueOf(i3 / 100.0f), this.F.f270417e.getSubLightInterface(), this.F.f270417e.getSubLightValue());
    }

    private void q(boolean z16) {
        int i3;
        QQLiveLoadingView qQLiveLoadingView = this.E;
        if (qQLiveLoadingView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            qQLiveLoadingView.setVisibility(i3);
        }
    }

    private void r(int i3) {
        if (this.F.f270416d == null) {
            return;
        }
        i iVar = this.G;
        if (iVar != null) {
            iVar.a(this);
        }
        DataModel.FilterItem filterItem = this.F.f270416d;
        if (filterItem == DataModel.FilterItem.ORIGIN) {
            BeautyProcessor.n().h(3);
            return;
        }
        TrafficStats.setThreadStatsTag(-255);
        AEMetaDataUtils.j(filterItem.getId(), filterItem.getOnlineZipUrl(), new b(String.valueOf(i3 / 100.0f)));
    }

    private void s(int i3) {
        if (this.F.f270415c == null) {
            return;
        }
        i iVar = this.G;
        if (iVar != null) {
            iVar.a(this);
        }
        DataModel.MakeUpItem makeUpItem = this.F.f270415c;
        if (makeUpItem == DataModel.MakeUpItem.ORIGIN) {
            BeautyProcessor.n().h(2);
            return;
        }
        TrafficStats.setThreadStatsTag(-255);
        AEMetaDataUtils.k(makeUpItem.getId(), makeUpItem.getOnlineZipUrl(), new a(String.valueOf(i3 / 100.0f)));
    }

    private void t(boolean z16) {
        int i3;
        ImageView imageView = this.C;
        int i16 = 0;
        if (imageView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            imageView.setVisibility(i3);
        }
        View view = this.D;
        if (view != null) {
            if (!z16) {
                i16 = 4;
            }
            view.setVisibility(i16);
        }
    }

    private void u(CategoryItem.a aVar) {
        int i3;
        DataModel.FilterItem filterItem = aVar.f270416d;
        if (filterItem != null && filterItem.getId() != null) {
            if (AEMetaDataUtils.o(aVar.f270416d.getId() + "", aVar.f270416d.getOnlineZipUrl() + "").booleanValue()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            m(i3);
            return;
        }
        m(0);
    }

    private void w(CategoryItem.a aVar) {
        int i3;
        DataModel.MakeUpItem makeUpItem = aVar.f270415c;
        if (makeUpItem != null && makeUpItem.getId() != null) {
            if (AEMetaDataUtils.p(aVar.f270415c.getId() + "", aVar.f270415c.getOnlineZipUrl() + "").booleanValue()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            m(i3);
            return;
        }
        m(0);
    }

    private void x() {
        CategoryItem.a aVar = this.F;
        if (aVar == null) {
            return;
        }
        int i3 = aVar.f270413a;
        if (i3 == 2) {
            w(aVar);
        } else if (i3 == 3) {
            u(aVar);
        } else {
            m(0);
        }
    }

    public CategoryItem.a i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (CategoryItem.a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.F;
    }

    public void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (this.I == 1) {
            return;
        }
        if (i3 != 0 && i3 != 1) {
            if (i3 == 2) {
                t(true);
                q(false);
            } else if (i3 == 3) {
                t(false);
                q(true);
            }
        } else {
            t(false);
            q(false);
        }
        this.I = i3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CategoryItem.a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
        } else if (this.f270585h != null && (aVar = this.F) != null) {
            int a16 = aVar.a();
            this.f270585h.setProgress(a16);
            StartPointSeekBar.s(this.f270585h, a16, this.f270586i);
            this.F.m(true);
            g(a16);
            j();
            v();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setData(CategoryItem.a aVar, CategoryItem.a aVar2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, aVar, aVar2, Boolean.valueOf(z16));
            return;
        }
        this.F = aVar;
        if (aVar == null) {
            return;
        }
        x();
        l(this.F.e(), aVar.d());
        this.f270582d.setText(this.F.i());
        v();
        if (aVar != aVar2) {
            z17 = false;
        }
        setSelected(z17);
        if (!z16) {
            return;
        }
        if (aVar2 == null) {
            this.f270587m.setVisibility(4);
        } else if (aVar == aVar2 && !DataModel.i().l(aVar)) {
            j();
        }
    }

    public void setItemResDownloadListener(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) hVar);
        } else {
            this.H = hVar;
        }
    }

    public void setListener(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iVar);
        } else {
            this.G = iVar;
        }
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        QQLiveLoadingView qQLiveLoadingView = this.E;
        if (qQLiveLoadingView != null || i3 < this.J) {
            if (qQLiveLoadingView != null) {
                qQLiveLoadingView.setProgressOnly(i3);
            }
            this.J = i3;
        }
    }

    public void setSeekBar(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            if (view == null) {
                return;
            }
            this.f270585h = (StartPointSeekBar) view.findViewById(R.id.uri);
            this.f270586i = (TextView) view.findViewById(R.id.f10506650);
            this.f270587m = view.findViewById(R.id.f81804f6);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        super.setSelected(z16);
        this.F.m(z16);
        this.f270583e.setSelected(z16);
        if (DataModel.i().m(this.F)) {
            v();
        }
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        CategoryItem.a aVar = this.F;
        if (aVar == null) {
            this.f270583e.setVisibility(4);
            return;
        }
        int i3 = aVar.f270413a;
        if (i3 != 0 && i3 != 2 && i3 != 3) {
            DataModel.BeautyItem beautyItem = aVar.f270414b;
            if (beautyItem != DataModel.BeautyItem.NONE && beautyItem != DataModel.BeautyItem.RESET) {
                if (DataModel.i().m(this.F)) {
                    if (this.F.j() && this.F.a() != 0) {
                        this.f270583e.setVisibility(0);
                        return;
                    } else {
                        this.f270583e.setVisibility(4);
                        return;
                    }
                }
                if (this.F.a() != 0) {
                    this.f270583e.setVisibility(0);
                    return;
                } else {
                    this.f270583e.setVisibility(4);
                    return;
                }
            }
            this.f270583e.setVisibility(4);
            return;
        }
        this.f270583e.setVisibility(4);
    }

    public EffectPageItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.I = 0;
        this.J = 0;
        this.K = new g();
        k();
    }

    public EffectPageItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.I = 0;
        this.J = 0;
        this.K = new g();
        k();
    }
}
