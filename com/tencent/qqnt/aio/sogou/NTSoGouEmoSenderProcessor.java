package com.tencent.qqnt.aio.sogou;

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

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R#\u0010\u0019\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u000b\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/sogou/NTSoGouEmoSenderProcessor;", "Lcom/tencent/mobileqq/emoticonview/NTEmoticonSenderApi;", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "emoInfo", "", "b", "c", "info", "", "send", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "getSessionInfo", "()Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "sessionInfo", "Lmqq/app/AppRuntime;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "()Lmqq/app/AppRuntime;", "appRuntime", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/activity/aio/SessionInfo;)V", "d", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class NTSoGouEmoSenderProcessor implements NTEmoticonSenderApi {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final SessionInfo sessionInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy appRuntime;

    public NTSoGouEmoSenderProcessor(Context context, SessionInfo sessionInfo) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        this.context = context;
        this.sessionInfo = sessionInfo;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AppRuntime>() { // from class: com.tencent.qqnt.aio.sogou.NTSoGouEmoSenderProcessor$appRuntime$2
            @Override // kotlin.jvm.functions.Function0
            public final AppRuntime invoke() {
                return MobileQQ.sMobileQQ.peekAppRuntime();
            }
        });
        this.appRuntime = lazy;
    }

    private final AppRuntime a() {
        return (AppRuntime) this.appRuntime.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean b(EmoticonInfo emoInfo) {
        if (!c(emoInfo)) {
            return false;
        }
        IPicEmoticonInfo iPicEmoticonInfo = emoInfo instanceof IPicEmoticonInfo ? (IPicEmoticonInfo) emoInfo : null;
        if (iPicEmoticonInfo == null) {
            return true;
        }
        iPicEmoticonInfo.sendFromGuild(a(), this.context, this.sessionInfo);
        return true;
    }

    private final boolean c(EmoticonInfo emoInfo) {
        return ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).isMarketFaceEmoticonType(emoInfo);
    }

    @Override // com.tencent.mobileqq.emoticonview.NTEmoticonSenderApi
    public void send(EmoticonInfo info) {
        if (QLog.isDevelopLevel()) {
            QLog.i("NTSogou NTSoGouEmoSenderProcessor", 4, "onSend clz=" + (info != null ? info.getClass().getSimpleName() : null) + " info=" + (info != null ? info.toString() : null));
        }
        if (info == null) {
            return;
        }
        b(info);
    }
}
