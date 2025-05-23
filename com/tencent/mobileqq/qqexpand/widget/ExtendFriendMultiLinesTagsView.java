package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExtendFriendMultiLinesTagsView extends ViewGroup implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    public int f264145d;

    /* renamed from: e, reason: collision with root package name */
    public int f264146e;

    /* renamed from: f, reason: collision with root package name */
    public a f264147f;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface a {
        void a(String str, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f264148a;

        /* renamed from: b, reason: collision with root package name */
        public String f264149b;

        public b(int i3, String str) {
            this.f264148a = i3;
            this.f264149b = str;
        }
    }

    public ExtendFriendMultiLinesTagsView(Context context) {
        super(context);
        this.f264145d = 30;
        this.f264146e = 30;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof b) {
            b bVar = (b) view.getTag();
            a aVar = this.f264147f;
            if (aVar != null) {
                aVar.a(bVar.f264149b, bVar.f264148a);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i3);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingTop2 = getPaddingTop();
        int childCount = getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            int i18 = childAt.getLayoutParams().height;
            if (i18 > 0) {
                childAt.measure(0, View.MeasureSpec.makeMeasureSpec(Math.max(0, i18), 1073741824));
            } else {
                childAt.measure(0, 0);
            }
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (paddingLeft + measuredWidth > defaultSize - getPaddingRight()) {
                paddingLeft = getPaddingLeft();
                paddingTop2 += this.f264145d + measuredHeight;
            }
            paddingLeft += this.f264145d + measuredWidth;
            paddingTop = measuredHeight + paddingTop2;
        }
        int paddingBottom = paddingTop + getPaddingBottom();
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendMultiLinesTagsView", 2, "onMeasure  measuredWidth:" + defaultSize + "  measuredHeight:" + paddingBottom);
        }
        setMeasuredDimension(defaultSize, paddingBottom);
    }

    public void setOnItemClickListener(a aVar) {
        this.f264147f = aVar;
    }

    public void setSearchTags(ArrayList<String> arrayList) {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int f16 = BaseAIOUtils.f(13.0f, getResources());
        int f17 = BaseAIOUtils.f(26.0f, getResources());
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str = arrayList.get(i3);
            if (!TextUtils.isEmpty(str)) {
                TextView textView = new TextView(getContext());
                textView.setText(com.tencent.mobileqq.confess.c.b(str, 8.5f));
                textView.setTag(new b(i3, str));
                textView.setContentDescription(str);
                textView.setOnClickListener(this);
                textView.setTextSize(1, 14.0f);
                textView.setIncludeFontPadding(false);
                textView.setGravity(17);
                textView.setClickable(true);
                textView.setFocusable(true);
                textView.setPadding(f16, 0, f16, 0);
                textView.setBackgroundResource(R.drawable.acj);
                textView.setTextColor(getResources().getColorStateList(R.color.f157811a04));
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setSingleLine();
                textView.setMaxLines(1);
                addView(textView, new ViewGroup.LayoutParams(-2, f17));
            }
        }
        requestLayout();
    }

    public void setViewMargin(int i3, int i16) {
        this.f264145d = i3;
        this.f264146e = i16;
    }

    public ExtendFriendMultiLinesTagsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f264145d = 30;
        this.f264146e = 30;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19 = i17 - i3;
        int i26 = i18 - i16;
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendMultiLinesTagsView", 2, "onLayout changed:" + z16 + " left:" + i3 + " top:" + i16 + " right:" + i17 + " bottom:" + i18 + " w:" + i19 + " h:" + i26);
        }
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i27 = 0; i27 < childCount; i27++) {
            View childAt = getChildAt(i27);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (paddingLeft + measuredWidth > i19 - getPaddingRight()) {
                paddingLeft = getPaddingLeft();
                paddingTop += this.f264145d + measuredHeight;
            }
            childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, measuredHeight + paddingTop);
            paddingLeft += this.f264145d + measuredWidth;
        }
    }

    public ExtendFriendMultiLinesTagsView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f264145d = 30;
        this.f264146e = 30;
    }
}
