package l82;

import android.app.Activity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Ll82/i;", "Ll82/a;", "", "isElementCanActivate", "", "onElementActivated", "onElementInactivated", "", "getContextHashCode", "", "getPriority", "Landroid/app/Activity;", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "f", "Z", "hasActivated", "<init>", "(Landroid/app/Activity;)V", tl.h.F, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class i extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasActivated;

    public i(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        return String.valueOf(this.activity.hashCode());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 106;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        if (com.tencent.mobileqq.matchfriend.reborn.utils.g.f245479a.c(this.activity)) {
            return false;
        }
        return !this.hasActivated;
    }

    @Override // l82.a, com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        super.onElementActivated();
        QLog.d("SurpriseMatchingGuideElement", 1, "onElementActivated");
        this.hasActivated = true;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        QLog.d("SurpriseMatchingGuideElement", 1, "onElementInactivated");
    }
}
