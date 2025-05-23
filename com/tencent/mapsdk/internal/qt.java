package com.tencent.mapsdk.internal;

import android.content.Context;
import android.widget.ListView;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qt extends ListView {

    /* renamed from: a, reason: collision with root package name */
    private a f149934a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void g();
    }

    public qt(Context context) {
        super(context);
    }

    @Override // android.widget.AbsListView
    protected final void handleDataChanged() {
        super.handleDataChanged();
        a aVar = this.f149934a;
        if (aVar != null) {
            aVar.g();
        }
    }

    public final void setOnDataChangedListener(a aVar) {
        this.f149934a = aVar;
    }
}
