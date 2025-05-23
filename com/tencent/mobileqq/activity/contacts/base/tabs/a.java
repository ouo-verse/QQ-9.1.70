package com.tencent.mobileqq.activity.contacts.base.tabs;

import com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendFragment;
import com.tencent.mobileqq.activity.contacts.friend.FriendFragment;
import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment;
import com.tencent.mobileqq.activity.contacts.troop.TroopFragment;
import com.tencent.mobileqq.contact.IContactExtApi;
import com.tencent.mobileqq.friend.alphabet.api.INTFriendApi;
import com.tencent.mobileqq.guild.IGuildExtApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static ContactsBaseFragment a(int i3) {
        ContactsBaseFragment friendFragment;
        switch (i3) {
            case 1:
                if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).isNewGroupFragment()) {
                    friendFragment = (ContactsBaseFragment) ((INTFriendApi) QRoute.api(INTFriendApi.class)).getGroupFragment();
                    break;
                } else {
                    friendFragment = new FriendFragment();
                    break;
                }
            case 2:
                friendFragment = new TroopFragment();
                break;
            case 3:
                friendFragment = (ContactsBaseFragment) ((INTFriendApi) QRoute.api(INTFriendApi.class)).getDeviceFragment();
                break;
            case 4:
                friendFragment = (ContactsBaseFragment) ((INTFriendApi) QRoute.api(INTFriendApi.class)).getPhoneContactFragment();
                break;
            case 5:
                friendFragment = new PublicAccountFragment();
                break;
            case 6:
                if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).isNewAlphabetFriendFragment()) {
                    friendFragment = (ContactsBaseFragment) ((INTFriendApi) QRoute.api(INTFriendApi.class)).getNtAlphabetFriendFragment();
                    break;
                } else {
                    friendFragment = new AlphabetFriendFragment();
                    break;
                }
            case 7:
                friendFragment = (ContactsBaseFragment) ((IContactExtApi) QRoute.api(IContactExtApi.class)).getRobotContactFragment();
                break;
            case 8:
                friendFragment = (ContactsBaseFragment) ((IGuildExtApi) QRoute.api(IGuildExtApi.class)).getGuildContactFragment();
                break;
            default:
                friendFragment = new FriendFragment();
                break;
        }
        friendFragment.Ch(i3);
        return friendFragment;
    }
}
