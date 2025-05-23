package com.tencent.mobileqq.bubble;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import com.tencent.upload.uinterface.data.UppUploadTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    static int f200745e;

    /* renamed from: a, reason: collision with root package name */
    public String f200746a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f200747b;

    /* renamed from: c, reason: collision with root package name */
    public int f200748c;

    /* renamed from: d, reason: collision with root package name */
    public String f200749d;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static final class a extends g {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        public int f200750f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f200751g;

        /* renamed from: h, reason: collision with root package name */
        public String f200752h;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f200750f = 0;
            this.f200751g = true;
            this.f200752h = "";
        }

        private int i(h hVar, Rect rect, int i3, int i16, int i17) {
            if (this.f200746a.endsWith("L")) {
                i17 = this.f200747b[0] + i16;
            } else if (this.f200746a.endsWith(BdhLogUtil.LogTag.Tag_Req)) {
                int[] iArr = this.f200747b;
                i17 = (((iArr[0] + iArr[2]) + rect.width()) - i3) - i16;
            }
            if (hVar.f200765g && !this.f200751g) {
                return (rect.width() - i17) - i3;
            }
            return i17;
        }

        public static g j(JSONObject jSONObject) {
            String optString = jSONObject.optString("type");
            if (!"diy_chartlet".equalsIgnoreCase(optString) && !"static".equalsIgnoreCase(optString)) {
                QLog.e("DiyBubbleConfig", 1, "error! paster type: " + optString);
                return null;
            }
            a aVar = new a();
            aVar.f200749d = optString;
            Context applicationContext = BaseApplicationImpl.getApplication().getApplicationContext();
            aVar.f200746a = jSONObject.optString("align").toUpperCase();
            if (jSONObject.has(CanvasView.ACTION_RECT)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(CanvasView.ACTION_RECT);
                aVar.f200747b = new int[4];
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    aVar.f200747b[i3] = x.c(applicationContext, optJSONArray.optInt(i3) / 2);
                }
            }
            aVar.f200751g = jSONObject.optBoolean("mirror", true);
            if (QLog.isColorLevel()) {
                QLog.d("DiyBubbleConfig", 2, "Resolve DiyBubblePasterConfig json->" + jSONObject);
            }
            return aVar;
        }

        @Override // com.tencent.mobileqq.bubble.g
        public void c(h hVar, Canvas canvas) {
            Bitmap bitmap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) hVar, (Object) canvas);
                return;
            }
            if (canvas != null && hVar != null) {
                if ("diy_chartlet".equalsIgnoreCase(this.f200749d)) {
                    bitmap = BubbleDiyFetcher.m().j(hVar, this);
                } else if ("static".equalsIgnoreCase(this.f200749d)) {
                    bitmap = BubbleDiyFetcher.m().l(hVar, this);
                } else {
                    bitmap = null;
                }
                if (bitmap == null) {
                    return;
                }
                int save = canvas.save();
                if (hVar.f200765g && this.f200751g) {
                    canvas.scale(-1.0f, 1.0f, hVar.getBounds().centerX(), hVar.getBounds().centerY());
                }
                Paint paint = new Paint();
                Rect h16 = h(hVar, canvas);
                if (canvas.getHeight() < g.f200745e) {
                    canvas.drawBitmap(bitmap, (Rect) null, h16, paint);
                } else {
                    canvas.drawBitmap(bitmap, h16.left, h16.top, paint);
                }
                canvas.restoreToCount(save);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0099  */
        @TargetApi(11)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Rect h(h hVar, Canvas canvas) {
            int i3;
            int i16;
            int i17;
            int i18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Rect) iPatchRedirector.redirect((short) 3, (Object) this, (Object) hVar, (Object) canvas);
            }
            Rect bounds = hVar.getBounds();
            Resources resources = BaseApplication.getContext().getResources();
            if (g.f200745e == -1) {
                g.f200745e = BaseAIOUtils.f(48.0f, resources);
            }
            int[] iArr = this.f200747b;
            int i19 = iArr[3];
            int i26 = iArr[2];
            int i27 = 0;
            if (bounds.height() >= g.f200745e) {
                BaseAIOUtils.f(10.0f, resources);
                BaseAIOUtils.f(9.0f, resources);
            } else {
                int f16 = BaseAIOUtils.f(10.0f, resources);
                int f17 = BaseAIOUtils.f(7.0f, resources);
                if ("static".equalsIgnoreCase(this.f200749d)) {
                    i16 = -BaseAIOUtils.f(2.0f, resources);
                    i18 = i26;
                    i3 = i19;
                    i17 = 0;
                } else {
                    int i28 = f17 * 2;
                    if (i19 > i28) {
                        int[] iArr2 = this.f200747b;
                        int i29 = (iArr2[2] * i28) / iArr2[3];
                        if (i29 < f16 * 2) {
                            i17 = f16 - (i29 / 2);
                            i3 = i28;
                            i16 = 0;
                        } else {
                            i3 = i28;
                            i16 = 0;
                            i17 = 0;
                        }
                        i18 = i29;
                    }
                }
                if (!this.f200746a.startsWith("T")) {
                    i27 = this.f200747b[1] + i16;
                } else if (this.f200746a.startsWith("B")) {
                    int[] iArr3 = this.f200747b;
                    i27 = (((iArr3[1] + iArr3[3]) + bounds.height()) - i3) - i16;
                }
                int i36 = i(hVar, bounds, i18, i17, 0);
                return new Rect(i36, i27, i18 + i36, i3 + i27);
            }
            i18 = i26;
            i3 = i19;
            i16 = 0;
            i17 = 0;
            if (!this.f200746a.startsWith("T")) {
            }
            int i362 = i(hVar, bounds, i18, i17, 0);
            return new Rect(i362, i27, i18 + i362, i3 + i27);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static final class b extends g {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        public int f200753f;

        /* renamed from: g, reason: collision with root package name */
        public int f200754g;

        /* renamed from: h, reason: collision with root package name */
        public String f200755h;

        /* renamed from: i, reason: collision with root package name */
        public int f200756i;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f200753f = -1;
            }
        }

        public static g i(JSONObject jSONObject) {
            b bVar = new b();
            Context applicationContext = BaseApplicationImpl.getApplication().getApplicationContext();
            bVar.f200746a = jSONObject.optString("align");
            bVar.f200754g = x.j(applicationContext, jSONObject.optInt("text_size") / 2) + 1;
            bVar.f200755h = jSONObject.optString("text_align");
            String optString = jSONObject.optString("text_color");
            if (optString.startsWith(RelationNTPushServiceImpl.PRE_HEX_STRING)) {
                optString = optString.substring(2);
            }
            try {
                bVar.f200753f = Color.parseColor("#" + optString);
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("DiyBubbleConfig", 2, "diy text_color invalid");
                }
            }
            if (jSONObject.has(CanvasView.ACTION_RECT)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(CanvasView.ACTION_RECT);
                bVar.f200747b = new int[4];
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    bVar.f200747b[i3] = x.c(applicationContext, optJSONArray.optInt(i3) / 2);
                }
            }
            bVar.f200756i = jSONObject.optInt("text_max_count");
            if (QLog.isColorLevel()) {
                QLog.d("DiyBubbleConfig", 2, "Resolve DiyBubbleTextConfig json->" + jSONObject);
            }
            return bVar;
        }

        @Override // com.tencent.mobileqq.bubble.g
        public void c(h hVar, Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) hVar, (Object) canvas);
                return;
            }
            if (canvas != null && hVar != null) {
                String k3 = BubbleDiyFetcher.m().k(hVar, hVar.f200769k);
                if (!TextUtils.isEmpty(k3) && !TextUtils.isEmpty(this.f200746a)) {
                    Paint paint = new Paint();
                    int i3 = this.f200753f;
                    if (i3 != -1) {
                        paint.setColor(i3);
                    }
                    Rect h16 = h(hVar, canvas, paint);
                    canvas.drawText(k3, h16.left, h16.top, paint);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00cb  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0104  */
        @TargetApi(11)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Rect h(h hVar, Canvas canvas, Paint paint) {
            float f16;
            int i3;
            float f17;
            int width;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Rect) iPatchRedirector.redirect((short) 3, this, hVar, canvas, paint);
            }
            Rect bounds = hVar.getBounds();
            Resources resources = BaseApplication.getContext().getResources();
            if (g.f200745e == -1) {
                g.f200745e = BaseAIOUtils.f(48.0f, resources);
            }
            float f18 = this.f200747b[3];
            float f19 = 1.0f;
            if (bounds.height() < g.f200745e) {
                i3 = BaseAIOUtils.f(2.0f, resources);
                int f26 = BaseAIOUtils.f(9.0f, resources);
                f19 = ((bounds.height() - (BaseAIOUtils.f(7.0f, resources) * 2)) * 1.0f) / (g.f200745e - (f26 * 2));
                f16 = this.f200747b[3] * f19;
            } else {
                f16 = f18;
                i3 = 0;
            }
            float f27 = 0.0f;
            if (this.f200746a.startsWith("T")) {
                f17 = this.f200747b[1] - i3;
            } else if (this.f200746a.startsWith("B")) {
                int[] iArr = this.f200747b;
                f17 = (((iArr[1] + iArr[3]) + bounds.height()) - f16) + i3;
            } else {
                f17 = 0.0f;
            }
            if (this.f200746a.endsWith("L")) {
                width = this.f200747b[0];
            } else {
                if (this.f200746a.endsWith(BdhLogUtil.LogTag.Tag_Req)) {
                    width = this.f200747b[0] + bounds.width();
                }
                int i17 = this.f200747b[2];
                i16 = this.f200754g;
                if (i16 != 0) {
                    paint.setTextSize(i16 * f19);
                }
                paint.setAntiAlias(true);
                paint.setFakeBoldText(true);
                String k3 = BubbleDiyFetcher.m().k(hVar, hVar.f200769k);
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                float e16 = g.e(paint, k3);
                float f28 = fontMetrics.bottom;
                float f29 = fontMetrics.top;
                float f36 = ((f17 + (f16 / 2.0f)) - ((f28 - f29) / 2.0f)) - f29;
                if (!this.f200755h.equals("center")) {
                    f27 += (i17 - e16) / 2.0f;
                } else if (this.f200755h.equals("right")) {
                    f27 = (f27 + i17) - e16;
                }
                return g.d(hVar, bounds, f16, f27, f36, i17, e16);
            }
            f27 = width;
            int i172 = this.f200747b[2];
            i16 = this.f200754g;
            if (i16 != 0) {
            }
            paint.setAntiAlias(true);
            paint.setFakeBoldText(true);
            String k36 = BubbleDiyFetcher.m().k(hVar, hVar.f200769k);
            Paint.FontMetrics fontMetrics2 = paint.getFontMetrics();
            float e162 = g.e(paint, k36);
            float f282 = fontMetrics2.bottom;
            float f292 = fontMetrics2.top;
            float f362 = ((f17 + (f16 / 2.0f)) - ((f282 - f292) / 2.0f)) - f292;
            if (!this.f200755h.equals("center")) {
            }
            return g.d(hVar, bounds, f16, f27, f362, i172, e162);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71044);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f200745e = -1;
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f200749d = "diy_chartlet";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public static Rect d(h hVar, Rect rect, float f16, float f17, float f18, int i3, float f19) {
        if (hVar.f200765g) {
            float width = (rect.width() - f17) - f19;
            return new Rect((int) width, (int) f18, (int) (width + i3), (int) (f18 + f16));
        }
        return new Rect((int) f17, (int) f18, (int) (f17 + i3), (int) (f18 + f16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float e(Paint paint, String str) {
        if (!TextUtils.isEmpty(str) && paint != null) {
            return paint.measureText(str);
        }
        return 0.0f;
    }

    private static void f(JSONObject jSONObject, List<String> list) {
        if (jSONObject.has("chartlet_animation")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("chartlet_animation");
            if (optJSONObject.has("animation_set")) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("animation_set");
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    list.add(optJSONArray.optString(i3));
                }
            }
        }
    }

    public static HashMap<String, g> g(int i3, JSONObject jSONObject) {
        HashMap<String, g> hashMap;
        g j3;
        String str;
        ArrayList arrayList = new ArrayList();
        f(jSONObject, arrayList);
        if (jSONObject.has("diy_animation")) {
            arrayList.add(jSONObject.optJSONObject("diy_animation").optString(UppUploadTask.sfUppAppId));
        }
        if (jSONObject.has("animation_sets")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("animation_sets");
            hashMap = new HashMap<>(4);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject((String) it.next());
                if (optJSONObject2 != null) {
                    if (optJSONObject2.has("text_size")) {
                        j3 = b.i(optJSONObject2);
                    } else {
                        j3 = a.j(optJSONObject2);
                        ReportInfo value2 = VasCommonReporter.getHistoryFeature().setValue1("bubble").setValue2(String.valueOf(i3));
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("diy_animation_");
                        if (j3 != null) {
                            str = j3.f200749d;
                        } else {
                            str = "null";
                        }
                        sb5.append(str);
                        value2.setValue3(sb5.toString()).report();
                    }
                    if (j3 != null) {
                        j3.f200748c = i3;
                        hashMap.put(j3.f200746a, j3);
                    }
                }
            }
        } else {
            hashMap = null;
        }
        if (hashMap != null && hashMap.size() > 0) {
            BubbleDiyFetcher.m().f200571i.put(Integer.valueOf(i3), hashMap);
        }
        return hashMap;
    }

    public void c(h hVar, Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) hVar, (Object) canvas);
        }
    }
}
