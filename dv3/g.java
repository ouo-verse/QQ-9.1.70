package dv3;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.gallery.share.NTShareContext;
import com.tencent.qqnt.aio.gallery.share.aa;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Ldv3/g;", "Lcom/tencent/qqnt/aio/gallery/share/aa;", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g extends aa {
    @Override // com.tencent.qqnt.aio.gallery.share.aa, com.tencent.qqnt.aio.gallery.share.a
    public void b(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        super.b(shareContext, item);
        if (QLog.isColorLevel()) {
            QLog.d("NTGroupEmoReportPart", 2, "NTGroupEmoShareToQZoneAlbumAction");
        }
        ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
    }
}
