package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import tencent.im.oidb.cmd0x935.oidb_0x935$Label;

/* compiled from: P */
/* loaded from: classes19.dex */
public class NewRecommendTroopItem extends Entity {
    static IPatchRedirector $redirector_;
    public int group_flag;
    public int group_flag_ext;
    public List<oidb_0x935$Label> labelList;
    public int memberNum;
    public String memo;
    public String name;
    public String owner_uin;
    public String recommendReason;
    oidb_0x935$Label tag_wording;
    public String uin;

    public NewRecommendTroopItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
