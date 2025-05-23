package og;

import android.text.TextUtils;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.qzone.reborn.feedx.presenter.ad.basepresenter.QZoneAdFeedBaseVideoPresenter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Log/e;", "Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/QZoneAdFeedBaseVideoPresenter;", "", "k", "", "a0", "", "d0", "W", "X", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;", "P", "Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;", "getMTianShuAd", "()Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;", "setMTianShuAd", "(Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;)V", "mTianShuAd", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends QZoneAdFeedBaseVideoPresenter {

    /* renamed from: P, reason: from kotlin metadata */
    private QZoneAdTianshuFeedData mTianShuAd;

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.QZoneAdFeedBaseVideoPresenter
    public boolean W() {
        QZoneAdTianshuFeedData qZoneAdTianshuFeedData = this.mTianShuAd;
        return Intrinsics.areEqual(qZoneAdTianshuFeedData != null ? qZoneAdTianshuFeedData.getAdType() : null, "1");
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.QZoneAdFeedBaseVideoPresenter
    public boolean X() {
        QZoneAdTianshuFeedData qZoneAdTianshuFeedData = this.mTianShuAd;
        return Intrinsics.areEqual(qZoneAdTianshuFeedData != null ? qZoneAdTianshuFeedData.getAdType() : null, "3");
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.QZoneAdFeedBaseVideoPresenter
    public boolean a0() {
        PBStringField pBStringField;
        BusinessFeedData businessFeedData = this.f441565h;
        vac_adv_get.TianShuMsg tianshuMsg = businessFeedData != null ? QZoneAdFeedDataExtKt.getTianshuMsg(businessFeedData) : null;
        String str = (tianshuMsg == null || (pBStringField = tianshuMsg.trace_id) == null) ? null : pBStringField.get();
        QZoneAdTianshuFeedData qZoneAdTianshuFeedData = this.mTianShuAd;
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, qZoneAdTianshuFeedData != null ? qZoneAdTianshuFeedData.getTraceId() : null);
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.QZoneAdFeedBaseVideoPresenter
    public void d0() {
        String str;
        String traceId;
        BusinessFeedData businessFeedData = this.f441565h;
        this.mTianShuAd = businessFeedData != null ? QZoneAdFeedDataExtKt.getTianshuData(businessFeedData) : null;
        e0(new QZoneAdFeedBaseVideoPresenter.a());
        QZoneAdFeedBaseVideoPresenter.a mAdFeedVideoData = getMAdFeedVideoData();
        QZoneAdTianshuFeedData qZoneAdTianshuFeedData = this.mTianShuAd;
        String str2 = "";
        if (qZoneAdTianshuFeedData == null || (str = qZoneAdTianshuFeedData.getAid()) == null) {
            str = "";
        }
        mAdFeedVideoData.d(str);
        QZoneAdFeedBaseVideoPresenter.a mAdFeedVideoData2 = getMAdFeedVideoData();
        QZoneAdTianshuFeedData qZoneAdTianshuFeedData2 = this.mTianShuAd;
        if (qZoneAdTianshuFeedData2 != null && (traceId = qZoneAdTianshuFeedData2.getTraceId()) != null) {
            str2 = traceId;
        }
        mAdFeedVideoData2.e(str2);
        VideoInfo videoInfo = this.f441565h.getVideoInfo();
        QZoneAdTianshuFeedData qZoneAdTianshuFeedData3 = this.mTianShuAd;
        videoInfo.width = qZoneAdTianshuFeedData3 != null ? qZoneAdTianshuFeedData3.getWidth() : 0;
        QZoneAdTianshuFeedData qZoneAdTianshuFeedData4 = this.mTianShuAd;
        videoInfo.height = qZoneAdTianshuFeedData4 != null ? qZoneAdTianshuFeedData4.getHeight() : 0;
        getMAdFeedVideoData().f(videoInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneAdTianshuVideoPresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        QZoneAdTianshuFeedData qZoneAdTianshuFeedData = this.mTianShuAd;
        if (qZoneAdTianshuFeedData != null) {
            ih.e.f407623a.k(qZoneAdTianshuFeedData, this.C);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
