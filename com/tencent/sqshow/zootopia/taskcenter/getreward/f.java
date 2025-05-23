package com.tencent.sqshow.zootopia.taskcenter.getreward;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskCommonRewardData;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskRewardInfo;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\"\u001a\u00020\u001d\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u001a\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/getreward/f;", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/t;", "", "c", "", "index", "", "type", "a", "result", "b", "error", "", "message", "onResultFailure", "", "Lcom/tencent/sqshow/zootopia/data/w;", "d", "Ljava/util/List;", "getRewardList", "()Ljava/util/List;", "rewardList", "Ldb4/a;", "e", "Ldb4/a;", "getVmHolder", "()Ldb4/a;", "vmHolder", "Lcc4/c;", "f", "Lcc4/c;", "getListener", "()Lcc4/c;", "listener", "Ldc4/a;", h.F, "Ldc4/a;", "repository", "<init>", "(Ljava/util/List;Ldb4/a;Lcc4/c;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f implements com.tencent.mobileqq.zootopia.api.e<ZootopiaTaskCommonRewardData> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<ZootopiaTaskRewardInfo> rewardList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final db4.a vmHolder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final cc4.c listener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final dc4.a repository;

    public f(List<ZootopiaTaskRewardInfo> rewardList, db4.a vmHolder, cc4.c listener) {
        Intrinsics.checkNotNullParameter(rewardList, "rewardList");
        Intrinsics.checkNotNullParameter(vmHolder, "vmHolder");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.rewardList = rewardList;
        this.vmHolder = vmHolder;
        this.listener = listener;
        this.repository = new dc4.b(ZootopiaSource.INSTANCE.g());
    }

    @Override // com.tencent.mobileqq.zootopia.api.e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onResultSuccess(ZootopiaTaskCommonRewardData result) {
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.i("ReceivedRewardController", 1, "onResultSuccess, result" + result);
        List<ZootopiaTaskRewardInfo> list = this.rewardList;
        if (!(list == null || list.isEmpty())) {
            List<ZootopiaTaskRewardInfo> b16 = result.b();
            if (b16 == null || b16.isEmpty()) {
                result.d(this.rewardList);
            }
        }
        List<ZootopiaTaskRewardInfo> b17 = result.b();
        if (b17 != null && (b17.isEmpty() ^ true)) {
            this.listener.a(result.b(), result.a());
            c();
        } else {
            this.vmHolder.I4(3);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.api.e
    public void onResultFailure(int error, String message) {
        QLog.i("ReceivedRewardController", 1, "onResultFailure, error:" + error + ", message:" + message);
        c();
        this.vmHolder.I4(2);
        this.listener.d(error, message);
    }

    private final void c() {
        QLog.i("ReceivedRewardController", 1, "refreshTaskData after reqeust");
        Object cache = ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).getCache("task_panel_handler", ZplanCacheComponentType.PARENT_PAGE_HANDLER);
        k84.a aVar = cache instanceof k84.a ? (k84.a) cache : null;
        if (aVar != null) {
            aVar.ne();
        }
        yb4.e.g(yb4.e.f450058a, "refreshTaskData", 0, 2, null);
        ZPlanRedDotManager.f373437a.x();
        BaseApplication.getContext().sendBroadcast(new Intent("action_broadcast_reward"));
    }

    public final void a(long index, int type) {
        if (type == 0) {
            this.repository.f((int) index, this);
        } else if (type == 1) {
            this.repository.a(this);
        } else {
            if (type != 2) {
                return;
            }
            this.repository.c(1L, index, this);
        }
    }
}
