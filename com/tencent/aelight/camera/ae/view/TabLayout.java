package com.tencent.aelight.camera.ae.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.aelight.camera.ae.util.i;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class TabLayout extends RelativeLayout {
    private boolean C;
    private boolean D;
    private int E;

    /* renamed from: d, reason: collision with root package name */
    private List<c> f65887d;

    /* renamed from: e, reason: collision with root package name */
    private View f65888e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f65889f;

    /* renamed from: h, reason: collision with root package name */
    private int f65890h;

    /* renamed from: i, reason: collision with root package name */
    private ViewPager f65891i;

    /* renamed from: m, reason: collision with root package name */
    private ViewPager2 f65892m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f65894d;

        a(int i3) {
            this.f65894d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TabLayout.this.g(this.f65894d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    private void d(int i3) {
        ObjectAnimator.ofFloat(this.f65888e, HippyTKDListViewAdapter.X, this.f65888e.getX(), (this.f65887d.get(i3).getX() + (this.f65887d.get(i3).getWidth() / 2.0f)) - (this.f65888e.getWidth() / 2.0f)).setDuration(250L).start();
    }

    public void g(int i3) {
        if (i3 < this.f65887d.size() && i3 != this.f65890h) {
            this.f65890h = i3;
            d(i3);
            f(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c extends FrameLayout {

        /* renamed from: d, reason: collision with root package name */
        private int f65896d;

        /* renamed from: e, reason: collision with root package name */
        private int f65897e;

        /* renamed from: f, reason: collision with root package name */
        private int f65898f;

        /* renamed from: h, reason: collision with root package name */
        private int f65899h;

        /* renamed from: i, reason: collision with root package name */
        private TextView f65900i;

        public c(Context context, boolean z16) {
            super(context);
            com.tencent.aelight.camera.ae.view.b bVar;
            com.tencent.aelight.camera.ae.view.b bVar2;
            com.tencent.aelight.camera.ae.view.b bVar3;
            com.tencent.aelight.camera.ae.view.b bVar4;
            if (!z16) {
                bVar = com.tencent.aelight.camera.ae.view.b.f65901x;
            } else {
                bVar = com.tencent.aelight.camera.ae.view.b.B;
            }
            this.f65896d = bVar.f65926w;
            if (!z16) {
                bVar2 = com.tencent.aelight.camera.ae.view.b.f65901x;
            } else {
                bVar2 = com.tencent.aelight.camera.ae.view.b.B;
            }
            this.f65897e = bVar2.f65925v;
            if (!z16) {
                bVar3 = com.tencent.aelight.camera.ae.view.b.f65902y;
            } else {
                bVar3 = com.tencent.aelight.camera.ae.view.b.C;
            }
            this.f65898f = bVar3.f65926w;
            if (!z16) {
                bVar4 = com.tencent.aelight.camera.ae.view.b.f65902y;
            } else {
                bVar4 = com.tencent.aelight.camera.ae.view.b.C;
            }
            this.f65899h = bVar4.f65925v;
            b(context);
        }

        private void b(Context context) {
            TextView textView = new TextView(context);
            this.f65900i = textView;
            textView.setGravity(1);
            this.f65900i.setTextSize(1, 15.0f);
            addView(this.f65900i);
        }

        public TextView a() {
            return this.f65900i;
        }

        public void c(boolean z16, boolean z17) {
            int i3;
            int i16;
            if (!z17) {
                TextView textView = this.f65900i;
                if (z16) {
                    i16 = this.f65897e;
                } else {
                    i16 = this.f65896d;
                }
                textView.setTextColor(i16);
            } else {
                TextView textView2 = this.f65900i;
                if (z16) {
                    i3 = this.f65899h;
                } else {
                    i3 = this.f65898f;
                }
                textView2.setTextColor(i3);
            }
            if (z17) {
                this.f65900i.setShadowLayer(1.0f, 0.0f, 0.0f, R.color.f156808bw);
            } else {
                this.f65900i.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f65887d = new ArrayList();
        this.f65888e = new View(getContext());
        this.f65889f = new LinearLayout(getContext());
        this.C = i.a();
        this.D = false;
        addView(this.f65889f, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void f(int i3) {
        int i16;
        int i17 = 0;
        while (i17 < this.f65887d.size()) {
            c cVar = this.f65887d.get(i17);
            if (i3 == 0) {
                cVar.c(i3 == i17, false);
            } else {
                cVar.c(i3 == i17, this.D);
            }
            i17++;
        }
        if (this.f65890h == 0) {
            i16 = this.E;
        } else {
            i16 = this.D ? R.drawable.iwu : this.E;
        }
        this.f65888e.setBackgroundResource(i16);
        ViewPager viewPager = this.f65891i;
        if (viewPager != null) {
            viewPager.setCurrentItem(i3);
        }
        ViewPager2 viewPager2 = this.f65892m;
        if (viewPager2 != null) {
            viewPager2.setCurrentItem(i3);
        }
    }

    public void setTabs(List<String> list, final int i3) {
        if (list == null || list.size() < 1) {
            return;
        }
        int size = list.size();
        this.f65889f.setWeightSum(size);
        int i16 = 0;
        while (i16 < size) {
            c cVar = new c(getContext(), this.C);
            cVar.a().setText(list.get(i16));
            cVar.c(i3 == i16, this.D);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.f65889f.addView(cVar, layoutParams);
            this.f65887d.add(cVar);
            cVar.setOnClickListener(new a(i16));
            i16++;
        }
        c();
        if (list.size() > 1) {
            this.f65887d.get(0).post(new Runnable() { // from class: com.tencent.aelight.camera.ae.view.TabLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) TabLayout.this.f65888e.getLayoutParams();
                    if (TabLayout.this.f65887d.size() > i3) {
                        layoutParams2.setMargins((int) ((((c) TabLayout.this.f65887d.get(i3)).getX() + (((c) TabLayout.this.f65887d.get(i3)).getWidth() / 2.0f)) - (TabLayout.this.f65888e.getWidth() / 2.0f)), 0, 0, 0);
                    } else {
                        layoutParams2.setMargins((((c) TabLayout.this.f65887d.get(0)).getRight() / 2) - (TabLayout.this.f65888e.getWidth() / 2), 0, 0, 0);
                    }
                    TabLayout.this.f65888e.setLayoutParams(layoutParams2);
                }
            });
        }
        this.f65890h = i3;
        if (i3 != 0) {
            f(i3);
        }
    }

    private void c() {
        this.E = R.drawable.iwv;
        this.f65888e.setBackgroundResource(R.drawable.iwv);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e(getContext(), 7.0f), e(getContext(), 7.0f));
        layoutParams.addRule(12);
        addView(this.f65888e, layoutParams);
    }

    public static int e(Context context, float f16) {
        if (context == null) {
            return 0;
        }
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setTabSelectedCallback(b bVar) {
    }
}
