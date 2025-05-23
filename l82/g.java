package l82;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.matchfriend.reborn.utils.k;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Ll82/g;", "Ll82/a;", "", "a", "", "isElementCanActivate", "onElementActivated", "onElementInactivated", "", "getContextHashCode", "", "getPriority", "Landroid/view/View;", "e", "Landroid/view/View;", "anchorView", "Landroid/app/Activity;", "f", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/view/View;Landroid/app/Activity;)V", tl.h.F, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View anchorView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    public g(View anchorView, Activity activity) {
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.anchorView = anchorView;
        this.activity = activity;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        return String.valueOf(this.activity.hashCode());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 102;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        if (com.tencent.mobileqq.matchfriend.reborn.utils.g.f245479a.c(this.activity)) {
            return false;
        }
        boolean z16 = !k.f245485a.g();
        if (QLog.isColorLevel()) {
            QLog.d("NearbyMergeEntryGuideElement", 2, "Check can activated " + z16);
        }
        return z16;
    }

    @Override // l82.a, com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        super.onElementActivated();
        QLog.i("NearbyMergeEntryGuideElement", 1, "Activate nearby merged entry guide");
        a();
        k.f245485a.l(true);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        if (QLog.isColorLevel()) {
            QLog.d("NearbyMergeEntryGuideElement", 2, "Element inactivated");
        }
    }

    private final void a() {
        int[] iArr = new int[2];
        this.anchorView.getLocationOnScreen(iArr);
        int i3 = this.anchorView.getResources().getDisplayMetrics().widthPixels;
        int i16 = this.anchorView.getResources().getDisplayMetrics().heightPixels;
        int width = this.anchorView.getWidth();
        int height = this.anchorView.getHeight();
        String str = "mqqapi://kuikly/open?version=1&src_type=app&page_name=qq_stranger_nearby_entry_guide&modal_mode=1&local_bundle_name=nearbypro&bottom_nav_bar_immersive=1&custom_back_pressed=1&x=" + iArr[0] + "&y=" + iArr[1] + "&w=" + width + "&h=" + height + "&screen_w=" + i3 + "&screen_h=" + i16;
        Intent intent = new Intent();
        intent.setData(Uri.parse(str));
        RouteUtils.startActivity(this.activity, intent, RouterConstants.UI_ROUTER_JUMP);
    }
}
