package com.tencent.biz.pubaccount.weishi;

import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.a;
import com.tencent.biz.pubaccount.weishi.d;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i<V extends a, P extends d<V>> implements c {

    /* renamed from: a, reason: collision with root package name */
    private b<V, P> f80850a;

    public i(b<V, P> bVar) {
        if (bVar != null) {
            this.f80850a = bVar;
            return;
        }
        throw new NullPointerException("IWSDelegateCallback is null!");
    }

    private V b() {
        V A8 = this.f80850a.A8();
        if (A8 != null) {
            return A8;
        }
        throw new NullPointerException("View returned from getMvpView() is null");
    }

    private P c() {
        P presenter = this.f80850a.getPresenter();
        if (presenter != null) {
            return presenter;
        }
        throw new NullPointerException("Presenter returned from getPresenter() is null");
    }

    @Override // com.tencent.biz.pubaccount.weishi.c
    public void a(View view, Bundle bundle) {
        c().attachView(b());
    }

    @Override // com.tencent.biz.pubaccount.weishi.c
    public void onCreate(Bundle bundle) {
        P presenter = this.f80850a.getPresenter();
        if (presenter == null) {
            presenter = this.f80850a.V();
        }
        this.f80850a.X3(presenter);
    }

    @Override // com.tencent.biz.pubaccount.weishi.c
    public void onDestroy() {
        c().destroy();
    }

    @Override // com.tencent.biz.pubaccount.weishi.c
    public void onDestroyView() {
        c().detachView();
    }
}
