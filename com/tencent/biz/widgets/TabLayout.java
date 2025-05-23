package com.tencent.biz.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.tencent.widget.HorizontalListView;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public class TabLayout extends HorizontalListView {

    /* renamed from: d, reason: collision with root package name */
    private Map<Integer, View> f97736d;

    /* renamed from: e, reason: collision with root package name */
    private Map<Integer, Integer> f97737e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f97738f;

    /* renamed from: h, reason: collision with root package name */
    private Function1<Canvas, Unit> f97739h;

    /* renamed from: i, reason: collision with root package name */
    private Function1<Canvas, Unit> f97740i;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements Function1<Canvas, Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Canvas canvas) {
            TabLayout.super.draw(canvas);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements Function1<Canvas, Unit> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Canvas canvas) {
            TabLayout.super.dispatchDraw(canvas);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static abstract class c<T> extends BaseAdapter {
    }

    public TabLayout(Context context) {
        super(context);
        this.f97736d = new HashMap();
        this.f97737e = new HashMap();
        this.f97738f = false;
        this.f97739h = new a();
        this.f97740i = new b();
        k();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public void setAdapter(c cVar) {
        super.setAdapter((ListAdapter) cVar);
        throw null;
    }

    public void setChildView(int i3, View view) {
        this.f97736d.put(Integer.valueOf(i3), view);
    }

    public void setChildWidth(int i3, int i16) {
        this.f97737e.put(Integer.valueOf(i3), Integer.valueOf(i16));
    }

    @Override // com.tencent.widget.HorizontalListView
    public void smoothScrollToPositionFromLeftOrRight(int i3, int i16, int i17) {
        super.smoothScrollToPositionFromLeftOrRight(i3, i16, i17);
    }

    private void k() {
        setHorizontalScrollBarEnabled(false);
    }

    public void setSwappingAnimation() {
        this.f97738f = true;
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f97736d = new HashMap();
        this.f97737e = new HashMap();
        this.f97738f = false;
        this.f97739h = new a();
        this.f97740i = new b();
        k();
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, false);
        this.f97736d = new HashMap();
        this.f97737e = new HashMap();
        this.f97738f = false;
        this.f97739h = new a();
        this.f97740i = new b();
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.HorizontalListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
    }
}
