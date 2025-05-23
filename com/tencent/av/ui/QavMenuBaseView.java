package com.tencent.av.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavMenuBaseView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    protected String f75037d;

    /* renamed from: e, reason: collision with root package name */
    protected VideoAppInterface f75038e;

    /* renamed from: f, reason: collision with root package name */
    protected QavPanel f75039f;

    public QavMenuBaseView(Context context) {
        this(context, null);
    }

    public void a(QavPanel qavPanel) {
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f75037d, 4, "onCreate, panel[" + qavPanel + "]");
        }
        this.f75039f = qavPanel;
        if (qavPanel != null) {
            this.f75038e = qavPanel.K0;
        }
    }

    public void e(long j3) {
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f75037d, 4, "onDestroy, seq[" + j3 + "]");
        }
        this.f75039f = null;
        this.f75038e = null;
    }

    public void f(long j3, boolean z16) {
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f75037d, 4, "onHide, seq[" + j3 + "], onBegin[" + z16 + "]");
        }
    }

    public void g(long j3, boolean z16) {
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f75037d, 4, "onShow, seq[" + j3 + "], onBegin[" + z16 + "]");
        }
    }

    public void h() {
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f75037d, 4, "refreshUI");
        }
    }

    public QavMenuBaseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QavMenuBaseView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f75038e = null;
        this.f75039f = null;
    }
}
