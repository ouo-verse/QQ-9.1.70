package com.tencent.mobileqq.vas.manager.api;

import android.os.Bundle;
import com.tencent.mobileqq.vas.api.IVasManager;
import com.tencent.mobileqq.vas.theme.diy.ThemeDIYData;
import eipc.EIPCCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH&J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H&JJ\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012H&J,\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H&J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H&J:\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0005H&J\u001a\u0010+\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/vas/manager/api/IJsbCallManager;", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "detailWithDarkMode", "", "curThemeId", "", "callback", "Leipc/EIPCCallback;", "getCardInfo", "forceRequest", "", "getCurrentChatBgId", "friendUin", "requestThemeServer", "bundle", "Landroid/os/Bundle;", "saveFont", "id", "", "type", "setChatBackground", "path", "name", "url", "feetype", "uinType", "entryType", "setCustomChatBackground", "uin", "picPath", "effectId", "setDiyThemeBackground", "diyData", "Lcom/tencent/mobileqq/vas/theme/diy/ThemeDIYData;", "setProfileCard", "layoutId", "", "backgroundId", "cardId", "extInfo", "diyTemplate", "setThemeAndBackGround", "themeId", "startDownloadTheme", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface IJsbCallManager extends IVasManager {
    void detailWithDarkMode(@NotNull String curThemeId, @Nullable EIPCCallback callback);

    void getCardInfo(@Nullable EIPCCallback callback, boolean forceRequest);

    void getCurrentChatBgId(@NotNull String friendUin, @Nullable EIPCCallback callback);

    void requestThemeServer(@NotNull Bundle bundle, @Nullable EIPCCallback callback);

    void saveFont(int id5, int type);

    void setChatBackground(@NotNull String id5, @Nullable String friendUin, @NotNull String path, @NotNull String name, @NotNull String url, int feetype, int uinType, int entryType);

    void setCustomChatBackground(@Nullable String uin, @Nullable String picPath, int effectId, int uinType);

    void setDiyThemeBackground(@NotNull String uin, @NotNull ThemeDIYData diyData);

    void setProfileCard(long layoutId, long backgroundId, long cardId, @NotNull String extInfo, @NotNull String diyTemplate, @Nullable EIPCCallback callback);

    void setThemeAndBackGround(@NotNull String themeId);

    void startDownloadTheme(@NotNull String curThemeId, @Nullable EIPCCallback callback);
}
