package com.tencent.biz.qqcircle.immersive.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.activity.QCircleFolderActivity;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSDynamicUIBottomPanelVisibleEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSFloatEndCaptureEvent;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QFSFrameTabBarVisibleEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ax {
    public static void b(QCircleSlidBottomView qCircleSlidBottomView) {
        if (qCircleSlidBottomView != null && qCircleSlidBottomView.t()) {
            qCircleSlidBottomView.g();
        }
    }

    public static void c(QCircleSlidBottomView qCircleSlidBottomView, int i3, int i16) {
        if (qCircleSlidBottomView == null) {
            return;
        }
        if (!QCirclePluginUtil.isInMainTab(i3)) {
            qCircleSlidBottomView.d(i16);
        } else if (QCircleHostGlobalInfo.isCurrentTabActive()) {
            qCircleSlidBottomView.d(i16);
        } else {
            qCircleSlidBottomView.d(i16 + cx.a(56.0f));
        }
    }

    public static View d() {
        QFSVideoView qFSVideoView;
        Object parent;
        ViewParent viewParent;
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference == null) {
            qFSVideoView = null;
        } else {
            qFSVideoView = weakReference.get();
        }
        if (qFSVideoView == null) {
            parent = null;
        } else {
            parent = qFSVideoView.getParent();
        }
        if (parent instanceof ViewGroup) {
            viewParent = ((View) parent).getParent();
        } else {
            viewParent = null;
        }
        if (!(viewParent instanceof ViewGroup)) {
            QLog.e("QFSSlideViewUtils", 1, "[getCoverIamgeView] item view should not is view group, end flow.");
            return null;
        }
        return ((ViewGroup) viewParent).findViewById(R.id.v_z);
    }

    public static void e(final View view) {
        QLog.d("QFSSlideViewUtils", 1, "[handleVideoFrameCut] crop video cover");
        bi.p(new bi.a() { // from class: com.tencent.biz.qqcircle.immersive.utils.aw
            @Override // com.tencent.biz.qqcircle.immersive.utils.bi.a
            public final void a(Pair pair) {
                ax.f(view, pair);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(View view, Pair pair) {
        if (pair != null && pair.first != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSFloatEndCaptureEvent((String) pair.first, (Bitmap) pair.second));
            if (view != null && (view.getTag() instanceof Boolean) && Boolean.TRUE.equals(view.getTag())) {
                view.setTag(null);
                view.setVisibility(8);
                QLog.d("QFSSlideViewUtils", 1, "[handleVideoFrameCut] has happen config change. ");
            } else if (view != null) {
                QLog.d("QFSSlideViewUtils", 1, "[handleVideoFrameCut] show coverView");
                view.setVisibility(0);
            }
        }
    }

    public static void g(Context context, boolean z16) {
        h(context, z16);
        k(context, z16);
    }

    public static void h(Context context, boolean z16) {
        i(context, z16, false);
    }

    public static void i(Context context, boolean z16, boolean z17) {
        j(context, z16, z17, 0);
    }

    public static void j(Context context, boolean z16, boolean z17, int i3) {
        if (!QCircleHostGlobalInfo.isCurrentTabActive()) {
            QLog.d("QFSSlideViewUtils", 1, "setBottomTabBarVisible return: isCurrentTabActive=false ,isVisible:", Boolean.valueOf(z16));
            return;
        }
        if (QCircleHostGlobalInfo.isNowFlatState()) {
            QLog.d("QFSSlideViewUtils", 1, "setBottomTabBarVisible return: isNowFlatState=true ,isVisible:", Boolean.valueOf(z16));
            return;
        }
        if (!(context instanceof QCircleFolderActivity) && !QCirclePluginUtil.isQFSTabNativeFragmentMode(context)) {
            QLog.d("QFSSlideViewUtils", 1, "setBottomTabBarVisible return: context not QCircleFolderActivity ", context, ",isVisible:", Boolean.valueOf(z16));
            return;
        }
        if (z16 && QCirclePanelStateEvent.isBottomPanelShowingForTabVisible(context) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_bottom_panel_interrupt_bottom_tab_show_8996", true)) {
            QLog.d("QFSSlideViewUtils", 1, "setBottomTabBarVisible return: bottom panel is showing, isVisible:", Boolean.valueOf(z16));
            return;
        }
        QLog.d("QFSSlideViewUtils", 1, "setBottomTabBarVisible debug, isVisible:" + z16);
        QFSFrameTabBarVisibleEvent qFSFrameTabBarVisibleEvent = new QFSFrameTabBarVisibleEvent(z16, i3);
        qFSFrameTabBarVisibleEvent.setShowSeekTouchArea(z17);
        SimpleEventBus.getInstance().dispatchEvent(qFSFrameTabBarVisibleEvent);
    }

    public static void k(Context context, boolean z16) {
        boolean z17;
        if (!QCirclePluginUtil.isNewFolderPage(context) && QCirclePluginUtil.isTabMode()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && !bz.t()) {
            return;
        }
        if (!(context instanceof QCircleFolderActivity) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_not_folder_interrupt_dynamic_tab_visibile", true)) {
            QLog.d("QFSSlideViewUtils", 1, "setDynamicUIBottomPanelVisible return: context not QCircleFolderActivity ", context, ",isVisible:", Boolean.valueOf(z16));
        } else if (z16 && QCirclePanelStateEvent.isBottomPanelShowingForTabVisible(context) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_bottom_panel_interrupt_dynamic_tab_show", true)) {
            QLog.d("QFSSlideViewUtils", 1, "setDynamicUIBottomPanelVisible return: bottom panel is showing, isVisible:", Boolean.valueOf(z16));
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new QFSDynamicUIBottomPanelVisibleEvent(z16));
        }
    }
}
