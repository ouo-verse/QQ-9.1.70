package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.view.AEDownLoadingView;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class bz extends RecyclerView.ViewHolder {
    public TextView C;
    private int D;
    private Context E;

    /* renamed from: d, reason: collision with root package name */
    public URLImageView f63176d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f63177e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f63178f;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f63179h;

    /* renamed from: i, reason: collision with root package name */
    public AEDownLoadingView f63180i;

    /* renamed from: m, reason: collision with root package name */
    public RelativeLayout f63181m;

    public bz(View view) {
        super(view);
        this.D = 0;
        this.f63176d = (URLImageView) view.findViewById(R.id.s2g);
        this.f63177e = (ImageView) view.findViewById(R.id.s0n);
        this.f63178f = (ImageView) view.findViewById(R.id.f163747rs4);
        this.f63179h = (ImageView) view.findViewById(R.id.s2y);
        this.f63180i = (AEDownLoadingView) view.findViewById(R.id.rys);
        this.f63181m = (RelativeLayout) view.findViewById(R.id.f163814s51);
        this.C = (TextView) view.findViewById(R.id.s3i);
    }

    private static int b(boolean z16) {
        if (z16) {
            return 0;
        }
        return 8;
    }

    private void d(AEMaterialMetaData aEMaterialMetaData) {
        if (TextUtils.isEmpty(aEMaterialMetaData.iconurl)) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        int f16 = BaseAIOUtils.f(60.0f, this.E.getResources());
        Drawable drawable = this.E.getResources().getDrawable(R.drawable.iz5);
        obtain.mRequestWidth = f16;
        obtain.mRequestHeight = f16;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        obtain.mRetryCount = 3;
        URLDrawable drawable2 = URLDrawable.getDrawable(aEMaterialMetaData.iconurl, obtain);
        if (drawable2.getStatus() == 2) {
            drawable2.restartDownload();
        }
        this.f63176d.setImageDrawable(drawable2);
    }

    private void f(AEMaterialMetaData aEMaterialMetaData) {
        this.f63177e.setVisibility(8);
        this.f63178f.setVisibility(8);
        this.f63179h.setVisibility(8);
        this.f63181m.setVisibility(8);
    }

    private void g(AEMaterialMetaData aEMaterialMetaData) {
        this.f63177e.setVisibility(0);
        this.f63177e.setImageResource(R.drawable.iru);
        i(aEMaterialMetaData);
        k(aEMaterialMetaData);
        this.f63181m.setVisibility(b(aEMaterialMetaData.editablewatermark));
    }

    private void h(AEMaterialMetaData aEMaterialMetaData) {
        this.f63177e.setVisibility(8);
        i(aEMaterialMetaData);
        k(aEMaterialMetaData);
        this.f63181m.setVisibility(b(aEMaterialMetaData.editablewatermark));
    }

    private void i(AEMaterialMetaData aEMaterialMetaData) {
        if (aEMaterialMetaData.isWsBanner()) {
            this.f63178f.setVisibility(8);
            this.f63180i.setVisibility(8);
            return;
        }
        if (aEMaterialMetaData.usable) {
            this.f63178f.setVisibility(8);
            this.f63180i.setVisibility(8);
        } else if (aEMaterialMetaData.downloading) {
            this.f63178f.setVisibility(8);
            this.f63180i.setVisibility(0);
            this.f63180i.setProgress(aEMaterialMetaData.downloadProgress);
        } else {
            this.f63178f.setVisibility(0);
            this.f63178f.setImageResource(R.drawable.iz6);
            this.f63180i.setVisibility(8);
        }
    }

    private void j(AEMaterialMetaData aEMaterialMetaData) {
        int i3 = this.D;
        if (i3 == 0) {
            f(aEMaterialMetaData);
            return;
        }
        if (i3 == 1) {
            h(aEMaterialMetaData);
            d(aEMaterialMetaData);
        } else if (i3 != 2) {
            f(aEMaterialMetaData);
        } else {
            g(aEMaterialMetaData);
            d(aEMaterialMetaData);
        }
    }

    private void k(AEMaterialMetaData aEMaterialMetaData) {
        if (aEMaterialMetaData.isWsBanner()) {
            this.f63179h.setVisibility(0);
            this.f63179h.setImageResource(R.drawable.f6x);
        } else if (aEMaterialMetaData.needDisplayType()) {
            this.f63179h.setVisibility(0);
            this.f63179h.setImageResource(aEMaterialMetaData.getDisplayIconByType());
        } else {
            this.f63179h.setVisibility(8);
        }
    }

    public void c(Context context) {
        this.E = context;
        int f16 = BaseAIOUtils.f(6.0f, context.getResources());
        int f17 = BaseAIOUtils.f(2.0f, context.getResources());
        int f18 = BaseAIOUtils.f(16.0f, context.getResources());
        this.f63180i.setBgCorner(f18 / 2);
        this.f63180i.setMinimumHeight(f18);
        this.f63180i.setMinimumWidth(f18);
        this.f63180i.setProgressSizeAndMode(f16, f17, false);
        this.f63180i.setBgColor(-1);
        this.f63180i.setProgressColor(-16725252);
        this.f63180i.b(false);
    }

    public void e(int i3, AEMaterialMetaData aEMaterialMetaData) {
        this.D = i3;
        j(aEMaterialMetaData);
    }
}
