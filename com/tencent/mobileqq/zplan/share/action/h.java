package com.tencent.mobileqq.zplan.share.action;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0006B%\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R%\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/action/h;", "Lcom/tencent/mobileqq/zplan/share/action/a;", "", "onFinish", "onResume", "Lcom/tencent/mobileqq/zplan/share/report/c;", "a", "", "", "", "d", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "extra", "", "shareType", "<init>", "(ILjava/util/Map;)V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final CopyOnWriteArraySet<c> f335512f = new CopyOnWriteArraySet<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Object> extra;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/action/h$a;", "", "Lcom/tencent/mobileqq/zplan/share/action/c;", "listener", "", "a", "", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "listenerSet", "Ljava/util/concurrent/CopyOnWriteArraySet;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.share.action.h$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(c listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            h.f335512f.add(listener);
        }

        Companion() {
        }
    }

    public h(int i3, Map<String, ? extends Object> map) {
        super(i3);
        this.extra = map;
    }

    @Override // com.tencent.mobileqq.zplan.share.action.a, com.tencent.mobileqq.zplan.share.action.b
    public com.tencent.mobileqq.zplan.share.report.c a() {
        Map<String, Object> map = this.extra;
        Object obj = map != null ? map.get("source") : null;
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        return new com.tencent.mobileqq.zplan.share.report.h(num != null ? num.intValue() : 0);
    }

    @Override // com.tencent.mobileqq.zplan.share.action.a, com.tencent.mobileqq.zplan.share.action.b
    public void onFinish() {
        super.onFinish();
        Iterator<T> it = f335512f.iterator();
        while (it.hasNext()) {
            ((c) it.next()).t();
        }
        f335512f.clear();
    }

    @Override // com.tencent.mobileqq.zplan.share.action.a, com.tencent.mobileqq.zplan.share.action.b
    public void onResume() {
        super.onResume();
        Iterator<T> it = f335512f.iterator();
        while (it.hasNext()) {
            ((c) it.next()).f();
        }
    }
}
