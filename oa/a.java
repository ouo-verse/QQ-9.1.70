package oa;

import android.view.View;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.albumx.qzone.vas.widget.QZoneAlbumExpirePicItemView;
import com.qzone.reborn.base.l;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Loa/a;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "u", "", "e", "Ljava/lang/String;", "TAG", "Lcom/qzone/reborn/albumx/qzone/vas/widget/QZoneAlbumExpirePicItemView;", "f", "Lcom/qzone/reborn/albumx/qzone/vas/widget/QZoneAlbumExpirePicItemView;", "imageView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends l<CommonGridItemData> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneAlbumExpirePicItemSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneAlbumExpirePicItemView imageView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.mnb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026d.qzone_album_expire_pic)");
        this.imageView = (QZoneAlbumExpirePicItemView) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonGridItemData data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        QZoneAlbumExpirePicItemView qZoneAlbumExpirePicItemView = this.imageView;
        if (qZoneAlbumExpirePicItemView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            qZoneAlbumExpirePicItemView = null;
        }
        qZoneAlbumExpirePicItemView.setData(data, position);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mvi};
    }
}
