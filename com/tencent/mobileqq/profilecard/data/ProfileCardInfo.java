package com.tencent.mobileqq.profilecard.data;

import android.text.TextUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.troop.QQGuildMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.unifiedname.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes16.dex */
public class ProfileCardInfo {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileCardInfo";
    public AllInOne allInOne;
    private Map<Class<? extends IProfileBusinessInfo>, IProfileBusinessInfo> businessInfoMap;
    public Card card;
    public ContactCard contactCard;
    public long curUseStyleId;
    public long curUseTemplateVersion;
    public ProfileCardTemplate currentTemplate;
    public QQGuildMemberCard guildMemberCard;
    public boolean hasShowedEditBubble;
    public boolean isFromGetProfileCardRequest;
    public boolean isNetRet;
    public boolean isQQGuildCard;
    public boolean isTimeOut;
    public boolean isTroopMemberCard;
    public String[] nameArray;
    public b profileName;
    public int troopGlamourLevel;
    public TroopMemberCard troopMemberCard;
    public String troopRecentSaid;
    public boolean troopShowMoreBtn;
    public String troopUin;

    public ProfileCardInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isFromGetProfileCardRequest = false;
        this.troopUin = "";
        this.troopGlamourLevel = -1;
        this.hasShowedEditBubble = false;
    }

    public <T extends IProfileBusinessInfo> T getBusinessInfo(Class<? extends IProfileBusinessInfo> cls) {
        IProfileBusinessInfo iProfileBusinessInfo;
        Card card;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cls);
        }
        Map<Class<? extends IProfileBusinessInfo>, IProfileBusinessInfo> map = this.businessInfoMap;
        if (map != null) {
            iProfileBusinessInfo = map.get(cls);
        } else {
            iProfileBusinessInfo = null;
        }
        if (iProfileBusinessInfo == null && (card = this.card) != null) {
            iProfileBusinessInfo = card.getBusinessInfo(cls);
        }
        if (iProfileBusinessInfo == null) {
            return null;
        }
        return (T) iProfileBusinessInfo;
    }

    public boolean isForbidByAnyType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        Card card = this.card;
        if (card == null) {
            return false;
        }
        return card.isForbidAccount;
    }

    public boolean isTroopMemberCard() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.isTroopMemberCard || !TextUtils.isEmpty(this.troopUin)) {
            return true;
        }
        AllInOne allInOne = this.allInOne;
        if (allInOne != null) {
            if (!TextUtils.isEmpty(allInOne.troopCode) || !TextUtils.isEmpty(this.allInOne.troopUin)) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void putBusinessInfo(IProfileBusinessInfo iProfileBusinessInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iProfileBusinessInfo);
            return;
        }
        if (this.businessInfoMap == null) {
            this.businessInfoMap = new HashMap();
        }
        this.businessInfoMap.put(iProfileBusinessInfo.getClass(), iProfileBusinessInfo);
    }

    public final void removeBusinessInfo(Class<? extends IProfileBusinessInfo> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cls);
            return;
        }
        Map<Class<? extends IProfileBusinessInfo>, IProfileBusinessInfo> map = this.businessInfoMap;
        if (map == null) {
            return;
        }
        map.remove(cls);
    }
}
