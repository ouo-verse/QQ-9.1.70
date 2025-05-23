package com.tencent.biz.qqcircle.share;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.picload.avatar.AvatarOption;
import com.tencent.biz.qqcircle.picload.avatar.QCircleAvatarLoader;
import com.tencent.biz.qqcircle.picload.avatar.QCircleAvatarUrlListener;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import uq3.q;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g extends QCircleBaseShareOperation {

    /* renamed from: u, reason: collision with root package name */
    private final Bundle f92368u;

    /* renamed from: v, reason: collision with root package name */
    private String f92369v;

    /* renamed from: w, reason: collision with root package name */
    private String f92370w;

    /* renamed from: x, reason: collision with root package name */
    private String f92371x;

    /* renamed from: y, reason: collision with root package name */
    private String f92372y;

    /* renamed from: z, reason: collision with root package name */
    private String f92373z;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements Consumer<String> {
        a() {
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            ((IShareActionHelper) QRoute.api(IShareActionHelper.class)).doShareToQZoneWithPics("QFSSharePart", g.this.f(), arrayList, -1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements QCircleAvatarUrlListener {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.picload.avatar.QCircleAvatarUrlListener
        public void onAvatarUrl(String str) {
            g.this.U(str);
        }
    }

    public g(QCircleBaseShareOperation.a aVar) {
        super(aVar);
        this.f92368u = new Bundle();
    }

    private long M(String str) {
        long j3;
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(t().feed.poster.f398463id.get())) {
            try {
                j3 = Long.parseLong(t().feed.poster.f398463id.get());
            } catch (Exception e16) {
                QLog.d("QFSSharePart", 1, "[shareToQZone] parse poster#id error!", e16.toString());
            }
            if (TextUtils.isEmpty(str) && str.startsWith("avatar://")) {
                try {
                    return Long.parseLong(str.substring(9));
                } catch (Exception e17) {
                    QLog.e("QFSSharePart", 1, "[shareToQZone] parse uin error!", e17.toString());
                    return j3;
                }
            }
        }
        j3 = 0;
        return TextUtils.isEmpty(str) ? j3 : j3;
    }

    private void N() {
        List<FeedCloudCommon$Entry> list = t().feed.share.shareQzoneInfo.entrys.get();
        HashMap hashMap = new HashMap();
        if (list != null && list.size() > 0) {
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
                hashMap.put(feedCloudCommon$Entry.key.get(), feedCloudCommon$Entry.value.get());
            }
            if (t().type == 1) {
                this.f92369v = t().feed.poster.icon.iconUrl.get();
            } else {
                this.f92369v = (String) hashMap.get("COVERURL");
            }
            this.f92370w = (String) hashMap.get("title");
            this.f92371x = (String) hashMap.get("summary");
            this.f92372y = (String) hashMap.get(AlbumCacheData.ACTIONURL);
            this.f92373z = (String) hashMap.get("aio_pure_text");
        }
        this.f92368u.putSerializable(QCircleHostConstants.AppConstants.Key.SHARE_REQ_SHARE_QZONE_INFO(), HostDataTransUtils.wrapSerializableMap(hashMap));
        this.f92368u.putString(QCircleHostConstants.AppConstants.Key.SHARE_REQ_TITLE(), this.f92370w);
        this.f92368u.putString(QCircleHostConstants.AppConstants.Key.SHARE_REQ_DESC(), this.f92371x);
        this.f92368u.putString(QCircleHostConstants.AppConstants.Key.SHARE_REQ_DETAIL_URL(), this.f92372y);
        if (!TextUtils.isEmpty(t().mDirectShowMsg) && TextUtils.isEmpty(this.f92373z)) {
            this.f92373z = t().mDirectShowMsg;
        }
        this.f92368u.putString(QCircleHostConstants.AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT(), this.f92373z);
        this.f92368u.putBoolean("is_need_show_toast", t().isNeedShowShareSuccessToast);
        this.f92368u.putLong(QCircleHostConstants.AppConstants.Key.SHARE_REQ_ID(), 0L);
        this.f92368u.putParcelable("PARAM_ActivityResultReceiver", QFSShareResultKt.e(m(), n(), ua0.d.d(t())));
    }

    private void O() {
        if (!C(57) && !uq3.c.g6()) {
            if (C(32)) {
                R();
                return;
            }
            if (C(31)) {
                T();
                return;
            } else if (A()) {
                S();
                return;
            } else {
                Q();
                return;
            }
        }
        P();
    }

    private void P() {
        H(26, 2, t().extraTypeInfo, "");
    }

    private void Q() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String str;
        int i3;
        if (t().extraTypeInfo != null) {
            feedCloudMeta$StFeed = t().extraTypeInfo.mFeed;
        } else {
            feedCloudMeta$StFeed = null;
        }
        QCircleLpReportDc05501.DataBuilder subActionType = ua0.c.a(feedCloudMeta$StFeed).setActionType(26).setSubActionType(2);
        if (t().extraTypeInfo != null && t().extraTypeInfo.mFeed != null) {
            str = t().extraTypeInfo.mFeed.poster.f398463id.get();
        } else {
            str = "";
        }
        QCircleLpReportDc05501.DataBuilder toUin = subActionType.setToUin(str);
        if (t().extraTypeInfo != null) {
            i3 = t().extraTypeInfo.mDataPosition;
        } else {
            i3 = -1;
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(toUin.setIndex(i3).setPageId(m())));
    }

    private void R() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(t().feed.poster.f398463id.get()).setActionType(11).setSubActionType(9).setThrActionType(2).setExt9(o()).setFeedReportInfo(p()).setPageId(m()));
    }

    private void S() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(F()).setSubActionType(3).setThrActionType(2).setExt6(String.valueOf(t().polymerizationName)).setPageId(m()));
    }

    private void T() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(t().feed.poster.f398463id.get()).setActionType(6).setSubActionType(4).setThrActionType(2).setPageId(m()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(String str) {
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(str);
        this.f92368u.putStringArrayList(QCircleHostConstants.AppConstants.Key.SHARE_REQ_IMAGE_URL(), arrayList);
        I(true);
        QCircleHostQzoneHelper.jumpToQzoneShare(HostDataTransUtils.getAccount(), f(), this.f92368u, null, -1);
        if (QLog.isColorLevel()) {
            QLog.d("QFSSharePart", 1, "shareToQZone  success");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (yb0.c.d(t())) {
            yb0.c.i(f());
            return;
        }
        if (t() != null && t().feed != null && t().feed.poster != null && t().feed.share != null && f() != null) {
            if (t().isShowPersonalQrcodeDown && h() != null) {
                h().g(new a());
            } else {
                N();
                long M = M(this.f92369v);
                if (M > 0) {
                    QCircleAvatarLoader.g().loadAvatar(new AvatarOption().setUin(String.valueOf(M)).setUrlListener(new b()));
                } else {
                    U(this.f92369v);
                }
            }
            O();
            d("share", "qzone");
            q.c(f(), "share_lately_type_key", "share_type_qzone");
            yb0.g.f449962a.g(true, j());
            return;
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return true;
    }
}
