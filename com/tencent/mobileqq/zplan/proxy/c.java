package com.tencent.mobileqq.zplan.proxy;

import android.content.Context;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.report.PerfReportUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.av;
import com.tencent.mobileqq.zplan.ZPlanAppInterface;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/c;", "Llx4/a;", "Lcom/tencent/common/app/AppInterface;", "d", "", "getNetWorkType", "getCarrier", "", "getImei", "c", "getGender", "userId", "Landroid/content/Context;", "getContext", "a", "", "isDebugVersion", "getCurrentUin", "b", "", "getServerTime", "Lcom/tencent/mobileqq/zootopia/api/a;", "Lcom/tencent/mobileqq/zootopia/api/a;", "getUeModprocessor", "()Lcom/tencent/mobileqq/zootopia/api/a;", "setUeModprocessor", "(Lcom/tencent/mobileqq/zootopia/api/a;)V", "ueModprocessor", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c implements lx4.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zootopia.api.a ueModprocessor = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/proxy/c$b", "Lcom/tencent/mobileqq/zootopia/api/a;", "", "mapId", "", "mapName", "", "doEnterUEMap", "doExitUEMap", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.a {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.a
        public void doEnterUEMap(int mapId, String mapName) {
            Intrinsics.checkNotNullParameter(mapName, "mapName");
            PerfReportUtil.j(mapId, mapName);
        }

        @Override // com.tencent.mobileqq.zootopia.api.a
        public void doExitUEMap(int mapId, String mapName) {
            Intrinsics.checkNotNullParameter(mapName, "mapName");
        }
    }

    private final AppInterface d() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface ? true : runtime instanceof ZPlanAppInterface) {
            AppRuntime runtime2 = BaseApplicationImpl.getApplication().getRuntime();
            Intrinsics.checkNotNull(runtime2, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            return (AppInterface) runtime2;
        }
        if (!(runtime instanceof ToolAppRuntime)) {
            return null;
        }
        AppRuntime appRuntime = BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web");
        Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        return (AppInterface) appRuntime;
    }

    @Override // lx4.a
    public String a() {
        return AppSetting.f99551k + "." + AppSetting.f99542b;
    }

    @Override // lx4.a
    public boolean b() {
        return !t74.s.f435588a.a();
    }

    @Override // lx4.a
    public String c() {
        String a16 = av.a(BaseApplication.getContext());
        return a16 == null ? "" : a16;
    }

    @Override // lx4.a
    public int getCarrier() {
        return ah.H(BaseApplication.getContext());
    }

    @Override // lx4.a
    public Context getContext() {
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        return context;
    }

    @Override // lx4.a
    public String getCurrentUin() {
        AppInterface d16 = d();
        if (d16 != null) {
            return d16.getCurrentUin();
        }
        return null;
    }

    @Override // lx4.a
    public int getGender() {
        AppInterface d16 = d();
        String currentAccountUin = d16 != null ? d16.getCurrentAccountUin() : null;
        int o16 = bb.f335811a.o(currentAccountUin);
        QLog.i("[zplan]_ZPlanCommonProxy", 1, "senderUin:" + currentAccountUin + ", senderGender: " + o16);
        return o16;
    }

    @Override // lx4.a
    public String getImei() {
        String qimei = QQDeviceInfo.getQIMEI();
        Intrinsics.checkNotNullExpressionValue(qimei, "getQIMEI()");
        return qimei;
    }

    @Override // lx4.a
    public int getNetWorkType() {
        int netWorkType = HttpUtil.getNetWorkType();
        QLog.d("[zplan]_ZPlanCommonProxy", 1, "getNetWorkType type: " + netWorkType);
        return netWorkType;
    }

    @Override // lx4.a
    public long getServerTime() {
        return NetConnInfoCenter.getServerTime();
    }

    @Override // lx4.a
    public boolean isDebugVersion() {
        return false;
    }

    @Override // lx4.a
    public int getGender(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return bb.f335811a.o(userId);
    }
}
