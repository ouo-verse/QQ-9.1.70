package jc3;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.lua.ar;
import com.tencent.mobileqq.zootopia.utils.DataConvertUtil;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaEvent;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"Ljc3/f;", "Lcom/tencent/mobileqq/z1/lua/b;", "Ljc3/a;", "", "", "j", "k", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleSoftInputAction", "Ljc3/g;", "inputEvent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f extends com.tencent.mobileqq.z1.lua.b<jc3.a> {

    /* renamed from: e, reason: collision with root package name */
    public static final f f409790e = new f();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"jc3/f$a", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "", "success", "", "engineInitFinish", UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements ZPlanEngineStatusUpdateListener {
        a() {
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineDestroy() {
            ZPlanEngineStatusUpdateListener.a.a(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
        public void engineFirstFrame() {
            ZPlanEngineStatusUpdateListener.a.b(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInitFinish(boolean success) {
            ZPlanEngineStatusUpdateListener.a.c(this, success);
            QLog.i("ZPlanSoftInputPlugin_", 1, "engineInitFinish success:" + success);
            if (success) {
                ar.f328509a.b(f.f409790e);
            }
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInversePurged() {
            ZPlanEngineStatusUpdateListener.a.d(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurged() {
            ZPlanEngineStatusUpdateListener.a.e(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurging() {
            ZPlanEngineStatusUpdateListener.a.f(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineSuspended() {
            ZPlanEngineStatusUpdateListener.a.g(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void hotPatchDownloadFailed(int i3, String str) {
            ZPlanEngineStatusUpdateListener.a.h(this, i3, str);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void serviceConnected(boolean connect) {
            ZPlanEngineStatusUpdateListener.a.i(this, connect);
            QLog.i("ZPlanSoftInputPlugin_", 1, "serviceConnected connect:" + connect);
            if (connect) {
                return;
            }
            f.f409790e.k();
        }
    }

    static {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: jc3.d
            @Override // java.lang.Runnable
            public final void run() {
                f.g();
            }
        });
    }

    f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        f409790e.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ZPlanSoftInputIns instruction) {
        for (jc3.a aVar : f409790e.a()) {
            Intrinsics.checkNotNullExpressionValue(instruction, "instruction");
            aVar.a(instruction);
        }
    }

    private final void j() {
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).registerZPlanEngineStatusUpdateListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: jc3.e
            @Override // java.lang.Runnable
            public final void run() {
                f.l();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l() {
        ZPlanSoftInputIns zPlanSoftInputIns = new ZPlanSoftInputIns(1, "", "");
        Iterator<T> it = f409790e.a().iterator();
        while (it.hasNext()) {
            ((jc3.a) it.next()).a(zPlanSoftInputIns);
        }
    }

    @LuaEvent("L2N_SoftInputAction")
    public final String handleSoftInputAction(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanSoftInputPlugin_", 1, "handleSoftInputAction, params:" + argument.getF440574c());
        final ZPlanSoftInputIns zPlanSoftInputIns = (ZPlanSoftInputIns) DataConvertUtil.f329546a.a().fromJson(argument.getF440574c(), ZPlanSoftInputIns.class);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: jc3.c
            @Override // java.lang.Runnable
            public final void run() {
                f.i(ZPlanSoftInputIns.this);
            }
        });
        return argument.ok();
    }

    public void m(ZPlanTextInputEvent inputEvent) {
        Intrinsics.checkNotNullParameter(inputEvent, "inputEvent");
        String json = DataConvertUtil.f329546a.a().toJson(inputEvent);
        QLog.i("ZPlanSoftInputPlugin_", 1, "onTextInputEvent, params:" + json);
        ar.f328509a.a("N2L_SoftInputCallback", json);
    }
}
