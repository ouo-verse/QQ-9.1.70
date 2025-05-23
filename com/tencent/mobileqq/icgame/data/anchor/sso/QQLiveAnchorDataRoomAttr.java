package com.tencent.mobileqq.icgame.data.anchor.sso;

import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomRichTitle;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveAnchorDataRoomAttr {
    public static final int LIVE_ROOM_TYPE_GAME = 1;
    public static final int LIVE_ROOM_TYPE_NORMAL = 0;
    public static final int LIVE_ROOM_TYPE_THIRDPUSH = 2;
    public static final int TYPE_LABEL_ENTERTAINMENT = 1;
    public static final int TYPE_LABEL_GAME = 2;
    public String city;
    public String defaultRoomName;
    public boolean enableGif;
    public QQLiveAnchorRoomGameInfo gameInfo;
    public boolean isECGoodsLive;
    public boolean isPrivateLive;
    public int liveRoomType;
    public String locationAT;
    public String locationNG;
    public int openTabLevel;
    public String phoneModel;
    public String poster;
    public String poster16v9;
    public String poster3v4;
    public int posterNum;
    public long posterTime;
    public long posterTime16v9;
    public long posterTime3v4;
    public PushType pushType;
    public long roomId;
    public String roomName;
    public QQLiveAnchorDataRoomRichTitle tags;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public enum PushType {
        QLS_CAMERA_CAPTURE_TRTC(0),
        QLS_SCREEN_CAPTURE_TRTC(1),
        QLS_OBS_CAPTURE_RTMP(2);

        public int value;

        PushType(int i3) {
            this.value = i3;
        }

        public static PushType getPushType(int i3) {
            if (i3 == 0) {
                return QLS_CAMERA_CAPTURE_TRTC;
            }
            if (i3 == 1) {
                return QLS_SCREEN_CAPTURE_TRTC;
            }
            return QLS_OBS_CAPTURE_RTMP;
        }
    }

    public QQLiveAnchorDataRoomAttr() {
        this.liveRoomType = 0;
        this.pushType = PushType.QLS_CAMERA_CAPTURE_TRTC;
        this.isPrivateLive = false;
        this.isECGoodsLive = false;
        this.openTabLevel = 0;
    }

    public QQLiveAnchorDataRoomAttr(QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr) {
        this.liveRoomType = 0;
        this.pushType = PushType.QLS_CAMERA_CAPTURE_TRTC;
        this.isPrivateLive = false;
        this.isECGoodsLive = false;
        this.openTabLevel = 0;
        if (qQLiveAnchorDataRoomAttr == null) {
            return;
        }
        this.roomId = qQLiveAnchorDataRoomAttr.roomId;
        this.roomName = qQLiveAnchorDataRoomAttr.roomName;
        this.locationNG = qQLiveAnchorDataRoomAttr.locationNG;
        this.locationAT = qQLiveAnchorDataRoomAttr.locationAT;
        this.city = qQLiveAnchorDataRoomAttr.city;
        this.phoneModel = qQLiveAnchorDataRoomAttr.phoneModel;
        this.enableGif = qQLiveAnchorDataRoomAttr.enableGif;
        this.poster = qQLiveAnchorDataRoomAttr.poster;
        this.posterTime = qQLiveAnchorDataRoomAttr.posterTime;
        this.poster3v4 = qQLiveAnchorDataRoomAttr.poster3v4;
        this.posterTime3v4 = qQLiveAnchorDataRoomAttr.posterTime3v4;
        this.poster16v9 = qQLiveAnchorDataRoomAttr.poster16v9;
        this.posterTime16v9 = qQLiveAnchorDataRoomAttr.posterTime16v9;
        this.defaultRoomName = qQLiveAnchorDataRoomAttr.defaultRoomName;
        this.posterNum = qQLiveAnchorDataRoomAttr.posterNum;
        this.liveRoomType = qQLiveAnchorDataRoomAttr.liveRoomType;
        this.pushType = qQLiveAnchorDataRoomAttr.pushType;
        this.gameInfo = qQLiveAnchorDataRoomAttr.gameInfo;
        this.tags = new QQLiveAnchorDataRoomRichTitle(qQLiveAnchorDataRoomAttr.tags);
        this.isECGoodsLive = qQLiveAnchorDataRoomAttr.isECGoodsLive;
        this.openTabLevel = qQLiveAnchorDataRoomAttr.openTabLevel;
    }
}
