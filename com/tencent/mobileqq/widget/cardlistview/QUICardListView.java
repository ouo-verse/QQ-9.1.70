package com.tencent.mobileqq.widget.cardlistview;

import a53.a;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import c53.a;
import com.tencent.widget.HorizontalListView;
import d53.b;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUICardListView extends HorizontalListView {

    /* renamed from: d, reason: collision with root package name */
    private final a f316816d;

    public QUICardListView(Context context) {
        this(context, null, false);
    }

    public void setActionButtonResource(int i3) {
        a aVar = this.f316816d;
        if (aVar != null) {
            aVar.l(i3);
        }
    }

    public void setActionListener(a.e eVar) {
        a53.a aVar = this.f316816d;
        if (aVar != null) {
            aVar.m(eVar);
        }
    }

    public void setData(List<b> list) {
        a53.a aVar = this.f316816d;
        if (aVar != null) {
            aVar.setData(list);
        }
    }

    public void setIconDefaultResource(int i3) {
        a53.a aVar = this.f316816d;
        if (aVar != null) {
            aVar.n(i3);
        }
    }

    public void setReport(b53.a aVar) {
        a53.a aVar2 = this.f316816d;
        if (aVar2 != null) {
            aVar2.o(aVar);
        }
    }

    public void setStateListener(a.c cVar) {
        a53.a aVar = this.f316816d;
        if (aVar != null) {
            aVar.p(cVar);
        }
    }

    public QUICardListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, false);
    }

    public QUICardListView(Context context, AttributeSet attributeSet, boolean z16) {
        super(context, attributeSet, z16);
        a53.a aVar = new a53.a(context);
        this.f316816d = aVar;
        setAdapter((ListAdapter) aVar);
        setOverScrollMode(0);
    }
}
