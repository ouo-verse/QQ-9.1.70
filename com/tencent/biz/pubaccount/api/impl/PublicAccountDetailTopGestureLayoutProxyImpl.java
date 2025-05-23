package com.tencent.biz.pubaccount.api.impl;

import android.content.Context;
import android.view.GestureDetector;
import android.view.View;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;

/* loaded from: classes32.dex */
public class PublicAccountDetailTopGestureLayoutProxyImpl implements IPublicAccountDetailTopGestureLayoutProxy {
    private AccountDetailTopGestureLayout mGestureLayout;

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy
    public void addDisableView(View view) {
        this.mGestureLayout.e(view);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy
    public TopGestureLayout.OnGestureListener getOnFlingGesture() {
        return this.mGestureLayout.f();
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy
    public TopGestureLayout getTopGestureLayout() {
        return this.mGestureLayout;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy
    public void init(Context context) {
        this.mGestureLayout = new AccountDetailTopGestureLayout(context);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy
    public boolean isInTwoFingerMode() {
        return this.mGestureLayout.isInTwoFingerMode();
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy
    public void setDefaultDetector(GestureDetector gestureDetector) {
        this.mGestureLayout.setDefaultDetector(gestureDetector);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy
    public GestureDetector.OnGestureListener setOnFlingListener(Context context, IPublicAccountDetailTopGestureLayoutProxy.a aVar) {
        return this.mGestureLayout.h(context, aVar);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy
    public void setTopGestureDetector(GestureDetector gestureDetector) {
        this.mGestureLayout.setTopGestureDetector(gestureDetector);
    }
}
