package com.tencent.mobileqq.search.base.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FitIMEInsetLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private a f282809d;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(int i3);
    }

    public FitIMEInsetLayout(@NonNull Context context) {
        super(context);
        a();
    }

    private void a() {
        if (((Activity) getContext()).getWindow().getAttributes().softInputMode != 16) {
            QLog.w("FitIMEInsetFrametLayout", 4, "#init: only work when softInputMode is adjustResize");
        }
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        rect.top = 0;
        super.fitSystemWindows(rect);
        a aVar = this.f282809d;
        if (aVar != null) {
            aVar.a(getPaddingBottom());
            return true;
        }
        return true;
    }

    public void setPaddingBottomChangedListener(a aVar) {
        this.f282809d = aVar;
    }

    public FitIMEInsetLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public FitIMEInsetLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
