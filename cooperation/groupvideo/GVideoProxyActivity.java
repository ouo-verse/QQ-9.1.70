package cooperation.groupvideo;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.widget.QQProgressDialog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;

/* loaded from: classes38.dex */
public class GVideoProxyActivity extends PluginProxyActivity {

    /* renamed from: a0, reason: collision with root package name */
    public FlingHandler f390122a0;

    /* loaded from: classes38.dex */
    public static class b extends FlingGestureHandler {

        /* renamed from: d, reason: collision with root package name */
        boolean f390123d;

        public b(Activity activity) {
            super(activity);
            this.f390123d = true;
        }

        @Override // com.tencent.mobileqq.activity.fling.FlingGestureHandler, com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener
        public void flingLToR() {
            if (this.f390123d) {
                super.flingLToR();
            }
        }
    }

    public static Dialog installPlugin(Activity activity) {
        QQProgressDialog qQProgressDialog = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.n75));
        qQProgressDialog.setOnDismissListener(new a());
        return qQProgressDialog;
    }

    public static void openPluginActivity(Activity activity, Intent intent, Dialog dialog, String str, String str2, int i3) {
        IPluginManager.i iVar = new IPluginManager.i(1);
        iVar.f390198d = "group_video_plugin.apk";
        iVar.f390201g = PluginInfo.D;
        iVar.f390197c = str2;
        iVar.f390202h = str;
        iVar.f390203i = GVideoProxyActivity.class;
        if (intent == null) {
            intent = new Intent();
        }
        iVar.f390204j = intent;
        iVar.f390206l = dialog;
        intent.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 2);
        iVar.f390204j.putExtra(PluginStatic.PARAM_PLUGIN_GESTURELOCK, true);
        iVar.f390205k = i3;
        iVar.f390212r = 20000;
        iVar.f390211q = null;
        IPluginManager.B5(activity, iVar);
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity
    public String getPluginID() {
        return "group_video_plugin.apk";
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity
    public Class<? extends PluginProxyActivity> getProxyActivity(String str) {
        return GVideoProxyActivity.class;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        FlingHandler flingHandler;
        super.onConfigurationChanged(configuration);
        if (!isWrapContent() || (flingHandler = this.f390122a0) == null) {
            return;
        }
        flingHandler.onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (getIntent().getExtras() != null) {
            this.f390122a0 = new b(this);
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f390122a0.onStart();
    }

    /* loaded from: classes38.dex */
    class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }
    }
}
