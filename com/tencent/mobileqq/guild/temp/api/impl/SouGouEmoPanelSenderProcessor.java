package com.tencent.mobileqq.guild.temp.api.impl;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.NTEmoticonSenderApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001\bB\u001f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R#\u0010\u001d\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u0012\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/impl/SouGouEmoPanelSenderProcessor;", "Lcom/tencent/mobileqq/emoticonview/NTEmoticonSenderApi;", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "emoInfo", "", "c", "d", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "a", "info", "", "send", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "b", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "getChannelId", "channelId", "Lmqq/app/AppRuntime;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "()Lmqq/app/AppRuntime;", "appRuntime", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "e", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class SouGouEmoPanelSenderProcessor implements NTEmoticonSenderApi {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String guildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String channelId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy appRuntime;

    public SouGouEmoPanelSenderProcessor(Context context, String guildId, String channelId) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.context = context;
        this.guildId = guildId;
        this.channelId = channelId;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AppRuntime>() { // from class: com.tencent.mobileqq.guild.temp.api.impl.SouGouEmoPanelSenderProcessor$appRuntime$2
            @Override // kotlin.jvm.functions.Function0
            public final AppRuntime invoke() {
                return MobileQQ.sMobileQQ.peekAppRuntime();
            }
        });
        this.appRuntime = lazy;
    }

    private final SessionInfo a() {
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = 10014;
        sessionInfo.f179559f = this.guildId;
        sessionInfo.f179557e = this.channelId;
        return sessionInfo;
    }

    private final AppRuntime b() {
        return (AppRuntime) this.appRuntime.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean c(EmoticonInfo emoInfo) {
        if (!d(emoInfo)) {
            return false;
        }
        IPicEmoticonInfo iPicEmoticonInfo = emoInfo instanceof IPicEmoticonInfo ? (IPicEmoticonInfo) emoInfo : null;
        if (iPicEmoticonInfo == null) {
            return true;
        }
        iPicEmoticonInfo.sendFromGuild(b(), this.context, a());
        return true;
    }

    private final boolean d(EmoticonInfo emoInfo) {
        return ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).isMarketFaceEmoticonType(emoInfo);
    }

    @Override // com.tencent.mobileqq.emoticonview.NTEmoticonSenderApi
    public void send(EmoticonInfo info) {
        QLog.i("SouGouEmoPanelSenderProcessor", 4, "onSend clz=" + (info != null ? info.getClass().getSimpleName() : null) + " info=" + (info != null ? info.toString() : null));
        if (info == null) {
            QLog.i("SouGouEmoPanelSenderProcessor", 4, "info==null");
        } else {
            c(info);
        }
    }
}
