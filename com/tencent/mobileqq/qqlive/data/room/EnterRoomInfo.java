package com.tencent.mobileqq.qqlive.data.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataTrtcInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class EnterRoomInfo implements BaseRoomInfo {
    static IPatchRedirector $redirector_;
    private String channelId;
    private String deviceId;
    private String extraData;
    private long openLiveType;
    private String programId;
    private long roomId;
    private String source;
    private VideoDefinition targetDefinition;
    private String transData;
    private QQLiveAnchorDataTrtcInfo trtcInfo;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class VideoDefinition {
        private static final /* synthetic */ VideoDefinition[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final VideoDefinition FHD;
        public static final VideoDefinition HD;
        public static final VideoDefinition ORIGIN;
        public static final VideoDefinition SD;
        public static final VideoDefinition SHD;
        public static final VideoDefinition THFD;
        public static final VideoDefinition UNKNOWN;
        public int level;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56710);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            VideoDefinition videoDefinition = new VideoDefinition("UNKNOWN", 0, -1);
            UNKNOWN = videoDefinition;
            VideoDefinition videoDefinition2 = new VideoDefinition("ORIGIN", 1, 0);
            ORIGIN = videoDefinition2;
            VideoDefinition videoDefinition3 = new VideoDefinition("SD", 2, 1);
            SD = videoDefinition3;
            VideoDefinition videoDefinition4 = new VideoDefinition("HD", 3, 2);
            HD = videoDefinition4;
            VideoDefinition videoDefinition5 = new VideoDefinition("SHD", 4, 3);
            SHD = videoDefinition5;
            VideoDefinition videoDefinition6 = new VideoDefinition("FHD", 5, 4);
            FHD = videoDefinition6;
            VideoDefinition videoDefinition7 = new VideoDefinition("THFD", 6, 5);
            THFD = videoDefinition7;
            $VALUES = new VideoDefinition[]{videoDefinition, videoDefinition2, videoDefinition3, videoDefinition4, videoDefinition5, videoDefinition6, videoDefinition7};
        }

        VideoDefinition(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.level = i16;
            }
        }

        public static VideoDefinition parse(int i3) {
            switch (i3) {
                case -1:
                    return UNKNOWN;
                case 0:
                    return ORIGIN;
                case 1:
                    return SD;
                case 2:
                    return HD;
                case 3:
                    return SHD;
                case 4:
                    return FHD;
                case 5:
                    return THFD;
                default:
                    return UNKNOWN;
            }
        }

        public static VideoDefinition valueOf(String str) {
            return (VideoDefinition) Enum.valueOf(VideoDefinition.class, str);
        }

        public static VideoDefinition[] values() {
            return (VideoDefinition[]) $VALUES.clone();
        }
    }

    public EnterRoomInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.roomId = 0L;
        this.source = "";
        this.programId = "";
        this.channelId = "";
        this.deviceId = "";
        this.targetDefinition = VideoDefinition.ORIGIN;
        this.transData = "";
        this.extraData = "";
    }

    public String getChannelId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.channelId;
    }

    public String getDeviceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.deviceId;
    }

    public String getExtraData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.extraData;
    }

    public long getOpenLiveType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return this.openLiveType;
    }

    @Override // com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo
    public String getProgramId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.programId;
    }

    @Override // com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo
    public long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.roomId;
    }

    public String getSource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.source;
    }

    public VideoDefinition getTargetDefinition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (VideoDefinition) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.targetDefinition;
    }

    public String getTransData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.transData;
    }

    public QQLiveAnchorDataTrtcInfo getTrtcInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (QQLiveAnchorDataTrtcInfo) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.trtcInfo;
    }

    public void setChannelId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.channelId = str;
        }
    }

    public void setDeviceId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.deviceId = str;
        }
    }

    public void setExtraData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.extraData = str;
        }
    }

    public void setOpenLiveType(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, j3);
        } else {
            this.openLiveType = j3;
        }
    }

    public void setProgramId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.programId = str;
        }
    }

    public void setRoomId(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            this.roomId = j3;
        }
    }

    public void setSource(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.source = str;
        }
    }

    public void setTargetDefinition(VideoDefinition videoDefinition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) videoDefinition);
        } else {
            this.targetDefinition = videoDefinition;
        }
    }

    public void setTransData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.transData = str;
        }
    }

    public void setTrtcInfo(QQLiveAnchorDataTrtcInfo qQLiveAnchorDataTrtcInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) qQLiveAnchorDataTrtcInfo);
        } else {
            this.trtcInfo = qQLiveAnchorDataTrtcInfo;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return "EnterRoomInfo:[roomId=" + this.roomId + ";source=" + this.source + ";programId=" + this.programId + ";deviceId=" + this.deviceId + "]";
    }
}
