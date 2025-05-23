package com.tencent.qqmini.minigame.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GuideBubbleView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private TextView f346757d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f346758e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f346759f;

    /* renamed from: h, reason: collision with root package name */
    private int f346760h;

    /* renamed from: i, reason: collision with root package name */
    private int f346761i;

    public GuideBubbleView(Context context) {
        super(context);
        this.f346760h = 0;
        this.f346761i = 0;
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.mini_sdk_guide_bubble, (ViewGroup) this, true);
        this.f346757d = (TextView) findViewById(R.id.tv_content);
        this.f346758e = (ImageView) findViewById(R.id.iv_up_arrow);
        this.f346759f = (ImageView) findViewById(R.id.iv_down_arrow);
    }

    public void setBubbleStyle(int i3) {
        this.f346761i = i3;
        if (i3 != 0) {
            if (i3 == 1) {
                this.f346757d.setBackground(getResources().getDrawable(R.drawable.mini_sdk_guide_bubble_rectangle_dark));
                this.f346757d.setTextColor(-1);
                this.f346758e.setImageResource(R.drawable.mini_sdk_guide_bubble_triangle_up_dark);
                this.f346759f.setImageResource(R.drawable.mini_sdk_guide_bubble_triangle_down_dark);
                return;
            }
            return;
        }
        this.f346757d.setBackground(getResources().getDrawable(R.drawable.mini_sdk_guide_bubble_rectangle));
        this.f346757d.setTextColor(-16777216);
        this.f346758e.setImageResource(R.drawable.mini_sdk_guide_bubble_triangle_up);
        this.f346759f.setImageResource(R.drawable.mini_sdk_guide_bubble_triangle_down);
    }

    public void setBubbleType(int i3, int i16) {
        this.f346760h = i3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                this.f346758e.setVisibility(8);
                                this.f346759f.setVisibility(0);
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f346759f.getLayoutParams();
                                layoutParams.rightMargin = DisplayUtil.dip2px(getContext(), i16);
                                layoutParams.addRule(11);
                                return;
                            }
                            return;
                        }
                        this.f346758e.setVisibility(8);
                        this.f346759f.setVisibility(0);
                        ((RelativeLayout.LayoutParams) this.f346759f.getLayoutParams()).leftMargin = DisplayUtil.dip2px(getContext(), i16);
                        return;
                    }
                    this.f346758e.setVisibility(8);
                    this.f346759f.setVisibility(0);
                    ((RelativeLayout.LayoutParams) this.f346759f.getLayoutParams()).addRule(14);
                    ((RelativeLayout.LayoutParams) this.f346757d.getLayoutParams()).addRule(14);
                    return;
                }
                this.f346758e.setVisibility(0);
                this.f346759f.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f346758e.getLayoutParams();
                layoutParams2.rightMargin = DisplayUtil.dip2px(getContext(), i16);
                layoutParams2.addRule(11);
                ((RelativeLayout.LayoutParams) this.f346757d.getLayoutParams()).addRule(11);
                return;
            }
            this.f346758e.setVisibility(0);
            this.f346759f.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.f346758e.getLayoutParams()).leftMargin = DisplayUtil.dip2px(getContext(), i16);
            return;
        }
        this.f346758e.setVisibility(0);
        this.f346759f.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.f346758e.getLayoutParams()).addRule(14);
    }

    public void setContent(String str) {
        this.f346757d.setText(str);
    }

    public GuideBubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f346760h = 0;
        this.f346761i = 0;
        a();
    }
}
