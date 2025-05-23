package com.qzone.homepage.diy.jsoninflate.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.qzone.proxy.feedcomponent.text.CellTextView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class DIYTextView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private CellTextView f47530d;

    public DIYTextView(Context context) {
        super(context);
        CellTextView cellTextView = new CellTextView(context);
        this.f47530d = cellTextView;
        addView(cellTextView);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
