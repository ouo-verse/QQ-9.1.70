package com.tencent.mobileqq.ark.api.impl;

import android.app.Dialog;
import android.content.Context;
import com.tencent.mobileqq.ark.QQCustomTemplateMsgDialog;
import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.ark.api.IArkQQApi;
import com.tencent.mobileqq.ark.k;
import com.tencent.mobileqq.ark.r;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomArkDialog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ArkQQApiImpl implements IArkQQApi {
    private static final String TAG = "ArkQQApiImpl";

    @Override // com.tencent.mobileqq.ark.api.IArkQQApi
    public IArkQQApi.a getPositionMsgDialog(Context context, int i3) {
        return new r(context, i3);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkQQApi
    public IArkQQApi.a getTemplateMsgDialog(Context context, int i3) {
        return new QQCustomTemplateMsgDialog(context, i3);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkQQApi
    public boolean isArkCustomDialog(Dialog dialog) {
        return (dialog instanceof QQCustomArkDialog) || (dialog instanceof IArkQQApi.a);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkQQApi
    public void registerArkQQCallBack() {
        ((IArkHelper) QRoute.api(IArkHelper.class)).registerArkCallBack(new k());
    }

    @Override // com.tencent.mobileqq.ark.api.IArkQQApi
    public void unregisterArkQQCallBack() {
        ((IArkHelper) QRoute.api(IArkHelper.class)).unregisterCallBack();
    }
}
