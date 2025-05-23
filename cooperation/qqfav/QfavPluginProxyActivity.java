package cooperation.qqfav;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.FlingConstant;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.mobileqq.utils.ca;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.IPluginManager;
import mqq.app.api.ProcessConstant;

/* loaded from: classes28.dex */
public class QfavPluginProxyActivity extends PluginProxyActivity {

    /* loaded from: classes28.dex */
    public static class DetailProxy extends SingleTop {
        @Override // cooperation.qqfav.QfavPluginProxyActivity.SingleTop, cooperation.qqfav.QfavPluginProxyActivity, com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
            return dispatchTouchEvent;
        }

        @Override // cooperation.qqfav.QfavPluginProxyActivity.SingleTop, cooperation.qqfav.QfavPluginProxyActivity, com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
        }
    }

    /* loaded from: classes28.dex */
    public static class ForResult extends QfavPluginProxyActivity {
        @Override // cooperation.qqfav.QfavPluginProxyActivity, com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
            return dispatchTouchEvent;
        }

        @Override // cooperation.qqfav.QfavPluginProxyActivity, com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
        }
    }

    /* loaded from: classes28.dex */
    public static class ImageViewer extends DetailProxy {
        @Override // cooperation.qqfav.QfavPluginProxyActivity.DetailProxy, cooperation.qqfav.QfavPluginProxyActivity.SingleTop, cooperation.qqfav.QfavPluginProxyActivity, com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
            return dispatchTouchEvent;
        }

        @Override // cooperation.qqfav.QfavPluginProxyActivity.DetailProxy, cooperation.qqfav.QfavPluginProxyActivity.SingleTop, cooperation.qqfav.QfavPluginProxyActivity, com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
        }
    }

    /* loaded from: classes28.dex */
    public static class SingleTop extends QfavPluginProxyActivity {
        @Override // cooperation.qqfav.QfavPluginProxyActivity, com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
            return dispatchTouchEvent;
        }

        @Override // cooperation.qqfav.QfavPluginProxyActivity, com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
        }
    }

    private static String H2(Intent intent) {
        switch (intent.getIntExtra("nOperation", -1)) {
            case 0:
            case 1:
            case 3:
            case 6:
            case 7:
            case 8:
            case 11:
                return "com.qqfav.FavoriteIpcDelegate";
            case 2:
                return "com.qqfav.activity.FavoritesListActivity";
            case 4:
            case 5:
            case 10:
            default:
                ComponentName component = intent.getComponent();
                if (component == null) {
                    return null;
                }
                return component.getClassName();
            case 9:
                return "com.qqfav.group.activity.QfavGroupActivity";
        }
    }

    private static Class<? extends PluginProxyActivity> I2(Intent intent) {
        String H2 = H2(intent);
        if ("com.qqfav.FavoriteIpcDelegate".equals(H2)) {
            return ForResult.class;
        }
        if (H2 != null && (H2.equals("com.qqfav.activity.AddPhotosFavActivity") || H2.equals("com.qqfav.activity.AddLocationFavActivity") || H2.equals("com.qqfav.FavoriteIpcDelegate") || H2.equals("com.qqfav.file.activity.QfavFileBrowserActivity"))) {
            intent.setFlags(intent.getFlags() | 536870912);
        }
        if ((intent.getFlags() & 536870912) != 0) {
            return SingleTop.class;
        }
        if (H2 != null && (H2.equals("com.qqfav.activity.AddPhotosFavActivity") || H2.equals("com.qqfav.activity.AddLocationFavActivity") || H2.equals("com.qqfav.FavoriteIpcDelegate") || H2.equals("com.qqfav.file.activity.QfavFileBrowserActivity"))) {
            intent.setFlags(intent.getFlags() | 536870912);
            return SingleTop.class;
        }
        if ("com.qqfav.activity.EditPhotosActivity".equals(H2)) {
            if (((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("qfav_bug")) {
                if (Build.VERSION.SDK_INT >= 31) {
                    return DetailProxy.class;
                }
                intent.setFlags(intent.getFlags() | 536870912);
                return SingleTop.class;
            }
            if (Build.VERSION.SDK_INT == 31) {
                return DetailProxy.class;
            }
            intent.setFlags(intent.getFlags() | 536870912);
            return SingleTop.class;
        }
        return QfavPluginProxyActivity.class;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void J2(final Context context, final String str, final Intent intent, final int i3, final boolean z16) {
        QfavPluginProxyService.d();
        QLog.d("QfavPluginProxyActivity: ", 1, "openPluginActivity");
        if (intent.getBooleanExtra("bShowProgress", false) && !QfavHelper.t(context)) {
            N2(new Runnable() { // from class: cooperation.qqfav.QfavPluginProxyActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    QfavPluginProxyActivity.K2(context, str, intent, i3, z16, new cooperation.qqfav.widget.c(context));
                }
            });
        } else {
            N2(new Runnable() { // from class: cooperation.qqfav.QfavPluginProxyActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    QfavPluginProxyActivity.K2(context, str, intent, i3, z16, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void K2(final Context context, String str, Intent intent, int i3, boolean z16, cooperation.qqfav.widget.c cVar) {
        String H2 = H2(intent);
        intent.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, true);
        intent.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 1);
        if (z16 || !(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        final IPluginManager.i iVar = new IPluginManager.i(0);
        iVar.f390198d = "qqfav.apk";
        iVar.f390201g = "qqfav.apk";
        iVar.f390197c = str;
        iVar.f390202h = H2;
        iVar.f390203i = I2(intent);
        iVar.f390204j = intent;
        iVar.f390205k = i3;
        iVar.f390206l = cVar;
        iVar.f390212r = 30000;
        iVar.f390211q = null;
        iVar.f390210p = false;
        N2(new Runnable() { // from class: cooperation.qqfav.QfavPluginProxyActivity.4
            @Override // java.lang.Runnable
            public void run() {
                IPluginManager.B5(context, iVar);
            }
        });
        QLog.i(ProcessConstant.QQFAV, 1, "QfavPluginProxyActivity: openPluginActivityForResult: " + H2);
    }

    public static boolean L2(Context context, String str, Intent intent, int i3) {
        return M2(context, str, intent, i3, false);
    }

    public static boolean M2(final Context context, final String str, final Intent intent, final int i3, final boolean z16) {
        QLog.d("QfavPluginProxyActivity: ", 1, "openPluginActivityForResult");
        if (QLog.isColorLevel()) {
            QLog.d("QfavPluginProxyActivity: ", 2, "openPluginActivityForResult " + Log.getStackTraceString(new Throwable()));
        }
        ThreadManagerV2.excute(new Runnable() { // from class: cooperation.qqfav.QfavPluginProxyActivity.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    QfavPluginProxyActivity.J2(context, str, intent, i3, z16);
                } catch (Exception e16) {
                    QLog.e("QfavPluginProxyActivity: ", 1, "error : " + e16);
                }
            }
        }, 16, null, false);
        return true;
    }

    private static void N2(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity
    public String getPluginID() {
        return "qqfav.apk";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity
    public Class<? extends PluginProxyActivity> getProxyActivity(String str) {
        if (str.equals("com.qqfav.activity.ImageDetailActivity")) {
            return ImageViewer.class;
        }
        if (str.matches("com\\.qqfav\\.activity\\..*DetailActivity")) {
            if (this instanceof DetailProxy) {
                return SingleTop.class;
            }
            return DetailProxy.class;
        }
        if (str.equals("com.qqfav.group.activity.QfavGroupActivity")) {
            if (Build.VERSION.SDK_INT < 31 || !"com.qqfav.edit.QfavEditActivity".equals(this.mLaunchActivity)) {
                return SingleTop.class;
            }
            return DetailProxy.class;
        }
        if (!str.equals("com.qqfav.activity.AddPhotosFavActivity") && !str.equals("com.qqfav.activity.AddLocationFavActivity") && !str.equals("com.qqfav.edit.QfavTitleEditActivity") && !str.equals("com.qqfav.FavoriteIpcDelegate") && !str.equals("com.qqfav.edit.EditPhotosActivity") && !str.equals("com.qqfav.file.activity.QfavFileBrowserActivity")) {
            if (str.equals("com.qqfav.edit.QfavEditActivity")) {
                if (((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("qfav_bug")) {
                    if (Build.VERSION.SDK_INT >= 31 && !"com.qqfav.file.activity.QfavFileBrowserActivity".equals(this.mLaunchActivity)) {
                        return SingleTop.class;
                    }
                    return DetailProxy.class;
                }
                if (Build.VERSION.SDK_INT == 31 && !"com.qqfav.file.activity.QfavFileBrowserActivity".equals(this.mLaunchActivity)) {
                    return SingleTop.class;
                }
                return DetailProxy.class;
            }
            return super.getProxyActivity(str);
        }
        if (((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("qfav_bug") && ((str.equals("com.qqfav.activity.AddPhotosFavActivity") || str.equals("com.qqfav.edit.QfavTitleEditActivity") || str.equals("com.qqfav.edit.EditPhotosActivity")) && Build.VERSION.SDK_INT >= 31)) {
            return ForResult.class;
        }
        if ((!str.equals("com.qqfav.activity.AddPhotosFavActivity") && !str.equals("com.qqfav.edit.QfavTitleEditActivity") && !str.equals("com.qqfav.edit.EditPhotosActivity")) || Build.VERSION.SDK_INT != 31) {
            return SingleTop.class;
        }
        return DetailProxy.class;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ca.a(this);
        getIntent().removeExtra(FlingConstant.FLING_ACTION_KEY);
        super.onCreate(bundle);
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getInt("nOperation") == 6) {
            super.overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
        }
    }
}
