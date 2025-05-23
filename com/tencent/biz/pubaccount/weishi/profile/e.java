package com.tencent.biz.pubaccount.weishi.profile;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e extends z10.a<j, f> {
    private String G;
    private a H;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a(z10.b<j> bVar);
    }

    public e(Context context) {
        super(context);
    }

    public void A0(a aVar) {
        this.H = aVar;
    }

    @Override // z10.a
    public int u0(int i3) {
        return 0;
    }

    public String v0() {
        return this.G;
    }

    @Override // z10.c
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public void l0(f fVar, int i3) {
        fVar.m(getDataList().get(i3));
    }

    @Override // z10.c
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public f n0(ViewGroup viewGroup, int i3) {
        return new f(viewGroup, this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(z10.b<j> bVar) {
        super.onViewAttachedToWindow(bVar);
        a aVar = this.H;
        if (aVar != null) {
            aVar.a(bVar);
        }
    }

    public void z0(String str) {
        this.G = str;
    }
}
