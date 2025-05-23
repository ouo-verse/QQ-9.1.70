package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* loaded from: classes28.dex */
public class TroopBaseProxyActivity extends PluginProxyActivity {
    public static Dialog installPlugin(Activity activity) {
        ReportDialog reportDialog;
        ReportDialog reportDialog2 = null;
        try {
            reportDialog = new ReportDialog(activity, R.style.qZoneInputDialog);
        } catch (OutOfMemoryError e16) {
            e = e16;
        }
        try {
            reportDialog.setCancelable(true);
            reportDialog.setContentView(R.layout.f168383uh);
            WindowManager.LayoutParams attributes = reportDialog.getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            reportDialog.getWindow().setAttributes(attributes);
            reportDialog.show();
            ((TextView) reportDialog.findViewById(R.id.photo_prievew_progress_dialog_text)).setText(HardCodeUtil.qqStr(R.string.uco));
            return reportDialog;
        } catch (OutOfMemoryError e17) {
            e = e17;
            reportDialog2 = reportDialog;
            if (QLog.isColorLevel()) {
                QLog.e("TroopBaseProxyActivity", 2, e.getStackTrace());
            }
            return reportDialog2;
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
        return null;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
