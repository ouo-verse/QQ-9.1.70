package com.tencent.mobileqq.tablequery;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DataReportListView extends ListView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private WindowManager f291338d;

    /* renamed from: e, reason: collision with root package name */
    private int f291339e;

    public DataReportListView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.f291338d = windowManager;
        this.f291339e = windowManager.getDefaultDisplay().getHeight() / 3;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        int size = View.MeasureSpec.getSize(i3);
        int measuredHeight = getMeasuredHeight();
        int i17 = this.f291339e;
        if (measuredHeight > i17) {
            setMeasuredDimension(size, i17);
        }
    }
}
