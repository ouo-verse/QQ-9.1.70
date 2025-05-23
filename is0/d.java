package is0;

import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.api.wallet.IGuildWalletApi;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \n2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lis0/d;", "Lpn0/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "", "o", "intent", "handleIntent", "<init>", "()V", "f", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends pn0.a<ol3.b, MviUIState> {
    /* JADX WARN: Multi-variable type inference failed */
    private final void o() {
        AppInterface appInterface;
        boolean z16;
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g18);
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
        if (iGPSService != null) {
            z16 = iGPSService.isGuest(g17);
        } else {
            z16 = true;
        }
        if (z16 && fo0.b.c((com.tencent.aio.api.runtime.a) getMContext())) {
            return;
        }
        if (((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).isNeedInterceptHongbao(g17, b16)) {
            ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptRedEnvelopeSendToast();
            return;
        }
        IGuildWalletApi iGuildWalletApi = (IGuildWalletApi) QRoute.api(IGuildWalletApi.class);
        FragmentActivity requireActivity = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "mContext.fragment.requireActivity()");
        iGuildWalletApi.goToSendHbActivity(requireActivity, g17, b16);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.handleIntent(intent);
        if (intent instanceof a) {
            o();
        }
    }
}
