package com.tencent.mobileqq.zplan.avatar;

import com.tencent.zplan.record.model.GeneralRecordParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0005B%\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/ZPlanAvatarPicEditRecordHelper;", "", "", "c", "", "a", "Ljava/lang/Integer;", "firstScreenCnt", "Lcom/tencent/zplan/record/model/GeneralRecordParams;", "b", "Lcom/tencent/zplan/record/model/GeneralRecordParams;", "batchRecordParams", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/avatar/a;", "Lmqq/util/WeakReference;", "listenerRef", "listener", "<init>", "(Ljava/lang/Integer;Lcom/tencent/zplan/record/model/GeneralRecordParams;Lcom/tencent/mobileqq/zplan/avatar/a;)V", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAvatarPicEditRecordHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Integer firstScreenCnt;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final GeneralRecordParams batchRecordParams;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<a> listenerRef;

    public ZPlanAvatarPicEditRecordHelper(Integer num, GeneralRecordParams batchRecordParams, a aVar) {
        Intrinsics.checkNotNullParameter(batchRecordParams, "batchRecordParams");
        this.firstScreenCnt = num;
        this.batchRecordParams = batchRecordParams;
        this.listenerRef = new WeakReference<>(aVar);
    }

    public final void c() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZPlanAvatarPicEditRecordHelper$recordAvatar$1(this, null), 3, null);
    }
}
