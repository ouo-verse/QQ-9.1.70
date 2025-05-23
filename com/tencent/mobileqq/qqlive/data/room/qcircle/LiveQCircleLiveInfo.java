package com.tencent.mobileqq.qqlive.data.room.qcircle;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LiveQCircleLiveInfo {
    public int isEnd;
    public List<LiveInfo> liveInfoList = new ArrayList();
    public String transInfo;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class AnchorInfoData {
        public String anchorIcon;
        public String anchorName;
        public int anchorType;
        public long anchorUid;
        public long anchorUin;
        public String businessUid;
        public String desc;
        public long fansCount;
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class LiveInfo {
        public AnchorInfoData anchorInfoData;
        public RoomInfoData roomInfoData;
        public String schema;
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class RoomInfoData {
        public long beginTimestamp;
        public String coverPic;
        public GameRoomInfo gameRoomInfo;
        public int label;
        public int liveRoomType;
        public String programId;
        public long roomId;
        public int roomState;
        public String roomTitle;
        public String rtmpUrl;
        public int subLabel;
        public long uid;
        public long uin;
        public long videoSource;
        public long viewer;

        /* compiled from: P */
        /* loaded from: classes17.dex */
        public static class GameRoomInfo {
            public long gameId;
            public long secondTagId;
        }
    }
}
