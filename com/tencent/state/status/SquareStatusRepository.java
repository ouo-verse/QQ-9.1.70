package com.tencent.state.status;

import com.tencent.mobileqq.mvvm.a;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.RspResult;
import com.tencent.state.service.VasBuyTheSameService;
import com.tencent.state.service.VasOnlineStatusListService;
import com.tencent.state.service.VasSetTopService;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.DressInfo;
import com.tencent.state.square.data.PanelInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$J:\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001c\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00100\nJ9\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\r0\u0014R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006%"}, d2 = {"Lcom/tencent/state/status/SquareStatusRepository;", "Lcom/tencent/mobileqq/mvvm/a;", "", "isMale", "", "status", "richStatus", "", "", "recentList", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/square/data/PanelInfo;", "callback", "", "getOnlineStatusList", "uin", "Lcom/tencent/state/square/data/DressInfo;", "getDressInfo", "", "isTop", "Lkotlin/Function1;", "Lcom/tencent/state/service/RspResult;", "Lkotlin/ParameterName;", "name", "type", "setTopInfo", "Lcom/tencent/state/service/VasOnlineStatusListService;", "statusListService", "Lcom/tencent/state/service/VasOnlineStatusListService;", "Lcom/tencent/state/service/VasBuyTheSameService;", "buyTheSameService", "Lcom/tencent/state/service/VasBuyTheSameService;", "Lcom/tencent/state/service/VasSetTopService;", "topService", "Lcom/tencent/state/service/VasSetTopService;", "<init>", "()V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareStatusRepository extends a {
    private final VasOnlineStatusListService statusListService = new VasOnlineStatusListService();
    private final VasBuyTheSameService buyTheSameService = new VasBuyTheSameService();
    private final VasSetTopService topService = new VasSetTopService();

    public final void getDressInfo(final long uin, final ResultCallback<DressInfo> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.status.SquareStatusRepository$getDressInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VasBuyTheSameService vasBuyTheSameService;
                vasBuyTheSameService = SquareStatusRepository.this.buyTheSameService;
                vasBuyTheSameService.getDressInfo(uin, callback);
            }
        });
    }

    public final void getOnlineStatusList(boolean isMale, int status, int richStatus, List<Long> recentList, ResultCallback<PanelInfo> callback) {
        Intrinsics.checkNotNullParameter(recentList, "recentList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.statusListService.getOnlineStatusList(isMale, status, richStatus, recentList, callback);
    }

    public final void setTopInfo(String uin, boolean isTop, Function1<? super RspResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.topService.requestSetTop(uin, isTop, callback);
    }
}
