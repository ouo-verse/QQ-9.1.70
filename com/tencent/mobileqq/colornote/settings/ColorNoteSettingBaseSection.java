package com.tencent.mobileqq.colornote.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.colornote.settings.a;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ColorNoteSettingBaseSection extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.colornote.settings.a f201525d;

    /* renamed from: e, reason: collision with root package name */
    private QFormSimpleItem f201526e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f201527f;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements a.c {
        a() {
        }

        @Override // com.tencent.mobileqq.colornote.settings.a.c
        public void a() {
            ColorNoteSettingBaseSection.this.b();
        }
    }

    public ColorNoteSettingBaseSection(Context context) {
        super(context);
        a();
    }

    private void a() {
        View.inflate(getContext(), R.layout.aoq, this);
        this.f201526e = (QFormSimpleItem) findViewById(R.id.ih8);
        this.f201527f = (LinearLayout) findViewById(R.id.aka);
    }

    public void b() {
        this.f201527f.removeAllViews();
        Iterator<HistoryFormItem> it = this.f201525d.f(getContext()).iterator();
        while (it.hasNext()) {
            this.f201527f.addView(it.next());
        }
    }

    public void setAdapter(com.tencent.mobileqq.colornote.settings.a aVar) {
        this.f201525d = aVar;
        aVar.h(new a());
    }

    public void setBgType(int i3) {
        QFormSimpleItem qFormSimpleItem = this.f201526e;
        if (qFormSimpleItem != null) {
            qFormSimpleItem.setBgType(i3);
        }
    }

    @Override // android.view.View
    public void setContentDescription(CharSequence charSequence) {
        this.f201526e.setContentDescription(charSequence);
    }

    public void setHeaderOnClickListener(View.OnClickListener onClickListener) {
        this.f201526e.setOnClickListener(onClickListener);
    }

    public void setHeaderTitle(CharSequence charSequence) {
        this.f201526e.setLeftText(charSequence);
    }

    public ColorNoteSettingBaseSection(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ColorNoteSettingBaseSection(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
