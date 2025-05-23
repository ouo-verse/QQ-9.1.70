package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Service(process = {""})
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\u001c\u0010\u000b\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u0005H&J\b\u0010\r\u001a\u00020\fH&J\u001c\u0010\u000e\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u0005H&J\b\u0010\u0010\u001a\u00020\u0003H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/IQCirclePublicAccountMessageService;", "Lmqq/app/api/IRuntimeService;", "fetchLastMessageInfo", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountMessageInfo;", "getAutoPlayFeedId", "", "getQCirclePublicAccountStaggerPreloadTriggerCount", "", "getRedDotType", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountRedDotType;", "getRedDotTypeFromCached", "hasUnReadMessage", "", "setQCircleMessageRead", "Companion", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public interface IQCirclePublicAccountMessageService extends IRuntimeService {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String TAG = "IQCirclePublicAccountMessageService";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/IQCirclePublicAccountMessageService$Companion;", "", "()V", "TAG", "", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String TAG = "IQCirclePublicAccountMessageService";

        Companion() {
        }
    }

    void fetchLastMessageInfo(@NotNull Function1<? super QCirclePublicAccountMessageInfo, Unit> callback);

    @NotNull
    String getAutoPlayFeedId();

    int getQCirclePublicAccountStaggerPreloadTriggerCount();

    void getRedDotType(@NotNull Function1<? super QCirclePublicAccountRedDotType, Unit> callback);

    @NotNull
    QCirclePublicAccountRedDotType getRedDotTypeFromCached();

    void hasUnReadMessage(@NotNull Function1<? super Boolean, Unit> callback);

    void setQCircleMessageRead();
}
