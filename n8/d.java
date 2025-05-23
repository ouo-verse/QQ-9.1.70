package n8;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static Paint f419486a;

    /* renamed from: b, reason: collision with root package name */
    public static Rect f419487b;

    /* renamed from: c, reason: collision with root package name */
    private static final SimpleDateFormat f419488c = new SimpleDateFormat("yy\u5e74M\u6708d\u65e5 hh:mm:ss");

    /* renamed from: d, reason: collision with root package name */
    private static final Date f419489d = new Date();

    /* renamed from: e, reason: collision with root package name */
    private static final StringBuilder f419490e;

    /* renamed from: f, reason: collision with root package name */
    private static final Formatter f419491f;

    static {
        StringBuilder sb5 = new StringBuilder();
        f419490e = sb5;
        f419491f = new Formatter(sb5, Locale.getDefault());
        Paint paint = new Paint();
        f419486a = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        f419487b = new Rect();
    }

    public static void a(Canvas canvas) {
        b(canvas);
    }

    public static void b(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }
}
