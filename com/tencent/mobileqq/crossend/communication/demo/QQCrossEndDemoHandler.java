package com.tencent.mobileqq.crossend.communication.demo;

import ab1.a;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.crossend.communication.QQWebApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@QQWebApi(business = "QQCrossEndDemo", desc = "QQ\u8de8\u7aef\u901a\u4fe1Demo")
/* loaded from: classes10.dex */
public class QQCrossEndDemoHandler {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQCrossEndDemoHandler";

    public QQCrossEndDemoHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Activity getCurrentActivity() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(invoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        return null;
    }

    private void openH5Demo(JSONObject jSONObject, a aVar) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null && !currentActivity.isFinishing()) {
            Intent intent = new Intent(currentActivity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", "https://downv6.qq.com/extendfriend/h5demo.html");
            currentActivity.startActivity(intent);
        }
    }

    private void openHippyDemo(JSONObject jSONObject, a aVar) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null && !currentActivity.isFinishing()) {
            OpenHippyInfo openHippyInfo = new OpenHippyInfo();
            openHippyInfo.bundleName = HippyQQConstants.ModuleName.QQ_NEARBY;
            openHippyInfo.processName = "main";
            openHippyInfo.isDisablePreload = true;
            openHippyInfo.framework = "react";
            openHippyInfo.url = "nearby.qq.hippy/demo";
            ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).openHippyPage(currentActivity, openHippyInfo);
        }
    }

    private void showDialog(JSONObject jSONObject, a aVar) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null && !currentActivity.isFinishing()) {
            try {
                currentActivity.runOnUiThread(new Runnable(currentActivity, jSONObject.getString("dialogTitle"), jSONObject.getString("dialogBody"), aVar) { // from class: com.tencent.mobileqq.crossend.communication.demo.QQCrossEndDemoHandler.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Activity f203041d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f203042e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ String f203043f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ ab1.a f203044h;

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.crossend.communication.demo.QQCrossEndDemoHandler$1$a */
                    /* loaded from: classes10.dex */
                    class a implements DialogInterface.OnClickListener {
                        static IPatchRedirector $redirector_;

                        a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                                return;
                            }
                            QLog.i(QQCrossEndDemoHandler.TAG, 1, "\u70b9\u51fb\u4e86Native\u7684\u5f39\u7a97\u786e\u8ba4\u6309\u94ae");
                            dialogInterface.dismiss();
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("code", 0);
                                jSONObject.put("data", "1000");
                                AnonymousClass1.this.f203044h.f(jSONObject);
                            } catch (JSONException e16) {
                                QLog.e(QQCrossEndDemoHandler.TAG, 1, e16, new Object[0]);
                            }
                        }
                    }

                    {
                        this.f203041d = currentActivity;
                        this.f203042e = r7;
                        this.f203043f = r8;
                        this.f203044h = aVar;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, QQCrossEndDemoHandler.this, currentActivity, r7, r8, aVar);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(this.f203041d);
                        builder.setTitle(this.f203042e);
                        builder.setMessage(this.f203043f);
                        builder.setPositiveButton("\u786e\u8ba4", new a());
                        builder.show();
                    }
                });
            } catch (JSONException e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
        }
    }
}
