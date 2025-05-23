package com.tencent.qqnt.aio.gallery.share;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqnt.aio.gallery.share.NTShareActionManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/j;", "Lcom/tencent/qqnt/aio/gallery/share/a;", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "", "j", "i", "", "g", "", "", "e", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager$ShareLine;", "d", "", "c", "a", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class j extends a {
    private final void i(NTShareContext shareContext) {
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        Activity activity = shareContext.getActivity();
        String str = shareContext.getActivity().getPackageName() + ".fileprovider";
        String existSaveOrEditPath = shareContext.getExistSaveOrEditPath();
        Intrinsics.checkNotNull(existSaveOrEditPath);
        intent.setDataAndType(FileProvider.getUriForFile(activity, str, new File(existSaveOrEditPath)), "video/*");
        intent.addFlags(1);
        intent.putExtra("big_brother_source_key", " biz_src_jc_video");
        shareContext.getActivity().startActivity(intent);
        if (shareContext.getAioLayerData() instanceof AIOVideoData) {
            int i3 = shareContext.getAioLayerData().istroop;
            if (i3 == 0) {
                ReportController.o(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
                return;
            }
            if (i3 == 1) {
                ReportController.o(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
            } else if (i3 != 3000) {
                ReportController.o(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
            } else {
                ReportController.o(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
            }
        }
    }

    private final void j(NTShareContext shareContext) {
        if (shareContext.getLayerItemInfo().isVideo()) {
            i(shareContext);
        } else {
            ah.r1(shareContext.getActivity(), shareContext.getExistSaveOrEditPath());
        }
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void a(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        j(shareContext);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void b(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        j(shareContext);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<String> c() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("otherapp");
        return listOf;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public NTShareActionManager.ShareLine d() {
        return NTShareActionManager.ShareLine.FIRST;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public boolean g(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return (shareContext.getLayerItemInfo().getInvalid() || shareContext.getMediaType() == 1 || TextUtils.isEmpty(shareContext.getExistSaveOrEditPath())) ? false : true;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<Integer> e() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(64);
        return arrayListOf;
    }
}
