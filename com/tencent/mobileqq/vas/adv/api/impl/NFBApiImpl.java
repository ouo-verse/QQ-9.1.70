package com.tencent.mobileqq.vas.adv.api.impl;

import android.app.Activity;
import android.view.MotionEvent;
import com.tencent.mobileqq.vas.adv.api.INFBApi;
import com.tencent.mobileqq.vas.adv.negativefeedback.common.QPublicAccountNFBController;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import jz2.NFBBusinessInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/api/impl/NFBApiImpl;", "Lcom/tencent/mobileqq/vas/adv/api/INFBApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/MotionEvent;", "event", "", "dispatchActivityTouchEvent", "Ljz2/a;", "info", "putNFBBusinessInfo", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class NFBApiImpl implements INFBApi {
    @Override // com.tencent.mobileqq.vas.adv.api.INFBApi
    public void dispatchActivityTouchEvent(@Nullable Activity activity, @Nullable MotionEvent event) {
        QPublicAccountNFBController.f308109d.f(activity, event);
    }

    @Override // com.tencent.mobileqq.vas.adv.api.INFBApi
    public void putNFBBusinessInfo(@Nullable Activity activity, @Nullable NFBBusinessInfo info) {
        QPublicAccountNFBController.f308109d.n(activity, info);
    }
}
