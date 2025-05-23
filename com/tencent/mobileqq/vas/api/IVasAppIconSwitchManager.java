package com.tencent.mobileqq.vas.api;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasAppIconSwitchManager;", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "changeIconForJsb", "", "uin", "", "id", "", "checkAndSwitchIcon", "isFromJsb", "", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface IVasAppIconSwitchManager extends IVasManager {
    void changeIconForJsb(@Nullable String uin, int id5);

    void checkAndSwitchIcon(@Nullable String uin, boolean isFromJsb);
}
