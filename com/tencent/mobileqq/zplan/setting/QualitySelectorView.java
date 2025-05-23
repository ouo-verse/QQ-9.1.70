package com.tencent.mobileqq.zplan.setting;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QualitySelectorView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private List<com.tencent.mobileqq.zplan.setting.a> f335433d;

    /* renamed from: e, reason: collision with root package name */
    private Map<Integer, FormSimpleItem> f335434e;

    /* renamed from: f, reason: collision with root package name */
    private int f335435f;

    /* renamed from: h, reason: collision with root package name */
    private b f335436h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f335437d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f335438e;

        a(int i3, int i16) {
            this.f335437d = i3;
            this.f335438e = i16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3 = QualitySelectorView.this.f335435f;
            int i16 = this.f335437d;
            if (i3 == i16) {
                return;
            }
            QualitySelectorView.this.f335435f = i16;
            if (QualitySelectorView.this.f335436h != null) {
                QualitySelectorView.this.f335436h.t0(view, this.f335438e, this.f335437d);
            }
            QualitySelectorView.this.l(this.f335437d);
            QualitySelectorView.this.m();
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public interface b {
        void t0(View view, int i3, int i16);
    }

    public QualitySelectorView(Context context) {
        this(context, null);
    }

    public com.tencent.mobileqq.zplan.setting.a f() {
        return g(this.f335435f);
    }

    public com.tencent.mobileqq.zplan.setting.a h(int i3) {
        for (com.tencent.mobileqq.zplan.setting.a aVar : this.f335433d) {
            if (i3 == aVar.f335440a) {
                return aVar;
            }
        }
        return null;
    }

    public void j(int i3, boolean z16, boolean z17) {
        com.tencent.mobileqq.zplan.setting.a aVar = new com.tencent.mobileqq.zplan.setting.a();
        aVar.f335440a = i3;
        aVar.f335441b = z16;
        aVar.f335443d = z17;
        this.f335433d.add(aVar);
    }

    public void k() {
        this.f335433d.clear();
        this.f335434e.clear();
        this.f335436h = null;
    }

    public void m() {
        com.tencent.mobileqq.zplan.setting.a aVar;
        FormSimpleItem e16;
        removeAllViews();
        for (int i3 = 0; i3 < this.f335433d.size() && (e16 = e((aVar = this.f335433d.get(i3)))) != null; i3++) {
            if (this.f335433d.size() == 1) {
                o.m(e16, 0, true);
            } else if (i3 == 0) {
                o.m(e16, 1, true);
            } else if (i3 == this.f335433d.size() - 1) {
                o.m(e16, 3, true);
            } else {
                o.m(e16, 2, true);
            }
            if (aVar.f335441b) {
                this.f335435f = i3;
            }
            e16.setOnClickListener(new a(i3, aVar.f335440a));
            addView(e16);
        }
    }

    public void setItemOnClickListener(b bVar) {
        this.f335436h = bVar;
    }

    public QualitySelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void i() {
        setOrientation(1);
    }

    public QualitySelectorView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f335433d = new ArrayList();
        this.f335434e = new HashMap();
        this.f335436h = null;
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i3) {
        int i16 = 0;
        while (i16 < this.f335433d.size()) {
            this.f335433d.get(i16).f335441b = i3 == i16;
            i16++;
        }
    }

    public com.tencent.mobileqq.zplan.setting.a g(int i3) {
        if (i3 < 0 || i3 >= this.f335433d.size()) {
            return null;
        }
        return this.f335433d.get(i3);
    }

    private FormSimpleItem e(com.tencent.mobileqq.zplan.setting.a aVar) {
        if (aVar == null) {
            return null;
        }
        FormSimpleItem formSimpleItem = this.f335434e.get(Integer.valueOf(aVar.f335440a));
        if (formSimpleItem == null) {
            formSimpleItem = new FormSimpleItem(getContext());
            this.f335434e.put(Integer.valueOf(aVar.f335440a), formSimpleItem);
        }
        if (aVar.f335441b) {
            formSimpleItem.setRightIcon(getContext().getDrawable(R.drawable.qq_account_select_icon), ScreenUtil.dip2px(16.0f), ScreenUtil.dip2px(16.0f));
        } else {
            formSimpleItem.setRightIcon(null);
        }
        if (aVar.f335443d) {
            String string = getContext().getString(R.string.xub);
            SpannableString spannableString = new SpannableString(aVar.b(getContext()) + string);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0099FF")), spannableString.length() - string.length(), spannableString.length(), 33);
            spannableString.setSpan(new RelativeSizeSpan(0.8f), spannableString.length() - string.length(), spannableString.length(), 33);
            formSimpleItem.setLeftTextNoColor(spannableString);
        } else {
            formSimpleItem.setLeftText(aVar.b(getContext()));
        }
        return formSimpleItem;
    }
}
