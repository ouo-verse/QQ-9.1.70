package ir;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends i {

    /* renamed from: i, reason: collision with root package name */
    private String f408249i;

    /* renamed from: j, reason: collision with root package name */
    private Bitmap f408250j;

    /* renamed from: k, reason: collision with root package name */
    private int f408251k;

    /* renamed from: l, reason: collision with root package name */
    private int f408252l;

    /* renamed from: m, reason: collision with root package name */
    private int f408253m;

    /* renamed from: n, reason: collision with root package name */
    private int f408254n;

    /* renamed from: o, reason: collision with root package name */
    private int f408255o;

    /* renamed from: p, reason: collision with root package name */
    private Rect f408256p;

    /* renamed from: q, reason: collision with root package name */
    private Rect f408257q;

    /* renamed from: r, reason: collision with root package name */
    private Paint f408258r;

    public c(Context context, String str) {
        super(context, str);
        this.f408257q = new Rect();
        k(str);
        m();
        b();
    }

    public static String l(int i3, String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i3);
            jSONObject.put("city_bitmap_path", str);
            str2 = jSONObject.toString();
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("CityStickerDrawable", 2, e16, new Object[0]);
            }
            str2 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CityStickerDrawable", 2, str2);
        }
        return str2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f408255o;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f408254n;
    }

    @Override // ir.i
    protected void j(Canvas canvas, ArrayList<Integer> arrayList) {
        int i3;
        if (this.f408250j != null) {
            int i16 = this.f408255o;
            int i17 = 225;
            if (arrayList != null) {
                try {
                    i3 = arrayList.get(this.f408251k).intValue();
                    try {
                        i17 = arrayList.get(this.f408252l).intValue();
                        i16 = arrayList.get(this.f408253m).intValue();
                    } catch (RuntimeException e16) {
                        e = e16;
                        QLog.e("CityStickerDrawable", 1, e, new Object[0]);
                        this.f408258r.setAlpha(i17);
                        canvas.save();
                        this.f408257q.set(this.f408256p);
                        this.f408257q.offset(0, i3);
                        canvas.clipRect(0, 0, this.f408254n, i16);
                        canvas.drawBitmap(this.f408250j, (Rect) null, this.f408257q, this.f408258r);
                        canvas.restore();
                    }
                } catch (RuntimeException e17) {
                    e = e17;
                    i3 = 0;
                }
            } else {
                i3 = 0;
            }
            this.f408258r.setAlpha(i17);
            canvas.save();
            this.f408257q.set(this.f408256p);
            this.f408257q.offset(0, i3);
            canvas.clipRect(0, 0, this.f408254n, i16);
            canvas.drawBitmap(this.f408250j, (Rect) null, this.f408257q, this.f408258r);
            canvas.restore();
        }
    }

    protected void m() {
        if (this.f408249i == null || !new File(this.f408249i).exists()) {
            return;
        }
        this.f408250j = BitmapFactory.decodeFile(this.f408249i);
        this.f408258r = new Paint(1);
        int c16 = i.c(this.f408250j.getWidth() / 3.0f, this.f408325c.getResources());
        int c17 = i.c(this.f408250j.getHeight() / 3.0f, this.f408325c.getResources());
        this.f408254n = c16;
        this.f408255o = c17;
        this.f408256p = new Rect(0, 0, c16, c17);
        this.f408251k = this.f408323a.a("offsetY", 0L, 500L, -i.c(15.0f, this.f408325c.getResources()), 0, new LinearInterpolator());
        this.f408252l = this.f408323a.a(com.tencent.luggage.wxa.c8.c.f123400v, 0L, 500L, 0, 255, new LinearInterpolator());
        this.f408253m = this.f408323a.a("height", 0L, 500L, 0, this.f408255o, new LinearInterpolator());
    }

    @Override // ir.i
    public String[] k(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e16) {
            QLog.e("CityStickerDrawable", 1, e16, new Object[0]);
            jSONObject = null;
        }
        if (jSONObject != null) {
            this.f408327e = jSONObject.optInt("type", 0);
            this.f408249i = jSONObject.optString("city_bitmap_path");
        }
        return new String[]{this.f408249i};
    }
}
