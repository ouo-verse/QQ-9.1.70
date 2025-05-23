package com.tencent.relation.common.widget.squaredIndicator;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quishimmer.view.QUIShimmerFrameLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SquaredIndicatorView extends LinearLayout {
    static IPatchRedirector $redirector_;
    private f C;
    private boolean D;
    private List<SquaredFragment> E;
    private QUIShimmerFrameLayout F;
    private View.OnClickListener G;
    private com.tencent.mobileqq.mutualmark.util.a H;
    private String I;
    private int J;
    private int[] K;
    private int[] L;
    private String M;

    /* renamed from: d, reason: collision with root package name */
    private Context f364855d;

    /* renamed from: e, reason: collision with root package name */
    private ViewPager2 f364856e;

    /* renamed from: f, reason: collision with root package name */
    private RadioGroup f364857f;

    /* renamed from: h, reason: collision with root package name */
    private View f364858h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f364859i;

    /* renamed from: m, reason: collision with root package name */
    private QUIButton f364860m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a extends ViewPager2.OnPageChangeCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SquaredIndicatorView.this);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                super.onPageScrollStateChanged(i3);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i3, float f16, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
            } else {
                super.onPageScrolled(i3, f16, i16);
                SquaredIndicatorView.this.c(i3);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                super.onPageSelected(i3);
                SquaredIndicatorView.this.c(i3);
            }
        }
    }

    public SquaredIndicatorView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i3) {
        boolean z16;
        int childCount = this.f364857f.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            RadioButton radioButton = (RadioButton) this.f364857f.getChildAt(i16);
            if (i16 == i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            radioButton.setChecked(z16);
        }
    }

    private void f(Context context) {
        Fragment fragment;
        Lifecycle lifecycle;
        View inflate = LayoutInflater.from(context).inflate(R.layout.fg_, (ViewGroup) this, true);
        this.f364856e = (ViewPager2) inflate.findViewById(R.id.viewPager);
        this.f364857f = (RadioGroup) inflate.findViewById(R.id.f74183vk);
        this.f364858h = inflate.findViewById(R.id.f87704v3);
        this.f364859i = (ImageView) inflate.findViewById(R.id.uu_);
        this.f364860m = (QUIButton) inflate.findViewById(R.id.bw8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f364857f.getLayoutParams();
        layoutParams.topMargin = this.H.h();
        this.f364857f.setLayoutParams(layoutParams);
        if ((context instanceof ContextWrapper) && !(context instanceof FragmentActivity)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (!(context instanceof FragmentActivity)) {
            return;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102129", false);
        QLog.i("SquaredIndicatorView", 1, "isFragmentInsertSwitch=" + isSwitchOn);
        List<Fragment> fragments = fragmentActivity.getSupportFragmentManager().getFragments();
        int i3 = 0;
        while (true) {
            if (i3 < fragments.size()) {
                fragment = fragments.get(i3);
                if (fragment != null && fragment.getClass().getName().equals(this.M)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                fragment = null;
                break;
            }
        }
        if (isSwitchOn && fragment != null) {
            boolean isSwitchOn2 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102177", true);
            QLog.i("SquaredIndicatorView", 1, "isFragmentInsertSwitch=" + isSwitchOn2);
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            if (isSwitchOn2) {
                lifecycle = fragment.getLifecycle();
            } else {
                lifecycle = fragmentActivity.getLifecycle();
            }
            this.C = new f(childFragmentManager, lifecycle);
        } else {
            this.C = new f(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
        }
        this.f364856e.setAdapter(this.C);
        this.f364856e.registerOnPageChangeCallback(new a());
        QUIShimmerFrameLayout qUIShimmerFrameLayout = (QUIShimmerFrameLayout) inflate.findViewById(R.id.f11846748);
        this.F = qUIShimmerFrameLayout;
        qUIShimmerFrameLayout.updateRepeatCount(0);
        this.F.updateXfermode(PorterDuff.Mode.SRC_ATOP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        try {
            ViewPager2 viewPager2 = this.f364856e;
            if (viewPager2 != null) {
                viewPager2.setAdapter(null);
            }
        } catch (IllegalStateException e16) {
            QLog.e("SquaredIndicatorView", 1, e16, new Object[0]);
        }
    }

    private void k(List<MutualMarkModel> list, int i3, int i16, int i17) {
        SquaredFragment squaredFragment;
        for (int i18 = 0; i18 < i16; i18++) {
            int i19 = i18 * 9;
            int min = Math.min(i3 - i19, 9) + i19;
            if (i19 >= 0 && min >= i19 && min <= i3) {
                int size = list.size() - i3;
                if (i17 > i18) {
                    squaredFragment = this.E.get(i18);
                } else {
                    squaredFragment = null;
                }
                List<MutualMarkModel> subList = list.subList(i19, min);
                if (squaredFragment == null) {
                    SquaredFragment qh5 = SquaredFragment.qh(new ArrayList(subList), size);
                    qh5.sh(new WeakReference<>(this.G));
                    this.E.add(qh5);
                } else {
                    squaredFragment.rh(subList, size);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("SquaredIndicatorView", 1, "begin < 0 || end < begin || end > lightUpContentSize");
            }
        }
        if (this.E.size() >= i16) {
            List<SquaredFragment> subList2 = this.E.subList(0, i16);
            this.E = subList2;
            this.C.j0(subList2);
        }
        this.f364856e.post(new Runnable() { // from class: com.tencent.relation.common.widget.squaredIndicator.SquaredIndicatorView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SquaredIndicatorView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    SquaredIndicatorView.this.m();
                }
            }
        });
    }

    private void l() {
        ViewPager2 viewPager2 = this.f364856e;
        if (viewPager2 == null) {
            return;
        }
        viewPager2.post(new Runnable() { // from class: com.tencent.relation.common.widget.squaredIndicator.g
            @Override // java.lang.Runnable
            public final void run() {
                SquaredIndicatorView.this.h();
            }
        });
    }

    private void n() {
        this.f364856e.setVisibility(8);
        this.f364857f.setVisibility(8);
        this.f364858h.setVisibility(0);
        if (!TextUtils.isEmpty(this.I)) {
            this.f364859i.setImageDrawable(URLDrawable.getDrawable(this.I, URLDrawable.URLDrawableOptions.obtain()));
        }
        this.f364860m.setClickable(false);
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100983", false);
        if (QLog.isColorLevel()) {
            QLog.i("SquaredIndicatorView", 1, "optSwitch:" + isSwitchOn);
        }
        if (isSwitchOn) {
            this.G = null;
            Iterator<SquaredFragment> it = this.E.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            this.E.clear();
            l();
        }
    }

    public void e(int i3, WeakReference<com.tencent.relation.common.widget.squaredIndicator.a> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) weakReference);
            return;
        }
        com.tencent.relation.common.widget.squaredIndicator.a aVar = weakReference.get();
        if (aVar == null) {
            return;
        }
        f fVar = this.C;
        if (fVar == null) {
            QLog.d("SquaredIndicatorView", 1, "null == adapter");
            aVar.a(null);
            return;
        }
        List<SquaredFragment> i06 = fVar.i0();
        if (i06 != null && i06.size() != 0) {
            int i16 = i3 / 9;
            int i17 = i3 % 9;
            if (i16 >= i06.size()) {
                QLog.d("SquaredIndicatorView", 1, "pageNo >= size");
                aVar.a(null);
            }
            if (i16 >= i06.size()) {
                return;
            }
            SquaredFragment squaredFragment = i06.get(i16);
            if (squaredFragment == null) {
                QLog.d("SquaredIndicatorView", 1, "null == squaredFragment");
                aVar.a(null);
            }
            this.f364856e.post(new Runnable(squaredFragment, i17, weakReference) { // from class: com.tencent.relation.common.widget.squaredIndicator.SquaredIndicatorView.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ SquaredFragment f364861d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f364862e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ WeakReference f364863f;

                {
                    this.f364861d = squaredFragment;
                    this.f364862e = i17;
                    this.f364863f = weakReference;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SquaredIndicatorView.this, squaredFragment, Integer.valueOf(i17), weakReference);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f364861d.ph(this.f364862e, this.f364863f);
                    }
                }
            });
            return;
        }
        QLog.d("SquaredIndicatorView", 1, "null == squaredFragments || squaredFragments.size() == 0");
        aVar.a(null);
    }

    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        ViewPager2 viewPager2 = this.f364856e;
        if (viewPager2 == null || viewPager2.getCurrentItem() == i3) {
            return;
        }
        this.f364856e.setCurrentItem(i3);
    }

    public void i(List<MutualMarkModel> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
            return;
        }
        Iterator<MutualMarkModel> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().N) {
                i3++;
            }
        }
        QLog.i("SquaredIndicatorView", 1, "lightUpContentSize=" + i3);
        if (i3 == 0) {
            n();
            return;
        }
        this.f364856e.setVisibility(0);
        this.f364857f.setVisibility(8);
        this.f364858h.setVisibility(8);
        k(list, i3, 1, this.E.size());
        if (this.D) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.relation.common.widget.squaredIndicator.SquaredIndicatorView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SquaredIndicatorView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        SquaredIndicatorView.this.o();
                    }
                }
            }, 1500L);
        }
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        f fVar = this.C;
        if (fVar != null) {
            return fVar.onBackEvent();
        }
        return false;
    }

    public void m() {
        int measuredHeight;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.f364856e.getChildCount() == 1) {
            return;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < this.f364856e.getChildCount(); i16++) {
            View childAt = this.f364856e.getChildAt(i16);
            if (childAt != null && (measuredHeight = childAt.getMeasuredHeight()) > i3) {
                i3 = measuredHeight;
            }
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100453", false);
        if (QLog.isColorLevel()) {
            QLog.i("SquaredIndicatorView", 1, String.format("squaredIndicatorFixSwitch: %b ", Boolean.valueOf(isSwitchOn)));
        }
        if (isSwitchOn && i3 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f364856e.getLayoutParams();
        layoutParams.height = i3;
        this.f364856e.setLayoutParams(layoutParams);
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.F != null && this.D && this.L != null && this.K != null) {
            this.D = false;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QUIShimmerFrameLayout qUIShimmerFrameLayout = this.F;
                int[] iArr = this.K;
                qUIShimmerFrameLayout.updateColors(iArr[0], iArr[1], iArr[2], iArr[3]);
                this.F.startShimming(null);
                return;
            }
            if (ThemeUtil.isNowThemeIsNight(peekAppRuntime, true, null)) {
                QUIShimmerFrameLayout qUIShimmerFrameLayout2 = this.F;
                int[] iArr2 = this.L;
                qUIShimmerFrameLayout2.updateColors(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
            } else {
                QUIShimmerFrameLayout qUIShimmerFrameLayout3 = this.F;
                int[] iArr3 = this.K;
                qUIShimmerFrameLayout3.updateColors(iArr3[0], iArr3[1], iArr3[2], iArr3[3]);
            }
            this.F.startShimming(null);
        }
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.D = true;
        }
    }

    public void setEmptyMutualIconUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.I = str;
        }
    }

    public void setOnEmptyClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) onClickListener);
        } else {
            this.G = onClickListener;
        }
    }

    public SquaredIndicatorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public SquaredIndicatorView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.D = false;
        this.E = new ArrayList();
        this.I = "";
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, oz3.b.S4);
        this.M = obtainStyledAttributes.getString(oz3.b.T4);
        obtainStyledAttributes.recycle();
        this.f364855d = context;
        this.H = new com.tencent.mobileqq.mutualmark.util.a(context);
        int color = context.getResources().getColor(R.color.cpf, null);
        this.J = color;
        this.K = new int[]{0, ColorUtils.setAlphaComponent(color, 153), ColorUtils.setAlphaComponent(this.J, 102), 0};
        this.L = new int[]{0, ColorUtils.setAlphaComponent(this.J, Math.round(91.8f)), Math.round(61.2f), 0};
        f(context);
    }
}
