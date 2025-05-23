package l04;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final m04.b f413609a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, p04.a> f413610b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private LinkedList<n04.b> f413611c = new LinkedList<>();

    public b(m04.b bVar) {
        this.f413609a = bVar;
    }

    private void b(List<n04.b> list, String str, String str2, View view, n04.a aVar) {
        if (aVar != null && this.f413609a.a(aVar.f417929b, aVar.f417930c, view.getWidth(), view.getHeight()).booleanValue()) {
            n04.b bVar = new n04.b(str, d(view), e(view), str2, view.getWidth(), view.getHeight(), aVar.f417929b, aVar.f417930c, aVar.f417928a, aVar.f417931d, aVar.f417932e, System.currentTimeMillis());
            if (!this.f413611c.isEmpty()) {
                Iterator<n04.b> it = this.f413611c.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(bVar)) {
                        Logger.f365497g.i("RMonitor_BigBitmap_Detector", "has reported, history's size = " + this.f413611c.size());
                        return;
                    }
                }
            }
            list.add(bVar);
            this.f413611c.addFirst(bVar);
            while (this.f413611c.size() > 500) {
                this.f413611c.removeLast();
            }
        }
    }

    private String d(View view) {
        String a16 = com.tencent.rmonitor.common.util.c.a(view, null);
        String str = "NO_ID";
        try {
            if (view.getId() != -1) {
                str = view.getResources().getResourceName(view.getId());
            }
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_BigBitmap_Detector", th5);
        }
        return a16 + "(id/" + str + ")";
    }

    private String e(View view) {
        String a16 = com.tencent.rmonitor.common.util.c.a(view, null);
        String str = "NO_TAG";
        try {
            Object tag = view.getTag();
            if (tag != null) {
                str = tag.toString();
            }
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_BigBitmap_Detector", th5);
        }
        return a16 + "(tag/" + str + ")";
    }

    public void a(p04.a aVar) {
        if (!this.f413610b.containsKey(aVar.c())) {
            this.f413610b.put(aVar.c(), aVar);
        }
    }

    public void c(List<n04.b> list, String str, String str2, View view) {
        Drawable drawable;
        Drawable background = view.getBackground();
        if (view instanceof ImageView) {
            drawable = ((ImageView) view).getDrawable();
        } else {
            drawable = null;
        }
        Drawable drawable2 = drawable;
        for (p04.a aVar : this.f413610b.values()) {
            b(list, str, str2, view, aVar.a(background));
            b(list, str, str2, view, aVar.b(drawable2));
        }
    }
}
