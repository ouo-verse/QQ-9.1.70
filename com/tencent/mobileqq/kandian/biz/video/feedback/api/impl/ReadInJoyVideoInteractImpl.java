package com.tencent.mobileqq.kandian.biz.video.feedback.api.impl;

import android.app.PendingIntent;
import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.video.b;
import com.tencent.mobileqq.kandian.biz.video.feedback.api.IReadInJoyVideoInteract;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/feedback/api/impl/ReadInJoyVideoInteractImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/feedback/api/IReadInJoyVideoInteract;", "()V", "handleReadinjoyVideoIntent", "", "appInterface", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "intent", "Landroid/content/Intent;", "pendingIntent", "Landroid/app/PendingIntent;", "businessCategory", "", "wording", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ReadInJoyVideoInteractImpl implements IReadInJoyVideoInteract {
    @Override // com.tencent.mobileqq.kandian.biz.video.feedback.api.IReadInJoyVideoInteract
    public void handleReadinjoyVideoIntent(BaseQQAppInterface appInterface, Intent intent, PendingIntent pendingIntent, String businessCategory, String wording) {
        if (appInterface instanceof QQAppInterface) {
            b.b((QQAppInterface) appInterface, intent, pendingIntent, businessCategory, wording);
        }
    }
}
