package com.tencent.mobileqq.tvideo.floatingwindow;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.util.HashMap;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes19.dex */
public class j {
    public static void b(Context context) {
        Intent intent = new Intent();
        intent.addFlags(131072);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTER_SPLASH);
    }

    public static boolean c(@NonNull Context context) {
        if (((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(context)) {
            return true;
        }
        ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialog(context);
        return false;
    }

    public static void d(@NonNull Context context, @NonNull View view) {
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).enterFloatingScreen(context, view, f(), 80);
    }

    public static com.tencent.mobileqq.qqfloatingwindow.a e(@NonNull Context context) {
        return ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).getFloatingProxyWrapper(context, ((IFloatingWrapperManager) QRoute.api(IFloatingWrapperManager.class)).getFloatingVideoWrapperName());
    }

    private static FloatingScreenParams f() {
        return new FloatingScreenParams.FloatingBuilder().setShapeType(1).setCanZoom(false).build();
    }

    public static boolean g() {
        return ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(Foreground.getTopActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h() {
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen();
    }

    public static void i(@NonNull Context context) {
        QCircleSchemeBean qCircleSchemeBean = new QCircleSchemeBean();
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("key_jump_from", "tvideo_floating_window");
        qCircleSchemeBean.setAttrs(hashMap);
        qCircleSchemeBean.setSchemeAction(QCircleScheme.Q_CIRCLE_ACTION_OPEN_TVIDEO_PUBLIC_ACCOUNT);
        QCircleSchemeLauncher.b(context.getApplicationContext(), qCircleSchemeBean);
    }

    public static void j() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.floatingwindow.i
            @Override // java.lang.Runnable
            public final void run() {
                j.h();
            }
        });
    }

    public static void k(@NonNull Context context, boolean z16) {
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(context, z16, 80);
    }
}
