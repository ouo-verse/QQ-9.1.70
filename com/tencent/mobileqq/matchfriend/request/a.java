package com.tencent.mobileqq.matchfriend.request;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$GetDefaultTagReq;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$SetMiniUserInfoReq;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$Tag;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$UpdateUserTagsReq;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static Integer[] f245579a = {1, 2, 3, 4, 5, 6, 7, 9, 13, 18, 27, 29};

    public static void a(AppInterface appInterface, int i3) {
        userInfo$GetDefaultTagReq userinfo_getdefaulttagreq = new userInfo$GetDefaultTagReq();
        userinfo_getdefaulttagreq.source_type.set(i3);
        b.a(appInterface, userinfo_getdefaulttagreq.toByteArray(), "QQStranger.UserInfo.SsoGetDefaultTag", 35);
    }

    public static void b(AppInterface appInterface, userInfo$MiniInfo userinfo_miniinfo, String str, List<Integer> list, int i3) {
        if (appInterface != null && !TextUtils.isEmpty(str)) {
            userInfo$SetMiniUserInfoReq userinfo_setminiuserinforeq = new userInfo$SetMiniUserInfoReq();
            userinfo_setminiuserinforeq.open_id.set(str);
            userinfo_setminiuserinforeq.infos.set(userinfo_miniinfo);
            userinfo_setminiuserinforeq.mini_info_ids.addAll(list);
            userinfo_setminiuserinforeq.source_type.set(i3);
            b.a(appInterface, userinfo_setminiuserinforeq.toByteArray(), "QQStranger.UserInfo.SsoSetMiniUserInfo", 25);
            return;
        }
        QLog.e("MatchFriendMiniInfoRequest", 1, "[setMiniInfo] app or openid is null openid is " + str);
    }

    public static void c(AppInterface appInterface, String str, List<userInfo$Tag> list, int i3, int i16) {
        if (appInterface != null && !TextUtils.isEmpty(str)) {
            userInfo$UpdateUserTagsReq userinfo_updateusertagsreq = new userInfo$UpdateUserTagsReq();
            userinfo_updateusertagsreq.open_id.set(str);
            userinfo_updateusertagsreq.tag_owner.set(i3);
            userinfo_updateusertagsreq.source_type.set(i16);
            if (list != null) {
                for (int i17 = 0; i17 < list.size(); i17++) {
                    if (list.get(i17) != null) {
                        userinfo_updateusertagsreq.tag_ids.add(Integer.valueOf(list.get(i17).tag_id.get()));
                    }
                }
            }
            b.a(appInterface, userinfo_updateusertagsreq.toByteArray(), "QQStranger.UserInfo.SsoUpdateUserTags", 26);
            return;
        }
        QLog.e("MatchFriendMiniInfoRequest", 1, "[updateUserTags] app or openid is null openid is " + str);
    }
}
