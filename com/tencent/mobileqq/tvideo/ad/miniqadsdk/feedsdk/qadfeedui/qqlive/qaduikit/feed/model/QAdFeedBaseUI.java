package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class QAdFeedBaseUI<T extends com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.a, V> extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private final int f304152d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f304153e;

    /* renamed from: f, reason: collision with root package name */
    private T f304154f;

    /* renamed from: h, reason: collision with root package name */
    protected FeedViewSkinType f304155h;

    /* renamed from: i, reason: collision with root package name */
    protected cx2.a f304156i;

    /* renamed from: m, reason: collision with root package name */
    protected View.OnClickListener f304157m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            cx2.a aVar = QAdFeedBaseUI.this.f304156i;
            if (aVar != null) {
                aVar.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f304159d;

        b(View view) {
            this.f304159d = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    this.f304159d.performClick();
                }
            } else if (this.f304159d.getTag(-15236) == null) {
                QAdFeedBaseUI.this.d(this.f304159d);
                this.f304159d.setTag(-15236, QAdFeedBaseUI.this.f304153e);
            }
            return true;
        }
    }

    public QAdFeedBaseUI(Context context) {
        this(context, null);
    }

    private void c(View view) {
        view.setTag(-15236, null);
        view.setOnTouchListener(new b(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view) {
        cx2.a aVar = this.f304156i;
        if (aVar != null) {
            aVar.a(view);
        }
    }

    public void e(cx2.a aVar) {
        this.f304156i = aVar;
    }

    public final void setData(T t16) {
        this.f304154f = t16;
        f(t16);
    }

    public final void setSkinType(FeedViewSkinType feedViewSkinType) {
        if (this.f304155h == feedViewSkinType) {
            return;
        }
        this.f304155h = feedViewSkinType;
        g(feedViewSkinType);
    }

    public void setViewOnClickListener(View... viewArr) {
        for (View view : viewArr) {
            if (view != null) {
                view.setOnClickListener(this.f304157m);
                c(view);
            }
        }
    }

    public QAdFeedBaseUI(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QAdFeedBaseUI(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f304152d = -15236;
        this.f304153e = new Object();
        this.f304155h = FeedViewSkinType.DEFAULT;
        this.f304157m = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(T t16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(FeedViewSkinType feedViewSkinType) {
    }
}
