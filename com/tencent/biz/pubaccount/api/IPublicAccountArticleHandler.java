package com.tencent.biz.pubaccount.api;

import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.ArrayList;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountArticleHandler extends QRouteApi {
    public static final String CMD_ARTICLE_LIKE = "PubAccountArticleCenter.ArticleLike";
    public static final String CMD_CHECK_ARTICLE_LIKE = "PubAccountArticleCenter.CheckArticleLike";
    public static final String CMD_CREATE_ARTICLE_COMMENT = "PubAccountArticleCenter.CreateArticleComment";
    public static final String CMD_GET_ARTICLE_COMMENT_COUNT = "PubAccountArticleCenter.GetArticleCommentCount";
    public static final String CMD_GET_ARTICLE_LIKE_COUNT = "PubAccountArticleCenter.GetArticleLikeCount";
    public static final String CMD_GET_PHOTO_COLLECTION_INFO = "PubAccountArticleCenter.PictureInfo";
    public static final String CMD_GET_RECOMMEND_INFO = "PubAccountArticleCenter.GetRecommendInfo";
    public static final String CMD_REPORT_READ_PHOTO_COLLECTION = "PubAccountArticleCenter.GalleryReport";
    public static final int TYPE_ARTICLE_LIKE = 0;
    public static final int TYPE_CHECK_ARTICLE_LIKE = 1;
    public static final int TYPE_CREATE_ARTICLE_COMMENT = 3;
    public static final int TYPE_GET_ARTICLE_COMMENT_COUNT = 4;
    public static final int TYPE_GET_ARTICLE_LIKE_COUNT = 2;
    public static final int TYPE_GET_PHOTO_COLLECTION_INFO = 5;
    public static final int TYPE_GET_RECOMMEND_INFO = 6;
    public static final int TYPE_REPORT_READ_PHOTO_COLLECTION = 7;
    public static final String VALUE_ARTICLE_COMMENT_COUNT = "VALUE_ARTICLE_COMMENT_COUNT";
    public static final String VALUE_ARTICLE_ID = "VALUE_ARTICLE_ID";
    public static final String VALUE_ARTICLE_IMAGEE_IS_SUCCESS = "VALUE_ARTICLE_IMAGEE_IS_SUCCESS";
    public static final String VALUE_ARTICLE_IS_LIKED = "VALUE_ARTICLE_IS_LIKED";
    public static final String VALUE_ARTICLE_IS_LIKE_SUCCESS = "VALUE_ARTICLE_IS_LIKE_SUCCESS";
    public static final String VALUE_ARTICLE_ITEM_COLLECTION_ARTICLE_URLS = "VALUE_ARTICLE_ITEM_COLLECTION_ARTICLE_URLS";
    public static final String VALUE_ARTICLE_ITEM_COLLECTION_CONTENTS = "VALUE_ARTICLE_ITEM_CONTENTS";
    public static final String VALUE_ARTICLE_ITEM_COLLECTION_IMG_URL = "VALUE_ARTICLE_ITEM_COLLECTION_IMG_URL";
    public static final String VALUE_ARTICLE_ITEM_COLLECTION_TITLE = "VALUE_ARTICLE_ITEM_COLLECTION_TITLE";
    public static final String VALUE_ARTICLE_ITEM_COLLECTION_URLS = "VALUE_ARTICLE_ITEM_URLS";
    public static final String VALUE_ARTICLE_ITEM_COMMENT_URL = "VALUE_ARTICLE_ITEM_COMMENT_URL";
    public static final String VALUE_ARTICLE_ITEM_RECOMMEND_CAN = "VALUE_ARTICLE_ITEM_RECOMMEND_CAN";
    public static final String VALUE_ARTICLE_ITEM_RECOMMEND_RECOMMEND_ARTICLE_ID = "VALUE_ARTICLE_ITEM_RECOMMEND_RECOMMEND_ARTICLE_ID";
    public static final String VALUE_ARTICLE_ITEM_RECOMMEND_RECOMMEND_SOURCE = "VALUE_ARTICLE_ITEM_RECOMMEND_RECOMMEND_SOURCE";
    public static final String VALUE_ARTICLE_ITEM_RECOMMEND_TITLES = "VALUE_ARTICLE_ITEM_RECOMMEND_TITLES";
    public static final String VALUE_ARTICLE_ITEM_RECOMMEND_URLS = "VALUE_ARTICLE_ITEM_RECOMMEND_URLS";
    public static final String VALUE_ARTICLE_LIKE_COUNT = "VALUE_ARTICLE_LIKE_COUNT";
    public static final String VALUE_ARTICLE_PUIN = "VALUE_ARTICLE_PUIN";

    void checkIsArticleLiked(String str);

    void createArticleComment(String str, String str2, int i3);

    void getArticleCommentCount(String str);

    void getPhotoCollectionInfo(String str, String str2, int i3, int i16);

    void getRecommendInfo(String str);

    void queryArticleLikeCount(String str);

    void queryArticleReadCount(String str);

    void removePublicAccountArticleObserver();

    void reportReadPhotoCollection(String str, String str2, String str3, int i3, int i16, String str4, int i17, ArrayList<IPublicAccountImageCollectionUtils.d> arrayList);

    void sendArticleLikeReq(String str, boolean z16, boolean z17);

    void setPublicAccountArticleObserver(IPublicAccountArticleObserver iPublicAccountArticleObserver);
}
