package com.tencent.timi.game.liveroom.impl.room.share.timishare;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRoute;

/* loaded from: classes26.dex */
public class TgLiveShareParam {
    public String anchorAvatarUrl;
    public String anchorNick;
    public long anchorUid;
    public String flvUrl;
    public String huYaAnchorId;
    public String liveProductType;
    public String platform;
    public String roomCoverUrl;
    public long roomId;
    public String roomTitle;
    public String selfNick;
    public String roomType = "1";
    public String videoSource = "0";
    public String gameId = "1";
    public String gameTagId = "1";
    public String arkJsonFromRemote = "";

    public String getArkJsonForShare() {
        return this.arkJsonFromRemote;
    }

    public String getShareDetailUrl(int i3) {
        return ((ITimiShareHelper) QRoute.api(ITimiShareHelper.class)).getShareDetailUrl(this, i3);
    }

    public Intent getShareQQArkIntent() {
        return ((ITimiShareHelper) QRoute.api(ITimiShareHelper.class)).getShareArkIntent(this);
    }

    public String getShareSingleOnlySummary() {
        ITimiShareHelper iTimiShareHelper = (ITimiShareHelper) QRoute.api(ITimiShareHelper.class);
        String str = this.roomTitle;
        if (str == null) {
            str = "";
        }
        return iTimiShareHelper.getShareSingleTitle(str);
    }

    public String getShareSummary() {
        ITimiShareHelper iTimiShareHelper = (ITimiShareHelper) QRoute.api(ITimiShareHelper.class);
        String str = this.anchorNick;
        if (str == null) {
            str = "";
        }
        return iTimiShareHelper.getShareSummary(str);
    }
}
