package com.tencent.kuikly.core.layout;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0011B/\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\nJ\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0017\u0010\u0015\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/kuikly/core/layout/d;", "", "Lcom/tencent/kuikly/core/layout/h;", "k", "other", "", "equals", "", "hashCode", "f", "", "j", tl.h.F, "i", "g", "", "toString", "a", UserInfo.SEX_FEMALE, "d", "()F", HippyTKDListViewAdapter.X, "b", "e", "y", "c", "width", "height", "<init>", "(FFFF)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final /* data */ class d {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final d f117323f = new d(0.0f, 0.0f, 0.0f, 0.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float x;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float y;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float width;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float height;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/kuikly/core/layout/d$a;", "", "Lcom/tencent/kuikly/core/layout/d;", "zero", "Lcom/tencent/kuikly/core/layout/d;", "a", "()Lcom/tencent/kuikly/core/layout/d;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.layout.d$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            return d.f117323f;
        }

        Companion() {
        }
    }

    public d() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    }

    /* renamed from: b, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    /* renamed from: c, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    /* renamed from: d, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: e, reason: from getter */
    public final float getY() {
        return this.y;
    }

    public boolean equals(Object other) {
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.kuikly.core.layout.Frame");
        d dVar = (d) other;
        if (this.x == dVar.x) {
            if (this.y == dVar.y) {
                if (this.width == dVar.width) {
                    if (this.height == dVar.height) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean f() {
        return this == f117323f;
    }

    public final float g() {
        return this.x + this.width;
    }

    public final float h() {
        return this.y + this.height;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public final float i() {
        return this.x;
    }

    public final float j() {
        return this.y;
    }

    public final h k() {
        return new h(this.x, this.y, this.width, this.height);
    }

    public String toString() {
        return "x:" + this.x + " y:" + this.y + " width:" + this.width + " height:" + this.height;
    }

    public d(float f16, float f17, float f18, float f19) {
        this.x = f16;
        this.y = f17;
        this.width = f18;
        this.height = f19;
    }

    public /* synthetic */ d(float f16, float f17, float f18, float f19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17, (i3 & 4) != 0 ? 0.0f : f18, (i3 & 8) != 0 ? 0.0f : f19);
    }
}
