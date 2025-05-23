package com.tencent.mobileqq.qwallet.impl.servlet.request;

import Wallet.JudgeDownloadReq;
import Wallet.JudgeDownloadRsp;
import Wallet.ResInfo;
import com.tencent.mobileqq.qwallet.impl.servlet.QWalletCommonRequest;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/impl/servlet/request/JudgeDownloadRequest;", "Lcom/tencent/mobileqq/qwallet/impl/servlet/QWalletCommonRequest;", "", "toString", "LWallet/JudgeDownloadReq;", "judgeReq", "LWallet/JudgeDownloadReq;", "<init>", "(LWallet/JudgeDownloadReq;)V", "Companion", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class JudgeDownloadRequest extends QWalletCommonRequest {

    @NotNull
    public static final String FUNC_NAME = "judgeDownload";

    @NotNull
    public static final String SERVANT_NAME = "Wallet.FrequencyControlServer.FrequencyControlObj";

    @NotNull
    public static final String SSO_COMMAND = "QQPayFrequencySvc.judgeDownload";

    @NotNull
    private final JudgeDownloadReq judgeReq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JudgeDownloadRequest(@NotNull JudgeDownloadReq judgeReq) {
        super(1, judgeReq, JudgeDownloadRsp.class, SSO_COMMAND, FUNC_NAME, "Wallet.FrequencyControlServer.FrequencyControlObj");
        Intrinsics.checkNotNullParameter(judgeReq, "judgeReq");
        this.judgeReq = judgeReq;
        setCallbackOnSubThread(true);
    }

    @Override // com.tencent.mobileqq.qwallet.impl.servlet.QWalletCommonRequest
    @NotNull
    public String toString() {
        String str;
        Object firstOrNull;
        JudgeDownloadReq judgeDownloadReq = this.judgeReq;
        int i3 = judgeDownloadReq.iType;
        ArrayList<ResInfo> arrayList = judgeDownloadReq.vecResInfo;
        if (arrayList != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            ResInfo resInfo = (ResInfo) firstOrNull;
            if (resInfo != null) {
                str = resInfo.sResId;
                return "JudgeDownloadReq| " + i3 + "|" + str;
            }
        }
        str = null;
        return "JudgeDownloadReq| " + i3 + "|" + str;
    }
}
