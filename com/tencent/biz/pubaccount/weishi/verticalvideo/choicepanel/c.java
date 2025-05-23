package com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.pubaccount.weishi.view.RoundCornerImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends lz.c<j> {

    /* renamed from: f, reason: collision with root package name */
    private RoundCornerImageView f81934f;

    /* renamed from: h, reason: collision with root package name */
    private FeedRichTextView f81935h;

    /* renamed from: i, reason: collision with root package name */
    private GradientDrawable f81936i;

    /* renamed from: m, reason: collision with root package name */
    private static final int f81933m = r.H(5.0f);
    private static final int C = Color.parseColor("#282828");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((lz.c) c.this).f415796d != null) {
                c.this.e();
            }
        }
    }

    private void j() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f81936i = gradientDrawable;
        gradientDrawable.setShape(0);
        this.f81936i.setColor(Color.parseColor("#515151"));
        this.f81936i.setCornerRadius(f81933m);
    }

    private void k() {
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) this.itemView.findViewById(R.id.p3l);
        this.f81934f = roundCornerImageView;
        roundCornerImageView.setCorner(f81933m, 0);
        this.f81935h = (FeedRichTextView) this.itemView.findViewById(R.id.p6n);
    }

    private void l() {
        a aVar = new a();
        this.itemView.setOnClickListener(aVar);
        this.f81935h.setOnClickListener(aVar);
        this.f81934f.setOnClickListener(aVar);
    }

    @Override // lz.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void bindData(j jVar) {
        super.bindData(jVar);
        if (jVar == null || jVar.e() == null) {
            return;
        }
        b(jVar.isChecked());
        this.f81935h.setText(jVar.e().feed_desc);
        WSPicLoader.g().l(this.f81934f, jVar.e(), this.f81936i, "", true, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // lz.c
    public void b(boolean z16) {
        if (z16) {
            this.itemView.setBackgroundColor(C);
        } else {
            this.itemView.setBackgroundColor(-16777216);
        }
    }

    public c(ViewGroup viewGroup, lz.b<j> bVar) {
        super(viewGroup, R.layout.d0j, bVar);
        j();
        k();
        l();
    }
}
