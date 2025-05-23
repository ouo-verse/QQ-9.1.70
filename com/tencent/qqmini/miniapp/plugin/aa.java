package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.DrawFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.qqmini.container.core.MiniWebView;
import com.tencent.qqmini.container.core.ax;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.sdk.action.ServiceEvaluateCallbackAction;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class aa implements IExtendedEmbeddedWidgetClient {
    private int C;
    private final IMiniAppContext D;
    private Path E;
    private float F;
    private float G;
    private String H;
    private Paint I;
    private Paint J;
    private Paint T;
    private Paint U;
    private int V;
    private int W;
    private int X;
    private String Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f346254a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f346255b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f346256c0;

    /* renamed from: d, reason: collision with root package name */
    private IJsService f346257d;

    /* renamed from: d0, reason: collision with root package name */
    private JSONArray f346258d0;

    /* renamed from: e, reason: collision with root package name */
    private Surface f346259e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f346260e0;

    /* renamed from: f0, reason: collision with root package name */
    private final HandlerThread f346262f0;

    /* renamed from: g0, reason: collision with root package name */
    private final Handler f346263g0;

    /* renamed from: h0, reason: collision with root package name */
    private final float f346265h0;

    /* renamed from: i, reason: collision with root package name */
    private Rect f346266i;

    /* renamed from: i0, reason: collision with root package name */
    private final ApkgInfo f346267i0;

    /* renamed from: f, reason: collision with root package name */
    private int f346261f = -1;

    /* renamed from: h, reason: collision with root package name */
    private int f346264h = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f346270m = -1;
    private int K = 255;
    private int L = 255;
    private int M = 255;
    private String N = "normal";
    private boolean P = false;
    private boolean Q = false;
    private int R = 0;
    private int S = 0;

    /* renamed from: j0, reason: collision with root package name */
    private final HashMap<String, a> f346268j0 = new HashMap<>();

    /* renamed from: k0, reason: collision with root package name */
    private final DrawFilter f346269k0 = new PaintFlagsDrawFilter(0, 3);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface a {
        void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface b {
        void onResult(boolean z16, JSONObject jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class c implements a {
        c() {
        }

        @Override // com.tencent.qqmini.miniapp.plugin.aa.a
        public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
            aa.this.W0(canvas, str, jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class d implements a {
        d() {
        }

        @Override // com.tencent.qqmini.miniapp.plugin.aa.a
        public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
            aa.this.d1(canvas, str, jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class e implements a {
        e() {
        }

        @Override // com.tencent.qqmini.miniapp.plugin.aa.a
        public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
            aa.this.e1(str, jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public float f346274a;

        /* renamed from: b, reason: collision with root package name */
        public float f346275b;

        /* renamed from: c, reason: collision with root package name */
        public float f346276c;

        /* renamed from: d, reason: collision with root package name */
        public int f346277d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class g implements a {
        g() {
        }

        @Override // com.tencent.qqmini.miniapp.plugin.aa.a
        public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
            aa.this.k1(canvas, str, jSONArray);
        }
    }

    public aa(IMiniAppContext iMiniAppContext, String str, Map<String, String> map, IEmbeddedWidget iEmbeddedWidget) {
        ApkgInfo apkgInfo;
        this.D = iMiniAppContext;
        this.f346265h0 = DisplayUtil.getDensity(iMiniAppContext.getContext());
        if (iMiniAppContext instanceof ax) {
            apkgInfo = ((ax) iMiniAppContext).v();
        } else {
            apkgInfo = (ApkgInfo) iMiniAppContext.getMiniAppInfo().apkgInfo;
        }
        this.f346267i0 = apkgInfo;
        Paint paint = new Paint(1);
        this.I = paint;
        paint.setStyle(Paint.Style.FILL);
        this.I.setColor(-16777216);
        Paint paint2 = new Paint(1);
        this.J = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.J.setColor(-16777216);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("embedded-canvas");
        this.f346262f0 = baseHandlerThread;
        baseHandlerThread.start();
        this.f346263g0 = new Handler(baseHandlerThread.getLooper());
        k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        this.N = jSONArray.optString(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        S0(canvas, str, jSONObject.optJSONObject("data"), jSONObject.optInt("callbackId"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        P(canvas, jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        float K0 = K0(jSONArray.optDouble(0, 0.0d));
        this.I.setTextSize(K0);
        this.J.setTextSize(K0);
    }

    private void E(float f16, float f17, float f18, float f19) {
        int i3;
        float f26;
        float f27;
        RectF rectF = new RectF();
        boolean z16 = this.P;
        if ((!z16 && !this.Q) || ((i3 = this.R) == 0 && this.S == 0)) {
            rectF.left = f16;
            rectF.top = f17;
            rectF.right = f16 + f18;
            rectF.bottom = f17 + f19;
        } else {
            if (z16) {
                f16 = 0.0f;
            }
            rectF.left = f16;
            boolean z17 = this.Q;
            if (z17) {
                f17 = 0.0f;
            }
            rectF.top = f17;
            if (z16) {
                f26 = f16 + f18;
            } else {
                f26 = i3;
            }
            rectF.right = f26;
            if (z17) {
                f27 = f17 + f19;
            } else {
                f27 = this.S;
            }
            rectF.bottom = f27;
        }
        this.E.addRect(rectF, Path.Direction.CW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        X0(jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        Y0(jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        int i3;
        int i16 = 0;
        String optString = jSONArray.optString(0);
        Typeface typeface = this.I.getTypeface();
        if (typeface != null) {
            i3 = typeface.getStyle();
        } else {
            i3 = 0;
        }
        this.I.setTypeface(Typeface.create(optString, i3));
        Typeface typeface2 = this.J.getTypeface();
        if (typeface2 != null) {
            i16 = typeface2.getStyle();
        }
        this.J.setTypeface(Typeface.create(typeface2, i16));
    }

    private void H(Canvas canvas, JSONArray jSONArray) {
        canvas.save();
        float K0 = K0(jSONArray.optDouble(0, 0.0d));
        float K02 = K0(jSONArray.optDouble(1, 0.0d));
        float K03 = K0(jSONArray.optDouble(2, 0.0d));
        float K04 = K0(jSONArray.optDouble(3, 0.0d));
        if (K03 <= 0.0f) {
            K0 += K03;
            K03 = -K03;
        }
        if (K04 <= 0.0f) {
            K02 += K04;
            K04 = -K04;
        }
        RectF rectF = new RectF();
        rectF.left = K0;
        rectF.top = K02;
        rectF.right = K0 + K03;
        rectF.bottom = K02 + K04;
        canvas.clipRect(rectF);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        i1(jSONArray);
    }

    private void I(int i3, int i16, int i17, int i18, int i19, int i26, Bitmap bitmap, JSONObject jSONObject, Bitmap bitmap2, String str, boolean z16, b bVar) throws IOException {
        FileOutputStream fileOutputStream;
        float f16;
        Canvas canvas = new Canvas(bitmap);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        Rect rect = new Rect(0, 0, i19, i26);
        int L0 = L0(jSONObject.optDouble(HippyTKDListViewAdapter.X, 0.0d));
        int L02 = L0(jSONObject.optDouble("y", 0.0d));
        Rect rect2 = new Rect(L0, L02, L0 + i3, L02 + i16);
        FileOutputStream fileOutputStream2 = null;
        canvas.drawBitmap(bitmap2, rect2, rect, (Paint) null);
        String tmpPath = ((MiniAppFileManager) getMiniAppContext().getManager(MiniAppFileManager.class)).getTmpPath(str);
        try {
            fileOutputStream = new FileOutputStream(FileUtils.createFile(tmpPath));
            f16 = (((i19 * 1.0f) * i26) / i17) / i18;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            if (z16) {
                bitmap.compress(Bitmap.CompressFormat.PNG, (int) ((jSONObject.optDouble(CustomImageProps.QUALITY, 1.0d) / f16) * 100.0d), fileOutputStream);
            } else {
                bitmap.compress(Bitmap.CompressFormat.JPEG, (int) ((jSONObject.optDouble("jpgQuality", 1.0d) / f16) * 100.0d), fileOutputStream);
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("tempFilePath", ((MiniAppFileManager) getMiniAppContext().getManager(MiniAppFileManager.class)).getWxFilePath(tmpPath));
                bVar.onResult(true, jSONObject2);
            } catch (JSONException e16) {
                e16.printStackTrace();
                bVar.onResult(false, null);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                fileOutputStream2.flush();
                fileOutputStream2.close();
            }
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        this.K = jSONArray.optInt(0, 0);
    }

    private Bitmap J(String str, float f16, float f17, int i3, int i16, int i17, int i18, BitmapFactory.Options options, int i19) {
        double sqrt;
        options.inDither = true;
        Bitmap bitmap = null;
        if (i17 > 0 && i18 > 0) {
            try {
                BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(str, false);
                bitmap = newInstance.decodeRegion(V(i3, i16, i17, i18, options, i19), options);
                newInstance.recycle();
            } catch (Exception e16) {
                QMLog.e("CanvasEmbeddedWidgetClient", "bitmapRegionDecoder newInstance exception: " + Log.getStackTraceString(e16));
            }
            return bitmap;
        }
        options.inJustDecodeBounds = false;
        float f18 = options.outWidth;
        float f19 = options.outHeight;
        float sqrt2 = (float) Math.sqrt(((f16 * f17) / r1) / r3);
        if (sqrt2 < 1.0f) {
            f18 *= sqrt2;
            f19 *= sqrt2;
        }
        if (ImageUtil.isPngFile(str)) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            sqrt = Math.sqrt(((8985600.0d / f18) / f19) / 4.0d);
        } else {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            sqrt = Math.sqrt(((8985600.0d / f18) / f19) / 2.0d);
        }
        float f26 = (float) sqrt;
        if (f26 < 1.0f) {
            options.inSampleSize = ImageUtil.calculateInSampleSize(options, f18 * f26, f19 * f26);
            try {
                bitmap = BitmapFactory.decodeFile(str, options);
            } catch (Throwable unused) {
                QMLog.w("CanvasEmbeddedWidgetClient", "getLocalBitmap error with inSampleSize error!try again with lower quality!");
            }
        } else {
            try {
                bitmap = BitmapFactory.decodeFile(str, options);
            } catch (Throwable unused2) {
                QMLog.w("CanvasEmbeddedWidgetClient", "getLocalBitmap error! try again with lower quality!");
            }
        }
        return K(str, options, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0(String str, int i3, boolean z16, JSONObject jSONObject) {
        if (z16) {
            G(str, jSONObject, i3);
        } else {
            F(str, jSONObject, i3);
        }
    }

    private Bitmap K(String str, BitmapFactory.Options options, Bitmap bitmap) {
        if (bitmap == null) {
            int i3 = options.inSampleSize;
            if (i3 > 0) {
                options.inSampleSize = i3 * 2;
            } else {
                options.inSampleSize = 2;
            }
            try {
                return BitmapFactory.decodeFile(str, options);
            } catch (Throwable th5) {
                QMLog.e("CanvasEmbeddedWidgetClient", "getLocalBitmap 2nd time error!", th5);
                return bitmap;
            }
        }
        return bitmap;
    }

    private void L(Canvas canvas, JSONArray jSONArray) throws Exception {
        if (jSONArray == null) {
            return;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            String optString = jSONObject.optString("method");
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            a aVar = this.f346268j0.get(optString);
            if (aVar != null) {
                aVar.doAction(canvas, jSONObject, optString, optJSONArray);
            }
        }
        this.I.setShader(null);
        this.I.setColor(-16777216);
        this.I.clearShadowLayer();
        this.J.setShader(null);
        this.J.setColor(-16777216);
        this.J.clearShadowLayer();
    }

    private void M(final boolean z16, final JSONObject jSONObject, final String str, final b bVar) {
        final Bitmap R = R(z16);
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.r
            @Override // java.lang.Runnable
            public final void run() {
                aa.this.l0(R, bVar, jSONObject, z16, str);
            }
        });
    }

    private void M0(JSONArray jSONArray, JSONArray jSONArray2) {
        float f16;
        float K0 = K0(jSONArray2.optDouble(0, 0.0d));
        float K02 = K0(jSONArray2.optDouble(1, 0.0d));
        float K03 = K0(jSONArray2.optDouble(2, 0.0d));
        double optDouble = jSONArray2.optDouble(3, 0.0d);
        double optDouble2 = jSONArray2.optDouble(4, 0.0d);
        float f17 = (float) ((optDouble / 3.141592653589793d) * 180.0d);
        float f18 = (float) ((optDouble2 / 3.141592653589793d) * 180.0d);
        boolean optBoolean = jSONArray.optBoolean(5);
        RectF rectF = new RectF(K0 - K03, K02 - K03, K0 + K03, K02 + K03);
        if (optBoolean) {
            f16 = f17 - f18;
        } else {
            f16 = f18 - f17;
        }
        float f19 = f16 % 360.0f;
        if (f19 <= 0.0f) {
            f19 += 360.0f;
        }
        if (this.E.isEmpty()) {
            this.E.addArc(rectF, f17, f19);
        } else if (Math.abs(Math.abs(f19) - 360.0f) < 1.0E-14d) {
            this.E.addArc(rectF, f17, f19);
        } else {
            this.E.arcTo(rectF, f17, f19);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        Surface surface = this.f346259e;
        if (surface != null && surface.isValid() && this.f346260e0) {
            if (this.f346266i == null) {
                this.f346266i = new Rect(0, 0, this.f346261f, this.f346264h);
            }
            try {
                Canvas lockHardwareCanvas = this.f346259e.lockHardwareCanvas();
                lockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                lockHardwareCanvas.setDrawFilter(this.f346269k0);
                L(lockHardwareCanvas, this.f346258d0);
                this.f346260e0 = false;
                this.f346259e.unlockCanvasAndPost(lockHardwareCanvas);
            } catch (Throwable th5) {
                QMLog.e("CanvasEmbeddedWidgetClient", "draw failed! " + Log.getStackTraceString(th5));
            }
        }
    }

    private void N0(JSONArray jSONArray) {
        float K0 = K0(jSONArray.optDouble(0, 0.0d));
        float K02 = K0(jSONArray.optDouble(1, 0.0d));
        float K03 = K0(jSONArray.optDouble(2, 0.0d));
        float K04 = K0(jSONArray.optDouble(3, 0.0d));
        float K05 = K0(jSONArray.optDouble(4, 0.0d));
        float K06 = K0(jSONArray.optDouble(5, 0.0d));
        if (this.E.isEmpty()) {
            this.E.moveTo(K0, K02);
        }
        this.E.cubicTo(K0, K02, K03, K04, K05, K06);
    }

    private void O(Canvas canvas, String str, float f16, float f17, float f18, float f19, int i3, int i16, int i17, int i18, BitmapFactory.Options options, int i19) {
        Bitmap J;
        if (f18 > 0.0f && f19 > 0.0f && (J = J(str, f18, f19, i3, i16, i17, i18, options, i19)) != null) {
            if (i19 != 0) {
                J = ImageUtil.rotaingImageView(i19, J);
            }
            RectF rectF = new RectF();
            rectF.left = K0(f16);
            rectF.top = K0(f17);
            rectF.right = rectF.left + K0(f18);
            rectF.bottom = rectF.top + K0(f19);
            canvas.drawBitmap(J, (Rect) null, rectF, (Paint) null);
            J.recycle();
        }
    }

    private void O0(JSONArray jSONArray) {
        float K0 = K0(jSONArray.optDouble(0, 0.0d));
        float K02 = K0(jSONArray.optDouble(1, 0.0d));
        if (this.E.isEmpty()) {
            this.E.moveTo(K0, K02);
        } else {
            this.E.lineTo(K0, K02);
        }
    }

    private void P(Canvas canvas, JSONArray jSONArray) {
        int i3;
        String optString = jSONArray.optString(0);
        if (!StringUtil.isEmpty(optString)) {
            optString = ((MiniAppFileManager) getMiniAppContext().getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
        }
        String str = optString;
        if (!StringUtil.isEmpty(str)) {
            float optDouble = (float) jSONArray.optDouble(1, 0.0d);
            float optDouble2 = (float) jSONArray.optDouble(2, 0.0d);
            float optDouble3 = (float) jSONArray.optDouble(3, 0.0d);
            float optDouble4 = (float) jSONArray.optDouble(4, 0.0d);
            int optDouble5 = (int) jSONArray.optDouble(5, 0.0d);
            int optDouble6 = (int) jSONArray.optDouble(6, 0.0d);
            int optDouble7 = (int) jSONArray.optDouble(7, 0.0d);
            int optDouble8 = (int) jSONArray.optDouble(8, 0.0d);
            BitmapFactory.Options options = new BitmapFactory.Options();
            int exifOrientation = ImageUtil.getExifOrientation(str);
            try {
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                if (optDouble3 <= 0.0f || optDouble4 <= 0.0f) {
                    if (optDouble7 > 0 && optDouble8 > 0) {
                        optDouble3 = optDouble7;
                        optDouble4 = optDouble8;
                    } else {
                        if (exifOrientation != 90 && exifOrientation != 270) {
                            optDouble3 = options.outWidth;
                            i3 = options.outHeight;
                            optDouble4 = i3;
                        }
                        optDouble3 = options.outHeight;
                        i3 = options.outWidth;
                        optDouble4 = i3;
                    }
                }
            } catch (Exception e16) {
                QMLog.e("CanvasEmbeddedWidgetClient", "calculate image size error! " + Log.getStackTraceString(e16));
            }
            O(canvas, str, optDouble, optDouble2, optDouble3, optDouble4, optDouble5, optDouble6, optDouble7, optDouble8, options, exifOrientation);
        }
    }

    private void P0(JSONArray jSONArray) {
        float K0 = K0(jSONArray.optDouble(0, 0.0d));
        float K02 = K0(jSONArray.optDouble(1, 0.0d));
        float K03 = K0(jSONArray.optDouble(2, 0.0d));
        float K04 = K0(jSONArray.optDouble(3, 0.0d));
        if (this.E.isEmpty()) {
            this.E.moveTo(K0, K02);
        }
        this.E.quadTo(K0, K02, K03, K04);
    }

    private void Q(String str, String str2, int i3) {
        IMiniAppContext iMiniAppContext = this.D;
        if (iMiniAppContext != null) {
            iMiniAppContext.performAction(ServiceSubscribeEvent.obtain(str, str2, i3));
        }
    }

    private void Q0(JSONArray jSONArray) {
        float K0 = K0(jSONArray.optDouble(0, 0.0d));
        float K02 = K0(jSONArray.optDouble(1, 0.0d));
        float K03 = K0(jSONArray.optDouble(2, 0.0d));
        float K04 = K0(jSONArray.optDouble(3, 0.0d));
        if (K03 <= 0.0f) {
            K0 += K03;
            K03 = -K03;
        }
        if (K04 <= 0.0f) {
            K02 += K04;
            K04 = -K04;
        }
        E(K0, K02, K03, K04);
    }

    private Bitmap R(boolean z16) {
        Bitmap.Config config;
        try {
            int i3 = this.f346261f;
            int i16 = this.f346264h;
            if (z16) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.RGB_565;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, config);
            L(new Canvas(createBitmap), this.f346258d0);
            return createBitmap;
        } catch (Throwable th5) {
            QMLog.e("CanvasEmbeddedWidgetClient", "getCacheBitmapFromView failed: " + Log.getStackTraceString(th5));
            return null;
        }
    }

    private void R0() {
        this.f346263g0.post(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.q
            @Override // java.lang.Runnable
            public final void run() {
                aa.this.N();
            }
        });
    }

    private int S(JSONArray jSONArray) {
        try {
            return Color.argb(jSONArray.optInt(3, 0), jSONArray.optInt(0, 0), jSONArray.optInt(1, 0), jSONArray.optInt(2, 0));
        } catch (Exception e16) {
            QMLog.e("CanvasEmbeddedWidgetClient", Log.getStackTraceString(e16));
            return 0;
        }
    }

    private void S0(Canvas canvas, String str, JSONObject jSONObject, int i3) {
        boolean isRecycled;
        int optInt;
        int optInt2;
        int optInt3;
        int optInt4;
        byte[] bArr;
        Bitmap bitmap = null;
        try {
            optInt = jSONObject.optInt(HippyTKDListViewAdapter.X);
            optInt2 = jSONObject.optInt("y");
            optInt3 = jSONObject.optInt("width");
            optInt4 = jSONObject.optInt("height");
            NativeBuffer unpackNativeBuffer = NativeBuffer.unpackNativeBuffer(null, jSONObject, "data");
            if (unpackNativeBuffer != null) {
                try {
                    bArr = unpackNativeBuffer.buf;
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        QMLog.e("CanvasEmbeddedWidgetClient", "putImageData failed: " + Log.getStackTraceString(th));
                        F(str, null, i3);
                        if (bitmap != null) {
                            if (isRecycled) {
                                return;
                            }
                        }
                        return;
                    } finally {
                        if (bitmap != null && !bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    }
                }
            } else {
                bArr = null;
            }
        } catch (Throwable th6) {
            th = th6;
            bitmap = null;
        }
        if (bArr == null) {
            return;
        }
        int[] iArr = new int[optInt3 * optInt4];
        for (int i16 = 0; i16 < optInt4; i16++) {
            for (int i17 = 0; i17 < optInt3; i17++) {
                int i18 = (optInt3 * i16) + i17;
                int i19 = i18 * 4;
                iArr[i18] = Color.argb((bArr[i19 + 3] + 256) % 256, (bArr[i19] + 256) % 256, (bArr[i19 + 1] + 256) % 256, (bArr[i19 + 2] + 256) % 256);
            }
        }
        bitmap = Bitmap.createBitmap(optInt3, optInt4, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(iArr, 0, optInt3, 0, 0, optInt3, optInt4);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        float K0 = K0(optInt);
        float K02 = K0(optInt2);
        canvas.drawBitmap(bitmap, (Rect) null, new RectF(K0, K02, K0(optInt3) + K0, K0(optInt4) + K02), paint);
        G(str, null, i3);
        if (bitmap.isRecycled()) {
        }
    }

    private float T(int i3, int i16) {
        return (float) Math.sqrt(((8985600.0d / i3) / i16) / 2.0d);
    }

    private Bitmap.Config U(boolean z16) {
        if (z16) {
            return Bitmap.Config.ARGB_8888;
        }
        return Bitmap.Config.RGB_565;
    }

    private Rect V(int i3, int i16, int i17, int i18, BitmapFactory.Options options, int i19) {
        Rect rect = new Rect();
        if (i19 == 90) {
            rect.left = i16;
            int i26 = (options.outHeight - i3) - i17;
            rect.top = i26;
            rect.right = i16 + i18;
            rect.bottom = i26 + i17;
        } else if (i19 == 180) {
            int i27 = (options.outWidth - i3) - i17;
            rect.left = i27;
            int i28 = (options.outHeight - i16) - i18;
            rect.top = i28;
            rect.right = i27 + i17;
            rect.bottom = i28 + i18;
        } else if (i19 == 270) {
            int i29 = (options.outWidth - i16) - i18;
            rect.left = i29;
            rect.top = i3;
            rect.right = i29 + i18;
            rect.bottom = i3 + i17;
        } else {
            rect.left = i3;
            rect.top = i16;
            rect.right = i3 + i17;
            rect.bottom = i16 + i18;
        }
        return rect;
    }

    private Paint W(String str) {
        if (str != null && str.contains(CanvasView.CUSTOM_ACTION_FILL)) {
            int i3 = this.K;
            if (i3 != -1 && i3 < this.L) {
                this.I.setAlpha(i3);
            } else {
                this.I.setAlpha(this.L);
            }
            return this.I;
        }
        int i16 = this.K;
        if (i16 != -1 && i16 < this.M) {
            this.J.setAlpha(i16);
        } else {
            this.J.setAlpha(this.M);
        }
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        if (r6.equals("bottom") == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void W0(Canvas canvas, String str, JSONArray jSONArray) {
        Paint W = W(str);
        float descent = W.descent();
        float ascent = W.ascent();
        boolean z16 = false;
        String optString = jSONArray.optString(0);
        float K0 = K0(jSONArray.optDouble(1, 0.0d));
        float K02 = K0(jSONArray.optDouble(2, 0.0d));
        float K03 = K0(jSONArray.optDouble(3, -1.0d));
        String str2 = this.N;
        str2.hashCode();
        switch (str2.hashCode()) {
            case -1383228885:
                break;
            case -1074341483:
                if (str2.equals("middle")) {
                    z16 = true;
                    break;
                }
                z16 = -1;
                break;
            case 115029:
                if (str2.equals("top")) {
                    z16 = 2;
                    break;
                }
                z16 = -1;
                break;
            default:
                z16 = -1;
                break;
        }
        switch (z16) {
            case true:
                descent = (descent + ascent) / 2.0f;
            case false:
                K02 -= descent;
                break;
            case true:
                K02 -= ascent;
                break;
        }
        if (K03 > 0.0f) {
            canvas.save();
            float measureText = K03 / W.measureText(optString);
            if (measureText < 1.0f) {
                canvas.scale(measureText, 1.0f, K0, K02);
            }
            canvas.drawText(optString, K0, K02, W);
            canvas.restore();
            return;
        }
        canvas.drawText(optString, K0, K02, W);
    }

    private int X(Typeface typeface) {
        if (typeface != null && typeface.isBold()) {
            return 3;
        }
        return 2;
    }

    private void X0(JSONArray jSONArray) {
        String optString = jSONArray.optString(0, "normal");
        if ("normal".equals(optString)) {
            Typeface typeface = this.I.getTypeface();
            this.I.setTypeface(Typeface.create(typeface, Y(typeface)));
            Typeface typeface2 = this.J.getTypeface();
            this.J.setTypeface(Typeface.create(typeface2, Y(typeface2)));
            return;
        }
        if ("italic".equals(optString) || "oblique".equals(optString)) {
            Typeface typeface3 = this.I.getTypeface();
            this.I.setTypeface(Typeface.create(typeface3, X(typeface3)));
            Typeface typeface4 = this.J.getTypeface();
            this.J.setTypeface(Typeface.create(typeface4, X(typeface4)));
        }
    }

    private int Y(Typeface typeface) {
        if (typeface != null && typeface.isBold()) {
            return 1;
        }
        return 0;
    }

    private void Y0(JSONArray jSONArray) {
        String optString = jSONArray.optString(0);
        if ("normal".equals(optString)) {
            Typeface typeface = this.I.getTypeface();
            this.I.setTypeface(Typeface.create(typeface, a0(typeface)));
            Typeface typeface2 = this.J.getTypeface();
            this.J.setTypeface(Typeface.create(typeface2, a0(typeface2)));
            return;
        }
        if ("bold".equals(optString)) {
            Typeface typeface3 = this.I.getTypeface();
            this.I.setTypeface(Typeface.create(typeface3, Z(typeface3)));
            Typeface typeface4 = this.J.getTypeface();
            this.J.setTypeface(Typeface.create(typeface4, Z(typeface4)));
        }
    }

    private int Z(Typeface typeface) {
        if (typeface != null && typeface.isItalic()) {
            return 3;
        }
        return 1;
    }

    private void Z0(JSONArray jSONArray) {
        PorterDuff.Mode mode;
        String optString = jSONArray.optString(0);
        if ("xor".equals(optString)) {
            mode = PorterDuff.Mode.XOR;
        } else if ("source-atop".equals(optString)) {
            mode = PorterDuff.Mode.SRC_ATOP;
        } else if ("destination-out".equals(optString)) {
            mode = PorterDuff.Mode.DST_OUT;
        } else if (!PTSNodeTextBase.WEIGHT_LIGHTER.equals(optString) && !"lighten".equals(optString) && !"hard-light".equals(optString)) {
            if ("overlay".equals(optString)) {
                mode = PorterDuff.Mode.OVERLAY;
            } else if ("darken".equals(optString)) {
                mode = PorterDuff.Mode.DARKEN;
            } else {
                mode = null;
            }
        } else {
            mode = PorterDuff.Mode.LIGHTEN;
        }
        if (mode != null) {
            this.I.setXfermode(new PorterDuffXfermode(mode));
            this.J.setXfermode(new PorterDuffXfermode(mode));
        }
    }

    private int a0(Typeface typeface) {
        if (typeface != null && typeface.isItalic()) {
            return 2;
        }
        return 0;
    }

    private void a1(JSONArray jSONArray) {
        Paint.Cap cap;
        String optString = jSONArray.optString(0);
        if ("butt".equals(optString)) {
            cap = Paint.Cap.BUTT;
        } else if ("round".equals(optString)) {
            cap = Paint.Cap.ROUND;
        } else if ("square".equals(optString)) {
            cap = Paint.Cap.SQUARE;
        } else {
            cap = null;
        }
        if (cap != null) {
            this.J.setStrokeCap(cap);
        }
    }

    private void b1(JSONArray jSONArray) {
        DashPathEffect dashPathEffect;
        JSONArray jSONArray2 = (JSONArray) jSONArray.opt(0);
        if (jSONArray2.length() > 0) {
            float K0 = K0(jSONArray.optDouble(1, 0.0d));
            float[] fArr = new float[jSONArray2.length()];
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                fArr[i3] = K0(jSONArray2.optDouble(i3, 0.0d));
            }
            dashPathEffect = new DashPathEffect(fArr, K0);
        } else {
            dashPathEffect = null;
        }
        this.I.setPathEffect(dashPathEffect);
        this.J.setPathEffect(dashPathEffect);
    }

    private void c1(JSONArray jSONArray) {
        Paint.Join join;
        String optString = jSONArray.optString(0);
        if ("bevel".equals(optString)) {
            join = Paint.Join.BEVEL;
        } else if ("round".equals(optString)) {
            join = Paint.Join.ROUND;
        } else if ("miter".equals(optString)) {
            join = Paint.Join.MITER;
        } else {
            join = null;
        }
        if (join != null) {
            this.J.setStrokeJoin(join);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009f, code lost:
    
        switch(r6) {
            case 0: goto L58;
            case 1: goto L57;
            case 2: goto L56;
            case 3: goto L55;
            case 4: goto L54;
            case 5: goto L53;
            case 6: goto L52;
            case 7: goto L51;
            default: goto L76;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a3, code lost:
    
        r9.translate(K0(r2.optDouble(0, 0.0d)), K0(r2.optDouble(1, 0.0d)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b7, code lost:
    
        Q0(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bb, code lost:
    
        M0(r11, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bf, code lost:
    
        N0(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c3, code lost:
    
        r8.E.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c9, code lost:
    
        r8.E.moveTo(K0(r2.optDouble(0, 0.0d)), K0(r2.optDouble(1, 0.0d)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00df, code lost:
    
        O0(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e3, code lost:
    
        P0(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d1(Canvas canvas, String str, JSONArray jSONArray) {
        if (this.E == null) {
            this.E = new Path();
        }
        this.E.reset();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                if (optJSONArray != null) {
                    optString.hashCode();
                    char c16 = '\uffff';
                    switch (optString.hashCode()) {
                        case -1904667246:
                            if (optString.equals(CanvasView.ACTION_QUADRATIC_CURVETO)) {
                                c16 = 0;
                                break;
                            }
                            break;
                        case -1102672497:
                            if (optString.equals(CanvasView.ACTION_LINETO)) {
                                c16 = 1;
                                break;
                            }
                            break;
                        case -1068263892:
                            if (optString.equals(CanvasView.ACTION_MOVETO)) {
                                c16 = 2;
                                break;
                            }
                            break;
                        case -482608579:
                            if (optString.equals(CanvasView.ACTION_CLOSEPATH)) {
                                c16 = 3;
                                break;
                            }
                            break;
                        case -435733525:
                            if (optString.equals(CanvasView.ACTION_QBEZIER_CURVETO)) {
                                c16 = 4;
                                break;
                            }
                            break;
                        case 96850:
                            if (optString.equals(CanvasView.ACTION_ARC)) {
                                c16 = 5;
                                break;
                            }
                            break;
                        case 3496420:
                            if (optString.equals(CanvasView.ACTION_RECT)) {
                                c16 = 6;
                                break;
                            }
                            break;
                        case 1052832078:
                            if (optString.equals(CanvasView.ACTION_TRANSLATE)) {
                                c16 = 7;
                                break;
                            }
                            break;
                    }
                }
            }
        }
        if ("clip".equals(str)) {
            canvas.clipPath(this.E);
        } else {
            canvas.drawPath(this.E, W(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1(String str, JSONArray jSONArray) {
        this.P = false;
        this.Q = false;
        this.R = 0;
        this.S = 0;
        String optString = jSONArray.optString(0);
        if ("normal".equals(optString)) {
            g1(str, jSONArray);
            return;
        }
        if (CanvasView.ACTION_RADIAL.equals(optString)) {
            JSONArray optJSONArray = jSONArray.optJSONArray(1);
            JSONArray optJSONArray2 = jSONArray.optJSONArray(2);
            RadialGradient radialGradient = new RadialGradient(K0(optJSONArray.optDouble(0)), K0(optJSONArray.optDouble(1)), K0(optJSONArray.optDouble(2)), S(optJSONArray2.optJSONArray(0).optJSONArray(1)), S(optJSONArray2.optJSONArray(1).optJSONArray(1)), Shader.TileMode.CLAMP);
            if (CanvasView.ACTION_SET_STROKESTYLE.equals(str)) {
                this.J.setShader(radialGradient);
                return;
            } else {
                if (CanvasView.ACTION_SET_FILLSTYLE.equals(str)) {
                    this.I.setShader(radialGradient);
                    return;
                }
                return;
            }
        }
        if (CanvasView.ACTION_LINER.equals(optString)) {
            JSONArray optJSONArray3 = jSONArray.optJSONArray(1);
            JSONArray optJSONArray4 = jSONArray.optJSONArray(2);
            LinearGradient linearGradient = new LinearGradient(K0(optJSONArray3.optDouble(0)), K0(optJSONArray3.optDouble(1)), K0(optJSONArray3.optDouble(2)), K0(optJSONArray3.optDouble(3)), S(optJSONArray4.optJSONArray(0).optJSONArray(1)), S(optJSONArray4.optJSONArray(1).optJSONArray(1)), Shader.TileMode.CLAMP);
            if (CanvasView.ACTION_SET_STROKESTYLE.equals(str)) {
                this.J.setShader(linearGradient);
                return;
            } else {
                if (CanvasView.ACTION_SET_FILLSTYLE.equals(str)) {
                    this.I.setShader(linearGradient);
                    return;
                }
                return;
            }
        }
        if ("pattern".equals(optString)) {
            f1(jSONArray);
        }
    }

    private void f0(MotionEvent motionEvent, JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(HippyTKDListViewAdapter.X, U0(motionEvent.getX()));
            jSONObject2.put("y", U0(motionEvent.getY()));
            jSONObject2.put("id", motionEvent.getPointerId(0));
            jSONArray.mo162put(jSONObject2);
            jSONObject.put("data", this.H);
            jSONObject.put("touches", jSONArray);
            Q("onTouchCancel", jSONObject.toString(), this.C);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void f1(JSONArray jSONArray) {
        if (jSONArray.length() == 3) {
            String optString = jSONArray.optString(1);
            if (!StringUtil.isEmpty(optString)) {
                if (optString.startsWith("wxfile")) {
                    optString = ((MiniAppFileManager) getMiniAppContext().getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
                } else {
                    optString = this.f346267i0.getChildFileAbsolutePath(optString);
                }
            }
            String optString2 = jSONArray.optString(2);
            if ("repeat".equals(optString2)) {
                this.P = true;
                this.Q = true;
            } else if ("repeat-x".equals(optString2)) {
                this.P = true;
            } else if ("repeat-y".equals(optString2)) {
                this.Q = true;
            }
            h1(optString);
        }
    }

    private void g0(MotionEvent motionEvent, JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(HippyTKDListViewAdapter.X, U0(motionEvent.getX()));
            jSONObject2.put("y", U0(motionEvent.getY()));
            jSONObject2.put("id", motionEvent.getPointerId(0));
            jSONObject.put("data", this.H);
            jSONObject.put(WebRTCSDK.PRIVILEGE_TOUCH, jSONObject2);
            Q(str, jSONObject.toString(), this.C);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void g1(String str, JSONArray jSONArray) {
        JSONArray optJSONArray = jSONArray.optJSONArray(1);
        if (CanvasView.ACTION_SET_STROKESTYLE.equals(str)) {
            int S = S(optJSONArray);
            this.M = optJSONArray.optInt(3);
            this.J.setShader(null);
            this.J.setColor(S);
            return;
        }
        if (CanvasView.ACTION_SET_FILLSTYLE.equals(str)) {
            int S2 = S(optJSONArray);
            this.L = optJSONArray.optInt(3);
            this.I.setShader(null);
            this.I.setColor(S2);
        }
    }

    private void h0(MotionEvent motionEvent, JSONObject jSONObject) {
        try {
            JSONArray jSONArray = new JSONArray();
            int pointerCount = motionEvent.getPointerCount();
            for (int i3 = 0; i3 < pointerCount; i3++) {
                float x16 = motionEvent.getX(i3);
                float y16 = motionEvent.getY(i3);
                if (Math.abs(x16 - this.F) >= 0.5d || Math.abs(y16 - this.G) >= 0.5d) {
                    this.F = x16;
                    this.G = y16;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(HippyTKDListViewAdapter.X, U0(x16));
                    jSONObject2.put("y", U0(y16));
                    jSONObject2.put("id", motionEvent.getPointerId(i3));
                    jSONArray.mo162put(jSONObject2);
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("data", this.H);
                jSONObject.put("touches", jSONArray);
                Q("onTouchMove", jSONObject.toString(), this.C);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void h1(String str) {
        Shader.TileMode tileMode;
        Shader.TileMode tileMode2;
        if (!StringUtil.isEmpty(str)) {
            Bitmap localBitmap = ImageUtil.getLocalBitmap(str);
            if (localBitmap != null) {
                this.R = localBitmap.getWidth();
                this.S = localBitmap.getHeight();
            }
            Matrix matrix = new Matrix();
            float f16 = this.f346265h0;
            matrix.postScale(f16, f16);
            Bitmap createBitmap = Bitmap.createBitmap(localBitmap, 0, 0, this.R, this.S, matrix, true);
            if (createBitmap != null) {
                this.R = createBitmap.getWidth();
                this.S = createBitmap.getHeight();
                if (this.P) {
                    tileMode = Shader.TileMode.REPEAT;
                } else {
                    tileMode = Shader.TileMode.CLAMP;
                }
                if (this.Q) {
                    tileMode2 = Shader.TileMode.REPEAT;
                } else {
                    tileMode2 = Shader.TileMode.CLAMP;
                }
                BitmapShader bitmapShader = new BitmapShader(createBitmap, tileMode, tileMode2);
                this.I.setShader(bitmapShader);
                this.J.setShader(bitmapShader);
            }
        }
    }

    private void i0(MotionEvent motionEvent, JSONObject jSONObject, String str) {
        try {
            int actionIndex = motionEvent.getActionIndex();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(HippyTKDListViewAdapter.X, U0(motionEvent.getX(actionIndex)));
            jSONObject2.put("y", U0(motionEvent.getY(actionIndex)));
            jSONObject2.put("id", motionEvent.getPointerId(actionIndex));
            jSONObject.put("data", this.H);
            jSONObject.put(WebRTCSDK.PRIVILEGE_TOUCH, jSONObject2);
            Q(str, jSONObject.toString(), this.C);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void i1(JSONArray jSONArray) {
        Paint.Align align;
        String optString = jSONArray.optString(0);
        if ("center".equals(optString)) {
            align = Paint.Align.CENTER;
        } else if ("right".equals(optString)) {
            align = Paint.Align.RIGHT;
        } else {
            align = Paint.Align.LEFT;
        }
        this.I.setTextAlign(align);
        this.J.setTextAlign(align);
    }

    private void k0() {
        this.f346268j0.put(CanvasView.ACTION_DRAWIMAGE, new a() { // from class: com.tencent.qqmini.miniapp.plugin.s
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.C0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put(CanvasView.ACTION_SET_STROKESTYLE, new e());
        this.f346268j0.put(CanvasView.ACTION_SET_FILLSTYLE, new e());
        this.f346268j0.put(CanvasView.ACTION_STROKEPATH, new d());
        this.f346268j0.put(CanvasView.ACTION_FILLPATH, new d());
        this.f346268j0.put("clip", new d());
        this.f346268j0.put(CanvasView.ACTION_SET_FONT_SIZE, new a() { // from class: com.tencent.qqmini.miniapp.plugin.e
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.D0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put(CanvasView.ACTION_SET_FONT_STYLE, new a() { // from class: com.tencent.qqmini.miniapp.plugin.h
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.E0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put(CanvasView.ACTION_SET_FONT_WEIGHT, new a() { // from class: com.tencent.qqmini.miniapp.plugin.i
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.F0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put(CanvasView.ACTION_SET_FONT_FAMILY, new a() { // from class: com.tencent.qqmini.miniapp.plugin.j
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.G0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put(CanvasView.ACTION_SET_TEXTALIGN, new a() { // from class: com.tencent.qqmini.miniapp.plugin.k
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.H0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put(CanvasView.ACTION_FILLTEXT, new c());
        this.f346268j0.put(CanvasView.ACTION_STROKETEXT, new c());
        this.f346268j0.put(CanvasView.ACTION_SET_GLOBALALPHA, new a() { // from class: com.tencent.qqmini.miniapp.plugin.m
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.I0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put(CanvasView.ACTION_RESTORE, new a() { // from class: com.tencent.qqmini.miniapp.plugin.n
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.n0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put("save", new a() { // from class: com.tencent.qqmini.miniapp.plugin.o
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.o0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put(CanvasView.ACTION_CLRAERECT, new a() { // from class: com.tencent.qqmini.miniapp.plugin.p
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.p0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put(CanvasView.ACTION_SETGLOBALCOMPOSITEOPERATION, new a() { // from class: com.tencent.qqmini.miniapp.plugin.t
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.q0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put(CanvasView.ACTION_ROTATE, new a() { // from class: com.tencent.qqmini.miniapp.plugin.u
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.r0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put("scale", new a() { // from class: com.tencent.qqmini.miniapp.plugin.v
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.s0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put(CanvasView.ACTION_TRANSLATE, new a() { // from class: com.tencent.qqmini.miniapp.plugin.w
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.t0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put(CanvasView.ACTION_SET_LINEWIDTH, new a() { // from class: com.tencent.qqmini.miniapp.plugin.x
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.u0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put(CanvasView.ACTION_SET_SHADOW, new a() { // from class: com.tencent.qqmini.miniapp.plugin.y
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.v0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put(CanvasView.ACTION_SET_LINECAP, new a() { // from class: com.tencent.qqmini.miniapp.plugin.z
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.w0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put(CanvasView.ACTION_SET_LINEJOIN, new a() { // from class: com.tencent.qqmini.miniapp.plugin.b
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.x0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put(CanvasView.ACTION_SET_LINEDASH, new a() { // from class: com.tencent.qqmini.miniapp.plugin.c
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.y0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put(CanvasView.ACTION_SET_MITERLIMIT, new a() { // from class: com.tencent.qqmini.miniapp.plugin.d
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.z0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put(CanvasView.ACTION_SET_TRANSFORM, new g());
        this.f346268j0.put("transform", new g());
        this.f346268j0.put(CanvasView.ACTION_SET_BASELINE, new a() { // from class: com.tencent.qqmini.miniapp.plugin.f
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.A0(canvas, jSONObject, str, jSONArray);
            }
        });
        this.f346268j0.put("xWebCanvasPutImageData", new a() { // from class: com.tencent.qqmini.miniapp.plugin.g
            @Override // com.tencent.qqmini.miniapp.plugin.aa.a
            public final void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                aa.this.B0(canvas, jSONObject, str, jSONArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(Canvas canvas, String str, JSONArray jSONArray) {
        float optDouble = (float) jSONArray.optDouble(0, 1.0d);
        float optDouble2 = (float) jSONArray.optDouble(3, 1.0d);
        float optDouble3 = (float) jSONArray.optDouble(2, 0.0d);
        float optDouble4 = (float) jSONArray.optDouble(1, 0.0d);
        float K0 = K0(jSONArray.optDouble(4, 0.0d));
        float K02 = K0(jSONArray.optDouble(5, 0.0d));
        float[] fArr = new float[9];
        try {
            fArr[2] = K0;
            fArr[5] = K02;
            fArr[0] = optDouble;
            fArr[4] = optDouble2;
            fArr[1] = optDouble3;
            fArr[3] = optDouble4;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            if ("transform".equals(str)) {
                Matrix matrix = new Matrix();
                matrix.setValues(fArr);
                canvas.concat(matrix);
            } else {
                Matrix matrix2 = canvas.getMatrix();
                if (matrix2 == null) {
                    matrix2 = new Matrix();
                }
                matrix2.setValues(fArr);
                canvas.setMatrix(matrix2);
            }
        } catch (Exception e16) {
            QMLog.e("CanvasEmbeddedWidgetClient", Log.getStackTraceString(e16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cf A[Catch: all -> 0x00f0, TRY_LEAVE, TryCatch #0 {all -> 0x00f0, blocks: (B:4:0x000d, B:7:0x0017, B:9:0x0031, B:12:0x0036, B:13:0x0039, B:15:0x004b, B:18:0x0053, B:19:0x005b, B:24:0x0090, B:35:0x00cf, B:48:0x00c6, B:53:0x00a7, B:58:0x0087, B:33:0x00bf, B:29:0x00a0, B:21:0x007f), top: B:2:0x000b, inners: #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void l0(Bitmap bitmap, b bVar, JSONObject jSONObject, boolean z16, String str) {
        String str2;
        int i3;
        Bitmap bitmap2;
        int i16;
        int i17;
        Bitmap bitmap3;
        try {
            if (bitmap == null) {
                QMLog.e("CanvasEmbeddedWidgetClient", "canvas save image error!----getCacheBitmapFromView return null!");
                bVar.onResult(false, null);
                return;
            }
            int L0 = L0(jSONObject.optDouble("width", 0.0d));
            int L02 = L0(jSONObject.optDouble("height", 0.0d));
            if (L0 <= 0) {
                L0 = this.f346261f;
            }
            int i18 = L0;
            if (L02 <= 0) {
                L02 = this.f346264h;
            }
            int optDouble = (int) jSONObject.optDouble("destWidth", 0.0d);
            int optDouble2 = (int) jSONObject.optDouble("destHeight", 0.0d);
            if (optDouble <= 0) {
                optDouble = V0(i18);
            }
            int i19 = optDouble;
            if (optDouble2 <= 0) {
                i3 = V0(L02);
            } else {
                i3 = optDouble2;
            }
            QMLog.d("CanvasEmbeddedWidgetClient", "----saveBitmap---destWidth: " + i19 + "---destHeight: " + i3);
            Bitmap.Config U = U(z16);
            try {
                bitmap2 = Bitmap.createBitmap(i19, i3, U);
            } catch (Throwable th5) {
                QMLog.w("CanvasEmbeddedWidgetClient", "saveBitmap() createBitmap error! try again use lower quality!", th5);
                bitmap2 = null;
            }
            if (bitmap2 == null) {
                float T = T(i19, i3);
                if (T < 1.0f) {
                    i16 = (int) (i19 * T);
                    i17 = (int) (i3 * T);
                    try {
                        bitmap2 = Bitmap.createBitmap(i16, i17, U);
                    } catch (Throwable th6) {
                        QMLog.w("CanvasEmbeddedWidgetClient", "saveBitmap() createBitmap 2nd time error!try again use lower quality!", th6);
                    }
                    if (bitmap2 == null) {
                        i16 = (int) (i16 / 1.4d);
                        i17 = (int) (i17 / 1.4d);
                        try {
                            bitmap3 = Bitmap.createBitmap(i16, i17, U);
                        } catch (Throwable th7) {
                            QMLog.e("CanvasEmbeddedWidgetClient", "saveBitmap() createBitmap 3rd time error!", th7);
                        }
                        if (bitmap3 != null) {
                            str2 = "CanvasEmbeddedWidgetClient";
                            try {
                                I(i18, L02, i19, i3, i16, i17, bitmap3, jSONObject, bitmap, str, z16, bVar);
                                return;
                            } catch (Throwable th8) {
                                th = th8;
                                QMLog.e(str2, "canvasToTempFilePath failed: " + Log.getStackTraceString(th));
                                bVar.onResult(false, null);
                                return;
                            }
                        }
                        bVar.onResult(false, null);
                        return;
                    }
                    bitmap3 = bitmap2;
                    if (bitmap3 != null) {
                    }
                }
            }
            i16 = i19;
            i17 = i3;
            if (bitmap2 == null) {
            }
            bitmap3 = bitmap2;
            if (bitmap3 != null) {
            }
        } catch (Throwable th9) {
            th = th9;
            str2 = "CanvasEmbeddedWidgetClient";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(Bitmap bitmap, String str, int i3, JSONObject jSONObject) {
        Bitmap bitmap2;
        if (bitmap == null) {
            F(str, null, i3);
            return;
        }
        try {
            Matrix matrix = new Matrix();
            float f16 = 1.0f / this.f346265h0;
            matrix.postScale(f16, f16);
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th5) {
            th = th5;
            bitmap2 = null;
        }
        try {
            int optInt = jSONObject.optInt(HippyTKDListViewAdapter.X);
            int optInt2 = jSONObject.optInt("y");
            int optInt3 = jSONObject.optInt("width");
            int optInt4 = jSONObject.optInt("height");
            int i16 = optInt3 * optInt4;
            int[] iArr = new int[i16];
            bitmap2.getPixels(iArr, 0, optInt3, optInt, optInt2, optInt3, optInt4);
            byte[] bArr = new byte[i16 * 4];
            for (int i17 = 0; i17 < optInt4; i17++) {
                int i18 = 0;
                while (i18 < optInt3) {
                    int i19 = (optInt3 * i17) + i18;
                    int i26 = i19 * 4;
                    int i27 = iArr[i19];
                    byte alpha = (byte) Color.alpha(i27);
                    byte red = (byte) Color.red(i27);
                    int[] iArr2 = iArr;
                    byte green = (byte) Color.green(i27);
                    byte blue = (byte) Color.blue(i27);
                    bArr[i26] = red;
                    bArr[i26 + 1] = green;
                    bArr[i26 + 2] = blue;
                    bArr[i26 + 3] = alpha;
                    i18++;
                    iArr = iArr2;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", optInt3);
            jSONObject2.put("height", optInt4);
            NativeBuffer.packNativeBuffer(null, bArr, NativeBuffer.TYPE_BUFFER_BASE64, "data", jSONObject2);
            G(str, jSONObject2, i3);
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            if (bitmap2.isRecycled()) {
            }
        } catch (Throwable th6) {
            th = th6;
            try {
                QMLog.e("CanvasEmbeddedWidgetClient", "getImageData failed: " + Log.getStackTraceString(th));
                F(str, null, i3);
            } finally {
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        try {
            canvas.restore();
        } catch (Exception e16) {
            QMLog.e("CanvasEmbeddedWidgetClient", "ACTION_RESTORE: " + Log.getStackTraceString(e16));
        }
        this.I = this.T;
        this.J = this.U;
        this.K = this.V;
        this.L = this.W;
        this.M = this.X;
        this.N = this.Y;
        this.P = this.Z;
        this.Q = this.f346254a0;
        this.R = this.f346255b0;
        this.S = this.f346256c0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        canvas.save();
        this.T = new Paint(this.I);
        this.U = new Paint(this.J);
        this.V = this.K;
        this.W = this.L;
        this.X = this.M;
        this.Y = this.N;
        this.Z = this.P;
        this.f346254a0 = this.Q;
        this.f346255b0 = this.R;
        this.f346256c0 = this.S;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        H(canvas, jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        Z0(jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        canvas.rotate((float) ((jSONArray.optDouble(0, 0.0d) * 180.0d) / 3.141592653589793d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        canvas.scale((float) jSONArray.optDouble(0, 1.0d), (float) jSONArray.optDouble(1, 1.0d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        canvas.translate(K0(jSONArray.optDouble(0, 0.0d)), K0(jSONArray.optDouble(1, 0.0d)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        this.J.setStrokeWidth(K0(jSONArray.optDouble(0, 0.0d)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        f fVar = new f();
        JSONArray optJSONArray = jSONArray.optJSONArray(3);
        float K0 = K0(jSONArray.optDouble(2, 0.0d));
        float K02 = K0(jSONArray.optDouble(0, 0.0d));
        float K03 = K0(jSONArray.optDouble(1, 0.0d));
        fVar.f346274a = K0;
        fVar.f346275b = K02;
        fVar.f346276c = K03;
        int S = S(optJSONArray);
        fVar.f346277d = S;
        this.I.setShadowLayer(fVar.f346274a, fVar.f346275b, fVar.f346276c, S);
        this.J.setShadowLayer(fVar.f346274a, fVar.f346275b, fVar.f346276c, fVar.f346277d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        a1(jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        c1(jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        b1(jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
        float K0 = K0(jSONArray.optDouble(0, 0.0d));
        this.I.setStrokeMiter(K0);
        this.J.setStrokeMiter(K0);
    }

    public void F(String str, JSONObject jSONObject, int i3) {
        IMiniAppContext iMiniAppContext = this.D;
        if (iMiniAppContext != null) {
            ServiceEvaluateCallbackAction.obtain(iMiniAppContext).callbackJsEventFail(str, jSONObject, i3);
        }
    }

    public void G(String str, JSONObject jSONObject, int i3) {
        IMiniAppContext iMiniAppContext = this.D;
        if (iMiniAppContext != null) {
            ServiceEvaluateCallbackAction.obtain(iMiniAppContext).callbackJsEventOK(str, jSONObject, i3);
        }
    }

    float K0(double d16) {
        return (float) (d16 * this.f346265h0);
    }

    int L0(double d16) {
        return (int) ((d16 * this.f346265h0) + 0.5d);
    }

    public void T0(String str, JSONObject jSONObject, int i3) {
        try {
            if (this.f346258d0 == null) {
                this.f346258d0 = new JSONArray();
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("method", str);
            jSONObject2.put("data", jSONObject);
            jSONObject2.put("callbackId", i3);
            this.f346258d0.mo162put(jSONObject2);
            this.f346260e0 = true;
            R0();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    float U0(double d16) {
        return (float) (d16 / this.f346265h0);
    }

    int V0(double d16) {
        return (int) ((d16 / this.f346265h0) + 0.5d);
    }

    public void b0(final String str, final JSONObject jSONObject, final int i3) {
        final Bitmap R = R(true);
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.l
            @Override // java.lang.Runnable
            public final void run() {
                aa.this.m0(R, str, i3, jSONObject);
            }
        });
    }

    public void c0(JSONObject jSONObject, IJsService iJsService) {
        this.f346257d = iJsService;
        if (iJsService instanceof MiniWebView) {
            this.C = ((MiniWebView) iJsService).J();
        } else {
            QMLog.e("CanvasEmbeddedWidgetClient", "cant get webViewId from " + iJsService);
        }
        if (jSONObject == null) {
            return;
        }
        QMLog.d("CanvasEmbeddedWidgetClient", "handleInsertXWebCanvas : " + jSONObject.toString());
        this.f346270m = jSONObject.optInt("viewId");
        if (jSONObject.optJSONObject("position") != null) {
            this.f346261f = (int) ((this.f346265h0 * r6.optInt("width", -1)) + 0.5f);
            this.f346264h = (int) ((this.f346265h0 * r6.optInt("height", -1)) + 0.5f);
            this.f346266i = new Rect(0, 0, this.f346261f, this.f346264h);
        }
        this.H = jSONObject.optString("data");
    }

    public void d0(JSONObject jSONObject) {
        this.f346258d0 = jSONObject.optJSONArray("actions");
        this.f346260e0 = true;
        R0();
    }

    public void e0() {
        QMLog.d("CanvasEmbeddedWidgetClient", "handleRemoveXWebCanvas");
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public IMiniAppContext getMiniAppContext() {
        return this.D;
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public int getViewId() {
        return this.f346270m;
    }

    public void j0(JSONObject jSONObject) {
        if (jSONObject != null) {
            QMLog.d("CanvasEmbeddedWidgetClient", "handleUpdateXWebCanvas : " + jSONObject.toString());
            if (jSONObject.optJSONObject("position") != null) {
                this.f346261f = (int) ((this.f346265h0 * r5.optInt("width", -1)) + 0.5f);
                this.f346264h = (int) ((this.f346265h0 * r5.optInt("height", -1)) + 0.5f);
                this.f346266i = new Rect(0, 0, this.f346261f, this.f346264h);
                R0();
            }
        }
    }

    public void j1(final String str, JSONObject jSONObject, final int i3) {
        String optString;
        if (jSONObject == null) {
            optString = "png";
        } else {
            optString = jSONObject.optString(TagName.FILE_TYPE);
        }
        M(!"jpg".equals(optString), jSONObject, optString, new b() { // from class: com.tencent.qqmini.miniapp.plugin.a
            @Override // com.tencent.qqmini.miniapp.plugin.aa.b
            public final void onResult(boolean z16, JSONObject jSONObject2) {
                aa.this.J0(str, i3, z16, jSONObject2);
            }
        });
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void nativeDestroy() {
        QMLog.i("CanvasEmbeddedWidgetClient", "nativeDestroy " + this);
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void nativePause() {
        QMLog.i("CanvasEmbeddedWidgetClient", "nativePause " + this);
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void nativeResume() {
        QMLog.i("CanvasEmbeddedWidgetClient", "nativeResume " + this);
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onDestroy() {
        QMLog.i("CanvasEmbeddedWidgetClient", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        if (this.f346262f0.isAlive()) {
            this.f346262f0.quit();
        }
        Surface surface = this.f346259e;
        if (surface != null) {
            surface.release();
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onRectChanged(Rect rect) {
        QMLog.i("CanvasEmbeddedWidgetClient", "onRectChanged, rect:" + rect.toString() + "\uff1b size : " + (rect.right - rect.left) + "," + (rect.bottom - rect.top));
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onRequestRedraw() {
        QMLog.i("CanvasEmbeddedWidgetClient", "onRequestRedraw");
        R0();
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onSurfaceCreated(Surface surface) {
        Boolean bool;
        QMLog.d("CanvasEmbeddedWidgetClient", "onSurfaceCreated: " + surface);
        if (surface != null && surface.isValid()) {
            this.f346259e = surface;
            R0();
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onSurfaceCreated isValid() : ");
        if (surface != null) {
            bool = Boolean.valueOf(surface.isValid());
        } else {
            bool = null;
        }
        sb5.append(bool);
        QMLog.e("CanvasEmbeddedWidgetClient", sb5.toString());
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onSurfaceDestroyed(Surface surface) {
        QMLog.i("CanvasEmbeddedWidgetClient", "onSurfaceDestroyed");
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public boolean onTouchEvent(MotionEvent motionEvent) {
        JSONObject jSONObject = new JSONObject();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                i0(motionEvent, jSONObject, "onTouchEnd");
                            }
                        } else {
                            i0(motionEvent, jSONObject, e.c.NAME);
                        }
                    } else {
                        f0(motionEvent, jSONObject);
                    }
                } else {
                    h0(motionEvent, jSONObject);
                }
            } else {
                g0(motionEvent, jSONObject, "onTouchEnd");
            }
        } else {
            g0(motionEvent, jSONObject, e.c.NAME);
        }
        return true;
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onVisibilityChanged(boolean z16) {
        QMLog.i("CanvasEmbeddedWidgetClient", "onVisibilityChanged \uff1a " + z16);
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void webViewDestroy() {
        QMLog.i("CanvasEmbeddedWidgetClient", "webViewDestroy " + this);
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void webViewPause() {
        QMLog.i("CanvasEmbeddedWidgetClient", "webViewPause " + this);
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void webViewResume() {
        QMLog.i("CanvasEmbeddedWidgetClient", "webViewResume " + this);
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onActive() {
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onDeactive() {
    }
}
