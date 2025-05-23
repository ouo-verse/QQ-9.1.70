package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.mapsdk.internal.aq;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class aw<D extends aq> implements fb {

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicInteger f147777b = new AtomicInteger(1);
    protected final String c_ = String.valueOf(f147777b.incrementAndGet());

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect getScreenBound(fa faVar) {
        return f_().getScreenBound(faVar);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: b */
    public Rect getBound(fa faVar) {
        return f_().getBound(faVar);
    }

    public abstract D f_();

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    public List<Boundable<fa>> getGroupBounds() {
        return f_().getGroupBounds();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    public String getId() {
        return f_().getId();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public int getLevel() {
        return f_().getLevel();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public int getZIndex() {
        return f_().getZIndex();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public boolean handleOnTap() {
        return f_().handleOnTap();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public boolean isRemoved() {
        return f_().isRemoved();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public boolean isSelected() {
        return f_().isSelected();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public boolean isVisible() {
        return f_().isVisible();
    }

    @Override // com.tencent.mapsdk.internal.fb
    public long o() {
        return f_().o();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public boolean onTap(float f16, float f17) {
        return f_().onTap(f16, f17);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public void releaseData() {
        f_().releaseData();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public void remove() {
        f_().remove();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void setLevel(int i3) {
        f_().setLevel(i3);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public void setSelected(boolean z16) {
        f_().setSelected(z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public <T> void setSelectedListener(Selectable.OnSelectedListener<T> onSelectedListener) {
        f_().setSelectedListener(onSelectedListener);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public void setVisible(boolean z16) {
        f_().setVisible(z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public void setZIndex(int i3) {
        f_().setZIndex(i3);
    }

    @Override // com.tencent.mapsdk.internal.ev
    public void a(GL10 gl10) {
        f_().a(gl10);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public void setZIndex(float f16) {
        setZIndex((int) f16);
    }
}
