package com.tencent.mobileqq.qqexpand.widget.search;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ExpandHorizontalTagsView extends LinearLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    public int f264255d;

    /* renamed from: e, reason: collision with root package name */
    public a f264256e;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void a(String str, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f264257a;

        /* renamed from: b, reason: collision with root package name */
        public String f264258b;

        public b(int i3, String str) {
            this.f264257a = i3;
            this.f264258b = str;
        }
    }

    public ExpandHorizontalTagsView(Context context) {
        super(context);
        this.f264255d = -1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        int i3;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        if ((view.getTag() instanceof b) && (i3 = (bVar = (b) view.getTag()).f264257a) != this.f264255d) {
            this.f264255d = i3;
            a aVar = this.f264256e;
            if (aVar != null) {
                aVar.a(bVar.f264258b, i3);
            }
            for (int i16 = 0; i16 < getChildCount(); i16++) {
                View childAt = getChildAt(i16);
                if (getChildAt(i16) == view) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                childAt.setSelected(z16);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setOnItemClickListener(a aVar) {
        this.f264256e = aVar;
    }

    public void setSearchTags(ArrayList<String> arrayList, int i3) {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            int c16 = x.c(getContext(), 13.0f);
            int c17 = x.c(getContext(), 26.0f);
            int i16 = 0;
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                String str = arrayList.get(i17);
                if (!TextUtils.isEmpty(str)) {
                    TextView textView = new TextView(getContext());
                    textView.setText(str);
                    textView.setTag(new b(i17, str));
                    textView.setContentDescription(str);
                    if (i17 == i3) {
                        this.f264255d = i17;
                        textView.setSelected(true);
                    } else {
                        textView.setSelected(false);
                    }
                    textView.setOnClickListener(this);
                    textView.setTextSize(1, 14.0f);
                    textView.setGravity(17);
                    textView.setClickable(true);
                    textView.setFocusable(true);
                    textView.setPadding(c16, 0, c16, 0);
                    textView.setBackgroundResource(R.drawable.kpz);
                    textView.setTextColor(getResources().getColorStateList(R.color.f157809a02));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, c17);
                    if (i16 > 0) {
                        layoutParams.leftMargin = x.c(getContext(), 8.0f);
                    }
                    addView(textView, layoutParams);
                    i16++;
                }
            }
        }
    }

    public ExpandHorizontalTagsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f264255d = -1;
    }

    public ExpandHorizontalTagsView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f264255d = -1;
    }
}
