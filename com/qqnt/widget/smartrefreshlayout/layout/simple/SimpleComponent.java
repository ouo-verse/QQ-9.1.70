package com.qqnt.widget.smartrefreshlayout.layout.simple;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import com.qqnt.widget.smartrefreshlayout.layout.constant.b;
import q3.a;
import q3.c;
import q3.d;
import q3.e;
import q3.f;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class SimpleComponent extends RelativeLayout implements a {

    /* renamed from: d, reason: collision with root package name */
    protected View f41260d;

    /* renamed from: e, reason: collision with root package name */
    protected b f41261e;

    /* renamed from: f, reason: collision with root package name */
    protected a f41262f;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleComponent(@NonNull View view) {
        this(view, view instanceof a ? (a) view : null);
    }

    public void a(@NonNull e eVar, int i3, int i16) {
        a aVar = this.f41262f;
        if (aVar != null && aVar != this) {
            aVar.a(eVar, i3, i16);
            return;
        }
        View view = this.f41260d;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                eVar.a(this, ((SmartRefreshLayout.LayoutParams) layoutParams).f41223a);
            }
        }
    }

    @Override // q3.a
    public int b(@NonNull f fVar, boolean z16) {
        a aVar = this.f41262f;
        if (aVar != null && aVar != this) {
            return aVar.b(fVar, z16);
        }
        return 0;
    }

    @Override // q3.a
    public void c(@NonNull f fVar, int i3, int i16) {
        a aVar = this.f41262f;
        if (aVar != null && aVar != this) {
            aVar.c(fVar, i3, i16);
        }
    }

    public void d(@NonNull f fVar, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        a aVar = this.f41262f;
        if (aVar != null && aVar != this) {
            if ((this instanceof c) && (aVar instanceof d)) {
                if (refreshState.isFooter) {
                    refreshState = refreshState.toHeader();
                }
                if (refreshState2.isFooter) {
                    refreshState2 = refreshState2.toHeader();
                }
            } else if ((this instanceof d) && (aVar instanceof c)) {
                if (refreshState.isHeader) {
                    refreshState = refreshState.toFooter();
                }
                if (refreshState2.isHeader) {
                    refreshState2 = refreshState2.toFooter();
                }
            }
            a aVar2 = this.f41262f;
            if (aVar2 != null) {
                aVar2.d(fVar, refreshState, refreshState2);
            }
        }
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if ((obj instanceof a) && getView() == ((a) obj).getView()) {
            return true;
        }
        return false;
    }

    @Override // q3.a
    public void f(@NonNull f fVar, int i3, int i16) {
        a aVar = this.f41262f;
        if (aVar != null && aVar != this) {
            aVar.f(fVar, i3, i16);
        }
    }

    @Override // q3.a
    @NonNull
    public b getSpinnerStyle() {
        int i3;
        b bVar = this.f41261e;
        if (bVar != null) {
            return bVar;
        }
        a aVar = this.f41262f;
        if (aVar != null && aVar != this) {
            return aVar.getSpinnerStyle();
        }
        View view = this.f41260d;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                b bVar2 = ((SmartRefreshLayout.LayoutParams) layoutParams).f41224b;
                this.f41261e = bVar2;
                if (bVar2 != null) {
                    return bVar2;
                }
            }
            if (layoutParams != null && ((i3 = layoutParams.height) == 0 || i3 == -1)) {
                for (b bVar3 : b.f41256i) {
                    if (bVar3.f41259c) {
                        this.f41261e = bVar3;
                        return bVar3;
                    }
                }
            }
        }
        b bVar4 = b.f41251d;
        this.f41261e = bVar4;
        return bVar4;
    }

    @Override // q3.a
    @NonNull
    public View getView() {
        View view = this.f41260d;
        if (view == null) {
            return this;
        }
        return view;
    }

    @Override // q3.a
    public boolean isSupportHorizontalDrag() {
        a aVar = this.f41262f;
        if (aVar != null && aVar != this && aVar.isSupportHorizontalDrag()) {
            return true;
        }
        return false;
    }

    @Override // q3.a
    public void onHorizontalDrag(float f16, int i3, int i16) {
        a aVar = this.f41262f;
        if (aVar != null && aVar != this) {
            aVar.onHorizontalDrag(f16, i3, i16);
        }
    }

    public void onMoving(boolean z16, float f16, int i3, int i16, int i17) {
        a aVar = this.f41262f;
        if (aVar != null && aVar != this) {
            aVar.onMoving(z16, f16, i3, i16, i17);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public boolean setNoMoreData(boolean z16) {
        a aVar = this.f41262f;
        if ((aVar instanceof c) && ((c) aVar).setNoMoreData(z16)) {
            return true;
        }
        return false;
    }

    @Override // q3.a
    public void setPrimaryColors(@ColorInt int... iArr) {
        a aVar = this.f41262f;
        if (aVar != null && aVar != this) {
            aVar.setPrimaryColors(iArr);
        }
    }

    protected SimpleComponent(@NonNull View view, @Nullable a aVar) {
        super(view.getContext(), null, 0);
        this.f41260d = view;
        this.f41262f = aVar;
        if ((this instanceof c) && (aVar instanceof d) && aVar.getSpinnerStyle() == b.f41255h) {
            aVar.getView().setScaleY(-1.0f);
            return;
        }
        if (this instanceof d) {
            a aVar2 = this.f41262f;
            if ((aVar2 instanceof c) && aVar2.getSpinnerStyle() == b.f41255h) {
                aVar.getView().setScaleY(-1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SimpleComponent(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
