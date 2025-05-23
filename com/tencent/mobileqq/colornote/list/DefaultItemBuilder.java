package com.tencent.mobileqq.colornote.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.internal.view.SupportMenu;
import com.airbnb.lottie.Cancellable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.list.ColorNoteListLayoutV2;
import com.tencent.mobileqq.colornote.list.a;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.colornote.smallscreen.UpComingMsgModel;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.cz;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DefaultItemBuilder implements g {

    /* renamed from: a, reason: collision with root package name */
    private Cancellable f201466a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.colornote.list.DefaultItemBuilder$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f201467d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f201468e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ a.d f201469f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f201470h;

        AnonymousClass1(String str, String str2, a.d dVar, boolean z16) {
            this.f201467d = str;
            this.f201468e = str2;
            this.f201469f = dVar;
            this.f201470h = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                InputStream open = BaseApplication.getContext().getAssets().open(this.f201467d);
                DefaultItemBuilder.this.f201466a = LottieComposition.Factory.fromInputStream(open, new OnCompositionLoadedListener() { // from class: com.tencent.mobileqq.colornote.list.DefaultItemBuilder.1.1
                    @Override // com.airbnb.lottie.OnCompositionLoadedListener
                    public void onCompositionLoaded(LottieComposition lottieComposition) {
                        if (lottieComposition == null) {
                            QLog.e("DefaultItemBuilder", 1, "getLottieDrawable onCompositionLoaded failed");
                            return;
                        }
                        LottieDrawable lottieDrawable = new LottieDrawable();
                        lottieDrawable.setComposition(lottieComposition);
                        lottieDrawable.setImagesAssetsFolder(AnonymousClass1.this.f201468e);
                        lottieDrawable.setColorFilter(-16777216, PorterDuff.Mode.MULTIPLY);
                        AnonymousClass1.this.f201469f.F = lottieDrawable;
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.colornote.list.DefaultItemBuilder.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                if (!anonymousClass1.f201470h) {
                                    DefaultItemBuilder.this.m(anonymousClass1.f201469f);
                                }
                            }
                        });
                    }
                });
            } catch (Throwable th5) {
                QLog.e("DefaultItemBuilder", 2, "load lottie failed", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.colornote.list.DefaultItemBuilder$2, reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f201473d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f201474e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ColorNoteListLayoutV2.e f201475f;

        AnonymousClass2(String str, String str2, ColorNoteListLayoutV2.e eVar) {
            this.f201473d = str;
            this.f201474e = str2;
            this.f201475f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                InputStream open = BaseApplication.getContext().getAssets().open(this.f201473d);
                DefaultItemBuilder.this.f201466a = LottieComposition.Factory.fromInputStream(open, new OnCompositionLoadedListener() { // from class: com.tencent.mobileqq.colornote.list.DefaultItemBuilder.2.1
                    @Override // com.airbnb.lottie.OnCompositionLoadedListener
                    public void onCompositionLoaded(LottieComposition lottieComposition) {
                        if (lottieComposition == null) {
                            QLog.e("DefaultItemBuilder", 1, "getLottieDrawable onCompositionLoaded failed");
                            return;
                        }
                        LottieDrawable lottieDrawable = new LottieDrawable();
                        lottieDrawable.setComposition(lottieComposition);
                        lottieDrawable.setImagesAssetsFolder(AnonymousClass2.this.f201474e);
                        lottieDrawable.setColorFilter(-16777216, PorterDuff.Mode.MULTIPLY);
                        AnonymousClass2.this.f201475f.f201464h = lottieDrawable;
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.colornote.list.DefaultItemBuilder.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                DefaultItemBuilder.this.n(anonymousClass2.f201475f);
                            }
                        });
                    }
                });
            } catch (Throwable th5) {
                QLog.e("DefaultItemBuilder", 2, "load lottie failed", th5);
            }
        }
    }

    private Drawable h(ColorNote colorNote, Resources resources) {
        Drawable drawable;
        int i3 = i(colorNote);
        try {
            URL url = new URL(colorNote.getPicUrl());
            if (ProtocolDownloaderConstants.PROTOCOL_RES_DRAWABLE.equals(url.getProtocol())) {
                try {
                    drawable = resources.getDrawable(Integer.parseInt(url.getHost()));
                } catch (Throwable th5) {
                    Drawable drawable2 = resources.getDrawable(i3);
                    QLog.e("DefaultItemBuilder", 1, "service type: " + colorNote.getServiceType() + " url error.", th5);
                    drawable = drawable2;
                }
            } else if (ProtocolDownloaderConstants.PROTOCAL_UIN_DRAWABLE.equals(url.getProtocol())) {
                drawable = cz.b(url.getQuery());
            } else {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = Utils.n(40.0f, resources);
                obtain.mRequestHeight = Utils.n(40.0f, resources);
                Drawable drawable3 = resources.getDrawable(i3);
                obtain.mLoadingDrawable = drawable3;
                obtain.mFailedDrawable = drawable3;
                drawable = URLDrawable.getDrawable(url, obtain);
            }
            return drawable;
        } catch (Throwable th6) {
            Drawable drawable4 = resources.getDrawable(i3);
            QLog.e("DefaultItemBuilder", 1, th6, new Object[0]);
            return drawable4;
        }
    }

    public static int i(ColorNote colorNote) {
        int k3 = com.tencent.mobileqq.colornote.data.a.k(colorNote.getServiceType()) & SupportMenu.CATEGORY_MASK;
        if (k3 != 16842752) {
            if (k3 != 16908288) {
                if (k3 != 16973824) {
                    if (k3 != 17039360) {
                        if (k3 != 17104896) {
                            if (k3 == 17170432 || k3 == 17235968 || k3 == 17301504) {
                                return R.drawable.f160830com;
                            }
                            if (k3 != 17367040) {
                                return R.drawable.f161608ea0;
                            }
                            return R.drawable.e__;
                        }
                        return R.drawable.htg;
                    }
                    return R.drawable.hml;
                }
                return R.drawable.e__;
            }
            return R.drawable.hmn;
        }
        return R.drawable.hmm;
    }

    private void j(Context context, a.d dVar, String str, String str2, boolean z16) {
        Drawable drawable = dVar.F;
        ThreadManagerV2.excute(new AnonymousClass1(str, str2, dVar, z16), 16, null, true);
    }

    private void k(ColorNoteListLayoutV2.e eVar, String str, String str2) {
        if (eVar.f201464h instanceof LottieDrawable) {
            n(eVar);
        } else {
            ThreadManagerV2.excute(new AnonymousClass2(str, str2, eVar), 16, null, true);
        }
    }

    private Drawable l(ColorNoteListLayoutV2.e eVar, Resources resources) {
        com.tencent.mobileqq.colornote.anim.c cVar = new com.tencent.mobileqq.colornote.anim.c();
        cVar.a(eVar.f201457a.getContext(), Utils.n(20.0f, resources), Utils.n(20.0f, resources), Color.parseColor("#0099FF"));
        eVar.f201463g.setVisibility(8);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(a.d dVar) {
        if (dVar != null && dVar.F != null) {
            QLog.d("DefaultItemBuilder", 4, "play animation");
            LottieDrawable lottieDrawable = (LottieDrawable) dVar.F;
            lottieDrawable.setRepeatCount(-1);
            lottieDrawable.playAnimation();
            dVar.D.setImageDrawable(lottieDrawable);
            dVar.D.setVisibility(0);
            dVar.f201491i.setMaxWidth(ViewUtils.dip2px(179.0f));
            return;
        }
        QLog.e("DefaultItemBuilder", 1, "lottie loaded but still null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(ColorNoteListLayoutV2.e eVar) {
        if (eVar != null && eVar.f201464h != null) {
            QLog.d("DefaultItemBuilder", 4, "play animation");
            LottieDrawable lottieDrawable = (LottieDrawable) eVar.f201464h;
            lottieDrawable.setRepeatCount(-1);
            lottieDrawable.playAnimation();
            eVar.f201465i.setImageDrawable(lottieDrawable);
            eVar.f201465i.setVisibility(0);
            eVar.f201462f.setMaxWidth(ViewUtils.dip2px(150.0f));
            return;
        }
        QLog.e("DefaultItemBuilder", 1, "lottie loaded but still null");
    }

    private void o(ColorNoteListLayoutV2.e eVar, ColorNote colorNote) {
        if (!com.tencent.mobileqq.colornote.data.a.x(colorNote)) {
            return;
        }
        if (com.tencent.mobileqq.colornote.data.a.u(colorNote)) {
            k(eVar, "colornote_clock_black/data.json", "colornote_clock_black/images");
        }
        eVar.f201462f.setCompoundDrawables(null, null, null, null);
        UpComingMsgModel e16 = ColorNoteSmallScreenUtil.e(colorNote);
        int c16 = x.c(eVar.f201462f.getContext(), 199.0f);
        if (com.tencent.mobileqq.colornote.data.a.u(colorNote)) {
            c16 = x.c(eVar.f201462f.getContext(), 150.0f);
        }
        int i3 = c16;
        if (e16.uniseq.size() > 1) {
            eVar.f201462f.setMaxWidth(i3);
            ColorNoteSmallScreenUtil.a(eVar.f201462f, colorNote.getMainTitle(), i3, TextUtils.TruncateAt.MIDDLE, "\u7684", 0);
        } else {
            ColorNoteSmallScreenUtil.a(eVar.f201462f, colorNote.getMainTitle(), i3, TextUtils.TruncateAt.END, null, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.colornote.list.g
    public void a(ColorNoteListLayoutV2.e eVar, int i3, ColorNote colorNote) {
        if (colorNote == null) {
            return;
        }
        Resources resources = eVar.f201457a.getContext().getResources();
        eVar.f201465i.setVisibility(8);
        eVar.f201462f.setMaxWidth(ViewUtils.dip2px(199.0f));
        int k3 = com.tencent.mobileqq.colornote.data.a.k(colorNote.getServiceType() & SupportMenu.CATEGORY_MASK);
        if (k3 != 16973824) {
            if (k3 != 17235968) {
                if (k3 != 17367040) {
                    eVar.f201458b.setImageDrawable(h(colorNote, resources));
                }
            } else {
                Drawable h16 = h(colorNote, resources);
                o(eVar, colorNote);
                eVar.f201458b.setImageDrawable(h16);
            }
            eVar.f201462f.setText(colorNote.getMainTitle());
            eVar.f201463g.setText(colorNote.getSubTitle());
        }
        Drawable l3 = l(eVar, resources);
        eVar.f201458b.setVisibility(8);
        eVar.f201459c.setVisibility(0);
        eVar.f201459c.setImageDrawable(l3);
        ((com.tencent.mobileqq.colornote.anim.b) l3).start(1200);
        eVar.f201462f.setText(colorNote.getMainTitle());
        eVar.f201463g.setText(colorNote.getSubTitle());
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0137  */
    @Override // com.tencent.mobileqq.colornote.list.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(a.d dVar, int i3, boolean z16) {
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        ColorNote b16 = dVar.b(i3);
        dVar.f201490h.setImageDrawable(h(b16, dVar.f201490h.getContext().getResources()));
        dVar.D.setVisibility(8);
        dVar.f201491i.setMaxWidth(ViewUtils.dip2px(199.0f));
        boolean w3 = com.tencent.mobileqq.colornote.data.a.w(b16);
        int k3 = com.tencent.mobileqq.colornote.data.a.k(b16.getServiceType() & SupportMenu.CATEGORY_MASK);
        if (k3 != 16842752) {
            if (k3 != 16908288 && k3 != 16908290) {
                if (k3 != 16973824) {
                    if (k3 != 17039360) {
                        if (k3 != 17104896) {
                            if (k3 != 17170432) {
                                if (k3 != 17235968) {
                                    if (k3 != 17301504) {
                                        if (k3 != 17367040) {
                                            dVar.f201491i.setCompoundDrawables(null, null, null, null);
                                        }
                                    }
                                } else {
                                    View view = dVar.f201488e;
                                    if (z16) {
                                        i28 = R.drawable.jh_;
                                    } else {
                                        i28 = R.drawable.jha;
                                    }
                                    view.setBackgroundResource(i28);
                                    dVar.f201489f.setBackgroundResource(R.drawable.jhb);
                                    dVar.f201491i.setCompoundDrawables(null, null, null, null);
                                    if (com.tencent.mobileqq.colornote.data.a.u(b16)) {
                                        j(dVar.f201490h.getContext(), dVar, "colornote/data_black.json", "colornote/images", false);
                                    }
                                }
                            } else {
                                dVar.f201491i.setCompoundDrawables(null, null, null, null);
                                View view2 = dVar.f201488e;
                                if (z16) {
                                    i27 = R.drawable.au_;
                                } else {
                                    i27 = R.drawable.axd;
                                }
                                view2.setBackgroundResource(i27);
                                dVar.f201489f.setBackgroundResource(R.drawable.cfx);
                            }
                        }
                    } else {
                        dVar.f201491i.setCompoundDrawables(null, null, null, null);
                        View view3 = dVar.f201488e;
                        if (z16) {
                            i26 = R.drawable.hbl;
                        } else {
                            i26 = R.drawable.hbm;
                        }
                        view3.setBackgroundResource(i26);
                        dVar.f201489f.setBackgroundResource(R.drawable.hmo);
                    }
                    if (w3) {
                        View view4 = dVar.f201488e;
                        if (z16) {
                            i17 = R.drawable.f160480jp;
                        } else {
                            i17 = R.drawable.f160481js;
                        }
                        view4.setBackgroundResource(i17);
                    }
                    dVar.f201491i.setText(b16.getMainTitle());
                    dVar.f201492m.setText(b16.getSubTitle());
                }
                dVar.f201491i.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, dVar.F, (Drawable) null);
                ((com.tencent.mobileqq.colornote.anim.b) dVar.F).start(300);
                View view5 = dVar.f201488e;
                if (z16) {
                    i19 = R.drawable.hbr;
                } else {
                    i19 = R.drawable.hbs;
                }
                view5.setBackgroundResource(i19);
                dVar.f201489f.setBackgroundResource(R.drawable.hmq);
                if (w3) {
                }
                dVar.f201491i.setText(b16.getMainTitle());
                dVar.f201492m.setText(b16.getSubTitle());
            }
            dVar.f201491i.setCompoundDrawables(null, null, null, null);
            View view6 = dVar.f201488e;
            if (z16) {
                i18 = R.drawable.hbu;
            } else {
                i18 = R.drawable.hbv;
            }
            view6.setBackgroundResource(i18);
            dVar.f201489f.setBackgroundResource(R.drawable.hmr);
            if (w3) {
            }
            dVar.f201491i.setText(b16.getMainTitle());
            dVar.f201492m.setText(b16.getSubTitle());
        }
        dVar.f201491i.setCompoundDrawables(null, null, null, null);
        View view7 = dVar.f201488e;
        if (z16) {
            i16 = R.drawable.hbo;
        } else {
            i16 = R.drawable.hbp;
        }
        view7.setBackgroundResource(i16);
        dVar.f201489f.setBackgroundResource(R.drawable.hmp);
        if (w3) {
        }
        dVar.f201491i.setText(b16.getMainTitle());
        dVar.f201492m.setText(b16.getSubTitle());
    }

    public void f(ColorNote colorNote, View view, ImageView imageView, boolean z16) {
        int g16 = g(colorNote, z16);
        if (g16 != 0) {
            view.setBackgroundResource(g16);
        }
        imageView.setImageDrawable(h(colorNote, view.getContext().getResources()));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int g(ColorNote colorNote, boolean z16) {
        int i3;
        int i16;
        int serviceType = colorNote.getServiceType() & SupportMenu.CATEGORY_MASK;
        if (serviceType != 16842752) {
            if (serviceType != 16908288 && serviceType != 16908290) {
                if (serviceType != 16973824) {
                    if (serviceType != 17039360) {
                        if (serviceType != 17104896) {
                            if (serviceType != 17170432) {
                                if (serviceType != 17235968) {
                                    if (serviceType != 17301504) {
                                        if (serviceType != 17367040) {
                                            i3 = 0;
                                        }
                                    }
                                } else if (z16) {
                                    i3 = R.drawable.jh_;
                                } else {
                                    i3 = R.drawable.jha;
                                }
                            } else if (z16) {
                                i3 = R.drawable.au_;
                            } else {
                                i3 = R.drawable.axd;
                            }
                        }
                    } else if (z16) {
                        i3 = R.drawable.hbl;
                    } else {
                        i3 = R.drawable.hbm;
                    }
                    if (!com.tencent.mobileqq.colornote.data.a.w(colorNote)) {
                        if (z16) {
                            i16 = R.drawable.f160480jp;
                        } else {
                            i16 = R.drawable.f160481js;
                        }
                        return i16;
                    }
                    return i3;
                }
                if (z16) {
                    i3 = R.drawable.hbr;
                } else {
                    i3 = R.drawable.hbs;
                }
                if (!com.tencent.mobileqq.colornote.data.a.w(colorNote)) {
                }
            }
            if (z16) {
                i3 = R.drawable.hbu;
            } else {
                i3 = R.drawable.hbv;
            }
            if (!com.tencent.mobileqq.colornote.data.a.w(colorNote)) {
            }
        }
        if (z16) {
            i3 = R.drawable.hbo;
        } else {
            i3 = R.drawable.hbp;
        }
        if (!com.tencent.mobileqq.colornote.data.a.w(colorNote)) {
        }
    }
}
