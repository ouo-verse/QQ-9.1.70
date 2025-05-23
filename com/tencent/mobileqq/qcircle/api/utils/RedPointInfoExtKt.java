package com.tencent.mobileqq.qcircle.api.utils;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.helper.QCircleRedDotDataHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleCounter$RedPointInfo;
import qqcircle.QQCircleCounterMsg$RedDisplayInfo;
import qqcircle.QQCircleCounterStyle$BubbleContent;
import qqcircle.QQCircleCounterStyle$StyleBubble;
import qqcircle.QQCircleCounterStyle$StyleRed;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a\f\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0006\u001a\n\u0010\t\u001a\u00020\u0003*\u00020\u0006\u001a\n\u0010\n\u001a\u00020\u0003*\u00020\u0006\u001a\n\u0010\u000b\u001a\u00020\u0003*\u00020\u0006\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\r\u001a\u00020\u0003*\u00020\u0006\u001a\n\u0010\u000e\u001a\u00020\u000f*\u00020\u0006\u001a\n\u0010\u0010\u001a\u00020\u0003*\u00020\u0006\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0006\u001a\n\u0010\u0013\u001a\u00020\u0012*\u00020\u0006\u001a\n\u0010\u0014\u001a\u00020\u0012*\u00020\u0006\u001a\n\u0010\u0015\u001a\u00020\u0012*\u00020\u0006\u001a\n\u0010\u0016\u001a\u00020\u0012*\u00020\u0006\u001a\n\u0010\u0017\u001a\u00020\u0012*\u00020\u0006\u001a\n\u0010\u0018\u001a\u00020\u0012*\u00020\u0006\u001a\n\u0010\u0019\u001a\u00020\u0012*\u00020\u001a\u001a\n\u0010\u001b\u001a\u00020\u0012*\u00020\u0006\u001a\u0012\u0010\u001c\u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006\u001a\u0016\u0010\u001e\u001a\u00020\u0012*\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u001a\u0012\u0010 \u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"DEFAULT_PLAY_DURATION", "", "TAG", "", "getAvatarCornerInfo", "Lqqcircle/QQCircleCounterStyle$StyleRed;", "Lqqcircle/QQCircleCounter$RedPointInfo;", "getAvatarDisplayInfo", "Lqqcircle/QQCircleCounterMsg$RedDisplayInfo;", "getAvatarInfoStr", "getAvatarRedPointId", "getBubbleId", "getPlayDuration", "getPreloadFeedId", "getPreloadSource", "", "getRedPointId", "hasAvatar", "", "hasBubble", "hasNum", "hasRedCorner", "hasRedPoint", "isBubbleContentEmpty", "isBubbleExpired", "isContentEmpty", "Lqqcircle/QQCircleCounterStyle$StyleBubble;", "isMatchBubbleDemotion", "isSameAvatarRedPoint", "redPointInfo", "isSameBubble", "preRedPointInfo", "isSameNumRedPoint", "qcircle-api_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class RedPointInfoExtKt {
    private static final long DEFAULT_PLAY_DURATION = 5000;

    @NotNull
    private static final String TAG = "QCircleTabRedPoint-RedPointInfoExt";

    @NotNull
    public static final QQCircleCounterStyle$StyleRed getAvatarCornerInfo(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        QQCircleCounterStyle$StyleRed qQCircleCounterStyle$StyleRed = qQCircleCounter$RedPointInfo.allPushInfo.styleBottomTab.red.get();
        Intrinsics.checkNotNullExpressionValue(qQCircleCounterStyle$StyleRed, "allPushInfo.styleBottomTab.red.get()");
        return qQCircleCounterStyle$StyleRed;
    }

    @Nullable
    public static final QQCircleCounterMsg$RedDisplayInfo getAvatarDisplayInfo(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        List<QQCircleCounterMsg$RedDisplayInfo> list = qQCircleCounter$RedPointInfo.allPushInfo.styleBottomTab.button.icons.get();
        Intrinsics.checkNotNullExpressionValue(list, "allPushInfo.styleBottomTab.button.icons.get()");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
        return (QQCircleCounterMsg$RedDisplayInfo) firstOrNull;
    }

    @NotNull
    public static final String getAvatarInfoStr(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        String str;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        QQCircleCounterMsg$RedDisplayInfo avatarDisplayInfo = getAvatarDisplayInfo(qQCircleCounter$RedPointInfo);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("id=");
        sb5.append(getAvatarRedPointId(qQCircleCounter$RedPointInfo));
        sb5.append(", uin=");
        String str2 = null;
        if (avatarDisplayInfo != null && (pBStringField2 = avatarDisplayInfo.headImg) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append(", url=");
        if (avatarDisplayInfo != null && (pBStringField = avatarDisplayInfo.avatarURL) != null) {
            str2 = pBStringField.get();
        }
        sb5.append(str2);
        return sb5.toString();
    }

    @NotNull
    public static final String getAvatarRedPointId(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        String str = qQCircleCounter$RedPointInfo.allPushInfo.styleBottomTab.button.f429299id.get();
        Intrinsics.checkNotNullExpressionValue(str, "allPushInfo.styleBottomTab.button.id.get()");
        return str;
    }

    @NotNull
    public static final String getBubbleId(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        String str = qQCircleCounter$RedPointInfo.allPushInfo.styleBottomTab.bubble.get().f429298id.get();
        Intrinsics.checkNotNullExpressionValue(str, "allPushInfo.styleBottomTab.bubble.get().id.get()");
        return str;
    }

    public static final long getPlayDuration(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        int i3 = qQCircleCounter$RedPointInfo.allPushInfo.styleBottomTab.playSecond.get();
        if (i3 <= 0) {
            return 5000L;
        }
        return i3 * 1000;
    }

    @NotNull
    public static final String getPreloadFeedId(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        String str;
        Object obj;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        List<FeedCloudCommon$Entry> list = qQCircleCounter$RedPointInfo.extInfo.mapInfo.get();
        Intrinsics.checkNotNullExpressionValue(list, "extInfo.mapInfo.get()");
        Iterator<T> it = list.iterator();
        while (true) {
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((FeedCloudCommon$Entry) obj).key.get(), "feedID")) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        FeedCloudCommon$Entry feedCloudCommon$Entry = (FeedCloudCommon$Entry) obj;
        if (feedCloudCommon$Entry != null && (pBStringField = feedCloudCommon$Entry.value) != null) {
            str = pBStringField.get();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static final int getPreloadSource(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        if (qQCircleCounter$RedPointInfo.tabType.get() == 9) {
            return 75;
        }
        return 10000;
    }

    @NotNull
    public static final String getRedPointId(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        String str;
        Object obj;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        List<FeedCloudCommon$Entry> list = qQCircleCounter$RedPointInfo.extInfo.mapInfo.get();
        Intrinsics.checkNotNullExpressionValue(list, "extInfo.mapInfo.get()");
        Iterator<T> it = list.iterator();
        while (true) {
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((FeedCloudCommon$Entry) obj).key.get(), "redPointID")) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        FeedCloudCommon$Entry feedCloudCommon$Entry = (FeedCloudCommon$Entry) obj;
        if (feedCloudCommon$Entry != null && (pBStringField = feedCloudCommon$Entry.value) != null) {
            str = pBStringField.get();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static final boolean hasAvatar(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        Intrinsics.checkNotNullExpressionValue(qQCircleCounter$RedPointInfo.allPushInfo.styleBottomTab.button.icons.get(), "allPushInfo.styleBottomTab.button.icons.get()");
        return !r1.isEmpty();
    }

    public static final boolean hasBubble(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        if (QCircleRedDotDataHelper.isShowBubbleRedDot(qQCircleCounter$RedPointInfo)) {
            QQCircleCounterStyle$StyleBubble qQCircleCounterStyle$StyleBubble = qQCircleCounter$RedPointInfo.allPushInfo.styleBottomTab.bubble.get();
            Intrinsics.checkNotNullExpressionValue(qQCircleCounterStyle$StyleBubble, "allPushInfo.styleBottomTab.bubble.get()");
            if (!isContentEmpty(qQCircleCounterStyle$StyleBubble)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean hasNum(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        if (QCircleRedDotDataHelper.getAllRedNum(qQCircleCounter$RedPointInfo) > 0) {
            return true;
        }
        return false;
    }

    public static final boolean hasRedCorner(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        if (qQCircleCounter$RedPointInfo.allPushInfo.styleBottomTab.red.typ.get() != 0) {
            return true;
        }
        return false;
    }

    public static final boolean hasRedPoint(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        if (QCircleRedDotDataHelper.isShowActiveRedDot(qQCircleCounter$RedPointInfo) || QCircleRedDotDataHelper.isShowRecommendRedDot(qQCircleCounter$RedPointInfo, 1) || QCircleRedDotDataHelper.isShowPymkRedDot(qQCircleCounter$RedPointInfo)) {
            return true;
        }
        return false;
    }

    public static final boolean isBubbleContentEmpty(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        QQCircleCounterStyle$StyleBubble qQCircleCounterStyle$StyleBubble = qQCircleCounter$RedPointInfo.allPushInfo.styleBottomTab.bubble.get();
        Intrinsics.checkNotNullExpressionValue(qQCircleCounterStyle$StyleBubble, "allPushInfo.styleBottomTab.bubble.get()");
        return isContentEmpty(qQCircleCounterStyle$StyleBubble);
    }

    public static final boolean isBubbleExpired(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        long j3 = qQCircleCounter$RedPointInfo.allPushInfo.styleBottomTab.bubble.expireTime.get();
        long serverTime = NetConnInfoCenter.getServerTime();
        if (j3 < serverTime) {
            QLog.i(TAG, 1, "isBubbleExpired, expireTime=" + j3 + ", serverTime=" + serverTime);
            return true;
        }
        return false;
    }

    public static final boolean isContentEmpty(@NotNull QQCircleCounterStyle$StyleBubble qQCircleCounterStyle$StyleBubble) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(qQCircleCounterStyle$StyleBubble, "<this>");
        List<QQCircleCounterStyle$BubbleContent> list = qQCircleCounterStyle$StyleBubble.contents.get();
        Intrinsics.checkNotNullExpressionValue(list, "contents.get()");
        List<QQCircleCounterStyle$BubbleContent> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((QQCircleCounterStyle$BubbleContent) it.next()).text.get().length()));
        }
        Iterator it5 = arrayList.iterator();
        int i3 = 0;
        while (it5.hasNext()) {
            i3 += ((Number) it5.next()).intValue();
        }
        if (i3 > 0) {
            return false;
        }
        return true;
    }

    public static final boolean isMatchBubbleDemotion(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        if (qQCircleCounter$RedPointInfo.allPushInfo.styleBottomTab.mod.get() == 1) {
            return true;
        }
        return false;
    }

    public static final boolean isSameAvatarRedPoint(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo, @NotNull QQCircleCounter$RedPointInfo redPointInfo) {
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        Intrinsics.checkNotNullParameter(redPointInfo, "redPointInfo");
        return Intrinsics.areEqual(getAvatarRedPointId(redPointInfo), getAvatarRedPointId(qQCircleCounter$RedPointInfo));
    }

    public static final boolean isSameBubble(@Nullable QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo, @Nullable QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo2) {
        if (qQCircleCounter$RedPointInfo == null && qQCircleCounter$RedPointInfo2 == null) {
            return true;
        }
        if (qQCircleCounter$RedPointInfo != null && qQCircleCounter$RedPointInfo2 != null) {
            QQCircleCounterStyle$StyleBubble qQCircleCounterStyle$StyleBubble = qQCircleCounter$RedPointInfo.allPushInfo.styleBottomTab.bubble.get();
            Intrinsics.checkNotNullExpressionValue(qQCircleCounterStyle$StyleBubble, "allPushInfo.styleBottomTab.bubble.get()");
            QQCircleCounterStyle$StyleBubble qQCircleCounterStyle$StyleBubble2 = qQCircleCounter$RedPointInfo2.allPushInfo.styleBottomTab.bubble.get();
            Intrinsics.checkNotNullExpressionValue(qQCircleCounterStyle$StyleBubble2, "preRedPointInfo.allPushI\u2026yleBottomTab.bubble.get()");
            return QCircleStyleTabExtKt.isSameBubbleContent(qQCircleCounterStyle$StyleBubble, qQCircleCounterStyle$StyleBubble2);
        }
        return false;
    }

    public static final boolean isSameNumRedPoint(@NotNull QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo, @NotNull QQCircleCounter$RedPointInfo redPointInfo) {
        Intrinsics.checkNotNullParameter(qQCircleCounter$RedPointInfo, "<this>");
        Intrinsics.checkNotNullParameter(redPointInfo, "redPointInfo");
        return Intrinsics.areEqual(getRedPointId(redPointInfo), getRedPointId(qQCircleCounter$RedPointInfo));
    }
}
