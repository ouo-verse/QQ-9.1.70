package com.tencent.mobileqq.zplan.proxy;

import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.push.ZPlanOIDBPushHandler;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R$\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/p;", "Lcom/tencent/mobileqq/zplan/push/h;", "Lyx4/d;", "Lay4/a;", "observer", "", "a", "", "cmdId", "", "buf", "onReceive", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "d", "Ljava/util/HashSet;", "mListenerPool", "<init>", "()V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class p implements com.tencent.mobileqq.zplan.push.h, yx4.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final HashSet<ay4.a> mListenerPool = new HashSet<>();

    public p() {
        ZPlanOIDBPushHandler a16 = ZPlanOIDBPushHandler.INSTANCE.a();
        QLog.i("QQZPlanPushProxy_", 1, "pushHandler:" + a16);
        if (a16 != null) {
            a16.E2(this);
        }
    }

    @Override // yx4.d
    public void a(ay4.a observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mListenerPool.add(observer);
    }

    @Override // com.tencent.mobileqq.zplan.push.b
    public void onReceive(int cmdId, byte[] buf) {
        QLog.i("QQZPlanPushProxy_", 1, "onReceive cmdId:" + cmdId + ", buf:" + buf + ", listeners:" + this.mListenerPool);
        Iterator<ay4.a> it = this.mListenerPool.iterator();
        while (it.hasNext()) {
            it.next().onReceive(cmdId, buf);
        }
    }
}
