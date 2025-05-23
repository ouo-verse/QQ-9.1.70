package com.tencent.mobileqq.icgame.data;

import androidx.annotation.Nullable;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import java.util.ArrayList;

/* loaded from: classes15.dex */
public class QQLiveEndPageInfo {

    @Nullable
    public LiveRoomExtraInfo extraInfo;
    public String from;
    public long roomId = 0;
    public String programId = "";
    public int liveType = 0;
    public String liveContent = "";
    public String liveSource = "";
    public long uid = 0;
    public long anchorUid = 0;
    public String headIcon = "";
    public String nick = "";
    public long time = 0;
    public String popularity = "";
    public int follow = 0;
    public long giftValue = 0;
    public long newFans = 0;
    public long commentNum = 0;
    public long sendGiftPopularity = 0;
    public long praiseNum = 0;
    public ArrayList<QQLiveEndRecommendInfo> recommendInfos = new ArrayList<>();
}
