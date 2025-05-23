package com.qzone.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class RapidCommentTabLayout extends HorizontalScrollView {

    /* renamed from: h, reason: collision with root package name */
    private static final int f60645h = Color.parseColor("#F8F8F8");

    /* renamed from: d, reason: collision with root package name */
    LinearLayout f60646d;

    /* renamed from: e, reason: collision with root package name */
    BaseAdapter f60647e;

    /* renamed from: f, reason: collision with root package name */
    boolean f60648f;

    public RapidCommentTabLayout(Context context, boolean z16) {
        super(context);
        this.f60648f = z16;
        c();
    }

    private View b(int i3) {
        if (i3 < this.f60646d.getChildCount()) {
            return this.f60646d.getChildAt(i3);
        }
        return null;
    }

    public void a(int i3) {
        View b16 = b(i3);
        if (b16 == null) {
            return;
        }
        int[] iArr = new int[2];
        b16.getLocationOnScreen(iArr);
        int width = b16.getWidth();
        int i16 = iArr[0];
        int i17 = width + i16;
        final int i18 = i16 < 0 ? -i16 : 0;
        if (i17 > getWidth()) {
            i18 = getWidth() - i17;
        }
        post(new Runnable() { // from class: com.qzone.widget.RapidCommentTabLayout.1
            @Override // java.lang.Runnable
            public void run() {
                RapidCommentTabLayout.this.smoothScrollBy(-i18, 0);
                RapidCommentTabLayout.this.invalidate();
            }
        });
    }

    public void d() {
        BaseAdapter baseAdapter = this.f60647e;
        if (baseAdapter != null) {
            setAdapter(baseAdapter);
            postInvalidate();
        }
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        this.f60647e = baseAdapter;
        int childCount = this.f60646d.getChildCount();
        for (int i3 = 0; i3 < baseAdapter.getCount(); i3++) {
            if (i3 < childCount) {
                baseAdapter.getView(i3, this.f60646d.getChildAt(i3), null);
            } else {
                this.f60646d.addView(baseAdapter.getView(i3, null, null));
            }
            setTabUnFocus(i3);
        }
    }

    public void setTabFocus(int i3) {
        View b16 = b(i3);
        if (b16 != null) {
            if (this.f60648f) {
                b16.setBackgroundColor(getResources().getColor(R.color.qui_common_fill_standard_primary));
            } else {
                b16.setBackgroundColor(getResources().getColor(R.color.qzone_skin_emo_item_pressed));
            }
        }
    }

    public void setTabUnFocus(int i3) {
        View b16 = b(i3);
        if (b16 != null) {
            if (this.f60648f) {
                b16.setBackgroundColor(getResources().getColor(R.color.qui_common_fill_light_secondary));
            } else {
                b16.setBackgroundColor(getResources().getColor(R.color.qzone_skin_emo_item_normal));
            }
        }
    }

    private void c() {
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f60646d = linearLayout;
        linearLayout.setOrientation(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.f60646d.setLayoutParams(layoutParams);
        addView(this.f60646d, layoutParams);
    }
}
