package com.qzone.reborn.repair.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.qzone.reborn.repair.utils.QZonePhotoRepairQNESingletonVM", f = "QZonePhotoRepairQNESingletonVM.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {157, 286}, m = "doPhotoRepair", n = {"inputImageInfo", "reportLoadBitmapCostTime", "reportOprHandleCostTime", "reportTotalCostTime", "reportModelLoaded", "inputImageInfo", "beforeUploadResultCallback", "reportLoadBitmapCostTime", "reportOprHandleCostTime", "reportTotalCostTime", "reportModelLoaded"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
/* loaded from: classes37.dex */
public final class QZonePhotoRepairQNESingletonVM$doPhotoRepair$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QZonePhotoRepairQNESingletonVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZonePhotoRepairQNESingletonVM$doPhotoRepair$1(QZonePhotoRepairQNESingletonVM qZonePhotoRepairQNESingletonVM, Continuation<? super QZonePhotoRepairQNESingletonVM$doPhotoRepair$1> continuation) {
        super(continuation);
        this.this$0 = qZonePhotoRepairQNESingletonVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, null, this);
    }
}
