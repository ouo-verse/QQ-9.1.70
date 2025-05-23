package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.mapview.QMapView;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AutoLocationMapView extends QMapView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    Handler f302254d;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AutoLocationMapView.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            GeoPoint geoPoint = (GeoPoint) message.obj;
            AutoLocationMapView.this.getMap().clear();
            if (message.arg1 == 0) {
                AutoLocationMapView.this.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(geoPoint.getLatitudeE6() / 1000000.0d, geoPoint.getLongitudeE6() / 1000000.0d)));
                AutoLocationMapView.this.getMap().moveCamera(CameraUpdateFactory.zoomTo(AutoLocationMapView.this.getMap().getMaxZoomLevel()));
                QQMapActivity.showInfoWindow(AutoLocationMapView.this.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(com.tencent.mobileqq.util.j.g(AutoLocationMapView.this.getContext().getResources(), R.drawable.bro))).snippet("").position(new LatLng(geoPoint.getLatitudeE6() / 1000000.0d, geoPoint.getLongitudeE6() / 1000000.0d))));
            }
            AutoLocationMapView.this.getClass();
        }
    }

    public AutoLocationMapView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f302254d = new a();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    public AutoLocationMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f302254d = new a();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }
}
