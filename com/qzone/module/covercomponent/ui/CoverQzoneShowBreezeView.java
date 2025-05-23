package com.qzone.module.covercomponent.ui;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qzone.proxy.covercomponent.adapter.CoverBreezeDrawable;
import cooperation.qzone.zipanimate.ZipLoadedListener;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverQzoneShowBreezeView extends ImageView {
    private boolean C;
    private ZipLoadedListener D;

    /* renamed from: d, reason: collision with root package name */
    private int f48679d;

    /* renamed from: e, reason: collision with root package name */
    private Context f48680e;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f48681f;

    /* renamed from: h, reason: collision with root package name */
    private CoverBreezeDrawable f48682h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f48683i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f48684m;

    public CoverQzoneShowBreezeView(Context context, ViewGroup viewGroup) {
        super(context);
        this.f48679d = 16;
        this.f48683i = false;
        this.f48684m = false;
        this.C = false;
        this.D = new ZipLoadedListener() { // from class: com.qzone.module.covercomponent.ui.CoverQzoneShowBreezeView.1
            @Override // cooperation.qzone.zipanimate.ZipLoadedListener
            public void onZipLoaded(final boolean z16) {
                if (CoverQzoneShowBreezeView.this.f48682h != null) {
                    CoverQzoneShowBreezeView.this.post(new Runnable() { // from class: com.qzone.module.covercomponent.ui.CoverQzoneShowBreezeView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CoverQzoneShowBreezeView.this.f48683i = z16;
                            if (CoverQzoneShowBreezeView.this.f48684m) {
                                CoverQzoneShowBreezeView.this.show();
                            }
                        }
                    });
                }
            }
        };
        this.f48680e = context;
        this.f48681f = viewGroup;
        d();
    }

    public void addToParent() {
        ViewGroup viewGroup;
        if (getParent() != null || (viewGroup = this.f48681f) == null) {
            return;
        }
        viewGroup.addView(this, 1, new ViewGroup.LayoutParams(-1, -1));
    }

    public void onDestroy() {
        hide();
        removeFromParent();
        this.f48682h = null;
    }

    public void removeFromParent() {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void d() {
        setWillNotDraw(false);
        this.f48682h = new CoverBreezeDrawable(this.f48680e);
    }

    public void hide() {
        this.f48684m = false;
        if (this.C) {
            this.C = false;
            setImageDrawable(null);
            CoverBreezeDrawable coverBreezeDrawable = this.f48682h;
            if (coverBreezeDrawable != null) {
                coverBreezeDrawable.setVisible(false, true);
                this.f48682h.stop();
            }
        }
    }

    public void setData(final String str, final String str2, final int i3) {
        this.f48683i = false;
        this.f48684m = true;
        this.f48682h.setAnimationListener(this.D);
        this.f48682h.setDisAppearAfterShow(false);
        postDelayed(new Runnable() { // from class: com.qzone.module.covercomponent.ui.CoverQzoneShowBreezeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (CoverQzoneShowBreezeView.this.f48682h != null) {
                    CoverQzoneShowBreezeView.this.f48682h.setDrawableData(str, str2, i3);
                }
            }
        }, 500L);
    }

    public void show() {
        this.f48684m = true;
        if (this.C || !this.f48683i) {
            return;
        }
        this.C = true;
        setImageDrawable(this.f48682h);
        CoverBreezeDrawable coverBreezeDrawable = this.f48682h;
        if (coverBreezeDrawable != null) {
            coverBreezeDrawable.setVisible(true, false);
            this.f48682h.start();
        }
    }
}
