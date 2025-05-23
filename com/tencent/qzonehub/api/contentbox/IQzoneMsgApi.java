package com.tencent.qzonehub.api.contentbox;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneMsgApi extends QRouteApi {
    public static final String ACTION = "action";
    public static final String ACTION_SYNC_QZONE_COMMENT_LIKE = "com.qzone.sync_comment_like";
    public static final int CLICK_TYPE_COMMENT = 2;
    public static final int CLICK_TYPE_DETAIL = 0;
    public static final int CLICK_TYPE_FRIENDFEED = 5;
    public static final int CLICK_TYPE_LIKE = 1;
    public static final int CLICK_TYPE_SHAREQQ = 3;
    public static final int CLICK_TYPE_SHAREQZONE = 4;
    public static final String FEED = "feed";
    public static final String LIKE_KEY = "like_key";
    public static final String SYNC_QZONE_COMMENT_COMMENT_NUM = "sync_comment_commentnum";
    public static final String SYNC_QZONE_COMMENT_HASLIKE = "sync_comment_haslike";
    public static final String SYNC_QZONE_COMMENT_LIKE_KEY = "sync_comment_likekey";
    public static final String SYNC_QZONE_COMMENT_LIKE_NUM = "sync_comment_likenum";

    boolean open(Context context, AppRuntime appRuntime);

    boolean openContentBox(Context context);
}
