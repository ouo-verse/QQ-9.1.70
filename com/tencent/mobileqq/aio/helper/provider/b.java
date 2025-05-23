package com.tencent.mobileqq.aio.helper.provider;

import android.content.Context;
import android.util.Log;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.aio.monitor.b;
import com.tencent.aio.monitor.c;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.debug.hodor.api.IQQHodorPrefApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.d;
import com.tencent.qqnt.trace.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/provider/b;", "Lcom/tencent/aio/main/businesshelper/h;", "", "a", "b", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "", "getTag", "", "getId", "state", "onMoveToState", "", "interestedIn", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/monitor/b;", "d", "Lcom/tencent/aio/monitor/b;", "mMainThreadMonitor", "Landroid/content/Context;", "e", "Landroid/content/Context;", "mContext", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class b implements h {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.monitor.b mMainThreadMonitor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a() {
        if (!d.INSTANCE.a()) {
            return;
        }
        Log.d(getTag(), "doOnCreate");
        b.Companion companion = com.tencent.aio.monitor.b.INSTANCE;
        companion.a("com.tencent.mobileqq.config.QConfigManager.loadConObj");
        companion.a("com.tencent.mobileqq.persistence.EntityManager.query");
        c.a aVar = new c.a();
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        com.tencent.aio.monitor.c a16 = aVar.a(context);
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "currentThread()");
        a16.j(currentThread);
        com.tencent.aio.monitor.b bVar = new com.tencent.aio.monitor.b(a16);
        this.mMainThreadMonitor = bVar;
        bVar.h();
    }

    private final void b() {
        if (this.mMainThreadMonitor == null) {
            return;
        }
        Log.d(getTag(), "doOnDestroy");
        com.tencent.aio.monitor.b bVar = this.mMainThreadMonitor;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainThreadMonitor");
            bVar = null;
        }
        bVar.i();
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 19;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "MainThreadLiveHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (int[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new int[]{0, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Context requireContext = param.a().c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "param.aioContext.fragment.requireContext()");
        this.mContext = requireContext;
        if (!com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
            ((IQQHodorPrefApi) g.INSTANCE.a(IQQHodorPrefApi.class)).collectTrackInfo("aio_begin_business");
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        h.a.b(this);
        if (!com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
            ((IQQHodorPrefApi) g.INSTANCE.a(IQQHodorPrefApi.class)).collectTrackInfo("aio_end_business");
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, state);
        } else {
            if (state != 0) {
                if (state == 12) {
                    b();
                    return;
                }
                return;
            }
            a();
        }
    }
}
