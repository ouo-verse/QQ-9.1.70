package be0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import ce0.e;
import com.tencent.biz.qui.quitoken.QUITokenConstants;
import de0.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import ud0.d;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements QUITokenConstants {

    /* renamed from: f, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f28300f = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<WeakReference<View>> f28301a;

    /* renamed from: b, reason: collision with root package name */
    private final String f28302b;

    /* renamed from: c, reason: collision with root package name */
    private ae0.a f28303c;

    /* renamed from: d, reason: collision with root package name */
    private e f28304d;

    /* renamed from: e, reason: collision with root package name */
    private ce0.a f28305e;

    a(String str) {
        this.f28302b = str;
    }

    public static a b(String str) {
        a aVar;
        ConcurrentHashMap<String, a> concurrentHashMap = f28300f;
        a aVar2 = concurrentHashMap.get(str);
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (a.class) {
            aVar = concurrentHashMap.get(str);
            if (aVar == null) {
                aVar = new a(str);
                concurrentHashMap.put(str, aVar);
            }
        }
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f(View view) {
        if (view instanceof b) {
            ((b) view).x();
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                f(viewGroup.getChildAt(i3));
            }
        }
    }

    public void a() {
        c(null);
    }

    public void c(ae0.a aVar) {
        View view;
        d.g("QUIProfileSkin", d.f438811e, "setCustomColorPalette profileId:" + this.f28302b + " colorPalette:" + aVar);
        if (this.f28303c == aVar) {
            return;
        }
        this.f28303c = aVar;
        if (aVar != null) {
            ce0.a aVar2 = new ce0.a(aVar);
            this.f28305e = aVar2;
            this.f28304d = new e(aVar2, aVar);
        } else {
            this.f28305e = null;
            this.f28304d = null;
        }
        ArrayList<WeakReference<View>> arrayList = this.f28301a;
        if (arrayList != null) {
            Iterator<WeakReference<View>> it = arrayList.iterator();
            while (it.hasNext()) {
                WeakReference<View> next = it.next();
                if (next != null) {
                    view = next.get();
                } else {
                    view = null;
                }
                if (view != null) {
                    f(view);
                }
            }
        }
    }

    public ColorStateList d(ColorStateList colorStateList) {
        ce0.a aVar = this.f28305e;
        if (aVar != null) {
            return aVar.d(colorStateList);
        }
        return colorStateList;
    }

    public Drawable e(Context context, Drawable drawable) {
        e eVar = this.f28304d;
        if (eVar != null) {
            return eVar.g(context, drawable);
        }
        return drawable;
    }
}
