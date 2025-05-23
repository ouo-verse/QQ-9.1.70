package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.ae.view.AEDownLoadingView;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.utils.NetworkUtil;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends RecyclerView.ViewHolder {
    private TextView C;
    private TextView D;
    private TextView E;

    /* renamed from: d, reason: collision with root package name */
    ImageView f63048d;

    /* renamed from: e, reason: collision with root package name */
    private URLImageView f63049e;

    /* renamed from: f, reason: collision with root package name */
    AEDownLoadingView f63050f;

    /* renamed from: h, reason: collision with root package name */
    private Context f63051h;

    /* renamed from: i, reason: collision with root package name */
    private View f63052i;

    /* renamed from: m, reason: collision with root package name */
    private View f63053m;

    public a(Context context, View view) {
        super(view);
        this.f63051h = context;
        this.f63049e = (URLImageView) view.findViewById(R.id.s2g);
        this.f63048d = (ImageView) view.findViewById(R.id.f163745rs2);
        this.f63050f = (AEDownLoadingView) view.findViewById(R.id.rys);
        this.f63052i = view.findViewById(R.id.s0p);
        this.C = (TextView) view.findViewById(R.id.ruh);
        this.D = (TextView) view.findViewById(R.id.rug);
        this.f63052i.setVisibility(8);
        this.E = (TextView) view.findViewById(R.id.f163736rq3);
        this.f63053m = view.findViewById(R.id.rzi);
        int f16 = BaseAIOUtils.f(6.0f, this.f63050f.getResources());
        int f17 = BaseAIOUtils.f(2.0f, this.f63050f.getResources());
        int f18 = BaseAIOUtils.f(16.0f, this.f63050f.getResources());
        this.f63050f.setBgCorner(f18 / 2);
        this.f63050f.setMinimumHeight(f18);
        this.f63050f.setMinimumWidth(f18);
        this.f63050f.setProgressSizeAndMode(f16, f17, false);
        this.f63050f.setBgColor(0);
        this.f63050f.setProgressColor(-1);
        this.f63050f.setBgColor(-1);
        this.f63050f.setProgressColor(-16725252);
        this.f63050f.b(false);
    }

    public void b(AEARCakeMaterial aEARCakeMaterial) {
        URLImageView uRLImageView = this.f63049e;
        com.tencent.aelight.camera.ae.flashshow.util.v.c(uRLImageView, aEARCakeMaterial.iconurl, com.tencent.aelight.camera.ae.flashshow.util.v.a(uRLImageView.getContext(), 67.0f), com.tencent.aelight.camera.ae.flashshow.util.v.a(this.f63049e.getContext(), 67.0f), this.f63051h.getResources().getDrawable(R.drawable.iz5), null);
    }

    public void c(String str) {
        this.E.setText(str);
    }

    public void d(int i3) {
        this.f63048d.setVisibility(i3);
    }

    public void e(int i3) {
        this.f63050f.setVisibility(i3);
    }

    public void g(int i3) {
        this.f63053m.setVisibility(i3);
    }

    public void h(int i3) {
        this.f63052i.setVisibility(i3);
    }

    public void i(AEMaterialMetaData aEMaterialMetaData) {
        if (aEMaterialMetaData.usable) {
            d(8);
            e(8);
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(this.f63051h)) {
            ms.a.c("AEARCakeMaterialHolder", "net work not available");
            d(0);
            e(8);
        } else if (aEMaterialMetaData.downloading) {
            d(8);
            e(0);
            this.f63050f.setProgress(aEMaterialMetaData.downloadProgress);
        } else {
            d(0);
            e(8);
        }
    }

    public void f(String str) {
        if (str == null) {
            this.C.setText(R.string.y7u);
            this.D.setText(R.string.y7s);
        } else if (str.length() <= 4) {
            this.D.setText(R.string.y7s);
            this.C.setText(str);
        } else {
            this.C.setText(str.substring(0, 4));
            this.D.setText(R.string.y7t);
        }
    }
}
