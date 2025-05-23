package com.tencent.gdtad.basics.motivevideo.hippy.web;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.ams.dsdk.view.webview.DKWebView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
final class c implements View.OnTouchListener {

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<GdtMotiveHippyWebView> f109036d;

    public c(WeakReference<GdtMotiveHippyWebView> weakReference) {
        this.f109036d = weakReference;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GdtMotiveHippyWebView gdtMotiveHippyWebView;
        if (motionEvent == null) {
            QLog.e("GdtMotiveHippyWebViewOnTouchListener", 1, "[onTouch] error, event is null");
            return false;
        }
        if (motionEvent.getAction() == 0) {
            WeakReference<GdtMotiveHippyWebView> weakReference = this.f109036d;
            DKWebView.OnTouchDownListener onTouchDownListener = null;
            if (weakReference != null) {
                gdtMotiveHippyWebView = weakReference.get();
            } else {
                gdtMotiveHippyWebView = null;
            }
            if (gdtMotiveHippyWebView != null) {
                onTouchDownListener = gdtMotiveHippyWebView.t();
            }
            if (onTouchDownListener != null) {
                QLog.i("GdtMotiveHippyWebViewOnTouchListener", 1, "[onTouch] event:" + motionEvent);
                onTouchDownListener.onTouchDown(motionEvent.getX(), motionEvent.getY());
            } else {
                QLog.e("GdtMotiveHippyWebViewOnTouchListener", 1, "[onTouch] error, listener is null, event:" + motionEvent);
            }
        }
        return false;
    }
}
