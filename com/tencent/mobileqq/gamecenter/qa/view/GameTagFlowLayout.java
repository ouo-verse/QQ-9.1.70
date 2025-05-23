package com.tencent.mobileqq.gamecenter.qa.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyTag;
import com.tencent.mobileqq.gamecenter.qa.view.bj;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameTagFlowLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private List<GameStrategyTag> f212908d;

    /* renamed from: e, reason: collision with root package name */
    private bj.b f212909e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f212910f;

    public GameTagFlowLayout(Context context) {
        super(context);
        this.f212908d = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(GameStrategyTag gameStrategyTag, TextView textView, View view) {
        int i3;
        int i16;
        int c16;
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f212909e.a(gameStrategyTag);
        if (this.f212910f) {
            i3 = R.color.cfq;
        } else {
            i3 = R.color.f157841cg3;
        }
        int c17 = com.tencent.mobileqq.gamecenter.qa.util.k.c(i3);
        if (gameStrategyTag.isSelected) {
            c17 = com.tencent.mobileqq.gamecenter.qa.util.k.c(R.color.cfv);
        }
        textView.setBackground(com.tencent.mobileqq.gamecenter.qa.util.k.h(0, ViewUtils.dip2px(2.0f), -1, c17));
        if (gameStrategyTag.isSelected) {
            c16 = com.tencent.mobileqq.gamecenter.qa.util.k.c(R.color.cfp);
        } else {
            if (this.f212910f) {
                i16 = R.color.f157842cg4;
            } else {
                i16 = R.color.f157838cg0;
            }
            c16 = com.tencent.mobileqq.gamecenter.qa.util.k.c(i16);
        }
        textView.setTextColor(c16);
        EventCollector.getInstance().onViewClicked(view);
    }

    protected void c() {
        int i3;
        int i16;
        int c16;
        removeAllViews();
        for (int i17 = 0; i17 < this.f212908d.size(); i17++) {
            final GameStrategyTag gameStrategyTag = this.f212908d.get(i17);
            boolean z16 = gameStrategyTag.isSelected;
            if (this.f212910f) {
                i3 = R.color.cfq;
            } else {
                i3 = R.color.f157841cg3;
            }
            int c17 = com.tencent.mobileqq.gamecenter.qa.util.k.c(i3);
            if (z16) {
                c17 = com.tencent.mobileqq.gamecenter.qa.util.k.c(R.color.cfv);
            }
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ec6, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(R.id.f89024yn);
            textView.setBackground(com.tencent.mobileqq.gamecenter.qa.util.k.h(0, ViewUtils.dip2px(2.0f), -1, c17));
            textView.setText(gameStrategyTag.mTagName);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.ad
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GameTagFlowLayout.this.b(gameStrategyTag, textView, view);
                }
            });
            if (z16) {
                c16 = com.tencent.mobileqq.gamecenter.qa.util.k.c(R.color.cfp);
            } else {
                if (this.f212910f) {
                    i16 = R.color.f157842cg4;
                } else {
                    i16 = R.color.f157838cg0;
                }
                c16 = com.tencent.mobileqq.gamecenter.qa.util.k.c(i16);
            }
            textView.setTextColor(c16);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = ViewUtils.dpToPx(10.0f);
            addView(inflate, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hd0.c.a("attach", "attach");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hd0.c.a("detach", "detach");
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int width = getWidth();
        int childCount = getChildCount();
        int i19 = 0;
        int i26 = 0;
        for (int i27 = 0; i27 < childCount; i27++) {
            View childAt = getChildAt(i27);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int i28 = marginLayoutParams.leftMargin;
                if (i19 + i28 + measuredWidth + marginLayoutParams.rightMargin > width) {
                    i26 += marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                    i19 = 0;
                }
                int i29 = i28 + i19;
                int i36 = marginLayoutParams.topMargin + i26;
                childAt.layout(i29, i36, i29 + measuredWidth, measuredHeight + i36);
                i19 += marginLayoutParams.leftMargin + measuredWidth + marginLayoutParams.rightMargin;
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        super.onMeasure(i3, i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int childCount = getChildCount();
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        while (i19 < childCount) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() == 8) {
                i18 = size2;
            } else {
                measureChild(childAt, i3, i16);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i18 = size2;
                int i36 = measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int i37 = measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i38 = i27 + i36;
                if (i38 > size) {
                    i26 = Math.max(i27, i36);
                    i29 += i37;
                } else {
                    i37 = Math.max(i28, i37);
                    i36 = i38;
                }
                if (i19 == childCount - 1) {
                    i29 += i37;
                    i26 = Math.max(i36, i26);
                }
                i27 = i36;
                i28 = i37;
            }
            i19++;
            size2 = i18;
        }
        int i39 = size2;
        if (mode != 1073741824) {
            size = i26;
        }
        if (mode2 == 1073741824) {
            i17 = i39;
        } else {
            i17 = i29;
        }
        setMeasuredDimension(size, i17);
    }

    public void setItemClickListener(bj.b bVar) {
        this.f212909e = bVar;
    }

    public void setNightTheme(boolean z16) {
        this.f212910f = z16;
    }

    public void setTagList(List<GameStrategyTag> list) {
        this.f212908d = list;
        c();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return (RelativeLayout.LayoutParams) new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public GameTagFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f212908d = new ArrayList();
    }

    public GameTagFlowLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f212908d = new ArrayList();
    }
}
