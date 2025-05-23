package com.tencent.kuikly.core.base.event;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\b\b\u0002\u0010!\u001a\u00020\t\u0012\b\b\u0002\u0010$\u001a\u00020\t\u0012\b\b\u0002\u0010'\u001a\u00020\t\u0012\b\b\u0002\u0010*\u001a\u00020\t\u0012\b\b\u0002\u0010-\u001a\u00020\t\u0012\b\b\u0002\u00100\u001a\u00020\t\u00a2\u0006\u0004\b1\u00102J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0017\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010!\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\rR\u0017\u0010$\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\rR\u0017\u0010'\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\rR\u0017\u0010*\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\rR\u0017\u0010-\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\rR\u0017\u00100\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b/\u0010\r\u00a8\u00063"}, d2 = {"Lcom/tencent/kuikly/core/base/event/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "d", "()F", HippyTKDListViewAdapter.X, "b", "e", "y", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "state", "pageX", "pageY", "", "Lcom/tencent/kuikly/core/base/event/j;", "f", "Ljava/util/List;", "getTouches", "()Ljava/util/List;", "touches", "g", "getDeltaScale", "deltaScale", tl.h.F, "getDeltaRotate", "deltaRotate", "i", "getDeltaTranslateX", "deltaTranslateX", "j", "getDeltaTranslateY", "deltaTranslateY", "k", "getAnchorPageX", "anchorPageX", "l", "getAnchorPageY", "anchorPageY", "<init>", "(FFLjava/lang/String;FFLjava/util/List;FFFFFF)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.kuikly.core.base.event.h, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class PanGestureParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float x;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float y;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String state;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final float pageX;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final float pageY;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<j> touches;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final float deltaScale;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final float deltaRotate;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final float deltaTranslateX;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final float deltaTranslateY;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final float anchorPageX;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final float anchorPageY;

    public PanGestureParams(float f16, float f17, String state, float f18, float f19, List<j> touches, float f26, float f27, float f28, float f29, float f36, float f37) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(touches, "touches");
        this.x = f16;
        this.y = f17;
        this.state = state;
        this.pageX = f18;
        this.pageY = f19;
        this.touches = touches;
        this.deltaScale = f26;
        this.deltaRotate = f27;
        this.deltaTranslateX = f28;
        this.deltaTranslateY = f29;
        this.anchorPageX = f36;
        this.anchorPageY = f37;
    }

    /* renamed from: a, reason: from getter */
    public final float getPageX() {
        return this.pageX;
    }

    /* renamed from: b, reason: from getter */
    public final float getPageY() {
        return this.pageY;
    }

    /* renamed from: c, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: d, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: e, reason: from getter */
    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return (((((((((((((((((((((Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y)) * 31) + this.state.hashCode()) * 31) + Float.floatToIntBits(this.pageX)) * 31) + Float.floatToIntBits(this.pageY)) * 31) + this.touches.hashCode()) * 31) + Float.floatToIntBits(this.deltaScale)) * 31) + Float.floatToIntBits(this.deltaRotate)) * 31) + Float.floatToIntBits(this.deltaTranslateX)) * 31) + Float.floatToIntBits(this.deltaTranslateY)) * 31) + Float.floatToIntBits(this.anchorPageX)) * 31) + Float.floatToIntBits(this.anchorPageY);
    }

    public String toString() {
        return "PanGestureParams(x=" + this.x + ", y=" + this.y + ", state=" + this.state + ", pageX=" + this.pageX + ", pageY=" + this.pageY + ", touches=" + this.touches + ", deltaScale=" + this.deltaScale + ", deltaRotate=" + this.deltaRotate + ", deltaTranslateX=" + this.deltaTranslateX + ", deltaTranslateY=" + this.deltaTranslateY + ", anchorPageX=" + this.anchorPageX + ", anchorPageY=" + this.anchorPageY + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PanGestureParams)) {
            return false;
        }
        PanGestureParams panGestureParams = (PanGestureParams) other;
        return Float.compare(this.x, panGestureParams.x) == 0 && Float.compare(this.y, panGestureParams.y) == 0 && Intrinsics.areEqual(this.state, panGestureParams.state) && Float.compare(this.pageX, panGestureParams.pageX) == 0 && Float.compare(this.pageY, panGestureParams.pageY) == 0 && Intrinsics.areEqual(this.touches, panGestureParams.touches) && Float.compare(this.deltaScale, panGestureParams.deltaScale) == 0 && Float.compare(this.deltaRotate, panGestureParams.deltaRotate) == 0 && Float.compare(this.deltaTranslateX, panGestureParams.deltaTranslateX) == 0 && Float.compare(this.deltaTranslateY, panGestureParams.deltaTranslateY) == 0 && Float.compare(this.anchorPageX, panGestureParams.anchorPageX) == 0 && Float.compare(this.anchorPageY, panGestureParams.anchorPageY) == 0;
    }
}
