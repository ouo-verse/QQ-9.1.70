package com.tencent.timi.game.liveroom.impl.room.share.timishare;

import android.content.Intent;
import java.io.Serializable;

/* loaded from: classes26.dex */
public class TgShareParam {
    public TgLiveShareParam tgLiveShareParam;
    public String simpleTitle = "";
    public String mainName = "";
    public String originSummary = "";
    public String singleSummaryOnly = "";
    public String coverImgUrl = "";
    public String jumpActionUrl = "";
    public String shareAppName = "";
    public boolean showReport = true;
    public String promotionUrl = "";

    /* loaded from: classes26.dex */
    public static class ShareBody {
        public String desc;
        public String imageUrl;
        public String jumpActionUrl;
        public String title;
    }

    /* loaded from: classes26.dex */
    public static class SharePlatformType implements Serializable {
        public static final int COPYLINK = 4;
        public static final int QQ = 1;
        public static final int QZONE = 0;
        public static final int WECHAT = 3;
        public static final int WECHATMOMENTS = 2;
    }

    public Intent getArkIntentIfExist() {
        TgLiveShareParam tgLiveShareParam = this.tgLiveShareParam;
        if (tgLiveShareParam != null) {
            return tgLiveShareParam.getShareQQArkIntent();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
    
        if (r3 != 3) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ShareBody getShareBody(int i3) {
        ShareBody shareBody = new ShareBody();
        shareBody.imageUrl = this.coverImgUrl;
        TgLiveShareParam tgLiveShareParam = this.tgLiveShareParam;
        if (tgLiveShareParam != null) {
            shareBody.jumpActionUrl = tgLiveShareParam.getShareDetailUrl(i3);
        } else {
            shareBody.jumpActionUrl = this.jumpActionUrl;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    shareBody.title = this.singleSummaryOnly;
                    shareBody.desc = this.mainName;
                }
            } else {
                shareBody.title = this.simpleTitle;
                shareBody.desc = this.mainName;
            }
            return shareBody;
        }
        shareBody.title = this.originSummary;
        shareBody.desc = this.mainName;
        return shareBody;
    }

    public String toString() {
        return "TgShareParam{tgLiveShareParam=" + this.tgLiveShareParam + ", simpleTitle='" + this.simpleTitle + "', mainName='" + this.mainName + "', originSummary='" + this.originSummary + "', singleSummaryOnly='" + this.singleSummaryOnly + "', coverImgUrl='" + this.coverImgUrl + "', jumpActionUrl='" + this.jumpActionUrl + "', shareAppName='" + this.shareAppName + "', showReport=" + this.showReport + '}';
    }
}
