package com.tencent.biz.eqq.api.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.eqq.api.ICrmApi;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.InputStream;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes2.dex */
public class CrmApiImpl implements ICrmApi {
    private QQAppInterface app;

    @Override // com.tencent.biz.eqq.api.ICrmApi
    public InputStream bitmap2InputStream(Bitmap bitmap) {
        return CrmUtils.d(bitmap);
    }

    @Override // com.tencent.biz.eqq.api.ICrmApi
    public int convertSubVersionToInt(String str) {
        return CrmUtils.e(str);
    }

    @Override // com.tencent.biz.eqq.api.ICrmApi
    public void deleteQdCustomerTransferSp(Context context, String str) {
        deleteQdCustomerTransferSp(context, str);
    }

    @Override // com.tencent.biz.eqq.api.ICrmApi
    public void enterLightTalk(Context context, String str, String str2) {
        CrmUtils.i(this.app, context, str, str2);
    }

    @Override // com.tencent.biz.eqq.api.ICrmApi
    public String getCrmNameFromCache(String str) {
        return CrmUtils.j(this.app, str);
    }

    @Override // com.tencent.biz.eqq.api.ICrmApi
    public void getCustomerTransferInfo(Context context, String str, String str2) {
        CrmUtils.k(this.app, context, str, str2);
    }

    @Override // com.tencent.biz.eqq.api.ICrmApi
    public String getNickName(String str) {
        return CrmUtils.l(this.app, str);
    }

    @Override // com.tencent.biz.eqq.api.ICrmApi
    public int getQidianUinType(String str) {
        return CrmUtils.m(this.app, str);
    }

    @Override // com.tencent.biz.eqq.api.ICrmApi
    public Intent gotoCrmMainProfile(Context context, Intent intent, String str, boolean z16, int i3, boolean z17, int i16) {
        return CrmUtils.n(context, intent, str, z16, i3, z17, i16);
    }

    @Override // com.tencent.biz.eqq.api.ICrmApi
    public boolean hasIvrAbility(String str, int i3) {
        return CrmUtils.o(this.app, str, i3);
    }

    @Override // com.tencent.biz.eqq.api.ICrmApi
    public int isCertified(String str) {
        return CrmUtils.p(this.app, str);
    }

    @Override // com.tencent.biz.eqq.api.ICrmApi
    public boolean isCrmMainUinAndGetSimpleInfoIfNeed(String str) {
        return CrmUtils.r(this.app, str);
    }

    @Override // com.tencent.biz.eqq.api.ICrmApi
    public boolean isCrmMaster(int i3) {
        return CrmUtils.s(i3);
    }

    @Override // com.tencent.biz.eqq.api.ICrmApi
    public boolean isCrmQQ(String str) {
        return CrmUtils.t(this.app, str);
    }

    @Override // com.tencent.biz.eqq.api.ICrmApi
    public boolean isQiye(String str, int i3) {
        return CrmUtils.v(this.app, str, i3);
    }

    @Override // com.tencent.biz.eqq.api.ICrmApi
    public void ivrAudio(Context context, String str, String str2, String str3) {
        CrmUtils.z(this.app, context, str, str2, str3);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.app = (QQAppInterface) appRuntime;
    }

    @Override // com.tencent.biz.eqq.api.ICrmApi
    public void showCrmIvrVideoActionSheet(Context context, String str, String str2) {
        CrmUtils.E(this.app, context, str, str2);
    }

    @Override // com.tencent.biz.eqq.api.ICrmApi
    public void updateDetailBackground(Context context, String str, int i3, BusinessObserver businessObserver) {
        CrmUtils.H(this.app, context, str, i3, businessObserver);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
