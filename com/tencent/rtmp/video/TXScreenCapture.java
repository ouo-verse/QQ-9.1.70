package com.tencent.rtmp.video;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class TXScreenCapture {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class TXScreenCaptureAssistantActivity extends Activity {
        static IPatchRedirector $redirector_ = null;
        private static final int REQUEST_CODE = 100;
        private static final String TAG = "TXScreenCaptureAssistantActivity";
        private volatile boolean mIsStop;
        private MediaProjectionManager mMediaProjectionManager;

        public TXScreenCaptureAssistantActivity() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mIsStop = false;
            }
        }

        @Override // android.app.Activity, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
            return dispatchTouchEvent;
        }

        public boolean isStop() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.mIsStop;
        }

        @Override // android.app.Activity
        public void onActivityResult(int i3, int i16, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
                return;
            }
            BaseBridge.printLog(TAG, "onActivityResult " + this + ", resultCode:" + i16 + ", data:" + intent);
            MediaProjection mediaProjection = null;
            if (intent == null) {
                VirtualDisplayManagerProxy.getInstance().signalSessionRequestFinish(null);
                finish();
                return;
            }
            if (BaseBridge.getSystemOSVersion() >= 26) {
                BaseBridge.printLog(TAG, "startForegroundService");
                Intent intent2 = new Intent(this, (Class<?>) ScreenCaptureService.class);
                intent2.putExtra("code", i16);
                intent2.putExtra("data", intent);
                startForegroundService(intent2);
            } else {
                try {
                    mediaProjection = this.mMediaProjectionManager.getMediaProjection(i16, intent);
                } catch (Throwable th5) {
                    BaseBridge.printLog(TAG, "onActivityResult mMediaProjectionManager.getMediaProjection fail.".concat(String.valueOf(th5)));
                }
                BaseBridge.printLog(TAG, "ProjectionManger get mediaProjection:".concat(String.valueOf(mediaProjection)));
                VirtualDisplayManagerProxy.getInstance().signalSessionRequestFinish(mediaProjection);
            }
            finish();
        }

        @Override // android.app.Activity, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
        }

        @Override // android.app.Activity
        public void onCreate(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                return;
            }
            super.onCreate(bundle);
            BaseBridge.printLog(TAG, "onCreate ".concat(String.valueOf(this)));
            requestWindowFeature(1);
            MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getSystemService("media_projection");
            this.mMediaProjectionManager = mediaProjectionManager;
            try {
                startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), 100);
                VirtualDisplayManagerProxy.getInstance().registerRequestPermissionActivity(this);
            } catch (Throwable th5) {
                BaseBridge.printLog(TAG, "Start permission activity failed. ".concat(String.valueOf(th5)));
                VirtualDisplayManagerProxy.getInstance().signalSessionRequestFinish(null);
                finish();
            }
        }

        @Override // android.app.Activity
        protected void onDestroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            BaseBridge.printLog(TAG, "onDestroy ".concat(String.valueOf(this)));
            VirtualDisplayManagerProxy.getInstance().unRegisterRequestPermissionActivity(this);
            super.onDestroy();
        }

        @Override // android.app.Activity
        protected void onStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            super.onStart();
            this.mIsStop = false;
            BaseBridge.printLog(TAG, "onStart:".concat(String.valueOf(this)));
        }

        @Override // android.app.Activity
        protected void onStop() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            super.onStop();
            this.mIsStop = true;
            BaseBridge.printLog(TAG, "onStop:".concat(String.valueOf(this)));
        }
    }

    public TXScreenCapture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
