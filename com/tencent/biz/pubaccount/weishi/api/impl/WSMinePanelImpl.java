package com.tencent.biz.pubaccount.weishi.api.impl;

import a10.a;
import android.app.Activity;
import com.tencent.biz.pubaccount.weishi.api.IWSMinePanel;

/* loaded from: classes32.dex */
public class WSMinePanelImpl implements IWSMinePanel {
    @Override // com.tencent.biz.pubaccount.weishi.api.IWSMinePanel
    public void reportProfileCardExposure(boolean z16, String str) {
        a.d(z16, str);
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSMinePanel
    public void reportProfileSettingBtnClick(boolean z16) {
        a.e(z16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSMinePanel
    public void reportProfileSettingExposure(boolean z16) {
        a.f(z16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSMinePanel
    public void reportWeiShiProfileClick(boolean z16, String str, boolean z17, boolean z18) {
        a.g(z16, str, z17, z18);
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSMinePanel
    public void reportProfileSettingPageVisitEnter() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSMinePanel
    public void reportProfileSettingPageVisitExit() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSMinePanel
    public void downloadWeishiWithDialog(Activity activity, boolean z16) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSMinePanel
    public void reportProfilePageVisitEnter(String str, boolean z16) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSMinePanel
    public void reportProfilePageVisitExit(String str, boolean z16) {
    }
}
