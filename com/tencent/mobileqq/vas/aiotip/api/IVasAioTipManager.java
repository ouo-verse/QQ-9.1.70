package com.tencent.mobileqq.vas.aiotip.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019J\u0015\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H&J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&\u00a2\u0006\u0002\u0010\u0005J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H&J@\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/aiotip/api/IVasAioTipManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getDirtyWords", "", "", "()[Ljava/lang/String;", "getKeywordLimitConfig", "Lcom/tencent/mobileqq/vas/aiotip/api/KeywordLimitConfig;", "getKeywords", "isGray", "", "sessionCurType", "", "curFriendUin", "requestUnitGrayTips", "", "cmd", WadlProxyConsts.CHANNEL, "fromUin", "map", "", "observer", "Lcom/tencent/mobileqq/app/BusinessObserver;", "transformFrom", "peerType", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasAioTipManager extends QRouteApi {
    public static final int CHANNEL_DISCUSSION = 3;
    public static final int CHANNEL_FRIEND = 1;
    public static final int CHANNEL_TROOP = 2;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final long DEFAULT_FREQ = 86400;
    public static final int FROM_AIO = 1;
    public static final int KEY_WORDS = 1;
    public static final int MESSAGE_ROAMING = 3;
    public static final int PASS_DATE = 2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/aiotip/api/IVasAioTipManager$Companion;", "", "()V", "CHANNEL_DISCUSSION", "", "CHANNEL_FRIEND", "CHANNEL_TROOP", "DEFAULT_FREQ", "", "FROM_AIO", "KEY_WORDS", "MESSAGE_ROAMING", "PASS_DATE", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int CHANNEL_DISCUSSION = 3;
        public static final int CHANNEL_FRIEND = 1;
        public static final int CHANNEL_TROOP = 2;
        public static final long DEFAULT_FREQ = 86400;
        public static final int FROM_AIO = 1;
        public static final int KEY_WORDS = 1;
        public static final int MESSAGE_ROAMING = 3;
        public static final int PASS_DATE = 2;

        Companion() {
        }
    }

    @Nullable
    String[] getDirtyWords();

    @NotNull
    KeywordLimitConfig getKeywordLimitConfig();

    @NotNull
    String[] getKeywords();

    boolean isGray(int sessionCurType, @Nullable String curFriendUin);

    void requestUnitGrayTips(int cmd, int channel, @NotNull String fromUin, @Nullable Map<String, String> map, @Nullable BusinessObserver observer);

    int transformFrom(int peerType);
}
