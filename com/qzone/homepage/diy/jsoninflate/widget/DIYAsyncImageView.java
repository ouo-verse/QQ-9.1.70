package com.qzone.homepage.diy.jsoninflate.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.qzone.widget.AsyncImageView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class DIYAsyncImageView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private AsyncImageView f47529d;

    public DIYAsyncImageView(Context context) {
        super(context);
        AsyncImageView asyncImageView = new AsyncImageView(context);
        this.f47529d = asyncImageView;
        addView(asyncImageView);
    }

    public AsyncImageView a() {
        return this.f47529d;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
