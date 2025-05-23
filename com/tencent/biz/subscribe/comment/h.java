package com.tencent.biz.subscribe.comment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private Integer[] f96016d;

    /* renamed from: e, reason: collision with root package name */
    private final int f96017e = R.drawable.cc_;

    /* renamed from: f, reason: collision with root package name */
    j f96018f;

    /* renamed from: h, reason: collision with root package name */
    private int f96019h;

    /* renamed from: i, reason: collision with root package name */
    private Context f96020i;

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f96015m = {23, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 43, 51, 17, 60, 61, 92, 93, 66, 58, 7, 8, 57, 29, 28, 74, 59, 80, 16, 70, 77, 62, 15, 68, 75, 76, 45, 52, 53, 54, 55, 56, 63, 73, 72, 65, 94, 64, 38, 47, 95, 71, 96, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105};
    public static final int[] C = {23, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 43, 51, 17, 60, 61, 92, 93, 66, 58, 7, 8, 57, 29, 28, 74, 59, 80, 16, 70, 77, 62, 15, 68, 75, 76, 45, 52, 53, 54, 55, 56, 63, 73, 72, 65, 94, 64, 38, 47, 95, 71, 96, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141};
    public static final int[] D = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f96021d;

        a(int i3) {
            this.f96021d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            h hVar = h.this;
            hVar.f96018f.b(this.f96021d, hVar.f96019h);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class b {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f96023a;

        b() {
        }
    }

    public h(Context context, int i3, int i16, int i17, int i18, j jVar) {
        String str;
        String sb5;
        this.f96020i = context;
        this.f96016d = new Integer[i17];
        this.f96018f = jVar;
        this.f96019h = i18;
        for (int i19 = 0; i19 < i17; i19++) {
            if (i19 < i16) {
                int i26 = ((i3 - 1) * (i17 - 1)) + i19;
                int i27 = C[i26];
                if (D[i26] == 1) {
                    str = "f";
                } else {
                    str = "f_static_";
                }
                if (i27 < 10) {
                    sb5 = str + "00" + i27;
                } else if (i27 < 100) {
                    sb5 = str + "0" + i27;
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str);
                    sb6.append("10");
                    sb6.append(i27 - 100);
                    sb5 = sb6.toString();
                }
                if (i27 >= 0 && i27 < 107) {
                    this.f96016d[i19] = Integer.valueOf(o.f96037h[i27]);
                    QLog.d("CommentInputPopupWindow", 2, "step1 has current id :" + this.f96016d[i19] + " " + sb5 + "  ");
                } else {
                    this.f96016d[i19] = 0;
                }
            } else {
                this.f96016d[i19] = 0;
            }
        }
        this.f96016d[i17 - 1] = Integer.valueOf(this.f96017e);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f96016d.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return Integer.valueOf(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout;
        if (view == null) {
            ImageView imageView = new ImageView(this.f96020i);
            int f16 = BaseAIOUtils.f(35.0f, this.f96020i.getResources());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f16, f16);
            int i16 = f16 / 5;
            layoutParams.setMargins(i16, i16, i16, i16);
            imageView.setAdjustViewBounds(false);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            linearLayout = new LinearLayout(this.f96020i);
            linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            linearLayout.setGravity(17);
            linearLayout.addView(imageView, layoutParams);
            b bVar = new b();
            bVar.f96023a = imageView;
            linearLayout.setTag(bVar);
        } else {
            linearLayout = (LinearLayout) view;
        }
        ImageView imageView2 = ((b) linearLayout.getTag()).f96023a;
        try {
            if (this.f96016d[i3].intValue() != 0) {
                imageView2.setImageResource(this.f96016d[i3].intValue());
                imageView2.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
                QLog.d("CommentInputPopupWindow", 2, "set gone because of 000:");
            }
        } catch (OutOfMemoryError unused) {
        }
        imageView2.setOnClickListener(new a(i3));
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return linearLayout;
    }
}
