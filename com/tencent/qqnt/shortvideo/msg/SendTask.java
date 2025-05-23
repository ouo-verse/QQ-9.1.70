package com.tencent.qqnt.shortvideo.msg;

import android.app.Activity;
import android.content.Intent;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/shortvideo/msg/SendTask;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Landroid/app/Activity;", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "intent", "<init>", "(Landroid/app/Activity;Landroid/content/Intent;)V", "shortvideo_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class SendTask implements Runnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    public SendTask(@NotNull Activity activity, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.activity = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
