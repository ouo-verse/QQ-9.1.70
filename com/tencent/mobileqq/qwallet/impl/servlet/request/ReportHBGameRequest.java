package com.tencent.mobileqq.qwallet.impl.servlet.request;

import Wallet.ReportHBGameReq;
import Wallet.ReportHBGameRsp;
import com.tencent.mobileqq.qwallet.impl.servlet.QWalletCommonRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/impl/servlet/request/ReportHBGameRequest;", "Lcom/tencent/mobileqq/qwallet/impl/servlet/QWalletCommonRequest;", "LWallet/ReportHBGameReq;", "req", "<init>", "(LWallet/ReportHBGameReq;)V", "Companion", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ReportHBGameRequest extends QWalletCommonRequest {

    @NotNull
    public static final String CMD_REPORT_HB_GAME = "GroupRedPackListSvc.reportHBGame";

    @NotNull
    public static final String FUN_REPORT_HB_GAME = "reportHBGame";

    @NotNull
    public static final String SERVANT_REPORT_HB_GAME = "Wallet.WalletHBGameServer.WalletHBGameObj";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportHBGameRequest(@NotNull ReportHBGameReq req) {
        super(20, req, ReportHBGameRsp.class, CMD_REPORT_HB_GAME, FUN_REPORT_HB_GAME, SERVANT_REPORT_HB_GAME);
        Intrinsics.checkNotNullParameter(req, "req");
    }
}
