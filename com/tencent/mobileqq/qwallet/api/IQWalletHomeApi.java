package com.tencent.mobileqq.qwallet.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\tH&J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/IQWalletHomeApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "getH5RedPointsAsJson", "h5Extra", "", "onH5RedPointClick", "url", "onH5TechReport", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getAdvIPCModule", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfo", "checkRedPointResReady", "Companion", "a", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletHomeApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f277089a;

    @NotNull
    public static final String QWALLET_HOME_ADV_MODULE_NAME = "QWalletHomeAdvIPCModule";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/IQWalletHomeApi$a;", "", "<init>", "()V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.api.IQWalletHomeApi$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f277089a = new Companion();

        Companion() {
        }
    }

    void checkRedPointResReady(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo);

    @NotNull
    QIPCModule getAdvIPCModule();

    @NotNull
    String getH5RedPointsAsJson();

    void onH5RedPointClick(@NotNull String h5Extra);

    void onH5TechReport(@NotNull String url, @NotNull String h5Extra);
}
