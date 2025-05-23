package com.tencent.sqshow.zootopia.nativeui.view.panel;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreCreateRoleBubbleView;
import com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreLeftOptView;
import com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreTopOptView;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView;
import com.tencent.sqshow.zootopia.nativeui.view.control.PortalStorePanelControlView;
import com.tencent.sqshow.zootopia.nativeui.view.title.PortalStoreTitleView;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\n\u0010\r\u001a\u0004\u0018\u00010\fH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000eH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000eH&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000eH&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/panel/a;", "", "Landroid/view/ViewGroup;", "getRoot", "Lcom/tencent/sqshow/zootopia/nativeui/view/title/PortalStoreTitleView;", "b", "Lcom/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreLeftOptView;", "u", "Lcom/tencent/sqshow/zootopia/nativeui/view/control/PortalStorePanelControlView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreTopOptView;", "I", "Landroid/widget/RelativeLayout;", "D", "Landroid/view/View;", "r0", "W", "X", "O", "Lcom/tencent/sqshow/zootopia/portal/shimmer/ShimmerLinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarPanelErrorView;", "w", "Lcom/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreCreateRoleBubbleView;", "e0", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface a {
    /* renamed from: A */
    PortalStorePanelControlView getMCategoryView();

    ShimmerLinearLayout C();

    RelativeLayout D();

    /* renamed from: I */
    PortalStoreTopOptView getMSaveView();

    View O();

    View W();

    View X();

    /* renamed from: b */
    PortalStoreTitleView getMTopTitileView();

    /* renamed from: e0 */
    PortalStoreCreateRoleBubbleView getMCreateRoleBubbleView();

    ViewGroup getRoot();

    View r0();

    /* renamed from: u */
    PortalStoreLeftOptView getMHistoryView();

    AvatarPanelErrorView w();
}
