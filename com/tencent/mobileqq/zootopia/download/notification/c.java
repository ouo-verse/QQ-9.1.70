package com.tencent.mobileqq.zootopia.download.notification;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/notification/c;", "Landroidx/core/app/NotificationCompat$Builder;", "Landroid/content/Context;", "context", "", "channelId", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c extends NotificationCompat.Builder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, String channelId) {
        super(context, channelId);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
    }
}
