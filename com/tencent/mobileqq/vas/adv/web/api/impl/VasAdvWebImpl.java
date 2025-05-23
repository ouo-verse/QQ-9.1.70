package com.tencent.mobileqq.vas.adv.web.api.impl;

import android.app.Activity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.vas.adv.web.VasAdvWebManager;
import com.tencent.mobileqq.vas.adv.web.api.IVasAdvWeb;
import com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/web/api/impl/VasAdvWebImpl;", "Lcom/tencent/mobileqq/vas/adv/web/api/IVasAdvWeb;", "()V", "getWebView", "Lcom/tencent/biz/ui/TouchWebView;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "initWebView", "", "removeWebView", "subscribe", "businessId", "", "subscriber", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Subscriber;", "unsubscribe", "unsubscribeAll", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasAdvWebImpl implements IVasAdvWeb {
    @Override // com.tencent.mobileqq.vas.adv.web.api.IVasAdvWeb
    @Nullable
    public TouchWebView getWebView(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return VasAdvWebManager.f308319d.getWebView(activity);
    }

    @Override // com.tencent.mobileqq.vas.adv.web.api.IVasAdvWeb
    public void initWebView() {
        VasAdvWebManager.f308319d.initWebView();
    }

    @Override // com.tencent.mobileqq.vas.adv.web.api.IVasAdvWeb
    public void removeWebView() {
        VasAdvWebManager.f308319d.removeWebView();
    }

    @Override // com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Publisher
    public void subscribe(@NotNull String businessId, @NotNull VasAdvWebEvent.Subscriber subscriber) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        VasAdvWebManager.f308319d.subscribe(businessId, subscriber);
    }

    @Override // com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Publisher
    public void unsubscribe(@NotNull String businessId, @NotNull VasAdvWebEvent.Subscriber subscriber) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        VasAdvWebManager.f308319d.unsubscribe(businessId, subscriber);
    }

    @Override // com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Publisher
    public void unsubscribeAll(@NotNull String businessId) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        VasAdvWebManager.f308319d.unsubscribeAll(businessId);
    }
}
