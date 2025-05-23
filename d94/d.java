package d94;

import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.sqshow.zootopia.nativeui.data.title.PortalStorePanelCategoryData;
import com.tencent.sqshow.zootopia.nativeui.view.page.PortalStorePanelCategoryPage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Ld94/d;", "Lc94/a;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelCategoryData;", "Lcom/tencent/sqshow/zootopia/nativeui/view/page/PortalStorePanelCategoryPage;", "l", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "i", "Landroid/content/Context;", "mContext", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "Lcom/tencent/sqshow/zootopia/nativeui/view/page/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/nativeui/view/page/b;", "subPageDataChangeListener", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/nativeui/data/j;Lcom/tencent/sqshow/zootopia/nativeui/view/page/b;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends c94.a<String, PortalStorePanelCategoryData, PortalStorePanelCategoryPage> {

    /* renamed from: C, reason: from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.view.page.b subPageDataChangeListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j channel;

    public d(Context mContext, com.tencent.sqshow.zootopia.nativeui.data.j channel, com.tencent.sqshow.zootopia.nativeui.view.page.b subPageDataChangeListener) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(subPageDataChangeListener, "subPageDataChangeListener");
        this.mContext = mContext;
        this.channel = channel;
        this.subPageDataChangeListener = subPageDataChangeListener;
    }

    @Override // c94.a
    public String l() {
        return "PortalStorePanelSubTitlePageAdapter";
    }

    @Override // c94.a
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public PortalStorePanelCategoryPage d(PortalStorePanelCategoryData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        PortalStorePanelCategoryPage portalStorePanelCategoryPage = new PortalStorePanelCategoryPage(this.mContext, null, 0, this.channel);
        portalStorePanelCategoryPage.setDataChangedListener(this.subPageDataChangeListener);
        return portalStorePanelCategoryPage;
    }
}
