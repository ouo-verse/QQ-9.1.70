package com.tencent.qqnt.aio.adapter.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J%\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\tH&\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOAvatarApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "clearAIOCache", "", "getAvatar", "Landroid/graphics/Bitmap;", "uin", "", "getAvatars", "", "uins", "([Ljava/lang/String;)[Landroid/graphics/Bitmap;", "isUseOldAvatarComponent", "", "useCircleImageView", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOAvatarApi extends QRouteApi {
    void clearAIOCache();

    @Nullable
    Bitmap getAvatar(@Nullable String uin);

    @NotNull
    Bitmap[] getAvatars(@NotNull String[] uins);

    boolean isUseOldAvatarComponent();

    boolean useCircleImageView();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static boolean b(@NotNull IAIOAvatarApi iAIOAvatarApi) {
            return false;
        }

        public static boolean c(@NotNull IAIOAvatarApi iAIOAvatarApi) {
            return false;
        }

        public static void a(@NotNull IAIOAvatarApi iAIOAvatarApi) {
        }
    }
}
