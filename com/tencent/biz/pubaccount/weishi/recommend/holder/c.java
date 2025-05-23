package com.tencent.biz.pubaccount.weishi.recommend.holder;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.view.RoundCornerImageView;
import com.tencent.mobileqq.R;
import com.tencent.widget.pull2refresh.BaseViewHolder;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends BaseViewHolder<mz.h> {

    /* renamed from: d, reason: collision with root package name */
    private RoundCornerImageView f81440d;

    /* renamed from: e, reason: collision with root package name */
    private View f81441e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f81442f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f81443h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f81444i;

    public c(View view) {
        super(view);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) view.findViewById(R.id.f75103y2);
        this.f81440d = roundCornerImageView;
        roundCornerImageView.setCorner(ba.f81748w, 0);
        this.f81441e = view.findViewById(R.id.f107516am);
        this.f81442f = (TextView) view.findViewById(R.id.f107506al);
        this.f81443h = (TextView) view.findViewById(R.id.f107496ak);
        this.f81444i = (TextView) view.findViewById(R.id.f107526an);
    }

    private static String c(mz.h hVar) {
        if (hVar.f()) {
            return com.tencent.biz.pubaccount.weishi.util.r.j(R.string.f241817sw, Integer.valueOf(hVar.a()));
        }
        return com.tencent.biz.pubaccount.weishi.util.r.j(R.string.f241847sz, Integer.valueOf(hVar.a()));
    }

    private static String d(mz.h hVar) {
        int b16 = hVar.b();
        if (b16 == 0) {
            return com.tencent.biz.pubaccount.weishi.util.r.m(R.string.f241837sy);
        }
        return com.tencent.biz.pubaccount.weishi.util.r.j(R.string.f241857t0, Integer.valueOf(b16));
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void bindData(mz.h hVar) {
        WSPicLoader.g().w(this.f81440d, hVar.c(), null);
        this.f81441e.setVisibility(hVar.g() ? 0 : 8);
        this.f81442f.setText(hVar.e());
        this.f81443h.setText(c(hVar));
        this.f81444i.setText(d(hVar));
        this.itemView.setTag(hVar.d());
    }
}
