package com.tencent.mobileqq.selectmember.util;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qidian.api.IQidianManagerApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class b implements Comparator<Friends> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public int a(Friends friends) {
            int i3;
            int i16;
            int i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) friends)).intValue();
            }
            int a16 = com.tencent.mobileqq.friend.status.b.a(friends.detalStatusFlag, friends.iTermType);
            if (a16 != 6 && a16 != 0) {
                i3 = 65536;
            } else {
                i3 = 131072;
            }
            if (friends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
                i16 = 4096;
            } else if (friends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
                i16 = 8192;
            } else if (friends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
                i16 = 12288;
            } else {
                i16 = 16384;
            }
            if (a16 != 1) {
                if (a16 != 2) {
                    if (a16 != 3 && a16 != 4) {
                        if (a16 != 7) {
                            i17 = ((int) friends.getLastLoginType()) | i16;
                        }
                    } else {
                        i17 = i16 | 1;
                    }
                }
                i17 = i16 | 3;
            } else {
                i17 = i16 | 2;
            }
            return i17 | i3;
        }

        @Override // java.util.Comparator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(Friends friends, Friends friends2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) friends, (Object) friends2)).intValue();
            }
            return a(friends) - a(friends2);
        }

        /* synthetic */ b(C8573a c8573a) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) c8573a);
        }
    }

    public static final int a(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static Friends b(AppInterface appInterface, String str) {
        return ((IFriendDataService) appInterface.getRuntimeService(IFriendDataService.class, "")).getFriend(str, true);
    }

    public static TroopInfo c(AppInterface appInterface, String str) {
        return ((ITroopInfoService) appInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
    }

    public static String d(DiscussionMemberInfo discussionMemberInfo, AppInterface appInterface) {
        String str;
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(discussionMemberInfo.memberUin);
        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, CommonUtils.TAG)) {
            str = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, CommonUtils.TAG).m();
        } else {
            str = discussionMemberInfo.inteRemark;
        }
        if (TextUtils.isEmpty(str)) {
            str = discussionMemberInfo.memberName;
        }
        if (TextUtils.isEmpty(str)) {
            return discussionMemberInfo.memberUin;
        }
        return str;
    }

    public static String e(Context context, DiscussionInfo discussionInfo) {
        String str;
        if (discussionInfo != null) {
            str = discussionInfo.discussionName;
        } else {
            str = "";
        }
        if (str == null || str.length() == 0) {
            return context.getResources().getString(R.string.as8);
        }
        return str;
    }

    public static String f(Friends friends) {
        return friends.getFriendNickWithAlias();
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.trim().substring(0, 1).toUpperCase();
    }

    @Deprecated
    public static List<Friends> h(AppInterface appInterface, String str) {
        try {
            return (ArrayList) ((IFriendDataService) appInterface.getRuntimeService(IFriendDataService.class, "")).getFriendList(Integer.parseInt(str));
        } catch (NumberFormatException e16) {
            QLog.e(CommonUtils.TAG, 1, e16, new Object[0]);
            return new ArrayList();
        }
    }

    public static TroopInfo i(AppInterface appInterface, String str) {
        return ((ITroopInfoService) appInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(str);
    }

    public static boolean j(AppInterface appInterface, String str) {
        return ((IAddFriendServiceApi) appInterface.getRuntimeService(IAddFriendServiceApi.class, "")).hasSendAddFriendReq(str, false);
    }

    public static boolean k(AppInterface appInterface, String str) {
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), CommonUtils.TAG);
    }

    public static boolean l(@NonNull AppInterface appInterface, String str, boolean z16, @Nullable List<String> list) {
        if (!TextUtils.equals(str, appInterface.getCurrentAccountUin()) && !m(appInterface, str) && !bl.a(list, str) && !Utils.G(str) && (!z16 || !n(appInterface, str))) {
            return true;
        }
        return false;
    }

    public static boolean m(AppInterface appInterface, String str) {
        return ((IQidianManagerApi) appInterface.getRuntimeService(IQidianManagerApi.class, "")).isQidianMaster(str);
    }

    public static boolean n(AppInterface appInterface, String str) {
        return ((ITroopRobotService) appInterface.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(str);
    }

    public static void o(List<Friends> list) {
        try {
            Collections.sort(list, new b(null));
        } catch (ArrayIndexOutOfBoundsException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(CommonUtils.TAG, 2, "", e16);
            }
        }
    }
}
