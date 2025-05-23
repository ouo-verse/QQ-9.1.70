package com.tencent.mobileqq.vasgift.utils;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class LongClickHandler {

    /* renamed from: b, reason: collision with root package name */
    private final View f311979b;

    /* renamed from: c, reason: collision with root package name */
    private c f311980c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f311978a = false;

    /* renamed from: d, reason: collision with root package name */
    private int f311981d = 0;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f311982e = new Runnable() { // from class: com.tencent.mobileqq.vasgift.utils.LongClickHandler.1
        @Override // java.lang.Runnable
        public void run() {
            LongClickHandler.this.f311980c.c(LongClickHandler.this.f311979b);
            if (LongClickHandler.this.f311978a) {
                ThreadManager.b(this, LongClickHandler.this.f311981d);
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements View.OnLongClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f311983d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f311984e;

        a(c cVar, int i3) {
            this.f311983d = cVar;
            this.f311984e = i3;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            LongClickHandler.this.f311978a = true;
            this.f311983d.b(LongClickHandler.this.f311979b);
            ThreadManager.b(LongClickHandler.this.f311982e, this.f311984e);
            EventCollector.getInstance().onViewLongClicked(view);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f311986d;

        b(c cVar) {
            this.f311986d = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (LongClickHandler.this.f311978a) {
                if (action == 1 || action == 3) {
                    LongClickHandler.this.g();
                    this.f311986d.a(LongClickHandler.this.f311979b);
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
        void a(View view);

        void b(View view);

        void c(View view);
    }

    public LongClickHandler(View view) {
        this.f311979b = view;
    }

    public void g() {
        this.f311978a = false;
        ThreadManager.d(this.f311982e);
    }

    public void h(c cVar, int i3) {
        this.f311980c = cVar;
        this.f311981d = i3;
        this.f311979b.setOnLongClickListener(new a(cVar, i3));
        this.f311979b.setOnTouchListener(new b(cVar));
    }
}
