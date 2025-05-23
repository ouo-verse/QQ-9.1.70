package com.tencent.mobileqq.qzoneplayer.cover.wrapper;

import android.view.View;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover;
import com.tencent.mobileqq.qzoneplayer.video.PictureUrl;
import com.tencent.mobileqq.qzoneplayer.video.Recycleable;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public interface ICoverWrapper extends Recycleable {
    View getBaseCover();

    View getCover();

    View getParentView();

    int getPicHeight();

    int getPicWidth();

    HashMap<String, Boolean> getPlayOnWifiMap();

    BaseVideoCover.CoverWarnType getWarnType();

    void reportStoreIconToLp(int i3, int i16);

    void reset();

    void setCoverWarnType(BaseVideoCover.CoverWarnType coverWarnType);

    void setJustShowReplyIcon(boolean z16);

    void setLoadFailedText(String str);

    void setMaxWidth(int i3);

    void setOpenFreeTrafficText(String str, String str2);

    void setPicInfo(PictureUrl pictureUrl, String str, VideoPlayInfo videoPlayInfo);

    void setPicInfoOnCoverThread(PictureUrl pictureUrl, String str, VideoPlayInfo videoPlayInfo);

    void setShowOpenFreeTraffic(boolean z16);

    void setShowPlayIcon(boolean z16);
}
