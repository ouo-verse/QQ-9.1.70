package com.tencent.av.ui.funchat.filter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.n;
import com.tencent.av.utils.VideoUtil;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class EffectFilterTextPager extends EffectCycleViewPager implements View.OnTouchListener {
    float C;
    long D;
    VideoAppInterface E;
    VideoUtil.AnimationTrigger F;

    /* renamed from: f, reason: collision with root package name */
    Handler f75797f;

    /* renamed from: h, reason: collision with root package name */
    a f75798h;

    /* renamed from: i, reason: collision with root package name */
    private int f75799i;

    /* renamed from: m, reason: collision with root package name */
    float f75800m;

    /* loaded from: classes3.dex */
    public static class a extends PagerAdapter {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<Context> f75801d;

        /* renamed from: f, reason: collision with root package name */
        private boolean f75803f;

        /* renamed from: h, reason: collision with root package name */
        private ColorDrawable f75804h = new ColorDrawable(0);

        /* renamed from: e, reason: collision with root package name */
        ArrayList<FilterItem> f75802e = new ArrayList<>();

        public a(Context context) {
            this.f75801d = new WeakReference<>(context);
        }

        public void d(boolean z16) {
            this.f75803f = z16;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            viewGroup.removeView((View) obj);
        }

        FilterItem e(int i3) {
            if (i3 >= 0 && i3 < this.f75802e.size()) {
                return this.f75802e.get(i3);
            }
            return null;
        }

        public int f(FilterItem filterItem) {
            int i3 = 0;
            if (filterItem == null) {
                return 0;
            }
            Iterator<FilterItem> it = this.f75802e.iterator();
            while (it.hasNext() && !it.next().getId().equals(filterItem.getId())) {
                i3++;
            }
            return i3;
        }

        public void g(List<FilterItem> list) {
            this.f75802e.addAll(list);
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return this.f75802e.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @TargetApi(11)
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            String str;
            FilterItem filterItem = this.f75802e.get(i3);
            Context context = this.f75801d.get();
            if (context == null) {
                return null;
            }
            ViewGroup viewGroup2 = (ViewGroup) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.f168522zj, (ViewGroup) null);
            ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.g7z);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            if (filterItem != null) {
                str = filterItem.getIconUrl();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                AVCoreLog.printColorLog("EffectFilterTextPager", "decodeFile url is null.");
                imageView.setImageDrawable(null);
            } else {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                ColorDrawable colorDrawable = this.f75804h;
                obtain.mFailedDrawable = colorDrawable;
                obtain.mLoadingDrawable = colorDrawable;
                obtain.mRequestWidth = context.getResources().getDimensionPixelSize(R.dimen.a46);
                obtain.mRequestHeight = context.getResources().getDimensionPixelSize(R.dimen.f159340a45);
                imageView.setImageDrawable(URLDrawable.getDrawable(str, obtain));
            }
            if (this.f75803f) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, (int) context.getResources().getDimension(R.dimen.f159336a41), layoutParams.rightMargin, layoutParams.bottomMargin);
                imageView.setLayoutParams(layoutParams);
                imageView.setScaleX(0.6f);
                imageView.setScaleY(0.6f);
            }
            viewGroup.addView(viewGroup2);
            return viewGroup2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            if (view == obj) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<EffectFilterTextPager> f75805a;

        public b(EffectFilterTextPager effectFilterTextPager) {
            this.f75805a = new WeakReference<>(effectFilterTextPager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            EffectFilterTextPager effectFilterTextPager = this.f75805a.get();
            if (effectFilterTextPager == null) {
                return;
            }
            if (message.what == 1) {
                effectFilterTextPager.i();
            }
            super.handleMessage(message);
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(long j3, int i3, String str);
    }

    public EffectFilterTextPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f75800m = 0.0f;
        this.C = 0.0f;
        this.D = 0L;
        this.E = null;
        this.F = null;
        a aVar = new a(context);
        this.f75798h = aVar;
        setAdapter(aVar);
        this.f75797f = new b(this);
        setOnTouchListener(this);
        this.f75799i = -1;
    }

    @TargetApi(11)
    public void g(boolean z16) {
        float f16;
        int i3;
        this.f75798h.d(z16);
        int childCount = getChildCount();
        if (z16) {
            f16 = 0.6f;
        } else {
            f16 = 1.0f;
        }
        if (z16) {
            i3 = R.dimen.f159336a41;
        } else {
            i3 = R.dimen.f159335a40;
        }
        float dimension = getContext().getResources().getDimension(i3);
        AVCoreLog.printColorLog("EffectFilterTextPager", "changeLayout: " + z16 + "|" + childCount + "|" + f16);
        for (int i16 = 0; i16 < childCount; i16++) {
            ImageView imageView = (ImageView) ((ViewGroup) getChildAt(i16)).findViewById(R.id.g7z);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, (int) dimension, layoutParams.rightMargin, layoutParams.bottomMargin);
            imageView.setScaleX(f16);
            imageView.setScaleY(f16);
        }
    }

    void h(int i3) {
        AVCoreLog.printColorLog("EffectFilterTextPager", "dispearPromotionText view:");
        this.f75797f.removeMessages(1);
        this.f75797f.sendMessageDelayed(this.f75797f.obtainMessage(1), i3);
    }

    void i() {
        View a16 = a();
        AVCoreLog.printColorLog("EffectFilterTextPager", "dispearPromotionText_internal view:" + getCurrentItem() + "|" + a16);
        if (a16 != null && a16.getVisibility() == 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(450L);
            alphaAnimation.setAnimationListener(new d(a16));
            a16.startAnimation(alphaAnimation);
        }
    }

    void k() {
        this.f75797f.removeMessages(1);
        AVCoreLog.printColorLog("EffectFilterTextPager", "showPromotionText ");
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).setVisibility(0);
        }
    }

    public void l(List<FilterItem> list) {
        this.f75798h.g(list);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        VideoUtil.AnimationTrigger animationTrigger;
        boolean z16 = n.e().f().f73048l0;
        if (motionEvent.getAction() == 0) {
            this.f75800m = 0.0f;
            this.C = 0.0f;
            this.D = System.currentTimeMillis();
            this.f75800m = motionEvent.getX();
            this.C = motionEvent.getY();
            if (QLog.isColorLevel()) {
                QLog.e("EffectFilterTextPager", 2, "[childLock] touch onDown: " + this.f75800m + " x " + this.C + " ==========");
            }
            if (this.F != null) {
                if (n.e().f().f73048l0) {
                    this.F.g();
                } else {
                    this.F.f(this.f75800m, this.C);
                }
            }
            if (!z16) {
                k();
            }
            Context context = getContext();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                EditText editText = (EditText) activity.findViewById(R.id.dmg);
                if (editText != null) {
                    editText.clearFocus();
                    ((InputMethodManager) activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                }
            }
        }
        if (!n.e().f().f73048l0 && (motionEvent.getAction() == 1 || motionEvent.getPointerCount() > 1 || (motionEvent.getAction() == 2 && (Math.abs(motionEvent.getX() - this.f75800m) > 70.0f || Math.abs(motionEvent.getY() - this.C) > 70.0f)))) {
            this.E.M().removeCallbacks(this.F);
            VideoUtil.AnimationTrigger animationTrigger2 = this.F;
            if (animationTrigger2 != null && animationTrigger2.e()) {
                this.F.cancel();
            }
            if (QLog.isColorLevel()) {
                QLog.e("EffectFilterTextPager", 2, "[childLock] touch end ==========");
            }
        }
        if (!z16) {
            return false;
        }
        if (motionEvent.getAction() == 1 && System.currentTimeMillis() - this.D < 200 && (animationTrigger = this.F) != null) {
            animationTrigger.h();
        }
        i();
        return true;
    }

    public void setAnimationTrigger(VideoUtil.AnimationTrigger animationTrigger) {
        this.F = animationTrigger;
    }

    public void setApp(VideoAppInterface videoAppInterface) {
        this.E = videoAppInterface;
    }

    public void setCurrentFilter(FilterItem filterItem) {
        int f16 = this.f75798h.f(filterItem);
        this.f75799i = f16;
        setCurrentItem(f16 + 1, false);
    }

    public void setOnFilterListenner(e eVar) {
        setOnPageChangeListener(new c(eVar));
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        int i16;
        if (i3 == 0) {
            k();
            if (n.e().f().M1) {
                i16 = 4000;
            } else {
                i16 = 1300;
            }
            h(i16);
        } else {
            this.f75797f.removeMessages(1);
            View a16 = a();
            if (a16 != null) {
                a16.clearAnimation();
            }
        }
        super.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class d implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<View> f75808d;

        d(View view) {
            this.f75808d = new WeakReference<>(view);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f75808d.get();
            AVCoreLog.printColorLog("EffectFilterTextPager", "onAnimationEnd :" + view + "|" + animation);
            if (view != null) {
                view.setVisibility(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes3.dex */
    private class c implements ViewPager.OnPageChangeListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<e> f75806d;

        public c(e eVar) {
            this.f75806d = new WeakReference<>(eVar);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            long d16 = com.tencent.av.utils.e.d();
            if (QLog.isColorLevel()) {
                QLog.w("EffectFilterTextPager", 1, "onPageScrollStateChanged, arg0[" + i3 + "], seq[" + d16 + "]");
            }
            if (i3 == 0) {
                EffectFilterTextPager.this.h(1300);
                VideoAppInterface videoAppInterface = EffectFilterTextPager.this.E;
                if (videoAppInterface != null) {
                    videoAppInterface.k0(new Object[]{110, Long.valueOf(d16)});
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            WeakReference<e> weakReference;
            long d16 = com.tencent.av.utils.e.d();
            if (com.tencent.av.utils.e.k()) {
                QLog.w("EffectFilterTextPager", 1, "onPageSelected, pos[" + i3 + "], mProgramingPos[" + EffectFilterTextPager.this.f75799i + "], seq[" + d16 + "]");
            }
            if (EffectFilterTextPager.this.f75799i != i3 && (weakReference = this.f75806d) != null && weakReference.get() != null) {
                FilterItem e16 = EffectFilterTextPager.this.f75798h.e(i3);
                if (e16 != null) {
                    this.f75806d.get().a(d16, i3, e16.getId());
                }
                EffectFilterTextPager.this.f75799i = -1;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }
}
