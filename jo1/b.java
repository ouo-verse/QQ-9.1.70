package jo1;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.forward.ForwardNewVersionDialog;
import com.tencent.mobileqq.forward.dialog.ForwardDialog;
import com.tencent.mobileqq.forward.utils.f;
import com.tencent.mobileqq.guild.api.IGuildTextForwardApi;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0012\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0013\u00a8\u0006\u0019"}, d2 = {"Ljo1/b;", "", "", "uinType", "", "troopUin", "toUin", "msg", "", "c", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "sessionInfo", "textAndEmoji", "d", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "confirmDialog", "b", "Landroid/content/Intent;", "intent", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam$LinkTypeParam;", "a", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f410734a = new b();

    b() {
    }

    @JvmStatic
    public static final String b(Bundle extraData, QQCustomDialog confirmDialog) {
        String inputValue;
        if (confirmDialog instanceof QQCustomDialogWtihEmoticonInput) {
            inputValue = ((QQCustomDialogWtihEmoticonInput) confirmDialog).getInputValue();
        } else if (confirmDialog instanceof ForwardNewVersionDialog) {
            inputValue = ((ForwardNewVersionDialog) confirmDialog).getInputValue();
        } else {
            inputValue = confirmDialog instanceof ForwardDialog ? ((ForwardDialog) confirmDialog).getInputValue() : null;
        }
        return inputValue == null ? "" : inputValue;
    }

    @JvmStatic
    public static final void c(int uinType, String troopUin, String toUin, String msg2) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(toUin, "toUin");
        if (msg2 != null) {
            SessionInfo sessionInfo = new SessionInfo();
            sessionInfo.f179555d = uinType;
            sessionInfo.f179559f = troopUin;
            sessionInfo.f179557e = toUin;
            d(sessionInfo, msg2);
            QLog.i("Guild.share.GuildForwardUtils", 1, "sendCommentMessage " + uinType + " " + toUin + " " + msg2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d(SessionInfo sessionInfo, String textAndEmoji) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        if (textAndEmoji != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(textAndEmoji);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    if (sessionInfo.f179555d == 10014) {
                        ((IGuildTextForwardApi) QRoute.api(IGuildTextForwardApi.class)).sendMsg(sessionInfo.f179559f, sessionInfo.f179557e, textAndEmoji);
                        return;
                    } else {
                        f.f211079a.i(sessionInfo, textAndEmoji);
                        return;
                    }
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    public final SharePublishGuildFeedParam.LinkTypeParam a(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return SharePublishGuildFeedParam.LinkTypeParam.INSTANCE.a(extras);
        }
        return null;
    }
}
