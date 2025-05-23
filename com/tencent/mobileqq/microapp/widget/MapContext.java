package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mobileqq.microapp.R;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class MapContext implements TencentMap.InfoWindowAdapter, TencentMap.OnInfoWindowClickListener, TencentMap.OnMapCameraChangeListener, TencentMap.OnMapClickListener, TencentMap.OnMapLoadedListener, TencentMap.OnMarkerClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected PageWebview f246074a;

    /* renamed from: b, reason: collision with root package name */
    public TencentMap f246075b;

    /* renamed from: c, reason: collision with root package name */
    public QQMapView f246076c;

    /* renamed from: d, reason: collision with root package name */
    public int f246077d;

    /* renamed from: e, reason: collision with root package name */
    protected Context f246078e;

    /* renamed from: f, reason: collision with root package name */
    public ServiceWebview f246079f;

    /* renamed from: g, reason: collision with root package name */
    private float f246080g;

    /* renamed from: h, reason: collision with root package name */
    private SparseArray f246081h;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class InfoView extends LinearLayout {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        TextView f246082a;

        public InfoView(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MapContext.this, (Object) context);
                return;
            }
            TextView textView = new TextView(context);
            this.f246082a = textView;
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f246082a.setTextColor(-16777216);
            this.f246082a.setTextSize(12.0f);
            setOrientation(1);
            setBackgroundColor(-1);
            addView(this.f246082a);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00a4  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00c1  */
        /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00aa  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(String str, String str2, float f16, float f17, String str3, int i3, String str4, String str5) {
            float f18;
            int parseColor;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, Float.valueOf(f16), Float.valueOf(f17), str3, Integer.valueOf(i3), str4, str5);
                return;
            }
            this.f246082a.setText(str);
            if (!TextUtils.isEmpty(str2)) {
                try {
                    this.f246082a.setTextColor(Color.parseColor(str2));
                } catch (IllegalArgumentException unused) {
                }
            }
            if (f16 > 0.0f) {
                this.f246082a.setTextSize(f16);
            }
            if (f17 < 1.0f) {
                f18 = 2.0f;
            } else {
                f18 = f17;
            }
            int i16 = (int) ((MapContext.this.f246080g * f18) + 0.5f);
            if (!TextUtils.isEmpty(str3)) {
                try {
                    parseColor = Color.parseColor(str3);
                } catch (IllegalArgumentException unused2) {
                }
                this.f246082a.setBackground(new e(parseColor, Paint.Style.FILL, 0.0f, 255, i16));
                if (i3 > 0) {
                    this.f246082a.setPadding(i3, i3, i3, i3);
                }
                if (!"left".equals(str5)) {
                    this.f246082a.setGravity(3);
                } else if ("right".equals(str5)) {
                    this.f246082a.setGravity(5);
                }
                if (!"center".equals(str5)) {
                    this.f246082a.setGravity(17);
                    return;
                }
                return;
            }
            parseColor = -1;
            this.f246082a.setBackground(new e(parseColor, Paint.Style.FILL, 0.0f, 255, i16));
            if (i3 > 0) {
            }
            if (!"left".equals(str5)) {
            }
            if (!"center".equals(str5)) {
            }
        }
    }

    public MapContext(PageWebview pageWebview, ServiceWebview serviceWebview, QQMapView qQMapView, int i3, com.tencent.mobileqq.microapp.a.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, pageWebview, serviceWebview, qQMapView, Integer.valueOf(i3), cVar);
            return;
        }
        this.f246074a = pageWebview;
        this.f246079f = serviceWebview;
        this.f246076c = qQMapView;
        this.f246075b = qQMapView.getMap();
        this.f246077d = i3;
        this.f246078e = qQMapView.getContext();
        this.f246075b.setInfoWindowAdapter(this);
        this.f246075b.setOnMarkerClickListener(this);
        this.f246075b.setOnInfoWindowClickListener(this);
        this.f246075b.setOnMapClickListener(this);
        this.f246075b.setOnMapLoadedListener(this);
        this.f246075b.setOnMapCameraChangeListener(this);
        this.f246081h = new SparseArray();
        this.f246080g = this.f246078e.getResources().getDisplayMetrics().density;
        try {
            BitmapFactory.decodeResource(qQMapView.getResources(), R.drawable.c);
        } catch (OutOfMemoryError unused) {
        }
    }

    public View getInfoWindow(Marker marker) {
        JSONObject optJSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) marker);
        }
        Object tag = marker.getTag();
        if (!(tag instanceof JSONObject) || (optJSONObject = ((JSONObject) tag).optJSONObject("callout")) == null) {
            return null;
        }
        String optString = optJSONObject.optString("content", "");
        String optString2 = optJSONObject.optString("color", "");
        float optDouble = (float) optJSONObject.optDouble("fontSize", 0.0d);
        float optDouble2 = (float) optJSONObject.optDouble(NodeProps.BORDER_RADIUS, 0.0d);
        String optString3 = optJSONObject.optString("bgColor", "");
        int optInt = (int) (optJSONObject.optInt("padding", 0) * this.f246080g);
        String optString4 = optJSONObject.optString("display", "");
        String optString5 = optJSONObject.optString("textAlign", "");
        InfoView infoView = new InfoView(this.f246078e);
        infoView.a(optString, optString2, optDouble, optDouble2, optString3, optInt, optString4, optString5);
        return infoView;
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) cameraPosition);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mapId", this.f246077d);
            jSONObject.put("type", "begin");
            this.f246079f.evaluteJs("WeixinJSBridge.subscribeHandler(\"onMapRegionChange\", " + jSONObject + ", " + this.f246074a.pageWebviewId + ")");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void onCameraChangeFinish(CameraPosition cameraPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) cameraPosition);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mapId", this.f246077d);
            jSONObject.put("type", "end");
            this.f246079f.evaluteJs("WeixinJSBridge.subscribeHandler(\"onMapRegionChange\", " + jSONObject + ", " + this.f246074a.pageWebviewId + ")");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void onInfoWindowClick(Marker marker) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) marker);
            return;
        }
        try {
            String optString = ((JSONObject) marker.getTag()).optString("data");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", optString);
            this.f246079f.evaluteJs("WeixinJSBridge.subscribeHandler(\"onMapCalloutClick\", " + jSONObject + ", " + this.f246074a.pageWebviewId + ")");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void onInfoWindowDettached(Marker marker, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) marker, (Object) view);
        }
    }

    public void onMapClick(LatLng latLng) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) latLng);
            return;
        }
        int size = this.f246081h.size();
        for (int i3 = 0; i3 < size; i3++) {
            Marker marker = (Marker) this.f246081h.valueAt(i3);
            if (marker != null && marker.isInfoWindowShown()) {
                marker.hideInfoWindow();
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mapId", this.f246077d);
            this.f246079f.evaluteJs("WeixinJSBridge.subscribeHandler(\"onMapClick\", " + jSONObject + ", " + this.f246074a.pageWebviewId + ")");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void onMapLoaded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            a("onMapUpdated", new JSONObject());
        }
    }

    public boolean onMarkerClick(Marker marker) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) marker)).booleanValue();
        }
        if (marker == null) {
            return false;
        }
        try {
            if (!marker.isInfoWindowShown()) {
                marker.showInfoWindow();
            }
            String optString = ((JSONObject) marker.getTag()).optString("data");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", optString);
            this.f246079f.evaluteJs("WeixinJSBridge.subscribeHandler(\"onMapMarkerClick\", " + jSONObject + ", " + this.f246074a.pageWebviewId + ")");
            return true;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return true;
        }
    }

    private void a(String str, JSONObject jSONObject) {
        String str2 = "WeixinJSBridge.subscribeHandler(\"" + str + "\", " + jSONObject + "," + this.f246074a.pageWebviewId + ")";
        if (QLog.isColorLevel()) {
            QLog.d("MapContext", 2, "callbackJs jsStr=" + str2);
        }
        this.f246074a.evaluteJs(str2);
    }
}
