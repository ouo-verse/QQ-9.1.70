package com.tencent.mobileqq.troop.recommend.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RecentRecommendTroopItem extends RecommendTroopItem {
    static IPatchRedirector $redirector_;

    public RecentRecommendTroopItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "RecommendTroopItem{uin=" + this.uin + "|, name=" + this.name + "|, labelStr=" + this.labelStr + "|, labelList=" + this.labelList + "}";
    }
}
