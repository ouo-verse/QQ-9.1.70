package com.tencent.mobileqq.minigame.api;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J?\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072%\u0010\b\u001a!\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\tj\u0002`\u000eH&J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0010H&J \u0010\u0011\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/IMiniGameVAShareApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", MiniChatConstants.MINI_APP_ADD_SHORTCUT, "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "appId", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/mobileqq/minigame/api/AddShortcutCallback;", "createMiniGameVAColorNote", "Lcom/tencent/mobileqq/minigame/api/CreateColorNoteCallback;", "isMiniGameShortcutExist", "appName", "openShareFragment", "params", "Landroid/os/Bundle;", "Companion", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniGameVAShareApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String SHARE_METHOD_SHARE_GAME_PICTURE = "shareGamePicture";

    @NotNull
    public static final String SHARE_METHOD_SHARE_GAME_STRUCT_MESSAGE = "shareGameStructMessage";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/IMiniGameVAShareApi$Companion;", "", "()V", "SHARE_METHOD_SHARE_GAME_PICTURE", "", "SHARE_METHOD_SHARE_GAME_STRUCT_MESSAGE", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String SHARE_METHOD_SHARE_GAME_PICTURE = "shareGamePicture";

        @NotNull
        public static final String SHARE_METHOD_SHARE_GAME_STRUCT_MESSAGE = "shareGameStructMessage";

        Companion() {
        }
    }

    void addShortcut(@NotNull Activity activity, @NotNull String appId, @NotNull Function1<? super Boolean, Unit> callback);

    void createMiniGameVAColorNote(@NotNull Activity activity, @NotNull String appId, @NotNull CreateColorNoteCallback callback);

    boolean isMiniGameShortcutExist(@NotNull Activity activity, @NotNull String appId, @NotNull String appName);

    void openShareFragment(@NotNull Activity activity, @NotNull Bundle params);
}
