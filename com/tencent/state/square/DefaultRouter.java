package com.tencent.state.square;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.state.square.IRouter;
import com.tencent.weiyun.poi.PoiDbManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J*\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J8\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J(\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0016J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\"\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010%\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0010H\u0016J\u0018\u0010'\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0010H\u0016J\u0018\u0010)\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0010H\u0016J\"\u0010+\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0010H\u0016\u00a8\u00060"}, d2 = {"Lcom/tencent/state/square/DefaultRouter;", "Lcom/tencent/state/square/IRouter;", "()V", "getDeviceType", "Lcom/tencent/state/square/SquareDeviceType;", "context", "Landroid/content/Context;", "getSquarePoiInfo", "", "data", "Landroid/content/Intent;", "routeLink", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "Lcom/tencent/state/square/EntranceLink;", "routeToAddFriend", "uin", "", "nick", "routeToFriendProfileCard", "recommendReason", "routeToLocationPage", "fragment", "Landroidx/fragment/app/Fragment;", "poiId", "routeToMapPage", "longitude", "", "latitude", PoiDbManager.TBL_POI, "poiAddress", "routeToNearbyAIO", "tinyId", PhotoCategorySummaryInfo.AVATAR_URL, "routeToNearbyDetailPage", "routeToProfilePage", "isMe", "", "routeToSmallHome", "smallHomeUin", "routeToSmallHomeTransition", "friendUin", "routeToSongPage", "songMid", "routeToZplanPortal", "bundle", "Landroid/os/Bundle;", "subSource", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public class DefaultRouter implements IRouter {
    private static final String TAG = "DefaultRouter";

    @Override // com.tencent.state.square.IRouter
    @NotNull
    public SquareDeviceType getDeviceType(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SquareDeviceType.PHONE;
    }

    @Override // com.tencent.state.square.IRouter
    public void getSquarePoiInfo(@Nullable Intent data) {
        SquareBaseKt.getSquareLog().d(TAG, "getSquarePoiInfo.");
    }

    @Override // com.tencent.state.square.IRouter
    public void routeLink(@NotNull Context context, @NotNull EntranceLink link) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(link, "link");
        Toast.makeText(context, "route link:" + link.getLinkType() + '-' + link.getLink(), 0).show();
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToAddFriend(@NotNull Context context, @NotNull String uin, @NotNull String nick) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Toast.makeText(context, "routeToAddFriend nick:" + nick + ", uin:" + uin, 0).show();
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToFriendProfileCard(@NotNull Context context, @NotNull String uin, @NotNull String nick, @Nullable String recommendReason) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Toast.makeText(context, "routeToFriendProfileCard nick:" + nick + ", uin:" + uin + ", recommendReason:" + recommendReason, 0).show();
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToLocationPage(@Nullable Fragment fragment, @NotNull String poiId) {
        Intrinsics.checkNotNullParameter(poiId, "poiId");
        SquareBaseKt.getSquareLog().d(TAG, "routeToLocationPage.");
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToMapPage(@NotNull Context context, double longitude, double latitude, @NotNull String poi, @NotNull String poiId, @NotNull String poiAddress) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(poi, "poi");
        Intrinsics.checkNotNullParameter(poiId, "poiId");
        Intrinsics.checkNotNullParameter(poiAddress, "poiAddress");
        SquareBaseKt.getSquareLog().d(TAG, "routeToMapPage.");
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToNearbyAIO(@NotNull Context context, @NotNull String tinyId, @NotNull String nick, @NotNull String avatarUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        SquareBaseKt.getSquareLog().d(TAG, "routeToNearbyAIO");
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToNearbyDetailPage(@NotNull Context context, @NotNull String uin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseKt.getSquareLog().d(TAG, "routeToNearbyDetailPage");
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToProfilePage(@NotNull Context context, boolean isMe, @NotNull String uin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Toast.makeText(context, "OpenProfile", 0).show();
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToSmallHome(@NotNull Context context, @NotNull String smallHomeUin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(smallHomeUin, "smallHomeUin");
        SquareBaseKt.getSquareLog().d(TAG, "routeToSmallHome smallHomeUin:" + smallHomeUin);
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToSmallHomeTransition(@NotNull Context context, @NotNull String friendUin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        SquareBaseKt.getSquareLog().d(TAG, "routeToSmallHomeTransition friendUin:" + friendUin);
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToSongPage(@NotNull Context context, @NotNull String songMid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(songMid, "songMid");
        Toast.makeText(context, "routeToSongPage songMid:" + songMid, 0).show();
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToZplanPortal(@NotNull Context context, @Nullable Bundle bundle, @NotNull String subSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(subSource, "subSource");
        SquareBaseKt.getSquareLog().d(TAG, "routeToZplanPortal.");
    }

    @Override // com.tencent.state.square.IRouter
    public void startActivity(@Nullable Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        IRouter.DefaultImpls.startActivity(this, context, intent);
    }

    @Override // com.tencent.state.square.IRouter
    public void startActivityForResult(@Nullable Context context, @NotNull Intent intent, int i3) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        IRouter.DefaultImpls.startActivityForResult(this, context, intent, i3);
    }
}
