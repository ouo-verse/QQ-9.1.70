package com.tencent.mobileqq.colornote.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HistoryFormItem extends QFormSimpleItem {

    /* renamed from: d, reason: collision with root package name */
    private boolean f201533d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f201534e;

    /* renamed from: f, reason: collision with root package name */
    private b f201535f;

    /* renamed from: h, reason: collision with root package name */
    private int f201536h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f201537i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (((IColorNoteHelper) MobileQQ.getMobileQQ().waitAppRuntime(null).getRuntimeService(IColorNoteHelper.class, "all")).canAddColorNote()) {
                z16 = true;
            } else {
                ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).showFullDialog(view.getContext());
                z16 = false;
            }
            if (z16 && HistoryFormItem.this.h()) {
                HistoryFormItem historyFormItem = HistoryFormItem.this;
                historyFormItem.f201533d = true ^ historyFormItem.f201533d;
                HistoryFormItem historyFormItem2 = HistoryFormItem.this;
                historyFormItem2.i(view, historyFormItem2.f201533d);
                if (HistoryFormItem.this.f201535f != null) {
                    HistoryFormItem.this.f201535f.a(view, HistoryFormItem.this.f201536h, HistoryFormItem.this.f201533d);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, int i3, boolean z16);
    }

    public HistoryFormItem(Context context) {
        super(context);
        this.f201533d = false;
        this.f201536h = 0;
        this.f201537i = true;
        g();
    }

    private void f() {
        ImageView imageView = new ImageView(getContext());
        this.f201534e = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f201534e.setContentDescription(getResources().getString(R.string.f170759vz4));
        k(this.f201533d);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.b_8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.addRule(11, 1);
        layoutParams.addRule(15, 1);
        addView(this.f201534e, layoutParams);
        this.f201534e.setOnClickListener(new a());
    }

    private void g() {
        f();
    }

    private void j(boolean z16) {
        if (z16) {
            setBackgroundResource(R.drawable.skin_setting_strip_bg_pressed);
        } else {
            setBgType(2);
        }
    }

    private void k(boolean z16) {
        if (z16) {
            this.f201534e.setImageResource(R.drawable.cfz);
        } else {
            this.f201534e.setImageResource(R.drawable.cfy);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.QFormSimpleItem
    public void calucateTextMaxWidth() {
        super.calucateTextMaxWidth();
        this.mLeftTextViewMaxWidth = x.c(getContext(), 290.0f);
    }

    public int e() {
        return this.f201536h;
    }

    public boolean h() {
        return this.f201537i;
    }

    public void i(View view, boolean z16) {
        j(z16);
        k(z16);
    }

    public void setEnable(boolean z16) {
        this.f201537i = z16;
    }

    public void setIndex(int i3) {
        this.f201536h = i3;
    }

    public void setItemOnClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setOnIconClickListener(b bVar) {
        this.f201535f = bVar;
    }

    public HistoryFormItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f201533d = false;
        this.f201536h = 0;
        this.f201537i = true;
        g();
    }
}
