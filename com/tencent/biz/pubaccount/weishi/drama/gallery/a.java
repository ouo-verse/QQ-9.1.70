package com.tencent.biz.pubaccount.weishi.drama.gallery;

import UserGrowth.stDramaInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.view.RoundCornerImageView;
import com.tencent.mobileqq.R;
import lz.c;
import mz.d;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends c<d> {
    private static final int E = r.H(7.5f);
    private TextView C;
    private String D;

    /* renamed from: f, reason: collision with root package name */
    private RoundCornerImageView f80694f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f80695h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f80696i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f80697m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.weishi.drama.gallery.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class ViewOnClickListenerC0823a implements View.OnClickListener {
        ViewOnClickListenerC0823a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((c) a.this).f415796d != null) {
                a.this.e();
            }
        }
    }

    private void j() {
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) this.itemView.findViewById(R.id.uls);
        this.f80694f = roundCornerImageView;
        roundCornerImageView.setCorner(E, 0);
        this.f80695h = (ImageView) this.itemView.findViewById(R.id.ult);
        this.f80696i = (TextView) this.itemView.findViewById(R.id.ulv);
        this.f80697m = (TextView) this.itemView.findViewById(R.id.ulw);
        this.C = (TextView) this.itemView.findViewById(R.id.ulu);
    }

    private void l() {
        this.itemView.setOnClickListener(new ViewOnClickListenerC0823a());
    }

    private void m(stDramaInfo stdramainfo) {
        this.f80696i.setText(vz.a.e(getContext(), stdramainfo));
    }

    @Override // lz.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void bindData(d dVar) {
        super.bindData(dVar);
        b(dVar.isChecked());
        stDramaInfo stdramainfo = dVar.e().dramaInfo;
        m(stdramainfo);
        this.f80697m.setText(stdramainfo.name);
        this.C.setText(stdramainfo.recmdDesc);
        WSPicLoader.g().n(this.f80694f, stdramainfo.coverImg, r.i(R.color.ajp), "", 0);
    }

    public void k(a aVar) {
        tz.a.l(aVar.d(), getAdapterPosition(), this.D);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // lz.c
    public void b(boolean z16) {
        if (z16) {
            this.f80695h.setImageResource(R.drawable.k7q);
            this.f80696i.setTextColor(-16777216);
        } else {
            this.f80695h.setImageResource(R.drawable.k7p);
            this.f80696i.setTextColor(-1);
        }
    }

    public a(ViewGroup viewGroup, String str, lz.b<d> bVar) {
        super(viewGroup, R.layout.fvv, bVar);
        this.D = str;
        j();
        l();
    }
}
