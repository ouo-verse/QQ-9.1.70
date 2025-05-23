package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import trpc.tianshu.RedPointTransInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ci {

    /* renamed from: a, reason: collision with root package name */
    public static final List<String> f92747a;

    static {
        ArrayList arrayList = new ArrayList();
        f92747a = arrayList;
        arrayList.add("140110");
        arrayList.add("4045");
    }

    public static void a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, RedPointTransInfo redPointTransInfo) {
        if (feedCloudMeta$StFeed != null && redPointTransInfo != null) {
            FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = new FeedCloudCommon$BytesEntry();
            feedCloudCommon$BytesEntry.key.set("client_red_point_trans_info");
            feedCloudCommon$BytesEntry.value.set(ByteStringMicro.copyFrom(redPointTransInfo.encode()));
            feedCloudMeta$StFeed.debugInfo.debugMapBytes.add(feedCloudCommon$BytesEntry);
        }
    }

    public static boolean b(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            return false;
        }
        return com.tencent.mobileqq.tianshu.ui.a.d(appInfo);
    }

    public static RedPointTransInfo c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return null;
        }
        List<FeedCloudCommon$BytesEntry> list = feedCloudMeta$StFeed.debugInfo.debugMapBytes.get();
        int i3 = 0;
        while (true) {
            if (i3 >= list.size()) {
                break;
            }
            FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = list.get(i3);
            if (!TextUtils.equals(feedCloudCommon$BytesEntry.key.get(), "client_red_point_trans_info")) {
                i3++;
            } else {
                try {
                    return RedPointTransInfo.ADAPTER.decode(feedCloudCommon$BytesEntry.value.get().toByteArray());
                } catch (Exception e16) {
                    RFWLog.e("QFSRedPoint_QFSTianshuRedPointUtils", RFWLog.USR, "getRedPointTransInfo error:" + e16);
                    return null;
                }
            }
        }
    }
}
