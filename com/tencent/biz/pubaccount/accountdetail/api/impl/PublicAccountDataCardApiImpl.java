package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDataCardApi;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/pubaccount/accountdetail/api/impl/PublicAccountDataCardApiImpl;", "Lcom/tencent/biz/pubaccount/accountdetail/api/IPublicAccountDataCardApi;", "()V", "startPublicAccountDataCardPage", "", "context", "Landroid/content/Context;", "params", "Landroid/content/Intent;", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public final class PublicAccountDataCardApiImpl implements IPublicAccountDataCardApi {
    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDataCardApi
    public void startPublicAccountDataCardPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        QPublicFragmentActivity.start(context, params, PublicAccountDataCardFragment.class);
    }
}
