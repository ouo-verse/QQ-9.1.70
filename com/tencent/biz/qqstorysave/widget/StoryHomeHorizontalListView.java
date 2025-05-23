package com.tencent.biz.qqstorysave.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.view.widget.a;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.TraceUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class StoryHomeHorizontalListView extends HorizontalListView {
    public int C;
    private boolean D;
    private boolean E;
    protected int F;
    protected int G;

    /* renamed from: d, reason: collision with root package name */
    private float f94547d;

    /* renamed from: e, reason: collision with root package name */
    private float f94548e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f94549f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f94550h;

    /* renamed from: i, reason: collision with root package name */
    private b f94551i;

    /* renamed from: m, reason: collision with root package name */
    private HorizontalListView.OnItemScrollEventListener f94552m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements HorizontalListView.OnItemScrollEventListener {
        a() {
        }

        @Override // com.tencent.widget.HorizontalListView.OnItemScrollEventListener
        public void onItemScrollNonVisible(int i3, boolean z16) {
            if (StoryHomeHorizontalListView.this.f94552m != null) {
                StoryHomeHorizontalListView.this.f94552m.onItemScrollNonVisible(i3, z16);
            }
            hd0.c.c(HorizontalListView.TAG, "on item scroll mHasMore=%b, mIsLoadingMore:%b", Boolean.valueOf(StoryHomeHorizontalListView.this.E), Boolean.valueOf(StoryHomeHorizontalListView.this.D));
            StoryHomeHorizontalListView.this.m();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
    }

    public StoryHomeHorizontalListView(Context context) {
        super(context);
        this.C = 5;
        l(context);
    }

    private void l(Context context) {
        this.F = context.getResources().getDisplayMetrics().widthPixels;
        this.G = x.c(context, 147.0f);
        super.setOnItemScollEventListener(new a());
        setOverScrollMode(1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (action == 0) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_STORY_FRIEND_STORY, 2, "StoryHomeHorizontalListView dispatchTouchEvent:ACTION_DOWN. mIsPress=" + this.f94549f);
            }
            this.f94547d = x16;
            this.f94548e = y16;
            getParent().requestDisallowInterceptTouchEvent(true);
            this.f94549f = true;
            this.f94550h = true;
            return super.dispatchTouchEvent(motionEvent);
        }
        if (action == 2) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_STORY_FRIEND_STORY, 2, "StoryHomeHorizontalListView dispatchTouchEvent:ACTION_MOVE. mIsPress=" + this.f94549f);
            }
            float f16 = x16 - this.f94547d;
            float f17 = y16 - this.f94548e;
            if (this.f94549f && Math.abs(f17) * 5.0f > Math.abs(f16) * 4.0f && Math.abs(f17) > x.c(getContext(), 5.0f)) {
                getParent().requestDisallowInterceptTouchEvent(false);
            } else {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (action == 3 || action == 1) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_STORY_FRIEND_STORY, 2, "StoryHomeHorizontalListView dispatchTouchEvent:ACTION_CANCEL or UP. action=" + action + " mIsPress=" + this.f94549f);
            }
            this.f94549f = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void m() {
        if (!this.E || this.D) {
            return;
        }
        hd0.c.c(HorizontalListView.TAG, "on item scroll last:%d, count:%d", Integer.valueOf(getLastVisiblePosition()), Integer.valueOf(getAdapter().getCount()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.HorizontalListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        TraceUtils.traceBegin("StoryHorizontal.onLayout");
        super.onLayout(z16, i3, i16, i17, i18);
        TraceUtils.traceEnd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.HorizontalListView, android.view.View
    public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        if (this.f94550h && i17 > 0 && i17 > x.c(getContext(), 50.0f)) {
            this.f94550h = false;
            b bVar = this.f94551i;
            if (bVar != null && this.f94549f) {
                bVar.b();
            }
        } else if (this.f94550h && i17 < 0 && i17 < (-x.c(getContext(), 50.0f))) {
            this.f94550h = false;
            b bVar2 = this.f94551i;
            if (bVar2 != null && this.f94549f) {
                bVar2.a();
            }
        }
        return super.overScrollBy(i3, i16, i17, i18, i19, i26, i27, i28, z16);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
    }

    public void setDataCount(int i3) {
        if (i3 >= this.F / this.G) {
            setOverScrollMode(0);
        } else {
            setOverScrollMode(1);
        }
    }

    public void setLoadMoreComplete(boolean z16) {
        this.E = z16;
        this.D = false;
    }

    @Override // com.tencent.widget.HorizontalListView
    public void setOnItemScollEventListener(HorizontalListView.OnItemScrollEventListener onItemScrollEventListener) {
        this.f94552m = onItemScrollEventListener;
    }

    public void setOnOverScrollRightListener(b bVar) {
        this.f94551i = bVar;
    }

    public StoryHomeHorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = 5;
        l(context);
    }

    public void setOnLoadMoreListener(a.InterfaceC0947a interfaceC0947a) {
    }

    public void setOnScrollChangeListener(c cVar) {
    }
}
