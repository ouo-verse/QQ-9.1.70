package com.tencent.kuikly.core.base.event;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001\nBE\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0013\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0012\u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/kuikly/core/base/event/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "d", "()F", HippyTKDListViewAdapter.X, "b", "e", "y", "c", "pageX", "pageY", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "action", "f", "Z", "()Z", "isCancelEvent", "", "Lcom/tencent/kuikly/core/base/event/j;", "g", "Ljava/util/List;", "()Ljava/util/List;", "touches", "<init>", "(FFFFLjava/lang/String;ZLjava/util/List;)V", tl.h.F, "core_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.kuikly.core.base.event.k, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class TouchParams {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float x;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float y;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float pageX;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final float pageY;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String action;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isCancelEvent;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<j> touches;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/kuikly/core/base/event/k$a;", "", "params", "Lcom/tencent/kuikly/core/base/event/k;", "a", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.base.event.k$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TouchParams a(Object params) {
            com.tencent.kuikly.core.nvi.serialization.json.e eVar = params instanceof com.tencent.kuikly.core.nvi.serialization.json.e ? (com.tencent.kuikly.core.nvi.serialization.json.e) params : null;
            if (eVar == null) {
                eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
            }
            float h16 = (float) eVar.h(HippyTKDListViewAdapter.X);
            float h17 = (float) eVar.h("y");
            float h18 = (float) eVar.h("pageX");
            float h19 = (float) eVar.h("pageY");
            String p16 = eVar.p("action");
            boolean g16 = eVar.g("cancel", false);
            ArrayList arrayList = new ArrayList();
            com.tencent.kuikly.core.nvi.serialization.json.b l3 = eVar.l("touches");
            if (l3 != null) {
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    arrayList.add(j.INSTANCE.a(l3.d(i3)));
                }
            }
            return new TouchParams(h16, h17, h18, h19, p16, g16, arrayList);
        }

        Companion() {
        }
    }

    public TouchParams(float f16, float f17, float f18, float f19, String action, boolean z16, List<j> touches) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(touches, "touches");
        this.x = f16;
        this.y = f17;
        this.pageX = f18;
        this.pageY = f19;
        this.action = action;
        this.isCancelEvent = z16;
        this.touches = touches;
    }

    /* renamed from: a, reason: from getter */
    public final float getPageX() {
        return this.pageX;
    }

    /* renamed from: b, reason: from getter */
    public final float getPageY() {
        return this.pageY;
    }

    public final List<j> c() {
        return this.touches;
    }

    /* renamed from: d, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: e, reason: from getter */
    public final float getY() {
        return this.y;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsCancelEvent() {
        return this.isCancelEvent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((((((((Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.pageX)) * 31) + Float.floatToIntBits(this.pageY)) * 31) + this.action.hashCode()) * 31;
        boolean z16 = this.isCancelEvent;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((floatToIntBits + i3) * 31) + this.touches.hashCode();
    }

    public String toString() {
        return "TouchParams(x=" + this.x + ", y=" + this.y + ", pageX=" + this.pageX + ", pageY=" + this.pageY + ", action=" + this.action + ", isCancelEvent=" + this.isCancelEvent + ", touches=" + this.touches + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TouchParams)) {
            return false;
        }
        TouchParams touchParams = (TouchParams) other;
        return Float.compare(this.x, touchParams.x) == 0 && Float.compare(this.y, touchParams.y) == 0 && Float.compare(this.pageX, touchParams.pageX) == 0 && Float.compare(this.pageY, touchParams.pageY) == 0 && Intrinsics.areEqual(this.action, touchParams.action) && this.isCancelEvent == touchParams.isCancelEvent && Intrinsics.areEqual(this.touches, touchParams.touches);
    }
}
