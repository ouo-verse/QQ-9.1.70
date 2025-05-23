package com.tencent.biz.qqcircle.immersive.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.share.QFSShareResultKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqforward.api.RecentContactListener;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bp {

    /* renamed from: b, reason: collision with root package name */
    public static final String f90194b = "com.tencent.biz.qqcircle.immersive.utils.bp";

    /* renamed from: c, reason: collision with root package name */
    public static final bp f90195c = new bp(new HostForwardUtils());

    /* renamed from: a, reason: collision with root package name */
    private HostForwardUtils f90196a;

    bp(HostForwardUtils hostForwardUtils) {
        this.f90196a = hostForwardUtils;
    }

    private void a(Intent intent, String str) {
        this.f90196a.registerForwardResultReceiver(intent, QFSShareResultKt.f(0, 0, null));
        this.f90196a.addForwardType(intent, str);
    }

    private Bundle d(String str, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt(QCircleHostConstants._ForwardRecentActivity.KEY_REQ(), QCircleHostConstants._ForwardRecentActivity.REQ_DIRECT_SHOW_DIALOG());
        bundle.putInt(QCircleHostConstants._ForwardRecentActivity.KEY_DIRECT_SHOW_UIN_TYPE(), i3);
        bundle.putString(QCircleHostConstants._ForwardRecentActivity.KEY_DIRECT_SHOW_UIN(), str);
        return bundle;
    }

    public void b(Activity activity, String str, int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!TextUtils.isEmpty(str) && feedCloudMeta$StFeed != null) {
            Intent s16 = QCircleBaseShareOperation.s(activity, feedCloudMeta$StFeed);
            s16.putExtras(d(str, i3));
            a(s16, HostForwardUtils.HOST_FORWARD_DIALOG_RECENTLY_FLAG());
            this.f90196a.startForwardActivityForResult(activity, s16);
            return;
        }
        QLog.e(f90194b, 1, "forward failed, uin:" + str + ",uinType:" + i3);
    }

    public void c(RecentContactListener recentContactListener) {
        this.f90196a.getQQRecentlyFriends(recentContactListener);
    }

    public void e(Activity activity, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Intent s16 = QCircleBaseShareOperation.s(activity, feedCloudMeta$StFeed);
        if (s16 == null) {
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.tx7), 0);
            return;
        }
        a(s16, HostForwardUtils.HOST_FORWARD_RECENTLY_CHAT_FLAG());
        activity.startActivityForResult(s16, QCircleHostConstants._ChatActivityConstants.FORWARD_REQUEST());
        QLog.d(f90194b, 1, "shareToQQ  success");
    }
}
