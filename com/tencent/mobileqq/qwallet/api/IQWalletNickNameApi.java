package com.tencent.mobileqq.qwallet.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qwallet.data.NickNameInfo;
import com.tencent.state.data.SquareJSConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J.\u0010\u000b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bH&J:\u0010\u000f\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0004\u0012\u00020\t0\bH&J\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/IQWalletNickNameApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getIPCModule", "", "groupId", "getCurrentNickName", "uin", "Lkotlin/Function1;", "", "callback", "getNickName", "", SquareJSConst.Params.PARAMS_UIN_LIST, "Lcom/tencent/mobileqq/qwallet/data/NickNameInfo;", "getNickNameList", "getNickNameSync", "Companion", "a", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletNickNameApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f277091a;

    @NotNull
    public static final String IPC_MODULE_NAME = "QWalletNickNameIPCModule";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/IQWalletNickNameApi$a;", "", "<init>", "()V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f277091a = new Companion();

        Companion() {
        }
    }

    @NotNull
    String getCurrentNickName(@Nullable String groupId);

    @NotNull
    QIPCModule getIPCModule();

    void getNickName(@Nullable String groupId, @NotNull String uin, @NotNull Function1<? super String, Unit> callback);

    void getNickNameList(@Nullable String groupId, @NotNull List<String> uinList, @NotNull Function1<? super List<NickNameInfo>, Unit> callback);

    @NotNull
    String getNickNameSync(@Nullable String groupId, @NotNull String uin);
}
