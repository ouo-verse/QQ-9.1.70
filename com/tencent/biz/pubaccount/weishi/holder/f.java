package com.tencent.biz.pubaccount.weishi.holder;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.widget.pull2refresh.BaseViewHolder;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class f<T> extends BaseViewHolder<T> {

    /* renamed from: d, reason: collision with root package name */
    public l f80801d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.biz.pubaccount.weishi.player.e f80802e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.biz.pubaccount.weishi.player.a f80803f;

    public f(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    public abstract ViewGroup b();

    public boolean c() {
        WSPlayerWrapper wSPlayerWrapper;
        com.tencent.biz.pubaccount.weishi.player.e eVar = this.f80802e;
        return (eVar == null || (wSPlayerWrapper = eVar.f81129e) == null || !wSPlayerWrapper.a0()) ? false : true;
    }

    public boolean d() {
        WSPlayerWrapper wSPlayerWrapper;
        com.tencent.biz.pubaccount.weishi.player.e eVar = this.f80802e;
        return (eVar == null || (wSPlayerWrapper = eVar.f81129e) == null || !wSPlayerWrapper.b0()) ? false : true;
    }
}
