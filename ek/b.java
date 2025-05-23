package ek;

import android.view.View;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.base.l;
import com.qzone.reborn.intimate.widget.QZoneIntimateAlbumDetailPicWidgetView;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014J*\u0010\u0011\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lek/b;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "", "getLogTag", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "u", "Lcom/qzone/reborn/intimate/widget/QZoneIntimateAlbumDetailPicWidgetView;", "e", "Lcom/qzone/reborn/intimate/widget/QZoneIntimateAlbumDetailPicWidgetView;", "picView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends l<CommonGridItemData> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneIntimateAlbumDetailPicWidgetView picView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public String getLogTag() {
        return "CommonAlbumDetailPicSection";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f20077e);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026d.common_pic_widget_view)");
        this.picView = (QZoneIntimateAlbumDetailPicWidgetView) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.n4c};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonGridItemData data, int position, List<Object> payload) {
        if (data != null) {
            QZoneIntimateAlbumDetailPicWidgetView qZoneIntimateAlbumDetailPicWidgetView = this.picView;
            if (qZoneIntimateAlbumDetailPicWidgetView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picView");
                qZoneIntimateAlbumDetailPicWidgetView = null;
            }
            qZoneIntimateAlbumDetailPicWidgetView.setData(data, data.getMediaPos());
        }
    }
}
