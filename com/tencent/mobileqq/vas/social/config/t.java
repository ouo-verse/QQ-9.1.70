package com.tencent.mobileqq.vas.social.config;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.BuildConfig;
import com.tencent.biz.map.DetailMapFragment;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.music.api.IQQPlayer;
import com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.api.IVasZplanGroupApi;
import com.tencent.mobileqq.vas.transit.ExtInfo;
import com.tencent.mobileqq.vas.transit.MasterInfo;
import com.tencent.mobileqq.vas.transit.TransitPageConfig;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.vas.transit.VisitorInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.SquareDeviceType;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.mayknow.VasMayKnowFragment;
import com.tencent.weiyun.poi.PoiDbManager;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J(\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\bH\u0016J\"\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\bH\u0016J \u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J*\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010!\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\bH\u0016J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0016J\u0012\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J8\u0010+\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0016J\u0010\u0010-\u001a\u00020,2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/t;", "Lcom/tencent/state/square/IRouter;", "Landroid/content/Context;", "context", "Lcom/tencent/state/square/EntranceLink;", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "", "routeLink", "", "smallHomeUin", "routeToSmallHome", "", "isMe", "uin", "routeToProfilePage", "tinyId", "nick", PhotoCategorySummaryInfo.AVATAR_URL, "routeToNearbyAIO", "friendUin", "routeToSmallHomeTransition", "songMid", "routeToSongPage", "Landroid/os/Bundle;", "bundle", "subSource", "routeToZplanPortal", "routeToAddFriend", "recommendReason", "routeToFriendProfileCard", "Landroidx/fragment/app/Fragment;", "fragment", "poiId", "routeToLocationPage", "routeToNearbyDetailPage", "Landroid/content/Intent;", "data", "getSquarePoiInfo", "", "longitude", "latitude", PoiDbManager.TBL_POI, "poiAddress", "routeToMapPage", "Lcom/tencent/state/square/SquareDeviceType;", "getDeviceType", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class t implements IRouter {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f310743a;

        static {
            int[] iArr = new int[DeviceType.values().length];
            try {
                iArr[DeviceType.PHONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceType.TABLET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DeviceType.FOLD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f310743a = iArr;
        }
    }

    @Override // com.tencent.state.square.IRouter
    public SquareDeviceType getDeviceType(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DeviceType a16 = PadUtil.a(context);
        SquareDeviceType squareDeviceType = SquareDeviceType.PHONE;
        int i3 = a16 == null ? -1 : b.f310743a[a16.ordinal()];
        if (i3 == 1) {
            return squareDeviceType;
        }
        if (i3 != 2) {
            return i3 != 3 ? squareDeviceType : SquareDeviceType.FOLD;
        }
        return SquareDeviceType.TABLET;
    }

    @Override // com.tencent.state.square.IRouter
    public void routeLink(Context context, EntranceLink link) {
        boolean startsWith$default;
        String link2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(link, "link");
        int linkType = link.getLinkType();
        if (linkType == 0) {
            QQToast.makeText(context, "\u8df3\u8f6c\u5f02\u5e38", 0).show();
            return;
        }
        if (linkType == 1 || linkType == 2) {
            if (!TextUtils.isEmpty(link.getLink())) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(link.getLink(), "mqzone://", false, 2, null);
                if (startsWith$default) {
                    byte[] bytes = link.getLink().getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    link2 = "mqqapi://qzoneschema?schema=" + PluginBaseInfoHelper.Base64Helper.encodeToString(bytes, 2);
                } else {
                    link2 = link.getLink();
                }
                ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchSchemeWithContext(context, link2);
                return;
            }
            QQToast.makeText(context, "\u8fdb\u5165\u9875\u9762\u5f02\u5e38", 0).show();
        }
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToAddFriend(Context context, String uin, String nick) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            QLog.e("VasSquareRouter", 1, "routeToAddFriend context error : " + context);
            return;
        }
        QRouteApi api = QRoute.api(IAddFriendApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAddFriendApi::class.java)");
        IAddFriendApi iAddFriendApi = (IAddFriendApi) api;
        iAddFriendApi.launchAddFriendForResult(activity, iAddFriendApi.startAddFriend(context, 1, uin, "", 3178, 0, nick, new byte[0]), VasMayKnowFragment.FRIEND_REQUEST_CODE_SQUARE_ADD_MAY_KNOW);
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToFriendProfileCard(Context context, String uin, String nick, String recommendReason) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            QLog.e("VasSquareRouter", 1, "routeToFriendProfileCard context error : " + context);
            return;
        }
        try {
            String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            AllInOne allInOne = new AllInOne(uin, iFriendsInfoService.isFriend(uid, "VasSquareRouter") ? 1 : 110);
            allInOne.nickname = nick;
            allInOne.profileEntryType = 88;
            Intent intent = ProfileUtils.getIntent(context, allInOne);
            intent.addFlags(536870912);
            Bundle bundle = new Bundle();
            bundle.putString("recommend_reason", recommendReason);
            intent.putExtra(IProfileCardConst.KEY_PROFILE_EXTRA, bundle);
            activity.startActivityForResult(intent, VasMayKnowFragment.FRIEND_REQUEST_CODE_SQUARE_ADD_MAY_KNOW);
        } catch (Exception e16) {
            QLog.e("VasSquareRouter", 1, "routeToFriendProfileCard throw:", e16);
        }
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToLocationPage(Fragment fragment, String poiId) {
        Intrinsics.checkNotNullParameter(poiId, "poiId");
        if (fragment == null) {
            QLog.e("VasSquareRouter", 1, "routeToFriendProfileCard fragment is null");
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mobileqq", "com.qzone.common.activities.base.QZoneFragmentHolderActivity");
        intent.putExtra("KEY_FRAGMENT_NAME", QZoneHelper.MOOD_SELECT_LOCATION);
        LbsDataV2.PoiInfo poiInfo = new LbsDataV2.PoiInfo();
        poiInfo.poiId = poiId;
        intent.putExtra("key_current_poi", poiInfo);
        intent.putExtra("key_lbs_state", 1);
        fragment.startActivityForResult(intent, 1208);
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToMapPage(Context context, double longitude, double latitude, String poi, String poiId, String poiAddress) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(poi, "poi");
        Intrinsics.checkNotNullParameter(poiId, "poiId");
        Intrinsics.checkNotNullParameter(poiAddress, "poiAddress");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        Intent className = new Intent().setClassName(BuildConfig.LIBRARY_PACKAGE_NAME, "com.map.detial");
        Intrinsics.checkNotNullExpressionValue(className, "Intent().setClassName(\"c\u2026ncent\", \"com.map.detial\")");
        Bundle bundle = new Bundle();
        bundle.putString("strName", poi);
        bundle.putString("address", poiAddress);
        bundle.putString(QCircleSchemeAttr.Polymerize.LAT, String.valueOf(latitude));
        bundle.putString("lon", String.valueOf(longitude));
        bundle.putString("sendUin", peekAppRuntime.getCurrentAccountUin());
        bundle.putString("receiveUin", com.tencent.sqshow.zootopia.utils.w.f373306a.a());
        bundle.putString("receiveUinType", peekAppRuntime.getAccount());
        className.putExtras(bundle);
        QPublicFragmentActivityForTool.start(context, className, DetailMapFragment.class);
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToNearbyAIO(Context context, String tinyId, String nick, String avatarUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        QRouteApi api = QRoute.api(INearbyProPageRouter.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INearbyProPageRouter::class.java)");
        INearbyProPageRouter.a.a((INearbyProPageRouter) api, context, tinyId, nick, avatarUrl, 22, 0, 32, null);
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToNearbyDetailPage(Context context, String uin) {
        long j3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        try {
            j3 = Long.parseLong(uin);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            j3 = 0;
        }
        long j16 = j3;
        QRouteApi api = QRoute.api(INearbyProPageRouter.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INearbyProPageRouter::class.java)");
        INearbyProPageRouter.a.b((INearbyProPageRouter) api, context, j16, false, 0, 12, null);
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToProfilePage(Context context, boolean isMe, String uin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        AllInOne allInOne = new AllInOne(uin, !isMe ? 1 : 0);
        allInOne.profileEntryType = 999;
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 0);
        ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).openProfileCard(context, allInOne);
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToSmallHome(Context context, String smallHomeUin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(smallHomeUin, "smallHomeUin");
        ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startSmallHomeByUin(context, ZootopiaSource.INSTANCE.g(), smallHomeUin);
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToSmallHomeTransition(Context context, String friendUin) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        MasterInfo masterInfo = new MasterInfo();
        masterInfo.setUin(friendUin);
        VisitorInfo visitorInfo = new VisitorInfo();
        visitorInfo.setUin(peekAppRuntime.getCurrentAccountUin());
        ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
        Source source = Source.StatusSquare;
        if (Intrinsics.areEqual(peekAppRuntime.getCurrentAccountUin(), friendUin)) {
            str = "em_zplan_state_square_entrance_zhutai";
        } else {
            str = "em_zplan_state_square_entrance_ketai";
        }
        ZootopiaSource d16 = ZootopiaSource.Companion.d(companion, source, str, null, 4, null);
        IVasZplanGroupApi iVasZplanGroupApi = (IVasZplanGroupApi) QRoute.api(IVasZplanGroupApi.class);
        TransitPageConfig transitPageConfig = new TransitPageConfig();
        transitPageConfig.setNeedTransitPageWhenReady(0);
        Unit unit = Unit.INSTANCE;
        iVasZplanGroupApi.openSmallHomeTransitPage(context, new TransitPageInfo(masterInfo, visitorInfo, transitPageConfig, new ExtInfo()), d16);
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToSongPage(Context context, String songMid) {
        AppRuntime peekAppRuntime;
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(songMid, "songMid");
        QLog.d("VasSquareRouter", 1, "routeToSongPage songMid:" + songMid);
        if ((context instanceof Activity) && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
            if (((IQQPlayer) QRoute.api(IQQPlayer.class)).isPlaying()) {
                SongInfo currentSong = ((IQQPlayer) QRoute.api(IQQPlayer.class)).getCurrentSong();
                if (Intrinsics.areEqual(currentSong != null ? currentSong.f251868e : null, songMid)) {
                    QLog.i("VasSquareRouter", 1, "do isPlaying songMid:" + songMid);
                    Intent i06 = QQPlayerService.i0();
                    if (i06 != null) {
                        i06.addFlags(268435456);
                        i06.addFlags(536870912);
                        i06.addFlags(67108864);
                        context.startActivity(i06);
                        return;
                    }
                    QQToast.makeText(context, "\u8df3\u8f6c\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
                    return;
                }
            }
            QLog.i("VasSquareRouter", 1, "do openH5 songMid:" + songMid);
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(songMid, "http://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(songMid, "https://", false, 2, null);
                if (!startsWith$default2) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("https://i.y.qq.com/v8/playsong.html?songmid=%s&ADTAG=hz_sq_sqzt&channelId=2005001004", Arrays.copyOf(new Object[]{songMid}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    Intent intent = new Intent();
                    intent.putExtra("url", format);
                    RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
                    return;
                }
            }
            QLog.d("VasSquareRouter", 1, "openH5 fail");
        }
    }

    @Override // com.tencent.state.square.IRouter
    public void routeToZplanPortal(Context context, Bundle bundle, String subSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(subSource, "subSource");
        ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startPortalActivity(context, ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.StatusSquare, subSource, null, 4, null), bundle);
    }

    @Override // com.tencent.state.square.IRouter
    public void startActivity(Context context, Intent intent) {
        IRouter.DefaultImpls.startActivity(this, context, intent);
    }

    @Override // com.tencent.state.square.IRouter
    public void startActivityForResult(Context context, Intent intent, int i3) {
        IRouter.DefaultImpls.startActivityForResult(this, context, intent, i3);
    }

    @Override // com.tencent.state.square.IRouter
    public void getSquarePoiInfo(Intent data) {
        if (data != null) {
            Bundle extras = data.getExtras();
            LbsDataV2.PoiInfo poiInfo = extras != null ? (LbsDataV2.PoiInfo) extras.getParcelable(QZoneHelper.INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI) : null;
            if (poiInfo != null) {
                AvatarLocationInfo avatarLocationInfo = new AvatarLocationInfo(0.0d, 0.0d, null, null, null, 31, null);
                String str = poiInfo.poiName;
                Intrinsics.checkNotNullExpressionValue(str, "poi.poiName");
                avatarLocationInfo.setPoi(str);
                String str2 = poiInfo.poiId;
                Intrinsics.checkNotNullExpressionValue(str2, "poi.poiId");
                avatarLocationInfo.setPoiId(str2);
                String str3 = poiInfo.address;
                if (str3 != null) {
                    Intrinsics.checkNotNullExpressionValue(str3, "poi.address");
                } else {
                    str3 = "";
                }
                avatarLocationInfo.setPoiAddress(str3);
                avatarLocationInfo.setLatitude(poiInfo.gpsInfo.lat / 1000000.0d);
                avatarLocationInfo.setLongitude(poiInfo.gpsInfo.lon / 1000000.0d);
                data.putExtra("square_poi_info", avatarLocationInfo);
            }
        }
    }
}
