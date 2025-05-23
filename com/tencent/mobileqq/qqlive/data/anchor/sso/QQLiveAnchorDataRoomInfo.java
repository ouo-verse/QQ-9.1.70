package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.anchor.room.LabelOriginInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorDataRoomInfo implements BaseRoomInfo {
    static IPatchRedirector $redirector_;
    public int continueLiveStatus;
    public String coverUrl16v9;
    public String coverUrl3v4;
    public QQLiveAnchorRoomGameInfo gameInfo;
    public int giftFlag;

    /* renamed from: id, reason: collision with root package name */
    public long f271212id;
    public boolean isPrivateLive;
    public List<LabelOriginInfo> labelOriginInfos;
    public int liveRoomType;
    public String name;
    public String poster;
    public String programId;
    public QQLiveAnchorDataRoomAttr.PushType pushType;
    public int roomGameType;
    public byte[] roomPrepareNotify;
    public String systemNotice;
    public QQLiveAnchorDataRoomRichTitle tags;

    public QQLiveAnchorDataRoomInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.tags = new QQLiveAnchorDataRoomRichTitle();
        this.pushType = QQLiveAnchorDataRoomAttr.PushType.QLS_CAMERA_CAPTURE_TRTC;
        this.isPrivateLive = false;
    }

    @Override // com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo
    public String getProgramId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.programId;
    }

    @Override // com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo
    public long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.f271212id;
    }

    public QQLiveAnchorDataRoomInfo(QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataRoomInfo);
            return;
        }
        this.tags = new QQLiveAnchorDataRoomRichTitle();
        this.pushType = QQLiveAnchorDataRoomAttr.PushType.QLS_CAMERA_CAPTURE_TRTC;
        this.isPrivateLive = false;
        if (qQLiveAnchorDataRoomInfo == null) {
            return;
        }
        this.f271212id = qQLiveAnchorDataRoomInfo.f271212id;
        this.name = qQLiveAnchorDataRoomInfo.name;
        this.poster = qQLiveAnchorDataRoomInfo.poster;
        this.programId = qQLiveAnchorDataRoomInfo.programId;
        this.giftFlag = qQLiveAnchorDataRoomInfo.giftFlag;
        this.tags = new QQLiveAnchorDataRoomRichTitle(qQLiveAnchorDataRoomInfo.tags);
        this.coverUrl16v9 = qQLiveAnchorDataRoomInfo.coverUrl16v9;
        this.coverUrl3v4 = qQLiveAnchorDataRoomInfo.coverUrl3v4;
        byte[] bArr = qQLiveAnchorDataRoomInfo.roomPrepareNotify;
        if (bArr != null) {
            this.roomPrepareNotify = Arrays.copyOf(bArr, bArr.length);
        }
        this.roomGameType = qQLiveAnchorDataRoomInfo.roomGameType;
        this.systemNotice = qQLiveAnchorDataRoomInfo.systemNotice;
        this.continueLiveStatus = qQLiveAnchorDataRoomInfo.continueLiveStatus;
        this.liveRoomType = qQLiveAnchorDataRoomInfo.liveRoomType;
        this.pushType = qQLiveAnchorDataRoomInfo.pushType;
        this.gameInfo = qQLiveAnchorDataRoomInfo.gameInfo;
        this.isPrivateLive = qQLiveAnchorDataRoomInfo.isPrivateLive;
        this.labelOriginInfos = qQLiveAnchorDataRoomInfo.labelOriginInfos;
    }
}
