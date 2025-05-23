package com.tencent.mobileqq.profilecard.api;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process = {"all"})
/* loaded from: classes16.dex */
public interface IProfileDataService extends IRuntimeService {
    ContactCard getContactCardByMobileNo(String str, boolean z16);

    Card getProfileCard(String str, boolean z16);

    Card getProfileCardFromCache(String str);

    boolean saveContactCard(ContactCard contactCard);

    boolean saveProfileCard(Card card);
}
