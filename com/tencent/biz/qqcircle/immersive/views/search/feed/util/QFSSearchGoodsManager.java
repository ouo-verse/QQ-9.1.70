package com.tencent.biz.qqcircle.immersive.views.search.feed.util;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchGoodsCardData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudRead$FeedAdInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchGoodsManager {

    /* renamed from: a, reason: collision with root package name */
    private final List<FeedCloudRead$FeedAdInfo> f91123a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, QFSSearchGoodsCardData> f91124b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private Gson f91125c;

    /* renamed from: d, reason: collision with root package name */
    private ParseTask f91126d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class ParseTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f91127d;

        ParseTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (FeedCloudRead$FeedAdInfo feedCloudRead$FeedAdInfo : QFSSearchGoodsManager.this.f91123a) {
                if (!this.f91127d) {
                    QFSSearchGoodsManager.this.i(feedCloudRead$FeedAdInfo.feedID.get());
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends TypeToken<ArrayList<QFSSearchGoodsCardData>> {
        a() {
        }
    }

    @Nullable
    private QFSSearchGoodsCardData d(String str) {
        ArrayList arrayList;
        String e16 = e(str);
        if (e16 == null || (arrayList = (ArrayList) h().fromJson(e16, new a().getType())) == null || arrayList.isEmpty()) {
            return null;
        }
        return (QFSSearchGoodsCardData) arrayList.get(0);
    }

    @Nullable
    private String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("ad");
            if (optJSONObject == null) {
                return null;
            }
            return optJSONObject.optString("ads");
        } catch (JSONException e16) {
            QLog.w("QFSSearchGoodsManager", 1, e16.getMessage(), e16);
            return null;
        }
    }

    private String f(String str) {
        int size = this.f91123a.size();
        for (int i3 = 0; i3 < size; i3++) {
            FeedCloudRead$FeedAdInfo feedCloudRead$FeedAdInfo = this.f91123a.get(i3);
            if (TextUtils.equals(str, feedCloudRead$FeedAdInfo.feedID.get()) && feedCloudRead$FeedAdInfo.f398469ad.has()) {
                QLog.d("QFSSearchGoodsManager", 1, "[getGoodsCardData] hasGoodsCardData, feedId: " + str);
                return new String(feedCloudRead$FeedAdInfo.f398469ad.get().toByteArray());
            }
        }
        return "";
    }

    private Gson h() {
        if (this.f91125c == null) {
            this.f91125c = new Gson();
        }
        return this.f91125c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public QFSSearchGoodsCardData i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        QFSSearchGoodsCardData d16 = d(f(str));
        if (d16 != null) {
            this.f91124b.put(str, d16);
        }
        return d16;
    }

    private void k() {
        ParseTask parseTask = this.f91126d;
        if (parseTask != null) {
            parseTask.f91127d = true;
            RFWThreadManager.getInstance().remove(this.f91126d);
        }
    }

    public void c(Collection<FeedCloudRead$FeedAdInfo> collection) {
        if (collection != null && !collection.isEmpty()) {
            k();
            this.f91123a.addAll(collection);
            this.f91126d = new ParseTask();
            RFWThreadManager.getInstance().execOnAsyncDisplayThread(this.f91126d);
        }
    }

    @Nullable
    public QFSSearchGoodsCardData g(String str) {
        if (this.f91124b.containsKey(str)) {
            return this.f91124b.get(str);
        }
        return i(str);
    }

    public void j() {
        k();
        this.f91123a.clear();
        this.f91124b.clear();
    }
}
