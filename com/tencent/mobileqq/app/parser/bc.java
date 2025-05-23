package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.matchfriend.MatchFriendOpenPageAction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bc extends av {
    static IPatchRedirector $redirector_;

    public bc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.av
    public com.tencent.mobileqq.utils.ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.utils.ax) iPatchRedirector.redirect((short) 2, this, baseQQAppInterface, context, str, jumpParserResult);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MatchFriendOpenPageParser", 2, "parse\uff1a" + str);
        }
        MatchFriendOpenPageAction matchFriendOpenPageAction = new MatchFriendOpenPageAction((QQAppInterface) baseQQAppInterface, context);
        matchFriendOpenPageAction.f307438c = str;
        matchFriendOpenPageAction.f307439d = "stranger";
        matchFriendOpenPageAction.f307440e = "user_profile";
        if (str.contains("jump_home_page")) {
            matchFriendOpenPageAction.f307440e = "jump_home_page";
        } else if (str.contains("aio")) {
            matchFriendOpenPageAction.f307440e = "aio";
            matchFriendOpenPageAction.f307458w = false;
        } else if (str.contains("match_home")) {
            matchFriendOpenPageAction.f307440e = "match_home";
        } else if (str.contains("jubao")) {
            matchFriendOpenPageAction.f307440e = "jubao";
        } else if (str.contains("open_age_selector")) {
            matchFriendOpenPageAction.f307440e = "open_age_selector";
        } else if (str.contains("message_notify_setting")) {
            matchFriendOpenPageAction.f307440e = "message_notify_setting";
        } else if (str.contains("jump_liteactionlist_page")) {
            matchFriendOpenPageAction.f307440e = "jump_liteactionlist_page";
        } else if (str.contains("signal_square")) {
            matchFriendOpenPageAction.f307440e = "signal_square";
        } else if (str.contains("publish_feed")) {
            matchFriendOpenPageAction.f307440e = "publish_feed";
        } else if (str.contains("immediate_match")) {
            matchFriendOpenPageAction.f307440e = "immediate_match";
        } else if (str.contains("feed_detail")) {
            matchFriendOpenPageAction.f307440e = "feed_detail";
        } else if (str.contains("feed_info")) {
            matchFriendOpenPageAction.f307440e = "feed_info";
        } else if (str.contains("msg_tab")) {
            matchFriendOpenPageAction.f307440e = "msg_tab";
        } else if (str.contains("notification")) {
            matchFriendOpenPageAction.f307440e = "notification";
        }
        String[] split = str.split("\\?");
        if (split.length != 2) {
            return matchFriendOpenPageAction;
        }
        String[] split2 = split[1].split(ContainerUtils.FIELD_DELIMITER);
        if (split2 != null) {
            for (String str2 : split2) {
                String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split3 != null && split3.length == 2) {
                    matchFriendOpenPageAction.r(split3[0], split3[1]);
                }
            }
        }
        return matchFriendOpenPageAction;
    }
}
