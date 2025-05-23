package com.tencent.mobileqq.wink.picker.core.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.utils.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkMediaListTimelineView extends RelativeLayout {
    List<LocalMediaInfo> C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private int f324733d;

    /* renamed from: e, reason: collision with root package name */
    private Context f324734e;

    /* renamed from: f, reason: collision with root package name */
    private List<Integer> f324735f;

    /* renamed from: h, reason: collision with root package name */
    private List<TextView> f324736h;

    /* renamed from: i, reason: collision with root package name */
    private RelativeLayout f324737i;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f324738m;

    public WinkMediaListTimelineView(Context context) {
        super(context);
        this.f324735f = new ArrayList();
        this.f324736h = new ArrayList();
        this.C = new ArrayList();
        this.D = false;
        this.f324734e = context;
    }

    private void a(int i3, String str, int i16) {
        TextView textView = new TextView(this.f324734e);
        textView.setTextSize(11.0f);
        textView.setTextColor(textView.getContext().getColorStateList(R.color.qui_button_text_secondary));
        textView.setBackgroundResource(R.drawable.qvideo_skin_pick_time_zone_background);
        int dpToPx = ViewUtils.dpToPx(32.0f);
        if (this.f324735f.size() > 0) {
            if (i3 - this.f324735f.get(r2.size() - 1).intValue() < dpToPx) {
                i3 = this.f324735f.get(r5.size() - 1).intValue() + dpToPx;
            }
        }
        int c16 = c(i3, i16);
        this.f324735f.add(Integer.valueOf(c16));
        textView.setY(c16);
        textView.setText(str);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        textView.setGravity(17);
        layoutParams.height = ViewUtils.dpToPx(20.0f);
        layoutParams.width = ViewUtils.dpToPx(40.0f);
        layoutParams.rightMargin = ViewUtils.dpToPx(62.0f);
        layoutParams.addRule(11);
        ViewCompat.setElevation(textView, 6.0f);
        RelativeLayout relativeLayout = this.f324737i;
        if (relativeLayout != null) {
            relativeLayout.addView(textView, 0, layoutParams);
        }
        this.f324736h.add(textView);
    }

    private int c(int i3, int i16) {
        int i17 = i16 - 1;
        int dpToPx = (ViewUtils.dpToPx(32.0f) * i17) + i3 + ViewUtils.dpToPx(20.0f);
        int i18 = this.f324733d;
        if (dpToPx > i18) {
            return i18 - ((ViewUtils.dpToPx(32.0f) * i17) + ViewUtils.dpToPx(20.0f));
        }
        return i3;
    }

    private List<Pair<Integer, Integer>> e() {
        int a16 = as.a(System.currentTimeMillis() / 1000);
        ArrayList arrayList = new ArrayList();
        if (this.C == null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<LocalMediaInfo> it = this.C.iterator();
        int i3 = 0;
        int i16 = 0;
        int i17 = Integer.MAX_VALUE;
        while (it.hasNext()) {
            int a17 = as.a(it.next().modifiedDate);
            if (a16 - a17 < 3 && !arrayList2.contains(Integer.valueOf(a17))) {
                arrayList.add(new Pair(Integer.valueOf(i16), Integer.valueOf(a17)));
                arrayList2.add(Integer.valueOf(a17));
            }
            if (a17 != i17) {
                i3 = i16;
            }
            i17 = Math.min(i17, a17);
            i16++;
        }
        if (!arrayList2.contains(Integer.valueOf(i17)) && i17 != Integer.MAX_VALUE) {
            arrayList.add(new Pair(Integer.valueOf(i3), Integer.valueOf(i17)));
            arrayList2.add(Integer.valueOf(i17));
        }
        return arrayList;
    }

    public void b(float f16) {
        if (this.f324735f.size() <= 2) {
            return;
        }
        Iterator<Integer> it = this.f324735f.iterator();
        float f17 = Float.MAX_VALUE;
        float f18 = Float.MIN_VALUE;
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (it.hasNext()) {
            float intValue = f16 - (it.next().intValue() + ViewUtils.dpToPx(16.0f));
            f17 = Math.min(Math.abs(intValue), f17);
            if (f17 == Math.abs(intValue)) {
                i16 = i3;
            }
            f18 = Math.max(Math.abs(intValue), f18);
            if (f18 == Math.abs(intValue)) {
                i17 = i3;
            }
            i3++;
        }
        if (f18 == f17) {
            return;
        }
        for (int i18 = 0; i18 < this.f324736h.size(); i18++) {
            if (i18 == i16) {
                this.f324736h.get(i18).setAlpha(1.0f);
            } else if (i18 == i17) {
                this.f324736h.get(i18).setAlpha(0.4f);
            } else {
                TextView textView = this.f324736h.get(i18);
                if (textView != null) {
                    textView.setAlpha(1.0f - (((Math.abs(f16 - textView.getY()) - f17) / (f18 - f17)) * 0.6f));
                }
            }
        }
    }

    public void d() {
        List<LocalMediaInfo> list = this.C;
        if (list != null && list.size() != 0) {
            if (this.f324737i != null) {
                Iterator<TextView> it = this.f324736h.iterator();
                while (it.hasNext()) {
                    this.f324737i.removeView(it.next());
                }
            }
            this.f324736h.clear();
            this.f324735f.clear();
            this.f324737i = (RelativeLayout) findViewById(R.id.f246609q);
            FrameLayout frameLayout = (FrameLayout) getParent();
            if (frameLayout != null) {
                this.f324738m = (RelativeLayout) frameLayout.findViewById(R.id.f246509p);
            }
            List<Pair<Integer, Integer>> e16 = e();
            int i3 = 0;
            for (Pair<Integer, Integer> pair : e16) {
                if (pair != null) {
                    a((int) ((((Integer) pair.first).intValue() / this.C.size()) * this.f324733d), ((Integer) pair.second).toString(), e16.size() - i3);
                    i3++;
                }
            }
        }
    }

    public void f(boolean z16) {
        RelativeLayout relativeLayout = this.f324737i;
        if (relativeLayout != null && this.f324738m != null) {
            if (z16) {
                relativeLayout.setVisibility(4);
                this.f324738m.setVisibility(4);
            }
            if (this.D) {
                this.D = false;
                ObjectAnimator.ofFloat(this.f324737i, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(300L).start();
                ObjectAnimator.ofFloat(this.f324738m, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(300L).start();
            }
        }
    }

    public void g() {
        RelativeLayout relativeLayout = this.f324737i;
        if (relativeLayout != null && this.f324738m != null) {
            relativeLayout.setVisibility(0);
            this.f324738m.setVisibility(0);
            if (!this.D) {
                this.D = true;
                ObjectAnimator.ofFloat(this.f324737i, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(300L).start();
                ObjectAnimator.ofFloat(this.f324738m, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(300L).start();
            }
        }
    }

    public void setPhotoList(List<LocalMediaInfo> list) {
        this.C = list;
    }

    public void setTimelineHeight(int i3) {
        this.f324733d = i3;
    }

    public WinkMediaListTimelineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f324735f = new ArrayList();
        this.f324736h = new ArrayList();
        this.C = new ArrayList();
        this.D = false;
        this.f324734e = context;
    }

    public WinkMediaListTimelineView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f324735f = new ArrayList();
        this.f324736h = new ArrayList();
        this.C = new ArrayList();
        this.D = false;
        this.f324734e = context;
    }
}
