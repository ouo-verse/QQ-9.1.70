package com.tencent.mobileqq.gamecenter.data;

import java.io.Serializable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FeedsItemData implements Serializable {
    public String algorithmId;
    public String authorIcon;
    public String authorName;
    public int commentNum;
    public String coverImgUrl;
    public String feedId;
    public List<Object> friendList;
    public int friendNum;
    public int friendType;
    public GameInfo gameInfo;
    public List<Object> giftList;
    public boolean independentPlayer;
    public String jumpUrl;
    public int miniType;
    public String msgId;
    public String title;
    public int type;
    public int videoDuration;
    public String videoSrcImg;
    public String videoSrcName;
    public int videoSrcType;
    public int videoType;
    public String videoUrl;
    public String videoVid;
    public int videoViewers;
    public int viewersNum;
    public String label = "";
    public String rcmdReason = "";
    public String subTitle = "";
    public String operateText = "";
    public String groupId = "";

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class GameInfo implements Serializable {
        public int gamePkgSize;
        public int gameStatus;
        public String gameName = "";
        public String gameIcon = "";
        public String gameApkUrl = "";
        public String gameAppId = "";
        public String gameVersionCode = "";
        public String gamePkgName = "";
        public String gameTicket = "";
    }
}
