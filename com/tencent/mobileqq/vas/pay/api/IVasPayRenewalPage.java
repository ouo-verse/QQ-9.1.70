package com.tencent.mobileqq.vas.pay.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\f\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H&J\f\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/api/IVasPayRenewalPage;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getNewCustomerPageParserClass", "Ljava/lang/Class;", "getRenewalParserClass", "open", "", "context", "Landroid/content/Context;", "source", "", "openNewCustomerPage", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasPayRenewalPage extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String EXTRA_SOURCE = "extra_source";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/api/IVasPayRenewalPage$Companion;", "", "()V", "EXTRA_SOURCE", "", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String EXTRA_SOURCE = "extra_source";

        Companion() {
        }
    }

    @NotNull
    Class<?> getNewCustomerPageParserClass();

    @NotNull
    Class<?> getRenewalParserClass();

    void open(@NotNull Context context, @NotNull String source);

    void openNewCustomerPage(@NotNull Context context, @NotNull String source);
}
