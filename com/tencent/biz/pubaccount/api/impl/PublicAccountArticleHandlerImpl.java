package com.tencent.biz.pubaccount.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import tencent.im.oidb.ac.ArticleComment$ArticleLikeRequest;
import tencent.im.oidb.ac.ArticleComment$ArticleLikeRespond;
import tencent.im.oidb.ac.ArticleComment$CheckArticleLikeRequest;
import tencent.im.oidb.ac.ArticleComment$CheckArticleLikeRespond;
import tencent.im.oidb.ac.ArticleComment$CreateArticleCommentRequest;
import tencent.im.oidb.ac.ArticleComment$CreateArticleCommentRespond;
import tencent.im.oidb.ac.ArticleComment$GetArticleCommentCountRequest;
import tencent.im.oidb.ac.ArticleComment$GetArticleCommentCountRespond;
import tencent.im.oidb.ac.ArticleComment$GetArticleLikeCountRequest;
import tencent.im.oidb.ac.ArticleComment$GetArticleLikeCountRespond;
import tencent.im.oidb.ac.ArticleComment$GetPhotoCollectionInfoRequest;
import tencent.im.oidb.ac.ArticleComment$GetPhotoCollectionInfoResponse;
import tencent.im.oidb.ac.ArticleComment$GetRecommendInfoRequest;
import tencent.im.oidb.ac.ArticleComment$GetRecommendInfoResponse;
import tencent.im.oidb.ac.ArticleComment$RecommendInfo;
import tencent.im.oidb.ac.ArticleComment$ReportGalleryInfoRequest;
import tencent.im.oidb.ac.ArticleComment$ReportGalleryInfoResponse;
import tencent.im.oidb.cmd0x6a6.oidb_0x6a6$ReqBody;
import tencent.im.oidb.cmd0x6a6.oidb_0x6a6$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* loaded from: classes32.dex */
public class PublicAccountArticleHandlerImpl extends BusinessHandler implements IPublicAccountArticleHandler {
    public static final String TAG = "Q.pubaccount.video.PublicAccountArticleHandler";
    public String IMAGE_COLLECTION_ARTICLE_ID;
    protected Set<String> allowCmdSet;
    private final long mTimeOut;
    IPublicAccountArticleObserver publicAccountArticleObserver;

    public PublicAccountArticleHandlerImpl(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.mTimeOut = 30000L;
        this.IMAGE_COLLECTION_ARTICLE_ID = "image_collection_article_id";
    }

