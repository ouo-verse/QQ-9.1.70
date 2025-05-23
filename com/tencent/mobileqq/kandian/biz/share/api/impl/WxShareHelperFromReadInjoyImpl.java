package com.tencent.mobileqq.kandian.biz.share.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.kandian.biz.share.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u001d\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u0013\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J-\u0010\u0014\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0001JE\u0010\u001b\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0096\u0001JC\u0010\u001c\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001JE\u0010\u001e\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\fH\u0096\u0001JC\u0010\u001f\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/share/api/impl/WxShareHelperFromReadInjoyImpl;", "Lcom/tencent/mobileqq/kandian/biz/share/api/IWxShareHelperFromReadInjoy;", "Lcom/tencent/mobileqq/kandian/biz/share/api/IWxShareHelperFromReadInjoy$a;", "observer", "", "addObserver", "Landroid/app/Activity;", "wxEntryActivity", "Landroid/content/Intent;", "intent", "handleWXEntryActivityIntent", "removeObserver", "", "filePath", "Landroid/graphics/Bitmap;", "bmp", "", "scene", "", "outSquare", "shareImageToWX", "transaction", "title", "icon", "description", "webPageUrl", "path", "shareToMiniProgramWithPath", "shareVideo", "rowKey", "shareVideoMiniProgram", "shareWebPage", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class WxShareHelperFromReadInjoyImpl implements IWxShareHelperFromReadInjoy {
    private final /* synthetic */ WxShareHelperFromReadInjoy $$delegate_0 = WxShareHelperFromReadInjoy.getInstance();

    @Override // com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy
    public void addObserver(IWxShareHelperFromReadInjoy.a observer) {
        this.$$delegate_0.addObserver(observer);
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy
    public void handleWXEntryActivityIntent(Activity wxEntryActivity, Intent intent) {
        this.$$delegate_0.handleWXEntryActivityIntent(wxEntryActivity, intent);
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy
    public void removeObserver(IWxShareHelperFromReadInjoy.a observer) {
        this.$$delegate_0.removeObserver(observer);
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy
    public void shareImageToWX(String filePath, Bitmap bmp, int scene, boolean outSquare) {
        this.$$delegate_0.shareImageToWX(filePath, bmp, scene, outSquare);
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy
    public void shareToMiniProgramWithPath(String transaction, String title, Bitmap icon, String description, String webPageUrl, String path) {
        this.$$delegate_0.shareToMiniProgramWithPath(transaction, title, icon, description, webPageUrl, path);
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy
    public void shareVideo(String transaction, String title, Bitmap icon, String description, String webPageUrl, int scene) {
        this.$$delegate_0.shareVideo(transaction, title, icon, description, webPageUrl, scene);
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy
    public void shareVideoMiniProgram(String transaction, String title, Bitmap icon, String description, String webPageUrl, String rowKey) {
        this.$$delegate_0.shareVideoMiniProgram(transaction, title, icon, description, webPageUrl, rowKey);
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy
    public void shareWebPage(String transaction, String title, Bitmap icon, String description, String webPageUrl, int scene) {
        this.$$delegate_0.shareWebPage(transaction, title, icon, description, webPageUrl, scene);
    }
}
