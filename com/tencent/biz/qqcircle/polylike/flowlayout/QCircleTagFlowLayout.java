package com.tencent.biz.qqcircle.polylike.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.polylike.flowlayout.a;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleTagFlowLayout extends QCircleFlowLayout implements a.InterfaceC0921a {
    private int C;
    private Set<Integer> D;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.qqcircle.polylike.flowlayout.a f91599m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QCircleFlowLayoutItemView f91600d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f91601e;

        a(QCircleFlowLayoutItemView qCircleFlowLayoutItemView, int i3) {
            this.f91600d = qCircleFlowLayoutItemView;
            this.f91601e = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QCircleTagFlowLayout.this.d(this.f91600d, this.f91601e);
            QCircleTagFlowLayout.a(QCircleTagFlowLayout.this);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface c {
    }

    public QCircleTagFlowLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = -1;
        this.D = new HashSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.U5);
        this.C = obtainStyledAttributes.getInt(y91.a.V5, -1);
        obtainStyledAttributes.recycle();
    }

    static /* bridge */ /* synthetic */ c a(QCircleTagFlowLayout qCircleTagFlowLayout) {
        qCircleTagFlowLayout.getClass();
        return null;
    }

    private void c() {
        removeAllViews();
        com.tencent.biz.qqcircle.polylike.flowlayout.a aVar = this.f91599m;
        HashSet<Integer> c16 = aVar.c();
        for (int i3 = 0; i3 < aVar.a(); i3++) {
            View d16 = aVar.d(this, i3, aVar.b(i3));
            QCircleFlowLayoutItemView qCircleFlowLayoutItemView = new QCircleFlowLayoutItemView(getContext());
            d16.setDuplicateParentStateEnabled(true);
            if (d16.getLayoutParams() != null) {
                qCircleFlowLayoutItemView.setLayoutParams(d16.getLayoutParams());
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                int a16 = cx.a(5.0f);
                marginLayoutParams.setMargins(a16, a16, a16, a16);
                qCircleFlowLayoutItemView.setLayoutParams(marginLayoutParams);
            }
            d16.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            qCircleFlowLayoutItemView.addView(d16);
            addView(qCircleFlowLayoutItemView);
            if (c16.contains(Integer.valueOf(i3))) {
                e(i3, qCircleFlowLayoutItemView);
            }
            if (this.f91599m.g(i3, aVar.b(i3))) {
                e(i3, qCircleFlowLayoutItemView);
            }
            d16.setClickable(false);
            qCircleFlowLayoutItemView.setOnClickListener(new a(qCircleFlowLayoutItemView, i3));
        }
        this.D.addAll(c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(QCircleFlowLayoutItemView qCircleFlowLayoutItemView, int i3) {
        if (!qCircleFlowLayoutItemView.isChecked()) {
            if (this.C == 1 && this.D.size() == 1) {
                Integer next = this.D.iterator().next();
                f(next.intValue(), (QCircleFlowLayoutItemView) getChildAt(next.intValue()));
                e(i3, qCircleFlowLayoutItemView);
                this.D.remove(next);
                this.D.add(Integer.valueOf(i3));
                return;
            }
            if (this.C > 0 && this.D.size() >= this.C) {
                return;
            }
            e(i3, qCircleFlowLayoutItemView);
            this.D.add(Integer.valueOf(i3));
            return;
        }
        f(i3, qCircleFlowLayoutItemView);
        this.D.remove(Integer.valueOf(i3));
    }

    private void e(int i3, QCircleFlowLayoutItemView qCircleFlowLayoutItemView) {
        qCircleFlowLayoutItemView.setChecked(true);
        this.f91599m.e(i3, qCircleFlowLayoutItemView.a());
    }

    private void f(int i3, QCircleFlowLayoutItemView qCircleFlowLayoutItemView) {
        qCircleFlowLayoutItemView.setChecked(false);
        this.f91599m.h(i3, qCircleFlowLayoutItemView.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.polylike.flowlayout.QCircleFlowLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        int childCount = getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            QCircleFlowLayoutItemView qCircleFlowLayoutItemView = (QCircleFlowLayoutItemView) getChildAt(i17);
            if (qCircleFlowLayoutItemView.getVisibility() != 8 && qCircleFlowLayoutItemView.a().getVisibility() == 8) {
                qCircleFlowLayoutItemView.setVisibility(8);
            }
        }
        super.onMeasure(i3, i16);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            String string = bundle.getString("key_choose_pos");
            if (!TextUtils.isEmpty(string)) {
                for (String str : string.split("\\|")) {
                    int parseInt = Integer.parseInt(str);
                    this.D.add(Integer.valueOf(parseInt));
                    QCircleFlowLayoutItemView qCircleFlowLayoutItemView = (QCircleFlowLayoutItemView) getChildAt(parseInt);
                    if (qCircleFlowLayoutItemView != null) {
                        e(parseInt, qCircleFlowLayoutItemView);
                    }
                }
            }
            super.onRestoreInstanceState(bundle.getParcelable("key_default"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_default", super.onSaveInstanceState());
        StringBuilder sb5 = new StringBuilder();
        if (this.D.size() > 0) {
            Iterator<Integer> it = this.D.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().intValue());
                sb5.append("|");
            }
            sb5 = new StringBuilder(sb5.substring(0, sb5.length() - 1));
        }
        bundle.putString("key_choose_pos", sb5.toString());
        return bundle;
    }

    public void setAdapter(com.tencent.biz.qqcircle.polylike.flowlayout.a aVar) {
        this.f91599m = aVar;
        aVar.f(this);
        this.D.clear();
        c();
    }

    public void setMaxSelectCount(int i3) {
        if (this.D.size() > i3) {
            QLog.w("TagFlowLayout", 1, "you has already select more than " + i3 + " views , so it will be clear .");
            this.D.clear();
        }
        this.C = i3;
    }

    public QCircleTagFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QCircleTagFlowLayout(Context context) {
        this(context, null);
    }

    public void setOnSelectListener(b bVar) {
    }

    public void setOnTagClickListener(c cVar) {
    }
}
