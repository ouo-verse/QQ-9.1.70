package com.tencent.mobileqq.webview.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.webview.api.IAddContactSecCheckWebApi;

/* compiled from: P */
/* loaded from: classes35.dex */
public class AddContactSecCheckWebApiImpl implements IAddContactSecCheckWebApi {
    @Override // com.tencent.mobileqq.webview.api.IAddContactSecCheckWebApi
    public void openSecCheckWeb(AppInterface appInterface, Context context, int i3, String str) {
        com.tencent.biz.webviewplugin.d.openSecCheckWeb(appInterface, context, i3, str);
    }

    @Override // com.tencent.mobileqq.webview.api.IAddContactSecCheckWebApi
    public void openSecCheckWebForFragment(AppInterface appInterface, Context context, QBaseFragment qBaseFragment, int i3, String str) {
        com.tencent.biz.webviewplugin.d.openSecCheckWebForFragment(appInterface, context, qBaseFragment, i3, str);
    }
}
