package com.tencent.biz.qqcircle.immersive.utils;

import android.view.ViewParent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes4.dex */
public class u {
    @Nullable
    private static com.tencent.biz.qqcircle.immersive.views.z a(ViewPager2 viewPager2) {
        if (viewPager2 == null) {
            return null;
        }
        try {
            Field declaredField = ViewPager2.class.getDeclaredField("mPagerSnapHelper");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(viewPager2);
            if (!(obj instanceof com.tencent.biz.qqcircle.immersive.views.z)) {
                return null;
            }
            return (com.tencent.biz.qqcircle.immersive.views.z) obj;
        } catch (Throwable th5) {
            QLog.e("QFSDisableFastScrollUtils", 1, "[getPagerSnapHelper] error: ", th5);
            return null;
        }
    }

    @Nullable
    private static ViewPager2 b(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return null;
        }
        ViewParent parent = recyclerView.getParent();
        if (!(parent instanceof ViewPager2)) {
            return null;
        }
        return (ViewPager2) parent;
    }

    public static void c(RecyclerView recyclerView) {
        ViewPager2 b16 = b(recyclerView);
        if (b16 == null) {
            QLog.e("QFSDisableFastScrollUtils", 1, "[updateAutoNextDisableFastScroll] view pager should not be null.");
            return;
        }
        com.tencent.biz.qqcircle.immersive.views.z a16 = a(b16);
        if (a16 == null) {
            QLog.e("QFSDisableFastScrollUtils", 1, "[updateAutoNextDisableFastScroll] pager turn snap helper should not be null.");
        } else if (uq3.c.R6()) {
            QLog.d("QFSDisableFastScrollUtils", 1, "[updateAutoNextDisableFastScroll] wns enabled auto next fast scroll, end flow.");
        } else {
            QLog.d("QFSDisableFastScrollUtils", 1, "[updateAutoNextDisableFastScroll] disable fast scroll.");
            a16.l(2);
        }
    }
}
