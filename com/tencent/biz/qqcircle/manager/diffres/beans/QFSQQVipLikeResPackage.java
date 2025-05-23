package com.tencent.biz.qqcircle.manager.diffres.beans;

import com.tencent.biz.qqcircle.manager.diffres.QCircleActionType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import uq3.c;
import uq3.o;

/* loaded from: classes4.dex */
public class QFSQQVipLikeResPackage extends QCircleBaseWnsConfigResPackage {
    public static final String QQ_VIP_COMMENT_HOT_COMMENT_LOTTIE = "qvideo_comment_like_hotcomment_svip.json";
    public static final String QQ_VIP_COMMENT_HOT_COMMENT_PNG = "qvideo_icon_general_thumb_solid_hotcomment_svip.png";
    public static final String QQ_VIP_COMMENT_LIKE_LOTTIE = "qvideo_comment_like_svip.json";
    public static final String QQ_VIP_COMMENT_LIKE_PNG = "qvideo_icon_general_thumb_solid_color_svip.png";
    public static final String QQ_VIP_FEED_CANCEL_LIKE_PAG = "icon_animation_interact_cancellike_svip.pag";
    public static final String QQ_VIP_FEED_LIKE_DOUBLE_SCREEN_PNG = "icon_interact_like_svip_doublescreen.png";
    public static final String QQ_VIP_FEED_LIKE_NORMAL_PNG = "icon_interact_like_svip_normal.png";
    public static final String QQ_VIP_FEED_LIKE_PAG = "icon_animation_interact_like_svip.pag";
    public static final String QQ_VIP_FEED_LIKE_SELECTED_PNG = "icon_interact_like_svipl_selected.png";
    public String mCommentQQVipLikeResUrl;
    public String mFeedQQVipLikeLineResUrl;

    public static QFSQQVipLikeResPackage getDefaultResBean() {
        return new QFSQQVipLikeResPackage();
    }

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseWnsConfigResPackage
    public String getDiffTimeConfigKey() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseWnsConfigResPackage
    public String getMainKey() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseResPackage
    public List<String> getPreloadZipList() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put("feed_svip_like_icon_line", "https://downv6.qq.com/video_story/wezone_url/defaultmode/8953/feed_svip_like_icon/feed_svip_like_icon_line_v6.zip");
        String str = o.M("31306", hashMap).get("feed_svip_like_icon_line");
        this.mFeedQQVipLikeLineResUrl = str;
        arrayList.add(str);
        String g46 = c.g4();
        this.mCommentQQVipLikeResUrl = g46;
        arrayList.add(g46);
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseWnsConfigResPackage
    public String getResConfigKey() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseResPackage
    public List<QCircleActionType> getResRefreshActionTypeList() {
        return new ArrayList();
    }
}
