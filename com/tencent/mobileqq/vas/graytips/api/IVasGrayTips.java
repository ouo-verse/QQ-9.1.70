package com.tencent.mobileqq.vas.graytips.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.pb.vas.uni_gray_tip.UniGrayTip$FromChannel;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/graytips/api/IVasGrayTips;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "requestUnitGrayTips", "", "cmd", "", WadlProxyConsts.CHANNEL, "Lcom/tencent/pb/vas/uni_gray_tip/UniGrayTip$FromChannel;", "map", "", "", "observer", "Lcom/tencent/mobileqq/app/BusinessObserver;", "transformFrom", "peerType", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes20.dex */
public interface IVasGrayTips extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int FROM_AIO = 1;
    public static final int KEY_WORDS = 1;
    public static final int PASS_DATE = 2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vas/graytips/api/IVasGrayTips$Companion;", "", "()V", "FROM_AIO", "", "KEY_WORDS", "PASS_DATE", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int FROM_AIO = 1;
        public static final int KEY_WORDS = 1;
        public static final int PASS_DATE = 2;

        Companion() {
        }
    }

    void requestUnitGrayTips(int cmd, @NotNull UniGrayTip$FromChannel channel, @Nullable Map<String, String> map, @Nullable BusinessObserver observer);

    int transformFrom(int peerType);
}
