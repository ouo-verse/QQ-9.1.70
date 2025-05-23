package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardTroopMemberControllerForMiniPie;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/MsgForwardApiImpl$getMemberViewController$1", "Lyw3/a;", "Landroid/content/Context;", "context", "", "uid", "", "chatType", "", "scale", "Landroid/view/View;", "a", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/forward/ForwardTroopMemberControllerForMiniPie;", "Lcom/tencent/mobileqq/forward/ForwardTroopMemberControllerForMiniPie;", "b", "()Lcom/tencent/mobileqq/forward/ForwardTroopMemberControllerForMiniPie;", "c", "(Lcom/tencent/mobileqq/forward/ForwardTroopMemberControllerForMiniPie;)V", "controller", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MsgForwardApiImpl$getMemberViewController$1 implements yw3.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public ForwardTroopMemberControllerForMiniPie controller;

    @Override // yw3.a
    public View a(Context context, String uid, int chatType, final float scale) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        c(new ForwardTroopMemberControllerForMiniPie(context));
        com.tencent.nt.adapter.session.c.h(uid, chatType, new Function2<Boolean, com.tencent.nt.adapter.session.f, Unit>() { // from class: com.tencent.qqnt.aio.adapter.api.impl.MsgForwardApiImpl$getMemberViewController$1$getView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, com.tencent.nt.adapter.session.f fVar) {
                invoke(bool.booleanValue(), fVar);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, com.tencent.nt.adapter.session.f fVar) {
                if (!z16 || fVar == null) {
                    return;
                }
                ForwardTroopMemberControllerForMiniPie b16 = MsgForwardApiImpl$getMemberViewController$1.this.b();
                AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
                Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                b16.r((QQAppInterface) waitAppRuntime, fVar.a(), fVar.b(), scale);
            }
        });
        View k3 = b().k();
        Intrinsics.checkNotNullExpressionValue(k3, "controller.getView()");
        return k3;
    }

    public final ForwardTroopMemberControllerForMiniPie b() {
        ForwardTroopMemberControllerForMiniPie forwardTroopMemberControllerForMiniPie = this.controller;
        if (forwardTroopMemberControllerForMiniPie != null) {
            return forwardTroopMemberControllerForMiniPie;
        }
        Intrinsics.throwUninitializedPropertyAccessException("controller");
        return null;
    }

    public final void c(ForwardTroopMemberControllerForMiniPie forwardTroopMemberControllerForMiniPie) {
        Intrinsics.checkNotNullParameter(forwardTroopMemberControllerForMiniPie, "<set-?>");
        this.controller = forwardTroopMemberControllerForMiniPie;
    }

    @Override // yw3.a
    public void onDestroy() {
        b().i();
    }
}
