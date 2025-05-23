package com.tencent.widget.datepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class DatePickerView extends RecyclerView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected Context f384742d;

    /* renamed from: e, reason: collision with root package name */
    protected b f384743e;

    /* renamed from: f, reason: collision with root package name */
    private TypedArray f384744f;

    public DatePickerView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public void init(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            return;
        }
        this.f384742d = context;
        setLayoutManager(new LinearLayoutManager(context));
        setVerticalScrollBarEnabled(false);
        setFadingEdgeLength(0);
    }

    public void setController(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        if (this.f384743e == null) {
            this.f384743e = new b(getContext(), aVar, this.f384744f);
        }
        this.f384743e.notifyDataSetChanged();
        setAdapter(this.f384743e);
        scrollToPosition(this.f384743e.getItemCount() - 1);
    }

    public DatePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public DatePickerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            if (isInEditMode()) {
                return;
            }
            this.f384744f = context.obtainStyledAttributes(attributeSet, jj2.b.J0);
            setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
            init(context);
        }
    }
}