    private void handleArticleReadCount(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean isSuccess = fromServiceMsg.isSuccess();
        int i3 = 0;
        boolean z16 = isSuccess && obj != null;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleArticleReadCount:" + z16);
        }
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                oidb_0x6a6$RspBody oidb_0x6a6_rspbody = new oidb_0x6a6$RspBody();
                oidb_0x6a6_rspbody.mergeFrom(byteArray);
                if (oidb_0x6a6_rspbody.uint32_ret_code.has() && oidb_0x6a6_rspbody.uint32_ret_code.get() == 0) {
                    if (oidb_0x6a6_rspbody.uint32_read_count.has()) {
                        i3 = oidb_0x6a6_rspbody.uint32_read_count.get();
                    } else if (oidb_0x6a6_rspbody.uint64_read_count.has()) {
                        i3 = (int) oidb_0x6a6_rspbody.uint64_read_count.get();
                    } else if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "handleArticleReadCount \u83b7\u53d6\u5931\u8d25, read_count \u4e3a\u7a7a");
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "handleArticleReadCount \u83b7\u53d6\u5931\u8d25, ret_code \u4e3a\u7a7a\u6216 ret_code == 1");
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "handleArticleReadCount, ERROR e=" + e16.getMessage());
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "handleArticleReadCount, \u8fd4\u56de\u76f4\u63a5\u51fa\u9519\u4e86");
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleArticleReadCount playCount :" + i3);
        }
        IPublicAccountArticleObserver iPublicAccountArticleObserver = this.publicAccountArticleObserver;
        if (iPublicAccountArticleObserver != null) {
            iPublicAccountArticleObserver.onGetArticleReadCount(z16, i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleCheckIsArticleLiked(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPublicAccountArticleObserver iPublicAccountArticleObserver;
        Bundle bundle = new Bundle();
        boolean z17 = false;
        String str = "";
        if (fromServiceMsg.isSuccess()) {
            ArticleComment$CheckArticleLikeRequest articleComment$CheckArticleLikeRequest = new ArticleComment$CheckArticleLikeRequest();
            ArticleComment$CheckArticleLikeRespond articleComment$CheckArticleLikeRespond = new ArticleComment$CheckArticleLikeRespond();
            try {
                articleComment$CheckArticleLikeRequest.mergeFrom(toServiceMsg.getWupBuffer(), 4, toServiceMsg.getWupBuffer().length - 4);
                articleComment$CheckArticleLikeRespond.mergeFrom((byte[]) obj);
                if (articleComment$CheckArticleLikeRespond.ret.has()) {
                    if (articleComment$CheckArticleLikeRespond.ret.ret_code.has() && articleComment$CheckArticleLikeRespond.ret.ret_code.get() == 0) {
                        if (articleComment$CheckArticleLikeRequest.article_id.has()) {
                            str = articleComment$CheckArticleLikeRequest.article_id.get().toStringUtf8();
                            bundle.putString(IPublicAccountArticleHandler.VALUE_ARTICLE_ID, str);
                        }
                        if (articleComment$CheckArticleLikeRespond.data.has() && articleComment$CheckArticleLikeRespond.data.size() > 0 && articleComment$CheckArticleLikeRespond.data.get(0).like.has()) {
                            if (articleComment$CheckArticleLikeRespond.data.get(0).like.get() == 0) {
                                bundle.putBoolean(IPublicAccountArticleHandler.VALUE_ARTICLE_IS_LIKED, false);
                            } else {
                                bundle.putBoolean(IPublicAccountArticleHandler.VALUE_ARTICLE_IS_LIKED, true);
                                z16 = true;
                                z17 = true;
                                iPublicAccountArticleObserver = this.publicAccountArticleObserver;
                                if (iPublicAccountArticleObserver != null) {
                                    iPublicAccountArticleObserver.onCheckIsArticleLiked(z17, str, z16);
                                    return;
                                } else {
                                    super.notifyUI(1, z17, bundle);
                                    return;
                                }
                            }
                        }
                    }
                }
                z16 = false;
                z17 = true;
                iPublicAccountArticleObserver = this.publicAccountArticleObserver;
                if (iPublicAccountArticleObserver != null) {
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "handleCheckIsArticleLiked() ERROR e=" + e16.getMessage());
                    return;
                }
                return;
            }
        }
        z16 = false;
        iPublicAccountArticleObserver = this.publicAccountArticleObserver;
        if (iPublicAccountArticleObserver != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleCreateArticleCommentReq(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        IPublicAccountArticleObserver iPublicAccountArticleObserver;
        boolean isSuccess = fromServiceMsg.isSuccess();
        boolean z16 = false;
        if (isSuccess) {
            ArticleComment$CreateArticleCommentRespond articleComment$CreateArticleCommentRespond = new ArticleComment$CreateArticleCommentRespond();
            try {
                articleComment$CreateArticleCommentRespond.mergeFrom((byte[]) obj);
                if (articleComment$CreateArticleCommentRespond.ret.has() && articleComment$CreateArticleCommentRespond.ret.ret_code.has()) {
                    i3 = articleComment$CreateArticleCommentRespond.ret.ret_code.get();
                    if (i3 == 0) {
                        z16 = true;
                    }
                    iPublicAccountArticleObserver = this.publicAccountArticleObserver;
                    if (iPublicAccountArticleObserver == null) {
                        iPublicAccountArticleObserver.onCreateArticleCommentRespond(z16, i3);
                        return;
                    }
                    return;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "handleCreateArticleCommentReq() ERROR e=" + e16.getMessage());
                    return;
                }
                return;
            }
        }
        i3 = -1;
        iPublicAccountArticleObserver = this.publicAccountArticleObserver;
        if (iPublicAccountArticleObserver == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleGetArticleCommentCountReq(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        IPublicAccountArticleObserver iPublicAccountArticleObserver;
        boolean isSuccess = fromServiceMsg.isSuccess();
        boolean z16 = false;
        if (isSuccess) {
            ArticleComment$GetArticleCommentCountRespond articleComment$GetArticleCommentCountRespond = new ArticleComment$GetArticleCommentCountRespond();
            try {
                articleComment$GetArticleCommentCountRespond.mergeFrom((byte[]) obj);
                if (articleComment$GetArticleCommentCountRespond.ret.has()) {
                    boolean z17 = !articleComment$GetArticleCommentCountRespond.ret.ret_code.has() || articleComment$GetArticleCommentCountRespond.ret.ret_code.get() == 0;
                    i3 = articleComment$GetArticleCommentCountRespond.count.has() ? articleComment$GetArticleCommentCountRespond.count.get() : 0;
                    z16 = z17;
                    iPublicAccountArticleObserver = this.publicAccountArticleObserver;
                    if (iPublicAccountArticleObserver == null) {
                        iPublicAccountArticleObserver.onGetArticleCommentCountRespond(z16, i3);
                        return;
                    }
                    return;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "handleGetArticleCommentCountReq() ERROR e=" + e16.getMessage());
                    return;
                }
                return;
            }
        }
        i3 = 0;
        iPublicAccountArticleObserver = this.publicAccountArticleObserver;
        if (iPublicAccountArticleObserver == null) {
        }
    }

    private void handleGetPhotoCollectionInfoReq(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        IPublicAccountImageCollectionUtils.a aVar = new IPublicAccountImageCollectionUtils.a();
        boolean z16 = false;
        z16 = false;
        if (fromServiceMsg.isSuccess()) {
            ArticleComment$GetPhotoCollectionInfoResponse articleComment$GetPhotoCollectionInfoResponse = new ArticleComment$GetPhotoCollectionInfoResponse();
            try {
                articleComment$GetPhotoCollectionInfoResponse.mergeFrom((byte[]) obj);
                str = (String) toServiceMsg.extraData.get(this.IMAGE_COLLECTION_ARTICLE_ID);
                aVar.f79733a = str;
                if (articleComment$GetPhotoCollectionInfoResponse.ret.has()) {
                    boolean z17 = !articleComment$GetPhotoCollectionInfoResponse.ret.ret_code.has() || articleComment$GetPhotoCollectionInfoResponse.ret.ret_code.get() == 0;
                    if (articleComment$GetPhotoCollectionInfoResponse.article_share_url.has()) {
                        aVar.f79734b = articleComment$GetPhotoCollectionInfoResponse.article_share_url.get().toStringUtf8();
                    }
                    if (articleComment$GetPhotoCollectionInfoResponse.puin.has()) {
                        aVar.f79735c = articleComment$GetPhotoCollectionInfoResponse.puin.get() + "";
                    }
                    if (articleComment$GetPhotoCollectionInfoResponse.article_img_url.has()) {
                        aVar.f79736d = articleComment$GetPhotoCollectionInfoResponse.article_img_url.get().toStringUtf8();
                    }
                    if (articleComment$GetPhotoCollectionInfoResponse.article_title.has()) {
                        aVar.f79737e = articleComment$GetPhotoCollectionInfoResponse.article_title.get().toStringUtf8();
                    }
                    if (articleComment$GetPhotoCollectionInfoResponse.enable_comment.has()) {
                        aVar.f79738f = articleComment$GetPhotoCollectionInfoResponse.enable_comment.get();
                    }
                    if (articleComment$GetPhotoCollectionInfoResponse.comment_url.has()) {
                        aVar.f79739g = articleComment$GetPhotoCollectionInfoResponse.comment_url.get().toStringUtf8();
                    }
                    if (articleComment$GetPhotoCollectionInfoResponse.firstItem.has()) {
                        IPublicAccountImageCollectionUtils.b bVar = new IPublicAccountImageCollectionUtils.b();
                        aVar.f79740h = bVar;
                        bVar.f79742a = articleComment$GetPhotoCollectionInfoResponse.firstItem.url.get().toStringUtf8();
                        aVar.f79740h.f79745d = articleComment$GetPhotoCollectionInfoResponse.firstItem.photo_author_name.get().toStringUtf8();
                        aVar.f79740h.f79744c = articleComment$GetPhotoCollectionInfoResponse.firstItem.photo_time.get().toStringUtf8();
                        aVar.f79740h.f79743b = articleComment$GetPhotoCollectionInfoResponse.firstItem.publicaccount_name.get().toStringUtf8();
                    }
                    if (articleComment$GetPhotoCollectionInfoResponse.item.has() && articleComment$GetPhotoCollectionInfoResponse.item.get().size() > 0) {
                        aVar.f79741i = new ArrayList<>();
                        int size = articleComment$GetPhotoCollectionInfoResponse.item.get().size();
                        for (int i3 = 0; i3 < size; i3++) {
                            IPublicAccountImageCollectionUtils.c cVar = new IPublicAccountImageCollectionUtils.c();
                            cVar.f79746a = articleComment$GetPhotoCollectionInfoResponse.item.get(i3).url.get().toStringUtf8();
                            cVar.f79747b = articleComment$GetPhotoCollectionInfoResponse.item.get(i3).content.get().toStringUtf8();
                            cVar.f79748c = articleComment$GetPhotoCollectionInfoResponse.item.get(i3).static_url.get().toStringUtf8();
                            cVar.f79749d = articleComment$GetPhotoCollectionInfoResponse.item.get(i3).width.get();
                            cVar.f79750e = articleComment$GetPhotoCollectionInfoResponse.item.get(i3).height.get();
                            aVar.f79741i.add(cVar);
                        }
                    }
                    z16 = z17;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "handleGetPhotoCollectionInfoReq() ERROR e=" + e16.getMessage());
                    return;
                }
                return;
            }
        } else {
            str = null;
        }
        IPublicAccountArticleObserver iPublicAccountArticleObserver = this.publicAccountArticleObserver;
        if (iPublicAccountArticleObserver != null) {
            iPublicAccountArticleObserver.onGetPhotoCollectionInfoRespond(z16, aVar, (byte[]) obj, str);
        }
    }

    private void handleGetRecommendInfoReq(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        ArrayList<IPublicAccountImageCollectionUtils.d> arrayList = new ArrayList<>();
        boolean z16 = false;
        if (fromServiceMsg.isSuccess()) {
            ArticleComment$GetRecommendInfoResponse articleComment$GetRecommendInfoResponse = new ArticleComment$GetRecommendInfoResponse();
            try {
                articleComment$GetRecommendInfoResponse.mergeFrom((byte[]) obj);
                if (articleComment$GetRecommendInfoResponse.ret.has()) {
                    if (articleComment$GetRecommendInfoResponse.ret.ret_code.has()) {
                        articleComment$GetRecommendInfoResponse.ret.ret_code.get();
                    }
                    if (articleComment$GetRecommendInfoResponse.item.has() && articleComment$GetRecommendInfoResponse.item.get().size() > 0) {
                        int size = articleComment$GetRecommendInfoResponse.item.get().size();
                        for (int i3 = 0; i3 < size; i3++) {
                            IPublicAccountImageCollectionUtils.d dVar = new IPublicAccountImageCollectionUtils.d();
                            dVar.f79755d = articleComment$GetRecommendInfoResponse.item.get(i3).article_id.get().toStringUtf8();
                            dVar.f79754c = articleComment$GetRecommendInfoResponse.item.get(i3).recommend_source.get().toStringUtf8();
                            dVar.f79753b = articleComment$GetRecommendInfoResponse.item.get(i3).title.get().toStringUtf8();
                            dVar.f79752a = articleComment$GetRecommendInfoResponse.item.get(i3).url.get().toStringUtf8();
                            arrayList.add(dVar);
                        }
                    }
                }
                z16 = true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "handleGetRecommendInfoReq ERROR e=" + e16.getMessage());
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "handleGetRecommendInfoReq success, size " + arrayList.size());
        }
        IPublicAccountArticleObserver iPublicAccountArticleObserver = this.publicAccountArticleObserver;
        if (iPublicAccountArticleObserver != null) {
            iPublicAccountArticleObserver.onGetRecommendInfoRespond(z16, arrayList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleQueryArticleLikeCount(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        IPublicAccountArticleObserver iPublicAccountArticleObserver;
        Bundle bundle = new Bundle();
        boolean z16 = false;
        r2 = 0;
        int i16 = 0;
        String str = "";
        if (fromServiceMsg.isSuccess()) {
            ArticleComment$GetArticleLikeCountRequest articleComment$GetArticleLikeCountRequest = new ArticleComment$GetArticleLikeCountRequest();
            ArticleComment$GetArticleLikeCountRespond articleComment$GetArticleLikeCountRespond = new ArticleComment$GetArticleLikeCountRespond();
            try {
                articleComment$GetArticleLikeCountRequest.mergeFrom(toServiceMsg.getWupBuffer(), 4, toServiceMsg.getWupBuffer().length - 4);
                articleComment$GetArticleLikeCountRespond.mergeFrom((byte[]) obj);
                if (articleComment$GetArticleLikeCountRespond.ret.has()) {
                    if (articleComment$GetArticleLikeCountRespond.ret.ret_code.has() && articleComment$GetArticleLikeCountRespond.ret.ret_code.get() == 0) {
                        if (articleComment$GetArticleLikeCountRequest.article_id.has()) {
                            str = articleComment$GetArticleLikeCountRequest.article_id.get().toStringUtf8();
                            bundle.putString(IPublicAccountArticleHandler.VALUE_ARTICLE_ID, str);
                        }
                        if (articleComment$GetArticleLikeCountRespond.count.has()) {
                            i16 = articleComment$GetArticleLikeCountRespond.count.get();
                            bundle.putInt(IPublicAccountArticleHandler.VALUE_ARTICLE_LIKE_COUNT, i16);
                        }
                    }
                }
                i3 = i16;
                z16 = true;
                iPublicAccountArticleObserver = this.publicAccountArticleObserver;
                if (iPublicAccountArticleObserver == null) {
                    iPublicAccountArticleObserver.onQueryArticleLikeCount(z16, str, i3);
                    return;
                } else {
                    super.notifyUI(2, z16, bundle);
                    return;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "handleQueryArticleLikeCount() ERROR e=" + e16.getMessage());
                    return;
                }
                return;
            }
        }
        i3 = 0;
        iPublicAccountArticleObserver = this.publicAccountArticleObserver;
        if (iPublicAccountArticleObserver == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleReportReadPhotoCollectionReq(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPublicAccountArticleObserver iPublicAccountArticleObserver;
        if (fromServiceMsg.isSuccess()) {
            ArticleComment$ReportGalleryInfoResponse articleComment$ReportGalleryInfoResponse = new ArticleComment$ReportGalleryInfoResponse();
            try {
                articleComment$ReportGalleryInfoResponse.mergeFrom((byte[]) obj);
                if (articleComment$ReportGalleryInfoResponse.ret.has() && (!articleComment$ReportGalleryInfoResponse.ret.ret_code.has() || articleComment$ReportGalleryInfoResponse.ret.ret_code.get() == 0)) {
                    z16 = true;
                    iPublicAccountArticleObserver = this.publicAccountArticleObserver;
                    if (iPublicAccountArticleObserver == null) {
                        iPublicAccountArticleObserver.onReportReadPhotoCollectionRespond(z16);
                        return;
                    }
                    return;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "handleReportReadPhotoCollectionReq() ERROR e=" + e16.getMessage());
                    return;
                }
                return;
            }
        }
        z16 = false;
        iPublicAccountArticleObserver = this.publicAccountArticleObserver;
        if (iPublicAccountArticleObserver == null) {
        }
    }

    private void handleSendArticleLikeReq(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        Bundle bundle = new Bundle();
        String str = "";
        if (fromServiceMsg.isSuccess()) {
            ArticleComment$ArticleLikeRequest articleComment$ArticleLikeRequest = new ArticleComment$ArticleLikeRequest();
            ArticleComment$ArticleLikeRespond articleComment$ArticleLikeRespond = new ArticleComment$ArticleLikeRespond();
            try {
                articleComment$ArticleLikeRequest.mergeFrom(toServiceMsg.getWupBuffer(), 4, toServiceMsg.getWupBuffer().length - 4);
                articleComment$ArticleLikeRespond.mergeFrom((byte[]) obj);
                z16 = true;
                if (articleComment$ArticleLikeRespond.ret.has()) {
                    if (articleComment$ArticleLikeRespond.ret.ret_code.has() && articleComment$ArticleLikeRespond.ret.ret_code.get() != 0) {
                        bundle.putBoolean(IPublicAccountArticleHandler.VALUE_ARTICLE_IS_LIKE_SUCCESS, false);
                        z16 = false;
                    } else {
                        bundle.putBoolean(IPublicAccountArticleHandler.VALUE_ARTICLE_IS_LIKE_SUCCESS, true);
                    }
                    if (articleComment$ArticleLikeRequest.article_id.has()) {
                        str = articleComment$ArticleLikeRequest.article_id.get().toStringUtf8();
                        bundle.putString(IPublicAccountArticleHandler.VALUE_ARTICLE_ID, str);
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "handleSendArticleLikeReq() ERROR e=" + e16.getMessage());
                    return;
                }
                return;
            }
        } else {
            z16 = false;
        }
        IPublicAccountArticleObserver iPublicAccountArticleObserver = this.publicAccountArticleObserver;
        if (iPublicAccountArticleObserver != null) {
            iPublicAccountArticleObserver.onSendArticleLikeReq(z16, str);
        } else {
            super.notifyUI(0, z16, bundle);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler
    public void checkIsArticleLiked(String str) {
        ArticleComment$CheckArticleLikeRequest articleComment$CheckArticleLikeRequest = new ArticleComment$CheckArticleLikeRequest();
        articleComment$CheckArticleLikeRequest.article_id.set(ByteStringMicro.copyFromUtf8(str));
        articleComment$CheckArticleLikeRequest.uins.add(Long.valueOf(getCurrentAccountUin()));
        ToServiceMsg createToServiceMsg = createToServiceMsg(IPublicAccountArticleHandler.CMD_CHECK_ARTICLE_LIKE);
        createToServiceMsg.putWupBuffer(articleComment$CheckArticleLikeRequest.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        super.sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler
    public void createArticleComment(String str, String str2, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "createArticleComment() articleId = " + str);
        }
        String articleId = ((IPublicAccountDetailActivity) QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(str);
        if (TextUtils.isEmpty(articleId)) {
            return;
        }
        ArticleComment$CreateArticleCommentRequest articleComment$CreateArticleCommentRequest = new ArticleComment$CreateArticleCommentRequest();
        articleComment$CreateArticleCommentRequest.article_id.set(ByteStringMicro.copyFromUtf8(articleId));
        articleComment$CreateArticleCommentRequest.comment.set(ByteStringMicro.copyFromUtf8(str2));
        articleComment$CreateArticleCommentRequest.uin.set(Long.valueOf(getCurrentAccountUin()).longValue());
        articleComment$CreateArticleCommentRequest.hide_name.set(i3);
        ToServiceMsg createToServiceMsg = createToServiceMsg(IPublicAccountArticleHandler.CMD_CREATE_ARTICLE_COMMENT);
        createToServiceMsg.putWupBuffer(articleComment$CreateArticleCommentRequest.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        super.sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler
    public void getArticleCommentCount(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String articleId = ((IPublicAccountDetailActivity) QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(str);
        if (TextUtils.isEmpty(articleId)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getArticleCommentCount() articleId = " + articleId);
        }
        ArticleComment$GetArticleCommentCountRequest articleComment$GetArticleCommentCountRequest = new ArticleComment$GetArticleCommentCountRequest();
        articleComment$GetArticleCommentCountRequest.article_id.set(ByteStringMicro.copyFromUtf8(articleId));
        ToServiceMsg createToServiceMsg = createToServiceMsg(IPublicAccountArticleHandler.CMD_GET_ARTICLE_COMMENT_COUNT);
        createToServiceMsg.putWupBuffer(articleComment$GetArticleCommentCountRequest.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        super.sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(IPublicAccountArticleHandler.CMD_ARTICLE_LIKE);
            this.allowCmdSet.add(IPublicAccountArticleHandler.CMD_CHECK_ARTICLE_LIKE);
            this.allowCmdSet.add(IPublicAccountArticleHandler.CMD_GET_ARTICLE_LIKE_COUNT);
            this.allowCmdSet.add(IPublicAccountArticleHandler.CMD_CREATE_ARTICLE_COMMENT);
            this.allowCmdSet.add(IPublicAccountArticleHandler.CMD_GET_ARTICLE_COMMENT_COUNT);
            this.allowCmdSet.add(IPublicAccountArticleHandler.CMD_GET_PHOTO_COLLECTION_INFO);
            this.allowCmdSet.add(IPublicAccountArticleHandler.CMD_GET_RECOMMEND_INFO);
            this.allowCmdSet.add(IPublicAccountArticleHandler.CMD_REPORT_READ_PHOTO_COLLECTION);
            this.allowCmdSet.add("OidbSvc.0x6a6");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler
    public void getPhotoCollectionInfo(String str, String str2, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getPhotoCollectionInfo() articleId = " + str);
        }
        ArticleComment$GetPhotoCollectionInfoRequest articleComment$GetPhotoCollectionInfoRequest = new ArticleComment$GetPhotoCollectionInfoRequest();
        articleComment$GetPhotoCollectionInfoRequest.article_id.set(ByteStringMicro.copyFromUtf8(str));
        articleComment$GetPhotoCollectionInfoRequest.cuin.set(Long.valueOf(getCurrentAccountUin()).longValue());
        articleComment$GetPhotoCollectionInfoRequest.versionInfo.set(AppSetting.f99551k + ",3," + AppSetting.f99542b);
        articleComment$GetPhotoCollectionInfoRequest.click_source.set(i16);
        articleComment$GetPhotoCollectionInfoRequest.recommend_position.set(i3);
        articleComment$GetPhotoCollectionInfoRequest.recommend_source.set(str2);
        ToServiceMsg createToServiceMsg = createToServiceMsg(IPublicAccountArticleHandler.CMD_GET_PHOTO_COLLECTION_INFO);
        createToServiceMsg.putWupBuffer(articleComment$GetPhotoCollectionInfoRequest.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        createToServiceMsg.extraData.putString(this.IMAGE_COLLECTION_ARTICLE_ID, str);
        super.sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler
    public void getRecommendInfo(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getRecommendInfo() articleId = " + str);
        }
        String str2 = AppSetting.f99551k + ",3," + AppSetting.f99542b;
        ArticleComment$GetRecommendInfoRequest articleComment$GetRecommendInfoRequest = new ArticleComment$GetRecommendInfoRequest();
        articleComment$GetRecommendInfoRequest.article_id.set(ByteStringMicro.copyFromUtf8(str));
        articleComment$GetRecommendInfoRequest.cuin.set(Long.valueOf(getCurrentAccountUin()).longValue());
        articleComment$GetRecommendInfoRequest.versionInfo.set(str2);
        ToServiceMsg createToServiceMsg = createToServiceMsg(IPublicAccountArticleHandler.CMD_GET_RECOMMEND_INFO);
        createToServiceMsg.putWupBuffer(articleComment$GetRecommendInfoRequest.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        super.sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountArticleObserver.class);
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onReceive() getServiceCmd=" + fromServiceMsg.getServiceCmd());
        }
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            return;
        }
        try {
            if (fromServiceMsg.getServiceCmd().equals(IPublicAccountArticleHandler.CMD_GET_ARTICLE_LIKE_COUNT)) {
                handleQueryArticleLikeCount(toServiceMsg, fromServiceMsg, obj);
            } else if (fromServiceMsg.getServiceCmd().equals(IPublicAccountArticleHandler.CMD_CHECK_ARTICLE_LIKE)) {
                handleCheckIsArticleLiked(toServiceMsg, fromServiceMsg, obj);
            } else if (fromServiceMsg.getServiceCmd().equals(IPublicAccountArticleHandler.CMD_ARTICLE_LIKE)) {
                handleSendArticleLikeReq(toServiceMsg, fromServiceMsg, obj);
            } else if (fromServiceMsg.getServiceCmd().equals(IPublicAccountArticleHandler.CMD_REPORT_READ_PHOTO_COLLECTION)) {
                handleReportReadPhotoCollectionReq(toServiceMsg, fromServiceMsg, obj);
            } else if (fromServiceMsg.getServiceCmd().equals(IPublicAccountArticleHandler.CMD_CREATE_ARTICLE_COMMENT)) {
                handleCreateArticleCommentReq(toServiceMsg, fromServiceMsg, obj);
            } else if (fromServiceMsg.getServiceCmd().equals(IPublicAccountArticleHandler.CMD_GET_ARTICLE_COMMENT_COUNT)) {
                handleGetArticleCommentCountReq(toServiceMsg, fromServiceMsg, obj);
            } else if (fromServiceMsg.getServiceCmd().equals(IPublicAccountArticleHandler.CMD_GET_PHOTO_COLLECTION_INFO)) {
                handleGetPhotoCollectionInfoReq(toServiceMsg, fromServiceMsg, obj);
            } else if (fromServiceMsg.getServiceCmd().equals(IPublicAccountArticleHandler.CMD_GET_RECOMMEND_INFO)) {
                handleGetRecommendInfoReq(toServiceMsg, fromServiceMsg, obj);
            } else if (fromServiceMsg.getServiceCmd().equals("OidbSvc.0x6a6")) {
                handleArticleReadCount(toServiceMsg, fromServiceMsg, obj);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "onReceive ERROR e=" + e16.getMessage() + fromServiceMsg.getServiceCmd());
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler
    public void queryArticleLikeCount(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "queryArticleLikeCount() articleId = " + str);
        }
        ArticleComment$GetArticleLikeCountRequest articleComment$GetArticleLikeCountRequest = new ArticleComment$GetArticleLikeCountRequest();
        articleComment$GetArticleLikeCountRequest.article_id.set(ByteStringMicro.copyFromUtf8(str));
        ToServiceMsg createToServiceMsg = createToServiceMsg(IPublicAccountArticleHandler.CMD_GET_ARTICLE_LIKE_COUNT);
        createToServiceMsg.putWupBuffer(articleComment$GetArticleLikeCountRequest.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        super.sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler
    public void queryArticleReadCount(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "queryArticleReadCount()  articleId" + str);
        }
        oidb_0x6a6$ReqBody oidb_0x6a6_reqbody = new oidb_0x6a6$ReqBody();
        oidb_0x6a6_reqbody.bytes_article_id.set(ByteStringMicro.copyFromUtf8(str));
        oidb_0x6a6_reqbody.uint32_req_type.set(0);
        super.sendPbReq(super.makeOIDBPkg("OidbSvc.0x6a6", FSUploadConst.ERR_LOGIN_STATUS_EMPTY, 0, oidb_0x6a6_reqbody.toByteArray()));
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler
    public void reportReadPhotoCollection(String str, String str2, String str3, int i3, int i16, String str4, int i17, ArrayList<IPublicAccountImageCollectionUtils.d> arrayList) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "reportReadPhotoCollection() articleId = " + str);
        }
        ArticleComment$ReportGalleryInfoRequest articleComment$ReportGalleryInfoRequest = new ArticleComment$ReportGalleryInfoRequest();
        articleComment$ReportGalleryInfoRequest.article_id.set(Integer.valueOf(((IPublicAccountDetailActivity) QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(str3)).intValue());
        articleComment$ReportGalleryInfoRequest.uin.set(Long.valueOf(getCurrentAccountUin()).longValue());
        articleComment$ReportGalleryInfoRequest.puin.set(Long.valueOf(str2).longValue());
        articleComment$ReportGalleryInfoRequest.article_url.set(ByteStringMicro.copyFromUtf8(str3));
        articleComment$ReportGalleryInfoRequest.f435965os.set(ByteStringMicro.copyFromUtf8("Android"));
        articleComment$ReportGalleryInfoRequest.is_qq.set(1);
        articleComment$ReportGalleryInfoRequest.f435964mv.set(ByteStringMicro.copyFromUtf8(AppSetting.f99551k));
        articleComment$ReportGalleryInfoRequest.subv.set(ByteStringMicro.copyFromUtf8(AppSetting.f99542b));
        articleComment$ReportGalleryInfoRequest.network.set(ByteStringMicro.copyFromUtf8(AppConstants.NET_TYPE_NAME[NetworkUtil.getSystemNetwork(this.appRuntime.getApplicationContext())]));
        articleComment$ReportGalleryInfoRequest.rowkey.set(ByteStringMicro.copyFromUtf8(str));
        articleComment$ReportGalleryInfoRequest.f435966ts.set((int) (System.currentTimeMillis() / 1000));
        articleComment$ReportGalleryInfoRequest.site_id.set(i3);
        if (i3 == 2) {
            articleComment$ReportGalleryInfoRequest.recommend_index.set(i16);
            articleComment$ReportGalleryInfoRequest.echo_info.set(ByteStringMicro.copyFromUtf8(str4));
        }
        articleComment$ReportGalleryInfoRequest.browse_time.set(i17);
        if (arrayList != null && arrayList.size() > 0 && i3 == 2) {
            ArticleComment$RecommendInfo articleComment$RecommendInfo = new ArticleComment$RecommendInfo();
            Iterator<IPublicAccountImageCollectionUtils.d> it = arrayList.iterator();
            while (it.hasNext()) {
                IPublicAccountImageCollectionUtils.d next = it.next();
                articleComment$RecommendInfo.rowkey.set(ByteStringMicro.copyFromUtf8(next.f79755d));
                articleComment$RecommendInfo.echo_info.set(ByteStringMicro.copyFromUtf8(next.f79754c));
                articleComment$ReportGalleryInfoRequest.recommend_info.add(articleComment$RecommendInfo);
            }
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(IPublicAccountArticleHandler.CMD_REPORT_READ_PHOTO_COLLECTION);
        createToServiceMsg.putWupBuffer(articleComment$ReportGalleryInfoRequest.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        super.sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler
    public void sendArticleLikeReq(String str, boolean z16, boolean z17) {
        ArticleComment$ArticleLikeRequest articleComment$ArticleLikeRequest = new ArticleComment$ArticleLikeRequest();
        articleComment$ArticleLikeRequest.article_id.set(ByteStringMicro.copyFromUtf8(str));
        articleComment$ArticleLikeRequest.uin.set(Long.valueOf(getCurrentAccountUin()).longValue());
        if (z16) {
            articleComment$ArticleLikeRequest.like.set(1);
        } else {
            articleComment$ArticleLikeRequest.like.set(0);
        }
        if (z17) {
            articleComment$ArticleLikeRequest.pin.set(1);
        } else {
            articleComment$ArticleLikeRequest.pin.set(0);
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(IPublicAccountArticleHandler.CMD_ARTICLE_LIKE);
        createToServiceMsg.putWupBuffer(articleComment$ArticleLikeRequest.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        super.sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler
    public void setPublicAccountArticleObserver(IPublicAccountArticleObserver iPublicAccountArticleObserver) {
        this.publicAccountArticleObserver = iPublicAccountArticleObserver;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler
    public void removePublicAccountArticleObserver() {
        this.publicAccountArticleObserver = null;
    }

    public PublicAccountArticleHandlerImpl(AppInterface appInterface) {
        super(appInterface);
        this.mTimeOut = 30000L;
        this.IMAGE_COLLECTION_ARTICLE_ID = "image_collection_article_id";
    }
}
