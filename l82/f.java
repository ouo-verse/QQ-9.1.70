package l82;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.matchfriend.reborn.guide.manager.util.ScheduleManager;
import com.tencent.mobileqq.matchfriend.reborn.register.guest.QQStrangerGuestHelper;
import com.tencent.mobileqq.matchfriend.reborn.utils.k;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Ll82/f;", "Ll82/a;", "", "isElementCanActivate", "", "onElementActivated", "onElementInactivated", "", "getContextHashCode", "", "getPriority", "Landroid/view/View;", "e", "Landroid/view/View;", "anchorView", "Landroid/app/Activity;", "f", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/view/View;Landroid/app/Activity;)V", tl.h.F, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View anchorView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    public f(View anchorView, Activity activity) {
        List listOf;
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.anchorView = anchorView;
        this.activity = activity;
        m82.a aVar = m82.a.f416439a;
        aVar.a().h(this, (r15 & 2) != 0 ? Dispatcher.DEFAULT_GROUP_NAME : null, (r15 & 4) != 0 ? "" : null, (r15 & 8) != 0 ? Integer.MIN_VALUE : 1, (r15 & 16) != 0 ? Long.MIN_VALUE : TimeUnit.DAYS.toMillis(1L), (r15 & 32) == 0 ? 3 : Integer.MIN_VALUE);
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        ScheduleManager a16 = aVar.a();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(fromV2.decodeLong(com.tencent.mobileqq.matchfriend.reborn.utils.h.f245480a.a("qqstranger_nearby_entry_last_show_time"), 0L)));
        ScheduleManager.l(a16, this, null, listOf, k.f245485a.e(), false, 2, null);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        return String.valueOf(this.activity.hashCode());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 101;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        boolean z16 = false;
        if (com.tencent.mobileqq.matchfriend.reborn.utils.g.f245479a.c(this.activity)) {
            return false;
        }
        if (ScheduleManager.d(m82.a.f416439a.a(), this, null, null, 6, null) && QQStrangerGuestHelper.f245363a.c() && k.f245485a.c()) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NearbyEntryGuideElement", 2, "Check can activated " + z16);
        }
        return z16;
    }

    @Override // l82.a, com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        super.onElementActivated();
        QLog.i("NearbyEntryGuideElement", 1, "Activate nearby entry guide");
        k.f245485a.m(this.anchorView, this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        if (QLog.isColorLevel()) {
            QLog.d("NearbyEntryGuideElement", 2, "Element inactivated");
        }
    }
}
