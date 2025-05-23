package com.tencent.av.ui.operation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.av.ui.QavMenuBaseView;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.m;
import com.tencent.av.ui.u;
import com.tencent.av.utils.ba;
import com.tencent.av.utils.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import rw.c;
import yv.a;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavOperationBaseMenuView extends QavMenuBaseView implements View.OnClickListener {

    /* renamed from: h, reason: collision with root package name */
    protected c f76180h;

    /* renamed from: i, reason: collision with root package name */
    protected RedTouch[] f76181i;

    /* renamed from: m, reason: collision with root package name */
    protected u f76182m;

    public QavOperationBaseMenuView(Context context) {
        this(context, null);
    }

    private void l() {
        this.f75037d = "QavOperationBaseMenuView_" + e.d();
    }

    @Override // com.tencent.av.ui.QavMenuBaseView
    public void a(QavPanel qavPanel) {
        super.a(qavPanel);
    }

    @Override // com.tencent.av.ui.QavMenuBaseView
    public void f(long j3, boolean z16) {
        super.f(j3, z16);
    }

    @Override // com.tencent.av.ui.QavMenuBaseView
    public void g(long j3, boolean z16) {
        super.g(j3, z16);
        if (z16) {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RedTouch i(View view, int i3, int i16) {
        if (view != null && view.getId() == i3) {
            RedTouch h16 = a.h(this.f75038e, view, i16);
            if (h16 != null) {
                h16.setMargin(0, (int) ba.px2dp(getContext(), view.getPaddingRight()), (int) ba.px2dp(getContext(), view.getPaddingTop()), 0).applyTo();
                return h16;
            }
            return h16;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int j(int i3) {
        if (i3 == m.e.f76018e) {
            return 0;
        }
        if (i3 == m.e.f76020g) {
            return 1;
        }
        if (i3 == m.e.f76024k) {
            return 3;
        }
        if (i3 == R.id.la5) {
            return 2;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int k(int i3) {
        if (i3 == m.e.f76018e) {
            return 2;
        }
        if (i3 == m.e.f76020g) {
            return 6;
        }
        if (i3 == m.e.f76024k) {
            return 9;
        }
        if (i3 == R.id.la5) {
            return 7;
        }
        return 0;
    }

    @SuppressLint({"ResourceType"})
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        u uVar = this.f76182m;
        if (uVar != null) {
            uVar.a(this, view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setQavMenuActionListener(u uVar) {
        this.f76182m = uVar;
    }

    public void setViewController(c cVar) {
        this.f76180h = cVar;
    }

    public QavOperationBaseMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QavOperationBaseMenuView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f76180h = null;
        this.f76181i = new RedTouch[5];
        this.f76182m = null;
        l();
    }
}
