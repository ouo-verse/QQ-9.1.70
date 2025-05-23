package fl1;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.fc;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import sz1.JoinTimeItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lfl1/d;", "Lfl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputArgs", "", "c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;", "inputContext", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;)V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a inputContext) {
        super(inputContext);
        Intrinsics.checkNotNullParameter(inputContext, "inputContext");
    }

    @Override // fl1.a
    @NotNull
    public SpeakPermissionType b() {
        return SpeakPermissionType.PERMISSION_TYPE_JOIN_TIME;
    }

    @Override // fl1.a
    public void c(@NotNull ShowInputComponentArgs inputArgs) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        long j3;
        Intrinsics.checkNotNullParameter(inputArgs, "inputArgs");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProGuildInfo iGProGuildInfo = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGProGuildInfo = iGPSService.getGuildInfo(getInputContext().getGuildId());
        }
        if (iGProGuildInfo == null) {
            QLog.e("JoinTimeInputProcessor", 1, "showJoinTimeLimitTips guildInfo is null");
            return;
        }
        fc speakThreshold = iGProGuildInfo.getSpeakThreshold();
        if (speakThreshold != null) {
            j3 = speakThreshold.b();
        } else {
            j3 = 0;
        }
        JoinTimeItem.Companion companion = JoinTimeItem.INSTANCE;
        companion.b(j3);
        Context context = getInputContext().getContext();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getInputContext().getContext().getString(R.string.f144560p4);
        Intrinsics.checkNotNullExpressionValue(string, "inputContext.context.get\u2026d_native_join_time_limit)");
        String format = String.format(string, Arrays.copyOf(new Object[]{companion.b(j3)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QQToast.makeText(context, format, 0).show();
    }
}
