package com.tencent.mobileqq.search.util;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.util.AppSetting;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class az implements TopGestureLayout.InterceptTouchEventListener {

    /* renamed from: a, reason: collision with root package name */
    private final Collection<TopGestureLayout.InterceptTouchEventListener> f285029a = new LinkedList();

    private void a(TopGestureLayout.InterceptTouchEventListener interceptTouchEventListener) {
        if (interceptTouchEventListener != null && !this.f285029a.contains(interceptTouchEventListener)) {
            this.f285029a.add(interceptTouchEventListener);
        }
    }

    @Nullable
    private static TopGestureLayout b(View view) {
        if (view == null) {
            return null;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TopGestureLayout) {
                return (TopGestureLayout) parent;
            }
        }
        return null;
    }

    @Nullable
    private static az c(View view) {
        TopGestureLayout b16 = b(view);
        if (b16 == null) {
            return null;
        }
        Object tag = b16.getTag(R.id.f99845qw);
        if (tag == null) {
            az azVar = new az();
            b16.setTag(R.id.f99845qw, azVar);
            b16.setInterceptTouchEventListener(azVar);
            return azVar;
        }
        if (tag instanceof az) {
            return (az) tag;
        }
        if (!AppSetting.isDebugVersion()) {
            return null;
        }
        throw new IllegalArgumentException("InterceptTouchEventListener\u88ab\u8bbe\u7f6e\u4e86\uff01" + tag);
    }

    public static void d(@Nullable View view, @Nullable TopGestureLayout.InterceptTouchEventListener interceptTouchEventListener) {
        az c16 = c(view);
        if (c16 != null) {
            c16.a(interceptTouchEventListener);
        }
    }

    private void e(TopGestureLayout.InterceptTouchEventListener interceptTouchEventListener) {
        if (interceptTouchEventListener != null) {
            this.f285029a.remove(interceptTouchEventListener);
        }
    }

    public static void f(@Nullable View view, @Nullable TopGestureLayout.InterceptTouchEventListener interceptTouchEventListener) {
        az c16 = c(view);
        if (c16 != null) {
            c16.e(interceptTouchEventListener);
        }
    }

    @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener
    public void OnDispatchTouchEvent(MotionEvent motionEvent) {
        Iterator<TopGestureLayout.InterceptTouchEventListener> it = this.f285029a.iterator();
        while (it.hasNext()) {
            it.next().OnDispatchTouchEvent(motionEvent);
        }
    }

    @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener
    public boolean OnInterceptTouchEvent(MotionEvent motionEvent) {
        Iterator<TopGestureLayout.InterceptTouchEventListener> it = this.f285029a.iterator();
        boolean z16 = true;
        while (it.hasNext() && (z16 = it.next().OnInterceptTouchEvent(motionEvent))) {
        }
        return z16;
    }
}
