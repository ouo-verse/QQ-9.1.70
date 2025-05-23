package og;

import android.text.TextUtils;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00052\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Log/d;", "Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/c;", "", "k", "", "I", "J", "", "K", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;", "H", "Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;", "getMTianShuAd", "()Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;", "setMTianShuAd", "(Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;)V", "mTianShuAd", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends com.qzone.reborn.feedx.presenter.ad.basepresenter.c {

    /* renamed from: H, reason: from kotlin metadata */
    private QZoneAdTianshuFeedData mTianShuAd;

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.c
    public boolean I() {
        BusinessFeedData businessFeedData = this.f441565h;
        return !TextUtils.isEmpty((businessFeedData != null ? QZoneAdFeedDataExtKt.getTianshuData(businessFeedData) : null) != null ? r0.getAdSourceUrl() : null);
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.c
    public boolean J() {
        QZoneAdTianshuFeedData qZoneAdTianshuFeedData = this.mTianShuAd;
        return Intrinsics.areEqual(qZoneAdTianshuFeedData != null ? qZoneAdTianshuFeedData.getAdType() : null, "2");
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.c
    public void K() {
        BusinessFeedData businessFeedData = this.f441565h;
        this.mTianShuAd = businessFeedData != null ? QZoneAdFeedDataExtKt.getTianshuData(businessFeedData) : null;
        PictureUrl pictureUrl = new PictureUrl();
        QZoneAdTianshuFeedData qZoneAdTianshuFeedData = this.mTianShuAd;
        pictureUrl.url = qZoneAdTianshuFeedData != null ? qZoneAdTianshuFeedData.getAdSourceUrl() : null;
        QZoneAdTianshuFeedData qZoneAdTianshuFeedData2 = this.mTianShuAd;
        pictureUrl.width = qZoneAdTianshuFeedData2 != null ? qZoneAdTianshuFeedData2.getWidth() : 0;
        QZoneAdTianshuFeedData qZoneAdTianshuFeedData3 = this.mTianShuAd;
        pictureUrl.height = qZoneAdTianshuFeedData3 != null ? qZoneAdTianshuFeedData3.getHeight() : 0;
        getMAdFeedPicData().b(pictureUrl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    public String k() {
        return "QZoneAdTianshuPicPresenter";
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
