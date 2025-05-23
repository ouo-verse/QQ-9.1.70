package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import tq4.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorDataRoomAttr {
    static IPatchRedirector $redirector_ = null;
    public static final int LIVE_ROOM_TYPE_GAME = 1;
    public static final int LIVE_ROOM_TYPE_NORMAL = 0;
    public static final int LIVE_ROOM_TYPE_THIRDPUSH = 2;
    public static final int TYPE_LABEL_ENTERTAINMENT = 1;
    public static final int TYPE_LABEL_GAME = 2;
    public a backgroundInfo;
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class PushType {
        private static final /* synthetic */ PushType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final PushType QLS_CAMERA_CAPTURE_TRTC;
        public static final PushType QLS_OBS_CAPTURE_RTMP;
        public static final PushType QLS_SCREEN_CAPTURE_TRTC;
        public int value;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56625);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            PushType pushType = new PushType("QLS_CAMERA_CAPTURE_TRTC", 0, 0);
            QLS_CAMERA_CAPTURE_TRTC = pushType;
            PushType pushType2 = new PushType("QLS_SCREEN_CAPTURE_TRTC", 1, 1);
            QLS_SCREEN_CAPTURE_TRTC = pushType2;
            PushType pushType3 = new PushType("QLS_OBS_CAPTURE_RTMP", 2, 2);
            QLS_OBS_CAPTURE_RTMP = pushType3;
            $VALUES = new PushType[]{pushType, pushType2, pushType3};
        }

        PushType(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
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

        public static PushType valueOf(String str) {
            return (PushType) Enum.valueOf(PushType.class, str);
        }

        public static PushType[] values() {
            return (PushType[]) $VALUES.clone();
        }
    }

    public QQLiveAnchorDataRoomAttr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.liveRoomType = 0;
        this.pushType = PushType.QLS_CAMERA_CAPTURE_TRTC;
        this.isPrivateLive = false;
        this.isECGoodsLive = false;
        this.openTabLevel = 0;
    }

    public QQLiveAnchorDataRoomAttr(QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataRoomAttr);
            return;
        }
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
        this.backgroundInfo = qQLiveAnchorDataRoomAttr.backgroundInfo;
    }
}
