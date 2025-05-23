package com.tencent.mobileqq.activity.aio.drawer;

import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/drawer/e;", "Lcom/tencent/qqnt/aio/frame/c;", "Lcom/tencent/aio/data/AIOParam;", "param", "Lcom/tencent/aio/frame/api/c;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e implements com.tencent.qqnt.aio.frame.c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/activity/aio/drawer/e$a", "Lcom/tencent/aio/frame/api/c;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a extends com.tencent.aio.frame.api.c {
        a() {
        }
    }

    @Override // com.tencent.qqnt.aio.frame.c
    @NotNull
    public com.tencent.aio.frame.api.c a(@NotNull AIOParam param) {
        String currentUid;
        Intrinsics.checkNotNullParameter(param, "param");
        AIOSession r16 = param.r();
        boolean z16 = false;
        if (r16.c().e() == 2) {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102845", false)) {
                return new TroopAppNewDrawer(r16);
            }
            return new TroopAppShortcutDrawer(r16);
        }
        if (r16.c().e() == 1) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (currentUid = peekAppRuntime.getCurrentUid()) != null && !currentUid.equals(r16.c().j())) {
                z16 = true;
            }
            if (z16) {
                return new FriendIntimateInfoDrawer(param);
            }
        }
        return new a();
    }
}
