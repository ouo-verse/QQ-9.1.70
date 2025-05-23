package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class EncryTokenActivity extends Activity {
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        String str;
        Intent intent;
        MobileQQ.sMobileQQ.addCommonActivity(this);
        super.onCreate(bundle);
        try {
            intent = super.getIntent();
        } catch (Exception unused) {
        }
        if (intent != null) {
            str = intent.getStringExtra("key_action");
            com.tencent.open.agent.util.d.e(str, 0L);
            if (!"action_check_token".equals(str)) {
                SharedPreferences a16 = lq3.b.a(this, "openid_encrytoken");
                try {
                    String str2 = super.getIntent().getStringExtra("openid") + "";
                    String stringExtra = super.getIntent().getStringExtra(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN);
                    String string = a16.getString(str2, "");
                    Intent intent2 = new Intent();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("openid", str2);
                    jSONObject.put(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, stringExtra);
                    jSONObject.put("encry_token", string);
                    intent2.putExtra("key_response", jSONObject.toString());
                    super.setResult(-1, intent2);
                    super.finish();
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            Intent intent3 = new Intent();
            intent3.putExtra("key_response", "");
            super.setResult(-1, intent3);
            super.finish();
            return;
        }
        str = "";
        com.tencent.open.agent.util.d.e(str, 0L);
        if (!"action_check_token".equals(str)) {
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        MobileQQ.sMobileQQ.removeCommonActivity(this);
    }
}
