package cooperation.groupvideo.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import cooperation.groupvideo.GVideoSmallScreenDialog;
import cooperation.groupvideo.api.IGVideoSmallScreenDialog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;

/* compiled from: P */
/* loaded from: classes38.dex */
public class GVideoSmallScreenDialogImpl implements IGVideoSmallScreenDialog {
    @Override // cooperation.groupvideo.api.IGVideoSmallScreenDialog
    public String getPluginID() {
        return "group_video_plugin.apk";
    }

    @Override // cooperation.groupvideo.api.IGVideoSmallScreenDialog
    public void openPluginActivity(Activity activity, Intent intent, String str) {
        IPluginManager.i iVar = new IPluginManager.i(1);
        iVar.f390198d = "group_video_plugin.apk";
        iVar.f390201g = PluginInfo.D;
        iVar.f390197c = str;
        iVar.f390202h = "com.gvideo.com.tencent.av.smallscreen.SmallScreenDialogActivity";
        iVar.f390203i = GVideoSmallScreenDialog.class;
        if (intent == null) {
            intent = new Intent();
        }
        iVar.f390204j = intent;
        intent.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 2);
        iVar.f390204j.putExtra(PluginStatic.PARAM_PLUGIN_GESTURELOCK, true);
        iVar.f390212r = 10000;
        iVar.f390211q = null;
        IPluginManager.B5(activity, iVar);
    }
}
