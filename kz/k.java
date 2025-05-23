package kz;

import UserGrowth.stUpdateFollowDramaRsp;
import UserGrowth.stUpdateWatchDramaRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.event.WSDramaFollowEvent;
import com.tencent.biz.pubaccount.weishi.event.WSDramaWatchRecordEvent;
import com.tencent.biz.pubaccount.weishi.request.newreq.WSDramaFollowRequest;
import com.tencent.biz.pubaccount.weishi.request.newreq.WSUpdateWatchDramaRequest;
import com.tencent.biz.pubaccount.weishi.util.x;

/* compiled from: P */
/* loaded from: classes38.dex */
public class k {
    public static void a(String str, int i3, kz.a<Integer> aVar) {
        x.i("WSDramaOperationRecordManager", "[followDrama] dramaId:" + str + ", followStatus:" + i3);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new WSDramaFollowRequest(str, i3)).b(new b(str, aVar));
    }

    public static boolean b(String str, String str2, int i3, int i16) {
        x.i("WSDramaOperationRecordManager", "reportDramaWatchRecord() dramaId = " + str + ", feedId = " + str2 + ", episodeNum = " + i3 + ", playSecond = " + i16);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new WSUpdateWatchDramaRequest(str, str2, i3, i16)).b(new a(str, str2, i3));
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a extends com.tencent.biz.pubaccount.weishi.net.common.b<stUpdateWatchDramaRsp, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f413475a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f413476b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f413477c;

        a(String str, String str2, int i3) {
            this.f413475a = str;
            this.f413476b = str2;
            this.f413477c = i3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
            x.i("WSDramaOperationRecordManager", "reportDramaWatchRecord() req failed. errCode = " + jVar.a() + ", errMsg = " + jVar.b());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public String c(com.tencent.biz.pubaccount.weishi.net.common.g<stUpdateWatchDramaRsp> gVar, stUpdateWatchDramaRsp stupdatewatchdramarsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            x.i("WSDramaOperationRecordManager", "reportDramaWatchRecord() req success");
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(String str) {
            wz.b.b().a(new WSDramaWatchRecordEvent(this.f413475a, this.f413476b, this.f413477c));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class b extends com.tencent.biz.pubaccount.weishi.net.common.b<stUpdateFollowDramaRsp, stUpdateFollowDramaRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f413478a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ kz.a f413479b;

        b(String str, kz.a aVar) {
            this.f413478a = str;
            this.f413479b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
            x.i("WSDramaOperationRecordManager", "[followDrama] failureOnUIThread errCode:" + jVar.a() + ", errMsg:" + jVar.b());
            this.f413479b.onFailure(jVar.a(), jVar.b());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(stUpdateFollowDramaRsp stupdatefollowdramarsp) {
            x.i("WSDramaOperationRecordManager", "[followDrama] successOnUIThread status:" + stupdatefollowdramarsp.isFollow);
            wz.b.b().a(new WSDramaFollowEvent(this.f413478a, stupdatefollowdramarsp.isFollow));
            this.f413479b.onSuccess(Integer.valueOf(stupdatefollowdramarsp.isFollow));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public stUpdateFollowDramaRsp c(com.tencent.biz.pubaccount.weishi.net.common.g<stUpdateFollowDramaRsp> gVar, stUpdateFollowDramaRsp stupdatefollowdramarsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            return stupdatefollowdramarsp;
        }
    }
}
