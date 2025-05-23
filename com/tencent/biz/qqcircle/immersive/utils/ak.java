package com.tencent.biz.qqcircle.immersive.utils;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import o60.a;
import qqcircle.QQCircleDitto$StButton;
import qqcircle.QQCircleDitto$StButtonGroup;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ak implements a.InterfaceC10889a {

    /* renamed from: i, reason: collision with root package name */
    private static volatile ak f90124i;

    /* renamed from: d, reason: collision with root package name */
    private o60.a f90125d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.personal.data.w f90126e;

    /* renamed from: f, reason: collision with root package name */
    private List<Integer> f90127f;

    /* renamed from: h, reason: collision with root package name */
    private QQCircleDitto$StButtonGroup f90128h;

    public static ak a() {
        if (f90124i == null) {
            synchronized (ak.class) {
                if (f90124i == null) {
                    f90124i = new ak();
                }
            }
        }
        return f90124i;
    }

    public QQCircleDitto$StButtonGroup b() {
        return this.f90128h;
    }

    @Override // o60.a.InterfaceC10889a
    public void b1(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (wVar != null && TextUtils.equals(this.f90126e.L(), wVar.L())) {
            this.f90126e = wVar;
            this.f90127f = wVar.d().g();
            if (this.f90126e.d().d() != null) {
                this.f90128h = this.f90126e.d().d().get();
            }
        }
    }

    public boolean c(e30.b bVar) {
        if (bVar == null) {
            QLog.e("QFSMultiGuideBtnUserInfoDataParser", 1, "[hasDoAnimMultiBtnGuideFollowView] mFeedBlockData is null");
            return false;
        }
        Object b16 = bVar.b("follow_view_has_do_animation");
        if (b16 instanceof Boolean) {
            QLog.e("QFSMultiGuideBtnUserInfoDataParser", 1, "[hasDoAnimMultiBtnGuideFollowView] hasDoAnim =" + b16);
            return ((Boolean) b16).booleanValue();
        }
        QLog.e("QFSMultiGuideBtnUserInfoDataParser", 1, "[hasDoAnimMultiBtnGuideFollowView] hasDoAnim return false");
        return false;
    }

    public boolean d(e30.b bVar) {
        if (bVar == null) {
            QLog.e("QFSMultiGuideBtnUserInfoDataParser", 1, "[hasShowedMultiBtnGuideFollowView] mFeedBlockData is null");
            return false;
        }
        Object b16 = bVar.b("follow_view_has_showed");
        if (b16 instanceof Boolean) {
            QLog.e("QFSMultiGuideBtnUserInfoDataParser", 1, "[hasShowedMultiBtnGuideFollowView] hasShowed =" + b16);
            return ((Boolean) b16).booleanValue();
        }
        QLog.e("QFSMultiGuideBtnUserInfoDataParser", 1, "[hasShowedMultiBtnGuideFollowView] hasShowed return false");
        return false;
    }

    public boolean e(e30.b bVar, int i3, QCircleInitBean qCircleInitBean) {
        if ((qCircleInitBean instanceof QCircleLayerBean) && i3 == 20101 && r.c0(this.f90127f) && !d(bVar)) {
            QLog.d("QFSMultiGuideBtnUserInfoDataParser", 1, "[isShowGuideFollowView] personal product tab. multi guide follow btn is show");
            return true;
        }
        if (bVar == null || bVar.g() == null || bVar.g().guideInfos == null || bVar.g().guideInfos.size() < 1 || !(qCircleInitBean instanceof QCircleFolderBean) || bVar.g().guideInfos.get(0).guide_type.get() != 1 || !r.C0(bVar.g().poster)) {
            return false;
        }
        QLog.d("QFSMultiGuideBtnUserInfoDataParser", 1, "[isShowGuideFollowView] folder tab. multi guide follow btn is show");
        return true;
    }

    public boolean f(e30.b bVar) {
        if (bVar == null) {
            QLog.e("QFSMultiGuideBtnUserInfoDataParser", 1, "[resolveMultiGroupBtnData] mFeedBlockData is null");
            return false;
        }
        QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = (QQCircleFeedBase$StFeedBusiReqData) bVar.b("DITTO_FEED_BUSI_REQ_DATA");
        if (qQCircleFeedBase$StFeedBusiReqData != null) {
            QQCircleDitto$StButtonGroup qQCircleDitto$StButtonGroup = qQCircleFeedBase$StFeedBusiReqData.bottomButtons.get();
            List<QQCircleDitto$StButton> arrayList = new ArrayList<>();
            if (qQCircleDitto$StButtonGroup != null) {
                arrayList = qQCircleDitto$StButtonGroup.buttons.get();
            }
            if (arrayList != null && arrayList.size() > 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void g(e30.b bVar) {
        if (bVar == null) {
            QLog.e("QFSMultiGuideBtnUserInfoDataParser", 1, "[updateHasDoAnimMultiBtnGuideFollowView] mFeedBlockData is null");
        } else {
            bVar.o("follow_view_has_do_animation", Boolean.TRUE);
        }
    }

    public void h(e30.b bVar) {
        if (bVar == null) {
            QLog.e("QFSMultiGuideBtnUserInfoDataParser", 1, "[updateHasShowedMultiBtnGuideFollowView] mFeedBlockData is null");
        } else {
            bVar.o("follow_view_has_showed", Boolean.TRUE);
        }
    }

    public void i(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.right != null) {
            String str = feedCloudMeta$StFeed.poster.f398463id.get();
            this.f90126e = new com.tencent.biz.qqcircle.immersive.personal.data.w(str);
            o60.a aVar = new o60.a(this);
            this.f90125d = aVar;
            aVar.b(str);
        }
    }
}
