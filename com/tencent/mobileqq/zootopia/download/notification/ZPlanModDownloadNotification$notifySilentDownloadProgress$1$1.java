package com.tencent.mobileqq.zootopia.download.notification;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "downloadData", "Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZPlanModDownloadNotification$notifySilentDownloadProgress$1$1 extends Lambda implements Function1<ZootopiaDownloadData, Unit> {
    final /* synthetic */ int $downloadStatus;
    final /* synthetic */ String $modId;
    final /* synthetic */ float $progress;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanModDownloadNotification$notifySilentDownloadProgress$1$1(String str, int i3, float f16) {
        super(1);
        this.$modId = str;
        this.$downloadStatus = i3;
        this.$progress = f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(String modId, ZootopiaDownloadData zootopiaDownloadData, int i3, float f16) {
        HashMap hashMap;
        Intrinsics.checkNotNullParameter(modId, "$modId");
        hashMap = ZPlanModDownloadNotification.modSummaryDataMap;
        hashMap.put(modId, zootopiaDownloadData.getSummaryData());
        ZPlanModDownloadNotification.f328166a.h(zootopiaDownloadData.getSummaryData(), modId, i3, f16);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ZootopiaDownloadData zootopiaDownloadData) {
        invoke2(zootopiaDownloadData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final ZootopiaDownloadData zootopiaDownloadData) {
        if (zootopiaDownloadData != null) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final String str = this.$modId;
            final int i3 = this.$downloadStatus;
            final float f16 = this.$progress;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.notification.b
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanModDownloadNotification$notifySilentDownloadProgress$1$1.b(str, zootopiaDownloadData, i3, f16);
                }
            });
            return;
        }
        QLog.e("ZPlanNotification_ModDownload", 1, "notifySilentDownloadProgress but getDownloadData null - " + this.$modId);
    }
}
