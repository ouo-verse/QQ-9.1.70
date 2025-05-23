package com.tencent.biz.qqcircle.immersive.part;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes4.dex */
public class dy extends u implements View.OnClickListener {
    private ImageView C;
    private ViewPager2 D;
    private String E;

    /* renamed from: d, reason: collision with root package name */
    private View f88017d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f88018e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f88019f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f88020h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f88021i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f88022m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i3, float f16, int i16) {
            super.onPageScrolled(i3, f16, i16);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            dy.this.D9(i3);
        }
    }

    public dy(@NonNull View view) {
        String str;
        this.f88017d = view;
        if (com.tencent.biz.qqcircle.f.h()) {
            str = com.tencent.biz.qqcircle.utils.h.a(R.string.f196084gc);
        } else {
            str = "\u6700\u70ed";
        }
        this.E = str;
    }

    private void B9() {
        ImageView imageView = this.f88022m;
        if (imageView != null && this.f88020h != null) {
            imageView.setVisibility(0);
            this.f88020h.setSelected(true);
        }
        ImageView imageView2 = this.C;
        if (imageView2 != null && this.f88021i != null) {
            imageView2.setVisibility(8);
            this.f88021i.setSelected(false);
        }
    }

    private void C9() {
        ImageView imageView = this.f88022m;
        if (imageView != null && this.f88020h != null) {
            imageView.setVisibility(8);
            this.f88020h.setSelected(false);
        }
        ImageView imageView2 = this.C;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
            this.f88021i.setSelected(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D9(int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                C9();
                return;
            }
            return;
        }
        B9();
    }

    public void A9(String str) {
        TextView textView = this.f88020h;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPolymerizationTagViewPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            int id5 = view.getId();
            if (id5 == R.id.f55012gr) {
                this.D.setCurrentItem(0);
            } else if (id5 == R.id.f55052gv) {
                this.D.setCurrentItem(1);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void z9() {
        View view = this.f88017d;
        if (view == null) {
            return;
        }
        this.f88018e = (LinearLayout) view.findViewById(R.id.f55012gr);
        this.f88019f = (LinearLayout) this.f88017d.findViewById(R.id.f55052gv);
        this.f88020h = (TextView) this.f88017d.findViewById(R.id.f55022gs);
        this.f88021i = (TextView) this.f88017d.findViewById(R.id.f55062gw);
        this.f88022m = (ImageView) this.f88017d.findViewById(R.id.f55032gt);
        this.C = (ImageView) this.f88017d.findViewById(R.id.f55072gx);
        ViewPager2 viewPager2 = (ViewPager2) this.f88017d.findViewById(R.id.f54842ga);
        this.D = viewPager2;
        viewPager2.registerOnPageChangeCallback(new a());
        this.f88020h.setText(this.E);
        this.f88018e.setOnClickListener(this);
        this.f88019f.setOnClickListener(this);
    }
}
