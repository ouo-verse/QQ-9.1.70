package com.tencent.qqnt.aio.adapter.api;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H&J\b\u0010\u000f\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\rH&J\b\u0010\u0011\u001a\u00020\rH&J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u001dH\u0016J\u0018\u0010\"\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0013H\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOChatBackgroundApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "", "curFriendUid", "", "uinType", "", "needImmersive", "Lcom/tencent/qqnt/aio/adapter/background/a;", "aioCreate", "selfUin", "", "aioDelayLoad", "aioResume", "aioPause", "aioDestroy", "curFriendUin", "Landroid/graphics/drawable/Drawable;", "getCurrentChatBackgroundDrawable", "uin", "isDIYChaTBackground", "uid", "isAvatarBackground", "getCurrentChatBackgroundBg", "peerUin", "Landroid/content/res/ColorStateList;", "getBackgroundTextColor", "Landroid/app/Activity;", "setWindowFit", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "drawable", "setImmersiveBottomDrawable", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOChatBackgroundApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        @Nullable
        public static ColorStateList a(@NotNull IAIOChatBackgroundApi iAIOChatBackgroundApi, @NotNull String uin, @NotNull String peerUin) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(peerUin, "peerUin");
            return null;
        }

        @Nullable
        public static String b(@NotNull IAIOChatBackgroundApi iAIOChatBackgroundApi, @NotNull String curFriendUin, int i3) {
            Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
            return "";
        }

        @Nullable
        public static Drawable c(@NotNull IAIOChatBackgroundApi iAIOChatBackgroundApi, @NotNull String curFriendUin, int i3) {
            Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
            return null;
        }

        public static boolean d(@NotNull IAIOChatBackgroundApi iAIOChatBackgroundApi, @NotNull String uid, int i3) {
            Intrinsics.checkNotNullParameter(uid, "uid");
            return false;
        }

        public static boolean e(@NotNull IAIOChatBackgroundApi iAIOChatBackgroundApi, @NotNull String uin) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            return false;
        }

        public static void f(@NotNull IAIOChatBackgroundApi iAIOChatBackgroundApi, @NotNull ViewGroup parent, @NotNull Drawable drawable) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(drawable, "drawable");
        }

        public static void g(@NotNull IAIOChatBackgroundApi iAIOChatBackgroundApi, @NotNull Activity context) {
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }

    @Nullable
    com.tencent.qqnt.aio.adapter.background.a aioCreate(@Nullable Context context, @NotNull String curFriendUid, int uinType, boolean needImmersive);

    void aioDelayLoad(@NotNull String selfUin);

    void aioDestroy();

    void aioPause();

    void aioResume();

    @Nullable
    ColorStateList getBackgroundTextColor(@NotNull String uin, @NotNull String peerUin);

    @Nullable
    String getCurrentChatBackgroundBg(@NotNull String curFriendUin, int uinType);

    @Nullable
    Drawable getCurrentChatBackgroundDrawable(@NotNull String curFriendUin, int uinType);

    boolean isAvatarBackground(@NotNull String uid, int uinType);

    boolean isDIYChaTBackground(@NotNull String uin);

    void setImmersiveBottomDrawable(@NotNull ViewGroup parent, @NotNull Drawable drawable);

    void setWindowFit(@NotNull Activity context);
}
