package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AccountDetailTopGestureLayout extends TopGestureLayout {

    /* renamed from: d, reason: collision with root package name */
    private int f79245d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<Integer, WeakReference<View>> f79246e;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    protected class a extends TopGestureLayout.TopGestureDetector {
        public a(Context context) {
            super(context);
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.TopGestureDetector, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            AccountDetailTopGestureLayout.d(AccountDetailTopGestureLayout.this);
            return super.onFling(motionEvent, motionEvent2, f16, f17);
        }
    }

    public AccountDetailTopGestureLayout(Context context) {
        super(context);
        init(context);
        this.f79246e = new HashMap<>();
    }

    static /* bridge */ /* synthetic */ IPublicAccountDetailTopGestureLayoutProxy.a d(AccountDetailTopGestureLayout accountDetailTopGestureLayout) {
        accountDetailTopGestureLayout.getClass();
        return null;
    }

    public TopGestureLayout.OnGestureListener f() {
        return this.mOnFlingGesture;
    }

    public GestureDetector.OnGestureListener h(Context context, IPublicAccountDetailTopGestureLayoutProxy.a aVar) {
        a aVar2 = new a(context);
        this.gestureListener = aVar2;
        return aVar2;
    }

    @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout
    public boolean isInTwoFingerMode() {
        return super.isInTwoFingerMode();
    }

    @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        HashMap<Integer, WeakReference<View>> hashMap = this.f79246e;
        if (hashMap != null && hashMap.size() > 0) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            Iterator<WeakReference<View>> it = this.f79246e.values().iterator();
            while (it.hasNext()) {
                View view = it.next().get();
                if (view != null && view.getVisibility() == 0 && g(view, rawX, rawY)) {
                    return false;
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setDefaultDetector(GestureDetector gestureDetector) {
        this.defaultGestureDetector = gestureDetector;
    }

    public void setTopGestureDetector(GestureDetector gestureDetector) {
        this.mTopGestureDetector = gestureDetector;
    }

    private boolean g(View view, float f16, float f17) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        view.getLocalVisibleRect(rect);
        int i3 = iArr[0] + rect.left;
        int width = rect.width() + i3;
        int i16 = iArr[1] + rect.top;
        int height = rect.height() + i16;
        int i17 = this.f79245d;
        if (i17 > 0 && i16 >= 0 && i16 <= i17) {
            i16 = i17;
        }
        return ((float) i3) < f16 && f16 < ((float) width) && ((float) i16) < f17 && f17 < ((float) height);
    }

    public void setTitleHeight(int i3) {
        if (i3 > 0) {
            this.f79245d = i3;
        }
    }

    public void e(View view) {
        if (view == null) {
            return;
        }
        if (this.f79246e.size() > 0) {
            HashSet hashSet = new HashSet();
            for (Integer num : this.f79246e.keySet()) {
                if (this.f79246e.get(num).get() == null) {
                    hashSet.add(num);
                }
            }
            if (hashSet.size() > 0) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    this.f79246e.remove((Integer) it.next());
                }
            }
        }
        this.f79246e.put(Integer.valueOf(view.hashCode()), new WeakReference<>(view));
    }
}
