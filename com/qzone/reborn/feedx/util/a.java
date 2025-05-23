package com.qzone.reborn.feedx.util;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a extends TouchDelegate {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<TouchDelegate> f55706a;

    public a(View view) {
        super(new Rect(), view);
        this.f55706a = new ArrayList<>();
    }

    public void a(TouchDelegate touchDelegate) {
        this.f55706a.add(touchDelegate);
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Iterator<TouchDelegate> it = this.f55706a.iterator();
        while (it.hasNext()) {
            if (it.next().onTouchEvent(motionEvent)) {
                return true;
            }
        }
        return false;
    }
}
