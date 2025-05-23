package com.tencent.biz.pubaccount.api;

import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.ArrayList;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountArticleObserver extends QRouteApi {
    BusinessObserver getBusinessObserver();

    void onCheckIsArticleLiked(boolean z16, String str, boolean z17);

    void onCreateArticleCommentRespond(boolean z16, int i3);

    void onGetArticleCommentCountRespond(boolean z16, int i3);

    void onGetArticleReadCount(boolean z16, int i3);

    void onGetPhotoCollectionInfoRespond(IPublicAccountImageCollectionUtils.a aVar);

    void onGetPhotoCollectionInfoRespond(boolean z16, IPublicAccountImageCollectionUtils.a aVar, byte[] bArr, String str);

    void onGetRecommendInfoRespond(boolean z16, ArrayList<IPublicAccountImageCollectionUtils.d> arrayList);

    void onQueryArticleLikeCount(boolean z16, String str, int i3);

    void onReportReadPhotoCollectionRespond(boolean z16);

    void onSendArticleLikeReq(boolean z16, String str);

    void setOnCallback(a aVar);

    /* loaded from: classes4.dex */
    public static abstract class a {
        public abstract void f(boolean z16, IPublicAccountImageCollectionUtils.a aVar, byte[] bArr, String str);

        public void e(IPublicAccountImageCollectionUtils.a aVar) {
        }

        public void i(boolean z16) {
        }

        public void b(boolean z16, int i3) {
        }

        public void c(boolean z16, int i3) {
        }

        public void d(boolean z16, int i3) {
        }

        public void g(boolean z16, ArrayList<IPublicAccountImageCollectionUtils.d> arrayList) {
        }

        public void j(boolean z16, String str) {
        }

        public void a(boolean z16, String str, boolean z17) {
        }

        public void h(boolean z16, String str, int i3) {
        }
    }
}
