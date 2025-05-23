package com.tencent.kuikly.core.base;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0005B\u0019\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/kuikly/core/base/u;", "", "", "toString", "", "a", UserInfo.SEX_FEMALE, "getX", "()F", HippyTKDListViewAdapter.X, "b", "getY", "y", "<init>", "(FF)V", "c", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class u {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final u f117211d = new u(1.0f, 1.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float x;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float y;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/kuikly/core/base/u$a;", "", "Lcom/tencent/kuikly/core/base/u;", "DEFAULT", "Lcom/tencent/kuikly/core/base/u;", "a", "()Lcom/tencent/kuikly/core/base/u;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.base.u$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final u a() {
            return u.f117211d;
        }

        Companion() {
        }
    }

    public u(float f16, float f17) {
        this.x = f16;
        this.y = f17;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.x);
        sb5.append(TokenParser.SP);
        sb5.append(this.y);
        return sb5.toString();
    }

    public /* synthetic */ u(float f16, float f17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f16, (i3 & 2) != 0 ? 1.0f : f17);
    }
}
