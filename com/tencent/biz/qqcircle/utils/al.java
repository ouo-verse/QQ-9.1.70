package com.tencent.biz.qqcircle.utils;

import android.graphics.drawable.Drawable;
import android.util.Size;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.picload.avatar.AvatarOption;
import com.tencent.biz.qqcircle.picload.avatar.QCircleAvatarLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes5.dex */
public class al {
    public static void a(ImageView imageView, String str, Size size) {
        if (imageView == null) {
            QLog.e("QFSAvatarUtils", 1, "[setAvatarByUin] avatar == null.");
            return;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
        feedCloudMeta$StUser.f398463id.set(str);
        if (!QCirclePluginUtil.isOwner(feedCloudMeta$StUser) && uq3.c.p7()) {
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            if (width == 0 && size != null) {
                width = size.getWidth();
            }
            if (height == 0 && size != null) {
                height = size.getHeight();
            }
            Drawable d16 = com.tencent.biz.qqcircle.immersive.manager.d.c().d(R.drawable.ntp);
            AvatarOption uin = new AvatarOption().setUin(str);
            uin.setTargetView(imageView).setLoadingDrawable(d16).setFailDrawable(d16).setFromPreLoad(false);
            uin.setRequestWidth(width);
            uin.setRequestHeight(height);
            QCircleAvatarLoader.g().loadAvatar(uin);
            return;
        }
        imageView.setImageDrawable(QCirclePluginGlobalInfo.p(str));
        imageView.setTag(HostUIHelper.getInstance().getHostResourceId("id", "qcircle_avatar_tag_id"), str);
    }
}
