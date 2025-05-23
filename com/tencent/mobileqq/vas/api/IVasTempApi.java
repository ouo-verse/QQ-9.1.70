package com.tencent.mobileqq.vas.api;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.BalanceExplainDialogData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 %2\u00020\u0001:\u0001%J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nH&J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&JJ\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH&J,\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH&J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0010H&J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fH&J \u0010 \u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H&\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasTempApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "initPagSo", "", "isTabletDevice", "context", "Landroid/content/Context;", "requestPagDownload", "", "block", "Lkotlin/Function0;", "saveFont", "id", "", "type", "setChatBackground", "", "friendUin", "path", "name", "url", "feetype", "uinType", "entryType", "setCustomChatBackground", "uin", "effectId", "setThemeAndBackGround", "themeId", "showCoinExplainDialog", "data", "Lcom/tencent/mobileqq/vas/BalanceExplainDialogData;", "showNotEnoughExplainDialog", "onClickListener", "Landroid/content/DialogInterface$OnClickListener;", "defaultRunnable", "Ljava/lang/Runnable;", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasTempApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0087\bJ\t\u0010\u0005\u001a\u00020\u0004H\u0086\n\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasTempApi$Companion;", "", "()V", "get", "Lcom/tencent/mobileqq/vas/api/IVasTempApi;", "invoke", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        Companion() {
        }

        @JvmStatic
        @NotNull
        public final IVasTempApi get() {
            QRouteApi api = QRoute.api(IVasTempApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IVasTempApi::class.java)");
            return (IVasTempApi) api;
        }

        @NotNull
        public final IVasTempApi invoke() {
            QRouteApi api = QRoute.api(IVasTempApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IVasTempApi::class.java)");
            return (IVasTempApi) api;
        }
    }

    boolean initPagSo();

    boolean isTabletDevice(@NotNull Context context);

    void requestPagDownload(@NotNull Function0<Unit> block);

    void saveFont(int id5, int type);

    void setChatBackground(@NotNull String id5, @Nullable String friendUin, @NotNull String path, @NotNull String name, @NotNull String url, int feetype, int uinType, int entryType);

    void setCustomChatBackground(@Nullable String uin, @Nullable String path, int effectId, int uinType);

    void setThemeAndBackGround(@NotNull String themeId);

    void showCoinExplainDialog(@NotNull Context context, @NotNull BalanceExplainDialogData data);

    void showNotEnoughExplainDialog(@NotNull Context context, @NotNull DialogInterface.OnClickListener onClickListener, @NotNull Runnable defaultRunnable);
}
