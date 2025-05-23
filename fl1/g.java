package fl1;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.troopguild.api.ITroopGuildPermissionService;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lfl1/g;", "Lfl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputArgs", "", "c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;", "inputContext", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a inputContext) {
        super(inputContext);
        Intrinsics.checkNotNullParameter(inputContext, "inputContext");
    }

    @Override // fl1.a
    @NotNull
    public SpeakPermissionType b() {
        return SpeakPermissionType.PERMISSION_TYPE_SELF_MUTED;
    }

    @Override // fl1.a
    public void c(@NotNull ShowInputComponentArgs inputArgs) {
        AppInterface appInterface;
        IGProGuildInfo guildInfo;
        long myShutUpExpireTime;
        Intrinsics.checkNotNullParameter(inputArgs, "inputArgs");
        if (!TextUtils.isEmpty(getInputContext().getTroopUin())) {
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopGuildPermissionService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
            myShutUpExpireTime = ((ITroopGuildPermissionService) runtimeService).getMuteSelfTime(getInputContext().getTroopUin());
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IRuntimeService iRuntimeService = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
            }
            IGPSService iGPSService = (IGPSService) iRuntimeService;
            if (iGPSService != null && (guildInfo = iGPSService.getGuildInfo(getInputContext().getGuildId())) != null) {
                myShutUpExpireTime = guildInfo.getMyShutUpExpireTime();
            } else {
                return;
            }
        }
        String G = com.tencent.mobileqq.guild.setting.mute.c.G(Long.valueOf(myShutUpExpireTime));
        Context context = getInputContext().getContext();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getInputContext().getContext().getString(R.string.f144600p8);
        Intrinsics.checkNotNullExpressionValue(string, "inputContext.context.get\u2026d_native_self_muted_tips)");
        String format = String.format(string, Arrays.copyOf(new Object[]{G}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QQToast.makeText(context, format, 0).show();
    }
}
