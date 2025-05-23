package com.tencent.kuikly.core.base.event;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\nB'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0013\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0015\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/kuikly/core/base/event/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "getX", "()F", HippyTKDListViewAdapter.X, "b", "getY", "y", "c", "pageX", "d", "pageY", "<init>", "(FFFF)V", "e", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final /* data */ class j {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float x;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float y;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float pageX;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float pageY;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/kuikly/core/base/event/j$a;", "", "params", "Lcom/tencent/kuikly/core/base/event/j;", "a", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.base.event.j$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final j a(Object params) {
            com.tencent.kuikly.core.nvi.serialization.json.e eVar = params instanceof com.tencent.kuikly.core.nvi.serialization.json.e ? (com.tencent.kuikly.core.nvi.serialization.json.e) params : null;
            if (eVar == null) {
                eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
            }
            return new j((float) eVar.h(HippyTKDListViewAdapter.X), (float) eVar.h("y"), (float) eVar.h("pageX"), (float) eVar.h("pageY"));
        }

        Companion() {
        }
    }

    public j(float f16, float f17, float f18, float f19) {
        this.x = f16;
        this.y = f17;
        this.pageX = f18;
        this.pageY = f19;
    }

    /* renamed from: a, reason: from getter */
    public final float getPageX() {
        return this.pageX;
    }

    /* renamed from: b, reason: from getter */
    public final float getPageY() {
        return this.pageY;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.pageX)) * 31) + Float.floatToIntBits(this.pageY);
    }

    public String toString() {
        return "x:" + this.x + ", y:" + this.y + ", pageX:" + this.pageX + ", pageY:" + this.pageY;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof j)) {
            return false;
        }
        j jVar = (j) other;
        return Float.compare(this.x, jVar.x) == 0 && Float.compare(this.y, jVar.y) == 0 && Float.compare(this.pageX, jVar.pageX) == 0 && Float.compare(this.pageY, jVar.pageY) == 0;
    }
}
