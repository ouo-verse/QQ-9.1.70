package cooperation.qlink;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qlink.QlAndQQInterface;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QlinkAgentActivity extends BaseActivity {
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (10 == i16) {
            setResult(10, intent);
        }
        if ((intent != null && intent.getExtras() != null && (intent.getBooleanExtra("foward_editbar", false) || intent.getBooleanExtra("destroy_last_activity", false))) || i16 == 4) {
            this.app.getQQProxyForQlink().F(new QlAndQQInterface.DailogClickInfo(8));
        } else {
            super.onActivityResult(i3, i16, intent);
        }
        super.finish();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mNeedStatusTrans = false;
        super.onCreate(bundle);
        setTitle((CharSequence) null);
        if (1 == getIntent().getIntExtra("what", 0)) {
            long longExtra = getIntent().getLongExtra("param.sessionid", 0L);
            if (0 != longExtra) {
                QQAppInterface qQAppInterface = this.app;
                if (qQAppInterface == null) {
                    super.finish();
                    return;
                }
                FileManagerDataCenter fileManagerDataCenter = qQAppInterface.getFileManagerDataCenter();
                if (fileManagerDataCenter == null) {
                    super.finish();
                    return;
                }
                FileManagerEntity D = fileManagerDataCenter.D(longExtra);
                if (D != null) {
                    ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
                    forwardFileInfo.w(D.getCloudType());
                    forwardFileInfo.N(10010);
                    forwardFileInfo.E(D.nSessionId);
                    forwardFileInfo.V(D.uniseq);
                    forwardFileInfo.y(D.fileName);
                    forwardFileInfo.z(D.fileSize);
                    forwardFileInfo.Z(D.Uuid);
                    forwardFileInfo.C(D.getFilePath());
                    Intent intent = new Intent(getApplicationContext(), (Class<?>) FileBrowserActivity.class);
                    intent.putExtra("fileinfo", forwardFileInfo);
                    intent.putExtra("from_qlink_enter_recent", true);
                    startActivityForResult(intent, 102);
                    return;
                }
            }
        }
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
    }
}
