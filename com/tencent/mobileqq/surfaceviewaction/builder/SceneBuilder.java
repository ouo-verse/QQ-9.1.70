package com.tencent.mobileqq.surfaceviewaction.builder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.surfaceviewaction.action.a;
import com.tencent.mobileqq.surfaceviewaction.b;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.a;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SceneBuilder {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f291192a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f291193b;

    /* renamed from: c, reason: collision with root package name */
    private int f291194c;

    /* renamed from: d, reason: collision with root package name */
    private float f291195d;

    /* renamed from: e, reason: collision with root package name */
    private FrameSprite.a f291196e;

    /* renamed from: f, reason: collision with root package name */
    private f f291197f;

    /* renamed from: g, reason: collision with root package name */
    private e f291198g;

    /* renamed from: h, reason: collision with root package name */
    private g f291199h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements a.InterfaceC8634a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.surfaceviewaction.c f291204a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f291205b;

        a(com.tencent.mobileqq.surfaceviewaction.c cVar, String str) {
            this.f291204a = cVar;
            this.f291205b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SceneBuilder.this, cVar, str);
            }
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.gl.a.InterfaceC8634a
        public void a(com.tencent.mobileqq.surfaceviewaction.gl.e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            } else {
                SceneBuilder.b(SceneBuilder.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.surfaceviewaction.c f291207d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.surfaceviewaction.a f291208e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f291209f;

        b(com.tencent.mobileqq.surfaceviewaction.c cVar, com.tencent.mobileqq.surfaceviewaction.a aVar, String str) {
            this.f291207d = cVar;
            this.f291208e = aVar;
            this.f291209f = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SceneBuilder.this, cVar, aVar, str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                SceneBuilder.b(SceneBuilder.this);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements a.InterfaceC8631a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SceneBuilder.this);
            }
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.action.a.InterfaceC8631a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                SceneBuilder.this.f291196e.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface d {
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface e {
        Bitmap a(com.tencent.mobileqq.surfaceviewaction.d dVar, String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface f {
        void a(int i3, String str, Paint paint);

        int b(int i3, int i16, int i17, String str, Paint paint);

        String c(com.tencent.mobileqq.surfaceviewaction.d dVar, String str);

        boolean d(Canvas canvas, String str, float f16, float f17, float f18, int i3, int i16, Paint paint);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface g {
        void a(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface h {
        void a(com.tencent.mobileqq.surfaceviewaction.c cVar);
    }

    public SceneBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f291192a = "";
        }
    }

    static /* bridge */ /* synthetic */ d b(SceneBuilder sceneBuilder) {
        sceneBuilder.getClass();
        return null;
    }

    private com.tencent.mobileqq.surfaceviewaction.action.a h(JSONObject jSONObject) {
        com.tencent.mobileqq.surfaceviewaction.action.a aVar;
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("timeType");
        int optInt = jSONObject.optInt("duration");
        if (optString.equals("sequence")) {
            aVar = new com.tencent.mobileqq.surfaceviewaction.action.h(i(jSONObject.optJSONArray("actions")));
        } else if (optString.equals("delay")) {
            aVar = new com.tencent.mobileqq.surfaceviewaction.action.b(optInt);
        } else if (optString.equals("position")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("from");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("to");
            aVar = new com.tencent.mobileqq.surfaceviewaction.action.d(optInt, (float) optJSONObject.optDouble(HippyTKDListViewAdapter.X), (float) optJSONObject.optDouble("y"), (float) optJSONObject2.optDouble(HippyTKDListViewAdapter.X), (float) optJSONObject2.optDouble("y"));
        } else if (optString.equals("scale")) {
            aVar = new com.tencent.mobileqq.surfaceviewaction.action.g(optInt, (float) jSONObject.optDouble("from", 1.0d), (float) jSONObject.optDouble("to", 1.0d));
        } else if (optString.equals(com.tencent.luggage.wxa.c8.c.f123400v)) {
            aVar = new com.tencent.mobileqq.surfaceviewaction.action.e(optInt, (int) (jSONObject.optDouble("from", 1.0d) * 255.0d), (int) (jSONObject.optDouble("to", 1.0d) * 255.0d));
        } else if (optString.equals(CanvasView.ACTION_ROTATE)) {
            aVar = new com.tencent.mobileqq.surfaceviewaction.action.f(optInt, jSONObject.optInt("from", 0), jSONObject.optInt("to", 0));
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.f291164i = jSONObject.optBoolean("isRepeat");
            if (optString2 != null) {
                if (optString2.equals(CanvasView.ACTION_LINER)) {
                    aVar.f291163h = 0;
                } else if (optString2.equals("easeIn")) {
                    aVar.f291163h = 1;
                } else if (optString2.equals("easeOut")) {
                    aVar.f291163h = 2;
                }
            }
            if (jSONObject.optBoolean("autoClose", false) && this.f291196e != null) {
                aVar.e(new c());
            }
        }
        return aVar;
    }

    private com.tencent.mobileqq.surfaceviewaction.action.a[] i(JSONArray jSONArray) {
        int length = jSONArray.length();
        com.tencent.mobileqq.surfaceviewaction.action.a[] aVarArr = new com.tencent.mobileqq.surfaceviewaction.action.a[length];
        for (int i3 = 0; i3 < length; i3++) {
            aVarArr[i3] = h(jSONArray.optJSONObject(i3));
        }
        return aVarArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.mobileqq.surfaceviewaction.gl.c] */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder$h] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.tencent.mobileqq.surfaceviewaction.e] */
    public void j(final com.tencent.mobileqq.surfaceviewaction.e eVar, String str, final h hVar) {
        com.tencent.mobileqq.surfaceviewaction.nv.b bVar;
        if (eVar instanceof SpriteGLView) {
            bVar = new com.tencent.mobileqq.surfaceviewaction.gl.c((SpriteGLView) eVar);
        } else {
            bVar = new com.tencent.mobileqq.surfaceviewaction.nv.b((SpriteNativeView) eVar);
        }
        if (str == null) {
            hVar.a(bVar);
            return;
        }
        try {
            final JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("size");
            int optInt = optJSONObject.optInt("width");
            int optInt2 = optJSONObject.optInt("height");
            if (optInt == 0) {
                hVar.a(bVar);
                return;
            }
            this.f291195d = this.f291194c / optInt;
            if (this.f291193b) {
                ViewGroup.LayoutParams layoutParams = ((ViewGroup) eVar).getLayoutParams();
                layoutParams.width = this.f291194c;
                layoutParams.height = (int) (optInt2 * this.f291195d);
                ((ViewGroup) eVar).setLayoutParams(layoutParams);
                bVar.u(this.f291195d);
                g gVar = this.f291199h;
                if (gVar != null) {
                    gVar.a(layoutParams.width, layoutParams.height);
                }
            }
            final com.tencent.mobileqq.surfaceviewaction.nv.b bVar2 = bVar;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.surfaceviewaction.builder.a
                @Override // java.lang.Runnable
                public final void run() {
                    SceneBuilder.this.n(jSONObject, eVar, bVar2, hVar);
                }
            }, 16, null, true);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SceneBuilder", 2, "buildFromJson" + QLog.getStackTraceString(e16));
            }
            hVar.a(bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0129  */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder$f] */
    /* JADX WARN: Type inference failed for: r12v16, types: [com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder$e] */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.tencent.mobileqq.surfaceviewaction.d, com.tencent.mobileqq.surfaceviewaction.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.tencent.mobileqq.surfaceviewaction.a k(com.tencent.mobileqq.surfaceviewaction.e eVar, JSONObject jSONObject) {
        int i3;
        com.tencent.mobileqq.surfaceviewaction.d dVar;
        Bitmap bitmap;
        int i16;
        int i17;
        int i18;
        f fVar;
        float f16;
        Bitmap bitmap2;
        int i19;
        String str;
        int i26;
        Paint paint;
        int i27;
        String optString;
        float f17;
        float f18;
        float f19;
        f fVar2;
        float f26;
        Canvas canvas;
        Bitmap bitmap3;
        int i28;
        Paint paint2;
        Paint paint3;
        float f27;
        float f28;
        float f29;
        float f36;
        int i29;
        Bitmap bitmap4;
        Bitmap bitmap5;
        StringBuilder sb5;
        boolean z16 = eVar instanceof SpriteGLView;
        if (z16) {
            i3 = 4;
        } else {
            i3 = 1;
        }
        String optString2 = jSONObject.optString("text");
        if (z16) {
            dVar = new com.tencent.mobileqq.surfaceviewaction.gl.e((SpriteGLView) eVar);
        } else {
            dVar = new com.tencent.mobileqq.surfaceviewaction.nv.d((SpriteNativeView) eVar);
        }
        ?? r75 = dVar;
        float f37 = i3;
        r75.u(1.0f / f37);
        ?? r06 = this.f291197f;
        if (r06 != 0) {
            optString2 = r06.c(r75, optString2);
        }
        int optInt = jSONObject.optInt("textSize", 20) * i3;
        int parseColor = Color.parseColor(jSONObject.optString("textColor"));
        Paint paint4 = new Paint();
        paint4.setAntiAlias(true);
        paint4.setColor(parseColor);
        float f38 = optInt;
        paint4.setTextSize(f38);
        JSONObject optJSONObject = jSONObject.optJSONObject("size");
        int measureText = (int) paint4.measureText(optString2);
        String optString3 = jSONObject.optString("imageRight");
        int optInt2 = jSONObject.optInt("imagePadding") * i3;
        int i36 = measureText;
        int i37 = 0;
        try {
            if (!TextUtils.isEmpty(optString3)) {
                ?? r122 = this.f291198g;
                if (r122 != 0) {
                    bitmap4 = r122.a(r75, this.f291192a, optString3);
                } else {
                    bitmap4 = null;
                }
                if (bitmap4 == null) {
                    try {
                        sb5 = new StringBuilder();
                        bitmap5 = bitmap4;
                    } catch (OutOfMemoryError e16) {
                        e = e16;
                        bitmap5 = bitmap4;
                    }
                    try {
                        sb5.append(this.f291192a);
                        sb5.append("/");
                        sb5.append(optString3);
                        bitmap = BaseImageUtil.decodeFileWithBufferedStream(sb5.toString(), null);
                    } catch (OutOfMemoryError e17) {
                        e = e17;
                        if (QLog.isColorLevel()) {
                            QLog.e("SceneBuilder", 2, "buildLabel" + QLog.getStackTraceString(e));
                            bitmap = bitmap5;
                            if (bitmap != null) {
                            }
                            i16 = 0;
                            i17 = 0;
                            if (optJSONObject == null) {
                            }
                            int i38 = i36;
                            fVar = this.f291197f;
                            if (fVar == null) {
                            }
                            Paint paint5 = paint;
                            if (i37 != 0) {
                            }
                            int i39 = i16 + i27 + i26;
                            Bitmap createBitmap = Bitmap.createBitmap(i38, i19, Bitmap.Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap);
                            canvas2.drawColor(-16777216, PorterDuff.Mode.CLEAR);
                            float f39 = f38 * 0.8f;
                            optString = jSONObject.optString(LayoutAttrDefine.Gravity.Gravity);
                            if (optString == null) {
                            }
                            fVar2 = this.f291197f;
                            if (fVar2 == null) {
                            }
                            float f46 = f18 + f39;
                            paint3 = paint2;
                            canvas.drawText(optString2, f17, f46, paint3);
                            if (bitmap2 != null) {
                            }
                            r75.a(eVar, bitmap3);
                            return r75;
                        }
                        bitmap = bitmap5;
                        if (bitmap != null) {
                        }
                        i16 = 0;
                        i17 = 0;
                        if (optJSONObject == null) {
                        }
                        int i382 = i36;
                        fVar = this.f291197f;
                        if (fVar == null) {
                        }
                        Paint paint52 = paint;
                        if (i37 != 0) {
                        }
                        int i392 = i16 + i27 + i26;
                        Bitmap createBitmap2 = Bitmap.createBitmap(i382, i19, Bitmap.Config.ARGB_8888);
                        Canvas canvas22 = new Canvas(createBitmap2);
                        canvas22.drawColor(-16777216, PorterDuff.Mode.CLEAR);
                        float f392 = f38 * 0.8f;
                        optString = jSONObject.optString(LayoutAttrDefine.Gravity.Gravity);
                        if (optString == null) {
                        }
                        fVar2 = this.f291197f;
                        if (fVar2 == null) {
                        }
                        float f462 = f18 + f392;
                        paint3 = paint2;
                        canvas.drawText(optString2, f17, f462, paint3);
                        if (bitmap2 != null) {
                        }
                        r75.a(eVar, bitmap3);
                        return r75;
                    }
                    if (bitmap != null) {
                        i16 = bitmap.getWidth() * i3;
                        i17 = bitmap.getHeight() * i3;
                        if (optJSONObject == null) {
                            if (optJSONObject.optInt("width") != 0) {
                                i36 = optJSONObject.optInt("width") * i3;
                            }
                            if (optJSONObject.optInt("height") != 0) {
                                i29 = optJSONObject.optInt("height") * i3;
                            } else {
                                i29 = optInt;
                            }
                            f fVar3 = this.f291197f;
                            if (fVar3 != null) {
                                fVar3.a((i36 - i16) - optInt2, optString2, paint4);
                            }
                            optString2 = m((i36 - i16) - optInt2, optString2, paint4);
                            i18 = i29;
                        } else {
                            i18 = optInt;
                        }
                        int i3822 = i36;
                        fVar = this.f291197f;
                        if (fVar == null) {
                            bitmap2 = bitmap;
                            i19 = i18;
                            str = "buildLabel";
                            f16 = f37;
                            i26 = optInt2;
                            paint = paint4;
                            i37 = fVar.b(i3822, i16, optInt2, optString2, paint4);
                        } else {
                            f16 = f37;
                            bitmap2 = bitmap;
                            i19 = i18;
                            str = "buildLabel";
                            i26 = optInt2;
                            paint = paint4;
                        }
                        Paint paint522 = paint;
                        if (i37 != 0) {
                            i27 = (int) paint522.measureText(optString2);
                        } else {
                            i27 = i37;
                        }
                        int i3922 = i16 + i27 + i26;
                        Bitmap createBitmap22 = Bitmap.createBitmap(i3822, i19, Bitmap.Config.ARGB_8888);
                        Canvas canvas222 = new Canvas(createBitmap22);
                        canvas222.drawColor(-16777216, PorterDuff.Mode.CLEAR);
                        float f3922 = f38 * 0.8f;
                        optString = jSONObject.optString(LayoutAttrDefine.Gravity.Gravity);
                        if (optString == null) {
                            if (!optString.contains("left") && optString.contains("right")) {
                                f27 = i3822 - i3922;
                            } else {
                                f27 = 0.0f;
                            }
                            if (!optString.contains("top") && optString.contains("bottom")) {
                                f28 = i19 - optInt;
                                f29 = i19 - i17;
                            } else {
                                f28 = 0.0f;
                                f29 = 0.0f;
                            }
                            if (optString.equals("center")) {
                                f27 = (i3822 - i3922) / 2;
                                f29 = (i19 - i17) / 2;
                                f28 = (i19 - optInt) / 2;
                            }
                            if (optString.contains("center_horizontal")) {
                                f36 = (i3822 - i3922) / 2;
                            } else {
                                f36 = f27;
                            }
                            if (optString.contains("center_vertical")) {
                                float f47 = (i19 - optInt) / 2;
                                f19 = (i19 - i17) / 2;
                                f18 = f47;
                                f17 = f36;
                            } else {
                                f18 = f28;
                                f17 = f36;
                                f19 = f29;
                            }
                        } else {
                            f17 = 0.0f;
                            f18 = 0.0f;
                            f19 = 0.0f;
                        }
                        fVar2 = this.f291197f;
                        if (fVar2 == null) {
                            canvas = canvas222;
                            bitmap3 = createBitmap22;
                            f26 = f19;
                            i28 = i27;
                            paint2 = paint522;
                            if (fVar2.d(canvas222, optString2, f17, f18, f3922, i3822, i19, paint2)) {
                                paint3 = paint2;
                                if (bitmap2 != null) {
                                    Matrix matrix = new Matrix();
                                    float f48 = f16;
                                    matrix.postScale(f48, f48);
                                    matrix.postTranslate(f17 + i26 + i28, f26);
                                    canvas.drawBitmap(bitmap2, matrix, paint3);
                                }
                                r75.a(eVar, bitmap3);
                                return r75;
                            }
                        } else {
                            f26 = f19;
                            canvas = canvas222;
                            bitmap3 = createBitmap22;
                            i28 = i27;
                            paint2 = paint522;
                        }
                        float f4622 = f18 + f3922;
                        paint3 = paint2;
                        canvas.drawText(optString2, f17, f4622, paint3);
                        if (bitmap2 != null) {
                        }
                        r75.a(eVar, bitmap3);
                        return r75;
                    }
                } else {
                    bitmap5 = bitmap4;
                }
                bitmap = bitmap5;
                if (bitmap != null) {
                }
            } else {
                bitmap = null;
            }
            Bitmap createBitmap222 = Bitmap.createBitmap(i3822, i19, Bitmap.Config.ARGB_8888);
            Canvas canvas2222 = new Canvas(createBitmap222);
            canvas2222.drawColor(-16777216, PorterDuff.Mode.CLEAR);
            float f39222 = f38 * 0.8f;
            optString = jSONObject.optString(LayoutAttrDefine.Gravity.Gravity);
            if (optString == null) {
            }
            fVar2 = this.f291197f;
            if (fVar2 == null) {
            }
            float f46222 = f18 + f39222;
            paint3 = paint2;
            canvas.drawText(optString2, f17, f46222, paint3);
            if (bitmap2 != null) {
            }
            r75.a(eVar, bitmap3);
            return r75;
        } catch (OutOfMemoryError e18) {
            if (QLog.isColorLevel()) {
                QLog.e("SceneBuilder", 2, str + QLog.getStackTraceString(e18));
            }
            return r75;
        }
        i16 = 0;
        i17 = 0;
        if (optJSONObject == null) {
        }
        int i38222 = i36;
        fVar = this.f291197f;
        if (fVar == null) {
        }
        Paint paint5222 = paint;
        if (i37 != 0) {
        }
        int i39222 = i16 + i27 + i26;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0097  */
    /* JADX WARN: Type inference failed for: r12v8, types: [com.tencent.mobileqq.surfaceviewaction.gl.a] */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.tencent.mobileqq.surfaceviewaction.c] */
    /* JADX WARN: Type inference failed for: r5v10, types: [com.tencent.mobileqq.surfaceviewaction.nv.d] */
    /* JADX WARN: Type inference failed for: r5v13, types: [com.tencent.mobileqq.surfaceviewaction.gl.e] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.tencent.mobileqq.surfaceviewaction.a l(com.tencent.mobileqq.surfaceviewaction.e eVar, JSONObject jSONObject, com.tencent.mobileqq.surfaceviewaction.c cVar) throws JSONException {
        com.tencent.mobileqq.surfaceviewaction.a aVar;
        com.tencent.mobileqq.surfaceviewaction.nv.a aVar2;
        com.tencent.mobileqq.surfaceviewaction.nv.a aVar3;
        e eVar2;
        Bitmap bitmap;
        String optString = jSONObject.optString("type");
        if ("layer".equals(optString)) {
            if (eVar instanceof SpriteGLView) {
                aVar = new com.tencent.mobileqq.surfaceviewaction.gl.c((SpriteGLView) eVar);
            } else {
                aVar = new com.tencent.mobileqq.surfaceviewaction.nv.b((SpriteNativeView) eVar);
            }
        } else if ("image".equals(optString)) {
            String optString2 = jSONObject.optString("path");
            String optString3 = jSONObject.optString("event");
            if (eVar instanceof SpriteGLView) {
                SpriteGLView spriteGLView = (SpriteGLView) eVar;
                if (TextUtils.isEmpty(optString3)) {
                    aVar3 = new com.tencent.mobileqq.surfaceviewaction.gl.e(spriteGLView);
                    eVar2 = this.f291198g;
                    if (eVar2 == null) {
                        bitmap = eVar2.a(aVar3, this.f291192a, optString2);
                    } else {
                        bitmap = null;
                    }
                    if (bitmap == null) {
                        try {
                            bitmap = BaseImageUtil.decodeFileWithBufferedStream(this.f291192a + "/" + optString2, null);
                        } catch (OutOfMemoryError e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e("SceneBuilder", 2, "buildNode" + QLog.getStackTraceString(e16));
                            }
                        }
                    }
                    if (bitmap != null) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("size");
                        if (optJSONObject != null) {
                            try {
                                bitmap = Bitmap.createScaledBitmap(bitmap, optJSONObject.optInt("width"), optJSONObject.optInt("height"), true);
                            } catch (OutOfMemoryError e17) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("SceneBuilder", 2, "buildNode" + QLog.getStackTraceString(e17));
                                }
                            }
                        }
                        aVar3.a(eVar, bitmap);
                    }
                    aVar = aVar3;
                } else {
                    ?? aVar4 = new com.tencent.mobileqq.surfaceviewaction.gl.a(spriteGLView, true, optString3);
                    aVar4.L(new a(cVar, optString3));
                    aVar2 = aVar4;
                    aVar3 = aVar2;
                    eVar2 = this.f291198g;
                    if (eVar2 == null) {
                    }
                    if (bitmap == null) {
                    }
                    if (bitmap != null) {
                    }
                    aVar = aVar3;
                }
            } else {
                SpriteNativeView spriteNativeView = (SpriteNativeView) eVar;
                if (TextUtils.isEmpty(optString3)) {
                    aVar3 = new com.tencent.mobileqq.surfaceviewaction.nv.d(spriteNativeView);
                    eVar2 = this.f291198g;
                    if (eVar2 == null) {
                    }
                    if (bitmap == null) {
                    }
                    if (bitmap != null) {
                    }
                    aVar = aVar3;
                } else {
                    com.tencent.mobileqq.surfaceviewaction.nv.a aVar5 = new com.tencent.mobileqq.surfaceviewaction.nv.a(spriteNativeView, optString3);
                    aVar5.E(new b(cVar, aVar5, optString3));
                    aVar2 = aVar5;
                    aVar3 = aVar2;
                    eVar2 = this.f291198g;
                    if (eVar2 == null) {
                    }
                    if (bitmap == null) {
                    }
                    if (bitmap != null) {
                    }
                    aVar = aVar3;
                }
            }
        } else if ("video".equals(optString)) {
            if (eVar instanceof SpriteGLView) {
                SpriteGLView spriteGLView2 = (SpriteGLView) eVar;
                VideoSprite videoSprite = new VideoSprite(spriteGLView2, spriteGLView2.getContext(), true);
                videoSprite.T(this.f291192a + "/" + jSONObject.optString("path"));
                if (jSONObject.optBoolean("isKey", false)) {
                    spriteGLView2.setVideoTimeGetter(videoSprite);
                }
                if (jSONObject.optBoolean("autoClose", false)) {
                    videoSprite.X(this.f291196e);
                }
                videoSprite.W(jSONObject.optBoolean("isLooping", false));
                aVar = videoSprite;
            } else {
                String str = this.f291192a + "/" + jSONObject.optString("path");
                com.tencent.mobileqq.surfaceviewaction.nv.e eVar3 = new com.tencent.mobileqq.surfaceviewaction.nv.e((SpriteNativeView) eVar, str);
                eVar3.C(str, jSONObject.optBoolean("isLooping", false));
                aVar = eVar3;
            }
        } else if ("label".equals(optString)) {
            aVar = k(eVar, jSONObject);
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        aVar.r(jSONObject.optString("name"));
        aVar.w(jSONObject.optInt("tag"));
        aVar.y((float) jSONObject.optDouble(HippyTKDListViewAdapter.X, 0.0d));
        aVar.z((float) jSONObject.optDouble("y", 0.0d));
        aVar.s((int) (jSONObject.optDouble(com.tencent.luggage.wxa.c8.c.f123400v, 1.0d) * 255.0d));
        aVar.u(aVar.i() * ((float) jSONObject.optDouble("scale", 1.0d)));
        aVar.t((float) jSONObject.optDouble(CanvasView.ACTION_ROTATE, 0.0d));
        aVar.v(((com.tencent.mobileqq.surfaceviewaction.a) cVar).i());
        JSONArray optJSONArray = jSONObject.optJSONArray("actions");
        if (optJSONArray != null) {
            aVar.o(i(optJSONArray));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("frames");
        if (optJSONObject2 != null) {
            com.tencent.mobileqq.surfaceviewaction.b bVar = new com.tencent.mobileqq.surfaceviewaction.b();
            bVar.f291188a = optJSONObject2.optInt("fps");
            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("datas");
            int length = optJSONArray2.length();
            bVar.f291189b = new b.a[length];
            for (int i3 = 0; i3 < length; i3++) {
                bVar.f291189b[i3] = new b.a();
                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                bVar.f291189b[i3].f291190a = optJSONObject3.optInt(HippyTKDListViewAdapter.X);
                bVar.f291189b[i3].f291191b = optJSONObject3.optInt("y");
            }
            aVar.p(bVar);
        }
        String optString4 = jSONObject.optString("horizontal_align");
        if (optString4 != null) {
            if (optString4.equals("left")) {
                aVar.q(0);
            } else if (optString4.equals("right")) {
                aVar.q(1);
            } else if (optString4.equals("center")) {
                aVar.q(2);
            }
        }
        String optString5 = jSONObject.optString("vertical_align");
        if (optString5 != null) {
            if (optString5.equals("top")) {
                aVar.x(0);
            } else if (optString5.equals("bottom")) {
                aVar.x(1);
            } else if (optString5.equals("center")) {
                aVar.x(2);
            }
        }
        if (aVar instanceof com.tencent.mobileqq.surfaceviewaction.c) {
            com.tencent.mobileqq.surfaceviewaction.c cVar2 = (com.tencent.mobileqq.surfaceviewaction.c) aVar;
            JSONArray optJSONArray3 = jSONObject.optJSONArray(Node.CHILDREN_ATTR);
            int length2 = optJSONArray3.length();
            for (int i16 = 0; i16 < length2; i16++) {
                com.tencent.mobileqq.surfaceviewaction.a l3 = l(eVar, optJSONArray3.getJSONObject(i16), cVar);
                if (l3 != null) {
                    cVar2.b(l3);
                }
            }
        }
        return aVar;
    }

    public static String m(int i3, String str, Paint paint) {
        if (i3 <= 0) {
            return str;
        }
        float measureText = paint.measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX);
        if (((int) Math.ceil(paint.measureText(str))) <= i3) {
            return str;
        }
        for (int length = str.length() - 1; length > 0; length--) {
            if (((int) Math.ceil(paint.measureText(str, 0, length) + measureText)) <= i3) {
                return str.substring(0, length) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(JSONObject jSONObject, com.tencent.mobileqq.surfaceviewaction.e eVar, com.tencent.mobileqq.surfaceviewaction.c cVar, h hVar) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("scene");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    com.tencent.mobileqq.surfaceviewaction.a l3 = l(eVar, optJSONArray.getJSONObject(i3), cVar);
                    if (l3 != null) {
                        cVar.b(l3);
                    }
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SceneBuilder", 2, "buildFromJson" + QLog.getStackTraceString(e16));
            }
        }
        hVar.a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String o(String str) {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(new File(str)));
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    StringBuilder sb5 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb5.append(readLine);
                            sb5.append('\n');
                        } else {
                            bufferedReader.close();
                            inputStreamReader.close();
                            return sb5.toString();
                        }
                    }
                } catch (Exception e16) {
                    e = e16;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Exception e19) {
                e = e19;
                bufferedReader = null;
            }
        } catch (Exception e26) {
            e = e26;
            bufferedReader = null;
            inputStreamReader = null;
        }
    }

    public void g(com.tencent.mobileqq.surfaceviewaction.e eVar, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) eVar, (Object) hVar);
        } else {
            ThreadManagerV2.post(new Runnable(eVar, hVar) { // from class: com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.surfaceviewaction.e f291200d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ h f291201e;

                {
                    this.f291200d = eVar;
                    this.f291201e = hVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SceneBuilder.this, eVar, hVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable(SceneBuilder.o(SceneBuilder.this.f291192a + "/scene.json")) { // from class: com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f291202d;

                        {
                            this.f291202d = r5;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) r5);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                SceneBuilder.this.j(anonymousClass1.f291200d, this.f291202d, anonymousClass1.f291201e);
                            }
                        }
                    });
                }
            }, 8, null, true);
        }
    }

    public SceneBuilder p(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SceneBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        this.f291192a = str;
        return this;
    }

    public SceneBuilder q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SceneBuilder) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        this.f291193b = true;
        this.f291194c = i3;
        return this;
    }

    public SceneBuilder r(FrameSprite.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SceneBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        }
        this.f291196e = aVar;
        return this;
    }

    public SceneBuilder s(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SceneBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) eVar);
        }
        this.f291198g = eVar;
        return this;
    }

    public SceneBuilder t(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SceneBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) fVar);
        }
        this.f291197f = fVar;
        return this;
    }

    public SceneBuilder u(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SceneBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) gVar);
        }
        this.f291199h = gVar;
        return this;
    }
}
