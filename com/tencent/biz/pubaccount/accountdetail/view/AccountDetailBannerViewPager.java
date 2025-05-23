package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

/* loaded from: classes32.dex */
public class AccountDetailBannerViewPager extends ViewPager implements Handler.Callback {
    private final int C;
    private ViewPager.OnPageChangeListener D;

    /* renamed from: d, reason: collision with root package name */
    private final int f79148d;

    /* renamed from: e, reason: collision with root package name */
    private List<ViewPager.OnPageChangeListener> f79149e;

    /* renamed from: f, reason: collision with root package name */
    private AccountDetailBannerIndicator f79150f;

    /* renamed from: h, reason: collision with root package name */
    private int f79151h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f79152i;

    /* renamed from: m, reason: collision with root package name */
    private MqqHandler f79153m;

    /* loaded from: classes32.dex */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AccountDetailBannerViewPager", 2, "onPageScrollStateChanged->" + i3);
            }
            AccountDetailBannerViewPager.this.f79151h = i3;
            if (AccountDetailBannerViewPager.this.f79149e != null) {
                Iterator it = AccountDetailBannerViewPager.this.f79149e.iterator();
                while (it.hasNext()) {
                    ((ViewPager.OnPageChangeListener) it.next()).onPageScrollStateChanged(i3);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            if (AccountDetailBannerViewPager.this.f79149e != null) {
                Iterator it = AccountDetailBannerViewPager.this.f79149e.iterator();
                while (it.hasNext()) {
                    ((ViewPager.OnPageChangeListener) it.next()).onPageScrolled(i3, f16, i16);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AccountDetailBannerViewPager", 2, "onPageSelected->" + i3);
            }
            if (AccountDetailBannerViewPager.this.f79149e != null) {
                Iterator it = AccountDetailBannerViewPager.this.f79149e.iterator();
                while (it.hasNext()) {
                    ((ViewPager.OnPageChangeListener) it.next()).onPageSelected(i3);
                }
            }
            if (AccountDetailBannerViewPager.this.f79150f != null) {
                AccountDetailBannerViewPager.this.f79150f.b(i3);
            }
        }
    }

    public AccountDetailBannerViewPager(Context context) {
        super(context);
        this.f79148d = 2000;
        this.f79151h = 0;
        this.f79152i = false;
        this.f79153m = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
        this.C = 1;
        a aVar = new a();
        this.D = aVar;
        super.setOnPageChangeListener(aVar);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void addOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.f79149e == null) {
            this.f79149e = new ArrayList();
        }
        this.f79149e.add(onPageChangeListener);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (QLog.isDevelopLevel()) {
            QLog.d("AccountDetailBannerViewPager", 2, "handleMessage->" + message.what);
        }
        if (message.what != 1) {
            return false;
        }
        this.f79153m.removeMessages(1);
        if (this.f79151h == 0) {
            int currentItem = getCurrentItem() + 1;
            setCurrentItem(currentItem, true);
            if (QLog.isDevelopLevel()) {
                QLog.d("AccountDetailBannerViewPager", 2, "setCurrentItem->" + currentItem);
            }
        }
        this.f79153m.sendEmptyMessageDelayed(1, 2000L);
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f79151h == 1) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f79151h == 1) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (this.f79152i) {
            if (motionEvent.getActionMasked() != 0 && motionEvent.getActionMasked() != 2) {
                if (motionEvent.getActionMasked() == 1) {
                    this.f79153m.sendEmptyMessageDelayed(1, 2000L);
                    if (QLog.isDevelopLevel()) {
                        QLog.d("AccountDetailBannerViewPager", 2, "onTouchEvent->startAutoScroll");
                    }
                }
            } else {
                this.f79153m.removeMessages(1);
                if (QLog.isDevelopLevel()) {
                    QLog.d("AccountDetailBannerViewPager", 2, "onTouchEvent->stopAutoScroll");
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        super.setAdapter(pagerAdapter);
        if (getAdapter() != null && getAdapter().getF373114d() > 1) {
            this.f79152i = true;
            this.f79153m.sendEmptyMessageDelayed(1, 2000L);
            if (QLog.isDevelopLevel()) {
                QLog.d("AccountDetailBannerViewPager", 2, "setAdapter->startAutoScroll");
                return;
            }
            return;
        }
        this.f79152i = false;
    }

    public void setIndicator(AccountDetailBannerIndicator accountDetailBannerIndicator) {
        this.f79150f = accountDetailBannerIndicator;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        throw new RuntimeException("please use addOnPageChangeListener instead");
    }

    public AccountDetailBannerViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f79148d = 2000;
        this.f79151h = 0;
        this.f79152i = false;
        this.f79153m = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
        this.C = 1;
        a aVar = new a();
        this.D = aVar;
        super.setOnPageChangeListener(aVar);
    }
}
