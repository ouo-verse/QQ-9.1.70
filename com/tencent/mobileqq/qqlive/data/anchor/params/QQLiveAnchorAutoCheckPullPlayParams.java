package com.tencent.mobileqq.qqlive.data.anchor.params;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;

/* loaded from: classes17.dex */
public class QQLiveAnchorAutoCheckPullPlayParams {
    static IPatchRedirector $redirector_ = null;
    private static final boolean AUTO_CHECK_PULL_PLAY = false;
    private static final int PLAYER_RETRY_COUNT = 150;
    private static final long PLAYER_RETRY_INTERVAL = 2000;
    public boolean autoCheckPullPlay;
    public EnterRoomInfo.VideoDefinition definition;
    public boolean isMute;
    public int playerRetryCount;
    public long playerRetryInterval;
    public int sceneID;

    public QQLiveAnchorAutoCheckPullPlayParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.definition = EnterRoomInfo.VideoDefinition.ORIGIN;
        this.autoCheckPullPlay = false;
        this.playerRetryCount = 150;
        this.playerRetryInterval = 2000L;
        this.isMute = false;
        this.sceneID = 130;
    }
}
