package com.tencent.mobileqq.qqlive.data;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class QQLiveEndPageInfo {
    static IPatchRedirector $redirector_;
    public long anchorUid;
    public long commentNum;

    @Nullable
    public LiveRoomExtraInfo extraInfo;
    public int follow;
    public String from;
    public long giftValue;
    public String headIcon;
    public String liveContent;
    public String liveSource;
    public int liveType;
    public long newFans;
    public String nick;
    public String popularity;
    public long praiseNum;
    public String programId;
    public ArrayList<QQLiveEndRecommendInfo> recommendInfos;
    public long roomId;
    public long sendGiftPopularity;
    public long time;
    public long uid;

    public QQLiveEndPageInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.roomId = 0L;
        this.programId = "";
        this.liveType = 0;
        this.liveContent = "";
        this.liveSource = "";
        this.uid = 0L;
        this.anchorUid = 0L;
        this.headIcon = "";
        this.nick = "";
        this.time = 0L;
        this.popularity = "";
        this.follow = 0;
        this.giftValue = 0L;
        this.newFans = 0L;
        this.commentNum = 0L;
        this.sendGiftPopularity = 0L;
        this.praiseNum = 0L;
        this.recommendInfos = new ArrayList<>();
    }
}
