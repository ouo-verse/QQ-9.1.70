package com.tencent.mobileqq.qqlive.data.anchor.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataMediaInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataTrtcInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.utils.e;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorRoomInfo implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int GAME_ROOM = 2;
    public static final int NORMAL_ROOM = 1;
    public static final int UNKNOW_ROOM = 0;
    public String machieId;
    public QQLiveAnchorDataMediaInfo mediaData;
    public QQLiveAnchorDataRoomAttr roomAttr;
    public QQLiveAnchorDataRoomInfo roomData;
    public String source;
    public QQLiveAnchorDataPullInfo thirdPullInfo;
    public QQLiveAnchorDataPushInfo thirdPushInfo;
    public QQLiveAnchorDataTrtcInfo trtcData;
    public long uid;
    public QQLiveAnchorDataUserInfo userDta;

    public QQLiveAnchorRoomInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.machieId = e.a();
        this.roomAttr = new QQLiveAnchorDataRoomAttr();
        this.roomData = new QQLiveAnchorDataRoomInfo();
        this.userDta = new QQLiveAnchorDataUserInfo();
        this.mediaData = new QQLiveAnchorDataMediaInfo();
        this.trtcData = new QQLiveAnchorDataTrtcInfo();
        this.thirdPushInfo = new QQLiveAnchorDataPushInfo();
        this.thirdPullInfo = new QQLiveAnchorDataPullInfo();
    }

    public QQLiveAnchorRoomInfo(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorRoomInfo);
            return;
        }
        this.machieId = e.a();
        this.roomAttr = new QQLiveAnchorDataRoomAttr();
        this.roomData = new QQLiveAnchorDataRoomInfo();
        this.userDta = new QQLiveAnchorDataUserInfo();
        this.mediaData = new QQLiveAnchorDataMediaInfo();
        this.trtcData = new QQLiveAnchorDataTrtcInfo();
        this.thirdPushInfo = new QQLiveAnchorDataPushInfo();
        this.thirdPullInfo = new QQLiveAnchorDataPullInfo();
        if (qQLiveAnchorRoomInfo == null) {
            return;
        }
        this.uid = qQLiveAnchorRoomInfo.uid;
        this.source = qQLiveAnchorRoomInfo.source;
        this.machieId = qQLiveAnchorRoomInfo.machieId;
        this.roomAttr = new QQLiveAnchorDataRoomAttr(qQLiveAnchorRoomInfo.roomAttr);
        this.roomData = new QQLiveAnchorDataRoomInfo(qQLiveAnchorRoomInfo.roomData);
        this.userDta = new QQLiveAnchorDataUserInfo(qQLiveAnchorRoomInfo.userDta);
        this.mediaData = new QQLiveAnchorDataMediaInfo(qQLiveAnchorRoomInfo.mediaData);
        this.trtcData = new QQLiveAnchorDataTrtcInfo(qQLiveAnchorRoomInfo.trtcData);
        this.thirdPushInfo = new QQLiveAnchorDataPushInfo(qQLiveAnchorRoomInfo.thirdPushInfo);
        this.thirdPullInfo = new QQLiveAnchorDataPullInfo(qQLiveAnchorRoomInfo.thirdPullInfo);
    }
}
