package com.tencent.mobileqq.activity.faceunlock;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class FaceUnblockCameraJsApiPlugin extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private String f182198d;

    /* renamed from: e, reason: collision with root package name */
    private String f182199e;

    /* renamed from: f, reason: collision with root package name */
    public BroadcastReceiver f182200f;

    /* loaded from: classes10.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FaceUnblockCameraJsApiPlugin.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if (intent.getBooleanExtra("recording_time_out", false)) {
                QQToast.makeText(FaceUnblockCameraJsApiPlugin.this.mRuntime.a(), R.string.ixv, 0).show();
                QLog.e("FaceUnblockCameraJsApiPlugin", 1, "FaceUnlock record timeout!");
            } else {
                FaceUnblockCameraJsApiPlugin.this.r(intent.getStringExtra("target_media_url"));
            }
        }
    }

    public FaceUnblockCameraJsApiPlugin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f182200f = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str) {
        if (!TextUtils.isEmpty(str)) {
            ThreadManagerV2.excute(new Runnable(str) { // from class: com.tencent.mobileqq.activity.faceunlock.FaceUnblockCameraJsApiPlugin.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f182201d;

                {
                    this.f182201d = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FaceUnblockCameraJsApiPlugin.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        byte[] readFile = FileUtils.readFile(this.f182201d);
                        if (readFile != null) {
                            ThreadManager.getUIHandler().post(new Runnable(Base64.encodeToString(readFile, 0)) { // from class: com.tencent.mobileqq.activity.faceunlock.FaceUnblockCameraJsApiPlugin.2.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ String f182202d;

                                {
                                    this.f182202d = r5;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) r5);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    try {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("retCode", 0);
                                        jSONObject.put("base64", this.f182202d);
                                        FaceUnblockCameraJsApiPlugin faceUnblockCameraJsApiPlugin = FaceUnblockCameraJsApiPlugin.this;
                                        faceUnblockCameraJsApiPlugin.callJs(faceUnblockCameraJsApiPlugin.f182198d, jSONObject.toString());
                                    } catch (Exception e16) {
                                        QLog.e("FaceUnblockCameraJsApiPlugin", 1, "FaceUnlock callJs error", e16);
                                    }
                                }
                            });
                        } else {
                            QLog.e("FaceUnblockCameraJsApiPlugin", 1, "FaceUnlock FileUtils.readFile returns null, filepath:" + this.f182201d);
                        }
                    } catch (Exception e16) {
                        QLog.e("FaceUnblockCameraJsApiPlugin", 1, "FaceUnlock read from filePath error", e16);
                    }
                }
            }, 64, null, true);
        } else {
            QLog.d("FaceUnblockCameraJsApiPlugin", 1, "onActivityResult failed: media url is null");
        }
    }

    private void s(Activity activity, String str) {
        if (((ICaptureUtil) QRoute.api(ICaptureUtil.class)).supportCapture()) {
            Bundle bundle = new Bundle();
            bundle.putInt("edit_video_type", 10025);
            bundle.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.W.b());
            bundle.putInt("entrance_type", 132);
            bundle.putBoolean(AECameraConstants.ENABLE_LOCAL_VIDEO, false);
            bundle.putBoolean(PeakConstants.ARG_BEAUTY, false);
            bundle.putBoolean(PeakConstants.ARG_ALBUM, false);
            bundle.putBoolean(PeakConstants.ARG_SHARP_FACE, false);
            bundle.putBoolean(PeakConstants.ARG_SUPPORT_FILTER, false);
            bundle.putInt("ability_flag", 3);
            bundle.putIntegerArrayList(AECameraConstants.SUPPORT_INTENT_MODE, new ArrayList<>(Arrays.asList(0)));
            bundle.putString("key_face_unlock_code", str);
            Intent intent = new Intent();
            intent.setAction("from_webtool_launchshortvideo");
            intent.setClass(activity, JumpActivity.class);
            intent.putExtras(bundle);
            activity.startActivity(intent);
            return;
        }
        QLog.d("FaceUnblockCameraJsApiPlugin", 1, "openQIMCameraCaptureActivity failed: not support media codec");
        this.f182199e = ShortVideoUtils.getLocalShortVideoPath();
        Intent intent2 = new Intent("android.media.action.VIDEO_CAPTURE");
        intent2.putExtra("output", Uri.fromFile(new File(this.f182199e)));
        intent2.putExtra("android.intent.extra.videoQuality", 1);
        startActivityForResult(intent2, (byte) 0);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "faceUnblockCamera";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("FaceUnblockCameraJsApiPlugin", 2, "Call FaceUnblockCameraJsApiPlugin handleJsRequest, url" + str + " pkgName:" + str2);
        }
        if (!"faceUnblockCamera".equals(str2)) {
            return false;
        }
        if ("startPTVActivity".equals(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("FaceUnblockCameraJsApiPlugin", 2, "Call startPTVActivity, args:" + strArr);
            }
            this.f182198d = str.split("#")[1];
            if (strArr != null && strArr.length > 0) {
                s(this.mRuntime.a(), strArr[0]);
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, intent, Byte.valueOf(b16), Integer.valueOf(i3));
            return;
        }
        super.onActivityResult(intent, b16, i3);
        if (b16 == 0 && i3 == -1) {
            if (QLog.isColorLevel()) {
                QLog.i("FaceUnblockCameraJsApiPlugin", 2, "onActivityResult: RESULT_OK, doParseData");
            }
            r(this.f182199e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onCreate();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.FaceUnblockCameraJsApiPlugin");
        this.mRuntime.a().registerReceiver(this.f182200f, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onDestroy();
            this.mRuntime.a().unregisterReceiver(this.f182200f);
        }
    }
}
