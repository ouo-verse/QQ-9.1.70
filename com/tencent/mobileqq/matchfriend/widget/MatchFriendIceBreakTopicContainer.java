package com.tencent.mobileqq.matchfriend.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendIceBreakTopicContainer extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private final Context f245640d;

    /* renamed from: e, reason: collision with root package name */
    private final List<com.tencent.mobileqq.matchfriend.bean.a> f245641e;

    /* renamed from: f, reason: collision with root package name */
    private final List<View> f245642f;

    public MatchFriendIceBreakTopicContainer(Context context) {
        this(context, null);
    }

    private TextView a(com.tencent.mobileqq.matchfriend.bean.a aVar) {
        TextView textView = new TextView(this.f245640d);
        textView.setText(aVar.f244050b);
        textView.setTextColor(aVar.f244049a);
        textView.setBackgroundResource(R.drawable.fgx);
        textView.setTextSize(14.0f);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setPadding(28, 8, 28, 8);
        return textView;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int measuredHeight;
        int i19;
        super.onLayout(z16, i3, i16, i17, i18);
        int i26 = 200;
        int i27 = 0;
        for (int i28 = 0; i28 < this.f245642f.size(); i28++) {
            View view = this.f245642f.get(i28);
            int i29 = i28 % 2;
            if (i29 == 0) {
                i19 = i26;
                measuredHeight = 0;
            } else {
                measuredHeight = view.getMeasuredHeight() + 24;
                i19 = i27;
            }
            view.layout(i19, measuredHeight, view.getMeasuredWidth() + i19, view.getMeasuredHeight() + measuredHeight);
            if (i29 == 0) {
                i26 += view.getMeasuredWidth() + 150;
            } else {
                i27 += view.getMeasuredWidth() + 150;
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (this.f245642f.size() == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i17 = 200;
        int i18 = 0;
        for (int i19 = 0; i19 < this.f245642f.size(); i19++) {
            int measuredWidth = this.f245642f.get(i19).getMeasuredWidth() + 150;
            if (i19 % 2 == 0) {
                i17 += measuredWidth;
            } else {
                i18 += measuredWidth;
            }
        }
        setMeasuredDimension(Math.max(i17, i18), (this.f245642f.get(0).getMeasuredHeight() * 2) + 24);
    }

    public MatchFriendIceBreakTopicContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c() {
        for (int i3 = 0; i3 < this.f245641e.size(); i3++) {
            TextView a16 = a(this.f245641e.get(i3));
            this.f245642f.add(i3, a16);
            addView(a16);
        }
    }

    public MatchFriendIceBreakTopicContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f245641e = new ArrayList();
        this.f245642f = new ArrayList();
        this.f245640d = context;
    }

    public void b(List<com.tencent.mobileqq.matchfriend.bean.a> list) {
        if (list == null) {
            return;
        }
        this.f245641e.addAll(list);
        c();
    }
}
