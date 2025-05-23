package com.tencent.mobileqq.troop.livesync.repository;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import tencent.trpcprotocol.TroopLiveSyncSvr$GetSyncGroupsRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001Jw\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022'\b\u0002\u0010\u000b\u001a!\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\n2<\b\u0002\u0010\u0011\u001a6\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\t0\fj\u0002`\u0010H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/livesync/repository/ITroopLiveSyncRepository;", "", "", "roomId", "Lkotlin/Function1;", "Ltencent/trpcprotocol/TroopLiveSyncSvr$GetSyncGroupsRsp;", "Lkotlin/ParameterName;", "name", "rsp", "", "Lcom/tencent/mobileqq/troop/livesync/repository/GetSyncGroupsSuccessBlock;", "successBlock", "Lkotlin/Function2;", "errorCode", "", "errorMsg", "Lcom/tencent/mobileqq/troop/livesync/repository/TroopLiveSyncErrorBlock;", "errorBlock", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface ITroopLiveSyncRepository {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(ITroopLiveSyncRepository iTroopLiveSyncRepository, int i3, Function1 function1, Function2 function2, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    function1 = ITroopLiveSyncRepository$reqGetSyncGroups$1.INSTANCE;
                }
                if ((i16 & 4) != 0) {
                    function2 = ITroopLiveSyncRepository$reqGetSyncGroups$2.INSTANCE;
                }
                iTroopLiveSyncRepository.a(i3, function1, function2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reqGetSyncGroups");
        }
    }

    void a(int roomId, @NotNull Function1<? super TroopLiveSyncSvr$GetSyncGroupsRsp, Unit> successBlock, @NotNull Function2<? super Integer, ? super String, Unit> errorBlock);
}
