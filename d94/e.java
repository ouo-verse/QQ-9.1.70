package d94;

import android.content.Context;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.sqshow.zootopia.nativeui.data.title.PortalStorePanelSectionData;
import com.tencent.sqshow.zootopia.nativeui.view.page.PortalStoreSectionPanelPage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Ld94/e;", "Lc94/a;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelSectionData;", "Lcom/tencent/sqshow/zootopia/nativeui/view/page/PortalStoreSectionPanelPage;", "l", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "typeId", "", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "i", "Landroid/content/Context;", "mContext", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends c94.a<String, PortalStorePanelSectionData, PortalStoreSectionPanelPage> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    public e(Context mContext, com.tencent.sqshow.zootopia.nativeui.data.j mChannel) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mChannel, "mChannel");
        this.mContext = mContext;
        this.mChannel = mChannel;
    }

    @Override // c94.a
    public String l() {
        return "PortalStorePanelTitlePageAdapter";
    }

    @Override // c94.a
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public PortalStoreSectionPanelPage d(PortalStorePanelSectionData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new PortalStoreSectionPanelPage(this.mContext, null, 0, this.mChannel);
    }

    public final void n(PortalStorePanelSectionData data, String typeId) {
        Intrinsics.checkNotNullParameter(typeId, "typeId");
        PortalStoreSectionPanelPage portalStoreSectionPanelPage = (PortalStoreSectionPanelPage) super.j(data);
        if ((typeId.length() == 0) || portalStoreSectionPanelPage == null) {
            return;
        }
        portalStoreSectionPanelPage.r(typeId);
    }
}
