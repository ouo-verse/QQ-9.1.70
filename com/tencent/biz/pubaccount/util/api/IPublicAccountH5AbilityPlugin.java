package com.tencent.biz.pubaccount.util.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;

@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountH5AbilityPlugin extends QRouteApi {
    public static final String COPY_URL = "menuItem:copyUrl";
    public static final String COPY_WATCH_WORD = "menuItem:copyWatchWord";
    public static final String EXPORT_TENCENT_DOCS = "menuItem:exportTencentDocs";
    public static final String EXPOSE_ARTICLE = "menuItem:exposeArticle";
    public static final String FAVORITE = "menuItem:favorite";
    public static final String ISPICORVOICE = "is_pic_or_voice";
    public static final String LOCALID_HEAD = "mqqpa://resourceid/";
    public static final String OPEN_QQ_BROWSER = "menuItem:openWithQQBrowser";
    public static final String OPEN_SYS_BROWSER = "menuItem:openWithSafari";
    public static final String PACKAGE_NAME = "publicAccountNew";
    public static final String PICCALLBACK = "pic_callback";
    public static final String PICISSHOWPRO = "is_showProgress_tips";
    public static final String PICLOCALID = "pic_local_id";
    public static final String PICLOCALPATH = "pic_local_path";
    public static final String PICPUIN = "pic_puin";
    public static final String PICSERVERID = "pic_server_id";
    public static final byte REQ_CODE_AQ_INVITE_FRIEND = 119;
    public static final byte REQ_CODE_COMMENT_EDITOR = 117;
    public static final byte REQ_CODE_DELIVER = 113;
    public static final byte REQ_CODE_DELIVER_QUESTION = 122;
    public static final byte REQ_CODE_DELIVER_TopicPic = 121;
    public static final byte REQ_CODE_DELIVER_UGC = 114;
    public static final byte REQ_CODE_SELECT_AND_UPLOAD_AVATAR = 118;
    public static final byte REQ_CODE_UGC_CAMERA_CAPTURE = 116;
    public static final byte REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM = 115;
    public static final String SCREEN_LONG_SHOT_SHARE = "menuItem:screenLongShotShare";
    public static final String SCREEN_SHOT_SHARE = "menuItem:screenShotShare";
    public static final String SET_FONT = "menuItem:setFont";
    public static final String SHARE_CHANNEL = "menuItem:share:QChannel";
    public static final String SHARE_DIANDIAN = "menuItem:share:diandian";
    public static final String SHARE_KANDIAN = "menuItem:share:kandian";
    public static final String SHARE_QIDIAN = "menuItem:share:qiDian";
    public static final String SHARE_QIYEQQ = "menuItem:share:qiYeQQ";
    public static final String SHARE_QQ = "menuItem:share:qq";
    public static final String SHARE_QZONE = "menuItem:share:QZone";
    public static final String SHARE_SINA_WEIBO = "menuItem:share:sinaWeibo";
    public static final String SHARE_WX_FRIEND = "menuItem:share:appMessage";
    public static final String SHARE_WX_FRIEND_LINE = "menuItem:share:timeline";

    boolean contains(ArrayList<String> arrayList, String str);

    void downloadShortVideoFilterSo();

    WebViewPlugin.b getRuntime();

    String getUserInfoFailStr(String str);

    Object getWebResponse(String str);

    WebViewPlugin getWebViewPlugin();

    boolean hasConfig(String str);

    boolean hasRight(String str, String str2);
}
