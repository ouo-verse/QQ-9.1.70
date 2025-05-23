package gi;

import android.app.Activity;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.common.share.b;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\nR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lgi/a;", "Lcom/qzone/reborn/albumx/common/share/b;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "c", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "d", "()Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "layerItemInfo", "", "Z", "()Z", "fromDetail", "", "e", "Ljava/lang/String;", "getExistSaveOrEditPath", "()Ljava/lang/String;", "existSaveOrEditPath", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", "shareManger", "<init>", "(Landroid/app/Activity;Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;Z)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final RFWLayerItemMediaInfo layerItemInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean fromDetail;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String existSaveOrEditPath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Activity activity, QQShareActionManager<?> shareManger, RFWLayerItemMediaInfo layerItemInfo, boolean z16) {
        super(activity, shareManger);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareManger, "shareManger");
        Intrinsics.checkNotNullParameter(layerItemInfo, "layerItemInfo");
        this.layerItemInfo = layerItemInfo;
        this.fromDetail = z16;
        this.existSaveOrEditPath = layerItemInfo.getExistSaveOrEditPath();
    }

    /* renamed from: c, reason: from getter */
    public final boolean getFromDetail() {
        return this.fromDetail;
    }

    /* renamed from: d, reason: from getter */
    public final RFWLayerItemMediaInfo getLayerItemInfo() {
        return this.layerItemInfo;
    }
}
