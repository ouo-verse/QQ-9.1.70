package com.tencent.mobileqq.troop.troopgame.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopGameInfo implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "TroopGameInfo";
    public long fightScore;
    public double fightScoreRank;
    public List<GradeDistributedInfo> gradeDistributedList;
    public int mGrade;
    public long mGradeId;
    public long mHeroId;
    public int mHonor;
    public double mWinRate;
    public long weekGPlayGameCount;
    public long weekPlayUserCount;

    public TroopGameInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.gradeDistributedList = new ArrayList();
        }
    }
}
