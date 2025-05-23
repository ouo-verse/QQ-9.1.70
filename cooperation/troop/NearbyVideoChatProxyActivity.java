package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd$SelfInfo;

/* loaded from: classes28.dex */
public class NearbyVideoChatProxyActivity extends TroopBaseProxyActivity {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class a implements IPluginManager.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f390883a;

        a(Activity activity) {
            this.f390883a = activity;
        }

        @Override // cooperation.plugin.IPluginManager.f
        public void a(boolean z16) {
            if (!z16) {
                this.f390883a.finish();
            }
        }
    }

    public static AppRuntime F2(BaseApplicationImpl baseApplicationImpl, String str) {
        Class<?> cls;
        if (baseApplicationImpl != null && str != null) {
            if (QLog.isColorLevel()) {
                QLog.d("NearbyVideoAppInterface", 2, "createAppInterface");
            }
            try {
                try {
                    cls = Class.forName("com.tencent.mobileqq.nearbyvideochat.com.tencent.av.app.NearbyVideoAppInterface");
                } catch (ClassNotFoundException unused) {
                    ClassLoader orCreateClassLoader = PluginStatic.getOrCreateClassLoader(baseApplicationImpl, "nearby_video_chat_plugin.apk");
                    Class<?> loadClass = orCreateClassLoader.loadClass("com.tencent.mobileqq.nearbyvideochat.com.tencent.av.app.NearbyVideoAppInterface");
                    BasicClassTypeUtil.setClassLoader(true, orCreateClassLoader);
                    cls = loadClass;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("NearbyVideoAppInterface", 2, "createAppInterface exp:", e16);
                }
            }
            if (cls == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("NearbyVideoAppInterface", 2, "createNearbyVideoAppInterface load class fail, return null");
                }
                return null;
            }
            Object newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (newInstance != null && (newInstance instanceof AppInterface)) {
                return (AppInterface) newInstance;
            }
            if (QLog.isColorLevel()) {
                QLog.d("NearbyVideoAppInterface", 2, "createAppInterface return null");
            }
        }
        return null;
    }

    public static void G2(AppInterface appInterface, Activity activity, Intent intent, String str, oidb_0x8dd$SelfInfo oidb_0x8dd_selfinfo, int i3) {
        H2(activity, intent, TroopBaseProxyActivity.installPlugin(activity), "com.tencent.mobileqq.nearbyvideochat.ui.AVActivity", appInterface, str, oidb_0x8dd_selfinfo, i3);
    }

    protected static void H2(Activity activity, Intent intent, Dialog dialog, String str, AppInterface appInterface, String str2, oidb_0x8dd$SelfInfo oidb_0x8dd_selfinfo, int i3) {
        long j3;
        long j16;
        Intent intent2;
        boolean z16;
        int i16;
        int i17;
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).loadAEBaseSo();
        SosoLbsInfo sosoInfo = ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).getSosoInfo();
        if (sosoInfo != null) {
            j3 = Double.valueOf(sosoInfo.mLocation.mLon02 * 1000000.0d).longValue();
            j16 = Double.valueOf(sosoInfo.mLocation.mLat02 * 1000000.0d).longValue();
        } else {
            j3 = 0;
            j16 = 0;
        }
        IPluginManager.i iVar = new IPluginManager.i(1);
        iVar.f390198d = "nearby_video_chat_plugin.apk";
        iVar.f390201g = PluginInfo.E;
        iVar.f390197c = appInterface.getCurrentAccountUin();
        iVar.f390202h = str;
        iVar.f390203i = NearbyVideoChatProxyActivity.class;
        if (intent == null) {
            intent2 = new Intent();
        } else {
            intent2 = intent;
        }
        iVar.f390204j = intent2;
        iVar.f390206l = dialog;
        intent2.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 2);
        iVar.f390204j.putExtra(PluginStatic.PARAM_PLUGIN_GESTURELOCK, true);
        iVar.f390204j.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 2);
        iVar.f390204j.putExtra("uinType", 10003);
        int i18 = 0;
        iVar.f390204j.putExtra("MultiAVType", 0);
        iVar.f390204j.putExtra("lon", j3);
        iVar.f390204j.putExtra(QCircleSchemeAttr.Polymerize.LAT, j16);
        if (!TextUtils.isEmpty(str2)) {
            iVar.f390204j.putExtra("nearbyVideoConfig", str2);
        }
        if (appInterface instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            if (qQAppInterface.isVideoChatting() && qQAppInterface.getAVNotifyCenter().c0()) {
                QLog.e("NearbyVideoChatProxyActivity", 2, "Fromwhere is SmallScreen");
                iVar.f390204j.putExtra("Fromwhere", "SmallScreen");
            }
        }
        Intent intent3 = iVar.f390204j;
        if (oidb_0x8dd_selfinfo != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        intent3.putExtra("hasSelfInfo", z16);
        if (oidb_0x8dd_selfinfo != null) {
            iVar.f390204j.putExtra("selfInfoLevel", oidb_0x8dd_selfinfo.uint32_charm_level.get());
            iVar.f390204j.putExtra("selfInfoAge", oidb_0x8dd_selfinfo.uint32_age.get());
            iVar.f390204j.putExtra("selfInfoGender", oidb_0x8dd_selfinfo.uint32_gender.get() + 1);
            i18 = oidb_0x8dd_selfinfo.uint32_charm_level.get();
            i16 = oidb_0x8dd_selfinfo.uint32_gender.get() + 1;
            i17 = oidb_0x8dd_selfinfo.uint32_age.get();
        } else {
            i16 = 0;
            i17 = 0;
        }
        iVar.f390205k = i3;
        iVar.f390212r = 10000;
        a aVar = null;
        iVar.f390211q = null;
        if (i3 == 123987) {
            aVar = new a(activity);
        }
        IPluginManager.C5(activity, iVar, aVar);
        ReportController.o(null, "dc00899", "grp_lbs", "", "video_chat", "num_entry", 0, 0, i18 + "", i16 + "", i17 + "", "");
    }

    @Override // cooperation.troop.TroopBaseProxyActivity, com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // cooperation.troop.TroopBaseProxyActivity, com.tencent.mobileqq.pluginsdk.PluginProxyActivity
    public String getPluginID() {
        return "nearby_video_chat_plugin.apk";
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity
    public Class<? extends PluginProxyActivity> getProxyActivity(String str) {
        return NearbyVideoChatProxyActivity.class;
    }

    @Override // cooperation.troop.TroopBaseProxyActivity, com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
