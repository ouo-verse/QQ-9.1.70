package com.tencent.kuikly.core.base;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/kuikly/core/base/a;", "", "", "toString", "", "a", UserInfo.SEX_FEMALE, HippyTKDListViewAdapter.X, "b", "y", "<init>", "(FF)V", "c", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final a f117080d = new a(0.5f, 0.5f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float x;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float y;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/kuikly/core/base/a$a;", "", "Lcom/tencent/kuikly/core/base/a;", "DEFAULT", "Lcom/tencent/kuikly/core/base/a;", "a", "()Lcom/tencent/kuikly/core/base/a;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.base.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a() {
            return a.f117080d;
        }

        Companion() {
        }
    }

    public a(float f16, float f17) {
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
}
