package com.tencent.biz.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.j;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class PopupMenu extends d {

    /* renamed from: f, reason: collision with root package name */
    private ImageView f96992f;

    /* renamed from: g, reason: collision with root package name */
    private LayoutInflater f96993g;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup f96994h;

    /* renamed from: i, reason: collision with root package name */
    protected CustomMenuBar.e f96995i;

    /* renamed from: j, reason: collision with root package name */
    private List<c> f96996j;

    /* renamed from: k, reason: collision with root package name */
    private int f96997k;

    /* renamed from: l, reason: collision with root package name */
    private int f96998l;

    public PopupMenu(Context context) {
        super(context);
        this.f96996j = new ArrayList();
        this.f96993g = (LayoutInflater) context.getSystemService("layout_inflater");
        h(R.layout.f167940nk);
        this.f96998l = 4;
        this.f96997k = 0;
        k();
    }

    private void f(int i3, int i16, boolean z16) {
        if (this.f96998l == 4) {
            this.f97028b.setAnimationStyle(R.style.f173320a4);
        }
    }

    private void j(int i3, int i16, int i17, int i18) {
        int measuredWidth = this.f96992f.getMeasuredWidth();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f96992f.getLayoutParams();
        if (i17 > i3) {
            if (i17 > i16 * 2) {
                layoutParams.leftMargin = i16 - (measuredWidth / 2);
                return;
            } else if (i17 > (i18 - i16) * 2) {
                layoutParams.leftMargin = ((i16 + i17) - i18) - (measuredWidth / 2);
                return;
            } else {
                layoutParams.addRule(14);
                return;
            }
        }
        layoutParams.addRule(14);
    }

    private void k() {
        this.f96994h.setBackgroundResource(R.drawable.jm7);
        ImageView imageView = this.f96992f;
        imageView.setColorFilter(imageView.getResources().getColor(R.color.qui_common_bg_middle_light, null));
    }

    public void e(c cVar) {
        this.f96996j.add(cVar);
        String i3 = cVar.i();
        Drawable b16 = cVar.b();
        if (this.f96997k != 0) {
            ImageView imageView = new ImageView(this.f97027a);
            imageView.setBackgroundColor(this.f96994h.getResources().getColor(R.color.qui_common_border_standard, null));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, BaseAIOUtils.f(1.0f, imageView.getResources()));
            layoutParams.setMargins(BaseAIOUtils.f(15.0f, imageView.getResources()), 0, BaseAIOUtils.f(15.0f, imageView.getResources()), 0);
            this.f96994h.addView(imageView, layoutParams);
        }
        View inflate = this.f96993g.inflate(R.layout.f167939nj, (ViewGroup) null);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.eq5);
        TextView textView = (TextView) inflate.findViewById(R.id.eqi);
        if (b16 != null) {
            imageView2.setImageDrawable(b16);
        } else {
            imageView2.setVisibility(8);
        }
        if (i3 != null) {
            if (j.c(i3) > 18) {
                textView.setText(j.a(i3, 18, MiniBoxNoticeInfo.APPNAME_SUFFIX));
            } else {
                textView.setText(i3);
            }
        } else {
            textView.setVisibility(8);
        }
        inflate.setBackground(inflate.getResources().getDrawable(R.drawable.qui_common_bg_middle_light_bg, null));
        final String d16 = cVar.d();
        final int e16 = cVar.e();
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.ui.PopupMenu.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                CustomMenuBar.e eVar = PopupMenu.this.f96995i;
                if (eVar != null) {
                    eVar.a(d16, e16, 2);
                }
                view.post(new Runnable() { // from class: com.tencent.biz.ui.PopupMenu.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PopupMenu.this.a();
                    }
                });
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        inflate.setFocusable(true);
        inflate.setClickable(true);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2, 1.0f);
        layoutParams2.gravity = 17;
        inflate.setLayoutParams(layoutParams2);
        this.f96994h.addView(inflate);
        this.f96997k++;
    }

    public void g(CustomMenuBar.e eVar) {
        this.f96995i = eVar;
    }

    public void h(int i3) {
        ViewGroup viewGroup = (ViewGroup) this.f96993g.inflate(i3, (ViewGroup) null);
        this.f97029c = viewGroup;
        this.f96994h = (ViewGroup) viewGroup.findViewById(R.id.epy);
        this.f96992f = (ImageView) this.f97029c.findViewById(R.id.f164476z2);
        this.f97029c.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        super.c(this.f97029c);
    }

    public void i(View view) {
        b();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        Rect rect = new Rect(i3, iArr[1], view.getWidth() + i3, iArr[1] + view.getHeight());
        this.f97029c.measure(-2, -2);
        int measuredWidth = this.f97029c.getMeasuredWidth();
        int measuredHeight = this.f97029c.getMeasuredHeight();
        int width = this.f97031e.getDefaultDisplay().getWidth();
        int width2 = iArr[0] + ((view.getWidth() - measuredWidth) / 2);
        int i16 = (rect.top - measuredHeight) - 10;
        j(view.getWidth(), rect.centerX(), measuredWidth, width);
        f(width, rect.centerX(), true);
        this.f97028b.showAtLocation(view, 0, width2, i16);
    }
}
