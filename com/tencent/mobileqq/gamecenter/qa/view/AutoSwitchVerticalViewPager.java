package com.tencent.mobileqq.gamecenter.qa.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.util.WeakReferenceHandler;

/* loaded from: classes12.dex */
public class AutoSwitchVerticalViewPager extends ViewPager implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    private WeakReferenceHandler f212718d;

    /* renamed from: e, reason: collision with root package name */
    private long f212719e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f212720f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a implements ViewPager.PageTransformer {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.PageTransformer
        public void transformPage(View view, float f16) {
            if (f16 < -1.0f) {
                view.setAlpha(0.0f);
            } else {
                if (f16 <= 1.0f) {
                    view.setAlpha(1.0f);
                    view.setTranslationX(view.getWidth() * (-f16));
                    view.setTranslationY(f16 * view.getHeight());
                    return;
                }
                view.setAlpha(0.0f);
            }
        }
    }

    public AutoSwitchVerticalViewPager(Context context) {
        super(context);
        init();
    }

    private void init() {
        setPageTransformer(true, new a());
        setOverScrollMode(2);
        this.f212718d = new WeakReferenceHandler(Looper.getMainLooper(), this);
    }

    private MotionEvent swapXY(MotionEvent motionEvent) {
        float width = getWidth();
        float height = getHeight();
        motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
        return motionEvent;
    }

    public void a() {
        WeakReferenceHandler weakReferenceHandler = this.f212718d;
        if (weakReferenceHandler != null) {
            weakReferenceHandler.removeCallbacksAndMessages(null);
            this.f212718d.removeMessages(0);
        }
    }

    public boolean b() {
        return this.f212720f;
    }

    public void c(long j3) {
        this.f212719e = j3;
        this.f212718d.removeMessages(1);
        WeakReferenceHandler weakReferenceHandler = this.f212718d;
        weakReferenceHandler.sendMessageDelayed(weakReferenceHandler.obtainMessage(1), this.f212719e);
        this.f212720f = true;
    }

    public void g() {
        this.f212718d.removeMessages(1);
        this.f212720f = false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        int count;
        if (message.what == 1) {
            int currentItem = getCurrentItem();
            PagerAdapter adapter = getAdapter();
            if (adapter != null && (count = adapter.getCount()) > 1) {
                int i3 = count - 1;
                if (currentItem < i3) {
                    setCurrentItem(currentItem + 1);
                } else if (currentItem == i3) {
                    setCurrentItem(0);
                }
                WeakReferenceHandler weakReferenceHandler = this.f212718d;
                weakReferenceHandler.sendMessageDelayed(weakReferenceHandler.obtainMessage(1), this.f212719e);
            }
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(swapXY(motionEvent));
        swapXY(motionEvent);
        return onInterceptTouchEvent;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(swapXY(motionEvent));
    }

    public AutoSwitchVerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
