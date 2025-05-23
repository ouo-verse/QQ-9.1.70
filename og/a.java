package og;

import android.view.View;
import android.widget.LinearLayout;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.qzone.reborn.feedx.presenter.ad.basepresenter.a;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \f2\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016R$\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Log/a;", "Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/a;", "", "k", "Landroid/view/View;", "containerView", "", BdhLogUtil.LogTag.Tag_Conn, "", "L", "K", "M", "N", "v", NodeProps.ON_CLICK, "Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;", "Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;", "getMTianShuAd", "()Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;", "setMTianShuAd", "(Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;)V", "mTianShuAd", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends com.qzone.reborn.feedx.presenter.ad.basepresenter.a {

    /* renamed from: M, reason: from kotlin metadata */
    private QZoneAdTianshuFeedData mTianShuAd;

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.a
    public boolean K() {
        return false;
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.a
    public boolean L() {
        BusinessFeedData businessFeedData = this.f441565h;
        QZoneAdTianshuFeedData tianshuData = businessFeedData != null ? QZoneAdFeedDataExtKt.getTianshuData(businessFeedData) : null;
        if (!Intrinsics.areEqual(tianshuData != null ? tianshuData.getAdType() : null, "3")) {
            if (!Intrinsics.areEqual(tianshuData != null ? tianshuData.getAdType() : null, "2")) {
                return false;
            }
        }
        return true;
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.a
    public void M() {
        String str;
        BusinessFeedData businessFeedData = this.f441565h;
        this.mTianShuAd = businessFeedData != null ? QZoneAdFeedDataExtKt.getTianshuData(businessFeedData) : null;
        a.C0466a mAdFeedBottomData = getMAdFeedBottomData();
        QZoneAdTianshuFeedData qZoneAdTianshuFeedData = this.mTianShuAd;
        if (qZoneAdTianshuFeedData == null || (str = qZoneAdTianshuFeedData.getBtnText()) == null) {
            str = "";
        }
        mAdFeedBottomData.b(str);
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.a
    public void N() {
        O();
        LinearLayout mAdBottomRightLayout = getMAdBottomRightLayout();
        if (mAdBottomRightLayout == null) {
            return;
        }
        mAdBottomRightLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneAdTianshuBottomRightPresenter";
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

    @Override // vg.a
    protected void C(View containerView) {
    }
}
