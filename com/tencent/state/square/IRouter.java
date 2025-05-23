package com.tencent.state.square;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.weiyun.poi.PoiDbManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J \u0010\r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH&J*\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH&J\u001c\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000fH&J>\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000fH&J(\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000fH&J\u0018\u0010 \u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH&J \u0010!\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u000fH&J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000fH&J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u000fH&J$\u0010*\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u000fH&J\u001a\u0010.\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\tH\u0016J\"\u00100\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\t2\u0006\u00101\u001a\u000202H\u0016\u00a8\u00063"}, d2 = {"Lcom/tencent/state/square/IRouter;", "", "getDeviceType", "Lcom/tencent/state/square/SquareDeviceType;", "context", "Landroid/content/Context;", "getSquarePoiInfo", "", "data", "Landroid/content/Intent;", "routeLink", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "Lcom/tencent/state/square/EntranceLink;", "routeToAddFriend", "uin", "", "nick", "routeToFriendProfileCard", "recommendReason", "routeToLocationPage", "fragment", "Landroidx/fragment/app/Fragment;", "poiId", "routeToMapPage", "longitude", "", "latitude", PoiDbManager.TBL_POI, "poiAddress", "routeToNearbyAIO", "tinyId", PhotoCategorySummaryInfo.AVATAR_URL, "routeToNearbyDetailPage", "routeToProfilePage", "isMe", "", "routeToSmallHome", "smallHomeUin", "routeToSmallHomeTransition", "friendUin", "routeToSongPage", "songMid", "routeToZplanPortal", "bundle", "Landroid/os/Bundle;", "subSource", "startActivity", "intent", IAELaunchRecorder.MILESTONE_START_ACTIVITY, "requestCode", "", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface IRouter {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void routeToLocationPage$default(IRouter iRouter, Fragment fragment, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str = "";
                }
                iRouter.routeToLocationPage(fragment, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: routeToLocationPage");
        }

        public static /* synthetic */ void routeToMapPage$default(IRouter iRouter, Context context, double d16, double d17, String str, String str2, String str3, int i3, Object obj) {
            String str4;
            String str5;
            String str6;
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    str4 = "";
                } else {
                    str4 = str;
                }
                if ((i3 & 16) != 0) {
                    str5 = "";
                } else {
                    str5 = str2;
                }
                if ((i3 & 32) != 0) {
                    str6 = "";
                } else {
                    str6 = str3;
                }
                iRouter.routeToMapPage(context, d16, d17, str4, str5, str6);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: routeToMapPage");
        }

        public static /* synthetic */ void routeToZplanPortal$default(IRouter iRouter, Context context, Bundle bundle, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    bundle = null;
                }
                iRouter.routeToZplanPortal(context, bundle, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: routeToZplanPortal");
        }

        public static void startActivity(@NotNull IRouter iRouter, @Nullable Context context, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (context != null) {
                context.startActivity(intent, null);
            }
        }

        public static void startActivityForResult(@NotNull IRouter iRouter, @Nullable Context context, @NotNull Intent intent, int i3) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, i3, null);
            } else {
                iRouter.startActivity(context, intent);
            }
        }
    }

    @NotNull
    SquareDeviceType getDeviceType(@NotNull Context context);

    void getSquarePoiInfo(@Nullable Intent data);

    void routeLink(@NotNull Context context, @NotNull EntranceLink link);

    void routeToAddFriend(@NotNull Context context, @NotNull String uin, @NotNull String nick);

    void routeToFriendProfileCard(@NotNull Context context, @NotNull String uin, @NotNull String nick, @Nullable String recommendReason);

    void routeToLocationPage(@Nullable Fragment fragment, @NotNull String poiId);

    void routeToMapPage(@NotNull Context context, double longitude, double latitude, @NotNull String poi, @NotNull String poiId, @NotNull String poiAddress);

    void routeToNearbyAIO(@NotNull Context context, @NotNull String tinyId, @NotNull String nick, @NotNull String avatarUrl);

    void routeToNearbyDetailPage(@NotNull Context context, @NotNull String uin);

    void routeToProfilePage(@NotNull Context context, boolean isMe, @NotNull String uin);

    void routeToSmallHome(@NotNull Context context, @NotNull String smallHomeUin);

    void routeToSmallHomeTransition(@NotNull Context context, @NotNull String friendUin);

    void routeToSongPage(@NotNull Context context, @NotNull String songMid);

    void routeToZplanPortal(@NotNull Context context, @Nullable Bundle bundle, @NotNull String subSource);

    void startActivity(@Nullable Context context, @NotNull Intent intent);

    void startActivityForResult(@Nullable Context context, @NotNull Intent intent, int requestCode);
}
