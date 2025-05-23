package com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private C0885a f86652a = new C0885a();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<String> f86653b = new ArrayList<>();

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0885a {

        /* renamed from: a, reason: collision with root package name */
        public int f86654a;

        /* renamed from: b, reason: collision with root package name */
        public int f86655b;

        /* renamed from: c, reason: collision with root package name */
        public int f86656c;

        public String toString() {
            return "WasteInfo{fetchSize=" + this.f86654a + ", totalReq=" + this.f86655b + ", consumeSize=" + this.f86656c + '}';
        }
    }

    public void a() {
        RFWLog.d("FeedLine_QFSFeedWasteWrapper", RFWLog.USR, "[destroy]");
    }

    public C0885a b() {
        return this.f86652a;
    }

    public void c(e30.b bVar) {
        if (bVar != null && bVar.g() != null) {
            String str = bVar.g().f398449id.get();
            if (!TextUtils.isEmpty(str) && !str.startsWith("share_fake_")) {
                String d16 = ba.d(bVar.g());
                if (TextUtils.isEmpty(d16)) {
                    return;
                }
                String str2 = str + "_" + d16;
                if (this.f86653b.contains(str2)) {
                    return;
                }
                this.f86653b.add(str2);
                C0885a c0885a = this.f86652a;
                if (c0885a != null) {
                    c0885a.f86656c++;
                }
                RFWLog.d("FeedLine_QFSFeedWasteWrapper", RFWLog.USR, "[onNewFeedExpose]");
            }
        }
    }

    public void d(List list) {
        if (list != null && !list.isEmpty()) {
            C0885a c0885a = this.f86652a;
            if (c0885a != null) {
                c0885a.f86654a += list.size();
                c0885a.f86655b++;
            }
            RFWLog.d("FeedLine_QFSFeedWasteWrapper", RFWLog.USR, "[recordFetchNewFeed] size:" + list.size());
        }
    }

    public void e() {
        this.f86652a = new C0885a();
    }
}
