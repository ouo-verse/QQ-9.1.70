package com.tencent.mobileqq.qwallet.api.impl;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi;
import com.tencent.mobileqq.qwallet.common.QWalletNickNameServer;
import com.tencent.mobileqq.qwallet.data.NickNameInfo;
import com.tencent.state.data.SquareJSConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J.\u0010\u000b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bH\u0016J:\u0010\u000f\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0004\u0012\u00020\t0\bH\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/impl/QWalletNickNameApiImpl;", "Lcom/tencent/mobileqq/qwallet/api/IQWalletNickNameApi;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getIPCModule", "", "groupId", "getCurrentNickName", "uin", "Lkotlin/Function1;", "", "callback", "getNickName", "", SquareJSConst.Params.PARAMS_UIN_LIST, "Lcom/tencent/mobileqq/qwallet/data/NickNameInfo;", "getNickNameList", "getNickNameSync", "<init>", "()V", "Companion", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletNickNameApiImpl implements IQWalletNickNameApi {

    @NotNull
    public static final String TAG = "QWalletNickNameApiImpl";

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi
    @NotNull
    public String getCurrentNickName(@Nullable String groupId) {
        return QWalletNickNameServer.f277113a.a(groupId);
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi
    @NotNull
    public QIPCModule getIPCModule() {
        return QWalletNickNameServer.NickNameIPCModule.f277114d;
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi
    public void getNickName(@Nullable String groupId, @NotNull final String uin, @NotNull final Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QWalletNickNameServer.b(groupId, uin, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.qwallet.api.impl.QWalletNickNameApiImpl$getNickName$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str) {
                Function1<String, Unit> function1 = callback;
                if (str == null) {
                    str = uin;
                }
                function1.invoke(str);
            }
        });
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi
    public void getNickNameList(@Nullable String groupId, @NotNull List<String> uinList, @NotNull Function1<? super List<NickNameInfo>, Unit> callback) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QWalletNickNameServer.c(groupId, uinList, callback);
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi
    @NotNull
    public String getNickNameSync(@Nullable String groupId, @NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return QWalletNickNameServer.f277113a.d(groupId, uin);
    }
}
