package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ;\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/ipc/methods/aq;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;", "context", "", "method", "", "", "arguments", "Leipc/EIPCResult;", "a", "(Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;Ljava/lang/String;[Ljava/lang/Object;)Leipc/EIPCResult;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class aq extends AbsIpcMethod {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final a f226316a = new a(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/ipc/methods/aq$a;", "", "", "ARGUMENT_SIZE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    @NotNull
    public EIPCResult a(@Nullable AbsIpcMethod.a context, @Nullable String method, @NotNull Object... arguments) {
        Long l3;
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (arguments.length != 2) {
            QLog.e("NavigateToTopicFusionMethod", 1, "doInvoke|expected arguments.size is 2, actual=" + arguments.length);
            EIPCResult createResult = EIPCResult.createResult(-102, Bundle.EMPTY);
            Intrinsics.checkNotNullExpressionValue(createResult, "createResult(EIPCResult.CODE_ERR, Bundle.EMPTY)");
            return createResult;
        }
        Object obj = arguments[0];
        String str = null;
        if (obj instanceof Long) {
            l3 = (Long) obj;
        } else {
            l3 = null;
        }
        Object obj2 = arguments[1];
        if (obj2 instanceof String) {
            str = (String) obj2;
        }
        String str2 = str;
        if (l3 == null) {
            QLog.e("NavigateToTopicFusionMethod", 1, "doInvoke|expected topicId is null");
            EIPCResult createResult2 = EIPCResult.createResult(-102, Bundle.EMPTY);
            Intrinsics.checkNotNullExpressionValue(createResult2, "createResult(EIPCResult.CODE_ERR, Bundle.EMPTY)");
            return createResult2;
        }
        BaseApplication context2 = BaseApplication.getContext();
        if (context2 != null) {
            ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).launchTopicFeeds(context2, l3.longValue(), str2, "");
        }
        EIPCResult createSuccessResult = EIPCResult.createSuccessResult(Bundle.EMPTY);
        Intrinsics.checkNotNullExpressionValue(createSuccessResult, "createSuccessResult(Bundle.EMPTY)");
        return createSuccessResult;
    }
}
