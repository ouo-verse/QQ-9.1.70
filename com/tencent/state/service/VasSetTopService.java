package com.tencent.state.service;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xt4.aa;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J9\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/service/VasSetTopService;", "", "()V", "requestSetTop", "", "uin", "", "isTop", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/state/service/RspResult;", "Lkotlin/ParameterName;", "name", "code", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSetTopService {
    private static final String CMD_SERVICE = "trpc.qmeta.status_square_svr.StatusSquareSvr";
    public static final int ERROR_CODE = 23068;
    private static final String METHOD = "SetTop";
    private static final String TAG = "VasSetTopService";

    public final void requestSetTop(String uin, boolean isTop, Function1<? super RspResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        aa aaVar = new aa();
        aaVar.f448517a = Long.parseLong(uin);
        aaVar.f448518b = isTop ? 2 : 1;
    }
}
