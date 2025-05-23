package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.teamwork.api.ICameraHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class CameraHelperImpl implements ICameraHelper {
    private static final String TAG = "CameraHelperImpl";
    private String mCallback;
    private Handler mHandler;
    private final WebViewPlugin mHostPlugin;
    private QQPermission mQQPermission;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends QQPermission.BasePermissionsListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QLog.d(CameraHelperImpl.TAG, 1, "checkPermission user grant");
            CameraHelperImpl.this.removePermissionUncertainMonitor();
            CameraHelperImpl.this.onPermissionResult(true, 0);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            QLog.e(CameraHelperImpl.TAG, 1, "checkPermission user denied");
            CameraHelperImpl.this.removePermissionUncertainMonitor();
            CameraHelperImpl.this.onPermissionResult(false, 1830003);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1 && !CameraHelperImpl.this.checkSelfPermission()) {
                QLog.e(CameraHelperImpl.TAG, 1, "checkPermission uncertain");
                CameraHelperImpl.this.onPermissionResult(false, 1830004);
            }
        }
    }

    public CameraHelperImpl(WebViewPlugin webViewPlugin) {
        this.mHostPlugin = webViewPlugin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSelfPermission() {
        AppActivity activity = getActivity();
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.TENCENT_DOCS_CAMERA, QQPermissionConstants.Business.SCENE.TENCENT_DOCS_USE_CAMERA));
        this.mQQPermission = qQPermission;
        if (qQPermission == null) {
            return false;
        }
        if (activity != null && qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) != 0) {
            return false;
        }
        return true;
    }

    private AppActivity getActivity() {
        WebViewPlugin.b bVar;
        Activity a16;
        WebViewPlugin webViewPlugin = this.mHostPlugin;
        if (webViewPlugin == null) {
            bVar = null;
        } else {
            bVar = webViewPlugin.mRuntime;
        }
        if (bVar == null) {
            a16 = null;
        } else {
            a16 = bVar.a();
        }
        if (!(a16 instanceof AppActivity)) {
            return null;
        }
        return (AppActivity) a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPermissionResult(boolean z16, int i3) {
        String str;
        String str2 = this.mCallback;
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("granted", z16);
                jSONObject.put("errorCode", i3);
                jSONObject.put("cmd", "onPermissionResult");
                str = jSONObject.toString();
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "onPermissionResult error", e16);
                str = "";
            }
            if (this.mHostPlugin != null && !TextUtils.isEmpty(str)) {
                this.mHostPlugin.callJs(str2, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePermissionUncertainMonitor() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    private void requestPermission() {
        if (getActivity() == null) {
            return;
        }
        this.mQQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new a());
        if (this.mHandler == null) {
            this.mHandler = new b(Looper.getMainLooper());
        }
        this.mHandler.sendEmptyMessageDelayed(1, 10000L);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ICameraHelper
    public boolean checkPermission(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "checkPermission failed, callback is invalid.");
            return false;
        }
        if (this.mHostPlugin == null) {
            return false;
        }
        this.mCallback = str;
        if (checkSelfPermission()) {
            onPermissionResult(true, 0);
            return true;
        }
        requestPermission();
        return false;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ICameraHelper
    public void destroy() {
        this.mCallback = null;
        removePermissionUncertainMonitor();
        this.mHandler = null;
    }
}
