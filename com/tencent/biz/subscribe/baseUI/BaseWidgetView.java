package com.tencent.biz.subscribe.baseUI;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class BaseWidgetView<T> extends FrameLayout {
    private ExtraTypeInfo C;
    private Handler D;

    /* renamed from: d, reason: collision with root package name */
    private SparseArray<Long> f95703d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<Integer, c> f95704e;

    /* renamed from: f, reason: collision with root package name */
    protected int f95705f;

    /* renamed from: h, reason: collision with root package name */
    private T f95706h;

    /* renamed from: i, reason: collision with root package name */
    protected int f95707i;

    /* renamed from: m, reason: collision with root package name */
    private WeakReference<Activity> f95708m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (BaseWidgetView.this.k() != null && !BaseWidgetView.this.e(view)) {
                BaseWidgetView baseWidgetView = BaseWidgetView.this;
                baseWidgetView.n(baseWidgetView.r());
                BaseWidgetView.this.k().onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void beforeClick();
    }

    public BaseWidgetView(@NonNull Context context) {
        this(context, 0);
    }

    private void o(Context context, int i3) {
        this.f95707i = i3;
        b(context, i3);
        if (i() != 0) {
            LayoutInflater.from(context).inflate(i(), (ViewGroup) this, true);
        }
        p(context, this);
        if (r() != null) {
            r().setOnClickListener(new a());
        }
        a(context, i3);
    }

    private void q(View view, c cVar) {
        if (view != null) {
            this.f95704e.put(Integer.valueOf(view.getId()), cVar);
        }
    }

    protected abstract void c(T t16);

    protected boolean e(View view) {
        if (view == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f95703d.get(view.getId(), -1L).longValue() > 800) {
            this.f95703d.put(view.getId(), Long.valueOf(currentTimeMillis));
            return false;
        }
        return true;
    }

    public T f() {
        return this.f95706h;
    }

    public ExtraTypeInfo g() {
        return this.C;
    }

    public Activity h() {
        WeakReference<Activity> weakReference = this.f95708m;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    protected abstract int i();

    public Handler j() {
        if (this.D == null) {
            this.D = new Handler(Looper.getMainLooper());
        }
        return this.D;
    }

    protected View.OnClickListener k() {
        return null;
    }

    public int l() {
        return this.f95707i;
    }

    protected void n(View view) {
        if (view != null && this.f95704e.get(Integer.valueOf(view.getId())) != null) {
            this.f95704e.get(Integer.valueOf(view.getId())).beforeClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j().removeCallbacksAndMessages(null);
    }

    protected abstract void p(Context context, View view);

    protected View r() {
        return null;
    }

    public void setData(T t16) {
        this.f95706h = t16;
        c(t16);
    }

    public void setDataPosInList(int i3) {
        this.f95705f = i3;
    }

    public void setExtraTypeInfo(ExtraTypeInfo extraTypeInfo) {
        this.C = extraTypeInfo;
    }

    public void setHostActivity(Activity activity) {
        this.f95708m = new WeakReference<>(activity);
    }

    public void setPreClickListener(c cVar) {
        q(r(), cVar);
    }

    public void setViewType(int i3) {
        this.f95707i = i3;
    }

    public BaseWidgetView(@NonNull Context context, int i3) {
        super(context);
        this.f95703d = new SparseArray<>();
        this.f95704e = new HashMap<>();
        o(context, i3);
    }

    public void setPreClickListener(View view, c cVar) {
        q(view, cVar);
    }

    public void setData(T t16, int i3) {
        this.f95706h = t16;
        d(t16, i3);
    }

    public BaseWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f95703d = new SparseArray<>();
        this.f95704e = new HashMap<>();
        m(context, attributeSet);
        o(context, l());
    }

    public void setInteractor(b bVar) {
    }

    protected void a(Context context, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Context context, int i3) {
    }

    public void d(T t16, int i3) {
    }

    protected void m(Context context, AttributeSet attributeSet) {
    }
}
