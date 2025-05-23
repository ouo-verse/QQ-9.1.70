package com.tencent.relation.common.widget.banner.util;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.relation.common.widget.banner.Banner;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b extends LinearLayoutManager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Banner f364853d;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends LinearSmoothScroller {
        static IPatchRedirector $redirector_;

        a(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) context);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForDeceleration(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
            }
            return b.this.f364853d.r();
        }
    }

    public b(Banner banner, LinearLayoutManager linearLayoutManager) {
        super(banner.getContext(), linearLayoutManager.getOrientation(), false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) banner, (Object) linearLayoutManager);
        } else {
            this.f364853d = banner;
        }
    }

    public static void r(Banner banner) {
        if (banner.r() < 100) {
            return;
        }
        try {
            ViewPager2 s16 = banner.s();
            RecyclerView recyclerView = (RecyclerView) s16.getChildAt(0);
            recyclerView.setOverScrollMode(2);
            b bVar = new b(banner, (LinearLayoutManager) recyclerView.getLayoutManager());
            recyclerView.setLayoutManager(bVar);
            Field declaredField = ViewPager2.class.getDeclaredField("mLayoutManager");
            declaredField.setAccessible(true);
            declaredField.set(s16, bVar);
            Field declaredField2 = ViewPager2.class.getDeclaredField("mPageTransformerAdapter");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(s16);
            if (obj != null) {
                Field declaredField3 = obj.getClass().getDeclaredField("mLayoutManager");
                declaredField3.setAccessible(true);
                declaredField3.set(obj, bVar);
            }
            Field declaredField4 = ViewPager2.class.getDeclaredField("mScrollEventAdapter");
            declaredField4.setAccessible(true);
            Object obj2 = declaredField4.get(s16);
            if (obj2 != null) {
                Field declaredField5 = obj2.getClass().getDeclaredField("mLayoutManager");
                declaredField5.setAccessible(true);
                declaredField5.set(obj2, bVar);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, recyclerView, state, Integer.valueOf(i3));
            return;
        }
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i3);
        startSmoothScroll(aVar);
    }
}
