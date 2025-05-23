package com.tencent.av.ui.beauty;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.av.ui.QavMenuBaseView;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.AbsSlidingIndicator;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class QavBeautyMenuPanel extends QavMenuBaseView {
    static final int[] G = {R.id.hum, R.id.huu};
    final b C;
    boolean D;
    long E;
    boolean F;

    /* renamed from: h, reason: collision with root package name */
    final View f75453h;

    /* renamed from: i, reason: collision with root package name */
    final SimpleSlidingIndicator f75454i;

    /* renamed from: m, reason: collision with root package name */
    final PanelViewPage f75455m;

    /* loaded from: classes3.dex */
    class a implements AbsSlidingIndicator.f {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator.f
        public int I0(int i3, boolean z16) {
            QavBeautyMenuPanel.this.setCurSelTab(i3, z16, 1);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class b extends PagerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final List<BeautyBaseView> f75457d;

        public b(List<BeautyBaseView> list) {
            ArrayList arrayList = new ArrayList();
            this.f75457d = arrayList;
            arrayList.clear();
            if (list != null) {
                arrayList.addAll(list);
            }
        }

        public BeautyBaseView d(int i3) {
            if (i3 >= 0 && i3 < this.f75457d.size()) {
                return this.f75457d.get(i3);
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            if (viewGroup != null && (obj instanceof BeautyBaseView)) {
                viewGroup.removeView((BeautyBaseView) obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return this.f75457d.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            BeautyBaseView d16 = d(i3);
            if (viewGroup != null && d16 != null) {
                viewGroup.addView(d16);
            }
            return d16;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            if (view == obj) {
                return true;
            }
            return false;
        }
    }

    public QavBeautyMenuPanel(Context context) {
        this(context, null);
    }

    private RedDotTextView i(int i3) {
        View findViewById = this.f75454i.findViewById(G[i3]);
        if (findViewById instanceof RedTouch) {
            RedTouch redTouch = (RedTouch) findViewById;
            for (int i16 = 0; i16 < redTouch.getChildCount(); i16++) {
                if (redTouch.getChildAt(i16) instanceof RedDotTextView) {
                    return (RedDotTextView) redTouch.getChildAt(i16);
                }
            }
        }
        return null;
    }

    private void j(int i3) {
        if (!this.F && i3 == 1) {
            this.F = true;
            AVUtil.a("0X800AA61", 0);
        }
    }

    @Override // com.tencent.av.ui.QavMenuBaseView
    public void a(QavPanel qavPanel) {
        super.a(qavPanel);
        int f373114d = this.C.getF373114d();
        for (int i3 = 0; i3 < f373114d; i3++) {
            BeautyBaseView d16 = this.C.d(i3);
            if (d16 != null) {
                d16.setAppInterface(this.f75038e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (action != 2 || Math.abs(elapsedRealtime - this.E) > 200) {
            this.E = elapsedRealtime;
            BaseToolbar.keepInToolbar(this.f75038e, -1043L);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.av.ui.QavMenuBaseView
    public void f(long j3, boolean z16) {
        super.f(j3, z16);
        int f373114d = this.C.getF373114d();
        for (int i3 = 0; i3 < f373114d; i3++) {
            BeautyBaseView d16 = this.C.d(i3);
            if (d16 != null) {
                d16.e(j3, z16);
            }
        }
        this.F = false;
    }

    @Override // com.tencent.av.ui.QavMenuBaseView
    public void g(long j3, boolean z16) {
        super.g(j3, z16);
        if (z16) {
            int f373114d = this.C.getF373114d();
            for (int i3 = 0; i3 < f373114d; i3++) {
                BeautyBaseView d16 = this.C.d(i3);
                if (d16 != null) {
                    d16.f(j3, z16);
                }
            }
            BusinessInfoCheckUpdate.AppInfo g16 = yv.a.g(this.f75038e, 8);
            if (yv.a.f(g16)) {
                RedDotTextView i16 = i(1);
                if (i16 != null) {
                    i16.c(true);
                } else {
                    this.f75454i.v(G[1], g16);
                }
                this.f75038e.o0(yv.a.c(8));
                this.D = true;
            } else {
                this.D = false;
            }
            j(this.f75454i.j());
        }
        h();
    }

    @Override // com.tencent.av.ui.QavMenuBaseView
    public void h() {
        super.h();
        BeautyBaseView d16 = this.C.d(this.f75455m.getCurrentItem());
        if (d16 != null) {
            d16.refreshUI();
        }
    }

    public void setCurSelTab(int i3, boolean z16, int i16) {
        if (i3 >= 0 && i3 <= 1) {
            if (QLog.isDevelopLevel()) {
                QLog.i(this.f75037d, 4, "setCurSelTab, [(" + this.f75455m.getCurrentItem() + "," + this.f75454i.j() + ") ---> " + i3 + "], anim[" + z16 + "], width[" + this.f75455m.getMeasuredWidth() + "], width[" + this.f75455m.getWidth() + "], from[" + i16 + "]");
            }
            if (i16 != 1 && i3 != this.f75454i.j()) {
                this.f75454i.setCurrentPosition(i3, z16);
            }
            if (i16 != 2 && i3 != this.f75455m.getCurrentItem()) {
                this.f75455m.setCurrentItem(i3, z16);
            }
            if (z16 && i3 == 1 && this.D) {
                RedDotTextView i17 = i(1);
                if (i17 != null) {
                    i17.c(false);
                } else {
                    this.f75454i.f(G[i3]);
                }
                this.f75038e.n0(yv.a.c(8));
                this.D = false;
            }
        }
    }

    public QavBeautyMenuPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QavBeautyMenuPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        int i16;
        this.D = false;
        this.E = 0L;
        this.F = false;
        this.f75037d = "QavBeautyMenuPanel" + e.d();
        View.inflate(context, R.layout.c9v, this);
        Resources resources = context.getResources();
        View findViewById = findViewById(R.id.j_o);
        this.f75453h = findViewById;
        SimpleSlidingIndicator simpleSlidingIndicator = (SimpleSlidingIndicator) findViewById.findViewById(R.id.ixv);
        this.f75454i = simpleSlidingIndicator;
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.b9n);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.b9k);
        int i17 = (min - dimensionPixelSize2) - (dimensionPixelSize * 2);
        if (i17 > 20) {
            i16 = i17 / 2;
        } else {
            float f16 = (min - 20) / (r5 + dimensionPixelSize2);
            dimensionPixelSize2 = (int) (dimensionPixelSize2 * f16);
            dimensionPixelSize = (int) (dimensionPixelSize * f16);
            i16 = ((min - dimensionPixelSize2) - (dimensionPixelSize * 2)) / 2;
        }
        simpleSlidingIndicator.y(dimensionPixelSize, dimensionPixelSize2, 0, i16);
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f75037d, 4, String.format("QavBeautyMenuPanel, init[%s, %s, %s, %s]", Integer.valueOf(min), Integer.valueOf(dimensionPixelSize), Integer.valueOf(dimensionPixelSize2), Integer.valueOf(i16)));
        }
        simpleSlidingIndicator.setTabData(new String[]{resources.getString(R.string.w2t), resources.getString(R.string.w2u)}, G);
        simpleSlidingIndicator.setCurrentPosition(0, false);
        simpleSlidingIndicator.setOnTabListener(new a());
        PanelViewPage panelViewPage = (PanelViewPage) findViewById(R.id.f166478fi0);
        this.f75455m = panelViewPage;
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new BeautyView(context));
        arrayList.add(new MakeupView(context));
        b bVar = new b(arrayList);
        this.C = bVar;
        panelViewPage.setAdapter(bVar);
        panelViewPage.setIsPagingEnabled(false);
        panelViewPage.setCurrentItem(0, false);
        setBackgroundResource(R.drawable.hea);
    }
}
