package com.tencent.mtt.hippy.a.a.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {

    /* renamed from: k, reason: collision with root package name */
    private static float f336927k = 0.4f;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f336928a;

    /* renamed from: b, reason: collision with root package name */
    private long f336929b;

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f336930c;

    /* renamed from: d, reason: collision with root package name */
    private String f336931d;

    /* renamed from: e, reason: collision with root package name */
    private int f336932e;

    /* renamed from: f, reason: collision with root package name */
    private int f336933f;

    /* renamed from: g, reason: collision with root package name */
    private int f336934g;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f336935h;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<a> f336936i;

    /* renamed from: j, reason: collision with root package name */
    private ViewTreeObserver.OnDrawListener f336937j;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void b();
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0052: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:55:0x0052 */
    private String a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        int i3;
        String encodeToString;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            if (bitmap != null) {
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                } catch (IOException e16) {
                    e = e16;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (byteArrayOutputStream3 != null) {
                        try {
                            byteArrayOutputStream3.flush();
                            byteArrayOutputStream3.close();
                        } catch (IOException e17) {
                            LogUtils.e("PageModel", "screenFrameAck, exception2=", e17);
                        }
                    }
                    throw th;
                }
                try {
                    Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                    if (this.f336930c != null) {
                        if (!TextUtils.isEmpty(this.f336931d)) {
                            if (MimeHelper.IMAGE_SUBTYPE_JPEG.equalsIgnoreCase(this.f336931d)) {
                                compressFormat = Bitmap.CompressFormat.JPEG;
                            } else if ("png".equalsIgnoreCase(this.f336931d)) {
                                compressFormat = Bitmap.CompressFormat.PNG;
                            }
                        }
                        i3 = this.f336932e;
                    } else {
                        i3 = 80;
                    }
                    bitmap.compress(compressFormat, i3, byteArrayOutputStream2);
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                    encodeToString = Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 0);
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                } catch (IOException e18) {
                    e = e18;
                    LogUtils.e("PageModel", "screenFrameAck, exception1=", e);
                    if (byteArrayOutputStream2 == null) {
                        return null;
                    }
                    try {
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                        return null;
                    } catch (IOException e19) {
                        LogUtils.e("PageModel", "screenFrameAck, exception2=", e19);
                        return null;
                    }
                }
            } else {
                encodeToString = null;
            }
            if (byteArrayOutputStream3 != null) {
                try {
                    byteArrayOutputStream3.flush();
                    byteArrayOutputStream3.close();
                } catch (IOException e26) {
                    LogUtils.e("PageModel", "screenFrameAck, exception2=", e26);
                }
            }
            return encodeToString;
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream3 = byteArrayOutputStream;
        }
    }

    private HippyRootView c(HippyEngineContext hippyEngineContext) {
        return hippyEngineContext.getInstance(hippyEngineContext.getDomManager().f());
    }

    private JSONObject d(HippyEngineContext hippyEngineContext) {
        float f16;
        JSONObject jSONObject = new JSONObject();
        try {
            HippyRootView c16 = c(hippyEngineContext);
            if (c16 == null) {
                LogUtils.e("PageModel", "getScreenCastData error none hippyRootView");
                return null;
            }
            int width = c16.getWidth();
            int height = c16.getHeight();
            if (this.f336930c != null) {
                f16 = Math.max(Math.min(this.f336933f / width, this.f336934g / height), f336927k);
            } else {
                f16 = 1.0f;
            }
            Bitmap bitmap = this.f336935h;
            if (bitmap == null) {
                bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.f336935h = bitmap;
            }
            Canvas canvas = new Canvas(bitmap);
            canvas.drawColor(-1);
            c16.draw(canvas);
            if (f16 != 1.0f) {
                Matrix matrix = new Matrix();
                matrix.postScale(f16, f16);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            }
            String a16 = a(bitmap);
            DisplayMetrics displayMetrics = c16.getContext().getResources().getDisplayMetrics();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("offsetTop", 0);
            jSONObject2.put("pageScaleFactor", 1);
            jSONObject2.put("deviceWidth", displayMetrics.widthPixels);
            jSONObject2.put("deviceHeight", displayMetrics.heightPixels);
            jSONObject2.put("scrollOffsetX", 0);
            jSONObject2.put("scrollOffsetY", 0);
            jSONObject2.put("timestamp", currentTimeMillis);
            if (TextUtils.isEmpty(a16)) {
                a16 = "";
            }
            jSONObject.put("data", a16);
            jSONObject.put(TtmlNode.TAG_METADATA, jSONObject2);
            jSONObject.put("sessionId", currentTimeMillis);
            this.f336929b = currentTimeMillis;
            return jSONObject;
        } catch (Exception e16) {
            LogUtils.e("PageModel", "getScreenCastData, exception=", e16);
            return null;
        }
    }

    public void b() {
        Bitmap bitmap = this.f336935h;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f336935h.recycle();
        this.f336935h = null;
    }

    private void b(HippyEngineContext hippyEngineContext) {
        if (a()) {
            HippyRootView c16 = c(hippyEngineContext);
            if (c16 == null) {
                LogUtils.e("PageModel", "listenFrameUpdate error none hippyRootView");
                return;
            }
            if (this.f336937j == null) {
                this.f336937j = new ViewTreeObserver.OnDrawListener() { // from class: com.tencent.mtt.hippy.a.a.b.d.1
                    @Override // android.view.ViewTreeObserver.OnDrawListener
                    public void onDraw() {
                        a aVar;
                        if (d.this.f336936i != null && (aVar = (a) d.this.f336936i.get()) != null) {
                            aVar.b();
                        }
                    }
                };
            }
            try {
                c16.getViewTreeObserver().removeOnDrawListener(this.f336937j);
                c16.getViewTreeObserver().addOnDrawListener(this.f336937j);
            } catch (Exception e16) {
                LogUtils.e("PageModel", "listenFrameUpdate e:", e16);
            }
        }
    }

    public JSONObject a(HippyEngineContext hippyEngineContext, int i3) {
        if (this.f336928a) {
            return d(hippyEngineContext);
        }
        LogUtils.e("PageModel", "screencast, screenFrameAck, isFramingScreenCast=" + this.f336928a);
        return null;
    }

    public JSONObject a(HippyEngineContext hippyEngineContext, JSONObject jSONObject) {
        this.f336928a = true;
        this.f336930c = jSONObject;
        if (jSONObject != null) {
            this.f336931d = jSONObject.optString("format");
            this.f336932e = jSONObject.optInt(CustomImageProps.QUALITY);
            this.f336933f = jSONObject.optInt(NodeProps.MAX_WIDTH);
            this.f336934g = jSONObject.optInt(NodeProps.MAX_HEIGHT);
        }
        b(hippyEngineContext);
        return d(hippyEngineContext);
    }

    public void a(HippyEngineContext hippyEngineContext) {
        this.f336928a = false;
        if (a()) {
            HippyRootView c16 = c(hippyEngineContext);
            if (c16 == null) {
                LogUtils.e("PageModel", "stopScreenCast error none hippyRootView");
            } else if (this.f336937j != null) {
                c16.getViewTreeObserver().removeOnDrawListener(this.f336937j);
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.f336936i = new WeakReference<>(aVar);
        } else {
            this.f336936i = null;
        }
    }

    public boolean a() {
        return true;
    }
}
