package com.tencent.mobileqq.vas.font.magic;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\u0003H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/font/magic/IVasMagicFontManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkAndTriggerLocalTips", "", "peerUid", "", "chatType", "", "hideGuestMagicFont", "", "isDisableMagicFontType", "setClearMagicFlag", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasMagicFontManager extends QRouteApi {
    void checkAndTriggerLocalTips(@NotNull String peerUid, int chatType);

    boolean hideGuestMagicFont();

    boolean isDisableMagicFontType();

    void setClearMagicFlag();
}
