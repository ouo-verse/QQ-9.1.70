package com.tencent.biz.qqcircle.immersive;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.bizparts.QFSSharePart;
import com.tencent.biz.qqcircle.bizparts.bj;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.QFSFullScreenRatePlayGuidePart;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.l;
import com.tencent.biz.qqcircle.immersive.part.bq;
import com.tencent.biz.qqcircle.immersive.utils.aa;
import com.tencent.biz.qqcircle.utils.cb;
import com.tencent.biz.richframework.part.Part;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFullScreenFragment extends QFSBaseFragment {
    private void rh(boolean z16, Window window) {
        View decorView;
        if (window == null) {
            decorView = null;
        } else {
            decorView = window.getDecorView();
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fix_comment_input_nav_bar_hide", true) && z16 && decorView != null) {
            decorView.setSystemUiVisibility(5894);
        }
    }

    public static boolean sh(Context context) {
        try {
            if (!Build.MANUFACTURER.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI)) {
                return false;
            }
            if (Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
                return true;
            }
            return false;
        } catch (Throwable th5) {
            QLog.e("QFSFullScreenFragment", 1, "[isTransparentNavBar] error: ", th5);
            return false;
        }
    }

    public static void th(Activity activity, int i3) {
        if (activity == null) {
            QLog.e("QFSFullScreenFragment", 1, "[setFullScreenNavigationBarColor] activity");
            return;
        }
        Window window = activity.getWindow();
        if (window == null) {
            return;
        }
        window.getDecorView().setFitsSystemWindows(true);
        if (DeviceInfoMonitor.getModel().contains("PFVM10") && Build.VERSION.SDK_INT >= 29) {
            window.setNavigationBarContrastEnforced(false);
        }
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(5894);
        window.addFlags(134218752);
        window.setNavigationBarColor(i3);
    }

    private void uh(@NonNull Window window) {
        if (Build.VERSION.SDK_INT >= 29) {
            window.setNavigationBarContrastEnforced(false);
        }
        window.setNavigationBarColor(0);
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1792);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new l());
        if (cb.c()) {
            arrayList.add(new QFSFullScreenRatePlayGuidePart());
        } else {
            arrayList.add(new bq());
        }
        arrayList.add(new com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.g(getQCircleInitBean()));
        arrayList.add(new com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.h());
        arrayList.add(new bj());
        if (com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.b.wa()) {
            arrayList.add(new com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.b());
            arrayList.add(new com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.i());
        }
        if (com.tencent.biz.qqcircle.immersive.utils.a.e()) {
            arrayList.add(new QFSSharePart());
            arrayList.add(new QCircleRichMediaDownLoadPart());
        }
        arrayList.add(new e60.h());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gtn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_FULL_SCREEN_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSFullScreenFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needAdjustImmersive() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (aa.a(configuration) && getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        th(getActivity(), Color.argb(127, 0, 0, 0));
        if (getActivity() != null) {
            getActivity().overridePendingTransition(R.anim.f155107wd, R.anim.f155108we);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        Window window;
        super.onWindowFocusChanged(z16);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            window = null;
        } else {
            window = activity.getWindow();
        }
        if (z16 && window != null && sh(getActivity())) {
            try {
                uh(window);
            } catch (Throwable th5) {
                QLog.e("QFSFullScreenFragment", 1, "[onWindowFocusChanged] ex: ", th5);
            }
        }
        rh(z16, window);
    }
}
