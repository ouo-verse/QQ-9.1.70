package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager;

import android.app.Activity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.detail.model.HWClockInDetailItemMoreActionUseCase;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/HWClockInDetailListMediaEditManager;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/DetailMediaEditManager;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/a;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "c", "", "K", "Ljava/lang/String;", "clockInId", "", "L", "J", "date", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/a;", "M", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/a;", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/a;", "dataModel", "troopUin", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;J)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInDetailListMediaEditManager extends DetailMediaEditManager<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final String clockInId;

    /* renamed from: L, reason: from kotlin metadata */
    private final long date;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.a dataModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWClockInDetailListMediaEditManager(@NotNull String troopUin, @NotNull CoroutineScope scope, @NotNull String clockInId, long j3) {
        super(troopUin, scope, AnonymousClass1.INSTANCE);
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(clockInId, "clockInId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, scope, clockInId, Long.valueOf(j3));
            return;
        }
        this.clockInId = clockInId;
        this.date = j3;
        this.dataModel = new com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.a(scope, troopUin);
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.DetailMediaEditManager
    @NotNull
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.a k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.dataModel;
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.b, qs2.a
    public void c(@Nullable Activity activity) {
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        if (activity == null) {
            return;
        }
        List<BaseItem> value = b().getValue();
        if (value instanceof ArrayList) {
            arrayList = (ArrayList) value;
        } else {
            arrayList = null;
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2 == null) {
            return;
        }
        new HWClockInDetailItemMoreActionUseCase(activity, n(), this.clockInId, arrayList2, this.date).d();
    }
}
