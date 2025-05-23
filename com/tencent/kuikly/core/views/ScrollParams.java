package com.tencent.kuikly.core.views;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0018\b\u0086\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\nB?\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0016\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0019\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u001a\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u001e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/kuikly/core/views/bn;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "c", "()F", tl.h.F, "(F)V", "offsetX", "b", "d", "i", "offsetY", "contentWidth", "contentHeight", "e", "f", "viewWidth", "viewHeight", "g", "Z", "()Z", "isDragging", "<init>", "(FFFFFFZ)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.kuikly.core.views.bn, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class ScrollParams {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private float offsetX;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private float offsetY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float contentWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final float contentHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final float viewWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final float viewHeight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isDragging;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/kuikly/core/views/bn$a;", "", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "params", "Lcom/tencent/kuikly/core/views/bn;", "a", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.views.bn$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ScrollParams a(com.tencent.kuikly.core.nvi.serialization.json.e params) {
            Intrinsics.checkNotNullParameter(params, "params");
            return new ScrollParams((float) params.h("offsetX"), (float) params.h("offsetY"), (float) params.h("contentWidth"), (float) params.h("contentHeight"), (float) params.h("viewWidth"), (float) params.h("viewHeight"), params.j("isDragging") == 1);
        }

        Companion() {
        }
    }

    public ScrollParams(float f16, float f17, float f18, float f19, float f26, float f27, boolean z16) {
        this.offsetX = f16;
        this.offsetY = f17;
        this.contentWidth = f18;
        this.contentHeight = f19;
        this.viewWidth = f26;
        this.viewHeight = f27;
        this.isDragging = z16;
    }

    /* renamed from: a, reason: from getter */
    public final float getContentHeight() {
        return this.contentHeight;
    }

    /* renamed from: b, reason: from getter */
    public final float getContentWidth() {
        return this.contentWidth;
    }

    /* renamed from: c, reason: from getter */
    public final float getOffsetX() {
        return this.offsetX;
    }

    /* renamed from: d, reason: from getter */
    public final float getOffsetY() {
        return this.offsetY;
    }

    /* renamed from: e, reason: from getter */
    public final float getViewHeight() {
        return this.viewHeight;
    }

    /* renamed from: f, reason: from getter */
    public final float getViewWidth() {
        return this.viewWidth;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsDragging() {
        return this.isDragging;
    }

    public final void h(float f16) {
        this.offsetX = f16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((((((((((Float.floatToIntBits(this.offsetX) * 31) + Float.floatToIntBits(this.offsetY)) * 31) + Float.floatToIntBits(this.contentWidth)) * 31) + Float.floatToIntBits(this.contentHeight)) * 31) + Float.floatToIntBits(this.viewWidth)) * 31) + Float.floatToIntBits(this.viewHeight)) * 31;
        boolean z16 = this.isDragging;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return floatToIntBits + i3;
    }

    public final void i(float f16) {
        this.offsetY = f16;
    }

    public String toString() {
        return "ScrollParams(offsetX=" + this.offsetX + ", offsetY=" + this.offsetY + ", contentWidth=" + this.contentWidth + ", contentHeight=" + this.contentHeight + ", viewWidth=" + this.viewWidth + ", viewHeight=" + this.viewHeight + ", isDragging=" + this.isDragging + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScrollParams)) {
            return false;
        }
        ScrollParams scrollParams = (ScrollParams) other;
        return Float.compare(this.offsetX, scrollParams.offsetX) == 0 && Float.compare(this.offsetY, scrollParams.offsetY) == 0 && Float.compare(this.contentWidth, scrollParams.contentWidth) == 0 && Float.compare(this.contentHeight, scrollParams.contentHeight) == 0 && Float.compare(this.viewWidth, scrollParams.viewWidth) == 0 && Float.compare(this.viewHeight, scrollParams.viewHeight) == 0 && this.isDragging == scrollParams.isDragging;
    }
}
