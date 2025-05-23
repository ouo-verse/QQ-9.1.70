package com.tencent.biz.pubaccount.weishi.recommend.holder;

import android.view.ViewGroup;
import com.tencent.widget.pull2refresh.BaseViewHolder;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class a<T> extends BaseViewHolder<T> {

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.biz.pubaccount.weishi.baseui.c<T> f81435d;

    /* renamed from: e, reason: collision with root package name */
    public T f81436e;

    /* renamed from: f, reason: collision with root package name */
    protected com.tencent.biz.pubaccount.weishi.t f81437f;

    public a(ViewGroup viewGroup, int i3, int i16, com.tencent.biz.pubaccount.weishi.t tVar) {
        super(viewGroup, i3);
        this.f81437f = tVar;
        this.f81435d = b(i16);
    }

    public abstract com.tencent.biz.pubaccount.weishi.baseui.c<T> b(int i3);

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    public void bindData(T t16) {
        super.bindData(t16);
        this.f81436e = t16;
        this.f81435d.setData(t16);
    }
}
