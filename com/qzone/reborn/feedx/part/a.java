package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.FakeShuoShuoDataCacheHelper;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.publish.business.publishqueue.common.CommonPublishVideoStatusInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001c\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/feedx/part/a;", "Lcom/qzone/reborn/feedx/part/g;", "Lsm/i;", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "onPartDestroy", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "data", "i7", "clientKey", "Lcom/qzone/publish/business/publishqueue/common/g;", "videoStatusInfo", "z5", "v1", "I4", "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a extends g implements sm.i {
    @Override // sm.i
    public void I4(BusinessFeedData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.d("QZPublishX_QZoneXPublishFakeFeedPart", 1, "onPublishSucceed  feedKey=" + data.getFeedCommInfo().feedskey + ", clientKey=" + data.getFeedCommInfo().clientkey);
        if (C9() == null) {
            QLog.e("QZPublishX_QZoneXPublishFakeFeedPart", 1, "onPublishSucceed  get no QZoneFeedService");
            return;
        }
        tc.b C9 = C9();
        Intrinsics.checkNotNull(C9);
        com.qzone.feed.business.service.a mCurService = C9.getMCurService();
        com.qzone.proxy.feedcomponent.manager.d E = mCurService != null ? mCurService.E() : null;
        if (E != null) {
            E.l(data, null, true);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZPublishX_QZoneXPublishFakeFeedPart";
    }

    @Override // sm.i
    public void i7(BusinessFeedData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.d("QZPublishX_QZoneXPublishFakeFeedPart", 1, "onAddFakeFeed  feedKey=" + data.getFeedCommInfo().feedskey + " clientKey=" + data.getFeedCommInfo().clientkey);
        if (C9() == null) {
            QLog.e("QZPublishX_QZoneXPublishFakeFeedPart", 1, "onAddFakeFeed  get no QZoneFeedService");
            return;
        }
        tc.b C9 = C9();
        Intrinsics.checkNotNull(C9);
        com.qzone.feed.business.service.a mCurService = C9.getMCurService();
        com.qzone.proxy.feedcomponent.manager.d E = mCurService != null ? mCurService.E() : null;
        if (E != null) {
            E.w(data);
        }
        FakeShuoShuoDataCacheHelper.f(data);
        broadcastMessage("SCROLL_TO_FIRST_FEED", null);
        if (E != null) {
            E.notify(2, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        lc.i.f414345a.i(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        lc.i.f414345a.y(this);
    }

    @Override // sm.i
    public void v1(String clientKey) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        if (C9() == null) {
            QLog.e("QZPublishX_QZoneXPublishFakeFeedPart", 1, "onDeleteFakeFeed  get no QZoneFeedService");
            return;
        }
        tc.b C9 = C9();
        Intrinsics.checkNotNull(C9);
        com.qzone.feed.business.service.a mCurService = C9.getMCurService();
        com.qzone.proxy.feedcomponent.manager.d E = mCurService != null ? mCurService.E() : null;
        QLog.d("QZPublishX_QZoneXPublishFakeFeedPart", 1, "onDeleteFakeFeed  clientKey=" + clientKey + ", fakeDataLogic=" + E);
        if (TextUtils.isEmpty(clientKey) || E == null) {
            return;
        }
        E.z("client_key='" + clientKey + "'", true);
    }

    @Override // sm.i
    public void z5(String clientKey, CommonPublishVideoStatusInfo videoStatusInfo) {
        BusinessFeedData businessFeedData;
        List<BusinessFeedData> D;
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(videoStatusInfo, "videoStatusInfo");
        if (C9() == null) {
            QLog.e("QZPublishX_QZoneXPublishFakeFeedPart", 1, "onUpdateVideoFakeFeed  get no QZoneFeedService");
            return;
        }
        tc.b C9 = C9();
        Intrinsics.checkNotNull(C9);
        com.qzone.feed.business.service.a mCurService = C9.getMCurService();
        if (mCurService == null || (D = mCurService.D()) == null) {
            businessFeedData = null;
        } else {
            businessFeedData = null;
            for (BusinessFeedData businessFeedData2 : D) {
                if (TextUtils.equals(businessFeedData2.getFeedCommInfo().clientkey, clientKey)) {
                    businessFeedData = businessFeedData2;
                }
            }
        }
        QLog.d("QZPublishX_QZoneXPublishFakeFeedPart", 1, "onUpdateVideoFakeFeed  clientKey=" + clientKey + ", videoStatusInfo=" + videoStatusInfo + ", findFeed=" + businessFeedData);
        if (businessFeedData == null) {
            return;
        }
        if (videoStatusInfo.getIsSingleVideo()) {
            Intrinsics.checkNotNull(businessFeedData);
            businessFeedData.getLocalInfo().setHalfReal();
            businessFeedData.setVideoInfo(videoStatusInfo.getVideoInfo());
        } else {
            Intrinsics.checkNotNull(businessFeedData);
            businessFeedData.setMixFake(videoStatusInfo.getVideoFeedStatus());
        }
        tc.b C92 = C9();
        Intrinsics.checkNotNull(C92);
        com.qzone.feed.business.service.a mCurService2 = C92.getMCurService();
        Intrinsics.checkNotNull(mCurService2, "null cannot be cast to non-null type com.qzone.feed.business.service.QZoneFeedService");
        com.qzone.proxy.feedcomponent.manager.d E = ((QZoneFeedService) mCurService2).E();
        if (E != null) {
            E.l(businessFeedData, null, true);
        }
    }
}
