package com.tencent.mobileqq.vas.treasurecard.api;

import com.tencent.mobileqq.vas.api.IVasManager;
import com.tencent.mobileqq.vas.treasurecard.VasFtCard;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import so4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\b\u0010\u0003\u001a\u00020\u0002H&J \u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0011\u001a\u00020\u0010H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/treasurecard/api/IVasFTManager;", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "", "init", "", "from", "", "intervalTime", "Lso4/a$a;", "listener", "Lso4/a;", "", "obtainCardState", "treasureCardState", "Lcom/tencent/mobileqq/vas/treasurecard/VasFtCard;", "obtainCardInfo", "", "clearCacheAndRequest", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface IVasFTManager extends IVasManager {
    public static final int CARD_STATE_KING = 1;
    public static final int CARD_STATE_NOORDER = 0;
    public static final int CARD_STATE_TREASURE = 2;
    public static final int CARD_STATE_UNKNOW = -1;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/treasurecard/api/IVasFTManager$Companion;", "", "()V", "CARD_STATE_KING", "", "CARD_STATE_NOORDER", "CARD_STATE_TREASURE", "CARD_STATE_UNKNOW", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int CARD_STATE_KING = 1;
        public static final int CARD_STATE_NOORDER = 0;
        public static final int CARD_STATE_TREASURE = 2;
        public static final int CARD_STATE_UNKNOW = -1;

        Companion() {
        }
    }

    boolean clearCacheAndRequest();

    @NotNull
    a init(@NotNull String from, long intervalTime, @NotNull a.InterfaceC11243a listener);

    void init();

    @Nullable
    VasFtCard obtainCardInfo(@NotNull String from);

    int obtainCardState(@NotNull String from);

    int treasureCardState(@NotNull String from);
}
