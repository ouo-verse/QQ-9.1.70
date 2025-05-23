package com.tencent.biz.qqcircle.immersive.feed.live;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.feed.live.od.a;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$RoomInfoData;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import weprotocols.WEProtocolsVaslive$DatingRoomInfo;
import weprotocols.WEProtocolsVaslive$SeatUserList;
import weprotocols.WEProtocolsVaslive$TrtcInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private static final IAegisLogApi f86369a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: b, reason: collision with root package name */
    private static final a f86370b = new a();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class a implements Comparator<WEProtocolsVaslive$SeatUserList> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(WEProtocolsVaslive$SeatUserList wEProtocolsVaslive$SeatUserList, WEProtocolsVaslive$SeatUserList wEProtocolsVaslive$SeatUserList2) {
            return wEProtocolsVaslive$SeatUserList.seatNo.get() - wEProtocolsVaslive$SeatUserList2.seatNo.get();
        }
    }

    private static boolean a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String str;
        if (feedCloudMeta$StFeed.live == null) {
            str = "live is null";
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        f86369a.w("LiveDataParser", 1, "check od data error! info:" + str);
        return false;
    }

    public static String b(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String str = "";
        if (!a(feedCloudMeta$StFeed)) {
            return "";
        }
        PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField = feedCloudMeta$StFeed.live.liveExtInfo;
        int size = pBRepeatMessageField.get().size();
        for (int i3 = 0; i3 < size; i3++) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = pBRepeatMessageField.get(i3);
            if (QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN.equalsIgnoreCase(feedCloudCommon$Entry.key.get())) {
                str = feedCloudCommon$Entry.value.get();
            }
        }
        return str;
    }

    public static WEProtocolsVaslive$DatingRoomInfo c(e30.b bVar) {
        if (bVar == null) {
            return null;
        }
        Object b16 = bVar.b("DITTO_FEED_DATING_ROOM_DATA");
        if (!(b16 instanceof WEProtocolsVaslive$DatingRoomInfo)) {
            return null;
        }
        return (WEProtocolsVaslive$DatingRoomInfo) b16;
    }

    @Nullable
    public static a.C0883a d(WEProtocolsVaslive$DatingRoomInfo wEProtocolsVaslive$DatingRoomInfo) {
        List<WEProtocolsVaslive$SeatUserList> list;
        if (wEProtocolsVaslive$DatingRoomInfo == null || wEProtocolsVaslive$DatingRoomInfo.seatUsers.isEmpty() || wEProtocolsVaslive$DatingRoomInfo.seatUsers.get() == null || wEProtocolsVaslive$DatingRoomInfo.seatUsers.get().isEmpty() || (list = wEProtocolsVaslive$DatingRoomInfo.seatUsers.get()) == null || list.isEmpty()) {
            return null;
        }
        WEProtocolsVaslive$SeatUserList wEProtocolsVaslive$SeatUserList = list.get(0);
        return new a.C0883a.C0884a().e(wEProtocolsVaslive$SeatUserList.uid.get()).b(wEProtocolsVaslive$SeatUserList.userBasic.logo.url.get()).c(wEProtocolsVaslive$SeatUserList.userBasic.nick.get()).d(wEProtocolsVaslive$SeatUserList.seatNo.get()).a();
    }

    public static WEProtocolsVaslive$TrtcInfo e(e30.b bVar) {
        if (bVar == null) {
            return null;
        }
        Object b16 = bVar.b("DITTO_FEED_TRTC_INFO_DATA");
        if (!(b16 instanceof WEProtocolsVaslive$TrtcInfo)) {
            return null;
        }
        return (WEProtocolsVaslive$TrtcInfo) b16;
    }

    public static boolean f(FeedCloudMeta$StFeed feedCloudMeta$StFeed, WEProtocolsVaslive$DatingRoomInfo wEProtocolsVaslive$DatingRoomInfo) {
        if (feedCloudMeta$StFeed == null || wEProtocolsVaslive$DatingRoomInfo == null || wEProtocolsVaslive$DatingRoomInfo.gameID.get() != 1 || wEProtocolsVaslive$DatingRoomInfo.seatUsers.get() == null || wEProtocolsVaslive$DatingRoomInfo.seatUsers.get().size() == 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public static WEProtocolsVaslive$DatingRoomInfo g(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        WEProtocolsVaslive$DatingRoomInfo wEProtocolsVaslive$DatingRoomInfo = null;
        if (!a(feedCloudMeta$StFeed)) {
            return null;
        }
        PBRepeatMessageField<FeedCloudCommon$BytesEntry> pBRepeatMessageField = feedCloudMeta$StFeed.live.liveBytesExtInfo;
        int size = pBRepeatMessageField.get().size();
        for (int i3 = 0; i3 < size; i3++) {
            FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = pBRepeatMessageField.get(i3);
            if ("dating_room_info".equalsIgnoreCase(feedCloudCommon$BytesEntry.key.get())) {
                wEProtocolsVaslive$DatingRoomInfo = new WEProtocolsVaslive$DatingRoomInfo();
                try {
                    wEProtocolsVaslive$DatingRoomInfo.mergeFrom(feedCloudCommon$BytesEntry.value.get().toByteArray());
                } catch (InvalidProtocolBufferMicroException e16) {
                    f86369a.w("LiveDataParser", 1, e16.getMessage());
                }
            }
        }
        if (wEProtocolsVaslive$DatingRoomInfo != null) {
            List<WEProtocolsVaslive$SeatUserList> list = wEProtocolsVaslive$DatingRoomInfo.seatUsers.get();
            Collections.sort(list, f86370b);
            wEProtocolsVaslive$DatingRoomInfo.seatUsers.clear();
            wEProtocolsVaslive$DatingRoomInfo.seatUsers.addAll(list);
        }
        return wEProtocolsVaslive$DatingRoomInfo;
    }

    @Nullable
    public static FeedCloudMeta$RoomInfoData h(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!a(feedCloudMeta$StFeed)) {
            return null;
        }
        return feedCloudMeta$StFeed.live.room;
    }

    public static long i(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!a(feedCloudMeta$StFeed)) {
            return -1L;
        }
        PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField = feedCloudMeta$StFeed.live.liveExtInfo;
        int size = pBRepeatMessageField.get().size();
        long j3 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = pBRepeatMessageField.get(i3);
            if ("uid".equalsIgnoreCase(feedCloudCommon$Entry.key.get())) {
                try {
                    j3 = Long.parseLong(feedCloudCommon$Entry.value.get());
                } catch (NumberFormatException e16) {
                    f86369a.w("LiveDataParser", 1, e16.getMessage());
                }
            }
        }
        return j3;
    }

    @Nullable
    public static WEProtocolsVaslive$TrtcInfo j(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        WEProtocolsVaslive$TrtcInfo wEProtocolsVaslive$TrtcInfo;
        InvalidProtocolBufferMicroException e16;
        WEProtocolsVaslive$TrtcInfo wEProtocolsVaslive$TrtcInfo2 = null;
        if (!a(feedCloudMeta$StFeed)) {
            return null;
        }
        PBRepeatMessageField<FeedCloudCommon$BytesEntry> pBRepeatMessageField = feedCloudMeta$StFeed.live.liveBytesExtInfo;
        int size = pBRepeatMessageField.get().size();
        for (int i3 = 0; i3 < size; i3++) {
            FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = pBRepeatMessageField.get(i3);
            try {
                if ("trtc_info".equals(feedCloudCommon$BytesEntry.key.get())) {
                    wEProtocolsVaslive$TrtcInfo = new WEProtocolsVaslive$TrtcInfo();
                    try {
                        wEProtocolsVaslive$TrtcInfo2 = wEProtocolsVaslive$TrtcInfo.mergeFrom(feedCloudCommon$BytesEntry.value.get().toByteArray());
                    } catch (InvalidProtocolBufferMicroException e17) {
                        e16 = e17;
                        f86369a.w("LiveDataParser", 1, e16.getMessage());
                        wEProtocolsVaslive$TrtcInfo2 = wEProtocolsVaslive$TrtcInfo;
                    }
                }
            } catch (InvalidProtocolBufferMicroException e18) {
                wEProtocolsVaslive$TrtcInfo = wEProtocolsVaslive$TrtcInfo2;
                e16 = e18;
            }
        }
        return wEProtocolsVaslive$TrtcInfo2;
    }
}
