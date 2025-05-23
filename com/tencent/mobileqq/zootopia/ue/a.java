package com.tencent.mobileqq.zootopia.ue;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.lua.ar;
import com.tencent.mobileqq.zootopia.ue.c;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0017J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH$R\"\u0010\u0003\u001a\u00020\u00028\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0005\u001a\u00020\u00048\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u000e\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ue/a;", "Lcom/tencent/mobileqq/zootopia/ue/c;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zootopia/ue/d;", DownloadInfo.spKey_Config, "", "u9", "", "success", "engineInitFinish", "", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "e", "d", "Landroidx/fragment/app/FragmentActivity;", "c", "()Landroidx/fragment/app/FragmentActivity;", "f", "(Landroidx/fragment/app/FragmentActivity;)V", "Lcom/tencent/mobileqq/zootopia/ue/d;", "()Lcom/tencent/mobileqq/zootopia/ue/d;", "g", "(Lcom/tencent/mobileqq/zootopia/ue/d;)V", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class a implements c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected FragmentActivity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected d config;

    /* JADX INFO: Access modifiers changed from: protected */
    public final FragmentActivity c() {
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final d d() {
        d dVar = this.config;
        if (dVar != null) {
            return dVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        return null;
    }

    protected abstract List<LuaBasePlugin> e();

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineDestroy() {
        c.a.a(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
    public void engineFirstFrame() {
        c.a.b(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInversePurged() {
        c.a.d(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurged() {
        c.a.e(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurging() {
        c.a.f(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineSuspended() {
        c.a.g(this);
    }

    protected final void f(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<set-?>");
        this.activity = fragmentActivity;
    }

    protected final void g(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.config = dVar;
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void hotPatchDownloadFailed(int i3, String str) {
        c.a.h(this, i3, str);
    }

    @Override // com.tencent.mobileqq.zootopia.ue.c
    public void pause() {
        c.a.i(this);
    }

    @Override // com.tencent.mobileqq.zootopia.ue.c
    public void resume() {
        c.a.j(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void serviceConnected(boolean z16) {
        c.a.k(this, z16);
    }

    @Override // com.tencent.mobileqq.zootopia.ue.c
    public void u9(FragmentActivity activity, d config) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(config, "config");
        f(activity);
        g(config);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInitFinish(boolean success) {
        if (success) {
            Iterator<T> it = e().iterator();
            while (it.hasNext()) {
                ar.f328509a.b((LuaBasePlugin) it.next());
            }
        }
    }
}
