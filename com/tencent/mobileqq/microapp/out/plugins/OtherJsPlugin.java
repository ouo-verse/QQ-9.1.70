package com.tencent.mobileqq.microapp.out.plugins;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.recent.l;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.microapp.MiniAppInterface;
import com.tencent.mobileqq.microapp.R;
import com.tencent.mobileqq.microapp.app.a;
import com.tencent.mobileqq.microapp.sdk.MiniAppController;
import com.tencent.mobileqq.microapp.sdk.OutBaseJsPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes15.dex */
public class OtherJsPlugin extends OutBaseJsPlugin {
    static IPatchRedirector $redirector_ = null;
    public static final String MA_PERMISSION_BROADCAST = "com.tencent.msg.permission.pushnotify";
    public static final String MICRO_APP_SCAN_DATA_RESULT = "com.tencent.mobileqq.microapp.out.plugins.scanResultData";
    public static final String MICRO_APP_SCAN_RESULT = "com.tencent.mobileqq.microapp.out.plugins.scanResultAction";
    public static final String MICRO_APP_SCAN_RESULT_TYPE = "com.tencent.mobileqq.microapp.out.plugins.scanResultType";
    public static final String TAG = "OtherJsPlugin";
    Set eventMap;
    private int mSeq;
    private BroadcastReceiver scanResultReceiver;

    public OtherJsPlugin(MiniAppInterface miniAppInterface) {
        super(miniAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) miniAppInterface);
            return;
        }
        this.scanResultReceiver = null;
        HashSet hashSet = new HashSet();
        this.eventMap = hashSet;
        hashSet.add("openSetting");
        this.eventMap.add("getSetting");
        this.eventMap.add("scanCode");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackSettingEvent(String str, String str2, int i3) {
        String str3;
        int i16;
        String str4 = "";
        com.tencent.mobileqq.microapp.app.a authorizeCenter = this.appInterface.getAuthorizeCenter(str2);
        if (authorizeCenter == null) {
            return;
        }
        List<a.C8028a> a16 = authorizeCenter.a(6);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (a.C8028a c8028a : a16) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scope", c8028a.f245883a);
                if (c8028a.f245884b == 2) {
                    i16 = 1;
                } else {
                    i16 = 0;
                }
                jSONObject2.put("state", i16);
                jSONArray.mo162put(jSONObject2);
            }
            jSONObject.put("authSetting", jSONArray);
            JSONObject a17 = com.tencent.mobileqq.microapp.a.c.a(str, jSONObject);
            if (a17 == null) {
                str3 = "";
            } else {
                str3 = a17.toString();
            }
            if (!TextUtils.isEmpty(str3)) {
                handleNativeResponse(str, str3, i3);
            }
        } catch (JSONException e16) {
            if (com.tencent.mobileqq.microapp.appbrand.b.c.b(str2)) {
                com.tencent.mobileqq.microapp.appbrand.b.c.a(TAG, 2, str2, e16, new Object[0]);
            }
            JSONObject b16 = com.tencent.mobileqq.microapp.a.c.b(str, (JSONObject) null);
            if (b16 != null) {
                str4 = b16.toString();
            }
            if (str4 != null) {
                handleNativeResponse(str, str4, i3);
            }
        }
    }

    public void enterQRCode(BaseActivity baseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseActivity);
            return;
        }
        if (!l.canEnterQRCode(baseActivity)) {
            return;
        }
        Intent intent = new Intent(baseActivity, (Class<?>) ScannerActivity.class);
        intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, baseActivity.getString(R.string.a));
        intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, baseActivity.getString(R.string.a));
        intent.putExtra("start_time", System.currentTimeMillis());
        intent.putExtra("from", "micro_app");
        baseActivity.startActivity(intent);
        BroadcastReceiver broadcastReceiver = this.scanResultReceiver;
        if (broadcastReceiver != null) {
            try {
                baseActivity.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused) {
            }
            this.scanResultReceiver = null;
        }
        this.scanResultReceiver = new a(this);
        baseActivity.registerReceiver(this.scanResultReceiver, new IntentFilter(MICRO_APP_SCAN_RESULT), "com.tencent.msg.permission.pushnotify", null);
        baseActivity.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.microapp.sdk.OutBaseJsPlugin
    public Set getEventMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.eventMap;
    }

    @Override // com.tencent.mobileqq.microapp.sdk.OutBaseJsPlugin
    public String handleNativeRequest(Activity activity, String str, String str2, String str3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, this, activity, str, str2, str3, Integer.valueOf(i3));
        }
        if ("openSetting".equals(str2)) {
            MiniAppController.getInstance().setActivityResultListener(new b(this, str, str2, i3));
            openSettingActivity(activity, str);
        } else if ("getSetting".equals(str2)) {
            com.tencent.mobileqq.microapp.appbrand.b.a.a(new c(this, str2, str, i3));
        } else if ("scanCode".equals(str2)) {
            this.mSeq = i3;
            enterQRCode((BaseActivity) activity);
        }
        return super.handleNativeRequest(activity, str, str2, str3, i3);
    }

    private void openSettingActivity(Activity activity, String str) {
    }
}
