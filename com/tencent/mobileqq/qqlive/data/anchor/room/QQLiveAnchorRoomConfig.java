package com.tencent.mobileqq.qqlive.data.anchor.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.room.PlayerConfig;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorRoomConfig {
    static IPatchRedirector $redirector_;
    public int audioVolumeEvaluation;
    public QQLiveAnchorRoomBizData bizData;
    public boolean cameraMirror;
    public String customVerifyUrl;
    public boolean enableVolumeEvaluation;
    public boolean openAudio;
    public PlayerConfig playerConfig;
    public RoomType roomType;
    public QQLiveAnchorStreamRecordType streamRecordType;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class RoomType {
        private static final /* synthetic */ RoomType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final RoomType LIVE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56606);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            RoomType roomType = new RoomType("LIVE", 0);
            LIVE = roomType;
            $VALUES = new RoomType[]{roomType};
        }

        RoomType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static RoomType valueOf(String str) {
            return (RoomType) Enum.valueOf(RoomType.class, str);
        }

        public static RoomType[] values() {
            return (RoomType[]) $VALUES.clone();
        }
    }

    public QQLiveAnchorRoomConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.playerConfig = new PlayerConfig();
        this.roomType = RoomType.LIVE;
        this.openAudio = true;
        this.cameraMirror = false;
        this.enableVolumeEvaluation = false;
        this.customVerifyUrl = "";
        this.streamRecordType = QQLiveAnchorStreamRecordType.CAMERA;
        this.bizData = new QQLiveAnchorRoomBizData(false);
        this.audioVolumeEvaluation = 200;
    }
}
