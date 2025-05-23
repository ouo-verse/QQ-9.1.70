package com.qzone.proxy.feedcomponent.service;

import NS_MOBILE_FEEDS.SimpleComment;
import NS_MOBILE_FEEDS.single_feed;
import NS_UNDEAL_COUNT.feed_host_info;
import PUSH_UPDATE_FEEDS.CommentReplyInfo;
import PUSH_UPDATE_FEEDS.PushUpdateFeeds;
import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.e;
import com.qzone.proxy.feedcomponent.b;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.util.WiFiDash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedIncrementalUpdateService {

    /* renamed from: d, reason: collision with root package name */
    static FeedIncrementalUpdateService f50449d;

    /* renamed from: e, reason: collision with root package name */
    static final Object f50450e = new Object();

    /* renamed from: b, reason: collision with root package name */
    private long f50452b;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f50451a = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private Runnable f50453c = new Runnable() { // from class: com.qzone.proxy.feedcomponent.service.FeedIncrementalUpdateService.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                FeedIncrementalUpdateService.this.c();
                FeedIncrementalUpdateService.this.f50452b = System.currentTimeMillis();
            } catch (Exception unused) {
            }
        }
    };

    FeedIncrementalUpdateService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        HashMap hashMap = new HashMap(this.f50451a);
        this.f50451a.clear();
        e.b("PushDataUpdate", this, 1, new Object[]{hashMap});
    }

    public static FeedIncrementalUpdateService d() {
        if (f50449d == null) {
            synchronized (f50450e) {
                if (f50449d == null) {
                    f50449d = new FeedIncrementalUpdateService();
                }
            }
        }
        return f50449d;
    }

    private void h(PushUpdateFeeds pushUpdateFeeds) {
        StringBuffer stringBuffer = new StringBuffer(1024);
        stringBuffer.append("recv FeedUpdate Push. ");
        stringBuffer.append("ugcKey:");
        stringBuffer.append(pushUpdateFeeds.ugc_key);
        stringBuffer.append(" feeds_update_time:");
        stringBuffer.append(pushUpdateFeeds.feeds_update_time);
        stringBuffer.append(" need_pull:");
        stringBuffer.append(pushUpdateFeeds.need_pull);
        if (pushUpdateFeeds.commmet_reply_info == null) {
            stringBuffer.append(" comment--");
            stringBuffer.append("N/A ");
        } else {
            stringBuffer.append(" comment--");
            stringBuffer.append(i(pushUpdateFeeds.commmet_reply_info));
            stringBuffer.append(" ");
        }
        if (pushUpdateFeeds.feeds_data == null) {
            stringBuffer.append(" feeds_data:");
            stringBuffer.append(WiFiDash.NOT_AVALIBLE);
        }
        b.e("FeedUpdate", "recv Push: " + stringBuffer.toString());
    }

    private String i(CommentReplyInfo commentReplyInfo) {
        StringBuffer stringBuffer = new StringBuffer(1024);
        stringBuffer.append(" total_num:");
        stringBuffer.append(commentReplyInfo.total_num);
        if (commentReplyInfo.cur_comment_reply != null) {
            stringBuffer.append(" currComment:");
            stringBuffer.append(commentReplyInfo.cur_comment_reply.commentid);
            stringBuffer.append(" content:");
            stringBuffer.append(commentReplyInfo.cur_comment_reply.content);
            stringBuffer.append(" isDel:");
            stringBuffer.append(commentReplyInfo.cur_comment_reply.isDeleted);
        }
        ArrayList<SimpleComment> arrayList = commentReplyInfo.all_commont_list;
        if (arrayList != null && arrayList.size() > 0) {
            stringBuffer.append(" ID:");
            Iterator<SimpleComment> it = commentReplyInfo.all_commont_list.iterator();
            while (it.hasNext()) {
                SimpleComment next = it.next();
                stringBuffer.append("[");
                stringBuffer.append(next.f24981id);
                ArrayList<Long> arrayList2 = next.reply_ids;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    stringBuffer.append("(");
                    Iterator<Long> it5 = next.reply_ids.iterator();
                    while (it5.hasNext()) {
                        stringBuffer.append(it5.next());
                        stringBuffer.append(",");
                    }
                    stringBuffer.append(")");
                }
                stringBuffer.append("]");
            }
        }
        return stringBuffer.toString();
    }

    public synchronized void g(PushUpdateFeeds pushUpdateFeeds) {
        if (pushUpdateFeeds != null) {
            if (!TextUtils.isEmpty(pushUpdateFeeds.ugc_key)) {
                b.e("FeedUpdate", "increase update. ugckey:" + pushUpdateFeeds.ugc_key);
                long j3 = 0;
                if (this.f50452b <= 0) {
                    this.f50452b = System.currentTimeMillis();
                }
                long currentTimeMillis = 1000 - (System.currentTimeMillis() - this.f50452b);
                if (currentTimeMillis >= 0) {
                    j3 = currentTimeMillis;
                }
                RFWThreadManager.getInstance().remove(this.f50453c);
                try {
                    h(pushUpdateFeeds);
                } catch (Throwable th5) {
                    b.d("FeedUpdate", "printPushInfo error.", th5);
                }
                if (!this.f50451a.containsKey(pushUpdateFeeds.ugc_key)) {
                    this.f50451a.put(pushUpdateFeeds.ugc_key, a.a(pushUpdateFeeds));
                } else {
                    a aVar = this.f50451a.get(pushUpdateFeeds.ugc_key);
                    if (aVar != null) {
                        aVar.b(pushUpdateFeeds);
                    }
                }
                RFWThreadManager.getInstance().execOnSubThread(this.f50453c, j3);
            }
        }
    }

    public void e(List<feed_host_info> list) {
        e.b("PushDataUpdate", this, 4, new Object[]{list});
    }

    public void f(List<single_feed> list) {
        e.b("PushDataUpdate", this, 2, new Object[]{list});
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f50454a;

        /* renamed from: b, reason: collision with root package name */
        public Map<Integer, byte[]> f50455b;

        /* renamed from: c, reason: collision with root package name */
        public Map<String, String> f50456c;

        /* renamed from: d, reason: collision with root package name */
        public Map<Integer, String> f50457d;

        /* renamed from: e, reason: collision with root package name */
        public List<CommentReplyInfo> f50458e;

        /* renamed from: f, reason: collision with root package name */
        public long f50459f;

        public void b(PushUpdateFeeds pushUpdateFeeds) {
            Map<Integer, byte[]> map = this.f50455b;
            if (map == null) {
                this.f50455b = pushUpdateFeeds.feeds_data;
            } else {
                map.putAll(pushUpdateFeeds.feeds_data);
            }
            Map<String, String> map2 = this.f50456c;
            if (map2 == null) {
                this.f50456c = pushUpdateFeeds.extendinfo;
            } else {
                map2.putAll(pushUpdateFeeds.extendinfo);
            }
            Map<Integer, String> map3 = this.f50457d;
            if (map3 == null) {
                this.f50457d = pushUpdateFeeds.cell_checksum;
            } else {
                map3.putAll(pushUpdateFeeds.cell_checksum);
            }
            if (pushUpdateFeeds.commmet_reply_info != null) {
                if (this.f50458e == null) {
                    this.f50458e = new ArrayList();
                }
                this.f50458e.add(pushUpdateFeeds.commmet_reply_info);
            }
        }

        public static a a(PushUpdateFeeds pushUpdateFeeds) {
            if (pushUpdateFeeds == null) {
                return null;
            }
            a aVar = new a();
            aVar.f50454a = pushUpdateFeeds.ugc_key;
            aVar.f50455b = pushUpdateFeeds.feeds_data;
            aVar.f50456c = pushUpdateFeeds.extendinfo;
            aVar.f50457d = pushUpdateFeeds.cell_checksum;
            aVar.f50459f = pushUpdateFeeds.feeds_update_time;
            ArrayList arrayList = new ArrayList();
            aVar.f50458e = arrayList;
            CommentReplyInfo commentReplyInfo = pushUpdateFeeds.commmet_reply_info;
            if (commentReplyInfo != null) {
                arrayList.add(commentReplyInfo);
            }
            return aVar;
        }
    }
}
