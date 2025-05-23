package com.tencent.mobileqq.qui.immersive.color;

import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qui.immersive.color.IColorFetcher;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final List<IColorFetcher> f276888a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50624);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f276888a = arrayList;
        arrayList.add(new b());
        arrayList.add(new e());
        arrayList.add(new g());
        arrayList.add(new k());
        if (com.tencent.mobileqq.immersive.a.c()) {
            arrayList.add(new j());
        }
        arrayList.add(new d());
        arrayList.add(new i());
        arrayList.add(new h());
    }

    public static synchronized void a(IColorFetcher iColorFetcher) {
        synchronized (f.class) {
            Iterator<IColorFetcher> it = f276888a.iterator();
            while (it.hasNext()) {
                if (it.next().getClass() == iColorFetcher.getClass()) {
                    return;
                }
            }
            f276888a.add(iColorFetcher);
        }
    }

    public static synchronized IColorFetcher b(View view) {
        synchronized (f.class) {
            for (IColorFetcher iColorFetcher : f276888a) {
                if (iColorFetcher.canHandle(view)) {
                    return iColorFetcher;
                }
            }
            return null;
        }
    }

    public static synchronized Pair<Boolean, Integer> c(@NonNull Drawable drawable, IColorFetcher.Area area) {
        synchronized (f.class) {
            for (IColorFetcher iColorFetcher : f276888a) {
                if (iColorFetcher.canHandle(drawable)) {
                    return iColorFetcher.getColor(drawable, area);
                }
            }
            QLog.e("QUIImmersiveHelper", 1, "no colorFetcher can handle drawable " + drawable);
            return new Pair<>(Boolean.FALSE, 0);
        }
    }
}
