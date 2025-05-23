package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;

/* compiled from: P */
/* loaded from: classes19.dex */
public class LoadMoreXListView extends XListView implements AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.biz.qqstory.view.widget.a f302340d;

    /* renamed from: e, reason: collision with root package name */
    private AbsListView.OnScrollListener f302341e;

    /* renamed from: f, reason: collision with root package name */
    private int f302342f;

    public LoadMoreXListView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f302341e = null;
        this.f302342f = -1;
        init();
    }

    protected void b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        LoadMoreLayout loadMoreLayout = new LoadMoreLayout(getContext());
        this.f302340d = new com.tencent.biz.qqstory.view.widget.a(loadMoreLayout, getContext().getApplicationContext());
        super.addFooterView(loadMoreLayout);
    }

    protected void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            b0();
            super.setOnScrollListener(this);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        AbsListView.OnScrollListener onScrollListener = this.f302341e;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i3, i16, i17);
        }
        if (i3 == this.f302342f) {
            return;
        }
        this.f302342f = i3;
        if (i17 - (i3 + i16) <= this.f302340d.a()) {
            this.f302340d.b(true);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) absListView, i3);
            return;
        }
        AbsListView.OnScrollListener onScrollListener = this.f302341e;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i3);
        }
    }

    @Override // com.tencent.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) onScrollListener);
        } else {
            this.f302341e = onScrollListener;
        }
    }

    public LoadMoreXListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f302341e = null;
        this.f302342f = -1;
        init();
    }

    public LoadMoreXListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f302341e = null;
        this.f302342f = -1;
        init();
    }
}
