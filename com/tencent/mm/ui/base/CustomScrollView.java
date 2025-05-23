package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* compiled from: P */
/* loaded from: classes9.dex */
public class CustomScrollView extends ScrollView {

    /* renamed from: a, reason: collision with root package name */
    public a f152627a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void onScrollChange(ScrollView scrollView, int i3, int i16, int i17, int i18);
    }

    public CustomScrollView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        a aVar = this.f152627a;
        if (aVar != null) {
            aVar.onScrollChange(this, i3, i16, i17, i18);
        }
    }

    public void setOnScrollChangeListener(a aVar) {
        this.f152627a = aVar;
    }

    public CustomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
