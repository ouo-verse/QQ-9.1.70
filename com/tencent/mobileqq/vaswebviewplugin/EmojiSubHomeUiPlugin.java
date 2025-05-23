package com.tencent.mobileqq.vaswebviewplugin;

/* loaded from: classes35.dex */
public class EmojiSubHomeUiPlugin extends EmojiUiPlugin {

    /* renamed from: tt, reason: collision with root package name */
    private int f312426tt;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 4L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 3L;
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin, com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public void OnActivityCreate() {
        this.mActivityType = 3;
        super.OnActivityCreate();
        if (checkOncreateParam(getInfoIntent())) {
            return;
        }
        this.activity.finish();
    }
}
