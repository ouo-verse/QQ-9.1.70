package d94;

import android.content.Context;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.sqshow.zootopia.nativeui.view.PortalStoreGroupPanelPageData;
import com.tencent.sqshow.zootopia.nativeui.view.page.PortalStoreGroupPanelPage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J \u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Ld94/a;", "Lc94/a;", "", "Lcom/tencent/sqshow/zootopia/nativeui/view/PortalStoreGroupPanelPageData;", "Lcom/tencent/sqshow/zootopia/nativeui/view/page/PortalStoreGroupPanelPage;", "l", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "targetCategoryId", "typeId", "", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "i", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "panelChannel", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends c94.a<String, PortalStoreGroupPanelPageData, PortalStoreGroupPanelPage> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j panelChannel;

    public a(Context context, com.tencent.sqshow.zootopia.nativeui.data.j panelChannel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(panelChannel, "panelChannel");
        this.context = context;
        this.panelChannel = panelChannel;
    }

    @Override // c94.a
    public String l() {
        return "PortalStoreGroupPanelPageAdapter";
    }

    @Override // c94.a
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public PortalStoreGroupPanelPage d(PortalStoreGroupPanelPageData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new PortalStoreGroupPanelPage(this.context, null, 0, this.panelChannel);
    }

    public final void n(PortalStoreGroupPanelPageData data, String targetCategoryId, String typeId) {
        Intrinsics.checkNotNullParameter(targetCategoryId, "targetCategoryId");
        Intrinsics.checkNotNullParameter(typeId, "typeId");
        PortalStoreGroupPanelPage portalStoreGroupPanelPage = (PortalStoreGroupPanelPage) super.j(data);
        if ((targetCategoryId.length() == 0) || portalStoreGroupPanelPage == null) {
            return;
        }
        portalStoreGroupPanelPage.q(targetCategoryId, typeId);
    }
}
