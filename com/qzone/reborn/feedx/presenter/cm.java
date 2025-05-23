package com.qzone.reborn.feedx.presenter;

import android.app.Activity;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class cm extends vg.a {
    /* JADX INFO: Access modifiers changed from: protected */
    public void H(BusinessFeedData businessFeedData, Activity activity) {
        String str;
        if (ef.b.f(businessFeedData)) {
            ho.i.o().f(activity, businessFeedData);
            return;
        }
        if (ef.b.d(businessFeedData)) {
            ho.i.m().o(activity, businessFeedData);
            return;
        }
        QLog.d("QZoneFeedLikeListPresenter", 1, "jumpToLikeListPage");
        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_LIKELIST_PAGE, QzoneConfig.DefaultValue.DEFAULT_LIKELIST_PAGE_URL);
        if (TextUtils.isEmpty(config) || businessFeedData == null) {
            return;
        }
        if (config.contains("{unikey}") && (str = businessFeedData.getFeedCommInfo().curlikekey) != null) {
            if (str.startsWith("http://") || str.startsWith("https://")) {
                str = URLEncoder.encode(str);
            }
            config = config.replace("{unikey}", str);
        }
        if (config.contains("{uin}")) {
            config = config.replace("{uin}", String.valueOf(LoginData.getInstance().getUin()));
        }
        if (config.contains("{hostuin}")) {
            User user = businessFeedData.getUser();
            if (user != null) {
                config = config.replace("{hostuin}", String.valueOf(user.uin));
            } else {
                config = config.replace("{hostuin}", "0");
            }
        }
        if (config.contains("{appid}")) {
            BusinessFeedData originalInfo = businessFeedData.getOriginalInfo();
            if (originalInfo != null) {
                config = config.replace("{appid}", String.valueOf(originalInfo.getFeedCommInfo().appid));
            } else {
                config = config.replace("{appid}", "");
            }
        }
        yo.d.d(config, activity, null);
    }
}
