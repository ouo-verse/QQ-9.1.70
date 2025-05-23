package com.tencent.mobileqq.qwallet.api;

import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&JL\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062:\b\u0002\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH&J\b\u0010\u0010\u001a\u00020\u0004H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/IQWalletKuiklyApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "", "registerExternalModule", "", "bundleName", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "code", "msg", "callback", "preloadKuiklyBundle", "clearFinancialOAuthCache", "Companion", "a", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletKuiklyApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f277090a;

    @NotNull
    public static final String EVENT_ACTION_CLOSE_WINDOW = "EVENT_ACTION_CLOSE_WINDOW";

    @NotNull
    public static final String EVENT_ACTION_NOTIFY_LOAD_STATE = "EVENT_ACTION_NOTIFY_LOAD_STATE";

    @NotNull
    public static final String FINANCIAL_APPID = "102022609";

    @NotNull
    public static final String KEY_EVENT_DATA = "data";

    @NotNull
    public static final String KUIKLY_BUNDLE_QWALLET_FINANCIAL = "qwallet_financial";

    @NotNull
    public static final String URL_ABILITY_KEY_H5_PRELOGIN = "preload_login";

    @NotNull
    public static final String URL_ABILITY_KEY_KUIKLY_PRELOGIN = "pre_login";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/IQWalletKuiklyApi$a;", "", "<init>", "()V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.api.IQWalletKuiklyApi$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f277090a = new Companion();

        Companion() {
        }
    }

    void clearFinancialOAuthCache();

    void preloadKuiklyBundle(@NotNull String bundleName, @Nullable Function2<? super Integer, ? super String, Unit> callback);

    void registerExternalModule(@NotNull b renderExport);
}
