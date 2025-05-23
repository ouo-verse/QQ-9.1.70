package com.tencent.sqshow.push;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.mobileqq.zplan.push.b;
import com.tencent.mobileqq.zplan.push.i;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001/B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ&\u0010\u000e\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0017\u0018\u00010\u0016H\u0014R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R'\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00070%j\b\u0012\u0004\u0012\u00020\u0007`&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/sqshow/push/ZPlanOIDBPushHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "Lcom/tencent/mobileqq/zplan/push/b;", "Lcom/tencent/mobileqq/zplan/push/i;", "observer", "", "F2", "Lcom/tencent/mobileqq/zplan/push/h;", "E2", Constants.MMCCID, "", "cmdId", "", "buf", "onReceive", Constants.BASE_IN_PLUGIN_VERSION, "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "getApp", "()Lcom/tencent/common/app/AppInterface;", "app", "", "e", "Ljava/util/List;", "getObserverList", "()Ljava/util/List;", "observerList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "f", "Ljava/util/HashSet;", "getCommonObserver", "()Ljava/util/HashSet;", "commonObserver", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", h.F, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanOIDBPushHandler extends BusinessHandler implements b {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AppInterface app;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<i> observerList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final HashSet<com.tencent.mobileqq.zplan.push.h> commonObserver;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/push/ZPlanOIDBPushHandler$a;", "", "Lcom/tencent/sqshow/push/ZPlanOIDBPushHandler;", "a", "", "CMD_KICK_OUT_GAME", "I", "CMD_RED_DOT", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.push.ZPlanOIDBPushHandler$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanOIDBPushHandler a() {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            BusinessHandler businessHandler = appInterface != null ? appInterface.getBusinessHandler(ZPlanOIDBPushHandler.class.getName()) : null;
            if (businessHandler instanceof ZPlanOIDBPushHandler) {
                return (ZPlanOIDBPushHandler) businessHandler;
            }
            return null;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanOIDBPushHandler(AppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        this.app = app;
        this.observerList = new ArrayList();
        this.commonObserver = new HashSet<>();
    }

    public final void D2(int cmdId, byte[] buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        List<i> list = this.observerList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((i) obj).getCmdId() == cmdId) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((i) it.next()).b(buf);
        }
        Iterator<T> it5 = this.commonObserver.iterator();
        while (it5.hasNext()) {
            ((com.tencent.mobileqq.zplan.push.h) it5.next()).onReceive(cmdId, buf);
        }
    }

    public final void E2(com.tencent.mobileqq.zplan.push.h observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.commonObserver.add(observer);
    }

    public final void G2(i observer) {
        TypeIntrinsics.asMutableCollection(this.observerList).remove(observer);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg req, FromServiceMsg res, Object data) {
    }

    @Override // com.tencent.mobileqq.zplan.push.b
    public void onReceive(int cmdId, byte[] buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        D2(cmdId, buf);
        ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).oidbPushForMainProcessOnReceive(cmdId, buf);
    }

    public final void F2(i observer) {
        if (observer == null || this.observerList.contains(observer)) {
            return;
        }
        this.observerList.add(observer);
    }
}
