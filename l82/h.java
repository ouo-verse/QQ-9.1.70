package l82;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.matchfriend.reborn.register.guest.QQStrangerGuestHelper;
import com.tencent.mobileqq.nearbypro.api.IStrangerPublicAccountUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Ll82/h;", "Ll82/a;", "", "a", "", "isElementCanActivate", "onElementActivated", "onElementInactivated", "", "getContextHashCode", "", "getPriority", "Landroid/app/Activity;", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "f", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class h extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    public h(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    private final void a() {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqapi://kuikly/open?version=1&src_type=app&page_name=nbp_public_account_follow&app_id=1&modal_mode=1&custom_back_pressed=1&local_bundle_name=nearbypro"));
        RouteUtils.startActivity(this.activity, intent, RouterConstants.UI_ROUTER_JUMP);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        return String.valueOf(this.activity.hashCode());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 103;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        boolean z16 = false;
        if (com.tencent.mobileqq.matchfriend.reborn.utils.g.f245479a.c(this.activity)) {
            return false;
        }
        boolean shouldShowFollowModal = ((IStrangerPublicAccountUtil) QRoute.api(IStrangerPublicAccountUtil.class)).shouldShowFollowModal(1);
        boolean c16 = QQStrangerGuestHelper.f245363a.c();
        if (shouldShowFollowModal && c16) {
            z16 = true;
        }
        QLog.d("PublicAccountFollowGuideElement", 2, "Check can active " + z16 + ", shouldShow=" + shouldShowFollowModal + ", hasRegister=" + c16);
        return z16;
    }

    @Override // l82.a, com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        super.onElementActivated();
        QLog.i("PublicAccountFollowGuideElement", 1, "Activate public account follow guide");
        a();
        ((IStrangerPublicAccountUtil) QRoute.api(IStrangerPublicAccountUtil.class)).markShowFollowModal(1);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        QLog.d("PublicAccountFollowGuideElement", 2, "Element inactivated");
    }
}
