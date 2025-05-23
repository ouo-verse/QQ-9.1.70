package com.tencent.mobileqq.troop.file.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.troop.widget.m;
import com.tencent.widget.XListView;

/* compiled from: P */
/* loaded from: classes35.dex */
public class TroopFileListView extends XListView implements m.c {

    /* renamed from: d, reason: collision with root package name */
    private m f295692d;

    public TroopFileListView(Context context) {
        this(context, null);
    }

    public void b0() {
        m mVar = this.f295692d;
        if (mVar != null) {
            mVar.g();
        }
    }

    @Override // com.tencent.mobileqq.troop.widget.m.c
    public boolean c(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.mobileqq.troop.widget.m.c
    public boolean d(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView, com.tencent.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m mVar = this.f295692d;
        if (mVar != null) {
            mVar.n();
            this.f295692d = null;
        }
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m mVar = this.f295692d;
        if (mVar != null) {
            return mVar.k(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        m mVar = this.f295692d;
        if (mVar != null) {
            return mVar.l(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSlidingListener(m.a aVar) {
        m mVar = this.f295692d;
        if (mVar != null) {
            mVar.p(aVar);
        }
    }

    public TroopFileListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public TroopFileListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f295692d = new m(context, this, this);
    }
}
