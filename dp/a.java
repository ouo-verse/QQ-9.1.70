package dp;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<Rect> f394509a;

    /* renamed from: b, reason: collision with root package name */
    private int f394510b;

    /* renamed from: d, reason: collision with root package name */
    private Path f394512d;

    /* renamed from: c, reason: collision with root package name */
    private Paint f394511c = new Paint(1);

    /* renamed from: e, reason: collision with root package name */
    private boolean f394513e = false;

    public a(int i3) {
        this.f394510b = SupportMenu.CATEGORY_MASK;
        this.f394510b = i3;
    }

    private void b() {
        if (this.f394509a != null) {
            Region region = new Region();
            Iterator<Rect> it = this.f394509a.iterator();
            while (it.hasNext()) {
                region.op(it.next(), Region.Op.UNION);
            }
            this.f394512d = region.getBoundaryPath();
        } else {
            this.f394512d = new Path();
        }
        this.f394513e = true;
        this.f394511c.setColor(this.f394510b);
    }

    public void a(Rect rect) {
        if (this.f394509a == null) {
            this.f394509a = new ArrayList<>();
        }
        this.f394509a.add(new Rect(rect));
        this.f394513e = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.f394513e) {
            b();
        }
        canvas.drawPath(this.f394512d, this.f394511c);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
