package cooperation.troop_homework.outer;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelPresenterCreater;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TroopHWRecordArrangeActivity extends TroopHWRecordBaseActivity {

    /* renamed from: g0, reason: collision with root package name */
    private String f391003g0 = null;

    /* renamed from: h0, reason: collision with root package name */
    private int f391004h0 = 20;

    /* renamed from: i0, reason: collision with root package name */
    private Handler f391005i0 = new a();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j3;
            int i3 = message.what;
            if (i3 != 3) {
                if (i3 != 101) {
                    if (i3 == 102) {
                        String obj = message.obj.toString();
                        File file = new File(obj);
                        if (file.exists()) {
                            j3 = file.length();
                        } else {
                            j3 = 0;
                        }
                        TroopHWRecordArrangeActivity troopHWRecordArrangeActivity = TroopHWRecordArrangeActivity.this;
                        troopHWRecordArrangeActivity.f391010d0 = new AudioInfo(obj, (int) troopHWRecordArrangeActivity.f391007a0.i(), j3);
                        TroopHWRecordArrangeActivity.this.f391007a0.setVisibility(8);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("webid", TroopHWRecordArrangeActivity.this.f391003g0);
                            jSONObject.put("type", QQPermissionConstants.Permission.AUIDO_GROUP);
                            jSONObject.put("state", "stop");
                            jSONObject.put("time", Math.round(TroopHWRecordArrangeActivity.this.f391010d0.duration / 1000.0f));
                            jSONObject.put("size", TroopHWRecordArrangeActivity.this.f391010d0.size);
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                        Intent intent = new Intent();
                        intent.putExtra("jscallback", jSONObject.toString());
                        intent.putExtra("localPath", TroopHWRecordArrangeActivity.this.f391010d0.path);
                        TroopHWRecordArrangeActivity.this.setResult(-1, intent);
                        TroopHWRecordArrangeActivity.this.finish();
                        return;
                    }
                    return;
                }
                TroopHWRecordArrangeActivity.this.setResult(0);
                TroopHWRecordArrangeActivity.this.finish();
                return;
            }
            TroopHWRecordArrangeActivity.this.f391011e0 = true;
        }
    }

    @Override // cooperation.troop_homework.outer.TroopHWRecordBaseActivity
    protected void F2() {
        CommonRecordSoundPanel commonRecordSoundPanel = (CommonRecordSoundPanel) LayoutInflater.from(this).inflate(R.layout.a18, (ViewGroup) null);
        this.f391007a0 = commonRecordSoundPanel;
        commonRecordSoundPanel.setPresenter(((IAudioPanelPresenterCreater) QRoute.api(IAudioPanelPresenterCreater.class)).createCommonRecordSoundPanelPresenter(this.f391007a0));
        this.f391008b0.addView(this.f391007a0);
        this.f391007a0.k(getAppRuntime(), this, this.f391005i0, 0);
        this.f391007a0.reset();
        this.f391007a0.setTimeOutTime(360000);
        this.f391007a0.setPermissionBusinessParams(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_RECORD_AUDIO, QQPermissionConstants.Business.SCENE.QQ_TROOP_HOMEWORK_RECORD_AUDIO);
    }

    @Override // cooperation.troop_homework.outer.TroopHWRecordBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cooperation.troop_homework.outer.TroopHWRecordBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        boolean doOnCreate = super.doOnCreate(bundle);
        if (getIntent() != null) {
            this.f391003g0 = getIntent().getStringExtra("webid");
        }
        return doOnCreate;
    }

    @Override // cooperation.troop_homework.outer.TroopHWRecordBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
