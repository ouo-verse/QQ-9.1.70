package com.tencent.mobileqq.aio.input.blockstate;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.aio.input.blockstate.GroupBlockStateIntent;
import com.tencent.mobileqq.aio.input.blockstate.GroupBlockUIState;
import com.tencent.mobileqq.aio.input.blockstate.a;
import com.tencent.mobileqq.aio.input.blockstate.f;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qqnt.aio.adapter.api.ITroopApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/input/blockstate/d;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/aio/input/blockstate/a;", "Lcom/tencent/mobileqq/aio/input/blockstate/GroupBlockUIState;", "Lcom/tencent/mvi/base/route/a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/runtime/a;", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "", "onCreate", "intent", "l", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "call", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class d extends com.tencent.qqnt.aio.baseVM.a<a, GroupBlockUIState> implements com.tencent.mvi.base.route.a {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean m() {
        ITroopApi iTroopApi = (ITroopApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(ITroopApi.class);
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String b16 = su3.c.b(g16);
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "sMobileQQ.peekAppRuntime().currentUin");
        return iTroopApi.isTroopOwner(b16, currentUin);
    }

    @Override // com.tencent.mvi.base.route.a
    public void call(@NotNull MsgIntent i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) i3);
            return;
        }
        Intrinsics.checkNotNullParameter(i3, "i");
        if (i3 instanceof TroopBlockStateChange) {
            updateUI(new GroupBlockUIState.GroupBlockChange(((TroopBlockStateChange) i3).a(), m()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C7259a) {
            ITroopApi iTroopApi = (ITroopApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(ITroopApi.class);
            Context context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext();
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            iTroopApi.goToAppealForTempBlock(context, su3.c.b(g16));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        f.a aVar;
        Integer a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        j e16 = context.e();
        String qualifiedName = Reflection.getOrCreateKotlinClass(TroopBlockStateChange.class).getQualifiedName();
        LifecycleOwner d16 = context.d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        e16.c(qualifiedName, this, d16);
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(GroupBlockStateIntent.GetTroopBlockState.f189333d);
        if (k3 instanceof f.a) {
            aVar = (f.a) k3;
        } else {
            aVar = null;
        }
        if (aVar != null && (a16 = aVar.a()) != null) {
            updateUI(new GroupBlockUIState.GroupBlockChange(a16.intValue(), m()));
        }
    }

    @Override // com.tencent.mvi.base.route.a
    public boolean sticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return a.C9235a.a(this);
    }
}
