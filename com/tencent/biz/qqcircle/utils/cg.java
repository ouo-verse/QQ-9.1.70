package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.qcircle.api.event.QFSShowReportBottomSheetEvent;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class cg {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, ArrayList<String>> f92743a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<String, ArrayList<String>> f92744b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<String, ArrayList<String>> f92745c = new HashMap<>();

    public static void a(String str, String str2) {
        HashMap<String, ArrayList<String>> hashMap = f92744b;
        ArrayList<String> arrayList = hashMap.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(str2);
        hashMap.put(str, arrayList);
    }

    public static void b(String str, String str2) {
        HashMap<String, ArrayList<String>> hashMap = f92743a;
        ArrayList<String> arrayList = hashMap.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(str2);
        hashMap.put(str, arrayList);
    }

    public static void c(String str, String str2) {
        HashMap<String, ArrayList<String>> hashMap = f92745c;
        ArrayList<String> arrayList = hashMap.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(str2);
        hashMap.put(str, arrayList);
    }

    public static void d() {
        f92743a.clear();
        f92744b.clear();
        f92745c.clear();
    }

    public static void e(String str, List<FeedCloudMeta$StComment> list) {
        ArrayList<String> arrayList;
        if (RFSafeListUtils.isEmpty(list) || (arrayList = f92743a.get(str)) == null) {
            return;
        }
        Iterator<FeedCloudMeta$StComment> it = list.iterator();
        while (it.hasNext()) {
            String str2 = it.next().f398447id.get();
            if (arrayList.contains(str2)) {
                QLog.d("QFSCommentReportHelper", 1, "[filterReportedComment] commentId: " + str2);
                it.remove();
            }
        }
    }

    public static void f(String str, List<FeedCloudMeta$StComment> list) {
        if (RFSafeListUtils.isEmpty(list) || f92745c.get(str) == null) {
            return;
        }
        Iterator<FeedCloudMeta$StComment> it = list.iterator();
        while (it.hasNext()) {
            g(str, it.next().vecReply.get());
        }
    }

    public static void g(String str, List<FeedCloudMeta$StReply> list) {
        ArrayList<String> arrayList;
        if (!RFSafeListUtils.isEmpty(list) && (arrayList = f92745c.get(str)) != null) {
            Iterator<FeedCloudMeta$StReply> it = list.iterator();
            while (it.hasNext()) {
                String str2 = it.next().f398460id.get();
                if (arrayList.contains(str2)) {
                    QLog.d("QFSCommentReportHelper", 1, "[filterReportedReply] replyId: " + str2);
                    it.remove();
                }
            }
        }
    }

    public static void h(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StComment != null) {
            j(i3, feedCloudMeta$StFeed, null, feedCloudMeta$StComment, null);
        } else {
            QLog.w("QFSCommentReportHelper", 1, "[report] feed or comment should not be null, flow end.", new Exception());
        }
    }

    public static void i(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StComment != null && feedCloudMeta$StReply != null) {
            j(i3, feedCloudMeta$StFeed, null, feedCloudMeta$StComment, feedCloudMeta$StReply);
        } else {
            QLog.w("QFSCommentReportHelper", 1, "[report] param exists null, flow end.", new Exception());
        }
    }

    private static void j(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        QFSShowReportBottomSheetEvent qFSShowReportBottomSheetEvent = new QFSShowReportBottomSheetEvent(feedCloudMeta$StFeed, feedCloudMeta$StBarrage, feedCloudMeta$StComment, feedCloudMeta$StReply);
        qFSShowReportBottomSheetEvent.mHashCode = i3;
        SimpleEventBus.getInstance().dispatchEvent(qFSShowReportBottomSheetEvent);
    }
}
