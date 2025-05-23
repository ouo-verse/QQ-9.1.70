package com.tencent.mobileqq.guild.ipc.methods;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/ipc/methods/am;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;", "ipcContext", "", "method", "", "", "arguments", "Leipc/EIPCResult;", "a", "(Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;Ljava/lang/String;[Ljava/lang/Object;)Leipc/EIPCResult;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class am extends AbsIpcMethod {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(int i3, String actId, String guildId, String channelId) {
        int i16;
        Intrinsics.checkNotNullParameter(actId, "$actId");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = ch.i();
        }
        Context context2 = context;
        if (context2 != null) {
            GuildFeedReportSourceInfo guildFeedReportSourceInfo = new GuildFeedReportSourceInfo();
            if (i3 == 1) {
                guildFeedReportSourceInfo.addReportItem("extra_feeds_create_source", "showcase");
                guildFeedReportSourceInfo.addReportItem("extra_feeds_from_activity_id", actId);
                i16 = 9;
            } else {
                i16 = 0;
            }
            ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).launchGuildFeedPublish(context2, guildId, channelId, i16, 1, guildFeedReportSourceInfo);
            return;
        }
        QLog.w("NavigateToLaunchFeedEditorMethod", 1, "context is null ");
    }

    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    @NotNull
    public EIPCResult a(@NotNull AbsIpcMethod.a ipcContext, @NotNull String method, @NotNull Object... arguments) {
        Intrinsics.checkNotNullParameter(ipcContext, "ipcContext");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Object obj = arguments[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        final String str = (String) obj;
        Object obj2 = arguments[1];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
        final String str2 = (String) obj2;
        Object obj3 = arguments[2];
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
        final int intValue = ((Integer) obj3).intValue();
        Object obj4 = arguments[3];
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
        final String str3 = (String) obj4;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.ipc.methods.al
            @Override // java.lang.Runnable
            public final void run() {
                am.e(intValue, str3, str, str2);
            }
        });
        EIPCResult createSuccessResult = EIPCResult.createSuccessResult(new Bundle());
        Intrinsics.checkNotNullExpressionValue(createSuccessResult, "createSuccessResult(Bundle())");
        return createSuccessResult;
    }
}
