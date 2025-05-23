package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.widget.pull2refresh.BaseViewHolder;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class e<T> extends BaseViewHolder<T> {

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.biz.pubaccount.weishi.baseui.c<T> f82127d;

    /* renamed from: e, reason: collision with root package name */
    public WSVerticalPageFragment f82128e;

    /* renamed from: f, reason: collision with root package name */
    public T f82129f;

    public e(ViewGroup viewGroup, int i3, int i16, WSVerticalPageFragment wSVerticalPageFragment) {
        super(viewGroup, i3);
        this.f82128e = wSVerticalPageFragment;
        this.f82127d = b(i16);
    }

    public abstract com.tencent.biz.pubaccount.weishi.baseui.c<T> b(int i3);

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    public void bindData(T t16) {
        super.bindData(t16);
        this.f82129f = t16;
    }

    public abstract FrameLayout c();

    public abstract void d(int i3);

    public abstract void e(int i3);
}
