package com.qqnt.widget.smartrefreshlayout.header;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import q3.d;
import q3.f;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ExtTwoLevelHeader extends TwoLevelHeader {
    private boolean P;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements o3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ o3.a f41139a;

        a(o3.a aVar) {
            this.f41139a = aVar;
        }

        @Override // o3.a
        public boolean a(@NonNull f fVar) {
            return this.f41139a.a(fVar);
        }
    }

    public ExtTwoLevelHeader(Context context) {
        this(context, null);
    }

    @Override // com.qqnt.widget.smartrefreshlayout.header.TwoLevelHeader, com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent, r3.i
    public void d(@NonNull f fVar, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        super.d(fVar, refreshState, refreshState2);
        if (refreshState2 == RefreshState.TwoLevelFinish) {
            this.P = false;
        }
        if (refreshState2 == RefreshState.TwoLevel || refreshState2 == RefreshState.TwoLevelReleased || refreshState2 == RefreshState.ReleaseToTwoLevel) {
            this.P = true;
        }
    }

    public ExtTwoLevelHeader q(int i3) {
        super.k(i3);
        return this;
    }

    public ExtTwoLevelHeader r(float f16) {
        super.l(f16);
        return this;
    }

    public ExtTwoLevelHeader s(float f16) {
        super.m(f16);
        return this;
    }

    public ExtTwoLevelHeader t(o3.a aVar) {
        super.n(new a(aVar));
        return this;
    }

    public ExtTwoLevelHeader u(d dVar) {
        super.o(dVar);
        return this;
    }

    @Override // com.qqnt.widget.smartrefreshlayout.header.TwoLevelHeader
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public ExtTwoLevelHeader p(d dVar, int i3, int i16) {
        super.p(dVar, i3, i16);
        return this;
    }

    public ExtTwoLevelHeader(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.P = false;
    }
}
