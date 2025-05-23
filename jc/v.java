package jc;

import android.text.TextUtils;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Ljc/v;", "Lcom/qzone/reborn/albumx/common/share/a;", "Lic/c;", "shareContext", "", "l", "", "", "c", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "k", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class v extends com.qzone.reborn.albumx.common.share.a<ic.c> {
    @Override // com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void a(ic.c shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        ((IOCR) QRoute.api(IOCR.class)).startOcrPerformFragment(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), shareContext.getLayerItemInfo().getExistSaveOrEditPath(), 2, -1009, null, false);
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public boolean f(ic.c shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOCRService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
        return (shareContext.getLayerItemInfo().isVideo() || !((IOCRService) runtimeService).isSupportOcr(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), 2) || TextUtils.isEmpty(shareContext.getExistSaveOrEditPath())) ? false : true;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(52);
        return listOf;
    }
}
