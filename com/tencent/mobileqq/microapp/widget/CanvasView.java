package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class CanvasView extends View {

    /* renamed from: c, reason: collision with root package name */
    private static final String f246046c = "CanvasView";

    /* renamed from: a, reason: collision with root package name */
    public boolean f246047a;

    /* renamed from: b, reason: collision with root package name */
    public JSONArray f246048b;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList f246049d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f246050e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f246051f;

    /* renamed from: g, reason: collision with root package name */
    private Paint f246052g;

    /* renamed from: h, reason: collision with root package name */
    private PorterDuff.Mode f246053h;

    /* renamed from: i, reason: collision with root package name */
    private Path f246054i;

    /* renamed from: j, reason: collision with root package name */
    private int f246055j;

    /* renamed from: k, reason: collision with root package name */
    private float f246056k;

    /* renamed from: l, reason: collision with root package name */
    private JSONObject f246057l;

    /* renamed from: m, reason: collision with root package name */
    private WebviewContainer f246058m;

    /* renamed from: n, reason: collision with root package name */
    private com.tencent.mobileqq.microapp.a.c f246059n;

    /* renamed from: o, reason: collision with root package name */
    private JSONArray f246060o;

    /* renamed from: p, reason: collision with root package name */
    private float f246061p;

    /* renamed from: q, reason: collision with root package name */
    private String f246062q;

    /* renamed from: r, reason: collision with root package name */
    private a f246063r;

    /* renamed from: s, reason: collision with root package name */
    private Paint.Cap f246064s;

    /* renamed from: t, reason: collision with root package name */
    private Paint.Join f246065t;

    /* renamed from: u, reason: collision with root package name */
    private float f246066u;

    /* renamed from: v, reason: collision with root package name */
    private int f246067v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public float f246068a;

        /* renamed from: b, reason: collision with root package name */
        public float f246069b;

        /* renamed from: c, reason: collision with root package name */
        public float f246070c;

        /* renamed from: d, reason: collision with root package name */
        public int f246071d;

        a(CanvasView canvasView) {
        }

        /* synthetic */ a(CanvasView canvasView, com.tencent.mobileqq.microapp.widget.a aVar) {
            this(canvasView);
        }
    }

    public CanvasView(Context context, WebviewContainer webviewContainer, com.tencent.mobileqq.microapp.a.c cVar, String str, int i3, boolean z16) {
        super(context);
        this.f246049d = new ArrayList();
        this.f246055j = -1;
        this.f246056k = DisplayUtil.getDensity(context);
        this.f246058m = webviewContainer;
        this.f246059n = cVar;
        Paint paint = new Paint(1);
        this.f246050e = paint;
        this.f246049d.add(paint);
        Paint paint2 = new Paint(1);
        this.f246051f = paint2;
        this.f246049d.add(paint2);
        Paint paint3 = new Paint(1);
        this.f246052g = paint3;
        this.f246049d.add(paint3);
        this.f246062q = str;
        setLayerType(z16 ? 2 : 1, null);
        setBackgroundColor(getContext().getResources().getColor(17170445));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (QLog.isColorLevel()) {
            QLog.w(f246046c, 2, "---onDraw---");
        }
        a(canvas, this.f246047a, true, this.f246048b);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i3;
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d(f246046c, 2, "--ACTION_UP--" + this.f246067v);
                }
                this.f246067v = 1;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(HippyTKDListViewAdapter.X, motionEvent.getX() / this.f246056k);
                    jSONObject.put("y", motionEvent.getY() / this.f246056k);
                    jSONObject.put("id", 0);
                    JSONObject jSONObject2 = new JSONObject();
                    this.f246057l = jSONObject2;
                    jSONObject2.put("data", this.f246062q);
                    this.f246057l.put(WebRTCSDK.PRIVILEGE_TOUCH, jSONObject);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                this.f246058m.appBrandRuntime.f245904i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onTouchEnd\", " + this.f246057l + "," + this.f246058m.getPageWebview().pageWebviewId + ")");
            } else if (action == 2) {
                if (QLog.isColorLevel()) {
                    QLog.d(f246046c, 2, "--ACTION_MOVE--");
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f246046c, 2, "action move mMode: " + this.f246067v);
                }
                if (this.f246067v < 2) {
                    try {
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(HippyTKDListViewAdapter.X, motionEvent.getX() / this.f246056k);
                        jSONObject3.put("y", motionEvent.getY() / this.f246056k);
                        jSONObject3.put("id", 0);
                        jSONArray.mo162put(jSONObject3);
                        JSONObject jSONObject4 = new JSONObject();
                        this.f246057l = jSONObject4;
                        jSONObject4.put("data", this.f246062q);
                        this.f246057l.put("touches", jSONArray);
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(f246046c, 2, "--\u5355\u6307\u6ed1\u52a8--");
                    }
                } else {
                    try {
                        JSONArray jSONArray2 = new JSONArray();
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put(HippyTKDListViewAdapter.X, motionEvent.getX(0) / this.f246056k);
                        jSONObject5.put("y", motionEvent.getY(0) / this.f246056k);
                        jSONObject5.put("id", 0);
                        jSONArray2.mo162put(jSONObject5);
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put(HippyTKDListViewAdapter.X, motionEvent.getX(1) / this.f246056k);
                        jSONObject6.put("y", motionEvent.getY(1) / this.f246056k);
                        jSONObject6.put("id", 1);
                        jSONArray2.mo162put(jSONObject6);
                        JSONObject jSONObject7 = new JSONObject();
                        this.f246057l = jSONObject7;
                        jSONObject7.put("data", this.f246062q);
                        this.f246057l.put("touches", jSONArray2);
                        if (QLog.isColorLevel()) {
                            QLog.i(f246046c, 2, "--\u53cc\u6307\u7f29\u653e--" + this.f246057l);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(f246046c, 2, this.f246057l);
                        }
                    } catch (JSONException e18) {
                        e18.printStackTrace();
                    }
                }
                this.f246058m.appBrandRuntime.f245904i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onTouchMove\", " + this.f246057l + "," + this.f246058m.getPageWebview().pageWebviewId + ")");
            } else {
                if (action != 3) {
                    if (action != 5) {
                        i3 = action == 6 ? 1 : 1;
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.e(f246046c, 2, "--ACTION_POINTER_DOWN--");
                        }
                        this.f246067v++;
                        try {
                            JSONObject jSONObject8 = new JSONObject();
                            jSONObject8.put(HippyTKDListViewAdapter.X, motionEvent.getX(1) / this.f246056k);
                            jSONObject8.put("y", motionEvent.getY(1) / this.f246056k);
                            jSONObject8.put("id", 1);
                            JSONObject jSONObject9 = new JSONObject();
                            this.f246057l = jSONObject9;
                            jSONObject9.put("data", this.f246062q);
                            this.f246057l.put(WebRTCSDK.PRIVILEGE_TOUCH, jSONObject8);
                        } catch (JSONException e19) {
                            e19.printStackTrace();
                        }
                        this.f246058m.appBrandRuntime.f245904i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onTouchStart\", " + this.f246057l + "," + this.f246058m.getPageWebview().pageWebviewId + ")");
                    }
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f246046c, 2, "--ACTION_CANCEL--");
                }
                JSONArray jSONArray3 = new JSONArray();
                this.f246067v = 1;
                try {
                    JSONObject jSONObject10 = new JSONObject();
                    jSONObject10.put(HippyTKDListViewAdapter.X, motionEvent.getX() / this.f246056k);
                    jSONObject10.put("y", motionEvent.getY() / this.f246056k);
                    jSONObject10.put("id", 0);
                    jSONArray3.mo162put(jSONObject10);
                    JSONObject jSONObject11 = new JSONObject();
                    this.f246057l = jSONObject11;
                    jSONObject11.put("data", this.f246062q);
                    this.f246057l.put("touches", jSONArray3);
                } catch (JSONException e26) {
                    e26.printStackTrace();
                }
                this.f246058m.appBrandRuntime.f245904i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onTouchCancel\", " + this.f246057l + "," + this.f246058m.getPageWebview().pageWebviewId + ")");
            }
            this.f246067v = i3;
            try {
                int action2 = (motionEvent.getAction() & 65280) >> 8;
                JSONObject jSONObject12 = new JSONObject();
                jSONObject12.put(HippyTKDListViewAdapter.X, motionEvent.getX(action2) / this.f246056k);
                jSONObject12.put("y", motionEvent.getY(action2) / this.f246056k);
                jSONObject12.put("id", 1);
                JSONObject jSONObject13 = new JSONObject();
                this.f246057l = jSONObject13;
                jSONObject13.put("data", this.f246062q);
                this.f246057l.put(WebRTCSDK.PRIVILEGE_TOUCH, jSONObject12);
            } catch (Exception e27) {
                e27.printStackTrace();
            }
            this.f246058m.appBrandRuntime.f245904i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onTouchEnd\", " + this.f246057l + "," + this.f246058m.getPageWebview().pageWebviewId + ")");
        } else {
            if (QLog.isColorLevel()) {
                QLog.e(f246046c, 2, "--ACTION_DOWN--");
            }
            this.f246067v = 1;
            try {
                JSONObject jSONObject14 = new JSONObject();
                jSONObject14.put(HippyTKDListViewAdapter.X, motionEvent.getX() / this.f246056k);
                jSONObject14.put("y", motionEvent.getY() / this.f246056k);
                jSONObject14.put("id", 0);
                JSONObject jSONObject15 = new JSONObject();
                this.f246057l = jSONObject15;
                jSONObject15.put("data", this.f246062q);
                this.f246057l.put(WebRTCSDK.PRIVILEGE_TOUCH, jSONObject14);
            } catch (JSONException e28) {
                e28.printStackTrace();
            }
            this.f246058m.appBrandRuntime.f245904i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onTouchStart\", " + this.f246057l + "," + this.f246058m.getPageWebview().pageWebviewId + ")");
        }
        return true;
    }

    public float a(JSONObject jSONObject) {
        if (this.f246052g == null) {
            return -1.0f;
        }
        String optString = jSONObject.optString("fontFamily");
        if ("normal".equals(jSONObject.optString("fontStyle"))) {
            this.f246052g.setTypeface(Typeface.create(optString, 0));
        }
        String optString2 = jSONObject.optString("text");
        this.f246052g.setTextSize(jSONObject.optInt("fontSize"));
        return this.f246052g.measureText(optString2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(View view) {
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache(true);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache);
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public void a(WebviewContainer webviewContainer, Context context, JSONObject jSONObject, String str, int i3) throws IOException {
        ThreadManagerV2.executeOnSubThread(new com.tencent.mobileqq.microapp.widget.a(this, jSONObject, webviewContainer, str, i3));
    }

    private void a(Canvas canvas, boolean z16, boolean z17, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0 || canvas == null) {
            return;
        }
        if (z16) {
            try {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            } catch (Throwable th5) {
                th5.printStackTrace();
                return;
            }
        }
        JSONArray jSONArray2 = new JSONArray();
        this.f246060o = jSONArray2;
        this.f246060o = com.tencent.mobileqq.microapp.a.c.a(jSONArray2, jSONArray);
        a(canvas, jSONArray, this.f246059n);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Canvas canvas, JSONArray jSONArray, com.tencent.mobileqq.microapp.a.c cVar) throws Exception {
        int i3;
        Canvas canvas2;
        int i16;
        Paint paint;
        Canvas canvas3;
        String str;
        int i17;
        int i18;
        int i19;
        Bitmap q16;
        Canvas canvas4 = canvas;
        JSONArray jSONArray2 = jSONArray;
        if (jSONArray2 == null) {
            return;
        }
        int i26 = 0;
        int i27 = 0;
        while (i27 < jSONArray.length()) {
            JSONObject jSONObject = jSONArray2.getJSONObject(i27);
            String optString = jSONObject.optString("method");
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            int i28 = 2;
            if (QLog.isColorLevel()) {
                QLog.d("drawCanvas", 2, "method: " + optString + "---" + optJSONArray);
            }
            com.tencent.mobileqq.microapp.widget.a aVar = null;
            int i29 = 1;
            if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_DRAWIMAGE.equals(optString)) {
                String optString2 = optJSONArray.optString(i26);
                if (!StringUtil.isEmpty(optString2)) {
                    if (optString2.startsWith("wxfile")) {
                        optString2 = com.tencent.mobileqq.microapp.appbrand.b.b.a().c(optString2);
                    } else {
                        optString2 = cVar.j(optString2);
                        if (QLog.isColorLevel()) {
                            QLog.i("drawCanvas", 2, "dataPath: " + optString2);
                        }
                        if (!StringUtil.isEmpty(optString2) || (q16 = com.tencent.mobileqq.microapp.a.c.q(optString2)) == null) {
                            i3 = i27;
                        } else {
                            RectF rectF = new RectF();
                            rectF.left = (float) ((this.f246056k * optJSONArray.optDouble(1)) + 0.5d);
                            rectF.top = (float) ((this.f246056k * optJSONArray.optDouble(2)) + 0.5d);
                            i3 = i27;
                            rectF.right = rectF.left + ((float) ((this.f246056k * optJSONArray.optDouble(3, q16.getWidth())) + 0.5d));
                            rectF.bottom = rectF.top + ((float) ((this.f246056k * optJSONArray.optDouble(4, q16.getHeight())) + 0.5d));
                            canvas4.drawBitmap(q16, (Rect) null, rectF, (Paint) null);
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                }
                if (StringUtil.isEmpty(optString2)) {
                }
                i3 = i27;
            } else {
                i3 = i27;
                if (!com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_SET_STROKESTYLE.equals(optString) && !com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_SET_FILLSTYLE.equals(optString)) {
                    boolean equals = com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_STROKEPATH.equals(optString);
                    String str2 = com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_TRANSLATE;
                    if (!equals && !com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_FILLPATH.equals(optString)) {
                        if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_SET_FONT_SIZE.equals(optString)) {
                            this.f246052g.setTextSize((float) ((this.f246056k * optJSONArray.optDouble(0)) + 0.5d));
                            canvas2 = canvas4;
                            i16 = 0;
                        } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_SET_TEXTALIGN.equals(optString)) {
                            String optString3 = optJSONArray.optString(0);
                            this.f246052g.setTextAlign("left".equals(optString3) ? Paint.Align.LEFT : "center".equals(optString3) ? Paint.Align.CENTER : Paint.Align.RIGHT);
                        } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_FILLTEXT.equals(optString)) {
                            canvas4.drawText(optJSONArray.optString(0), (float) ((this.f246056k * optJSONArray.optDouble(1)) + 0.5d), (float) ((this.f246056k * optJSONArray.optDouble(2)) + 0.5d), this.f246052g);
                        } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_SET_GLOBALALPHA.equals(optString)) {
                            this.f246055j = optJSONArray.optInt(0);
                        } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_RESTORE.equals(optString)) {
                            Iterator it = this.f246049d.iterator();
                            while (it.hasNext()) {
                                Paint paint2 = (Paint) it.next();
                                paint2.reset();
                                paint2.setColor(-16777216);
                            }
                            canvas.restore();
                        } else if ("save".equals(optString)) {
                            canvas.save();
                        } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_STROKETEXT.equals(optString)) {
                            this.f246052g.setStyle(Paint.Style.STROKE);
                            canvas4.drawText(optJSONArray.optString(0), (float) ((this.f246056k * optJSONArray.optDouble(1)) + 0.5d), (float) ((this.f246056k * optJSONArray.optDouble(2)) + 0.5d), this.f246052g);
                        } else {
                            if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_CLRAERECT.equals(optString)) {
                                canvas.save();
                                RectF rectF2 = new RectF();
                                rectF2.left = (float) ((this.f246056k * optJSONArray.optDouble(0)) + 0.5d);
                                rectF2.top = (float) ((this.f246056k * optJSONArray.optDouble(1)) + 0.5d);
                                rectF2.right = rectF2.left + ((float) ((this.f246056k * optJSONArray.optDouble(2)) + 0.5d));
                                rectF2.bottom = rectF2.top + ((float) ((this.f246056k * optJSONArray.optDouble(3)) + 0.5d));
                                canvas4.clipRect(rectF2);
                                i19 = 0;
                                canvas4.drawColor(0, PorterDuff.Mode.CLEAR);
                                canvas.restore();
                            } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_SETGLOBALCOMPOSITEOPERATION.equals(optString)) {
                                String optString4 = optJSONArray.optString(0);
                                if ("xor".equals(optString4)) {
                                    this.f246053h = PorterDuff.Mode.XOR;
                                } else if ("source-atop".equals(optString4)) {
                                    this.f246053h = PorterDuff.Mode.SRC_ATOP;
                                } else if ("destination-out".equals(optString4)) {
                                    this.f246053h = PorterDuff.Mode.DST_OUT;
                                } else if (!PTSNodeTextBase.WEIGHT_LIGHTER.equals(optString4) && !"lighten".equals(optString4) && !"hard-light".equals(optString4)) {
                                    if ("overlay".equals(optString4)) {
                                        this.f246053h = PorterDuff.Mode.OVERLAY;
                                    } else if ("darken".equals(optString4)) {
                                        this.f246053h = PorterDuff.Mode.DARKEN;
                                    }
                                } else {
                                    this.f246053h = PorterDuff.Mode.LIGHTEN;
                                }
                            } else {
                                if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_ROTATE.equals(optString)) {
                                    i18 = 0;
                                    canvas4.rotate((float) ((optJSONArray.optDouble(0) * 180.0d) / 3.141592653589793d));
                                } else {
                                    i18 = 0;
                                    if ("scale".equals(optString)) {
                                        canvas4.scale((float) optJSONArray.optDouble(0), (float) optJSONArray.optDouble(1));
                                    } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_SET_LINEWIDTH.equals(optString)) {
                                        this.f246061p = (float) ((this.f246056k * optJSONArray.optDouble(0)) + 0.5d);
                                    } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_SET_SHADOW.equals(optString)) {
                                        this.f246063r = new a(this, aVar);
                                        JSONArray optJSONArray2 = optJSONArray.optJSONArray(3);
                                        float optDouble = (float) ((this.f246056k * optJSONArray.optDouble(0)) + 0.5d);
                                        float optDouble2 = (float) ((this.f246056k * optJSONArray.optDouble(1)) + 0.5d);
                                        float optDouble3 = (float) ((this.f246056k * optJSONArray.optDouble(2)) + 0.5d);
                                        a aVar2 = this.f246063r;
                                        aVar2.f246068a = optDouble;
                                        aVar2.f246069b = optDouble2;
                                        aVar2.f246070c = optDouble3;
                                        i16 = 0;
                                        aVar2.f246071d = Color.argb(optJSONArray2.optInt(3), optJSONArray2.optInt(2), optJSONArray2.optInt(1), optJSONArray2.optInt(0));
                                        canvas2 = canvas4;
                                    } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_SET_LINECAP.equals(optString)) {
                                        String optString5 = optJSONArray.optString(0);
                                        if ("butt".equals(optString5)) {
                                            this.f246064s = Paint.Cap.BUTT;
                                        } else if ("round".equals(optString5)) {
                                            this.f246064s = Paint.Cap.ROUND;
                                        } else if ("square".equals(optString5)) {
                                            this.f246064s = Paint.Cap.SQUARE;
                                        }
                                    } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_SET_LINEJOIN.equals(optString)) {
                                        String optString6 = optJSONArray.optString(0);
                                        if ("bevel".equals(optString6)) {
                                            this.f246065t = Paint.Join.BEVEL;
                                        } else if ("round".equals(optString6)) {
                                            this.f246065t = Paint.Join.ROUND;
                                        } else if ("miter".equals(optString6)) {
                                            this.f246065t = Paint.Join.MITER;
                                        }
                                    } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_SET_MITERLIMIT.equals(optString)) {
                                        i19 = 0;
                                        this.f246066u = (float) ((this.f246056k * optJSONArray.optDouble(0)) + 0.5d);
                                    } else {
                                        i19 = 0;
                                        if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_TRANSLATE.equals(optString)) {
                                            canvas4.translate((float) ((this.f246056k * optJSONArray.optDouble(0)) + 0.5d), (float) ((this.f246056k * optJSONArray.optDouble(1)) + 0.5d));
                                        }
                                    }
                                }
                                i16 = i18;
                                canvas2 = canvas4;
                            }
                            i16 = i19;
                            canvas2 = canvas4;
                        }
                    } else {
                        this.f246054i = new Path();
                        if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_STROKEPATH.equals(optString)) {
                            a aVar3 = this.f246063r;
                            if (aVar3 != null) {
                                this.f246051f.setShadowLayer(aVar3.f246068a, aVar3.f246069b, aVar3.f246070c, aVar3.f246071d);
                                this.f246063r = null;
                            }
                            this.f246051f.setStyle(Paint.Style.STROKE);
                            paint = this.f246051f;
                        } else {
                            a aVar4 = this.f246063r;
                            if (aVar4 != null) {
                                this.f246050e.setShadowLayer(aVar4.f246068a, aVar4.f246069b, aVar4.f246070c, aVar4.f246071d);
                                this.f246063r = null;
                            }
                            this.f246050e.setStyle(Paint.Style.FILL);
                            paint = this.f246050e;
                        }
                        Paint paint3 = paint;
                        if (this.f246053h != null) {
                            paint3.setXfermode(new PorterDuffXfermode(this.f246053h));
                            this.f246053h = null;
                        }
                        float f16 = this.f246061p;
                        if (f16 != 0.0f) {
                            paint3.setStrokeWidth(f16);
                            this.f246061p = 0.0f;
                        }
                        int i36 = this.f246055j;
                        if (i36 != -1) {
                            paint3.setAlpha(i36);
                            this.f246055j = -1;
                        }
                        Paint.Cap cap = this.f246064s;
                        if (cap != null) {
                            paint3.setStrokeCap(cap);
                            this.f246064s = null;
                        }
                        Paint.Join join = this.f246065t;
                        if (join != null) {
                            paint3.setStrokeJoin(join);
                            this.f246065t = null;
                        }
                        float f17 = this.f246066u;
                        if (f17 != 0.0f) {
                            paint3.setStrokeMiter(f17);
                            this.f246066u = 0.0f;
                        }
                        int i37 = 0;
                        while (i37 < optJSONArray.length()) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i37);
                            if (optJSONObject != null) {
                                String optString7 = optJSONObject.optString("method");
                                JSONArray optJSONArray3 = optJSONObject.optJSONArray("data");
                                if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_RECT.equals(optString7)) {
                                    RectF rectF3 = new RectF();
                                    rectF3.left = (float) ((this.f246056k * optJSONArray3.optDouble(0)) + 0.5d);
                                    rectF3.top = (float) ((this.f246056k * optJSONArray3.optDouble(i29)) + 0.5d);
                                    rectF3.right = rectF3.left + ((float) ((this.f246056k * optJSONArray3.optDouble(i28)) + 0.5d));
                                    rectF3.bottom = rectF3.top + ((float) ((this.f246056k * optJSONArray3.optDouble(3)) + 0.5d));
                                    canvas4.drawRect(rectF3, paint3);
                                } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_MOVETO.equals(optString7)) {
                                    this.f246054i.moveTo((float) ((this.f246056k * optJSONArray3.optDouble(0)) + 0.5d), (float) ((this.f246056k * optJSONArray3.optDouble(1)) + 0.5d));
                                    canvas4.drawPath(this.f246054i, paint3);
                                } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_LINETO.equals(optString7)) {
                                    this.f246054i.lineTo((float) ((this.f246056k * optJSONArray3.optDouble(0)) + 0.5d), (float) ((this.f246056k * optJSONArray3.optDouble(1)) + 0.5d));
                                    canvas4.drawPath(this.f246054i, paint3);
                                } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_CLOSEPATH.equals(optString7)) {
                                    Path path = this.f246054i;
                                    if (path != null) {
                                        path.close();
                                    }
                                } else {
                                    if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_ARC.equals(optString7)) {
                                        float optDouble4 = (float) ((this.f246056k * optJSONArray3.optDouble(0)) + 0.5d);
                                        float optDouble5 = (float) ((this.f246056k * optJSONArray3.optDouble(1)) + 0.5d);
                                        float optDouble6 = (float) ((this.f246056k * optJSONArray3.optDouble(i28)) + 0.5d);
                                        i17 = i37;
                                        float optDouble7 = (float) optJSONArray3.optDouble(3);
                                        float optDouble8 = (float) ((((float) optJSONArray3.optDouble(4)) / 3.141592653589793d) * 180.0d);
                                        if (optJSONArray.optBoolean(5)) {
                                            optDouble8 = -optDouble8;
                                        }
                                        canvas.drawArc(new RectF(optDouble4 - optDouble6, optDouble5 - optDouble6, optDouble4 + optDouble6, optDouble5 + optDouble6), optDouble7, optDouble8, false, paint3);
                                        canvas3 = canvas;
                                    } else {
                                        i17 = i37;
                                        if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_QUADRATIC_CURVETO.equals(optString7)) {
                                            this.f246054i.quadTo((float) ((this.f246056k * optJSONArray3.optDouble(0)) + 0.5d), (float) ((this.f246056k * optJSONArray3.optDouble(1)) + 0.5d), (float) ((this.f246056k * optJSONArray3.optDouble(2)) + 0.5d), (float) ((this.f246056k * optJSONArray3.optDouble(3)) + 0.5d));
                                            canvas3 = canvas;
                                            canvas3.drawPath(this.f246054i, paint3);
                                        } else {
                                            canvas3 = canvas;
                                            if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_QBEZIER_CURVETO.equals(optString7)) {
                                                this.f246054i.cubicTo((float) ((this.f246056k * optJSONArray3.optDouble(0)) + 0.5d), (float) ((this.f246056k * optJSONArray3.optDouble(1)) + 0.5d), (float) ((this.f246056k * optJSONArray3.optDouble(2)) + 0.5d), (float) ((this.f246056k * optJSONArray3.optDouble(3)) + 0.5d), (float) ((this.f246056k * optJSONArray3.optDouble(4)) + 0.5d), (float) ((this.f246056k * optJSONArray3.optDouble(5)) + 0.5d));
                                                canvas3.drawPath(this.f246054i, paint3);
                                                str = str2;
                                            } else {
                                                str = str2;
                                                if (str.equals(optString7)) {
                                                    canvas3.translate((float) ((this.f246056k * optJSONArray3.optDouble(0)) + 0.5d), (float) ((this.f246056k * optJSONArray3.optDouble(1)) + 0.5d));
                                                }
                                            }
                                            i37 = i17 + 1;
                                            canvas4 = canvas3;
                                            str2 = str;
                                            i29 = 1;
                                            i28 = 2;
                                        }
                                    }
                                    str = str2;
                                    i37 = i17 + 1;
                                    canvas4 = canvas3;
                                    str2 = str;
                                    i29 = 1;
                                    i28 = 2;
                                }
                            }
                            canvas3 = canvas4;
                            str = str2;
                            i17 = i37;
                            i37 = i17 + 1;
                            canvas4 = canvas3;
                            str2 = str;
                            i29 = 1;
                            i28 = 2;
                        }
                    }
                } else {
                    canvas2 = canvas4;
                    String optString8 = optJSONArray.optString(0);
                    if ("normal".equals(optString8)) {
                        String a16 = a(optJSONArray.optJSONArray(1), 0);
                        if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_SET_STROKESTYLE.equals(optString)) {
                            this.f246051f.setColor(Color.parseColor(a16));
                        } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_SET_FILLSTYLE.equals(optString)) {
                            this.f246050e.setColor(Color.parseColor(a16));
                        }
                    } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_RADIAL.equals(optString8)) {
                        JSONArray optJSONArray4 = optJSONArray.optJSONArray(1);
                        JSONArray optJSONArray5 = optJSONArray.optJSONArray(2);
                        RadialGradient radialGradient = new RadialGradient((float) ((this.f246056k * optJSONArray4.optDouble(0)) + 0.5d), (float) ((this.f246056k * optJSONArray4.optDouble(1)) + 0.5d), (float) ((this.f246056k * optJSONArray4.optDouble(2)) + 0.5d), Color.parseColor(a(optJSONArray5.optJSONArray(0).optJSONArray(1), 0)), Color.parseColor(a(optJSONArray5.optJSONArray(1).optJSONArray(1), 0)), Shader.TileMode.CLAMP);
                        if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_SET_STROKESTYLE.equals(optString)) {
                            this.f246051f.setShader(radialGradient);
                        } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_SET_FILLSTYLE.equals(optString)) {
                            this.f246050e.setShader(radialGradient);
                        }
                    } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_LINER.equals(optString8)) {
                        JSONArray optJSONArray6 = optJSONArray.optJSONArray(1);
                        JSONArray optJSONArray7 = optJSONArray.optJSONArray(2);
                        i16 = 0;
                        LinearGradient linearGradient = new LinearGradient((float) ((this.f246056k * optJSONArray6.optDouble(0)) + 0.5d), (float) ((this.f246056k * optJSONArray6.optDouble(1)) + 0.5d), (float) ((this.f246056k * optJSONArray6.optDouble(2)) + 0.5d), (float) ((this.f246056k * optJSONArray6.optDouble(3)) + 0.5d), Color.parseColor(a(optJSONArray7.optJSONArray(0).optJSONArray(1), 0)), Color.parseColor(a(optJSONArray7.optJSONArray(1).optJSONArray(1), 0)), Shader.TileMode.CLAMP);
                        if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_SET_STROKESTYLE.equals(optString)) {
                            this.f246051f.setShader(linearGradient);
                        } else if (com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_SET_FILLSTYLE.equals(optString)) {
                            this.f246050e.setShader(linearGradient);
                        }
                    }
                    i16 = 0;
                }
                i27 = i3 + 1;
                jSONArray2 = jSONArray;
                canvas4 = canvas2;
                i26 = i16;
            }
            canvas2 = canvas4;
            i16 = 0;
            i27 = i3 + 1;
            jSONArray2 = jSONArray;
            canvas4 = canvas2;
            i26 = i16;
        }
    }

    private String a(JSONArray jSONArray, int i3) {
        StringBuilder sb5 = new StringBuilder("#");
        sb5.append(String.format("%02X", Integer.valueOf(jSONArray.optInt(jSONArray.length() - 1))));
        while (i3 < jSONArray.length() - 1) {
            sb5.append(String.format("%02X", Integer.valueOf(jSONArray.optInt(i3))));
            i3++;
        }
        return sb5.toString();
    }
}
