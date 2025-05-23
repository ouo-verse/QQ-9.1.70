package com.tencent.mobileqq.vas.lovechat.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/lovechat/api/ILoveStateData;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getLoveState", "", "getLoveUin", "", "setLoveState", "", "state", "setLoveUin", "uin", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface ILoveStateData extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int LOVE_STATE_LOVED = 1;
    public static final int LOVE_STATE_SINGLE = 0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/lovechat/api/ILoveStateData$Companion;", "", "()V", "LOVE_STATE_LOVED", "", "LOVE_STATE_SINGLE", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int LOVE_STATE_LOVED = 1;
        public static final int LOVE_STATE_SINGLE = 0;

        Companion() {
        }
    }

    int getLoveState();

    @NotNull
    String getLoveUin();

    void setLoveState(int state);

    void setLoveUin(@NotNull String uin);
}
