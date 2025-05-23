package com.tencent.mobileqq.guild.ipc.methods;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.extras.PendingTransition;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/ipc/methods/h;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;", "ipcContext", "", "method", "", "", "arguments", "Leipc/EIPCResult;", "a", "(Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;Ljava/lang/String;[Ljava/lang/Object;)Leipc/EIPCResult;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h extends AbsIpcMethod {
    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    @NotNull
    public EIPCResult a(@NotNull AbsIpcMethod.a ipcContext, @NotNull String method, @NotNull Object... arguments) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(ipcContext, "ipcContext");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = ch.i();
        }
        Object obj = arguments[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        Object obj2 = arguments[1];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
        String str2 = (String) obj2;
        Object obj3 = arguments[2];
        if (obj3 instanceof Bundle) {
            bundle = (Bundle) obj3;
        } else {
            bundle = null;
        }
        if (context != null) {
            IGuildMainFrameApi iGuildMainFrameApi = (IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class);
            JumpGuildParam jumpGuildParam = new JumpGuildParam(str, str2);
            if (bundle != null) {
                jumpGuildParam.getExtras().putAll(bundle);
            }
            PendingTransition pendingTransition = new PendingTransition(R.anim.f154427o, R.anim.f154429q);
            Bundle extras = jumpGuildParam.extras;
            Intrinsics.checkNotNullExpressionValue(extras, "extras");
            pendingTransition.saveTo(extras);
            Unit unit = Unit.INSTANCE;
            iGuildMainFrameApi.gotoChannelDirectly(context, jumpGuildParam);
        } else {
            QLog.i("GotoChannelDirectlyMethod", 1, "context == null");
        }
        EIPCResult createSuccessResult = EIPCResult.createSuccessResult(new Bundle());
        Intrinsics.checkNotNullExpressionValue(createSuccessResult, "createSuccessResult(Bundle())");
        return createSuccessResult;
    }
}
