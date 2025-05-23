package in0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.article.fragment.GuildArticleWrapperFragment;
import com.tencent.guild.aio.article.launcher.GuildBaseFragment;
import com.tencent.guild.api.activity.IAIOSingleActivityApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJG\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J0\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00102\u0010\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00180\u00172\u0006\u0010\u001a\u001a\u00020\u000b\u00a8\u0006\u001e"}, d2 = {"Lin0/c;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "", "mainMsgSeq", "rspMsgSeq", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", IProfileCardConst.KEY_FROM_TYPE, "", "b", "(Landroid/app/Activity;Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;JLjava/lang/Long;Lcom/tencent/aio/api/runtime/a;I)V", "Landroid/content/Intent;", "a", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;JLjava/lang/Long;I)Landroid/content/Intent;", "Landroid/content/Context;", "context", "d", "intent", "Ljava/lang/Class;", "Lcom/tencent/guild/aio/article/launcher/GuildBaseFragment;", "cls", "requestCode", "e", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f408006a = new c();

    c() {
    }

    private final Intent a(Contact contact, long mainMsgSeq, Long rspMsgSeq, int fromType) {
        Intent intent = new Intent();
        intent.putExtra("LAUNCHER_FROM_KEY", fromType);
        intent.putExtra("guild_article_guild_id", contact.guildId);
        intent.putExtra("guild_article_channel_id", contact.peerUid);
        intent.putExtra("guild_article_main_msg_seq", mainMsgSeq);
        if (rspMsgSeq != null) {
            intent.putExtra("guild_article_rsp_msg_seq", rspMsgSeq.longValue());
        }
        return intent;
    }

    @JvmStatic
    public static final void b(@NotNull Activity activity, @NotNull Contact contact, long mainMsgSeq, @Nullable Long rspMsgSeq, @Nullable com.tencent.aio.api.runtime.a aioContext, int fromType) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(contact, "contact");
        if (((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick("article_fast_click")) {
            return;
        }
        if (!AppNetConnInfo.isNetSupport()) {
            f408006a.d(activity);
            return;
        }
        if (mainMsgSeq > 0 && (fromType != 2 || (rspMsgSeq != null && rspMsgSeq.longValue() > 0))) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IGProChannelInfo iGProChannelInfo = null;
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
                iGProChannelInfo = iGPSService.getChannelInfo(contact.peerUid);
            }
            if (iGProChannelInfo != null && (iGProChannelInfo.getType() == 1 || iGProChannelInfo.getType() == 6 || iGProChannelInfo.getApplicationId() == 1000137)) {
                if (fo0.b.c(aioContext)) {
                    return;
                }
                c cVar = f408006a;
                cVar.e(activity, cVar.a(contact, mainMsgSeq, rspMsgSeq, fromType), GuildArticleWrapperFragment.class, 0);
                return;
            }
            QLog.e("GuildArticleMsgLauncher", 1, "channelInfo error! channelId = " + contact.peerUid);
            return;
        }
        QLog.e("GuildArticleMsgLauncher", 1, "msg args error!" + contact.peerUid);
    }

    public static /* synthetic */ void c(Activity activity, Contact contact, long j3, Long l3, com.tencent.aio.api.runtime.a aVar, int i3, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            aVar = null;
        }
        com.tencent.aio.api.runtime.a aVar2 = aVar;
        if ((i16 & 32) != 0) {
            i3 = 1;
        }
        b(activity, contact, j3, l3, aVar2, i3);
    }

    private final void d(Context context) {
        QQToast.makeText(context, 1, R.string.f139720c1, 0).show();
    }

    public final void e(@NotNull Activity activity, @NotNull Intent intent, @NotNull Class<? extends GuildBaseFragment> cls, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(cls, "cls");
        intent.setClass(activity, ((IAIOSingleActivityApi) QRoute.api(IAIOSingleActivityApi.class)).getAIOSingleActivityClass());
        intent.putExtra("public_fragment_class", cls.getName());
        activity.startActivityForResult(intent, requestCode);
    }
}
