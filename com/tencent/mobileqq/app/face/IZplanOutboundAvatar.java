package com.tencent.mobileqq.app.face;

import androidx.annotation.WorkerThread;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\u0005H'J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/app/face/IZplanOutboundAvatar;", "", "getZPlanAvatarBackgroundUrl", "", "hideZplanAvatar", "", "hideMaxDuration", "", "isShowZplanOutboundAvatar", "", "isSupportZPlanOutboundAvatar", "preloadOutboundResource", "showZplanAvatar", "animateDuration", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public interface IZplanOutboundAvatar {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class DefaultImpls {
        public static void hideZplanAvatar(@NotNull IZplanOutboundAvatar iZplanOutboundAvatar) {
            iZplanOutboundAvatar.hideZplanAvatar(0L);
        }
    }

    @Nullable
    String getZPlanAvatarBackgroundUrl();

    void hideZplanAvatar();

    void hideZplanAvatar(long hideMaxDuration);

    boolean isShowZplanOutboundAvatar();

    boolean isSupportZPlanOutboundAvatar();

    @WorkerThread
    void preloadOutboundResource();

    void showZplanAvatar(long animateDuration);
}
