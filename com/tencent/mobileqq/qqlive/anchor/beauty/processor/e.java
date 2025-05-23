package com.tencent.mobileqq.qqlive.anchor.beauty.processor;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.util.ArrayList;
import java.util.HashMap;
import org.light.CameraController;
import org.light.utils.TouchEventUtils;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final IAegisLogApi f270455a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<PointF> f270456b;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f270455a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        }
    }

    public static String a(MotionEvent motionEvent, int i3, int i16) {
        if (motionEvent != null && i3 != 0 && i16 != 0) {
            return "{\"x\":" + (motionEvent.getX() / i3) + ",\"y\":" + (motionEvent.getY() / i16) + "}";
        }
        return "{\"x\":0,\"y\":0}";
    }

    public void b(CameraController cameraController, MotionEvent motionEvent, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, cameraController, motionEvent, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (motionEvent == null) {
            this.f270455a.e("TouchUtils", "updateMotionEvent motionEvent: null!");
            return;
        }
        if (i3 != 0 && i16 != 0) {
            if (cameraController == null) {
                this.f270455a.e("TouchUtils", "updateMotionEvent mCameraController == null!");
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("event.touchPoint", a(motionEvent, i3, i16));
            cameraController.setAssetData(hashMap);
            return;
        }
        this.f270455a.e("TouchUtils", "updateMotionEvent invalid view size!");
    }

    public void c(CameraController cameraController, MotionEvent motionEvent, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, cameraController, motionEvent, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (motionEvent == null) {
            this.f270455a.e("TouchUtils", "updateTouchEvent motionEvent: null!");
            return;
        }
        if (i3 != 0 && i16 != 0) {
            if (cameraController == null) {
                this.f270455a.e("TouchUtils", "updateTouchEvent mCameraController == null!");
                return;
            }
            if (this.f270456b == null) {
                this.f270456b = new ArrayList<>();
            }
            this.f270456b.clear();
            int pointerCount = motionEvent.getPointerCount();
            for (int i17 = 0; i17 < pointerCount; i17++) {
                this.f270456b.add(new PointF(motionEvent.getX(i17), motionEvent.getY(i17)));
            }
            cameraController.updateTouchEvent(TouchEventUtils.getEventAction(motionEvent), motionEvent.getDownTime(), motionEvent.getEventTime(), this.f270456b, i3, i16);
            return;
        }
        this.f270455a.e("TouchUtils", "updateTouchEvent invalid view size!");
    }
}
