package com.tencent.relation.common.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RelationXRecyclerView extends XRecyclerView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private boolean f364789d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f364790e;

    public RelationXRecyclerView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f364789d = true;
            this.f364790e = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.pull2refresh.XRecyclerView, com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    public boolean isScroll2Top() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (!this.f364789d) {
            return false;
        }
        return super.isScroll2Top();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    public void rebound() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else if (!this.f364790e) {
            super.rebound();
        }
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) adapter);
            return;
        }
        RecyclerViewWithHeaderFooter recyclerViewWithHeaderFooter = this.mRecyclerView;
        if (recyclerViewWithHeaderFooter != null && adapter != null) {
            recyclerViewWithHeaderFooter.setAdapter(adapter);
        } else {
            QLog.d("RelationXRecyclerView", 1, "(null == mRecyclerView) || (null == adapter)");
        }
    }

    public void setIsAutoScrolling(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f364790e = z16;
        }
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) layoutManager);
            return;
        }
        RecyclerViewWithHeaderFooter recyclerViewWithHeaderFooter = this.mRecyclerView;
        if (recyclerViewWithHeaderFooter != null && layoutManager != null) {
            recyclerViewWithHeaderFooter.setLayoutManager(layoutManager);
        } else {
            QLog.d("RelationXRecyclerView", 1, "(null == mRecyclerView) || (null == layout)");
        }
    }

    public void setRefreshEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f364789d = z16;
        }
    }

    public RelationXRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f364789d = true;
            this.f364790e = false;
        }
    }

    public RelationXRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f364789d = true;
            this.f364790e = false;
        }
    }
}
