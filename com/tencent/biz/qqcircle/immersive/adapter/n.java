package com.tencent.biz.qqcircle.immersive.adapter;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$RoomInfoData;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLive;

/* compiled from: P */
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseArray<Integer> f84727a;

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>();
        f84727a = sparseArray;
        sparseArray.put(15, 100015);
        sparseArray.put(34, 100015);
        sparseArray.put(35, 100035);
        sparseArray.put(36, 100036);
        sparseArray.put(37, 100037);
        sparseArray.put(38, 100038);
        sparseArray.put(41, 100041);
        sparseArray.put(48, 100048);
        sparseArray.put(44, 100044);
        sparseArray.put(47, 100047);
    }

    private static int a(int i3, int i16, int i17) {
        if (i3 >= 0) {
            return i3;
        }
        return (i16 * 1000) + i17;
    }

    private static int b(int i3, int i16) {
        return (i3 * 2000) + i16;
    }

    private static int c(int i3, int i16) {
        return (i3 * 3000) + i16;
    }

    public static int d(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSLayerPageTypeUtils", 1, "getItemViewType() input data is null!");
            return -1008;
        }
        if (feedCloudMeta$StFeed.feedType.get() != 4) {
            return -1008;
        }
        return -1009;
    }

    public static int e(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSLayerPageTypeUtils", 1, "getItemViewType() input data is null!");
            return 0;
        }
        int i3 = feedCloudMeta$StFeed.dittoFeed.dittoId.get();
        int i16 = feedCloudMeta$StFeed.type.get();
        int f16 = f(i3);
        int i17 = feedCloudMeta$StFeed.feedType.get();
        if (i17 != 1) {
            if (i17 != 3) {
                if (i17 != 4) {
                    if (i17 != 5) {
                        if (!j30.f.a(i17)) {
                            return 0;
                        }
                        return i17;
                    }
                    return 100032;
                }
                return 4003;
            }
            return a(f16, 3, i16);
        }
        if (h(feedCloudMeta$StFeed)) {
            return b(1, g(feedCloudMeta$StFeed));
        }
        if (k(feedCloudMeta$StFeed)) {
            return c(1, i16);
        }
        return a(f16, 1, i16);
    }

    private static int f(int i3) {
        SparseArray<Integer> sparseArray = f84727a;
        int indexOfKey = sparseArray.indexOfKey(i3);
        if (indexOfKey < 0) {
            return indexOfKey;
        }
        return sparseArray.get(i3).intValue();
    }

    public static int g(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$RoomInfoData feedCloudMeta$RoomInfoData;
        FeedCloudMeta$StLive feedCloudMeta$StLive = feedCloudMeta$StFeed.live;
        if (feedCloudMeta$StLive != null && (feedCloudMeta$RoomInfoData = feedCloudMeta$StLive.room) != null && feedCloudMeta$RoomInfoData.roomType.get() == 2) {
            return 2;
        }
        return 1;
    }

    private static boolean h(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed.type.get() == 4) {
            return true;
        }
        return false;
    }

    public static boolean i(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null || feedCloudMeta$StFeed.type.get() != 2) {
            return false;
        }
        return true;
    }

    public static boolean j(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        int i3 = feedCloudMeta$StFeed.feedType.get();
        int i16 = feedCloudMeta$StFeed.type.get();
        if (i3 != 1 || i16 != 4) {
            return false;
        }
        return true;
    }

    public static boolean k(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        String d16 = bh.d(feedCloudMeta$StFeed.extInfo.get(), "top_view");
        if (TextUtils.isEmpty(d16) || !"1".equalsIgnoreCase(d16)) {
            return false;
        }
        return true;
    }

    public static boolean l(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        return p40.o.e(feedCloudMeta$StFeed);
    }
}
