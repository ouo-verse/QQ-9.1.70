package com.tencent.kuikly.core.base.event;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\nB#\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/kuikly/core/base/event/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "b", "()F", HippyTKDListViewAdapter.X, "c", "y", "Ljava/lang/Object;", "()Ljava/lang/Object;", "params", "<init>", "(FFLjava/lang/Object;)V", "d", "core_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.kuikly.core.base.event.c, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class ClickParams {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float x;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float y;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final Object params;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/kuikly/core/base/event/c$a;", "", "params", "Lcom/tencent/kuikly/core/base/event/c;", "a", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.base.event.c$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ClickParams a(Object params) {
            com.tencent.kuikly.core.nvi.serialization.json.e eVar = params instanceof com.tencent.kuikly.core.nvi.serialization.json.e ? (com.tencent.kuikly.core.nvi.serialization.json.e) params : null;
            if (eVar == null) {
                eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
            }
            return new ClickParams((float) eVar.h(HippyTKDListViewAdapter.X), (float) eVar.h("y"), params);
        }

        Companion() {
        }
    }

    public ClickParams(float f16, float f17, Object obj) {
        this.x = f16;
        this.y = f17;
        this.params = obj;
    }

    /* renamed from: a, reason: from getter */
    public final Object getParams() {
        return this.params;
    }

    /* renamed from: b, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: c, reason: from getter */
    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        int floatToIntBits = ((Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y)) * 31;
        Object obj = this.params;
        return floatToIntBits + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "ClickParams(x=" + this.x + ", y=" + this.y + ", params=" + this.params + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClickParams)) {
            return false;
        }
        ClickParams clickParams = (ClickParams) other;
        return Float.compare(this.x, clickParams.x) == 0 && Float.compare(this.y, clickParams.y) == 0 && Intrinsics.areEqual(this.params, clickParams.params);
    }
}
