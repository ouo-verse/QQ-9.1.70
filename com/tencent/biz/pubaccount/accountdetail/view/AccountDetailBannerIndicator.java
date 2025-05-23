package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.widget.BubbleViewLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AccountDetailBannerIndicator extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private final String f79142d;

    /* renamed from: e, reason: collision with root package name */
    private final String f79143e;

    /* renamed from: f, reason: collision with root package name */
    private Context f79144f;

    /* renamed from: h, reason: collision with root package name */
    private int f79145h;

    /* renamed from: i, reason: collision with root package name */
    private int f79146i;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<ImageView> f79147m;

    public AccountDetailBannerIndicator(Context context, int i3) {
        super(context);
        this.f79142d = "#FFFFFFFF";
        this.f79143e = "#33FFFFFF";
        this.f79145h = 0;
        this.f79146i = 0;
        this.f79147m = new ArrayList<>();
        this.f79144f = context;
        this.f79145h = i3;
        a();
    }

    private void a() {
        int f16 = BaseAIOUtils.f(6.0f, this.f79144f.getResources());
        int f17 = BaseAIOUtils.f(9.0f, this.f79144f.getResources());
        for (int i3 = 0; i3 < this.f79145h; i3++) {
            BubbleViewLayout bubbleViewLayout = new BubbleViewLayout(this.f79144f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i3 != 0) {
                layoutParams.setMargins(f17, 0, 0, 0);
            }
            bubbleViewLayout.setLayoutParams(layoutParams);
            bubbleViewLayout.e(false);
            bubbleViewLayout.setRadius(3.0f);
            addView(bubbleViewLayout);
            ImageView imageView = new ImageView(this.f79144f);
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(f16, f16));
            if (i3 == 0) {
                imageView.setImageDrawable(new ColorDrawable(Color.parseColor("#FFFFFFFF")));
            } else {
                imageView.setImageDrawable(new ColorDrawable(Color.parseColor("#33FFFFFF")));
            }
            bubbleViewLayout.addView(imageView);
            this.f79147m.add(imageView);
        }
    }

    public void b(int i3) {
        int i16 = this.f79145h;
        int i17 = i16 > 1 ? i3 % i16 : i3;
        if (i3 < 0) {
            i17 += i16;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("AccountDetailBannerIndicator", 2, "updateCurrentItem->pos:" + i3 + ", newPos:" + i17);
        }
        this.f79147m.get(this.f79146i).setImageDrawable(new ColorDrawable(Color.parseColor("#33FFFFFF")));
        this.f79146i = i17;
        this.f79147m.get(i17).setImageDrawable(new ColorDrawable(Color.parseColor("#FFFFFFFF")));
    }
}
