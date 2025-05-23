package com.tencent.biz.pubaccount.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountSearchRecommendManager extends QRouteApi {

    /* loaded from: classes4.dex */
    public interface a {
        void a(ArrayList<c> arrayList, String str, boolean z16);
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f79358a;

        /* renamed from: b, reason: collision with root package name */
        public String f79359b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f79360c;

        /* renamed from: d, reason: collision with root package name */
        public long f79361d;

        public b(String str, String str2, long j3, boolean z16) {
            this.f79358a = str;
            this.f79359b = str2;
            this.f79361d = j3;
            this.f79360c = z16;
        }

        public String toString() {
            return "PublicAccountSearchHistoryItem->uin:" + this.f79358a + ", name:" + this.f79359b + ", isPublicAccount:" + this.f79360c + ", time:" + this.f79361d;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f79362a;

        /* renamed from: b, reason: collision with root package name */
        public String f79363b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f79364c;

        public c(String str, String str2, boolean z16) {
            this.f79362a = str;
            this.f79363b = str2;
            this.f79364c = z16;
        }

        public String toString() {
            return "PublicAccountSearchRecommendItem->uin:" + this.f79362a + ", name:" + this.f79363b + ", isPublicAccount:" + this.f79364c;
        }
    }

    void getRecommendList(AppInterface appInterface, boolean z16, a aVar);

    void initFromLocalData(AppInterface appInterface);

    void reset();

    void updatePublicAccountSearchHistoryItem(AppInterface appInterface, String str, String str2, boolean z16);
}
